package b6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c1 extends k0 {

    /* renamed from: q, reason: collision with root package name */
    public static final Object[] f1365q;

    /* renamed from: r, reason: collision with root package name */
    public static final c1 f1366r;

    /* renamed from: l, reason: collision with root package name */
    public final transient Object[] f1367l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f1368m;

    /* renamed from: n, reason: collision with root package name */
    public final transient Object[] f1369n;

    /* renamed from: o, reason: collision with root package name */
    public final transient int f1370o;

    /* renamed from: p, reason: collision with root package name */
    public final transient int f1371p;

    static {
        Object[] objArr = new Object[0];
        f1365q = objArr;
        f1366r = new c1(0, 0, 0, objArr, objArr);
    }

    public c1(int i9, int i10, int i11, Object[] objArr, Object[] objArr2) {
        this.f1367l = objArr;
        this.f1368m = i9;
        this.f1369n = objArr2;
        this.f1370o = i10;
        this.f1371p = i11;
    }

    @Override // b6.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f1369n;
            if (objArr.length != 0) {
                int n4 = q.n(obj);
                while (true) {
                    int i9 = n4 & this.f1370o;
                    Object obj2 = objArr[i9];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    n4 = i9 + 1;
                }
            }
        }
        return false;
    }

    @Override // b6.b0
    public final int g(int i9, Object[] objArr) {
        Object[] objArr2 = this.f1367l;
        int i10 = this.f1371p;
        System.arraycopy(objArr2, 0, objArr, i9, i10);
        return i9 + i10;
    }

    @Override // b6.b0
    public final Object[] h() {
        return this.f1367l;
    }

    @Override // b6.k0, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f1368m;
    }

    @Override // b6.b0
    public final int i() {
        return this.f1371p;
    }

    @Override // b6.b0
    public final int j() {
        return 0;
    }

    @Override // b6.b0
    public final boolean k() {
        return false;
    }

    @Override // b6.k0
    public final g0 o() {
        return g0.l(this.f1371p, this.f1367l);
    }

    @Override // b6.k0
    /* renamed from: p */
    public final k1 iterator() {
        return f().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f1371p;
    }
}
