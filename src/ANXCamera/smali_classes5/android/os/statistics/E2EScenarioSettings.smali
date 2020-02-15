.class public final Landroid/os/statistics/E2EScenarioSettings;
.super Ljava/lang/Object;
.source "E2EScenarioSettings.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Ljava/lang/Cloneable;
.implements Ljava/io/Serializable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Landroid/os/statistics/E2EScenarioSettings;",
            ">;"
        }
    .end annotation
.end field

.field public static final STATISTICS_MODE_ALL:I = 0x7

.field public static final STATISTICS_MODE_AVERAGE:I = 0x1

.field public static final STATISTICS_MODE_DISTRIBUTION:I = 0x4

.field public static final STATISTICS_MODE_HISTORY:I = 0x2

.field public static final STATISTICS_MODE_NONE:I = 0x0

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field public historyLimitPerDay:I

.field public isAutoAnalysisEnabled:Z

.field public slownessFloorThresholdMillis:I

.field public statisticsMode:I

.field public timeoutMillisOfAutoAnalysis:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Landroid/os/statistics/E2EScenarioSettings$1;

    invoke-direct {v0}, Landroid/os/statistics/E2EScenarioSettings$1;-><init>()V

    sput-object v0, Landroid/os/statistics/E2EScenarioSettings;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/os/statistics/E2EScenarioSettings;->statisticsMode:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/os/statistics/E2EScenarioSettings;->historyLimitPerDay:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-boolean v0, p0, Landroid/os/statistics/E2EScenarioSettings;->isAutoAnalysisEnabled:Z

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/os/statistics/E2EScenarioSettings;->slownessFloorThresholdMillis:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/os/statistics/E2EScenarioSettings;->timeoutMillisOfAutoAnalysis:I

    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 2

    new-instance v0, Landroid/os/statistics/E2EScenarioSettings;

    invoke-direct {v0}, Landroid/os/statistics/E2EScenarioSettings;-><init>()V

    iget v1, p0, Landroid/os/statistics/E2EScenarioSettings;->statisticsMode:I

    iput v1, v0, Landroid/os/statistics/E2EScenarioSettings;->statisticsMode:I

    iget v1, p0, Landroid/os/statistics/E2EScenarioSettings;->historyLimitPerDay:I

    iput v1, v0, Landroid/os/statistics/E2EScenarioSettings;->historyLimitPerDay:I

    iget-boolean v1, p0, Landroid/os/statistics/E2EScenarioSettings;->isAutoAnalysisEnabled:Z

    iput-boolean v1, v0, Landroid/os/statistics/E2EScenarioSettings;->isAutoAnalysisEnabled:Z

    iget v1, p0, Landroid/os/statistics/E2EScenarioSettings;->slownessFloorThresholdMillis:I

    iput v1, v0, Landroid/os/statistics/E2EScenarioSettings;->slownessFloorThresholdMillis:I

    iget v1, p0, Landroid/os/statistics/E2EScenarioSettings;->timeoutMillisOfAutoAnalysis:I

    iput v1, v0, Landroid/os/statistics/E2EScenarioSettings;->timeoutMillisOfAutoAnalysis:I

    return-object v0
.end method

.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public enableAutoAnalysis(II)V
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/os/statistics/E2EScenarioSettings;->isAutoAnalysisEnabled:Z

    iput p1, p0, Landroid/os/statistics/E2EScenarioSettings;->slownessFloorThresholdMillis:I

    iput p2, p0, Landroid/os/statistics/E2EScenarioSettings;->timeoutMillisOfAutoAnalysis:I

    return-void
.end method

.method public isValid()Z
    .locals 1

    iget-boolean v0, p0, Landroid/os/statistics/E2EScenarioSettings;->isAutoAnalysisEnabled:Z

    if-eqz v0, :cond_0

    iget v0, p0, Landroid/os/statistics/E2EScenarioSettings;->slownessFloorThresholdMillis:I

    if-gtz v0, :cond_0

    const/4 v0, 0x0

    return v0

    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public setHistoryLimitPerDay(I)V
    .locals 0

    iput p1, p0, Landroid/os/statistics/E2EScenarioSettings;->historyLimitPerDay:I

    return-void
.end method

.method public setStatisticsMode(I)V
    .locals 0

    iput p1, p0, Landroid/os/statistics/E2EScenarioSettings;->statisticsMode:I

    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    iget v0, p0, Landroid/os/statistics/E2EScenarioSettings;->statisticsMode:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/os/statistics/E2EScenarioSettings;->historyLimitPerDay:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-boolean v0, p0, Landroid/os/statistics/E2EScenarioSettings;->isAutoAnalysisEnabled:Z

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/os/statistics/E2EScenarioSettings;->slownessFloorThresholdMillis:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/os/statistics/E2EScenarioSettings;->timeoutMillisOfAutoAnalysis:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    return-void
.end method
