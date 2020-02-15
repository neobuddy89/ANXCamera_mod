package com.arcsoft.camera.utils;

/* compiled from: MSize */
public class g implements Comparable<g> {

    /* renamed from: a  reason: collision with root package name */
    private int f168a;

    /* renamed from: b  reason: collision with root package name */
    private int f169b;

    public g() {
    }

    public g(int i, int i2) {
        this.f168a = i;
        this.f169b = i2;
    }

    /* renamed from: a */
    public int i(g gVar) {
        if (gVar == null) {
            return 1;
        }
        int i = this.f168a;
        int i2 = gVar.f168a;
        return i == i2 ? this.f169b - gVar.f169b : i - i2;
    }

    public String a() {
        return new String("[" + this.f168a + "," + this.f169b + "]");
    }

    public boolean a(int i, int i2) {
        return this.f168a == i && this.f169b == i2;
    }

    public int b() {
        return (this.f168a * 31) + this.f169b;
    }

    public boolean h(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g) || obj == null) {
            return false;
        }
        g gVar = (g) obj;
        return a(gVar.f168a, gVar.f169b);
    }
}
