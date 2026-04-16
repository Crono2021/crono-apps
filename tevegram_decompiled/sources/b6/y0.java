package b6;

import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y0 extends k0 {

    /* renamed from: l, reason: collision with root package name */
    public final transient b1 f1472l;

    /* renamed from: m, reason: collision with root package name */
    public final transient Object[] f1473m;

    /* renamed from: n, reason: collision with root package name */
    public final transient int f1474n;

    public y0(b1 b1Var, Object[] objArr, int i9) {
        this.f1472l = b1Var;
        this.f1473m = objArr;
        this.f1474n = i9;
    }

    @Override // b6.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f1472l.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // b6.b0
    public final int g(int i9, Object[] objArr) {
        return f().g(i9, objArr);
    }

    @Override // b6.b0
    public final boolean k() {
        return true;
    }

    @Override // b6.k0
    public final g0 o() {
        return new x0(this);
    }

    @Override // b6.k0
    /* renamed from: p */
    public final k1 iterator() {
        return f().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f1474n;
    }
}
