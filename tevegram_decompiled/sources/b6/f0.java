package b6;

import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f0 extends g0 {

    /* renamed from: k, reason: collision with root package name */
    public final transient int f1385k;

    /* renamed from: l, reason: collision with root package name */
    public final transient int f1386l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ g0 f1387m;

    public f0(g0 g0Var, int i9, int i10) {
        this.f1387m = g0Var;
        this.f1385k = i9;
        this.f1386l = i10;
    }

    @Override // java.util.List
    public final Object get(int i9) {
        com.bumptech.glide.c.f(i9, this.f1386l);
        return this.f1387m.get(i9 + this.f1385k);
    }

    @Override // b6.b0
    public final Object[] h() {
        return this.f1387m.h();
    }

    @Override // b6.b0
    public final int i() {
        return this.f1387m.j() + this.f1385k + this.f1386l;
    }

    @Override // b6.g0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // b6.b0
    public final int j() {
        return this.f1387m.j() + this.f1385k;
    }

    @Override // b6.b0
    public final boolean k() {
        return true;
    }

    @Override // b6.g0, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1386l;
    }

    @Override // b6.g0, java.util.List
    /* renamed from: t */
    public final g0 subList(int i9, int i10) {
        com.bumptech.glide.c.h(i9, i10, this.f1386l);
        int i11 = this.f1385k;
        return this.f1387m.subList(i9 + i11, i10 + i11);
    }

    @Override // b6.g0, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i9) {
        return listIterator(i9);
    }
}
