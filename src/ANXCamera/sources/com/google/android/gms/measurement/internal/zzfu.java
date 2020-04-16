package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzfu implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzfs zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzfq zzf;

    public zzfu(zzfq zzfq, String str, URL url, byte[] bArr, Map<String, String> map, zzfs zzfs) {
        this.zzf = zzfq;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzfs);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzfs;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d6 A[SYNTHETIC, Splitter:B:45:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0111 A[SYNTHETIC, Splitter:B:58:0x0111] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012b  */
    public final void run() {
        Map map;
        IOException iOException;
        int i;
        HttpURLConnection httpURLConnection;
        Map map2;
        int i2;
        Throwable th;
        int responseCode;
        this.zzf.zzc();
        OutputStream outputStream = null;
        try {
            httpURLConnection = this.zzf.zza(this.zza);
            try {
                if (this.zze != null) {
                    for (Map.Entry next : this.zze.entrySet()) {
                        httpURLConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                }
                if (this.zzb != null) {
                    byte[] zzc2 = this.zzf.zzg().zzc(this.zzb);
                    this.zzf.zzr().zzx().zza("Uploading data. size", Integer.valueOf(zzc2.length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(zzc2.length);
                    httpURLConnection.connect();
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(zzc2);
                        outputStream2.close();
                    } catch (IOException e2) {
                        map = null;
                        i = 0;
                        iOException = e2;
                        outputStream = outputStream2;
                    } catch (Throwable th2) {
                        map2 = null;
                        i2 = 0;
                        th = th2;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.zzf.zzr().zzf().zza("Error closing HTTP compressed POST connection output stream. appId", zzfj.zza(this.zzd), e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        zzgj zzq = this.zzf.zzq();
                        zzfr zzfr = new zzfr(this.zzd, this.zzc, i2, (Throwable) null, (byte[]) null, map2);
                        zzq.zza((Runnable) zzfr);
                        throw th;
                    }
                }
                responseCode = httpURLConnection.getResponseCode();
            } catch (IOException e4) {
                e = e4;
                map = null;
                i = 0;
                iOException = e;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                zzgj zzq2 = this.zzf.zzq();
                zzfr zzfr2 = new zzfr(this.zzd, this.zzc, i, iOException, (byte[]) null, map);
                zzq2.zza((Runnable) zzfr2);
            } catch (Throwable th3) {
                th = th3;
                map2 = null;
                i2 = 0;
                th = th;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                zzgj zzq3 = this.zzf.zzq();
                zzfr zzfr3 = new zzfr(this.zzd, this.zzc, i2, (Throwable) null, (byte[]) null, map2);
                zzq3.zza((Runnable) zzfr3);
                throw th;
            }
            try {
                Map headerFields = httpURLConnection.getHeaderFields();
                try {
                    byte[] zza2 = zzfq.zza(httpURLConnection);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzgj zzq4 = this.zzf.zzq();
                    zzfr zzfr4 = new zzfr(this.zzd, this.zzc, responseCode, (Throwable) null, zza2, headerFields);
                    zzq4.zza((Runnable) zzfr4);
                } catch (IOException e5) {
                    e = e5;
                    i = responseCode;
                    map = headerFields;
                    iOException = e;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzgj zzq22 = this.zzf.zzq();
                    zzfr zzfr22 = new zzfr(this.zzd, this.zzc, i, iOException, (byte[]) null, map);
                    zzq22.zza((Runnable) zzfr22);
                } catch (Throwable th4) {
                    th = th4;
                    i2 = responseCode;
                    map2 = headerFields;
                    if (outputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                    zzgj zzq32 = this.zzf.zzq();
                    zzfr zzfr32 = new zzfr(this.zzd, this.zzc, i2, (Throwable) null, (byte[]) null, map2);
                    zzq32.zza((Runnable) zzfr32);
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                map = null;
                i = responseCode;
                iOException = e;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                zzgj zzq222 = this.zzf.zzq();
                zzfr zzfr222 = new zzfr(this.zzd, this.zzc, i, iOException, (byte[]) null, map);
                zzq222.zza((Runnable) zzfr222);
            } catch (Throwable th5) {
                map2 = null;
                th = th5;
                i2 = responseCode;
                if (outputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                zzgj zzq322 = this.zzf.zzq();
                zzfr zzfr322 = new zzfr(this.zzd, this.zzc, i2, (Throwable) null, (byte[]) null, map2);
                zzq322.zza((Runnable) zzfr322);
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            httpURLConnection = null;
            map = null;
            i = 0;
            iOException = e;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e8) {
                    this.zzf.zzr().zzf().zza("Error closing HTTP compressed POST connection output stream. appId", zzfj.zza(this.zzd), e8);
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            zzgj zzq2222 = this.zzf.zzq();
            zzfr zzfr2222 = new zzfr(this.zzd, this.zzc, i, iOException, (byte[]) null, map);
            zzq2222.zza((Runnable) zzfr2222);
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            map2 = null;
            i2 = 0;
            th = th;
            if (outputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            zzgj zzq3222 = this.zzf.zzq();
            zzfr zzfr3222 = new zzfr(this.zzd, this.zzc, i2, (Throwable) null, (byte[]) null, map2);
            zzq3222.zza((Runnable) zzfr3222);
            throw th;
        }
    }
}
