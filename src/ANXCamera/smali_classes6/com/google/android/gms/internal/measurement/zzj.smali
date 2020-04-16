.class public final Lcom/google/android/gms/internal/measurement/zzj;
.super Landroid/os/Handler;
.source "com.google.android.gms:play-services-measurement-impl@@17.3.0"


# static fields
.field private static zza:Lcom/google/android/gms/internal/measurement/zzi;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcom/google/android/gms/internal/measurement/zzj;->zza:Lcom/google/android/gms/internal/measurement/zzi;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/os/Looper;)V
    .locals 0

    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public final dispatchMessage(Landroid/os/Message;)V
    .locals 0

    nop

    invoke-super {p0, p1}, Landroid/os/Handler;->dispatchMessage(Landroid/os/Message;)V

    return-void
.end method
