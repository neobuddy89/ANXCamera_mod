package android.support.v4.media;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.GuardedBy;
import android.support.v4.media.MediaLibraryService2;
import android.support.v4.media.MediaSession2;
import android.support.v4.media.MediaSession2ImplBase;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

@TargetApi(19)
class MediaLibrarySessionImplBase extends MediaSession2ImplBase implements MediaLibraryService2.MediaLibrarySession.SupportLibraryImpl {
    private final MediaBrowserServiceCompat mBrowserServiceLegacyStub = new MediaLibraryService2LegacyStub(this);
    @GuardedBy("mLock")
    private final ArrayMap<MediaSession2.ControllerInfo, Set<String>> mSubscriptions = new ArrayMap<>();

    MediaLibrarySessionImplBase(MediaLibraryService2.MediaLibrarySession mediaLibrarySession, Context context, String str, BaseMediaPlayer baseMediaPlayer, MediaPlaylistAgent mediaPlaylistAgent, VolumeProviderCompat volumeProviderCompat, PendingIntent pendingIntent, Executor executor, MediaSession2.SessionCallback sessionCallback) {
        super(mediaLibrarySession, context, str, baseMediaPlayer, mediaPlaylistAgent, volumeProviderCompat, pendingIntent, executor, sessionCallback);
        this.mBrowserServiceLegacyStub.attachToBaseContext(context);
        this.mBrowserServiceLegacyStub.onCreate();
    }

    /* access modifiers changed from: private */
    public void dumpSubscription() {
        if (MediaSession2ImplBase.DEBUG) {
            synchronized (this.mLock) {
                Log.d("MS2ImplBase", "Dumping subscription, controller sz=" + this.mSubscriptions.size());
                for (int i = 0; i < this.mSubscriptions.size(); i++) {
                    Log.d("MS2ImplBase", "  controller " + this.mSubscriptions.valueAt(i));
                    Iterator it = this.mSubscriptions.valueAt(i).iterator();
                    while (it.hasNext()) {
                        Log.d("MS2ImplBase", "  - " + ((String) it.next()));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean isSubscribed(MediaSession2.ControllerInfo controllerInfo, String str) {
        synchronized (this.mLock) {
            Set set = this.mSubscriptions.get(controllerInfo);
            if (set != null) {
                if (set.contains(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public MediaLibraryService2.MediaLibrarySession.MediaLibrarySessionCallback getCallback() {
        return (MediaLibraryService2.MediaLibrarySession.MediaLibrarySessionCallback) super.getCallback();
    }

    public MediaLibraryService2.MediaLibrarySession getInstance() {
        return (MediaLibraryService2.MediaLibrarySession) super.getInstance();
    }

    public IBinder getLegacySessionBinder() {
        return this.mBrowserServiceLegacyStub.onBind(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE));
    }

    public void notifyChildrenChanged(MediaSession2.ControllerInfo controllerInfo, String str, int i, Bundle bundle) {
        if (controllerInfo == null) {
            throw new IllegalArgumentException("controller shouldn't be null");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query shouldn't be empty");
        } else if (i >= 0) {
            final MediaSession2.ControllerInfo controllerInfo2 = controllerInfo;
            final String str2 = str;
            final int i2 = i;
            final Bundle bundle2 = bundle;
            AnonymousClass2 r1 = new MediaSession2ImplBase.NotifyRunnable() {
                public void run(MediaSession2.ControllerCb controllerCb) throws RemoteException {
                    if (MediaLibrarySessionImplBase.this.isSubscribed(controllerInfo2, str2)) {
                        controllerCb.onChildrenChanged(str2, i2, bundle2);
                    } else if (MediaSession2ImplBase.DEBUG) {
                        Log.d("MS2ImplBase", "Skipping notifyChildrenChanged() to " + controllerInfo2 + " because it hasn't subscribed");
                        MediaLibrarySessionImplBase.this.dumpSubscription();
                    }
                }
            };
            notifyToController(controllerInfo, r1);
        } else {
            throw new IllegalArgumentException("itemCount shouldn't be negative");
        }
    }

    public void notifyChildrenChanged(final String str, final int i, final Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query shouldn't be empty");
        } else if (i >= 0) {
            List<MediaSession2.ControllerInfo> connectedControllers = getConnectedControllers();
            AnonymousClass1 r1 = new MediaSession2ImplBase.NotifyRunnable() {
                public void run(MediaSession2.ControllerCb controllerCb) throws RemoteException {
                    controllerCb.onChildrenChanged(str, i, bundle);
                }
            };
            for (int i2 = 0; i2 < connectedControllers.size(); i2++) {
                if (isSubscribed(connectedControllers.get(i2), str)) {
                    notifyToController(connectedControllers.get(i2), r1);
                }
            }
        } else {
            throw new IllegalArgumentException("itemCount shouldn't be negative");
        }
    }

    public void notifySearchResultChanged(MediaSession2.ControllerInfo controllerInfo, final String str, final int i, final Bundle bundle) {
        if (controllerInfo == null) {
            throw new IllegalArgumentException("controller shouldn't be null");
        } else if (!TextUtils.isEmpty(str)) {
            notifyToController(controllerInfo, new MediaSession2ImplBase.NotifyRunnable() {
                public void run(MediaSession2.ControllerCb controllerCb) throws RemoteException {
                    controllerCb.onSearchResultChanged(str, i, bundle);
                }
            });
        } else {
            throw new IllegalArgumentException("query shouldn't be empty");
        }
    }

    public void onGetChildrenOnExecutor(MediaSession2.ControllerInfo controllerInfo, String str, int i, int i2, Bundle bundle) {
        final List<MediaItem2> onGetChildren = getCallback().onGetChildren(getInstance(), controllerInfo, str, i, i2, bundle);
        if (onGetChildren == null || onGetChildren.size() <= i2) {
            final String str2 = str;
            final int i3 = i;
            final int i4 = i2;
            final Bundle bundle2 = bundle;
            AnonymousClass6 r2 = new MediaSession2ImplBase.NotifyRunnable() {
                public void run(MediaSession2.ControllerCb controllerCb) throws RemoteException {
                    controllerCb.onGetChildrenDone(str2, i3, i4, onGetChildren, bundle2);
                }
            };
            notifyToController(controllerInfo, r2);
            return;
        }
        throw new IllegalArgumentException("onGetChildren() shouldn't return media items more than pageSize. result.size()=" + onGetChildren.size() + " pageSize=" + i2);
    }

    public void onGetItemOnExecutor(MediaSession2.ControllerInfo controllerInfo, final String str) {
        final MediaItem2 onGetItem = getCallback().onGetItem(getInstance(), controllerInfo, str);
        notifyToController(controllerInfo, new MediaSession2ImplBase.NotifyRunnable() {
            public void run(MediaSession2.ControllerCb controllerCb) throws RemoteException {
                controllerCb.onGetItemDone(str, onGetItem);
            }
        });
    }

    public void onGetLibraryRootOnExecutor(MediaSession2.ControllerInfo controllerInfo, final Bundle bundle) {
        final MediaLibraryService2.LibraryRoot onGetLibraryRoot = getCallback().onGetLibraryRoot(getInstance(), controllerInfo, bundle);
        notifyToController(controllerInfo, new MediaSession2ImplBase.NotifyRunnable() {
            public void run(MediaSession2.ControllerCb controllerCb) throws RemoteException {
                Bundle bundle = bundle;
                MediaLibraryService2.LibraryRoot libraryRoot = onGetLibraryRoot;
                Bundle bundle2 = null;
                String rootId = libraryRoot == null ? null : libraryRoot.getRootId();
                MediaLibraryService2.LibraryRoot libraryRoot2 = onGetLibraryRoot;
                if (libraryRoot2 != null) {
                    bundle2 = libraryRoot2.getExtras();
                }
                controllerCb.onGetLibraryRootDone(bundle, rootId, bundle2);
            }
        });
    }

    public void onGetSearchResultOnExecutor(MediaSession2.ControllerInfo controllerInfo, String str, int i, int i2, Bundle bundle) {
        final List<MediaItem2> onGetSearchResult = getCallback().onGetSearchResult(getInstance(), controllerInfo, str, i, i2, bundle);
        if (onGetSearchResult == null || onGetSearchResult.size() <= i2) {
            final String str2 = str;
            final int i3 = i;
            final int i4 = i2;
            final Bundle bundle2 = bundle;
            AnonymousClass7 r2 = new MediaSession2ImplBase.NotifyRunnable() {
                public void run(MediaSession2.ControllerCb controllerCb) throws RemoteException {
                    controllerCb.onGetSearchResultDone(str2, i3, i4, onGetSearchResult, bundle2);
                }
            };
            notifyToController(controllerInfo, r2);
            return;
        }
        throw new IllegalArgumentException("onGetSearchResult() shouldn't return media items more than pageSize. result.size()=" + onGetSearchResult.size() + " pageSize=" + i2);
    }

    public void onSearchOnExecutor(MediaSession2.ControllerInfo controllerInfo, String str, Bundle bundle) {
        getCallback().onSearch(getInstance(), controllerInfo, str, bundle);
    }

    public void onSubscribeOnExecutor(MediaSession2.ControllerInfo controllerInfo, String str, Bundle bundle) {
        synchronized (this.mLock) {
            Set set = this.mSubscriptions.get(controllerInfo);
            if (set == null) {
                set = new HashSet();
                this.mSubscriptions.put(controllerInfo, set);
            }
            set.add(str);
        }
        getCallback().onSubscribe(getInstance(), controllerInfo, str, bundle);
    }

    public void onUnsubscribeOnExecutor(MediaSession2.ControllerInfo controllerInfo, String str) {
        getCallback().onUnsubscribe(getInstance(), controllerInfo, str);
        synchronized (this.mLock) {
            this.mSubscriptions.remove(controllerInfo);
        }
    }
}
