.class public Lcom/xiaomi/stat/b/e;
.super Ljava/lang/Object;


# static fields
.field private static final a:Ljava/lang/Object;

.field private static volatile b:Lcom/xiaomi/stat/b/e;

.field private static volatile c:Ljava/util/concurrent/ExecutorService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/xiaomi/stat/b/e;->a:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a()Lcom/xiaomi/stat/b/e;
    .locals 2

    sget-object v0, Lcom/xiaomi/stat/b/e;->b:Lcom/xiaomi/stat/b/e;

    if-nez v0, :cond_1

    sget-object v0, Lcom/xiaomi/stat/b/e;->a:Ljava/lang/Object;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/xiaomi/stat/b/e;->b:Lcom/xiaomi/stat/b/e;

    if-nez v1, :cond_0

    new-instance v1, Lcom/xiaomi/stat/b/e;

    invoke-direct {v1}, Lcom/xiaomi/stat/b/e;-><init>()V

    sput-object v1, Lcom/xiaomi/stat/b/e;->b:Lcom/xiaomi/stat/b/e;

    :cond_0
    monitor-exit v0

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_1
    :goto_0
    sget-object v0, Lcom/xiaomi/stat/b/e;->b:Lcom/xiaomi/stat/b/e;

    return-object v0
.end method


# virtual methods
.method public declared-synchronized b()Ljava/util/concurrent/ExecutorService;
    .locals 1

    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/xiaomi/stat/b/e;->c:Ljava/util/concurrent/ExecutorService;

    if-nez v0, :cond_0

    invoke-static {}, Ljava/util/concurrent/Executors;->newCachedThreadPool()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/stat/b/e;->c:Ljava/util/concurrent/ExecutorService;

    :cond_0
    sget-object v0, Lcom/xiaomi/stat/b/e;->c:Ljava/util/concurrent/ExecutorService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
