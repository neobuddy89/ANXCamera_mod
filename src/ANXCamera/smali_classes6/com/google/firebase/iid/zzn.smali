.class final synthetic Lcom/google/firebase/iid/zzn;
.super Ljava/lang/Object;
.source "com.google.firebase:firebase-iid@@20.0.2"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final zza:Lcom/google/firebase/iid/zzl;

.field private final zzb:Landroid/os/Bundle;

.field private final zzc:Lcom/google/android/gms/tasks/TaskCompletionSource;


# direct methods
.method constructor <init>(Lcom/google/firebase/iid/zzl;Landroid/os/Bundle;Lcom/google/android/gms/tasks/TaskCompletionSource;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/firebase/iid/zzn;->zza:Lcom/google/firebase/iid/zzl;

    iput-object p2, p0, Lcom/google/firebase/iid/zzn;->zzb:Landroid/os/Bundle;

    iput-object p3, p0, Lcom/google/firebase/iid/zzn;->zzc:Lcom/google/android/gms/tasks/TaskCompletionSource;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v0, p0, Lcom/google/firebase/iid/zzn;->zza:Lcom/google/firebase/iid/zzl;

    iget-object v1, p0, Lcom/google/firebase/iid/zzn;->zzb:Landroid/os/Bundle;

    iget-object v2, p0, Lcom/google/firebase/iid/zzn;->zzc:Lcom/google/android/gms/tasks/TaskCompletionSource;

    invoke-virtual {v0, v1, v2}, Lcom/google/firebase/iid/zzl;->zza(Landroid/os/Bundle;Lcom/google/android/gms/tasks/TaskCompletionSource;)V

    return-void
.end method
