package com.arcsoft.camera.wideselfie;

public class AwsInitParameter {

    /* renamed from: a  reason: collision with root package name */
    private int f200a;

    /* renamed from: b  reason: collision with root package name */
    private int f201b;

    /* renamed from: c  reason: collision with root package name */
    private int f202c;
    public float cameraViewAngleForHeight;
    public float cameraViewAngleForWidth;
    public int changeDirectionThumbThreshold;
    public boolean convertNV21;

    /* renamed from: d  reason: collision with root package name */
    private int f203d;

    /* renamed from: e  reason: collision with root package name */
    private int f204e;

    /* renamed from: f  reason: collision with root package name */
    private int f205f;
    public int guideStableBarThumbHeight;
    public int guideStopBarThumbHeight;
    public int maxResultWidth;
    public int mode;
    public int progressBarThumbHeight;
    public float progressBarThumbHeightCropRatio;
    public float resultAngleForHeight;
    public float resultAngleForWidth;
    public int thumbnailHeight;
    public int thumbnailWidth;

    private AwsInitParameter() {
    }

    public static AwsInitParameter getDefaultInitParams(int i, int i2, int i3, int i4) {
        AwsInitParameter awsInitParameter = new AwsInitParameter();
        awsInitParameter.f200a = 0;
        awsInitParameter.mode = 64;
        awsInitParameter.cameraViewAngleForHeight = 42.9829f;
        awsInitParameter.cameraViewAngleForWidth = 55.3014f;
        awsInitParameter.resultAngleForWidth = 180.0f;
        awsInitParameter.resultAngleForHeight = 180.0f;
        awsInitParameter.changeDirectionThumbThreshold = 120;
        awsInitParameter.f201b = i3;
        awsInitParameter.f202c = i;
        awsInitParameter.f203d = i2;
        awsInitParameter.f204e = awsInitParameter.f201b;
        awsInitParameter.thumbnailWidth = awsInitParameter.f202c;
        awsInitParameter.thumbnailHeight = awsInitParameter.f203d;
        awsInitParameter.f205f = i4;
        awsInitParameter.guideStopBarThumbHeight = 0;
        awsInitParameter.maxResultWidth = 0;
        awsInitParameter.progressBarThumbHeight = 0;
        awsInitParameter.guideStableBarThumbHeight = 5;
        awsInitParameter.progressBarThumbHeightCropRatio = 0.0f;
        awsInitParameter.convertNV21 = false;
        return awsInitParameter;
    }

    public int getBufferSize() {
        return this.f200a;
    }

    public int getDeviceOrientation() {
        return this.f205f;
    }

    public int getFullImageHeight() {
        return this.f203d;
    }

    public int getFullImageWidth() {
        return this.f202c;
    }

    public int getSrcFormat() {
        return this.f201b;
    }

    public int getThumbForamt() {
        return this.f204e;
    }

    public int getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    public int getThumbnailWidth() {
        return this.thumbnailWidth;
    }
}
