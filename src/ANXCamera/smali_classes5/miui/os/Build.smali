.class public Lmiui/os/Build;
.super Landroid/os/Build;
.source "Build.java"


# static fields


.field public static final HAS_CUST_PARTITION:Z

.field public static final IS_ALPHA_BUILD:Z

.field public static final IS_CDMA:Z

.field public static final IS_CM_COOPERATION:Z

.field public static final IS_CM_CUSTOMIZATION:Z

.field public static final IS_CM_CUSTOMIZATION_TEST:Z

.field public static final IS_CTA_BUILD:Z = false

.field public static final IS_CTS_BUILD:Z

.field public static final IS_CT_CUSTOMIZATION:Z

.field public static final IS_CT_CUSTOMIZATION_TEST:Z

.field public static final IS_CU_CUSTOMIZATION:Z

.field public static final IS_CU_CUSTOMIZATION_TEST:Z

.field public static final IS_DEBUGGABLE:Z

.field public static final IS_DEVELOPMENT_VERSION:Z

.field public static final IS_FUNCTION_LIMITED:Z

.field public static final IS_GLOBAL_BUILD:Z

.field public static final IS_HONGMI:Z

.field public static final IS_HONGMI2_TDSCDMA:Z

.field public static final IS_HONGMI_THREE:Z

.field public static final IS_HONGMI_THREEX:Z

.field public static final IS_HONGMI_THREEX_CM:Z

.field public static final IS_HONGMI_THREEX_CT:Z

.field public static final IS_HONGMI_THREEX_CU:Z

.field public static final IS_HONGMI_THREE_LTE:Z

.field public static final IS_HONGMI_THREE_LTE_CM:Z

.field public static final IS_HONGMI_THREE_LTE_CU:Z

.field public static final IS_HONGMI_TWO:Z

.field public static final IS_HONGMI_TWOS_LTE_MTK:Z

.field public static final IS_HONGMI_TWOX:Z

.field public static final IS_HONGMI_TWOX_BR:Z

.field public static final IS_HONGMI_TWOX_CM:Z

.field public static final IS_HONGMI_TWOX_CT:Z

.field public static final IS_HONGMI_TWOX_CU:Z

.field public static final IS_HONGMI_TWOX_IN:Z

.field public static final IS_HONGMI_TWOX_LC:Z

.field public static final IS_HONGMI_TWOX_SA:Z

.field public static final IS_HONGMI_TWO_A:Z

.field public static final IS_HONGMI_TWO_S:Z

.field public static final IS_INTERNATIONAL_BUILD:Z

.field public static final IS_MI1S:Z

.field public static final IS_MI2A:Z

.field public static final IS_MIFIVE:Z

.field public static final IS_MIFOUR:Z

.field public static final IS_MIFOUR_CDMA:Z

.field public static final IS_MIFOUR_LTE_CM:Z

.field public static final IS_MIFOUR_LTE_CT:Z

.field public static final IS_MIFOUR_LTE_CU:Z

.field public static final IS_MIFOUR_LTE_INDIA:Z

.field public static final IS_MIFOUR_LTE_SEASA:Z

.field public static final IS_MIONE:Z

.field public static final IS_MIONE_CDMA:Z

.field public static final IS_MIPAD:Z

.field public static final IS_MITHREE:Z

.field public static final IS_MITHREE_CDMA:Z

.field public static final IS_MITHREE_TDSCDMA:Z

.field public static final IS_MITWO:Z

.field public static final IS_MITWO_CDMA:Z

.field public static final IS_MITWO_TDSCDMA:Z

.field public static final IS_MIUI:Z

.field public static final IS_N7:Z

.field public static final IS_OFFICIAL_VERSION:Z

.field public static final IS_PRIVATE_BUILD:Z

.field public static final IS_PRIVATE_WATER_MARKER:Z

.field public static final IS_PRO_DEVICE:Z

.field public static final IS_STABLE_VERSION:Z

.field public static final IS_TABLET:Z

.field public static final IS_TDS_CDMA:Z

.field public static final IS_XIAOMI:Z

.field private static final PROP_MIUI_VERSION_CODE:Ljava/lang/String; = "ro.miui.ui.version.code"

.field private static final REGULAR_EXPRESSION_FOR_DEVELOPMENT:Ljava/lang/String; = "\\d+(.\\d+){2,}(-internal)?"

.field private static final REGULAR_EXPRESSION_FOR_STABLE:Ljava/lang/String; = "^V(\\d+.)+([A-Z]+\\d{0,}.?)+(\\d+.?){0,}$"

.field public static final USERDATA_IMAGE_VERSION_CODE:Ljava/lang/String;

.field public static final USER_MODE:Ljava/lang/String; = "persist.sys.user_mode"

.field public static final USER_MODE_ELDER:I = 0x1

.field public static final USER_MODE_NORMAL:I


# direct methods
.method static constructor <clinit>()V
    .locals 10

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v1, "mione"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-nez v0, :cond_1

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "mione_plus"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    move v0, v1

    goto :goto_1

    :cond_1
    :goto_0
    move v0, v2

    :goto_1
    sput-boolean v0, Lmiui/os/Build;->IS_MIONE:Z

    sget-object v0, Laeonax/Build;->ANXMODEL:Ljava/lang/String;

    const-string v3, "MI 1S"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Laeonax/Build;->ANXMODEL:Ljava/lang/String;

    const-string v3, "MI 1SC"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    goto :goto_2

    :cond_2
    move v0, v1

    goto :goto_3

    :cond_3
    :goto_2
    move v0, v2

    :goto_3
    sput-boolean v0, Lmiui/os/Build;->IS_MI1S:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "aries"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "taurus"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "taurus_td"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    goto :goto_4

    :cond_4
    move v0, v1

    goto :goto_5

    :cond_5
    :goto_4
    move v0, v2

    :goto_5
    sput-boolean v0, Lmiui/os/Build;->IS_MITWO:Z

    sget-object v0, Laeonax/Build;->ANXMODEL:Ljava/lang/String;

    const-string v3, "MI 2A"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    sget-object v0, Laeonax/Build;->ANXMODEL:Ljava/lang/String;

    const-string v3, "MI 2A TD"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    goto :goto_6

    :cond_6
    move v0, v1

    goto :goto_7

    :cond_7
    :goto_6
    move v0, v2

    :goto_7
    sput-boolean v0, Lmiui/os/Build;->IS_MI2A:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "pisces"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const-string v3, "cancro"

    if-nez v0, :cond_9

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    sget-object v0, Laeonax/Build;->ANXMODEL:Ljava/lang/String;

    const-string v4, "MI 3"

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    goto :goto_8

    :cond_8
    move v0, v1

    goto :goto_9

    :cond_9
    :goto_8
    move v0, v2

    :goto_9
    sput-boolean v0, Lmiui/os/Build;->IS_MITHREE:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    sget-object v0, Laeonax/Build;->ANXMODEL:Ljava/lang/String;

    const-string v3, "MI 4"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_a

    move v0, v2

    goto :goto_a

    :cond_a
    move v0, v1

    :goto_a
    sput-boolean v0, Lmiui/os/Build;->IS_MIFOUR:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "virgo"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_MIFIVE:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MIONE:Z

    if-nez v0, :cond_c

    sget-boolean v0, Lmiui/os/Build;->IS_MITWO:Z

    if-nez v0, :cond_c

    sget-boolean v0, Lmiui/os/Build;->IS_MITHREE:Z

    if-nez v0, :cond_c

    sget-boolean v0, Lmiui/os/Build;->IS_MIFOUR:Z

    if-nez v0, :cond_c

    sget-boolean v0, Lmiui/os/Build;->IS_MIFIVE:Z

    if-eqz v0, :cond_b

    goto :goto_b

    :cond_b
    move v0, v1

    goto :goto_c

    :cond_c
    :goto_b
    move v0, v2

    :goto_c
    sput-boolean v0, Lmiui/os/Build;->IS_XIAOMI:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "mocha"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_MIPAD:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "flo"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_N7:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "armani"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWO_A:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "HM2014011"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_e

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "HM2014012"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    goto :goto_d

    :cond_d
    move v0, v1

    goto :goto_e

    :cond_e
    :goto_d
    move v0, v2

    :goto_e
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWO_S:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "HM2014501"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOS_LTE_MTK:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v3, "HM2013022"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "HM2013023"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWO_A:Z

    if-nez v0, :cond_10

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWO_S:Z

    if-eqz v0, :cond_f

    goto :goto_f

    :cond_f
    move v0, v1

    goto :goto_10

    :cond_10
    :goto_f
    move v0, v2

    :goto_10
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWO:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "lcsh92_wet_jb9"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_12

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "lcsh92_wet_tdd"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    goto :goto_11

    :cond_11
    move v0, v1

    goto :goto_12

    :cond_12
    :goto_11
    move v0, v2

    :goto_12
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREE:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "dior"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREE_LTE:Z

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREE_LTE:Z

    const-string v4, "ro.boot.modem"

    if-eqz v0, :cond_13

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v5, "LTETD"

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    move v0, v2

    goto :goto_13

    :cond_13
    move v0, v1

    :goto_13
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREE_LTE_CM:Z

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREE_LTE:Z

    if-eqz v0, :cond_14

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v4, "LTEW"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_14

    move v0, v2

    goto :goto_14

    :cond_14
    move v0, v1

    :goto_14
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREE_LTE_CU:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "HM2014811"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_CU:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "HM2014812"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_16

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "HM2014821"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_15

    goto :goto_15

    :cond_15
    move v0, v1

    goto :goto_16

    :cond_16
    :goto_15
    move v0, v2

    :goto_16
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_CT:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "HM2014813"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_18

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "HM2014112"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_17

    goto :goto_17

    :cond_17
    move v0, v1

    goto :goto_18

    :cond_18
    :goto_17
    move v0, v2

    :goto_18
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_CM:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "HM2014818"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_IN:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "HM2014817"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_SA:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "HM2014819"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_BR:Z

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_CU:Z

    if-nez v0, :cond_1a

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_CT:Z

    if-nez v0, :cond_1a

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_CM:Z

    if-nez v0, :cond_1a

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_IN:Z

    if-nez v0, :cond_1a

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_SA:Z

    if-nez v0, :cond_1a

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_BR:Z

    if-eqz v0, :cond_19

    goto :goto_19

    :cond_19
    move v0, v1

    goto :goto_1a

    :cond_1a
    :goto_19
    move v0, v2

    :goto_1a
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "lte26007"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_LC:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    const-string v4, "gucci"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREEX:Z

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREEX:Z

    const-string v4, "persist.sys.modem"

    const-string v5, "cm"

    if-eqz v0, :cond_1b

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1b

    move v0, v2

    goto :goto_1b

    :cond_1b
    move v0, v1

    :goto_1b
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREEX_CM:Z

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREEX:Z

    const-string v6, "cu"

    if-eqz v0, :cond_1c

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1c

    move v0, v2

    goto :goto_1c

    :cond_1c
    move v0, v1

    :goto_1c
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREEX_CU:Z

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREEX:Z

    const-string v7, "ct"

    if-eqz v0, :cond_1d

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1d

    move v0, v2

    goto :goto_1d

    :cond_1d
    move v0, v1

    :goto_1d
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREEX_CT:Z

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWO:Z

    if-nez v0, :cond_1f

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREE:Z

    if-nez v0, :cond_1f

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX:Z

    if-nez v0, :cond_1f

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREE_LTE:Z

    if-nez v0, :cond_1f

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOX_LC:Z

    if-nez v0, :cond_1f

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_TWOS_LTE_MTK:Z

    if-nez v0, :cond_1f

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI_THREEX:Z

    if-eqz v0, :cond_1e

    goto :goto_1e

    :cond_1e
    move v0, v1

    goto :goto_1f

    :cond_1f
    :goto_1e
    move v0, v2

    :goto_1f
    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MIONE:Z

    if-eqz v0, :cond_20

    invoke-static {}, Lmiui/os/Build;->hasMsm8660Property()Z

    move-result v0

    if-eqz v0, :cond_20

    move v0, v2

    goto :goto_20

    :cond_20
    move v0, v1

    :goto_20
    sput-boolean v0, Lmiui/os/Build;->IS_MIONE_CDMA:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MITWO:Z

    const-string v4, "persist.radio.modem"

    if-eqz v0, :cond_21

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "CDMA"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_21

    move v0, v2

    goto :goto_21

    :cond_21
    move v0, v1

    :goto_21
    sput-boolean v0, Lmiui/os/Build;->IS_MITWO_CDMA:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MITHREE:Z

    if-eqz v0, :cond_22

    sget-object v0, Laeonax/Build;->ANXMODEL:Ljava/lang/String;

    const-string v8, "MI 3C"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_22

    move v0, v2

    goto :goto_22

    :cond_22
    move v0, v1

    :goto_22
    sput-boolean v0, Lmiui/os/Build;->IS_MITHREE_CDMA:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MIFOUR:Z

    if-eqz v0, :cond_23

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "CDMA"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_23

    move v0, v2

    goto :goto_23

    :cond_23
    move v0, v1

    :goto_23
    sput-boolean v0, Lmiui/os/Build;->IS_MIFOUR_CDMA:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MITWO:Z

    if-eqz v0, :cond_24

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "TD"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_24

    move v0, v2

    goto :goto_24

    :cond_24
    move v0, v1

    :goto_24
    sput-boolean v0, Lmiui/os/Build;->IS_MITWO_TDSCDMA:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MITHREE:Z

    if-eqz v0, :cond_25

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "TD"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_25

    move v0, v2

    goto :goto_25

    :cond_25
    move v0, v1

    :goto_25
    sput-boolean v0, Lmiui/os/Build;->IS_MITHREE_TDSCDMA:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MIFOUR:Z

    if-eqz v0, :cond_26

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "LTE-CMCC"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_26

    move v0, v2

    goto :goto_26

    :cond_26
    move v0, v1

    :goto_26
    sput-boolean v0, Lmiui/os/Build;->IS_MIFOUR_LTE_CM:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MIFOUR:Z

    if-eqz v0, :cond_27

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "LTE-CU"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_27

    move v0, v2

    goto :goto_27

    :cond_27
    move v0, v1

    :goto_27
    sput-boolean v0, Lmiui/os/Build;->IS_MIFOUR_LTE_CU:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MIFOUR:Z

    if-eqz v0, :cond_28

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "LTE-CT"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_28

    move v0, v2

    goto :goto_28

    :cond_28
    move v0, v1

    :goto_28
    sput-boolean v0, Lmiui/os/Build;->IS_MIFOUR_LTE_CT:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MIFOUR:Z

    if-eqz v0, :cond_29

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v8, "LTE-India"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_29

    move v0, v2

    goto :goto_29

    :cond_29
    move v0, v1

    :goto_29
    sput-boolean v0, Lmiui/os/Build;->IS_MIFOUR_LTE_INDIA:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MIFOUR:Z

    if-eqz v0, :cond_2a

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v4, "LTE-SEAsa"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2a

    move v0, v2

    goto :goto_2a

    :cond_2a
    move v0, v1

    :goto_2a
    sput-boolean v0, Lmiui/os/Build;->IS_MIFOUR_LTE_SEASA:Z

    sget-object v0, Laeonax/Build;->ANXDEVICE:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_HONGMI2_TDSCDMA:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MIONE_CDMA:Z

    if-nez v0, :cond_2c

    sget-boolean v0, Lmiui/os/Build;->IS_MITWO_CDMA:Z

    if-nez v0, :cond_2c

    sget-boolean v0, Lmiui/os/Build;->IS_MITHREE_CDMA:Z

    if-nez v0, :cond_2c

    sget-boolean v0, Lmiui/os/Build;->IS_MIFOUR_CDMA:Z

    if-nez v0, :cond_2c

    sget-boolean v0, Lmiui/os/Build;->IS_MIFOUR_LTE_CT:Z

    if-eqz v0, :cond_2b

    goto :goto_2b

    :cond_2b
    move v0, v1

    goto :goto_2c

    :cond_2c
    :goto_2b
    move v0, v2

    :goto_2c
    sput-boolean v0, Lmiui/os/Build;->IS_CDMA:Z

    sget-boolean v0, Lmiui/os/Build;->IS_MITHREE_TDSCDMA:Z

    if-nez v0, :cond_2e

    sget-boolean v0, Lmiui/os/Build;->IS_HONGMI2_TDSCDMA:Z

    if-nez v0, :cond_2e

    sget-boolean v0, Lmiui/os/Build;->IS_MITWO_TDSCDMA:Z

    if-eqz v0, :cond_2d

    goto :goto_2d

    :cond_2d
    move v0, v1

    goto :goto_2e

    :cond_2e
    :goto_2d
    move v0, v2

    :goto_2e
    sput-boolean v0, Lmiui/os/Build;->IS_TDS_CDMA:Z

    nop

    const-string v0, "ro.carrier.name"

    invoke-static {v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    sput-boolean v3, Lmiui/os/Build;->IS_CU_CUSTOMIZATION:Z

    nop

    invoke-static {v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    const-string v4, "ro.miui.cust_variant"

    if-eqz v3, :cond_30

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v8, "cn_chinamobile"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2f

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v8, "cn_cta"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_30

    :cond_2f
    move v3, v2

    goto :goto_2f

    :cond_30
    move v3, v1

    :goto_2f
    sput-boolean v3, Lmiui/os/Build;->IS_CM_CUSTOMIZATION:Z

    nop

    invoke-static {v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_31

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "cn_cmcooperation"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_31

    move v3, v2

    goto :goto_30

    :cond_31
    move v3, v1

    :goto_30
    sput-boolean v3, Lmiui/os/Build;->IS_CM_COOPERATION:Z

    nop

    invoke-static {v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_CT_CUSTOMIZATION:Z

    sget-object v0, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_32

    sget-object v0, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    const-string v3, "\\d+(.\\d+){2,}(-internal)?"

    invoke-virtual {v0, v3}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_32

    move v0, v2

    goto :goto_31

    :cond_32
    move v0, v1

    :goto_31
    sput-boolean v0, Lmiui/os/Build;->IS_DEVELOPMENT_VERSION:Z

    sget-object v0, Lmiui/os/Build;->TYPE:Ljava/lang/String;

    const-string v3, "user"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_33

    sget-object v0, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_33

    sget-object v0, Landroid/os/Build$VERSION;->INCREMENTAL:Ljava/lang/String;

    const-string v3, "^V(\\d+.)+([A-Z]+\\d{0,}.?)+(\\d+.?){0,}$"

    invoke-virtual {v0, v3}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_33

    move v0, v2

    goto :goto_32

    :cond_33
    move v0, v1

    :goto_32
    sput-boolean v0, Lmiui/os/Build;->IS_STABLE_VERSION:Z

    sget-boolean v0, Lmiui/os/Build;->IS_DEVELOPMENT_VERSION:Z

    if-nez v0, :cond_35

    sget-boolean v0, Lmiui/os/Build;->IS_STABLE_VERSION:Z

    if-eqz v0, :cond_34

    goto :goto_33

    :cond_34
    move v0, v1

    goto :goto_34

    :cond_35
    :goto_33
    move v0, v2

    :goto_34
    sput-boolean v0, Lmiui/os/Build;->IS_OFFICIAL_VERSION:Z

    const-string v0, "ro.product.mod_device"

    const-string v3, ""

    invoke-static {v0, v3}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v8, "_alpha"

    invoke-virtual {v4, v8}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    sput-boolean v4, Lmiui/os/Build;->IS_ALPHA_BUILD:Z

    nop

    const-string v4, "ro.miui.cts"

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v8, "1"

    invoke-virtual {v8, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    xor-int/2addr v4, v2

    const-string v8, "persist.sys.miui_optimization"

    invoke-static {v8, v4}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    xor-int/2addr v4, v2

    sput-boolean v4, Lmiui/os/Build;->IS_CTS_BUILD:Z

    sget-boolean v4, Lcom/miui/internal/cust/PrivateConfig;->IS_PRIVATE_BUILD:Z

    sput-boolean v4, Lmiui/os/Build;->IS_PRIVATE_BUILD:Z

    sget-boolean v4, Lcom/miui/internal/cust/PrivateWaterMarkerConfig;->IS_PRIVATE_WATER_MARKER:Z

    sput-boolean v4, Lmiui/os/Build;->IS_PRIVATE_WATER_MARKER:Z

    nop

    const-string v4, "ro.cust.test"

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    sput-boolean v5, Lmiui/os/Build;->IS_CM_CUSTOMIZATION_TEST:Z

    nop

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    sput-boolean v5, Lmiui/os/Build;->IS_CU_CUSTOMIZATION_TEST:Z

    nop

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v7, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    sput-boolean v4, Lmiui/os/Build;->IS_CT_CUSTOMIZATION_TEST:Z

    nop

    const-string v4, "persist.sys.func_limit_switch"

    invoke-static {v4}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "1"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    sput-boolean v4, Lmiui/os/Build;->IS_FUNCTION_LIMITED:Z

    invoke-static {v0, v3}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "_global"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    sput-boolean v4, Lmiui/os/Build;->IS_INTERNATIONAL_BUILD:Z

    invoke-static {v0, v3}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v4, "_global"

    invoke-virtual {v0, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_GLOBAL_BUILD:Z

    invoke-static {}, Lmiui/os/Build;->isTablet()Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_TABLET:Z

    invoke-static {}, Lmiui/os/Build;->getUserdataImageVersionCode()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmiui/os/Build;->USERDATA_IMAGE_VERSION_CODE:Ljava/lang/String;

    nop

    const-string v0, "ro.debuggable"

    invoke-static {v0, v1}, Landroid/os/SystemProperties;->getInt(Ljava/lang/String;I)I

    move-result v0

    if-ne v0, v2, :cond_36

    move v0, v2

    goto :goto_35

    :cond_36
    move v0, v1

    :goto_35
    sput-boolean v0, Lmiui/os/Build;->IS_DEBUGGABLE:Z

    nop

    const-string v0, "ro.miui.has_cust_partition"

    invoke-static {v0, v1}, Landroid/os/SystemProperties;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->HAS_CUST_PARTITION:Z

    const-string v0, "ro.miui.cust_device"

    invoke-static {v0, v3}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "_pro"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    sput-boolean v0, Lmiui/os/Build;->IS_PRO_DEVICE:Z

    const-string v0, "ro.miui.ui.version.code"

    invoke-static {v0, v3}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    xor-int/2addr v0, v2

    sput-boolean v0, Lmiui/os/Build;->IS_MIUI:Z

    return-void
.end method

.method protected constructor <init>()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InstantiationException;
        }
    .end annotation

    invoke-direct {p0}, Landroid/os/Build;-><init>()V

    new-instance v0, Ljava/lang/InstantiationException;

    const-string v1, "Cannot instantiate utility class"

    invoke-direct {v0, v1}, Ljava/lang/InstantiationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static checkRegion(Ljava/lang/String;)Z
    .locals 1

    invoke-static {}, Lmiui/os/Build;->getRegion()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static getCustVariant()Ljava/lang/String;
    .locals 2

    sget-boolean v0, Lmiui/os/Build;->IS_INTERNATIONAL_BUILD:Z

    const-string v1, "ro.miui.cust_variant"

    if-nez v0, :cond_0

    const-string v0, "cn"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string v0, "hk"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static final getMiUiVersionCode()Ljava/lang/String;
    .locals 2

    const-string v0, "ro.miui.ui.version.code"

    const-string v1, ""

    invoke-static {v0, v1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getRegion()Ljava/lang/String;
    .locals 2

    const-string v0, "ro.miui.region"

    const-string v1, "CN"

    invoke-static {v0, v1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUserMode()I
    .locals 2

    const-string v0, "persist.sys.user_mode"

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/os/SystemProperties;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method private static getUserdataImageVersionCode()Ljava/lang/String;
    .locals 5

    const-string v0, ""

    const-string v1, "ro.miui.userdata_version"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const-string v0, "Unavailable"

    return-object v0

    :cond_0
    sget-boolean v2, Lmiui/os/Build;->IS_INTERNATIONAL_BUILD:Z

    if-eqz v2, :cond_1

    const-string v2, "global"

    goto :goto_0

    :cond_1
    const-string v2, "cn"

    :goto_0
    const-string v3, "ro.carrier.name"

    invoke-static {v3, v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "_"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :cond_2
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v1, v0, v4

    const/4 v4, 0x1

    aput-object v2, v0, v4

    const/4 v4, 0x2

    aput-object v3, v0, v4

    const-string v4, "%s(%s%s)"

    invoke-static {v4, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static hasCameraFlash(Landroid/content/Context;)Z
    .locals 2

    const-string v0, "support_torch"

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lmiui/util/FeatureParser;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method private static hasMsm8660Property()Z
    .locals 2

    const-string v0, "ro.soc.name"

    invoke-static {v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "msm8660"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    const-string v1, "unkown"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v1, 0x1

    :goto_1
    return v1
.end method

.method private static isTablet()Z
    .locals 2

    const-string v0, "ro.build.characteristics"

    invoke-static {v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "tablet"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method private static reboot(ZLjava/lang/String;Z)V
    .locals 1

    :try_start_0
    const-string v0, "power"

    invoke-static {v0}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/os/IPowerManager$Stub;->asInterface(Landroid/os/IBinder;)Landroid/os/IPowerManager;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0, p0, p1, p2}, Landroid/os/IPowerManager;->reboot(ZLjava/lang/String;Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    goto :goto_0

    :catch_0
    move-exception v0

    :goto_0
    return-void
.end method

.method public static setUserMode(Landroid/content/Context;I)V
    .locals 2

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    const-string v1, "persist.sys.user_mode"

    invoke-static {v1, v0}, Landroid/os/SystemProperties;->set(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {v0, v1, v0}, Lmiui/os/Build;->reboot(ZLjava/lang/String;Z)V

    return-void
.end method
