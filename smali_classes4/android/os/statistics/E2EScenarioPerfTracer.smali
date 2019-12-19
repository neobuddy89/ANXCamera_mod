.class public final Landroid/os/statistics/E2EScenarioPerfTracer;
.super Ljava/lang/Object;
.source "E2EScenarioPerfTracer.java"


# static fields
.field private static final VERSION:I = 0x1

.field private static final executor:Ljava/util/concurrent/ThreadPoolExecutor;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    new-instance v7, Ljava/util/concurrent/ThreadPoolExecutor;

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    const/4 v1, 0x1

    const/4 v2, 0x1

    const-wide/16 v3, 0x0

    move-object v0, v7

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    sput-object v7, Landroid/os/statistics/E2EScenarioPerfTracer;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static abortScenario(Landroid/os/Bundle;)V
    .locals 12

    if-nez p0, :cond_0

    return-void

    :cond_0
    invoke-static {}, Lcom/miui/daemon/performance/PerfShielderManager;->getService()Lcom/android/internal/app/IPerfShielder;

    move-result-object v6

    if-nez v6, :cond_1

    return-void

    :cond_1
    invoke-static {}, Landroid/os/Process;->myTid()I

    move-result v7

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v8

    sget-object v10, Landroid/os/statistics/E2EScenarioPerfTracer;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v11, Landroid/os/statistics/E2EScenarioPerfTracer$3;

    move-object v0, v11

    move-object v1, v6

    move-object v2, p0

    move v3, v7

    move-wide v4, v8

    invoke-direct/range {v0 .. v5}, Landroid/os/statistics/E2EScenarioPerfTracer$3;-><init>(Lcom/android/internal/app/IPerfShielder;Landroid/os/Bundle;IJ)V

    invoke-virtual {v10, v11}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method public static abortScenario(Landroid/os/statistics/E2EScenario;)V
    .locals 1

    const-string v0, ""

    invoke-static {p0, v0}, Landroid/os/statistics/E2EScenarioPerfTracer;->abortScenario(Landroid/os/statistics/E2EScenario;Ljava/lang/String;)V

    return-void
.end method

.method public static abortScenario(Landroid/os/statistics/E2EScenario;Ljava/lang/String;)V
    .locals 13

    if-eqz p0, :cond_2

    invoke-virtual {p0}, Landroid/os/statistics/E2EScenario;->isValid()Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    invoke-static {}, Lcom/miui/daemon/performance/PerfShielderManager;->getService()Lcom/android/internal/app/IPerfShielder;

    move-result-object v0

    if-nez v0, :cond_1

    return-void

    :cond_1
    invoke-static {}, Landroid/os/Process;->myTid()I

    move-result v8

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v9

    sget-object v11, Landroid/os/statistics/E2EScenarioPerfTracer;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v12, Landroid/os/statistics/E2EScenarioPerfTracer$2;

    move-object v1, v12

    move-object v2, v0

    move-object v3, p0

    move-object v4, p1

    move v5, v8

    move-wide v6, v9

    invoke-direct/range {v1 .. v7}, Landroid/os/statistics/E2EScenarioPerfTracer$2;-><init>(Lcom/android/internal/app/IPerfShielder;Landroid/os/statistics/E2EScenario;Ljava/lang/String;IJ)V

    invoke-virtual {v11, v12}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    return-void

    :cond_2
    :goto_0
    return-void
.end method

.method public static asyncBeginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;)V
    .locals 2

    const-string v0, ""

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Landroid/os/statistics/E2EScenarioPerfTracer;->asyncBeginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)V

    return-void
.end method

.method public static asyncBeginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Landroid/os/statistics/E2EScenarioPayload;)V
    .locals 1

    const-string v0, ""

    invoke-static {p0, p1, v0, p2}, Landroid/os/statistics/E2EScenarioPerfTracer;->asyncBeginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)V

    return-void
.end method

.method public static asyncBeginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;)V
    .locals 1

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Landroid/os/statistics/E2EScenarioPerfTracer;->asyncBeginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)V

    return-void
.end method

.method public static asyncBeginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)V
    .locals 15

    if-eqz p0, :cond_4

    invoke-virtual {p0}, Landroid/os/statistics/E2EScenario;->isValid()Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_1

    :cond_0
    if-eqz p1, :cond_3

    invoke-virtual/range {p1 .. p1}, Landroid/os/statistics/E2EScenarioSettings;->isValid()Z

    move-result v0

    if-nez v0, :cond_1

    goto :goto_0

    :cond_1
    invoke-static {}, Lcom/miui/daemon/performance/PerfShielderManager;->getService()Lcom/android/internal/app/IPerfShielder;

    move-result-object v9

    if-nez v9, :cond_2

    return-void

    :cond_2
    invoke-static {}, Landroid/os/Process;->myTid()I

    move-result v10

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v11

    sget-object v13, Landroid/os/statistics/E2EScenarioPerfTracer;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v14, Landroid/os/statistics/E2EScenarioPerfTracer$1;

    move-object v0, v14

    move-object v1, v9

    move-object v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move v6, v10

    move-wide v7, v11

    invoke-direct/range {v0 .. v8}, Landroid/os/statistics/E2EScenarioPerfTracer$1;-><init>(Lcom/android/internal/app/IPerfShielder;Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;IJ)V

    invoke-virtual {v13, v14}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    return-void

    :cond_3
    :goto_0
    return-void

    :cond_4
    :goto_1
    return-void
.end method

.method public static beginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;)Landroid/os/Bundle;
    .locals 2

    const-string v0, ""

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Landroid/os/statistics/E2EScenarioPerfTracer;->beginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public static beginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Landroid/os/statistics/E2EScenarioPayload;)Landroid/os/Bundle;
    .locals 1

    const-string v0, ""

    invoke-static {p0, p1, v0, p2}, Landroid/os/statistics/E2EScenarioPerfTracer;->beginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public static beginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 1

    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Landroid/os/statistics/E2EScenarioPerfTracer;->beginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public static beginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)Landroid/os/Bundle;
    .locals 11

    const/4 v0, 0x0

    if-eqz p0, :cond_4

    invoke-virtual {p0}, Landroid/os/statistics/E2EScenario;->isValid()Z

    move-result v1

    if-nez v1, :cond_0

    goto :goto_1

    :cond_0
    if-eqz p1, :cond_3

    invoke-virtual {p1}, Landroid/os/statistics/E2EScenarioSettings;->isValid()Z

    move-result v1

    if-nez v1, :cond_1

    goto :goto_0

    :cond_1
    invoke-static {}, Lcom/miui/daemon/performance/PerfShielderManager;->getService()Lcom/android/internal/app/IPerfShielder;

    move-result-object v1

    if-nez v1, :cond_2

    return-object v0

    :cond_2
    :try_start_0
    invoke-static {}, Landroid/os/Process;->myTid()I

    move-result v7

    const-wide/16 v8, 0x0

    const/4 v10, 0x1

    move-object v2, v1

    move-object v3, p0

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    invoke-interface/range {v2 .. v10}, Lcom/android/internal/app/IPerfShielder;->beginScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioSettings;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;IJZ)Landroid/os/Bundle;

    move-result-object v0
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v2

    return-object v0

    :cond_3
    :goto_0
    return-object v0

    :cond_4
    :goto_1
    return-object v0
.end method

.method public static finishScenario(Landroid/os/Bundle;)V
    .locals 1

    const/4 v0, 0x0

    invoke-static {p0, v0}, Landroid/os/statistics/E2EScenarioPerfTracer;->finishScenario(Landroid/os/Bundle;Landroid/os/statistics/E2EScenarioPayload;)V

    return-void
.end method

.method public static finishScenario(Landroid/os/Bundle;Landroid/os/statistics/E2EScenarioPayload;)V
    .locals 13

    if-nez p0, :cond_0

    return-void

    :cond_0
    invoke-static {}, Lcom/miui/daemon/performance/PerfShielderManager;->getService()Lcom/android/internal/app/IPerfShielder;

    move-result-object v7

    if-nez v7, :cond_1

    return-void

    :cond_1
    invoke-static {}, Landroid/os/Process;->myTid()I

    move-result v8

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v9

    sget-object v11, Landroid/os/statistics/E2EScenarioPerfTracer;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v12, Landroid/os/statistics/E2EScenarioPerfTracer$5;

    move-object v0, v12

    move-object v1, v7

    move-object v2, p0

    move-object v3, p1

    move v4, v8

    move-wide v5, v9

    invoke-direct/range {v0 .. v6}, Landroid/os/statistics/E2EScenarioPerfTracer$5;-><init>(Lcom/android/internal/app/IPerfShielder;Landroid/os/Bundle;Landroid/os/statistics/E2EScenarioPayload;IJ)V

    invoke-virtual {v11, v12}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    return-void
.end method

.method public static finishScenario(Landroid/os/statistics/E2EScenario;)V
    .locals 2

    const-string v0, ""

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroid/os/statistics/E2EScenarioPerfTracer;->finishScenario(Landroid/os/statistics/E2EScenario;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)V

    return-void
.end method

.method public static finishScenario(Landroid/os/statistics/E2EScenario;Landroid/os/statistics/E2EScenarioPayload;)V
    .locals 1

    const-string v0, ""

    invoke-static {p0, v0, p1}, Landroid/os/statistics/E2EScenarioPerfTracer;->finishScenario(Landroid/os/statistics/E2EScenario;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)V

    return-void
.end method

.method public static finishScenario(Landroid/os/statistics/E2EScenario;Ljava/lang/String;)V
    .locals 1

    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Landroid/os/statistics/E2EScenarioPerfTracer;->finishScenario(Landroid/os/statistics/E2EScenario;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)V

    return-void
.end method

.method public static finishScenario(Landroid/os/statistics/E2EScenario;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;)V
    .locals 14

    if-eqz p0, :cond_2

    invoke-virtual {p0}, Landroid/os/statistics/E2EScenario;->isValid()Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    invoke-static {}, Lcom/miui/daemon/performance/PerfShielderManager;->getService()Lcom/android/internal/app/IPerfShielder;

    move-result-object v8

    if-nez v8, :cond_1

    return-void

    :cond_1
    invoke-static {}, Landroid/os/Process;->myTid()I

    move-result v9

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v10

    sget-object v12, Landroid/os/statistics/E2EScenarioPerfTracer;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    new-instance v13, Landroid/os/statistics/E2EScenarioPerfTracer$4;

    move-object v0, v13

    move-object v1, v8

    move-object v2, p0

    move-object v3, p1

    move-object/from16 v4, p2

    move v5, v9

    move-wide v6, v10

    invoke-direct/range {v0 .. v7}, Landroid/os/statistics/E2EScenarioPerfTracer$4;-><init>(Lcom/android/internal/app/IPerfShielder;Landroid/os/statistics/E2EScenario;Ljava/lang/String;Landroid/os/statistics/E2EScenarioPayload;IJ)V

    invoke-virtual {v12, v13}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    return-void

    :cond_2
    :goto_0
    return-void
.end method

.method public static getVersion()I
    .locals 1

    const/4 v0, 0x1

    return v0
.end method
