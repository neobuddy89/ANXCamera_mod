package com.android.camera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.InflateException;
import android.view.WindowManager;
import android.widget.Toast;
import com.android.camera.log.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ToastUtils {
    private static final long SHORT_DURATION_TIMEOUT = 2000;
    public static final String TAG = "ToastUtils";
    private static int sGravity = 17;
    private static String sOldMsg;
    private static long sOneTime;
    protected static Toast sToast;
    private static long sTwoTime;
    private static int sXOffset;
    private static int sYOffset;

    private static WindowManager.LayoutParams getWindowParams(Toast toast) {
        if (toast == null) {
            return null;
        }
        try {
            Method method = Toast.class.getMethod("getWindowParams", new Class[0]);
            method.setAccessible(true);
            return (WindowManager.LayoutParams) method.invoke(toast, new Object[0]);
        } catch (NoSuchMethodException e2) {
            Log.d(TAG, "getWindowParams: no such method", (Throwable) e2);
            Log.d(TAG, "getWindowsParam: ret: " + null);
            return null;
        } catch (IllegalAccessException e3) {
            Log.d(TAG, "getWindowParams: cannot access", (Throwable) e3);
            Log.d(TAG, "getWindowsParam: ret: " + null);
            return null;
        } catch (InvocationTargetException e4) {
            Log.d(TAG, "getWindowParams: invoke failed: ", (Throwable) e4);
            Log.d(TAG, "getWindowsParam: ret: " + null);
            return null;
        }
    }

    private static void prepareShowOnKeyguard(Toast toast) {
        WindowManager.LayoutParams windowParams = getWindowParams(toast);
        if (windowParams != null) {
            windowParams.flags |= 524288;
        }
    }

    public static void showToast(Context context, int i) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                showToast(new WeakReference(context), resources.getString(i), 17, 0, 0, false);
            }
        }
    }

    public static void showToast(Context context, int i, boolean z) {
        if (context != null) {
            Resources resources = context.getResources();
            if (resources != null) {
                showToast(new WeakReference(context), resources.getString(i), 17, 0, 0, z);
            }
        }
    }

    public static void showToast(Context context, String str) {
        showToast(new WeakReference(context), str, 17, 0, 0, false);
    }

    public static void showToast(Context context, String str, int i) {
        if (context != null && context.getResources() != null) {
            showToast(new WeakReference(context), str, i, 0, 0, false);
        }
    }

    public static void showToast(Context context, String str, int i, int i2, int i3) {
        if (context != null && context.getResources() != null) {
            showToast(new WeakReference(context), str, i, i2, i3, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0026 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    private static void showToast(WeakReference<Context> weakReference, String str, int i, int i2, int i3, boolean z) {
        boolean z2;
        Context context = (Context) weakReference.get();
        boolean z3 = true;
        boolean z4 = false;
        if (context instanceof Activity) {
            Intent intent = ((Activity) context).getIntent();
            if (intent != null && intent.getBooleanExtra("StartActivityWhenLocked", false)) {
                z2 = true;
                if (TextUtils.isEmpty(str)) {
                    if (sToast != null) {
                        sTwoTime = System.currentTimeMillis();
                        String str2 = sOldMsg;
                        if (str2 != null && !str2.equals(str)) {
                            sOldMsg = str;
                            sToast.setText(str);
                            z4 = true;
                        }
                        if (z && !(sGravity == sToast.getGravity() && sXOffset == sToast.getXOffset() && sYOffset == sToast.getYOffset())) {
                            sToast.setGravity(sGravity, sXOffset, sYOffset);
                            z4 = true;
                        }
                        if (z || (i == sToast.getGravity() && i2 == sToast.getXOffset() && i3 == sToast.getYOffset())) {
                            z3 = z4;
                        } else {
                            sToast.setGravity(i, i2, i3);
                        }
                        if (z3 || sTwoTime - sOneTime > 2000) {
                            sOneTime = sTwoTime;
                            if (z2) {
                                prepareShowOnKeyguard(sToast);
                            }
                            sToast.show();
                            return;
                        }
                        return;
                    } else if (context != null) {
                        try {
                            sToast = Toast.makeText(context.getApplicationContext(), str, 0);
                            sGravity = sToast.getGravity();
                            sXOffset = sToast.getXOffset();
                            sYOffset = sToast.getYOffset();
                            if (!z) {
                                sToast.setGravity(i, i2, i3);
                            }
                            if (z2) {
                                prepareShowOnKeyguard(sToast);
                            }
                            sToast.show();
                            sOldMsg = str;
                            sOneTime = System.currentTimeMillis();
                            return;
                        } catch (InflateException e2) {
                            sToast = null;
                            e2.printStackTrace();
                            return;
                        } catch (Exception e3) {
                            sToast = null;
                            e3.printStackTrace();
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        z2 = false;
        if (TextUtils.isEmpty(str)) {
        }
    }
}
