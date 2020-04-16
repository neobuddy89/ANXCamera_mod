.class final synthetic Lcom/google/android/gms/measurement/internal/zzka;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-measurement@@17.3.0"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final zza:Lcom/google/android/gms/measurement/internal/zzjx;

.field private final zzb:I

.field private final zzc:Lcom/google/android/gms/measurement/internal/zzfj;

.field private final zzd:Landroid/content/Intent;


# direct methods
.method constructor <init>(Lcom/google/android/gms/measurement/internal/zzjx;ILcom/google/android/gms/measurement/internal/zzfj;Landroid/content/Intent;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/measurement/internal/zzka;->zza:Lcom/google/android/gms/measurement/internal/zzjx;

    iput p2, p0, Lcom/google/android/gms/measurement/internal/zzka;->zzb:I

    iput-object p3, p0, Lcom/google/android/gms/measurement/internal/zzka;->zzc:Lcom/google/android/gms/measurement/internal/zzfj;

    iput-object p4, p0, Lcom/google/android/gms/measurement/internal/zzka;->zzd:Landroid/content/Intent;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/measurement/internal/zzka;->zza:Lcom/google/android/gms/measurement/internal/zzjx;

    iget v1, p0, Lcom/google/android/gms/measurement/internal/zzka;->zzb:I

    iget-object v2, p0, Lcom/google/android/gms/measurement/internal/zzka;->zzc:Lcom/google/android/gms/measurement/internal/zzfj;

    iget-object v3, p0, Lcom/google/android/gms/measurement/internal/zzka;->zzd:Landroid/content/Intent;

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/android/gms/measurement/internal/zzjx;->zza(ILcom/google/android/gms/measurement/internal/zzfj;Landroid/content/Intent;)V

    return-void
.end method
