package com.google.android.gms.internal.firebase_messaging;

import java.io.PrintStream;

/* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
public final class zzm {
    private static final zzp zza;
    private static final int zzb;

    /* compiled from: com.google.firebase:firebase-iid@@20.0.2 */
    static final class zza extends zzp {
        zza() {
        }

        public final void zza(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    static {
        zzp zzp;
        Integer num;
        int i = 1;
        try {
            num = zza();
            if (num != null) {
                try {
                    if (num.intValue() >= 19) {
                        zzp = new zzs();
                        zza = zzp;
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
                    zzp = new zza();
                    zza = zzp;
                    if (num != null) {
                    }
                    zzb = i;
                }
            }
            zzp = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new zzq() : new zza();
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
            zzp = new zza();
            zza = zzp;
            if (num != null) {
            }
            zzb = i;
        }
        zza = zzp;
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
