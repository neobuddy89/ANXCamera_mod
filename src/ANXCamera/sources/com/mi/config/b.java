package com.mi.config;

import android.os.SystemProperties;
import android.text.TextUtils;
import com.android.camera.AutoLockManager;
import com.android.camera.Util;
import com.android.camera.data.DataRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import miui.os.Build;

/* compiled from: Device */
public class b {
    private static final int Am = 100;
    private static final String An = "ro.boot.hwversion";
    public static final String Bm = Build.MODEL;
    private static final AtomicReference<Optional<Boolean>> Bn = new AtomicReference<>(Optional.empty());
    public static final boolean Cm = Build.IS_MITWO;
    public static final boolean Dm = ("cancro".equals(xm) && Build.MODEL.startsWith("MI 3"));
    public static final boolean Em = Dm;
    public static final boolean Fm = (Build.IS_HONGMI_TWO && !Build.IS_HONGMI_TWO_A && !Build.IS_HONGMI_TWO_S);
    public static final boolean Gm = Build.IS_HONGMI_TWO_S;
    public static final boolean Hm = Build.IS_HONGMI_TWOS_LTE_MTK;
    public static final boolean IS_HONGMI = d.getBoolean(d.IS_HONGMI, false);
    public static final boolean IS_MI2A = Build.IS_MI2A;
    public static final boolean IS_XIAOMI = d.getBoolean(d.IS_XIAOMI, false);
    public static final boolean Im = Build.IS_HONGMI_TWO_A;
    public static final boolean Jm = Build.IS_HONGMI_THREE;
    public static final boolean Km = Build.IS_HONGMI_TWOX_LC;
    public static final boolean Lm = Build.IS_MIFOUR;
    public static final boolean Mm = Build.IS_MIFIVE;
    public static final boolean Nm = "leo".equals(xm);
    public static final boolean Om = "lithium".equals(xm);
    public static final boolean Pm = "chiron".equals(xm);
    public static final boolean Qm = "beryllium".equals(xm);
    public static final boolean Rm = "violet".equals(xm);
    public static final boolean Sm = "polaris".equals(xm);
    public static final boolean Tm = "sirius".equals(xm);
    public static final boolean Um = "dipper".equals(xm);
    public static final boolean Vm = "andromeda".equals(xm);
    public static final boolean Wm = "perseus".equals(xm);
    public static final boolean Xm = "cepheus".equals(xm);
    public static final boolean Ym = "grus".equals(xm);
    public static final boolean Zm = "begonia".equals(xm);
    public static final boolean _m = "phoenix".equals(xm);
    public static final boolean bn = "begoniain".equals(xm);
    public static final boolean cn = "ginkgo".equals(xm);
    public static final boolean en = "pyxis".equals(xm);
    public static final boolean fn = "vela".equals(xm);
    public static final boolean gn = "laurus".equals(xm);
    public static final boolean hn = "laurel_sprout".equals(xm);
    public static final boolean jn = "tucana".equals(xm);
    public static final boolean kn = ("tucana".equals(xm) && SystemProperties.get("persist.camera.rearMain.vendorID", "03").equals("03"));
    public static final boolean ln = "umi".equals(xm);
    public static final boolean mn = "cmi".equals(xm);
    public static final boolean nn = "lmipro".equals(xm);
    public static final boolean pn = "draco".equals(xm);
    public static final boolean qn;
    public static final boolean rn = "crux".equals(xm);
    public static final boolean sn = Build.IS_STABLE_VERSION;
    public static final boolean tn = Build.IS_CM_CUSTOMIZATION_TEST;
    public static final boolean un = Build.IS_CM_CUSTOMIZATION;
    private static final int vn = 1;
    private static final int wn = 4;
    public static final String xm = aeonax.Build.ANXDEVICE;
    private static final int xn = 8;
    public static final String ym = "qcom";
    private static ArrayList<String> yn = null;
    public static final String zm = "mediatek";
    private static final String[] zn = {"KR", "JP"};

    static {
        boolean z = true;
        if (!"picasso".equals(xm) && !"picassoin".equals(xm)) {
            z = false;
        }
        qn = z;
    }

    public static boolean A(boolean z) {
        String str = SystemProperties.get("ro.miui.customized.region");
        if ("fr_sfr".equals(str) || "fr_orange".equals(str)) {
            return false;
        }
        return z;
    }

    public static boolean Ak() {
        return d.getBoolean(d.sp, false);
    }

    public static boolean Bk() {
        return d.getBoolean(d.Jo, false);
    }

    public static boolean Ck() {
        return d.getBoolean(d.so, false);
    }

    public static boolean Dk() {
        return false;
    }

    public static boolean Ek() {
        return d.getBoolean(d.wp, false);
    }

    public static boolean Fk() {
        return xk() || Ek();
    }

    public static boolean Gk() {
        return d.getBoolean(d.rp, true);
    }

    public static boolean Hk() {
        return !DataRepository.dataItemFeature().uc() && IS_HONGMI;
    }

    public static boolean Ik() {
        return d.getBoolean(d.np, false);
    }

    private static boolean J(String str) {
        for (String equals : zn) {
            if (TextUtils.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Jk() {
        return (d.getInteger(d.fo, 0) & 13) != 0;
    }

    public static boolean Kk() {
        return !Build.IS_INTERNATIONAL_BUILD && d.getBoolean(d.Pn, false);
    }

    public static boolean Lk() {
        return d.getBoolean(d.Wn, false);
    }

    public static boolean Mc() {
        return DataRepository.dataItemFeature().Mc();
    }

    public static boolean Mk() {
        return (d.getInteger(d.fo, 0) & 1) != 0;
    }

    public static boolean Nk() {
        return (d.getInteger(d.fo, 0) & 4) != 0;
    }

    private static boolean Nm() {
        return SystemProperties.getBoolean("ro.hardware.fp.fod", false);
    }

    public static boolean Oj() {
        return !tn && d.getBoolean(d.Un, false);
    }

    public static boolean Ok() {
        return false;
    }

    private static boolean Om() {
        return d.getBoolean(d.Po, false) || Nm();
    }

    public static boolean Pj() {
        return d.getBoolean(d.yp, false);
    }

    public static boolean Pk() {
        return d.getBoolean(d.Yn, false);
    }

    static String Qj() {
        int i = SystemProperties.getInt("ro.boot.camera.config", 1);
        if (i == 0) {
            return "_pro";
        }
        if (i != 1) {
        }
        return "";
    }

    public static boolean Qk() {
        return d.getBoolean(d.En, false);
    }

    public static ArrayList<String> Rj() {
        if (yn == null) {
            yn = new ArrayList<>();
            String[] stringArray = d.getStringArray(d.Hn);
            if (stringArray != null) {
                Collections.addAll(yn, stringArray);
            }
        }
        return yn;
    }

    public static boolean Rk() {
        return d.getBoolean(d.Go, false);
    }

    public static String Sj() {
        return ak() ? "_l" : mk() ? "_in" : !DataRepository.dataItemFeature().getBoolean(c.us, false) ? "" : (android.os.Build.MODEL.contains("BROWN EDITION") || android.os.Build.MODEL.contains("Explorer")) ? "_a" : android.os.Build.MODEL.contains("ROY") ? "_b" : bk() ? "_s" : (hk() || gk()) ? "_global" : rk() ? "_premium" : jk() ? sk() ? "_global_pro" : "_global" : "";
    }

    public static boolean Sk() {
        return false;
    }

    public static int Tj() {
        return d.getInteger(d.HIBERNATION_TIMEOUT, AutoLockManager.HIBERNATION_TIMEOUT);
    }

    public static boolean Tk() {
        return d.getBoolean(d.Qn, false);
    }

    public static boolean Uj() {
        return d.getBoolean(d.Fp, false);
    }

    public static boolean Uk() {
        return d.getBoolean(d.Jn, false);
    }

    public static boolean Vj() {
        return ((float) Util.sWindowHeight) / ((float) Util.sWindowWidth) >= 2.0f && d.getBoolean(d.So, false);
    }

    public static boolean Vk() {
        return !Build.IS_INTERNATIONAL_BUILD && d.getBoolean(d.Bo, false);
    }

    public static boolean Wj() {
        return !Om() && DataRepository.dataItemFeature().Ec() && Rj() != null && !Rj().isEmpty();
    }

    public static boolean Wk() {
        return d.getBoolean(d.jo, false);
    }

    public static boolean Xj() {
        return DataRepository.dataItemFeature().Ud() || _m;
    }

    public static boolean Xk() {
        if (ak()) {
            return false;
        }
        return d.getBoolean(d.Mn, false);
    }

    public static boolean Yj() {
        if (!Build.IS_INTERNATIONAL_BUILD) {
            return false;
        }
        String str = Util.sRegion;
        return TextUtils.isEmpty(str) ? J(Locale.getDefault().getCountry()) : J(str);
    }

    public static boolean Yk() {
        return !Yj();
    }

    public static boolean Zj() {
        return d.getBoolean(d.zo, false);
    }

    public static boolean Zk() {
        return d.getBoolean(d.Sn, false);
    }

    public static boolean _j() {
        String str = SystemProperties.get(An);
        return rn && (TextUtils.equals(str, "7.1.7") || TextUtils.equals(str, "7.2.0"));
    }

    public static boolean _k() {
        return d.getBoolean(d.Zn, false);
    }

    public static boolean ak() {
        if (!"onc".equals(xm)) {
            return false;
        }
        String str = SystemProperties.get(An);
        return !TextUtils.isEmpty(str) && '2' == str.charAt(0);
    }

    public static boolean al() {
        return d.getBoolean(d.qo, false);
    }

    public static boolean bk() {
        return xm.equalsIgnoreCase("lavender") && "India_48_5".equalsIgnoreCase(SystemProperties.get("ro.boot.hwc"));
    }

    public static boolean bl() {
        return !Build.IS_INTERNATIONAL_BUILD && d.getBoolean(d.Co, false);
    }

    public static boolean ck() {
        return Om || Pm || Sm;
    }

    public static boolean cl() {
        return d.getBoolean(d.Dn, false);
    }

    public static boolean dk() {
        return fk() || en || Ym || DataRepository.dataItemFeature().Ud();
    }

    public static boolean dl() {
        return d.getBoolean(d.In, false);
    }

    public static boolean ek() {
        return !Im && !Km && !Build.IS_HONGMI_TWOX && !Dm && !Jm && !Fm && !Gm && !Hm && !Cm && !IS_MI2A && !Em && d.getBoolean(d.Vo, true);
    }

    public static boolean el() {
        return d.getBoolean(d.Nn, false);
    }

    public static boolean fk() {
        return Wm && Build.IS_INTERNATIONAL_BUILD;
    }

    public static boolean fl() {
        return d.getBoolean(d.cp, false);
    }

    public static int getBurstShootCount() {
        return d.getInteger(d.Ln, 100);
    }

    public static boolean gk() {
        return xm.equalsIgnoreCase("davinci") && Build.IS_INTERNATIONAL_BUILD;
    }

    public static boolean gl() {
        return d.getBoolean(d.Ao, false);
    }

    public static boolean hk() {
        return xm.equalsIgnoreCase("raphael") && Build.IS_INTERNATIONAL_BUILD;
    }

    public static boolean hl() {
        return d.getBoolean(d.Rn, false);
    }

    public static boolean ie() {
        return DataRepository.dataItemFeature().ie();
    }

    public static boolean ik() {
        return en && Build.IS_INTERNATIONAL_BUILD;
    }

    public static boolean il() {
        return d.getBoolean(d.lo, false);
    }

    public static boolean isMTKPlatform() {
        if (!Bn.get().isPresent()) {
            synchronized (Bn) {
                if (!Bn.get().isPresent()) {
                    Bn.set(Optional.of(Boolean.valueOf(zm.equals(d.getString(d.VENDOR)))));
                }
            }
        }
        return ((Boolean) Bn.get().get()).booleanValue();
    }

    public static boolean isPad() {
        return d.getBoolean(d.Cn, false);
    }

    public static boolean isSupportSuperResolution() {
        return d.getBoolean(d.Bp, false);
    }

    public static boolean isSupportedOpticalZoom() {
        return d.getBoolean(d.dp, false);
    }

    public static boolean jk() {
        return jn && Build.IS_INTERNATIONAL_BUILD;
    }

    public static boolean jl() {
        return d.getBoolean(d.Tn, false);
    }

    public static boolean kk() {
        return d.getBoolean(d.Zo, false);
    }

    public static boolean kl() {
        return d.getBoolean(d._n, false);
    }

    public static boolean lk() {
        return d.getBoolean(d.po, false);
    }

    public static boolean ll() {
        return d.getBoolean(d.Yo, false);
    }

    public static boolean mk() {
        return Qm && "India".equalsIgnoreCase(SystemProperties.get("ro.boot.hwc"));
    }

    public static boolean ml() {
        return !IS_XIAOMI && !IS_HONGMI;
    }

    public static boolean nk() {
        return d.getBoolean(d.Lo, true);
    }

    public static boolean nl() {
        return !Im && !Km && !Build.IS_HONGMI_TWOX && !Dm && !Jm && !Fm && !Gm && !Hm && !Cm && !IS_MI2A && !Em && !Lm && d.getBoolean(d.Xo, true);
    }

    public static boolean ol() {
        return d.getBoolean(d.Dp, false);
    }

    public static boolean pk() {
        return d.getBoolean(d.uo, false);
    }

    public static boolean pl() {
        return d.getBoolean(d.Cp, true);
    }

    public static boolean qk() {
        return false;
    }

    public static boolean rk() {
        return xm.equalsIgnoreCase("raphael") && Build.MODEL.endsWith("Premium Edition");
    }

    public static boolean sk() {
        return jn && !kn;
    }

    public static boolean tk() {
        return ym.equals(d.getString(d.VENDOR));
    }

    public static boolean uk() {
        return d.getBoolean(d.hp, true);
    }

    public static boolean vk() {
        return false;
    }

    public static boolean wk() {
        return d.getBoolean(d.vo, false);
    }

    public static boolean xk() {
        return d.getBoolean(d.vp, false);
    }

    public static boolean yk() {
        return d.getBoolean(d.Ep, false);
    }

    public static boolean zk() {
        return d.getBoolean(d.zp, false);
    }
}
