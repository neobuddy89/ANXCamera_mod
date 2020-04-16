package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount = 0;
    public boolean mGroupsWrapOptimized = false;
    private boolean mHeightMeasuredTooSmall = false;
    ChainHead[] mHorizontalChainsArray = new ChainHead[4];
    int mHorizontalChainsSize = 0;
    public boolean mHorizontalWrapOptimized = false;
    private boolean mIsRtl = false;
    private int mOptimizationLevel = 7;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver = false;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem = new LinearSystem();
    ChainHead[] mVerticalChainsArray = new ChainHead[4];
    int mVerticalChainsSize = 0;
    public boolean mVerticalWrapOptimized = false;
    public List<ConstraintWidgetGroup> mWidgetGroups = new ArrayList();
    private boolean mWidthMeasuredTooSmall = false;
    public int mWrapFixedHeight = 0;
    public int mWrapFixedWidth = 0;

    public ConstraintWidgetContainer() {
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    /* access modifiers changed from: package-private */
    public void addChain(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2 = constraintWidget;
        if (i == 0) {
            addHorizontalChain(constraintWidget2);
        } else if (i == 1) {
            addVerticalChain(constraintWidget2);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return true;
    }

    public void analyze(int i) {
        super.analyze(i);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintWidget) this.mChildren.get(i2)).analyze(i);
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v47, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v51, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v52, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v53, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v18, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r17v5 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=?, for r17v2, types: [boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f9  */
    public void layout() {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int max;
        int max2;
        int i6;
        int i7;
        int i8;
        ? r17;
        int i9 = this.mX;
        int i10 = this.mY;
        int max3 = Math.max(0, getWidth());
        int max4 = Math.max(0, getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        if (this.mParent != null) {
            if (this.mSnapshot == null) {
                this.mSnapshot = new Snapshot(this);
            }
            this.mSnapshot.updateFrom(this);
            setX(this.mPaddingLeft);
            setY(this.mPaddingTop);
            resetAnchors();
            resetSolverVariables(this.mSystem.getCache());
        } else {
            this.mX = 0;
            this.mY = 0;
        }
        int i11 = 32;
        if (this.mOptimizationLevel != 0) {
            if (!optimizeFor(8)) {
                optimizeReset();
            }
            if (!optimizeFor(32)) {
                optimize();
            }
            this.mSystem.graphOptimizer = true;
        } else {
            this.mSystem.graphOptimizer = false;
        }
        boolean z2 = false;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mListDimensionBehaviors[0];
        resetChains();
        if (this.mWidgetGroups.size() == 0) {
            this.mWidgetGroups.clear();
            this.mWidgetGroups.add(0, new ConstraintWidgetGroup(this.mChildren));
        }
        int size = this.mWidgetGroups.size();
        ArrayList arrayList = this.mChildren;
        boolean z3 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        int i12 = 0;
        while (i12 < size && !this.mSkipSolver) {
            if (this.mWidgetGroups.get(i12).mSkipSolver) {
                i = size;
            } else {
                if (optimizeFor(i11)) {
                    if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED && getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                        this.mChildren = (ArrayList) this.mWidgetGroups.get(i12).getWidgetsToSolve();
                    } else {
                        this.mChildren = (ArrayList) this.mWidgetGroups.get(i12).mConstrainedGroup;
                    }
                }
                resetChains();
                int size2 = this.mChildren.size();
                int i13 = 0;
                int i14 = 0;
                while (i14 < size2) {
                    ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i14);
                    int i15 = i13;
                    if (constraintWidget instanceof WidgetContainer) {
                        ((WidgetContainer) constraintWidget).layout();
                    }
                    i14++;
                    i13 = i15;
                }
                int i16 = i13;
                int i17 = true;
                boolean z4 = z2;
                while (i17 != 0) {
                    int i18 = i16 + 1;
                    try {
                        this.mSystem.reset();
                        resetChains();
                        createObjectVariables(this.mSystem);
                        int i19 = 0;
                        while (i19 < size2) {
                            z = z4;
                            try {
                                i2 = i17;
                            } catch (Exception e2) {
                                e = e2;
                                int i20 = i17;
                                e.printStackTrace();
                                PrintStream printStream = System.out;
                                int i21 = i17;
                                StringBuilder sb = new StringBuilder();
                                i3 = size;
                                sb.append("EXCEPTION : ");
                                sb.append(e);
                                printStream.println(sb.toString());
                                i17 = i21;
                                if (i17 != 0) {
                                }
                                int i22 = 0;
                                if (z3) {
                                }
                                i8 = 0;
                                i4 = size2;
                                i5 = i8;
                                z4 = z;
                                max = Math.max(this.mMinWidth, getWidth());
                                if (max > getWidth()) {
                                }
                                max2 = Math.max(this.mMinHeight, getHeight());
                                if (max2 > getHeight()) {
                                }
                                if (!z4) {
                                }
                                i16 = i18;
                                size = i3;
                                size2 = i4;
                            }
                            try {
                                ((ConstraintWidget) this.mChildren.get(i19)).createObjectVariables(this.mSystem);
                                i19++;
                                z4 = z;
                                i17 = i2;
                            } catch (Exception e3) {
                                e = e3;
                                i17 = i2;
                                e.printStackTrace();
                                PrintStream printStream2 = System.out;
                                int i212 = i17;
                                StringBuilder sb2 = new StringBuilder();
                                i3 = size;
                                sb2.append("EXCEPTION : ");
                                sb2.append(e);
                                printStream2.println(sb2.toString());
                                i17 = i212;
                                if (i17 != 0) {
                                }
                                int i222 = 0;
                                if (z3) {
                                }
                                i8 = 0;
                                i4 = size2;
                                i5 = i8;
                                z4 = z;
                                max = Math.max(this.mMinWidth, getWidth());
                                if (max > getWidth()) {
                                }
                                max2 = Math.max(this.mMinHeight, getHeight());
                                if (max2 > getHeight()) {
                                }
                                if (!z4) {
                                }
                                i16 = i18;
                                size = i3;
                                size2 = i4;
                            }
                        }
                        z = z4;
                        int i23 = i17;
                        i17 = addChildrenToSolver(this.mSystem);
                        if (i17 != 0) {
                            try {
                                this.mSystem.minimize();
                            } catch (Exception e4) {
                                e = e4;
                            }
                        }
                        i3 = size;
                    } catch (Exception e5) {
                        e = e5;
                        z = z4;
                        int i24 = i17;
                        e.printStackTrace();
                        PrintStream printStream22 = System.out;
                        int i2122 = i17;
                        StringBuilder sb22 = new StringBuilder();
                        i3 = size;
                        sb22.append("EXCEPTION : ");
                        sb22.append(e);
                        printStream22.println(sb22.toString());
                        i17 = i2122;
                        if (i17 != 0) {
                        }
                        int i2222 = 0;
                        if (z3) {
                        }
                        i8 = 0;
                        i4 = size2;
                        i5 = i8;
                        z4 = z;
                        max = Math.max(this.mMinWidth, getWidth());
                        if (max > getWidth()) {
                        }
                        max2 = Math.max(this.mMinHeight, getHeight());
                        if (max2 > getHeight()) {
                        }
                        if (!z4) {
                        }
                        i16 = i18;
                        size = i3;
                        size2 = i4;
                    }
                    if (i17 != 0) {
                        updateFromSolver(this.mSystem);
                        int i25 = 0;
                        while (true) {
                            if (i25 >= size2) {
                                i2 = i17;
                                break;
                            }
                            ConstraintWidget constraintWidget2 = (ConstraintWidget) this.mChildren.get(i25);
                            i2 = i17;
                            if (constraintWidget2.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                r17 = 1;
                            } else if (constraintWidget2.getWidth() < constraintWidget2.getWrapWidth()) {
                                Optimizer.flags[2] = true;
                                break;
                            } else {
                                r17 = 1;
                            }
                            if (constraintWidget2.mListDimensionBehaviors[r17] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.getHeight() < constraintWidget2.getWrapHeight()) {
                                Optimizer.flags[2] = r17;
                                break;
                            } else {
                                i25++;
                                i17 = i2;
                            }
                        }
                    } else {
                        updateChildrenFromSolver(this.mSystem, Optimizer.flags);
                        i2 = i17;
                    }
                    int i22222 = 0;
                    if (z3 || i18 >= 8 || !Optimizer.flags[2]) {
                        i8 = 0;
                        i4 = size2;
                    } else {
                        int i26 = 0;
                        int i27 = 0;
                        int i28 = 0;
                        while (i28 < size2) {
                            int i29 = i22222;
                            ConstraintWidget constraintWidget3 = (ConstraintWidget) this.mChildren.get(i28);
                            int i30 = size2;
                            i26 = Math.max(i26, constraintWidget3.mX + constraintWidget3.getWidth());
                            int i31 = constraintWidget3.mY;
                            i2 = constraintWidget3.getHeight();
                            i27 = Math.max(i27, i31 + i2);
                            i28++;
                            i22222 = i29;
                            size2 = i30;
                        }
                        i8 = i22222;
                        i4 = size2;
                        int max5 = Math.max(this.mMinWidth, i26);
                        int max6 = Math.max(this.mMinHeight, i27);
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getWidth() < max5) {
                            setWidth(max5);
                            this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            z = true;
                            i8 = 1;
                        }
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getHeight() < max6) {
                            setHeight(max6);
                            this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            z4 = true;
                            i5 = 1;
                            max = Math.max(this.mMinWidth, getWidth());
                            if (max > getWidth()) {
                                setWidth(max);
                                this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                                z4 = true;
                                i5 = 1;
                            }
                            max2 = Math.max(this.mMinHeight, getHeight());
                            if (max2 > getHeight()) {
                                setHeight(max2);
                                this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                                z4 = true;
                                i5 = 1;
                            }
                            if (!z4) {
                                int i32 = i5;
                                if (this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || max3 <= 0 || getWidth() <= max3) {
                                    i6 = i32;
                                } else {
                                    this.mWidthMeasuredTooSmall = true;
                                    z4 = true;
                                    this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                                    setWidth(max3);
                                    i6 = 1;
                                }
                                boolean z5 = z4;
                                if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || max4 <= 0) {
                                    i7 = i6;
                                } else if (getHeight() > max4) {
                                    this.mHeightMeasuredTooSmall = true;
                                    int i33 = i6;
                                    this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                                    setHeight(max4);
                                    i17 = 1;
                                    z4 = true;
                                } else {
                                    i7 = i6;
                                }
                                z4 = z5;
                                i17 = i7;
                            } else {
                                i17 = i5;
                            }
                            i16 = i18;
                            size = i3;
                            size2 = i4;
                        }
                    }
                    i5 = i8;
                    z4 = z;
                    max = Math.max(this.mMinWidth, getWidth());
                    if (max > getWidth()) {
                    }
                    max2 = Math.max(this.mMinHeight, getHeight());
                    if (max2 > getHeight()) {
                    }
                    if (!z4) {
                    }
                    i16 = i18;
                    size = i3;
                    size2 = i4;
                }
                int i34 = size2;
                i2 = i17;
                i = size;
                this.mWidgetGroups.get(i12).updateUnresolvedWidgets();
                int i35 = i16;
                z2 = z4;
            }
            i12++;
            size = i;
            i11 = 32;
        }
        int i36 = size;
        this.mChildren = arrayList;
        if (this.mParent != null) {
            int max7 = Math.max(this.mMinWidth, getWidth());
            int max8 = Math.max(this.mMinHeight, getHeight());
            this.mSnapshot.applyTo(this);
            setWidth(this.mPaddingLeft + max7 + this.mPaddingRight);
            setHeight(this.mPaddingTop + max8 + this.mPaddingBottom);
        } else {
            this.mX = i9;
            this.mY = i10;
        }
        if (z2) {
            this.mListDimensionBehaviors[0] = dimensionBehaviour2;
            this.mListDimensionBehaviors[1] = dimensionBehaviour;
        }
        resetSolverVariables(this.mSystem.getCache());
        if (this == getRootConstraintContainer()) {
            updateDrawPosition();
        }
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public boolean optimizeFor(int i) {
        return (this.mOptimizationLevel & i) == i;
    }

    public void optimizeForDimensions(int i, int i2) {
        if (!(this.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.mResolutionWidth == null)) {
            this.mResolutionWidth.resolve(i);
        }
        if (this.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.mResolutionHeight != null) {
            this.mResolutionHeight.resolve(i2);
        }
    }

    public void optimizeReset() {
        int size = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < size; i++) {
            ((ConstraintWidget) this.mChildren.get(i)).resetResolutionNodes();
        }
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.resolve((ResolutionAnchor) null, 0.0f);
        resolutionNode2.resolve((ResolutionAnchor) null, 0.0f);
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = true;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = true;
            }
        }
    }
}
