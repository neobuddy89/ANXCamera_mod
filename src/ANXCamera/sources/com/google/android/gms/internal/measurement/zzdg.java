package com.google.android.gms.internal.measurement;

import java.io.PrintStream;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
public final class zzdg {
    private static final zzdf zza;
    private static final int zzb;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.3.0 */
    static final class zza extends zzdf {
        zza() {
        }

        public final void zza(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    static {
        zzdf zzdf;
        Integer num;
        int i = 1;
        try {
            num = zza();
            if (num != null) {
                try {
                    if (num.intValue() >= 19) {
                        zzdf = new zzdk();
                        zza = zzdf;
                        if (num != null) {
                            i = num.intValue();
                        }
                        zzb = i;
                    }
                } catch (Throwable th) {
                    th = th;
                    PrintStream printStream = System.err;
                    String name = zza.class.getName();
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 133);
                    sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(System.err);
                    zzdf = new zza();
                    zza = zzdf;
                    if (num != null) {
                    }
                    zzb = i;
                }
            }
            zzdf = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new zzdj() : new zza();
        } catch (Throwable th2) {
            th = th2;
            num = null;
            PrintStream printStream2 = System.err;
            String name2 = zza.class.getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name2).length() + 133);
            sb2.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb2.append(name2);
            sb2.append("will be used. The error is: ");
            printStream2.println(sb2.toString());
            th.printStackTrace(System.err);
            zzdf = new zza();
            zza = zzdf;
            if (num != null) {
            }
            zzb = i;
        }
        zza = zzdf;
        if (num != null) {
        }
        zzb = i;
    }

    private static Integer zza() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }

    public static void zza(Throwable th, Throwable th2) {
        zza.zza(th, th2);
    }
}
