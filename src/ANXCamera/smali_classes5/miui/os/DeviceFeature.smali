.class public Lmiui/os/DeviceFeature;
.super Ljava/lang/Object;
.source "DeviceFeature.java"


# static fields
.field public static final BACKLIGHT_BIT:I

.field public static final PERSIST_SCREEN_EFFECT:Z

.field public static final SCREEN_EFFECT_CONFLICT:Z

.field public static final SUPPORT_3D_GESTURE:Z

.field public static final SUPPORT_AUTO_BRIGHTNESS_OPTIMIZE:Z

.field public static final SUPPORT_CAMERA_ANIMATION:Z

.field public static final SUPPORT_DISPLAYFEATURE_CALLBACK:Z

.field public static final SUPPORT_DISPLAYFEATURE_HIDL:Z

.field public static final SUPPORT_GAME_MODE:Z

.field public static final SUPPORT_LAB_GESTURE:Z

.field public static final SUPPORT_NIGHT_LIGHT:Z

.field public static final SUPPORT_NIGHT_LIGHT_ADJ:Z

.field public static final SUPPORT_PAPERMODE_ANIMATION:Z

.field public static final SYSTEM_RESOURCES:Landroid/content/res/Resources;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    sput-object v0, Lmiui/os/DeviceFeature;->SYSTEM_RESOURCES:Landroid/content/res/Resources;

    const/4 v0, 0x0

    const-string/jumbo v1, "support_autobrightness_optimize"

    invoke-static {v1, v0}, Lmiui/util/FeatureParser;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x17

    if-gt v1, v3, :cond_1

    :cond_0
    const-string/jumbo v1, "sys.autobrightness_optimize"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_1
    move v1, v2

    goto :goto_0

    :cond_2
    move v1, v0

    :goto_0
    sput-boolean v1, Lmiui/os/DeviceFeature;->SUPPORT_AUTO_BRIGHTNESS_OPTIMIZE:Z

    nop

    const-string/jumbo v1, "sys.displayfeature_hidl"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    sput-boolean v1, Lmiui/os/DeviceFeature;->SUPPORT_DISPLAYFEATURE_HIDL:Z

    sget-object v1, Lmiui/os/DeviceFeature;->SYSTEM_RESOURCES:Landroid/content/res/Resources;

    const v3, 0x11040018

    # invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getBoolean(I)Z

    # move-result v1

    # sput-boolean v1, Lmiui/os/DeviceFeature;->SUPPORT_DISPLAYFEATURE_CALLBACK:Z

    sget-object v1, Lmiui/os/DeviceFeature;->SYSTEM_RESOURCES:Landroid/content/res/Resources;

    const v3, 0x11040024

    # invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getBoolean(I)Z

    # move-result v1

    # sput-boolean v1, Lmiui/os/DeviceFeature;->SUPPORT_NIGHT_LIGHT:Z

    const-string/jumbo v1, "support_papermode_animation"

    invoke-static {v1, v0}, Lmiui/util/FeatureParser;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    sput-boolean v1, Lmiui/os/DeviceFeature;->SUPPORT_PAPERMODE_ANIMATION:Z

    sget-object v1, Lmiui/os/DeviceFeature;->SYSTEM_RESOURCES:Landroid/content/res/Resources;

    const v3, 0x11040023

    # invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getBoolean(I)Z

    # move-result v1

    # sput-boolean v1, Lmiui/os/DeviceFeature;->SUPPORT_NIGHT_LIGHT_ADJ:Z

    sget-object v1, Lmiui/os/DeviceFeature;->SYSTEM_RESOURCES:Landroid/content/res/Resources;

    const v3, 0x110a0010

    # invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getInteger(I)I

    # move-result v1

    # sput v1, Lmiui/os/DeviceFeature;->BACKLIGHT_BIT:I

    const-string/jumbo v1, "sys.persist_screen_effect"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    sput-boolean v1, Lmiui/os/DeviceFeature;->PERSIST_SCREEN_EFFECT:Z

    const-string/jumbo v1, "ro.df.effect.conflict"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->getInt(Ljava/lang/String;I)I

    move-result v1

    if-eq v1, v2, :cond_4

    const-string/jumbo v1, "ro.vendor.df.effect.conflict"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->getInt(Ljava/lang/String;I)I

    move-result v1

    if-ne v1, v2, :cond_3

    goto :goto_1

    :cond_3
    move v1, v0

    goto :goto_2

    :cond_4
    :goto_1
    move v1, v2

    :goto_2
    sput-boolean v1, Lmiui/os/DeviceFeature;->SCREEN_EFFECT_CONFLICT:Z

    const-string/jumbo v1, "support_touchfeature_gamemode"

    invoke-static {v1, v0}, Lmiui/util/FeatureParser;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    sput-boolean v1, Lmiui/os/DeviceFeature;->SUPPORT_GAME_MODE:Z

    sget-object v1, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string/jumbo v3, "sagit"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    sget-boolean v1, Lmiui/os/Build;->IS_STABLE_VERSION:Z

    if-nez v1, :cond_5

    move v1, v2

    goto :goto_3

    :cond_5
    move v1, v0

    :goto_3
    sput-boolean v1, Lmiui/os/DeviceFeature;->SUPPORT_LAB_GESTURE:Z

    sget-object v1, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string/jumbo v3, "pyxis"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_7

    sget-object v1, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string/jumbo v3, "vela"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    goto :goto_4

    :cond_6
    move v1, v0

    goto :goto_5

    :cond_7
    :goto_4
    move v1, v2

    :goto_5
    sput-boolean v1, Lmiui/os/DeviceFeature;->SUPPORT_CAMERA_ANIMATION:Z

    sget-object v1, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "cepheus"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    sget-boolean v1, Lmiui/os/Build;->IS_INTERNATIONAL_BUILD:Z

    if-nez v1, :cond_8

    move v0, v2

    :cond_8
    sput-boolean v0, Lmiui/os/DeviceFeature;->SUPPORT_3D_GESTURE:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static final hasFlipSupport()Z
    .locals 2

    sget-object v0, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v1, "draco"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static final hasMirihiSupport()Z
    .locals 2

    sget-object v0, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string/jumbo v1, "perseus"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v1, "andromeda"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public static final hasPopupCameraSupport()Z
    .locals 2

    sget-object v0, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string/jumbo v1, "raphael"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v1, "davinci"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string/jumbo v1, "raphaelin"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lmiui/os/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v1, "davinciin"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public static final hasSupportAudioPromity()Z
    .locals 2

    const/4 v0, 0x0

    const-string/jumbo v1, "ro.vendor.audio.us.proximity"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "ro.audio.us.proximity"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :cond_1
    return v0
.end method
