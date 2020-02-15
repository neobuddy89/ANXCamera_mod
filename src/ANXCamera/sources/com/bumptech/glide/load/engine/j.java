package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: DiskCacheStrategy */
class j extends o {
    j() {
    }

    public boolean a(DataSource dataSource) {
        return dataSource == DataSource.REMOTE;
    }

    public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
        return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
    }

    public boolean pi() {
        return true;
    }

    public boolean qi() {
        return true;
    }
}
