package com.android.camera;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.provider.MiuiSettings;
import android.support.annotation.MainThread;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.provider.DocumentFile;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.aeonax.PermissionsAsker;
import com.android.camera.LocalParallelService;
import com.android.camera.ThermalDetector;
import com.android.camera.aftersales.AftersalesManager;
import com.android.camera.constant.GlobalConstant;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.config.DataItemConfig;
import com.android.camera.data.data.global.DataItemGlobal;
import com.android.camera.data.observeable.VMProcessing;
import com.android.camera.effect.EffectController;
import com.android.camera.fragment.BaseFragmentDelegate;
import com.android.camera.fragment.FragmentUtils;
import com.android.camera.fragment.dialog.AiSceneNewbieDialogFragment;
import com.android.camera.fragment.dialog.FrontRotateNewbieDialogFragment;
import com.android.camera.fragment.dialog.HibernationFragment;
import com.android.camera.fragment.dialog.IDCardModeNewbieDialogFragment;
import com.android.camera.fragment.dialog.LensDirtyDetectDialogFragment;
import com.android.camera.fragment.dialog.MacroModeNewbieDialogFragment;
import com.android.camera.fragment.dialog.PortraitNewbieDialogFragment;
import com.android.camera.fragment.dialog.UltraTeleNewbieDialogFragment;
import com.android.camera.fragment.dialog.UltraWideNewbieDialogFragment;
import com.android.camera.fragment.dialog.VVNewbieDialogFragment;
import com.android.camera.fragment.lifeCircle.BaseLifecycleListener;
import com.android.camera.fragment.music.FragmentLiveMusic;
import com.android.camera.fragment.top.FragmentTopAlert;
import com.android.camera.fragment.top.FragmentTopConfig;
import com.android.camera.lib.compatibility.util.CompatibilityUtils;
import com.android.camera.log.Log;
import com.android.camera.module.BaseModule;
import com.android.camera.module.Module;
import com.android.camera.module.ModuleManager;
import com.android.camera.module.impl.ImplFactory;
import com.android.camera.module.loader.FunctionCameraLegacySetup;
import com.android.camera.module.loader.FunctionCameraPrepare;
import com.android.camera.module.loader.FunctionDataSetup;
import com.android.camera.module.loader.FunctionModuleSetup;
import com.android.camera.module.loader.FunctionResumeModule;
import com.android.camera.module.loader.FunctionUISetup;
import com.android.camera.module.loader.NullHolder;
import com.android.camera.module.loader.StartControl;
import com.android.camera.module.loader.camera2.Camera2OpenManager;
import com.android.camera.module.loader.camera2.Camera2OpenOnSubScribe;
import com.android.camera.module.loader.camera2.Camera2Result;
import com.android.camera.module.loader.camera2.CompletablePreFixCamera2Setup;
import com.android.camera.parallel.AlgoConnector;
import com.android.camera.permission.PermissionManager;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.android.camera.scene.MiAlgoAsdSceneProfile;
import com.android.camera.statistic.CameraStatUtils;
import com.android.camera.statistic.MistatsConstants;
import com.android.camera.statistic.MistatsWrapper;
import com.android.camera.statistic.ScenarioTrackUtil;
import com.android.camera.storage.ImageSaver;
import com.android.camera.storage.PriorityStorageBroadcastReceiver;
import com.android.camera.storage.Storage;
import com.android.camera.ui.CameraRootView;
import com.android.camera.ui.V6CameraGLSurfaceView;
import com.android.camera.ui.V6GestureRecognizer;
import com.android.camera.ui.V9EdgeShutterView;
import com.android.camera2.Camera2Proxy;
import com.android.lens.LensAgent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mi.config.b;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import com.xiaomi.camera.imagecodec.ImagePool;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import miui.hardware.display.DisplayFeatureManager;
import miui.os.Build;

public class Camera extends ActivityBase implements ActivityCompat.OnRequestPermissionsResultCallback, BaseLifecycleListener, ModeProtocol.BaseProtocol {
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int PERMISSION_RESULT_CODE = 2308;
    private static final int REPEAT_KEY_EVENT_GAP = 250;
    /* access modifiers changed from: private */
    public final String TAG = (Camera.class.getSimpleName() + "@" + hashCode());
    /* access modifiers changed from: private */
    public BaseFragmentDelegate mBaseFragmentDelegate;
    private Camera2OpenOnSubScribe mCamera2OpenOnSubScribe;
    private BiFunction mCameraOpenResult = new BiFunction<NullHolder<BaseModule>, Camera2Result, NullHolder<BaseModule>>() {
        public NullHolder<BaseModule> apply(@NonNull NullHolder<BaseModule> nullHolder, @NonNull Camera2Result camera2Result) throws Exception {
            int result = camera2Result.getResult();
            String access$400 = Camera.this.TAG;
            Log.d(access$400, "mCameraOpenResult apply : result = " + result);
            if (result != 2 && result == 3) {
                if (nullHolder.isPresent()) {
                    nullHolder.get().setDeparted();
                }
                Camera.this.showCameraError(camera2Result.getCameraError());
            }
            return nullHolder;
        }
    };
    private Disposable mCameraPendingSetupDisposable;
    private final Object mCameraPendingSetupDisposableGuard = new Object();
    private Consumer<NullHolder<BaseModule>> mCameraSetupConsumer = new Consumer<NullHolder<BaseModule>>() {
        public void accept(@NonNull NullHolder<BaseModule> nullHolder) throws Exception {
            if (!nullHolder.isPresent()) {
                Camera.this.showCameraError(nullHolder.getException());
                Camera.this.mCurrentModule = null;
            } else {
                V6GestureRecognizer.getInstance(Camera.this).setCurrentModule(nullHolder.get());
            }
            Camera.this.getCameraScreenNail().resetFrameAvailableFlag();
            Camera.this.setSwitchingModule(false);
            synchronized (Camera.this.mCameraSetupDisposableGuard) {
                Disposable unused = Camera.this.mCameraSetupDisposable = null;
            }
            DataRepository.dataCloudMgr().fillCloudValues();
            AutoLockManager.getInstance(Camera.this).hibernateDelayed();
            if (CameraSettings.isCameraParallelProcessEnable()) {
                ImagePool.getInstance().trimPoolBuffer();
            }
            Log.d(Camera.this.TAG, "cameraSetupConsumer#accept switch module done.");
        }
    };
    /* access modifiers changed from: private */
    public Disposable mCameraSetupDisposable;
    /* access modifiers changed from: private */
    public final Object mCameraSetupDisposableGuard = new Object();
    /* access modifiers changed from: private */
    public int mCurrentDisplayMode;
    private LogThread mDebugThread;
    private boolean mDidRegister;
    private DisplayFeatureManager mDisplayFeatureManager;
    private FirebaseAnalytics mFirebaseAnalytics;
    /* access modifiers changed from: private */
    public boolean mFirstOrientationArrived;
    /* access modifiers changed from: private */
    public boolean mHasFocus;
    private boolean mHasbeenSetupOnFocusChanged = false;
    private ImageSaver mImageSaver;
    private ImplFactory mImplFactory;
    private boolean mIsGalleryServiceBound = false;
    private boolean mIsInRequestRuntimePermission = false;
    private boolean mIsLunchFromAutoTest = false;
    private boolean mIsModeSwitched;
    private boolean mIsScreenSlideOff;
    private int mLastIgnoreKey = -1;
    private long mLastKeyDownEventTime = 0;
    private long mLastKeyUpEventTime = 0;
    private MyOrientationEventListener mOrientationListener;
    private int mPendingScreenSlideKeyCode;
    private ProximitySensorLock mProximitySensorLock;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Module module = Camera.this.mCurrentModule;
            if (module != null && !module.isDeparted()) {
                Camera.this.mCurrentModule.onBroadcastReceived(context, intent);
            }
        }
    };
    private BroadcastReceiver mSDReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (!Camera.this.mCurrentModule.isDeparted()) {
                Camera.this.mCurrentModule.onBroadcastReceived(context, intent);
            }
        }
    };
    private ContentObserver mScreenSlideStatusObserver = new ContentObserver(this.mHandler) {
        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            super.onChange(z);
            if (!Camera.this.mHasFocus && !Camera.this.mActivityPaused) {
                int i = Util.isScreenSlideOff(Camera.this) ? 701 : 700;
                String access$400 = Camera.this.TAG;
                Log.d(access$400, "focus lost, try key code: " + i);
                Camera.this.onKeyDown(i, new KeyEvent(0, i));
            }
        }
    };
    private SensorStateManager mSensorStateManager;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private StartControl mStartControl;
    private ThermalDetector.OnThermalNotificationListener mThermalNotificationListener = new a(this);
    /* access modifiers changed from: private */
    public volatile int mTick;
    private Thread mWatchDog;
    private String newbieDialogFragmentTag = null;
    /* access modifiers changed from: private */
    public final Runnable tickerRunnable = new Runnable() {
        public void run() {
            Camera camera = Camera.this;
            int unused = camera.mTick = (camera.mTick + 1) % 10;
        }
    };

    private static class CameraRunnable implements Runnable {
        private static final String TAG = "CameraRunnable";
        private WeakReference<Camera> mCamera;
        private boolean mReleaseDevice;
        private boolean mReleaseImmediate;

        CameraRunnable(WeakReference<Camera> weakReference, boolean z, boolean z2) {
            this.mCamera = weakReference;
            this.mReleaseDevice = z;
            this.mReleaseImmediate = z2;
        }

        public void run() {
            Camera camera = (Camera) this.mCamera.get();
            if (camera != null) {
                if (camera.isCurrentModuleAlive()) {
                    Module module = camera.mCurrentModule;
                    DataRepository.getInstance().backUp().backupRunning(DataRepository.dataItemRunning(), DataRepository.dataItemGlobal().getDataBackUpKey(camera.getCurrentModuleIndex()), DataRepository.dataItemGlobal().getCurrentCameraId(), false);
                    if (ModeCoordinatorImpl.isAlive(camera.hashCode())) {
                        module.unRegisterProtocol();
                        module.unRegisterModulePersistProtocol();
                    }
                    module.onPause();
                    module.onStop();
                    module.onDestroy();
                }
                DataRepository.dataItemGlobal().resetTimeOut();
                if (this.mReleaseDevice) {
                    boolean containsResumedCameraInStack = camera.mApplication.containsResumedCameraInStack();
                    Log.d(TAG, "start releaseCameraDevice: " + (!containsResumedCameraInStack));
                    if (!containsResumedCameraInStack) {
                        Camera2OpenManager.getInstance().release(this.mReleaseImmediate);
                        camera.releaseCameraScreenNail();
                        return;
                    }
                    Log.d(TAG, "Camera2OpenManager release ignored.");
                }
            }
        }
    }

    class LogThread extends Thread {
        private volatile boolean mRunFlag = true;

        LogThread() {
        }

        public void run() {
            while (this.mRunFlag) {
                try {
                    Thread.sleep(10);
                    if (!Camera.this.isActivityPaused()) {
                        Camera.this.mHandler.obtainMessage(0, Util.getDebugInfo()).sendToTarget();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }

        public void setRunFlag(boolean z) {
            this.mRunFlag = z;
        }
    }

    private class MyOrientationEventListener extends OrientationEventListener {
        public MyOrientationEventListener(Context context) {
            super(context);
        }

        public void onOrientationChanged(int i) {
            if (b.isMTKPlatform()) {
                android.util.Log.d("MTKCAMERAXM", "onOrientationChanged: " + i);
            }
            if (i != -1) {
                Camera camera = Camera.this;
                camera.mOrientation = Util.roundOrientation(i, camera.mOrientation);
                if (Camera.this.mCurrentDisplayMode == 2) {
                    Camera camera2 = Camera.this;
                    camera2.mOrientation = 360 - camera2.mOrientation;
                    i = 360 - i;
                }
                if (!Camera.this.mFirstOrientationArrived) {
                    boolean unused = Camera.this.mFirstOrientationArrived = true;
                    String access$400 = Camera.this.TAG;
                    Log.d(access$400, "onOrientationChanged: first orientation is arrived... , orientation = " + i + ", mOrientation = " + Camera.this.mOrientation);
                }
                int displayRotation = Util.getDisplayRotation(Camera.this);
                Camera camera3 = Camera.this;
                if (displayRotation != camera3.mDisplayRotation) {
                    camera3.mDisplayRotation = displayRotation;
                    camera3.onDisplayRotationChanged();
                }
                Camera camera4 = Camera.this;
                int i2 = camera4.mOrientation;
                camera4.mOrientationCompensation = (camera4.mDisplayRotation + i2) % MiuiSettings.ScreenEffect.SCREEN_PAPER_MODE_TWILIGHT_START_DEAULT;
                Module module = camera4.mCurrentModule;
                if (module != null) {
                    module.onOrientationChanged(i2, camera4.mOrientationCompensation, i);
                }
                if (Camera.this.mBaseFragmentDelegate != null) {
                    Camera.this.mBaseFragmentDelegate.getAnimationComposite().disposeRotation(Camera.this.mOrientationCompensation);
                }
            }
        }
    }

    private class WatchDogThread extends Thread {
        private static final String TAG = "WatchDogThread";
        private static final int TIMEOUT_INTERVAL = 5000;

        private WatchDogThread() {
        }

        public void run() {
            setName("ANR-WatchDog");
            while (!isInterrupted()) {
                Log.v(TAG, "watch dog run " + Thread.currentThread().getId());
                int access$000 = Camera.this.mTick;
                Camera camera = Camera.this;
                camera.mHandler.post(camera.tickerRunnable);
                try {
                    Thread.sleep(5000);
                    if (Camera.this.mTick == access$000) {
                        if (b.Qk()) {
                            CameraSettings.setEdgeMode(Camera.this, false);
                        }
                        Camera.this.setBrightnessRampRate(-1);
                        Camera.this.setScreenEffect(false);
                        AftersalesManager.getInstance().count(System.currentTimeMillis(), 2);
                        if (Util.sIsKillCameraService && DataRepository.dataItemFeature().Ac() && SystemClock.elapsedRealtime() - CameraSettings.getBroadcastKillServiceTime() > 60000) {
                            Util.broadcastKillService(Camera.this, false);
                            return;
                        }
                        return;
                    }
                } catch (InterruptedException unused) {
                    Log.e(TAG, "watch dog InterruptedException " + Thread.currentThread().getId());
                    return;
                }
            }
        }
    }

    private void bindServices() {
        try {
            Intent intent = new Intent(Util.ACTION_BIND_GALLERY_SERVICE);
            intent.setPackage(Util.REVIEW_ACTIVITY_PACKAGE);
            bindService(intent, this.mServiceConnection, 5);
            this.mIsGalleryServiceBound = true;
        } catch (Exception e2) {
            Log.w(this.TAG, "bindServices error.", e2.getCause());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r0.isPendingSave() != false) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[SYNTHETIC, Splitter:B:18:0x0040] */
    private void boostParallelServiceAdj() {
        boolean z;
        LocalParallelService.LocalBinder localBinder = AlgoConnector.getInstance().getLocalBinder();
        Camera2Proxy currentCamera2Device = Camera2OpenManager.getInstance().getCurrentCamera2Device();
        if ((!CameraSettings.isCameraParallelProcessEnable() || localBinder == null || localBinder.isIdle()) && (currentCamera2Device == null || !currentCamera2Device.isCaptureBusy(true))) {
            ImageSaver imageSaver = this.mImageSaver;
            if (imageSaver != null) {
            }
            z = false;
            if (z) {
                try {
                    Log.d(this.TAG, "boostParallelServiceAdj");
                    Class.forName("miui.process.ProcessManager").getDeclaredMethod("adjBoost", new Class[]{String.class, Integer.TYPE, Long.TYPE, Integer.TYPE}).invoke((Object) null, new Object[]{"com.android.camera", 0, 60000L, Integer.valueOf(((Integer) Class.forName("android.os.UserHandle").getMethod("myUserId", new Class[0]).invoke((Object) null, new Object[0])).intValue())});
                    return;
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                    Log.e(this.TAG, e2.getMessage(), (Throwable) e2);
                    return;
                }
            } else {
                return;
            }
        }
        if (!this.mCameraIntentManager.isImageCaptureIntent()) {
            z = true;
            if (z) {
            }
        }
        z = false;
        if (z) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        return false;
     */
    private boolean closeCameraSetup() {
        synchronized (this.mCameraPendingSetupDisposableGuard) {
            if (this.mCameraPendingSetupDisposable != null && !this.mCameraPendingSetupDisposable.isDisposed()) {
                this.mCameraPendingSetupDisposable.dispose();
                this.mCameraPendingSetupDisposable = null;
            }
        }
        synchronized (this.mCameraSetupDisposableGuard) {
            if (this.mCameraSetupDisposable != null && !this.mCameraSetupDisposable.isDisposed()) {
                this.mCameraSetupDisposable.dispose();
                this.mCameraSetupDisposable = null;
                return true;
            }
        }
    }

    private Module createNewModule(StartControl startControl) {
        Module moduleByIndex = ModuleManager.getModuleByIndex(startControl.mTargetMode);
        if (moduleByIndex != null) {
            moduleByIndex.fillFeatureControl(startControl);
            moduleByIndex.setActivity(this);
            moduleByIndex.preTransferOrientation(this.mOrientation, this.mOrientationCompensation);
            return moduleByIndex;
        }
        throw new RuntimeException("invalid module index " + startControl.mTargetMode);
    }

    private boolean currentIsMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private void hideHibernationFragment() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(HibernationFragment.TAG);
        if (findFragmentByTag != null && (findFragmentByTag instanceof DialogFragment)) {
            ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
        }
    }

    private boolean isFromKeyguard() {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        return (TextUtils.equals(action, "android.media.action.STILL_IMAGE_CAMERA") || TextUtils.equals(action, "android.media.action.STILL_IMAGE_CAMERA_SECURE")) && getKeyguardFlag();
    }

    private boolean isFromOneShotKeyPressed(KeyEvent keyEvent) {
        boolean isTimeout = Util.isTimeout(keyEvent.getEventTime(), this.mLastKeyUpEventTime, 250);
        boolean z = this.mLastKeyDownEventTime > this.mLastKeyUpEventTime;
        if (isTimeout && !z) {
            return false;
        }
        String str = this.TAG;
        Log.i(str, "isFromOneShotKeyPressed: lastUpTIme " + this.mLastKeyUpEventTime + " | eventTime " + keyEvent.getEventTime() + " isKeyEventOrderWrong: " + z);
        return true;
    }

    /* access modifiers changed from: private */
    public void onDisplayRotationChanged() {
        if (b.ck()) {
            FrontRotateNewbieDialogFragment frontRotateNewbieDialogFragment = (FrontRotateNewbieDialogFragment) getSupportFragmentManager().findFragmentByTag(FrontRotateNewbieDialogFragment.TAG);
            if (frontRotateNewbieDialogFragment != null) {
                frontRotateNewbieDialogFragment.animateOut(0);
            }
        }
    }

    private void parseLocationPermission(String[] strArr, int[] iArr) {
        if (PermissionManager.isContainLocationPermissions(strArr)) {
            boolean isCameraLocationPermissionsResultReady = PermissionManager.isCameraLocationPermissionsResultReady(strArr, iArr);
            String str = this.TAG;
            Log.d(str, "onRequestPermissionsResult: is location granted = " + isCameraLocationPermissionsResultReady);
            CameraSettings.updateRecordLocationPreference(isCameraLocationPermissionsResultReady);
            if (!isActivityPaused()) {
                LocationManager.instance().recordLocation(CameraSettings.isRecordLocation());
            }
        }
    }

    private void prefixCamera2Setup() {
        CompletablePreFixCamera2Setup completablePreFixCamera2Setup = new CompletablePreFixCamera2Setup((Module) null, (StartControl) null, (CameraScreenNail) null, getIntent(), startFromSecureKeyguard(), this.mCameraIntentManager.checkCallerLegality());
        Completable.create(completablePreFixCamera2Setup).subscribeOn(GlobalConstant.sCameraSetupScheduler).subscribe();
    }

    private final void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CameraIntentManager.ACTION_VOICE_CONTROL);
        intentFilter.addAction("android.intent.action.REBOOT");
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        registerReceiver(this.mReceiver, intentFilter);
        this.mDidRegister = true;
    }

    private void registerSDReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_STARTED");
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter.addDataScheme(ComposerHelper.COMPOSER_PATH);
        registerReceiver(this.mSDReceiver, intentFilter);
    }

    private void releaseAll(boolean z, boolean z2, boolean z3) {
        boolean isFinishing = isFinishing();
        String str = this.TAG;
        Log.d(str, "releaseAll: releaseDevice = " + z2 + ", isCurrentModuleAlive = " + isCurrentModuleAlive() + ", releaseImmediate = " + z3 + ", isFinishing = " + isFinishing);
        this.mReleaseByModule = false;
        Module module = this.mCurrentModule;
        if (module != null) {
            module.setDeparted();
        }
        GlobalConstant.sCameraSetupScheduler.scheduleDirect(new CameraRunnable(new WeakReference(this), z2, z3));
    }

    private void resumeCamera() {
        boolean z;
        int i;
        Log.d(this.TAG, "resumeCamera: E");
        if (!isSwitchingModule()) {
            if (!ModeCoordinatorImpl.isAlive(hashCode())) {
                Log.d(this.TAG, "resumeCamera: module is obsolete");
                HybridZoomingSystem.clearZoomRatioHistory();
                unRegisterProtocol();
                registerProtocol();
            } else {
                DataItemGlobal dataItemGlobal = DataRepository.dataItemGlobal();
                boolean checkCallerLegality = this.mCameraIntentManager.checkCallerLegality();
                int i2 = 1;
                boolean z2 = false;
                if (isJumpBack()) {
                    Log.d(this.TAG, "resumeCamera: from gallery, mReleaseByModule = " + this.mReleaseByModule);
                    this.mJumpedToGallery = false;
                    if (this.mReleaseByModule) {
                        Module module = this.mCurrentModule;
                        if (module != null && module.isShot2GalleryOrEnableParallel()) {
                            this.mCurrentModule.enableCameraControls(true);
                            this.mReleaseByModule = false;
                            return;
                        }
                    }
                    z = false;
                } else {
                    int intentType = dataItemGlobal.getIntentType();
                    int currentMode = dataItemGlobal.getCurrentMode();
                    boolean isCameraAliveWhenResume = isCameraAliveWhenResume();
                    dataItemGlobal.parseIntent(getIntent(), Boolean.valueOf(checkCallerLegality), startFromSecureKeyguard(), false, !isCameraAliveWhenResume);
                    int intentType2 = dataItemGlobal.getIntentType();
                    int currentMode2 = dataItemGlobal.getCurrentMode();
                    z = currentMode != currentMode2;
                    if (intentType != 0) {
                        Module module2 = this.mCurrentModule;
                        if (module2 != null && module2.isSelectingCapturedResult()) {
                            z2 = true;
                        }
                        Log.d(this.TAG, "resumeCamera: lastType=" + intentType + " curType=" + intentType2 + " captureFinish=" + z2);
                        if (intentType == intentType2 && z2) {
                            resumeCurrentMode(currentMode2);
                            return;
                        } else if (z2) {
                            this.mBaseFragmentDelegate.delegateEvent(6);
                        }
                    } else {
                        Log.d(this.TAG, "resumeCamera: lastType=" + intentType + " | mReleaseByModule " + this.mReleaseByModule);
                        if (isCameraAliveWhenResume) {
                            this.mBaseFragmentDelegate.getAnimationComposite().notifyAfterFirstFrameArrived(4);
                            this.mReleaseByModule = false;
                            return;
                        }
                    }
                }
                if (dataItemGlobal.isTimeOut() || z) {
                    if (this.mBaseFragmentDelegate != null) {
                        FragmentUtils.removeFragmentByTag(getSupportFragmentManager(), FragmentLiveMusic.TAG);
                        if (this.mBaseFragmentDelegate.getActiveFragment(R.id.full_screen_feature) == 65529) {
                            this.mBaseFragmentDelegate.delegateEvent(11);
                        }
                        this.mBaseFragmentDelegate.delegateEvent(7);
                    }
                    i = 3;
                } else {
                    i = 2;
                }
                if (i != 3 && checkCallerLegality) {
                    i2 = 2;
                } else if (i != 3 && dataItemGlobal.getCurrentMode() == 179) {
                    if (((VMProcessing) DataRepository.dataItemObservable().get(VMProcessing.class)).getCurrentState() == 7) {
                        Log.d(this.TAG, "resumeCamera: vv combine, return");
                        return;
                    }
                    i2 = -1;
                }
                HybridZoomingSystem.clearZoomRatioHistory();
                onModeSelected(StartControl.create(dataItemGlobal.getCurrentMode()).setResetType(i).setViewConfigType(i2));
            }
            Log.d(this.TAG, "resumeCamera: X");
        }
    }

    /* access modifiers changed from: private */
    public void setBrightnessRampRate(int i) {
    }

    /* access modifiers changed from: private */
    public void setScreenEffect(boolean z) {
        DisplayFeatureManager displayFeatureManager = this.mDisplayFeatureManager;
        if (displayFeatureManager != null) {
            displayFeatureManager.setScreenEffect(14, z ? 1 : 0);
        }
    }

    private void setTranslucentNavigation(boolean z) {
        if (Util.checkDeviceHasNavigationBar(this)) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(768);
            window.addFlags(Integer.MIN_VALUE);
        }
    }

    private void setupCamera(StartControl startControl) {
        if (this.mIsInRequestRuntimePermission) {
            Log.d(this.TAG, "skip caz request runtime permission.");
        } else if (isActivityPaused()) {
            Log.w(this.TAG, "setupCamera: activity is paused!");
            setSwitchingModule(false);
        } else if (!PermissionManager.checkCameraLaunchPermissions()) {
            Log.w(this.TAG, "setupCamera: waiting for permissions to be granted");
            setSwitchingModule(false);
        } else {
            Log.d(this.TAG, "setupCamera");
            closeCameraSetup();
            FunctionCameraPrepare functionCameraPrepare = new FunctionCameraPrepare(startControl.mTargetMode, startControl.mResetType, startControl.mNeedReConfigureData, (BaseModule) this.mCurrentModule);
            FunctionModuleSetup functionModuleSetup = new FunctionModuleSetup(startControl.mTargetMode);
            FunctionDataSetup functionDataSetup = new FunctionDataSetup(startControl.mTargetMode);
            FunctionUISetup functionUISetup = new FunctionUISetup(startControl.mTargetMode, startControl.needNotifyUI());
            Single map = Single.just(NullHolder.ofNullable(this)).observeOn(GlobalConstant.sCameraSetupScheduler).map(functionCameraPrepare);
            Single observeOn = Single.create(this.mCamera2OpenOnSubScribe).subscribeOn(GlobalConstant.sCameraSetupScheduler).observeOn(GlobalConstant.sCameraSetupScheduler);
            synchronized (this.mCameraSetupDisposableGuard) {
                this.mCameraSetupDisposable = map.zipWith(observeOn, this.mCameraOpenResult).map(functionModuleSetup).map(functionDataSetup).observeOn(functionUISetup.getWorkThread()).map(functionUISetup).subscribe(this.mCameraSetupConsumer);
            }
        }
    }

    private boolean shouldReleaseLater() {
        return isCurrentModuleAlive() && this.mCurrentModule.shouldReleaseLater();
    }

    /* access modifiers changed from: private */
    public void showCameraError(int i) {
        CameraStatUtils.trackCameraError("" + i);
        AftersalesManager.getInstance().count(System.currentTimeMillis(), 4, CameraSettings.getCameraId());
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.arg1 = i;
        this.mHandler.sendMessage(obtain);
        CompatibilityUtils.takebackMotor();
    }

    private void showDebug() {
        if (Util.isShowDebugInfo()) {
            TextView textView = this.mDebugInfoView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            this.mDebugThread = new LogThread();
            this.mDebugThread.start();
        }
        if (this.mDebugInfoView != null && Util.isShowPreviewDebugInfo()) {
            this.mDebugInfoView.setVisibility(0);
        }
    }

    private void showFirstUseHintIfNeeded() {
        if (!startFromSecureKeyguard()) {
            CameraRootView cameraRootView = this.mCameraRootView;
            if (cameraRootView != null) {
                cameraRootView.disableTouchEvent();
            }
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    if (!Camera.this.isActivityPaused()) {
                        Camera.this.getScreenHint().showFirstUseHint();
                        CameraRootView cameraRootView = Camera.this.mCameraRootView;
                        if (cameraRootView != null) {
                            cameraRootView.enableTouchEvent();
                        }
                    }
                }
            }, 1000);
        }
    }

    private void showFirstUsePermissionActivity() {
        if (DataRepository.dataItemGlobal().getBoolean("pref_camera_first_use_permission_shown_key", true)) {
            boolean z = Build.IS_INTERNATIONAL_BUILD;
            String str = Util.sRegion;
            if (z && "KR".equals(str)) {
                Intent intent = new Intent("miui.intent.action.APP_PERMISSION_USE");
                ArrayList arrayList = new ArrayList(6);
                arrayList.add(getResources().getString(R.string.permission_contacts));
                arrayList.add(getResources().getString(R.string.permission_location));
                arrayList.add(getResources().getString(R.string.permission_camera));
                arrayList.add(getResources().getString(R.string.permission_phone_state));
                arrayList.add(getResources().getString(R.string.permission_storage));
                arrayList.add(getResources().getString(R.string.permission_microphone));
                intent.putStringArrayListExtra("extra_main_permission_groups", arrayList);
                intent.putExtra("extra_pkgname", "com.android.camera");
                try {
                    startActivityForResult(intent, 1);
                } catch (Exception e2) {
                    String str2 = this.TAG;
                    Log.i(str2, "KR Exception:" + e2);
                }
            }
        }
    }

    private void showHibernationFragment() {
        HibernationFragment hibernationFragment = new HibernationFragment();
        hibernationFragment.setStyle(2, R.style.DialogFragmentFullScreen);
        getSupportFragmentManager().beginTransaction().add((Fragment) hibernationFragment, HibernationFragment.TAG).commitAllowingStateLoss();
    }

    private void switchEdgeFingerMode(boolean z) {
        if (b.Qk()) {
            CameraSettings.setEdgeMode(this, z);
        }
    }

    private void triggerWatchDog(boolean z) {
        String str = this.TAG;
        Log.d(str, "triggerWatchDog: " + z);
        if (b.sn && DataRepository.dataItemFeature().Ac()) {
            if (z) {
                this.mWatchDog = new WatchDogThread();
                this.mWatchDog.start();
                return;
            }
            Thread thread = this.mWatchDog;
            if (thread != null) {
                thread.interrupt();
                this.mWatchDog = null;
            }
        }
    }

    private void unbindServices() {
        if (this.mIsGalleryServiceBound) {
            unbindService(this.mServiceConnection);
            this.mIsGalleryServiceBound = false;
        }
    }

    private void unregisterSDReceiver() {
        try {
            unregisterReceiver(this.mSDReceiver);
        } catch (Exception e2) {
            Log.e(this.TAG, e2.getMessage());
        }
    }

    public void changeRequestOrientation() {
        if (b.ck()) {
            if (CameraSettings.isFrontCamera()) {
                setRequestedOrientation(7);
            } else {
                setRequestedOrientation(1);
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ProximitySensorLock proximitySensorLock = this.mProximitySensorLock;
        if (proximitySensorLock == null || !proximitySensorLock.intercept(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 1) {
            HybridZoomingSystem.setZoomingSourceIdentity(0);
        }
        if (this.mActivityPaused) {
            return true;
        }
        ProximitySensorLock proximitySensorLock = this.mProximitySensorLock;
        if (proximitySensorLock != null && proximitySensorLock.active()) {
            return true;
        }
        Module module = this.mCurrentModule;
        return (module == null || module.isIgnoreTouchEvent()) ? super.dispatchTouchEvent(motionEvent) : super.dispatchTouchEvent(motionEvent) || V6GestureRecognizer.getInstance(this).onTouchEvent(motionEvent);
    }

    public int getCapturePosture() {
        return this.mSensorStateManager.getCapturePosture();
    }

    public int getCurrentBrightness() {
        return this.mCameraBrightness.getCurrentBrightness();
    }

    public int getCurrentModuleIndex() {
        if (isCurrentModuleAlive()) {
            return this.mCurrentModule.getModuleIndex();
        }
        return 160;
    }

    public ImageSaver getImageSaver() {
        return this.mImageSaver;
    }

    public ImplFactory getImplFactory() {
        return this.mImplFactory;
    }

    public SensorStateManager getSensorStateManager() {
        return this.mSensorStateManager;
    }

    public boolean handleScreenSlideKeyEvent(int i, KeyEvent keyEvent) {
        Log.d(this.TAG, "handleScreenSlideKeyEvent " + i);
        if (DataRepository.dataItemFeature().Bc()) {
            return true;
        }
        if (i == 701 && getCameraIntentManager().isFromScreenSlide().booleanValue() && !isModeSwitched()) {
            finish();
            overridePendingTransition(R.anim.anim_screen_slide_fade_in, R.anim.anim_screen_slide_fade_out);
            return true;
        } else if (isPostProcessing()) {
            return true;
        } else {
            DataItemGlobal dataItemGlobal = DataRepository.dataItemGlobal();
            int currentCameraId = dataItemGlobal.getCurrentCameraId();
            boolean z = false;
            int i2 = i == 700 ? 1 : 0;
            int currentMode = dataItemGlobal.getCurrentMode();
            if ((currentMode == 171 && !DataRepository.dataItemFeature().yd()) || currentMode == 166 || currentMode == 167 || currentMode == 173 || currentMode == 175) {
                currentMode = 163;
            } else if (currentMode == 169 || currentMode == 172) {
                currentMode = 162;
            } else if (currentMode == 162 && i2 == 0 && DataRepository.getInstance().backUp().isLastVideoFastMotion()) {
                currentMode = 169;
            }
            if (currentMode == 163 || currentMode == 165) {
                currentMode = ((DataItemConfig) DataRepository.provider().dataConfig(i2)).getComponentConfigRatio().getMappingModeByRatio(163);
            }
            if (currentCameraId != i2) {
                ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
                ModeProtocol.ActionProcessing actionProcessing = (ModeProtocol.ActionProcessing) ModeCoordinatorImpl.getInstance().getAttachProtocol(162);
                if (topAlert != null) {
                    topAlert.removeExtraMenu(4);
                }
                if (actionProcessing != null) {
                    actionProcessing.hideExtra();
                }
                dataItemGlobal.setCurrentMode(currentMode);
                dataItemGlobal.setCameraId(i2);
                boolean z2 = currentCameraId == 1;
                if (i2 == 1) {
                    z = true;
                }
                ScenarioTrackUtil.trackSwitchCameraStart(z2, z, dataItemGlobal.getCurrentMode());
                onModeSelected(StartControl.create(currentMode).setFromScreenSlide(true).setNeedBlurAnimation(true).setViewConfigType(2));
            } else if (i == 700 && isCurrentModuleAlive()) {
                ((BaseModule) this.mCurrentModule).updateScreenSlide(true);
                ModeProtocol.MainContentProtocol mainContentProtocol = (ModeProtocol.MainContentProtocol) ModeCoordinatorImpl.getInstance().getAttachProtocol(166);
                if (Util.isAccessible() && mainContentProtocol != null) {
                    mainContentProtocol.updateContentDescription();
                }
            }
            return true;
        }
    }

    public void hideLensDirtyDetectedHint() {
        if (!DataRepository.dataItemFeature().Qc()) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(LensDirtyDetectDialogFragment.TAG);
            if (findFragmentByTag != null && (findFragmentByTag instanceof DialogFragment)) {
                ((DialogFragment) findFragmentByTag).dismissAllowingStateLoss();
            }
        }
    }

    public boolean isCurrentModuleAlive() {
        Module module = this.mCurrentModule;
        return module != null && module.isCreated();
    }

    public boolean isModeSwitched() {
        return this.mIsModeSwitched;
    }

    public boolean isNewBieAlive(int i) {
        String str;
        switch (i) {
            case 1:
                str = PortraitNewbieDialogFragment.TAG;
                break;
            case 2:
                str = FrontRotateNewbieDialogFragment.TAG;
                break;
            case 3:
                str = AiSceneNewbieDialogFragment.TAG;
                break;
            case 4:
                str = UltraWideNewbieDialogFragment.TAG;
                break;
            case 5:
                str = MacroModeNewbieDialogFragment.TAG;
                break;
            case 6:
                str = VVNewbieDialogFragment.TAG;
                break;
            case 7:
                str = UltraTeleNewbieDialogFragment.TAG;
                break;
            default:
                str = null;
                break;
        }
        return (str == null || getSupportFragmentManager().findFragmentByTag(str) == null) ? false : true;
    }

    public boolean isRecording() {
        return isCurrentModuleAlive() && this.mCurrentModule.isRecording();
    }

    public boolean isScreenSlideOff() {
        return this.mIsScreenSlideOff;
    }

    public boolean isSelectingCapturedResult() {
        return isCurrentModuleAlive() && this.mCurrentModule.isSelectingCapturedResult();
    }

    public boolean isStable() {
        return this.mSensorStateManager.isStable();
    }

    public /* synthetic */ void j(int i) {
        if (!this.mIsLunchFromAutoTest) {
            if (i == 1) {
                if (!isActivityPaused()) {
                    this.mHandler.sendEmptyMessage(3);
                } else {
                    return;
                }
            }
            ModeProtocol.ConfigChanges configChanges = (ModeProtocol.ConfigChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(164);
            if (configChanges == null) {
                Log.w(this.TAG, "onThermalNotification config is null");
                return;
            }
            try {
                configChanges.onThermalNotification(i);
            } catch (Exception e2) {
                Log.w(this.TAG, "onThermalNotification error", (Throwable) e2);
            }
        }
    }

    public void notifyOnFirstFrameArrived(int i) {
        Module module = this.mCurrentModule;
        if (module != null && !module.isDeparted() && !isSwitchingModule()) {
            this.mHandler.sendEmptyMessageDelayed(2, FragmentTopAlert.HINT_DELAY_TIME);
            getCameraScreenNail().clearAnimation();
            this.mBaseFragmentDelegate.getAnimationComposite().notifyAfterFirstFrameArrived(i);
            this.mCurrentModule.enableCameraControls(true);
            this.mCurrentModule.setFrameAvailable(true);
            if (this.mModeSelectGaussianTime > 0 && SystemClock.uptimeMillis() - this.mModeSelectGaussianTime > 3000) {
                AftersalesManager.getInstance().count(SystemClock.uptimeMillis(), 3);
                this.mModeSelectGaussianTime = -1;
            }
            if ((getCurrentModuleIndex() == 165 || getCurrentModuleIndex() == 163) && b.ck() && CameraSettings.isFrontCamera() && this.mDisplayRotation == 0 && DataRepository.dataItemGlobal().getBoolean("pref_front_camera_first_use_hint_shown_key", true)) {
                DataRepository.dataItemGlobal().editor().putBoolean("pref_front_camera_first_use_hint_shown_key", false).apply();
                showNewBie(2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 161) {
                if (FileCompat.handleActivityResult(this, i, i2, intent)) {
                    DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this, intent.getData());
                    if (fromTreeUri.findFile("Camera") == null) {
                        fromTreeUri.createDirectory("Camera");
                        return;
                    }
                    return;
                }
                Log.w(this.TAG, "onActivityResult documents permission not granted");
                PriorityStorageBroadcastReceiver.setPriorityStorage(false);
            }
        } else if (i2 == PERMISSION_RESULT_CODE) {
            DataRepository.dataItemGlobal().putBoolean("pref_camera_first_use_permission_shown_key", false);
        }
    }

    public void onAwaken() {
        Log.d(this.TAG, "onAwaken");
        getCameraScreenNail().requestAwaken();
        onModeSelected(this.mStartControl);
    }

    public void onBackPressed() {
        Log.d(this.TAG, "onBackPressed");
        Module module = this.mCurrentModule;
        if (module == null || !module.onBackPressed()) {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        Log.d(this.TAG, "onCreate start");
        this.mApplication = (CameraAppImpl) getApplication();
        this.mIsLunchFromAutoTest = SystemProperties.getBoolean("camera.test.auto", this.mIsLunchFromAutoTest);
        trackAppLunchTimeStart(this.mApplication.isApplicationFirstLaunched());
        this.mAppStartTime = System.currentTimeMillis();
        this.mCameraIntentManager = CameraIntentManager.getInstance(getIntent());
        this.mCameraIntentManager.setReferer(this);
        if (CompatibilityUtils.isInMultiWindowMode(this)) {
            super.onCreate((Bundle) null);
            PermissionsAsker.Ask(this);
            this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
            ToastUtils.showToast((Context) this, (int) R.string.multi_window_mode_not_supported);
            Log.d(this.TAG, "isInMultiWindowMode call finish");
            finish();
        } else if (!CameraIntentManager.ACTION_VOICE_CONTROL.equals(getIntent().getAction()) || this.mCameraIntentManager.checkCallerLegality()) {
            String caller = this.mCameraIntentManager.getCaller();
            if (this.mCameraIntentManager.checkCallerLegality()) {
                CameraStatUtils.trackCallerControl(getIntent(), caller);
            }
            if (DataRepository.dataItemFeature().Bc()) {
                Util.initialize(getApplicationContext());
            }
            Util.initStatusBarHeight(getApplicationContext());
            super.onCreate(bundle);
            showFirstUsePermissionActivity();
            if (!getKeyguardFlag()) {
                if (CameraSettings.isShowFirstUseHint()) {
                    showFirstUseHintIfNeeded();
                } else if (PermissionManager.checkCameraLaunchPermissions()) {
                    prefixCamera2Setup();
                } else {
                    this.mIsInRequestRuntimePermission = !PermissionManager.requestCameraRuntimePermissions(this);
                }
            }
            if (ProximitySensorLock.enabled() && isFromKeyguard()) {
                if (!Util.isNonUIEnabled() || !this.mCameraIntentManager.isFromVolumeKey().booleanValue()) {
                    if (ProximitySensorLock.supported()) {
                        this.mProximitySensorLock = new ProximitySensorLock(this);
                        this.mProximitySensorLock.startWatching();
                    }
                } else if (Util.isNonUI()) {
                    CameraStatUtils.trackPocketModeEnter(MistatsConstants.NonUI.POCKET_MODE_NONUI_ENTER_VOLUME);
                    Log.d(this.TAG, "Finish from NonUI mode.");
                    finish();
                    return;
                }
            }
            EffectController.releaseInstance();
            setContentView(R.layout.v9_main);
            getWindow().setBackgroundDrawable((Drawable) null);
            this.mGLView = (V6CameraGLSurfaceView) findViewById(R.id.v6_gl_surface_view);
            this.mGLCoverView = (ImageView) findViewById(R.id.gl_root_cover);
            this.mDebugInfoView = (TextView) findViewById(R.id.camera_debug_content);
            this.mEdgeShutterView = (V9EdgeShutterView) findViewById(R.id.v9_edge_shutter_view);
            this.mCameraRootView = (CameraRootView) findViewById(R.id.camera_app_root);
            this.mSensorStateManager = new SensorStateManager(this, getMainLooper());
            this.mOrientationListener = new MyOrientationEventListener(this);
            createCameraScreenNail(false, false);
            this.mCamera2OpenOnSubScribe = new Camera2OpenOnSubScribe(this);
            registerProtocol();
            Util.updateDeviceConfig(this);
            if (b.Ik()) {
                try {
                    this.mDisplayFeatureManager = DisplayFeatureManager.getInstance();
                } catch (Exception e2) {
                    Log.w(this.TAG, "DisplayFeatureManager init failed", (Throwable) e2);
                }
            }
            setTranslucentNavigation(true);
            EffectChangedListenerController.setHoldKey(hashCode());
            if (b.ie()) {
                FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.layout_google_lens, (ViewGroup) null);
                this.mCameraRootView.addView(frameLayout);
                LensAgent.getInstance().init(this, this.mGLView, frameLayout);
            }
            showDebug();
            this.mCurrentDisplayMode = DataRepository.dataItemGlobal().getDisplayMode();
            ThermalDetector.getInstance().onCreate(CameraAppImpl.getAndroidContext());
            Log.d(this.TAG, "onCreate end");
        } else {
            String str = this.TAG;
            Log.e(str, "An illegal caller:" + this.mCameraIntentManager.getCaller() + " use VOICE_CONTROL_INTENT!");
            super.onCreate((Bundle) null);
            PermissionsAsker.Ask(this);
            this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
            finish();
        }
    }

    public void onDestroy() {
        Log.d(this.TAG, "onDestroy start");
        super.onDestroy();
        AutoLockManager.removeInstance(this);
        unRegisterProtocol();
        ThermalDetector.getInstance().onDestroy();
        ImageSaver imageSaver = this.mImageSaver;
        if (imageSaver != null) {
            imageSaver.onHostDestroy();
        }
        SensorStateManager sensorStateManager = this.mSensorStateManager;
        if (sensorStateManager != null) {
            sensorStateManager.onDestroy();
        }
        this.mDisplayFeatureManager = null;
        V6GestureRecognizer.onDestroy(this);
        EffectChangedListenerController.removeEffectChangedListenerMap(hashCode());
        LogThread logThread = this.mDebugThread;
        if (logThread != null) {
            logThread.setRunFlag(false);
        }
        ProximitySensorLock proximitySensorLock = this.mProximitySensorLock;
        if (proximitySensorLock != null) {
            proximitySensorLock.destroy();
        }
        CameraIntentManager cameraIntentManager = this.mCameraIntentManager;
        if (cameraIntentManager != null) {
            cameraIntentManager.destroy();
            this.mCameraIntentManager = null;
        }
        if (getScreenHint() != null) {
            getScreenHint().dismissSystemChoiceDialog();
        }
        CameraIntentManager.removeAllInstance();
        if (b.ie()) {
            LensAgent.getInstance().release();
        }
        Log.d(this.TAG, "onDestroy end");
    }

    public void onHibernate() {
        Log.d(this.TAG, "onHibernate");
        if (isDestroyed()) {
            AutoLockManager.getInstance(this).removeMessage();
            return;
        }
        showHibernationFragment();
        getCameraScreenNail().requestHibernate();
        GlobalConstant.sCameraSetupScheduler.scheduleDirect(new Runnable() {
            public void run() {
                if (Camera.this.isCurrentModuleAlive()) {
                    Camera.this.mCurrentModule.setDeparted();
                    Camera.this.mCurrentModule.closeCamera();
                }
                Camera2OpenManager.getInstance().release(true);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2 = i;
        KeyEvent keyEvent2 = keyEvent;
        if (this.mActivityPaused) {
            return super.onKeyDown(i, keyEvent);
        }
        String str = this.TAG;
        Log.d(str, "onKeyDown: keycode " + i2);
        if (keyEvent.getRepeatCount() == 0 && (i2 == 66 || i2 == 27 || i2 == 88 || i2 == 87 || i2 == 24 || i2 == 25)) {
            if (this.mLastKeyDownEventTime != 0 && keyEvent.getEventTime() < this.mLastKeyDownEventTime) {
                this.mLastIgnoreKey = i2;
                this.mLastKeyDownEventTime = 0;
                return true;
            } else if (isFromOneShotKeyPressed(keyEvent2)) {
                String str2 = this.TAG;
                Log.d(str2, "onKeyDown: isFromOneShotKeyPressed and return! keyCode is " + i2);
                this.mLastIgnoreKey = i2;
                this.mLastKeyDownEventTime = 0;
                return true;
            } else {
                this.mLastIgnoreKey = -1;
                this.mLastKeyDownEventTime = keyEvent.getEventTime();
            }
        } else if (keyEvent.getRepeatCount() > 0 && i2 == this.mLastIgnoreKey) {
            this.mLastIgnoreKey = -1;
        }
        if (i2 == 700) {
            this.mIsScreenSlideOff = false;
        } else if (i2 == 701) {
            this.mIsScreenSlideOff = true;
        }
        if (isCurrentModuleAlive() && this.mCurrentModule.isFrameAvailable()) {
            if (i2 == 24 || i2 == 25 || i2 == 87 || i2 == 88) {
                HybridZoomingSystem.setZoomingSourceIdentity(this.mCurrentModule.hashCode());
            }
            return (!b.pn || !(i2 == 24 || i2 == 25 || i2 == 87 || i2 == 88)) ? this.mCurrentModule.onKeyDown(i2, keyEvent2) || super.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
        } else if (i2 == 24 || i2 == 25 || i2 == 27 || i2 == 66 || i2 == 80 || i2 == 87 || i2 == 88) {
            return true;
        } else {
            return (i2 == 700 || i2 == 701) ? handleScreenSlideKeyEvent(i, keyEvent) : super.onKeyDown(i, keyEvent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25 || i == 87 || i == 88) {
            HybridZoomingSystem.setZoomingSourceIdentity(0);
        }
        if (this.mActivityPaused) {
            return super.onKeyUp(i, keyEvent);
        }
        if (i == 4 && (!keyEvent.isTracking() || keyEvent.isCanceled())) {
            Log.d(this.TAG, "onKeyUp: keyCode KeyEvent.KEYCODE_BACK is not isTracking or isCanceled");
            return false;
        } else if (i == this.mLastIgnoreKey) {
            this.mLastKeyUpEventTime = 0;
            this.mLastIgnoreKey = -1;
            String str = this.TAG;
            Log.d(str, "onKeyUp: key is lastIgnore key   keyCode : " + i);
            return true;
        } else {
            this.mLastKeyUpEventTime = keyEvent.getEventTime();
            String str2 = this.TAG;
            Log.d(str2, "onKeyUp: mLastKeyUpEventTime " + this.mLastKeyUpEventTime + " keyCode : " + i);
            return !isCurrentModuleAlive() ? super.onKeyUp(i, keyEvent) : (!b.pn || !(i == 24 || i == 25 || i == 87 || i == 88)) ? this.mCurrentModule.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent) : super.onKeyUp(i, keyEvent);
        }
    }

    public void onLifeAlive() {
        Log.d(this.TAG, String.format(Locale.ENGLISH, "onLifeAlive module 0x%x, need anim %d, need blur %b need reconfig %b reset type %d", new Object[]{Integer.valueOf(this.mStartControl.mTargetMode), Integer.valueOf(this.mStartControl.mViewConfigType), Boolean.valueOf(this.mStartControl.mNeedBlurAnimation), Boolean.valueOf(this.mStartControl.mNeedReConfigureCamera), Integer.valueOf(this.mStartControl.mResetType)}));
        String str = this.TAG;
        Log.d(str, "onLifeAlive: isFromKeyguard:" + isFromKeyguard() + " mHasbeenSetupOnFocusChanged:" + this.mHasbeenSetupOnFocusChanged + " mHasFocus:" + this.mHasFocus);
        if (!isFromKeyguard() || ((this.mHasbeenSetupOnFocusChanged || this.mHasFocus) && isFromKeyguard())) {
            setupCamera(this.mStartControl);
        }
    }

    public void onLifeDestroy(String str) {
        String str2 = this.TAG;
        Log.d(str2, "onLifeDestroy " + str);
    }

    public void onLifeStart(String str) {
        String str2 = this.TAG;
        Log.d(str2, "onLifeStart " + str);
    }

    public void onLifeStop(String str) {
        String str2 = this.TAG;
        Log.d(str2, "onLifeStop " + str);
    }

    @MainThread
    public void onModeSelected(StartControl startControl) {
        int currentModuleIndex = getCurrentModuleIndex();
        this.mIsModeSwitched = this.mStartControl != null;
        this.mIsScreenSlideOff = Util.isScreenSlideOff(this);
        Log.d(this.TAG, String.format(Locale.ENGLISH, "onModeSelected from 0x%x to 0x%x, ScreenSlideOff = %b", new Object[]{Integer.valueOf(currentModuleIndex), Integer.valueOf(startControl.mTargetMode), Boolean.valueOf(this.mIsScreenSlideOff)}));
        if (currentModuleIndex != 160 && !CameraStatUtils.modeIdToName(currentModuleIndex).equals(CameraStatUtils.modeIdToName(startControl.mTargetMode))) {
            this.mHandler.removeMessages(2);
            ScenarioTrackUtil.trackSwitchModeStart(currentModuleIndex, startControl.mTargetMode, CameraSettings.isFrontCamera());
        }
        closeCameraSetup();
        this.mStartControl = startControl;
        ModuleManager.setActiveModuleIndex(startControl.mTargetMode);
        Completable completable = null;
        if (!startControl.mNeedReConfigureCamera) {
            this.mBaseFragmentDelegate.delegateMode((Completable) null, startControl, (BaseLifecycleListener) null);
            return;
        }
        BaseFragmentDelegate baseFragmentDelegate = this.mBaseFragmentDelegate;
        if (baseFragmentDelegate != null) {
            baseFragmentDelegate.getAnimationComposite().setClickEnable(false);
        }
        this.mModeSelectGaussianTime = -1;
        if (startControl.mNeedBlurAnimation) {
            this.mModeSelectGaussianTime = SystemClock.uptimeMillis();
        }
        setSwitchingModule(true);
        if (!isCurrentModuleAlive()) {
            startControl.mNeedBlurAnimation = false;
            getWindow().clearFlags(128);
        }
        V6GestureRecognizer.getInstance(this).setCurrentModule((Module) null);
        BaseModule baseModule = (BaseModule) this.mCurrentModule;
        if (baseModule != null) {
            baseModule.setDeparted();
        }
        this.mCurrentModule = createNewModule(startControl);
        String str = this.TAG;
        Log.d(str, "current module" + this.mCurrentModule);
        if (this.mBaseFragmentDelegate == null) {
            this.mBaseFragmentDelegate = new BaseFragmentDelegate(this);
            this.mBaseFragmentDelegate.init(getSupportFragmentManager(), startControl.mTargetMode, this);
        } else {
            boolean checkCallerLegality = this.mCameraIntentManager.checkCallerLegality();
            if (PermissionManager.checkCameraLaunchPermissions()) {
                CompletablePreFixCamera2Setup completablePreFixCamera2Setup = new CompletablePreFixCamera2Setup(baseModule, startControl, getCameraScreenNail(), (Intent) null, startFromSecureKeyguard(), checkCallerLegality);
                completable = Completable.create(completablePreFixCamera2Setup).subscribeOn(GlobalConstant.sCameraSetupScheduler);
            }
            synchronized (this.mCameraPendingSetupDisposableGuard) {
                this.mCameraPendingSetupDisposable = this.mBaseFragmentDelegate.delegateMode(completable, startControl, this);
            }
        }
        this.mBaseFragmentDelegate.lazyLoadFragment(R.id.full_screen, 4086);
        if (startControl.getFeatureFragmentAlias() != null) {
            this.mBaseFragmentDelegate.loadFeatureFragment(startControl.getFeatureFragmentAlias());
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Log.d(this.TAG, "onNewIntent start");
        setIntent(intent);
        super.onNewIntent(intent);
        this.mCameraIntentManager.destroy();
        this.mCameraIntentManager = CameraIntentManager.getInstance(intent);
        this.mCameraIntentManager.setReferer(this);
        this.mJumpedToGallery = false;
        Log.d(this.TAG, "onNewIntent end");
    }

    public void onPause() {
        Log.d(this.TAG, "onPause start");
        CameraSettings.setLensIndex(0);
        CameraSettings.setMacro2Sat(false);
        this.mAppStartTime = 0;
        this.mActivityPaused = true;
        this.mIsInRequestRuntimePermission = false;
        this.mPendingScreenSlideKeyCode = 0;
        getContentResolver().unregisterContentObserver(this.mScreenSlideStatusObserver);
        switchEdgeFingerMode(false);
        this.mOrientationListener.disable();
        AutoLockManager.getInstance(this).onPause();
        hideHibernationFragment();
        setBrightnessRampRate(-1);
        setScreenEffect(false);
        getWindow().clearFlags(128);
        if (this.mDidRegister) {
            unregisterReceiver(this.mReceiver);
            this.mDidRegister = false;
        }
        unregisterSDReceiver();
        super.onPause();
        if (b.ie()) {
            LensAgent.getInstance().onPause();
        }
        if (getScreenHint() != null) {
            getScreenHint().cancelHint();
        }
        CameraRootView cameraRootView = this.mCameraRootView;
        if (cameraRootView != null) {
            cameraRootView.enableTouchEvent();
        }
        ImageSaver imageSaver = this.mImageSaver;
        if (imageSaver != null) {
            imageSaver.onHostPause();
        }
        MistatsWrapper.recordPageEnd("CameraActivity");
        this.mReleaseByModule = false;
        if (shouldReleaseLater()) {
            Log.d(this.TAG, "release by module");
            this.mReleaseByModule = true;
            DataRepository.dataItemGlobal().resetTimeOut();
            this.mCurrentModule.onHostStopAndNotifyActionStop();
        }
        if (ThermalDetector.getInstance().thermalConstrained()) {
            finish();
        }
        ThermalDetector.getInstance().unregisterReceiver();
        triggerWatchDog(false);
        controlScreenNailDraw(false);
        boostParallelServiceAdj();
        Log.d(this.TAG, "onPause end");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == PermissionManager.getCameraRuntimePermissionRequestCode()) {
            this.mIsInRequestRuntimePermission = false;
            if (!PermissionManager.isCameraLaunchPermissionsResultReady(strArr, iArr)) {
                String str = this.TAG;
                Log.w(str, "onRequestPermissionsResult: no permission finish, " + Arrays.toString(strArr) + Arrays.toString(iArr));
                finish();
            } else if (strArr.length == 0 && iArr.length == 0) {
                Log.w(this.TAG, "ignore this onRequestPermissionsResult callback");
            } else {
                prefixCamera2Setup();
                setupCamera(this.mStartControl);
                parseLocationPermission(strArr, iArr);
            }
        } else if (i != PermissionManager.getCameraLocationPermissionRequestCode()) {
        } else {
            if (strArr.length == 0 && iArr.length == 0) {
                Log.w(this.TAG, "ignore this onRequestPermissionsResult callback");
            } else {
                parseLocationPermission(strArr, iArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        Log.d(this.TAG, "onRestart start");
        trackAppLunchTimeStart(false);
        this.mAppStartTime = System.currentTimeMillis();
        if (!getKeyguardFlag() && CameraSettings.isShowFirstUseHint()) {
            showFirstUseHintIfNeeded();
        }
        Log.d(this.TAG, "onRestart end");
    }

    public void onResume() {
        Log.d(this.TAG, "onResume start");
        if (getKeyguardFlag() && !PermissionManager.checkCameraLaunchPermissions()) {
            Log.w(this.TAG, "start from keyguard, not grant lunch permission, finish activity");
            finish();
        }
        showBlurCover();
        if (!(Util.sIsnotchScreenHidden == Util.isNotchScreenHidden(this) && Util.sIsFullScreenNavBarHidden == Util.isFullScreenNavBarHidden(this))) {
            Util.initialize(this);
            Util.initStatusBarHeight(getApplicationContext());
            if (Util.isContentViewExtendToTopEdges()) {
                CompatibilityUtils.setCutoutModeShortEdges(getWindow());
            }
        }
        AutoLockManager.getInstance(this).onResume();
        ProximitySensorLock proximitySensorLock = this.mProximitySensorLock;
        if (proximitySensorLock != null) {
            proximitySensorLock.onResume();
        }
        boolean z = false;
        getContentResolver().registerContentObserver(Util.SCREEN_SLIDE_STATUS_SETTING_URI, false, this.mScreenSlideStatusObserver);
        MistatsWrapper.recordPageStart("CameraActivity");
        Util.checkLockedOrientation(this);
        this.mActivityPaused = false;
        this.mActivityStopped = false;
        switchEdgeFingerMode(true);
        this.mFirstOrientationArrived = false;
        this.mOrientationListener.enable();
        super.onResume();
        this.mIsScreenSlideOff = Util.isScreenSlideOff(this);
        if (b.ie()) {
            LensAgent.getInstance().onResume();
        }
        Storage.initStorage(this);
        if (Storage.isUseDocumentMode() && !FileCompat.hasStoragePermission(Storage.DIRECTORY)) {
            if (!getKeyguardFlag()) {
                Log.w(this.TAG, "start request documents permission");
                FileCompat.getStorageAccessForLOLLIPOP(this, Storage.DIRECTORY);
                return;
            }
            Log.w(this.TAG, "documents permission not granted, getKeyguardFlag = " + getKeyguardFlag());
            PriorityStorageBroadcastReceiver.setPriorityStorage(false);
        }
        if (getScreenHint() != null) {
            getScreenHint().updateHint();
        }
        registerReceiver();
        registerSDReceiver();
        resumeCamera();
        this.mIsModeSwitched = false;
        ThermalDetector.getInstance().registerReceiver(this.mThermalNotificationListener);
        if (this.mCameraIntentManager.isImageCaptureIntent() || this.mCameraIntentManager.isVideoCaptureIntent()) {
            z = true;
        }
        if (this.mImageSaver == null) {
            this.mImageSaver = new ImageSaver(this, this.mHandler, z);
        }
        this.mImageSaver.onHostResume(z);
        bindServices();
        triggerWatchDog(true);
        Util.updateAccessibility(this);
        if (this.mIsInRequestRuntimePermission) {
            this.mCameraRootView.post(new h(this));
        }
        Log.d(this.TAG, "onResume end");
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Log.d(this.TAG, "onSaveInstanceState");
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BaseFragmentDelegate baseFragmentDelegate = this.mBaseFragmentDelegate;
        if (baseFragmentDelegate != null) {
            baseFragmentDelegate.getAnimationComposite().onStart();
        }
    }

    public void onStop() {
        Log.d(this.TAG, "onStop start");
        super.onStop();
        removeNewBie();
        this.mActivityStopped = true;
        closeCameraSetup();
        setSwitchingModule(false);
        this.mHasbeenSetupOnFocusChanged = false;
        BaseFragmentDelegate baseFragmentDelegate = this.mBaseFragmentDelegate;
        if (baseFragmentDelegate != null) {
            baseFragmentDelegate.getAnimationComposite().onStop();
        }
        if (!this.mReleaseByModule) {
            releaseAll(true, true);
        }
        unbindServices();
        if (!isGotoGallery() && !isGotoSettings()) {
            MiAlgoAsdSceneProfile.clearInitASDScenes();
        }
        Log.d(this.TAG, "onStop end");
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        String str = this.TAG;
        Log.v(str, "onTrimMemory: level=" + i);
        MemoryHelper.setTrimLevel(i);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        Log.d(this.TAG, "onUserInteraction");
        AutoLockManager.getInstance(this).onUserInteraction();
        if (isCurrentModuleAlive()) {
            this.mCurrentModule.onUserInteraction();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        boolean isFromKeyguard = isFromKeyguard();
        String str = this.TAG;
        Log.d(str, "onWindowFocusChanged hasFocus->" + z + ", isFromKeyguard() " + isFromKeyguard + ", mHasbeenSetupOnFocusChanged " + this.mHasbeenSetupOnFocusChanged);
        this.mHasFocus = z;
        super.onWindowFocusChanged(z);
        boolean z2 = Camera2OpenManager.getInstance().getCurrentCamera2Device() == null;
        if (this.mHasFocus && ((z2 || (isFromKeyguard && !this.mHasbeenSetupOnFocusChanged)) && this.mCameraSetupDisposable == null)) {
            Log.d(this.TAG, "setupCamera in onWindowFocusChanged");
            this.mHasbeenSetupOnFocusChanged = true;
            if (!isCurrentModuleAlive() || z2) {
                setupCamera(this.mStartControl);
            }
        }
        Module module = this.mCurrentModule;
        if (module != null) {
            module.onWindowFocusChanged(z);
            CameraBrightness cameraBrightness = this.mCameraBrightness;
            if (cameraBrightness != null) {
                cameraBrightness.onWindowFocusChanged(z);
            }
            if (z) {
                Util.checkLockedOrientation(this);
                this.mCurrentModule.checkActivityOrientation();
                SensorStateManager sensorStateManager = this.mSensorStateManager;
                if (sensorStateManager != null) {
                    sensorStateManager.register();
                    return;
                }
                return;
            }
            SensorStateManager sensorStateManager2 = this.mSensorStateManager;
            if (sensorStateManager2 != null) {
                sensorStateManager2.unregister(255);
            }
        }
    }

    public void pause() {
        if (!isRecording()) {
            super.pause();
        }
    }

    public void registerProtocol() {
        ModeCoordinatorImpl.forceDestroy();
        ModeCoordinatorImpl.create(hashCode());
        EffectChangedListenerController.setHoldKey(hashCode());
        this.mImplFactory = new ImplFactory();
        this.mImplFactory.initBase(this, 171);
        DataItemGlobal dataItemGlobal = DataRepository.dataItemGlobal();
        getCameraIntentManager();
        dataItemGlobal.parseIntent(getIntent(), Boolean.valueOf(this.mCameraIntentManager.checkCallerLegality()), startFromSecureKeyguard(), false, true);
        onModeSelected(StartControl.create(dataItemGlobal.getCurrentMode()).setResetType(dataItemGlobal.isTimeOut() ? 3 : 2));
    }

    public void releaseAll(boolean z, boolean z2) {
        if (isActivityStopped() || !z) {
            releaseAll(z, z2, true);
        } else {
            this.mReleaseByModule = false;
        }
    }

    public void removeNewBie() {
        String str = this.TAG;
        Log.d(str, "removeNewBie = " + this.newbieDialogFragmentTag);
        getCameraScreenNail().drawBlackFrame(false);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.newbieDialogFragmentTag != null) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.newbieDialogFragmentTag);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public void removeShotAfterPictureTaken() {
        if (Camera2OpenManager.getInstance().getCurrentCamera2Device() != null) {
            Camera2OpenManager.getInstance().getCurrentCamera2Device().onParallelImagePostProcStart();
        }
    }

    public void restoreWindowBrightness() {
        float f2;
        CameraBrightness cameraBrightness = this.mCameraBrightness;
        if (cameraBrightness != null) {
            int currentBrightness = cameraBrightness.getCurrentBrightness();
            if (currentBrightness > 0) {
                f2 = ((float) currentBrightness) / 255.0f;
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.screenBrightness = f2;
                getWindow().setAttributes(attributes);
                setBrightnessRampRate(-1);
                setScreenEffect(false);
            }
        }
        f2 = -1.0f;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.screenBrightness = f2;
        getWindow().setAttributes(attributes2);
        setBrightnessRampRate(-1);
        setScreenEffect(false);
    }

    public void resume() {
        if (!isRecording()) {
            super.resume();
        }
    }

    public void resumeCurrentMode(int i) {
        closeCameraSetup();
        setSwitchingModule(true);
        FunctionCameraLegacySetup functionCameraLegacySetup = new FunctionCameraLegacySetup(i);
        FunctionResumeModule functionResumeModule = new FunctionResumeModule(i);
        Single map = Single.just(NullHolder.ofNullable((BaseModule) this.mCurrentModule)).observeOn(GlobalConstant.sCameraSetupScheduler).map(functionCameraLegacySetup);
        Single observeOn = Single.create(this.mCamera2OpenOnSubScribe).observeOn(GlobalConstant.sCameraSetupScheduler);
        synchronized (this.mCameraSetupDisposableGuard) {
            this.mCameraSetupDisposable = map.zipWith(observeOn, this.mCameraOpenResult).map(functionResumeModule).observeOn(AndroidSchedulers.mainThread()).subscribe(this.mCameraSetupConsumer);
        }
    }

    @Deprecated
    public void setBlockingLifeCycles(List<String> list) {
    }

    public void setWindowBrightness(int i) {
        setBrightnessRampRate(0);
        setScreenEffect(true);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = ((float) i) / 255.0f;
        getWindow().setAttributes(attributes);
    }

    public void showGuide() {
        showGuide(DataRepository.dataItemGlobal().getCurrentMode());
    }

    public void showGuide(int i) {
        boolean isCtsCall = getCameraIntentManager().isCtsCall();
        String str = this.TAG;
        Log.d(str, "showGuide = " + i + "  isCtsCall = " + isCtsCall);
        if (!isCtsCall && !ThermalDetector.getInstance().thermalConstrained()) {
            DataItemGlobal dataItemGlobal = DataRepository.dataItemGlobal();
            if (i == 162) {
                if ((DataRepository.dataItemFeature().Uc() && DataRepository.dataItemGlobal().getCurrentCameraId() == 0) && DataRepository.dataItemGlobal().isNormalIntent() && dataItemGlobal.getBoolean("pref_camera_first_vv_hint_shown_key", true) && !isNewBieAlive(6)) {
                    showNewBie(6);
                }
            } else if (i == 163) {
                boolean jd = DataRepository.dataItemFeature().jd();
                boolean ue = DataRepository.dataItemFeature().ue();
                boolean isSupportUltraWide = DataRepository.dataItemFeature().isSupportUltraWide();
                if (jd) {
                    if (!isNewBieAlive(7) && dataItemGlobal.getBoolean("pref_camera_first_ultra_tele_use_hint_shown_key", true)) {
                        showNewBie(7);
                    }
                } else if (ue) {
                    if (!isNewBieAlive(5) && dataItemGlobal.getBoolean("pref_camera_first_macro_mode_use_hint_shown_key", true)) {
                        showNewBie(5);
                    }
                } else if (isSupportUltraWide) {
                    if (!isNewBieAlive(4) && dataItemGlobal.getBoolean("pref_camera_first_ultra_wide_use_hint_shown_key", true)) {
                        showNewBie(4);
                    }
                } else if (!isNewBieAlive(3) && dataItemGlobal.getBoolean("pref_camera_first_ai_scene_use_hint_shown_key", true) && DataRepository.dataItemFeature().uc()) {
                    showNewBie(3);
                }
            } else if (i == 182 && DataRepository.dataItemFeature().Nc() && !isNewBieAlive(8) && dataItemGlobal.getBoolean("pref_camera_first_id_card_mode_use_hint_shown_key", true)) {
                showNewBie(8);
            }
        }
    }

    public void showLensDirtyDetectedHint() {
        if (DataRepository.dataItemFeature().Qc()) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    FragmentTopConfig fragmentTopConfig = (FragmentTopConfig) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
                    if (fragmentTopConfig != null) {
                        fragmentTopConfig.alertAiDetectTipHint(0, R.string.dirty_tip_toast, 3000);
                    }
                }
            });
        } else if (getSupportFragmentManager().findFragmentByTag(LensDirtyDetectDialogFragment.TAG) == null) {
            LensDirtyDetectDialogFragment lensDirtyDetectDialogFragment = new LensDirtyDetectDialogFragment();
            lensDirtyDetectDialogFragment.setStyle(2, R.style.LensDirtyDetectDialogFragment);
            getSupportFragmentManager().beginTransaction().add((Fragment) lensDirtyDetectDialogFragment, LensDirtyDetectDialogFragment.TAG).commitAllowingStateLoss();
        }
    }

    public boolean showNewBie(int i) {
        if (!(i == 2 || i == 1 || getCameraScreenNail() == null)) {
            getCameraScreenNail().drawBlackFrame(true);
        }
        switch (i) {
            case 2:
                FrontRotateNewbieDialogFragment frontRotateNewbieDialogFragment = new FrontRotateNewbieDialogFragment();
                frontRotateNewbieDialogFragment.setStyle(2, R.style.DialogFragmentFullScreen);
                getSupportFragmentManager().beginTransaction().add((Fragment) frontRotateNewbieDialogFragment, FrontRotateNewbieDialogFragment.TAG).commitAllowingStateLoss();
                this.newbieDialogFragmentTag = FrontRotateNewbieDialogFragment.TAG;
                return true;
            case 3:
                AiSceneNewbieDialogFragment aiSceneNewbieDialogFragment = new AiSceneNewbieDialogFragment();
                aiSceneNewbieDialogFragment.setStyle(2, R.style.DialogFragmentFullScreen);
                getSupportFragmentManager().beginTransaction().add((Fragment) aiSceneNewbieDialogFragment, AiSceneNewbieDialogFragment.TAG).commitAllowingStateLoss();
                this.newbieDialogFragmentTag = AiSceneNewbieDialogFragment.TAG;
                DataRepository.dataItemGlobal().editor().putBoolean("pref_camera_first_ai_scene_use_hint_shown_key", false).apply();
                return true;
            case 4:
                UltraWideNewbieDialogFragment ultraWideNewbieDialogFragment = new UltraWideNewbieDialogFragment();
                ultraWideNewbieDialogFragment.setStyle(2, R.style.DialogFragmentFullScreen);
                getSupportFragmentManager().beginTransaction().add((Fragment) ultraWideNewbieDialogFragment, UltraWideNewbieDialogFragment.TAG).commitAllowingStateLoss();
                this.newbieDialogFragmentTag = UltraWideNewbieDialogFragment.TAG;
                DataRepository.dataItemGlobal().editor().putBoolean("pref_camera_first_ultra_wide_use_hint_shown_key", false).apply();
                return true;
            case 5:
                MacroModeNewbieDialogFragment macroModeNewbieDialogFragment = new MacroModeNewbieDialogFragment();
                macroModeNewbieDialogFragment.setStyle(2, R.style.DialogFragmentFullScreen);
                getSupportFragmentManager().beginTransaction().add((Fragment) macroModeNewbieDialogFragment, MacroModeNewbieDialogFragment.TAG).commitAllowingStateLoss();
                this.newbieDialogFragmentTag = MacroModeNewbieDialogFragment.TAG;
                DataRepository.dataItemGlobal().editor().putBoolean("pref_camera_first_macro_mode_use_hint_shown_key", false).apply();
                return true;
            case 6:
                VVNewbieDialogFragment vVNewbieDialogFragment = new VVNewbieDialogFragment();
                vVNewbieDialogFragment.setStyle(2, R.style.DialogFragmentFullScreen);
                getSupportFragmentManager().beginTransaction().add((Fragment) vVNewbieDialogFragment, VVNewbieDialogFragment.TAG).commitAllowingStateLoss();
                this.newbieDialogFragmentTag = VVNewbieDialogFragment.TAG;
                DataRepository.dataItemGlobal().editor().putBoolean("pref_camera_first_vv_hint_shown_key", false).apply();
                return true;
            case 7:
                UltraTeleNewbieDialogFragment ultraTeleNewbieDialogFragment = new UltraTeleNewbieDialogFragment();
                ultraTeleNewbieDialogFragment.setStyle(2, R.style.DialogFragmentFullScreen);
                getSupportFragmentManager().beginTransaction().add((Fragment) ultraTeleNewbieDialogFragment, UltraTeleNewbieDialogFragment.TAG).commitAllowingStateLoss();
                this.newbieDialogFragmentTag = UltraTeleNewbieDialogFragment.TAG;
                DataRepository.dataItemGlobal().editor().putBoolean("pref_camera_first_ultra_tele_use_hint_shown_key", false).apply();
                return true;
            case 8:
                IDCardModeNewbieDialogFragment iDCardModeNewbieDialogFragment = new IDCardModeNewbieDialogFragment();
                iDCardModeNewbieDialogFragment.setStyle(2, R.style.DialogFragmentFullScreen);
                getSupportFragmentManager().beginTransaction().add((Fragment) iDCardModeNewbieDialogFragment, IDCardModeNewbieDialogFragment.TAG).commitAllowingStateLoss();
                this.newbieDialogFragmentTag = IDCardModeNewbieDialogFragment.TAG;
                DataRepository.dataItemGlobal().editor().putBoolean("pref_camera_first_id_card_mode_use_hint_shown_key", false).apply();
                return true;
            default:
                return false;
        }
    }

    public void showNewNotification() {
        if (startFromSecureKeyguard() || Util.isGlobalVersion() || this.mIsLunchFromAutoTest || TextUtils.isEmpty(DataRepository.dataItemFeature().eb()) || DataRepository.dataItemGlobal().getBoolean(CameraSettings.KEY_CAMERA_FIRST_NOTIFICATION_SHOWN, false)) {
            Log.w(this.TAG, "showNewNotification: return...");
            return;
        }
        LocaleList locales = getResources().getConfiguration().getLocales();
        if (locales != null && locales.size() >= 1) {
            Locale locale = locales.get(0);
            if (locale.getDisplayName().equals(Locale.CHINA.getDisplayName()) || locale.getDisplayName().equals(Locale.US.getDisplayName())) {
                DataRepository.dataItemGlobal().editor().putBoolean(CameraSettings.KEY_CAMERA_FIRST_NOTIFICATION_SHOWN, true).apply();
                Intent intent = new Intent("com.miui.miservice.MISERVICE_NOTIFICATION");
                intent.putExtra("intent_extra_key_flag", "2");
                intent.putExtra("intent_extra_key_label", DataRepository.dataItemFeature().eb());
                intent.putExtra("intent_extra_key_title", getString(R.string.miservice_notification_title));
                intent.putExtra("intent_extra_key_content", getString(R.string.miservice_notification_content));
                intent.putExtra("intent_extra_key_is_to_main", true);
                intent.addFlags(32);
                intent.addFlags(16777216);
                sendBroadcast(intent);
                return;
            }
            Log.w(this.TAG, "showNewNotification: locale does not match, return...");
        }
    }

    public void unRegisterProtocol() {
        ImplFactory implFactory = this.mImplFactory;
        if (implFactory != null) {
            implFactory.detachBase();
        }
        BaseFragmentDelegate baseFragmentDelegate = this.mBaseFragmentDelegate;
        if (baseFragmentDelegate != null) {
            baseFragmentDelegate.unRegisterProtocol();
            this.mBaseFragmentDelegate = null;
        }
    }

    public void updateSurfaceState(int i) {
        super.updateSurfaceState(i);
        if (i == 4) {
            this.mCamera2OpenOnSubScribe.onGlSurfaceCreated();
            if (ModuleManager.isCapture()) {
                Module module = this.mCurrentModule;
                if (module != null) {
                    ((BaseModule) module).updatePreviewSurface();
                } else {
                    Log.w(this.TAG, "updateSurfaceState: module has not been initialized");
                }
            }
        }
    }
}
