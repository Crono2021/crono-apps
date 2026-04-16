package s;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements Collection, Set {

    /* renamed from: l, reason: collision with root package name */
    public static Object[] f8631l;

    /* renamed from: m, reason: collision with root package name */
    public static int f8632m;

    /* renamed from: n, reason: collision with root package name */
    public static Object[] f8633n;

    /* renamed from: o, reason: collision with root package name */
    public static int f8634o;

    /* renamed from: p, reason: collision with root package name */
    public static final Object f8635p = new Object();

    /* renamed from: q, reason: collision with root package name */
    public static final Object f8636q = new Object();

    /* renamed from: i, reason: collision with root package name */
    public int[] f8637i;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f8638j;

    /* renamed from: k, reason: collision with root package name */
    public int f8639k;

    public e(int i9) {
        if (i9 == 0) {
            this.f8637i = f.f8640a;
            this.f8638j = f.f8641b;
        } else {
            f(i9);
        }
        this.f8639k = 0;
    }

    public static void g(int[] iArr, Object[] objArr, int i9) {
        if (iArr.length == 8) {
            synchronized (f8636q) {
                try {
                    if (f8634o < 10) {
                        objArr[0] = f8633n;
                        objArr[1] = iArr;
                        for (int i10 = i9 - 1; i10 >= 2; i10--) {
                            objArr[i10] = null;
                        }
                        f8633n = objArr;
                        f8634o++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (f8635p) {
                try {
                    if (f8632m < 10) {
                        objArr[0] = f8631l;
                        objArr[1] = iArr;
                        for (int i11 = i9 - 1; i11 >= 2; i11--) {
                            objArr[i11] = null;
                        }
                        f8631l = objArr;
                        f8632m++;
                    }
                } finally {
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i9;
        int h;
        int i10 = this.f8639k;
        if (obj == null) {
            h = i();
            i9 = 0;
        } else {
            int hashCode = obj.hashCode();
            i9 = hashCode;
            h = h(hashCode, obj);
        }
        if (h >= 0) {
            return false;
        }
        int i11 = ~h;
        int[] iArr = this.f8637i;
        if (i10 >= iArr.length) {
            int i12 = 8;
            if (i10 >= 8) {
                i12 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i12 = 4;
            }
            Object[] objArr = this.f8638j;
            f(i12);
            if (i10 != this.f8639k) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f8637i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f8638j, 0, objArr.length);
            }
            g(iArr, objArr, i10);
        }
        if (i11 < i10) {
            int[] iArr3 = this.f8637i;
            int i13 = i11 + 1;
            int i14 = i10 - i11;
            System.arraycopy(iArr3, i11, iArr3, i13, i14);
            Object[] objArr2 = this.f8638j;
            System.arraycopy(objArr2, i11, objArr2, i13, i14);
        }
        int i15 = this.f8639k;
        if (i10 == i15) {
            int[] iArr4 = this.f8637i;
            if (i11 < iArr4.length) {
                iArr4[i11] = i9;
                this.f8638j[i11] = obj;
                this.f8639k = i15 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f8639k;
        int i9 = this.f8639k;
        int[] iArr = this.f8637i;
        boolean z8 = false;
        if (iArr.length < size) {
            Object[] objArr = this.f8638j;
            f(size);
            int i10 = this.f8639k;
            if (i10 > 0) {
                System.arraycopy(iArr, 0, this.f8637i, 0, i10);
                System.arraycopy(objArr, 0, this.f8638j, 0, this.f8639k);
            }
            g(iArr, objArr, this.f8639k);
        }
        if (this.f8639k != i9) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            z8 |= add(it.next());
        }
        return z8;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i9 = this.f8639k;
        if (i9 != 0) {
            int[] iArr = this.f8637i;
            Object[] objArr = this.f8638j;
            this.f8637i = f.f8640a;
            this.f8638j = f.f8641b;
            this.f8639k = 0;
            g(iArr, objArr, i9);
        }
        if (this.f8639k != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? i() : h(obj.hashCode(), obj)) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f8639k != set.size()) {
                return false;
            }
            for (int i9 = 0; i9 < this.f8639k; i9++) {
                try {
                    if (!set.contains(this.f8638j[i9])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final void f(int i9) {
        if (i9 == 8) {
            synchronized (f8636q) {
                try {
                    Object[] objArr = f8633n;
                    if (objArr != null) {
                        try {
                            this.f8638j = objArr;
                            f8633n = (Object[]) objArr[0];
                            int[] iArr = (int[]) objArr[1];
                            this.f8637i = iArr;
                            if (iArr != null) {
                                objArr[1] = null;
                                objArr[0] = null;
                                f8634o--;
                                return;
                            }
                        } catch (ClassCastException unused) {
                        }
                        System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr[0] + " [1]=" + objArr[1]);
                        f8633n = null;
                        f8634o = 0;
                    }
                } finally {
                }
            }
        } else if (i9 == 4) {
            synchronized (f8635p) {
                try {
                    Object[] objArr2 = f8631l;
                    if (objArr2 != null) {
                        try {
                            this.f8638j = objArr2;
                            f8631l = (Object[]) objArr2[0];
                            int[] iArr2 = (int[]) objArr2[1];
                            this.f8637i = iArr2;
                            if (iArr2 != null) {
                                objArr2[1] = null;
                                objArr2[0] = null;
                                f8632m--;
                                return;
                            }
                        } catch (ClassCastException unused2) {
                        }
                        System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr2[0] + " [1]=" + objArr2[1]);
                        f8631l = null;
                        f8632m = 0;
                    }
                } finally {
                }
            }
        }
        this.f8637i = new int[i9];
        this.f8638j = new Object[i9];
    }

    public final int h(int i9, Object obj) {
        int i10 = this.f8639k;
        if (i10 == 0) {
            return -1;
        }
        try {
            int a9 = f.a(i10, i9, this.f8637i);
            if (a9 < 0 || obj.equals(this.f8638j[a9])) {
                return a9;
            }
            int i11 = a9 + 1;
            while (i11 < i10 && this.f8637i[i11] == i9) {
                if (obj.equals(this.f8638j[i11])) {
                    return i11;
                }
                i11++;
            }
            for (int i12 = a9 - 1; i12 >= 0 && this.f8637i[i12] == i9; i12--) {
                if (obj.equals(this.f8638j[i12])) {
                    return i12;
                }
            }
            return ~i11;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f8637i;
        int i9 = this.f8639k;
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            i10 += iArr[i11];
        }
        return i10;
    }

    public final int i() {
        int i9 = this.f8639k;
        if (i9 == 0) {
            return -1;
        }
        try {
            int a9 = f.a(i9, 0, this.f8637i);
            if (a9 < 0 || this.f8638j[a9] == null) {
                return a9;
            }
            int i10 = a9 + 1;
            while (i10 < i9 && this.f8637i[i10] == 0) {
                if (this.f8638j[i10] == null) {
                    return i10;
                }
                i10++;
            }
            for (int i11 = a9 - 1; i11 >= 0 && this.f8637i[i11] == 0; i11--) {
                if (this.f8638j[i11] == null) {
                    return i11;
                }
            }
            return ~i10;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f8639k <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new a(this);
    }

    public final void j(int i9) {
        int i10 = this.f8639k;
        Object[] objArr = this.f8638j;
        Object obj = objArr[i9];
        if (i10 <= 1) {
            clear();
            return;
        }
        int i11 = i10 - 1;
        int[] iArr = this.f8637i;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            if (i9 < i11) {
                int i12 = i9 + 1;
                int i13 = i11 - i9;
                System.arraycopy(iArr, i12, iArr, i9, i13);
                Object[] objArr2 = this.f8638j;
                System.arraycopy(objArr2, i12, objArr2, i9, i13);
            }
            this.f8638j[i11] = null;
        } else {
            f(i10 > 8 ? i10 + (i10 >> 1) : 8);
            if (i9 > 0) {
                System.arraycopy(iArr, 0, this.f8637i, 0, i9);
                System.arraycopy(objArr, 0, this.f8638j, 0, i9);
            }
            if (i9 < i11) {
                int i14 = i9 + 1;
                int i15 = i11 - i9;
                System.arraycopy(iArr, i14, this.f8637i, i9, i15);
                System.arraycopy(objArr, i14, this.f8638j, i9, i15);
            }
        }
        if (i10 != this.f8639k) {
            throw new ConcurrentModificationException();
        }
        this.f8639k = i11;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i9 = obj == null ? i() : h(obj.hashCode(), obj);
        if (i9 < 0) {
            return false;
        }
        j(i9);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z8 = false;
        while (it.hasNext()) {
            z8 |= remove(it.next());
        }
        return z8;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z8 = false;
        for (int i9 = this.f8639k - 1; i9 >= 0; i9--) {
            if (!collection.contains(this.f8638j[i9])) {
                j(i9);
                z8 = true;
            }
        }
        return z8;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f8639k;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f8639k) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f8639k);
        }
        System.arraycopy(this.f8638j, 0, objArr, 0, this.f8639k);
        int length = objArr.length;
        int i9 = this.f8639k;
        if (length > i9) {
            objArr[i9] = null;
        }
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f8639k * 14);
        sb.append('{');
        for (int i9 = 0; i9 < this.f8639k; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            Object obj = this.f8638j[i9];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i9 = this.f8639k;
        Object[] objArr = new Object[i9];
        System.arraycopy(this.f8638j, 0, objArr, 0, i9);
        return objArr;
    }
}
