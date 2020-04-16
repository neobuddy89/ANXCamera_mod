package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    static boolean[] flags = new boolean[3];

    static void analyze(int i, ConstraintWidget constraintWidget) {
        ConstraintWidget constraintWidget2 = constraintWidget;
        constraintWidget.updateResolutionNodes();
        ResolutionAnchor resolutionNode = constraintWidget2.mLeft.getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget2.mTop.getResolutionNode();
        ResolutionAnchor resolutionNode3 = constraintWidget2.mRight.getResolutionNode();
        ResolutionAnchor resolutionNode4 = constraintWidget2.mBottom.getResolutionNode();
        boolean z = (i & 8) == 8;
        boolean z2 = constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget2, 0);
        if (!(resolutionNode.type == 4 || resolutionNode3.type == 4)) {
            if (constraintWidget2.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget2.mLeft.mTarget != null && constraintWidget2.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget != null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    }
                } else if (!(constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget == null)) {
                    resolutionNode.setType(2);
                    resolutionNode3.setType(2);
                    if (z) {
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                        resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.setOpposite(resolutionNode3, (float) (-constraintWidget.getWidth()));
                        resolutionNode3.setOpposite(resolutionNode, (float) constraintWidget.getWidth());
                    }
                }
            } else if (z2) {
                int width = constraintWidget.getWidth();
                resolutionNode.setType(1);
                resolutionNode3.setType(1);
                if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                } else if (constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget != null) {
                    if (constraintWidget2.mLeft.mTarget != null || constraintWidget2.mRight.mTarget == null) {
                        if (!(constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget == null)) {
                            if (z) {
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                            }
                            if (constraintWidget2.mDimensionRatio == 0.0f) {
                                resolutionNode.setType(3);
                                resolutionNode3.setType(3);
                                resolutionNode.setOpposite(resolutionNode3, 0.0f);
                                resolutionNode3.setOpposite(resolutionNode, 0.0f);
                            } else {
                                resolutionNode.setType(2);
                                resolutionNode3.setType(2);
                                resolutionNode.setOpposite(resolutionNode3, (float) (-width));
                                resolutionNode3.setOpposite(resolutionNode, (float) width);
                                constraintWidget2.setWidth(width);
                            }
                        }
                    } else if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                } else if (z) {
                    resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                } else {
                    resolutionNode3.dependsOn(resolutionNode, width);
                }
            }
        }
        boolean z3 = constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget2, 1);
        if (resolutionNode2.type != 4 && resolutionNode4.type != 4) {
            if (constraintWidget2.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || (z3 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaseline.mTarget != null) {
                        constraintWidget2.mBaseline.getResolutionNode().setType(1);
                        resolutionNode2.dependsOn(1, constraintWidget2.mBaseline.getResolutionNode(), -constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget != null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget != null) {
                    resolutionNode2.setType(2);
                    resolutionNode4.setType(2);
                    if (z) {
                        resolutionNode2.setOpposite(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                        resolutionNode4.setOpposite(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                    } else {
                        resolutionNode2.setOpposite(resolutionNode4, (float) (-constraintWidget.getHeight()));
                        resolutionNode4.setOpposite(resolutionNode2, (float) constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                }
            } else if (z3) {
                int height = constraintWidget.getHeight();
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null) {
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                    }
                } else if (constraintWidget2.mTop.mTarget == null || constraintWidget2.mBottom.mTarget != null) {
                    if (constraintWidget2.mTop.mTarget != null || constraintWidget2.mBottom.mTarget == null) {
                        if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget != null) {
                            if (z) {
                                constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                            }
                            if (constraintWidget2.mDimensionRatio == 0.0f) {
                                resolutionNode2.setType(3);
                                resolutionNode4.setType(3);
                                resolutionNode2.setOpposite(resolutionNode4, 0.0f);
                                resolutionNode4.setOpposite(resolutionNode2, 0.0f);
                                return;
                            }
                            resolutionNode2.setType(2);
                            resolutionNode4.setType(2);
                            resolutionNode2.setOpposite(resolutionNode4, (float) (-height));
                            resolutionNode4.setOpposite(resolutionNode2, (float) height);
                            constraintWidget2.setHeight(height);
                            if (constraintWidget2.mBaselineDistance > 0) {
                                constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                            }
                        }
                    } else if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -height);
                    }
                } else if (z) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, height);
                }
            }
        }
    }

    static boolean applyChainOptimized(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        float f2;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean z6;
        int i3;
        float f3;
        boolean z7;
        ResolutionAnchor resolutionAnchor;
        float f4;
        boolean z8;
        boolean z9;
        int i4;
        int i5;
        ConstraintWidget constraintWidget3;
        LinearSystem linearSystem2 = linearSystem;
        int i6 = i;
        ChainHead chainHead2 = chainHead;
        ConstraintWidget constraintWidget4 = chainHead2.mFirst;
        ConstraintWidget constraintWidget5 = chainHead2.mLast;
        ConstraintWidget constraintWidget6 = chainHead2.mFirstVisibleWidget;
        ConstraintWidget constraintWidget7 = chainHead2.mLastVisibleWidget;
        ConstraintWidget constraintWidget8 = chainHead2.mHead;
        float f5 = chainHead2.mTotalWeight;
        ConstraintWidget constraintWidget9 = chainHead2.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget10 = chainHead2.mLastMatchConstraintWidget;
        ConstraintWidget constraintWidget11 = constraintWidget4;
        boolean z10 = constraintWidgetContainer.mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i6 == 0) {
            boolean z11 = constraintWidget8.mHorizontalChainStyle == 0;
            boolean z12 = z10;
            boolean z13 = constraintWidget8.mHorizontalChainStyle == 1;
            z = z11;
            z2 = constraintWidget8.mHorizontalChainStyle == 2;
            z3 = z13;
        } else {
            boolean z14 = z10;
            boolean z15 = constraintWidget8.mVerticalChainStyle == 0;
            boolean z16 = constraintWidget8.mVerticalChainStyle == 1;
            z = z15;
            z2 = constraintWidget8.mVerticalChainStyle == 2;
            z3 = z16;
        }
        float f6 = 0.0f;
        float f7 = 0.0f;
        ConstraintWidget constraintWidget12 = constraintWidget11;
        ConstraintWidget constraintWidget13 = constraintWidget8;
        int i7 = 0;
        boolean z17 = false;
        ConstraintWidget constraintWidget14 = constraintWidget12;
        ConstraintWidget constraintWidget15 = constraintWidget9;
        int i8 = 0;
        while (true) {
            ConstraintWidget constraintWidget16 = constraintWidget10;
            if (!z17) {
                boolean z18 = z17;
                if (constraintWidget14.getVisibility() != 8) {
                    i8++;
                    f6 = i6 == 0 ? f6 + ((float) constraintWidget14.getWidth()) : f6 + ((float) constraintWidget14.getHeight());
                    if (constraintWidget14 != constraintWidget6) {
                        f6 += (float) constraintWidget14.mListAnchors[i2].getMargin();
                    }
                    if (constraintWidget14 != constraintWidget7) {
                        f6 += (float) constraintWidget14.mListAnchors[i2 + 1].getMargin();
                    }
                    f7 = f7 + ((float) constraintWidget14.mListAnchors[i2].getMargin()) + ((float) constraintWidget14.mListAnchors[i2 + 1].getMargin());
                }
                ConstraintAnchor constraintAnchor = constraintWidget14.mListAnchors[i2];
                if (constraintWidget14.getVisibility() != 8 && constraintWidget14.mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7++;
                    if (i6 == 0) {
                        if (!(constraintWidget14.mMatchConstraintDefaultWidth == 0 && constraintWidget14.mMatchConstraintMinWidth == 0 && constraintWidget14.mMatchConstraintMaxWidth == 0)) {
                            return false;
                        }
                    } else if (!(constraintWidget14.mMatchConstraintDefaultHeight == 0 && constraintWidget14.mMatchConstraintMinHeight == 0 && constraintWidget14.mMatchConstraintMaxHeight == 0)) {
                        return false;
                    }
                    if (constraintWidget14.mDimensionRatio != 0.0f) {
                        return false;
                    }
                }
                ConstraintAnchor constraintAnchor2 = constraintWidget14.mListAnchors[i2 + 1].mTarget;
                if (constraintAnchor2 != null) {
                    ConstraintWidget constraintWidget17 = constraintAnchor2.mOwner;
                    i5 = i7;
                    constraintWidget3 = (constraintWidget17.mListAnchors[i2].mTarget == null || constraintWidget17.mListAnchors[i2].mTarget.mOwner != constraintWidget14) ? null : constraintWidget17;
                } else {
                    i5 = i7;
                    constraintWidget3 = null;
                }
                if (constraintWidget3 != null) {
                    constraintWidget14 = constraintWidget3;
                    z17 = z18;
                } else {
                    z17 = true;
                }
                i7 = i5;
                constraintWidget10 = constraintWidget16;
            } else {
                boolean z19 = z17;
                ResolutionAnchor resolutionNode = constraintWidget4.mListAnchors[i2].getResolutionNode();
                ResolutionAnchor resolutionNode2 = constraintWidget5.mListAnchors[i2 + 1].getResolutionNode();
                if (resolutionNode.target == null) {
                    boolean z20 = z3;
                    ConstraintWidget constraintWidget18 = constraintWidget7;
                    int i9 = i7;
                    boolean z21 = z2;
                    boolean z22 = z;
                    float f8 = f5;
                    ResolutionAnchor resolutionAnchor2 = resolutionNode2;
                    LinearSystem linearSystem3 = linearSystem2;
                    ConstraintWidget constraintWidget19 = constraintWidget4;
                    int i10 = i8;
                } else if (resolutionNode2.target == null) {
                    boolean z23 = z3;
                    ConstraintWidget constraintWidget20 = constraintWidget7;
                    int i11 = i7;
                    boolean z24 = z2;
                    boolean z25 = z;
                    float f9 = f5;
                    ResolutionAnchor resolutionAnchor3 = resolutionNode2;
                    LinearSystem linearSystem4 = linearSystem2;
                    ConstraintWidget constraintWidget21 = constraintWidget4;
                    int i12 = i8;
                } else {
                    if (resolutionNode.target.state != 1) {
                        boolean z26 = z3;
                        ConstraintWidget constraintWidget22 = constraintWidget7;
                        int i13 = i7;
                        boolean z27 = z2;
                        boolean z28 = z;
                        float f10 = f5;
                        ResolutionAnchor resolutionAnchor4 = resolutionNode2;
                        LinearSystem linearSystem5 = linearSystem;
                        ConstraintWidget constraintWidget23 = constraintWidget4;
                        int i14 = i8;
                    } else if (resolutionNode2.target.state != 1) {
                        boolean z29 = z3;
                        ConstraintWidget constraintWidget24 = constraintWidget7;
                        int i15 = i7;
                        boolean z30 = z2;
                        boolean z31 = z;
                        float f11 = f5;
                        ResolutionAnchor resolutionAnchor5 = resolutionNode2;
                        LinearSystem linearSystem6 = linearSystem;
                        ConstraintWidget constraintWidget25 = constraintWidget4;
                        int i16 = i8;
                    } else if (i7 > 0 && i7 != i8) {
                        return false;
                    } else {
                        float f12 = 0.0f;
                        if (z2 || z || z3) {
                            if (constraintWidget6 != null) {
                                f12 = (float) constraintWidget6.mListAnchors[i2].getMargin();
                            }
                            if (constraintWidget7 != null) {
                                f12 += (float) constraintWidget7.mListAnchors[i2 + 1].getMargin();
                            }
                        }
                        float f13 = resolutionNode.target.resolvedOffset;
                        boolean z32 = z3;
                        float f14 = resolutionNode2.target.resolvedOffset;
                        float f15 = f13 < f14 ? (f14 - f13) - f6 : (f13 - f14) - f6;
                        if (i7 <= 0 || i7 != i8) {
                            float f16 = f14;
                            ConstraintWidget constraintWidget26 = constraintWidget7;
                            int i17 = i7;
                            boolean z33 = z2;
                            boolean z34 = z;
                            LinearSystem linearSystem7 = linearSystem;
                            if (f15 < 0.0f) {
                                z4 = true;
                                z34 = false;
                                z5 = false;
                            } else {
                                z5 = z32;
                                z4 = z33;
                            }
                            if (z4) {
                                ConstraintWidget constraintWidget27 = constraintWidget4;
                                float biasPercent = (constraintWidget4.getBiasPercent(i6) * (f15 - f12)) + f13;
                                while (constraintWidget27 != null) {
                                    if (LinearSystem.sMetrics != null) {
                                        z7 = z4;
                                        LinearSystem.sMetrics.nonresolvedWidgets--;
                                        LinearSystem.sMetrics.resolvedWidgets++;
                                        LinearSystem.sMetrics.chainConnectionResolved++;
                                    } else {
                                        z7 = z4;
                                    }
                                    ConstraintWidget constraintWidget28 = constraintWidget27.mNextChainWidget[i6];
                                    if (constraintWidget28 != null || constraintWidget27 == constraintWidget5) {
                                        float width = i6 == 0 ? (float) constraintWidget27.getWidth() : (float) constraintWidget27.getHeight();
                                        float margin = biasPercent + ((float) constraintWidget27.mListAnchors[i2].getMargin());
                                        f4 = f5;
                                        constraintWidget27.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin);
                                        resolutionAnchor = resolutionNode2;
                                        constraintWidget27.mListAnchors[i2 + 1].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin + width);
                                        constraintWidget27.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem7);
                                        constraintWidget27.mListAnchors[i2 + 1].getResolutionNode().addResolvedValue(linearSystem7);
                                        biasPercent = margin + width + ((float) constraintWidget27.mListAnchors[i2 + 1].getMargin());
                                    } else {
                                        f4 = f5;
                                        resolutionAnchor = resolutionNode2;
                                    }
                                    constraintWidget27 = constraintWidget28;
                                    z4 = z7;
                                    f5 = f4;
                                    resolutionNode2 = resolutionAnchor;
                                }
                                boolean z35 = z4;
                                float f17 = f5;
                                ResolutionAnchor resolutionAnchor6 = resolutionNode2;
                                float f18 = f12;
                                boolean z36 = z5;
                                ConstraintWidget constraintWidget29 = constraintWidget4;
                                int i18 = i8;
                                return true;
                            }
                            boolean z37 = z4;
                            float f19 = f5;
                            ResolutionAnchor resolutionAnchor7 = resolutionNode2;
                            if (z34 || z5) {
                                if (z34) {
                                    f15 -= f12;
                                } else if (z5) {
                                    f15 -= f12;
                                }
                                ConstraintWidget constraintWidget30 = constraintWidget4;
                                float f20 = f15 / ((float) (i8 + 1));
                                if (z5) {
                                    f20 = i8 > 1 ? f15 / ((float) (i8 - 1)) : f15 / 2.0f;
                                }
                                float f21 = f13;
                                if (constraintWidget4.getVisibility() != 8) {
                                    f21 += f20;
                                }
                                if (z5 && i8 > 1) {
                                    f21 = f13 + ((float) constraintWidget6.mListAnchors[i2].getMargin());
                                }
                                if (!z34 || constraintWidget6 == null) {
                                    constraintWidget = constraintWidget30;
                                    f2 = f21;
                                } else {
                                    constraintWidget = constraintWidget30;
                                    f2 = f21 + ((float) constraintWidget6.mListAnchors[i2].getMargin());
                                }
                                while (constraintWidget != null) {
                                    if (LinearSystem.sMetrics != null) {
                                        boolean z38 = z5;
                                        constraintWidget2 = constraintWidget4;
                                        LinearSystem.sMetrics.nonresolvedWidgets--;
                                        z6 = z38;
                                        i3 = i8;
                                        LinearSystem.sMetrics.resolvedWidgets++;
                                        LinearSystem.sMetrics.chainConnectionResolved++;
                                    } else {
                                        z6 = z5;
                                        constraintWidget2 = constraintWidget4;
                                        i3 = i8;
                                    }
                                    ConstraintWidget constraintWidget31 = constraintWidget.mNextChainWidget[i6];
                                    if (constraintWidget31 != null || constraintWidget == constraintWidget5) {
                                        float width2 = i6 == 0 ? (float) constraintWidget.getWidth() : (float) constraintWidget.getHeight();
                                        float margin2 = constraintWidget != constraintWidget6 ? f2 + ((float) constraintWidget.mListAnchors[i2].getMargin()) : f2;
                                        constraintWidget.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin2);
                                        f3 = f12;
                                        constraintWidget.mListAnchors[i2 + 1].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin2 + width2);
                                        constraintWidget.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem7);
                                        constraintWidget.mListAnchors[i2 + 1].getResolutionNode().addResolvedValue(linearSystem7);
                                        f2 = margin2 + ((float) constraintWidget.mListAnchors[i2 + 1].getMargin()) + width2;
                                        if (constraintWidget31 != null) {
                                            if (constraintWidget31.getVisibility() != 8) {
                                                f2 += f20;
                                            }
                                        }
                                    } else {
                                        f3 = f12;
                                    }
                                    constraintWidget = constraintWidget31;
                                    i8 = i3;
                                    z5 = z6;
                                    constraintWidget4 = constraintWidget2;
                                    f12 = f3;
                                }
                                float f22 = f12;
                                boolean z39 = z5;
                                ConstraintWidget constraintWidget32 = constraintWidget4;
                                int i19 = i8;
                                return true;
                            }
                            float f23 = f12;
                            boolean z40 = z5;
                            ConstraintWidget constraintWidget33 = constraintWidget4;
                            int i20 = i8;
                            return true;
                        }
                        if (constraintWidget14.getParent() != null) {
                            float f24 = f14;
                            ConstraintWidget constraintWidget34 = constraintWidget7;
                            if (constraintWidget14.getParent().mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                                return false;
                            }
                        } else {
                            float f25 = f14;
                            ConstraintWidget constraintWidget35 = constraintWidget7;
                        }
                        float f26 = (f15 + f6) - f7;
                        ConstraintWidget constraintWidget36 = constraintWidget4;
                        float f27 = f13;
                        while (constraintWidget36 != null) {
                            if (LinearSystem.sMetrics != null) {
                                z9 = z2;
                                z8 = z;
                                LinearSystem.sMetrics.nonresolvedWidgets--;
                                LinearSystem.sMetrics.resolvedWidgets++;
                                LinearSystem.sMetrics.chainConnectionResolved++;
                            } else {
                                z9 = z2;
                                z8 = z;
                            }
                            ConstraintWidget constraintWidget37 = constraintWidget36.mNextChainWidget[i6];
                            if (constraintWidget37 != null || constraintWidget36 == constraintWidget5) {
                                float f28 = f26 / ((float) i7);
                                if (f5 > 0.0f) {
                                    f28 = constraintWidget36.mWeight[i6] == -1.0f ? 0.0f : (constraintWidget36.mWeight[i6] * f26) / f5;
                                }
                                if (constraintWidget36.getVisibility() == 8) {
                                    f28 = 0.0f;
                                }
                                float margin3 = f27 + ((float) constraintWidget36.mListAnchors[i2].getMargin());
                                constraintWidget36.mListAnchors[i2].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin3);
                                i4 = i7;
                                constraintWidget36.mListAnchors[i2 + 1].getResolutionNode().resolve(resolutionNode.resolvedTarget, margin3 + f28);
                                LinearSystem linearSystem8 = linearSystem;
                                constraintWidget36.mListAnchors[i2].getResolutionNode().addResolvedValue(linearSystem8);
                                constraintWidget36.mListAnchors[i2 + 1].getResolutionNode().addResolvedValue(linearSystem8);
                                f27 = margin3 + f28 + ((float) constraintWidget36.mListAnchors[i2 + 1].getMargin());
                            } else {
                                LinearSystem linearSystem9 = linearSystem;
                                i4 = i7;
                            }
                            constraintWidget36 = constraintWidget37;
                            z2 = z9;
                            z = z8;
                            i7 = i4;
                        }
                        int i21 = i7;
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            constraintWidget.mLeft.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mLeft);
            constraintWidget.mRight.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mRight);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            constraintWidget.mTop.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mTop);
            constraintWidget.mBottom.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBottom);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                constraintWidget.mBaseline.mSolverVariable = linearSystem.createObjectVariable(constraintWidget.mBaseline);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i2, height);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003e A[RETURN] */
    private static boolean optimizableMatchConstraint(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        char c2 = 1;
        if (constraintWidget.mDimensionRatio != 0.0f) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
            if (i != 0) {
                c2 = 0;
            }
            return dimensionBehaviourArr[c2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? false : false;
        }
        if (i == 0) {
            return constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mMatchConstraintMinWidth == 0 && constraintWidget.mMatchConstraintMaxWidth == 0;
        }
        if (constraintWidget.mMatchConstraintDefaultHeight != 0 || constraintWidget.mMatchConstraintMinHeight != 0 || constraintWidget.mMatchConstraintMaxHeight != 0) {
            return false;
        }
    }

    static void setOptimizedWidget(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedTarget = constraintWidget.getParent().mLeft.getResolutionNode();
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset = (float) i2;
        constraintWidget.mListAnchors[i3].getResolutionNode().state = 1;
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedTarget = constraintWidget.mListAnchors[i3].getResolutionNode();
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset = (float) constraintWidget.getLength(i);
        constraintWidget.mListAnchors[i4].getResolutionNode().state = 1;
    }
}
