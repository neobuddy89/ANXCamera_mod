package com.xiaomi.camera.processor;

import android.media.Image;
import android.support.annotation.NonNull;
import com.android.camera.log.Log;
import com.xiaomi.camera.base.PerformanceTracker;
import com.xiaomi.camera.core.CaptureData;
import com.xiaomi.camera.core.CaptureDataListener;
import com.xiaomi.camera.imagecodec.ImagePool;
import com.xiaomi.engine.FrameData;
import com.xiaomi.engine.TaskSession;
import com.xiaomi.protocol.ICustomCaptureResult;
import java.util.ArrayList;
import java.util.List;

public class SuperResolutionProcessor implements AlgoProcessor {
    private static final String TAG = "SRProcessor";

    private void onImageAvailable(CaptureData captureData, CaptureData.CaptureDataBean captureDataBean, ProcessResultListener processResultListener) {
        captureData.setMultiFrameProcessResult(captureDataBean);
        processResultListener.onProcessFinished(captureData, !captureData.isMoonMode());
    }

    public void doProcess(@NonNull CaptureData captureData, ProcessResultListener processResultListener, TaskSession taskSession) {
        Log.d(TAG, "doProcess: E");
        List<CaptureData.CaptureDataBean> captureDataBeanList = captureData.getCaptureDataBeanList();
        if (captureDataBeanList == null || captureDataBeanList.isEmpty()) {
            throw new IllegalArgumentException("taskBeanList is not allow to be empty!");
        }
        CaptureData.CaptureDataBean captureDataBean = new CaptureData.CaptureDataBean(captureData.getStreamNum());
        Log.d(TAG, "doProcess: dataNum = " + captureDataBeanList.size());
        PerformanceTracker.trackAlgorithmProcess("[SR]", 0);
        ArrayList arrayList = new ArrayList();
        for (CaptureData.CaptureDataBean next : captureDataBeanList) {
            FrameData frameData = new FrameData(0, next.getResult().getSequenceId(), next.getResult().getFrameNumber(), next.getResult().getResults(), next.getMainImage());
            arrayList.add(frameData);
        }
        Image mainImage = captureDataBeanList.get(0).getMainImage();
        Image anEmptyImage = ImagePool.getInstance().getAnEmptyImage(new ImagePool.ImageFormat(mainImage.getWidth(), mainImage.getHeight(), mainImage.getFormat()));
        int processFrameWithSync = taskSession.processFrameWithSync(arrayList, anEmptyImage, 0);
        if (processFrameWithSync > arrayList.size() || processFrameWithSync < 0) {
            Log.w(TAG, "doProcess: returned a error baseIndex: " + processFrameWithSync);
            processFrameWithSync = 0;
        }
        PerformanceTracker.trackAlgorithmProcess("[SR]", 1);
        Log.d(TAG, "doProcess: SR done. baseIndex = " + processFrameWithSync);
        CaptureData.CaptureDataBean captureDataBean2 = captureDataBeanList.get(processFrameWithSync);
        ICustomCaptureResult result = captureDataBean2.getResult();
        captureDataBean.setCaptureResult(result, true);
        long timeStamp = result.getTimeStamp();
        anEmptyImage.setTimestamp(timeStamp);
        ImagePool.getInstance().queueImage(anEmptyImage);
        Image image = ImagePool.getInstance().getImage(timeStamp);
        captureDataBean.setImage(image, 0);
        ImagePool.getInstance().holdImage(image);
        CaptureDataListener captureDataListener = captureData.getCaptureDataListener();
        for (CaptureData.CaptureDataBean next2 : captureDataBeanList) {
            if (next2 != captureDataBean2) {
                Image mainImage2 = next2.getMainImage();
                mainImage2.close();
                captureDataListener.onOriginalImageClosed(mainImage2);
                Image subImage = next2.getSubImage();
                if (subImage != null) {
                    subImage.close();
                    captureDataListener.onOriginalImageClosed(subImage);
                }
            }
        }
        captureDataBeanList.clear();
        Image mainImage3 = captureDataBean2.getMainImage();
        mainImage3.close();
        captureDataListener.onOriginalImageClosed(mainImage3);
        Image subImage2 = captureDataBean2.getSubImage();
        if (subImage2 != null) {
            long timestamp = subImage2.getTimestamp();
            ImagePool.getInstance().queueImage(subImage2);
            Image image2 = ImagePool.getInstance().getImage(timestamp);
            captureDataBean.setImage(image2, 1);
            captureDataListener.onOriginalImageClosed(subImage2);
            if (timestamp != timeStamp) {
                image2.setTimestamp(timeStamp);
            }
            ImagePool.getInstance().holdImage(image2);
        }
        if (captureDataBean.isDataReady()) {
            onImageAvailable(captureData, captureDataBean, processResultListener);
        }
        Log.d(TAG, "doProcess: X");
    }
}
