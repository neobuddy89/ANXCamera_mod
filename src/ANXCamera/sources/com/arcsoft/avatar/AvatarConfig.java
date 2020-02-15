package com.arcsoft.avatar;

import android.graphics.Bitmap;
import com.arcsoft.avatar.util.LOG;
import java.io.Serializable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public interface AvatarConfig {

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ASAvatarConfigComponentType {
        public static final int BEARD_COLOR = 17;
        public static final int BEARD_STYLE = 16;
        public static final int CUSTOM_EXPRESSION = 32;
        public static final int EARRING_STYLE = 18;
        public static final int EAR_SHAPE = 29;
        public static final int EYEBROW_COLOR = 20;
        public static final int EYEBROW_SHAPE = 30;
        public static final int EYELASH_STYLE = 19;
        public static final int EYEWEAR_FRAME = 10;
        public static final int EYEWEAR_LENSES = 11;
        public static final int EYEWEAR_STYLE = 9;
        public static final int EYE_COLOR = 4;
        public static final int EYE_SHAPE = 22;
        public static final int FACE_COLOR = 3;
        public static final int FACE_SHAPE = 21;
        public static final int FRECKLES = 7;
        public static final int GENDER = 31;
        public static final int HAIR_COLOR = 2;
        public static final int HAIR_HIGHLIGHT_COLOR = 6;
        public static final int HAIR_STYLE = 1;
        public static final int HAT_COLOR = 15;
        public static final int HAT_STYLE = 14;
        public static final int HEADWEAR_COLOR = 13;
        public static final int HEADWEAR_STYLE = 12;
        public static final int LIP_COLOR = 5;
        public static final int MOUTH_HSHAPE = 25;
        public static final int MOUTH_SHAPE = 23;
        public static final int MOUTH_WSHAPE = 24;
        public static final int NEVUS = 8;
        public static final int NONE = 0;
        public static final int NOSE_HSHAPE = 28;
        public static final int NOSE_SHAPE = 26;
        public static final int NOSE_WSHAPE = 27;
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ASAvatarConfigGenderType {
        public static final int FEMALE = 2;
        public static final int MALE = 1;
        public static final int UNKNOWN = 0;
    }

    public static class ASAvatarConfigInfo {
        public int configID;
        public String configThumbPath;
        public int configType;
        public float continuousValue;
        public int endColorValue;
        public int gender;
        public boolean isDefault;
        public boolean isSupportContinuous;
        public boolean isValid;
        public String name;
        public int startColorValue;
        public Bitmap thum;

        public String toString() {
            return "configID = " + this.configID + " configType = " + this.configType + " gender = " + this.gender + " name = " + this.name + " configThumbPath = " + this.configThumbPath + " isDefault = " + this.isDefault + " isValid = " + this.isValid + " isSupportContinuous = " + this.isSupportContinuous + " continuousValue = " + this.continuousValue + " startColorValue = " + this.startColorValue + " endColorValue = " + this.endColorValue + "thum = " + this.thum + "\n";
        }
    }

    public static class ASAvatarConfigType {
        public int configType;
        public String configTypeDesc;
        public boolean refreshThum = true;

        public String toString() {
            return "configTypeDesc = " + this.configTypeDesc + " configType = " + this.configType + " refreshThum = " + this.refreshThum;
        }
    }

    public static class ASAvatarConfigValue implements Cloneable {
        public int configBeardColorID;
        public float configBeardColorValue;
        public int configBeardStyleID;
        public int configEarShapeID;
        public float configEarShapeValue;
        public int configEarringStyleID;
        public int configEyeColorID;
        public float configEyeColorValue;
        public int configEyeShapeID;
        public float configEyeShapeValue;
        public int configEyebrowColorID;
        public float configEyebrowColorValue;
        public int configEyebrowShapeID;
        public float configEyebrowShapeValue;
        public int configEyelashStyleID;
        public int configEyewearFrameID;
        public float configEyewearFrameValue;
        public int configEyewearLensesID;
        public float configEyewearLensesValue;
        public int configEyewearStyleID;
        public int configFaceColorID;
        public float configFaceColorValue;
        public int configFaceShapeID;
        public float configFaceShapeValue;
        public int configFrecklesID;
        public int configGenderID;
        public int configHairColorID;
        public float configHairColorValue;
        public int configHairHighlightColorID;
        public float configHairHighlightColorValue;
        public int configHairStyleID;
        public int configHatColorID;
        public float configHatColorValue;
        public int configHatStyleID;
        public int configHeadwearColorID;
        public float configHeadwearColorValue;
        public int configHeadwearStyleID;
        public int configLipColorID;
        public float configLipColorValue;
        public int configMouthShapeID;
        public float configMouthShapeValue;
        public int configNevusID;
        public int configNoseShapeID;
        public float configNoseShapeValue;
        public int config_CustomExpression_ID;
        public int gender;

        public Object clone() {
            try {
                return (ASAvatarConfigValue) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public String toString() {
            return "gender = " + this.gender + " hairStyleID = " + this.configHairStyleID + " hairColorID = " + this.configHairColorID + " hairColorValue = " + this.configHairColorValue + " faceColorID = " + this.configFaceColorID + " faceColorValue = " + this.configFaceColorValue + " eyeColorID = " + this.configEyeColorID + " eyeColorValue = " + this.configEyeColorValue + " lipColorID = " + this.configLipColorID + " lipColorValue = " + this.configLipColorValue + " hairHighlightColorID = " + this.configHairHighlightColorID + " hairHighlightColorValue = " + this.configHairHighlightColorValue + " frecklesID = " + this.configFrecklesID + " nevusID = " + this.configNevusID + " eyewearStyleID = " + this.configEyewearStyleID + " eyewearFrameID = " + this.configEyewearFrameID + " eyewearFrameValue = " + this.configEyewearFrameValue + " eyewearLensesID = " + this.configEyewearLensesID + " eyewearLensesValue = " + this.configEyewearLensesValue + " headwearStyleID = " + this.configHeadwearStyleID + " headwearColorID = " + this.configHeadwearColorID + " headwearColorValue = " + this.configHeadwearColorValue + " hatStyleID = " + this.configHatStyleID + " hatColorID = " + this.configHatColorID + " hatColorValue = " + this.configHatColorValue + " beardStyleID = " + this.configBeardStyleID + " beardColorID = " + this.configBeardColorID + " beardColorValue = " + this.configBeardColorValue + " earringStyleID = " + this.configEarringStyleID + " eyelashStyleID = " + this.configEyelashStyleID + " eyebrowColorID = " + this.configEyebrowColorID + " eyebrowColorValue = " + this.configEyebrowColorValue + " faceShapeID = " + this.configFaceShapeID + " faceShapeValue = " + this.configFaceShapeValue + " eyeShapeID = " + this.configEyeShapeID + " eyeShapeValue = " + this.configEyeShapeValue + " mouthShapeID = " + this.configMouthShapeID + " mouthShapeValue = " + this.configMouthShapeValue + " noseShapeID = " + this.configNoseShapeID + " noseShapeValue = " + this.configNoseShapeValue + " earShapeID = " + this.configEarShapeID + " earShapeValue = " + this.configEarShapeValue + " eyebrowShapeID = " + this.configEyebrowShapeID + " eyebrowShapeValue = " + this.configEyebrowShapeValue + "\n";
        }
    }

    public interface ASAvatarOutLineStatusCode {
        public static final int STATUS_FACE_BEYOND_20_DEGREES = 9;
        public static final int STATUS_FACE_OCCLUSION = 6;
        public static final int STATUS_FACE_TOO_BIG = 7;
        public static final int STATUS_FACE_TOO_SMALL = 8;
        public static final int STATUS_LEFT_EYES_OCCLUSION = 2;
        public static final int STATUS_MOUTH_OCCLUSION = 4;
        public static final int STATUS_MULTIPLE_FACES = 10;
        public static final int STATUS_NORMAL = 0;
        public static final int STATUS_NOSE_OCCLUSION = 5;
        public static final int STATUS_NO_FACE = 1;
        public static final int STATUS_RIGHT_EYES_OCCLUSION = 3;
    }

    public static class ASAvatarProcessInfo {
        private static final float F_THRESHOLD = 0.5f;
        private static final int Max_Express_Num = 69;
        private static final int Max_Outline_Num = 154;
        private static final float OUTLINE_THRESHOLD_VALUE = 0.8f;
        private float[] expWeights;
        private ASRect face;
        private int faceCount;
        private float[] faceOrientations;
        private boolean isMirror;
        private int orientation;
        private float[] orientationLeftEyes;
        private float[] orientationRightEyes;
        private float[] orientations;
        private ASPointF[] outlines = new ASPointF[154];
        private int processHeight;
        private int processWidth;
        private int result;
        private float[] shelterFlags;
        private float zoomInScale;

        public boolean checkFaceBlocking() {
            float f2;
            float f3;
            float f4;
            float f5 = 0.0f;
            int i = 0;
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            float f10 = 0.0f;
            float f11 = 0.0f;
            float f12 = 0.0f;
            float f13 = 0.0f;
            while (true) {
                float[] fArr = this.shelterFlags;
                if (i >= fArr.length) {
                    break;
                }
                if (i >= 0 && i <= 18) {
                    f10 += fArr[i];
                } else if (i >= 19 && i <= 36) {
                    f11 += this.shelterFlags[i];
                } else if (i >= 37 && i <= 46) {
                    f12 += this.shelterFlags[i];
                } else if (i >= 47 && i <= 56) {
                    f13 += this.shelterFlags[i];
                } else if (i >= 57 && i <= 68) {
                    f6 += this.shelterFlags[i];
                } else if (i >= 69 && i <= 80) {
                    f7 += this.shelterFlags[i];
                } else if (i >= 81 && i <= 92) {
                    f8 += this.shelterFlags[i];
                } else if (i >= 93 && i <= 112) {
                    f9 += this.shelterFlags[i];
                }
                i++;
            }
            for (int i2 = 7; i2 <= 29; i2++) {
                f5 += this.shelterFlags[i2];
            }
            float f14 = f10 / 19.0f;
            float f15 = f11 / 18.0f;
            float f16 = f12 / 10.0f;
            float f17 = f13 / 10.0f;
            float f18 = f6 / 12.0f;
            float f19 = f7 / 12.0f;
            LOG.d("CheckOutLine", "leftFace = " + f14);
            LOG.d("CheckOutLine", "rightFace = " + f15);
            LOG.d("CheckOutLine", "leftEyeBrow = " + f16);
            LOG.d("CheckOutLine", "rightEyeBrow = " + f17);
            LOG.d("CheckOutLine", "leftEye = " + f18);
            LOG.d("CheckOutLine", "rightEye = " + f19);
            LOG.d("CheckOutLine", "nose = " + f2);
            LOG.d("CheckOutLine", "mouth = " + f3);
            LOG.d("CheckOutLine", "chin = " + f4);
            if (f14 > 0.5f && f16 > 0.5f && f18 > 0.5f) {
                LOG.d("CheckOutLine", "--- > left is blocking <---");
                return true;
            } else if (f15 > 0.5f && f17 > 0.5f && f19 > 0.5f) {
                LOG.d("CheckOutLine", "--- > right is blocking <---");
                return true;
            } else if (f16 <= 0.4f || f17 <= 0.4f || f19 <= 0.4f || f18 <= 0.4f) {
                int i3 = (f4 > 0.4f ? 1 : (f4 == 0.4f ? 0 : -1));
                if (i3 > 0 && f3 > 0.4f && f2 > 0.4f) {
                    LOG.d("CheckOutLine", "--- > central is blocking <---");
                    return true;
                } else if (f14 <= 0.4f || f15 <= 0.4f || i3 <= 0) {
                    return false;
                } else {
                    LOG.d("CheckOutLine", "--- > left & right is blocking <---");
                    return true;
                }
            } else {
                LOG.d("CheckOutLine", "--- > top is blocking <---");
                return true;
            }
        }

        public int checkOutLineInfo() {
            float f2;
            int i;
            float[] fArr = this.faceOrientations;
            float f3 = fArr[0];
            float f4 = fArr[1];
            int i2 = 2;
            float f5 = fArr[2];
            if (((f3 < -110.0f || f3 > -70.0f) && ((f3 < -20.0f || f3 > 20.0f) && ((f3 < 160.0f || f3 > 180.0f) && ((f3 < -180.0f || f3 > -160.0f) && (f3 < 70.0f || f3 > 110.0f))))) || -20.0f > f4 || f4 > 20.0f || -20.0f > f5 || f5 > 20.0f) {
                return 9;
            }
            float f6 = 0.0f;
            float f7 = 0.0f;
            for (int i3 = 0; i3 <= 36; i3++) {
                f7 += this.shelterFlags[i3];
            }
            LOG.d("CheckOutLine", "fFaceValue = " + f2);
            if (f2 > OUTLINE_THRESHOLD_VALUE) {
                return 6;
            }
            float f8 = 0.0f;
            for (int i4 = 69; i4 <= 80; i4++) {
                f8 += this.shelterFlags[i4];
            }
            float f9 = f8 / 12.0f;
            LOG.d("CheckOutLine", "fLeftEyeValue = " + f9);
            float f10 = 0.0f;
            for (int i5 = 57; i5 <= 68; i5++) {
                f10 += this.shelterFlags[i5];
            }
            float f11 = f10 / 12.0f;
            LOG.d("CheckOutLine", "fRightEyeValue = " + f11);
            if (f11 > f9) {
                i2 = 3;
            } else {
                f11 = f9;
            }
            float f12 = 0.0f;
            for (int i6 = 93; i6 <= 112; i6++) {
                f12 += this.shelterFlags[i6];
            }
            float f13 = f12 / 20.0f;
            LOG.d("CheckOutLine", "fMouthEyeValue = " + f13);
            if (f13 > f11) {
                i2 = 4;
                f11 = f13;
            }
            for (int i7 = 81; i7 <= 119; i7++) {
                f6 += this.shelterFlags[i7];
            }
            float f14 = f6 / 39.0f;
            LOG.d("CheckOutLine", "fNOSEEyeValue = " + f14);
            if (f14 > f11) {
                i = 5;
            } else {
                f14 = f11;
                i = i2;
            }
            LOG.d("CheckOutLine", "fMax = " + f14 + " res = " + i);
            if (f14 > OUTLINE_THRESHOLD_VALUE) {
                return i;
            }
            return 0;
        }

        public int getFaceCount() {
            return this.faceCount;
        }

        public void setEmpty() {
            this.processHeight = 0;
            this.processWidth = 0;
            this.orientation = 0;
            this.isMirror = false;
            this.faceCount = 0;
            for (ASPointF aSPointF : this.outlines) {
                aSPointF.x = 0.0f;
                aSPointF.y = 0.0f;
            }
            ASRect aSRect = this.face;
            aSRect.bottom = 0;
            aSRect.right = 0;
            aSRect.top = 0;
            aSRect.left = 0;
            Arrays.fill(this.faceOrientations, 0.0f);
            this.result = 0;
            Arrays.fill(this.orientations, 0.0f);
            Arrays.fill(this.orientationLeftEyes, 0.0f);
            Arrays.fill(this.orientationRightEyes, 0.0f);
            Arrays.fill(this.expWeights, 0.0f);
            this.zoomInScale = 0.0f;
        }

        public boolean shelterIsNull() {
            return this.shelterFlags == null;
        }
    }

    public static class ASAvatarProfileInfo implements Serializable {
        private int eyeShape;
        private int faceShape;
        private int gender;
        private int glassType;
        private byte[] hairColor;
        private int hairType;
        private int hasFringe;
        private int mouthShape;
        private int noseShape;
        private byte[] skinColor;
        private int skinColorScale;

        public String getHairType() {
            String str;
            switch (this.hairType) {
                case 0:
                    str = "光寸头";
                    break;
                case 1:
                    str = "直短发";
                    break;
                case 2:
                    str = "卷短发";
                    break;
                case 3:
                    str = "丸子马尾";
                    break;
                case 4:
                    str = "哪吒头";
                    break;
                case 5:
                    str = "直中短发";
                    break;
                case 6:
                    str = "卷中短发";
                    break;
                case 7:
                    str = "直中发";
                    break;
                case 8:
                    str = "卷中发";
                    break;
                case 9:
                    str = "直长发";
                    break;
                case 10:
                    str = "卷长发";
                    break;
                case 11:
                    str = "双马尾";
                    break;
                case 12:
                    str = "双麻花辫";
                    break;
                default:
                    str = "unknow";
                    break;
            }
            return "Hair Type = " + str;
        }

        public String getHasFringe() {
            return this.hasFringe == 0 ? "无" : "有";
        }

        public String toString() {
            return "gender = " + this.gender + "\nfaceShape = " + this.faceShape + "\neyeShape = " + this.eyeShape + "\nmouthShape = " + this.mouthShape + "\nnoseShape = " + this.noseShape + "\nhairType = " + this.hairType + "\nhasFringe = " + this.hasFringe + "\nhairColor = " + Arrays.toString(this.hairColor) + "\nskinColor = " + Arrays.toString(this.skinColor) + "\nskinColorScale = " + this.skinColorScale + "\nglassType = " + this.glassType;
        }
    }

    public static class ASAvatarProfileResult implements Serializable {
        public int gender;
        public int status;
    }

    public interface ASAvatarProfileStatusCode {
        public static final int STATUS_FAILED_NOFACE = 1;
        public static final int STATUS_SUCCESS_FACESHAPE = 128;
        public static final int STATUS_SUCCESS_FACIAL = 2;
        public static final int STATUS_SUCCESS_GENDER = 16;
        public static final int STATUS_SUCCESS_GLASS = 64;
        public static final int STATUS_SUCCESS_HAIRCOLOR = 8;
        public static final int STATUS_SUCCESS_HAIRSTYLE = 4;
        public static final int STATUS_SUCCESS_SKINCOLOR = 32;
        public static final int STATUS_UNKNOWN = 0;
    }

    public static class ASPointF {
        public float x;
        public float y;
    }

    public static class ASRect {
        public int bottom;
        public int left;
        public int right;
        public int top;
    }

    public interface GetConfigCallback {
        void onGetConfig(int i, int i2, int i3, int i4, String str, String str2, int i5, int i6, boolean z, boolean z2, boolean z3, float f2);
    }

    public interface GetSupportConfigTypeCallback {
        void onGetSupportConfigType(String str, int i);
    }

    public interface UpdateProgressCallback {
        void onUpdateProgress(int i);
    }
}
