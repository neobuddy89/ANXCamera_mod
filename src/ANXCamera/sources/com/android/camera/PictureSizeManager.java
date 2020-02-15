package com.android.camera;

import com.android.camera.data.DataRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class PictureSizeManager {
    private static final int LIMIT_PICTURE_SIZE = 0;
    private static final int LIMIT_WIDTH_SIZE = 1;
    private static float[] PICTURE_ASPECT_RATIOS = {1.3333333f, 1.7777777f, 1.0f, 2.0f, 2.1666667f, 2.1111112f, 2.0833333f, 2.2222223f};
    private static final ArrayList<CameraSize> sPictureList = new ArrayList<>();

    static {
        Arrays.sort(PICTURE_ASPECT_RATIOS);
    }

    private static CameraSize findMaxSizeWithRatio(List<CameraSize> list, float f2) {
        CameraSize cameraSize;
        int i = 0;
        int i2 = 0;
        for (CameraSize next : list) {
            if (((double) Math.abs(next.getRatio() - f2)) < 0.02d && next.area() > i * i2) {
                i = next.getWidth();
                i2 = next.getHeight();
            }
        }
        if (i != 0) {
            cameraSize = new CameraSize(i, i2);
        } else {
            cameraSize = new CameraSize();
        }
        return cameraSize;
    }

    public static CameraSize getBestPanoPictureSize() {
        CameraSize cameraSize;
        if (CameraSettings.isAspectRatio4_3(Util.sWindowWidth, Util.sWindowHeight)) {
            cameraSize = findMaxSizeWithRatio(sPictureList, 1.3333333f);
        } else if (CameraSettings.isAspectRatio18_9(Util.sWindowWidth, Util.sWindowHeight)) {
            cameraSize = findMaxSizeWithRatio(sPictureList, 2.0f);
            if (cameraSize.isEmpty()) {
                cameraSize = findMaxSizeWithRatio(sPictureList, 1.7777777f);
            }
        } else {
            cameraSize = findMaxSizeWithRatio(sPictureList, 1.7777777f);
        }
        return cameraSize.isEmpty() ? new CameraSize(sPictureList.get(0).width, sPictureList.get(0).height) : cameraSize;
    }

    public static CameraSize getBestPictureSize() {
        return getBestPictureSize((List<CameraSize>) sPictureList);
    }

    public static CameraSize getBestPictureSize(float f2) {
        return getBestPictureSize(sPictureList, f2);
    }

    public static CameraSize getBestPictureSize(List<CameraSize> list) {
        return (list == null || list.isEmpty()) ? new CameraSize() : getBestPictureSize(list, Util.getRatio(CameraSettings.getPictureSizeRatioString()));
    }

    public static CameraSize getBestPictureSize(List<CameraSize> list, float f2) {
        if (list.isEmpty()) {
            return new CameraSize();
        }
        CameraSize cameraSize = null;
        float[] fArr = PICTURE_ASPECT_RATIOS;
        int length = fArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            float f3 = fArr[i];
            if (((double) Math.abs(f2 - f3)) < 0.02d) {
                cameraSize = findMaxSizeWithRatio(list, f3);
                break;
            }
            i++;
        }
        return (cameraSize == null || cameraSize.isEmpty()) ? new CameraSize(list.get(0).width, list.get(0).height) : cameraSize;
    }

    public static CameraSize getBestPictureSize(List<CameraSize> list, float f2, int i) {
        float f3;
        CameraSize cameraSize;
        if (list.isEmpty()) {
            return new CameraSize();
        }
        float[] fArr = PICTURE_ASPECT_RATIOS;
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                f3 = -1.0f;
                break;
            }
            f3 = fArr[i3];
            if (((double) Math.abs(f2 - f3)) < 0.02d) {
                break;
            }
            i3++;
        }
        if (f3 == -1.0f) {
            return new CameraSize();
        }
        int i4 = 0;
        for (CameraSize next : list) {
            if (((double) Math.abs(next.getRatio() - f3)) < 0.02d && next.area() > i2 * i4 && next.area() <= i) {
                i2 = next.getWidth();
                i4 = next.getHeight();
            }
        }
        if (i2 != 0) {
            cameraSize = new CameraSize(i2, i4);
        } else {
            cameraSize = new CameraSize();
        }
        return cameraSize;
    }

    public static CameraSize getBestSquareSize(List<CameraSize> list, int i, boolean z) {
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            return new CameraSize(0, 0);
        }
        for (CameraSize next : list) {
            if (next.getWidth() == next.getHeight() && ((i <= 0 || i >= next.getWidth() || z) && i2 < next.getWidth())) {
                i2 = next.getWidth();
            }
        }
        return new CameraSize(i2, i2);
    }

    public static void initialize(List<CameraSize> list, int i, int i2, int i3) {
        initializeBase(list, 0, i, i2, i3);
    }

    static void initializeBase(List<CameraSize> list, int i, int i2, int i3, int i4) {
        sPictureList.clear();
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("The supported picture size list return from hal is null!");
        }
        if (i2 != 0) {
            ArrayList arrayList = new ArrayList();
            if (i == 0) {
                for (CameraSize next : list) {
                    if (next.area() <= i2) {
                        arrayList.add(next);
                    }
                }
            } else if (i == 1) {
                for (CameraSize next2 : list) {
                    if (next2.width <= i2) {
                        arrayList.add(next2);
                    }
                }
            }
            list = arrayList;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f2 : PICTURE_ASPECT_RATIOS) {
            CameraSize findMaxSizeWithRatio = findMaxSizeWithRatio(list, f2);
            if (!findMaxSizeWithRatio.isEmpty()) {
                sPictureList.add(findMaxSizeWithRatio);
                linkedHashMap.put(Float.valueOf(f2), findMaxSizeWithRatio);
            }
        }
        if (sPictureList.size() != 0) {
            DataRepository.dataItemConfig().getComponentConfigRatio().initSensorRatio(linkedHashMap, i3, i4);
            return;
        }
        throw new IllegalArgumentException("Not find the desire picture sizes!");
    }

    public static void initializeLimitWidth(List<CameraSize> list, int i, int i2, int i3) {
        initializeBase(list, 1, i, i2, i3);
    }
}
