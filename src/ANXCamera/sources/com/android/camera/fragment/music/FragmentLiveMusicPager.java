package com.android.camera.fragment.music;

import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.camera.CameraSettings;
import com.android.camera.R;
import com.android.camera.data.DataRepository;
import com.android.camera.fragment.CtaNoticeFragment;
import com.android.camera.fragment.DefaultItemAnimator;
import com.android.camera.fragment.FragmentUtils;
import com.android.camera.fragment.beauty.LinearLayoutManagerWrapper;
import com.android.camera.fragment.music.FragmentLiveMusic;
import com.android.camera.log.Log;
import com.android.camera.module.ModuleManager;
import com.android.camera.module.impl.component.FileUtils;
import com.android.camera.network.NetworkDependencies;
import com.android.camera.network.live.BaseRequestException;
import com.android.camera.network.live.TTLiveMusicResourceRequest;
import com.android.camera.network.net.base.ErrorCode;
import com.android.camera.network.net.base.ResponseListener;
import com.android.camera.protocol.ModeCoordinatorImpl;
import com.android.camera.protocol.ModeProtocol;
import com.ss.android.vesdk.VEEditor;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import miui.app.ProgressDialog;

public class FragmentLiveMusicPager extends Fragment implements View.OnClickListener, View.OnTouchListener, CtaNoticeFragment.OnCtaNoticeClickListener {
    private static final long MAX_REQUEST_TIME = 10800000;
    /* access modifiers changed from: private */
    public static final String TAG = "FragmentLiveMusicPager";
    /* access modifiers changed from: private */
    public LiveMusicInfo mCurrentSelectMusic;
    /* access modifiers changed from: private */
    public LinearLayout mCurrentSelectedMusicLayout;
    private AudioManager.OnAudioFocusChangeListener mFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
            if (i == -3 && FragmentLiveMusicPager.this.mMediaPlayer != null) {
                FragmentLiveMusicPager.this.mMediaPlayer.setVolume(0.2f, 0.2f);
            }
        }
    };
    private boolean mIsDestroyed;
    /* access modifiers changed from: private */
    public boolean mIsLoadingAnimationStart;
    /* access modifiers changed from: private */
    public boolean mIsMediaPreparing;
    private int mItemType;
    private List<LiveMusicInfo> mLiveMusicInfoList;
    /* access modifiers changed from: private */
    public ProgressBar mMediaLoadingProgressBar;
    /* access modifiers changed from: private */
    public MediaPlayer mMediaPlayer;
    private FragmentLiveMusic.Mp3DownloadCallback mMp3DownloadCallback = new FragmentLiveMusic.Mp3DownloadCallback() {
        public void onCompleted() {
            FragmentLiveMusicPager.this.stopDownloadAnimation();
            FragmentLiveMusicPager fragmentLiveMusicPager = FragmentLiveMusicPager.this;
            fragmentLiveMusicPager.onSelectedMusic(fragmentLiveMusicPager.mCurrentSelectMusic);
            FragmentUtils.removeFragmentByTag(FragmentLiveMusicPager.this.getParentFragment().getFragmentManager(), FragmentLiveMusic.TAG);
        }

        public void onFailed() {
            Log.e(FragmentLiveMusicPager.TAG, "mp3 download failed !!");
            Completable.fromAction(new Action() {
                public void run() {
                    FragmentLiveMusicPager.this.stopDownloadAnimation();
                    if (FragmentLiveMusicPager.this.mCurrentSelectedMusicLayout != null) {
                        FragmentLiveMusicPager.this.mCurrentSelectedMusicLayout.setBackgroundColor(-1);
                        FragmentLiveMusicPager.this.mCurrentSelectedMusicLayout.setAlpha(1.0f);
                    }
                    if (FragmentLiveMusicPager.this.getActivity() != null) {
                        Toast.makeText(FragmentLiveMusicPager.this.getActivity(), R.string.live_music_network_exception, 1).show();
                    }
                }
            }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
        }
    };
    private MusicAdapter mMusicAdapter;
    private int mMusicPlayPosition;
    /* access modifiers changed from: private */
    public LinearLayout mNetworkExceptionLayout;
    /* access modifiers changed from: private */
    public ImageView mPlayingImageView;
    /* access modifiers changed from: private */
    public ProgressDialog mProgressDialog;
    private RecyclerView mRecyclerView;
    private LinearLayout mUpdateLayout;

    private void initAdapter() {
        if (this.mItemType == 0) {
            this.mLiveMusicInfoList = new ArrayList();
            this.mMusicAdapter = new MusicAdapter(getContext(), this, this, this.mLiveMusicInfoList);
            if (CtaNoticeFragment.checkCta(getActivity().getFragmentManager(), false, this, 1)) {
                loadOnlineHotMusic();
            }
        } else {
            this.mNetworkExceptionLayout.setVisibility(8);
            this.mUpdateLayout.setVisibility(8);
            this.mRecyclerView.setVisibility(0);
            this.mLiveMusicInfoList = MusicUtils.getMusicListFromLocalFolder(FileUtils.MUSIC_LOCAL, getContext());
            this.mMusicAdapter = new MusicAdapter(getContext(), this, this, this.mLiveMusicInfoList);
        }
        this.mRecyclerView.setAdapter(this.mMusicAdapter);
    }

    /* access modifiers changed from: private */
    public void loadOnlineHotMusic() {
        if (!ModuleManager.isMiLiveModule()) {
            Context context = getContext();
            if (context != null) {
                TTLiveMusicResourceRequest tTLiveMusicResourceRequest = new TTLiveMusicResourceRequest();
                boolean isConnected = NetworkDependencies.isConnected(context);
                long liveMusicFirstRequestTime = DataRepository.dataItemRunning().getLiveMusicFirstRequestTime();
                long currentTimeMillis = System.currentTimeMillis() - liveMusicFirstRequestTime;
                if (!isConnected || (liveMusicFirstRequestTime > 0 && currentTimeMillis < MAX_REQUEST_TIME)) {
                    try {
                        updateAdapter(tTLiveMusicResourceRequest.loadFromCache());
                    } catch (BaseRequestException e2) {
                        this.mNetworkExceptionLayout.setVisibility(0);
                        String str = TAG;
                        Log.e(str, "request online music failed " + e2.getMessage());
                    }
                } else {
                    tTLiveMusicResourceRequest.execute(new ResponseListener() {
                        public void onResponse(Object... objArr) {
                            final List list = objArr[0];
                            if (FragmentLiveMusicPager.this.isAdded()) {
                                Completable.fromAction(new Action() {
                                    public void run() {
                                        DataRepository.dataItemRunning().setLiveMusicFirstRequestTime(System.currentTimeMillis());
                                        FragmentLiveMusicPager.this.updateAdapter(list);
                                    }
                                }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
                            }
                        }

                        public void onResponseError(ErrorCode errorCode, String str, Object obj) {
                            Completable.fromAction(new Action() {
                                public void run() {
                                    if (FragmentLiveMusicPager.this.mNetworkExceptionLayout != null) {
                                        FragmentLiveMusicPager.this.mNetworkExceptionLayout.setVisibility(0);
                                    }
                                }
                            }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
                            String access$400 = FragmentLiveMusicPager.TAG;
                            Log.e(access$400, "request online music failed, errorCode =  " + errorCode);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void onSelectedMusic(LiveMusicInfo liveMusicInfo) {
        String str = liveMusicInfo.mPlayUrl;
        if (this.mItemType == 0) {
            str = FileUtils.MUSIC_ONLINE + liveMusicInfo.mTitle + ".mp3";
        }
        ModeProtocol.LiveAudioChanges liveAudioChanges = (ModeProtocol.LiveAudioChanges) ModeCoordinatorImpl.getInstance().getAttachProtocol(211);
        if (liveAudioChanges != null) {
            liveAudioChanges.setAudioPath(str);
        }
        final ModeProtocol.TopAlert topAlert = (ModeProtocol.TopAlert) ModeCoordinatorImpl.getInstance().getAttachProtocol(172);
        CameraSettings.setCurrentLiveMusic(str, liveMusicInfo.mTitle + "-" + liveMusicInfo.mAuthor);
        Completable.fromAction(new Action() {
            public void run() {
                ModeProtocol.TopAlert topAlert = topAlert;
                if (topAlert != null) {
                    topAlert.updateConfigItem(245);
                }
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    private void startDownloadAnimation() {
        this.mIsLoadingAnimationStart = true;
        this.mProgressDialog = new ProgressDialog(getActivity());
        String string = getString(R.string.live_music_downloading_tips);
        this.mProgressDialog.setCancelable(true);
        this.mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                if (!FragmentLiveMusicPager.this.mProgressDialog.isShowing()) {
                    return true;
                }
                FragmentLiveMusicPager.this.mProgressDialog.dismiss();
                if (!FragmentLiveMusicPager.this.mIsLoadingAnimationStart) {
                    return true;
                }
                FragmentLiveMusicPager.this.mCurrentSelectedMusicLayout.setBackgroundColor(-1);
                FragmentLiveMusicPager.this.mCurrentSelectedMusicLayout.setAlpha(1.0f);
                return true;
            }
        });
        this.mProgressDialog.setMessage(string);
        this.mProgressDialog.show();
    }

    private void startDownloadMuusic(LiveMusicInfo liveMusicInfo) {
        String str = liveMusicInfo.mPlayUrl;
        if (this.mItemType == 0) {
            String str2 = FileUtils.MUSIC_ONLINE + liveMusicInfo.mTitle + ".mp3";
            if (!new File(str2).exists()) {
                if (NetworkDependencies.isConnected(getContext())) {
                    startDownloadAnimation();
                    OkHttpUtils.downloadMp3Async(liveMusicInfo.mPlayUrl, str2, this.mMp3DownloadCallback);
                } else {
                    LinearLayout linearLayout = this.mCurrentSelectedMusicLayout;
                    if (linearLayout != null) {
                        linearLayout.setBackgroundColor(-1);
                        this.mCurrentSelectedMusicLayout.setAlpha(1.0f);
                    }
                    Toast.makeText(getActivity(), R.string.live_music_network_exception, 1).show();
                    return;
                }
            }
        }
        this.mCurrentSelectMusic = liveMusicInfo;
        if (!this.mIsLoadingAnimationStart) {
            onSelectedMusic(liveMusicInfo);
            FragmentUtils.removeFragmentByTag(getParentFragment().getFragmentManager(), FragmentLiveMusic.TAG);
        }
    }

    private void startPlayMusic(LiveMusicInfo liveMusicInfo) {
        ((AudioManager) getContext().getSystemService(VEEditor.MVConsts.TYPE_AUDIO)).requestAudioFocus(this.mFocusChangeListener, 3, 1);
        if (liveMusicInfo != null && !liveMusicInfo.mPlayUrl.isEmpty() && !this.mIsDestroyed) {
            LiveMusicInfo liveMusicInfo2 = this.mCurrentSelectMusic;
            if (liveMusicInfo2 == null || !liveMusicInfo2.equals(liveMusicInfo) || !this.mMediaPlayer.isPlaying()) {
                try {
                    if (this.mMediaPlayer != null && this.mMediaPlayer.isPlaying()) {
                        this.mMediaPlayer.stop();
                        this.mMediaPlayer.reset();
                    }
                    this.mPlayingImageView.setVisibility(4);
                    this.mMediaLoadingProgressBar.setVisibility(0);
                    this.mMediaPlayer.setDataSource(liveMusicInfo.mPlayUrl);
                    this.mMediaPlayer.prepareAsync();
                    this.mIsMediaPreparing = true;
                    this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            FragmentLiveMusicPager.this.mMediaLoadingProgressBar.setVisibility(4);
                            FragmentLiveMusicPager.this.mPlayingImageView.setVisibility(0);
                            FragmentLiveMusicPager.this.mPlayingImageView.setBackgroundResource(R.drawable.ic_live_music_pause);
                            mediaPlayer.start();
                            boolean unused = FragmentLiveMusicPager.this.mIsMediaPreparing = false;
                        }
                    });
                    this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            FragmentLiveMusicPager.this.mMediaPlayer.stop();
                            FragmentLiveMusicPager.this.mMediaPlayer.reset();
                            FragmentLiveMusicPager.this.mPlayingImageView.setBackgroundResource(R.drawable.ic_live_music_play);
                        }
                    });
                } catch (IOException e2) {
                    String str = TAG;
                    Log.e(str, "mediaplayer play failed " + e2.getMessage());
                }
                this.mCurrentSelectMusic = liveMusicInfo;
                return;
            }
            this.mMediaPlayer.stop();
            this.mMediaPlayer.reset();
        }
    }

    /* access modifiers changed from: private */
    public void stopDownloadAnimation() {
        this.mIsLoadingAnimationStart = false;
        this.mProgressDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public void updateAdapter(List<LiveMusicInfo> list) {
        this.mLiveMusicInfoList.addAll(list);
        if (this.mItemType == 0) {
            this.mUpdateLayout.setVisibility(8);
            this.mNetworkExceptionLayout.setVisibility(8);
            this.mRecyclerView.setVisibility(0);
        }
        this.mMusicAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.music_recycler_view);
        this.mRecyclerView.setFocusable(false);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getContext(), "music_recycler_view");
        linearLayoutManagerWrapper.setOrientation(1);
        this.mRecyclerView.setLayoutManager(linearLayoutManagerWrapper);
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.mUpdateLayout = (LinearLayout) view.findViewById(R.id.music_updating_layout);
        this.mNetworkExceptionLayout = (LinearLayout) view.findViewById(R.id.music_network_exception);
        this.mNetworkExceptionLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CtaNoticeFragment.checkCta(FragmentLiveMusicPager.this.getActivity().getFragmentManager(), false, FragmentLiveMusicPager.this, 1)) {
                    FragmentLiveMusicPager.this.loadOnlineHotMusic();
                }
            }
        });
        this.mItemType = getArguments().getInt("ITEM_TYPE");
        this.mMediaPlayer = new MediaPlayer();
        this.mIsLoadingAnimationStart = false;
        this.mIsMediaPreparing = false;
        initAdapter();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.music_network_exception:
                this.mUpdateLayout.setVisibility(0);
                this.mNetworkExceptionLayout.setVisibility(8);
                loadOnlineHotMusic();
                return;
            case R.id.music_play:
                if (!this.mIsMediaPreparing) {
                    LiveMusicInfo liveMusicInfo = (LiveMusicInfo) view.getTag();
                    if (this.mItemType == 0 && !NetworkDependencies.isConnected(getContext())) {
                        String str = FileUtils.MUSIC_ONLINE + liveMusicInfo.mTitle + ".mp3";
                        if (!new File(str).exists()) {
                            Toast.makeText(getActivity(), R.string.live_music_network_exception, 1).show();
                            return;
                        }
                        liveMusicInfo.mPlayUrl = str;
                    }
                    ImageView imageView = this.mPlayingImageView;
                    if (imageView != null) {
                        imageView.setBackgroundResource(R.drawable.ic_live_music_play);
                    }
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.music_play);
                    if (!imageView2.equals(this.mPlayingImageView)) {
                        this.mPlayingImageView = imageView2;
                    }
                    this.mMediaLoadingProgressBar = (ProgressBar) ((ViewGroup) view.getParent()).findViewById(R.id.music_loading);
                    startPlayMusic(liveMusicInfo);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_music_pager, viewGroup, false);
        initView(inflate);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mIsDestroyed = true;
        this.mMediaPlayer.release();
        this.mRecyclerView.setAdapter((RecyclerView.Adapter) null);
    }

    public void onNegativeClick(DialogInterface dialogInterface, int i) {
        this.mUpdateLayout.setVisibility(8);
        this.mNetworkExceptionLayout.setVisibility(0);
    }

    public void onPause() {
        super.onPause();
        if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mMusicPlayPosition = this.mMediaPlayer.getCurrentPosition();
        }
    }

    public void onPositiveClick(DialogInterface dialogInterface, int i) {
        loadOnlineHotMusic();
    }

    public void onResume() {
        super.onResume();
        if (this.mMusicPlayPosition != 0) {
            ((AudioManager) getContext().getSystemService(VEEditor.MVConsts.TYPE_AUDIO)).requestAudioFocus(this.mFocusChangeListener, 3, 1);
            this.mMediaPlayer.seekTo(this.mMusicPlayPosition);
            this.mMediaPlayer.start();
            this.mMusicPlayPosition = 0;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.mCurrentSelectedMusicLayout = (LinearLayout) view.findViewById(R.id.music_layout);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mCurrentSelectedMusicLayout.setBackgroundColor(-3355444);
            this.mCurrentSelectedMusicLayout.setAlpha(0.5f);
        } else if (actionMasked == 1) {
            startDownloadMuusic((LiveMusicInfo) view.getTag());
        } else if (actionMasked != 2 && actionMasked == 3) {
            this.mCurrentSelectedMusicLayout.setBackgroundColor(-1);
            this.mCurrentSelectedMusicLayout.setAlpha(1.0f);
        }
        return true;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.mMediaPlayer.stop();
                this.mMediaPlayer.reset();
                this.mPlayingImageView.setBackgroundResource(R.drawable.ic_live_music_play);
            }
        }
    }
}
