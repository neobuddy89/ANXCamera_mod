package com.arcsoft.avatar.recoder;

import android.opengl.GLES30;
import com.arcsoft.avatar.gl.GLFramebuffer;
import com.arcsoft.avatar.util.CodecLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FrameQueue {

    /* renamed from: a  reason: collision with root package name */
    private static final String f91a = "FrameQueue";

    /* renamed from: b  reason: collision with root package name */
    private FrameItem f92b = null;

    /* renamed from: c  reason: collision with root package name */
    private FrameItem f93c = null;

    /* renamed from: d  reason: collision with root package name */
    private List<FrameItem> f94d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private Queue<FrameItem> f95e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f96f;

    public void addEmptyFrameForConsumer() {
        FrameItem frameItem = this.f93c;
        if (frameItem != null) {
            this.f94d.add(frameItem);
            this.f93c = null;
        }
    }

    public void addFrameForProducer() {
        FrameItem frameItem = this.f92b;
        if (frameItem != null) {
            this.f95e.offer(frameItem);
            this.f92b = null;
        }
    }

    public void deleteSync(FrameItem frameItem) {
        try {
            if (0 != frameItem.f90a) {
                String str = f91a;
                CodecLog.d(str, "deleteSync delete_a_sync : " + frameItem.f90a);
                GLES30.glDeleteSync(frameItem.f90a);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            String str2 = f91a;
            CodecLog.e(str2, "deleteSync meet error : " + e2.getMessage());
        } catch (Throwable th) {
            frameItem.f90a = 0;
            throw th;
        }
        frameItem.f90a = 0;
    }

    public FrameItem getFrameForConsumer() {
        FrameItem frameItem = this.f93c;
        if (frameItem != null) {
            return frameItem;
        }
        if (this.f95e.isEmpty()) {
            return null;
        }
        this.f93c = this.f95e.poll();
        return this.f93c;
    }

    public FrameItem getFrameForProducer() {
        FrameItem frameItem = this.f92b;
        if (frameItem != null) {
            return frameItem;
        }
        if (!this.f94d.isEmpty()) {
            this.f92b = this.f94d.remove(0);
        } else if (this.f95e.isEmpty()) {
            return null;
        } else {
            this.f92b = this.f95e.poll();
        }
        return this.f92b;
    }

    public void init(int i, int i2, int i3, boolean z) {
        unInit();
        for (int i4 = 0; i4 < i; i4++) {
            FrameItem frameItem = new FrameItem();
            frameItem.mIsEmpty = true;
            frameItem.mIsInited = true;
            frameItem.mFrameIndex = i4;
            frameItem.mFramebuffer = new GLFramebuffer();
            frameItem.mFramebuffer.init(i2, i3, z);
            this.f94d.add(frameItem);
        }
        this.f96f = true;
    }

    public boolean isIsInited() {
        return this.f96f;
    }

    public int queueSize() {
        return this.f95e.size();
    }

    public void unInit() {
        FrameItem frameItem = this.f92b;
        if (frameItem != null) {
            GLFramebuffer gLFramebuffer = frameItem.mFramebuffer;
            if (gLFramebuffer != null) {
                gLFramebuffer.unInit();
                deleteSync(this.f92b);
                this.f92b.mFramebuffer = null;
                this.f92b = null;
            }
        }
        FrameItem frameItem2 = this.f93c;
        if (frameItem2 != null) {
            GLFramebuffer gLFramebuffer2 = frameItem2.mFramebuffer;
            if (gLFramebuffer2 != null) {
                gLFramebuffer2.unInit();
                deleteSync(this.f93c);
                this.f93c.mFramebuffer = null;
                this.f93c = null;
            }
        }
        if (!this.f94d.isEmpty()) {
            for (FrameItem next : this.f94d) {
                GLFramebuffer gLFramebuffer3 = next.mFramebuffer;
                if (gLFramebuffer3 != null) {
                    gLFramebuffer3.unInit();
                    deleteSync(next);
                    next.mFramebuffer = null;
                }
            }
        }
        this.f94d.clear();
        while (!this.f95e.isEmpty()) {
            FrameItem poll = this.f95e.poll();
            if (poll != null) {
                GLFramebuffer gLFramebuffer4 = poll.mFramebuffer;
                if (gLFramebuffer4 != null) {
                    gLFramebuffer4.unInit();
                    deleteSync(poll);
                    poll.mFramebuffer = null;
                }
            }
        }
        this.f95e.clear();
        this.f96f = false;
    }
}
