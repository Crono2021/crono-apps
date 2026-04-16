package b6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a1 extends g0 {

    /* renamed from: k, reason: collision with root package name */
    public final transient Object[] f1347k;

    /* renamed from: l, reason: collision with root package name */
    public final transient int f1348l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f1349m;

    public a1(Object[] objArr, int i9, int i10) {
        this.f1347k = objArr;
        this.f1348l = i9;
        this.f1349m = i10;
    }

    @Override // java.util.List
    public final Object get(int i9) {
        com.bumptech.glide.c.f(i9, this.f1349m);
        Object obj = this.f1347k[(i9 * 2) + this.f1348l];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // b6.b0
    public final boolean k() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1349m;
    }
}
