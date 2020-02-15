package android.support.v4.graphics;

import android.graphics.Path;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class PathParser {
    private static final String LOGTAG = "PathParser";

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public float[] mParams;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
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

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0231, code lost:
            r22 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x0239, code lost:
            if (r12[r9 + 4] == 0.0f) goto L_0x023e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x023b, code lost:
            r23 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x023e, code lost:
            r23 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x0240, code lost:
            r1 = r8;
            r2 = r7;
            r11 = r7;
            r7 = r15;
            r15 = r8;
            r8 = r22;
            r22 = r9;
            drawArc(r24, r1, r2, r3, r4, r5, r6, r7, r8, r23);
            r8 = r15 + r12[r13];
            r7 = r11 + r12[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x025a, code lost:
            r22 = r9;
            r9 = r22 + 0;
            r10.lineTo(r8, r12[r9]);
            r7 = r12[r9];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0268, code lost:
            r22 = r9;
            r9 = r22 + 0;
            r1 = r22 + 1;
            r3 = r22 + 2;
            r5 = r22 + 3;
            r10.quadTo(r12[r9], r12[r1], r12[r3], r12[r5]);
            r0 = r12[r9];
            r1 = r12[r1];
            r8 = r12[r3];
            r7 = r12[r5];
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0289, code lost:
            r22 = r9;
            r9 = r22 + 0;
            r10.lineTo(r12[r9], r7);
            r8 = r12[r9];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0297, code lost:
            r22 = r9;
            r9 = r22 + 2;
            r7 = r22 + 3;
            r8 = r22 + 4;
            r11 = r22 + 5;
            r24.cubicTo(r12[r22 + 0], r12[r22 + 1], r12[r9], r12[r7], r12[r8], r12[r11]);
            r8 = r12[r8];
            r0 = r12[r11];
            r1 = r12[r9];
            r2 = r12[r7];
            r7 = r0;
            r3 = r2;
            r2 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x02c2, code lost:
            r11 = r7;
            r15 = r8;
            r22 = r9;
            r13 = r22 + 5;
            r3 = r12[r13];
            r14 = r22 + 6;
            r4 = r12[r14];
            r5 = r12[r22 + 0];
            r6 = r12[r22 + 1];
            r7 = r12[r22 + 2];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x02e1, code lost:
            if (r12[r22 + 3] == 0.0f) goto L_0x02e5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x02e3, code lost:
            r8 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x02e5, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x02ec, code lost:
            if (r12[r22 + 4] == 0.0f) goto L_0x02f0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x02ee, code lost:
            r9 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x02f0, code lost:
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x02f1, code lost:
            drawArc(r24, r15, r11, r3, r4, r5, r6, r7, r8, r9);
            r8 = r12[r13];
            r7 = r12[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x02fc, code lost:
            r3 = r7;
            r2 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
            if (r9 >= r12.length) goto L_0x0308;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x02fe, code lost:
            r9 = r22 + r19;
            r0 = r27;
            r11 = r0;
            r13 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x0308, code lost:
            r25[r13] = r8;
            r25[1] = r7;
            r25[2] = r2;
            r25[3] = r3;
            r25[4] = r20;
            r25[5] = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x0319, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            if (r11 == 'A') goto L_0x02c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
            if (r11 == 'C') goto L_0x0297;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
            if (r11 == 'H') goto L_0x0289;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
            if (r11 == 'Q') goto L_0x0268;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
            if (r11 == 'V') goto L_0x025a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
            if (r11 == 'a') goto L_0x020d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
            if (r11 == 'c') goto L_0x01e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
            if (r11 == 'h') goto L_0x01d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
            if (r11 == 'q') goto L_0x01b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x001e, code lost:
            r19 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
            if (r11 == 'v') goto L_0x01a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006d, code lost:
            if (r11 == 'L') goto L_0x0197;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0071, code lost:
            if (r11 == 'M') goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0077, code lost:
            if (r11 == 'S') goto L_0x0146;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x007b, code lost:
            if (r11 == 'T') goto L_0x011f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007f, code lost:
            if (r11 == 'l') goto L_0x010c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0083, code lost:
            if (r11 == 'm') goto L_0x00ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0087, code lost:
            if (r11 == 's') goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x008b, code lost:
            if (r11 == 't') goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x008d, code lost:
            r22 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0091, code lost:
            if (r0 == 'q') goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0095, code lost:
            if (r0 == 't') goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0097, code lost:
            if (r0 == 'Q') goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0099, code lost:
            if (r0 != 'T') goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009c, code lost:
            r0 = 0.0f;
            r4 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x009f, code lost:
            r4 = r8 - r2;
            r0 = r7 - r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a3, code lost:
            r1 = r9 + 0;
            r3 = r9 + 1;
            r10.rQuadTo(r4, r0, r12[r1], r12[r3]);
            r4 = r4 + r8;
            r0 = r0 + r7;
            r8 = r8 + r12[r1];
            r7 = r7 + r12[r3];
            r3 = r0;
            r2 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b9, code lost:
            if (r0 == 'c') goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00bd, code lost:
            if (r0 == 's') goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00bf, code lost:
            if (r0 == 'C') goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c1, code lost:
            if (r0 != 'S') goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c4, code lost:
            r1 = 0.0f;
            r2 = 0.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c7, code lost:
            r0 = r8 - r2;
            r2 = r7 - r3;
            r1 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00cd, code lost:
            r13 = r9 + 0;
            r14 = r9 + 1;
            r15 = r9 + 2;
            r22 = r9 + 3;
            r24.rCubicTo(r1, r2, r12[r13], r12[r14], r12[r15], r12[r22]);
            r0 = r12[r13] + r8;
            r1 = r12[r14] + r7;
            r8 = r8 + r12[r15];
            r2 = r12[r22];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ef, code lost:
            r0 = r9 + 0;
            r8 = r8 + r12[r0];
            r1 = r9 + 1;
            r7 = r7 + r12[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f9, code lost:
            if (r9 <= 0) goto L_0x0103;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00fb, code lost:
            r10.rLineTo(r12[r0], r12[r1]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0103, code lost:
            r10.rMoveTo(r12[r0], r12[r1]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x010c, code lost:
            r0 = r9 + 0;
            r4 = r9 + 1;
            r10.rLineTo(r12[r0], r12[r4]);
            r8 = r8 + r12[r0];
            r0 = r12[r4];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x011c, code lost:
            r7 = r7 + r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x011f, code lost:
            if (r0 == 'q') goto L_0x0129;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0123, code lost:
            if (r0 == 't') goto L_0x0129;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0125, code lost:
            if (r0 == 'Q') goto L_0x0129;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0127, code lost:
            if (r0 != 'T') goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0129, code lost:
            r8 = (r8 * 2.0f) - r2;
            r7 = (r7 * 2.0f) - r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x012f, code lost:
            r0 = r9 + 0;
            r2 = r9 + 1;
            r10.quadTo(r8, r7, r12[r0], r12[r2]);
            r0 = r12[r0];
            r1 = r12[r2];
            r3 = r7;
            r2 = r8;
            r22 = r9;
            r8 = r0;
            r7 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0146, code lost:
            if (r0 == 'c') goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x014a, code lost:
            if (r0 == 's') goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x014c, code lost:
            if (r0 == 'C') goto L_0x0150;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x014e, code lost:
            if (r0 != 'S') goto L_0x0156;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0150, code lost:
            r8 = (r8 * 2.0f) - r2;
            r7 = (r7 * 2.0f) - r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0156, code lost:
            r2 = r7;
            r7 = r9 + 0;
            r8 = r9 + 1;
            r13 = r9 + 2;
            r14 = r9 + 3;
            r24.cubicTo(r8, r2, r12[r7], r12[r8], r12[r13], r12[r14]);
            r0 = r12[r7];
            r1 = r12[r8];
            r8 = r12[r13];
            r7 = r12[r14];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0177, code lost:
            r0 = r9 + 0;
            r8 = r12[r0];
            r1 = r9 + 1;
            r7 = r12[r1];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x017f, code lost:
            if (r9 <= 0) goto L_0x018a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0181, code lost:
            r10.lineTo(r12[r0], r12[r1]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x018a, code lost:
            r10.moveTo(r12[r0], r12[r1]);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0191, code lost:
            r21 = r7;
            r20 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            r19 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0197, code lost:
            r0 = r9 + 0;
            r4 = r9 + 1;
            r10.lineTo(r12[r0], r12[r4]);
            r8 = r12[r0];
            r7 = r12[r4];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x01a8, code lost:
            r0 = r9 + 0;
            r10.rLineTo(0.0f, r12[r0]);
            r0 = r12[r0];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x01b4, code lost:
            r0 = r9 + 0;
            r2 = r9 + 1;
            r4 = r9 + 2;
            r6 = r9 + 3;
            r10.rQuadTo(r12[r0], r12[r2], r12[r4], r12[r6]);
            r0 = r12[r0] + r8;
            r1 = r12[r2] + r7;
            r8 = r8 + r12[r4];
            r2 = r12[r6];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d3, code lost:
            r0 = r9 + 0;
            r10.rLineTo(r12[r0], 0.0f);
            r8 = r8 + r12[r0];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x01e0, code lost:
            r13 = r9 + 2;
            r14 = r9 + 3;
            r15 = r9 + 4;
            r22 = r9 + 5;
            r24.rCubicTo(r12[r9 + 0], r12[r9 + 1], r12[r13], r12[r14], r12[r15], r12[r22]);
            r0 = r12[r13] + r8;
            r1 = r12[r14] + r7;
            r8 = r8 + r12[r15];
            r2 = r12[r22];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0208, code lost:
            r7 = r7 + r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x0209, code lost:
            r2 = r0;
            r3 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x020d, code lost:
            r13 = r9 + 5;
            r3 = r12[r13] + r8;
            r14 = r9 + 6;
            r4 = r12[r14] + r7;
            r5 = r12[r9 + 0];
            r6 = r12[r9 + 1];
            r15 = r12[r9 + 2];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x022c, code lost:
            if (r12[r9 + 3] == 0.0f) goto L_0x0231;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x022e, code lost:
            r22 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
            r8 = r0;
            r7 = r1;
            r20 = r4;
            r21 = r5;
            r9 = 0;
            r0 = r26;
         */
        private static void addCommand(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i;
            int i2;
            Path path2 = path;
            char c4 = c3;
            float[] fArr3 = fArr2;
            boolean z = false;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = fArr[3];
            float f6 = fArr[4];
            float f7 = fArr[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
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
                    path2.moveTo(f6, f7);
                    f2 = f6;
                    f4 = f2;
                    f3 = f7;
                    f5 = f3;
                    break;
            }
        }

        private static void arcToBezier(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = d10 / ((double) ceil);
            double d20 = d7;
            double d21 = d18;
            double d22 = d15;
            int i = 0;
            double d23 = d6;
            double d24 = d9;
            while (i < ceil) {
                double d25 = d24 + d19;
                double sin3 = Math.sin(d25);
                double cos3 = Math.cos(d25);
                double d26 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d27 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d28 = (d13 * sin3) - (d14 * cos3);
                double d29 = (sin3 * d16) + (cos3 * d17);
                double d30 = d25 - d24;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d31 = cos;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d23 + (d22 * sin4)), (float) (d20 + (d21 * sin4)), (float) (d26 - (sin4 * d28)), (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
                i++;
                d19 = d19;
                ceil = ceil;
                sin = sin;
                d20 = d27;
                d16 = d16;
                d24 = d25;
                d21 = d29;
                d22 = d28;
                cos = d31;
                d11 = d4;
                d23 = d26;
            }
        }

        private static void drawArc(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            float f9 = f2;
            float f10 = f4;
            float f11 = f6;
            boolean z3 = z2;
            double radians = Math.toRadians((double) f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = (double) f9;
            double d5 = d4 * cos;
            double d6 = d4;
            double d7 = (double) f3;
            double d8 = (double) f11;
            double d9 = (d5 + (d7 * sin)) / d8;
            double d10 = (((double) (-f9)) * sin) + (d7 * cos);
            double d11 = d7;
            double d12 = (double) f7;
            double d13 = d10 / d12;
            double d14 = (double) f5;
            double d15 = ((((double) f10) * cos) + (d14 * sin)) / d8;
            double d16 = d8;
            double d17 = ((((double) (-f10)) * sin) + (d14 * cos)) / d12;
            double d18 = d9 - d15;
            double d19 = d13 - d17;
            double d20 = (d9 + d15) / 2.0d;
            double d21 = (d13 + d17) / 2.0d;
            double d22 = sin;
            double d23 = (d18 * d18) + (d19 * d19);
            if (d23 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d24 = (1.0d / d23) - 0.25d;
            if (d24 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d23);
                float sqrt = (float) (Math.sqrt(d23) / 1.99999d);
                drawArc(path, f2, f3, f4, f5, f11 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d24);
            double d25 = d18 * sqrt2;
            double d26 = sqrt2 * d19;
            boolean z4 = z2;
            if (z == z4) {
                d3 = d20 - d26;
                d2 = d21 + d25;
            } else {
                d3 = d20 + d26;
                d2 = d21 - d25;
            }
            double atan2 = Math.atan2(d13 - d2, d9 - d3);
            double atan22 = Math.atan2(d17 - d2, d15 - d3) - atan2;
            int i = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z4 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d27 = d3 * d16;
            double d28 = d2 * d12;
            arcToBezier(path, (d27 * cos) - (d28 * d22), (d27 * d22) + (d28 * cos), d16, d12, d6, d11, radians, atan2, atan22);
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
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int nextStart = nextStart(str, i);
            String trim = str.substring(i2, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i2 = nextStart;
            i = nextStart + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[LOOP:0: B:1:0x0007->B:20:0x003a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        int i2 = i;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt == 'E' || charAt == 'e') {
                    z = true;
                    if (!z3) {
                        extractFloatResult.mEndPosition = i2;
                    }
                    i2++;
                } else {
                    switch (charAt) {
                        case ',':
                            break;
                        case '-':
                            if (i2 != i && !z) {
                                extractFloatResult.mEndWithNegOrDot = true;
                            }
                        case '.':
                            if (!z2) {
                                z = false;
                                z2 = true;
                                break;
                            } else {
                                extractFloatResult.mEndWithNegOrDot = true;
                            }
                    }
                }
            }
            z = false;
            z3 = true;
            if (!z3) {
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
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
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
