package s;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements Set {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ d f8623i;

    public b(d dVar) {
        this.f8623i = dVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f8623i.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f8623i.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.f8623i.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        try {
            if (this.f8623i.f8653k == set.size()) {
                return containsAll(set);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        d dVar = this.f8623i;
        int i9 = 0;
        for (int i10 = dVar.f8653k - 1; i10 >= 0; i10--) {
            Object h = dVar.h(i10);
            i9 += h == null ? 0 : h.hashCode();
        }
        return i9;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f8623i.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f8623i, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        d dVar = this.f8623i;
        int e9 = dVar.e(obj);
        if (e9 < 0) {
            return false;
        }
        dVar.j(e9);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        d dVar = this.f8623i;
        int i9 = dVar.f8653k;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            dVar.remove(it.next());
        }
        return i9 != dVar.f8653k;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        d dVar = this.f8623i;
        int i9 = dVar.f8653k;
        for (int i10 = i9 - 1; i10 >= 0; i10--) {
            if (!collection.contains(dVar.h(i10))) {
                dVar.j(i10);
            }
        }
        return i9 != dVar.f8653k;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f8623i.f8653k;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        d dVar = this.f8623i;
        int i9 = dVar.f8653k;
        Object[] objArr = new Object[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            objArr[i10] = dVar.h(i10);
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f8623i.m(0, objArr);
    }
}
