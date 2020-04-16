.class public Lcom/google/android/gms/internal/measurement/zzeq;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-measurement-base@@17.3.0"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/internal/measurement/zzeq$zza;
    }
.end annotation


# static fields
.field private static volatile zza:Z

.field private static zzb:Z

.field private static volatile zzc:Lcom/google/android/gms/internal/measurement/zzeq;

.field private static volatile zzd:Lcom/google/android/gms/internal/measurement/zzeq;

.field private static final zze:Lcom/google/android/gms/internal/measurement/zzeq;


# instance fields
.field private final zzf:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Lcom/google/android/gms/internal/measurement/zzeq$zza;",
            "Lcom/google/android/gms/internal/measurement/zzfd$zzf<",
            "**>;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v0, 0x0

    sput-boolean v0, Lcom/google/android/gms/internal/measurement/zzeq;->zza:Z

    const/4 v0, 0x1

    sput-boolean v0, Lcom/google/android/gms/internal/measurement/zzeq;->zzb:Z

    new-instance v1, Lcom/google/android/gms/internal/measurement/zzeq;

    invoke-direct {v1, v0}, Lcom/google/android/gms/internal/measurement/zzeq;-><init>(Z)V

    sput-object v1, Lcom/google/android/gms/internal/measurement/zzeq;->zze:Lcom/google/android/gms/internal/measurement/zzeq;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/measurement/zzeq;->zzf:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>(Z)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object p1

    iput-object p1, p0, Lcom/google/android/gms/internal/measurement/zzeq;->zzf:Ljava/util/Map;

    return-void
.end method

.method public static zza()Lcom/google/android/gms/internal/measurement/zzeq;
    .locals 2

    sget-object v0, Lcom/google/android/gms/internal/measurement/zzeq;->zzc:Lcom/google/android/gms/internal/measurement/zzeq;

    if-nez v0, :cond_1

    const-class v1, Lcom/google/android/gms/internal/measurement/zzeq;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/google/android/gms/internal/measurement/zzeq;->zzc:Lcom/google/android/gms/internal/measurement/zzeq;

    if-nez v0, :cond_0

    nop

    sget-object v0, Lcom/google/android/gms/internal/measurement/zzeq;->zze:Lcom/google/android/gms/internal/measurement/zzeq;

    sput-object v0, Lcom/google/android/gms/internal/measurement/zzeq;->zzc:Lcom/google/android/gms/internal/measurement/zzeq;

    :cond_0
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :goto_0
    return-object v0
.end method

.method public static zzb()Lcom/google/android/gms/internal/measurement/zzeq;
    .locals 2

    const-class v0, Lcom/google/android/gms/internal/measurement/zzeq;

    sget-object v1, Lcom/google/android/gms/internal/measurement/zzeq;->zzd:Lcom/google/android/gms/internal/measurement/zzeq;

    if-eqz v1, :cond_0

    return-object v1

    :cond_0
    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/google/android/gms/internal/measurement/zzeq;->zzd:Lcom/google/android/gms/internal/measurement/zzeq;

    if-eqz v1, :cond_1

    monitor-exit v0

    return-object v1

    :cond_1
    nop

    invoke-static {v0}, Lcom/google/android/gms/internal/measurement/zzfb;->zza(Ljava/lang/Class;)Lcom/google/android/gms/internal/measurement/zzeq;

    move-result-object v1

    nop

    sput-object v1, Lcom/google/android/gms/internal/measurement/zzeq;->zzd:Lcom/google/android/gms/internal/measurement/zzeq;

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method


# virtual methods
.method public final zza(Lcom/google/android/gms/internal/measurement/zzgo;I)Lcom/google/android/gms/internal/measurement/zzfd$zzf;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<ContainingType::",
            "Lcom/google/android/gms/internal/measurement/zzgo;",
            ">(TContainingType;I)",
            "Lcom/google/android/gms/internal/measurement/zzfd$zzf<",
            "TContainingType;*>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/gms/internal/measurement/zzeq;->zzf:Ljava/util/Map;

    new-instance v1, Lcom/google/android/gms/internal/measurement/zzeq$zza;

    invoke-direct {v1, p1, p2}, Lcom/google/android/gms/internal/measurement/zzeq$zza;-><init>(Ljava/lang/Object;I)V

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/internal/measurement/zzfd$zzf;

    return-object p1
.end method
