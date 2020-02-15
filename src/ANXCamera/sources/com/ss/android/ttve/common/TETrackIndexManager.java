package com.ss.android.ttve.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class TETrackIndexManager {
    public static final int TRACK_TYPE_AUDIO = 1;
    public static final int TRACK_TYPE_VIDEO = 2;
    private List<Integer> mAudioTrackIndexList = new ArrayList();
    private int mFirstAudioIndex = -1;
    private int mFirstVideoIndex = -1;
    private List<Integer> mVideoTrackIndexList = new ArrayList();

    @Retention(RetentionPolicy.SOURCE)
    public @interface TETrackType {
    }

    public int addTrack(int i, int i2) {
        if (i == 1) {
            if (this.mFirstAudioIndex == -1) {
                this.mFirstAudioIndex = i2;
            }
            if (this.mAudioTrackIndexList.size() > 0) {
                List<Integer> list = this.mAudioTrackIndexList;
                i2 = list.get(list.size() - 1).intValue() + 1;
            }
            this.mAudioTrackIndexList.add(Integer.valueOf(i2));
            return i2;
        } else if (i != 2) {
            return i2;
        } else {
            if (this.mFirstVideoIndex == -1) {
                this.mFirstVideoIndex = i2;
            }
            if (this.mVideoTrackIndexList.size() > 0) {
                List<Integer> list2 = this.mVideoTrackIndexList;
                i2 = list2.get(list2.size() - 1).intValue() + 1;
            }
            this.mVideoTrackIndexList.add(Integer.valueOf(i2));
            return i2;
        }
    }

    public int getNativeTrackIndex(int i, int i2) {
        int i3;
        int i4 = 0;
        if (i != 1) {
            if (i == 2) {
                int i5 = this.mFirstVideoIndex;
                if (i2 < i5 || i5 == -1) {
                    return i2;
                }
                while (i4 < this.mVideoTrackIndexList.size()) {
                    if (i2 == this.mVideoTrackIndexList.get(i4).intValue()) {
                        i3 = this.mFirstVideoIndex;
                    } else {
                        i4++;
                    }
                }
            }
            return i2;
        }
        int i6 = this.mFirstAudioIndex;
        if (i2 >= i6 && i6 != -1) {
            while (i4 < this.mAudioTrackIndexList.size()) {
                if (i2 == this.mAudioTrackIndexList.get(i4).intValue()) {
                    i3 = this.mFirstAudioIndex;
                } else {
                    i4++;
                }
            }
        }
        return i2;
        return i4 + i3;
    }

    public void removeTrack(int i, int i2) {
        if (i == 1) {
            this.mAudioTrackIndexList.remove(Integer.valueOf(i2));
        } else if (i == 2) {
            this.mVideoTrackIndexList.remove(Integer.valueOf(i2));
        }
    }
}
