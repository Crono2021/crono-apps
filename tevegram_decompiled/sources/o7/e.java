package o7;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends AbstractList implements List {

    /* renamed from: l, reason: collision with root package name */
    public static final Object[] f8007l = new Object[0];

    /* renamed from: i, reason: collision with root package name */
    public int f8008i;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f8009j = f8007l;

    /* renamed from: k, reason: collision with root package name */
    public int f8010k;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i9, Object obj) {
        int i10;
        int i11 = this.f8010k;
        if (i9 < 0 || i9 > i11) {
            m7.c.h(", size: ", "index: ", i9, i11);
            return;
        }
        if (i9 == i11) {
            addLast(obj);
            return;
        }
        if (i9 == 0) {
            l();
            g(this.f8010k + 1);
            int i12 = this.f8008i;
            if (i12 == 0) {
                Object[] objArr = this.f8009j;
                objArr.getClass();
                i12 = objArr.length;
            }
            int i13 = i12 - 1;
            this.f8008i = i13;
            this.f8009j[i13] = obj;
            this.f8010k++;
            return;
        }
        l();
        g(this.f8010k + 1);
        int k3 = k(this.f8008i + i9);
        int i14 = this.f8010k;
        if (i9 < ((i14 + 1) >> 1)) {
            if (k3 == 0) {
                Object[] objArr2 = this.f8009j;
                objArr2.getClass();
                i10 = objArr2.length - 1;
            } else {
                i10 = k3 - 1;
            }
            int i15 = this.f8008i;
            if (i15 == 0) {
                Object[] objArr3 = this.f8009j;
                objArr3.getClass();
                i15 = objArr3.length;
            }
            int i16 = i15 - 1;
            int i17 = this.f8008i;
            Object[] objArr4 = this.f8009j;
            if (i10 >= i17) {
                objArr4[i16] = objArr4[i17];
                f.Z(i17, i17 + 1, i10 + 1, objArr4, objArr4);
            } else {
                f.Z(i17 - 1, i17, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.f8009j;
                objArr5[objArr5.length - 1] = objArr5[0];
                f.Z(0, 1, i10 + 1, objArr5, objArr5);
            }
            this.f8009j[i10] = obj;
            this.f8008i = i16;
        } else {
            int k9 = k(this.f8008i + i14);
            Object[] objArr6 = this.f8009j;
            if (k3 < k9) {
                f.Z(k3 + 1, k3, k9, objArr6, objArr6);
            } else {
                f.Z(1, 0, k9, objArr6, objArr6);
                Object[] objArr7 = this.f8009j;
                objArr7[0] = objArr7[objArr7.length - 1];
                f.Z(k3 + 1, k3, objArr7.length - 1, objArr7, objArr7);
            }
            this.f8009j[k3] = obj;
        }
        this.f8010k++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i9, Collection collection) {
        collection.getClass();
        int i10 = this.f8010k;
        if (i9 < 0 || i9 > i10) {
            m7.c.h(", size: ", "index: ", i9, i10);
            return false;
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i9 == this.f8010k) {
            return addAll(collection);
        }
        l();
        g(collection.size() + this.f8010k);
        int k3 = k(this.f8008i + this.f8010k);
        int k9 = k(this.f8008i + i9);
        int size = collection.size();
        if (i9 >= ((this.f8010k + 1) >> 1)) {
            int i11 = k9 + size;
            Object[] objArr = this.f8009j;
            if (k9 < k3) {
                int i12 = size + k3;
                if (i12 <= objArr.length) {
                    f.Z(i11, k9, k3, objArr, objArr);
                } else if (i11 >= objArr.length) {
                    f.Z(i11 - objArr.length, k9, k3, objArr, objArr);
                } else {
                    int length = k3 - (i12 - objArr.length);
                    f.Z(0, length, k3, objArr, objArr);
                    Object[] objArr2 = this.f8009j;
                    f.Z(i11, k9, length, objArr2, objArr2);
                }
            } else {
                f.Z(size, 0, k3, objArr, objArr);
                Object[] objArr3 = this.f8009j;
                if (i11 >= objArr3.length) {
                    f.Z(i11 - objArr3.length, k9, objArr3.length, objArr3, objArr3);
                } else {
                    f.Z(0, objArr3.length - size, objArr3.length, objArr3, objArr3);
                    Object[] objArr4 = this.f8009j;
                    f.Z(i11, k9, objArr4.length - size, objArr4, objArr4);
                }
            }
            f(k9, collection);
            return true;
        }
        int i13 = this.f8008i;
        int i14 = i13 - size;
        Object[] objArr5 = this.f8009j;
        if (k9 < i13) {
            f.Z(i14, i13, objArr5.length, objArr5, objArr5);
            Object[] objArr6 = this.f8009j;
            if (size >= k9) {
                f.Z(objArr6.length - size, 0, k9, objArr6, objArr6);
            } else {
                f.Z(objArr6.length - size, 0, size, objArr6, objArr6);
                Object[] objArr7 = this.f8009j;
                f.Z(0, size, k9, objArr7, objArr7);
            }
        } else if (i14 >= 0) {
            f.Z(i14, i13, k9, objArr5, objArr5);
        } else {
            i14 += objArr5.length;
            int i15 = k9 - i13;
            int length2 = objArr5.length - i14;
            if (length2 >= i15) {
                f.Z(i14, i13, k9, objArr5, objArr5);
            } else {
                f.Z(i14, i13, i13 + length2, objArr5, objArr5);
                Object[] objArr8 = this.f8009j;
                f.Z(0, this.f8008i + length2, k9, objArr8, objArr8);
            }
        }
        this.f8008i = i14;
        f(i(k9 - size), collection);
        return true;
    }

    public final void addLast(Object obj) {
        l();
        g(this.f8010k + 1);
        this.f8009j[k(this.f8008i + this.f8010k)] = obj;
        this.f8010k++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            l();
            j(this.f8008i, k(this.f8008i + this.f8010k));
        }
        this.f8008i = 0;
        this.f8010k = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void f(int i9, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f8009j.length;
        while (i9 < length && it.hasNext()) {
            this.f8009j[i9] = it.next();
            i9++;
        }
        int i10 = this.f8008i;
        for (int i11 = 0; i11 < i10 && it.hasNext(); i11++) {
            this.f8009j[i11] = it.next();
        }
        this.f8010k = collection.size() + this.f8010k;
    }

    public final void g(int i9) {
        if (i9 < 0) {
            m7.c.p("Deque is too big.");
            return;
        }
        Object[] objArr = this.f8009j;
        if (i9 <= objArr.length) {
            return;
        }
        if (objArr == f8007l) {
            if (i9 < 10) {
                i9 = 10;
            }
            this.f8009j = new Object[i9];
            return;
        }
        int length = objArr.length;
        int i10 = length + (length >> 1);
        if (i10 - i9 < 0) {
            i10 = i9;
        }
        if (i10 - 2147483639 > 0) {
            i10 = i9 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i10];
        f.Z(0, this.f8008i, objArr.length, objArr, objArr2);
        Object[] objArr3 = this.f8009j;
        int length2 = objArr3.length;
        int i11 = this.f8008i;
        f.Z(length2 - i11, 0, i11, objArr3, objArr2);
        this.f8008i = 0;
        this.f8009j = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        int i10 = this.f8010k;
        if (i9 >= 0 && i9 < i10) {
            return this.f8009j[k(this.f8008i + i9)];
        }
        m7.c.h(", size: ", "index: ", i9, i10);
        return null;
    }

    public final int h(int i9) {
        this.f8009j.getClass();
        if (i9 == r0.length - 1) {
            return 0;
        }
        return i9 + 1;
    }

    public final int i(int i9) {
        return i9 < 0 ? i9 + this.f8009j.length : i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i9;
        int k3 = k(this.f8008i + this.f8010k);
        int i10 = this.f8008i;
        if (i10 < k3) {
            while (i10 < k3) {
                if (b8.i.a(obj, this.f8009j[i10])) {
                    i9 = this.f8008i;
                } else {
                    i10++;
                }
            }
            return -1;
        }
        if (i10 < k3) {
            return -1;
        }
        int length = this.f8009j.length;
        while (true) {
            if (i10 >= length) {
                for (int i11 = 0; i11 < k3; i11++) {
                    if (b8.i.a(obj, this.f8009j[i11])) {
                        i10 = i11 + this.f8009j.length;
                        i9 = this.f8008i;
                    }
                }
                return -1;
            }
            if (b8.i.a(obj, this.f8009j[i10])) {
                i9 = this.f8008i;
                break;
            }
            i10++;
        }
        return i10 - i9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f8010k == 0;
    }

    public final void j(int i9, int i10) {
        Object[] objArr = this.f8009j;
        if (i9 < i10) {
            f.a0(objArr, null, i9, i10);
        } else {
            Arrays.fill(objArr, i9, objArr.length, (Object) null);
            f.a0(this.f8009j, null, 0, i10);
        }
    }

    public final int k(int i9) {
        Object[] objArr = this.f8009j;
        return i9 >= objArr.length ? i9 - objArr.length : i9;
    }

    public final void l() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i9;
        int k3 = k(this.f8008i + this.f8010k);
        int i10 = this.f8008i;
        if (i10 < k3) {
            length = k3 - 1;
            if (i10 <= length) {
                while (!b8.i.a(obj, this.f8009j[length])) {
                    if (length != i10) {
                        length--;
                    }
                }
                i9 = this.f8008i;
                return length - i9;
            }
            return -1;
        }
        if (i10 > k3) {
            while (true) {
                k3--;
                Object[] objArr = this.f8009j;
                if (-1 >= k3) {
                    objArr.getClass();
                    length = objArr.length - 1;
                    int i11 = this.f8008i;
                    if (i11 <= length) {
                        while (!b8.i.a(obj, this.f8009j[length])) {
                            if (length != i11) {
                                length--;
                            }
                        }
                        i9 = this.f8008i;
                    }
                } else if (b8.i.a(obj, objArr[k3])) {
                    length = k3 + this.f8009j.length;
                    i9 = this.f8008i;
                    break;
                }
            }
        }
        return -1;
    }

    public final Object m(int i9) {
        int i10 = this.f8010k;
        if (i9 < 0 || i9 >= i10) {
            m7.c.h(", size: ", "index: ", i9, i10);
            return null;
        }
        if (i9 == i10 - 1) {
            if (isEmpty()) {
                throw new NoSuchElementException("ArrayDeque is empty.");
            }
            l();
            int k3 = k((this.f8010k - 1) + this.f8008i);
            Object[] objArr = this.f8009j;
            Object obj = objArr[k3];
            objArr[k3] = null;
            this.f8010k--;
            return obj;
        }
        if (i9 == 0) {
            return removeFirst();
        }
        l();
        int k9 = k(this.f8008i + i9);
        Object[] objArr2 = this.f8009j;
        Object obj2 = objArr2[k9];
        int i11 = this.f8010k;
        int i12 = i11 >> 1;
        int i13 = this.f8008i;
        if (i9 < i12) {
            if (k9 >= i13) {
                f.Z(i13 + 1, i13, k9, objArr2, objArr2);
            } else {
                f.Z(1, 0, k9, objArr2, objArr2);
                Object[] objArr3 = this.f8009j;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i14 = this.f8008i;
                f.Z(i14 + 1, i14, objArr3.length - 1, objArr3, objArr3);
            }
            Object[] objArr4 = this.f8009j;
            int i15 = this.f8008i;
            objArr4[i15] = null;
            this.f8008i = h(i15);
        } else {
            int k10 = k((i11 - 1) + i13);
            Object[] objArr5 = this.f8009j;
            if (k9 <= k10) {
                f.Z(k9, k9 + 1, k10 + 1, objArr5, objArr5);
            } else {
                f.Z(k9, k9 + 1, objArr5.length, objArr5, objArr5);
                Object[] objArr6 = this.f8009j;
                objArr6[objArr6.length - 1] = objArr6[0];
                f.Z(0, 1, k10 + 1, objArr6, objArr6);
            }
            this.f8009j[k10] = null;
        }
        this.f8010k--;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        m(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int k3;
        Object[] objArr;
        collection.getClass();
        boolean z8 = false;
        z8 = false;
        z8 = false;
        if (!isEmpty() && this.f8009j.length != 0) {
            int k9 = k(this.f8008i + this.f8010k);
            int i9 = this.f8008i;
            if (i9 < k9) {
                k3 = i9;
                while (true) {
                    objArr = this.f8009j;
                    if (i9 >= k9) {
                        break;
                    }
                    Object obj = objArr[i9];
                    if (collection.contains(obj)) {
                        z8 = true;
                    } else {
                        this.f8009j[k3] = obj;
                        k3++;
                    }
                    i9++;
                }
                f.a0(objArr, null, k3, k9);
            } else {
                int length = this.f8009j.length;
                int i10 = i9;
                boolean z9 = false;
                while (i9 < length) {
                    Object[] objArr2 = this.f8009j;
                    Object obj2 = objArr2[i9];
                    objArr2[i9] = null;
                    if (collection.contains(obj2)) {
                        z9 = true;
                    } else {
                        this.f8009j[i10] = obj2;
                        i10++;
                    }
                    i9++;
                }
                k3 = k(i10);
                for (int i11 = 0; i11 < k9; i11++) {
                    Object[] objArr3 = this.f8009j;
                    Object obj3 = objArr3[i11];
                    objArr3[i11] = null;
                    if (collection.contains(obj3)) {
                        z9 = true;
                    } else {
                        this.f8009j[k3] = obj3;
                        k3 = h(k3);
                    }
                }
                z8 = z9;
            }
            if (z8) {
                l();
                this.f8010k = i(k3 - this.f8008i);
            }
        }
        return z8;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        l();
        Object[] objArr = this.f8009j;
        int i9 = this.f8008i;
        Object obj = objArr[i9];
        objArr[i9] = null;
        this.f8008i = h(i9);
        this.f8010k--;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        com.bumptech.glide.d.g(i9, i10, this.f8010k);
        int i11 = i10 - i9;
        if (i11 == 0) {
            return;
        }
        if (i11 == this.f8010k) {
            clear();
            return;
        }
        if (i11 == 1) {
            m(i9);
            return;
        }
        l();
        int i12 = this.f8010k - i10;
        int i13 = this.f8008i;
        if (i9 < i12) {
            int k3 = k((i9 - 1) + i13);
            int k9 = k(this.f8008i + (i10 - 1));
            while (i9 > 0) {
                int i14 = k3 + 1;
                int min = Math.min(i9, Math.min(i14, k9 + 1));
                Object[] objArr = this.f8009j;
                int i15 = k9 - min;
                int i16 = k3 - min;
                f.Z(i15 + 1, i16 + 1, i14, objArr, objArr);
                k3 = i(i16);
                k9 = i(i15);
                i9 -= min;
            }
            int k10 = k(this.f8008i + i11);
            j(this.f8008i, k10);
            this.f8008i = k10;
        } else {
            int k11 = k(i13 + i10);
            int k12 = k(this.f8008i + i9);
            int i17 = this.f8010k;
            while (true) {
                i17 -= i10;
                if (i17 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f8009j;
                i10 = Math.min(i17, Math.min(objArr2.length - k11, objArr2.length - k12));
                Object[] objArr3 = this.f8009j;
                int i18 = k11 + i10;
                f.Z(k12, k11, i18, objArr3, objArr3);
                k11 = k(i18);
                k12 = k(k12 + i10);
            }
            int k13 = k(this.f8008i + this.f8010k);
            j(i(k13 - i11), k13);
        }
        this.f8010k -= i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int k3;
        Object[] objArr;
        collection.getClass();
        boolean z8 = false;
        z8 = false;
        z8 = false;
        if (!isEmpty() && this.f8009j.length != 0) {
            int k9 = k(this.f8008i + this.f8010k);
            int i9 = this.f8008i;
            if (i9 < k9) {
                k3 = i9;
                while (true) {
                    objArr = this.f8009j;
                    if (i9 >= k9) {
                        break;
                    }
                    Object obj = objArr[i9];
                    if (collection.contains(obj)) {
                        this.f8009j[k3] = obj;
                        k3++;
                    } else {
                        z8 = true;
                    }
                    i9++;
                }
                f.a0(objArr, null, k3, k9);
            } else {
                int length = this.f8009j.length;
                int i10 = i9;
                boolean z9 = false;
                while (i9 < length) {
                    Object[] objArr2 = this.f8009j;
                    Object obj2 = objArr2[i9];
                    objArr2[i9] = null;
                    if (collection.contains(obj2)) {
                        this.f8009j[i10] = obj2;
                        i10++;
                    } else {
                        z9 = true;
                    }
                    i9++;
                }
                k3 = k(i10);
                for (int i11 = 0; i11 < k9; i11++) {
                    Object[] objArr3 = this.f8009j;
                    Object obj3 = objArr3[i11];
                    objArr3[i11] = null;
                    if (collection.contains(obj3)) {
                        this.f8009j[k3] = obj3;
                        k3 = h(k3);
                    } else {
                        z9 = true;
                    }
                }
                z8 = z9;
            }
            if (z8) {
                l();
                this.f8010k = i(k3 - this.f8008i);
            }
        }
        return z8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i9, Object obj) {
        int i10 = this.f8010k;
        if (i9 < 0 || i9 >= i10) {
            m7.c.h(", size: ", "index: ", i9, i10);
            return null;
        }
        int k3 = k(this.f8008i + i9);
        Object[] objArr = this.f8009j;
        Object obj2 = objArr[k3];
        objArr[k3] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f8010k;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i9 = this.f8010k;
        if (length < i9) {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i9);
            newInstance.getClass();
            objArr = (Object[]) newInstance;
        }
        int k3 = k(this.f8008i + this.f8010k);
        int i10 = this.f8008i;
        if (i10 < k3) {
            f.Z(0, i10, k3, this.f8009j, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f8009j;
            f.Z(0, this.f8008i, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.f8009j;
            f.Z(objArr3.length - this.f8008i, 0, k3, objArr3, objArr);
        }
        int i11 = this.f8010k;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i9) {
        return m(i9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.f8010k]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        l();
        g(collection.size() + this.f8010k);
        f(k(this.f8008i + this.f8010k), collection);
        return true;
    }
}
