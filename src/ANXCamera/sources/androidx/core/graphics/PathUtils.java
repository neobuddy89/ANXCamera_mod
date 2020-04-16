package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;

public final class PathUtils {
    private PathUtils() {
    }

    public static Collection<PathSegment> flatten(Path path) {
        return flatten(path, 0.5f);
    }

    public static Collection<PathSegment> flatten(Path path, float f2) {
        float[] approximate = path.approximate(f2);
        int length = approximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 1; i < length; i++) {
            int i2 = i * 3;
            int i3 = (i - 1) * 3;
            float f3 = approximate[i2];
            float f4 = approximate[i2 + 1];
            float f5 = approximate[i2 + 2];
            float f6 = approximate[i3];
            float f7 = approximate[i3 + 1];
            float f8 = approximate[i3 + 2];
            if (!(f3 == f6 || (f4 == f7 && f5 == f8))) {
                arrayList.add(new PathSegment(new PointF(f7, f8), f6, new PointF(f4, f5), f3));
            }
        }
        return arrayList;
    }
}
