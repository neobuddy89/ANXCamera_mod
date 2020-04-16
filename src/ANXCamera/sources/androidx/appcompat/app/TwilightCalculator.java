package androidx.appcompat.app;

class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    TwilightCalculator() {
    }

    static TwilightCalculator getInstance() {
        if (sInstance == null) {
            sInstance = new TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j, double d2, double d3) {
        float f2 = ((float) (j - UTC_2000)) / 8.64E7f;
        float f3 = (0.01720197f * f2) + 6.24006f;
        double sin = ((double) f3) + (Math.sin((double) f3) * 0.03341960161924362d) + (Math.sin((double) (2.0f * f3)) * 3.4906598739326E-4d) + (Math.sin((double) (3.0f * f3)) * 5.236000106378924E-6d);
        double d4 = 1.796593063d + sin + 3.141592653589793d;
        double d5 = (-d3) / 360.0d;
        double d6 = sin;
        double round = ((double) (J0 + ((float) Math.round(((double) (f2 - J0)) - d5)))) + d5 + (Math.sin((double) f3) * 0.0053d) + (Math.sin(2.0d * d4) * -0.0069d);
        double asin = Math.asin(Math.sin(d4) * Math.sin(0.4092797040939331d));
        double d7 = 0.01745329238474369d * d2;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d7) * Math.sin(asin))) / (Math.cos(d7) * Math.cos(asin));
        float f4 = f2;
        float f5 = f3;
        if (sin2 >= 1.0d) {
            this.state = 1;
            this.sunset = -1;
            this.sunrise = -1;
        } else if (sin2 <= -1.0d) {
            this.state = 0;
            this.sunset = -1;
            this.sunrise = -1;
        } else {
            float acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            double d8 = asin;
            this.sunset = Math.round((((double) acos) + round) * 8.64E7d) + UTC_2000;
            long round2 = Math.round((round - ((double) acos)) * 8.64E7d) + UTC_2000;
            this.sunrise = round2;
            if (round2 >= j || this.sunset <= j) {
                this.state = 1;
            } else {
                this.state = 0;
            }
        }
    }
}
