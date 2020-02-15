package com.bumptech.glide.load.engine.b;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* compiled from: RuntimeCompat */
class f implements FilenameFilter {
    final /* synthetic */ Pattern zh;

    f(Pattern pattern) {
        this.zh = pattern;
    }

    public boolean accept(File file, String str) {
        return this.zh.matcher(str).matches();
    }
}
