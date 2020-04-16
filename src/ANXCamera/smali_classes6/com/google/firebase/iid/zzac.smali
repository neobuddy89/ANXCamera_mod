.class final synthetic Lcom/google/firebase/iid/zzac;
.super Ljava/lang/Object;
.source "com.google.firebase:firebase-iid@@20.0.2"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final zza:Lcom/google/firebase/iid/zzw;

.field private final zzb:Lcom/google/firebase/iid/zzah;


# direct methods
.method constructor <init>(Lcom/google/firebase/iid/zzw;Lcom/google/firebase/iid/zzah;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/firebase/iid/zzac;->zza:Lcom/google/firebase/iid/zzw;

    iput-object p2, p0, Lcom/google/firebase/iid/zzac;->zzb:Lcom/google/firebase/iid/zzah;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcom/google/firebase/iid/zzac;->zza:Lcom/google/firebase/iid/zzw;

    iget-object v1, p0, Lcom/google/firebase/iid/zzac;->zzb:Lcom/google/firebase/iid/zzah;

    iget v1, v1, Lcom/google/firebase/iid/zzah;->zza:I

    invoke-virtual {v0, v1}, Lcom/google/firebase/iid/zzw;->zza(I)V

    return-void
.end method
