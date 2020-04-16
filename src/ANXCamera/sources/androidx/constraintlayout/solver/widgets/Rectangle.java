package androidx.constraintlayout.solver.widgets;

public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public boolean contains(int i, int i2) {
        int i3 = this.x;
        if (i >= i3 && i < i3 + this.width) {
            int i4 = this.y;
            return i2 >= i4 && i2 < i4 + this.height;
        }
    }

    public int getCenterX() {
        return (this.x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }

    /* access modifiers changed from: package-private */
    public void grow(int i, int i2) {
        this.x -= i;
        this.y -= i2;
        this.width += i * 2;
        this.height += i2 * 2;
    }

    /* access modifiers changed from: package-private */
    public boolean intersects(Rectangle rectangle) {
        int i = this.x;
        int i2 = rectangle.x;
        if (i >= i2 && i < i2 + rectangle.width) {
            int i3 = this.y;
            int i4 = rectangle.y;
            return i3 >= i4 && i3 < i4 + rectangle.height;
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.x = i;
        this.y = i2;
        this.width = i3;
        this.height = i4;
    }
}
