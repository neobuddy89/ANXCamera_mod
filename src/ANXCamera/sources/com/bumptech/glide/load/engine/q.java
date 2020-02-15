package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.util.a.d;

/* compiled from: Engine */
class q implements d.a<EngineJob<?>> {
    final /* synthetic */ Engine.EngineJobFactory this$0;

    q(Engine.EngineJobFactory engineJobFactory) {
        this.this$0 = engineJobFactory;
    }

    public EngineJob<?> create() {
        Engine.EngineJobFactory engineJobFactory = this.this$0;
        EngineJob engineJob = new EngineJob(engineJobFactory.Qb, engineJobFactory.Pb, engineJobFactory.sf, engineJobFactory.Ub, engineJobFactory.listener, engineJobFactory.pool);
        return engineJob;
    }
}
