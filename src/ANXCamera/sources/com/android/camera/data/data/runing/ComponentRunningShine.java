package com.android.camera.data.data.runing;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import com.android.camera.CameraSettings;
import com.android.camera.R;
import com.android.camera.data.DataRepository;
import com.android.camera.data.data.ComponentData;
import com.android.camera.data.data.ComponentDataItem;
import com.android.camera.effect.EffectController;
import com.android.camera.effect.FilterInfo;
import com.android.camera.fragment.beauty.BeautyValues;
import com.android.camera.log.Log;
import com.android.camera.statistic.MistatsConstants;
import com.android.camera2.CameraCapabilities;
import com.mi.config.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ComponentRunningShine extends ComponentData {
    public static final int ENTRY_NONE = -1;
    public static final int ENTRY_POPUP_BEAUTY = 5;
    public static final int ENTRY_POPUP_SHINE = 4;
    public static final int ENTRY_TOP_BEAUTY = 2;
    public static final int ENTRY_TOP_FILTER = 3;
    public static final int ENTRY_TOP_SHINE = 1;
    public static final int FILTER_NATIVE_NONE_ID = 0;
    public static final String SHINE_BEAUTY_LEVEL_SMOOTH = "2";
    public static final String SHINE_BEAUTY_LEVEL_SWITCH = "1";
    public static final String SHINE_EYE_LIGHT = "9";
    public static final String SHINE_FIGURE = "6";
    public static final String SHINE_FILTER = "7";
    public static final String SHINE_LIGHTING = "8";
    public static final String SHINE_LIVE_BEAUTY = "11";
    public static final String SHINE_LIVE_FILTER = "10";
    public static final String SHINE_LIVE_SPEED = "13";
    public static final String SHINE_LIVE_STICKER = "12";
    public static final String SHINE_MAKEUP = "5";
    public static final String SHINE_MODEL_ADVANCE = "3";
    public static final String SHINE_MODEL_REMODELING = "4";
    public static final String SHINE_VIDEO_BOKEH_LEVEL = "14";
    private static final String TAG = "ComponentRunningShine";
    private BeautyValues mBeautyValues;
    private int mBeautyVersion;
    private boolean mCurrentStatus;
    private String mCurrentTipType;
    @ShineType
    private String mCurrentType;
    @ShineType
    private String mDefaultType;
    private boolean mIsClosed;
    private HashMap<String, Boolean> mIsVideoBeautySwitchedOnMap = new HashMap<>();
    @ShineEntry
    private int mShineEntry;
    private boolean mSupportBeautyBody;
    private boolean mSupportBeautyLevel;
    private boolean mSupportBeautyMakeUp;
    private boolean mSupportBeautyModel;
    private boolean mSupportColorRententionBack;
    private boolean mSupportColorRententionFront;
    private boolean mSupportSmoothLevel;
    private boolean mSupportVideoBokehLevel;
    private boolean mSupportVideoFilter;
    private TypeElementsBeauty mTypeElementsBeauty = new TypeElementsBeauty(this);

    public @interface ShineEntry {
    }

    public @interface ShineType {
    }

    public ComponentRunningShine(DataItemRunning dataItemRunning) {
        super(dataItemRunning);
    }

    private ComponentDataItem generateBeautyLevelItem(boolean z) {
        return b.Fk() ? new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, (int) R.string.beauty_fragment_tab_name_3d_beauty, "1") : new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, (int) R.string.beauty_fragment_tab_name_beauty, "1");
    }

    private ComponentDataItem generateFigureItem() {
        return new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, isSmoothDependBeautyVersion() ? R.string.beauty_fragment_tab_name_3d_beauty : R.string.beauty_body, "6");
    }

    private ComponentDataItem generateFilterItem() {
        return new ComponentDataItem((int) R.drawable.ic_new_effect_button_normal, (int) R.drawable.ic_new_effect_button_selected, (int) R.string.pref_camera_coloreffect_title, "7");
    }

    private ComponentDataItem generateMakeupItem() {
        return new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, (int) R.string.beauty_fragment_tab_name_3d_makeup, "5");
    }

    private ComponentDataItem generateModelItem() {
        if (!b.Fk()) {
            return new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, (int) R.string.beauty_fragment_tab_name_makeup, "3");
        }
        return new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, isSmoothDependBeautyVersion() ? R.string.beauty_fragment_tab_name_3d_beauty : R.string.beauty_fragment_tab_name_3d_remodeling, "4");
    }

    private ComponentDataItem generateSmoothLevelItem(boolean z) {
        return new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, (int) R.string.beauty_fragment_tab_name_3d_beauty, "2");
    }

    private ComponentDataItem generateVideoBokeh() {
        return new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, (int) R.string.fragment_tab_name_bokeh, SHINE_VIDEO_BOKEH_LEVEL);
    }

    public boolean SupportVideoFilter() {
        return this.mSupportVideoFilter;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00dc A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0036 A[SYNTHETIC] */
    public boolean determineStatus(int i) {
        char c2;
        if (this.mBeautyValues == null) {
            this.mBeautyValues = new BeautyValues();
        }
        boolean z = false;
        if (isClosed()) {
            this.mCurrentStatus = false;
        } else if (isSmoothBarVideoBeautyVersion(i)) {
            this.mCurrentStatus = DataRepository.dataItemRunning().getComponentRunningShine().isVideoBeautyOpen(i);
            return this.mCurrentStatus;
        } else {
            Iterator<ComponentDataItem> it = this.mItems.iterator();
            Boolean bool = null;
            Boolean bool2 = null;
            Boolean bool3 = null;
            while (true) {
                boolean z2 = true;
                if (it.hasNext()) {
                    ComponentDataItem next = it.next();
                    if (next != null) {
                        String str = next.mValue;
                        int hashCode = str.hashCode();
                        if (hashCode == 1567) {
                            if (str.equals("10")) {
                                c2 = 8;
                                switch (c2) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        break;
                                    case 7:
                                        break;
                                    case 8:
                                        break;
                                    case 9:
                                        break;
                                }
                            }
                        } else if (hashCode == 1568) {
                            if (str.equals(SHINE_LIVE_BEAUTY)) {
                                c2 = 6;
                                switch (c2) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        break;
                                    case 7:
                                        break;
                                    case 8:
                                        break;
                                    case 9:
                                        break;
                                }
                            }
                        } else if (hashCode == 1571) {
                            if (str.equals(SHINE_VIDEO_BOKEH_LEVEL)) {
                                c2 = 9;
                                switch (c2) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                        if (bool != null) {
                                            break;
                                        } else {
                                            bool = Boolean.valueOf(CameraSettings.isFaceBeautyOn(i, this.mBeautyValues));
                                            break;
                                        }
                                    case 5:
                                        if (bool != null) {
                                            break;
                                        } else {
                                            bool = Boolean.valueOf(CameraSettings.isFaceBeautyOn(i, this.mBeautyValues));
                                            break;
                                        }
                                    case 6:
                                        if (bool == null) {
                                            if (i != 183) {
                                                bool = Boolean.valueOf(CameraSettings.isLiveBeautyOpen());
                                                break;
                                            } else {
                                                if (!CameraSettings.isMiLiveBeautyOpen() && !EffectController.getInstance().isEffectPageSelected()) {
                                                    z2 = false;
                                                }
                                                bool = Boolean.valueOf(z2);
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    case 7:
                                        if (bool2 != null) {
                                            break;
                                        } else {
                                            int shaderEffect = CameraSettings.getShaderEffect();
                                            if (shaderEffect != FilterInfo.FILTER_ID_NONE && shaderEffect > 0) {
                                                bool2 = true;
                                                break;
                                            }
                                        }
                                    case 8:
                                        if (bool2 == null && DataRepository.dataItemLive().getLiveFilter() != 0) {
                                            bool2 = true;
                                            break;
                                        }
                                    case 9:
                                        if (bool3 == null && CameraSettings.getVideoBokehRatio() != 0.0f) {
                                            bool3 = true;
                                            break;
                                        }
                                }
                            }
                        } else {
                            switch (hashCode) {
                                case 49:
                                    if (str.equals("1")) {
                                        c2 = 0;
                                        break;
                                    }
                                case 50:
                                    if (str.equals("2")) {
                                        c2 = 5;
                                        break;
                                    }
                                case 51:
                                    if (str.equals("3")) {
                                        c2 = 1;
                                        break;
                                    }
                                case 52:
                                    if (str.equals("4")) {
                                        c2 = 2;
                                        break;
                                    }
                                case 53:
                                    if (str.equals("5")) {
                                        c2 = 3;
                                        break;
                                    }
                                case 54:
                                    if (str.equals("6")) {
                                        c2 = 4;
                                        break;
                                    }
                                case 55:
                                    if (str.equals("7")) {
                                        c2 = 7;
                                        break;
                                    }
                            }
                        }
                        c2 = 65535;
                        switch (c2) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                break;
                            case 9:
                                break;
                        }
                    }
                } else {
                    if ((bool != null && bool.booleanValue()) || ((bool2 != null && bool2.booleanValue()) || (bool3 != null && bool3.booleanValue()))) {
                        z = true;
                    }
                    this.mCurrentStatus = z;
                }
            }
        }
        return this.mCurrentStatus;
    }

    public int getBeautyVersion() {
        return this.mBeautyVersion;
    }

    @DrawableRes
    public int getBottomEntryRes(int i) {
        this.mCurrentStatus = determineStatus(i);
        int i2 = this.mShineEntry;
        return i2 != 4 ? i2 != 5 ? R.drawable.ic_shine_off : this.mCurrentStatus ? R.drawable.ic_beauty_on : R.drawable.ic_beauty_off : this.mCurrentStatus ? R.drawable.ic_beauty_tips_on : R.drawable.ic_beauty_tips_normal;
    }

    public boolean getCurrentStatus() {
        return this.mCurrentStatus;
    }

    public String getCurrentTipType() {
        return this.mCurrentTipType;
    }

    @ShineType
    public String getCurrentType() {
        return this.mCurrentType;
    }

    @NonNull
    public String getDefaultValue(int i) {
        return this.mDefaultType;
    }

    public int getDisplayTitleString() {
        return 0;
    }

    public List<ComponentDataItem> getItems() {
        return this.mItems;
    }

    public String getKey(int i) {
        return null;
    }

    @DrawableRes
    public int getTopConfigEntryRes(int i) {
        this.mCurrentStatus = determineStatus(i);
        int i2 = this.mShineEntry;
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? R.drawable.ic_shine_off : this.mCurrentStatus ? R.drawable.ic_new_effect_button_selected : R.drawable.ic_new_effect_button_normal : this.mCurrentStatus ? R.drawable.ic_beauty_on : R.drawable.ic_beauty_off : this.mCurrentStatus ? R.drawable.ic_shine_on : R.drawable.ic_shine_off;
    }

    public int getTopConfigItem() {
        int i = this.mShineEntry;
        if (i == 1 || i == 2 || i == 3) {
            return 212;
        }
        throw new RuntimeException("unknown Shine" + this.mShineEntry);
    }

    public TypeElementsBeauty getTypeElementsBeauty() {
        return this.mTypeElementsBeauty;
    }

    public boolean isClosed() {
        return this.mIsClosed;
    }

    public boolean isLegacyBeautyVersion() {
        return this.mBeautyVersion == 1;
    }

    public boolean isSmoothBarVideoBeautyVersion(int i) {
        if (i == 162 && this.mSupportSmoothLevel) {
            return true;
        }
        if (i != 169 || !this.mSupportSmoothLevel) {
            return i == 180 && this.mSupportVideoFilter;
        }
        return true;
    }

    public boolean isSmoothDependBeautyVersion() {
        return this.mBeautyVersion == 3;
    }

    public boolean isTopBeautyEntry() {
        return this.mShineEntry == 2;
    }

    public boolean isTopShineEntry() {
        return this.mShineEntry == 1;
    }

    public boolean isVideoBeautyOpen(int i) {
        String str = CameraSettings.isFrontCamera() ? "front" : MistatsConstants.BaseEvent.BACK;
        return i != 162 ? i == 180 && CameraSettings.getShaderEffect() != 0 : this.mIsVideoBeautySwitchedOnMap.getOrDefault(i + str, Boolean.FALSE).booleanValue();
    }

    public void reInit() {
        if (this.mItems == null) {
            this.mItems = new CopyOnWriteArrayList();
        } else {
            this.mItems.clear();
        }
    }

    public void reInit(int i, int i2, CameraCapabilities cameraCapabilities) {
        boolean isSupportVideoFilter;
        boolean isSupportVideoBokehAdjust;
        int i3 = i2;
        reInit();
        this.mBeautyVersion = cameraCapabilities.getBeautyVersion();
        boolean z = true;
        if (this.mBeautyVersion < 0) {
            if (b.Fk()) {
                this.mBeautyVersion = 2;
            } else {
                this.mBeautyVersion = 1;
            }
        }
        this.mShineEntry = -1;
        this.mDefaultType = null;
        this.mSupportBeautyLevel = false;
        this.mSupportSmoothLevel = false;
        this.mSupportBeautyModel = false;
        this.mSupportBeautyMakeUp = false;
        this.mSupportBeautyBody = false;
        switch (i) {
            case 161:
                if (!cameraCapabilities.isSupportVideoBeauty()) {
                    this.mShineEntry = 3;
                    this.mItems.add(generateFilterItem());
                    break;
                } else {
                    this.mShineEntry = 4;
                    if (i3 == 0) {
                        this.mDefaultType = "7";
                        if (!isSmoothDependBeautyVersion()) {
                            this.mSupportBeautyLevel = true;
                            this.mItems.add(generateBeautyLevelItem(i3 == 1));
                            if (DataRepository.dataItemFeature().isSupportShortVideoBeautyBody()) {
                                this.mSupportBeautyBody = true;
                                this.mItems.add(generateFigureItem());
                            }
                        } else {
                            this.mSupportSmoothLevel = true;
                            if (DataRepository.dataItemFeature().isSupportShortVideoBeautyBody()) {
                                this.mSupportBeautyBody = true;
                                this.mItems.add(generateFigureItem());
                            } else {
                                List<ComponentDataItem> list = this.mItems;
                                if (i3 != 1) {
                                    z = false;
                                }
                                list.add(generateSmoothLevelItem(z));
                            }
                        }
                    } else if (!isSmoothDependBeautyVersion()) {
                        this.mSupportBeautyLevel = true;
                        List<ComponentDataItem> list2 = this.mItems;
                        if (i3 != 1) {
                            z = false;
                        }
                        list2.add(generateBeautyLevelItem(z));
                    } else {
                        this.mSupportSmoothLevel = true;
                        List<ComponentDataItem> list3 = this.mItems;
                        if (i3 != 1) {
                            z = false;
                        }
                        list3.add(generateSmoothLevelItem(z));
                    }
                    this.mItems.add(generateFilterItem());
                    break;
                }
            case 162:
            case 169:
                if (cameraCapabilities.isSupportVideoBeauty()) {
                    this.mCurrentTipType = "2";
                    if (!isSmoothDependBeautyVersion()) {
                        this.mShineEntry = 2;
                        this.mSupportBeautyLevel = true;
                        this.mItems.add(generateBeautyLevelItem(i3 == 1));
                    } else {
                        this.mShineEntry = 1;
                        this.mSupportSmoothLevel = true;
                        this.mItems.add(generateSmoothLevelItem(i3 == 1));
                    }
                }
                Log.i(TAG, "isSupportVideoFilter: " + isSupportVideoFilter);
                if (isSupportVideoFilter) {
                    this.mSupportVideoFilter = true;
                    if (i3 == 0) {
                        this.mDefaultType = "7";
                        this.mCurrentTipType = "7";
                    }
                    this.mItems.add(generateFilterItem());
                }
                Log.i(TAG, "isSupportVideoBokehLevel:" + isSupportVideoBokehAdjust);
                if (isSupportVideoBokehAdjust) {
                    this.mSupportVideoBokehLevel = true;
                    this.mItems.add(generateVideoBokeh());
                }
                this.mSupportColorRententionFront = cameraCapabilities.isSupportVideoFilterColorRetentionFront();
                this.mSupportColorRententionBack = cameraCapabilities.isSupportVideoFilterColorRetentionBack();
                Log.i(TAG, "mSupportColorRententionFront:" + this.mSupportColorRententionFront + "  mSupportColorRententionBack:" + this.mSupportColorRententionBack);
                if (this.mItems.size() > 1) {
                    this.mShineEntry = 1;
                    break;
                }
                break;
            case 163:
            case 165:
                if (!CameraSettings.isUltraPixelRearOn()) {
                    if (!isSmoothDependBeautyVersion()) {
                        this.mSupportBeautyLevel = true;
                        this.mItems.add(generateBeautyLevelItem(i3 == 1));
                    } else {
                        this.mSupportSmoothLevel = true;
                    }
                    if (i3 == 0) {
                        this.mShineEntry = 1;
                        this.mDefaultType = "7";
                        if (DataRepository.dataItemFeature().isSupportBeautyBody()) {
                            this.mSupportBeautyBody = true;
                            this.mItems.add(generateFigureItem());
                        } else if (isSmoothDependBeautyVersion()) {
                            this.mItems.add(generateSmoothLevelItem(false));
                        }
                    } else {
                        this.mShineEntry = 4;
                        if (!DataRepository.dataItemFeature().Nb()) {
                            this.mSupportBeautyModel = true;
                            this.mItems.add(generateModelItem());
                            if (DataRepository.dataItemFeature().Xd() && cameraCapabilities.isSupportBeautyMakeup()) {
                                this.mSupportBeautyMakeUp = true;
                                this.mItems.add(generateMakeupItem());
                            }
                        } else if (isSmoothDependBeautyVersion()) {
                            this.mItems.add(generateSmoothLevelItem(true));
                        }
                    }
                } else if (i3 == 0) {
                    this.mShineEntry = 3;
                } else {
                    this.mShineEntry = 4;
                }
                this.mItems.add(generateFilterItem());
                break;
            case 167:
            case 175:
                this.mShineEntry = 3;
                this.mItems.add(generateFilterItem());
                break;
            case 171:
                this.mShineEntry = 4;
                if (!isSmoothDependBeautyVersion()) {
                    this.mSupportBeautyLevel = true;
                    List<ComponentDataItem> list4 = this.mItems;
                    if (i3 != 1) {
                        z = false;
                    }
                    list4.add(generateBeautyLevelItem(z));
                } else {
                    this.mSupportSmoothLevel = true;
                    List<ComponentDataItem> list5 = this.mItems;
                    if (i3 != 1) {
                        z = false;
                    }
                    list5.add(generateSmoothLevelItem(z));
                }
                this.mItems.add(generateFilterItem());
                break;
            case 174:
                this.mShineEntry = 4;
                this.mDefaultType = "10";
                this.mItems.add(new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, (int) R.string.beauty_fragment_tab_name_3d_beauty, SHINE_LIVE_BEAUTY));
                this.mItems.add(new ComponentDataItem((int) R.drawable.ic_new_effect_button_normal, (int) R.drawable.ic_new_effect_button_selected, (int) R.string.pref_camera_coloreffect_title, "10"));
                break;
            case 176:
                this.mShineEntry = 4;
                if (isSmoothDependBeautyVersion()) {
                    this.mSupportSmoothLevel = true;
                    List<ComponentDataItem> list6 = this.mItems;
                    if (i3 != 1) {
                        z = false;
                    }
                    list6.add(generateSmoothLevelItem(z));
                    break;
                } else {
                    this.mSupportBeautyLevel = true;
                    List<ComponentDataItem> list7 = this.mItems;
                    if (i3 != 1) {
                        z = false;
                    }
                    list7.add(generateBeautyLevelItem(z));
                    break;
                }
            case 177:
                this.mSupportSmoothLevel = true;
                break;
            case 180:
                if (cameraCapabilities.isSupportVideoFilter()) {
                    this.mShineEntry = 3;
                    this.mItems.add(generateFilterItem());
                    this.mSupportVideoFilter = true;
                    break;
                }
                break;
            case 183:
                this.mShineEntry = 4;
                this.mDefaultType = "7";
                this.mItems.add(new ComponentDataItem((int) R.drawable.ic_beauty_off, (int) R.drawable.ic_beauty_on, (int) R.string.beauty_fragment_tab_name_3d_beauty, SHINE_LIVE_BEAUTY));
                this.mItems.add(new ComponentDataItem((int) R.drawable.ic_new_effect_button_normal, (int) R.drawable.ic_new_effect_button_selected, (int) R.string.pref_camera_coloreffect_title, "7"));
                break;
        }
        if (this.mDefaultType == null && !this.mItems.isEmpty()) {
            this.mDefaultType = this.mItems.get(0).mValue;
        }
        this.mCurrentType = this.mDefaultType;
    }

    public void setClosed(boolean z) {
        this.mIsClosed = z;
    }

    public void setCurrentTipType(String str) {
        this.mCurrentTipType = str;
    }

    public void setCurrentType(@ShineType String str) {
        this.mCurrentType = str;
    }

    public void setVideoBeautySwitch(int i, boolean z) {
        String str = CameraSettings.isFrontCamera() ? "front" : MistatsConstants.BaseEvent.BACK;
        this.mIsVideoBeautySwitchedOnMap.put(i + str, Boolean.valueOf(z));
    }

    public boolean supportBeautyBody() {
        return this.mSupportBeautyBody;
    }

    public boolean supportBeautyLevel() {
        return this.mSupportBeautyLevel;
    }

    public boolean supportBeautyMakeUp() {
        return this.mSupportBeautyMakeUp;
    }

    public boolean supportBeautyModel() {
        return this.mSupportBeautyModel;
    }

    public boolean supportColorRentention() {
        return CameraSettings.isFrontCamera() ? this.mSupportColorRententionFront : this.mSupportColorRententionBack;
    }

    public boolean supportPopUpEntry() {
        int i = this.mShineEntry;
        return i == 4 || i == 5;
    }

    public boolean supportSmoothLevel() {
        return this.mSupportSmoothLevel;
    }

    public boolean supportTopConfigEntry() {
        int i = this.mShineEntry;
        return i == 1 || i == 2 || i == 3;
    }
}
