package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.3.0 */
final class zzfi extends SQLiteOpenHelper {
    private final /* synthetic */ zzff zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfi(zzff zzff, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzff;
    }

    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e2) {
            throw e2;
        } catch (SQLiteException e3) {
            this.zza.zzr().zzf().zza("Opening the local database failed, dropping and recreating it");
            if (!this.zza.zzn().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.zza.zzr().zzf().zza("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e4) {
                this.zza.zzr().zzf().zza("Failed to open local database. Events will bypass local storage", e4);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzag.zza(this.zza.zzr(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (Build.VERSION.SDK_INT < 15) {
            ? r0 = 0;
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", r0);
                rawQuery.moveToFirst();
                r0 = rawQuery;
            } finally {
                if (r0 != 0) {
                    r0.close();
                }
            }
        }
        zzag.zza(this.zza.zzr(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", (String[]) null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
