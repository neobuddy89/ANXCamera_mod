package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            int i4 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.mHorizontalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0452  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04ac  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04af  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04bc  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0367 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x016b  */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        ArrayList<ConstraintWidget> arrayList;
        SolverVariable solverVariable;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i3;
        ConstraintWidget constraintWidget2;
        int i4;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        ConstraintAnchor constraintAnchor5;
        ArrayList<ConstraintWidget> arrayList2;
        int i5;
        float f2;
        boolean z3;
        int i6;
        ConstraintWidget constraintWidget5;
        boolean z4;
        int i7;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        LinearSystem linearSystem2 = linearSystem;
        ChainHead chainHead2 = chainHead;
        ConstraintWidget constraintWidget6 = chainHead2.mFirst;
        ConstraintWidget constraintWidget7 = chainHead2.mLast;
        ConstraintWidget constraintWidget8 = chainHead2.mFirstVisibleWidget;
        ConstraintWidget constraintWidget9 = chainHead2.mLastVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead2.mHead;
        float f3 = chainHead2.mTotalWeight;
        ConstraintWidget constraintWidget11 = chainHead2.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget12 = chainHead2.mLastMatchConstraintWidget;
        boolean z5 = constraintWidgetContainer2.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z2 = constraintWidget10.mHorizontalChainStyle == 0;
            z = constraintWidget10.mHorizontalChainStyle == 1;
        } else {
            z2 = constraintWidget10.mVerticalChainStyle == 0;
            z = constraintWidget10.mVerticalChainStyle == 1;
        }
        boolean z6 = true;
        boolean z7 = z2;
        ConstraintWidget constraintWidget13 = constraintWidget6;
        boolean z8 = z;
        boolean z9 = z6;
        boolean z10 = false;
        while (true) {
            ConstraintWidget constraintWidget14 = null;
            if (z10) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget13.mListAnchors[i2];
            int i8 = (z5 || z9) ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            ConstraintAnchor constraintAnchor7 = constraintAnchor6.mTarget;
            if (!(constraintAnchor7 == null || constraintWidget13 == constraintWidget6)) {
                margin += constraintAnchor7.getMargin();
            }
            int i9 = margin;
            if (z9 && constraintWidget13 != constraintWidget6 && constraintWidget13 != constraintWidget8) {
                f2 = f3;
                z3 = z10;
                i6 = 6;
            } else if (!z7 || !z5) {
                f2 = f3;
                i6 = i8;
                z3 = z10;
            } else {
                f2 = f3;
                z3 = z10;
                i6 = 4;
            }
            ConstraintAnchor constraintAnchor8 = constraintAnchor6.mTarget;
            if (constraintAnchor8 != null) {
                if (constraintWidget13 == constraintWidget8) {
                    z4 = z7;
                    constraintWidget5 = constraintWidget10;
                    linearSystem2.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, i9, 5);
                } else {
                    constraintWidget5 = constraintWidget10;
                    z4 = z7;
                    linearSystem2.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, i9, 6);
                }
                linearSystem2.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i9, i6);
            } else {
                constraintWidget5 = constraintWidget10;
                z4 = z7;
            }
            if (z5) {
                if (constraintWidget13.getVisibility() == 8 || constraintWidget13.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget13.mListAnchors;
                    i7 = 0;
                    linearSystem2.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem2.addGreaterThan(constraintWidget13.mListAnchors[i2].mSolverVariable, constraintWidgetContainer2.mListAnchors[i2].mSolverVariable, i7, 6);
            }
            ConstraintAnchor constraintAnchor9 = constraintWidget13.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor9 != null) {
                ConstraintWidget constraintWidget15 = constraintAnchor9.mOwner;
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget15.mListAnchors;
                if (constraintAnchorArr2[i2].mTarget != null && constraintAnchorArr2[i2].mTarget.mOwner == constraintWidget13) {
                    constraintWidget14 = constraintWidget15;
                }
            }
            if (constraintWidget14 != null) {
                constraintWidget13 = constraintWidget14;
                z10 = z3;
            } else {
                z10 = true;
            }
            f3 = f2;
            z7 = z4;
            constraintWidget10 = constraintWidget5;
        }
        ConstraintWidget constraintWidget16 = constraintWidget10;
        float f4 = f3;
        boolean z11 = z7;
        if (constraintWidget9 != null) {
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget7.mListAnchors;
            int i10 = i2 + 1;
            if (constraintAnchorArr3[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor10 = constraintWidget9.mListAnchors[i10];
                linearSystem2.addLowerThan(constraintAnchor10.mSolverVariable, constraintAnchorArr3[i10].mTarget.mSolverVariable, -constraintAnchor10.getMargin(), 5);
                if (z5) {
                    int i11 = i2 + 1;
                    SolverVariable solverVariable6 = constraintWidgetContainer2.mListAnchors[i11].mSolverVariable;
                    ConstraintAnchor[] constraintAnchorArr4 = constraintWidget7.mListAnchors;
                    linearSystem2.addGreaterThan(solverVariable6, constraintAnchorArr4[i11].mSolverVariable, constraintAnchorArr4[i11].getMargin(), 6);
                }
                arrayList = chainHead2.mWeightedMatchConstraintsWidgets;
                if (arrayList != null) {
                    int size = arrayList.size();
                    if (size > 1) {
                        float f5 = (!chainHead2.mHasUndefinedWeights || chainHead2.mHasComplexMatchWeights) ? f4 : (float) chainHead2.mWidgetsMatchCount;
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        ConstraintWidget constraintWidget17 = null;
                        int i12 = 0;
                        while (i12 < size) {
                            ConstraintWidget constraintWidget18 = arrayList.get(i12);
                            float f8 = constraintWidget18.mWeight[i];
                            if (f8 < f6) {
                                if (chainHead2.mHasComplexMatchWeights) {
                                    ConstraintAnchor[] constraintAnchorArr5 = constraintWidget18.mListAnchors;
                                    linearSystem2.addEquality(constraintAnchorArr5[i2 + 1].mSolverVariable, constraintAnchorArr5[i2].mSolverVariable, 0, 4);
                                    arrayList2 = arrayList;
                                    i5 = size;
                                    i12++;
                                    size = i5;
                                    arrayList = arrayList2;
                                    f6 = 0.0f;
                                } else {
                                    f8 = 1.0f;
                                    f6 = 0.0f;
                                }
                            }
                            if (f8 == f6) {
                                ConstraintAnchor[] constraintAnchorArr6 = constraintWidget18.mListAnchors;
                                linearSystem2.addEquality(constraintAnchorArr6[i2 + 1].mSolverVariable, constraintAnchorArr6[i2].mSolverVariable, 0, 6);
                                arrayList2 = arrayList;
                                i5 = size;
                                i12++;
                                size = i5;
                                arrayList = arrayList2;
                                f6 = 0.0f;
                            } else {
                                if (constraintWidget17 != null) {
                                    ConstraintAnchor[] constraintAnchorArr7 = constraintWidget17.mListAnchors;
                                    SolverVariable solverVariable7 = constraintAnchorArr7[i2].mSolverVariable;
                                    int i13 = i2 + 1;
                                    SolverVariable solverVariable8 = constraintAnchorArr7[i13].mSolverVariable;
                                    ConstraintAnchor[] constraintAnchorArr8 = constraintWidget18.mListAnchors;
                                    arrayList2 = arrayList;
                                    SolverVariable solverVariable9 = constraintAnchorArr8[i2].mSolverVariable;
                                    SolverVariable solverVariable10 = constraintAnchorArr8[i13].mSolverVariable;
                                    i5 = size;
                                    ArrayRow createRow = linearSystem.createRow();
                                    createRow.createRowEqualMatchDimensions(f7, f5, f8, solverVariable7, solverVariable8, solverVariable9, solverVariable10);
                                    linearSystem2.addConstraint(createRow);
                                } else {
                                    arrayList2 = arrayList;
                                    i5 = size;
                                }
                                f7 = f8;
                                constraintWidget17 = constraintWidget18;
                                i12++;
                                size = i5;
                                arrayList = arrayList2;
                                f6 = 0.0f;
                            }
                        }
                    }
                }
                if (constraintWidget8 == null && (constraintWidget8 == constraintWidget9 || z9)) {
                    ConstraintAnchor[] constraintAnchorArr9 = constraintWidget6.mListAnchors;
                    ConstraintAnchor constraintAnchor11 = constraintAnchorArr9[i2];
                    int i14 = i2 + 1;
                    ConstraintAnchor constraintAnchor12 = constraintWidget7.mListAnchors[i14];
                    SolverVariable solverVariable11 = constraintAnchorArr9[i2].mTarget != null ? constraintAnchorArr9[i2].mTarget.mSolverVariable : null;
                    ConstraintAnchor[] constraintAnchorArr10 = constraintWidget7.mListAnchors;
                    SolverVariable solverVariable12 = constraintAnchorArr10[i14].mTarget != null ? constraintAnchorArr10[i14].mTarget.mSolverVariable : null;
                    if (constraintWidget8 == constraintWidget9) {
                        ConstraintAnchor[] constraintAnchorArr11 = constraintWidget8.mListAnchors;
                        constraintAnchor11 = constraintAnchorArr11[i2];
                        constraintAnchor12 = constraintAnchorArr11[i14];
                    }
                    if (!(solverVariable11 == null || solverVariable12 == null)) {
                        linearSystem.addCentering(constraintAnchor11.mSolverVariable, solverVariable11, constraintAnchor11.getMargin(), i == 0 ? constraintWidget16.mHorizontalBiasPercent : constraintWidget16.mVerticalBiasPercent, solverVariable12, constraintAnchor12.mSolverVariable, constraintAnchor12.getMargin(), 5);
                    }
                } else if (z11 || constraintWidget8 == null) {
                    int i15 = 8;
                    if (z8 && constraintWidget8 != null) {
                        int i16 = chainHead2.mWidgetsMatchCount;
                        boolean z12 = i16 <= 0 && chainHead2.mWidgetsCount == i16;
                        constraintWidget = constraintWidget8;
                        ConstraintWidget constraintWidget19 = constraintWidget;
                        while (constraintWidget != null) {
                            ConstraintWidget constraintWidget20 = constraintWidget.mNextChainWidget[i];
                            while (constraintWidget20 != null && constraintWidget20.getVisibility() == i15) {
                                constraintWidget20 = constraintWidget20.mNextChainWidget[i];
                            }
                            if (constraintWidget == constraintWidget8 || constraintWidget == constraintWidget9 || constraintWidget20 == null) {
                                constraintWidget2 = constraintWidget19;
                                i4 = i15;
                            } else {
                                ConstraintWidget constraintWidget21 = constraintWidget20 == constraintWidget9 ? null : constraintWidget20;
                                ConstraintAnchor constraintAnchor13 = constraintWidget.mListAnchors[i2];
                                SolverVariable solverVariable13 = constraintAnchor13.mSolverVariable;
                                ConstraintAnchor constraintAnchor14 = constraintAnchor13.mTarget;
                                if (constraintAnchor14 != null) {
                                    SolverVariable solverVariable14 = constraintAnchor14.mSolverVariable;
                                }
                                int i17 = i2 + 1;
                                SolverVariable solverVariable15 = constraintWidget19.mListAnchors[i17].mSolverVariable;
                                int margin2 = constraintAnchor13.getMargin();
                                int margin3 = constraintWidget.mListAnchors[i17].getMargin();
                                if (constraintWidget21 != null) {
                                    constraintAnchor4 = constraintWidget21.mListAnchors[i2];
                                    solverVariable3 = constraintAnchor4.mSolverVariable;
                                    ConstraintAnchor constraintAnchor15 = constraintAnchor4.mTarget;
                                    solverVariable2 = constraintAnchor15 != null ? constraintAnchor15.mSolverVariable : null;
                                } else {
                                    constraintAnchor4 = constraintWidget.mListAnchors[i17].mTarget;
                                    solverVariable3 = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                    solverVariable2 = constraintWidget.mListAnchors[i17].mSolverVariable;
                                }
                                if (constraintAnchor4 != null) {
                                    margin3 += constraintAnchor4.getMargin();
                                }
                                int i18 = margin3;
                                if (constraintWidget19 != null) {
                                    margin2 += constraintWidget19.mListAnchors[i17].getMargin();
                                }
                                int i19 = margin2;
                                int i20 = z12 ? 6 : 4;
                                if (solverVariable13 == null || solverVariable15 == null || solverVariable3 == null || solverVariable2 == null) {
                                    constraintWidget3 = constraintWidget21;
                                    constraintWidget2 = constraintWidget19;
                                    i4 = 8;
                                } else {
                                    constraintWidget3 = constraintWidget21;
                                    int i21 = i18;
                                    constraintWidget2 = constraintWidget19;
                                    i4 = 8;
                                    linearSystem.addCentering(solverVariable13, solverVariable15, i19, 0.5f, solverVariable3, solverVariable2, i21, i20);
                                }
                                constraintWidget20 = constraintWidget3;
                            }
                            if (constraintWidget.getVisibility() == i4) {
                                constraintWidget = constraintWidget2;
                            }
                            i15 = i4;
                            constraintWidget19 = constraintWidget;
                            constraintWidget = constraintWidget20;
                        }
                        ConstraintAnchor constraintAnchor16 = constraintWidget8.mListAnchors[i2];
                        constraintAnchor = constraintWidget6.mListAnchors[i2].mTarget;
                        int i22 = i2 + 1;
                        constraintAnchor2 = constraintWidget9.mListAnchors[i22];
                        constraintAnchor3 = constraintWidget7.mListAnchors[i22].mTarget;
                        if (constraintAnchor != null) {
                            i3 = 5;
                        } else if (constraintWidget8 != constraintWidget9) {
                            i3 = 5;
                            linearSystem2.addEquality(constraintAnchor16.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor16.getMargin(), 5);
                        } else {
                            i3 = 5;
                            if (constraintAnchor3 != null) {
                                linearSystem.addCentering(constraintAnchor16.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor16.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                            }
                        }
                        if (!(constraintAnchor3 == null || constraintWidget8 == constraintWidget9)) {
                            linearSystem2.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                        }
                    }
                } else {
                    int i23 = chainHead2.mWidgetsMatchCount;
                    boolean z13 = i23 > 0 && chainHead2.mWidgetsCount == i23;
                    ConstraintWidget constraintWidget22 = constraintWidget8;
                    ConstraintWidget constraintWidget23 = constraintWidget22;
                    while (constraintWidget22 != null) {
                        ConstraintWidget constraintWidget24 = constraintWidget22.mNextChainWidget[i];
                        while (true) {
                            if (constraintWidget24 != null) {
                                if (constraintWidget24.getVisibility() != 8) {
                                    break;
                                }
                                constraintWidget24 = constraintWidget24.mNextChainWidget[i];
                            } else {
                                break;
                            }
                        }
                        if (constraintWidget24 != null || constraintWidget22 == constraintWidget9) {
                            ConstraintAnchor constraintAnchor17 = constraintWidget22.mListAnchors[i2];
                            SolverVariable solverVariable16 = constraintAnchor17.mSolverVariable;
                            ConstraintAnchor constraintAnchor18 = constraintAnchor17.mTarget;
                            SolverVariable solverVariable17 = constraintAnchor18 != null ? constraintAnchor18.mSolverVariable : null;
                            if (constraintWidget23 != constraintWidget22) {
                                solverVariable17 = constraintWidget23.mListAnchors[i2 + 1].mSolverVariable;
                            } else if (constraintWidget22 == constraintWidget8 && constraintWidget23 == constraintWidget22) {
                                ConstraintAnchor[] constraintAnchorArr12 = constraintWidget6.mListAnchors;
                                solverVariable17 = constraintAnchorArr12[i2].mTarget != null ? constraintAnchorArr12[i2].mTarget.mSolverVariable : null;
                            }
                            int margin4 = constraintAnchor17.getMargin();
                            int i24 = i2 + 1;
                            int margin5 = constraintWidget22.mListAnchors[i24].getMargin();
                            if (constraintWidget24 != null) {
                                constraintAnchor5 = constraintWidget24.mListAnchors[i2];
                                solverVariable5 = constraintAnchor5.mSolverVariable;
                                solverVariable4 = constraintWidget22.mListAnchors[i24].mSolverVariable;
                            } else {
                                constraintAnchor5 = constraintWidget7.mListAnchors[i24].mTarget;
                                solverVariable5 = constraintAnchor5 != null ? constraintAnchor5.mSolverVariable : null;
                                solverVariable4 = constraintWidget22.mListAnchors[i24].mSolverVariable;
                            }
                            if (constraintAnchor5 != null) {
                                margin5 += constraintAnchor5.getMargin();
                            }
                            if (constraintWidget23 != null) {
                                margin4 += constraintWidget23.mListAnchors[i24].getMargin();
                            }
                            if (!(solverVariable16 == null || solverVariable17 == null || solverVariable5 == null || solverVariable4 == null)) {
                                if (constraintWidget22 == constraintWidget8) {
                                    margin4 = constraintWidget8.mListAnchors[i2].getMargin();
                                }
                                int i25 = margin4;
                                int margin6 = constraintWidget22 == constraintWidget9 ? constraintWidget9.mListAnchors[i24].getMargin() : margin5;
                                int i26 = i25;
                                SolverVariable solverVariable18 = solverVariable5;
                                SolverVariable solverVariable19 = solverVariable4;
                                int i27 = margin6;
                                constraintWidget4 = constraintWidget24;
                                linearSystem.addCentering(solverVariable16, solverVariable17, i26, 0.5f, solverVariable18, solverVariable19, i27, z13 ? 6 : 4);
                                if (constraintWidget22.getVisibility() == 8) {
                                    constraintWidget23 = constraintWidget22;
                                }
                                constraintWidget22 = constraintWidget4;
                            }
                        }
                        constraintWidget4 = constraintWidget24;
                        if (constraintWidget22.getVisibility() == 8) {
                        }
                        constraintWidget22 = constraintWidget4;
                    }
                }
                if ((!z11 || z8) && constraintWidget8 != null) {
                    ConstraintAnchor constraintAnchor19 = constraintWidget8.mListAnchors[i2];
                    int i28 = i2 + 1;
                    ConstraintAnchor constraintAnchor20 = constraintWidget9.mListAnchors[i28];
                    ConstraintAnchor constraintAnchor21 = constraintAnchor19.mTarget;
                    solverVariable = constraintAnchor21 == null ? constraintAnchor21.mSolverVariable : null;
                    ConstraintAnchor constraintAnchor22 = constraintAnchor20.mTarget;
                    SolverVariable solverVariable20 = constraintAnchor22 == null ? constraintAnchor22.mSolverVariable : null;
                    if (constraintWidget7 != constraintWidget9) {
                        ConstraintAnchor constraintAnchor23 = constraintWidget7.mListAnchors[i28].mTarget;
                        solverVariable20 = constraintAnchor23 != null ? constraintAnchor23.mSolverVariable : null;
                    }
                    SolverVariable solverVariable21 = solverVariable20;
                    if (constraintWidget8 == constraintWidget9) {
                        ConstraintAnchor[] constraintAnchorArr13 = constraintWidget8.mListAnchors;
                        ConstraintAnchor constraintAnchor24 = constraintAnchorArr13[i2];
                        constraintAnchor20 = constraintAnchorArr13[i28];
                        constraintAnchor19 = constraintAnchor24;
                    }
                    if (solverVariable != null && solverVariable21 != null) {
                        int margin7 = constraintAnchor19.getMargin();
                        if (constraintWidget9 != null) {
                            constraintWidget7 = constraintWidget9;
                        }
                        linearSystem.addCentering(constraintAnchor19.mSolverVariable, solverVariable, margin7, 0.5f, solverVariable21, constraintAnchor20.mSolverVariable, constraintWidget7.mListAnchors[i28].getMargin(), 5);
                        return;
                    }
                }
                return;
            }
        }
        if (z5) {
        }
        arrayList = chainHead2.mWeightedMatchConstraintsWidgets;
        if (arrayList != null) {
        }
        if (constraintWidget8 == null) {
        }
        if (z11) {
        }
        int i152 = 8;
        int i162 = chainHead2.mWidgetsMatchCount;
        if (i162 <= 0) {
        }
        constraintWidget = constraintWidget8;
        ConstraintWidget constraintWidget192 = constraintWidget;
        while (constraintWidget != null) {
        }
        ConstraintAnchor constraintAnchor162 = constraintWidget8.mListAnchors[i2];
        constraintAnchor = constraintWidget6.mListAnchors[i2].mTarget;
        int i222 = i2 + 1;
        constraintAnchor2 = constraintWidget9.mListAnchors[i222];
        constraintAnchor3 = constraintWidget7.mListAnchors[i222].mTarget;
        if (constraintAnchor != null) {
        }
        linearSystem2.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
        if (!z11) {
        }
        ConstraintAnchor constraintAnchor192 = constraintWidget8.mListAnchors[i2];
        int i282 = i2 + 1;
        ConstraintAnchor constraintAnchor202 = constraintWidget9.mListAnchors[i282];
        ConstraintAnchor constraintAnchor212 = constraintAnchor192.mTarget;
        if (constraintAnchor212 == null) {
        }
        ConstraintAnchor constraintAnchor222 = constraintAnchor202.mTarget;
        if (constraintAnchor222 == null) {
        }
        if (constraintWidget7 != constraintWidget9) {
        }
        SolverVariable solverVariable212 = solverVariable20;
        if (constraintWidget8 == constraintWidget9) {
        }
        if (solverVariable != null) {
        }
    }
}
