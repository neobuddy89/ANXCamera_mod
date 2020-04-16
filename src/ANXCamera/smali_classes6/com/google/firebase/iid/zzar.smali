.class final Lcom/google/firebase/iid/zzar;
.super Lcom/google/android/gms/internal/firebase_messaging/zze;
.source "com.google.firebase:firebase-iid@@20.0.2"


# instance fields
.field private final synthetic zza:Lcom/google/firebase/iid/zzao;


# direct methods
.method constructor <init>(Lcom/google/firebase/iid/zzao;Landroid/os/Looper;)V
    .locals 0

    iput-object p1, p0, Lcom/google/firebase/iid/zzar;->zza:Lcom/google/firebase/iid/zzao;

    invoke-direct {p0, p2}, Lcom/google/android/gms/internal/firebase_messaging/zze;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 1

    iget-object v0, p0, Lcom/google/firebase/iid/zzar;->zza:Lcom/google/firebase/iid/zzao;

    invoke-static {v0, p1}, Lcom/google/firebase/iid/zzao;->zza(Lcom/google/firebase/iid/zzao;Landroid/os/Message;)V

    return-void
.end method
