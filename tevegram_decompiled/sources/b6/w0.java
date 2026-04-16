package b6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w0 extends g0 {

    /* renamed from: m, reason: collision with root package name */
    public static final w0 f1464m = new w0(0, new Object[0]);

    /* renamed from: k, reason: collision with root package name */
    public final transient Object[] f1465k;

    /* renamed from: l, reason: collision with root package name */
    public final transient int f1466l;

    public w0(int i9, Object[] objArr) {
        this.f1465k = objArr;
        this.f1466l = i9;
    }

    @Override // b6.g0, b6.b0
    public final int g(int i9, Object[] objArr) {
        Object[] objArr2 = this.f1465k;
        int i10 = this.f1466l;
        System.arraycopy(objArr2, 0, objArr, i9, i10);
        return i9 + i10;
    }

    @Override // java.util.List
    public final Object get(int i9) {
        com.bumptech.glide.c.f(i9, this.f1466l);
        Object obj = this.f1465k[i9];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // b6.b0
    public final Object[] h() {
        return this.f1465k;
    }

    @Override // b6.b0
    public final int i() {
        return this.f1466l;
    }

    @Override // b6.b0
    public final int j() {
        return 0;
    }

    @Override // b6.b0
    public final boolean k() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1466l;
    }
}
