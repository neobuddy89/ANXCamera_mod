.class final Lcom/google/android/gms/measurement/internal/zzhf;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-measurement@@17.3.0"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final synthetic zza:Ljava/lang/String;

.field private final synthetic zzb:Ljava/lang/String;

.field private final synthetic zzc:Ljava/lang/String;

.field private final synthetic zzd:J

.field private final synthetic zze:Lcom/google/android/gms/measurement/internal/zzgr;


# direct methods
.method constructor <init>(Lcom/google/android/gms/measurement/internal/zzgr;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zze:Lcom/google/android/gms/measurement/internal/zzgr;

    iput-object p2, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zza:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zzb:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zzc:Ljava/lang/String;

    iput-wide p5, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zzd:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 5

    iget-object v0, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zza:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zze:Lcom/google/android/gms/measurement/internal/zzgr;

    invoke-static {v0}, Lcom/google/android/gms/measurement/internal/zzgr;->zza(Lcom/google/android/gms/measurement/internal/zzgr;)Lcom/google/android/gms/measurement/internal/zzks;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/measurement/internal/zzks;->zzs()Lcom/google/android/gms/measurement/internal/zzgq;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gms/measurement/internal/zzgq;->zzv()Lcom/google/android/gms/measurement/internal/zziy;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zzb:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gms/measurement/internal/zziy;->zza(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zziv;)V

    return-void

    :cond_0
    new-instance v0, Lcom/google/android/gms/measurement/internal/zziv;

    iget-object v1, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zzc:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zza:Ljava/lang/String;

    iget-wide v3, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zzd:J

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/android/gms/measurement/internal/zziv;-><init>(Ljava/lang/String;Ljava/lang/String;J)V

    iget-object v1, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zze:Lcom/google/android/gms/measurement/internal/zzgr;

    invoke-static {v1}, Lcom/google/android/gms/measurement/internal/zzgr;->zza(Lcom/google/android/gms/measurement/internal/zzgr;)Lcom/google/android/gms/measurement/internal/zzks;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/measurement/internal/zzks;->zzs()Lcom/google/android/gms/measurement/internal/zzgq;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gms/measurement/internal/zzgq;->zzv()Lcom/google/android/gms/measurement/internal/zziy;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gms/measurement/internal/zzhf;->zzb:Ljava/lang/String;

    invoke-virtual {v1, v2, v0}, Lcom/google/android/gms/measurement/internal/zziy;->zza(Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zziv;)V

    return-void
.end method
