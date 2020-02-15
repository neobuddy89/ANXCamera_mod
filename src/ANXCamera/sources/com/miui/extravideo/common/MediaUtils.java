package com.miui.extravideo.common;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaMuxer;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaUtils {
    private static void addVideoToTrack(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(mediaExtractor.getTrackFormat(mediaExtractor.getSampleTrackIndex()).getInteger("max-input-size"));
        allocate.position(0);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        readBufferByExtractor(allocate, bufferInfo, mediaExtractor);
        while (bufferInfo.size > 0) {
            allocate.position(0);
            mediaMuxer.writeSampleData(i, allocate, bufferInfo);
            if ((bufferInfo.flags & 4) == 0) {
                mediaExtractor.advance();
                allocate.position(0);
                readBufferByExtractor(allocate, bufferInfo, mediaExtractor);
            } else {
                return;
            }
        }
    }

    public static long computePresentationTime(int i, int i2) {
        return (long) (((i * 1000000) / i2) + 132);
    }

    private static MediaExtractor generateExtractor(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int i = 0;
        while (true) {
            if (i >= mediaExtractor.getTrackCount()) {
                break;
            } else if (mediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
                mediaExtractor.selectTrack(i);
                break;
            } else {
                i++;
            }
        }
        return mediaExtractor;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.media.MediaExtractor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.media.MediaMuxer} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0082  */
    public static int mixVideo(String str, String str2, String str3, int i) {
        MediaExtractor mediaExtractor;
        MediaMuxer mediaMuxer;
        MediaExtractor mediaExtractor2;
        ? r0 = 0;
        try {
            mediaMuxer = new MediaMuxer(str, 0);
            try {
                mediaMuxer.setOrientationHint(i);
                mediaExtractor = generateExtractor(str2);
            } catch (Exception e2) {
                e = e2;
                mediaExtractor = null;
                mediaExtractor2 = null;
                r0 = mediaMuxer;
                try {
                    e.printStackTrace();
                    if (r0 != 0) {
                        r0.stop();
                        r0.release();
                    }
                    if (mediaExtractor != null) {
                        mediaExtractor.release();
                    }
                    if (mediaExtractor2 != null) {
                        mediaExtractor2.release();
                    }
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    mediaMuxer = r0;
                    r0 = mediaExtractor2;
                    if (mediaMuxer != null) {
                        mediaMuxer.stop();
                        mediaMuxer.release();
                    }
                    if (mediaExtractor != null) {
                        mediaExtractor.release();
                    }
                    if (r0 != 0) {
                        r0.release();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                mediaExtractor = null;
                if (mediaMuxer != null) {
                }
                if (mediaExtractor != null) {
                }
                if (r0 != 0) {
                }
                throw th;
            }
            try {
                MediaExtractor generateExtractor = generateExtractor(str3);
                int addTrack = mediaMuxer.addTrack(mediaExtractor.getTrackFormat(mediaExtractor.getSampleTrackIndex()));
                int addTrack2 = mediaMuxer.addTrack(generateExtractor.getTrackFormat(generateExtractor.getSampleTrackIndex()));
                mediaMuxer.start();
                addVideoToTrack(mediaExtractor, mediaMuxer, addTrack);
                addVideoToTrack(generateExtractor, mediaMuxer, addTrack2);
                r0 = generateExtractor;
                r0 = generateExtractor;
                mediaMuxer.stop();
                mediaMuxer.release();
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
                if (generateExtractor == null) {
                    return addTrack2;
                }
                generateExtractor.release();
                return addTrack2;
            } catch (Exception e3) {
                e = e3;
                mediaExtractor2 = r0;
                r0 = mediaMuxer;
                e.printStackTrace();
                if (r0 != 0) {
                }
                if (mediaExtractor != null) {
                }
                if (mediaExtractor2 != null) {
                }
                return -1;
            } catch (Throwable th3) {
                th = th3;
                r0 = r0;
                if (mediaMuxer != null) {
                }
                if (mediaExtractor != null) {
                }
                if (r0 != 0) {
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            mediaExtractor = null;
            mediaExtractor2 = null;
            e.printStackTrace();
            if (r0 != 0) {
            }
            if (mediaExtractor != null) {
            }
            if (mediaExtractor2 != null) {
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            mediaExtractor = null;
            mediaMuxer = null;
            if (mediaMuxer != null) {
            }
            if (mediaExtractor != null) {
            }
            if (r0 != 0) {
            }
            throw th;
        }
    }

    private static void readBufferByExtractor(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, MediaExtractor mediaExtractor) {
        bufferInfo.size = mediaExtractor.readSampleData(byteBuffer, 0);
        bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime();
        bufferInfo.flags = mediaExtractor.getSampleFlags();
        bufferInfo.offset = 0;
    }
}
