.class Lcom/xiaomi/stat/c/h;
.super Landroid/content/BroadcastReceiver;


# instance fields
.field final synthetic a:Lcom/xiaomi/stat/c/g;


# direct methods
.method constructor <init>(Lcom/xiaomi/stat/c/g;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/stat/c/h;->a:Lcom/xiaomi/stat/c/g;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    invoke-static {}, Lcom/xiaomi/stat/d/r;->b()J

    move-result-wide p1

    iget-object v0, p0, Lcom/xiaomi/stat/c/h;->a:Lcom/xiaomi/stat/c/g;

    invoke-static {v0}, Lcom/xiaomi/stat/c/g;->a(Lcom/xiaomi/stat/c/g;)J

    move-result-wide v0

    sub-long/2addr p1, v0

    iget-object v0, p0, Lcom/xiaomi/stat/c/h;->a:Lcom/xiaomi/stat/c/g;

    invoke-static {v0}, Lcom/xiaomi/stat/c/g;->b(Lcom/xiaomi/stat/c/g;)I

    move-result v0

    int-to-long v0, v0

    cmp-long p1, p1, v0

    if-lez p1, :cond_0

    const/4 p1, 0x1

    goto :goto_0

    :cond_0
    const/4 p1, 0x0

    :goto_0
    invoke-static {}, Lcom/xiaomi/stat/d/l;->a()Z

    move-result p2

    if-eqz p2, :cond_1

    iget-object p2, p0, Lcom/xiaomi/stat/c/h;->a:Lcom/xiaomi/stat/c/g;

    invoke-static {p2}, Lcom/xiaomi/stat/c/g;->c(Lcom/xiaomi/stat/c/g;)Z

    move-result p2

    if-eqz p2, :cond_1

    if-eqz p1, :cond_1

    iget-object p1, p0, Lcom/xiaomi/stat/c/h;->a:Lcom/xiaomi/stat/c/g;

    invoke-virtual {p1}, Lcom/xiaomi/stat/c/g;->b()V

    iget-object p0, p0, Lcom/xiaomi/stat/c/h;->a:Lcom/xiaomi/stat/c/g;

    invoke-static {}, Lcom/xiaomi/stat/d/r;->b()J

    move-result-wide p1

    invoke-static {p0, p1, p2}, Lcom/xiaomi/stat/c/g;->a(Lcom/xiaomi/stat/c/g;J)J

    :cond_1
    return-void
.end method
