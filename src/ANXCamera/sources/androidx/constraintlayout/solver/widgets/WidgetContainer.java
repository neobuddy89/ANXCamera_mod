package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
    protected ArrayList<ConstraintWidget> mChildren = new ArrayList<>();

    public WidgetContainer() {
    }

    public WidgetContainer(int i, int i2) {
        super(i, i2);
    }

    public WidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public static Rectangle getBounds(ArrayList<ConstraintWidget> arrayList) {
        Rectangle rectangle = new Rectangle();
        if (arrayList.size() == 0) {
            return rectangle;
        }
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = arrayList.get(i5);
            if (constraintWidget.getX() < i) {
                i = constraintWidget.getX();
            }
            if (constraintWidget.getY() < i3) {
                i3 = constraintWidget.getY();
            }
            if (constraintWidget.getRight() > i2) {
                i2 = constraintWidget.getRight();
            }
            if (constraintWidget.getBottom() > i4) {
                i4 = constraintWidget.getBottom();
            }
        }
        rectangle.setBounds(i, i3, i2 - i, i4 - i3);
        return rectangle;
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget add : constraintWidgetArr) {
            add(add);
        }
    }

    public ConstraintWidget findWidget(float f2, float f3) {
        ConstraintWidget constraintWidget = null;
        int drawX = getDrawX();
        int drawY = getDrawY();
        int width = getWidth() + drawX;
        int height = getHeight() + drawY;
        if (f2 >= ((float) drawX) && f2 <= ((float) width) && f3 >= ((float) drawY) && f3 <= ((float) height)) {
            constraintWidget = this;
        }
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget2 = this.mChildren.get(i);
            if (constraintWidget2 instanceof WidgetContainer) {
                ConstraintWidget findWidget = ((WidgetContainer) constraintWidget2).findWidget(f2, f3);
                if (findWidget != null) {
                    constraintWidget = findWidget;
                }
            } else {
                int drawX2 = constraintWidget2.getDrawX();
                int drawY2 = constraintWidget2.getDrawY();
                int width2 = constraintWidget2.getWidth() + drawX2;
                int height2 = constraintWidget2.getHeight() + drawY2;
                if (f2 < ((float) drawX2) || f2 > ((float) width2) || f3 < ((float) drawY2) || f3 > ((float) height2)) {
                    int i2 = height2;
                    int i3 = width2;
                } else {
                    constraintWidget = constraintWidget2;
                    int i4 = height2;
                    int i5 = width2;
                }
            }
        }
        return constraintWidget;
    }

    public ArrayList<ConstraintWidget> findWidgets(int i, int i2, int i3, int i4) {
        ArrayList<ConstraintWidget> arrayList = new ArrayList<>();
        Rectangle rectangle = new Rectangle();
        rectangle.setBounds(i, i2, i3, i4);
        int size = this.mChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i5);
            Rectangle rectangle2 = new Rectangle();
            rectangle2.setBounds(constraintWidget.getDrawX(), constraintWidget.getDrawY(), constraintWidget.getWidth(), constraintWidget.getHeight());
            if (rectangle.intersects(rectangle2)) {
                arrayList.add(constraintWidget);
            }
        }
        return arrayList;
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget parent = getParent();
        ConstraintWidgetContainer constraintWidgetContainer = null;
        if (this instanceof ConstraintWidgetContainer) {
            constraintWidgetContainer = (ConstraintWidgetContainer) this;
        }
        while (parent != null) {
            ConstraintWidget constraintWidget = parent;
            parent = constraintWidget.getParent();
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget;
            }
        }
        return constraintWidgetContainer;
    }

    public void layout() {
        updateDrawPosition();
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).layout();
                }
            }
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.setParent((ConstraintWidget) null);
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).resetSolverVariables(cache);
        }
    }

    public void setOffset(int i, int i2) {
        super.setOffset(i, i2);
        int size = this.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mChildren.get(i3).setOffset(getRootX(), getRootY());
        }
    }

    public void updateDrawPosition() {
        super.updateDrawPosition();
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                constraintWidget.setOffset(getDrawX(), getDrawY());
                if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                    constraintWidget.updateDrawPosition();
                }
            }
        }
    }
}
