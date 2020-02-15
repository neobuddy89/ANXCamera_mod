package com.bef.effectsdk;

public final class FileResourceFinder implements ResourceFinder {
    private final String mDir;

    public FileResourceFinder(String str) {
        this.mDir = str;
    }

    private static native long nativeCreateFileResourceFinder(long j, String str);

    public long createNativeResourceFinder(long j) {
        return nativeCreateFileResourceFinder(j, this.mDir);
    }

    public void release(long j) {
    }
}
