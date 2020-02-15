package com.xiaomi.camera.core;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.LongSparseArray;
import com.xiaomi.camera.core.CaptureData;
import com.xiaomi.protocol.ICustomCaptureResult;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import miui.os.Build;

public class ParallelDataZipper {
    /* access modifiers changed from: private */
    public static final String TAG = "ParallelDataZipper";
    /* access modifiers changed from: private */
    @SuppressLint({"UseSparseArrays"})
    public final Map<Long, CaptureData> mCaptureDataArray;
    /* access modifiers changed from: private */
    public LongSparseArray<CaptureData.CaptureDataBean> mCaptureDataBeanArray;
    private Handler mHandler;
    private HandlerThread mWorkThread;

    public interface DataListener {
        void onParallelDataAbandoned(CaptureData captureData);

        void onParallelDataAvailable(CaptureData captureData);
    }

    static class InstanceHolder {
        static ParallelDataZipper INSTANCE = new ParallelDataZipper();

        InstanceHolder() {
        }
    }

    private ParallelDataZipper() {
        this.mCaptureDataBeanArray = new LongSparseArray<>(4);
        this.mCaptureDataArray = new HashMap(4);
        this.mWorkThread = new HandlerThread("ParallelDataZipperThread");
        this.mWorkThread.start();
        this.mHandler = new Handler(this.mWorkThread.getLooper());
    }

    private long getFirstFrameTimestamp(long j) {
        if (this.mCaptureDataArray.containsKey(Long.valueOf(j))) {
            String str = TAG;
            Log.d(str, "getFirstFrameTimestamp: return current timestamp: " + j);
            return j;
        }
        Long[] lArr = (Long[]) this.mCaptureDataArray.keySet().toArray(new Long[0]);
        if (!(lArr == null || lArr.length == 0)) {
            Arrays.sort(lArr);
            if (lArr.length == 1) {
                return lArr[0].longValue();
            }
            for (int i = 0; i <= lArr.length - 2; i++) {
                if (j > lArr[i].longValue() && j < lArr[i + 1].longValue()) {
                    return lArr[i].longValue();
                }
            }
            if (j > lArr[lArr.length - 1].longValue()) {
                return lArr[lArr.length - 1].longValue();
            }
        }
        String str2 = TAG;
        Log.e(str2, "getFirstFrameTimestamp: return an error result with timestamp: " + j);
        return 0;
    }

    public static ParallelDataZipper getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* access modifiers changed from: private */
    public int getStreamNumberByTimestamp(long j) {
        CaptureData captureData = this.mCaptureDataArray.get(Long.valueOf(getFirstFrameTimestamp(j)));
        if (captureData != null) {
            return captureData.getStreamNum();
        }
        String str = TAG;
        Log.e(str, "getStreamNumberByTimestamp: returned an error result with timestamp: " + j);
        return 0;
    }

    /* access modifiers changed from: private */
    public void tryToCallback(CaptureData.CaptureDataBean captureDataBean) {
        Integer valueOf = Integer.valueOf(captureDataBean.getResult().getSequenceId());
        long firstFrameTimestamp = getFirstFrameTimestamp(captureDataBean.getResult().getTimeStamp());
        CaptureData captureData = this.mCaptureDataArray.get(Long.valueOf(firstFrameTimestamp));
        if (captureData != null) {
            captureData.putCaptureDataBean(captureDataBean);
            if (captureData.isDataReady()) {
                DataListener dataListener = captureData.getDataListener();
                if (dataListener != null) {
                    if (!captureData.isAbandoned()) {
                        dataListener.onParallelDataAvailable(captureData);
                    } else {
                        dataListener.onParallelDataAbandoned(captureData);
                    }
                }
                this.mCaptureDataArray.remove(Long.valueOf(firstFrameTimestamp));
                return;
            }
            return;
        }
        String str = "No task found with sequenceId: " + valueOf + " timestamp: " + r1 + "|" + firstFrameTimestamp;
        Log.e(TAG, str, new RuntimeException(str));
        captureDataBean.close();
        if (Build.IS_DEBUGGABLE) {
            throw new RuntimeException(str);
        }
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public synchronized void join(final Image image, final int i) {
        if (!this.mWorkThread.isAlive() || this.mHandler == null) {
            throw new RuntimeException("Thread already die!");
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                long timestamp = image.getTimestamp();
                CaptureData.CaptureDataBean captureDataBean = (CaptureData.CaptureDataBean) ParallelDataZipper.this.mCaptureDataBeanArray.get(timestamp);
                if (captureDataBean == null) {
                    CaptureData.CaptureDataBean captureDataBean2 = new CaptureData.CaptureDataBean(ParallelDataZipper.this.getStreamNumberByTimestamp(timestamp));
                    ParallelDataZipper.this.mCaptureDataBeanArray.append(timestamp, captureDataBean2);
                    captureDataBean = captureDataBean2;
                }
                String access$100 = ParallelDataZipper.TAG;
                Log.d(access$100, "setImage: timestamp=" + timestamp + " streamNum=" + captureDataBean.getStreamNum());
                captureDataBean.setImage(image, i);
                if (captureDataBean.isDataReady()) {
                    ParallelDataZipper.this.mCaptureDataBeanArray.remove(timestamp);
                    ParallelDataZipper.this.tryToCallback(captureDataBean);
                }
            }
        });
    }

    public synchronized void join(@NonNull final ICustomCaptureResult iCustomCaptureResult, final boolean z) {
        if (!this.mWorkThread.isAlive() || this.mHandler == null) {
            throw new RuntimeException("Thread already die!");
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                long timeStamp = iCustomCaptureResult.getTimeStamp();
                int sequenceId = iCustomCaptureResult.getSequenceId();
                int access$300 = ParallelDataZipper.this.getStreamNumberByTimestamp(timeStamp);
                CaptureData.CaptureDataBean captureDataBean = (CaptureData.CaptureDataBean) ParallelDataZipper.this.mCaptureDataBeanArray.get(timeStamp);
                if (captureDataBean == null) {
                    captureDataBean = new CaptureData.CaptureDataBean(access$300);
                    ParallelDataZipper.this.mCaptureDataBeanArray.append(timeStamp, captureDataBean);
                }
                if (!(captureDataBean.getStreamNum() == access$300 || access$300 == 0)) {
                    String access$100 = ParallelDataZipper.TAG;
                    Log.d(access$100, "setResult: update stream number with: " + access$300);
                    captureDataBean.setStreamNum(access$300);
                }
                captureDataBean.setCaptureResult(iCustomCaptureResult, z);
                String access$1002 = ParallelDataZipper.TAG;
                Log.d(access$1002, "setResult: timestamp=" + timeStamp + " sequenceId=" + sequenceId + " streamNum=" + captureDataBean.getStreamNum() + " isFirst=" + z);
                if (captureDataBean.isDataReady()) {
                    ParallelDataZipper.this.mCaptureDataBeanArray.remove(timeStamp);
                    ParallelDataZipper.this.tryToCallback(captureDataBean);
                }
            }
        });
    }

    public synchronized void startTask(@NonNull final CaptureData captureData) {
        if (!this.mWorkThread.isAlive() || this.mHandler == null) {
            throw new RuntimeException("Thread already die!");
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                String access$100 = ParallelDataZipper.TAG;
                Log.d(access$100, "startTask: " + captureData);
                ParallelDataZipper.this.mCaptureDataArray.put(Long.valueOf(captureData.getCaptureTimestamp()), captureData);
            }
        });
    }
}
