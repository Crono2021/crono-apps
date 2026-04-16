package b6;

import java.util.AbstractMap;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x0 extends g0 {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ y0 f1468k;

    public x0(y0 y0Var) {
        this.f1468k = y0Var;
    }

    @Override // java.util.List
    public final Object get(int i9) {
        y0 y0Var = this.f1468k;
        com.bumptech.glide.c.f(i9, y0Var.f1474n);
        Object[] objArr = y0Var.f1473m;
        int i10 = i9 * 2;
        Object obj = objArr[i10];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i10 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // b6.b0
    public final boolean k() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1468k.f1474n;
    }
}
