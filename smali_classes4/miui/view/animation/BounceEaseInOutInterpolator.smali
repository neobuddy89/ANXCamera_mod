.class public Lmiui/view/animation/BounceEaseInOutInterpolator;
.super Ljava/lang/Object;
.source "BounceEaseInOutInterpolator.java"

# interfaces
.implements Landroid/view/animation/Interpolator;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getInterpolation(F)F
    .locals 4

    const/high16 v0, 0x3f000000    # 0.5f

    cmpg-float v1, p1, v0

    const/high16 v2, 0x40000000    # 2.0f

    if-gez v1, :cond_0

    new-instance v1, Lmiui/view/animation/BounceEaseInInterpolator;

    invoke-direct {v1}, Lmiui/view/animation/BounceEaseInInterpolator;-><init>()V

    mul-float/2addr v2, p1

    invoke-virtual {v1, v2}, Lmiui/view/animation/BounceEaseInInterpolator;->getInterpolation(F)F

    move-result v1

    mul-float/2addr v1, v0

    return v1

    :cond_0
    new-instance v1, Lmiui/view/animation/BounceEaseOutInterpolator;

    invoke-direct {v1}, Lmiui/view/animation/BounceEaseOutInterpolator;-><init>()V

    mul-float/2addr v2, p1

    const/high16 v3, 0x3f800000    # 1.0f

    sub-float/2addr v2, v3

    invoke-virtual {v1, v2}, Lmiui/view/animation/BounceEaseOutInterpolator;->getInterpolation(F)F

    move-result v1

    mul-float/2addr v1, v0

    add-float/2addr v1, v0

    return v1
.end method
