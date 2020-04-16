package androidx.core.graphics;

import android.graphics.Color;
import java.util.Objects;

public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    private ColorUtils() {
    }

    public static int HSLToColor(float[] fArr) {
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float abs = (1.0f - Math.abs((f4 * 2.0f) - 1.0f)) * f3;
        float f5 = f4 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f2 / 60.0f) % 2.0f) - 1.0f)) * abs;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        switch (((int) f2) / 60) {
            case 0:
                i = Math.round((abs + f5) * 255.0f);
                i2 = Math.round((abs2 + f5) * 255.0f);
                i3 = Math.round(255.0f * f5);
                break;
            case 1:
                i = Math.round((abs2 + f5) * 255.0f);
                i2 = Math.round((abs + f5) * 255.0f);
                i3 = Math.round(255.0f * f5);
                break;
            case 2:
                i = Math.round(f5 * 255.0f);
                i2 = Math.round((abs + f5) * 255.0f);
                i3 = Math.round((abs2 + f5) * 255.0f);
                break;
            case 3:
                i = Math.round(f5 * 255.0f);
                i2 = Math.round((abs2 + f5) * 255.0f);
                i3 = Math.round((abs + f5) * 255.0f);
                break;
            case 4:
                i = Math.round((abs2 + f5) * 255.0f);
                i2 = Math.round(f5 * 255.0f);
                i3 = Math.round((abs + f5) * 255.0f);
                break;
            case 5:
            case 6:
                i = Math.round((abs + f5) * 255.0f);
                i2 = Math.round(f5 * 255.0f);
                i3 = Math.round((abs2 + f5) * 255.0f);
                break;
        }
        return Color.rgb(constrain(i, 0, 255), constrain(i2, 0, 255), constrain(i3, 0, 255));
    }

    public static int LABToColor(double d2, double d3, double d4) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d2, d3, d4, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(double d2, double d3, double d4, double[] dArr) {
        double d5 = (d2 + 16.0d) / 116.0d;
        double d6 = (d3 / 500.0d) + d5;
        double d7 = d5 - (d4 / 200.0d);
        double pow = Math.pow(d6, 3.0d);
        double d8 = pow > XYZ_EPSILON ? pow : ((d6 * 116.0d) - 16.0d) / XYZ_KAPPA;
        double pow2 = d2 > 7.9996247999999985d ? Math.pow(d5, 3.0d) : d2 / XYZ_KAPPA;
        double pow3 = Math.pow(d7, 3.0d);
        double d9 = pow3 > XYZ_EPSILON ? pow3 : ((116.0d * d7) - 16.0d) / XYZ_KAPPA;
        dArr[0] = XYZ_WHITE_REFERENCE_X * d8;
        dArr[1] = XYZ_WHITE_REFERENCE_Y * pow2;
        dArr[2] = XYZ_WHITE_REFERENCE_Z * d9;
    }

    public static void RGBToHSL(int i, int i2, int i3, float[] fArr) {
        float f2;
        float f3;
        float f4 = ((float) i) / 255.0f;
        float f5 = ((float) i2) / 255.0f;
        float f6 = ((float) i3) / 255.0f;
        float max = Math.max(f4, Math.max(f5, f6));
        float min = Math.min(f4, Math.min(f5, f6));
        float f7 = max - min;
        float f8 = (max + min) / 2.0f;
        if (max == min) {
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            f2 = max == f4 ? ((f5 - f6) / f7) % 6.0f : max == f5 ? ((f6 - f4) / f7) + 2.0f : ((f4 - f5) / f7) + 4.0f;
            f3 = f7 / (1.0f - Math.abs((2.0f * f8) - 1.0f));
        }
        float f9 = (60.0f * f2) % 360.0f;
        if (f9 < 0.0f) {
            f9 += 360.0f;
        }
        fArr[0] = constrain(f9, 0.0f, 360.0f);
        fArr[1] = constrain(f3, 0.0f, 1.0f);
        fArr[2] = constrain(f8, 0.0f, 1.0f);
    }

    public static void RGBToLAB(int i, int i2, int i3, double[] dArr) {
        RGBToXYZ(i, i2, i3, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(int i, int i2, int i3, double[] dArr) {
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d2 = ((double) i) / 255.0d;
            double pow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
            double d3 = ((double) i2) / 255.0d;
            double pow2 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
            double d4 = ((double) i3) / 255.0d;
            double pow3 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((0.055d + d4) / 1.055d, 2.4d);
            dArr2[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * XYZ_WHITE_REFERENCE_Y;
            dArr2[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * XYZ_WHITE_REFERENCE_Y;
            dArr2[2] = ((0.0193d * pow) + (0.1192d * pow2) + (0.9505d * pow3)) * XYZ_WHITE_REFERENCE_Y;
            return;
        }
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int XYZToColor(double d2, double d3, double d4) {
        double d5 = (((3.2406d * d2) + (-1.5372d * d3)) + (-0.4986d * d4)) / XYZ_WHITE_REFERENCE_Y;
        double d6 = (((-0.9689d * d2) + (1.8758d * d3)) + (0.0415d * d4)) / XYZ_WHITE_REFERENCE_Y;
        double d7 = (((0.0557d * d2) + (-0.204d * d3)) + (1.057d * d4)) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round(255.0d * (d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : d7 * 12.92d)), 0, 255));
    }

    public static void XYZToLAB(double d2, double d3, double d4, double[] dArr) {
        if (dArr.length == 3) {
            double pivotXyzComponent = pivotXyzComponent(d2 / XYZ_WHITE_REFERENCE_X);
            double pivotXyzComponent2 = pivotXyzComponent(d3 / XYZ_WHITE_REFERENCE_Y);
            double pivotXyzComponent3 = pivotXyzComponent(d4 / XYZ_WHITE_REFERENCE_Z);
            dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
            dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
            dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    public static int blendARGB(int i, int i2, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i)) * f3) + (((float) Color.alpha(i2)) * f2)), (int) ((((float) Color.red(i)) * f3) + (((float) Color.red(i2)) * f2)), (int) ((((float) Color.green(i)) * f3) + (((float) Color.green(i2)) * f2)), (int) ((((float) Color.blue(i)) * f3) + (((float) Color.blue(i2)) * f2)));
    }

    public static void blendHSL(float[] fArr, float[] fArr2, float f2, float[] fArr3) {
        if (fArr3.length == 3) {
            float f3 = 1.0f - f2;
            fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f2);
            fArr3[1] = (fArr[1] * f3) + (fArr2[1] * f2);
            fArr3[2] = (fArr[2] * f3) + (fArr2[2] * f2);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(double[] dArr, double[] dArr2, double d2, double[] dArr3) {
        if (dArr3.length == 3) {
            double d3 = 1.0d - d2;
            dArr3[0] = (dArr[0] * d3) + (dArr2[0] * d2);
            dArr3[1] = (dArr[1] * d3) + (dArr2[1] * d2);
            dArr3[2] = (dArr[2] * d3) + (dArr2[2] * d2);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(int i, int i2) {
        if (Color.alpha(i2) == 255) {
            if (Color.alpha(i) < 255) {
                i = compositeColors(i, i2);
            }
            double calculateLuminance = calculateLuminance(i) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i2) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
    }

    public static double calculateLuminance(int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(int i, int i2, float f2) {
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        } else if (calculateContrast(setAlphaComponent(i, 255), i2) < ((double) f2)) {
            return -1;
        } else {
            int i3 = 0;
            int i4 = 255;
            for (int i5 = 0; i5 <= 10 && i4 - i3 > 1; i5++) {
                int i6 = (i3 + i4) / 2;
                if (calculateContrast(setAlphaComponent(i, i6), i2) < ((double) f2)) {
                    i3 = i6;
                } else {
                    i4 = i6;
                }
            }
            return i4;
        }
    }

    static float circularInterpolate(float f2, float f3, float f4) {
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > f2) {
                f2 += 360.0f;
            } else {
                f3 += 360.0f;
            }
        }
        return (((f3 - f2) * f4) + f2) % 360.0f;
    }

    public static void colorToHSL(int i, float[] fArr) {
        RGBToHSL(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void colorToLAB(int i, double[] dArr) {
        RGBToLAB(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void colorToXYZ(int i, double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    private static int compositeAlpha(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    public static int compositeColors(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i), alpha2, Color.red(i2), alpha, compositeAlpha), compositeComponent(Color.green(i), alpha2, Color.green(i2), alpha, compositeAlpha), compositeComponent(Color.blue(i), alpha2, Color.blue(i2), alpha, compositeAlpha));
    }

    public static Color compositeColors(Color color, Color color2) {
        if (Objects.equals(color.getModel(), color2.getModel())) {
            Color convert = Objects.equals(color2.getColorSpace(), color.getColorSpace()) ? color : color.convert(color2.getColorSpace());
            float[] components = convert.getComponents();
            float[] components2 = color2.getComponents();
            float alpha = convert.alpha();
            float alpha2 = color2.alpha() * (1.0f - alpha);
            int componentCount = color2.getComponentCount() - 1;
            components2[componentCount] = alpha + alpha2;
            if (components2[componentCount] > 0.0f) {
                alpha /= components2[componentCount];
                alpha2 /= components2[componentCount];
            }
            for (int i = 0; i < componentCount; i++) {
                components2[i] = (components[i] * alpha) + (components2[i] * alpha2);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
        throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
    }

    private static int compositeComponent(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    private static float constrain(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static double distanceEuclidean(double[] dArr, double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        double[] dArr = TEMP_ARRAY.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        TEMP_ARRAY.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d2) {
        return d2 > XYZ_EPSILON ? Math.pow(d2, 0.3333333333333333d) : ((XYZ_KAPPA * d2) + 16.0d) / 116.0d;
    }

    public static int setAlphaComponent(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
