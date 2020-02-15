package com.mi.config;

import java.util.HashMap;

class FeatureParserWrapper$1 extends HashMap<String, String> {
    FeatureParserWrapper$1() {
        put(d.np, "o_0x00_s_s_l");
        put(d.wo, "o_0x01_r_p_s_f");
        put(d.VENDOR, "o_0x02_soc_vendor");
        put(d.vp, "o_0x03_support_3d_face_beauty");
        put(d.wp, "o_0x04_support_mi_face_beauty");
        put(d.dp, "o_0x05_is_support_optical_zoom");
        put(d.qo, "o_0x06_is_support_peaking_mf");
        put(d.zp, "o_0x08_is_support_dynamic_light_spot");
        put(d.Xn, "o_0x07_support_hfr");
        put(d.Mn, "o_0x08_support_movie_solid");
        put(d.Ao, "o_0x09_support_tilt_shift");
        put(d.so, "o_0x10_support_gradienter");
        put(d.Dp, "o_0x11_picture_water_mark");
        put(d.Bo, "o_0x12_magic_mirror");
        put(d.Pn, "o_0x13_age_detection");
        put(d.Ln, "o_0x14_burst_count");
        put(d.Dn, "o_0x15_support_dual_sd_card");
        put(d.rp, "o_0x16_support_psensor_pocket_mode");
        put(d.Bp, "o_0x17_support_super_resolution");
        put(d.Co, "o_0x18_support_camera_quick_snap");
        put(d.Ep, "o_0x19_camera_role");
        put(d.Rn, "o_0x20_time_water_mark");
        put(d.Jn, "o_0x21_long_press_shutter");
        put(d.Qn, "o_0x22_support_location");
        put(d.jo, "o_0x23_support_manual");
        put(d.uo, "o_0x24_support_qr_code");
    }

    public String put(String str, String str2) {
        if (str2 == null || !str2.startsWith("o_0x")) {
            throw new IllegalStateException("The key \"" + str + "\" must be mapped to non-null string starting with \"o_0x\"");
        }
        String str3 = (String) super.put(str, str2);
        if (str3 == null) {
            return null;
        }
        throw new IllegalStateException("The key \"" + str + "\" has already be mapped to \"" + str3 + "\"");
    }
}
