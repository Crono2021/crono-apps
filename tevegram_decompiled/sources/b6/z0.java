package b6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z0 extends k0 {

    /* renamed from: l, reason: collision with root package name */
    public final transient b1 f1476l;

    /* renamed from: m, reason: collision with root package name */
    public final transient a1 f1477m;

    public z0(b1 b1Var, a1 a1Var) {
        this.f1476l = b1Var;
        this.f1477m = a1Var;
    }

    @Override // b6.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f1476l.get(obj) != null;
    }

    @Override // b6.k0, b6.b0
    public final g0 f() {
        return this.f1477m;
    }

    @Override // b6.b0
    public final int g(int i9, Object[] objArr) {
        return this.f1477m.g(i9, objArr);
    }

    @Override // b6.b0
    public final boolean k() {
        return true;
    }

    @Override // b6.k0
    /* renamed from: p */
    public final k1 iterator() {
        return this.f1477m.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f1476l.f1358n;
    }
}
