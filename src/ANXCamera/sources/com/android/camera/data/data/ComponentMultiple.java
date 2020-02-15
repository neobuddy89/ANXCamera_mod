package com.android.camera.data.data;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import com.android.camera.data.provider.DataProvider;
import com.android.camera2.CameraCapabilities;
import java.util.Arrays;
import java.util.List;

public abstract class ComponentMultiple extends ComponentData {
    private List<TypeItem> mTypeItemList;

    public <D extends DataItemBase> ComponentMultiple(D d2) {
        super(d2);
    }

    @NonNull
    public String getDefaultValue(int i) {
        throw new RuntimeException("provided by TypeItem");
    }

    public List<ComponentDataItem> getItems() {
        throw new RuntimeException("refactor later");
    }

    @CallSuper
    public String getKey(int i) {
        throw new RuntimeException("provided by TypeItem");
    }

    public List<TypeItem> getTypeItemList() {
        return this.mTypeItemList;
    }

    public <T> T getValueByItem(TypeItem<T> typeItem) {
        if (!typeItem.mExpandable) {
            String str = typeItem.mKeyOrType;
            if (typeItem.asString()) {
                return this.mParentDataItem.getString(str, (String) typeItem.mDefaultValue);
            }
            if (typeItem.asInteger()) {
                return Integer.valueOf(this.mParentDataItem.getInt(str, ((Integer) typeItem.mDefaultValue).intValue()));
            }
            if (typeItem.asBoolean()) {
                return Boolean.valueOf(this.mParentDataItem.getBoolean(str, ((Boolean) typeItem.mDefaultValue).booleanValue()));
            }
            return null;
        }
        throw new RuntimeException("complex result");
    }

    public abstract void initTypeElements(Context context, int i, CameraCapabilities cameraCapabilities, int i2);

    /* access modifiers changed from: protected */
    public void insert(TypeItem... typeItemArr) {
        List<TypeItem> list = this.mTypeItemList;
        if (list == null) {
            this.mTypeItemList = Arrays.asList(typeItemArr);
        } else if (typeItemArr.length == 1) {
            list.add(typeItemArr[0]);
        } else {
            list.addAll(Arrays.asList(typeItemArr));
        }
    }

    public boolean isEmpty() {
        List<TypeItem> list = this.mTypeItemList;
        return list == null || list.isEmpty();
    }

    public <T> void putValueWithItem(TypeItem<T> typeItem, T t) {
        if (!typeItem.mExpandable) {
            String str = typeItem.mKeyOrType;
            DataProvider.ProviderEditor editor = this.mParentDataItem.editor();
            if (typeItem.asString()) {
                editor.putString(str, (String) t);
            } else if (typeItem.asInteger()) {
                editor.putInt(str, ((Integer) t).intValue());
            } else if (typeItem.asBoolean()) {
                editor.putBoolean(str, ((Boolean) t).booleanValue());
            }
            editor.apply();
            return;
        }
        throw new RuntimeException("complex result");
    }
}
