package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzir implements Runnable {
    private final URL zza;
    private final byte[] zzb = null;
    private final zzis zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzip zzf;

    public zzir(zzip zzip, String str, URL url, byte[] bArr, Map<String, String> map, zzis zzis) {
        this.zzf = zzip;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzis);
        this.zza = url;
        this.zzc = zzis;
        this.zzd = str;
        this.zze = null;
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        zzgj zzq = this.zzf.zzq();
        zziu zziu = new zziu(this, i, exc, bArr, map);
        zzq.zza((Runnable) zziu);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0074  */
    public final void run() {
        Map map;
        HttpURLConnection httpURLConnection;
        Map map2;
        Map headerFields;
        this.zzf.zzc();
        int i = 0;
        try {
            httpURLConnection = this.zzf.zza(this.zza);
            try {
                if (this.zze != null) {
                    for (Map.Entry next : this.zze.entrySet()) {
                        httpURLConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                }
                i = httpURLConnection.getResponseCode();
                headerFields = httpURLConnection.getHeaderFields();
            } catch (IOException e2) {
                e = e2;
                map = null;
                if (httpURLConnection != null) {
                }
                zzb(i, e, (byte[]) null, map);
            } catch (Throwable th) {
                th = th;
                map2 = null;
                if (httpURLConnection != null) {
                }
                zzb(i, (Exception) null, (byte[]) null, map2);
                throw th;
            }
            try {
                byte[] zza2 = zzip.zza(httpURLConnection);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                zzb(i, (Exception) null, zza2, headerFields);
            } catch (IOException e3) {
                IOException iOException = e3;
                map = headerFields;
                e = iOException;
                if (httpURLConnection != null) {
                }
                zzb(i, e, (byte[]) null, map);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                map2 = headerFields;
                th = th3;
                if (httpURLConnection != null) {
                }
                zzb(i, (Exception) null, (byte[]) null, map2);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            httpURLConnection = null;
            map = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            zzb(i, e, (byte[]) null, map);
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            map2 = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            zzb(i, (Exception) null, (byte[]) null, map2);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}
