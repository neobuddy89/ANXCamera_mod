.class Lmiui/util/TypefaceUtils$Holder$FontCacheItem;
.super Ljava/lang/Object;
.source "TypefaceUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/TypefaceUtils$Holder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FontCacheItem"
.end annotation


# instance fields
.field cache:[Landroid/graphics/Typeface;

.field scale:I


# direct methods
.method constructor <init>()V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x3

    new-array v1, v0, [Landroid/graphics/Typeface;

    iput-object v1, p0, Lmiui/util/TypefaceUtils$Holder$FontCacheItem;->cache:[Landroid/graphics/Typeface;

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_0

    iget-object v2, p0, Lmiui/util/TypefaceUtils$Holder$FontCacheItem;->cache:[Landroid/graphics/Typeface;

    const/4 v3, 0x0

    aput-object v3, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method


# virtual methods
.method clear()V
    .locals 3

    const/4 v0, 0x0

    :goto_0
    iget-object v1, p0, Lmiui/util/TypefaceUtils$Holder$FontCacheItem;->cache:[Landroid/graphics/Typeface;

    array-length v2, v1

    if-ge v0, v2, :cond_0

    const/4 v2, 0x0

    aput-object v2, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method

.method getFont(I)Landroid/graphics/Typeface;
    .locals 1

    iget-object v0, p0, Lmiui/util/TypefaceUtils$Holder$FontCacheItem;->cache:[Landroid/graphics/Typeface;

    aget-object v0, v0, p1

    return-object v0
.end method

.method setFont(Landroid/graphics/Typeface;I)V
    .locals 1

    iget-object v0, p0, Lmiui/util/TypefaceUtils$Holder$FontCacheItem;->cache:[Landroid/graphics/Typeface;

    aput-object p1, v0, p2

    return-void
.end method
