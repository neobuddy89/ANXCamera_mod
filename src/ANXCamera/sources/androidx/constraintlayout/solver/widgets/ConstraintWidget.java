package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import com.android.gallery3d.exif.ExifInterface;
import java.util.ArrayList;

public class ConstraintWidget {
    protected static final int ANCHOR_BASELINE = 4;
    protected static final int ANCHOR_BOTTOM = 3;
    protected static final int ANCHOR_LEFT = 0;
    protected static final int ANCHOR_RIGHT = 1;
    protected static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    ConstraintWidgetGroup mBelongingGroup;
    ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    protected float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    private int mDrawHeight;
    private int mDrawWidth;
    private int mDrawX;
    private int mDrawY;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    boolean mIsHeightWrapContent;
    boolean mIsWidthWrapContent;
    ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    protected ConstraintAnchor[] mListAnchors;
    protected DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    int mMatchConstraintDefaultHeight;
    int mMatchConstraintDefaultWidth;
    int mMatchConstraintMaxHeight;
    int mMatchConstraintMaxWidth;
    int mMatchConstraintMinHeight;
    int mMatchConstraintMinWidth;
    float mMatchConstraintPercentHeight;
    float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    boolean mOptimizerMeasured;
    ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    ResolutionDimension mResolutionHeight;
    ResolutionDimension mResolutionWidth;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    int[] mResolvedMatchConstraintDefault;
    ConstraintAnchor mRight;
    boolean mRightHasCentered;
    ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    float[] mWeight;
    int mWidth;
    private int mWrapHeight;
    private int mWrapWidth;
    protected int mX;
    protected int mY;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mBelongingGroup = null;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = i;
        this.mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        addAnchors();
        forceUpdateDrawPosition();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    private void applyConstraints(LinearSystem linearSystem, boolean z, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f2, boolean z3, boolean z4, int i5, int i6, int i7, float f3, boolean z5) {
        boolean z6;
        int i8;
        SolverVariable solverVariable3;
        int i9;
        int i10;
        SolverVariable solverVariable4;
        int i11;
        int i12;
        int i13;
        int i14;
        SolverVariable solverVariable5;
        int i15;
        int i16;
        int i17;
        boolean z7;
        boolean z8;
        SolverVariable solverVariable6;
        int i18;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        int i19;
        int i20;
        boolean z9;
        boolean z10;
        int i21;
        int i22;
        int i23;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        int i24;
        LinearSystem linearSystem2 = linearSystem;
        SolverVariable solverVariable11 = solverVariable;
        SolverVariable solverVariable12 = solverVariable2;
        int i25 = i3;
        int i26 = i4;
        SolverVariable createObjectVariable = linearSystem2.createObjectVariable(constraintAnchor);
        SolverVariable createObjectVariable2 = linearSystem2.createObjectVariable(constraintAnchor2);
        SolverVariable createObjectVariable3 = linearSystem2.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable createObjectVariable4 = linearSystem2.createObjectVariable(constraintAnchor2.getTarget());
        if (linearSystem2.graphOptimizer && constraintAnchor.getResolutionNode().state == 1 && constraintAnchor2.getResolutionNode().state == 1) {
            if (LinearSystem.getMetrics() != null) {
                LinearSystem.getMetrics().resolvedWidgets++;
            }
            constraintAnchor.getResolutionNode().addResolvedValue(linearSystem2);
            constraintAnchor2.getResolutionNode().addResolvedValue(linearSystem2);
            if (!z4 && z) {
                linearSystem2.addGreaterThan(solverVariable12, createObjectVariable2, 0, 6);
                return;
            }
            return;
        }
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isConnected = constraintAnchor.isConnected();
        boolean isConnected2 = constraintAnchor2.isConnected();
        boolean isConnected3 = this.mCenter.isConnected();
        int i27 = 0;
        if (isConnected) {
            i27 = 0 + 1;
        }
        if (isConnected2) {
            i27++;
        }
        if (isConnected3) {
            i27++;
        }
        int i28 = i27;
        int i29 = z3 ? 3 : i5;
        int i30 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        int i31 = i28;
        boolean z11 = i30 != 1 ? i30 != 2 ? i30 != 3 ? i30 != 4 ? false : i29 != 4 : false : false : false;
        if (this.mVisibility == 8) {
            i8 = 0;
            z6 = false;
        } else {
            i8 = i2;
            z6 = z11;
        }
        if (z5) {
            if (isConnected || isConnected2 || isConnected3) {
                int i32 = i;
                if (isConnected && !isConnected2) {
                    linearSystem2.addEquality(createObjectVariable, createObjectVariable3, constraintAnchor.getMargin(), 6);
                }
            } else {
                linearSystem2.addEquality(createObjectVariable, i);
            }
        }
        if (!z6) {
            if (z2) {
                linearSystem2.addEquality(createObjectVariable2, createObjectVariable, 0, 3);
                if (i25 > 0) {
                    i24 = 6;
                    linearSystem2.addGreaterThan(createObjectVariable2, createObjectVariable, i25, 6);
                } else {
                    i24 = 6;
                }
                if (i26 < Integer.MAX_VALUE) {
                    linearSystem2.addLowerThan(createObjectVariable2, createObjectVariable, i26, i24);
                }
            } else {
                linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i8, 6);
            }
            i10 = i6;
            i12 = i7;
            int i33 = i8;
            i9 = i29;
            solverVariable4 = createObjectVariable4;
            solverVariable3 = createObjectVariable3;
            i11 = i31;
        } else {
            int i34 = i6;
            if (i34 == -2) {
                i34 = i8;
            }
            SolverVariable solverVariable13 = createObjectVariable4;
            int i35 = i7;
            if (i35 == -2) {
                i35 = i8;
            }
            if (i34 > 0) {
                i22 = 6;
                linearSystem2.addGreaterThan(createObjectVariable2, createObjectVariable, i34, 6);
                i8 = Math.max(i8, i34);
            } else {
                i22 = 6;
            }
            if (i35 > 0) {
                linearSystem2.addLowerThan(createObjectVariable2, createObjectVariable, i35, i22);
                i8 = Math.min(i8, i35);
            }
            if (i29 == 1) {
                if (z) {
                    linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i8, 6);
                    i23 = i8;
                    i9 = i29;
                    i10 = i34;
                    i12 = i35;
                    solverVariable3 = createObjectVariable3;
                    i11 = i31;
                    solverVariable4 = solverVariable13;
                } else if (z4) {
                    linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i8, 4);
                    i23 = i8;
                    i9 = i29;
                    i10 = i34;
                    i12 = i35;
                    solverVariable3 = createObjectVariable3;
                    i11 = i31;
                    solverVariable4 = solverVariable13;
                } else {
                    linearSystem2.addEquality(createObjectVariable2, createObjectVariable, i8, 1);
                    i23 = i8;
                    i9 = i29;
                    i10 = i34;
                    i12 = i35;
                    solverVariable3 = createObjectVariable3;
                    i11 = i31;
                    solverVariable4 = solverVariable13;
                }
            } else if (i29 == 2) {
                int i36 = i8;
                if (constraintAnchor.getType() == ConstraintAnchor.Type.TOP || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                    solverVariable9 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                    solverVariable10 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                } else {
                    solverVariable9 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                    solverVariable10 = linearSystem2.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                }
                i9 = i29;
                i23 = i36;
                i11 = i31;
                i10 = i34;
                i12 = i35;
                solverVariable4 = solverVariable13;
                solverVariable3 = createObjectVariable3;
                linearSystem2.addConstraint(linearSystem.createRow().createRowDimensionRatio(createObjectVariable2, createObjectVariable, solverVariable10, solverVariable9, f3));
                z6 = false;
            } else {
                i23 = i8;
                i9 = i29;
                i10 = i34;
                i12 = i35;
                solverVariable3 = createObjectVariable3;
                i11 = i31;
                solverVariable4 = solverVariable13;
            }
            if (!z6 || i11 == 2 || z3) {
                int i37 = i23;
            } else {
                z6 = false;
                int i38 = i23;
                int max = Math.max(i10, i38);
                if (i12 > 0) {
                    max = Math.min(i12, max);
                }
                linearSystem2.addEquality(createObjectVariable2, createObjectVariable, max, 6);
                int i39 = i38;
            }
        }
        if (!z5) {
            ConstraintAnchor constraintAnchor3 = constraintAnchor;
            ConstraintAnchor constraintAnchor4 = constraintAnchor2;
            int i40 = i12;
            solverVariable5 = createObjectVariable;
            int i41 = i10;
            SolverVariable solverVariable14 = solverVariable3;
            i14 = 6;
            i13 = i11;
            int i42 = i9;
        } else if (z4) {
            ConstraintAnchor constraintAnchor5 = constraintAnchor;
            ConstraintAnchor constraintAnchor6 = constraintAnchor2;
            int i43 = i12;
            solverVariable5 = createObjectVariable;
            int i44 = i10;
            SolverVariable solverVariable15 = solverVariable3;
            i14 = 6;
            i13 = i11;
            int i45 = i9;
        } else {
            if (isConnected || isConnected2 || isConnected3) {
                i15 = 0;
                if (!isConnected || isConnected2) {
                    if (!isConnected && isConnected2) {
                        linearSystem2.addEquality(createObjectVariable2, solverVariable4, -constraintAnchor2.getMargin(), 6);
                        if (z) {
                            linearSystem2.addGreaterThan(createObjectVariable, solverVariable11, 0, 5);
                            ConstraintAnchor constraintAnchor7 = constraintAnchor;
                            ConstraintAnchor constraintAnchor8 = constraintAnchor2;
                            int i46 = i12;
                            SolverVariable solverVariable16 = createObjectVariable;
                            int i47 = i10;
                            SolverVariable solverVariable17 = solverVariable3;
                            i16 = 6;
                            int i48 = i11;
                            int i49 = i9;
                        } else {
                            ConstraintAnchor constraintAnchor9 = constraintAnchor;
                            ConstraintAnchor constraintAnchor10 = constraintAnchor2;
                            int i50 = i12;
                            SolverVariable solverVariable18 = createObjectVariable;
                            int i51 = i10;
                            SolverVariable solverVariable19 = solverVariable3;
                            i16 = 6;
                            int i52 = i11;
                            int i53 = i9;
                        }
                    } else if (!isConnected || !isConnected2) {
                        ConstraintAnchor constraintAnchor11 = constraintAnchor;
                        ConstraintAnchor constraintAnchor12 = constraintAnchor2;
                        int i54 = i12;
                        SolverVariable solverVariable20 = createObjectVariable;
                        int i55 = i10;
                        SolverVariable solverVariable21 = solverVariable3;
                        i16 = 6;
                        int i56 = i11;
                        int i57 = i9;
                    } else {
                        boolean z12 = false;
                        boolean z13 = false;
                        if (z6) {
                            if (z && i25 == 0) {
                                linearSystem2.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 6);
                            }
                            i18 = i9;
                            if (i18 == 0) {
                                if (i12 > 0 || i10 > 0) {
                                    z12 = true;
                                    i21 = 4;
                                } else {
                                    i21 = 6;
                                }
                                solverVariable6 = solverVariable3;
                                linearSystem2.addEquality(createObjectVariable, solverVariable6, constraintAnchor.getMargin(), i21);
                                linearSystem2.addEquality(createObjectVariable2, solverVariable4, -constraintAnchor2.getMargin(), i21);
                                if (i12 > 0 || i10 > 0) {
                                    z13 = true;
                                }
                                z8 = z12;
                                z7 = z13;
                                i17 = 5;
                            } else {
                                solverVariable6 = solverVariable3;
                                if (i18 == 1) {
                                    z8 = true;
                                    z7 = true;
                                    i17 = 6;
                                } else if (i18 == 3) {
                                    int i58 = 4;
                                    if (!z3) {
                                        z10 = true;
                                        z9 = true;
                                        if (this.mResolvedDimensionRatioSide != -1 && i12 <= 0) {
                                            i58 = 6;
                                        }
                                    } else {
                                        z10 = true;
                                        z9 = true;
                                    }
                                    linearSystem2.addEquality(createObjectVariable, solverVariable6, constraintAnchor.getMargin(), i58);
                                    linearSystem2.addEquality(createObjectVariable2, solverVariable4, -constraintAnchor2.getMargin(), i58);
                                    z8 = z10;
                                    z7 = z9;
                                    i17 = 5;
                                } else {
                                    z8 = false;
                                    z7 = false;
                                    i17 = 5;
                                }
                            }
                        } else {
                            i18 = i9;
                            solverVariable6 = solverVariable3;
                            z8 = false;
                            z7 = true;
                            i17 = 5;
                        }
                        int i59 = 5;
                        int i60 = 5;
                        boolean z14 = z;
                        boolean z15 = z;
                        if (z7) {
                            int i61 = i18;
                            int i62 = i12;
                            solverVariable7 = createObjectVariable2;
                            solverVariable8 = createObjectVariable;
                            int i63 = i10;
                            int i64 = i11;
                            linearSystem.addCentering(createObjectVariable, solverVariable6, constraintAnchor.getMargin(), f2, solverVariable4, createObjectVariable2, constraintAnchor2.getMargin(), i17);
                            boolean z16 = constraintAnchor.mTarget.mOwner instanceof Barrier;
                            i16 = 6;
                            boolean z17 = constraintAnchor2.mTarget.mOwner instanceof Barrier;
                            if (z16 && !z17) {
                                i60 = 6;
                                z15 = true;
                            } else if (!z16 && z17) {
                                i59 = 6;
                                z14 = true;
                            }
                        } else {
                            ConstraintAnchor constraintAnchor13 = constraintAnchor;
                            ConstraintAnchor constraintAnchor14 = constraintAnchor2;
                            int i65 = i12;
                            int i66 = i18;
                            solverVariable7 = createObjectVariable2;
                            solverVariable8 = createObjectVariable;
                            int i67 = i10;
                            i16 = 6;
                            int i68 = i11;
                        }
                        if (z8) {
                            i20 = 6;
                            i19 = 6;
                        } else {
                            i20 = i59;
                            i19 = i60;
                        }
                        if ((!z6 && z14) || z8) {
                            linearSystem2.addGreaterThan(solverVariable8, solverVariable6, constraintAnchor.getMargin(), i20);
                        }
                        if ((z6 || !z15) && !z8) {
                            createObjectVariable2 = solverVariable7;
                        } else {
                            createObjectVariable2 = solverVariable7;
                            linearSystem2.addLowerThan(createObjectVariable2, solverVariable4, -constraintAnchor2.getMargin(), i19);
                        }
                        if (z) {
                            i15 = 0;
                            linearSystem2.addGreaterThan(solverVariable8, solverVariable11, 0, i16);
                        } else {
                            i15 = 0;
                        }
                    }
                } else if (z) {
                    linearSystem2.addGreaterThan(solverVariable12, createObjectVariable2, 0, 5);
                    ConstraintAnchor constraintAnchor15 = constraintAnchor;
                    ConstraintAnchor constraintAnchor16 = constraintAnchor2;
                    int i69 = i12;
                    SolverVariable solverVariable22 = createObjectVariable;
                    int i70 = i10;
                    SolverVariable solverVariable23 = solverVariable3;
                    i16 = 6;
                    int i71 = i11;
                    int i72 = i9;
                } else {
                    ConstraintAnchor constraintAnchor17 = constraintAnchor;
                    ConstraintAnchor constraintAnchor18 = constraintAnchor2;
                    int i73 = i12;
                    SolverVariable solverVariable24 = createObjectVariable;
                    int i74 = i10;
                    SolverVariable solverVariable25 = solverVariable3;
                    i16 = 6;
                    int i75 = i11;
                    int i76 = i9;
                }
            } else if (z) {
                i15 = 0;
                linearSystem2.addGreaterThan(solverVariable12, createObjectVariable2, 0, 5);
                ConstraintAnchor constraintAnchor19 = constraintAnchor;
                ConstraintAnchor constraintAnchor20 = constraintAnchor2;
                int i77 = i12;
                SolverVariable solverVariable26 = createObjectVariable;
                int i78 = i10;
                SolverVariable solverVariable27 = solverVariable3;
                i16 = 6;
                int i79 = i11;
                int i80 = i9;
            } else {
                i15 = 0;
                ConstraintAnchor constraintAnchor21 = constraintAnchor;
                ConstraintAnchor constraintAnchor22 = constraintAnchor2;
                int i81 = i12;
                SolverVariable solverVariable28 = createObjectVariable;
                int i82 = i10;
                SolverVariable solverVariable29 = solverVariable3;
                i16 = 6;
                int i83 = i11;
                int i84 = i9;
            }
            if (z) {
                linearSystem2.addGreaterThan(solverVariable12, createObjectVariable2, i15, i16);
                return;
            }
            return;
        }
        if (i13 < 2 && z) {
            linearSystem2.addGreaterThan(solverVariable5, solverVariable11, 0, i14);
            linearSystem2.addGreaterThan(solverVariable12, createObjectVariable2, 0, i14);
        }
    }

    private boolean isChainHead(int i) {
        int i2 = i * 2;
        if (this.mListAnchors[i2].mTarget != null) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[i2].mTarget.mTarget;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            return (constraintAnchor == constraintAnchorArr[i2] || constraintAnchorArr[i2 + 1].mTarget == null || this.mListAnchors[i2 + 1].mTarget.mTarget != this.mListAnchors[i2 + 1]) ? false : true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c8, code lost:
        if (r0 == -1) goto L_0x01cc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0277 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01c3  */
    public void addToSolver(LinearSystem linearSystem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i;
        int i2;
        int i3;
        int i4;
        SolverVariable solverVariable;
        boolean z6;
        char c2;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        SolverVariable solverVariable6;
        LinearSystem linearSystem2;
        boolean z11;
        boolean z12;
        LinearSystem linearSystem3 = linearSystem;
        SolverVariable createObjectVariable = linearSystem3.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem3.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable3 = linearSystem3.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable4 = linearSystem3.createObjectVariable(this.mBottom);
        SolverVariable createObjectVariable5 = linearSystem3.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null) {
            boolean z13 = constraintWidget != null && constraintWidget.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget constraintWidget2 = this.mParent;
            boolean z14 = constraintWidget2 != null && constraintWidget2.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                z11 = true;
            } else {
                z11 = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                z12 = true;
            } else {
                z12 = isInVerticalChain();
            }
            if (z13 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mRight), createObjectVariable2, 0, 1);
            }
            if (z14 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem3.addGreaterThan(linearSystem3.createObjectVariable(this.mParent.mBottom), createObjectVariable4, 0, 1);
            }
            z2 = z11;
            z = z12;
            z3 = z13;
            z4 = z14;
        } else {
            z2 = false;
            z = false;
            z3 = false;
            z4 = false;
        }
        int i5 = this.mWidth;
        if (i5 < this.mMinWidth) {
            i5 = this.mMinWidth;
        }
        int i6 = this.mHeight;
        if (i6 < this.mMinHeight) {
            i6 = this.mMinHeight;
        }
        boolean z15 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z16 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z17 = false;
        this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
        float f2 = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f2;
        int i7 = this.mMatchConstraintDefaultWidth;
        int i8 = this.mMatchConstraintDefaultHeight;
        SolverVariable solverVariable7 = createObjectVariable2;
        if (f2 <= 0.0f || this.mVisibility == 8) {
            solverVariable = createObjectVariable4;
        } else {
            z17 = true;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i7 == 0) {
                i7 = 3;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i8 == 0) {
                i8 = 3;
            }
            solverVariable = createObjectVariable4;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i7 == 3 && i8 == 3) {
                setupDimensionRatio(z3, z4, z15, z16);
            } else if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i7 == 3) {
                this.mResolvedDimensionRatioSide = 0;
                int i9 = (int) (this.mResolvedDimensionRatio * ((float) this.mHeight));
                if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4 = i9;
                    i3 = i6;
                    i2 = i8;
                    i = 4;
                    z5 = false;
                } else {
                    i4 = i9;
                    i3 = i6;
                    i2 = i8;
                    i = i7;
                    z5 = true;
                }
                int[] iArr = this.mResolvedMatchConstraintDefault;
                iArr[0] = i;
                iArr[1] = i2;
                if (z5) {
                }
                z6 = false;
                boolean z18 = z16;
                boolean z19 = this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
                if (this.mCenter.isConnected()) {
                }
                if (this.mHorizontalResolution == 2) {
                }
                if (this.mVerticalResolution == 2) {
                }
            } else if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i8 == 3) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
                int i10 = (int) (this.mResolvedDimensionRatio * ((float) this.mWidth));
                if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                    i4 = i5;
                    i3 = i10;
                    i2 = 4;
                    i = i7;
                    z5 = false;
                } else {
                    i4 = i5;
                    i3 = i10;
                    i2 = i8;
                    i = i7;
                    z5 = true;
                }
                int[] iArr2 = this.mResolvedMatchConstraintDefault;
                iArr2[0] = i;
                iArr2[1] = i2;
                if (z5) {
                    int i11 = this.mResolvedDimensionRatioSide;
                    if (i11 != 0) {
                        c2 = 65535;
                    } else {
                        c2 = 65535;
                    }
                    z6 = true;
                    boolean z182 = z16;
                    boolean z192 = this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
                    boolean z20 = this.mCenter.isConnected();
                    if (this.mHorizontalResolution == 2) {
                        ConstraintWidget constraintWidget3 = this.mParent;
                        SolverVariable createObjectVariable6 = constraintWidget3 != null ? linearSystem3.createObjectVariable(constraintWidget3.mRight) : null;
                        ConstraintWidget constraintWidget4 = this.mParent;
                        boolean z21 = z15;
                        z7 = z4;
                        z8 = false;
                        char c3 = c2;
                        solverVariable5 = createObjectVariable5;
                        solverVariable4 = solverVariable;
                        solverVariable3 = createObjectVariable3;
                        solverVariable2 = solverVariable7;
                        applyConstraints(linearSystem, z3, constraintWidget4 != null ? linearSystem3.createObjectVariable(constraintWidget4.mLeft) : null, createObjectVariable6, this.mListDimensionBehaviors[0], z192, this.mLeft, this.mRight, this.mX, i4, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z6, z2, i, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z20);
                    } else {
                        solverVariable3 = createObjectVariable3;
                        boolean z22 = z15;
                        z7 = z4;
                        boolean z23 = z3;
                        solverVariable5 = createObjectVariable5;
                        solverVariable2 = solverVariable7;
                        solverVariable4 = solverVariable;
                        z8 = false;
                    }
                    if (this.mVerticalResolution == 2) {
                        boolean z24 = (this.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT || !(this instanceof ConstraintWidgetContainer)) ? z8 : true;
                        if (z5) {
                            int i12 = this.mResolvedDimensionRatioSide;
                            if (i12 == 1 || i12 == -1) {
                                z9 = true;
                                if (this.mBaselineDistance > 0) {
                                    linearSystem2 = linearSystem;
                                    SolverVariable solverVariable8 = solverVariable5;
                                    solverVariable6 = solverVariable3;
                                } else if (this.mBaseline.getResolutionNode().state == 1) {
                                    linearSystem2 = linearSystem;
                                    this.mBaseline.getResolutionNode().addResolvedValue(linearSystem2);
                                    SolverVariable solverVariable9 = solverVariable5;
                                    solverVariable6 = solverVariable3;
                                } else {
                                    linearSystem2 = linearSystem;
                                    SolverVariable solverVariable10 = solverVariable5;
                                    solverVariable6 = solverVariable3;
                                    linearSystem2.addEquality(solverVariable10, solverVariable6, getBaselineDistance(), 6);
                                    if (this.mBaseline.mTarget != null) {
                                        linearSystem2.addEquality(solverVariable10, linearSystem2.createObjectVariable(this.mBaseline.mTarget), 0, 6);
                                        z10 = false;
                                        ConstraintWidget constraintWidget5 = this.mParent;
                                        SolverVariable createObjectVariable7 = constraintWidget5 != null ? linearSystem2.createObjectVariable(constraintWidget5.mBottom) : null;
                                        ConstraintWidget constraintWidget6 = this.mParent;
                                        applyConstraints(linearSystem, z7, constraintWidget6 != null ? linearSystem2.createObjectVariable(constraintWidget6.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z24, this.mTop, this.mBottom, this.mY, i3, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z9, z, i2, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z10);
                                        if (z5) {
                                            if (this.mResolvedDimensionRatioSide == 1) {
                                                linearSystem.addRatio(solverVariable4, solverVariable6, solverVariable2, createObjectVariable, this.mResolvedDimensionRatio, 6);
                                            } else {
                                                linearSystem.addRatio(solverVariable2, createObjectVariable, solverVariable4, solverVariable6, this.mResolvedDimensionRatio, 6);
                                            }
                                        }
                                        if (this.mCenter.isConnected()) {
                                            linearSystem2.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians((double) (this.mCircleConstraintAngle + 90.0f)), this.mCenter.getMargin());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                z10 = z20;
                                ConstraintWidget constraintWidget52 = this.mParent;
                                if (constraintWidget52 != null) {
                                }
                                ConstraintWidget constraintWidget62 = this.mParent;
                                applyConstraints(linearSystem, z7, constraintWidget62 != null ? linearSystem2.createObjectVariable(constraintWidget62.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z24, this.mTop, this.mBottom, this.mY, i3, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z9, z, i2, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z10);
                                if (z5) {
                                }
                                if (this.mCenter.isConnected()) {
                                }
                            }
                        }
                        z9 = z8;
                        if (this.mBaselineDistance > 0) {
                        }
                        z10 = z20;
                        ConstraintWidget constraintWidget522 = this.mParent;
                        if (constraintWidget522 != null) {
                        }
                        ConstraintWidget constraintWidget622 = this.mParent;
                        applyConstraints(linearSystem, z7, constraintWidget622 != null ? linearSystem2.createObjectVariable(constraintWidget622.mTop) : null, createObjectVariable7, this.mListDimensionBehaviors[1], z24, this.mTop, this.mBottom, this.mY, i3, this.mMinHeight, this.mMaxDimension[1], this.mVerticalBiasPercent, z9, z, i2, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, z10);
                        if (z5) {
                        }
                        if (this.mCenter.isConnected()) {
                        }
                    } else {
                        return;
                    }
                } else {
                    c2 = 65535;
                }
                z6 = false;
                boolean z1822 = z16;
                boolean z1922 = this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
                if (this.mCenter.isConnected()) {
                }
                if (this.mHorizontalResolution == 2) {
                }
                if (this.mVerticalResolution == 2) {
                }
            }
        }
        i4 = i5;
        i3 = i6;
        i2 = i8;
        i = i7;
        z5 = z17;
        int[] iArr22 = this.mResolvedMatchConstraintDefault;
        iArr22[0] = i;
        iArr22[1] = i2;
        if (z5) {
        }
        z6 = false;
        boolean z18222 = z16;
        boolean z19222 = this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
        if (this.mCenter.isConnected()) {
        }
        if (this.mHorizontalResolution == 2) {
        }
        if (this.mVerticalResolution == 2) {
        }
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void analyze(int i) {
        Optimizer.analyze(i, this);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        connect(type, constraintWidget, type2, i, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength) {
        connect(type, constraintWidget, type2, i, strength, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, ConstraintAnchor.Strength strength, int i2) {
        int i3;
        ConstraintAnchor.Type type3 = type;
        ConstraintWidget constraintWidget2 = constraintWidget;
        ConstraintAnchor.Type type4 = type2;
        int i4 = i2;
        if (type3 == ConstraintAnchor.Type.CENTER) {
            if (type4 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z = false;
                boolean z2 = false;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    ConstraintWidget constraintWidget3 = constraintWidget;
                    ConstraintAnchor.Strength strength2 = strength;
                    int i5 = i2;
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget3, ConstraintAnchor.Type.LEFT, 0, strength2, i5);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget3, ConstraintAnchor.Type.RIGHT, 0, strength2, i5);
                    z = true;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    ConstraintWidget constraintWidget4 = constraintWidget;
                    ConstraintAnchor.Strength strength3 = strength;
                    int i6 = i2;
                    connect(ConstraintAnchor.Type.TOP, constraintWidget4, ConstraintAnchor.Type.TOP, 0, strength3, i6);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget4, ConstraintAnchor.Type.BOTTOM, 0, strength3, i6);
                    z2 = true;
                }
                if (z && z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.CENTER), 0, i4);
                } else if (z) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, i4);
                } else if (z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, i4);
                }
                ConstraintAnchor.Strength strength4 = strength;
            } else {
                if (type4 == ConstraintAnchor.Type.LEFT || type4 == ConstraintAnchor.Type.RIGHT) {
                    ConstraintWidget constraintWidget5 = constraintWidget;
                    ConstraintAnchor.Type type5 = type2;
                    ConstraintAnchor.Strength strength5 = strength;
                    int i7 = i2;
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget5, type5, 0, strength5, i7);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget5, type5, 0, strength5, i7);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i4);
                } else if (type4 == ConstraintAnchor.Type.TOP || type4 == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintWidget constraintWidget6 = constraintWidget;
                    ConstraintAnchor.Type type6 = type2;
                    ConstraintAnchor.Strength strength6 = strength;
                    int i8 = i2;
                    connect(ConstraintAnchor.Type.TOP, constraintWidget6, type6, 0, strength6, i8);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget6, type6, 0, strength6, i8);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0, i4);
                    ConstraintAnchor.Strength strength7 = strength;
                }
                ConstraintAnchor.Strength strength8 = strength;
            }
        } else if (type3 == ConstraintAnchor.Type.CENTER_X && (type4 == ConstraintAnchor.Type.LEFT || type4 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0, i4);
            anchor7.connect(anchor6, 0, i4);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0, i4);
            ConstraintAnchor.Strength strength9 = strength;
        } else if (type3 == ConstraintAnchor.Type.CENTER_Y && (type4 == ConstraintAnchor.Type.TOP || type4 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0, i4);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0, i4);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0, i4);
            ConstraintAnchor.Strength strength10 = strength;
        } else if (type3 == ConstraintAnchor.Type.CENTER_X && type4 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), 0, i4);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT), 0, i4);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0, i4);
            ConstraintAnchor.Strength strength11 = strength;
        } else if (type3 == ConstraintAnchor.Type.CENTER_Y && type4 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP), 0, i4);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, i4);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0, i4);
            ConstraintAnchor.Strength strength12 = strength;
        } else {
            ConstraintAnchor anchor9 = getAnchor(type);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            if (anchor9.isValidConnection(anchor10)) {
                if (type3 == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                    i3 = 0;
                } else {
                    if (type3 == ConstraintAnchor.Type.TOP || type3 == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.BASELINE);
                        if (anchor13 != null) {
                            anchor13.reset();
                        }
                        ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor14.getTarget() != anchor10) {
                            anchor14.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                        if (anchor15.isConnected()) {
                            opposite.reset();
                            anchor15.reset();
                        }
                    } else if (type3 == ConstraintAnchor.Type.LEFT || type3 == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                        if (anchor16.getTarget() != anchor10) {
                            anchor16.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                        if (anchor17.isConnected()) {
                            opposite2.reset();
                            anchor17.reset();
                        }
                    }
                    i3 = i;
                }
                anchor9.connect(anchor10, i3, strength, i4);
                anchor10.getOwner().connectedTo(anchor9.getOwner());
                return;
            }
            ConstraintAnchor.Strength strength13 = strength;
        }
        int i9 = i;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2) {
        connect(constraintAnchor, constraintAnchor2, i, ConstraintAnchor.Strength.STRONG, i2);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, ConstraintAnchor.Strength strength, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i, strength, i2);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f2, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.mCircleConstraintAngle = f2;
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = anchors.get(i);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    public void forceUpdateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        int i4 = this.mY + this.mHeight;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public int getDrawBottom() {
        return getDrawY() + this.mDrawHeight;
    }

    public int getDrawHeight() {
        return this.mDrawHeight;
    }

    public int getDrawRight() {
        return getDrawX() + this.mDrawWidth;
    }

    public int getDrawWidth() {
        return this.mDrawWidth;
    }

    public int getDrawX() {
        return this.mDrawX + this.mOffsetX;
    }

    public int getDrawY() {
        return this.mDrawY + this.mOffsetY;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintWidget constraintWidget = null;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        while (constraintWidget == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor constraintAnchor = null;
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget2;
            }
            if (owner != null) {
                constraintAnchor = owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor == null || constraintAnchor.getOwner() == constraintWidget2) {
                constraintWidget2 = owner;
            } else {
                constraintWidget = constraintWidget2;
            }
        }
        return constraintWidget;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getInternalDrawBottom() {
        return this.mDrawY + this.mDrawHeight;
    }

    public int getInternalDrawRight() {
        return this.mDrawX + this.mDrawWidth;
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawX() {
        return this.mDrawX;
    }

    /* access modifiers changed from: package-private */
    public int getInternalDrawY() {
        return this.mDrawY;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i = Math.max(this.mMatchConstraintMinHeight, i2);
        } else if (this.mMatchConstraintMinHeight > 0) {
            i = this.mMatchConstraintMinHeight;
            this.mHeight = i;
        } else {
            i = 0;
        }
        int i3 = this.mMatchConstraintMaxHeight;
        return (i3 <= 0 || i3 >= i) ? i : this.mMatchConstraintMaxHeight;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i = Math.max(this.mMatchConstraintMinWidth, i2);
        } else if (this.mMatchConstraintMinWidth > 0) {
            i = this.mMatchConstraintMinWidth;
            this.mWidth = i;
        } else {
            i = 0;
        }
        int i3 = this.mMatchConstraintMaxWidth;
        return (i3 <= 0 || i3 >= i) ? i : this.mMatchConstraintMaxWidth;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int i) {
        if (i == 0) {
            return this.mRelX;
        }
        if (i == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.mResolutionHeight == null) {
            this.mResolutionHeight = new ResolutionDimension();
        }
        return this.mResolutionHeight;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.mResolutionWidth == null) {
            this.mResolutionWidth = new ResolutionDimension();
        }
        return this.mResolutionWidth;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget constraintWidget = this;
        while (constraintWidget.getParent() != null) {
            constraintWidget = constraintWidget.getParent();
        }
        if (constraintWidget instanceof WidgetContainer) {
            return (WidgetContainer) constraintWidget;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintWidget constraintWidget = null;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        while (constraintWidget == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor constraintAnchor = null;
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget2;
            }
            if (owner != null) {
                constraintAnchor = owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor == null || constraintAnchor.getOwner() == constraintWidget2) {
                constraintWidget2 = owner;
            } else {
                constraintWidget = constraintWidget2;
            }
        }
        return constraintWidget;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getWrapHeight() {
        return this.mWrapHeight;
    }

    public int getWrapWidth() {
        return this.mWrapWidth;
    }

    public int getX() {
        return this.mX;
    }

    public int getY() {
        return this.mY;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasBaseline() {
        return this.mBaselineDistance > 0;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        ConstraintAnchor anchor = getAnchor(type);
        anchor.connect(constraintWidget.getAnchor(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public boolean isFullyResolved() {
        return this.mLeft.getResolutionNode().state == 1 && this.mRight.getResolutionNode().state == 1 && this.mTop.getResolutionNode().state == 1 && this.mBottom.getResolutionNode().state == 1;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isRootContainer() {
        if (this instanceof ConstraintWidgetContainer) {
            ConstraintWidget constraintWidget = this.mParent;
            if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mDrawX = 0;
        this.mDrawY = 0;
        this.mDrawWidth = 0;
        this.mDrawHeight = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mWrapWidth = 0;
        this.mWrapHeight = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        ResolutionDimension resolutionDimension = this.mResolutionWidth;
        if (resolutionDimension != null) {
            resolutionDimension.reset();
        }
        ResolutionDimension resolutionDimension2 = this.mResolutionHeight;
        if (resolutionDimension2 != null) {
            resolutionDimension2.reset();
        }
        this.mBelongingGroup = null;
        this.mOptimizerMeasurable = false;
        this.mOptimizerMeasured = false;
        this.mGroupsToSolver = false;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (!(this instanceof ConstraintWidgetContainer)) {
            if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
                if (getWidth() == getWrapWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                } else if (getWidth() > getMinWidth()) {
                    setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
                }
            }
            if (getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
                return;
            }
            if (getHeight() == getWrapHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getHeight() > getMinHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i = 0; i < size; i++) {
                this.mAnchors.get(i).reset();
            }
        }
    }

    public void resetAnchors(int i) {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintAnchor constraintAnchor = this.mAnchors.get(i2);
                if (i == constraintAnchor.getConnectionCreator()) {
                    if (constraintAnchor.isVerticalAnchor()) {
                        setVerticalBiasPercent(DEFAULT_BIAS);
                    } else {
                        setHorizontalBiasPercent(DEFAULT_BIAS);
                    }
                    constraintAnchor.reset();
                }
            }
        }
    }

    public void resetResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().reset();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void resolve() {
    }

    public void setBaselineDistance(int i) {
        this.mBaselineDistance = i;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.mContainerItemSkip = i;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            createObjectVariable5.setName(str + ".baseline");
        }
    }

    public void setDimension(int i, int i2) {
        this.mWidth = i;
        int i3 = this.mMinWidth;
        if (i < i3) {
            this.mWidth = i3;
        }
        this.mHeight = i2;
        int i4 = this.mMinHeight;
        if (i2 < i4) {
            this.mHeight = i4;
        }
    }

    public void setDimensionRatio(float f2, int i) {
        this.mDimensionRatio = f2;
        this.mDimensionRatioSide = i;
    }

    public void setDimensionRatio(String str) {
        int i;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int i2 = -1;
        float f2 = 0.0f;
        int length = str.length();
        int indexOf = str.indexOf(44);
        if (indexOf <= 0 || indexOf >= length - 1) {
            i = 0;
        } else {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase(ExifInterface.GpsLongitudeRef.WEST)) {
                i2 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i);
            if (substring2.length() > 0) {
                try {
                    f2 = Float.parseFloat(substring2);
                } catch (NumberFormatException e2) {
                }
            }
        } else {
            String substring3 = str.substring(i, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                try {
                    float parseFloat = Float.parseFloat(substring3);
                    float parseFloat2 = Float.parseFloat(substring4);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        f2 = i2 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                    }
                } catch (NumberFormatException e3) {
                }
            }
        }
        if (f2 > 0.0f) {
            this.mDimensionRatio = f2;
            this.mDimensionRatioSide = i2;
        }
    }

    public void setDrawHeight(int i) {
        this.mDrawHeight = i;
    }

    public void setDrawOrigin(int i, int i2) {
        int i3 = i - this.mOffsetX;
        this.mDrawX = i3;
        int i4 = i2 - this.mOffsetY;
        this.mDrawY = i4;
        this.mX = i3;
        this.mY = i4;
    }

    public void setDrawWidth(int i) {
        this.mDrawWidth = i;
    }

    public void setDrawX(int i) {
        int i2 = i - this.mOffsetX;
        this.mDrawX = i2;
        this.mX = i2;
    }

    public void setDrawY(int i) {
        int i2 = i - this.mOffsetY;
        this.mDrawY = i2;
        this.mY = i2;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
        this.mOptimizerMeasured = true;
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.mX = i;
        this.mY = i2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i5 < this.mWidth) {
            i5 = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i6 < this.mHeight) {
            i6 = this.mHeight;
        }
        this.mWidth = i5;
        this.mHeight = i6;
        int i7 = this.mMinHeight;
        if (i6 < i7) {
            this.mHeight = i7;
        }
        int i8 = this.mWidth;
        int i9 = this.mMinWidth;
        if (i8 < i9) {
            this.mWidth = i9;
        }
        this.mOptimizerMeasured = true;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.mGoneMargin = i;
        } else if (i2 == 2) {
            this.mTop.mGoneMargin = i;
        } else if (i2 == 3) {
            this.mRight.mGoneMargin = i;
        } else if (i2 == 4) {
            this.mBottom.mGoneMargin = i;
        }
    }

    public void setHeight(int i) {
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f2) {
        this.mHorizontalBiasPercent = f2;
    }

    public void setHorizontalChainStyle(int i) {
        this.mHorizontalChainStyle = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.mX = i;
        int i3 = i2 - i;
        this.mWidth = i3;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.mWrapWidth);
        }
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f2) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        this.mMatchConstraintMaxWidth = i3;
        this.mMatchConstraintPercentWidth = f2;
        if (f2 < 1.0f && i == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f2) {
        this.mWeight[0] = f2;
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        this.mMaxDimension[1] = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxDimension[0] = i;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i;
        }
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
    }

    public void setOrigin(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int i, int i2) {
        if (i2 == 0) {
            this.mRelX = i;
        } else if (i2 == 1) {
            this.mRelY = i;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f2) {
        this.mVerticalBiasPercent = f2;
    }

    public void setVerticalChainStyle(int i) {
        this.mVerticalChainStyle = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.mY = i;
        int i3 = i2 - i;
        this.mHeight = i3;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.mWrapHeight);
        }
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f2) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        this.mMatchConstraintMaxHeight = i3;
        this.mMatchConstraintPercentHeight = f2;
        if (f2 < 1.0f && i == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f2) {
        this.mWeight[1] = f2;
    }

    public void setVisibility(int i) {
        this.mVisibility = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setWrapHeight(int i) {
        this.mWrapHeight = i;
    }

    public void setWrapWidth(int i) {
        this.mWrapWidth = i;
    }

    public void setX(int i) {
        this.mX = i;
    }

    public void setY(int i) {
        this.mY = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z && !z2) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z && z2) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1 && z && z2) {
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(") wrap: (");
        sb.append(this.mWrapWidth);
        sb.append(" x ");
        sb.append(this.mWrapHeight);
        sb.append(")");
        return sb.toString();
    }

    public void updateDrawPosition() {
        int i = this.mX;
        int i2 = this.mY;
        int i3 = this.mX + this.mWidth;
        int i4 = this.mY + this.mHeight;
        this.mDrawX = i;
        this.mDrawY = i2;
        this.mDrawWidth = i3 - i;
        this.mDrawHeight = i4 - i2;
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        int i = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
            objectVariableValue4 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void updateResolutionNodes() {
        for (int i = 0; i < 6; i++) {
            this.mListAnchors[i].getResolutionNode().update();
        }
    }
}
