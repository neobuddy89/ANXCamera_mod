package com.android.camera.network.resource;

import com.google.android.gms.common.internal.ImagesContract;
import com.ss.android.ugc.effectmanager.common.EffectConstants;

public class LiveResource {
    public String id;
    public boolean isLocal;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LiveResource{id=");
        sb.append(this.id);
        sb.append(", ");
        sb.append(this.isLocal ? ImagesContract.LOCAL : EffectConstants.CHANNEL_ONLINE);
        sb.append('}');
        return sb.toString();
    }
}
