.class Lmiui/util/Pools$InstanceHolder;
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
    name = "InstanceHolder"
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

.field private final mQueue:Lmiui/util/concurrent/ConcurrentRingQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lmiui/util/concurrent/ConcurrentRingQueue<",
            "TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/lang/Class;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "TT;>;I)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/util/Pools$InstanceHolder;->mClazz:Ljava/lang/Class;

    new-instance v0, Lmiui/util/concurrent/ConcurrentRingQueue;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-direct {v0, p2, v1, v2}, Lmiui/util/concurrent/ConcurrentRingQueue;-><init>(IZZ)V

    iput-object v0, p0, Lmiui/util/Pools$InstanceHolder;->mQueue:Lmiui/util/concurrent/ConcurrentRingQueue;

    return-void
.end method


# virtual methods
.method public get()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    iget-object v0, p0, Lmiui/util/Pools$InstanceHolder;->mQueue:Lmiui/util/concurrent/ConcurrentRingQueue;

    invoke-virtual {v0}, Lmiui/util/concurrent/ConcurrentRingQueue;->get()Ljava/lang/Object;

    move-result-object v0

    return-object v0
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

    iget-object v0, p0, Lmiui/util/Pools$InstanceHolder;->mClazz:Ljava/lang/Class;

    return-object v0
.end method

.method public getSize()I
    .locals 1

    iget-object v0, p0, Lmiui/util/Pools$InstanceHolder;->mQueue:Lmiui/util/concurrent/ConcurrentRingQueue;

    invoke-virtual {v0}, Lmiui/util/concurrent/ConcurrentRingQueue;->getCapacity()I

    move-result v0

    return v0
.end method

.method public put(Ljava/lang/Object;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)Z"
        }
    .end annotation

    iget-object v0, p0, Lmiui/util/Pools$InstanceHolder;->mQueue:Lmiui/util/concurrent/ConcurrentRingQueue;

    invoke-virtual {v0, p1}, Lmiui/util/concurrent/ConcurrentRingQueue;->put(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public declared-synchronized resize(I)V
    .locals 3

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lmiui/util/Pools$InstanceHolder;->mQueue:Lmiui/util/concurrent/ConcurrentRingQueue;

    invoke-virtual {v0}, Lmiui/util/concurrent/ConcurrentRingQueue;->getCapacity()I

    move-result v0

    add-int/2addr p1, v0

    if-gtz p1, :cond_0

    invoke-static {}, Lmiui/util/Pools;->access$000()Ljava/util/HashMap;

    move-result-object v0

    monitor-enter v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    invoke-static {}, Lmiui/util/Pools;->access$000()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0}, Lmiui/util/Pools$InstanceHolder;->getElementClass()Ljava/lang/Class;

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
    if-lez p1, :cond_1

    iget-object v0, p0, Lmiui/util/Pools$InstanceHolder;->mQueue:Lmiui/util/concurrent/ConcurrentRingQueue;

    invoke-virtual {v0, p1}, Lmiui/util/concurrent/ConcurrentRingQueue;->increaseCapacity(I)V

    goto :goto_1

    :cond_1
    iget-object v0, p0, Lmiui/util/Pools$InstanceHolder;->mQueue:Lmiui/util/concurrent/ConcurrentRingQueue;

    neg-int v1, p1

    invoke-virtual {v0, v1}, Lmiui/util/concurrent/ConcurrentRingQueue;->decreaseCapacity(I)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    :goto_1
    monitor-exit p0

    return-void

    :catchall_2
    move-exception p1

    monitor-exit p0

    throw p1
.end method
