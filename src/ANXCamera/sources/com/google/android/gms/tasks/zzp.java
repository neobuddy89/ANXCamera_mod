package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

final class zzp implements Runnable {
    private final /* synthetic */ Task zzg;
    private final /* synthetic */ zzo zzs;

    zzp(zzo zzo, Task task) {
        this.zzs = zzo;
        this.zzg = task;
    }

    public final void run() {
        try {
            Task then = this.zzs.zzr.then(this.zzg.getResult());
            if (then == null) {
                this.zzs.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            then.addOnSuccessListener(TaskExecutors.zzw, this.zzs);
            then.addOnFailureListener(TaskExecutors.zzw, (OnFailureListener) this.zzs);
            then.addOnCanceledListener(TaskExecutors.zzw, (OnCanceledListener) this.zzs);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.zzs.onFailure((Exception) e2.getCause());
            } else {
                this.zzs.onFailure(e2);
            }
        } catch (CancellationException e3) {
            this.zzs.onCanceled();
        } catch (Exception e4) {
            this.zzs.onFailure(e4);
        }
    }
}
