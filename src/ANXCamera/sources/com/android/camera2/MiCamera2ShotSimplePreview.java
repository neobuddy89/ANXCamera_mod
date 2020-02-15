package com.android.camera2;

import android.graphics.Bitmap;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.location.Location;
import android.media.Image;
import android.net.Uri;
import com.android.camera.EncodingQuality;
import com.android.camera.LocationManager;
import com.android.camera.SurfaceTextureScreenNail;
import com.android.camera.Util;
import com.android.camera.log.Log;
import com.android.camera.storage.ImageSaver;
import com.android.camera2.Camera2Proxy;
import com.android.gallery3d.exif.ExifInterface;
import com.xiaomi.camera.core.PictureInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class MiCamera2ShotSimplePreview extends MiCamera2Shot<byte[]> implements SurfaceTextureScreenNail.PreviewSaveListener {
    private static final String TAG = "MiCamera2ShotSimplePreview";

    public MiCamera2ShotSimplePreview(MiCamera2 miCamera2) {
        super(miCamera2);
    }

    /* access modifiers changed from: protected */
    public CameraCaptureSession.CaptureCallback generateCaptureCallback() {
        return null;
    }

    /* access modifiers changed from: protected */
    public CaptureRequest.Builder generateRequestBuilder() throws CameraAccessException, IllegalStateException {
        return null;
    }

    /* access modifiers changed from: protected */
    public void notifyResultData(byte[] bArr) {
    }

    /* access modifiers changed from: protected */
    public void onImageReceived(Image image, int i) {
    }

    /* access modifiers changed from: protected */
    public void prepare() {
    }

    public void save(byte[] bArr, int i, int i2, int i3, ImageSaver imageSaver) {
        byte[] bArr2;
        int i4 = i;
        int i5 = i2;
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
        byte[] bitmapData = Util.getBitmapData(createBitmap, EncodingQuality.NORMAL.toInteger(false));
        long currentTimeMillis = System.currentTimeMillis();
        Location currentLocation = LocationManager.instance().getCurrentLocation();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ExifInterface exifInterface = new ExifInterface();
        try {
            exifInterface.readExif(bitmapData);
            try {
                exifInterface.addParallelProcessComment("None", i3, i4, i5);
                exifInterface.removeParallelProcessComment();
                exifInterface.writeExif(bitmapData, (OutputStream) byteArrayOutputStream);
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            int i6 = i3;
            Log.e(TAG, "updateExif error", (Throwable) e);
            bArr2 = bitmapData;
            imageSaver.addImage(bArr2, true, Util.createJpegName(currentTimeMillis), (String) null, System.currentTimeMillis(), (Uri) null, currentLocation, i, i2, (ExifInterface) null, i3, false, false, true, false, false, (String) null, (PictureInfo) null, -1, (CaptureResult) null);
        }
        imageSaver.addImage(bArr2, true, Util.createJpegName(currentTimeMillis), (String) null, System.currentTimeMillis(), (Uri) null, currentLocation, i, i2, (ExifInterface) null, i3, false, false, true, false, false, (String) null, (PictureInfo) null, -1, (CaptureResult) null);
    }

    /* access modifiers changed from: protected */
    public void startSessionCapture() {
        Camera2Proxy.PictureCallback pictureCallback = getPictureCallback();
        if (pictureCallback != null) {
            pictureCallback.onCaptureShutter(true);
        } else {
            Log.w(TAG, "startSessionCapture: null picture callback");
        }
    }
}
