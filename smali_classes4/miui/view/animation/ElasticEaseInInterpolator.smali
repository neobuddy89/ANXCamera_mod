.class public Lmiui/view/animation/ElasticEaseInInterpolator;
.super Ljava/lang/Object;
.source "ElasticEaseInInterpolator.java"

# interfaces
.implements Landroid/view/animation/Interpolator;


# instance fields
.field private final mAmplitude:F

.field private final mPeriod:F


# direct methods
.method public constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, v0, v0}, Lmiui/view/animation/ElasticEaseInInterpolator;-><init>(FF)V

    return-void
.end method

.method public constructor <init>(FF)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lmiui/view/animation/ElasticEaseInInterpolator;->mAmplitude:F

    iput p2, p0, Lmiui/view/animation/ElasticEaseInInterpolator;->mPeriod:F

    return-void
.end method


# virtual methods
.method public getInterpolation(F)F
    .locals 12

    iget v0, p0, Lmiui/view/animation/ElasticEaseInInterpolator;->mPeriod:F

    iget v1, p0, Lmiui/view/animation/ElasticEaseInInterpolator;->mAmplitude:F

    const/4 v2, 0x0

    cmpl-float v3, p1, v2

    if-nez v3, :cond_0

    return v2

    :cond_0
    const/high16 v3, 0x3f800000    # 1.0f

    cmpl-float v4, p1, v3

    if-nez v4, :cond_1

    return v3

    :cond_1
    cmpl-float v4, v0, v2

    if-nez v4, :cond_2

    const v0, 0x3e99999a    # 0.3f

    :cond_2
    cmpl-float v2, v1, v2

    const-wide v4, 0x401921fb54442d18L    # 6.283185307179586

    if-eqz v2, :cond_4

    cmpg-float v2, v1, v3

    if-gez v2, :cond_3

    goto :goto_0

    :cond_3
    float-to-double v6, v0

    div-double/2addr v6, v4

    div-float v2, v3, v1

    float-to-double v8, v2

    invoke-static {v8, v9}, Ljava/lang/Math;->asin(D)D

    move-result-wide v8

    mul-double/2addr v6, v8

    double-to-float v2, v6

    goto :goto_1

    :cond_4
    :goto_0
    const/high16 v1, 0x3f800000    # 1.0f

    const/high16 v2, 0x40800000    # 4.0f

    div-float v2, v0, v2

    :goto_1
    sub-float/2addr p1, v3

    float-to-double v6, v1

    const-wide/high16 v8, 0x4000000000000000L    # 2.0

    const/high16 v3, 0x41200000    # 10.0f

    mul-float/2addr v3, p1

    float-to-double v10, v3

    invoke-static {v8, v9, v10, v11}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v8

    mul-double/2addr v6, v8

    sub-float v3, p1, v2

    float-to-double v8, v3

    mul-double/2addr v8, v4

    float-to-double v3, v0

    div-double/2addr v8, v3

    invoke-static {v8, v9}, Ljava/lang/Math;->sin(D)D

    move-result-wide v3

    mul-double/2addr v6, v3

    double-to-float v3, v6

    neg-float v3, v3

    return v3
.end method
