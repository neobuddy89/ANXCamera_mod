.class public Lmiui/util/concurrent/ConcurrentRingQueue;
.super Ljava/lang/Object;
.source "ConcurrentRingQueue.java"

# interfaces
.implements Lmiui/util/concurrent/Queue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/util/concurrent/ConcurrentRingQueue$Node;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lmiui/util/concurrent/Queue<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private volatile mAdditional:I

.field private final mAllowExtendCapacity:Z

.field private final mAutoReleaseCapacity:Z

.field private mCapacity:I

.field private volatile mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lmiui/util/concurrent/ConcurrentRingQueue$Node<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

.field private volatile mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lmiui/util/concurrent/ConcurrentRingQueue$Node<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method public constructor <init>(IZZ)V
    .locals 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mCapacity:I

    iput-boolean p2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAllowExtendCapacity:Z

    iput-boolean p3, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAutoReleaseCapacity:Z

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    new-instance v0, Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lmiui/util/concurrent/ConcurrentRingQueue$Node;-><init>(Lmiui/util/concurrent/ConcurrentRingQueue$1;)V

    iput-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iput-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    const/4 v2, 0x0

    :goto_0
    if-ge v2, p1, :cond_0

    new-instance v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    invoke-direct {v3, v1}, Lmiui/util/concurrent/ConcurrentRingQueue$Node;-><init>(Lmiui/util/concurrent/ConcurrentRingQueue$1;)V

    iput-object v3, v0, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v0, v0, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iput-object v1, v0, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    return-void
.end method


# virtual methods
.method public clear()I
    .locals 4

    iget-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    :goto_0
    if-nez v0, :cond_2

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v3, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v1

    if-nez v1, :cond_0

    goto :goto_2

    :cond_0
    const/4 v0, 0x0

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    :goto_1
    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    if-eq v1, v2, :cond_1

    const/4 v2, 0x0

    iput-object v2, v1, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->element:Ljava/lang/Object;

    add-int/lit8 v0, v0, 0x1

    iget-object v1, v1, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    goto :goto_1

    :cond_1
    iput-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    return v0

    :cond_2
    :goto_2
    invoke-static {}, Ljava/lang/Thread;->yield()V

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    goto :goto_0
.end method

.method public decreaseCapacity(I)V
    .locals 4

    iget-boolean v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAutoReleaseCapacity:Z

    if-eqz v0, :cond_3

    if-gtz p1, :cond_0

    goto :goto_2

    :cond_0
    iget-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    :goto_0
    if-nez v0, :cond_2

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v3, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v1

    if-nez v1, :cond_1

    goto :goto_1

    :cond_1
    iget v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mCapacity:I

    sub-int/2addr v0, p1

    iput v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mCapacity:I

    iput p1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAdditional:I

    iget-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    return-void

    :cond_2
    :goto_1
    invoke-static {}, Ljava/lang/Thread;->yield()V

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    goto :goto_0

    :cond_3
    :goto_2
    return-void
.end method

.method public get()Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    iget-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    :goto_0
    if-nez v0, :cond_3

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v3, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v1

    if-nez v1, :cond_0

    goto :goto_2

    :cond_0
    const/4 v0, 0x0

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    :goto_1
    if-nez v0, :cond_1

    if-eq v1, v2, :cond_1

    iget-object v0, v1, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->element:Ljava/lang/Object;

    const/4 v4, 0x0

    iput-object v4, v1, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->element:Ljava/lang/Object;

    iget-object v1, v1, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    goto :goto_1

    :cond_1
    if-eqz v0, :cond_2

    iput-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    :cond_2
    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    return-object v0

    :cond_3
    :goto_2
    invoke-static {}, Ljava/lang/Thread;->yield()V

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    goto :goto_0
.end method

.method public getCapacity()I
    .locals 2

    iget v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAdditional:I

    move v1, v0

    if-lez v0, :cond_0

    iget v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mCapacity:I

    add-int/2addr v0, v1

    goto :goto_0

    :cond_0
    iget v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mCapacity:I

    :goto_0
    return v0
.end method

.method public increaseCapacity(I)V
    .locals 4

    iget-boolean v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAllowExtendCapacity:Z

    if-nez v0, :cond_3

    if-gtz p1, :cond_0

    goto :goto_2

    :cond_0
    iget-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    :goto_0
    if-nez v0, :cond_2

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v3, v2}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v1

    if-nez v1, :cond_1

    goto :goto_1

    :cond_1
    neg-int v0, p1

    iput v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAdditional:I

    iget v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mCapacity:I

    add-int/2addr v0, p1

    iput v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mCapacity:I

    iget-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    return-void

    :cond_2
    :goto_1
    invoke-static {}, Ljava/lang/Thread;->yield()V

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v0

    goto :goto_0

    :cond_3
    :goto_2
    return-void
.end method

.method public isEmpty()Z
    .locals 2

    iget-object v0, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public put(Ljava/lang/Object;)Z
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    const/4 v0, 0x0

    if-nez p1, :cond_0

    return v0

    :cond_0
    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    :goto_0
    if-nez v1, :cond_6

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v3, -0x1

    invoke-virtual {v2, v0, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v2

    if-nez v2, :cond_1

    goto :goto_2

    :cond_1
    const/4 v1, 0x0

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v3, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget v4, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAdditional:I

    iget-object v5, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    if-eq v5, v2, :cond_3

    iput-object p1, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->element:Ljava/lang/Object;

    iget-object v5, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v5, v5, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    if-eq v5, v2, :cond_2

    iget-boolean v5, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAutoReleaseCapacity:Z

    if-eqz v5, :cond_2

    if-lez v4, :cond_2

    iget-object v5, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v5, v5, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iput-object v5, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    add-int/lit8 v5, v4, -0x1

    iput v5, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAdditional:I

    :cond_2
    iget-object v5, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iput-object v5, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    const/4 v1, 0x1

    goto :goto_1

    :cond_3
    iget-boolean v5, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAllowExtendCapacity:Z

    if-nez v5, :cond_4

    if-gez v4, :cond_5

    :cond_4
    new-instance v5, Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    const/4 v6, 0x0

    invoke-direct {v5, v6}, Lmiui/util/concurrent/ConcurrentRingQueue$Node;-><init>(Lmiui/util/concurrent/ConcurrentRingQueue$1;)V

    iput-object v5, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iget-object v5, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iput-object v2, v5, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iput-object p1, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->element:Ljava/lang/Object;

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mAdditional:I

    iget-object v5, v3, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    iput-object v5, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    const/4 v1, 0x1

    :cond_5
    :goto_1
    iget-object v5, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v5, v0}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    return v1

    :cond_6
    :goto_2
    invoke-static {}, Ljava/lang/Thread;->yield()V

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    goto :goto_0
.end method

.method public remove(Lmiui/util/concurrent/Queue$Predicate;)I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lmiui/util/concurrent/Queue$Predicate<",
            "TT;>;)I"
        }
    .end annotation

    const/4 v0, 0x0

    if-nez p1, :cond_0

    return v0

    :cond_0
    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    :goto_0
    if-nez v1, :cond_4

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v3, -0x1

    invoke-virtual {v2, v0, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v2

    if-nez v2, :cond_1

    goto :goto_2

    :cond_1
    const/4 v1, 0x0

    :try_start_0
    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    :goto_1
    iget-object v3, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    if-eq v2, v3, :cond_3

    iget-object v3, v2, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->element:Ljava/lang/Object;

    invoke-interface {p1, v3}, Lmiui/util/concurrent/Queue$Predicate;->apply(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    const/4 v3, 0x0

    iput-object v3, v2, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->element:Ljava/lang/Object;

    add-int/lit8 v1, v1, 0x1

    :cond_2
    iget-object v3, v2, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v2, v3

    goto :goto_1

    :cond_3
    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2, v0}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    nop

    return v1

    :catchall_0
    move-exception v2

    iget-object v3, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v3, v0}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    throw v2

    :cond_4
    :goto_2
    invoke-static {}, Ljava/lang/Thread;->yield()V

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    goto :goto_0
.end method

.method public remove(Ljava/lang/Object;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    const/4 v0, 0x0

    if-nez p1, :cond_0

    return v0

    :cond_0
    iget-object v1, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    :goto_0
    if-nez v1, :cond_4

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v3, -0x1

    invoke-virtual {v2, v0, v3}, Ljava/util/concurrent/atomic/AtomicInteger;->compareAndSet(II)Z

    move-result v2

    if-nez v2, :cond_1

    goto :goto_3

    :cond_1
    const/4 v1, 0x0

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    :goto_1
    iget-object v3, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mWriteCursor:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    if-eq v2, v3, :cond_3

    iget-object v3, v2, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->element:Ljava/lang/Object;

    invoke-virtual {p1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    const/4 v3, 0x0

    iput-object v3, v2, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->element:Ljava/lang/Object;

    const/4 v1, 0x1

    goto :goto_2

    :cond_2
    iget-object v2, v2, Lmiui/util/concurrent/ConcurrentRingQueue$Node;->next:Lmiui/util/concurrent/ConcurrentRingQueue$Node;

    goto :goto_1

    :cond_3
    :goto_2
    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2, v0}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    return v1

    :cond_4
    :goto_3
    invoke-static {}, Ljava/lang/Thread;->yield()V

    iget-object v2, p0, Lmiui/util/concurrent/ConcurrentRingQueue;->mReadLock:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v1

    goto :goto_0
.end method
