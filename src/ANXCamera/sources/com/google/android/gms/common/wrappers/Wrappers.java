package com.google.android.gms.common.wrappers;

import android.content.Context;

public class Wrappers {
    private static Wrappers zzhz = new Wrappers();
    private PackageManagerWrapper zzhy = null;

    public static PackageManagerWrapper packageManager(Context context) {
        return zzhz.zzi(context);
    }

    private final synchronized PackageManagerWrapper zzi(Context context) {
        if (this.zzhy == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzhy = new PackageManagerWrapper(context);
        }
        return this.zzhy;
    }
}
