package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class PathParser {
    private static final String LOGTAG = "PathParser";

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        PathDataNode(char c2, float[] fArr) {
            this.mType = c2;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        private static void addCommand(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i;
            int i2;
            float f2;
            float f3;
            float f4;
            float f5;
            Path path2 = path;
            char c4 = c3;
            float[] fArr3 = fArr2;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            float f9 = fArr[3];
            float f10 = fArr[4];
            float f11 = fArr[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    f6 = f10;
                    f7 = f11;
                    f8 = f10;
                    f9 = f11;
                    path2.moveTo(f6, f7);
                    i = 2;
                    break;
                default:
                    i = 2;
                    break;
            }
            char c5 = c2;
            int i3 = 0;
            float f12 = f6;
            float f13 = f8;
            float f14 = f9;
            float f15 = f10;
            float f16 = f11;
            float f17 = f7;
            while (i3 < fArr3.length) {
                if (c4 == 'A') {
                    i2 = i3;
                    char c6 = c5;
                    drawArc(path, f12, f17, fArr3[i2 + 5], fArr3[i2 + 6], fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3] != 0.0f, fArr3[i2 + 4] != 0.0f);
                    float f18 = fArr3[i2 + 5];
                    float f19 = fArr3[i2 + 6];
                    f12 = f18;
                    f17 = f19;
                    f13 = f18;
                    f14 = f19;
                } else if (c4 == 'C') {
                    float f20 = f17;
                    float f21 = f12;
                    i2 = i3;
                    char c7 = c5;
                    path.cubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3], fArr3[i2 + 4], fArr3[i2 + 5]);
                    f12 = fArr3[i2 + 4];
                    f17 = fArr3[i2 + 5];
                    f13 = fArr3[i2 + 2];
                    f14 = fArr3[i2 + 3];
                } else if (c4 == 'H') {
                    float f22 = f12;
                    i2 = i3;
                    char c8 = c5;
                    path2.lineTo(fArr3[i2 + 0], f17);
                    f12 = fArr3[i2 + 0];
                } else if (c4 == 'Q') {
                    float f23 = f17;
                    float f24 = f12;
                    i2 = i3;
                    char c9 = c5;
                    path2.quadTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3]);
                    f13 = fArr3[i2 + 0];
                    f14 = fArr3[i2 + 1];
                    f12 = fArr3[i2 + 2];
                    f17 = fArr3[i2 + 3];
                } else if (c4 == 'V') {
                    float f25 = f17;
                    i2 = i3;
                    char c10 = c5;
                    path2.lineTo(f12, fArr3[i2 + 0]);
                    f17 = fArr3[i2 + 0];
                } else if (c4 == 'a') {
                    float f26 = f17;
                    float f27 = fArr3[i3 + 5] + f12;
                    float f28 = fArr3[i3 + 6] + f26;
                    float f29 = fArr3[i3 + 0];
                    float f30 = fArr3[i3 + 1];
                    float f31 = fArr3[i3 + 2];
                    boolean z = fArr3[i3 + 3] != 0.0f;
                    boolean z2 = fArr3[i3 + 4] != 0.0f;
                    float f32 = f12;
                    float f33 = f31;
                    i2 = i3;
                    boolean z3 = z;
                    char c11 = c5;
                    drawArc(path, f12, f26, f27, f28, f29, f30, f33, z3, z2);
                    f12 = f32 + fArr3[i2 + 5];
                    f17 = f26 + fArr3[i2 + 6];
                    f13 = f12;
                    f14 = f17;
                } else if (c4 == 'c') {
                    float f34 = f17;
                    path.rCubicTo(fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3], fArr3[i3 + 4], fArr3[i3 + 5]);
                    float f35 = fArr3[i3 + 2] + f12;
                    float f36 = f34 + fArr3[i3 + 3];
                    f12 += fArr3[i3 + 4];
                    f13 = f35;
                    f14 = f36;
                    i2 = i3;
                    char c12 = c5;
                    f17 = fArr3[i3 + 5] + f34;
                } else if (c4 == 'h') {
                    float f37 = f17;
                    path2.rLineTo(fArr3[i3 + 0], 0.0f);
                    f12 += fArr3[i3 + 0];
                    i2 = i3;
                    char c13 = c5;
                } else if (c4 == 'q') {
                    float f38 = f17;
                    path2.rQuadTo(fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3]);
                    float f39 = fArr3[i3 + 0] + f12;
                    float f40 = f38 + fArr3[i3 + 1];
                    f12 += fArr3[i3 + 2];
                    f13 = f39;
                    f14 = f40;
                    i2 = i3;
                    char c14 = c5;
                    f17 = fArr3[i3 + 3] + f38;
                } else if (c4 == 'v') {
                    path2.rLineTo(0.0f, fArr3[i3 + 0]);
                    f17 += fArr3[i3 + 0];
                    i2 = i3;
                    char c15 = c5;
                } else if (c4 == 'L') {
                    float f41 = f17;
                    path2.lineTo(fArr3[i3 + 0], fArr3[i3 + 1]);
                    f12 = fArr3[i3 + 0];
                    f17 = fArr3[i3 + 1];
                    i2 = i3;
                    char c16 = c5;
                } else if (c4 == 'M') {
                    float f42 = f17;
                    float f43 = fArr3[i3 + 0];
                    float f44 = fArr3[i3 + 1];
                    if (i3 > 0) {
                        path2.lineTo(fArr3[i3 + 0], fArr3[i3 + 1]);
                        f12 = f43;
                        f17 = f44;
                        i2 = i3;
                        char c17 = c5;
                    } else {
                        path2.moveTo(fArr3[i3 + 0], fArr3[i3 + 1]);
                        f12 = f43;
                        f17 = f44;
                        f15 = f43;
                        f16 = f44;
                        i2 = i3;
                        char c18 = c5;
                    }
                } else if (c4 == 'S') {
                    float f45 = f17;
                    float f46 = f12;
                    float f47 = f45;
                    if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                        f3 = (f12 * 2.0f) - f13;
                        f2 = (f45 * 2.0f) - f14;
                    } else {
                        f3 = f46;
                        f2 = f47;
                    }
                    path.cubicTo(f3, f2, fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3]);
                    f13 = fArr3[i3 + 0];
                    f14 = fArr3[i3 + 1];
                    f12 = fArr3[i3 + 2];
                    f17 = fArr3[i3 + 3];
                    i2 = i3;
                    char c19 = c5;
                } else if (c4 == 'T') {
                    float f48 = f17;
                    float f49 = f12;
                    float f50 = f48;
                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                        f49 = (f12 * 2.0f) - f13;
                        f50 = (f48 * 2.0f) - f14;
                    }
                    path2.quadTo(f49, f50, fArr3[i3 + 0], fArr3[i3 + 1]);
                    f13 = f49;
                    f14 = f50;
                    f12 = fArr3[i3 + 0];
                    f17 = fArr3[i3 + 1];
                    i2 = i3;
                    char c20 = c5;
                } else if (c4 == 'l') {
                    path2.rLineTo(fArr3[i3 + 0], fArr3[i3 + 1]);
                    f12 += fArr3[i3 + 0];
                    f17 += fArr3[i3 + 1];
                    i2 = i3;
                    char c21 = c5;
                } else if (c4 == 'm') {
                    f12 += fArr3[i3 + 0];
                    f17 += fArr3[i3 + 1];
                    if (i3 > 0) {
                        path2.rLineTo(fArr3[i3 + 0], fArr3[i3 + 1]);
                        i2 = i3;
                        char c22 = c5;
                    } else {
                        path2.rMoveTo(fArr3[i3 + 0], fArr3[i3 + 1]);
                        f15 = f12;
                        f16 = f17;
                        i2 = i3;
                        char c23 = c5;
                    }
                } else if (c4 == 's') {
                    if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                        f5 = f12 - f13;
                        f4 = f17 - f14;
                    } else {
                        f5 = 0.0f;
                        f4 = 0.0f;
                    }
                    float f51 = f4;
                    float f52 = f4;
                    float f53 = f17;
                    path.rCubicTo(f5, f51, fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3]);
                    float f54 = fArr3[i3 + 0] + f12;
                    float f55 = f53 + fArr3[i3 + 1];
                    f12 += fArr3[i3 + 2];
                    f13 = f54;
                    f14 = f55;
                    i2 = i3;
                    char c24 = c5;
                    f17 = fArr3[i3 + 3] + f53;
                } else if (c4 != 't') {
                    i2 = i3;
                    char c25 = c5;
                } else {
                    float f56 = 0.0f;
                    float f57 = 0.0f;
                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                        f56 = f12 - f13;
                        f57 = f17 - f14;
                    }
                    path2.rQuadTo(f56, f57, fArr3[i3 + 0], fArr3[i3 + 1]);
                    float f58 = f12 + f56;
                    float f59 = f17 + f57;
                    f12 += fArr3[i3 + 0];
                    f17 += fArr3[i3 + 1];
                    f13 = f58;
                    f14 = f59;
                    i2 = i3;
                    char c26 = c5;
                }
                c5 = c3;
                i3 = i2 + i;
                c4 = c3;
            }
            fArr[0] = f12;
            fArr[1] = f17;
            fArr[2] = f13;
            fArr[3] = f14;
            fArr[4] = f15;
            fArr[5] = f16;
        }

        private static void arcToBezier(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double d12 = d9;
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d12);
            double sin2 = Math.sin(d12);
            double d13 = ((-d11) * sin * sin2) + (d5 * cos * cos2);
            double d14 = d10 / ((double) ceil);
            double d15 = d12;
            int i = 0;
            double d16 = d6;
            double d17 = (((-d11) * cos) * sin2) - ((d5 * sin) * cos2);
            double d18 = d7;
            while (i < ceil) {
                double d19 = d15 + d14;
                double sin3 = Math.sin(d19);
                double cos3 = Math.cos(d19);
                double d20 = d14;
                double d21 = (d2 + ((d11 * cos) * cos3)) - ((d5 * sin) * sin3);
                double d22 = cos2;
                double d23 = sin2;
                double d24 = (((-d11) * cos) * sin3) - ((d5 * sin) * cos3);
                double d25 = d3 + (d11 * sin * cos3) + (d5 * cos * sin3);
                double d26 = ((-d11) * sin * sin3) + (d5 * cos * cos3);
                double tan = Math.tan((d19 - d15) / 2.0d);
                double sin4 = (Math.sin(d19 - d15) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d27 = d16 + (sin4 * d17);
                int i2 = ceil;
                double d28 = d16;
                double d29 = d18 + (sin4 * d13);
                double d30 = d21 - (sin4 * d24);
                double d31 = d25 - (sin4 * d26);
                path.rLineTo(0.0f, 0.0f);
                double d32 = d27;
                double d33 = d29;
                double d34 = d30;
                double d35 = d25;
                double d36 = d31;
                path.cubicTo((float) d27, (float) d29, (float) d30, (float) d31, (float) d21, (float) d35);
                d15 = d19;
                d18 = d35;
                d17 = d24;
                d13 = d26;
                d16 = d21;
                i++;
                ceil = i2;
                sin2 = d23;
                d14 = d20;
                cos2 = d22;
                cos = cos;
                sin = sin;
                d11 = d4;
            }
        }

        private static void drawArc(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            float f9 = f2;
            float f10 = f3;
            float f11 = f4;
            float f12 = f5;
            float f13 = f6;
            float f14 = f7;
            boolean z3 = z2;
            double radians = Math.toRadians((double) f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = ((((double) f9) * cos) + (((double) f10) * sin)) / ((double) f13);
            double d5 = ((((double) (-f9)) * sin) + (((double) f10) * cos)) / ((double) f14);
            double d6 = ((((double) f11) * cos) + (((double) f12) * sin)) / ((double) f13);
            double d7 = ((((double) (-f11)) * sin) + (((double) f12) * cos)) / ((double) f14);
            double d8 = d4 - d6;
            double d9 = d5 - d7;
            double d10 = (d4 + d6) / 2.0d;
            double d11 = (d5 + d7) / 2.0d;
            double d12 = (d8 * d8) + (d9 * d9);
            if (d12 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d13 = (1.0d / d12) - 0.25d;
            if (d13 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d12);
                float sqrt = (float) (Math.sqrt(d12) / 1.99999d);
                float f15 = sqrt;
                double d14 = d12;
                boolean z4 = z3;
                drawArc(path, f2, f3, f4, f5, f13 * sqrt, f14 * sqrt, f8, z, z2);
                return;
            }
            double d15 = d12;
            boolean z5 = z3;
            double sqrt2 = Math.sqrt(d13);
            double d16 = sqrt2 * d8;
            double d17 = sqrt2 * d9;
            if (z == z5) {
                d3 = d10 - d17;
                d2 = d11 + d16;
            } else {
                d3 = d10 + d17;
                d2 = d11 - d16;
            }
            double d18 = sqrt2;
            double atan2 = Math.atan2(d5 - d2, d4 - d3);
            double d19 = d16;
            double atan22 = Math.atan2(d7 - d2, d6 - d3);
            double d20 = atan22 - atan2;
            if (z5 != (d20 >= 0.0d)) {
                d20 = d20 > 0.0d ? d20 - 6.283185307179586d : d20 + 6.283185307179586d;
            }
            double d21 = atan22;
            double d22 = d3 * ((double) f13);
            double d23 = ((double) f14) * d2;
            double d24 = (d22 * sin) + (d23 * cos);
            double d25 = d24;
            arcToBezier(path, (d22 * cos) - (d23 * sin), d24, (double) f13, (double) f14, (double) f9, (double) f10, radians, atan2, d20);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                addCommand(path, fArr, c2, pathDataNodeArr[i].mType, pathDataNodeArr[i].mParams);
                c2 = pathDataNodeArr[i].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f2) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i < fArr.length) {
                    this.mParams[i] = (fArr[i] * (1.0f - f2)) + (pathDataNode2.mParams[i] * f2);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c2, float[] fArr) {
        arrayList.add(new PathDataNode(c2, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, Math.min(i3, length - i));
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        int i2 = 1;
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            int nextStart = nextStart(str, i2);
            String trim = str.substring(i, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i = nextStart;
            i2 = nextStart + 1;
        }
        if (i2 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(createNodesFromPathData, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing " + str, e2);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b A[LOOP:0: B:1:0x0007->B:20:0x003b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[SYNTHETIC] */
    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        int i2 = i;
        boolean z = false;
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < str.length()) {
            boolean z4 = z3;
            z3 = false;
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt != 'E' && charAt != 'e') {
                    switch (charAt) {
                        case ',':
                            break;
                        case '-':
                            if (i2 != i && !z4) {
                                z = true;
                                extractFloatResult.mEndWithNegOrDot = true;
                                break;
                            }
                        case '.':
                            if (z2) {
                                z = true;
                                extractFloatResult.mEndWithNegOrDot = true;
                                break;
                            } else {
                                z2 = true;
                                break;
                            }
                    }
                } else {
                    z3 = true;
                    if (!z) {
                        extractFloatResult.mEndPosition = i2;
                    }
                    i2++;
                }
            }
            z = true;
            if (!z) {
            }
        }
        extractFloatResult.mEndPosition = i2;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            int i = 0;
            int i2 = 1;
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            while (i2 < length) {
                extract(str, i2, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i2 < i3) {
                    fArr[i] = Float.parseFloat(str.substring(i2, i3));
                    i++;
                }
                i2 = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr3 == null) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        } else if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        } else if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        } else {
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f2);
            }
            return true;
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }
}
