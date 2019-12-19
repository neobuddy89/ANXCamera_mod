.class Lmiui/util/Pools$SoftReferenceInstanceHolder;
.super Ljava/lang/Object;
.source "Pools.java"

# interfaces
.implements Lmiui/util/Pools$IInstanceHolder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/Pools;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SoftReferenceInstanceHolder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lmiui/util/Pools$IInstanceHolder<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final mClazz:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class<",
            "TT;>;"
        }
    .end annotation
.end field

.field private volatile mElements:[Ljava/lang/ref/SoftReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/ref/SoftReference<",
            "TT;>;"
        }
    .end annotation
.end field

.field private volatile mIndex:I

.field private volatile mSize:I


# direct methods
.method constructor <init>(Ljava/lang/Class;I)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "TT;>;I)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mClazz:Ljava/lang/Class;

    iput p2, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mSize:I

    new-array v0, p2, [Ljava/lang/ref/SoftReference;

    iput-object v0, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mElements:[Ljava/lang/ref/SoftReference;

    const/4 v1, 0x0

    iput v1, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mIndex:I

    return-void
.end method


# virtual methods
.method public declared-synchronized get()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    iget v0, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mIndex:I

    iget-object v1, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mElements:[Ljava/lang/ref/SoftReference;

    :cond_0
    :goto_0
    const/4 v2, 0x0

    if-eqz v0, :cond_2

    add-int/lit8 v0, v0, -0x1

    aget-object v3, v1, v0

    if-eqz v3, :cond_0

    aget-object v3, v1, v0

    invoke-virtual {v3}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v3

    aput-object v2, v1, v0

    if-eqz v3, :cond_1

    iput v0, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mIndex:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v3

    :cond_1
    goto :goto_0

    :cond_2
    monitor-exit p0

    return-object v2

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getElementClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class<",
            "TT;>;"
        }
    .end annotation

    iget-object v0, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mClazz:Ljava/lang/Class;

    return-object v0
.end method

.method public getSize()I
    .locals 1

    iget v0, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mSize:I

    return v0
.end method

.method public declared-synchronized put(Ljava/lang/Object;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    iget v0, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mIndex:I

    iget-object v1, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mElements:[Ljava/lang/ref/SoftReference;

    iget v2, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mSize:I

    const/4 v3, 0x1

    if-lt v0, v2, :cond_3

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_2

    aget-object v4, v1, v2

    if-eqz v4, :cond_1

    aget-object v4, v1, v2

    invoke-virtual {v4}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v4

    if-nez v4, :cond_0

    goto :goto_1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    :goto_1
    new-instance v4, Ljava/lang/ref/SoftReference;

    invoke-direct {v4, p1}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    aput-object v4, v1, v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v3

    :cond_2
    const/4 v2, 0x0

    monitor-exit p0

    return v2

    :cond_3
    :try_start_1
    new-instance v2, Ljava/lang/ref/SoftReference;

    invoke-direct {v2, p1}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    aput-object v2, v1, v0

    add-int/lit8 v2, v0, 0x1

    iput v2, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mIndex:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return v3

    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized resize(I)V
    .locals 4

    monitor-enter p0

    :try_start_0
    iget v0, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mSize:I

    add-int/2addr p1, v0

    if-gtz p1, :cond_0

    invoke-static {}, Lmiui/util/Pools;->access$100()Ljava/util/HashMap;

    move-result-object v0

    monitor-enter v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    invoke-static {}, Lmiui/util/Pools;->access$100()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0}, Lmiui/util/Pools$SoftReferenceInstanceHolder;->getElementClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v1

    :goto_0
    :try_start_2
    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    :try_start_3
    throw v1

    :catchall_1
    move-exception v1

    goto :goto_0

    :cond_0
    iput p1, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mSize:I

    iget-object v0, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mElements:[Ljava/lang/ref/SoftReference;

    iget v1, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mIndex:I

    array-length v2, v0

    if-le p1, v2, :cond_1

    new-array v2, p1, [Ljava/lang/ref/SoftReference;

    const/4 v3, 0x0

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v2, p0, Lmiui/util/Pools$SoftReferenceInstanceHolder;->mElements:[Ljava/lang/ref/SoftReference;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    :cond_1
    monitor-exit p0

    return-void

    :catchall_2
    move-exception p1

    monitor-exit p0

    throw p1
.end method
