package com.ss.android.ugc.effectmanager.common.cache;

import android.text.TextUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.ugc.effectmanager.common.listener.ICache;
import com.ss.android.ugc.effectmanager.common.utils.FileUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.regex.Pattern;

public class FileCache implements ICache {
    private EffectConfiguration mConfiguration;

    public FileCache(EffectConfiguration effectConfiguration) {
        this.mConfiguration = effectConfiguration;
    }

    public void clear() {
        FileUtils.removeDir(this.mConfiguration.getEffectDir());
    }

    public boolean has(String str) {
        return FileUtils.checkFileExists(this.mConfiguration.getEffectDir() + File.separator + str);
    }

    public InputStream queryToStream(String str) {
        InputStream fileStream;
        String str2 = this.mConfiguration.getEffectDir().getPath() + File.separator + str;
        synchronized (FileCache.class) {
            fileStream = FileUtils.getFileStream(str2);
        }
        return fileStream;
    }

    public String queryToString(String str) {
        String str2 = this.mConfiguration.getEffectDir().getPath() + File.separator + str;
        synchronized (FileCache.class) {
            String fileContent = FileUtils.getFileContent(str2);
            return TextUtils.isEmpty(fileContent) ? "" : fileContent;
        }
    }

    public boolean remove(String str) {
        boolean removeFile;
        synchronized (FileCache.class) {
            removeFile = FileUtils.removeFile(this.mConfiguration.getEffectDir() + File.separator + str);
        }
        return removeFile;
    }

    public void removePattern(final Pattern pattern) {
        synchronized (FileCache.class) {
            for (File delete : this.mConfiguration.getEffectDir().listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return pattern.matcher(str).matches();
                }
            })) {
                delete.delete();
            }
        }
    }

    public void save(String str, String str2) {
        synchronized (FileCache.class) {
            FileUtils.writeToExternal(str2, this.mConfiguration.getEffectDir() + File.separator + str);
        }
    }
}
