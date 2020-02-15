package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: DiskCacheStrategy */
class n extends o {
    n() {
    }

    public boolean a(DataSource dataSource) {
        return dataSource == DataSource.REMOTE;
    }

    public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
        return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
    }

    public boolean pi() {
        return true;
    }

    public boolean qi() {
        return true;
    }
}
