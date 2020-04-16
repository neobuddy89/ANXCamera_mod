package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        ChainHead[] chainHeadArr;
        int i2;
        int i3;
        if (i == 0) {
            i3 = 0;
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            i3 = 2;
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:286:0x0634 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0646  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x064b  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0652  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0657  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x065a  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x066e  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0672  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x067e  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0681 A[ADDED_TO_REGION] */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ArrayList<ConstraintWidget> arrayList;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget7;
        int i3;
        ConstraintWidget constraintWidget8;
        ConstraintWidget constraintWidget9;
        ConstraintWidget constraintWidget10;
        int i4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        ConstraintAnchor constraintAnchor5;
        ConstraintAnchor constraintAnchor6;
        ConstraintAnchor constraintAnchor7;
        ConstraintWidget constraintWidget11;
        ConstraintWidget constraintWidget12;
        ArrayList<ConstraintWidget> arrayList2;
        ConstraintWidget constraintWidget13;
        float f2;
        int i5;
        ConstraintWidget constraintWidget14;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        LinearSystem linearSystem2 = linearSystem;
        ChainHead chainHead2 = chainHead;
        ConstraintWidget constraintWidget15 = chainHead2.mFirst;
        ConstraintWidget constraintWidget16 = chainHead2.mLast;
        ConstraintWidget constraintWidget17 = chainHead2.mFirstVisibleWidget;
        ConstraintWidget constraintWidget18 = chainHead2.mLastVisibleWidget;
        ConstraintWidget constraintWidget19 = chainHead2.mHead;
        float f3 = chainHead2.mTotalWeight;
        ConstraintWidget constraintWidget20 = chainHead2.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget21 = chainHead2.mLastMatchConstraintWidget;
        ConstraintWidget constraintWidget22 = constraintWidget15;
        boolean z5 = constraintWidgetContainer2.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z2 = constraintWidget19.mHorizontalChainStyle == 0;
            boolean z6 = constraintWidget19.mHorizontalChainStyle == 1;
            z3 = false;
            z = constraintWidget19.mHorizontalChainStyle == 2;
            constraintWidget = constraintWidget22;
            z4 = z6;
        } else {
            z2 = constraintWidget19.mVerticalChainStyle == 0;
            boolean z7 = constraintWidget19.mVerticalChainStyle == 1;
            z3 = false;
            z = constraintWidget19.mVerticalChainStyle == 2;
            constraintWidget = constraintWidget22;
            z4 = z7;
        }
        while (!z3) {
            ConstraintAnchor constraintAnchor8 = constraintWidget.mListAnchors[i2];
            int i6 = 4;
            if (z5 || z) {
                i6 = 1;
            }
            int margin = constraintAnchor8.getMargin();
            int margin2 = (constraintAnchor8.mTarget == null || constraintWidget == constraintWidget15) ? margin : margin + constraintAnchor8.mTarget.getMargin();
            int i7 = (!z || constraintWidget == constraintWidget15 || constraintWidget == constraintWidget17) ? (!z2 || !z5) ? i6 : 4 : 6;
            if (constraintAnchor8.mTarget != null) {
                if (constraintWidget == constraintWidget17) {
                    f2 = f3;
                    linearSystem2.addGreaterThan(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, margin2, 5);
                } else {
                    f2 = f3;
                    linearSystem2.addGreaterThan(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, margin2, 6);
                }
                i5 = i7;
                linearSystem2.addEquality(constraintAnchor8.mSolverVariable, constraintAnchor8.mTarget.mSolverVariable, margin2, i5);
            } else {
                f2 = f3;
                i5 = i7;
            }
            if (z5) {
                if (constraintWidget.getVisibility() == 8 || constraintWidget.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintAnchor constraintAnchor9 = constraintAnchor8;
                    int i8 = i5;
                } else {
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    int i9 = i5;
                    linearSystem2.addGreaterThan(constraintWidget.mListAnchors[i2 + 1].mSolverVariable, constraintWidget.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem2.addGreaterThan(constraintWidget.mListAnchors[i2].mSolverVariable, constraintWidgetContainer2.mListAnchors[i2].mSolverVariable, 0, 6);
            } else {
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i10 = i5;
            }
            ConstraintAnchor constraintAnchor12 = constraintWidget.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor12 != null) {
                ConstraintWidget constraintWidget23 = constraintAnchor12.mOwner;
                constraintWidget14 = (constraintWidget23.mListAnchors[i2].mTarget == null || constraintWidget23.mListAnchors[i2].mTarget.mOwner != constraintWidget) ? null : constraintWidget23;
            } else {
                constraintWidget14 = null;
            }
            if (constraintWidget14 != null) {
                constraintWidget = constraintWidget14;
            } else {
                z3 = true;
            }
            f3 = f2;
        }
        float f4 = f3;
        if (constraintWidget18 != null && constraintWidget16.mListAnchors[i2 + 1].mTarget != null) {
            ConstraintAnchor constraintAnchor13 = constraintWidget18.mListAnchors[i2 + 1];
            linearSystem2.addLowerThan(constraintAnchor13.mSolverVariable, constraintWidget16.mListAnchors[i2 + 1].mTarget.mSolverVariable, -constraintAnchor13.getMargin(), 5);
        }
        if (z5) {
            linearSystem2.addGreaterThan(constraintWidgetContainer2.mListAnchors[i2 + 1].mSolverVariable, constraintWidget16.mListAnchors[i2 + 1].mSolverVariable, constraintWidget16.mListAnchors[i2 + 1].getMargin(), 6);
        }
        ArrayList<ConstraintWidget> arrayList3 = chainHead2.mWeightedMatchConstraintsWidgets;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            if (size > 1) {
                ConstraintWidget constraintWidget24 = null;
                float f5 = 0.0f;
                float f6 = (!chainHead2.mHasUndefinedWeights || chainHead2.mHasComplexMatchWeights) ? f4 : (float) chainHead2.mWidgetsMatchCount;
                int i11 = 0;
                while (i11 < size) {
                    ConstraintWidget constraintWidget25 = arrayList3.get(i11);
                    int i12 = size;
                    float f7 = constraintWidget25.mWeight[i];
                    if (f7 < 0.0f) {
                        float f8 = f7;
                        if (chainHead2.mHasComplexMatchWeights) {
                            arrayList2 = arrayList3;
                            constraintWidget12 = constraintWidget;
                            constraintWidget11 = constraintWidget21;
                            linearSystem2.addEquality(constraintWidget25.mListAnchors[i2 + 1].mSolverVariable, constraintWidget25.mListAnchors[i2].mSolverVariable, 0, 4);
                            constraintWidget13 = constraintWidget20;
                            i11++;
                            ConstraintWidgetContainer constraintWidgetContainer3 = constraintWidgetContainer;
                            constraintWidget20 = constraintWidget13;
                            size = i12;
                            arrayList3 = arrayList2;
                            constraintWidget = constraintWidget12;
                            constraintWidget21 = constraintWidget11;
                        } else {
                            arrayList2 = arrayList3;
                            constraintWidget12 = constraintWidget;
                            constraintWidget11 = constraintWidget21;
                            f7 = 1.0f;
                        }
                    } else {
                        float f9 = f7;
                        arrayList2 = arrayList3;
                        constraintWidget12 = constraintWidget;
                        constraintWidget11 = constraintWidget21;
                    }
                    if (f7 == 0.0f) {
                        constraintWidget13 = constraintWidget20;
                        linearSystem2.addEquality(constraintWidget25.mListAnchors[i2 + 1].mSolverVariable, constraintWidget25.mListAnchors[i2].mSolverVariable, 0, 6);
                    } else {
                        constraintWidget13 = constraintWidget20;
                        if (constraintWidget24 != null) {
                            SolverVariable solverVariable8 = constraintWidget24.mListAnchors[i2].mSolverVariable;
                            SolverVariable solverVariable9 = constraintWidget24.mListAnchors[i2 + 1].mSolverVariable;
                            SolverVariable solverVariable10 = constraintWidget25.mListAnchors[i2].mSolverVariable;
                            SolverVariable solverVariable11 = constraintWidget25.mListAnchors[i2 + 1].mSolverVariable;
                            ConstraintWidget constraintWidget26 = constraintWidget24;
                            ArrayRow createRow = linearSystem.createRow();
                            createRow.createRowEqualMatchDimensions(f5, f6, f7, solverVariable8, solverVariable9, solverVariable10, solverVariable11);
                            linearSystem2.addConstraint(createRow);
                        } else {
                            ConstraintWidget constraintWidget27 = constraintWidget24;
                        }
                        constraintWidget24 = constraintWidget25;
                        f5 = f7;
                    }
                    i11++;
                    ConstraintWidgetContainer constraintWidgetContainer32 = constraintWidgetContainer;
                    constraintWidget20 = constraintWidget13;
                    size = i12;
                    arrayList3 = arrayList2;
                    constraintWidget = constraintWidget12;
                    constraintWidget21 = constraintWidget11;
                }
                int i13 = size;
                ConstraintWidget constraintWidget28 = constraintWidget24;
                arrayList = arrayList3;
                constraintWidget3 = constraintWidget;
                constraintWidget2 = constraintWidget21;
                ConstraintWidget constraintWidget29 = constraintWidget20;
                float f10 = f6;
            } else {
                int i14 = size;
                arrayList = arrayList3;
                constraintWidget3 = constraintWidget;
                constraintWidget2 = constraintWidget21;
                ConstraintWidget constraintWidget30 = constraintWidget20;
            }
        } else {
            arrayList = arrayList3;
            constraintWidget3 = constraintWidget;
            constraintWidget2 = constraintWidget21;
            ConstraintWidget constraintWidget31 = constraintWidget20;
        }
        if (constraintWidget17 == null) {
            ConstraintWidget constraintWidget32 = constraintWidget19;
            ArrayList<ConstraintWidget> arrayList4 = arrayList;
            ConstraintWidget constraintWidget33 = constraintWidget3;
            ConstraintWidget constraintWidget34 = constraintWidget2;
        } else if (constraintWidget17 == constraintWidget18 || z) {
            ConstraintAnchor constraintAnchor14 = constraintWidget15.mListAnchors[i2];
            ConstraintAnchor constraintAnchor15 = constraintWidget16.mListAnchors[i2 + 1];
            SolverVariable solverVariable12 = constraintWidget15.mListAnchors[i2].mTarget != null ? constraintWidget15.mListAnchors[i2].mTarget.mSolverVariable : null;
            SolverVariable solverVariable13 = constraintWidget16.mListAnchors[i2 + 1].mTarget != null ? constraintWidget16.mListAnchors[i2 + 1].mTarget.mSolverVariable : null;
            if (constraintWidget17 == constraintWidget18) {
                constraintAnchor6 = constraintWidget17.mListAnchors[i2];
                constraintAnchor7 = constraintWidget17.mListAnchors[i2 + 1];
            } else {
                constraintAnchor6 = constraintAnchor14;
                constraintAnchor7 = constraintAnchor15;
            }
            if (solverVariable12 == null || solverVariable13 == null) {
                ConstraintAnchor constraintAnchor16 = constraintAnchor7;
                ConstraintAnchor constraintAnchor17 = constraintAnchor6;
                ConstraintWidget constraintWidget35 = constraintWidget19;
                ArrayList<ConstraintWidget> arrayList5 = arrayList;
                ConstraintWidget constraintWidget36 = constraintWidget3;
                ConstraintWidget constraintWidget37 = constraintWidget2;
                if ((!z2 || z4) && constraintWidget17 != null) {
                    ConstraintAnchor constraintAnchor18 = constraintWidget17.mListAnchors[i2];
                    ConstraintAnchor constraintAnchor19 = constraintWidget18.mListAnchors[i2 + 1];
                    solverVariable = constraintAnchor18.mTarget == null ? constraintAnchor18.mTarget.mSolverVariable : null;
                    SolverVariable solverVariable14 = constraintAnchor19.mTarget == null ? constraintAnchor19.mTarget.mSolverVariable : null;
                    if (constraintWidget16 == constraintWidget18) {
                        ConstraintAnchor constraintAnchor20 = constraintWidget16.mListAnchors[i2 + 1];
                        solverVariable2 = constraintAnchor20.mTarget != null ? constraintAnchor20.mTarget.mSolverVariable : null;
                    } else {
                        solverVariable2 = solverVariable14;
                    }
                    if (constraintWidget17 != constraintWidget18) {
                        constraintAnchor18 = constraintWidget17.mListAnchors[i2];
                        constraintAnchor = constraintWidget17.mListAnchors[i2 + 1];
                    } else {
                        constraintAnchor = constraintAnchor19;
                    }
                    if (solverVariable != null || solverVariable2 == null) {
                        ConstraintAnchor constraintAnchor21 = constraintAnchor;
                    }
                    int margin3 = constraintAnchor18.getMargin();
                    if (constraintWidget18 == null) {
                        constraintWidget18 = constraintWidget16;
                    }
                    ConstraintAnchor constraintAnchor22 = constraintAnchor;
                    linearSystem.addCentering(constraintAnchor18.mSolverVariable, solverVariable, margin3, 0.5f, solverVariable2, constraintAnchor.mSolverVariable, constraintWidget18.mListAnchors[i2 + 1].getMargin(), 5);
                    return;
                }
                return;
            }
            ArrayList<ConstraintWidget> arrayList6 = arrayList;
            ConstraintWidget constraintWidget38 = constraintWidget3;
            ConstraintAnchor constraintAnchor23 = constraintAnchor7;
            ConstraintWidget constraintWidget39 = constraintWidget2;
            ConstraintAnchor constraintAnchor24 = constraintAnchor6;
            ConstraintWidget constraintWidget40 = constraintWidget19;
            linearSystem.addCentering(constraintAnchor6.mSolverVariable, solverVariable12, constraintAnchor6.getMargin(), i == 0 ? constraintWidget19.mHorizontalBiasPercent : constraintWidget19.mVerticalBiasPercent, solverVariable13, constraintAnchor7.mSolverVariable, constraintAnchor7.getMargin(), 5);
            if (!z2) {
            }
            ConstraintAnchor constraintAnchor182 = constraintWidget17.mListAnchors[i2];
            ConstraintAnchor constraintAnchor192 = constraintWidget18.mListAnchors[i2 + 1];
            solverVariable = constraintAnchor182.mTarget == null ? constraintAnchor182.mTarget.mSolverVariable : null;
            if (constraintAnchor192.mTarget == null) {
            }
            if (constraintWidget16 == constraintWidget18) {
            }
            if (constraintWidget17 != constraintWidget18) {
            }
            if (solverVariable != null) {
            }
            ConstraintAnchor constraintAnchor212 = constraintAnchor;
        } else {
            ConstraintWidget constraintWidget41 = constraintWidget19;
            ArrayList<ConstraintWidget> arrayList7 = arrayList;
            ConstraintWidget constraintWidget42 = constraintWidget3;
            ConstraintWidget constraintWidget43 = constraintWidget2;
        }
        if (!z2 || constraintWidget17 == null) {
            int i15 = 8;
            if (z4 && constraintWidget17 != null) {
                ConstraintWidget constraintWidget44 = constraintWidget17;
                ConstraintWidget constraintWidget45 = constraintWidget17;
                boolean z8 = chainHead2.mWidgetsMatchCount > 0 && chainHead2.mWidgetsCount == chainHead2.mWidgetsMatchCount;
                ConstraintWidget constraintWidget46 = constraintWidget44;
                ConstraintWidget constraintWidget47 = constraintWidget45;
                while (constraintWidget46 != null) {
                    ConstraintWidget constraintWidget48 = constraintWidget46.mNextChainWidget[i];
                    while (constraintWidget48 != null && constraintWidget48.getVisibility() == i15) {
                        constraintWidget48 = constraintWidget48.mNextChainWidget[i];
                    }
                    if (constraintWidget46 == constraintWidget17 || constraintWidget46 == constraintWidget18 || constraintWidget48 == null) {
                        constraintWidget5 = constraintWidget46;
                        constraintWidget4 = constraintWidget47;
                        constraintWidget6 = constraintWidget48;
                    } else {
                        ConstraintWidget constraintWidget49 = constraintWidget48 == constraintWidget18 ? null : constraintWidget48;
                        ConstraintAnchor constraintAnchor25 = constraintWidget46.mListAnchors[i2];
                        SolverVariable solverVariable15 = constraintAnchor25.mSolverVariable;
                        if (constraintAnchor25.mTarget != null) {
                            SolverVariable solverVariable16 = constraintAnchor25.mTarget.mSolverVariable;
                        }
                        SolverVariable solverVariable17 = constraintWidget47.mListAnchors[i2 + 1].mSolverVariable;
                        SolverVariable solverVariable18 = null;
                        int margin4 = constraintAnchor25.getMargin();
                        int margin5 = constraintWidget46.mListAnchors[i2 + 1].getMargin();
                        if (constraintWidget49 != null) {
                            ConstraintAnchor constraintAnchor26 = constraintWidget49.mListAnchors[i2];
                            SolverVariable solverVariable19 = constraintAnchor26.mSolverVariable;
                            solverVariable4 = constraintAnchor26.mTarget != null ? constraintAnchor26.mTarget.mSolverVariable : null;
                            solverVariable3 = solverVariable19;
                            constraintAnchor4 = constraintAnchor26;
                        } else {
                            ConstraintAnchor constraintAnchor27 = constraintWidget46.mListAnchors[i2 + 1].mTarget;
                            if (constraintAnchor27 != null) {
                                solverVariable18 = constraintAnchor27.mSolverVariable;
                            }
                            constraintAnchor4 = constraintAnchor27;
                            solverVariable4 = constraintWidget46.mListAnchors[i2 + 1].mSolverVariable;
                            solverVariable3 = solverVariable18;
                        }
                        if (constraintAnchor4 != null) {
                            margin5 += constraintAnchor4.getMargin();
                        }
                        if (constraintWidget47 != null) {
                            margin4 += constraintWidget47.mListAnchors[i2 + 1].getMargin();
                        }
                        int i16 = z8 ? 6 : 4;
                        if (solverVariable15 == null || solverVariable17 == null || solverVariable3 == null || solverVariable4 == null) {
                            SolverVariable solverVariable20 = solverVariable17;
                            SolverVariable solverVariable21 = solverVariable15;
                            ConstraintAnchor constraintAnchor28 = constraintAnchor25;
                            constraintWidget7 = constraintWidget49;
                            constraintWidget5 = constraintWidget46;
                            constraintWidget4 = constraintWidget47;
                        } else {
                            SolverVariable solverVariable22 = solverVariable17;
                            SolverVariable solverVariable23 = solverVariable15;
                            ConstraintAnchor constraintAnchor29 = constraintAnchor25;
                            constraintWidget7 = constraintWidget49;
                            constraintWidget5 = constraintWidget46;
                            constraintWidget4 = constraintWidget47;
                            linearSystem.addCentering(solverVariable15, solverVariable17, margin4, 0.5f, solverVariable3, solverVariable4, margin5, i16);
                        }
                        constraintWidget6 = constraintWidget7;
                    }
                    constraintWidget47 = constraintWidget5.getVisibility() != 8 ? constraintWidget5 : constraintWidget4;
                    constraintWidget46 = constraintWidget6;
                    i15 = 8;
                }
                ConstraintWidget constraintWidget50 = constraintWidget46;
                ConstraintWidget constraintWidget51 = constraintWidget47;
                ConstraintAnchor constraintAnchor30 = constraintWidget17.mListAnchors[i2];
                ConstraintAnchor constraintAnchor31 = constraintWidget15.mListAnchors[i2].mTarget;
                ConstraintAnchor constraintAnchor32 = constraintWidget18.mListAnchors[i2 + 1];
                ConstraintAnchor constraintAnchor33 = constraintWidget16.mListAnchors[i2 + 1].mTarget;
                if (constraintAnchor31 == null) {
                    constraintAnchor3 = constraintAnchor33;
                    constraintAnchor2 = constraintAnchor32;
                    ConstraintAnchor constraintAnchor34 = constraintAnchor31;
                } else if (constraintWidget17 != constraintWidget18) {
                    linearSystem2.addEquality(constraintAnchor30.mSolverVariable, constraintAnchor31.mSolverVariable, constraintAnchor30.getMargin(), 5);
                    constraintAnchor3 = constraintAnchor33;
                    constraintAnchor2 = constraintAnchor32;
                    ConstraintAnchor constraintAnchor35 = constraintAnchor31;
                } else if (constraintAnchor33 != null) {
                    constraintAnchor3 = constraintAnchor33;
                    constraintAnchor2 = constraintAnchor32;
                    ConstraintAnchor constraintAnchor36 = constraintAnchor31;
                    linearSystem.addCentering(constraintAnchor30.mSolverVariable, constraintAnchor31.mSolverVariable, constraintAnchor30.getMargin(), 0.5f, constraintAnchor32.mSolverVariable, constraintAnchor33.mSolverVariable, constraintAnchor32.getMargin(), 5);
                } else {
                    constraintAnchor3 = constraintAnchor33;
                    constraintAnchor2 = constraintAnchor32;
                    ConstraintAnchor constraintAnchor37 = constraintAnchor31;
                }
                ConstraintAnchor constraintAnchor38 = constraintAnchor3;
                if (constraintAnchor38 == null || constraintWidget17 == constraintWidget18) {
                    ConstraintAnchor constraintAnchor39 = constraintAnchor2;
                } else {
                    ConstraintAnchor constraintAnchor40 = constraintAnchor2;
                    linearSystem2.addEquality(constraintAnchor40.mSolverVariable, constraintAnchor38.mSolverVariable, -constraintAnchor40.getMargin(), 5);
                }
                ConstraintWidget constraintWidget52 = constraintWidget50;
            }
            if (!z2) {
            }
            ConstraintAnchor constraintAnchor1822 = constraintWidget17.mListAnchors[i2];
            ConstraintAnchor constraintAnchor1922 = constraintWidget18.mListAnchors[i2 + 1];
            solverVariable = constraintAnchor1822.mTarget == null ? constraintAnchor1822.mTarget.mSolverVariable : null;
            if (constraintAnchor1922.mTarget == null) {
            }
            if (constraintWidget16 == constraintWidget18) {
            }
            if (constraintWidget17 != constraintWidget18) {
            }
            if (solverVariable != null) {
            }
            ConstraintAnchor constraintAnchor2122 = constraintAnchor;
        }
        ConstraintWidget constraintWidget53 = constraintWidget17;
        ConstraintWidget constraintWidget54 = constraintWidget17;
        boolean z9 = chainHead2.mWidgetsMatchCount > 0 && chainHead2.mWidgetsCount == chainHead2.mWidgetsMatchCount;
        ConstraintWidget constraintWidget55 = constraintWidget53;
        ConstraintWidget constraintWidget56 = constraintWidget54;
        while (constraintWidget55 != null) {
            ConstraintWidget constraintWidget57 = constraintWidget55.mNextChainWidget[i];
            while (true) {
                if (constraintWidget57 == null) {
                    i3 = 8;
                    break;
                }
                i3 = 8;
                if (constraintWidget57.getVisibility() != 8) {
                    break;
                }
                constraintWidget57 = constraintWidget57.mNextChainWidget[i];
            }
            if (constraintWidget57 != null || constraintWidget55 == constraintWidget18) {
                ConstraintAnchor constraintAnchor41 = constraintWidget55.mListAnchors[i2];
                SolverVariable solverVariable24 = constraintAnchor41.mSolverVariable;
                SolverVariable solverVariable25 = constraintAnchor41.mTarget != null ? constraintAnchor41.mTarget.mSolverVariable : null;
                if (constraintWidget56 != constraintWidget55) {
                    solverVariable5 = constraintWidget56.mListAnchors[i2 + 1].mSolverVariable;
                } else if (constraintWidget55 == constraintWidget17 && constraintWidget56 == constraintWidget55) {
                    solverVariable5 = constraintWidget15.mListAnchors[i2].mTarget != null ? constraintWidget15.mListAnchors[i2].mTarget.mSolverVariable : null;
                } else {
                    solverVariable5 = solverVariable25;
                }
                SolverVariable solverVariable26 = null;
                int margin6 = constraintAnchor41.getMargin();
                int margin7 = constraintWidget55.mListAnchors[i2 + 1].getMargin();
                if (constraintWidget57 != null) {
                    ConstraintAnchor constraintAnchor42 = constraintWidget57.mListAnchors[i2];
                    constraintAnchor5 = constraintAnchor42;
                    solverVariable7 = constraintAnchor42.mSolverVariable;
                    solverVariable6 = constraintWidget55.mListAnchors[i2 + 1].mSolverVariable;
                } else {
                    ConstraintAnchor constraintAnchor43 = constraintWidget16.mListAnchors[i2 + 1].mTarget;
                    if (constraintAnchor43 != null) {
                        solverVariable26 = constraintAnchor43.mSolverVariable;
                    }
                    constraintAnchor5 = constraintAnchor43;
                    solverVariable7 = solverVariable26;
                    solverVariable6 = constraintWidget55.mListAnchors[i2 + 1].mSolverVariable;
                }
                if (constraintAnchor5 != null) {
                    margin7 += constraintAnchor5.getMargin();
                }
                if (constraintWidget56 != null) {
                    margin6 += constraintWidget56.mListAnchors[i2 + 1].getMargin();
                }
                if (solverVariable24 == null || solverVariable5 == null || solverVariable7 == null || solverVariable6 == null) {
                    int i17 = margin7;
                    SolverVariable solverVariable27 = solverVariable24;
                    ConstraintAnchor constraintAnchor44 = constraintAnchor41;
                    constraintWidget10 = constraintWidget57;
                    constraintWidget9 = constraintWidget55;
                    constraintWidget8 = constraintWidget56;
                    i4 = 8;
                } else {
                    int margin8 = constraintWidget55 == constraintWidget17 ? constraintWidget17.mListAnchors[i2].getMargin() : margin6;
                    int margin9 = constraintWidget55 == constraintWidget18 ? constraintWidget18.mListAnchors[i2 + 1].getMargin() : margin7;
                    SolverVariable solverVariable28 = solverVariable24;
                    int i18 = margin7;
                    i4 = 8;
                    ConstraintAnchor constraintAnchor45 = constraintAnchor41;
                    constraintWidget10 = constraintWidget57;
                    constraintWidget9 = constraintWidget55;
                    constraintWidget8 = constraintWidget56;
                    linearSystem.addCentering(solverVariable24, solverVariable5, margin8, 0.5f, solverVariable7, solverVariable6, margin9, z9 ? 6 : 4);
                }
            } else {
                i4 = i3;
                constraintWidget10 = constraintWidget57;
                constraintWidget9 = constraintWidget55;
                constraintWidget8 = constraintWidget56;
            }
            constraintWidget56 = constraintWidget9.getVisibility() != i4 ? constraintWidget9 : constraintWidget8;
            constraintWidget55 = constraintWidget10;
            ConstraintWidget constraintWidget58 = constraintWidget10;
        }
        ConstraintWidget constraintWidget59 = constraintWidget56;
        ConstraintWidget constraintWidget60 = constraintWidget55;
        if (!z2) {
        }
        ConstraintAnchor constraintAnchor18222 = constraintWidget17.mListAnchors[i2];
        ConstraintAnchor constraintAnchor19222 = constraintWidget18.mListAnchors[i2 + 1];
        solverVariable = constraintAnchor18222.mTarget == null ? constraintAnchor18222.mTarget.mSolverVariable : null;
        if (constraintAnchor19222.mTarget == null) {
        }
        if (constraintWidget16 == constraintWidget18) {
        }
        if (constraintWidget17 != constraintWidget18) {
        }
        if (solverVariable != null) {
        }
        ConstraintAnchor constraintAnchor21222 = constraintAnchor;
    }
}
