package miui.util;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.TypefaceInjector;
import android.os.Bundle;
import android.provider.MiuiSettings;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ss.android.ttve.common.TEDefine;
import com.xiaomi.stat.c.c;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import miui.os.Build;

public class TypefaceUtils {
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final int DEFAULT_IDX = 4;
    private static final int DEFAULT_SCALE = 50;
    private static final String KEY_FONT_WEIGHT = "key_miui_font_weight_scale";
    private static final String KEY_USE_MIUI_FONT = "use_miui_font";
    private static final String MIPRO_FAMILY = "mipro";
    private static final String MITYPE_FAMILY = "mitype";
    private static final String MITYPE_MONO_FAMILY = "mitype-mono";
    private static final String MIUI_FAMILY = "miui";
    private static final String TAG = "TypefaceUtils";
    /* access modifiers changed from: private */
    public static final boolean USING_VAR_FONT = (sFamilyNameField != null && new File("system/fonts/MiLanProVF.ttf").exists());
    private static final int WEIGHT_BOLD = 700;
    private static final int WEIGHT_DEMIBOLD = 550;
    private static final int WEIGHT_EXTRALIGHT = 200;
    private static final int WEIGHT_HEAVY = 900;
    private static final int WEIGHT_LIGHT = 300;
    private static final int WEIGHT_MEDIUM = 500;
    private static final int WEIGHT_NORMAL = 350;
    private static final int WEIGHT_REGULAR = 400;
    private static final int WEIGHT_SEMIBOLD = 600;
    private static final int WEIGHT_THIN = 100;
    private static final Field sFamilyNameField = getFamilyNameField();
    private static final Map<String, Boolean> sUsingMiuiFontMap = new ArrayMap();

    private static class FontsWhiteListHolder {
        /* access modifiers changed from: private */
        public static final HashSet<String> mFontsWhiteList = new HashSet<>();

        static {
            mFontsWhiteList.add(MiuiSettings.XSpace.WEIXIN_PACKAGE_NAME);
            mFontsWhiteList.add(MiuiSettings.XSpace.QQ_PACKAGE_NAME);
            mFontsWhiteList.add("com.UCMobile");
            mFontsWhiteList.add("com.qzone");
            mFontsWhiteList.add(MiuiSettings.XSpace.WEIBO_PACKAGE_NAME);
            mFontsWhiteList.add("com.qvod.player");
            mFontsWhiteList.add("com.qihoo360.mobilesafe");
            mFontsWhiteList.add("com.kugou.android");
            mFontsWhiteList.add("com.taobao.taobao");
            mFontsWhiteList.add("com.baidu.BaiduMap");
            mFontsWhiteList.add("com.youku.phone");
            mFontsWhiteList.add("com.sds.android.ttpod");
            mFontsWhiteList.add("com.qihoo.appstore");
            mFontsWhiteList.add("com.pplive.androidphone");
            mFontsWhiteList.add("com.tencent.minihd.qq");
            mFontsWhiteList.add("tv.pps.mobile");
            mFontsWhiteList.add("com.xiaomi.channel");
            mFontsWhiteList.add("com.shuqi.controller");
            mFontsWhiteList.add("com.storm.smart");
            mFontsWhiteList.add("com.tencent.qbx");
            mFontsWhiteList.add("com.moji.mjweather");
            mFontsWhiteList.add("com.wandoujia.phoenix2");
            mFontsWhiteList.add("com.renren.mobile.android");
            mFontsWhiteList.add("com.duokan.reader");
            mFontsWhiteList.add("com.immomo.momo");
            mFontsWhiteList.add("com.tencent.news");
            mFontsWhiteList.add("com.tencent.qqmusic");
            mFontsWhiteList.add("com.qiyi.video");
            mFontsWhiteList.add("com.baidu.video");
            mFontsWhiteList.add("com.tencent.WBlog");
            mFontsWhiteList.add("qsbk.app");
            mFontsWhiteList.add("com.netease.newsreader.activity");
            mFontsWhiteList.add("com.sohu.newsclient");
            mFontsWhiteList.add("com.tencent.mtt");
            mFontsWhiteList.add("com.baidu.tieba");
            mFontsWhiteList.add("com.wochacha");
            mFontsWhiteList.add("com.tencent.qqpimsecure");
            mFontsWhiteList.add("com.xiaomi.shop");
            mFontsWhiteList.add("com.mt.mtxx.mtxx");
            mFontsWhiteList.add("com.qihoo360.mobilesafe.opti.powerctl");
            mFontsWhiteList.add("com.dragon.android.pandaspace");
            mFontsWhiteList.add("cn.etouch.ecalendar");
            mFontsWhiteList.add("com.changba");
            mFontsWhiteList.add(c.f423a);
            mFontsWhiteList.add("com.tencent.qqlive");
            mFontsWhiteList.add("com.chaozh.iReaderFree");
            mFontsWhiteList.add("com.snda.wifilocating");
            mFontsWhiteList.add("com.ijinshan.kbatterydoctor");
            mFontsWhiteList.add("com.duowan.mobile");
            mFontsWhiteList.add("com.hiapk.marketpho");
            mFontsWhiteList.add("com.qihoo360.launcher");
            mFontsWhiteList.add("com.qihoo360.mobilesafe.opti");
            mFontsWhiteList.add("cn.com.fetion");
            mFontsWhiteList.add("com.nd.android.pandahome2");
            mFontsWhiteList.add("com.youdao.dict");
            mFontsWhiteList.add("com.eg.android.AlipayGphone");
            mFontsWhiteList.add("cn.kuwo.player");
            mFontsWhiteList.add("cn.wps.moffice");
            mFontsWhiteList.add("com.alibaba.mobileim");
            mFontsWhiteList.add("com.letv.android.client");
            mFontsWhiteList.add("com.baidu.searchbox");
            mFontsWhiteList.add("com.funshion.video.mobile");
            mFontsWhiteList.add("com.gau.go.launcherex");
            mFontsWhiteList.add("cn.opda.a.phonoalbumshoushou");
            mFontsWhiteList.add("com.qq.reader");
            mFontsWhiteList.add("com.duomi.android");
            mFontsWhiteList.add("com.qihoo.browser");
            mFontsWhiteList.add("com.meitu.meiyancamera");
            mFontsWhiteList.add("com.nd.android.pandareader");
            mFontsWhiteList.add("com.kingsoft");
            mFontsWhiteList.add("com.cleanmaster.mguard");
            mFontsWhiteList.add("com.sohu.sohuvideo");
            mFontsWhiteList.add("com.jingdong.app.mall");
            mFontsWhiteList.add("bubei.tingshu");
            mFontsWhiteList.add("com.alipay.android.app");
            mFontsWhiteList.add("vStudio.Android.Camera360");
            mFontsWhiteList.add("com.androidesk");
            mFontsWhiteList.add("com.ss.android.article.news");
            mFontsWhiteList.add("org.funship.findsomething.withRK");
            mFontsWhiteList.add("com.mybook66");
            mFontsWhiteList.add("com.tencent.token");
            mFontsWhiteList.add("com.tmall.wireless");
            mFontsWhiteList.add("com.tencent.qqgame.qqlordwvga");
            mFontsWhiteList.add("com.budejie.www");
            mFontsWhiteList.add("com.sankuai.meituan");
            mFontsWhiteList.add("com.google.android.apps.maps");
            mFontsWhiteList.add("com.kascend.video");
            mFontsWhiteList.add("com.tencent.android.pad");
            mFontsWhiteList.add("com.muzhiwan.market");
            mFontsWhiteList.add("com.mymoney");
            mFontsWhiteList.add("com.baidu.browser.apps");
            mFontsWhiteList.add("com.geili.koudai");
            mFontsWhiteList.add("com.baidu.news");
            mFontsWhiteList.add("com.tencent.androidqqmail");
            mFontsWhiteList.add("com.myzaker.ZAKER_Phone");
            mFontsWhiteList.add("com.ifeng.news2");
            mFontsWhiteList.add("com.handsgo.jiakao.android");
            mFontsWhiteList.add("com.hexin.plat.android");
            mFontsWhiteList.add("com.tencent.qqphonebook");
            mFontsWhiteList.add("my.beautyCamera");
            mFontsWhiteList.add("com.autonavi.minimap");
            mFontsWhiteList.add("com.cubic.autohome");
            mFontsWhiteList.add("com.clov4r.android.nil");
            mFontsWhiteList.add("com.yangzhibin.chengrenxiaohua");
            mFontsWhiteList.add("com.dianxinos.powermanager");
            mFontsWhiteList.add("com.ijinshan.duba");
            mFontsWhiteList.add("com.wuba");
            mFontsWhiteList.add("sina.mobile.tianqitong");
            mFontsWhiteList.add("com.mandi.lol");
            mFontsWhiteList.add("com.duowan.lolbox");
            mFontsWhiteList.add("com.android.chrome");
            mFontsWhiteList.add("com.chinamworld.main");
            mFontsWhiteList.add("com.ss.android.essay.joke");
            mFontsWhiteList.add("air.com.tencent.qqpasture");
            mFontsWhiteList.add("com.kingreader.framework");
            mFontsWhiteList.add("cn.ibuka.manga.ui");
            mFontsWhiteList.add("com.ting.mp3.qianqian.android");
            mFontsWhiteList.add("com.jiubang.goscreenlock");
            mFontsWhiteList.add("com.shoujiduoduo.ringtone");
            mFontsWhiteList.add("com.lbe.security");
            mFontsWhiteList.add("com.snda.youni");
            mFontsWhiteList.add("com.jiasoft.swreader");
            mFontsWhiteList.add("com.anyview");
            mFontsWhiteList.add("com.baidu.appsearch");
            mFontsWhiteList.add("com.sohu.inputmethod.sogou");
            mFontsWhiteList.add("com.mxtech.videoplayer.ad");
            mFontsWhiteList.add("com.zdworks.android.zdclock");
            mFontsWhiteList.add("com.antutu.ABenchMark");
            mFontsWhiteList.add("dopool.player");
            mFontsWhiteList.add("com.uc.browser");
            mFontsWhiteList.add("com.ijinshan.mguard");
            mFontsWhiteList.add("bdmobile.android.app");
            mFontsWhiteList.add("com.alensw.PicFolder");
            mFontsWhiteList.add("com.xiaomi.topic");
            mFontsWhiteList.add("com.oupeng.mini.android");
            mFontsWhiteList.add("com.qihoo360.launcher.screenlock");
            mFontsWhiteList.add("com.android.vending");
            mFontsWhiteList.add("com.meilishuo");
            mFontsWhiteList.add("com.qidian.QDReader");
            mFontsWhiteList.add("com.tencent.research.drop");
            mFontsWhiteList.add("com.android.bluetooth");
            mFontsWhiteList.add("com.sinovatech.unicom.ui");
            mFontsWhiteList.add("com.dianping.v1");
            mFontsWhiteList.add("com.yx");
            mFontsWhiteList.add("com.dianxinos.dxhome");
            mFontsWhiteList.add("com.yiche.price");
            mFontsWhiteList.add("com.iBookStar.activity");
            mFontsWhiteList.add("com.android.dazhihui");
            mFontsWhiteList.add("cn.wps.moffice_eng");
            mFontsWhiteList.add("com.taobao.wwseller");
            mFontsWhiteList.add("com.icbc");
            mFontsWhiteList.add("cn.chinabus.main");
            mFontsWhiteList.add("com.ganji.android");
            mFontsWhiteList.add("com.ting.mp3.android");
            mFontsWhiteList.add("com.hy.minifetion");
            mFontsWhiteList.add("com.mogujie");
            mFontsWhiteList.add("com.baozoumanhua.android");
            mFontsWhiteList.add("com.calendar.UI");
            mFontsWhiteList.add("com.wacai365");
            mFontsWhiteList.add("com.cnvcs.junqi");
            mFontsWhiteList.add("cn.cntv");
            mFontsWhiteList.add("com.xunlei.kankan");
            mFontsWhiteList.add("com.xikang.android.slimcoach");
            mFontsWhiteList.add("com.thunder.ktvdaren");
            mFontsWhiteList.add("cn.goapk.market");
            mFontsWhiteList.add("cn.htjyb.reader");
            mFontsWhiteList.add("com.sec.android.app.camera");
            mFontsWhiteList.add("com.blovestorm");
            mFontsWhiteList.add("me.papa");
            mFontsWhiteList.add("com.when.android.calendar365");
            mFontsWhiteList.add("com.android.wallpaper.livepicker");
            mFontsWhiteList.add("com.vancl.activity");
            mFontsWhiteList.add("jp.naver.line.android");
            mFontsWhiteList.add("com.netease.mkey");
            mFontsWhiteList.add("com.youba.barcode");
            mFontsWhiteList.add("com.hupu.games");
            mFontsWhiteList.add("com.kandian.vodapp");
            mFontsWhiteList.add("com.dewmobile.kuaiya");
            mFontsWhiteList.add("com.anguanjia.safe");
            mFontsWhiteList.add("com.tudou.android");
            mFontsWhiteList.add("cmb.pb");
            mFontsWhiteList.add("com.weico.sinaweibo");
            mFontsWhiteList.add("com.ireadercity.b2");
            mFontsWhiteList.add("cn.wps.livespace");
            mFontsWhiteList.add("com.estrongs.android.pop");
            mFontsWhiteList.add(MiuiSettings.XSpace.FACEBOOK_PACKAGE_NAME);
            mFontsWhiteList.add("com.disney.WMW");
            mFontsWhiteList.add("com.tuan800.tao800");
            mFontsWhiteList.add("com.byread.reader");
            mFontsWhiteList.add("me.imid.fuubo");
            mFontsWhiteList.add("com.lingdong.client.android");
            mFontsWhiteList.add("com.mop.activity");
            mFontsWhiteList.add("com.sina.mfweibo");
            mFontsWhiteList.add("cld.navi.mainframe");
            mFontsWhiteList.add("com.mappn.gfan");
            mFontsWhiteList.add("com.tencent.pengyou");
            mFontsWhiteList.add("com.xunlei.downloadprovider");
            mFontsWhiteList.add("com.tencent.android.qqdownloader");
            mFontsWhiteList.add(MiuiSettings.XSpace.WHATSAPP_PACKAGE_NAME);
            mFontsWhiteList.add("com.mx.browser");
            mFontsWhiteList.add("com.xiaomi.jr");
            mFontsWhiteList.add("com.xiaomi.smarthome");
            mFontsWhiteList.add("com.miui.backup.transfer");
            mFontsWhiteList.add("com.sohu.inputmethod.sogou.xiaomi");
            mFontsWhiteList.add("com.baidu.input_miv6");
            mFontsWhiteList.add("com.baidu.input_mi");
            mFontsWhiteList.add("com.souhu.inputmethod.sogou.xiaomi");
            mFontsWhiteList.add("com.iflytek.inputmethod.miui");
            mFontsWhiteList.add("com.wali.live");
            mFontsWhiteList.add("com.miui.hybrid");
            mFontsWhiteList.add("com.miui.hybrid.loader");
            mFontsWhiteList.add("com.miui.player");
            mFontsWhiteList.add("com.android.browser");
            mFontsWhiteList.add("com.miui.systemAdSolution");
            mFontsWhiteList.add("com.mi.health");
            mFontsWhiteList.add("com.xiaomi.vipaccount");
        }

        private FontsWhiteListHolder() {
        }
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final String[] DEFAULT_FONT_NAMES = {TypefaceUtils.DEFAULT_FAMILY, "sans-serif-thin", "sans-serif-light", "sans-serif-medium", "sans-serif-black", "sans-serif-regular", "arial", "helvetica", "tahoma", "verdana"};
        /* access modifiers changed from: private */
        public static final String[] DEFAULT_NAME_MAP;
        private static final SparseArray<FontCacheItem> FONT_CACHE = new SparseArray<>();
        private static final int[][] LARGE_RULES;
        private static final String[] MITYPE_MONO_NAMES;
        /* access modifiers changed from: private */
        public static final Typeface MITYPE_MONO_VAR_FONT;
        private static final String[] MITYPE_NAMES;
        /* access modifiers changed from: private */
        public static final Typeface MITYPE_VAR_FONT;
        private static final int[] MITYPE_WGHT;
        /* access modifiers changed from: private */
        public static final String[] MIUI_NAMES;
        /* access modifiers changed from: private */
        public static final String[] MIUI_NAME_ARRAY;
        /* access modifiers changed from: private */
        public static final Typeface[] MIUI_TYPEFACES;
        /* access modifiers changed from: private */
        public static final Typeface MIUI_VAR_FONT;
        private static final int[] MIUI_WGHT;
        /* access modifiers changed from: private */
        public static final int[][] NORAML_RULES;
        private static final int SIZE_GRADE_COUNT = 3;
        private static final int[][] SMALL_RULES;
        /* access modifiers changed from: private */
        public static final String[] VF_NAME_ARRAY;
        /* access modifiers changed from: private */
        public static final int[] WEIGHT_KEYS;

        private static class FontCacheItem {
            Typeface[] cache = new Typeface[3];
            int scale;

            FontCacheItem() {
                for (int i = 0; i < 3; i++) {
                    this.cache[i] = null;
                }
            }

            /* access modifiers changed from: package-private */
            public void clear() {
                int i = 0;
                while (true) {
                    Typeface[] typefaceArr = this.cache;
                    if (i < typefaceArr.length) {
                        typefaceArr[i] = null;
                        i++;
                    } else {
                        return;
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public Typeface getFont(int i) {
                return this.cache[i];
            }

            /* access modifiers changed from: package-private */
            public void setFont(Typeface typeface, int i) {
                this.cache[i] = typeface;
            }
        }

        static {
            if (TypefaceUtils.USING_VAR_FONT) {
                DEFAULT_NAME_MAP = new String[]{"thin", "thin", "light", "light", FirebaseAnalytics.Param.MEDIUM, FirebaseAnalytics.Param.MEDIUM, TEDefine.TETransition.BLACK, "heavy"};
                VF_NAME_ARRAY = new String[]{"thin", "extralight", "light", "normal", "regular", FirebaseAnalytics.Param.MEDIUM, "demibold", "semibold", "bold", "heavy"};
                MIUI_NAME_ARRAY = new String[]{"thin", "null", "light", "null", "regular", "bold"};
                WEIGHT_KEYS = new int[]{100, 200, 300, TypefaceUtils.WEIGHT_NORMAL, TypefaceUtils.WEIGHT_REGULAR, 500, TypefaceUtils.WEIGHT_DEMIBOLD, TypefaceUtils.WEIGHT_SEMIBOLD, 700, 900};
                MIUI_WGHT = new int[]{150, 200, 250, 305, 340, TypefaceUtils.WEIGHT_REGULAR, 480, 540, 630, 700};
                MITYPE_WGHT = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
                int i = 0;
                while (true) {
                    int[] iArr = MIUI_WGHT;
                    if (i >= iArr.length) {
                        break;
                    }
                    FONT_CACHE.put(iArr[i], new FontCacheItem());
                    i++;
                }
                int i2 = 0;
                while (true) {
                    int[] iArr2 = MITYPE_WGHT;
                    if (i2 < iArr2.length) {
                        FONT_CACHE.put(iArr2[i2], new FontCacheItem());
                        i2++;
                    } else {
                        MIUI_NAMES = new String[]{TypefaceUtils.MIUI_FAMILY, TypefaceUtils.MIPRO_FAMILY};
                        MITYPE_NAMES = new String[]{TypefaceUtils.MITYPE_FAMILY};
                        MITYPE_MONO_NAMES = new String[]{TypefaceUtils.MITYPE_MONO_FAMILY};
                        SMALL_RULES = new int[][]{new int[]{100, 500}, new int[]{200, 500}, new int[]{300, 500}, new int[]{TypefaceUtils.WEIGHT_NORMAL, TypefaceUtils.WEIGHT_DEMIBOLD}, new int[]{TypefaceUtils.WEIGHT_NORMAL, TypefaceUtils.WEIGHT_DEMIBOLD}, new int[]{TypefaceUtils.WEIGHT_REGULAR, TypefaceUtils.WEIGHT_SEMIBOLD}, new int[]{500, 700}, new int[]{TypefaceUtils.WEIGHT_DEMIBOLD, 700}, new int[]{TypefaceUtils.WEIGHT_SEMIBOLD, 700}, new int[]{700, 900}};
                        NORAML_RULES = new int[][]{new int[]{100, 500}, new int[]{100, 500}, new int[]{200, TypefaceUtils.WEIGHT_DEMIBOLD}, new int[]{300, TypefaceUtils.WEIGHT_DEMIBOLD}, new int[]{300, TypefaceUtils.WEIGHT_SEMIBOLD}, new int[]{TypefaceUtils.WEIGHT_NORMAL, 700}, new int[]{TypefaceUtils.WEIGHT_REGULAR, 700}, new int[]{500, 900}, new int[]{TypefaceUtils.WEIGHT_DEMIBOLD, 900}, new int[]{TypefaceUtils.WEIGHT_SEMIBOLD, 900}};
                        LARGE_RULES = new int[][]{new int[]{100, 300}, new int[]{100, TypefaceUtils.WEIGHT_NORMAL}, new int[]{200, TypefaceUtils.WEIGHT_REGULAR}, new int[]{200, 500}, new int[]{300, TypefaceUtils.WEIGHT_DEMIBOLD}, new int[]{300, TypefaceUtils.WEIGHT_SEMIBOLD}, new int[]{TypefaceUtils.WEIGHT_NORMAL, 700}, new int[]{TypefaceUtils.WEIGHT_REGULAR, 900}, new int[]{500, 900}, new int[]{TypefaceUtils.WEIGHT_DEMIBOLD, 900}};
                        MIUI_TYPEFACES = new Typeface[0];
                        MIUI_VAR_FONT = Typeface.create(TypefaceUtils.MIPRO_FAMILY, 0);
                        MITYPE_VAR_FONT = Typeface.create(TypefaceUtils.MITYPE_FAMILY, 0);
                        MITYPE_MONO_VAR_FONT = Typeface.create(TypefaceUtils.MITYPE_MONO_FAMILY, 0);
                        return;
                    }
                }
            } else {
                int[] iArr3 = new int[0];
                MITYPE_WGHT = iArr3;
                MIUI_WGHT = iArr3;
                WEIGHT_KEYS = iArr3;
                String[] strArr = new String[0];
                MITYPE_MONO_NAMES = strArr;
                MITYPE_NAMES = strArr;
                MIUI_NAMES = strArr;
                MIUI_NAME_ARRAY = strArr;
                VF_NAME_ARRAY = strArr;
                DEFAULT_NAME_MAP = strArr;
                int[][] iArr4 = (int[][]) Array.newInstance(int.class, new int[]{0, 0});
                LARGE_RULES = iArr4;
                NORAML_RULES = iArr4;
                SMALL_RULES = iArr4;
                MITYPE_MONO_VAR_FONT = null;
                MITYPE_VAR_FONT = null;
                MIUI_VAR_FONT = null;
                if (new File("system/fonts/Miui-Regular.ttf").exists()) {
                    MIUI_TYPEFACES = new Typeface[4];
                    MIUI_TYPEFACES[0] = Typeface.create(TypefaceUtils.MIUI_FAMILY, 0);
                    MIUI_TYPEFACES[1] = Typeface.create(TypefaceUtils.MIUI_FAMILY, 1);
                    MIUI_TYPEFACES[2] = Typeface.create(TypefaceUtils.MIUI_FAMILY, 2);
                    MIUI_TYPEFACES[3] = Typeface.create(TypefaceUtils.MIUI_FAMILY, 3);
                    return;
                }
                MIUI_TYPEFACES = new Typeface[0];
            }
        }

        private Holder() {
        }

        static void cacheFont(Typeface typeface, int i, int i2, int i3) {
            FontCacheItem fontCacheItem = FONT_CACHE.get(i);
            if (fontCacheItem.scale != i2) {
                fontCacheItem.scale = i2;
                fontCacheItem.clear();
            }
            fontCacheItem.setFont(typeface, i3);
        }

        static Typeface getCachedFont(int i, int i2, int i3) {
            FontCacheItem fontCacheItem = FONT_CACHE.get(i);
            if (fontCacheItem == null || fontCacheItem.scale != i2) {
                return null;
            }
            return fontCacheItem.getFont(i3);
        }

        static int[][] getRules(int i) {
            return i != 0 ? i != 1 ? SMALL_RULES : LARGE_RULES : NORAML_RULES;
        }

        static int getTextSizeGrade(float f2) {
            if (f2 > 20.0f) {
                return 1;
            }
            return (f2 <= 0.0f || f2 >= 12.0f) ? 0 : 2;
        }

        static int getWeightIndex(int i) {
            int i2 = 0;
            while (true) {
                int[] iArr = WEIGHT_KEYS;
                if (i2 >= iArr.length) {
                    return -1;
                }
                if (iArr[i2] == i) {
                    return i2;
                }
                i2++;
            }
        }

        static int getWght(int i, boolean z) {
            int[] iArr = z ? MITYPE_WGHT : MIUI_WGHT;
            int weightIndex = getWeightIndex(i);
            return weightIndex >= 0 ? iArr[weightIndex] : getWght(TypefaceUtils.WEIGHT_REGULAR, z);
        }
    }

    private static String[] convertFontNames(String[] strArr) {
        for (int i = 0; i < Holder.DEFAULT_NAME_MAP.length; i += 2) {
            for (String contains : strArr) {
                if (contains.contains(Holder.DEFAULT_NAME_MAP[i])) {
                    return new String[]{"mipro-" + Holder.DEFAULT_NAME_MAP[i + 1]};
                }
            }
        }
        return new String[]{MIPRO_FAMILY};
    }

    private static Typeface convertMiuiFontToSysFont(Typeface typeface, String[] strArr) {
        String str = DEFAULT_FAMILY;
        for (int i = 1; i < Holder.DEFAULT_NAME_MAP.length; i += 2) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2].contains(Holder.DEFAULT_NAME_MAP[i])) {
                    str = "sans-serif-" + Holder.DEFAULT_NAME_MAP[i - 1];
                    break;
                } else {
                    i2++;
                }
            }
        }
        return Typeface.create(str, typeface.getStyle());
    }

    private static Field getFamilyNameField() {
        try {
            return Typeface.class.getField("familyName");
        } catch (Exception e2) {
            Log.i(TAG, "Typeface has no familyName field");
            return null;
        }
    }

    private static String[] getFontNames(Typeface typeface) {
        String[] strArr = new String[0];
        Field field = sFamilyNameField;
        if (field == null) {
            return strArr;
        }
        try {
            return (String[]) field.get(typeface);
        } catch (Exception e2) {
            Log.w(TAG, "get familyName failed", e2);
            return strArr;
        }
    }

    private static int getNameIndex(String[] strArr, String[] strArr2) {
        for (int i = 0; i < strArr.length; i++) {
            for (int i2 = 0; i2 < strArr2.length; i2++) {
                if (strArr[i].contains(strArr2[i2])) {
                    return i2;
                }
            }
        }
        return 4;
    }

    private static int getProperWeight(Typeface typeface, String[] strArr) {
        if (typeface == null) {
            return WEIGHT_REGULAR;
        }
        int nameIndex = getNameIndex(strArr, isNamesOf(strArr, MIUI_FAMILY) ? Holder.MIUI_NAME_ARRAY : Holder.VF_NAME_ARRAY);
        return (!typeface.isBold() || nameIndex >= Holder.WEIGHT_KEYS.length + -1) ? Holder.WEIGHT_KEYS[nameIndex] : Holder.WEIGHT_KEYS[nameIndex + 1];
    }

    private static int getScaleWght(int i, int i2, int i3, boolean z) {
        int[][] rules = Holder.getRules(i3);
        int weightIndex = Holder.getWeightIndex(i);
        if (weightIndex >= 0) {
            return getWghtInRange(i, rules[weightIndex], i2, z);
        }
        return getWghtInRange(WEIGHT_REGULAR, Holder.NORAML_RULES[Holder.getWeightIndex(WEIGHT_REGULAR)], i2, z);
    }

    private static Typeface getVarFont(Context context, Typeface typeface, float f2, boolean z, Typeface typeface2, String[] strArr) {
        int properWeight = getProperWeight(typeface, strArr);
        int wght = Holder.getWght(properWeight, z);
        int i = 50;
        if (context != null) {
            i = Settings.System.getInt(context.getContentResolver(), KEY_FONT_WEIGHT, 50);
        }
        int textSizeGrade = Holder.getTextSizeGrade(f2);
        Typeface cachedFont = Holder.getCachedFont(wght, i, textSizeGrade);
        if (cachedFont != null) {
            return cachedFont;
        }
        Typeface createVarFont = TypefaceHelper.createVarFont(typeface2, getScaleWght(properWeight, i, textSizeGrade, z));
        setFontNames(createVarFont, strArr);
        Holder.cacheFont(createVarFont, wght, i, textSizeGrade);
        return createVarFont;
    }

    private static int getWghtInRange(int i, int[] iArr, int i2, boolean z) {
        int wght = Holder.getWght(iArr[0], z);
        int wght2 = Holder.getWght(i, z);
        int wght3 = Holder.getWght(iArr[1], z);
        int i3 = wght2;
        if (i2 < 50) {
            float f2 = ((float) i2) / 50.0f;
            return (int) (((1.0f - f2) * ((float) wght)) + (((float) wght2) * f2));
        } else if (i2 <= 50) {
            return i3;
        } else {
            float f3 = ((float) (i2 - 50)) / 50.0f;
            return (int) (((1.0f - f3) * ((float) wght2)) + (((float) wght3) * f3));
        }
    }

    private static boolean isDefaultFont(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (int i = 0; i < Holder.DEFAULT_FONT_NAMES.length; i++) {
            for (String contains : strArr) {
                if (contains.contains(Holder.DEFAULT_FONT_NAMES[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isFontChanged(Configuration configuration) {
        return (configuration.extraConfig.themeChangedFlags & 536870912) != 0;
    }

    private static boolean isNamesOf(String[] strArr, String... strArr2) {
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        for (int i = 0; i < strArr2.length; i++) {
            String str = strArr2[i] + '-';
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2].equals(strArr2[i]) || strArr[i2].contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isUsingMiFont(Typeface typeface) {
        return isNamesOf(typeface != null ? getFontNames(typeface) : new String[0], MIUI_FAMILY, MIPRO_FAMILY, MITYPE_FAMILY, MITYPE_MONO_FAMILY);
    }

    private static boolean isUsingMiuiFont(Context context) {
        String packageName = context.getPackageName();
        Boolean bool = sUsingMiuiFontMap.get(packageName);
        if (bool == null) {
            try {
                Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
                bool = Boolean.valueOf(bundle != null ? bundle.getBoolean(KEY_USE_MIUI_FONT, false) : false);
                sUsingMiuiFontMap.put(packageName, bool);
            } catch (Exception e2) {
                Log.w(TAG, "get metaData of " + context.getPackageName() + " failed", e2);
                return false;
            }
        }
        return bool.booleanValue();
    }

    public static Typeface replaceTypeface(Context context, Typeface typeface) {
        return replaceTypeface(context, typeface, -1.0f);
    }

    public static Typeface replaceTypeface(Context context, Typeface typeface, float f2) {
        String[] fontNames = typeface != null ? getFontNames(typeface) : new String[0];
        boolean isNamesOf = isNamesOf(fontNames, MIUI_FAMILY, MIPRO_FAMILY, MITYPE_FAMILY, MITYPE_MONO_FAMILY);
        if (Build.IS_INTERNATIONAL_BUILD || TypefaceInjector.isUsingThemeFont()) {
            return isNamesOf ? convertMiuiFontToSysFont(typeface, fontNames) : typeface;
        }
        Typeface typeface2 = null;
        if (usingMiuiFonts(context) || isNamesOf) {
            typeface2 = USING_VAR_FONT ? replaceWithVarFont(context, typeface, f2) : replaceWithMiuiFont(typeface);
        }
        return typeface2 == null ? typeface : typeface2;
    }

    private static Typeface replaceWithMiuiFont(Typeface typeface) {
        if (typeface != null && !Typeface.DEFAULT.equals(typeface) && !Typeface.DEFAULT_BOLD.equals(typeface) && !Typeface.SANS_SERIF.equals(typeface)) {
            return null;
        }
        return Holder.MIUI_TYPEFACES[typeface == null ? 0 : typeface.getStyle()];
    }

    private static Typeface replaceWithVarFont(Context context, Typeface typeface, float f2) {
        if (typeface != null && typeface.isItalic()) {
            return null;
        }
        float f3 = context == null ? -1.0f : f2 / context.getResources().getDisplayMetrics().scaledDensity;
        String[] fontNames = (typeface == null || typeface == Typeface.DEFAULT || typeface == Typeface.DEFAULT_BOLD) ? new String[]{MIPRO_FAMILY} : getFontNames(typeface);
        boolean isDefaultFont = isDefaultFont(fontNames);
        if (isDefaultFont || isNamesOf(fontNames, Holder.MIUI_NAMES)) {
            if (isDefaultFont) {
                fontNames = convertFontNames(fontNames);
            }
            return getVarFont(context, typeface, f3, false, Holder.MIUI_VAR_FONT, fontNames);
        } else if (isNamesOf(fontNames, MITYPE_MONO_FAMILY)) {
            return getVarFont(context, typeface, f3, true, Holder.MITYPE_MONO_VAR_FONT, fontNames);
        } else if (!isNamesOf(fontNames, MITYPE_FAMILY)) {
            return null;
        } else {
            return getVarFont(context, typeface, f3, true, Holder.MITYPE_VAR_FONT, fontNames);
        }
    }

    private static void setFontNames(Typeface typeface, String[] strArr) {
        try {
            sFamilyNameField.set(typeface, strArr);
        } catch (Exception e2) {
            Log.w(TAG, "set familyName failed", e2);
        }
    }

    public static boolean usingMiuiFonts(Context context) {
        return false;
    }
}
