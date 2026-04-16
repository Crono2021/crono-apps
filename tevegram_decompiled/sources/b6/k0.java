package b6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class k0 extends b0 implements Set {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f1405k = 0;

    /* renamed from: j, reason: collision with root package name */
    public transient g0 f1406j;

    public static int l(int i9) {
        int max = Math.max(i9, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max < 1073741824) {
            return 1073741824;
        }
        m7.c.n("collection too large");
        return 0;
    }

    public static k0 m(int i9, Object... objArr) {
        if (i9 == 0) {
            return c1.f1366r;
        }
        if (i9 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new i1(obj);
        }
        int l4 = l(i9);
        Object[] objArr2 = new Object[l4];
        int i10 = l4 - 1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i9; i13++) {
            Object obj2 = objArr[i13];
            if (obj2 == null) {
                m7.c.o(androidx.activity.g.m(i13, "at index "));
                return null;
            }
            int hashCode = obj2.hashCode();
            int m9 = q.m(hashCode);
            while (true) {
                int i14 = m9 & i10;
                Object obj3 = objArr2[i14];
                if (obj3 == null) {
                    objArr[i12] = obj2;
                    objArr2[i14] = obj2;
                    i11 += hashCode;
                    i12++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                m9++;
            }
        }
        Arrays.fill(objArr, i12, i9, (Object) null);
        if (i12 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new i1(obj4);
        }
        if (l(i12) < l4 / 2) {
            return m(i12, objArr);
        }
        int length = objArr.length;
        if (i12 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i12);
        }
        return new c1(i11, i10, i12, objArr, objArr2);
    }

    public static k0 n(Collection collection) {
        if ((collection instanceof k0) && !(collection instanceof SortedSet)) {
            k0 k0Var = (k0) collection;
            if (!k0Var.k()) {
                return k0Var;
            }
        }
        Object[] array = collection.toArray();
        return m(array.length, array);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof k0) && (this instanceof c1) && (((k0) obj) instanceof c1) && hashCode() != obj.hashCode()) {
            return false;
        }
        return q.e(this, obj);
    }

    @Override // b6.b0
    public g0 f() {
        g0 g0Var = this.f1406j;
        if (g0Var != null) {
            return g0Var;
        }
        g0 o8 = o();
        this.f1406j = o8;
        return o8;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return q.h(this);
    }

    public g0 o() {
        Object[] array = toArray(b0.f1351i);
        e0 e0Var = g0.f1391j;
        return g0.l(array.length, array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public abstract k1 iterator();
}
