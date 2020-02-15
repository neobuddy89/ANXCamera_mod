package com.arcsoft.avatar;

import com.arcsoft.avatar.AvatarConfig;
import com.arcsoft.avatar.util.ASVLOFFSCREEN;
import com.arcsoft.avatar.util.LOG;
import com.arcsoft.avatar.util.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class AvatarEngine implements AvatarConfig {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19a = "AvatarEngine";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f20b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f21c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TreeMap<String, AvatarConfig.ASAvatarConfigInfo> f22d = new TreeMap<>();

    /* renamed from: e  reason: collision with root package name */
    private long f23e = 0;

    static {
        System.loadLibrary("Arcsoft_Avatar_Jni");
        System.loadLibrary(f19a);
    }

    private native int nativeAvatarProcess(long j, int i, int i2, int i3, byte[] bArr, byte[] bArr2, int i4, boolean z, int i5);

    private native int nativeAvatarProcessEx(long j, int i, int i2, int i3, ByteBuffer[] byteBufferArr, byte[] bArr, int i4, boolean z, int i5);

    private native int nativeAvatarProcessEx2(long j, ASVLOFFSCREEN asvloffscreen, byte[] bArr, int i, boolean z, int i2);

    private native int nativeAvatarProfile(long j, String str, int i, int i2, int i3, byte[] bArr, int i4, boolean z, AvatarConfig.ASAvatarProfileResult aSAvatarProfileResult, AvatarConfig.ASAvatarProfileInfo aSAvatarProfileInfo, AvatarConfig.UpdateProgressCallback updateProgressCallback);

    private native int nativeAvatarRender(long j, int i, int i2, int i3, int i4, boolean z, int[] iArr);

    private native long nativeCreate();

    private native int nativeDestroy(long j);

    private native int nativeGetConfig(long j, int i, int i2, AvatarConfig.GetConfigCallback getConfigCallback);

    private native int nativeGetConfigValue(long j, AvatarConfig.ASAvatarConfigValue aSAvatarConfigValue);

    private native int nativeGetSupportConfigType(long j, int i, AvatarConfig.GetSupportConfigTypeCallback getSupportConfigTypeCallback);

    private native int nativeInit(long j, String str, String str2);

    private native boolean nativeIsSupportSwitchGender(long j);

    private native int nativeLoadColorValue(String str);

    private native int nativeLoadConfig(long j, String str);

    private native int nativeOutlineCreateEngine(long j, String str);

    private native int nativeOutlineDestroyEngine(long j);

    private native int nativeOutlineProcess(long j, byte[] bArr, int i, int i2, int i3, int i4, AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo);

    private native int nativeOutlineProcessEx(long j, ASVLOFFSCREEN asvloffscreen, int i, AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo);

    private native int nativeProcessOutlineExpression(long j, byte[] bArr, int i, int i2, int i3, int i4, boolean z, int i5, AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo);

    private native int nativeProcessWithInfo(long j, byte[] bArr, int i, int i2, int i3, int i4, boolean z, int i5, AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo);

    private native int nativeProcessWithInfoEx(long j, ASVLOFFSCREEN asvloffscreen, int i, boolean z, int i2, AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo, boolean z2);

    private native int nativeReleaseRender(long j);

    private native int nativeRenderBackgroundWithImageData(long j, ASVLOFFSCREEN asvloffscreen, int i, boolean z, int[] iArr);

    private native int nativeRenderBackgroundWithTexture(long j, int i, int i2, boolean z);

    private native int nativeRenderThumb(long j, int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6, int i7, float[] fArr, float f2);

    private native int nativeRenderWithBackground(long j, ASVLOFFSCREEN asvloffscreen, int i, boolean z, int i2, int i3, int i4, int i5, boolean z2, int[] iArr, byte[] bArr);

    private native int nativeSaveConfig(long j, String str);

    private native int nativeSetConfig(long j, AvatarConfig.ASAvatarConfigInfo aSAvatarConfigInfo);

    private native int nativeSetRenderScene(long j, boolean z, float f2);

    private native int nativeSetTemplate(long j, String str);

    private native int nativeSwitchGender(long j, boolean z);

    private native int nativeUnInit(long j);

    public synchronized int avatarProcess(int i, int i2, int i3, byte[] bArr, byte[] bArr2, int i4, boolean z, int i5) {
        int nativeAvatarProcess;
        synchronized (this) {
            nativeAvatarProcess = nativeAvatarProcess(this.f23e, i, i2, i3, bArr, bArr2, i4, z, i5);
        }
        return nativeAvatarProcess;
    }

    public synchronized int avatarProcessEx(int i, int i2, int i3, ByteBuffer[] byteBufferArr, byte[] bArr, int i4, boolean z, int i5) {
        int nativeAvatarProcessEx;
        synchronized (this) {
            nativeAvatarProcessEx = nativeAvatarProcessEx(this.f23e, i, i2, i3, byteBufferArr, bArr, i4, z, i5);
        }
        return nativeAvatarProcessEx;
    }

    public synchronized int avatarProcessEx2(ASVLOFFSCREEN asvloffscreen, byte[] bArr, int i, boolean z, int i2) {
        return nativeAvatarProcessEx2(this.f23e, asvloffscreen, bArr, i, z, i2);
    }

    public int avatarProcessWithInfo(byte[] bArr, int i, int i2, int i3, int i4, boolean z, int i5, AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo) {
        d.a("avatarProcessWithInfo");
        int nativeProcessWithInfo = nativeProcessWithInfo(this.f23e, bArr, i, i2, i3, i4, z, i5, aSAvatarProcessInfo);
        d.a("performance", "avatarProcessWithInfo");
        return nativeProcessWithInfo;
    }

    public int avatarProcessWithInfoEx(ASVLOFFSCREEN asvloffscreen, int i, boolean z, int i2, AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo, boolean z2) {
        return nativeProcessWithInfoEx(this.f23e, asvloffscreen, i, z, i2, aSAvatarProcessInfo, z2);
    }

    public synchronized int avatarProfile(String str, int i, int i2, int i3, byte[] bArr, int i4, boolean z, AvatarConfig.ASAvatarProfileResult aSAvatarProfileResult, AvatarConfig.ASAvatarProfileInfo aSAvatarProfileInfo, AvatarConfig.UpdateProgressCallback updateProgressCallback) {
        int nativeAvatarProfile;
        synchronized (this) {
            nativeAvatarProfile = nativeAvatarProfile(this.f23e, str, i, i2, i3, bArr, i4, z, aSAvatarProfileResult, aSAvatarProfileInfo, updateProgressCallback);
        }
        return nativeAvatarProfile;
    }

    public synchronized void avatarRender(int i, int i2, int i3, int i4, boolean z, int[] iArr) {
        nativeAvatarRender(this.f23e, i, i2, i3, i4, z, iArr);
    }

    public int checkOutlineInfo(AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo) {
        if (aSAvatarProcessInfo == null) {
            LOG.d("CheckOutLine", "null");
            return 1;
        }
        LOG.d("CheckOutLine", "faceCount = " + aSAvatarProcessInfo.getFaceCount());
        if (aSAvatarProcessInfo.getFaceCount() > 1) {
            return 10;
        }
        if (aSAvatarProcessInfo.shelterIsNull()) {
            LOG.d("CheckOutLine", "shelterFlags == null");
            return 1;
        } else if (aSAvatarProcessInfo.getFaceCount() <= 0) {
            return 1;
        } else {
            return aSAvatarProcessInfo.checkOutLineInfo();
        }
    }

    public synchronized int createOutlineEngine(String str) {
        return nativeOutlineCreateEngine(this.f23e, str);
    }

    public synchronized void destroy() {
        d.a("destroy");
        nativeDestroy(this.f23e);
        this.f23e = 0;
        d.a("performance", "destroy");
    }

    public synchronized int destroyOutlineEngine() {
        return nativeOutlineDestroyEngine(this.f23e);
    }

    public synchronized ArrayList<AvatarConfig.ASAvatarConfigInfo> getConfig(final int i, int i2) {
        final ArrayList<AvatarConfig.ASAvatarConfigInfo> arrayList;
        arrayList = new ArrayList<>();
        nativeGetConfig(this.f23e, i, i2, new AvatarConfig.GetConfigCallback() {
            public void onGetConfig(int i, int i2, int i3, int i4, String str, String str2, int i5, int i6, boolean z, boolean z2, boolean z3, float f2) {
                AvatarConfig.ASAvatarConfigInfo aSAvatarConfigInfo = new AvatarConfig.ASAvatarConfigInfo();
                aSAvatarConfigInfo.configID = i;
                aSAvatarConfigInfo.configType = i3;
                aSAvatarConfigInfo.gender = i4;
                aSAvatarConfigInfo.name = str;
                aSAvatarConfigInfo.configThumbPath = str2;
                aSAvatarConfigInfo.isDefault = z;
                aSAvatarConfigInfo.isValid = z2;
                aSAvatarConfigInfo.isSupportContinuous = z3;
                aSAvatarConfigInfo.continuousValue = f2;
                aSAvatarConfigInfo.startColorValue = i5;
                aSAvatarConfigInfo.endColorValue = i6;
                if (i3 == 5 && i2 != -1) {
                    String num = new Integer(i2).toString();
                    if (!AvatarEngine.this.f22d.containsKey(num)) {
                        AvatarEngine.this.f22d.put(num, aSAvatarConfigInfo);
                    }
                    if (i2 != AvatarEngine.this.f20b) {
                        return;
                    }
                }
                arrayList.add(aSAvatarConfigInfo);
                LOG.d(AvatarEngine.f19a, "type = " + i + " info = " + aSAvatarConfigInfo.toString());
            }
        });
        return arrayList;
    }

    public synchronized void getConfigValue(AvatarConfig.ASAvatarConfigValue aSAvatarConfigValue) {
        nativeGetConfigValue(this.f23e, aSAvatarConfigValue);
        this.f20b = aSAvatarConfigValue.configFaceColorID;
        this.f21c = aSAvatarConfigValue.configLipColorID;
    }

    public synchronized ArrayList<AvatarConfig.ASAvatarConfigType> getSupportConfigType(int i) {
        final ArrayList<AvatarConfig.ASAvatarConfigType> arrayList;
        arrayList = new ArrayList<>();
        nativeGetSupportConfigType(this.f23e, i, new AvatarConfig.GetSupportConfigTypeCallback() {
            public void onGetSupportConfigType(String str, int i) {
                AvatarConfig.ASAvatarConfigType aSAvatarConfigType = new AvatarConfig.ASAvatarConfigType();
                aSAvatarConfigType.configType = i;
                aSAvatarConfigType.configTypeDesc = str;
                arrayList.add(aSAvatarConfigType);
            }
        });
        return arrayList;
    }

    public synchronized void init(String str, String str2) {
        d.a("init");
        this.f23e = nativeCreate();
        int nativeInit = nativeInit(this.f23e, str, str2);
        LOG.d(f19a, "init res = " + nativeInit);
        d.a("performance", "init");
    }

    public synchronized boolean isSupportSwitchGender() {
        return nativeIsSupportSwitchGender(this.f23e);
    }

    public synchronized int loadColorValue(String str) {
        return nativeLoadColorValue(str);
    }

    public synchronized void loadConfig(String str) {
        d.a("loadConfig");
        nativeLoadConfig(this.f23e, str);
        d.a("performance", "loadConfig");
    }

    public synchronized int outlineProcess(byte[] bArr, int i, int i2, int i3, int i4) {
        AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo;
        aSAvatarProcessInfo = new AvatarConfig.ASAvatarProcessInfo();
        d.a("outlineProcess");
        int nativeOutlineProcess = nativeOutlineProcess(this.f23e, bArr, i, i2, i3, i4, aSAvatarProcessInfo);
        d.a("performance", "outlineProcess");
        LOG.d("CheckOutLine", "nativeOutlineProcess = " + nativeOutlineProcess);
        return checkOutlineInfo(aSAvatarProcessInfo);
    }

    public synchronized int outlineProcessEx(ASVLOFFSCREEN asvloffscreen, int i) {
        AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo;
        aSAvatarProcessInfo = new AvatarConfig.ASAvatarProcessInfo();
        d.a("outlineProcessEx");
        int nativeOutlineProcessEx = nativeOutlineProcessEx(this.f23e, asvloffscreen, i, aSAvatarProcessInfo);
        d.a("performance", "outlineProcessEx");
        LOG.d("CheckOutLine", "nativeOutlineProcess = " + nativeOutlineProcessEx);
        return checkOutlineInfo(aSAvatarProcessInfo);
    }

    public synchronized int processOutlineExpression(byte[] bArr, int i, int i2, int i3, int i4, boolean z, int i5, AvatarConfig.ASAvatarProcessInfo aSAvatarProcessInfo) {
        int nativeProcessOutlineExpression;
        synchronized (this) {
            nativeProcessOutlineExpression = nativeProcessOutlineExpression(this.f23e, bArr, i, i2, i3, i4, z, i5, aSAvatarProcessInfo);
        }
        return nativeProcessOutlineExpression;
    }

    public synchronized void releaseRender() {
        d.a("releaseRender");
        nativeReleaseRender(this.f23e);
        d.a("performance", "releaseRender");
    }

    public int renderBackgroundWithImageData(ASVLOFFSCREEN asvloffscreen, int i, boolean z, int[] iArr) {
        return nativeRenderBackgroundWithImageData(this.f23e, asvloffscreen, i, z, iArr);
    }

    public int renderBackgroundWithTexture(int i, int i2, boolean z) {
        return nativeRenderBackgroundWithTexture(this.f23e, i, i2, z);
    }

    public synchronized int renderThumb(int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6, int i7, float[] fArr, float f2) {
        int nativeRenderThumb;
        synchronized (this) {
            d.a("renderThumb");
            nativeRenderThumb = nativeRenderThumb(this.f23e, i, i2, i3, i4, bArr, i5, i6, i7, fArr, f2);
            d.a("performance", "renderThumb");
        }
        return nativeRenderThumb;
    }

    public int renderWithBackground(ASVLOFFSCREEN asvloffscreen, int i, boolean z, int i2, int i3, int i4, int i5, boolean z2, int[] iArr, byte[] bArr) {
        return nativeRenderWithBackground(this.f23e, asvloffscreen, i, z, i2, i3, i4, i5, z2, iArr, bArr);
    }

    public synchronized int saveConfig(String str) {
        return nativeSaveConfig(this.f23e, str);
    }

    public synchronized int setConfig(AvatarConfig.ASAvatarConfigInfo aSAvatarConfigInfo) {
        if (aSAvatarConfigInfo.configType == 3) {
            this.f20b = aSAvatarConfigInfo.configID;
            String num = new Integer(this.f20b).toString();
            if (this.f22d.size() > 0 && this.f22d.containsKey(num)) {
                boolean z = false;
                Iterator<AvatarConfig.ASAvatarConfigInfo> it = this.f22d.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().configID == this.f21c) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    nativeSetConfig(this.f23e, this.f22d.get(num));
                }
            }
        } else if (aSAvatarConfigInfo.configType == 5) {
            this.f21c = aSAvatarConfigInfo.configID;
        }
        return nativeSetConfig(this.f23e, aSAvatarConfigInfo);
    }

    public synchronized void setRenderScene(boolean z, float f2) {
        nativeSetRenderScene(this.f23e, z, f2);
    }

    public synchronized void setTemplatePath(String str) {
        d.a("setTemplatePath");
        nativeSetTemplate(this.f23e, str);
        d.a("performance", "setTemplatePath");
    }

    public synchronized void switchGender(boolean z) {
        nativeSwitchGender(this.f23e, z);
    }

    public synchronized void unInit() {
        d.a("unInit");
        int nativeUnInit = nativeUnInit(this.f23e);
        d.a("performance", "unInit");
        LOG.d(f19a, "uninit res = " + nativeUnInit);
    }
}
