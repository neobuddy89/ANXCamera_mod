.class public Lorg/jcodec/containers/mp4/boxes/ProductionApertureBox;
.super Lorg/jcodec/containers/mp4/boxes/ClearApertureBox;
.source "ProductionApertureBox.java"


# static fields
.field public static final PROF:Ljava/lang/String; = "prof"


# direct methods
.method public constructor <init>(Lorg/jcodec/containers/mp4/boxes/Header;)V
    .locals 0

    invoke-direct {p0, p1}, Lorg/jcodec/containers/mp4/boxes/ClearApertureBox;-><init>(Lorg/jcodec/containers/mp4/boxes/Header;)V

    return-void
.end method

.method public static createProductionApertureBox(II)Lorg/jcodec/containers/mp4/boxes/ProductionApertureBox;
    .locals 3

    new-instance v0, Lorg/jcodec/containers/mp4/boxes/ProductionApertureBox;

    new-instance v1, Lorg/jcodec/containers/mp4/boxes/Header;

    const-string v2, "prof"

    invoke-direct {v1, v2}, Lorg/jcodec/containers/mp4/boxes/Header;-><init>(Ljava/lang/String;)V

    invoke-direct {v0, v1}, Lorg/jcodec/containers/mp4/boxes/ProductionApertureBox;-><init>(Lorg/jcodec/containers/mp4/boxes/Header;)V

    int-to-float p0, p0

    iput p0, v0, Lorg/jcodec/containers/mp4/boxes/ClearApertureBox;->width:F

    int-to-float p0, p1

    iput p0, v0, Lorg/jcodec/containers/mp4/boxes/ClearApertureBox;->height:F

    return-object v0
.end method
