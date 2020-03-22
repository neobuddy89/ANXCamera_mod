package com.mi.config;

import android.os.Build;
import android.os.SystemProperties;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Size;
import com.android.camera.CameraAppImpl;
import com.android.camera.CameraSettings;
import com.android.camera.HybridZoomingSystem;
import com.android.camera.Util;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.DataItemBase;
import com.android.camera.log.Log;
import com.xiaomi.stat.C0157d;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DataItemFeature */
public class a extends DataItemBase implements c {
    private static final String TAG = "DataFeature";
    private static final String yb = "feature_";
    private static final boolean zb = false;
    private String xb;

    public a() {
        d(yb + b.xm, true);
    }

    private int A(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        char charAt = str.charAt(0);
        if (Character.isDigit(charAt)) {
            return Integer.parseInt(String.valueOf(charAt));
        }
        return -1;
    }

    private Size B(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String substring = str.substring(str.indexOf(58) + 1);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        String[] split = substring.replace(" ", "").split("x");
        if (split.length >= 2) {
            return new Size(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue());
        }
        return null;
    }

    private int Bl() {
        return getInt(c.Qu, 0);
    }

    private boolean Cl() {
        return getBoolean(c.mu, false);
    }

    private boolean Dl() {
        return getBoolean(c.St, false);
    }

    private void c(String str, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        SimpleArrayMap<String, Object> values = getValues();
        String str2 = null;
        while (keys.hasNext()) {
            String next = keys.next();
            if (TextUtils.equals("parent", next)) {
                if (z) {
                    Object opt = jSONObject.opt(next);
                    if (opt instanceof String) {
                        str2 = opt.toString();
                    }
                } else {
                    throw new UnsupportedOperationException("Parent json file can't nest parent");
                }
            } else if (z) {
                if (values.put(next, jSONObject.opt(next)) != null) {
                    throw new IllegalStateException("Duplicate key is found in the configuration file: " + next);
                }
            } else if (!values.containsKey(next)) {
                values.put(next, jSONObject.opt(next));
            } else {
                Log.w(TAG, "parseJson: ignore key = " + next + ", value = " + jSONObject.opt(next));
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            d(str2, false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0078, code lost:
        c(r5.toString(), r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0085, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        throw r0;
     */
    private void d(String str, boolean z) {
        if (CameraAppImpl.getAndroidContext().getResources().getIdentifier(str, "raw", "com.android.camera") <= 0) {
            Log.e(TAG, "feature list default, firstInit = " + z + ", name = " + str);
            return;
        }
        Log.d(TAG, "parseJsonFile: start >>> " + str);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/sdcard/.ANXCamera/cheatcodes/" + str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
        } catch (IOException | JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            r11.addSuppressed(th);
        }
        Log.d(TAG, "parseJsonFile: end >>> " + str + ", firstInit = " + z + ", cost " + (System.currentTimeMillis() - currentTimeMillis) + C0157d.H);
    }

    public boolean Ab() {
        return getBoolean(c.bv, false);
    }

    public boolean Ac() {
        return getBoolean(c.Hs, false);
    }

    public boolean Ad() {
        if (b.ak()) {
            return false;
        }
        return getBoolean(c.nt, true);
    }

    public boolean Ae() {
        if (!HybridZoomingSystem.IS_3_OR_MORE_SAT) {
            return false;
        }
        return getBoolean(c.yt, false);
    }

    public boolean Bb() {
        if (this.xb == null) {
            this.xb = SystemProperties.get("ro.boot.hwc");
        }
        return "cn".equalsIgnoreCase(this.xb);
    }

    public boolean Bc() {
        return getBoolean(c.au, false);
    }

    public boolean Bd() {
        return Build.VERSION.SDK_INT >= 28 && getBoolean(c.Ir, false);
    }

    public boolean Be() {
        return getBoolean(c.tr, false);
    }

    public boolean Cb() {
        return Arrays.asList(getString(c.Dr, "").toUpperCase().split(":")).contains("CAPTURE_INTENT");
    }

    public boolean Cc() {
        return getBoolean(c.Lt, false);
    }

    public boolean Cd() {
        return getBoolean(c.qu, false);
    }

    public boolean Ce() {
        return getBoolean(c.rr, false);
    }

    public boolean Db() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return getBoolean(c.Ls, false);
    }

    public boolean Dc() {
        return getBoolean(c.Eu, false);
    }

    public boolean Dd() {
        return getBoolean(c.Gr, false);
    }

    public boolean De() {
        return getBoolean(c.Yu, false) || SystemProperties.getBoolean("miuicamera.sat.video", false);
    }

    public boolean Eb() {
        return getBoolean(c.Fu, false);
    }

    public boolean Ec() {
        return getBoolean(c.ht, true);
    }

    public boolean Ed() {
        return Arrays.asList(getString(c.Dr, "").toUpperCase().split(":")).contains("ULTRA_WIDE");
    }

    public boolean Ee() {
        return getBoolean(c.Ap, false);
    }

    public boolean Fb() {
        return getBoolean(c.Uu, false);
    }

    public boolean Fc() {
        return getBoolean(c.ou, false);
    }

    public boolean Fd() {
        return getBoolean(c.ns, false);
    }

    public boolean Fe() {
        return getBoolean(c.Bt, true);
    }

    public boolean Gb() {
        return getBoolean(c.Ht, true);
    }

    public boolean Gc() {
        return getBoolean(c.rs, false);
    }

    public boolean Gd() {
        return getBoolean(c.Ur, false);
    }

    public boolean Ge() {
        return getBoolean(c.It, false);
    }

    public boolean Hb() {
        return getBoolean(c.Rs, true);
    }

    public boolean Hc() {
        return getBoolean(c.kt, false);
    }

    public boolean Hd() {
        return Oc();
    }

    public boolean He() {
        return getBoolean(c.Er, false) || getBoolean(c.Fr, false) || getBoolean(c.Jt, false) || getBoolean(c.Kt, false);
    }

    public boolean Ib() {
        return getBoolean(c.Kr, false);
    }

    public boolean Ic() {
        return getBoolean(c.ku, false);
    }

    public boolean Id() {
        return getBoolean(c.pt, false);
    }

    public boolean Jb() {
        return getBoolean(c.As, true);
    }

    public boolean Jc() {
        return getBoolean(c.Os, false);
    }

    public boolean Jd() {
        return getBoolean(c.ot, !Ge());
    }

    public boolean Kb() {
        return getBoolean(c.Bs, false);
    }

    public boolean Kc() {
        return getBoolean(c.Es, false);
    }

    public boolean Kd() {
        return getBoolean(c.ks, false);
    }

    public boolean Lb() {
        return getBoolean(c.Pu, false);
    }

    public boolean Lc() {
        return getBoolean(c.jt, false) && !miui.os.Build.IS_INTERNATIONAL_BUILD;
    }

    public int Ld() {
        return getInt(c.is, 180);
    }

    public boolean Mb() {
        return getBoolean(c.Hu, false);
    }

    public boolean Mc() {
        return getBoolean(c.ps, false);
    }

    public boolean Md() {
        return getBoolean(c.Ou, false);
    }

    public boolean Nb() {
        return getBoolean(c.lt, false);
    }

    public boolean Nc() {
        if (Util.isGlobalVersion() || !DataRepository.dataItemGlobal().isNormalIntent()) {
            return false;
        }
        return getBoolean(c.Mt, false);
    }

    public boolean Nd() {
        return getBoolean(c.et, true);
    }

    public boolean Ob() {
        return getBoolean(c.ys, false);
    }

    public boolean Oc() {
        return getBoolean(c._u, false);
    }

    public boolean Od() {
        return ((double) Math.abs((((float) Util.sWindowHeight) / ((float) Util.sWindowWidth)) - 2.0833333f)) < 0.02d && getBoolean(c.xr, false);
    }

    public boolean Pb() {
        return getBoolean(c.Cu, false);
    }

    public boolean Pc() {
        return getBoolean(c.fs, false);
    }

    public boolean Pd() {
        return ((float) Util.sWindowHeight) / ((float) Util.sWindowWidth) >= 2.1666667f && getBoolean(c.vr, false);
    }

    public boolean Qa() {
        return getBoolean(c.Wu, false);
    }

    public boolean Qb() {
        return getBoolean(c.ut, false);
    }

    public boolean Qc() {
        return getBoolean(c.gs, false);
    }

    public boolean Qd() {
        return ((double) Math.abs((((float) Util.sWindowHeight) / ((float) Util.sWindowWidth)) - 2.1111112f)) <= 0.02d && getBoolean(c.wr, false);
    }

    public boolean Ra() {
        return getBoolean(c.Ts, false);
    }

    public boolean Rb() {
        if (getBoolean(c.Iu, false)) {
            return Tb() || Xb();
        }
        return false;
    }

    public boolean Rc() {
        return getBoolean(c.Yr, false);
    }

    public boolean Rd() {
        return ((float) Util.sWindowHeight) / ((float) Util.sWindowWidth) >= 2.2222223f && getBoolean(c.yr, false);
    }

    public boolean Sa() {
        return getBoolean(c.Nt, false);
    }

    public boolean Sb() {
        return getBoolean(c.Ns, false);
    }

    public boolean Sc() {
        if (Util.isGlobalVersion()) {
        }
        return getBoolean(c.Vr, false);
    }

    public boolean Sd() {
        return getBoolean(c.Ar, false);
    }

    public boolean Ta() {
        return getBoolean(c.Us, false);
    }

    public boolean Tb() {
        if (this.xb == null) {
            this.xb = SystemProperties.get("ro.boot.hwc");
        }
        if ("india".equalsIgnoreCase(this.xb)) {
            return true;
        }
        return !TextUtils.isEmpty(this.xb) && this.xb.toLowerCase(Locale.ENGLISH).startsWith("india_");
    }

    public boolean Tc() {
        return Cl() && Bl() == 1;
    }

    public boolean Td() {
        if (!getBoolean(c.av, false)) {
            return Vd();
        }
        if (!getBoolean(c.Cr, false) || !getBoolean(c.av, false) || (!(163 == DataRepository.dataItemGlobal().getCurrentMode() || 165 == DataRepository.dataItemGlobal().getCurrentMode()) || CameraSettings.getCameraId() != 0 || CameraSettings.isUltraPixelOn() || ((double) CameraSettings.readZoom()) < 1.0d)) {
            Log.i(TAG, "Algo up disabled for mm-camera");
            return false;
        }
        Log.i(TAG, "Algo up enabled for mm-camera");
        return true;
    }

    public int Ua() {
        return getInt(c.AEC_LUX_HEIGHT_LIGHT, 300);
    }

    public boolean Ub() {
        return miui.os.Build.getRegion().endsWith("IN");
    }

    public boolean Uc() {
        return Cl() && Bl() == 0;
    }

    public boolean Ud() {
        return getBoolean(c.av, false);
    }

    public int Va() {
        return getInt(c.AEC_LUX_LAST_LIGHT, 350);
    }

    public boolean Vb() {
        return getBoolean(c.Zr, false);
    }

    public boolean Vc() {
        return getBoolean(c.nu, true);
    }

    public boolean Vd() {
        return Build.VERSION.SDK_INT > 28 ? Dl() : getBoolean(c.Cr, false);
    }

    public boolean Wa() {
        return getBoolean(c.hr, false);
    }

    public boolean Wb() {
        return getBoolean(c.Qr, false);
    }

    public boolean Wc() {
        return getBoolean(c.hu, false);
    }

    public boolean Wd() {
        return getBoolean(c.Xu, false) && !SystemProperties.getBoolean("close.append.yuv", false);
    }

    public int Xa() {
        return getInt(c.su, 0);
    }

    public boolean Xb() {
        return getBoolean(c.Ju, false);
    }

    public boolean Xc() {
        return getBoolean(c.Vu, false);
    }

    public boolean Xd() {
        return getBoolean(c.Br, false);
    }

    public String Ya() {
        return getString(c.mt, "common");
    }

    public boolean Yb() {
        return getBoolean(c.Du, false);
    }

    public boolean Yc() {
        return getBoolean(c.Gt, false);
    }

    public boolean Yd() {
        return getBoolean(c.Sr, true);
    }

    public int Za() {
        return getInt(c.os, 0);
    }

    public boolean Zb() {
        return getInt(c.fu, -1) == 0;
    }

    public boolean Zc() {
        return getBoolean(c.lu, false);
    }

    public boolean Zd() {
        return getBoolean(c.Lr, false);
    }

    public String _a() {
        return getString(c.wt, "v0");
    }

    public boolean _b() {
        return getInt(c.fu, -1) == 2;
    }

    public boolean _c() {
        return getBoolean(c.Ut, false);
    }

    public boolean _d() {
        return getBoolean(c.mr, false);
    }

    public int ab() {
        return getInt(c.Ku, -1);
    }

    public boolean ac() {
        return getInt(c.fu, -1) == 1;
    }

    public boolean ad() {
        return getBoolean(c.ms, true);
    }

    public boolean ae() {
        return getBoolean(c.vt, false);
    }

    public int bb() {
        return A(getString(c.cu, ""));
    }

    public boolean bc() {
        return getBoolean(c.zr, false);
    }

    public boolean bd() {
        return getBoolean(c.ju, false);
    }

    public boolean be() {
        return getBoolean(c.Mu, false);
    }

    public boolean cc() {
        return getBoolean(c.Jr, false);
    }

    public boolean cd() {
        return getBoolean(c.Fs, false);
    }

    public boolean ce() {
        return getBoolean(c.gr, false) && Tb();
    }

    public String db() {
        return getString(c.Mr, "");
    }

    public boolean dc() {
        return getBoolean(c.Cs, false);
    }

    public boolean dd() {
        return getBoolean(c.Zs, false);
    }

    public boolean de() {
        return getBoolean(c.js, false) && Tb();
    }

    public String eb() {
        return getString(c.Ds, (String) null);
    }

    public boolean ec() {
        return Arrays.asList(getString(c.Dr, "").toUpperCase().split(":")).contains("NO_PIXEL");
    }

    public boolean ed() {
        return getBoolean(c.yu, false);
    }

    public boolean ee() {
        return getBoolean(c.xt, false);
    }

    public float fb() {
        return (float) getDoubleFromValues(c.Xr, 0.8766000270843506d);
    }

    public boolean fc() {
        return Arrays.asList(getString(c.Dr, "").toUpperCase().split(":")).contains("PRO");
    }

    public boolean fd() {
        return getBoolean(c.Ws, false);
    }

    public boolean fe() {
        return getBoolean(c.Ru, true);
    }

    public int gb() {
        return getInt(c.Wr, 280);
    }

    public boolean gd() {
        return getBoolean(c.Zt, false);
    }

    public boolean ge() {
        return getBoolean(c.Su, false);
    }

    public int hb() {
        return getInt(c.Yt, 0);
    }

    public boolean hc() {
        return getBoolean(c.Ps, false);
    }

    public boolean hd() {
        return getBoolean(c._t, false);
    }

    public boolean he() {
        return getBoolean(c.Et, false);
    }

    public int ib() {
        return getInt(c.eu, -1);
    }

    public boolean ic() {
        return getBoolean(c.Bu, false);
    }

    public boolean ie() {
        if (!Util.isGlobalVersion()) {
            return false;
        }
        return getBoolean(c.xs, false);
    }

    public boolean is4K30FpsEISSupported() {
        return getBoolean(c.es, false);
    }

    public boolean isCinematicPhotoSupported() {
        return getBoolean(c.pu, false) && Td();
    }

    /* access modifiers changed from: protected */
    public boolean isMutable() {
        return false;
    }

    public boolean isSRRequireReprocess() {
        return getBoolean(c.Gu, false);
    }

    public boolean isSupport960VideoEditor() {
        return getBoolean(c.Au, true);
    }

    public boolean isSupportBeautyBody() {
        return getBoolean(c.Rr, false);
    }

    public boolean isSupportBokehAdjust() {
        return getBoolean(c.Is, false);
    }

    public boolean isSupportMacroMode() {
        return getBoolean(c.dt, false);
    }

    public boolean isSupportNormalWideLDC() {
        return getBoolean(c._r, false);
    }

    public boolean isSupportShortVideoBeautyBody() {
        return getBoolean(c._s, false);
    }

    public boolean isSupportUltraWide() {
        return getBoolean(c.Pr, false);
    }

    public boolean isSupportUltraWideLDC() {
        return getBoolean(c.bs, false);
    }

    public boolean isSupportVideoBokehAdjust() {
        return getBoolean(c.Js, false);
    }

    public boolean isSupportVideoFilter() {
        return getBoolean(c.Ks, false);
    }

    public boolean isTransient() {
        return true;
    }

    public int jb() {
        return A(getString(c.bu, ""));
    }

    public boolean jc() {
        return Sa();
    }

    public boolean jd() {
        return getBoolean(c.Tt, false);
    }

    public boolean je() {
        return getBoolean(c.Tu, false);
    }

    public int kb() {
        if (b.kn) {
            return 6;
        }
        return getInt(c.Pt, 5);
    }

    public boolean kc() {
        return getBoolean(c.Or, false);
    }

    public boolean kd() {
        return getBoolean(c.Qs, false);
    }

    public boolean ke() {
        return getBoolean(c.sr, false);
    }

    public String l(String str) {
        return getString(c.rt, str);
    }

    public boolean l(boolean z) {
        return z && getBoolean(c.st, false);
    }

    public int lb() {
        return getInt(c.Ys, -1);
    }

    public boolean lc() {
        return getBoolean(c.Ms, false);
    }

    public boolean ld() {
        if (Util.isGlobalVersion()) {
            return false;
        }
        return getBoolean(c.Wt, false);
    }

    public boolean le() {
        return getBoolean(c.ur, false);
    }

    public String m(String str) {
        return getString(c.qt, str);
    }

    public String m(boolean z) {
        return z ? getString(c.at, "4.5") : getString(c.bt, "4");
    }

    public long mb() {
        return (long) getInt(c.Xs, -1);
    }

    public boolean mc() {
        return getBoolean(c.Nr, true);
    }

    public boolean md() {
        return getBoolean(c.wu, false);
    }

    public boolean me() {
        return getBoolean(c.pr, false);
    }

    public boolean n(String str) {
        return getValues().containsKey(str);
    }

    public int nb() {
        return getInt(c.fr, 20);
    }

    public boolean nc() {
        return Arrays.asList(getString(c.Dr, "").toUpperCase().split(":")).contains("MACRO");
    }

    public boolean nd() {
        return getBoolean(c.iu, false);
    }

    public boolean ne() {
        return (Tb() || Ub()) && getBoolean(c.lr, false);
    }

    public Size ob() {
        return B(getString(c.cu, ""));
    }

    public boolean oc() {
        return getBoolean(c.Gs, false);
    }

    public boolean od() {
        return 3 == jb();
    }

    public boolean oe() {
        return getBoolean(c.jr, false);
    }

    public Size pb() {
        return B(getString(c.bu, ""));
    }

    public boolean pc() {
        return getBoolean(c.gu, false);
    }

    public boolean pd() {
        return getBoolean(c.hs, false);
    }

    public boolean pe() {
        return getBoolean(c.kr, false);
    }

    public String provideKey() {
        return null;
    }

    public int qb() {
        return getInt(c.zu, 0);
    }

    public boolean qc() {
        return getBoolean(c.Vs, true);
    }

    public boolean qd() {
        return getBoolean(c.du, true);
    }

    public boolean qe() {
        return getBoolean(c.Nu, false);
    }

    public String rb() {
        return getString(c.uu, (String) null);
    }

    public boolean rc() {
        return getBoolean(c.ru, false);
    }

    public boolean rd() {
        return getBoolean(c.Xt, false);
    }

    public boolean re() {
        return getBoolean(c.Dt, false);
    }

    public int sb() {
        return getInt(c.Rt, 0);
    }

    public boolean sc() {
        return getBoolean(c.ct, false);
    }

    public boolean sd() {
        return getBoolean(c.Ss, false);
    }

    public boolean se() {
        return getBoolean(c.Ft, true);
    }

    public boolean shouldCheckSatFallbackState() {
        return getBoolean(c.Lu, false);
    }

    public int tb() {
        return getInt(c.Zu, 0);
    }

    public boolean tc() {
        return getBoolean(c.Vt, false);
    }

    public boolean td() {
        return getBoolean(c.ft, true);
    }

    public boolean te() {
        return getBoolean(c.zs, false);
    }

    public boolean ub() {
        return jb() < 0 || getBoolean(c.ls, false);
    }

    public boolean uc() {
        return getBoolean(c.or, true);
    }

    public boolean ud() {
        return !vd() && getBoolean(c.Fr, false);
    }

    public boolean ue() {
        return getBoolean(c.zt, false);
    }

    public boolean vb() {
        return getBoolean(c.tt, false);
    }

    public boolean vc() {
        return getBoolean(c.fo, false);
    }

    public boolean vd() {
        return getBoolean(c.Er, false);
    }

    public boolean ve() {
        return getBoolean(c.Ct, false);
    }

    public boolean wb() {
        return getBoolean(c.vu, false);
    }

    public boolean wc() {
        return getBoolean(c.ss, false);
    }

    public boolean wd() {
        return getBoolean(c.Hr, false);
    }

    public boolean we() {
        return getBoolean(c.At, false);
    }

    public boolean xb() {
        return getInt(c.xu, 0) == 1;
    }

    public boolean xc() {
        return getBoolean(c.Tr, false);
    }

    public boolean xd() {
        return getBoolean(c.Kt, false);
    }

    public boolean xe() {
        return getBoolean(c.ir, false);
    }

    public boolean yb() {
        return getInt(c.xu, 0) == 0;
    }

    public boolean yc() {
        return getBoolean(c.vs, true);
    }

    public boolean yd() {
        return getBoolean(c.gt, true);
    }

    public boolean ye() {
        return getBoolean(c.Ot, false);
    }

    public boolean zb() {
        return getBoolean(c.Qt, false);
    }

    public boolean zc() {
        return getBoolean(c.tu, false);
    }

    public boolean zd() {
        return !vd() && !ud() && getBoolean(c.Jt, false);
    }

    public boolean ze() {
        int jb = jb();
        if (jb == 1 || jb == 2 || jb == 3) {
            return Nd();
        }
        return false;
    }
}
