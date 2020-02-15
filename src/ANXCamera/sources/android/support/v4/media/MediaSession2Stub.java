package android.support.v4.media;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.annotation.GuardedBy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.mediacompat.Rating2;
import android.support.v4.media.IMediaSession2;
import android.support.v4.media.MediaController2;
import android.support.v4.media.MediaLibraryService2;
import android.support.v4.media.MediaSession2;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

@TargetApi(19)
class MediaSession2Stub extends IMediaSession2.Stub {
    private static final boolean DEBUG = true;
    private static final String TAG = "MediaSession2Stub";
    /* access modifiers changed from: private */
    public static final SparseArray<SessionCommand2> sCommandsForOnCommandRequest = new SparseArray<>();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final ArrayMap<MediaSession2.ControllerInfo, SessionCommandGroup2> mAllowedCommandGroupMap = new ArrayMap<>();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final Set<IBinder> mConnectingControllers = new HashSet();
    final Context mContext;
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final ArrayMap<IBinder, MediaSession2.ControllerInfo> mControllers = new ArrayMap<>();
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    final MediaSession2.SupportLibraryImpl mSession;

    static final class Controller2Cb extends MediaSession2.ControllerCb {
        private final IMediaController2 mIControllerCallback;

        Controller2Cb(@NonNull IMediaController2 iMediaController2) {
            this.mIControllerCallback = iMediaController2;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public IBinder getId() {
            return this.mIControllerCallback.asBinder();
        }

        /* access modifiers changed from: package-private */
        public void onAllowedCommandsChanged(SessionCommandGroup2 sessionCommandGroup2) throws RemoteException {
            this.mIControllerCallback.onAllowedCommandsChanged(sessionCommandGroup2.toBundle());
        }

        /* access modifiers changed from: package-private */
        public void onBufferingStateChanged(MediaItem2 mediaItem2, int i, long j) throws RemoteException {
            this.mIControllerCallback.onBufferingStateChanged(mediaItem2 == null ? null : mediaItem2.toBundle(), i, j);
        }

        /* access modifiers changed from: package-private */
        public void onChildrenChanged(String str, int i, Bundle bundle) throws RemoteException {
            this.mIControllerCallback.onChildrenChanged(str, i, bundle);
        }

        /* access modifiers changed from: package-private */
        public void onCurrentMediaItemChanged(MediaItem2 mediaItem2) throws RemoteException {
            this.mIControllerCallback.onCurrentMediaItemChanged(mediaItem2 == null ? null : mediaItem2.toBundle());
        }

        /* access modifiers changed from: package-private */
        public void onCustomCommand(SessionCommand2 sessionCommand2, Bundle bundle, ResultReceiver resultReceiver) throws RemoteException {
            this.mIControllerCallback.onCustomCommand(sessionCommand2.toBundle(), bundle, resultReceiver);
        }

        /* access modifiers changed from: package-private */
        public void onCustomLayoutChanged(List<MediaSession2.CommandButton> list) throws RemoteException {
            this.mIControllerCallback.onCustomLayoutChanged(MediaUtils2.convertCommandButtonListToBundleList(list));
        }

        /* access modifiers changed from: package-private */
        public void onDisconnected() throws RemoteException {
            this.mIControllerCallback.onDisconnected();
        }

        /* access modifiers changed from: package-private */
        public void onError(int i, Bundle bundle) throws RemoteException {
            this.mIControllerCallback.onError(i, bundle);
        }

        /* access modifiers changed from: package-private */
        public void onGetChildrenDone(String str, int i, int i2, List<MediaItem2> list, Bundle bundle) throws RemoteException {
            this.mIControllerCallback.onGetChildrenDone(str, i, i2, MediaUtils2.convertMediaItem2ListToBundleList(list), bundle);
        }

        /* access modifiers changed from: package-private */
        public void onGetItemDone(String str, MediaItem2 mediaItem2) throws RemoteException {
            this.mIControllerCallback.onGetItemDone(str, mediaItem2 == null ? null : mediaItem2.toBundle());
        }

        /* access modifiers changed from: package-private */
        public void onGetLibraryRootDone(Bundle bundle, String str, Bundle bundle2) throws RemoteException {
            this.mIControllerCallback.onGetLibraryRootDone(bundle, str, bundle2);
        }

        /* access modifiers changed from: package-private */
        public void onGetSearchResultDone(String str, int i, int i2, List<MediaItem2> list, Bundle bundle) throws RemoteException {
            this.mIControllerCallback.onGetSearchResultDone(str, i, i2, MediaUtils2.convertMediaItem2ListToBundleList(list), bundle);
        }

        /* access modifiers changed from: package-private */
        public void onPlaybackInfoChanged(MediaController2.PlaybackInfo playbackInfo) throws RemoteException {
            this.mIControllerCallback.onPlaybackInfoChanged(playbackInfo.toBundle());
        }

        /* access modifiers changed from: package-private */
        public void onPlaybackSpeedChanged(long j, long j2, float f2) throws RemoteException {
            this.mIControllerCallback.onPlaybackSpeedChanged(j, j2, f2);
        }

        /* access modifiers changed from: package-private */
        public void onPlayerStateChanged(long j, long j2, int i) throws RemoteException {
            this.mIControllerCallback.onPlayerStateChanged(j, j2, i);
        }

        /* access modifiers changed from: package-private */
        public void onPlaylistChanged(List<MediaItem2> list, MediaMetadata2 mediaMetadata2) throws RemoteException {
            this.mIControllerCallback.onPlaylistChanged(MediaUtils2.convertMediaItem2ListToBundleList(list), mediaMetadata2 == null ? null : mediaMetadata2.toBundle());
        }

        /* access modifiers changed from: package-private */
        public void onPlaylistMetadataChanged(MediaMetadata2 mediaMetadata2) throws RemoteException {
            this.mIControllerCallback.onPlaylistMetadataChanged(mediaMetadata2.toBundle());
        }

        /* access modifiers changed from: package-private */
        public void onRepeatModeChanged(int i) throws RemoteException {
            this.mIControllerCallback.onRepeatModeChanged(i);
        }

        /* access modifiers changed from: package-private */
        public void onRoutesInfoChanged(List<Bundle> list) throws RemoteException {
            this.mIControllerCallback.onRoutesInfoChanged(list);
        }

        /* access modifiers changed from: package-private */
        public void onSearchResultChanged(String str, int i, Bundle bundle) throws RemoteException {
            this.mIControllerCallback.onSearchResultChanged(str, i, bundle);
        }

        /* access modifiers changed from: package-private */
        public void onSeekCompleted(long j, long j2, long j3) throws RemoteException {
            this.mIControllerCallback.onSeekCompleted(j, j2, j3);
        }

        /* access modifiers changed from: package-private */
        public void onShuffleModeChanged(int i) throws RemoteException {
            this.mIControllerCallback.onShuffleModeChanged(i);
        }
    }

    @FunctionalInterface
    private interface SessionRunnable {
        void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException;
    }

    static {
        SessionCommandGroup2 sessionCommandGroup2 = new SessionCommandGroup2();
        sessionCommandGroup2.addAllPlaybackCommands();
        sessionCommandGroup2.addAllPlaylistCommands();
        sessionCommandGroup2.addAllVolumeCommands();
        for (SessionCommand2 next : sessionCommandGroup2.getCommands()) {
            sCommandsForOnCommandRequest.append(next.getCommandCode(), next);
        }
    }

    MediaSession2Stub(MediaSession2.SupportLibraryImpl supportLibraryImpl) {
        this.mSession = supportLibraryImpl;
        this.mContext = this.mSession.getContext();
    }

    /* access modifiers changed from: private */
    public MediaLibraryService2.MediaLibrarySession.SupportLibraryImpl getLibrarySession() {
        MediaSession2.SupportLibraryImpl supportLibraryImpl = this.mSession;
        if (supportLibraryImpl instanceof MediaLibraryService2.MediaLibrarySession.SupportLibraryImpl) {
            return (MediaLibraryService2.MediaLibrarySession.SupportLibraryImpl) supportLibraryImpl;
        }
        throw new RuntimeException("Session cannot be casted to library session");
    }

    /* access modifiers changed from: private */
    public boolean isAllowedCommand(MediaSession2.ControllerInfo controllerInfo, int i) {
        SessionCommandGroup2 sessionCommandGroup2;
        synchronized (this.mLock) {
            sessionCommandGroup2 = this.mAllowedCommandGroupMap.get(controllerInfo);
        }
        return sessionCommandGroup2 != null && sessionCommandGroup2.hasCommand(i);
    }

    /* access modifiers changed from: private */
    public boolean isAllowedCommand(MediaSession2.ControllerInfo controllerInfo, SessionCommand2 sessionCommand2) {
        SessionCommandGroup2 sessionCommandGroup2;
        synchronized (this.mLock) {
            sessionCommandGroup2 = this.mAllowedCommandGroupMap.get(controllerInfo);
        }
        return sessionCommandGroup2 != null && sessionCommandGroup2.hasCommand(sessionCommand2);
    }

    private void onBrowserCommand(@NonNull IMediaController2 iMediaController2, int i, @NonNull SessionRunnable sessionRunnable) {
        if (this.mSession instanceof MediaLibraryService2.MediaLibrarySession.SupportLibraryImpl) {
            onSessionCommandInternal(iMediaController2, (SessionCommand2) null, i, sessionRunnable);
            return;
        }
        throw new RuntimeException("MediaSession2 cannot handle MediaLibrarySession command");
    }

    private void onSessionCommand(@NonNull IMediaController2 iMediaController2, int i, @NonNull SessionRunnable sessionRunnable) {
        onSessionCommandInternal(iMediaController2, (SessionCommand2) null, i, sessionRunnable);
    }

    private void onSessionCommand(@NonNull IMediaController2 iMediaController2, @NonNull SessionCommand2 sessionCommand2, @NonNull SessionRunnable sessionRunnable) {
        onSessionCommandInternal(iMediaController2, sessionCommand2, 0, sessionRunnable);
    }

    private void onSessionCommandInternal(@NonNull IMediaController2 iMediaController2, @Nullable SessionCommand2 sessionCommand2, int i, @NonNull SessionRunnable sessionRunnable) {
        final MediaSession2.ControllerInfo controllerInfo;
        synchronized (this.mLock) {
            controllerInfo = iMediaController2 == null ? null : this.mControllers.get(iMediaController2.asBinder());
        }
        if (!this.mSession.isClosed() && controllerInfo != null) {
            Executor callbackExecutor = this.mSession.getCallbackExecutor();
            final SessionCommand2 sessionCommand22 = sessionCommand2;
            final int i2 = i;
            final SessionRunnable sessionRunnable2 = sessionRunnable;
            AnonymousClass1 r1 = new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
                    if (android.support.v4.media.MediaSession2Stub.access$200(r4.this$0, r3, r0) != false) goto L_0x0027;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
                    r0 = (android.support.v4.media.SessionCommand2) android.support.v4.media.MediaSession2Stub.access$300().get(r4.getCommandCode());
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
                    if (android.support.v4.media.MediaSession2Stub.access$400(r4.this$0, r3, r5) != false) goto L_0x0045;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
                    r0 = (android.support.v4.media.SessionCommand2) android.support.v4.media.MediaSession2Stub.access$300().get(r5);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
                    if (r0 == null) goto L_0x0098;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
                    if (r4.this$0.mSession.getCallback().onCommandRequest(r4.this$0.mSession.getInstance(), r3, r0) != false) goto L_0x0098;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
                    android.util.Log.d(android.support.v4.media.MediaSession2Stub.TAG, "Command (" + r0 + ") from " + r3 + " was rejected by " + r4.this$0.mSession);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x0097, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
                    r6.run(r3);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a0, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a1, code lost:
                    android.util.Log.w(android.support.v4.media.MediaSession2Stub.TAG, "Exception in " + r3.toString(), r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
                    r0 = r4;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
                    if (r0 == null) goto L_0x0038;
                 */
                public void run() {
                    synchronized (MediaSession2Stub.this.mLock) {
                        if (!MediaSession2Stub.this.mControllers.containsValue(controllerInfo)) {
                        }
                    }
                }
            };
            callbackExecutor.execute(r1);
        }
    }

    private void releaseController(IMediaController2 iMediaController2) {
        final MediaSession2.ControllerInfo remove;
        synchronized (this.mLock) {
            remove = this.mControllers.remove(iMediaController2.asBinder());
            Log.d(TAG, "releasing " + remove);
        }
        if (!this.mSession.isClosed() && remove != null) {
            this.mSession.getCallbackExecutor().execute(new Runnable() {
                public void run() {
                    MediaSession2Stub.this.mSession.getCallback().onDisconnected(MediaSession2Stub.this.mSession.getInstance(), remove);
                }
            });
        }
    }

    public void addPlaylistItem(IMediaController2 iMediaController2, final int i, final Bundle bundle) {
        onSessionCommand(iMediaController2, 15, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getInstance().addPlaylistItem(i, MediaItem2.fromBundle(bundle, (UUID) null));
            }
        });
    }

    public void adjustVolume(IMediaController2 iMediaController2, final int i, final int i2) throws RuntimeException {
        onSessionCommand(iMediaController2, 11, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                VolumeProviderCompat volumeProvider = MediaSession2Stub.this.mSession.getVolumeProvider();
                if (volumeProvider == null) {
                    MediaSessionCompat sessionCompat = MediaSession2Stub.this.mSession.getSessionCompat();
                    if (sessionCompat != null) {
                        sessionCompat.getController().adjustVolume(i, i2);
                        return;
                    }
                    return;
                }
                volumeProvider.onAdjustVolume(i);
            }
        });
    }

    public void connect(final IMediaController2 iMediaController2, String str) throws RuntimeException {
        final MediaSession2.ControllerInfo controllerInfo = new MediaSession2.ControllerInfo(str, Binder.getCallingPid(), Binder.getCallingUid(), new Controller2Cb(iMediaController2));
        this.mSession.getCallbackExecutor().execute(new Runnable() {
            public void run() {
                if (!MediaSession2Stub.this.mSession.isClosed()) {
                    synchronized (MediaSession2Stub.this.mLock) {
                        MediaSession2Stub.this.mConnectingControllers.add(controllerInfo.getId());
                    }
                    SessionCommandGroup2 onConnect = MediaSession2Stub.this.mSession.getCallback().onConnect(MediaSession2Stub.this.mSession.getInstance(), controllerInfo);
                    if (onConnect != null || controllerInfo.isTrusted()) {
                        Log.d(MediaSession2Stub.TAG, "Accepting connection, controllerInfo=" + controllerInfo + " allowedCommands=" + onConnect);
                        if (onConnect == null) {
                            onConnect = new SessionCommandGroup2();
                        }
                        synchronized (MediaSession2Stub.this.mLock) {
                            MediaSession2Stub.this.mConnectingControllers.remove(controllerInfo.getId());
                            MediaSession2Stub.this.mControllers.put(controllerInfo.getId(), controllerInfo);
                            MediaSession2Stub.this.mAllowedCommandGroupMap.put(controllerInfo, onConnect);
                        }
                        int playerState = MediaSession2Stub.this.mSession.getPlayerState();
                        List<MediaItem2> list = null;
                        Bundle bundle = MediaSession2Stub.this.mSession.getCurrentMediaItem() == null ? null : MediaSession2Stub.this.mSession.getCurrentMediaItem().toBundle();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        long currentPosition = MediaSession2Stub.this.mSession.getCurrentPosition();
                        float playbackSpeed = MediaSession2Stub.this.mSession.getPlaybackSpeed();
                        long bufferedPosition = MediaSession2Stub.this.mSession.getBufferedPosition();
                        Bundle bundle2 = MediaSession2Stub.this.mSession.getPlaybackInfo().toBundle();
                        int repeatMode = MediaSession2Stub.this.mSession.getRepeatMode();
                        int shuffleMode = MediaSession2Stub.this.mSession.getShuffleMode();
                        PendingIntent sessionActivity = MediaSession2Stub.this.mSession.getSessionActivity();
                        if (onConnect.hasCommand(18)) {
                            list = MediaSession2Stub.this.mSession.getPlaylist();
                        }
                        List<Bundle> convertMediaItem2ListToBundleList = MediaUtils2.convertMediaItem2ListToBundleList(list);
                        if (!MediaSession2Stub.this.mSession.isClosed()) {
                            try {
                                iMediaController2.onConnected(MediaSession2Stub.this, onConnect.toBundle(), playerState, bundle, elapsedRealtime, currentPosition, playbackSpeed, bufferedPosition, bundle2, repeatMode, shuffleMode, convertMediaItem2ListToBundleList, sessionActivity);
                            } catch (RemoteException unused) {
                            }
                        }
                    } else {
                        synchronized (MediaSession2Stub.this.mLock) {
                            MediaSession2Stub.this.mConnectingControllers.remove(controllerInfo.getId());
                        }
                        Log.d(MediaSession2Stub.TAG, "Rejecting connection, controllerInfo=" + controllerInfo);
                        iMediaController2.onDisconnected();
                    }
                }
            }
        });
    }

    public void fastForward(IMediaController2 iMediaController2) {
        onSessionCommand(iMediaController2, 7, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getCallback().onFastForward(MediaSession2Stub.this.mSession.getInstance(), controllerInfo);
            }
        });
    }

    public void getChildren(IMediaController2 iMediaController2, String str, int i, int i2, Bundle bundle) throws RuntimeException {
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final Bundle bundle2 = bundle;
        AnonymousClass37 r0 = new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (str2 == null) {
                    Log.w(MediaSession2Stub.TAG, "getChildren(): Ignoring null parentId from " + controllerInfo);
                } else if (i3 < 1 || i4 < 1) {
                    Log.w(MediaSession2Stub.TAG, "getChildren(): Ignoring page nor pageSize less than 1 from " + controllerInfo);
                } else {
                    MediaSession2Stub.this.getLibrarySession().onGetChildrenOnExecutor(controllerInfo, str2, i3, i4, bundle2);
                }
            }
        };
        onBrowserCommand(iMediaController2, 29, r0);
    }

    /* access modifiers changed from: package-private */
    public List<MediaSession2.ControllerInfo> getConnectedControllers() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            for (int i = 0; i < this.mControllers.size(); i++) {
                arrayList.add(this.mControllers.valueAt(i));
            }
        }
        return arrayList;
    }

    public void getItem(IMediaController2 iMediaController2, final String str) throws RuntimeException {
        onBrowserCommand(iMediaController2, 30, new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (str == null) {
                    Log.w(MediaSession2Stub.TAG, "getItem(): Ignoring null mediaId from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.getLibrarySession().onGetItemOnExecutor(controllerInfo, str);
            }
        });
    }

    public void getLibraryRoot(IMediaController2 iMediaController2, final Bundle bundle) throws RuntimeException {
        onBrowserCommand(iMediaController2, 31, new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.getLibrarySession().onGetLibraryRootOnExecutor(controllerInfo, bundle);
            }
        });
    }

    public void getSearchResult(IMediaController2 iMediaController2, String str, int i, int i2, Bundle bundle) {
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final Bundle bundle2 = bundle;
        AnonymousClass39 r0 = new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (TextUtils.isEmpty(str2)) {
                    Log.w(MediaSession2Stub.TAG, "getSearchResult(): Ignoring empty query from " + controllerInfo);
                } else if (i3 < 1 || i4 < 1) {
                    Log.w(MediaSession2Stub.TAG, "getSearchResult(): Ignoring page nor pageSize less than 1  from " + controllerInfo);
                } else {
                    MediaSession2Stub.this.getLibrarySession().onGetSearchResultOnExecutor(controllerInfo, str2, i3, i4, bundle2);
                }
            }
        };
        onBrowserCommand(iMediaController2, 32, r0);
    }

    public void pause(IMediaController2 iMediaController2) throws RuntimeException {
        onSessionCommand(iMediaController2, 2, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.pause();
            }
        });
    }

    public void play(IMediaController2 iMediaController2) throws RuntimeException {
        onSessionCommand(iMediaController2, 1, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.play();
            }
        });
    }

    public void playFromMediaId(IMediaController2 iMediaController2, final String str, final Bundle bundle) {
        onSessionCommand(iMediaController2, 22, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (str == null) {
                    Log.w(MediaSession2Stub.TAG, "playFromMediaId(): Ignoring null mediaId from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.mSession.getCallback().onPlayFromMediaId(MediaSession2Stub.this.mSession.getInstance(), controllerInfo, str, bundle);
            }
        });
    }

    public void playFromSearch(IMediaController2 iMediaController2, final String str, final Bundle bundle) {
        onSessionCommand(iMediaController2, 24, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    Log.w(MediaSession2Stub.TAG, "playFromSearch(): Ignoring empty query from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.mSession.getCallback().onPlayFromSearch(MediaSession2Stub.this.mSession.getInstance(), controllerInfo, str, bundle);
            }
        });
    }

    public void playFromUri(IMediaController2 iMediaController2, final Uri uri, final Bundle bundle) {
        onSessionCommand(iMediaController2, 23, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (uri == null) {
                    Log.w(MediaSession2Stub.TAG, "playFromUri(): Ignoring null uri from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.mSession.getCallback().onPlayFromUri(MediaSession2Stub.this.mSession.getInstance(), controllerInfo, uri, bundle);
            }
        });
    }

    public void prepare(IMediaController2 iMediaController2) throws RuntimeException {
        onSessionCommand(iMediaController2, 6, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.prepare();
            }
        });
    }

    public void prepareFromMediaId(IMediaController2 iMediaController2, final String str, final Bundle bundle) {
        onSessionCommand(iMediaController2, 25, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (str == null) {
                    Log.w(MediaSession2Stub.TAG, "prepareFromMediaId(): Ignoring null mediaId from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.mSession.getCallback().onPrepareFromMediaId(MediaSession2Stub.this.mSession.getInstance(), controllerInfo, str, bundle);
            }
        });
    }

    public void prepareFromSearch(IMediaController2 iMediaController2, final String str, final Bundle bundle) {
        onSessionCommand(iMediaController2, 27, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    Log.w(MediaSession2Stub.TAG, "prepareFromSearch(): Ignoring empty query from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.mSession.getCallback().onPrepareFromSearch(MediaSession2Stub.this.mSession.getInstance(), controllerInfo, str, bundle);
            }
        });
    }

    public void prepareFromUri(IMediaController2 iMediaController2, final Uri uri, final Bundle bundle) {
        onSessionCommand(iMediaController2, 26, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (uri == null) {
                    Log.w(MediaSession2Stub.TAG, "prepareFromUri(): Ignoring null uri from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.mSession.getCallback().onPrepareFromUri(MediaSession2Stub.this.mSession.getInstance(), controllerInfo, uri, bundle);
            }
        });
    }

    public void release(IMediaController2 iMediaController2) throws RemoteException {
        releaseController(iMediaController2);
    }

    /* access modifiers changed from: package-private */
    public void removeControllerInfo(MediaSession2.ControllerInfo controllerInfo) {
        synchronized (this.mLock) {
            Log.d(TAG, "releasing " + this.mControllers.remove(controllerInfo.getId()));
        }
    }

    public void removePlaylistItem(IMediaController2 iMediaController2, final Bundle bundle) {
        onSessionCommand(iMediaController2, 16, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getInstance().removePlaylistItem(MediaItem2.fromBundle(bundle));
            }
        });
    }

    public void replacePlaylistItem(IMediaController2 iMediaController2, final int i, final Bundle bundle) {
        onSessionCommand(iMediaController2, 17, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getInstance().replacePlaylistItem(i, MediaItem2.fromBundle(bundle, (UUID) null));
            }
        });
    }

    public void reset(IMediaController2 iMediaController2) throws RuntimeException {
        onSessionCommand(iMediaController2, 3, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.reset();
            }
        });
    }

    public void rewind(IMediaController2 iMediaController2) {
        onSessionCommand(iMediaController2, 8, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getCallback().onRewind(MediaSession2Stub.this.mSession.getInstance(), controllerInfo);
            }
        });
    }

    public void search(IMediaController2 iMediaController2, final String str, final Bundle bundle) {
        onBrowserCommand(iMediaController2, 33, new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    Log.w(MediaSession2Stub.TAG, "search(): Ignoring empty query from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.getLibrarySession().onSearchOnExecutor(controllerInfo, str, bundle);
            }
        });
    }

    public void seekTo(IMediaController2 iMediaController2, final long j) throws RuntimeException {
        onSessionCommand(iMediaController2, 9, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.seekTo(j);
            }
        });
    }

    public void selectRoute(IMediaController2 iMediaController2, final Bundle bundle) {
        onSessionCommand(iMediaController2, 37, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getCallback().onSelectRoute(MediaSession2Stub.this.mSession.getInstance(), controllerInfo, bundle);
            }
        });
    }

    public void sendCustomCommand(IMediaController2 iMediaController2, Bundle bundle, final Bundle bundle2, final ResultReceiver resultReceiver) {
        final SessionCommand2 fromBundle = SessionCommand2.fromBundle(bundle);
        onSessionCommand(iMediaController2, SessionCommand2.fromBundle(bundle), (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getCallback().onCustomCommand(MediaSession2Stub.this.mSession.getInstance(), controllerInfo, fromBundle, bundle2, resultReceiver);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setAllowedCommands(MediaSession2.ControllerInfo controllerInfo, SessionCommandGroup2 sessionCommandGroup2) {
        synchronized (this.mLock) {
            this.mAllowedCommandGroupMap.put(controllerInfo, sessionCommandGroup2);
        }
    }

    public void setPlaybackSpeed(IMediaController2 iMediaController2, final float f2) {
        onSessionCommand(iMediaController2, 39, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getInstance().setPlaybackSpeed(f2);
            }
        });
    }

    public void setPlaylist(IMediaController2 iMediaController2, final List<Bundle> list, final Bundle bundle) {
        onSessionCommand(iMediaController2, 19, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (list == null) {
                    Log.w(MediaSession2Stub.TAG, "setPlaylist(): Ignoring null playlist from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.mSession.getInstance().setPlaylist(MediaUtils2.convertBundleListToMediaItem2List(list), MediaMetadata2.fromBundle(bundle));
            }
        });
    }

    public void setRating(IMediaController2 iMediaController2, final String str, final Bundle bundle) {
        onSessionCommand(iMediaController2, 28, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (str == null) {
                    Log.w(MediaSession2Stub.TAG, "setRating(): Ignoring null mediaId from " + controllerInfo);
                    return;
                }
                Bundle bundle = bundle;
                if (bundle == null) {
                    Log.w(MediaSession2Stub.TAG, "setRating(): Ignoring null ratingBundle from " + controllerInfo);
                    return;
                }
                Rating2 fromBundle = Rating2.fromBundle(bundle);
                if (fromBundle != null) {
                    MediaSession2Stub.this.mSession.getCallback().onSetRating(MediaSession2Stub.this.mSession.getInstance(), controllerInfo, str, fromBundle);
                } else if (bundle == null) {
                    Log.w(MediaSession2Stub.TAG, "setRating(): Ignoring null rating from " + controllerInfo);
                }
            }
        });
    }

    public void setRepeatMode(IMediaController2 iMediaController2, final int i) {
        onSessionCommand(iMediaController2, 14, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getInstance().setRepeatMode(i);
            }
        });
    }

    public void setShuffleMode(IMediaController2 iMediaController2, final int i) {
        onSessionCommand(iMediaController2, 13, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getInstance().setShuffleMode(i);
            }
        });
    }

    public void setVolumeTo(IMediaController2 iMediaController2, final int i, final int i2) throws RuntimeException {
        onSessionCommand(iMediaController2, 10, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                VolumeProviderCompat volumeProvider = MediaSession2Stub.this.mSession.getVolumeProvider();
                if (volumeProvider == null) {
                    MediaSessionCompat sessionCompat = MediaSession2Stub.this.mSession.getSessionCompat();
                    if (sessionCompat != null) {
                        sessionCompat.getController().setVolumeTo(i, i2);
                        return;
                    }
                    return;
                }
                volumeProvider.onSetVolumeTo(i);
            }
        });
    }

    public void skipToNextItem(IMediaController2 iMediaController2) {
        onSessionCommand(iMediaController2, 4, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getInstance().skipToNextItem();
            }
        });
    }

    public void skipToPlaylistItem(IMediaController2 iMediaController2, final Bundle bundle) {
        onSessionCommand(iMediaController2, 12, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (bundle == null) {
                    Log.w(MediaSession2Stub.TAG, "skipToPlaylistItem(): Ignoring null mediaItem from " + controllerInfo);
                }
                MediaSession2Stub.this.mSession.getInstance().skipToPlaylistItem(MediaItem2.fromBundle(bundle));
            }
        });
    }

    public void skipToPreviousItem(IMediaController2 iMediaController2) {
        onSessionCommand(iMediaController2, 5, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getInstance().skipToPreviousItem();
            }
        });
    }

    public void subscribe(IMediaController2 iMediaController2, final String str, final Bundle bundle) {
        onBrowserCommand(iMediaController2, 34, new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (str == null) {
                    Log.w(MediaSession2Stub.TAG, "subscribe(): Ignoring null parentId from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.getLibrarySession().onSubscribeOnExecutor(controllerInfo, str, bundle);
            }
        });
    }

    public void subscribeRoutesInfo(IMediaController2 iMediaController2) {
        onSessionCommand(iMediaController2, 36, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getCallback().onSubscribeRoutesInfo(MediaSession2Stub.this.mSession.getInstance(), controllerInfo);
            }
        });
    }

    public void unsubscribe(IMediaController2 iMediaController2, final String str) {
        onBrowserCommand(iMediaController2, 35, new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                if (str == null) {
                    Log.w(MediaSession2Stub.TAG, "unsubscribe(): Ignoring null parentId from " + controllerInfo);
                    return;
                }
                MediaSession2Stub.this.getLibrarySession().onUnsubscribeOnExecutor(controllerInfo, str);
            }
        });
    }

    public void unsubscribeRoutesInfo(IMediaController2 iMediaController2) {
        onSessionCommand(iMediaController2, 37, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getCallback().onUnsubscribeRoutesInfo(MediaSession2Stub.this.mSession.getInstance(), controllerInfo);
            }
        });
    }

    public void updatePlaylistMetadata(IMediaController2 iMediaController2, final Bundle bundle) {
        onSessionCommand(iMediaController2, 21, (SessionRunnable) new SessionRunnable() {
            public void run(MediaSession2.ControllerInfo controllerInfo) throws RemoteException {
                MediaSession2Stub.this.mSession.getInstance().updatePlaylistMetadata(MediaMetadata2.fromBundle(bundle));
            }
        });
    }
}
