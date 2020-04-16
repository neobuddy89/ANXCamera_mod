package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzmv;
import com.xiaomi.stat.a.j;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@17.3.0 */
final class zzn extends zzkp {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzp> zzd;
    private Long zze;
    private Long zzf;

    zzn(zzks zzks) {
        super(zzks);
    }

    private final zzp zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzp zzp = new zzp(this, this.zzb, (zzq) null);
        this.zzd.put(Integer.valueOf(i), zzp);
        return zzp;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.zzd.get(Integer.valueOf(i)).zzd.get(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0376  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0420  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x063b  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x07b2  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x07d9  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0358 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0111  */
    public final List<zzbr.zza> zza(String str, List<zzbr.zzc> list, List<zzbr.zzk> list2, Long l, Long l2) {
        boolean z;
        Map<Integer, List<zzbj.zzb>> emptyMap;
        Map<Integer, zzbr.zzi> zzg;
        boolean z2;
        zzq zzq;
        boolean zzd2;
        zzbj.zze zze2;
        zzaj zzaj;
        zzs zzs;
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        boolean z3;
        ArrayMap arrayMap3;
        Iterator it;
        Map<Integer, zzbr.zzi> map;
        List<zzbj.zzb> list3;
        Map<Integer, List<zzbj.zzb>> map2;
        Iterator it2;
        Map<Integer, zzbr.zzi> map3;
        boolean z4;
        boolean z5;
        Iterator<zzbr.zzj> it3;
        zzac zzi;
        String str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zzb = str;
        this.zzc = new HashSet();
        this.zzd = new ArrayMap();
        this.zze = l;
        this.zzf = l2;
        if (zzt().zzd(this.zzb, zzap.zzbm) || zzt().zzd(this.zzb, zzap.zzbn)) {
            Iterator<zzbr.zzc> it4 = list.iterator();
            while (true) {
                if (it4.hasNext()) {
                    if ("_s".equals(it4.next().zzc())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            boolean zzd3 = zzt().zzd(this.zzb, zzap.zzbm);
            boolean zzd4 = zzt().zzd(this.zzb, zzap.zzbn);
            boolean z6 = !zzkg.zzb() && zzt().zzd(this.zzb, zzap.zzbx);
            boolean z7 = !zzkg.zzb() && zzt().zzd(this.zzb, zzap.zzbw);
            if (z && zzd4) {
                zzi = zzi();
                str2 = this.zzb;
                zzi.zzak();
                zzi.zzd();
                Preconditions.checkNotEmpty(str2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("current_session_count", 0);
                zzi.c_().update(j.f343b, contentValues, "app_id = ?", new String[]{str2});
            }
            emptyMap = Collections.emptyMap();
            if (z7 && z6) {
                emptyMap = zzi().zze(this.zzb);
            }
            zzg = zzi().zzg(this.zzb);
            if (zzg != null) {
                z2 = true;
                zzq = null;
            } else if (zzg.isEmpty()) {
                z2 = true;
                zzq = null;
            } else {
                HashSet hashSet = new HashSet(zzg.keySet());
                if (!zzd3 || !z) {
                    arrayMap2 = zzg;
                } else {
                    String str3 = this.zzb;
                    Preconditions.checkNotEmpty(str3);
                    Preconditions.checkNotNull(zzg);
                    ArrayMap arrayMap4 = new ArrayMap();
                    if (!zzg.isEmpty()) {
                        Map<Integer, List<Integer>> zzf2 = zzi().zzf(str3);
                        for (Integer intValue : zzg.keySet()) {
                            int intValue2 = intValue.intValue();
                            zzbr.zzi zzi2 = zzg.get(Integer.valueOf(intValue2));
                            List list4 = zzf2.get(Integer.valueOf(intValue2));
                            if (list4 == null || list4.isEmpty()) {
                                arrayMap4.put(Integer.valueOf(intValue2), zzi2);
                            } else {
                                List<Long> zza = zzg().zza(zzi2.zzc(), (List<Integer>) list4);
                                if (!zza.isEmpty()) {
                                    zzbr.zzi.zza zzb2 = ((zzbr.zzi.zza) zzi2.zzbm()).zzb().zzb((Iterable<? extends Long>) zza);
                                    zzb2.zza().zza((Iterable<? extends Long>) zzg().zza(zzi2.zza(), (List<Integer>) list4));
                                    for (int i = 0; i < zzi2.zzf(); i++) {
                                        if (list4.contains(Integer.valueOf(zzi2.zza(i).zzb()))) {
                                            zzb2.zza(i);
                                        }
                                    }
                                    for (int i2 = 0; i2 < zzi2.zzh(); i2++) {
                                        if (list4.contains(Integer.valueOf(zzi2.zzb(i2).zzb()))) {
                                            zzb2.zzb(i2);
                                        }
                                    }
                                    arrayMap4.put(Integer.valueOf(intValue2), (zzbr.zzi) ((zzfd) zzb2.zzu()));
                                }
                            }
                        }
                    }
                    arrayMap2 = arrayMap4;
                }
                Iterator it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    int intValue3 = ((Integer) it5.next()).intValue();
                    zzbr.zzi zzi3 = arrayMap2.get(Integer.valueOf(intValue3));
                    BitSet bitSet = new BitSet();
                    BitSet bitSet2 = new BitSet();
                    ArrayMap arrayMap5 = new ArrayMap();
                    if (!(zzi3 == null || zzi3.zzf() == 0)) {
                        for (zzbr.zzb next : zzi3.zze()) {
                            if (next.zza()) {
                                arrayMap5.put(Integer.valueOf(next.zzb()), next.zzc() ? Long.valueOf(next.zzd()) : null);
                            }
                        }
                    }
                    if (!zzmv.zzb()) {
                        z5 = true;
                    } else if (zzt().zzd(this.zzb, zzap.zzbt)) {
                        ArrayMap arrayMap6 = new ArrayMap();
                        if (zzi3 == null) {
                            z3 = true;
                        } else if (zzi3.zzh() == 0) {
                            z3 = true;
                        } else {
                            Iterator<zzbr.zzj> it6 = zzi3.zzg().iterator();
                            while (it6.hasNext()) {
                                zzbr.zzj next2 = it6.next();
                                if (!next2.zza() || next2.zzd() <= 0) {
                                    it3 = it6;
                                } else {
                                    it3 = it6;
                                    arrayMap6.put(Integer.valueOf(next2.zzb()), Long.valueOf(next2.zza(next2.zzd() - 1)));
                                }
                                it6 = it3;
                            }
                            z3 = true;
                        }
                        arrayMap3 = arrayMap6;
                        if (zzi3 == null) {
                            int i3 = 0;
                            while (i3 < (zzi3.zzb() << 6)) {
                                if (zzkw.zza(zzi3.zza(), i3)) {
                                    map3 = arrayMap2;
                                    it2 = it5;
                                    zzr().zzx().zza("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue3), Integer.valueOf(i3));
                                    bitSet2.set(i3);
                                    if (zzkw.zza(zzi3.zzc(), i3)) {
                                        bitSet.set(i3);
                                        z4 = z3;
                                        if (z4) {
                                            arrayMap5.remove(Integer.valueOf(i3));
                                        }
                                        i3++;
                                        it5 = it2;
                                        arrayMap2 = map3;
                                    }
                                } else {
                                    map3 = arrayMap2;
                                    it2 = it5;
                                }
                                z4 = false;
                                if (z4) {
                                }
                                i3++;
                                it5 = it2;
                                arrayMap2 = map3;
                            }
                            map = arrayMap2;
                            it = it5;
                        } else {
                            map = arrayMap2;
                            it = it5;
                        }
                        zzbr.zzi zzi4 = !zzd3 ? zzg.get(Integer.valueOf(intValue3)) : zzi3;
                        if (z7 && z6) {
                            list3 = emptyMap.get(Integer.valueOf(intValue3));
                            if (!(list3 == null || this.zzf == null || this.zze == null)) {
                                for (zzbj.zzb zzb3 : list3) {
                                    int zzb4 = zzb3.zzb();
                                    long longValue = this.zzf.longValue() / 1000;
                                    if (zzb3.zzi()) {
                                        longValue = this.zze.longValue() / 1000;
                                    }
                                    if (arrayMap5.containsKey(Integer.valueOf(zzb4))) {
                                        map2 = emptyMap;
                                        arrayMap5.put(Integer.valueOf(zzb4), Long.valueOf(longValue));
                                    } else {
                                        map2 = emptyMap;
                                    }
                                    if (arrayMap3.containsKey(Integer.valueOf(zzb4))) {
                                        arrayMap3.put(Integer.valueOf(zzb4), Long.valueOf(longValue));
                                    }
                                    emptyMap = map2;
                                }
                            }
                        }
                        zzp zzp = new zzp(this, this.zzb, zzi4, bitSet, bitSet2, arrayMap5, arrayMap3, (zzq) null);
                        this.zzd.put(Integer.valueOf(intValue3), zzp);
                        it5 = it;
                        arrayMap2 = map;
                        emptyMap = emptyMap;
                        zzg = zzg;
                    } else {
                        z5 = true;
                    }
                    arrayMap3 = null;
                    if (zzi3 == null) {
                    }
                    if (!zzd3) {
                    }
                    list3 = emptyMap.get(Integer.valueOf(intValue3));
                    while (r1.hasNext()) {
                    }
                    zzp zzp2 = new zzp(this, this.zzb, zzi4, bitSet, bitSet2, arrayMap5, arrayMap3, (zzq) null);
                    this.zzd.put(Integer.valueOf(intValue3), zzp2);
                    it5 = it;
                    arrayMap2 = map;
                    emptyMap = emptyMap;
                    zzg = zzg;
                }
                zzq = null;
                z2 = true;
            }
            if (!list.isEmpty()) {
                zzs zzs2 = new zzs(this, zzq);
                ArrayMap arrayMap7 = new ArrayMap();
                for (zzbr.zzc next3 : list) {
                    zzbr.zzc zza2 = zzs2.zza(this.zzb, next3);
                    if (zza2 != null) {
                        zzac zzi5 = zzi();
                        String str4 = this.zzb;
                        String zzc2 = zza2.zzc();
                        boolean zzd5 = zzi5.zzt().zzd(str4, zzap.zzbn);
                        zzaj zza3 = zzi5.zza(str4, next3.zzc());
                        if (zza3 == null) {
                            zzi5.zzr().zzi().zza("Event aggregate wasn't created during raw event logging. appId, event", zzfj.zza(str4), zzi5.zzo().zza(zzc2));
                            zzaj = zzd5 ? new zzaj(str4, next3.zzc(), 1, 1, 1, next3.zze(), 0, (Long) null, (Long) null, (Long) null, (Boolean) null) : new zzaj(str4, next3.zzc(), 1, 1, next3.zze(), 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        } else if (zzd5) {
                            zzaj zzaj2 = new zzaj(zza3.zza, zza3.zzb, zza3.zzc + 1, zza3.zzd + 1, zza3.zze + 1, zza3.zzf, zza3.zzg, zza3.zzh, zza3.zzi, zza3.zzj, zza3.zzk);
                            zzaj = zzaj2;
                        } else {
                            zzaj zzaj3 = new zzaj(zza3.zza, zza3.zzb, zza3.zzc + 1, zza3.zzd + 1, zza3.zze, zza3.zzf, zza3.zzg, zza3.zzh, zza3.zzi, zza3.zzj, zza3.zzk);
                            zzaj = zzaj3;
                        }
                        zzi().zza(zzaj);
                        long j = zzaj.zzc;
                        String zzc3 = zza2.zzc();
                        Map map4 = (Map) arrayMap7.get(zzc3);
                        if (map4 == null) {
                            map4 = zzi().zzf(this.zzb, zzc3);
                            if (map4 == null) {
                                map4 = new ArrayMap();
                            }
                            arrayMap7.put(zzc3, map4);
                        }
                        for (Integer intValue4 : map4.keySet()) {
                            int intValue5 = intValue4.intValue();
                            if (this.zzc.contains(Integer.valueOf(intValue5))) {
                                zzr().zzx().zza("Skipping failed audience ID", Integer.valueOf(intValue5));
                            } else {
                                Iterator it7 = ((List) map4.get(Integer.valueOf(intValue5))).iterator();
                                boolean z8 = z2;
                                while (true) {
                                    if (!it7.hasNext()) {
                                        zzs = zzs2;
                                        arrayMap = arrayMap7;
                                        break;
                                    }
                                    zzbj.zzb zzb5 = (zzbj.zzb) it7.next();
                                    zzr zzr = new zzr(this, this.zzb, intValue5, zzb5);
                                    zzs = zzs2;
                                    z8 = zzr.zza(this.zze, this.zzf, zza2, j, zzaj, zza(intValue5, zzb5.zzb()));
                                    arrayMap = arrayMap7;
                                    if (zzt().zzd(this.zzb, zzap.zzbu) && !z8) {
                                        this.zzc.add(Integer.valueOf(intValue5));
                                        break;
                                    }
                                    zza(intValue5).zza((zzu) zzr);
                                    zzs2 = zzs;
                                    arrayMap7 = arrayMap;
                                }
                                if (!z8) {
                                    this.zzc.add(Integer.valueOf(intValue5));
                                }
                                zzs2 = zzs;
                                arrayMap7 = arrayMap;
                            }
                        }
                        zzs zzs3 = zzs2;
                        ArrayMap arrayMap8 = arrayMap7;
                    } else {
                        zzs zzs4 = zzs2;
                        ArrayMap arrayMap9 = arrayMap7;
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            if (!list2.isEmpty()) {
                ArrayMap arrayMap10 = new ArrayMap();
                for (zzbr.zzk next4 : list2) {
                    arrayList.add(next4.zzc());
                    String zzc4 = next4.zzc();
                    Map map5 = (Map) arrayMap10.get(zzc4);
                    if (map5 == null) {
                        map5 = zzi().zzg(this.zzb, zzc4);
                        if (map5 == null) {
                            map5 = new ArrayMap();
                        }
                        arrayMap10.put(zzc4, map5);
                    }
                    Iterator it8 = map5.keySet().iterator();
                    while (true) {
                        if (!it8.hasNext()) {
                            break;
                        }
                        int intValue6 = ((Integer) it8.next()).intValue();
                        if (this.zzc.contains(Integer.valueOf(intValue6))) {
                            zzr().zzx().zza("Skipping failed audience ID", Integer.valueOf(intValue6));
                            break;
                        }
                        Iterator it9 = ((List) map5.get(Integer.valueOf(intValue6))).iterator();
                        boolean z9 = z2;
                        while (true) {
                            if (!it9.hasNext()) {
                                break;
                            }
                            zze2 = (zzbj.zze) it9.next();
                            if (zzr().zza(2)) {
                                zzr().zzx().zza("Evaluating filter. audience, filter, property", Integer.valueOf(intValue6), zze2.zza() ? Integer.valueOf(zze2.zzb()) : null, zzo().zzc(zze2.zzc()));
                                zzr().zzx().zza("Filter definition", zzg().zza(zze2));
                            }
                            if (zze2.zza() && zze2.zzb() <= 256) {
                                zzt zzt = new zzt(this, this.zzb, intValue6, zze2);
                                z9 = zzt.zza(this.zze, this.zzf, next4, zza(intValue6, zze2.zzb()));
                                if (zzt().zzd(this.zzb, zzap.zzbu) && !z9) {
                                    this.zzc.add(Integer.valueOf(intValue6));
                                    break;
                                }
                                zza(intValue6).zza((zzu) zzt);
                            }
                        }
                        zzr().zzi().zza("Invalid property filter ID. appId, id", zzfj.zza(this.zzb), String.valueOf(zze2.zza() ? Integer.valueOf(zze2.zzb()) : null));
                        z9 = false;
                        if (!z9) {
                            this.zzc.add(Integer.valueOf(intValue6));
                        }
                    }
                }
            }
            zzd2 = zzt().zzd(this.zzb, zzap.zzbs);
            Map arrayMap11 = new ArrayMap();
            if (zzd2) {
                arrayMap11 = zzi().zza(this.zzb, (List<String>) arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Set<Integer> keySet = this.zzd.keySet();
            keySet.removeAll(this.zzc);
            for (Integer intValue7 : keySet) {
                int intValue8 = intValue7.intValue();
                zzbr.zza zza4 = this.zzd.get(Integer.valueOf(intValue8)).zza(intValue8, (List) arrayMap11.get(Integer.valueOf(intValue8)));
                arrayList2.add(zza4);
                zzac zzi6 = zzi();
                String str5 = this.zzb;
                zzbr.zzi zzc5 = zza4.zzc();
                zzi6.zzak();
                zzi6.zzd();
                Preconditions.checkNotEmpty(str5);
                Preconditions.checkNotNull(zzc5);
                byte[] zzbi = zzc5.zzbi();
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str5);
                contentValues2.put("audience_id", Integer.valueOf(intValue8));
                contentValues2.put("current_results", zzbi);
                try {
                    try {
                        if (zzi6.c_().insertWithOnConflict("audience_filter_values", (String) null, contentValues2, 5) == -1) {
                            zzi6.zzr().zzf().zza("Failed to insert filter results (got -1). appId", zzfj.zza(str5));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        zzi6.zzr().zzf().zza("Error storing filter results. appId", zzfj.zza(str5), e);
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    zzi6.zzr().zzf().zza("Error storing filter results. appId", zzfj.zza(str5), e);
                }
            }
            return arrayList2;
        }
        z = false;
        boolean zzd32 = zzt().zzd(this.zzb, zzap.zzbm);
        boolean zzd42 = zzt().zzd(this.zzb, zzap.zzbn);
        if (!zzkg.zzb()) {
        }
        if (!zzkg.zzb()) {
        }
        zzi = zzi();
        str2 = this.zzb;
        zzi.zzak();
        zzi.zzd();
        Preconditions.checkNotEmpty(str2);
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("current_session_count", 0);
        try {
            zzi.c_().update(j.f343b, contentValues3, "app_id = ?", new String[]{str2});
        } catch (SQLiteException e4) {
            zzi.zzr().zzf().zza("Error resetting session-scoped event counts. appId", zzfj.zza(str2), e4);
        }
        emptyMap = Collections.emptyMap();
        emptyMap = zzi().zze(this.zzb);
        zzg = zzi().zzg(this.zzb);
        if (zzg != null) {
        }
        if (!list.isEmpty()) {
        }
        ArrayList arrayList3 = new ArrayList();
        if (!list2.isEmpty()) {
        }
        zzd2 = zzt().zzd(this.zzb, zzap.zzbs);
        Map arrayMap112 = new ArrayMap();
        if (zzd2) {
        }
        ArrayList arrayList22 = new ArrayList();
        Set<Integer> keySet2 = this.zzd.keySet();
        keySet2.removeAll(this.zzc);
        while (r3.hasNext()) {
        }
        return arrayList22;
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }
}
