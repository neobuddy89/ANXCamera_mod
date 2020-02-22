.class Lmiui/util/TypefaceUtils$FontsWhiteListHolder;
.super Ljava/lang/Object;
.source "TypefaceUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/TypefaceUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FontsWhiteListHolder"
.end annotation


# static fields
.field private static final mFontsWhiteList:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.mm"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.mobileqq"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.UCMobile"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qzone"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sina.weibo"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qvod.player"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qihoo360.mobilesafe"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.kugou.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.taobao.taobao"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baidu.BaiduMap"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.youku.phone"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sds.android.ttpod"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qihoo.appstore"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.pplive.androidphone"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.minihd.qq"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "tv.pps.mobile"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xiaomi.channel"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.shuqi.controller"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.storm.smart"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.qbx"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.moji.mjweather"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.wandoujia.phoenix2"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.renren.mobile.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.duokan.reader"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.immomo.momo"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.news"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.qqmusic"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qiyi.video"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baidu.video"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.WBlog"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "qsbk.app"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.netease.newsreader.activity"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sohu.newsclient"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.mtt"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baidu.tieba"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.wochacha"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.qqpimsecure"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xiaomi.shop"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mt.mtxx.mtxx"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qihoo360.mobilesafe.opti.powerctl"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.dragon.android.pandaspace"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.etouch.ecalendar"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.changba"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xiaomi.xmsf"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.qqlive"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.chaozh.iReaderFree"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.snda.wifilocating"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ijinshan.kbatterydoctor"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.duowan.mobile"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.hiapk.marketpho"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qihoo360.launcher"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qihoo360.mobilesafe.opti"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.com.fetion"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.nd.android.pandahome2"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.youdao.dict"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.eg.android.AlipayGphone"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.kuwo.player"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.wps.moffice"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.alibaba.mobileim"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.letv.android.client"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baidu.searchbox"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.funshion.video.mobile"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.gau.go.launcherex"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.opda.a.phonoalbumshoushou"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qq.reader"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.duomi.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qihoo.browser"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.meitu.meiyancamera"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.nd.android.pandareader"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.kingsoft"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.cleanmaster.mguard"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sohu.sohuvideo"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.jingdong.app.mall"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "bubei.tingshu"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.alipay.android.app"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "vStudio.Android.Camera360"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.androidesk"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ss.android.article.news"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "org.funship.findsomething.withRK"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mybook66"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.token"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tmall.wireless"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.qqgame.qqlordwvga"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.budejie.www"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sankuai.meituan"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.google.android.apps.maps"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.kascend.video"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.android.pad"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.muzhiwan.market"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mymoney"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baidu.browser.apps"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.geili.koudai"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baidu.news"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.androidqqmail"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.myzaker.ZAKER_Phone"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ifeng.news2"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.handsgo.jiakao.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.hexin.plat.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.qqphonebook"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "my.beautyCamera"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.autonavi.minimap"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.cubic.autohome"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.clov4r.android.nil"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.yangzhibin.chengrenxiaohua"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.dianxinos.powermanager"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ijinshan.duba"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.wuba"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "sina.mobile.tianqitong"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mandi.lol"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.duowan.lolbox"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.android.chrome"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.chinamworld.main"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ss.android.essay.joke"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "air.com.tencent.qqpasture"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.kingreader.framework"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.ibuka.manga.ui"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ting.mp3.qianqian.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.jiubang.goscreenlock"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.shoujiduoduo.ringtone"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.lbe.security"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.snda.youni"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.jiasoft.swreader"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.anyview"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baidu.appsearch"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sohu.inputmethod.sogou"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mxtech.videoplayer.ad"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.zdworks.android.zdclock"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.antutu.ABenchMark"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "dopool.player"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.uc.browser"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ijinshan.mguard"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "bdmobile.android.app"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.alensw.PicFolder"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xiaomi.topic"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.oupeng.mini.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qihoo360.launcher.screenlock"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.android.vending"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.meilishuo"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.qidian.QDReader"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.research.drop"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.android.bluetooth"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sinovatech.unicom.ui"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.dianping.v1"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.yx"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.dianxinos.dxhome"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.yiche.price"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.iBookStar.activity"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.android.dazhihui"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.wps.moffice_eng"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.taobao.wwseller"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.icbc"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.chinabus.main"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ganji.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ting.mp3.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.hy.minifetion"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mogujie"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baozoumanhua.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.calendar.UI"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.wacai365"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.cnvcs.junqi"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.cntv"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xunlei.kankan"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xikang.android.slimcoach"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.thunder.ktvdaren"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.goapk.market"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.htjyb.reader"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sec.android.app.camera"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.blovestorm"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "me.papa"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.when.android.calendar365"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.android.wallpaper.livepicker"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.vancl.activity"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "jp.naver.line.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.netease.mkey"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.youba.barcode"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.hupu.games"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.kandian.vodapp"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.dewmobile.kuaiya"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.anguanjia.safe"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tudou.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cmb.pb"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.weico.sinaweibo"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.ireadercity.b2"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cn.wps.livespace"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.estrongs.android.pop"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.facebook.katana"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.disney.WMW"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tuan800.tao800"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.byread.reader"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "me.imid.fuubo"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.lingdong.client.android"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mop.activity"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sina.mfweibo"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "cld.navi.mainframe"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mappn.gfan"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.pengyou"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xunlei.downloadprovider"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.tencent.android.qqdownloader"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.whatsapp"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mx.browser"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xiaomi.jr"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xiaomi.smarthome"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.miui.backup.transfer"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.sohu.inputmethod.sogou.xiaomi"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baidu.input_miv6"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.baidu.input_mi"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.souhu.inputmethod.sogou.xiaomi"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.iflytek.inputmethod.miui"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.wali.live"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.miui.hybrid"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.miui.hybrid.loader"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.miui.player"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.android.browser"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.miui.systemAdSolution"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.mi.health"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    const-string v1, "com.xiaomi.vipaccount"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Ljava/util/HashSet;
    .locals 1

    sget-object v0, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->mFontsWhiteList:Ljava/util/HashSet;

    return-object v0
.end method
