package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Analyzer;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.ResolutionAnchor;
import com.android.gallery3d.exif.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    static final boolean ALLOWS_EMBEDDED = false;
    private static final boolean CACHE_MEASURED_DIMENSION = false;
    private static final boolean DEBUG = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-1.1.3";
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    private boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOptimizationLevel = 7;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>(100);

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        int dimensionRatioSide;
        float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        boolean horizontalDimensionFixed;
        public float horizontalWeight;
        boolean isGuideline;
        boolean isHelper;
        boolean isInPlaceholder;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        boolean needsBaseline;
        public int orientation;
        int resolveGoneLeftMargin;
        int resolveGoneRightMargin;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias;
        int resolvedLeftToLeft;
        int resolvedLeftToRight;
        int resolvedRightToLeft;
        int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        boolean verticalDimensionFixed;
        public float verticalWeight;
        ConstraintWidget widget;

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                map = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                map.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                map.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                map.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                map.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }

            private Table() {
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            int i2;
            int i3;
            int i4 = -1;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            int i5 = 0;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i6 = 0;
            while (i6 < indexCount) {
                int index = obtainStyledAttributes.getIndex(i6);
                int i7 = Table.map.get(index);
                switch (i7) {
                    case 1:
                        int i8 = i5;
                        i = i4;
                        i2 = i8;
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        i2 = i5;
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        i = -1;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        i2 = i5;
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        i = -1;
                        break;
                    case 4:
                        i2 = i5;
                        float f2 = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f2;
                        if (f2 >= 0.0f) {
                            i = -1;
                            break;
                        } else {
                            this.circleAngle = (360.0f - f2) % 360.0f;
                            i = -1;
                            break;
                        }
                    case 5:
                        i2 = i5;
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        i = -1;
                        break;
                    case 6:
                        i2 = i5;
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        i = -1;
                        break;
                    case 7:
                        i2 = i5;
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        i = -1;
                        break;
                    case 8:
                        int i9 = i5;
                        int i10 = i4;
                        i2 = i9;
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 != i10) {
                            i = -1;
                            break;
                        } else {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, i10);
                            i = -1;
                            break;
                        }
                    case 9:
                        int i11 = i5;
                        i = i4;
                        i2 = i11;
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 != i) {
                            break;
                        } else {
                            this.leftToRight = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 10:
                        int i12 = i5;
                        i = i4;
                        i2 = i12;
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 != i) {
                            break;
                        } else {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 11:
                        int i13 = i5;
                        i = i4;
                        i2 = i13;
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 != i) {
                            break;
                        } else {
                            this.rightToRight = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 12:
                        int i14 = i5;
                        i = i4;
                        i2 = i14;
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 != i) {
                            break;
                        } else {
                            this.topToTop = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 13:
                        int i15 = i5;
                        i = i4;
                        i2 = i15;
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 != i) {
                            break;
                        } else {
                            this.topToBottom = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 14:
                        int i16 = i5;
                        i = i4;
                        i2 = i16;
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 != i) {
                            break;
                        } else {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 15:
                        int i17 = i5;
                        i = i4;
                        i2 = i17;
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 != i) {
                            break;
                        } else {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 16:
                        int i18 = i5;
                        i = i4;
                        i2 = i18;
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 != i) {
                            break;
                        } else {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 17:
                        int i19 = i5;
                        i = i4;
                        i2 = i19;
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 != i) {
                            break;
                        } else {
                            this.startToEnd = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 18:
                        int i20 = i5;
                        i = i4;
                        i2 = i20;
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 != i) {
                            break;
                        } else {
                            this.startToStart = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 19:
                        int i21 = i5;
                        i = i4;
                        i2 = i21;
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 != i) {
                            break;
                        } else {
                            this.endToStart = obtainStyledAttributes.getInt(index, i);
                            break;
                        }
                    case 20:
                        i2 = i5;
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        i = -1;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        i2 = i5;
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        i = -1;
                        break;
                    case 22:
                        i2 = i5;
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        i = -1;
                        break;
                    case 23:
                        i2 = i5;
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        i = -1;
                        break;
                    case 24:
                        i2 = i5;
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        i = -1;
                        break;
                    case 25:
                        i2 = i5;
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        i = -1;
                        break;
                    case 26:
                        i2 = i5;
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        i = -1;
                        break;
                    case 27:
                        i2 = i5;
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        i = -1;
                        break;
                    case 28:
                        i2 = i5;
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        i = -1;
                        break;
                    case 29:
                        i2 = i5;
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        i = -1;
                        break;
                    case 30:
                        i2 = i5;
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        i = -1;
                        break;
                    case 31:
                        i2 = i5;
                        int i22 = obtainStyledAttributes.getInt(index, i2);
                        this.matchConstraintDefaultWidth = i22;
                        if (i22 != 1) {
                            i = -1;
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            i = -1;
                            break;
                        }
                    case 32:
                        i2 = 0;
                        int i23 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i23;
                        if (i23 != 1) {
                            i = -1;
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            i = -1;
                            break;
                        }
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            i2 = 0;
                            i = -1;
                            break;
                        } catch (Exception e2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) == -2) {
                                this.matchConstraintMinWidth = -2;
                            }
                            i2 = 0;
                            i = -1;
                            break;
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            i2 = 0;
                            i = -1;
                            break;
                        } catch (Exception e3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) == -2) {
                                this.matchConstraintMaxWidth = -2;
                            }
                            i2 = 0;
                            i = -1;
                            break;
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        i2 = 0;
                        i = -1;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            i2 = 0;
                            i = -1;
                            break;
                        } catch (Exception e4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) == -2) {
                                this.matchConstraintMinHeight = -2;
                            }
                            i2 = 0;
                            i = -1;
                            break;
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            i2 = 0;
                            i = -1;
                            break;
                        } catch (Exception e5) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) == -2) {
                                this.matchConstraintMaxHeight = -2;
                            }
                            i2 = 0;
                            i = -1;
                            break;
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        i2 = 0;
                        i = -1;
                        break;
                    default:
                        switch (i7) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.dimensionRatio = string;
                                this.dimensionRatioValue = Float.NaN;
                                this.dimensionRatioSide = i4;
                                if (string == null) {
                                    i2 = 0;
                                    i = -1;
                                    break;
                                } else {
                                    int length = string.length();
                                    int indexOf = this.dimensionRatio.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i3 = 0;
                                    } else {
                                        String substring = this.dimensionRatio.substring(i5, indexOf);
                                        if (substring.equalsIgnoreCase(ExifInterface.GpsLongitudeRef.WEST)) {
                                            this.dimensionRatioSide = i5;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.dimensionRatioSide = 1;
                                        }
                                        i3 = indexOf + 1;
                                    }
                                    int indexOf2 = this.dimensionRatio.indexOf(58);
                                    if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                        String substring2 = this.dimensionRatio.substring(i3);
                                        if (substring2.length() > 0) {
                                            try {
                                                this.dimensionRatioValue = Float.parseFloat(substring2);
                                            } catch (NumberFormatException e6) {
                                            }
                                        }
                                    } else {
                                        String substring3 = this.dimensionRatio.substring(i3, indexOf2);
                                        String substring4 = this.dimensionRatio.substring(indexOf2 + 1);
                                        if (substring3.length() > 0 && substring4.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring3);
                                                float parseFloat2 = Float.parseFloat(substring4);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.dimensionRatioSide == 1) {
                                                        this.dimensionRatioValue = Math.abs(parseFloat2 / parseFloat);
                                                    } else {
                                                        this.dimensionRatioValue = Math.abs(parseFloat / parseFloat2);
                                                    }
                                                }
                                            } catch (NumberFormatException e7) {
                                            }
                                        }
                                    }
                                    i2 = 0;
                                    i = -1;
                                    break;
                                }
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                int i24 = i5;
                                i = i4;
                                i2 = i24;
                                break;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                int i25 = i5;
                                i = i4;
                                i2 = i25;
                                break;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, i5);
                                int i26 = i5;
                                i = i4;
                                i2 = i26;
                                break;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, i5);
                                int i27 = i5;
                                i = i4;
                                i2 = i27;
                                break;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                int i28 = i5;
                                i = i4;
                                i2 = i28;
                                break;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                int i29 = i5;
                                i = i4;
                                i2 = i29;
                                break;
                            default:
                                int i30 = i5;
                                i = i4;
                                i2 = i30;
                                break;
                        }
                }
                i6++;
                int i31 = i;
                i5 = i2;
                i4 = i31;
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.widget = layoutParams.widget;
        }

        public void reset() {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        public void resolveLayoutDirection(int i) {
            int i2 = this.leftMargin;
            int i3 = this.rightMargin;
            super.resolveLayoutDirection(i);
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            this.resolvedHorizontalBias = this.horizontalBias;
            this.resolvedGuideBegin = this.guideBegin;
            this.resolvedGuideEnd = this.guideEnd;
            this.resolvedGuidePercent = this.guidePercent;
            if (1 == getLayoutDirection()) {
                boolean z = false;
                int i4 = this.startToEnd;
                if (i4 != -1) {
                    this.resolvedRightToLeft = i4;
                    z = true;
                } else {
                    int i5 = this.startToStart;
                    if (i5 != -1) {
                        this.resolvedRightToRight = i5;
                        z = true;
                    }
                }
                int i6 = this.endToStart;
                if (i6 != -1) {
                    this.resolvedLeftToRight = i6;
                    z = true;
                }
                int i7 = this.endToEnd;
                if (i7 != -1) {
                    this.resolvedLeftToLeft = i7;
                    z = true;
                }
                int i8 = this.goneStartMargin;
                if (i8 != -1) {
                    this.resolveGoneRightMargin = i8;
                }
                int i9 = this.goneEndMargin;
                if (i9 != -1) {
                    this.resolveGoneLeftMargin = i9;
                }
                if (z) {
                    this.resolvedHorizontalBias = 1.0f - this.horizontalBias;
                }
                if (this.isGuideline && this.orientation == 1) {
                    float f2 = this.guidePercent;
                    if (f2 != -1.0f) {
                        this.resolvedGuidePercent = 1.0f - f2;
                        this.resolvedGuideBegin = -1;
                        this.resolvedGuideEnd = -1;
                    } else {
                        int i10 = this.guideBegin;
                        if (i10 != -1) {
                            this.resolvedGuideEnd = i10;
                            this.resolvedGuideBegin = -1;
                            this.resolvedGuidePercent = -1.0f;
                        } else {
                            int i11 = this.guideEnd;
                            if (i11 != -1) {
                                this.resolvedGuideBegin = i11;
                                this.resolvedGuideEnd = -1;
                                this.resolvedGuidePercent = -1.0f;
                            }
                        }
                    }
                }
            } else {
                int i12 = this.startToEnd;
                if (i12 != -1) {
                    this.resolvedLeftToRight = i12;
                }
                int i13 = this.startToStart;
                if (i13 != -1) {
                    this.resolvedLeftToLeft = i13;
                }
                int i14 = this.endToStart;
                if (i14 != -1) {
                    this.resolvedRightToLeft = i14;
                }
                int i15 = this.endToEnd;
                if (i15 != -1) {
                    this.resolvedRightToRight = i15;
                }
                int i16 = this.goneStartMargin;
                if (i16 != -1) {
                    this.resolveGoneLeftMargin = i16;
                }
                int i17 = this.goneEndMargin;
                if (i17 != -1) {
                    this.resolveGoneRightMargin = i17;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                int i18 = this.rightToLeft;
                if (i18 != -1) {
                    this.resolvedRightToLeft = i18;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                } else {
                    int i19 = this.rightToRight;
                    if (i19 != -1) {
                        this.resolvedRightToRight = i19;
                        if (this.rightMargin <= 0 && i3 > 0) {
                            this.rightMargin = i3;
                        }
                    }
                }
                int i20 = this.leftToLeft;
                if (i20 != -1) {
                    this.resolvedLeftToLeft = i20;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                        return;
                    }
                    return;
                }
                int i21 = this.leftToRight;
                if (i21 != -1) {
                    this.resolvedLeftToRight = i21;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                    }
                }
            }
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                this.matchConstraintDefaultWidth = 1;
            }
            if (this.height == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                this.matchConstraintDefaultHeight = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.horizontalDimensionFixed = false;
                if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.verticalDimensionFixed = false;
                if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null) {
            view = findViewById(i);
            if (!(view == null || view == this || view.getParent() != this)) {
                onViewAdded(view);
            }
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    private void init(AttributeSet attributeSet) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId);
                    } catch (Resources.NotFoundException e2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void internalMeasureChildren(int i, int i2) {
        int i3;
        int i4;
        ConstraintLayout constraintLayout = this;
        int i5 = i;
        int i6 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = constraintLayout.getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.widget;
                if (!layoutParams.isGuideline && !layoutParams.isHelper) {
                    constraintWidget.setVisibility(childAt.getVisibility());
                    int i8 = layoutParams.width;
                    int i9 = layoutParams.height;
                    boolean z = false;
                    boolean z2 = false;
                    if (layoutParams.horizontalDimensionFixed || layoutParams.verticalDimensionFixed || (!layoutParams.horizontalDimensionFixed && layoutParams.matchConstraintDefaultWidth == 1) || layoutParams.width == -1 || (!layoutParams.verticalDimensionFixed && (layoutParams.matchConstraintDefaultHeight == 1 || layoutParams.height == -1))) {
                        if (i8 == 0) {
                            z = true;
                            i3 = getChildMeasureSpec(i5, paddingLeft, -2);
                        } else if (i8 == -1) {
                            i3 = getChildMeasureSpec(i5, paddingLeft, -1);
                        } else {
                            if (i8 == -2) {
                                z = true;
                            }
                            i3 = getChildMeasureSpec(i5, paddingLeft, i8);
                        }
                        if (i9 == 0) {
                            z2 = true;
                            i4 = getChildMeasureSpec(i6, paddingTop, -2);
                        } else if (i9 == -1) {
                            i4 = getChildMeasureSpec(i6, paddingTop, -1);
                        } else {
                            if (i9 == -2) {
                                z2 = true;
                            }
                            i4 = getChildMeasureSpec(i6, paddingTop, i9);
                        }
                        childAt.measure(i3, i4);
                        Metrics metrics = constraintLayout.mMetrics;
                        if (metrics != null) {
                            metrics.measures++;
                        }
                        constraintWidget.setWidthWrapContent(i8 == -2);
                        constraintWidget.setHeightWrapContent(i9 == -2);
                        i8 = childAt.getMeasuredWidth();
                        i9 = childAt.getMeasuredHeight();
                    }
                    constraintWidget.setWidth(i8);
                    constraintWidget.setHeight(i9);
                    if (z) {
                        constraintWidget.setWrapWidth(i8);
                    }
                    if (z2) {
                        constraintWidget.setWrapHeight(i9);
                    }
                    if (layoutParams.needsBaseline) {
                        int baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            constraintWidget.setBaselineDistance(baseline);
                        }
                    }
                }
            }
            i7++;
            constraintLayout = this;
            i5 = i;
        }
    }

    private void internalMeasureDimensions(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        int i9;
        int i10;
        ConstraintLayout constraintLayout = this;
        int i11 = i;
        int i12 = i2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            i3 = 8;
            if (i13 >= childCount) {
                break;
            }
            View childAt = constraintLayout.getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                i9 = paddingTop;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = layoutParams.widget;
                if (layoutParams.isGuideline) {
                    i9 = paddingTop;
                } else if (layoutParams.isHelper) {
                    i9 = paddingTop;
                } else {
                    constraintWidget.setVisibility(childAt.getVisibility());
                    int i14 = layoutParams.width;
                    int i15 = layoutParams.height;
                    if (i14 == 0) {
                        i10 = paddingTop;
                    } else if (i15 == 0) {
                        i10 = paddingTop;
                    } else {
                        boolean z2 = false;
                        boolean z3 = false;
                        if (i14 == -2) {
                            z2 = true;
                        }
                        int childMeasureSpec = getChildMeasureSpec(i11, paddingLeft, i14);
                        if (i15 == -2) {
                            z3 = true;
                        }
                        childAt.measure(childMeasureSpec, getChildMeasureSpec(i12, paddingTop, i15));
                        Metrics metrics = constraintLayout.mMetrics;
                        if (metrics != null) {
                            i9 = paddingTop;
                            metrics.measures++;
                        } else {
                            i9 = paddingTop;
                        }
                        constraintWidget.setWidthWrapContent(i14 == -2);
                        constraintWidget.setHeightWrapContent(i15 == -2);
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        constraintWidget.setWidth(measuredWidth);
                        constraintWidget.setHeight(measuredHeight);
                        if (z2) {
                            constraintWidget.setWrapWidth(measuredWidth);
                        }
                        if (z3) {
                            constraintWidget.setWrapHeight(measuredHeight);
                        }
                        if (layoutParams.needsBaseline) {
                            int baseline = childAt.getBaseline();
                            if (baseline != -1) {
                                constraintWidget.setBaselineDistance(baseline);
                            }
                        }
                        if (layoutParams.horizontalDimensionFixed && layoutParams.verticalDimensionFixed) {
                            constraintWidget.getResolutionWidth().resolve(measuredWidth);
                            constraintWidget.getResolutionHeight().resolve(measuredHeight);
                        }
                    }
                    constraintWidget.getResolutionWidth().invalidate();
                    constraintWidget.getResolutionHeight().invalidate();
                }
            }
            i13++;
            i12 = i2;
            paddingTop = i9;
        }
        int i16 = paddingTop;
        constraintLayout.mLayoutWidget.solveGraph();
        int i17 = 0;
        while (i17 < childCount) {
            View childAt2 = constraintLayout.getChildAt(i17);
            if (childAt2.getVisibility() == i3) {
                i5 = i17;
                i4 = paddingLeft;
                i6 = childCount;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                ConstraintWidget constraintWidget2 = layoutParams2.widget;
                if (layoutParams2.isGuideline) {
                    i5 = i17;
                    i4 = paddingLeft;
                    i6 = childCount;
                    LayoutParams layoutParams3 = layoutParams2;
                } else if (layoutParams2.isHelper) {
                    i5 = i17;
                    i4 = paddingLeft;
                    i6 = childCount;
                } else {
                    constraintWidget2.setVisibility(childAt2.getVisibility());
                    int i18 = layoutParams2.width;
                    int i19 = layoutParams2.height;
                    if (i18 == 0 || i19 == 0) {
                        ResolutionAnchor resolutionNode = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
                        ResolutionAnchor resolutionNode2 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getResolutionNode();
                        boolean z4 = (constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getTarget() == null || constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget() == null) ? false : true;
                        ResolutionAnchor resolutionNode3 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
                        ResolutionAnchor resolutionNode4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getResolutionNode();
                        i6 = childCount;
                        boolean z5 = (constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getTarget() == null || constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget() == null) ? false : true;
                        if (i18 != 0 || i19 != 0 || !z4 || !z5) {
                            boolean z6 = false;
                            boolean z7 = false;
                            i5 = i17;
                            LayoutParams layoutParams4 = layoutParams2;
                            boolean z8 = constraintLayout.mLayoutWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            boolean z9 = constraintLayout.mLayoutWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            if (!z8) {
                                constraintWidget2.getResolutionWidth().invalidate();
                            }
                            if (!z9) {
                                constraintWidget2.getResolutionHeight().invalidate();
                            }
                            if (i18 == 0) {
                                if (!z8 || !constraintWidget2.isSpreadWidth() || !z4 || !resolutionNode.isResolved() || !resolutionNode2.isResolved()) {
                                    z6 = true;
                                    z8 = false;
                                    i7 = getChildMeasureSpec(i11, paddingLeft, -2);
                                } else {
                                    i18 = (int) (resolutionNode2.getResolvedValue() - resolutionNode.getResolvedValue());
                                    constraintWidget2.getResolutionWidth().resolve(i18);
                                    i7 = getChildMeasureSpec(i11, paddingLeft, i18);
                                }
                            } else if (i18 == -1) {
                                i7 = getChildMeasureSpec(i11, paddingLeft, -1);
                            } else {
                                if (i18 == -2) {
                                    z6 = true;
                                }
                                i7 = getChildMeasureSpec(i11, paddingLeft, i18);
                            }
                            if (i19 != 0) {
                                z = z9;
                                int i20 = i2;
                                if (i19 == -1) {
                                    i8 = getChildMeasureSpec(i20, i16, -1);
                                } else {
                                    if (i19 == -2) {
                                        z7 = true;
                                    }
                                    i8 = getChildMeasureSpec(i20, i16, i19);
                                }
                            } else if (!z9 || !constraintWidget2.isSpreadHeight() || !z5 || !resolutionNode3.isResolved() || !resolutionNode4.isResolved()) {
                                boolean z10 = z9;
                                z7 = true;
                                z = false;
                                i8 = getChildMeasureSpec(i2, i16, -2);
                            } else {
                                z = z9;
                                i19 = (int) (resolutionNode4.getResolvedValue() - resolutionNode3.getResolvedValue());
                                constraintWidget2.getResolutionHeight().resolve(i19);
                                i8 = getChildMeasureSpec(i2, i16, i19);
                            }
                            childAt2.measure(i7, i8);
                            constraintLayout = this;
                            int i21 = i8;
                            Metrics metrics2 = constraintLayout.mMetrics;
                            if (metrics2 != null) {
                                i4 = paddingLeft;
                                boolean z11 = z5;
                                metrics2.measures++;
                            } else {
                                i4 = paddingLeft;
                                boolean z12 = z5;
                            }
                            constraintWidget2.setWidthWrapContent(i18 == -2);
                            constraintWidget2.setHeightWrapContent(i19 == -2);
                            int measuredWidth2 = childAt2.getMeasuredWidth();
                            int measuredHeight2 = childAt2.getMeasuredHeight();
                            constraintWidget2.setWidth(measuredWidth2);
                            constraintWidget2.setHeight(measuredHeight2);
                            if (z6) {
                                constraintWidget2.setWrapWidth(measuredWidth2);
                            }
                            if (z7) {
                                constraintWidget2.setWrapHeight(measuredHeight2);
                            }
                            if (z8) {
                                constraintWidget2.getResolutionWidth().resolve(measuredWidth2);
                            } else {
                                constraintWidget2.getResolutionWidth().remove();
                            }
                            if (z) {
                                constraintWidget2.getResolutionHeight().resolve(measuredHeight2);
                            } else {
                                constraintWidget2.getResolutionHeight().remove();
                            }
                            if (layoutParams4.needsBaseline) {
                                int baseline2 = childAt2.getBaseline();
                                if (baseline2 != -1) {
                                    constraintWidget2.setBaselineDistance(baseline2);
                                }
                            }
                        } else {
                            i5 = i17;
                            i4 = paddingLeft;
                        }
                    } else {
                        i5 = i17;
                        i4 = paddingLeft;
                        i6 = childCount;
                    }
                }
            }
            i17 = i5 + 1;
            i11 = i;
            childCount = i6;
            paddingLeft = i4;
            i3 = 8;
        }
    }

    private void setChildrenConstraints() {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        LayoutParams layoutParams;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        boolean z2 = false;
        int i15 = -1;
        if (isInEditMode) {
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = getChildAt(i16);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).setDebugName(resourceName);
                } catch (Resources.NotFoundException e2) {
                }
            }
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i17));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt2 = getChildAt(i18);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.applyToInternal(this);
        }
        this.mLayoutWidget.removeAllChildren();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i19 = 0; i19 < size; i19++) {
                this.mConstraintHelpers.get(i19).updatePreLayout(this);
            }
        }
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt3 = getChildAt(i20);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).updatePreLayout(this);
            }
        }
        int i21 = 0;
        while (i21 < childCount) {
            View childAt4 = getChildAt(i21);
            ConstraintWidget viewWidget2 = getViewWidget(childAt4);
            if (viewWidget2 == null) {
                i2 = childCount;
                z = z2;
                i3 = i15;
                i = size;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                layoutParams2.validate();
                if (layoutParams2.helped) {
                    layoutParams2.helped = z2;
                } else if (isInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt4.getId());
                        setDesignInformation(z2 ? 1 : 0, resourceName2, Integer.valueOf(childAt4.getId()));
                        getTargetWidget(childAt4.getId()).setDebugName(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                    } catch (Resources.NotFoundException e3) {
                    }
                }
                viewWidget2.setVisibility(childAt4.getVisibility());
                if (layoutParams2.isInPlaceholder) {
                    viewWidget2.setVisibility(8);
                }
                viewWidget2.setCompanionWidget(childAt4);
                this.mLayoutWidget.add(viewWidget2);
                if (!layoutParams2.verticalDimensionFixed || !layoutParams2.horizontalDimensionFixed) {
                    this.mVariableDimensionsWidgets.add(viewWidget2);
                }
                if (layoutParams2.isGuideline) {
                    Guideline guideline = (Guideline) viewWidget2;
                    int i22 = layoutParams2.resolvedGuideBegin;
                    int i23 = layoutParams2.resolvedGuideEnd;
                    float f2 = layoutParams2.resolvedGuidePercent;
                    if (Build.VERSION.SDK_INT < 17) {
                        i22 = layoutParams2.guideBegin;
                        i23 = layoutParams2.guideEnd;
                        f2 = layoutParams2.guidePercent;
                    }
                    if (f2 != -1.0f) {
                        guideline.setGuidePercent(f2);
                    } else if (i22 != i15) {
                        guideline.setGuideBegin(i22);
                    } else if (i23 != i15) {
                        guideline.setGuideEnd(i23);
                    }
                } else if (!(layoutParams2.leftToLeft == i15 && layoutParams2.leftToRight == i15 && layoutParams2.rightToLeft == i15 && layoutParams2.rightToRight == i15 && layoutParams2.startToStart == i15 && layoutParams2.startToEnd == i15 && layoutParams2.endToStart == i15 && layoutParams2.endToEnd == i15 && layoutParams2.topToTop == i15 && layoutParams2.topToBottom == i15 && layoutParams2.bottomToTop == i15 && layoutParams2.bottomToBottom == i15 && layoutParams2.baselineToBaseline == i15 && layoutParams2.editorAbsoluteX == i15 && layoutParams2.editorAbsoluteY == i15 && layoutParams2.circleConstraint == i15 && layoutParams2.width != i15 && layoutParams2.height != i15)) {
                    int i24 = layoutParams2.resolvedLeftToLeft;
                    int i25 = layoutParams2.resolvedLeftToRight;
                    int i26 = layoutParams2.resolvedRightToLeft;
                    int i27 = layoutParams2.resolvedRightToRight;
                    int i28 = layoutParams2.resolveGoneLeftMargin;
                    int i29 = layoutParams2.resolveGoneRightMargin;
                    float f3 = layoutParams2.resolvedHorizontalBias;
                    int i30 = i24;
                    if (Build.VERSION.SDK_INT < 17) {
                        int i31 = layoutParams2.leftToLeft;
                        int i32 = layoutParams2.leftToRight;
                        int i33 = layoutParams2.rightToLeft;
                        int i34 = layoutParams2.rightToRight;
                        int i35 = layoutParams2.goneLeftMargin;
                        i29 = layoutParams2.goneRightMargin;
                        f3 = layoutParams2.horizontalBias;
                        if (i31 == -1 && i32 == -1) {
                            i14 = i31;
                            if (layoutParams2.startToStart != -1) {
                                i12 = layoutParams2.startToStart;
                                i11 = i32;
                            } else if (layoutParams2.startToEnd != -1) {
                                i11 = layoutParams2.startToEnd;
                                i12 = i14;
                            }
                            if (i33 == -1 || i34 != -1) {
                                i13 = i12;
                            } else {
                                i13 = i12;
                                if (layoutParams2.endToStart != -1) {
                                    i8 = i13;
                                    i4 = i35;
                                    i5 = i11;
                                    int i36 = i34;
                                    i6 = layoutParams2.endToStart;
                                    i7 = i36;
                                } else if (layoutParams2.endToEnd != -1) {
                                    i8 = i13;
                                    i4 = i35;
                                    i5 = i11;
                                    i6 = i33;
                                    i7 = layoutParams2.endToEnd;
                                }
                            }
                            i8 = i13;
                            i4 = i35;
                            i5 = i11;
                            int i37 = i34;
                            i6 = i33;
                            i7 = i37;
                        } else {
                            i14 = i31;
                        }
                        i11 = i32;
                        i12 = i14;
                        if (i33 == -1) {
                        }
                        i13 = i12;
                        i8 = i13;
                        i4 = i35;
                        i5 = i11;
                        int i372 = i34;
                        i6 = i33;
                        i7 = i372;
                    } else {
                        i8 = i30;
                        i4 = i28;
                        i5 = i25;
                        int i38 = i27;
                        i6 = i26;
                        i7 = i38;
                    }
                    if (layoutParams2.circleConstraint != -1) {
                        ConstraintWidget targetWidget = getTargetWidget(layoutParams2.circleConstraint);
                        if (targetWidget != null) {
                            i2 = childCount;
                            viewWidget2.connectCircularConstraint(targetWidget, layoutParams2.circleAngle, layoutParams2.circleRadius);
                        } else {
                            i2 = childCount;
                        }
                        int i39 = i8;
                        i = size;
                        View view = childAt4;
                        int i40 = i7;
                        int i41 = i6;
                        int i42 = i5;
                        layoutParams = layoutParams2;
                    } else {
                        i2 = childCount;
                        if (i8 != -1) {
                            ConstraintWidget targetWidget2 = getTargetWidget(i8);
                            if (targetWidget2 != null) {
                                ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                                int i43 = i8;
                                i10 = i7;
                                ConstraintWidget constraintWidget = targetWidget2;
                                ConstraintWidget constraintWidget2 = targetWidget2;
                                i9 = i6;
                                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.LEFT;
                                i = size;
                                int i44 = i5;
                                View view2 = childAt4;
                                layoutParams = layoutParams2;
                                viewWidget2.immediateConnect(type, constraintWidget, type2, layoutParams2.leftMargin, i4);
                            } else {
                                int i45 = i8;
                                ConstraintWidget constraintWidget3 = targetWidget2;
                                i = size;
                                View view3 = childAt4;
                                i10 = i7;
                                i9 = i6;
                                int i46 = i5;
                                layoutParams = layoutParams2;
                            }
                        } else {
                            int i47 = i8;
                            i = size;
                            View view4 = childAt4;
                            i10 = i7;
                            i9 = i6;
                            int i48 = i5;
                            layoutParams = layoutParams2;
                            if (i48 != -1) {
                                ConstraintWidget targetWidget3 = getTargetWidget(i48);
                                if (targetWidget3 != null) {
                                    viewWidget2.immediateConnect(ConstraintAnchor.Type.LEFT, targetWidget3, ConstraintAnchor.Type.RIGHT, layoutParams.leftMargin, i4);
                                }
                            }
                        }
                        if (i9 != -1) {
                            ConstraintWidget targetWidget4 = getTargetWidget(i9);
                            if (targetWidget4 != null) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.RIGHT, targetWidget4, ConstraintAnchor.Type.LEFT, layoutParams.rightMargin, i29);
                            }
                        } else if (i10 != -1) {
                            ConstraintWidget targetWidget5 = getTargetWidget(i10);
                            if (targetWidget5 != null) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.RIGHT, targetWidget5, ConstraintAnchor.Type.RIGHT, layoutParams.rightMargin, i29);
                            }
                        }
                        if (layoutParams.topToTop != -1) {
                            ConstraintWidget targetWidget6 = getTargetWidget(layoutParams.topToTop);
                            if (targetWidget6 != null) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.TOP, targetWidget6, ConstraintAnchor.Type.TOP, layoutParams.topMargin, layoutParams.goneTopMargin);
                            }
                        } else if (layoutParams.topToBottom != -1) {
                            ConstraintWidget targetWidget7 = getTargetWidget(layoutParams.topToBottom);
                            if (targetWidget7 != null) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.TOP, targetWidget7, ConstraintAnchor.Type.BOTTOM, layoutParams.topMargin, layoutParams.goneTopMargin);
                            }
                        }
                        if (layoutParams.bottomToTop != -1) {
                            ConstraintWidget targetWidget8 = getTargetWidget(layoutParams.bottomToTop);
                            if (targetWidget8 != null) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.BOTTOM, targetWidget8, ConstraintAnchor.Type.TOP, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                            }
                        } else if (layoutParams.bottomToBottom != -1) {
                            ConstraintWidget targetWidget9 = getTargetWidget(layoutParams.bottomToBottom);
                            if (targetWidget9 != null) {
                                viewWidget2.immediateConnect(ConstraintAnchor.Type.BOTTOM, targetWidget9, ConstraintAnchor.Type.BOTTOM, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                            }
                        }
                        if (layoutParams.baselineToBaseline != -1) {
                            View view5 = this.mChildrenByIds.get(layoutParams.baselineToBaseline);
                            ConstraintWidget targetWidget10 = getTargetWidget(layoutParams.baselineToBaseline);
                            if (!(targetWidget10 == null || view5 == null || !(view5.getLayoutParams() instanceof LayoutParams))) {
                                layoutParams.needsBaseline = true;
                                ((LayoutParams) view5.getLayoutParams()).needsBaseline = true;
                                viewWidget2.getAnchor(ConstraintAnchor.Type.BASELINE).connect(targetWidget10.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
                                viewWidget2.getAnchor(ConstraintAnchor.Type.TOP).reset();
                                viewWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                            }
                        }
                        if (f3 >= 0.0f && f3 != 0.5f) {
                            viewWidget2.setHorizontalBiasPercent(f3);
                        }
                        if (layoutParams.verticalBias >= 0.0f && layoutParams.verticalBias != 0.5f) {
                            viewWidget2.setVerticalBiasPercent(layoutParams.verticalBias);
                        }
                    }
                    if (isInEditMode && !(layoutParams.editorAbsoluteX == -1 && layoutParams.editorAbsoluteY == -1)) {
                        viewWidget2.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
                    }
                    if (layoutParams.horizontalDimensionFixed) {
                        viewWidget2.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        viewWidget2.setWidth(layoutParams.width);
                    } else if (layoutParams.width == -1) {
                        viewWidget2.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                        viewWidget2.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = layoutParams.leftMargin;
                        viewWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = layoutParams.rightMargin;
                    } else {
                        viewWidget2.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                        viewWidget2.setWidth(0);
                    }
                    if (!layoutParams.verticalDimensionFixed) {
                        i3 = -1;
                        if (layoutParams.height == -1) {
                            viewWidget2.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                            viewWidget2.getAnchor(ConstraintAnchor.Type.TOP).mMargin = layoutParams.topMargin;
                            viewWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = layoutParams.bottomMargin;
                            z = false;
                        } else {
                            viewWidget2.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                            z = false;
                            viewWidget2.setHeight(0);
                        }
                    } else {
                        z = false;
                        i3 = -1;
                        viewWidget2.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        viewWidget2.setHeight(layoutParams.height);
                    }
                    if (layoutParams.dimensionRatio != null) {
                        viewWidget2.setDimensionRatio(layoutParams.dimensionRatio);
                    }
                    viewWidget2.setHorizontalWeight(layoutParams.horizontalWeight);
                    viewWidget2.setVerticalWeight(layoutParams.verticalWeight);
                    viewWidget2.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
                    viewWidget2.setVerticalChainStyle(layoutParams.verticalChainStyle);
                    viewWidget2.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
                    viewWidget2.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
                }
                i2 = childCount;
                z = z2;
                i3 = i15;
                i = size;
            }
            i21++;
            z2 = z;
            i15 = i3;
            childCount = i2;
            size = i;
        }
    }

    private void setSelfDimensionBehaviour(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int i3 = 0;
        int i4 = 0;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (mode == Integer.MIN_VALUE) {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            i3 = size;
        } else if (mode == 0) {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        } else if (mode == 1073741824) {
            i3 = Math.min(this.mMaxWidth, size) - paddingLeft;
        }
        if (mode2 == Integer.MIN_VALUE) {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            i4 = size2;
        } else if (mode2 == 0) {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        } else if (mode2 == 1073741824) {
            i4 = Math.min(this.mMaxHeight, size2) - paddingTop;
        }
        this.mLayoutWidget.setMinWidth(0);
        this.mLayoutWidget.setMinHeight(0);
        this.mLayoutWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.mLayoutWidget.setWidth(i3);
        this.mLayoutWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
        this.mLayoutWidget.setHeight(i4);
        this.mLayoutWidget.setMinWidth((this.mMinWidth - getPaddingLeft()) - getPaddingRight());
        this.mLayoutWidget.setMinHeight((this.mMinHeight - getPaddingTop()) - getPaddingBottom());
    }

    private void updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.mVariableDimensionsWidgets.clear();
            setChildrenConstraints();
        }
    }

    private void updatePostMeasures() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).updatePostMeasure(this);
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.mConstraintHelpers.get(i2).updatePostMeasure(this);
            }
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int i;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            float f5 = 1080.0f;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 8) {
                    i = childCount;
                    f4 = width;
                    f3 = height;
                    f2 = f5;
                } else {
                    Object tag = childAt.getTag();
                    if (tag == null || !(tag instanceof String)) {
                        i = childCount;
                        f4 = width;
                        f3 = height;
                        f2 = f5;
                    } else {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            int i3 = (int) ((((float) parseInt) / f5) * width);
                            int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                            int parseInt3 = (int) ((((float) Integer.parseInt(split[2])) / f5) * width);
                            int parseInt4 = (int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height);
                            Paint paint = new Paint();
                            i = childCount;
                            paint.setColor(-65536);
                            f4 = width;
                            f3 = height;
                            f2 = f5;
                            Canvas canvas2 = canvas;
                            Paint paint2 = paint;
                            canvas2.drawLine((float) i3, (float) i4, (float) (i3 + parseInt3), (float) i4, paint2);
                            canvas2.drawLine((float) (i3 + parseInt3), (float) i4, (float) (i3 + parseInt3), (float) (i4 + parseInt4), paint2);
                            canvas2.drawLine((float) (i3 + parseInt3), (float) (i4 + parseInt4), (float) i3, (float) (i4 + parseInt4), paint2);
                            canvas2.drawLine((float) i3, (float) (i4 + parseInt4), (float) i3, (float) i4, paint2);
                            paint.setColor(-16711936);
                            canvas2.drawLine((float) i3, (float) i4, (float) (i3 + parseInt3), (float) (i4 + parseInt4), paint2);
                            canvas2.drawLine((float) i3, (float) (i4 + parseInt4), (float) (i3 + parseInt3), (float) i4, paint2);
                        } else {
                            i = childCount;
                            f4 = width;
                            f3 = height;
                            f2 = f5;
                        }
                    }
                }
                i2++;
                childCount = i;
                width = f4;
                height = f3;
                f5 = f2;
            }
            int i5 = childCount;
            float f6 = width;
            float f7 = height;
            float f8 = f5;
            return;
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || isInEditMode) && !layoutParams.isInPlaceholder) {
                int drawX = constraintWidget.getDrawX();
                int drawY = constraintWidget.getDrawY();
                int width = constraintWidget.getWidth() + drawX;
                int height = constraintWidget.getHeight() + drawY;
                childAt.layout(drawX, drawY, width, height);
                if (childAt instanceof Placeholder) {
                    View content = ((Placeholder) childAt).getContent();
                    if (content != null) {
                        content.setVisibility(0);
                        content.layout(drawX, drawY, width, height);
                    }
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePostLayout(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        int i7;
        int i8;
        int i9;
        int i10 = i;
        int i11 = i2;
        long currentTimeMillis = System.currentTimeMillis();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.mLayoutWidget.setX(paddingLeft);
        this.mLayoutWidget.setY(paddingTop);
        this.mLayoutWidget.setMaxWidth(this.mMaxWidth);
        this.mLayoutWidget.setMaxHeight(this.mMaxHeight);
        if (Build.VERSION.SDK_INT >= 17) {
            this.mLayoutWidget.setRtl(getLayoutDirection() == 1);
        }
        setSelfDimensionBehaviour(i, i2);
        int width = this.mLayoutWidget.getWidth();
        int height = this.mLayoutWidget.getHeight();
        boolean z3 = false;
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            updateHierarchy();
            z3 = true;
        }
        long j = currentTimeMillis;
        boolean z4 = (this.mOptimizationLevel & 8) == 8;
        if (z4) {
            this.mLayoutWidget.preOptimize();
            this.mLayoutWidget.optimizeForDimensions(width, height);
            internalMeasureDimensions(i, i2);
        } else {
            internalMeasureChildren(i, i2);
        }
        updatePostMeasures();
        if (getChildCount() > 0 && z3) {
            Analyzer.determineGroups(this.mLayoutWidget);
        }
        if (this.mLayoutWidget.mGroupsWrapOptimized) {
            if (this.mLayoutWidget.mHorizontalWrapOptimized && mode == Integer.MIN_VALUE) {
                if (this.mLayoutWidget.mWrapFixedWidth < size) {
                    ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
                    constraintWidgetContainer.setWidth(constraintWidgetContainer.mWrapFixedWidth);
                }
                this.mLayoutWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            }
            if (this.mLayoutWidget.mVerticalWrapOptimized && mode2 == Integer.MIN_VALUE) {
                if (this.mLayoutWidget.mWrapFixedHeight < size2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutWidget;
                    constraintWidgetContainer2.setHeight(constraintWidgetContainer2.mWrapFixedHeight);
                }
                this.mLayoutWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            }
        }
        int i12 = 0;
        if ((this.mOptimizationLevel & 32) == 32) {
            int width2 = this.mLayoutWidget.getWidth();
            int height2 = this.mLayoutWidget.getHeight();
            if (this.mLastMeasureWidth == width2 || mode != 1073741824) {
                i3 = 0;
            } else {
                i3 = 0;
                Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 0, width2);
            }
            if (this.mLastMeasureHeight != height2 && mode2 == 1073741824) {
                Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 1, height2);
            }
            if (this.mLayoutWidget.mHorizontalWrapOptimized && this.mLayoutWidget.mWrapFixedWidth > size) {
                Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 0, size);
            }
            if (this.mLayoutWidget.mVerticalWrapOptimized && this.mLayoutWidget.mWrapFixedHeight > size2) {
                Analyzer.setPosition(this.mLayoutWidget.mWidgetGroups, 1, size2);
            }
        } else {
            i3 = 0;
        }
        if (getChildCount() > 0) {
            solveLinearSystem("First pass");
        }
        int size3 = this.mVariableDimensionsWidgets.size();
        int paddingBottom = getPaddingBottom() + paddingTop;
        int paddingRight = paddingLeft + getPaddingRight();
        if (size3 > 0) {
            int i13 = mode;
            boolean z5 = this.mLayoutWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int i14 = size;
            boolean z6 = this.mLayoutWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int i15 = mode2;
            int max = Math.max(this.mLayoutWidget.getWidth(), this.mMinWidth);
            int i16 = size2;
            int max2 = Math.max(this.mLayoutWidget.getHeight(), this.mMinHeight);
            int i17 = 0;
            boolean z7 = false;
            int i18 = paddingLeft;
            int i19 = 0;
            int i20 = max;
            int i21 = i16;
            while (i19 < size3) {
                int i22 = paddingTop;
                ConstraintWidget constraintWidget = this.mVariableDimensionsWidgets.get(i19);
                int i23 = size3;
                View view = (View) constraintWidget.getCompanionWidget();
                if (view == null) {
                    i7 = i19;
                    i9 = width;
                    i8 = height;
                } else {
                    i8 = height;
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    i9 = width;
                    if (layoutParams.isHelper) {
                        i7 = i19;
                    } else if (layoutParams.isGuideline) {
                        i7 = i19;
                    } else {
                        i7 = i19;
                        if (view.getVisibility() != 8 && (!z4 || !constraintWidget.getResolutionWidth().isResolved() || !constraintWidget.getResolutionHeight().isResolved())) {
                            int makeMeasureSpec = (layoutParams.width != -2 || !layoutParams.horizontalDimensionFixed) ? View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), 1073741824) : getChildMeasureSpec(i10, paddingRight, layoutParams.width);
                            int makeMeasureSpec2 = (layoutParams.height != -2 || !layoutParams.verticalDimensionFixed) ? View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), 1073741824) : getChildMeasureSpec(i11, paddingBottom, layoutParams.height);
                            view.measure(makeMeasureSpec, makeMeasureSpec2);
                            Metrics metrics = this.mMetrics;
                            if (metrics != null) {
                                int i24 = makeMeasureSpec2;
                                metrics.additionalMeasures++;
                            } else {
                                int i25 = makeMeasureSpec2;
                            }
                            i12++;
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            if (measuredWidth != constraintWidget.getWidth()) {
                                constraintWidget.setWidth(measuredWidth);
                                if (z4) {
                                    constraintWidget.getResolutionWidth().resolve(measuredWidth);
                                }
                                if (!z5 || constraintWidget.getRight() <= i20) {
                                    int i26 = measuredWidth;
                                } else {
                                    int i27 = measuredWidth;
                                    i20 = Math.max(i20, constraintWidget.getRight() + constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                                }
                                z7 = true;
                            } else {
                                int i28 = measuredWidth;
                            }
                            if (measuredHeight != constraintWidget.getHeight()) {
                                constraintWidget.setHeight(measuredHeight);
                                if (z4) {
                                    constraintWidget.getResolutionHeight().resolve(measuredHeight);
                                }
                                if (z6 && constraintWidget.getBottom() > max2) {
                                    max2 = Math.max(max2, constraintWidget.getBottom() + constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                                }
                                z7 = true;
                            }
                            if (layoutParams.needsBaseline) {
                                int baseline = view.getBaseline();
                                if (!(baseline == -1 || baseline == constraintWidget.getBaselineDistance())) {
                                    constraintWidget.setBaselineDistance(baseline);
                                    z7 = true;
                                }
                            }
                            if (Build.VERSION.SDK_INT >= 11) {
                                i17 = combineMeasuredStates(i17, view.getMeasuredState());
                            }
                        }
                    }
                }
                i19 = i7 + 1;
                i10 = i;
                i11 = i2;
                paddingTop = i22;
                width = i9;
                size3 = i23;
                height = i8;
            }
            int i29 = size3;
            int i30 = i19;
            int i31 = paddingTop;
            int i32 = width;
            int i33 = height;
            if (z7) {
                i5 = i32;
                this.mLayoutWidget.setWidth(i5);
                this.mLayoutWidget.setHeight(i33);
                if (z4) {
                    this.mLayoutWidget.solveGraph();
                }
                solveLinearSystem("2nd pass");
                boolean z8 = false;
                if (this.mLayoutWidget.getWidth() < i20) {
                    this.mLayoutWidget.setWidth(i20);
                    z8 = true;
                }
                if (this.mLayoutWidget.getHeight() < max2) {
                    this.mLayoutWidget.setHeight(max2);
                    z2 = true;
                } else {
                    z2 = z8;
                }
                if (z2) {
                    solveLinearSystem("3rd pass");
                }
            } else {
                i5 = i32;
                int i34 = i33;
            }
            int i35 = 0;
            while (true) {
                int i36 = i29;
                if (i35 >= i36) {
                    break;
                }
                ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i35);
                View view2 = (View) constraintWidget2.getCompanionWidget();
                if (view2 == null) {
                    i6 = i5;
                    z = z5;
                } else {
                    i6 = i5;
                    if (view2.getMeasuredWidth() == constraintWidget2.getWidth() && view2.getMeasuredHeight() == constraintWidget2.getHeight()) {
                        z = z5;
                    } else if (constraintWidget2.getVisibility() != 8) {
                        int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(constraintWidget2.getWidth(), 1073741824);
                        z = z5;
                        int makeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(constraintWidget2.getHeight(), 1073741824);
                        view2.measure(makeMeasureSpec3, makeMeasureSpec4);
                        Metrics metrics2 = this.mMetrics;
                        if (metrics2 != null) {
                            int i37 = makeMeasureSpec3;
                            int i38 = makeMeasureSpec4;
                            metrics2.additionalMeasures++;
                        } else {
                            int i39 = makeMeasureSpec3;
                            int i40 = makeMeasureSpec4;
                        }
                        i3++;
                    } else {
                        z = z5;
                    }
                }
                i35++;
                i29 = i36;
                z5 = z;
                i5 = i6;
            }
            int i41 = i5;
            boolean z9 = z5;
            i4 = i17;
        } else {
            int i42 = mode;
            int i43 = size;
            int i44 = mode2;
            int i45 = size2;
            int i46 = paddingLeft;
            int i47 = paddingTop;
            int i48 = width;
            int i49 = size3;
            int i50 = height;
            i4 = 0;
        }
        int width3 = this.mLayoutWidget.getWidth() + paddingRight;
        int height3 = this.mLayoutWidget.getHeight() + paddingBottom;
        if (Build.VERSION.SDK_INT >= 11) {
            int min = Math.min(this.mMaxWidth, resolveSizeAndState(width3, i, i4) & 16777215);
            int min2 = Math.min(this.mMaxHeight, resolveSizeAndState(height3, i2, i4 << 16) & 16777215);
            if (this.mLayoutWidget.isWidthMeasuredTooSmall()) {
                min |= 16777216;
            }
            if (this.mLayoutWidget.isHeightMeasuredTooSmall()) {
                min2 |= 16777216;
            }
            setMeasuredDimension(min, min2);
            this.mLastMeasureWidth = min;
            this.mLastMeasureHeight = min2;
            return;
        }
        int i51 = i;
        int i52 = i2;
        setMeasuredDimension(width3, height3);
        this.mLastMeasureWidth = width3;
        this.mLastMeasureHeight = height3;
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.widget = new Guideline();
            layoutParams.isGuideline = true;
            ((Guideline) layoutParams.widget).setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.remove(viewWidget);
        this.mConstraintHelpers.remove(view);
        this.mVariableDimensionsWidgets.remove(viewWidget);
        this.mDirtyHierarchy = true;
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setOptimizationLevel(int i) {
        this.mLayoutWidget.setOptimizationLevel(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void solveLinearSystem(String str) {
        this.mLayoutWidget.layout();
        Metrics metrics = this.mMetrics;
        if (metrics != null) {
            metrics.resolutions++;
        }
    }
}
