.class final synthetic Lcom/google/firebase/iid/zzz;
.super Ljava/lang/Object;
.source "com.google.firebase:firebase-iid@@20.0.2"

# interfaces
.implements Landroid/os/Handler$Callback;


# instance fields
.field private final zza:Lcom/google/firebase/iid/zzw;


# direct methods
.method constructor <init>(Lcom/google/firebase/iid/zzw;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/firebase/iid/zzz;->zza:Lcom/google/firebase/iid/zzw;

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)Z
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/iid/zzz;->zza:Lcom/google/firebase/iid/zzw;

    invoke-virtual {v0, p1}, Lcom/google/firebase/iid/zzw;->zza(Landroid/os/Message;)Z

    move-result p1

    return p1
.end method
