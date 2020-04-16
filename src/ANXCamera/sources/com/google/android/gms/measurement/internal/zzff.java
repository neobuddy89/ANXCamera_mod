package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
public final class zzff extends zze {
    private final zzfi zza = new zzfi(this, zzn(), "google_app_measurement_local.db");
    private boolean zzb;

    zzff(zzgq zzgq) {
        super(zzgq);
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, (String) null, (String) null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00cb A[SYNTHETIC, Splitter:B:48:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0122 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0122 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0122 A[SYNTHETIC] */
    private final boolean zza(int i, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Cursor cursor;
        zzb();
        zzd();
        ? r2 = 0;
        if (this.zzb) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 5;
        int i3 = 0;
        int i4 = 5;
        while (i3 < i2) {
            ? r7 = 0;
            try {
                sQLiteDatabase = zzae();
                if (sQLiteDatabase == null) {
                    try {
                        this.zzb = true;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return r2;
                    } catch (SQLiteFullException e2) {
                        e = e2;
                    } catch (SQLiteDatabaseLockedException e3) {
                        try {
                            z = r7;
                            SystemClock.sleep((long) i4);
                            z = r7;
                            i4 += 20;
                            if (r7 != 0) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            i3++;
                            r2 = 0;
                            i2 = 5;
                        } catch (Throwable th) {
                            th = th;
                            r7 = z;
                            if (r7 != 0) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    } catch (SQLiteException e4) {
                        e = e4;
                        cursor = null;
                        r7 = sQLiteDatabase;
                        if (r7 != 0) {
                        }
                        zzr().zzf().zza("Error writing entry to local database", e);
                        this.zzb = true;
                        if (cursor != null) {
                        }
                        if (r7 != 0) {
                        }
                        i3++;
                        r2 = 0;
                        i2 = 5;
                    }
                } else {
                    sQLiteDatabase.beginTransaction();
                    long j = 0;
                    cursor = sQLiteDatabase.rawQuery("select count(1) from messages", (String[]) null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                j = cursor.getLong(r2);
                            }
                        } catch (SQLiteFullException e5) {
                            e = e5;
                            r7 = cursor;
                            z = r7;
                            zzr().zzf().zza("Error writing entry; local database full", e);
                            this.zzb = true;
                            z = r7;
                            if (r7 != 0) {
                                r7.close();
                            }
                            if (sQLiteDatabase == null) {
                                sQLiteDatabase.close();
                            }
                            i3++;
                            r2 = 0;
                            i2 = 5;
                        } catch (SQLiteDatabaseLockedException e6) {
                            r7 = cursor;
                            z = r7;
                            SystemClock.sleep((long) i4);
                            z = r7;
                            i4 += 20;
                            if (r7 != 0) {
                                r7.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i3++;
                            r2 = 0;
                            i2 = 5;
                        } catch (SQLiteException e7) {
                            e = e7;
                            r7 = sQLiteDatabase;
                            if (r7 != 0) {
                                try {
                                    if (r7.inTransaction()) {
                                        r7.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabase = r7;
                                    r7 = cursor;
                                    if (r7 != 0) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th;
                                }
                            }
                            zzr().zzf().zza("Error writing entry to local database", e);
                            this.zzb = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (r7 != 0) {
                                r7.close();
                            }
                            i3++;
                            r2 = 0;
                            i2 = 5;
                        } catch (Throwable th3) {
                            th = th3;
                            r7 = cursor;
                            if (r7 != 0) {
                                r7.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    if (j >= 100000) {
                        zzr().zzf().zza("Data loss, local db full");
                        long j2 = (100000 - j) + 1;
                        String[] strArr = new String[1];
                        strArr[r2] = Long.toString(j2);
                        long delete = (long) sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (delete != j2) {
                            zzr().zzf().zza("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(delete), Long.valueOf(j2 - delete));
                        }
                    }
                    sQLiteDatabase.insertOrThrow("messages", (String) null, contentValues);
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return true;
                    }
                    sQLiteDatabase.close();
                    return true;
                }
            } catch (SQLiteFullException e8) {
                e = e8;
                sQLiteDatabase = null;
                z = r7;
                zzr().zzf().zza("Error writing entry; local database full", e);
                this.zzb = true;
                z = r7;
                if (r7 != 0) {
                }
                if (sQLiteDatabase == null) {
                }
                i3++;
                r2 = 0;
                i2 = 5;
            } catch (SQLiteDatabaseLockedException e9) {
                sQLiteDatabase = null;
                z = r7;
                SystemClock.sleep((long) i4);
                z = r7;
                i4 += 20;
                if (r7 != 0) {
                }
                if (sQLiteDatabase != null) {
                }
                i3++;
                r2 = 0;
                i2 = 5;
            } catch (SQLiteException e10) {
                e = e10;
                cursor = null;
                if (r7 != 0) {
                }
                zzr().zzf().zza("Error writing entry to local database", e);
                this.zzb = true;
                if (cursor != null) {
                }
                if (r7 != 0) {
                }
                i3++;
                r2 = 0;
                i2 = 5;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabase = null;
                if (r7 != 0) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        }
        zzr().zzx().zza("Failed to write entry to local database");
        return false;
    }

    private final SQLiteDatabase zzae() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    private final boolean zzaf() {
        return zzn().getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x017a, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x017d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x019f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01a0, code lost:
        r15 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01a4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01a5, code lost:
        r15 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01e8, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01e9, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01f3, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01fa, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01fb, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x01ff, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0200, code lost:
        r13 = r24;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0206, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0209, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x020a, code lost:
        r13 = r24;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0210, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0218, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0219, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x022c, code lost:
        if (r15.inTransaction() != false) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x022e, code lost:
        r15.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0240, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0245, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0254, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0259, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x027b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x027c, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x027d, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0280, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0285, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0098, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0099, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009e, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a3, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0109, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x010c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0127, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0141, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0144, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x015f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01e8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:52:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01f2 A[ExcHandler: SQLiteDatabaseLockedException (e android.database.sqlite.SQLiteDatabaseLockedException), Splitter:B:52:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01fa A[ExcHandler: all (th java.lang.Throwable), PHI: r24 
  PHI: (r24v4 android.database.sqlite.SQLiteDatabase) = (r24v5 android.database.sqlite.SQLiteDatabase), (r24v9 android.database.sqlite.SQLiteDatabase) binds: [B:49:0x00ab, B:35:0x0088] A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0205 A[ExcHandler: SQLiteDatabaseLockedException (e android.database.sqlite.SQLiteDatabaseLockedException), PHI: r24 
  PHI: (r24v2 android.database.sqlite.SQLiteDatabase) = (r24v5 android.database.sqlite.SQLiteDatabase), (r24v9 android.database.sqlite.SQLiteDatabase) binds: [B:49:0x00ab, B:35:0x0088] A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0210 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0217 A[ExcHandler: SQLiteDatabaseLockedException (e android.database.sqlite.SQLiteDatabaseLockedException), Splitter:B:12:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0228 A[SYNTHETIC, Splitter:B:168:0x0228] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0277 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0277 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0277 A[SYNTHETIC] */
    public final List<AbstractSafeParcelable> zza(int i) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase3;
        zzv zzv;
        zzkz zzkz;
        String[] strArr;
        String str;
        zzd();
        zzb();
        Cursor cursor2 = null;
        if (this.zzb) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!zzaf()) {
            return arrayList;
        }
        int i2 = 5;
        int i3 = 0;
        while (i3 < 5) {
            try {
                sQLiteDatabase2 = zzae();
                if (sQLiteDatabase2 == null) {
                    try {
                        this.zzb = true;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                        }
                        return null;
                    } catch (SQLiteFullException e2) {
                        e = e2;
                        SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
                    } catch (SQLiteDatabaseLockedException e3) {
                    } catch (SQLiteException e4) {
                        e = e4;
                        SQLiteDatabase sQLiteDatabase5 = sQLiteDatabase2;
                        cursor = null;
                        if (sQLiteDatabase2 != null) {
                        }
                        zzr().zzf().zza("Error reading entries from local database", e);
                        this.zzb = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                        i3++;
                    } catch (Throwable th) {
                    }
                } else {
                    sQLiteDatabase2.beginTransaction();
                    long j = -1;
                    if (zzt().zza(zzap.zzbz)) {
                        long zza2 = zza(sQLiteDatabase2);
                        if (zza2 != -1) {
                            str = "rowid<?";
                            strArr = new String[]{String.valueOf(zza2)};
                        } else {
                            str = null;
                            strArr = null;
                        }
                        sQLiteDatabase3 = sQLiteDatabase2;
                        try {
                            cursor = sQLiteDatabase2.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, (String) null, (String) null, "rowid asc", Integer.toString(100));
                        } catch (SQLiteFullException e5) {
                            e = e5;
                            sQLiteDatabase2 = sQLiteDatabase3;
                            cursor = null;
                            zzr().zzf().zza("Error reading entries from local database", e);
                            this.zzb = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase2 != null) {
                            }
                            i3++;
                        } catch (SQLiteDatabaseLockedException e6) {
                        } catch (SQLiteException e7) {
                            e = e7;
                            sQLiteDatabase2 = sQLiteDatabase3;
                            cursor = null;
                            if (sQLiteDatabase2 != null) {
                            }
                            zzr().zzf().zza("Error reading entries from local database", e);
                            this.zzb = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase2 != null) {
                            }
                            i3++;
                        } catch (Throwable th2) {
                        }
                    } else {
                        sQLiteDatabase3 = sQLiteDatabase2;
                        cursor = sQLiteDatabase3.query("messages", new String[]{"rowid", "type", "entry"}, (String) null, (String[]) null, (String) null, (String) null, "rowid asc", Integer.toString(100));
                    }
                    while (cursor.moveToNext()) {
                        try {
                            j = cursor.getLong(0);
                            int i4 = cursor.getInt(1);
                            byte[] blob = cursor.getBlob(2);
                            if (i4 == 0) {
                                Parcel obtain = Parcel.obtain();
                                try {
                                    obtain.unmarshall(blob, 0, blob.length);
                                    obtain.setDataPosition(0);
                                    zzan createFromParcel = zzan.CREATOR.createFromParcel(obtain);
                                    obtain.recycle();
                                    if (createFromParcel != null) {
                                        arrayList.add(createFromParcel);
                                    }
                                } catch (SafeParcelReader.ParseException e8) {
                                    zzr().zzf().zza("Failed to load event from local database");
                                    obtain.recycle();
                                }
                            } else if (i4 == 1) {
                                Parcel obtain2 = Parcel.obtain();
                                try {
                                    obtain2.unmarshall(blob, 0, blob.length);
                                    obtain2.setDataPosition(0);
                                    zzkz = zzkz.CREATOR.createFromParcel(obtain2);
                                    obtain2.recycle();
                                } catch (SafeParcelReader.ParseException e9) {
                                    zzr().zzf().zza("Failed to load user property from local database");
                                    obtain2.recycle();
                                    zzkz = null;
                                }
                                if (zzkz != null) {
                                    arrayList.add(zzkz);
                                }
                            } else if (i4 == 2) {
                                Parcel obtain3 = Parcel.obtain();
                                try {
                                    obtain3.unmarshall(blob, 0, blob.length);
                                    obtain3.setDataPosition(0);
                                    zzv = zzv.CREATOR.createFromParcel(obtain3);
                                    obtain3.recycle();
                                } catch (SafeParcelReader.ParseException e10) {
                                    zzr().zzf().zza("Failed to load conditional user property from local database");
                                    obtain3.recycle();
                                    zzv = null;
                                }
                                if (zzv != null) {
                                    arrayList.add(zzv);
                                }
                            } else if (i4 == 3) {
                                zzr().zzi().zza("Skipping app launch break");
                            } else {
                                zzr().zzf().zza("Unknown record type in local database");
                            }
                        } catch (SQLiteFullException e11) {
                            e = e11;
                            sQLiteDatabase = sQLiteDatabase3;
                            sQLiteDatabase2 = sQLiteDatabase;
                            zzr().zzf().zza("Error reading entries from local database", e);
                            this.zzb = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase2 != null) {
                            }
                            i3++;
                        } catch (SQLiteDatabaseLockedException e12) {
                        } catch (SQLiteException e13) {
                            e = e13;
                            sQLiteDatabase = sQLiteDatabase3;
                            sQLiteDatabase2 = sQLiteDatabase;
                            if (sQLiteDatabase2 != null) {
                            }
                            zzr().zzf().zza("Error reading entries from local database", e);
                            this.zzb = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase2 != null) {
                            }
                            i3++;
                        } catch (Throwable th3) {
                        }
                    }
                    sQLiteDatabase = sQLiteDatabase3;
                    try {
                        if (sQLiteDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                            zzr().zzf().zza("Fewer entries removed from local database than expected");
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return arrayList;
                    } catch (SQLiteFullException e14) {
                        e = e14;
                        sQLiteDatabase2 = sQLiteDatabase;
                        zzr().zzf().zza("Error reading entries from local database", e);
                        this.zzb = true;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                        }
                        i3++;
                    } catch (SQLiteDatabaseLockedException e15) {
                        sQLiteDatabase2 = sQLiteDatabase;
                        SystemClock.sleep((long) i2);
                        i2 += 20;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                        i3++;
                    } catch (SQLiteException e16) {
                        e = e16;
                        sQLiteDatabase2 = sQLiteDatabase;
                        if (sQLiteDatabase2 != null) {
                        }
                        zzr().zzf().zza("Error reading entries from local database", e);
                        this.zzb = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                        i3++;
                    } catch (Throwable th4) {
                        th = th4;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                }
            } catch (SQLiteFullException e17) {
                e = e17;
                cursor = null;
                sQLiteDatabase2 = null;
                zzr().zzf().zza("Error reading entries from local database", e);
                this.zzb = true;
                if (cursor != null) {
                }
                if (sQLiteDatabase2 != null) {
                }
                i3++;
            } catch (SQLiteDatabaseLockedException e18) {
                cursor = null;
                sQLiteDatabase2 = null;
                SystemClock.sleep((long) i2);
                i2 += 20;
                if (cursor != null) {
                }
                if (sQLiteDatabase2 != null) {
                }
                i3++;
            } catch (SQLiteException e19) {
                e = e19;
                cursor = null;
                sQLiteDatabase2 = null;
                if (sQLiteDatabase2 != null) {
                }
                zzr().zzf().zza("Error reading entries from local database", e);
                this.zzb = true;
                if (cursor != null) {
                }
                if (sQLiteDatabase2 != null) {
                }
                i3++;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase = null;
                if (cursor2 != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        }
        zzr().zzi().zza("Failed to read events from database in reasonable time");
        return null;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final boolean zza(zzan zzan) {
        Parcel obtain = Parcel.obtain();
        zzan.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzr().zzg().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzkz zzkz) {
        Parcel obtain = Parcel.obtain();
        zzkz.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzr().zzg().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zza(zzv zzv) {
        zzp();
        byte[] zza2 = zzla.zza((Parcelable) zzv);
        if (zza2.length <= 131072) {
            return zza(2, zza2);
        }
        zzr().zzg().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final void zzab() {
        zzb();
        zzd();
        try {
            int delete = zzae().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzr().zzx().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            zzr().zzf().zza("Error resetting local analytics data. error", e2);
        }
    }

    public final boolean zzac() {
        return zza(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008b, code lost:
        r3 = r3 + 1;
     */
    public final boolean zzad() {
        zzd();
        zzb();
        if (this.zzb || !zzaf()) {
            return false;
        }
        int i = 5;
        int i2 = 0;
        while (i2 < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = zzae();
                if (sQLiteDatabase == null) {
                    this.zzb = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return false;
                }
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return true;
            } catch (SQLiteFullException e2) {
                zzr().zzf().zza("Error deleting app launch break from local database", e2);
                this.zzb = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteDatabaseLockedException e3) {
                SystemClock.sleep((long) i);
                i += 20;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e4) {
                if (sQLiteDatabase != null) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                zzr().zzf().zza("Error deleting app launch break from local database", e4);
                this.zzb = true;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
        zzr().zzi().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzhr zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfg zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zziz zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zziy zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzff zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzke zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzfh zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgj zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfv zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }
}
