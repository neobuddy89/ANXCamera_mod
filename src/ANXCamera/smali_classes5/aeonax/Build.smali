.class public Laeonax/Build;
.super Lmiui/os/Build;
.source "Build.java"

# static fields

.field public static final ANXDEVICE:Ljava/lang/String;
.field public static final ANXMODEL:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    invoke-static {}, Lmiui/external/SdkHelper;->isMiuiSystem()Z

    move-result v0

    if-eqz v0, :cond_0


    const-string v1, "ro.product.device"

    invoke-static {v1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;
    
    move-result-object v1

    sput-object v1, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    

    const-string v1, "ro.product.model"

    invoke-static {v1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;
    
    move-result-object v1

    sput-object v1, Laeonax/Build;->ANXMODEL:Ljava/lang/String;
    
    return-void
    :cond_0
    
    const-string v1, "ro.product.vendor.device"

    invoke-static {v1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;
    
    move-result-object v1

    sput-object v1, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;
    
    
    const-string v1, "ro.product.vendor.model"

    invoke-static {v1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;
    
    move-result-object v1

    sput-object v1, Laeonax/Build;->ANXMODEL:Ljava/lang/String;

    return-void

.end method
