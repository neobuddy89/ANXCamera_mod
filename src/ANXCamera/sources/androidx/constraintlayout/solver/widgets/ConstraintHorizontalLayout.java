package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;

public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
    private ContentAlignment mAlignment = ContentAlignment.MIDDLE;

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

    public ConstraintHorizontalLayout() {
    }

    public ConstraintHorizontalLayout(int i, int i2) {
        super(i, i2);
    }

    public ConstraintHorizontalLayout(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public void addToSolver(LinearSystem linearSystem) {
        if (this.mChildren.size() != 0) {
            ConstraintHorizontalLayout constraintHorizontalLayout = this;
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) this.mChildren.get(i);
                if (constraintHorizontalLayout != this) {
                    constraintWidget.connect(ConstraintAnchor.Type.LEFT, (ConstraintWidget) constraintHorizontalLayout, ConstraintAnchor.Type.RIGHT);
                    constraintHorizontalLayout.connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.LEFT);
                } else {
                    constraintWidget.connect(ConstraintAnchor.Type.LEFT, (ConstraintWidget) constraintHorizontalLayout, ConstraintAnchor.Type.LEFT, 0, this.mAlignment == ContentAlignment.END ? ConstraintAnchor.Strength.WEAK : ConstraintAnchor.Strength.STRONG);
                }
                constraintWidget.connect(ConstraintAnchor.Type.TOP, (ConstraintWidget) this, ConstraintAnchor.Type.TOP);
                constraintWidget.connect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget) this, ConstraintAnchor.Type.BOTTOM);
                constraintHorizontalLayout = constraintWidget;
            }
            if (constraintHorizontalLayout != this) {
                ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
                if (this.mAlignment == ContentAlignment.BEGIN) {
                    strength = ConstraintAnchor.Strength.WEAK;
                }
                constraintHorizontalLayout.connect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget) this, ConstraintAnchor.Type.RIGHT, 0, strength);
            }
        }
        super.addToSolver(linearSystem);
    }
}
