package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzkg;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzr extends zzu {
    private zzbj.zzb zzg;
    private final /* synthetic */ zzn zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzr(zzn zzn, String str, int i, zzbj.zzb zzb) {
        super(str, i);
        this.zzh = zzn;
        this.zzg = zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzg.zzb();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0139, code lost:
        if (r8.booleanValue() == false) goto L_0x03e0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03f8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03f9  */
    public final boolean zza(Long l, Long l2, zzbr.zzc zzc, long j, zzaj zzaj, boolean z) {
        Boolean bool;
        boolean zzd = this.zzh.zzt().zzd(this.zza, zzap.zzbm);
        boolean zzd2 = this.zzh.zzt().zzd(this.zza, zzap.zzbn);
        Boolean bool2 = false;
        boolean z2 = zzkg.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbx);
        long j2 = (!zzd2 || !zzd || !this.zzg.zzk()) ? j : zzaj.zze;
        Integer num = null;
        if (this.zzh.zzr().zza(2)) {
            this.zzh.zzr().zzx().zza("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzb), this.zzg.zza() ? Integer.valueOf(this.zzg.zzb()) : null, this.zzh.zzo().zza(this.zzg.zzc()));
            this.zzh.zzr().zzx().zza("Filter definition", this.zzh.zzg().zza(this.zzg));
        }
        if (!this.zzg.zza() || this.zzg.zzb() > 256) {
            zzfl zzi = this.zzh.zzr().zzi();
            Object zza = zzfj.zza(this.zza);
            if (this.zzg.zza()) {
                num = Integer.valueOf(this.zzg.zzb());
            }
            zzi.zza("Invalid event filter ID. appId, id", zza, String.valueOf(num));
            return !this.zzh.zzt().zzd(this.zza, zzap.zzbu);
        }
        boolean z3 = this.zzg.zzh() || this.zzg.zzi() || (zzd && this.zzg.zzk());
        if (!z || z3) {
            zzbj.zzb zzb = this.zzg;
            String zzc2 = zzc.zzc();
            if (zzb.zzf()) {
                Boolean zza2 = zza(j2, zzb.zzg());
                if (zza2 == null) {
                    bool2 = null;
                }
                this.zzh.zzr().zzx().zza("Event filter result", bool2 != null ? "null" : bool2);
                if (bool2 != null) {
                    return false;
                }
                this.zzc = true;
                if (!bool2.booleanValue()) {
                    return true;
                }
                this.zzd = true;
                if (z3 && zzc.zzd()) {
                    Long valueOf = Long.valueOf(zzc.zze());
                    if (this.zzg.zzi()) {
                        if (z2 && this.zzg.zzf()) {
                            valueOf = l;
                        }
                        this.zzf = valueOf;
                    } else {
                        if (z2 && this.zzg.zzf()) {
                            valueOf = l2;
                        }
                        this.zze = valueOf;
                    }
                }
                return true;
            }
            HashSet hashSet = new HashSet();
            Iterator<zzbj.zzc> it = zzb.zzd().iterator();
            while (true) {
                if (!it.hasNext()) {
                    ArrayMap arrayMap = new ArrayMap();
                    Iterator<zzbr.zze> it2 = zzc.zza().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            Iterator<zzbj.zzc> it3 = zzb.zzd().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    bool2 = true;
                                    break;
                                }
                                zzbj.zzc next = it3.next();
                                boolean z4 = next.zze() && next.zzf();
                                String zzh2 = next.zzh();
                                if (zzh2.isEmpty()) {
                                    this.zzh.zzr().zzi().zza("Event has empty param name. event", this.zzh.zzo().zza(zzc2));
                                    bool2 = null;
                                    break;
                                }
                                Object obj = arrayMap.get(zzh2);
                                if (obj instanceof Long) {
                                    if (!next.zzc()) {
                                        this.zzh.zzr().zzi().zza("No number filter for long param. event, param", this.zzh.zzo().zza(zzc2), this.zzh.zzo().zzb(zzh2));
                                        bool2 = null;
                                        break;
                                    }
                                    Boolean zza3 = zza(((Long) obj).longValue(), next.zzd());
                                    if (zza3 == null) {
                                        bool2 = null;
                                        break;
                                    } else if (zza3.booleanValue() == z4) {
                                        break;
                                    }
                                } else if (obj instanceof Double) {
                                    if (!next.zzc()) {
                                        this.zzh.zzr().zzi().zza("No number filter for double param. event, param", this.zzh.zzo().zza(zzc2), this.zzh.zzo().zzb(zzh2));
                                        bool2 = null;
                                        break;
                                    }
                                    Boolean zza4 = zza(((Double) obj).doubleValue(), next.zzd());
                                    if (zza4 == null) {
                                        bool2 = null;
                                        break;
                                    } else if (zza4.booleanValue() == z4) {
                                        break;
                                    }
                                } else if (obj instanceof String) {
                                    if (!next.zza()) {
                                        if (!next.zzc()) {
                                            this.zzh.zzr().zzi().zza("No filter for String param. event, param", this.zzh.zzo().zza(zzc2), this.zzh.zzo().zzb(zzh2));
                                            bool2 = null;
                                            break;
                                        }
                                        String str = (String) obj;
                                        if (!zzkw.zza(str)) {
                                            this.zzh.zzr().zzi().zza("Invalid param value for number filter. event, param", this.zzh.zzo().zza(zzc2), this.zzh.zzo().zzb(zzh2));
                                            bool2 = null;
                                            break;
                                        }
                                        bool = zza(str, next.zzd());
                                    } else {
                                        bool = zza((String) obj, next.zzb(), this.zzh.zzr());
                                    }
                                    if (bool == null) {
                                        bool2 = null;
                                        break;
                                    } else if (bool.booleanValue() == z4) {
                                        break;
                                    }
                                } else if (obj == null) {
                                    this.zzh.zzr().zzx().zza("Missing param for filter. event, param", this.zzh.zzo().zza(zzc2), this.zzh.zzo().zzb(zzh2));
                                } else {
                                    this.zzh.zzr().zzi().zza("Unknown param type. event, param", this.zzh.zzo().zza(zzc2), this.zzh.zzo().zzb(zzh2));
                                    bool2 = null;
                                }
                            }
                        } else {
                            zzbr.zze next2 = it2.next();
                            if (hashSet.contains(next2.zzb())) {
                                if (!next2.zze()) {
                                    if (!next2.zzg()) {
                                        if (!next2.zzc()) {
                                            this.zzh.zzr().zzi().zza("Unknown value for param. event, param", this.zzh.zzo().zza(zzc2), this.zzh.zzo().zzb(next2.zzb()));
                                            bool2 = null;
                                            break;
                                        }
                                        arrayMap.put(next2.zzb(), next2.zzd());
                                    } else {
                                        arrayMap.put(next2.zzb(), next2.zzg() ? Double.valueOf(next2.zzh()) : null);
                                    }
                                } else {
                                    arrayMap.put(next2.zzb(), next2.zze() ? Long.valueOf(next2.zzf()) : null);
                                }
                            }
                        }
                    }
                } else {
                    zzbj.zzc next3 = it.next();
                    if (next3.zzh().isEmpty()) {
                        this.zzh.zzr().zzi().zza("null or empty param name in filter. event", this.zzh.zzo().zza(zzc2));
                        bool2 = null;
                        break;
                    }
                    hashSet.add(next3.zzh());
                }
            }
            this.zzh.zzr().zzx().zza("Event filter result", bool2 != null ? "null" : bool2);
            if (bool2 != null) {
            }
        } else {
            zzfl zzx = this.zzh.zzr().zzx();
            Integer valueOf2 = Integer.valueOf(this.zzb);
            if (this.zzg.zza()) {
                num = Integer.valueOf(this.zzg.zzb());
            }
            zzx.zza("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf2, num);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return this.zzg.zzf();
    }
}
