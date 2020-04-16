.class public Lcom/google/android/gms/measurement/module/Analytics;
.super Ljava/lang/Object;
.source "com.google.android.gms:play-services-measurement-impl@@17.3.0"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/measurement/module/Analytics$Param;,
        Lcom/google/android/gms/measurement/module/Analytics$Event;
    }
.end annotation


# static fields
.field public static final CRASH_ORIGIN:Ljava/lang/String; = "crash"

.field public static final FCM_ORIGIN:Ljava/lang/String; = "fcm"

.field public static final FIAM_ORIGIN:Ljava/lang/String; = "fiam"

.field private static volatile zza:Lcom/google/android/gms/measurement/module/Analytics;


# instance fields
.field private final zzb:Lcom/google/android/gms/measurement/internal/zzgq;


# direct methods
.method private constructor <init>(Lcom/google/android/gms/measurement/internal/zzgq;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    iput-object p1, p0, Lcom/google/android/gms/measurement/module/Analytics;->zzb:Lcom/google/android/gms/measurement/internal/zzgq;

    return-void
.end method

.method public static getInstance(Landroid/content/Context;)Lcom/google/android/gms/measurement/module/Analytics;
    .locals 2

    sget-object v0, Lcom/google/android/gms/measurement/module/Analytics;->zza:Lcom/google/android/gms/measurement/module/Analytics;

    if-nez v0, :cond_1

    const-class v0, Lcom/google/android/gms/measurement/module/Analytics;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/google/android/gms/measurement/module/Analytics;->zza:Lcom/google/android/gms/measurement/module/Analytics;

    if-nez v1, :cond_0

    nop

    const/4 v1, 0x0

    invoke-static {p0, v1}, Lcom/google/android/gms/measurement/internal/zzgq;->zza(Landroid/content/Context;Lcom/google/android/gms/internal/measurement/zzv;)Lcom/google/android/gms/measurement/internal/zzgq;

    move-result-object p0

    nop

    new-instance v1, Lcom/google/android/gms/measurement/module/Analytics;

    invoke-direct {v1, p0}, Lcom/google/android/gms/measurement/module/Analytics;-><init>(Lcom/google/android/gms/measurement/internal/zzgq;)V

    sput-object v1, Lcom/google/android/gms/measurement/module/Analytics;->zza:Lcom/google/android/gms/measurement/module/Analytics;

    :cond_0
    monitor-exit v0

    goto :goto_0

    :catchall_0
    move-exception p0

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw p0

    :cond_1
    :goto_0
    sget-object p0, Lcom/google/android/gms/measurement/module/Analytics;->zza:Lcom/google/android/gms/measurement/module/Analytics;

    return-object p0
.end method
