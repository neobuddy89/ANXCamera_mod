.class public Landroid/graphics/TypefaceInjector;
.super Ljava/lang/Object;
.source "TypefaceInjector.java"


# static fields
.field private static final THEME_FONT_DIR:Ljava/lang/String; = "/data/system/theme/fonts/"

.field private static sIsUsingThemeFont:Ljava/lang/Boolean;


# direct methods
.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isUsingThemeFont()Z
    .locals 4

    sget-object v0, Landroid/graphics/TypefaceInjector;->sIsUsingThemeFont:Ljava/lang/Boolean;

    if-nez v0, :cond_2

    new-instance v0, Ljava/io/File;

    const-string v1, "/data/system/theme/fonts/"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    const/4 v2, 0x0

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    array-length v3, v1

    if-lez v3, :cond_0

    const/4 v2, 0x1

    :cond_0
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    sput-object v2, Landroid/graphics/TypefaceInjector;->sIsUsingThemeFont:Ljava/lang/Boolean;

    goto :goto_0

    :cond_1
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    sput-object v1, Landroid/graphics/TypefaceInjector;->sIsUsingThemeFont:Ljava/lang/Boolean;

    :cond_2
    :goto_0
    sget-object v0, Landroid/graphics/TypefaceInjector;->sIsUsingThemeFont:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method
