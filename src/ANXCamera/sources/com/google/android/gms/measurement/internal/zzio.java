package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzlr;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzio implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhr zza;

    private zzio(zzhr zzhr) {
        this.zza = zzhr;
    }

    /* synthetic */ zzio(zzhr zzhr, zzht zzht) {
        this(zzhr);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2 A[SYNTHETIC, Splitter:B:33:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ea A[Catch:{ Exception -> 0x01b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fb A[SYNTHETIC, Splitter:B:49:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012a A[Catch:{ Exception -> 0x01b4 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012b A[Catch:{ Exception -> 0x01b4 }] */
    public final void zza(boolean z, Uri uri, String str, String str2) {
        Bundle bundle;
        Bundle bundle2;
        String str3 = str;
        String str4 = str2;
        try {
            if (!this.zza.zzt().zza(zzap.zzca)) {
                if (!this.zza.zzt().zza(zzap.zzcc)) {
                    if (!this.zza.zzt().zza(zzap.zzcb)) {
                        bundle = null;
                        boolean z2 = false;
                        if (!z) {
                            bundle2 = this.zza.zzp().zza(uri);
                            if (bundle2 != null) {
                                bundle2.putString("_cis", "intent");
                                if (this.zza.zzt().zza(zzap.zzca) && !bundle2.containsKey("gclid") && bundle != null && bundle.containsKey("gclid")) {
                                    bundle2.putString("_cer", String.format("gclid=%s", new Object[]{bundle.getString("gclid")}));
                                }
                                this.zza.zza(str3, "_cmp", bundle2);
                            }
                        } else {
                            bundle2 = null;
                        }
                        if (this.zza.zzt().zza(zzap.zzcc)) {
                            if (!this.zza.zzt().zza(zzap.zzcb) && bundle != null && bundle.containsKey("gclid") && (bundle2 == null || !bundle2.containsKey("gclid"))) {
                                this.zza.zza("auto", "_lgclid", (Object) bundle.getString("gclid"), true);
                            }
                        }
                        if (TextUtils.isEmpty(str2)) {
                            this.zza.zzr().zzw().zza("Activity created with referrer", str4);
                            if (this.zza.zzt().zza(zzap.zzcb)) {
                                if (bundle != null) {
                                    this.zza.zza(str3, "_cmp", bundle);
                                } else {
                                    this.zza.zzr().zzw().zza("Referrer does not contain valid parameters", str4);
                                }
                                this.zza.zza("auto", "_ldl", (Object) null, true);
                                return;
                            }
                            if (str4.contains("gclid") && (str4.contains("utm_campaign") || str4.contains("utm_source") || str4.contains("utm_medium") || str4.contains("utm_term") || str4.contains("utm_content"))) {
                                z2 = true;
                            }
                            if (!z2) {
                                this.zza.zzr().zzw().zza("Activity created with data 'referrer' without required params");
                                return;
                            } else if (!TextUtils.isEmpty(str2)) {
                                this.zza.zza("auto", "_ldl", (Object) str4, true);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
            zzla zzp = this.zza.zzp();
            if (TextUtils.isEmpty(str2)) {
                bundle = null;
            } else if (str4.contains("gclid") || str4.contains("utm_campaign") || str4.contains("utm_source") || str4.contains("utm_medium")) {
                String valueOf = String.valueOf(str2);
                bundle = zzp.zza(Uri.parse(valueOf.length() != 0 ? "https://google.com/search?".concat(valueOf) : new String("https://google.com/search?")));
                if (bundle != null) {
                    bundle.putString("_cis", "referrer");
                }
            } else {
                zzp.zzr().zzw().zza("Activity created with data 'referrer' without required params");
                bundle = null;
            }
            boolean z22 = false;
            if (!z) {
            }
            if (this.zza.zzt().zza(zzap.zzcc)) {
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (Exception e2) {
            this.zza.zzr().zzf().zza("Throwable caught in handleReferrerForOnActivityCreated", e2);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.zza.zzr().zzx().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzp();
                        String str = zzla.zza(intent) ? "gs" : "auto";
                        String queryParameter = data.getQueryParameter("referrer");
                        boolean z = bundle == null;
                        if (!zzlr.zzb() || !zzap.zzcd.zza(null).booleanValue()) {
                            zza(z, data, str, queryParameter);
                        } else {
                            zzgj zzq = this.zza.zzq();
                            zzin zzin = new zzin(this, z, data, str, queryParameter);
                            zzq.zza((Runnable) zzin);
                        }
                        this.zza.zzi().zza(activity, bundle);
                        return;
                    }
                }
                this.zza.zzi().zza(activity, bundle);
            }
        } catch (Exception e2) {
            this.zza.zzr().zzf().zza("Throwable caught in onActivityCreated", e2);
        } finally {
            this.zza.zzi().zza(activity, bundle);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzi().zzc(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzi().zzb(activity);
        zzke zzk = this.zza.zzk();
        zzk.zzq().zza((Runnable) new zzkg(zzk, zzk.zzm().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        if (!zzle.zzb() || !zzap.zzay.zza(null).booleanValue()) {
            this.zza.zzi().zza(activity);
            this.zza.zzk().zzab();
            return;
        }
        this.zza.zzk().zzab();
        this.zza.zzi().zza(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzi().zzb(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
