.class Lcom/bumptech/glide/util/a/g$a;
.super Lcom/bumptech/glide/util/a/g;
.source "StateVerifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bumptech/glide/util/a/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field private volatile jm:Ljava/lang/RuntimeException;


# direct methods
.method constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/bumptech/glide/util/a/g;-><init>(Lcom/bumptech/glide/util/a/f;)V

    return-void
.end method


# virtual methods
.method public Mh()V
    .locals 2

    iget-object v0, p0, Lcom/bumptech/glide/util/a/g$a;->jm:Ljava/lang/RuntimeException;

    if-nez v0, :cond_0

    return-void

    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    iget-object p0, p0, Lcom/bumptech/glide/util/a/g$a;->jm:Ljava/lang/RuntimeException;

    const-string v1, "Already released"

    invoke-direct {v0, v1, p0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
.end method

.method u(Z)V
    .locals 1

    if-eqz p1, :cond_0

    new-instance p1, Ljava/lang/RuntimeException;

    const-string v0, "Released"

    invoke-direct {p1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    iput-object p1, p0, Lcom/bumptech/glide/util/a/g$a;->jm:Ljava/lang/RuntimeException;

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    iput-object p1, p0, Lcom/bumptech/glide/util/a/g$a;->jm:Ljava/lang/RuntimeException;

    :goto_0
    return-void
.end method
