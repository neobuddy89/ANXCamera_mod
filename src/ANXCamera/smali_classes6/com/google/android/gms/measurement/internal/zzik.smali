.class final Lcom/google/android/gms/measurement/internal/zzik;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-measurement-impl@@17.3.0"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final synthetic zza:Z

.field private final synthetic zzb:Lcom/google/android/gms/measurement/internal/zzhr;


# direct methods
.method constructor <init>(Lcom/google/android/gms/measurement/internal/zzhr;Z)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/measurement/internal/zzik;->zzb:Lcom/google/android/gms/measurement/internal/zzhr;

    iput-boolean p2, p0, Lcom/google/android/gms/measurement/internal/zzik;->zza:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/measurement/internal/zzik;->zzb:Lcom/google/android/gms/measurement/internal/zzhr;

    iget-boolean v1, p0, Lcom/google/android/gms/measurement/internal/zzik;->zza:Z

    invoke-static {v0, v1}, Lcom/google/android/gms/measurement/internal/zzhr;->zza(Lcom/google/android/gms/measurement/internal/zzhr;Z)V

    return-void
.end method
