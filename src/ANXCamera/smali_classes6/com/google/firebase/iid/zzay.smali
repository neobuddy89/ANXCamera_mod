.class final synthetic Lcom/google/firebase/iid/zzay;
.super Ljava/lang/Object;
.source "com.google.firebase:firebase-iid@@20.0.2"

# interfaces
.implements Lcom/google/android/gms/tasks/OnCompleteListener;


# instance fields
.field private final zza:Lcom/google/firebase/iid/zzbd;


# direct methods
.method constructor <init>(Lcom/google/firebase/iid/zzbd;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/firebase/iid/zzay;->zza:Lcom/google/firebase/iid/zzbd;

    return-void
.end method


# virtual methods
.method public final onComplete(Lcom/google/android/gms/tasks/Task;)V
    .locals 0

    iget-object p1, p0, Lcom/google/firebase/iid/zzay;->zza:Lcom/google/firebase/iid/zzbd;

    invoke-virtual {p1}, Lcom/google/firebase/iid/zzbd;->zza()V

    return-void
.end method
