.class public Lcom/android/camera/fragment/mimoji/MimojiInfo;
.super Ljava/lang/Object;
.source "MimojiInfo.java"

# interfaces
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Comparable<",
        "Lcom/android/camera/fragment/mimoji/MimojiInfo;",
        ">;"
    }
.end annotation


# instance fields
.field public mAvatarTemplatePath:Ljava/lang/String;

.field public mConfigPath:Ljava/lang/String;

.field public mData:[B

.field public mDirectoryName:J

.field public mPackPath:Ljava/lang/String;

.field public mThumbnailUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compareTo(Lcom/android/camera/fragment/mimoji/MimojiInfo;)I
    .locals 3

    iget-wide v0, p0, Lcom/android/camera/fragment/mimoji/MimojiInfo;->mDirectoryName:J

    iget-wide p0, p1, Lcom/android/camera/fragment/mimoji/MimojiInfo;->mDirectoryName:J

    cmp-long v2, v0, p0

    if-lez v2, :cond_0

    const/4 p0, -0x1

    return p0

    :cond_0
    cmp-long p0, v0, p0

    if-gez p0, :cond_1

    const/4 p0, 0x1

    return p0

    :cond_1
    const/4 p0, 0x0

    return p0
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .locals 0

    check-cast p1, Lcom/android/camera/fragment/mimoji/MimojiInfo;

    invoke-virtual {p0, p1}, Lcom/android/camera/fragment/mimoji/MimojiInfo;->compareTo(Lcom/android/camera/fragment/mimoji/MimojiInfo;)I

    move-result p0

    return p0
.end method
