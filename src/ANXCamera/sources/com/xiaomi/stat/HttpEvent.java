package com.xiaomi.stat;

public class HttpEvent {

    /* renamed from: a  reason: collision with root package name */
    private int f293a;

    /* renamed from: b  reason: collision with root package name */
    private long f294b;

    /* renamed from: c  reason: collision with root package name */
    private long f295c;

    /* renamed from: d  reason: collision with root package name */
    private String f296d;

    /* renamed from: e  reason: collision with root package name */
    private String f297e;

    public HttpEvent(String str, long j) {
        this(str, j, -1, (String) null);
    }

    public HttpEvent(String str, long j, int i, String str2) {
        this(str, j, 0, i, str2);
    }

    public HttpEvent(String str, long j, long j2) {
        this(str, j, j2, -1, (String) null);
    }

    public HttpEvent(String str, long j, long j2, int i) {
        this(str, j, j2, i, (String) null);
    }

    public HttpEvent(String str, long j, long j2, int i, String str2) {
        this.f295c = 0;
        this.f296d = str;
        this.f294b = j;
        this.f293a = i;
        this.f297e = str2;
        this.f295c = j2;
    }

    public HttpEvent(String str, long j, String str2) {
        this(str, j, -1, str2);
    }

    public String getExceptionName() {
        return this.f297e;
    }

    public long getNetFlow() {
        return this.f295c;
    }

    public int getResponseCode() {
        return this.f293a;
    }

    public long getTimeCost() {
        return this.f294b;
    }

    public String getUrl() {
        return this.f296d;
    }
}
