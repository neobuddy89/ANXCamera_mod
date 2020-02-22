.class public Lmiui/util/TypefaceUtils;
.super Ljava/lang/Object;
.source "TypefaceUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/util/TypefaceUtils$Holder;,
        Lmiui/util/TypefaceUtils$FontsWhiteListHolder;
    }
.end annotation


# static fields
.field private static final DEFAULT_FAMILY:Ljava/lang/String; = "sans-serif"

.field private static final DEFAULT_IDX:I = 0x4

.field private static final DEFAULT_SCALE:I = 0x32

.field private static final KEY_FONT_WEIGHT:Ljava/lang/String; = "key_miui_font_weight_scale"

.field private static final KEY_USE_MIUI_FONT:Ljava/lang/String; = "use_miui_font"

.field private static final MIPRO_FAMILY:Ljava/lang/String; = "mipro"

.field private static final MITYPE_FAMILY:Ljava/lang/String; = "mitype"

.field private static final MITYPE_MONO_FAMILY:Ljava/lang/String; = "mitype-mono"

.field private static final MIUI_FAMILY:Ljava/lang/String; = "miui"

.field private static final TAG:Ljava/lang/String; = "TypefaceUtils"

.field private static final USING_VAR_FONT:Z

.field private static final WEIGHT_BOLD:I = 0x2bc

.field private static final WEIGHT_DEMIBOLD:I = 0x226

.field private static final WEIGHT_EXTRALIGHT:I = 0xc8

.field private static final WEIGHT_HEAVY:I = 0x384

.field private static final WEIGHT_LIGHT:I = 0x12c

.field private static final WEIGHT_MEDIUM:I = 0x1f4

.field private static final WEIGHT_NORMAL:I = 0x15e

.field private static final WEIGHT_REGULAR:I = 0x190

.field private static final WEIGHT_SEMIBOLD:I = 0x258

.field private static final WEIGHT_THIN:I = 0x64

.field private static final sFamilyNameField:Ljava/lang/reflect/Field;

.field private static final sUsingMiuiFontMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    invoke-static {}, Lmiui/util/TypefaceUtils;->getFamilyNameField()Ljava/lang/reflect/Field;

    move-result-object v0

    sput-object v0, Lmiui/util/TypefaceUtils;->sFamilyNameField:Ljava/lang/reflect/Field;

    new-instance v0, Landroid/util/ArrayMap;

    invoke-direct {v0}, Landroid/util/ArrayMap;-><init>()V

    sput-object v0, Lmiui/util/TypefaceUtils;->sUsingMiuiFontMap:Ljava/util/Map;

    sget-object v0, Lmiui/util/TypefaceUtils;->sFamilyNameField:Ljava/lang/reflect/Field;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/io/File;

    const-string v1, "system/fonts/MiLanProVF.ttf"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    sput-boolean v0, Lmiui/util/TypefaceUtils;->USING_VAR_FONT:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$100()Z
    .locals 1

    sget-boolean v0, Lmiui/util/TypefaceUtils;->USING_VAR_FONT:Z

    return v0
.end method

.method private static convertFontNames([Ljava/lang/String;)[Ljava/lang/String;
    .locals 7

    const/4 v0, 0x0

    :goto_0
    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$200()[Ljava/lang/String;

    move-result-object v1

    array-length v1, v1

    if-ge v0, v1, :cond_2

    const/4 v1, 0x0

    :goto_1
    array-length v2, p0

    if-ge v1, v2, :cond_1

    aget-object v2, p0, v1

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$200()[Ljava/lang/String;

    move-result-object v3

    aget-object v3, v3, v0

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "mipro-"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$200()[Ljava/lang/String;

    move-result-object v5

    add-int/lit8 v6, v0, 0x1

    aget-object v5, v5, v6

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    return-object v2

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    :cond_2
    const-string v0, "mipro"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static convertMiuiFontToSysFont(Landroid/graphics/Typeface;[Ljava/lang/String;)Landroid/graphics/Typeface;
    .locals 6

    const-string v0, "sans-serif"

    const/4 v1, 0x1

    :goto_0
    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$200()[Ljava/lang/String;

    move-result-object v2

    array-length v2, v2

    if-ge v1, v2, :cond_2

    const/4 v2, 0x0

    :goto_1
    array-length v3, p1

    if-ge v2, v3, :cond_1

    aget-object v3, p1, v2

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$200()[Ljava/lang/String;

    move-result-object v4

    aget-object v4, v4, v1

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "sans-serif-"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$200()[Ljava/lang/String;

    move-result-object v4

    add-int/lit8 v5, v1, -0x1

    aget-object v4, v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_1
    :goto_2
    add-int/lit8 v1, v1, 0x2

    goto :goto_0

    :cond_2
    invoke-virtual {p0}, Landroid/graphics/Typeface;->getStyle()I

    move-result v1

    invoke-static {v0, v1}, Landroid/graphics/Typeface;->create(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v1

    return-object v1
.end method

.method private static getFamilyNameField()Ljava/lang/reflect/Field;
    .locals 3

    :try_start_0
    const-class v0, Landroid/graphics/Typeface;

    const-string v1, "familyName"

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    const-string v1, "TypefaceUtils"

    const-string v2, "Typeface has no familyName field"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    return-object v1
.end method

.method private static getFontNames(Landroid/graphics/Typeface;)[Ljava/lang/String;
    .locals 4

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    sget-object v1, Lmiui/util/TypefaceUtils;->sFamilyNameField:Ljava/lang/reflect/Field;

    if-eqz v1, :cond_0

    :try_start_0
    invoke-virtual {v1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    goto :goto_0

    :catch_0
    move-exception v1

    const-string v2, "TypefaceUtils"

    const-string v3, "get familyName failed"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_0
    :goto_0
    return-object v0
.end method

.method private static getNameIndex([Ljava/lang/String;[Ljava/lang/String;)I
    .locals 4

    const/4 v0, 0x0

    :goto_0
    array-length v1, p0

    if-ge v0, v1, :cond_2

    const/4 v1, 0x0

    :goto_1
    array-length v2, p1

    if-ge v1, v2, :cond_1

    aget-object v2, p0, v0

    aget-object v3, p1, v1

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    return v1

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_2
    const/4 v0, 0x4

    return v0
.end method

.method private static getProperWeight(Landroid/graphics/Typeface;[Ljava/lang/String;)I
    .locals 4

    if-nez p0, :cond_0

    const/16 v0, 0x190

    return v0

    :cond_0
    const-string v0, "miui"

    filled-new-array {v0}, [Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Lmiui/util/TypefaceUtils;->isNamesOf([Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$800()[Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    :cond_1
    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$900()[Ljava/lang/String;

    move-result-object v1

    :goto_0
    invoke-static {p1, v1}, Lmiui/util/TypefaceUtils;->getNameIndex([Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    invoke-virtual {p0}, Landroid/graphics/Typeface;->isBold()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$1000()[I

    move-result-object v2

    array-length v2, v2

    add-int/lit8 v2, v2, -0x1

    if-ge v1, v2, :cond_2

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$1000()[I

    move-result-object v2

    add-int/lit8 v3, v1, 0x1

    aget v2, v2, v3

    goto :goto_1

    :cond_2
    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$1000()[I

    move-result-object v2

    aget v2, v2, v1

    :goto_1
    return v2
.end method

.method private static getScaleWght(IIIZ)I
    .locals 5

    invoke-static {p2}, Lmiui/util/TypefaceUtils$Holder;->getRules(I)[[I

    move-result-object v0

    invoke-static {p0}, Lmiui/util/TypefaceUtils$Holder;->getWeightIndex(I)I

    move-result v1

    if-ltz v1, :cond_0

    aget-object v2, v0, v1

    invoke-static {p0, v2, p1, p3}, Lmiui/util/TypefaceUtils;->getWghtInRange(I[IIZ)I

    move-result v2

    return v2

    :cond_0
    const/16 v2, 0x190

    invoke-static {v2}, Lmiui/util/TypefaceUtils$Holder;->getWeightIndex(I)I

    move-result v3

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$1100()[[I

    move-result-object v4

    aget-object v4, v4, v3

    invoke-static {v2, v4, p1, p3}, Lmiui/util/TypefaceUtils;->getWghtInRange(I[IIZ)I

    move-result v2

    return v2
.end method

.method private static getVarFont(Landroid/content/Context;Landroid/graphics/Typeface;FZLandroid/graphics/Typeface;[Ljava/lang/String;)Landroid/graphics/Typeface;
    .locals 6

    invoke-static {p1, p5}, Lmiui/util/TypefaceUtils;->getProperWeight(Landroid/graphics/Typeface;[Ljava/lang/String;)I

    move-result v0

    invoke-static {v0, p3}, Lmiui/util/TypefaceUtils$Holder;->getWght(IZ)I

    move-result v1

    const/16 v2, 0x32

    if-nez p0, :cond_0

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "key_miui_font_weight_scale"

    invoke-static {v3, v4, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v2

    :goto_0
    nop

    invoke-static {p2}, Lmiui/util/TypefaceUtils$Holder;->getTextSizeGrade(F)I

    move-result v3

    invoke-static {v1, v2, v3}, Lmiui/util/TypefaceUtils$Holder;->getCachedFont(III)Landroid/graphics/Typeface;

    move-result-object v4

    if-nez v4, :cond_1

    invoke-static {v0, v2, v3, p3}, Lmiui/util/TypefaceUtils;->getScaleWght(IIIZ)I

    move-result v5

    invoke-static {p4, v5}, Lmiui/util/TypefaceHelper;->createVarFont(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object v4

    invoke-static {v4, p5}, Lmiui/util/TypefaceUtils;->setFontNames(Landroid/graphics/Typeface;[Ljava/lang/String;)V

    invoke-static {v4, v1, v2, v3}, Lmiui/util/TypefaceUtils$Holder;->cacheFont(Landroid/graphics/Typeface;III)V

    :cond_1
    return-object v4
.end method

.method private static getWghtInRange(I[IIZ)I
    .locals 7

    const/4 v0, 0x0

    aget v0, p1, v0

    invoke-static {v0, p3}, Lmiui/util/TypefaceUtils$Holder;->getWght(IZ)I

    move-result v0

    invoke-static {p0, p3}, Lmiui/util/TypefaceUtils$Holder;->getWght(IZ)I

    move-result v1

    const/4 v2, 0x1

    aget v2, p1, v2

    invoke-static {v2, p3}, Lmiui/util/TypefaceUtils$Holder;->getWght(IZ)I

    move-result v2

    move v3, v1

    const/high16 v4, 0x3f800000    # 1.0f

    const/high16 v5, 0x42480000    # 50.0f

    const/16 v6, 0x32

    if-ge p2, v6, :cond_0

    int-to-float v6, p2

    div-float/2addr v6, v5

    sub-float/2addr v4, v6

    int-to-float v5, v0

    mul-float/2addr v4, v5

    int-to-float v5, v1

    mul-float/2addr v5, v6

    add-float/2addr v4, v5

    float-to-int v3, v4

    goto :goto_0

    :cond_0
    if-le p2, v6, :cond_1

    add-int/lit8 v6, p2, -0x32

    int-to-float v6, v6

    div-float/2addr v6, v5

    sub-float/2addr v4, v6

    int-to-float v5, v1

    mul-float/2addr v4, v5

    int-to-float v5, v2

    mul-float/2addr v5, v6

    add-float/2addr v4, v5

    float-to-int v3, v4

    goto :goto_1

    :cond_1
    :goto_0
    nop

    :goto_1
    return v3
.end method

.method private static isDefaultFont([Ljava/lang/String;)Z
    .locals 5

    const/4 v0, 0x0

    if-nez p0, :cond_0

    return v0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$1200()[Ljava/lang/String;

    move-result-object v2

    array-length v2, v2

    if-ge v1, v2, :cond_3

    const/4 v2, 0x0

    :goto_1
    array-length v3, p0

    if-ge v2, v3, :cond_2

    aget-object v3, p0, v2

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$1200()[Ljava/lang/String;

    move-result-object v4

    aget-object v4, v4, v1

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    const/4 v0, 0x1

    return v0

    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_3
    return v0
.end method

.method public static isFontChanged(Landroid/content/res/Configuration;)Z
    .locals 4

    iget-object v0, p0, Landroid/content/res/Configuration;->extraConfig:Landroid/content/res/MiuiConfiguration;

    iget-wide v0, v0, Landroid/content/res/MiuiConfiguration;->themeChangedFlags:J

    const-wide/32 v2, 0x20000000

    and-long/2addr v0, v2

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private static varargs isNamesOf([Ljava/lang/String;[Ljava/lang/String;)Z
    .locals 5

    if-eqz p0, :cond_3

    array-length v0, p0

    if-lez v0, :cond_3

    const/4 v0, 0x0

    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_3

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v2, p1, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/16 v2, 0x2d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    :goto_1
    array-length v3, p0

    if-ge v2, v3, :cond_2

    aget-object v3, p0, v2

    aget-object v4, p1, v0

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    aget-object v3, p0, v2

    invoke-virtual {v3, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    goto :goto_2

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_1
    :goto_2
    const/4 v3, 0x1

    return v3

    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_3
    const/4 v0, 0x0

    return v0
.end method

.method public static isUsingMiFont(Landroid/graphics/Typeface;)Z
    .locals 5

    if-eqz p0, :cond_0

    invoke-static {p0}, Lmiui/util/TypefaceUtils;->getFontNames(Landroid/graphics/Typeface;)[Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    :goto_0
    const-string v1, "miui"

    const-string v2, "mipro"

    const-string v3, "mitype"

    const-string v4, "mitype-mono"

    filled-new-array {v1, v2, v3, v4}, [Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lmiui/util/TypefaceUtils;->isNamesOf([Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v1

    return v1
.end method

.method private static isUsingMiuiFont(Landroid/content/Context;)Z
    .locals 6

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lmiui/util/TypefaceUtils;->sUsingMiuiFontMap:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Boolean;

    if-nez v1, :cond_1

    const/4 v2, 0x0

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    const/16 v4, 0x80

    invoke-virtual {v3, v0, v4}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    if-eqz v3, :cond_0

    const-string v4, "use_miui_font"

    invoke-virtual {v3, v4, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    goto :goto_0

    :cond_0
    move v4, v2

    :goto_0
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    move-object v1, v4

    sget-object v4, Lmiui/util/TypefaceUtils;->sUsingMiuiFontMap:Ljava/util/Map;

    invoke-interface {v4, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    nop

    goto :goto_1

    :catch_0
    move-exception v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "get metaData of "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, " failed"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "TypefaceUtils"

    invoke-static {v5, v4, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    return v2

    :cond_1
    :goto_1
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    return v2
.end method

.method public static replaceTypeface(Landroid/content/Context;Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    .locals 1

    const/high16 v0, -0x40800000    # -1.0f

    invoke-static {p0, p1, v0}, Lmiui/util/TypefaceUtils;->replaceTypeface(Landroid/content/Context;Landroid/graphics/Typeface;F)Landroid/graphics/Typeface;

    move-result-object v0

    return-object v0
.end method

.method public static replaceTypeface(Landroid/content/Context;Landroid/graphics/Typeface;F)Landroid/graphics/Typeface;
    .locals 5

    if-eqz p1, :cond_0

    invoke-static {p1}, Lmiui/util/TypefaceUtils;->getFontNames(Landroid/graphics/Typeface;)[Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    :goto_0
    const-string v1, "miui"

    const-string v2, "mipro"

    const-string v3, "mitype"

    const-string v4, "mitype-mono"

    filled-new-array {v1, v2, v3, v4}, [Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lmiui/util/TypefaceUtils;->isNamesOf([Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v1

    sget-boolean v2, Lmiui/os/Build;->IS_INTERNATIONAL_BUILD:Z

    if-nez v2, :cond_6

    invoke-static {}, Landroid/graphics/TypefaceInjector;->isUsingThemeFont()Z

    move-result v2

    if-eqz v2, :cond_1

    goto :goto_3

    :cond_1
    const/4 v2, 0x0

    invoke-static {p0}, Lmiui/util/TypefaceUtils;->usingMiuiFonts(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_2

    if-eqz v1, :cond_4

    :cond_2
    sget-boolean v3, Lmiui/util/TypefaceUtils;->USING_VAR_FONT:Z

    if-eqz v3, :cond_3

    invoke-static {p0, p1, p2}, Lmiui/util/TypefaceUtils;->replaceWithVarFont(Landroid/content/Context;Landroid/graphics/Typeface;F)Landroid/graphics/Typeface;

    move-result-object v2

    goto :goto_1

    :cond_3
    invoke-static {p1}, Lmiui/util/TypefaceUtils;->replaceWithMiuiFont(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    move-result-object v2

    :cond_4
    :goto_1
    if-nez v2, :cond_5

    move-object v3, p1

    goto :goto_2

    :cond_5
    move-object v3, v2

    :goto_2
    return-object v3

    :cond_6
    :goto_3
    if-eqz v1, :cond_7

    invoke-static {p1, v0}, Lmiui/util/TypefaceUtils;->convertMiuiFontToSysFont(Landroid/graphics/Typeface;[Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v2

    return-object v2

    :cond_7
    return-object p1
.end method

.method private static replaceWithMiuiFont(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    .locals 2

    if-eqz p0, :cond_1

    sget-object v0, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v0, p0}, Landroid/graphics/Typeface;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/graphics/Typeface;->DEFAULT_BOLD:Landroid/graphics/Typeface;

    invoke-virtual {v0, p0}, Landroid/graphics/Typeface;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    invoke-virtual {v0, p0}, Landroid/graphics/Typeface;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return-object v0

    :cond_1
    :goto_0
    if-nez p0, :cond_2

    const/4 v0, 0x0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Landroid/graphics/Typeface;->getStyle()I

    move-result v0

    :goto_1
    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$300()[Landroid/graphics/Typeface;

    move-result-object v1

    aget-object v1, v1, v0

    return-object v1
.end method

.method private static replaceWithVarFont(Landroid/content/Context;Landroid/graphics/Typeface;F)Landroid/graphics/Typeface;
    .locals 12

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/graphics/Typeface;->isItalic()Z

    move-result v1

    if-eqz v1, :cond_0

    return-object v0

    :cond_0
    if-nez p0, :cond_1

    const/high16 v1, -0x40800000    # -1.0f

    move v4, v1

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->scaledDensity:F

    div-float v1, p2, v1

    move v4, v1

    :goto_0
    nop

    if-eqz p1, :cond_3

    sget-object v1, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    if-eq p1, v1, :cond_3

    sget-object v1, Landroid/graphics/Typeface;->DEFAULT_BOLD:Landroid/graphics/Typeface;

    if-ne p1, v1, :cond_2

    goto :goto_1

    :cond_2
    invoke-static {p1}, Lmiui/util/TypefaceUtils;->getFontNames(Landroid/graphics/Typeface;)[Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    :cond_3
    :goto_1
    const-string v1, "mipro"

    filled-new-array {v1}, [Ljava/lang/String;

    move-result-object v1

    :goto_2
    invoke-static {v1}, Lmiui/util/TypefaceUtils;->isDefaultFont([Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_7

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$400()[Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lmiui/util/TypefaceUtils;->isNamesOf([Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    goto :goto_3

    :cond_4
    const-string v2, "mitype-mono"

    filled-new-array {v2}, [Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lmiui/util/TypefaceUtils;->isNamesOf([Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    const/4 v5, 0x1

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$600()Landroid/graphics/Typeface;

    move-result-object v6

    move-object v2, p0

    move-object v3, p1

    move-object v7, v1

    invoke-static/range {v2 .. v7}, Lmiui/util/TypefaceUtils;->getVarFont(Landroid/content/Context;Landroid/graphics/Typeface;FZLandroid/graphics/Typeface;[Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    return-object v0

    :cond_5
    const-string v2, "mitype"

    filled-new-array {v2}, [Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lmiui/util/TypefaceUtils;->isNamesOf([Ljava/lang/String;[Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    const/4 v8, 0x1

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$700()Landroid/graphics/Typeface;

    move-result-object v9

    move-object v5, p0

    move-object v6, p1

    move v7, v4

    move-object v10, v1

    invoke-static/range {v5 .. v10}, Lmiui/util/TypefaceUtils;->getVarFont(Landroid/content/Context;Landroid/graphics/Typeface;FZLandroid/graphics/Typeface;[Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    return-object v0

    :cond_6
    return-object v0

    :cond_7
    :goto_3
    if-eqz v11, :cond_8

    invoke-static {v1}, Lmiui/util/TypefaceUtils;->convertFontNames([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    :cond_8
    const/4 v8, 0x0

    invoke-static {}, Lmiui/util/TypefaceUtils$Holder;->access$500()Landroid/graphics/Typeface;

    move-result-object v9

    move-object v5, p0

    move-object v6, p1

    move v7, v4

    move-object v10, v1

    invoke-static/range {v5 .. v10}, Lmiui/util/TypefaceUtils;->getVarFont(Landroid/content/Context;Landroid/graphics/Typeface;FZLandroid/graphics/Typeface;[Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    return-object v0
.end method

.method private static setFontNames(Landroid/graphics/Typeface;[Ljava/lang/String;)V
    .locals 3

    :try_start_0
    sget-object v0, Lmiui/util/TypefaceUtils;->sFamilyNameField:Ljava/lang/reflect/Field;

    invoke-virtual {v0, p0, p1}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    const-string v1, "TypefaceUtils"

    const-string v2, "set familyName failed"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :goto_0
    return-void
.end method

.method public static usingMiuiFonts(Landroid/content/Context;)Z
    .locals 3

    const/4 v0, 0x0

    return v0

    # sget-boolean v0, Lmiui/os/Build;->IS_INTERNATIONAL_BUILD:Z

    # if-eqz v0, :cond_0

    # const/4 v0, 0x0

    # return v0

    # :cond_0
    # invoke-static {p0}, Lmiui/os/Environment;->isUsingMiui(Landroid/content/Context;)Z

    # move-result v0

    # const/4 v1, 0x1

    # if-eqz v0, :cond_1

    # return v1

    # :cond_1
    # invoke-static {}, Lmiui/util/TypefaceUtils$FontsWhiteListHolder;->access$000()Ljava/util/HashSet;

    # move-result-object v0

    # invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    # move-result-object v2

    # invoke-virtual {v0, v2}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    # move-result v0

    # if-eqz v0, :cond_2

    # return v1

    # :cond_2
    # invoke-static {p0}, Lmiui/util/TypefaceUtils;->isUsingMiuiFont(Landroid/content/Context;)Z

    # move-result v0

    # return v0
.end method
