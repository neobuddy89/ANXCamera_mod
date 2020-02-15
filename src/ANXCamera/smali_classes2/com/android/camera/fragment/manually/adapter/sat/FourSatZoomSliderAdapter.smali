.class public Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;
.super Lcom/android/camera/fragment/manually/adapter/AbstractZoomSliderAdapter;
.source "FourSatZoomSliderAdapter.java"


# static fields
.field public static final ENTRY_COUNT_10X_TO_MAX:I = 0xc

.field public static final ENTRY_COUNT_1X_TO_5X:I = 0xb

.field public static final ENTRY_COUNT_1X_TO_5X_RANGE_10X:I = 0xb

.field public static final ENTRY_COUNT_5X_TO_10X:I = 0xb

.field public static final ENTRY_COUNT_5X_TO_10X_RANGE_10X:I = 0x15

.field public static ENTRY_COUNT_MIN_TO_10X_RANGE_10X:I = 0x0

.field public static final ENTRY_COUNT_MIN_TO_1X:I = 0x5

.field public static ENTRY_COUNT_MIN_TO_MAX:I = 0x24

.field public static ENTRY_COUNT_TOTAL:I = 0x0

.field public static final ENTRY_INDEX_10X:I = 0x18

.field public static final ENTRY_INDEX_10X_RANGE_10X:I = 0x1e

.field public static final ENTRY_INDEX_1X:I = 0x4

.field public static final ENTRY_INDEX_1X_RANGE_10X:I = 0x0

.field public static final ENTRY_INDEX_5X:I = 0xe

.field public static final ENTRY_INDEX_5X_RANGE_10X:I = 0xa

.field public static ENTRY_INDEX_LAST:I = 0x23

.field public static ENTRY_INDEX_MAX:I = 0x0

.field public static final ENTRY_INDEX_MIN:I = 0x0

.field private static final RANGE_10X_TO_MAX_ENTRY_INDEX_X:[F

.field private static final RANGE_10X_TO_MAX_ZOOM_RATIO_Y:[F

.field private static final RANGE_1X_TO_5X_ENTRY_INDEX_X:[F

.field private static final RANGE_1X_TO_5X_FOR_10X_ENTRY_INDEX_X:[F

.field private static final RANGE_1X_TO_5X_FOR_10X_ZOOM_RATIO_Y:[F

.field private static final RANGE_1X_TO_5X_ZOOM_RATIO_Y:[F

.field private static final RANGE_5X_TO_10X_ENTRY_INDEX_X:[F

.field private static final RANGE_5X_TO_10X_FOR_10X_ENTRY_INDEX_X:[F

.field private static final RANGE_5X_TO_10X_FOR_10X_ZOOM_RATIO_Y:[F

.field private static final RANGE_5X_TO_10X_ZOOM_RATIO_Y:[F

.field private static final RANGE_MIN_TO_1X_ENTRY_INDEX_X:[F

.field private static final RANGE_MIN_TO_1X_ZOOM_RATIO_Y:[F

.field private static final TAG:Ljava/lang/String; = "FourSatZoomSliderAdapter"


# instance fields
.field private mComponentData:Lcom/android/camera/data/data/ComponentData;

.field private mCurrentMode:I

.field private mCurrentValue:Ljava/lang/String;

.field private mCurrentValueIndex:I

.field private mEnable:Z

.field private mEntryLayouts:[Landroid/text/StaticLayout;

.field private mIsLayoutRTL:Z

.field private mLineColorDefault:I

.field private mLineHalfHeight:F

.field private mLineTextGap:I

.field private mLineWidth:I

.field private mManuallyListener:Lcom/android/camera/fragment/manually/ManuallyListener;

.field private mPaint:Landroid/graphics/Paint;

.field private mRange10XToMaxEntryToZoomRatioSpline:Landroid/util/Spline;

.field private mRange10XToMaxZoomRatioToEntrySpline:Landroid/util/Spline;

.field private mRange1XTo5XEntryToZoomRatioSpline:Landroid/util/Spline;

.field private mRange1XTo5XFor10XEntryToZoomRatioSpline:Landroid/util/Spline;

.field private mRange1XTo5XFor10XZoomRatioToEntrySpline:Landroid/util/Spline;

.field private mRange1XTo5XZoomRatioToEntrySpline:Landroid/util/Spline;

.field private mRange5XTo10XEntryToZoomRatioSpline:Landroid/util/Spline;

.field private mRange5XTo10XFor10XEntryToZoomRatioSpline:Landroid/util/Spline;

.field private mRange5XTo10XFor10XZoomRatioToEntrySpline:Landroid/util/Spline;

.field private mRange5XTo10XZoomRatioToEntrySpline:Landroid/util/Spline;

.field private mRangeMinTo1XEntryToZoomRatioSpline:Landroid/util/Spline;

.field private mRangeMinTo1XZoomRatioToEntrySpline:Landroid/util/Spline;

.field private mSelectHalfHeight:I

.field private mSelectPaint:Landroid/graphics/Paint;

.field private mSpaceTextStyle:Landroid/text/style/AbsoluteSizeSpan;

.field private mTargetHalfHeight:I

.field private mTextBoldStyle:Landroid/text/style/StyleSpan;

.field private mTextColor:I

.field private mTextFontStyle:Landroid/text/style/TypefaceSpan;

.field private mTextPaint:Landroid/text/TextPaint;

.field private mTextSize:I

.field private final mZoomRatioMax:F

.field private final mZoomRatioMin:F


# direct methods
.method static constructor <clinit>()V
    .locals 3

    sget v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_COUNT_MIN_TO_MAX:I

    sput v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_COUNT_TOTAL:I

    sget v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_LAST:I

    sput v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_MAX:I

    const/4 v0, 0x5

    new-array v1, v0, [F

    fill-array-data v1, :array_0

    sput-object v1, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_MIN_TO_1X_ENTRY_INDEX_X:[F

    new-array v1, v0, [F

    fill-array-data v1, :array_1

    sput-object v1, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_MIN_TO_1X_ZOOM_RATIO_Y:[F

    const/4 v1, 0x2

    new-array v2, v1, [F

    fill-array-data v2, :array_2

    sput-object v2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_ENTRY_INDEX_X:[F

    new-array v2, v1, [F

    fill-array-data v2, :array_3

    sput-object v2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_ZOOM_RATIO_Y:[F

    new-array v2, v1, [F

    fill-array-data v2, :array_4

    sput-object v2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_ENTRY_INDEX_X:[F

    new-array v1, v1, [F

    fill-array-data v1, :array_5

    sput-object v1, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_ZOOM_RATIO_Y:[F

    new-array v1, v0, [F

    fill-array-data v1, :array_6

    sput-object v1, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_10X_TO_MAX_ENTRY_INDEX_X:[F

    new-array v0, v0, [F

    fill-array-data v0, :array_7

    sput-object v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_10X_TO_MAX_ZOOM_RATIO_Y:[F

    const/16 v0, 0x1f

    sput v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_COUNT_MIN_TO_10X_RANGE_10X:I

    const/4 v0, 0x6

    new-array v1, v0, [F

    fill-array-data v1, :array_8

    sput-object v1, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_FOR_10X_ENTRY_INDEX_X:[F

    new-array v0, v0, [F

    fill-array-data v0, :array_9

    sput-object v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_FOR_10X_ZOOM_RATIO_Y:[F

    const/4 v0, 0x7

    new-array v1, v0, [F

    fill-array-data v1, :array_a

    sput-object v1, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_FOR_10X_ENTRY_INDEX_X:[F

    new-array v0, v0, [F

    fill-array-data v0, :array_b

    sput-object v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_FOR_10X_ZOOM_RATIO_Y:[F

    return-void

    nop

    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
        0x40000000    # 2.0f
        0x40400000    # 3.0f
        0x40800000    # 4.0f
    .end array-data

    :array_1
    .array-data 4
        0x3f19999a    # 0.6f
        0x3f333333    # 0.7f
        0x3f4ccccd    # 0.8f
        0x3f666666    # 0.9f
        0x3f800000    # 1.0f
    .end array-data

    :array_2
    .array-data 4
        0x40800000    # 4.0f
        0x41600000    # 14.0f
    .end array-data

    :array_3
    .array-data 4
        0x3f800000    # 1.0f
        0x40a00000    # 5.0f
    .end array-data

    :array_4
    .array-data 4
        0x41600000    # 14.0f
        0x41c00000    # 24.0f
    .end array-data

    :array_5
    .array-data 4
        0x40a00000    # 5.0f
        0x41200000    # 10.0f
    .end array-data

    :array_6
    .array-data 4
        0x41c00000    # 24.0f
        0x41e80000    # 29.0f
        0x420c0000    # 35.0f
        0x422c0000    # 43.0f
        0x42300000    # 44.0f
    .end array-data

    :array_7
    .array-data 4
        0x41200000    # 10.0f
        0x41a00000    # 20.0f
        0x42000000    # 32.0f
        0x4239999a    # 46.4f
        0x42480000    # 50.0f
    .end array-data

    :array_8
    .array-data 4
        0x0
        0x40000000    # 2.0f
        0x40800000    # 4.0f
        0x40c00000    # 6.0f
        0x41000000    # 8.0f
        0x41200000    # 10.0f
    .end array-data

    :array_9
    .array-data 4
        0x3f800000    # 1.0f
        0x3fe66666    # 1.8f
        0x40266666    # 2.6f
        0x4059999a    # 3.4f
        0x40866666    # 4.2f
        0x40a00000    # 5.0f
    .end array-data

    :array_a
    .array-data 4
        0x41200000    # 10.0f
        0x41400000    # 12.0f
        0x41600000    # 14.0f
        0x41a00000    # 20.0f
        0x41b00000    # 22.0f
        0x41d00000    # 26.0f
        0x41f00000    # 30.0f
    .end array-data

    :array_b
    .array-data 4
        0x40a00000    # 5.0f
        0x40b00000    # 5.5f
        0x40c00000    # 6.0f
        0x40f00000    # 7.5f
        0x41000000    # 8.0f
        0x41100000    # 9.0f
        0x41200000    # 10.0f
    .end array-data
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/android/camera/data/data/ComponentData;ILcom/android/camera/fragment/manually/ManuallyListener;)V
    .locals 8

    invoke-direct {p0}, Lcom/android/camera/fragment/manually/adapter/AbstractZoomSliderAdapter;-><init>()V

    const-string v0, "-1"

    iput-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValue:Ljava/lang/String;

    const/4 v0, -0x1

    iput v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValueIndex:I

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mComponentData:Lcom/android/camera/data/data/ComponentData;

    iput p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentMode:I

    iput-object p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mManuallyListener:Lcom/android/camera/fragment/manually/ManuallyListener;

    invoke-static {p1}, Lcom/android/camera/Util;->isLayoutRTL(Landroid/content/Context;)Z

    move-result p3

    iput-boolean p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mIsLayoutRTL:Z

    iget p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentMode:I

    invoke-virtual {p2, p3}, Lcom/android/camera/data/data/ComponentData;->getComponentValue(I)Ljava/lang/String;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValue:Ljava/lang/String;

    move-object p2, p1

    check-cast p2, Lcom/android/camera/ActivityBase;

    invoke-virtual {p2}, Lcom/android/camera/ActivityBase;->getCurrentModule()Lcom/android/camera/module/Module;

    move-result-object p2

    check-cast p2, Lcom/android/camera/module/BaseModule;

    invoke-virtual {p2}, Lcom/android/camera/module/BaseModule;->getMaxZoomRatio()F

    move-result p3

    iput p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    invoke-virtual {p2}, Lcom/android/camera/module/BaseModule;->getMinZoomRatio()F

    move-result p2

    iput p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMin:F

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string p3, "ZOOM RATIO RANGE ["

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMin:F

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string p3, ", "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    const-string p3, "]"

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    const-string p3, "FourSatZoomSliderAdapter"

    invoke-static {p3, p2}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    const/high16 p3, 0x41200000    # 10.0f

    cmpl-float p2, p2, p3

    if-lez p2, :cond_0

    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_MIN_TO_1X_ENTRY_INDEX_X:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_MIN_TO_1X_ZOOM_RATIO_Y:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createLinearSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRangeMinTo1XEntryToZoomRatioSpline:Landroid/util/Spline;

    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_MIN_TO_1X_ZOOM_RATIO_Y:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_MIN_TO_1X_ENTRY_INDEX_X:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createLinearSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRangeMinTo1XZoomRatioToEntrySpline:Landroid/util/Spline;

    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_ENTRY_INDEX_X:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_ZOOM_RATIO_Y:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createLinearSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange1XTo5XEntryToZoomRatioSpline:Landroid/util/Spline;

    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_ZOOM_RATIO_Y:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_ENTRY_INDEX_X:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createLinearSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange1XTo5XZoomRatioToEntrySpline:Landroid/util/Spline;

    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_ENTRY_INDEX_X:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_ZOOM_RATIO_Y:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createLinearSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange5XTo10XEntryToZoomRatioSpline:Landroid/util/Spline;

    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_ZOOM_RATIO_Y:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_ENTRY_INDEX_X:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createLinearSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange5XTo10XZoomRatioToEntrySpline:Landroid/util/Spline;

    invoke-static {}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->getEntryX()[F

    move-result-object p2

    iget p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    invoke-static {p3}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->getZoomRatioY(F)[F

    move-result-object p3

    invoke-static {p2, p3}, Landroid/util/Spline;->createMonotoneCubicSpline([F[F)Landroid/util/Spline;

    move-result-object p4

    iput-object p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange10XToMaxEntryToZoomRatioSpline:Landroid/util/Spline;

    invoke-static {p3, p2}, Landroid/util/Spline;->createMonotoneCubicSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange10XToMaxZoomRatioToEntrySpline:Landroid/util/Spline;

    sget p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_COUNT_MIN_TO_MAX:I

    sput p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_COUNT_TOTAL:I

    sget p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_LAST:I

    sput p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_MAX:I

    goto :goto_0

    :cond_0
    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_FOR_10X_ENTRY_INDEX_X:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_FOR_10X_ZOOM_RATIO_Y:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange1XTo5XFor10XEntryToZoomRatioSpline:Landroid/util/Spline;

    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_FOR_10X_ZOOM_RATIO_Y:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_1X_TO_5X_FOR_10X_ENTRY_INDEX_X:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange1XTo5XFor10XZoomRatioToEntrySpline:Landroid/util/Spline;

    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_FOR_10X_ENTRY_INDEX_X:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_FOR_10X_ZOOM_RATIO_Y:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange5XTo10XFor10XEntryToZoomRatioSpline:Landroid/util/Spline;

    sget-object p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_FOR_10X_ZOOM_RATIO_Y:[F

    sget-object p3, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_5X_TO_10X_FOR_10X_ENTRY_INDEX_X:[F

    invoke-static {p2, p3}, Landroid/util/Spline;->createSpline([F[F)Landroid/util/Spline;

    move-result-object p2

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange5XTo10XFor10XZoomRatioToEntrySpline:Landroid/util/Spline;

    sget p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_COUNT_MIN_TO_10X_RANGE_10X:I

    sput p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_COUNT_TOTAL:I

    const/16 p2, 0x1e

    sput p2, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_MAX:I

    :goto_0
    invoke-direct {p0, p1}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->initStyle(Landroid/content/Context;)V

    const/4 p1, 0x2

    new-array p1, p1, [Ljava/lang/CharSequence;

    iget p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMin:F

    invoke-direct {p0, p2}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->createZoomRatioLabel(F)Ljava/lang/CharSequence;

    move-result-object p2

    const/4 p3, 0x0

    aput-object p2, p1, p3

    iget p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    invoke-direct {p0, p2}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->createZoomRatioLabel(F)Ljava/lang/CharSequence;

    move-result-object p2

    const/4 p4, 0x1

    aput-object p2, p1, p4

    array-length p2, p1

    new-array p2, p2, [Landroid/text/StaticLayout;

    iput-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEntryLayouts:[Landroid/text/StaticLayout;

    :goto_1
    array-length p2, p1

    if-ge p3, p2, :cond_1

    iget-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEntryLayouts:[Landroid/text/StaticLayout;

    new-instance p4, Landroid/text/StaticLayout;

    aget-object v1, p1, p3

    iget-object v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextPaint:Landroid/text/TextPaint;

    sget v3, Lcom/android/camera/Util;->sWindowWidth:I

    sget-object v4, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    const/high16 v5, 0x3f800000    # 1.0f

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v0, p4

    invoke-direct/range {v0 .. v7}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    aput-object p4, p2, p3

    add-int/lit8 p3, p3, 0x1

    goto :goto_1

    :cond_1
    return-void
.end method

.method private createZoomRatioLabel(F)Ljava/lang/CharSequence;
    .locals 4

    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    invoke-static {p1}, Lcom/android/camera/HybridZoomingSystem;->toDecimal(F)F

    move-result p1

    float-to-int v1, p1

    const/high16 v2, 0x41200000    # 10.0f

    mul-float/2addr v2, p1

    mul-int/lit8 v3, v1, 0xa

    int-to-float v3, v3

    sub-float/2addr v2, v3

    float-to-int v2, v2

    if-nez v2, :cond_0

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, v0, p1}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->setStyleSpan(Landroid/text/SpannableStringBuilder;Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_0

    :cond_0
    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, v0, p1}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->setStyleSpan(Landroid/text/SpannableStringBuilder;Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    :goto_0
    iget-object p1, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mSpaceTextStyle:Landroid/text/style/AbsoluteSizeSpan;

    const/16 v1, 0x21

    const-string v2, " "

    invoke-static {v0, v2, p1, v1}, Lcom/android/camera/Util;->appendInApi26(Landroid/text/SpannableStringBuilder;Ljava/lang/CharSequence;Ljava/lang/Object;I)Landroid/text/SpannableStringBuilder;

    const-string p1, "X"

    invoke-direct {p0, v0, p1}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->setStyleSpan(Landroid/text/SpannableStringBuilder;Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    return-object v0
.end method

.method private drawText(FILandroid/graphics/Canvas;)V
    .locals 3

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEntryLayouts:[Landroid/text/StaticLayout;

    aget-object v0, v0, p2

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/text/StaticLayout;->getLineAscent(I)I

    move-result v0

    iget-object v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEntryLayouts:[Landroid/text/StaticLayout;

    aget-object v2, v2, p2

    invoke-virtual {v2, v1}, Landroid/text/StaticLayout;->getLineDescent(I)I

    move-result v1

    sub-int/2addr v0, v1

    int-to-float v0, v0

    invoke-virtual {p3}, Landroid/graphics/Canvas;->save()I

    const/high16 v1, 0x40000000    # 2.0f

    div-float/2addr v0, v1

    invoke-virtual {p3, p1, v0}, Landroid/graphics/Canvas;->translate(FF)V

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEntryLayouts:[Landroid/text/StaticLayout;

    aget-object p0, p0, p2

    invoke-virtual {p0, p3}, Landroid/text/StaticLayout;->draw(Landroid/graphics/Canvas;)V

    invoke-virtual {p3}, Landroid/graphics/Canvas;->restore()V

    return-void
.end method

.method private static drawTextForItemAt(I)Z
    .locals 1

    if-eqz p0, :cond_1

    sget v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_MAX:I

    if-ne p0, v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 p0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 p0, 0x1

    :goto_1
    return p0
.end method

.method private static getEntryX()[F
    .locals 7

    sget-object v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_10X_TO_MAX_ENTRY_INDEX_X:[F

    array-length v1, v0

    add-int/lit8 v1, v1, -0x1

    aget v1, v0, v1

    const/16 v2, 0x18

    int-to-float v2, v2

    sub-float/2addr v1, v2

    const/high16 v3, 0x3f800000    # 1.0f

    add-float/2addr v1, v3

    float-to-int v1, v1

    array-length v3, v0

    new-array v3, v3, [F

    const/4 v4, 0x0

    :goto_0
    array-length v5, v0

    if-ge v4, v5, :cond_1

    aget v5, v0, v4

    cmpg-float v5, v5, v2

    if-gtz v5, :cond_0

    aget v5, v0, v4

    aput v5, v3, v4

    goto :goto_1

    :cond_0
    aget v5, v0, v4

    sub-float/2addr v5, v2

    add-int/lit8 v6, v1, -0x1

    int-to-float v6, v6

    div-float/2addr v5, v6

    const/high16 v6, 0x41300000    # 11.0f

    mul-float/2addr v5, v6

    add-float/2addr v5, v2

    aput v5, v3, v4

    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    :cond_1
    return-object v3
.end method

.method private static getZoomRatioY(F)[F
    .locals 7

    sget-object v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->RANGE_10X_TO_MAX_ZOOM_RATIO_Y:[F

    array-length v1, v0

    add-int/lit8 v1, v1, -0x1

    aget v1, v0, v1

    float-to-int v1, v1

    array-length v2, v0

    new-array v2, v2, [F

    const/4 v3, 0x0

    :goto_0
    array-length v4, v0

    if-ge v3, v4, :cond_1

    aget v4, v0, v3

    const/high16 v5, 0x41200000    # 10.0f

    cmpg-float v4, v4, v5

    if-gtz v4, :cond_0

    aget v4, v0, v3

    aput v4, v2, v3

    goto :goto_1

    :cond_0
    aget v4, v0, v3

    sub-float/2addr v4, v5

    int-to-float v6, v1

    sub-float/2addr v6, v5

    div-float/2addr v4, v6

    sub-float v6, p0, v5

    mul-float/2addr v4, v6

    add-float/2addr v4, v5

    aput v4, v2, v3

    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_1
    return-object v2
.end method

.method private indexToSection(I)I
    .locals 0

    if-nez p1, :cond_0

    const/4 p0, 0x0

    return p0

    :cond_0
    sget p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_MAX:I

    if-ne p1, p0, :cond_1

    const/4 p0, 0x1

    return p0

    :cond_1
    const/4 p0, -0x1

    return p0
.end method

.method private initStyle(Landroid/content/Context;)V
    .locals 5

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f070278

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    iput v1, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextSize:I

    const v1, 0x7f06006d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    iput v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextColor:I

    const v2, 0x7f070272

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    iput v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineHalfHeight:F

    const v2, 0x7f070274

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    iput v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTargetHalfHeight:I

    const v2, 0x7f070273

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    iput v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mSelectHalfHeight:I

    const v2, 0x7f070276

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    iput v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineWidth:I

    const v2, 0x7f070275

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    iput v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineTextGap:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineColorDefault:I

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mPaint:Landroid/graphics/Paint;

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mPaint:Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mPaint:Landroid/graphics/Paint;

    iget v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineWidth:I

    int-to-float v2, v2

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mPaint:Landroid/graphics/Paint;

    iget v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineColorDefault:I

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setColor(I)V

    new-instance v0, Landroid/graphics/Paint;

    iget-object v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mPaint:Landroid/graphics/Paint;

    invoke-direct {v0, v2}, Landroid/graphics/Paint;-><init>(Landroid/graphics/Paint;)V

    iput-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mSelectPaint:Landroid/graphics/Paint;

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mSelectPaint:Landroid/graphics/Paint;

    const v2, -0xff5701

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mPaint:Landroid/graphics/Paint;

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v3, 0x0

    const/high16 v4, -0x41000000    # -0.5f

    invoke-virtual {v0, v2, v3, v2, v4}, Landroid/graphics/Paint;->setShadowLayer(FFFI)V

    new-instance v0, Landroid/text/TextPaint;

    iget-object v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mPaint:Landroid/graphics/Paint;

    invoke-direct {v0, v2}, Landroid/text/TextPaint;-><init>(Landroid/graphics/Paint;)V

    iput-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextPaint:Landroid/text/TextPaint;

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextPaint:Landroid/text/TextPaint;

    iget v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextSize:I

    int-to-float v2, v2

    invoke-virtual {v0, v2}, Landroid/text/TextPaint;->setTextSize(F)V

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextPaint:Landroid/text/TextPaint;

    iget v2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextColor:I

    invoke-virtual {v0, v2}, Landroid/text/TextPaint;->setColor(I)V

    new-instance v0, Landroid/text/style/AbsoluteSizeSpan;

    const/16 v2, 0x12

    invoke-direct {v0, v2, v1}, Landroid/text/style/AbsoluteSizeSpan;-><init>(IZ)V

    iput-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mSpaceTextStyle:Landroid/text/style/AbsoluteSizeSpan;

    new-instance v0, Landroid/text/style/TypefaceSpan;

    invoke-static {p1}, Lcom/android/camera/Util;->getLanTineGBTypeface(Landroid/content/Context;)Landroid/graphics/Typeface;

    move-result-object p1

    invoke-direct {v0, p1}, Landroid/text/style/TypefaceSpan;-><init>(Landroid/graphics/Typeface;)V

    iput-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextFontStyle:Landroid/text/style/TypefaceSpan;

    new-instance p1, Landroid/text/style/StyleSpan;

    invoke-direct {p1, v1}, Landroid/text/style/StyleSpan;-><init>(I)V

    iput-object p1, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextBoldStyle:Landroid/text/style/StyleSpan;

    return-void
.end method

.method private setStyleSpan(Landroid/text/SpannableStringBuilder;Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    .locals 3

    invoke-virtual {p1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    invoke-virtual {p1, p2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    iget-object p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextFontStyle:Landroid/text/style/TypefaceSpan;

    invoke-static {p2}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object p2

    invoke-virtual {p1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    const/16 v2, 0x21

    invoke-virtual {p1, p2, v0, v1, v2}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTextBoldStyle:Landroid/text/style/StyleSpan;

    invoke-static {p0}, Landroid/text/style/CharacterStyle;->wrap(Landroid/text/style/CharacterStyle;)Landroid/text/style/CharacterStyle;

    move-result-object p0

    invoke-virtual {p1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result p2

    invoke-virtual {p1, p0, v0, p2, v2}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    return-object p1
.end method


# virtual methods
.method public draw(FILandroid/graphics/Canvas;Z)V
    .locals 6

    if-nez p2, :cond_0

    iget-boolean v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mIsLayoutRTL:Z

    if-eqz v0, :cond_1

    :cond_0
    sget v0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_MAX:I

    if-ne p2, v0, :cond_2

    iget-boolean v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mIsLayoutRTL:Z

    if-eqz v0, :cond_2

    :cond_1
    invoke-direct {p0, p2}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->indexToSection(I)I

    move-result v0

    invoke-direct {p0, p1, v0, p3}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->drawText(FILandroid/graphics/Canvas;)V

    invoke-virtual {p0, p2}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->measureWidth(I)F

    move-result v0

    iget v1, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineWidth:I

    int-to-float v1, v1

    sub-float/2addr v0, v1

    add-float/2addr p1, v0

    :cond_2
    if-eqz p4, :cond_3

    iget p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mSelectHalfHeight:I

    neg-int v0, p4

    int-to-float v2, v0

    int-to-float v4, p4

    iget-object v5, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mSelectPaint:Landroid/graphics/Paint;

    move-object v0, p3

    move v1, p1

    move v3, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto :goto_0

    :cond_3
    iget p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    const/high16 v0, 0x41200000    # 10.0f

    cmpl-float p4, p4, v0

    if-lez p4, :cond_4

    if-eqz p2, :cond_5

    const/4 p4, 0x4

    if-eq p2, p4, :cond_5

    const/16 p4, 0xe

    if-eq p2, p4, :cond_5

    const/16 p4, 0x18

    if-eq p2, p4, :cond_5

    sget p4, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_MAX:I

    if-eq p2, p4, :cond_5

    :cond_4
    iget p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    cmpg-float p4, p4, v0

    if-gtz p4, :cond_6

    if-eqz p2, :cond_5

    const/16 p4, 0xa

    if-eq p2, p4, :cond_5

    const/16 p4, 0x1e

    if-ne p2, p4, :cond_6

    :cond_5
    iget p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mTargetHalfHeight:I

    neg-int v0, p4

    int-to-float v2, v0

    int-to-float v4, p4

    iget-object v5, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mPaint:Landroid/graphics/Paint;

    move-object v0, p3

    move v1, p1

    move v3, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto :goto_0

    :cond_6
    iget v4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineHalfHeight:F

    neg-float v2, v4

    iget-object v5, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mPaint:Landroid/graphics/Paint;

    move-object v0, p3

    move v1, p1

    move v3, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    :goto_0
    sget p4, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_INDEX_MAX:I

    if-ne p2, p4, :cond_7

    iget-boolean p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mIsLayoutRTL:Z

    if-eqz p4, :cond_8

    :cond_7
    if-nez p2, :cond_9

    iget-boolean p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mIsLayoutRTL:Z

    if-eqz p4, :cond_9

    :cond_8
    iget p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineWidth:I

    int-to-float p4, p4

    add-float/2addr p1, p4

    iget p4, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineTextGap:I

    int-to-float p4, p4

    add-float/2addr p1, p4

    invoke-direct {p0, p2}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->indexToSection(I)I

    move-result p2

    invoke-direct {p0, p1, p2, p3}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->drawText(FILandroid/graphics/Canvas;)V

    :cond_9
    return-void
.end method

.method public getAlign(I)Landroid/graphics/Paint$Align;
    .locals 0

    const/4 p0, 0x0

    return-object p0
.end method

.method public getCount()I
    .locals 0

    sget p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->ENTRY_COUNT_TOTAL:I

    return p0
.end method

.method public isEnable()Z
    .locals 0

    iget-boolean p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEnable:Z

    return p0
.end method

.method public mapPositionToZoomRatio(F)F
    .locals 3

    iget v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    const/high16 v1, 0x41200000    # 10.0f

    cmpl-float v0, v0, v1

    const/4 v2, 0x0

    if-lez v0, :cond_3

    cmpg-float v0, v2, p1

    const/high16 v1, 0x40800000    # 4.0f

    if-gtz v0, :cond_0

    cmpg-float v0, p1, v1

    if-gez v0, :cond_0

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRangeMinTo1XEntryToZoomRatioSpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_0
    cmpg-float v0, v1, p1

    const/high16 v1, 0x41600000    # 14.0f

    if-gtz v0, :cond_1

    cmpg-float v0, p1, v1

    if-gez v0, :cond_1

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange1XTo5XEntryToZoomRatioSpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_1
    cmpg-float v0, v1, p1

    if-gtz v0, :cond_2

    const/high16 v0, 0x41c00000    # 24.0f

    cmpg-float v0, p1, v0

    if-gtz v0, :cond_2

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange5XTo10XEntryToZoomRatioSpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_2
    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange10XToMaxEntryToZoomRatioSpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_3
    cmpg-float v0, v2, p1

    if-gtz v0, :cond_4

    cmpg-float v0, p1, v1

    if-gez v0, :cond_4

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange1XTo5XFor10XEntryToZoomRatioSpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_4
    cmpg-float v0, v1, p1

    if-gtz v0, :cond_5

    const/high16 v0, 0x41f00000    # 30.0f

    cmpg-float v0, p1, v0

    if-gtz v0, :cond_5

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange5XTo10XFor10XEntryToZoomRatioSpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_5
    return v2
.end method

.method public mapZoomRatioToPosition(F)F
    .locals 4

    iget v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    const/high16 v1, 0x41200000    # 10.0f

    cmpl-float v0, v0, v1

    const/high16 v2, 0x3f800000    # 1.0f

    const/high16 v3, 0x40a00000    # 5.0f

    if-lez v0, :cond_3

    const v0, 0x3f19999a    # 0.6f

    cmpg-float v0, v0, p1

    if-gtz v0, :cond_0

    cmpg-float v0, p1, v2

    if-gez v0, :cond_0

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRangeMinTo1XZoomRatioToEntrySpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_0
    cmpg-float v0, v2, p1

    if-gtz v0, :cond_1

    cmpg-float v0, p1, v3

    if-gez v0, :cond_1

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange1XTo5XZoomRatioToEntrySpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_1
    cmpg-float v0, v3, p1

    if-gtz v0, :cond_2

    cmpg-float v0, p1, v1

    if-gtz v0, :cond_2

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange5XTo10XZoomRatioToEntrySpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_2
    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange10XToMaxZoomRatioToEntrySpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_3
    cmpg-float v0, v2, p1

    if-gtz v0, :cond_4

    cmpg-float v0, p1, v3

    if-gez v0, :cond_4

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange1XTo5XFor10XZoomRatioToEntrySpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_4
    cmpg-float v0, v3, p1

    if-gtz v0, :cond_5

    cmpg-float v0, p1, v1

    if-gtz v0, :cond_5

    iget-object p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mRange5XTo10XFor10XZoomRatioToEntrySpline:Landroid/util/Spline;

    invoke-virtual {p0, p1}, Landroid/util/Spline;->interpolate(F)F

    move-result p0

    return p0

    :cond_5
    const/4 p0, 0x0

    return p0
.end method

.method public measureTextWidth(I)F
    .locals 1

    invoke-static {p1}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->drawTextForItemAt(I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEntryLayouts:[Landroid/text/StaticLayout;

    invoke-direct {p0, p1}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->indexToSection(I)I

    move-result p0

    aget-object p0, v0, p0

    const/4 p1, 0x0

    invoke-virtual {p0, p1}, Landroid/text/StaticLayout;->getLineWidth(I)F

    move-result p0

    return p0

    :cond_0
    const/4 p0, 0x0

    return p0
.end method

.method public measureWidth(I)F
    .locals 1

    invoke-static {p1}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->drawTextForItemAt(I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEntryLayouts:[Landroid/text/StaticLayout;

    invoke-direct {p0, p1}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->indexToSection(I)I

    move-result p1

    aget-object p1, v0, p1

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/text/StaticLayout;->getLineWidth(I)F

    move-result p1

    iget v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineWidth:I

    int-to-float v0, v0

    add-float/2addr p1, v0

    iget p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineTextGap:I

    int-to-float p0, p0

    add-float/2addr p1, p0

    return p1

    :cond_0
    iget p0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mLineWidth:I

    int-to-float p0, p0

    return p0
.end method

.method public onPositionSelect(Landroid/view/View;IF)V
    .locals 12

    iget-boolean p1, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEnable:Z

    if-nez p1, :cond_0

    return-void

    :cond_0
    const/4 p1, 0x0

    const/4 v0, 0x0

    cmpg-float v1, p3, v0

    if-gez v1, :cond_1

    move p3, v0

    :cond_1
    const/high16 v0, 0x3f800000    # 1.0f

    cmpl-float v1, p3, v0

    if-ltz v1, :cond_2

    move p3, v0

    :cond_2
    const/high16 v1, 0x40a00000    # 5.0f

    const v2, 0x3ecccccd    # 0.4f

    const/4 v3, -0x1

    const/4 v4, 0x0

    const/4 v5, 0x1

    if-eq p2, v3, :cond_7

    iget v6, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mZoomRatioMax:F

    const/high16 v7, 0x41200000    # 10.0f

    cmpl-float v6, v6, v7

    if-lez v6, :cond_7

    const/4 p1, 0x4

    if-gt p2, p1, :cond_4

    const p1, 0x3f19999a    # 0.6f

    int-to-float p3, p2

    const v0, 0x3dcccccd    # 0.1f

    mul-float/2addr p3, v0

    invoke-static {p1, p3}, Lcom/android/camera/HybridZoomingSystem;->add(FF)F

    move-result p1

    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object p1

    iget p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValueIndex:I

    if-eq p3, p2, :cond_3

    goto/16 :goto_1

    :cond_3
    move v5, v4

    goto/16 :goto_1

    :cond_4
    const/16 p1, 0xe

    if-gt p2, p1, :cond_5

    add-int/lit8 p1, p2, -0x4

    int-to-float p1, p1

    mul-float/2addr p1, v2

    invoke-static {v0, p1}, Lcom/android/camera/HybridZoomingSystem;->add(FF)F

    move-result p1

    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object p1

    iget p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValueIndex:I

    if-eq p3, p2, :cond_3

    goto/16 :goto_1

    :cond_5
    const/16 p1, 0x18

    if-gt p2, p1, :cond_6

    add-int/lit8 p1, p2, -0xe

    int-to-float p1, p1

    const/high16 p3, 0x3f000000    # 0.5f

    mul-float/2addr p1, p3

    invoke-static {v1, p1}, Lcom/android/camera/HybridZoomingSystem;->add(FF)F

    move-result p1

    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object p1

    iget p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValueIndex:I

    if-eq p3, p2, :cond_3

    goto :goto_1

    :cond_6
    invoke-virtual {p0}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->getCount()I

    move-result p1

    sub-int/2addr p1, v5

    int-to-float p1, p1

    mul-float/2addr p3, p1

    invoke-virtual {p0, p3}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mapPositionToZoomRatio(F)F

    move-result p1

    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object p1

    iget-object p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValue:Ljava/lang/String;

    invoke-virtual {p1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p3

    goto :goto_0

    :cond_7
    if-eq p2, v3, :cond_9

    const/16 p3, 0xa

    if-gt p2, p3, :cond_8

    int-to-float p1, p2

    mul-float/2addr p1, v2

    invoke-static {v0, p1}, Lcom/android/camera/HybridZoomingSystem;->add(FF)F

    move-result p1

    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object p1

    iget p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValueIndex:I

    if-eq p3, p2, :cond_3

    goto :goto_1

    :cond_8
    const/16 p3, 0x1e

    if-gt p2, p3, :cond_a

    add-int/lit8 p1, p2, -0xa

    int-to-float p1, p1

    const/high16 p3, 0x3e800000    # 0.25f

    mul-float/2addr p1, p3

    invoke-static {v1, p1}, Lcom/android/camera/HybridZoomingSystem;->add(FF)F

    move-result p1

    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object p1

    iget p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValueIndex:I

    if-eq p3, p2, :cond_3

    goto :goto_1

    :cond_9
    invoke-virtual {p0}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->getCount()I

    invoke-virtual {p0}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->getCount()I

    move-result p1

    sub-int/2addr p1, v5

    int-to-float p1, p1

    mul-float/2addr p3, p1

    invoke-virtual {p0, p3}, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mapPositionToZoomRatio(F)F

    move-result p1

    invoke-static {p1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object p1

    iget-object p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValue:Ljava/lang/String;

    invoke-virtual {p1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p3

    :goto_0
    xor-int/2addr v5, p3

    :cond_a
    :goto_1
    if-eqz v5, :cond_c

    iget-object p3, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mComponentData:Lcom/android/camera/data/data/ComponentData;

    iget v0, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentMode:I

    invoke-virtual {p3, v0, p1}, Lcom/android/camera/data/data/ComponentData;->setComponentValue(ILjava/lang/String;)V

    iget-object v6, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mManuallyListener:Lcom/android/camera/fragment/manually/ManuallyListener;

    if-eqz v6, :cond_b

    iget-object v7, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mComponentData:Lcom/android/camera/data/data/ComponentData;

    iget-object v8, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValue:Ljava/lang/String;

    const/4 v10, 0x0

    iget v11, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentMode:I

    move-object v9, p1

    invoke-interface/range {v6 .. v11}, Lcom/android/camera/fragment/manually/ManuallyListener;->onManuallyDataChanged(Lcom/android/camera/data/data/ComponentData;Ljava/lang/String;Ljava/lang/String;ZI)V

    :cond_b
    iput-object p1, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValue:Ljava/lang/String;

    iput p2, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mCurrentValueIndex:I

    :cond_c
    return-void
.end method

.method public setEnable(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/android/camera/fragment/manually/adapter/sat/FourSatZoomSliderAdapter;->mEnable:Z

    return-void
.end method
