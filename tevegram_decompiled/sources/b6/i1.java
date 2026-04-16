package b6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i1 extends k0 {

    /* renamed from: l, reason: collision with root package name */
    public final transient Object f1401l;

    public i1(Object obj) {
        obj.getClass();
        this.f1401l = obj;
    }

    @Override // b6.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f1401l.equals(obj);
    }

    @Override // b6.k0, b6.b0
    public final g0 f() {
        return g0.q(this.f1401l);
    }

    @Override // b6.b0
    public final int g(int i9, Object[] objArr) {
        objArr[i9] = this.f1401l;
        return i9 + 1;
    }

    @Override // b6.k0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f1401l.hashCode();
    }

    @Override // b6.b0
    public final boolean k() {
        return false;
    }

    @Override // b6.k0
    /* renamed from: p */
    public final k1 iterator() {
        return new m0(this.f1401l);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.f1401l.toString() + ']';
    }
}
