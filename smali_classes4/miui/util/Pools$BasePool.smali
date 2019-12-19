.class abstract Lmiui/util/Pools$BasePool;
.super Ljava/lang/Object;
.source "Pools.java"

# interfaces
.implements Lmiui/util/Pools$Pool;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/util/Pools;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "BasePool"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lmiui/util/Pools$Pool<",
        "TT;>;"
    }
.end annotation


# instance fields
.field private final mFinalizeGuardian:Ljava/lang/Object;

.field private mInstanceHolder:Lmiui/util/Pools$IInstanceHolder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lmiui/util/Pools$IInstanceHolder<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final mManager:Lmiui/util/Pools$Manager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lmiui/util/Pools$Manager<",
            "TT;>;"
        }
    .end annotation
.end field

.field private final mSize:I


# direct methods
.method public constructor <init>(Lmiui/util/Pools$Manager;I)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lmiui/util/Pools$Manager<",
            "TT;>;I)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lmiui/util/Pools$BasePool$1;

    invoke-direct {v0, p0}, Lmiui/util/Pools$BasePool$1;-><init>(Lmiui/util/Pools$BasePool;)V

    iput-object v0, p0, Lmiui/util/Pools$BasePool;->mFinalizeGuardian:Ljava/lang/Object;

    if-eqz p1, :cond_1

    const/4 v0, 0x1

    if-lt p2, v0, :cond_1

    iput-object p1, p0, Lmiui/util/Pools$BasePool;->mManager:Lmiui/util/Pools$Manager;

    iput p2, p0, Lmiui/util/Pools$BasePool;->mSize:I

    iget-object v0, p0, Lmiui/util/Pools$BasePool;->mManager:Lmiui/util/Pools$Manager;

    invoke-virtual {v0}, Lmiui/util/Pools$Manager;->createInstance()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lmiui/util/Pools$BasePool;->createInstanceHolder(Ljava/lang/Class;I)Lmiui/util/Pools$IInstanceHolder;

    move-result-object v2

    iput-object v2, p0, Lmiui/util/Pools$BasePool;->mInstanceHolder:Lmiui/util/Pools$IInstanceHolder;

    invoke-virtual {p0, v0}, Lmiui/util/Pools$BasePool;->doRelease(Ljava/lang/Object;)V

    return-void

    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "manager create instance cannot return null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1
    iget-object v0, p0, Lmiui/util/Pools$BasePool;->mFinalizeGuardian:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    iput v0, p0, Lmiui/util/Pools$BasePool;->mSize:I

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "manager cannot be null and size cannot less then 1"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public acquire()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    invoke-virtual {p0}, Lmiui/util/Pools$BasePool;->doAcquire()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public close()V
    .locals 2

    iget-object v0, p0, Lmiui/util/Pools$BasePool;->mInstanceHolder:Lmiui/util/Pools$IInstanceHolder;

    if-eqz v0, :cond_0

    iget v1, p0, Lmiui/util/Pools$BasePool;->mSize:I

    invoke-virtual {p0, v0, v1}, Lmiui/util/Pools$BasePool;->destroyInstanceHolder(Lmiui/util/Pools$IInstanceHolder;I)V

    const/4 v0, 0x0

    iput-object v0, p0, Lmiui/util/Pools$BasePool;->mInstanceHolder:Lmiui/util/Pools$IInstanceHolder;

    :cond_0
    return-void
.end method

.method abstract createInstanceHolder(Ljava/lang/Class;I)Lmiui/util/Pools$IInstanceHolder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "TT;>;I)",
            "Lmiui/util/Pools$IInstanceHolder<",
            "TT;>;"
        }
    .end annotation
.end method

.method abstract destroyInstanceHolder(Lmiui/util/Pools$IInstanceHolder;I)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lmiui/util/Pools$IInstanceHolder<",
            "TT;>;I)V"
        }
    .end annotation
.end method

.method protected final doAcquire()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    iget-object v0, p0, Lmiui/util/Pools$BasePool;->mInstanceHolder:Lmiui/util/Pools$IInstanceHolder;

    if-eqz v0, :cond_2

    invoke-interface {v0}, Lmiui/util/Pools$IInstanceHolder;->get()Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_1

    iget-object v1, p0, Lmiui/util/Pools$BasePool;->mManager:Lmiui/util/Pools$Manager;

    invoke-virtual {v1}, Lmiui/util/Pools$Manager;->createInstance()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "manager create instance cannot return null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1
    :goto_0
    iget-object v1, p0, Lmiui/util/Pools$BasePool;->mManager:Lmiui/util/Pools$Manager;

    invoke-virtual {v1, v0}, Lmiui/util/Pools$Manager;->onAcquire(Ljava/lang/Object;)V

    return-object v0

    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot acquire object after close()"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected final doRelease(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    iget-object v0, p0, Lmiui/util/Pools$BasePool;->mInstanceHolder:Lmiui/util/Pools$IInstanceHolder;

    if-eqz v0, :cond_2

    if-nez p1, :cond_0

    return-void

    :cond_0
    iget-object v0, p0, Lmiui/util/Pools$BasePool;->mManager:Lmiui/util/Pools$Manager;

    invoke-virtual {v0, p1}, Lmiui/util/Pools$Manager;->onRelease(Ljava/lang/Object;)V

    iget-object v0, p0, Lmiui/util/Pools$BasePool;->mInstanceHolder:Lmiui/util/Pools$IInstanceHolder;

    invoke-interface {v0, p1}, Lmiui/util/Pools$IInstanceHolder;->put(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lmiui/util/Pools$BasePool;->mManager:Lmiui/util/Pools$Manager;

    invoke-virtual {v0, p1}, Lmiui/util/Pools$Manager;->onDestroy(Ljava/lang/Object;)V

    :cond_1
    return-void

    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Cannot release object after close()"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getSize()I
    .locals 1

    iget-object v0, p0, Lmiui/util/Pools$BasePool;->mInstanceHolder:Lmiui/util/Pools$IInstanceHolder;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    iget v0, p0, Lmiui/util/Pools$BasePool;->mSize:I

    :goto_0
    return v0
.end method

.method public release(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lmiui/util/Pools$BasePool;->doRelease(Ljava/lang/Object;)V

    return-void
.end method
