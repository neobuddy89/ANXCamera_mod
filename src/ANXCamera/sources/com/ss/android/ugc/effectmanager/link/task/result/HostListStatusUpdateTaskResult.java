package com.ss.android.ugc.effectmanager.link.task.result;

import com.ss.android.ugc.effectmanager.common.task.BaseTaskResult;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.link.model.host.Host;
import java.util.ArrayList;
import java.util.List;

public class HostListStatusUpdateTaskResult extends BaseTaskResult {
    private ExceptionResult mExceptionResult;
    private List<Host> mHosts = new ArrayList();

    public HostListStatusUpdateTaskResult(List<Host> list, ExceptionResult exceptionResult) {
        this.mHosts.clear();
        this.mHosts.addAll(list);
        this.mExceptionResult = exceptionResult;
    }

    public ExceptionResult getExceptionResult() {
        return this.mExceptionResult;
    }

    public List<Host> getHosts() {
        return this.mHosts;
    }

    public void setExceptionResult(ExceptionResult exceptionResult) {
        this.mExceptionResult = exceptionResult;
    }

    public void setHosts(List<Host> list) {
        this.mHosts = list;
    }

    public String toString() {
        String str = "HostListStatusUpdateTaskResult{ Hosts{";
        while (this.mHosts.iterator().hasNext()) {
            str = str + r0.next().toString() + ", ";
        }
        return str + " }, mExceptionResult=" + this.mExceptionResult + '}';
    }
}
