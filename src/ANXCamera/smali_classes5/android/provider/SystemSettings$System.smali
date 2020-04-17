.class public Landroid/provider/SystemSettings$System;
.super Ljava/lang/Object;
.source "SystemSettings.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/SystemSettings;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "System"
.end annotation


# static fields
.field private static final E10_DEVICE:Ljava/lang/String; = "beryllium"

.field private static final INDIA:Ljava/lang/String; = "INDIA"

.field public static final LOCK_WALLPAPER_PROVIDER_AUTHORITY:Ljava/lang/String; = "lock_wallpaper_provider_authority"

.field public static final PERSIST_SYS_DEVICE_NAME:Ljava/lang/String; = "persist.sys.device_name"

.field public static final STATUS_BAR_WINDOW_LOADED:Ljava/lang/String; = "status_bar_window_loaded"


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getBoolean(Landroid/content/ContentResolver;Ljava/lang/String;Z)Z
    .locals 1

    invoke-static {p0, p1, p2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public static getDeviceName(Landroid/content/Context;)Ljava/lang/String;
    .locals 4

    const-string v0, ""

    const/4 v1, -0x1

    const/4 v2, 0x0

    const-string v3, "is_redmi"

    invoke-static {v3, v2}, Lmiui/util/FeatureParser;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    if-eqz v3, :cond_0

    sget v1, Lcom/miui/system/internal/R$string;->device_redmi:I

    goto :goto_1

    :cond_0
    const-string v3, "is_poco"

    invoke-static {v3, v2}, Lmiui/util/FeatureParser;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    if-eqz v3, :cond_1

    sget v1, Lcom/miui/system/internal/R$string;->device_poco:I

    goto :goto_1

    :cond_1
    const-string v3, "is_hongmi"

    invoke-static {v3, v2}, Lmiui/util/FeatureParser;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    if-eqz v3, :cond_2

    sget v1, Lcom/miui/system/internal/R$string;->device_hongmi:I

    goto :goto_1

    :cond_2
    const-string v3, "is_xiaomi"

    invoke-static {v3, v2}, Lmiui/util/FeatureParser;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    if-eqz v3, :cond_5

    const-string v2, "ro.product.vendor.device"

    invoke-static {v2}, Lmiui/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "beryllium"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    const-string v2, "ro.boot.hwc"

    const-string v3, ""

    invoke-static {v2, v3}, Lmiui/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "INDIA"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_3

    sget v1, Lcom/miui/system/internal/R$string;->device_poco_india:I

    goto :goto_0

    :cond_3
    sget v1, Lcom/miui/system/internal/R$string;->device_poco_global:I

    :goto_0
    goto :goto_1

    :cond_4
    sget v1, Lcom/miui/system/internal/R$string;->device_xiaomi:I

    goto :goto_1

    :cond_5
    const-string v3, "is_pad"

    invoke-static {v3, v2}, Lmiui/util/FeatureParser;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_6

    sget v1, Lcom/miui/system/internal/R$string;->device_pad:I

    goto :goto_1

    :cond_6
    sget v1, Lcom/miui/system/internal/R$string;->miui_device_name:I

    :goto_1
    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v2, "persist.sys.device_name"

    invoke-static {v2, v0}, Lmiui/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static setDeviceName(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1

    const-string v0, "persist.sys.device_name"

    invoke-static {v0, p1}, Lmiui/os/SystemProperties;->set(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p0}, Landroid/provider/SystemSettings$System;->setNetHostName(Landroid/content/Context;)V

    return-void
.end method

.method public static setNetHostName(Landroid/content/Context;)V
    .locals 8

    const-string v0, "net.hostname"

    const-string v1, "net.hostname"

    invoke-static {v1}, Lmiui/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Laeonax/Build;->ANXMODEL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "-"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {}, Lmiui/text/ChinesePinyinConverter;->getInstance()Lmiui/text/ChinesePinyinConverter;

    move-result-object v4

    invoke-static {p0}, Landroid/provider/SystemSettings$System;->getDeviceName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lmiui/text/ChinesePinyinConverter;->get(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lmiui/text/ChinesePinyinConverter$Token;

    iget-object v7, v6, Lmiui/text/ChinesePinyinConverter$Token;->target:Ljava/lang/String;

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_0
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const-string v6, " "

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    const/16 v6, 0x14

    invoke-static {v5, v6}, Lmiui/util/Utf8TextUtils;->truncateByte(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_1

    invoke-static {v1, v6}, Lmiui/os/SystemProperties;->set(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    return-void
.end method
