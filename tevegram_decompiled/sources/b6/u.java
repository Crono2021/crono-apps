package b6;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u extends AbstractMap implements Serializable {

    /* renamed from: r, reason: collision with root package name */
    public static final Object f1450r = new Object();

    /* renamed from: i, reason: collision with root package name */
    public transient Object f1451i;

    /* renamed from: j, reason: collision with root package name */
    public transient int[] f1452j;

    /* renamed from: k, reason: collision with root package name */
    public transient Object[] f1453k;

    /* renamed from: l, reason: collision with root package name */
    public transient Object[] f1454l;

    /* renamed from: m, reason: collision with root package name */
    public transient int f1455m;

    /* renamed from: n, reason: collision with root package name */
    public transient int f1456n;

    /* renamed from: o, reason: collision with root package name */
    public transient s f1457o;

    /* renamed from: p, reason: collision with root package name */
    public transient s f1458p;

    /* renamed from: q, reason: collision with root package name */
    public transient n f1459q;

    public static u a(int i9) {
        u uVar = new u();
        if (i9 >= 0) {
            uVar.f1455m = a.a.k(i9, 1);
            return uVar;
        }
        m7.c.n("Expected size must be >= 0");
        return null;
    }

    public final Map b() {
        Object obj = this.f1451i;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int c() {
        return (1 << (this.f1455m & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (f()) {
            return;
        }
        this.f1455m += 32;
        Map b9 = b();
        if (b9 != null) {
            this.f1455m = a.a.k(size(), 3);
            b9.clear();
            this.f1451i = null;
            this.f1456n = 0;
            return;
        }
        Arrays.fill(i(), 0, this.f1456n, (Object) null);
        Arrays.fill(j(), 0, this.f1456n, (Object) null);
        Object obj = this.f1451i;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(h(), 0, this.f1456n, 0);
        this.f1456n = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map b9 = b();
        return b9 != null ? b9.containsKey(obj) : d(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map b9 = b();
        if (b9 != null) {
            return b9.containsValue(obj);
        }
        for (int i9 = 0; i9 < this.f1456n; i9++) {
            if (android.support.v4.media.session.b.G(obj, j()[i9])) {
                return true;
            }
        }
        return false;
    }

    public final int d(Object obj) {
        if (f()) {
            return -1;
        }
        int n4 = q.n(obj);
        int c9 = c();
        Object obj2 = this.f1451i;
        Objects.requireNonNull(obj2);
        int o8 = q.o(n4 & c9, obj2);
        if (o8 == 0) {
            return -1;
        }
        int i9 = ~c9;
        int i10 = n4 & i9;
        do {
            int i11 = o8 - 1;
            int i12 = h()[i11];
            if ((i12 & i9) == i10 && android.support.v4.media.session.b.G(obj, i()[i11])) {
                return i11;
            }
            o8 = i12 & c9;
        } while (o8 != 0);
        return -1;
    }

    public final void e(int i9, int i10) {
        Object obj = this.f1451i;
        Objects.requireNonNull(obj);
        int[] h = h();
        Object[] i11 = i();
        Object[] j5 = j();
        int size = size();
        int i12 = size - 1;
        if (i9 >= i12) {
            i11[i9] = null;
            j5[i9] = null;
            h[i9] = 0;
            return;
        }
        Object obj2 = i11[i12];
        i11[i9] = obj2;
        j5[i9] = j5[i12];
        i11[i12] = null;
        j5[i12] = null;
        h[i9] = h[i12];
        h[i12] = 0;
        int n4 = q.n(obj2) & i10;
        int o8 = q.o(n4, obj);
        if (o8 == size) {
            q.p(n4, i9 + 1, obj);
            return;
        }
        while (true) {
            int i13 = o8 - 1;
            int i14 = h[i13];
            int i15 = i14 & i10;
            if (i15 == size) {
                h[i13] = q.j(i14, i9 + 1, i10);
                return;
            }
            o8 = i15;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        s sVar = this.f1458p;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 0);
        this.f1458p = sVar2;
        return sVar2;
    }

    public final boolean f() {
        return this.f1451i == null;
    }

    public final Object g(Object obj) {
        if (!f()) {
            int c9 = c();
            Object obj2 = this.f1451i;
            Objects.requireNonNull(obj2);
            int k3 = q.k(obj, null, c9, obj2, h(), i(), null);
            if (k3 != -1) {
                Object obj3 = j()[k3];
                e(k3, c9);
                this.f1456n--;
                this.f1455m += 32;
                return obj3;
            }
        }
        return f1450r;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map b9 = b();
        if (b9 != null) {
            return b9.get(obj);
        }
        int d9 = d(obj);
        if (d9 == -1) {
            return null;
        }
        return j()[d9];
    }

    public final int[] h() {
        int[] iArr = this.f1452j;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] i() {
        Object[] objArr = this.f1453k;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Object[] j() {
        Object[] objArr = this.f1454l;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final int k(int i9, int i10, int i11, int i12) {
        Object c9 = q.c(i10);
        int i13 = i10 - 1;
        if (i12 != 0) {
            q.p(i11 & i13, i12 + 1, c9);
        }
        Object obj = this.f1451i;
        Objects.requireNonNull(obj);
        int[] h = h();
        for (int i14 = 0; i14 <= i9; i14++) {
            int o8 = q.o(i14, obj);
            while (o8 != 0) {
                int i15 = o8 - 1;
                int i16 = h[i15];
                int i17 = ((~i9) & i16) | i14;
                int i18 = i17 & i13;
                int o9 = q.o(i18, c9);
                q.p(i18, o8, c9);
                h[i15] = q.j(i17, o9, i13);
                o8 = i16 & i9;
            }
        }
        this.f1451i = c9;
        this.f1455m = q.j(this.f1455m, 32 - Integer.numberOfLeadingZeros(i13), 31);
        return i13;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        s sVar = this.f1457o;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this, 1);
        this.f1457o = sVar2;
        return sVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00f1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0104 -> B:47:0x00ea). Please report as a decompilation issue!!! */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object put(java.lang.Object r23, java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.u.put(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map b9 = b();
        if (b9 != null) {
            return b9.remove(obj);
        }
        Object g9 = g(obj);
        if (g9 == f1450r) {
            return null;
        }
        return g9;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map b9 = b();
        return b9 != null ? b9.size() : this.f1456n;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        n nVar = this.f1459q;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(1, this);
        this.f1459q = nVar2;
        return nVar2;
    }
}
