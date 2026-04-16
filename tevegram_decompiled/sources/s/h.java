package s;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class h {

    /* renamed from: l, reason: collision with root package name */
    public static Object[] f8647l;

    /* renamed from: m, reason: collision with root package name */
    public static int f8648m;

    /* renamed from: n, reason: collision with root package name */
    public static Object[] f8649n;

    /* renamed from: o, reason: collision with root package name */
    public static int f8650o;

    /* renamed from: i, reason: collision with root package name */
    public int[] f8651i = f.f8640a;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f8652j = f.f8641b;

    /* renamed from: k, reason: collision with root package name */
    public int f8653k = 0;

    public static void c(int[] iArr, Object[] objArr, int i9) {
        if (iArr.length == 8) {
            synchronized (h.class) {
                try {
                    if (f8650o < 10) {
                        objArr[0] = f8649n;
                        objArr[1] = iArr;
                        for (int i10 = (i9 << 1) - 1; i10 >= 2; i10--) {
                            objArr[i10] = null;
                        }
                        f8649n = objArr;
                        f8650o++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (h.class) {
                try {
                    if (f8648m < 10) {
                        objArr[0] = f8647l;
                        objArr[1] = iArr;
                        for (int i11 = (i9 << 1) - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        f8647l = objArr;
                        f8648m++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i9) {
        if (i9 == 8) {
            synchronized (h.class) {
                try {
                    Object[] objArr = f8649n;
                    if (objArr != null) {
                        this.f8652j = objArr;
                        f8649n = (Object[]) objArr[0];
                        this.f8651i = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f8650o--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i9 == 4) {
            synchronized (h.class) {
                try {
                    Object[] objArr2 = f8647l;
                    if (objArr2 != null) {
                        this.f8652j = objArr2;
                        f8647l = (Object[]) objArr2[0];
                        this.f8651i = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f8648m--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f8651i = new int[i9];
        this.f8652j = new Object[i9 << 1];
    }

    public final void b(int i9) {
        int i10 = this.f8653k;
        int[] iArr = this.f8651i;
        if (iArr.length < i9) {
            Object[] objArr = this.f8652j;
            a(i9);
            if (this.f8653k > 0) {
                System.arraycopy(iArr, 0, this.f8651i, 0, i10);
                System.arraycopy(objArr, 0, this.f8652j, 0, i10 << 1);
            }
            c(iArr, objArr, i10);
        }
        if (this.f8653k != i10) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i9 = this.f8653k;
        if (i9 > 0) {
            int[] iArr = this.f8651i;
            Object[] objArr = this.f8652j;
            this.f8651i = f.f8640a;
            this.f8652j = f.f8641b;
            this.f8653k = 0;
            c(iArr, objArr, i9);
        }
        if (this.f8653k > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final int d(int i9, Object obj) {
        int i10 = this.f8653k;
        if (i10 == 0) {
            return -1;
        }
        try {
            int a9 = f.a(i10, i9, this.f8651i);
            if (a9 < 0 || obj.equals(this.f8652j[a9 << 1])) {
                return a9;
            }
            int i11 = a9 + 1;
            while (i11 < i10 && this.f8651i[i11] == i9) {
                if (obj.equals(this.f8652j[i11 << 1])) {
                    return i11;
                }
                i11++;
            }
            for (int i12 = a9 - 1; i12 >= 0 && this.f8651i[i12] == i9; i12--) {
                if (obj.equals(this.f8652j[i12 << 1])) {
                    return i12;
                }
            }
            return ~i11;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f8653k != hVar.f8653k) {
                return false;
            }
            for (int i9 = 0; i9 < this.f8653k; i9++) {
                Object h = h(i9);
                Object l4 = l(i9);
                Object orDefault = hVar.getOrDefault(h, null);
                if (l4 == null) {
                    if (orDefault != null || !hVar.containsKey(h)) {
                        return false;
                    }
                } else if (!l4.equals(orDefault)) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f8653k != map.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f8653k; i10++) {
                Object h9 = h(i10);
                Object l9 = l(i10);
                Object obj2 = map.get(h9);
                if (l9 == null) {
                    if (obj2 != null || !map.containsKey(h9)) {
                        return false;
                    }
                } else if (!l9.equals(obj2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i9 = this.f8653k;
        if (i9 == 0) {
            return -1;
        }
        try {
            int a9 = f.a(i9, 0, this.f8651i);
            if (a9 < 0 || this.f8652j[a9 << 1] == null) {
                return a9;
            }
            int i10 = a9 + 1;
            while (i10 < i9 && this.f8651i[i10] == 0) {
                if (this.f8652j[i10 << 1] == null) {
                    return i10;
                }
                i10++;
            }
            for (int i11 = a9 - 1; i11 >= 0 && this.f8651i[i11] == 0; i11--) {
                if (this.f8652j[i11 << 1] == null) {
                    return i11;
                }
            }
            return ~i10;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int g(Object obj) {
        int i9 = this.f8653k * 2;
        Object[] objArr = this.f8652j;
        if (obj == null) {
            for (int i10 = 1; i10 < i9; i10 += 2) {
                if (objArr[i10] == null) {
                    return i10 >> 1;
                }
            }
            return -1;
        }
        for (int i11 = 1; i11 < i9; i11 += 2) {
            if (obj.equals(objArr[i11])) {
                return i11 >> 1;
            }
        }
        return -1;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int e9 = e(obj);
        return e9 >= 0 ? this.f8652j[(e9 << 1) + 1] : obj2;
    }

    public final Object h(int i9) {
        return this.f8652j[i9 << 1];
    }

    public int hashCode() {
        int[] iArr = this.f8651i;
        Object[] objArr = this.f8652j;
        int i9 = this.f8653k;
        int i10 = 1;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            Object obj = objArr[i10];
            i12 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i11];
            i11++;
            i10 += 2;
        }
        return i12;
    }

    public void i(d dVar) {
        int i9 = dVar.f8653k;
        b(this.f8653k + i9);
        if (this.f8653k != 0) {
            for (int i10 = 0; i10 < i9; i10++) {
                put(dVar.h(i10), dVar.l(i10));
            }
        } else if (i9 > 0) {
            System.arraycopy(dVar.f8651i, 0, this.f8651i, 0, i9);
            System.arraycopy(dVar.f8652j, 0, this.f8652j, 0, i9 << 1);
            this.f8653k = i9;
        }
    }

    public final boolean isEmpty() {
        return this.f8653k <= 0;
    }

    public Object j(int i9) {
        Object[] objArr = this.f8652j;
        int i10 = i9 << 1;
        Object obj = objArr[i10 + 1];
        int i11 = this.f8653k;
        if (i11 <= 1) {
            clear();
            return obj;
        }
        int i12 = i11 - 1;
        int[] iArr = this.f8651i;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            if (i9 < i12) {
                int i13 = i9 + 1;
                int i14 = i12 - i9;
                System.arraycopy(iArr, i13, iArr, i9, i14);
                Object[] objArr2 = this.f8652j;
                System.arraycopy(objArr2, i13 << 1, objArr2, i10, i14 << 1);
            }
            Object[] objArr3 = this.f8652j;
            int i15 = i12 << 1;
            objArr3[i15] = null;
            objArr3[i15 + 1] = null;
        } else {
            a(i11 > 8 ? i11 + (i11 >> 1) : 8);
            if (i11 != this.f8653k) {
                throw new ConcurrentModificationException();
            }
            if (i9 > 0) {
                System.arraycopy(iArr, 0, this.f8651i, 0, i9);
                System.arraycopy(objArr, 0, this.f8652j, 0, i10);
            }
            if (i9 < i12) {
                int i16 = i9 + 1;
                int i17 = i12 - i9;
                System.arraycopy(iArr, i16, this.f8651i, i9, i17);
                System.arraycopy(objArr, i16 << 1, this.f8652j, i10, i17 << 1);
            }
        }
        if (i11 != this.f8653k) {
            throw new ConcurrentModificationException();
        }
        this.f8653k = i12;
        return obj;
    }

    public Object k(int i9, Object obj) {
        int i10 = (i9 << 1) + 1;
        Object[] objArr = this.f8652j;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    public final Object l(int i9) {
        return this.f8652j[(i9 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i9;
        int d9;
        int i10 = this.f8653k;
        if (obj == null) {
            d9 = f();
            i9 = 0;
        } else {
            int hashCode = obj.hashCode();
            i9 = hashCode;
            d9 = d(hashCode, obj);
        }
        if (d9 >= 0) {
            int i11 = (d9 << 1) + 1;
            Object[] objArr = this.f8652j;
            Object obj3 = objArr[i11];
            objArr[i11] = obj2;
            return obj3;
        }
        int i12 = ~d9;
        int[] iArr = this.f8651i;
        if (i10 >= iArr.length) {
            int i13 = 8;
            if (i10 >= 8) {
                i13 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i13 = 4;
            }
            Object[] objArr2 = this.f8652j;
            a(i13);
            if (i10 != this.f8653k) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f8651i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f8652j, 0, objArr2.length);
            }
            c(iArr, objArr2, i10);
        }
        if (i12 < i10) {
            int[] iArr3 = this.f8651i;
            int i14 = i12 + 1;
            System.arraycopy(iArr3, i12, iArr3, i14, i10 - i12);
            Object[] objArr3 = this.f8652j;
            System.arraycopy(objArr3, i12 << 1, objArr3, i14 << 1, (this.f8653k - i12) << 1);
        }
        int i15 = this.f8653k;
        if (i10 == i15) {
            int[] iArr4 = this.f8651i;
            if (i12 < iArr4.length) {
                iArr4[i12] = i9;
                Object[] objArr4 = this.f8652j;
                int i16 = i12 << 1;
                objArr4[i16] = obj;
                objArr4[i16 + 1] = obj2;
                this.f8653k = i15 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, null);
        return orDefault == null ? put(obj, obj2) : orDefault;
    }

    public final boolean remove(Object obj, Object obj2) {
        int e9 = e(obj);
        if (e9 < 0) {
            return false;
        }
        Object l4 = l(e9);
        if (obj2 != l4 && (obj2 == null || !obj2.equals(l4))) {
            return false;
        }
        j(e9);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int e9 = e(obj);
        if (e9 < 0) {
            return false;
        }
        Object l4 = l(e9);
        if (l4 != obj2 && (obj2 == null || !obj2.equals(l4))) {
            return false;
        }
        k(e9, obj3);
        return true;
    }

    public final int size() {
        return this.f8653k;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f8653k * 28);
        sb.append('{');
        for (int i9 = 0; i9 < this.f8653k; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            Object h = h(i9);
            if (h != this) {
                sb.append(h);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object l4 = l(i9);
            if (l4 != this) {
                sb.append(l4);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object remove(Object obj) {
        int e9 = e(obj);
        if (e9 >= 0) {
            return j(e9);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int e9 = e(obj);
        if (e9 >= 0) {
            return k(e9, obj2);
        }
        return null;
    }
}
