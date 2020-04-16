package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat {
    private static final String TAG = "ResourcesCompat";

    public static abstract class FontCallback {
        public final void callbackFailAsync(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    FontCallback.this.onFontRetrievalFailed(i);
                }
            });
        }

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public void run() {
                    FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    private ResourcesCompat() {
    }

    public static int getColor(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? resources.getColor(i, theme) : resources.getColor(i);
    }

    public static ColorStateList getColorStateList(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? resources.getColorStateList(i, theme) : resources.getColorStateList(i);
    }

    public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawableForDensity(i, i2, theme) : Build.VERSION.SDK_INT >= 15 ? resources.getDrawableForDensity(i, i2) : resources.getDrawable(i);
    }

    public static float getFloat(Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    public static Typeface getFont(Context context, int i) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, (FontCallback) null, (Handler) null, false);
    }

    public static Typeface getFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, typedValue, i2, fontCallback, (Handler) null, true);
    }

    public static void getFont(Context context, int i, FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
            return;
        }
        loadFont(context, i, new TypedValue(), 0, fontCallback, handler, false);
    }

    private static Typeface loadFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i, i2, fontCallback, handler, z);
        if (loadFont != null || fontCallback != null) {
            return loadFont;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f0  */
    private static Typeface loadFont(Context context, Resources resources, TypedValue typedValue, int i, int i2, FontCallback fontCallback, Handler handler, boolean z) {
        String str;
        Typeface typeface;
        Resources resources2 = resources;
        TypedValue typedValue2 = typedValue;
        int i3 = i;
        int i4 = i2;
        FontCallback fontCallback2 = fontCallback;
        Handler handler2 = handler;
        if (typedValue2.string != null) {
            String charSequence = typedValue2.string.toString();
            if (!charSequence.startsWith("res/")) {
                if (fontCallback2 != null) {
                    fontCallback2.callbackFailAsync(-3, handler2);
                }
                return null;
            }
            Typeface findFromCache = TypefaceCompat.findFromCache(resources2, i3, i4);
            if (findFromCache != null) {
                if (fontCallback2 != null) {
                    fontCallback2.callbackSuccessAsync(findFromCache, handler2);
                }
                return findFromCache;
            }
            try {
                if (charSequence.toLowerCase().endsWith(".xml")) {
                    try {
                        FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources2.getXml(i3), resources2);
                        if (parse == null) {
                            try {
                                Log.e(TAG, "Failed to find font-family tag");
                                if (fontCallback2 != null) {
                                    fontCallback2.callbackFailAsync(-3, handler2);
                                }
                                return null;
                            } catch (XmlPullParserException e2) {
                                e = e2;
                                Context context2 = context;
                                str = charSequence;
                                Log.e(TAG, "Failed to parse xml resource " + str, e);
                                if (fontCallback2 != null) {
                                }
                                return null;
                            } catch (IOException e3) {
                                e = e3;
                                Context context3 = context;
                                str = charSequence;
                                Log.e(TAG, "Failed to read xml resource " + str, e);
                                if (fontCallback2 != null) {
                                }
                                return null;
                            }
                        } else {
                            typeface = findFromCache;
                            str = charSequence;
                            try {
                                return TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i, i2, fontCallback, handler, z);
                            } catch (XmlPullParserException e4) {
                                e = e4;
                                Context context4 = context;
                                Typeface typeface2 = typeface;
                                Log.e(TAG, "Failed to parse xml resource " + str, e);
                                if (fontCallback2 != null) {
                                }
                                return null;
                            } catch (IOException e5) {
                                e = e5;
                                Context context5 = context;
                                Typeface typeface3 = typeface;
                                Log.e(TAG, "Failed to read xml resource " + str, e);
                                if (fontCallback2 != null) {
                                }
                                return null;
                            }
                        }
                    } catch (XmlPullParserException e6) {
                        e = e6;
                        Typeface typeface4 = findFromCache;
                        str = charSequence;
                        Context context6 = context;
                        Log.e(TAG, "Failed to parse xml resource " + str, e);
                        if (fontCallback2 != null) {
                        }
                        return null;
                    } catch (IOException e7) {
                        e = e7;
                        Typeface typeface5 = findFromCache;
                        str = charSequence;
                        Context context7 = context;
                        Log.e(TAG, "Failed to read xml resource " + str, e);
                        if (fontCallback2 != null) {
                        }
                        return null;
                    }
                } else {
                    typeface = findFromCache;
                    str = charSequence;
                    try {
                        Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources2, i3, str, i4);
                        if (fontCallback2 != null) {
                            if (createFromResourcesFontFile != null) {
                                try {
                                    fontCallback2.callbackSuccessAsync(createFromResourcesFontFile, handler2);
                                } catch (XmlPullParserException e8) {
                                    e = e8;
                                    Log.e(TAG, "Failed to parse xml resource " + str, e);
                                    if (fontCallback2 != null) {
                                    }
                                    return null;
                                } catch (IOException e9) {
                                    e = e9;
                                    Log.e(TAG, "Failed to read xml resource " + str, e);
                                    if (fontCallback2 != null) {
                                    }
                                    return null;
                                }
                            } else {
                                fontCallback2.callbackFailAsync(-3, handler2);
                            }
                        }
                        return createFromResourcesFontFile;
                    } catch (XmlPullParserException e10) {
                        e = e10;
                        Typeface typeface22 = typeface;
                        Log.e(TAG, "Failed to parse xml resource " + str, e);
                        if (fontCallback2 != null) {
                        }
                        return null;
                    } catch (IOException e11) {
                        e = e11;
                        Typeface typeface32 = typeface;
                        Log.e(TAG, "Failed to read xml resource " + str, e);
                        if (fontCallback2 != null) {
                        }
                        return null;
                    }
                }
            } catch (XmlPullParserException e12) {
                e = e12;
                Context context8 = context;
                Typeface typeface6 = findFromCache;
                str = charSequence;
                Log.e(TAG, "Failed to parse xml resource " + str, e);
                if (fontCallback2 != null) {
                    fontCallback2.callbackFailAsync(-3, handler2);
                }
                return null;
            } catch (IOException e13) {
                e = e13;
                Context context9 = context;
                Typeface typeface7 = findFromCache;
                str = charSequence;
                Log.e(TAG, "Failed to read xml resource " + str, e);
                if (fontCallback2 != null) {
                }
                return null;
            }
        } else {
            Context context10 = context;
            throw new Resources.NotFoundException("Resource \"" + resources2.getResourceName(i3) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
    }
}
