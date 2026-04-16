package b6;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g0 extends b0 implements List, RandomAccess {

    /* renamed from: j, reason: collision with root package name */
    public static final e0 f1391j = new e0(w0.f1464m, 0);

    public static w0 l(int i9, Object[] objArr) {
        return i9 == 0 ? w0.f1464m : new w0(i9, objArr);
    }

    public static g0 m(Collection collection) {
        if (!(collection instanceof b0)) {
            Object[] array = collection.toArray();
            q.a(array.length, array);
            return l(array.length, array);
        }
        g0 f9 = ((b0) collection).f();
        if (!f9.k()) {
            return f9;
        }
        Object[] array2 = f9.toArray(b0.f1351i);
        return l(array2.length, array2);
    }

    public static w0 n(Object[] objArr) {
        if (objArr.length == 0) {
            return w0.f1464m;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        q.a(objArr2.length, objArr2);
        return l(objArr2.length, objArr2);
    }

    public static w0 p(Long l4, Long l9, Long l10, Long l11, Long l12) {
        Object[] objArr = {l4, l9, l10, l11, l12};
        q.a(5, objArr);
        return l(5, objArr);
    }

    public static w0 q(Object obj) {
        Object[] objArr = {obj};
        q.a(1, objArr);
        return l(1, objArr);
    }

    public static w0 r(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        q.a(2, objArr);
        return l(2, objArr);
    }

    public static w0 s(v0 v0Var, AbstractCollection abstractCollection) {
        v0Var.getClass();
        if (!t.a.d(abstractCollection)) {
            Iterator it = abstractCollection.iterator();
            ArrayList arrayList = new ArrayList();
            it.getClass();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            abstractCollection = arrayList;
        }
        Object[] array = abstractCollection.toArray();
        q.a(array.length, array);
        Arrays.sort(array, v0Var);
        return l(array.length, array);
    }

    @Override // java.util.List
    public final void add(int i9, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i9, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // b6.b0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    if (!(list instanceof RandomAccess)) {
                        Iterator it = iterator();
                        Iterator it2 = list.iterator();
                        while (it.hasNext()) {
                            if (it2.hasNext() && android.support.v4.media.session.b.G(it.next(), it2.next())) {
                            }
                        }
                        return !it2.hasNext();
                    }
                    for (int i9 = 0; i9 < size; i9++) {
                        if (android.support.v4.media.session.b.G(get(i9), list.get(i9))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // b6.b0
    public int g(int i9, Object[] objArr) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            objArr[i9 + i10] = get(i10);
        }
        return i9 + size;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i9 = 1;
        for (int i10 = 0; i10 < size; i10++) {
            i9 = ~(~(get(i10).hashCode() + (i9 * 31)));
        }
        return i9;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            if (obj.equals(get(i9))) {
                return i9;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final e0 listIterator(int i9) {
        com.bumptech.glide.c.g(i9, size());
        return isEmpty() ? f1391j : new e0(this, i9);
    }

    @Override // java.util.List
    public final Object remove(int i9) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i9, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public g0 subList(int i9, int i10) {
        com.bumptech.glide.c.h(i9, i10, size());
        int i11 = i10 - i9;
        return i11 == size() ? this : i11 == 0 ? w0.f1464m : new f0(this, i9, i11);
    }

    @Override // b6.b0
    public final g0 f() {
        return this;
    }
}
