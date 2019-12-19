.class final Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;
.super Lcom/xiaomi/camera/liveshot/util/BackgroundTaskScheduler$CancellableTask;
.source "CircularMediaRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "SnapshotRequest"
.end annotation


# instance fields
.field private final mAudioSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

.field private final mOrientationHint:I

.field private final mSampleWriterExecutor:Ljava/util/concurrent/ExecutorService;

.field private final mTag:Ljava/lang/Object;

.field private final mVideoClipSavingCallback:Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;

.field private final mVideoSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;


# direct methods
.method private static synthetic $closeResource(Ljava/lang/Throwable;Ljava/lang/AutoCloseable;)V
    .locals 0

    if-eqz p0, :cond_0

    :try_start_0
    invoke-interface {p1}, Ljava/lang/AutoCloseable;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception p1

    invoke-virtual {p0, p1}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    goto :goto_0

    :cond_0
    invoke-interface {p1}, Ljava/lang/AutoCloseable;->close()V

    :goto_0
    return-void
.end method

.method private constructor <init>(Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;ILjava/lang/Object;Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;)V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/camera/liveshot/util/BackgroundTaskScheduler$CancellableTask;-><init>()V

    if-nez p2, :cond_1

    if-eqz p1, :cond_0

    goto :goto_0

    :cond_0
    new-instance p0, Ljava/lang/IllegalStateException;

    const-string p1, "At least one non-null snapshot should be provided"

    invoke-direct {p0, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_1
    :goto_0
    iput-object p1, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mAudioSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    iput-object p2, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    iput p3, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mOrientationHint:I

    iput-object p4, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mTag:Ljava/lang/Object;

    iput-object p5, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoClipSavingCallback:Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;

    const/4 p1, 0x2

    invoke-static {p1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object p1

    iput-object p1, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mSampleWriterExecutor:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method synthetic constructor <init>(Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;ILjava/lang/Object;Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$1;)V
    .locals 0

    invoke-direct/range {p0 .. p5}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;-><init>(Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;ILjava/lang/Object;Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;)V

    return-void
.end method

.method private static readFully(Ljava/lang/String;)[B
    .locals 4

    const/4 v0, 0x0

    :try_start_0
    new-instance v1, Ljava/io/BufferedInputStream;

    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, p0}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    invoke-direct {v1, v2}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    new-instance p0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {p0}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    const/16 v2, 0x800

    :try_start_2
    new-array v2, v2, [B

    :goto_0
    invoke-virtual {v1, v2}, Ljava/io/FilterInputStream;->read([B)I

    move-result v3

    if-gez v3, :cond_0

    invoke-virtual {p0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    const/4 v3, 0x0

    :try_start_3
    invoke-static {v3, p0}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->$closeResource(Ljava/lang/Throwable;Ljava/lang/AutoCloseable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    :try_start_4
    invoke-static {v3, v1}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->$closeResource(Ljava/lang/Throwable;Ljava/lang/AutoCloseable;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0

    return-object v2

    :cond_0
    :try_start_5
    invoke-virtual {p0, v2, v0, v3}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v2

    :try_start_6
    throw v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    :catchall_1
    move-exception v3

    :try_start_7
    invoke-static {v2, p0}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->$closeResource(Ljava/lang/Throwable;Ljava/lang/AutoCloseable;)V

    throw v3
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    :catchall_2
    move-exception p0

    :try_start_8
    throw p0
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_3

    :catchall_3
    move-exception v2

    :try_start_9
    invoke-static {p0, v1}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->$closeResource(Ljava/lang/Throwable;Ljava/lang/AutoCloseable;)V

    throw v2
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_0

    :catch_0
    move-exception p0

    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to load the mp4 file content into memory: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v1, p0}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    new-array p0, v0, [B

    return-object p0
.end method


# virtual methods
.method public run()V
    .locals 14

    const-string v0, "Failed to delete the temporary mp4 file: "

    const-string v1, "Failed to release the media muxer: "

    const-string v2, "Ignore deleting the temporary mp4 file: "

    invoke-virtual {p0}, Lcom/xiaomi/camera/liveshot/util/BackgroundTaskScheduler$CancellableTask;->isCancelled()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Saving request is cancelled before executing"

    invoke-static {v0, v1}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v0, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mSampleWriterExecutor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    iget-object v0, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoClipSavingCallback:Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;

    if-eqz v0, :cond_0

    iget-object p0, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mTag:Ljava/lang/Object;

    invoke-interface {v0, p0}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;->onVideoClipSavingCancelled(Ljava/lang/Object;)V

    :cond_0
    return-void

    :cond_1
    const/4 v3, 0x0

    :try_start_0
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$200()Z

    move-result v4

    if-eqz v4, :cond_2

    new-instance v4, Ljava/io/File;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v5

    const-string v6, "microvideo.mp4"

    invoke-direct {v4, v5, v6}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    const-string v4, "microvideo"

    const-string v5, ".mp4"

    invoke-static {v4, v5}, Ljava/io/File;->createTempFile(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    :goto_0
    :try_start_1
    new-instance v5, Landroid/media/MediaMuxer;

    invoke-virtual {v4}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-direct {v5, v6, v7}, Landroid/media/MediaMuxer;-><init>(Ljava/lang/String;I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iget v6, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mOrientationHint:I

    invoke-virtual {v5, v6}, Landroid/media/MediaMuxer;->setOrientationHint(I)V

    iget-object v6, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    const/4 v7, -0x1

    if-eqz v6, :cond_3

    iget-object v6, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    iget-object v6, v6, Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;->format:Landroid/media/MediaFormat;

    invoke-virtual {v5, v6}, Landroid/media/MediaMuxer;->addTrack(Landroid/media/MediaFormat;)I

    move-result v6

    goto :goto_1

    :cond_3
    move v6, v7

    :goto_1
    iget-object v8, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mAudioSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    if-eqz v8, :cond_4

    iget-object v8, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mAudioSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    iget-object v8, v8, Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;->format:Landroid/media/MediaFormat;

    invoke-virtual {v5, v8}, Landroid/media/MediaMuxer;->addTrack(Landroid/media/MediaFormat;)I

    move-result v8

    goto :goto_2

    :cond_4
    move v8, v7

    :goto_2
    invoke-virtual {v5}, Landroid/media/MediaMuxer;->start()V

    new-instance v9, Ljava/util/ArrayList;

    const/4 v10, 0x2

    invoke-direct {v9, v10}, Ljava/util/ArrayList;-><init>(I)V

    iget-object v10, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    if-eqz v10, :cond_5

    if-eq v6, v7, :cond_5

    new-instance v3, Lcom/xiaomi/camera/liveshot/writer/SampleWriter$StatusNotifier;

    const-wide/16 v10, 0x0

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-direct {v3, v10}, Lcom/xiaomi/camera/liveshot/writer/SampleWriter$StatusNotifier;-><init>(Ljava/lang/Object;)V

    iget-object v10, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mSampleWriterExecutor:Ljava/util/concurrent/ExecutorService;

    new-instance v11, Lcom/xiaomi/camera/liveshot/writer/VideoSampleWriter;

    iget-object v12, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    invoke-direct {v11, v5, v12, v6, v3}, Lcom/xiaomi/camera/liveshot/writer/VideoSampleWriter;-><init>(Landroid/media/MediaMuxer;Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;ILcom/xiaomi/camera/liveshot/writer/SampleWriter$StatusNotifier;)V

    invoke-interface {v10, v11}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    move-result-object v6

    invoke-interface {v9, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_5
    iget-object v6, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mAudioSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    if-eqz v6, :cond_6

    if-eq v8, v7, :cond_6

    iget-object v6, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mSampleWriterExecutor:Ljava/util/concurrent/ExecutorService;

    new-instance v7, Lcom/xiaomi/camera/liveshot/writer/AudioSampleWriter;

    iget-object v10, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mAudioSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    invoke-direct {v7, v5, v10, v8, v3}, Lcom/xiaomi/camera/liveshot/writer/AudioSampleWriter;-><init>(Landroid/media/MediaMuxer;Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;ILcom/xiaomi/camera/liveshot/writer/SampleWriter$StatusNotifier;)V

    invoke-interface {v6, v7}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;

    move-result-object v3

    invoke-interface {v9, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_6
    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_7
    :goto_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_8

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/concurrent/Future;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    if-eqz v6, :cond_7

    :try_start_3
    invoke-interface {v6}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    goto :goto_3

    :catch_0
    move-exception v6

    :try_start_4
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Writing is interrupted and the generated video may be corrupted: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v7, v6}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3

    :cond_8
    invoke-virtual {v5}, Landroid/media/MediaMuxer;->stop()V

    iget-object v3, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoClipSavingCallback:Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;

    if-eqz v3, :cond_a

    invoke-virtual {v4}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->readFully(Ljava/lang/String;)[B

    move-result-object v3

    iget-object v6, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoClipSavingCallback:Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;

    iget-object v7, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mTag:Ljava/lang/Object;

    iget-object v8, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    if-nez v8, :cond_9

    const-wide/16 v8, -0x1

    goto :goto_4

    :cond_9
    iget-object v8, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoSnapshot:Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;

    iget-wide v8, v8, Lcom/xiaomi/camera/liveshot/encoder/CircularMediaEncoder$Snapshot;->time:J

    :goto_4
    invoke-interface {v6, v7, v3, v8, v9}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;->onVideoClipSavingCompleted(Ljava/lang/Object;[BJ)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    :cond_a
    :try_start_5
    invoke-virtual {v5}, Landroid/media/MediaMuxer;->release()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_5

    :catch_1
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :goto_5
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$200()Z

    move-result v1

    if-eqz v1, :cond_b

    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    goto/16 :goto_8

    :cond_b
    if-eqz v4, :cond_f

    invoke-virtual {v4}, Ljava/io/File;->delete()Z

    move-result v1

    if-nez v1, :cond_f

    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    goto/16 :goto_9

    :catch_2
    move-exception v3

    goto :goto_6

    :catchall_0
    move-exception v5

    move-object v13, v5

    move-object v5, v3

    move-object v3, v13

    goto/16 :goto_b

    :catch_3
    move-exception v5

    move-object v13, v5

    move-object v5, v3

    move-object v3, v13

    goto :goto_6

    :catchall_1
    move-exception v4

    move-object v5, v3

    move-object v3, v4

    move-object v4, v5

    goto/16 :goto_b

    :catch_4
    move-exception v4

    move-object v5, v3

    move-object v3, v4

    move-object v4, v5

    :goto_6
    :try_start_6
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Failed to save the videoclip as an mp4 file: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v6, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoClipSavingCallback:Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;

    if-eqz v6, :cond_c

    iget-object v6, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mVideoClipSavingCallback:Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;

    iget-object v7, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mTag:Ljava/lang/Object;

    invoke-interface {v6, v7, v3}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$VideoClipSavingCallback;->onVideoClipSavingException(Ljava/lang/Object;Ljava/lang/Throwable;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    :cond_c
    if-eqz v5, :cond_d

    :try_start_7
    invoke-virtual {v5}, Landroid/media/MediaMuxer;->release()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_5

    goto :goto_7

    :catch_5
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v3

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_d
    :goto_7
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$200()Z

    move-result v1

    if-eqz v1, :cond_e

    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    :goto_8
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_a

    :cond_e
    if-eqz v4, :cond_f

    invoke-virtual {v4}, Ljava/io/File;->delete()Z

    move-result v1

    if-nez v1, :cond_f

    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    :goto_9
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_f
    :goto_a
    iget-object p0, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mSampleWriterExecutor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {p0}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    return-void

    :catchall_2
    move-exception v3

    :goto_b
    if-eqz v5, :cond_10

    :try_start_8
    invoke-virtual {v5}, Landroid/media/MediaMuxer;->release()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_6

    goto :goto_c

    :catch_6
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v6, v1}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_10
    :goto_c
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$200()Z

    move-result v1

    if-nez v1, :cond_11

    if-eqz v4, :cond_12

    invoke-virtual {v4}, Ljava/io/File;->delete()Z

    move-result v1

    if-nez v1, :cond_12

    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_d

    :cond_11
    invoke-static {}, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder;->access$100()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/android/camera/log/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_12
    :goto_d
    iget-object p0, p0, Lcom/xiaomi/camera/liveshot/CircularMediaRecorder$SnapshotRequest;->mSampleWriterExecutor:Ljava/util/concurrent/ExecutorService;

    invoke-interface {p0}, Ljava/util/concurrent/ExecutorService;->shutdown()V

    throw v3
.end method
