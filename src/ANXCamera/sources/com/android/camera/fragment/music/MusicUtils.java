package com.android.camera.fragment.music;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import com.android.camera.R;
import com.android.camera.Util;
import com.android.camera.log.Log;
import com.android.camera.module.impl.component.FileUtils;
import com.android.camera.storage.Storage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MusicUtils {
    private static final String[] LOCAL_MUSIC_LIST_CN = {"Innervation", "Cheerful"};
    private static final String[] LOCAL_MUSIC_LIST_GLOBAL = {"Smooth", "Autumn", "City", "Sports", "Cheerful", "Morning", "Lovely", "Dynamic", "Fashion", "Chic"};

    public static List<LiveMusicInfo> getMusicListFromLocalFolder(String str, Context context) {
        String str2;
        String extractMetadata;
        ArrayList arrayList = new ArrayList();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        File file = new File(str);
        String string = context.getResources().getString(R.string.live_music_author);
        String[] strArr = Util.isGlobalVersion() ? LOCAL_MUSIC_LIST_GLOBAL : LOCAL_MUSIC_LIST_CN;
        String str3 = Util.isGlobalVersion() ? ".aac" : ".mp3";
        if (file.listFiles() != null) {
            for (String str4 : strArr) {
                File file2 = new File(str + str2);
                if (file2.exists()) {
                    LiveMusicInfo liveMusicInfo = new LiveMusicInfo();
                    mediaMetadataRetriever.setDataSource(file2.getAbsolutePath());
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(7);
                    if (extractMetadata2 == null) {
                        extractMetadata2 = str2.substring(0, str2.length() - 4);
                    }
                    liveMusicInfo.mTitle = extractMetadata2;
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(1);
                    if (extractMetadata3 == null) {
                        extractMetadata3 = FileUtils.MUSIC_LOCAL + extractMetadata2 + Storage.JPEG_SUFFIX;
                    }
                    liveMusicInfo.mThumbnailUrl = extractMetadata3;
                    String extractMetadata4 = mediaMetadataRetriever.extractMetadata(2);
                    if (extractMetadata4 == null) {
                        extractMetadata4 = string;
                    }
                    liveMusicInfo.mAuthor = extractMetadata4;
                    liveMusicInfo.mDuration = extractMetadata.substring(0, mediaMetadataRetriever.extractMetadata(9).length() - 3);
                    liveMusicInfo.mPlayUrl = file2.getAbsolutePath();
                    arrayList.add(liveMusicInfo);
                    Log.d("LiveMusicInfo", liveMusicInfo.mAuthor + ", " + liveMusicInfo.mTitle + ", " + liveMusicInfo.mPlayUrl + "," + liveMusicInfo.mThumbnailUrl + "," + liveMusicInfo.mDuration);
                }
            }
        }
        mediaMetadataRetriever.release();
        return arrayList;
    }
}
