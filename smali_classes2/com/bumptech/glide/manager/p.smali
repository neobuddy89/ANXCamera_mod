.class public Lcom/bumptech/glide/manager/p;
.super Ljava/lang/Object;
.source "RequestTracker.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "RequestTracker"


# instance fields
.field private final qk:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/bumptech/glide/request/c;",
            ">;"
        }
    .end annotation
.end field

.field private final requests:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Lcom/bumptech/glide/request/c;",
            ">;"
        }
    .end annotation
.end field

.field private rk:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bumptech/glide/manager/p;->qk:Ljava/util/List;

    return-void
.end method

.method private a(Lcom/bumptech/glide/request/c;Z)Z
    .locals 2
    .param p1    # Lcom/bumptech/glide/request/c;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    const/4 v0, 0x1

    if-nez p1, :cond_0

    return v0

    :cond_0
    iget-object v1, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    move-result v1

    iget-object p0, p0, Lcom/bumptech/glide/manager/p;->qk:Ljava/util/List;

    invoke-interface {p0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result p0

    if-nez p0, :cond_2

    if-eqz v1, :cond_1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :cond_2
    :goto_0
    if-eqz v0, :cond_3

    invoke-interface {p1}, Lcom/bumptech/glide/request/c;->clear()V

    if-eqz p2, :cond_3

    invoke-interface {p1}, Lcom/bumptech/glide/request/c;->recycle()V

    :cond_3
    return v0
.end method


# virtual methods
.method public Ig()V
    .locals 3

    iget-object v0, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    invoke-static {v0}, Lcom/bumptech/glide/util/l;->b(Ljava/util/Collection;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/request/c;

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/bumptech/glide/manager/p;->a(Lcom/bumptech/glide/request/c;Z)Z

    goto :goto_0

    :cond_0
    iget-object p0, p0, Lcom/bumptech/glide/manager/p;->qk:Ljava/util/List;

    invoke-interface {p0}, Ljava/util/List;->clear()V

    return-void
.end method

.method public Jg()V
    .locals 3

    iget-object v0, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    invoke-static {v0}, Lcom/bumptech/glide/util/l;->b(Ljava/util/Collection;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/request/c;

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->isComplete()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->isCancelled()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->pause()V

    iget-boolean v2, p0, Lcom/bumptech/glide/manager/p;->rk:Z

    if-nez v2, :cond_1

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->begin()V

    goto :goto_0

    :cond_1
    iget-object v2, p0, Lcom/bumptech/glide/manager/p;->qk:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_2
    return-void
.end method

.method public Pf()V
    .locals 3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/manager/p;->rk:Z

    iget-object v0, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    invoke-static {v0}, Lcom/bumptech/glide/util/l;->b(Ljava/util/Collection;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/request/c;

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->isRunning()Z

    move-result v2

    if-nez v2, :cond_1

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->isComplete()Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_1
    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->pause()V

    iget-object v2, p0, Lcom/bumptech/glide/manager/p;->qk:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_2
    return-void
.end method

.method public Qf()V
    .locals 3

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bumptech/glide/manager/p;->rk:Z

    iget-object v0, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    invoke-static {v0}, Lcom/bumptech/glide/util/l;->b(Ljava/util/Collection;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/request/c;

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->isRunning()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->pause()V

    iget-object v2, p0, Lcom/bumptech/glide/manager/p;->qk:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    return-void
.end method

.method public Sf()V
    .locals 3

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bumptech/glide/manager/p;->rk:Z

    iget-object v0, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    invoke-static {v0}, Lcom/bumptech/glide/util/l;->b(Ljava/util/Collection;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bumptech/glide/request/c;

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->isComplete()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->isCancelled()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->isRunning()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-interface {v1}, Lcom/bumptech/glide/request/c;->begin()V

    goto :goto_0

    :cond_1
    iget-object p0, p0, Lcom/bumptech/glide/manager/p;->qk:Ljava/util/List;

    invoke-interface {p0}, Ljava/util/List;->clear()V

    return-void
.end method

.method addRequest(Lcom/bumptech/glide/request/c;)V
    .locals 0
    .annotation build Landroid/support/annotation/VisibleForTesting;
    .end annotation

    iget-object p0, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    invoke-interface {p0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public h(Lcom/bumptech/glide/request/c;)Z
    .locals 1
    .param p1    # Lcom/bumptech/glide/request/c;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/bumptech/glide/manager/p;->a(Lcom/bumptech/glide/request/c;Z)Z

    move-result p0

    return p0
.end method

.method public i(Lcom/bumptech/glide/request/c;)V
    .locals 2
    .param p1    # Lcom/bumptech/glide/request/c;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    iget-object v0, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    iget-boolean v0, p0, Lcom/bumptech/glide/manager/p;->rk:Z

    if-nez v0, :cond_0

    invoke-interface {p1}, Lcom/bumptech/glide/request/c;->begin()V

    goto :goto_0

    :cond_0
    const/4 v0, 0x2

    const-string v1, "RequestTracker"

    invoke-static {v1, v0}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "Paused, delaying request"

    invoke-static {v1, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1
    iget-object p0, p0, Lcom/bumptech/glide/manager/p;->qk:Ljava/util/List;

    invoke-interface {p0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :goto_0
    return-void
.end method

.method public isPaused()Z
    .locals 0

    iget-boolean p0, p0, Lcom/bumptech/glide/manager/p;->rk:Z

    return p0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "{numRequests="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/bumptech/glide/manager/p;->requests:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ", isPaused="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-boolean p0, p0, Lcom/bumptech/glide/manager/p;->rk:Z

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string p0, "}"

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method
