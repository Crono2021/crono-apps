package b6;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class l extends AbstractCollection implements List {

    /* renamed from: i, reason: collision with root package name */
    public final Object f1407i;

    /* renamed from: j, reason: collision with root package name */
    public Collection f1408j;

    /* renamed from: k, reason: collision with root package name */
    public final l f1409k;

    /* renamed from: l, reason: collision with root package name */
    public final Collection f1410l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ t0 f1411m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ t0 f1412n;

    public l(t0 t0Var, Object obj, List list, l lVar) {
        this.f1412n = t0Var;
        this.f1411m = t0Var;
        this.f1407i = obj;
        this.f1408j = list;
        this.f1409k = lVar;
        this.f1410l = lVar == null ? null : lVar.f1408j;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        boolean isEmpty = this.f1408j.isEmpty();
        boolean add = this.f1408j.add(obj);
        if (add) {
            this.f1411m.f1448m++;
            if (isEmpty) {
                f();
            }
        }
        return add;
    }

    @Override // java.util.List
    public final boolean addAll(int i9, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.f1408j).addAll(i9, collection);
        if (addAll) {
            this.f1412n.f1448m += this.f1408j.size() - size;
            if (size == 0) {
                f();
            }
        }
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f1408j.clear();
        this.f1411m.f1448m -= size;
        h();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        g();
        return this.f1408j.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean containsAll(Collection collection) {
        g();
        return this.f1408j.containsAll(collection);
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        g();
        return this.f1408j.equals(obj);
    }

    public final void f() {
        l lVar = this.f1409k;
        if (lVar != null) {
            lVar.f();
        } else {
            this.f1411m.f1447l.put(this.f1407i, this.f1408j);
        }
    }

    public final void g() {
        Collection collection;
        l lVar = this.f1409k;
        if (lVar != null) {
            lVar.g();
            if (lVar.f1408j != this.f1410l) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.f1408j.isEmpty() || (collection = (Collection) this.f1411m.f1447l.get(this.f1407i)) == null) {
                return;
            }
            this.f1408j = collection;
        }
    }

    @Override // java.util.List
    public final Object get(int i9) {
        g();
        return ((List) this.f1408j).get(i9);
    }

    public final void h() {
        l lVar = this.f1409k;
        if (lVar != null) {
            lVar.h();
        } else if (this.f1408j.isEmpty()) {
            this.f1411m.f1447l.remove(this.f1407i);
        }
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        g();
        return this.f1408j.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        g();
        return ((List) this.f1408j).indexOf(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        g();
        return new c(this);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        g();
        return ((List) this.f1408j).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        g();
        return new k(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        boolean remove = this.f1408j.remove(obj);
        if (remove) {
            t0 t0Var = this.f1411m;
            t0Var.f1448m--;
            h();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.f1408j.removeAll(collection);
        if (removeAll) {
            this.f1411m.f1448m += this.f1408j.size() - size;
            h();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.f1408j.retainAll(collection);
        if (retainAll) {
            this.f1411m.f1448m += this.f1408j.size() - size;
            h();
        }
        return retainAll;
    }

    @Override // java.util.List
    public final Object set(int i9, Object obj) {
        g();
        return ((List) this.f1408j).set(i9, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        g();
        return this.f1408j.size();
    }

    @Override // java.util.List
    public final List subList(int i9, int i10) {
        g();
        List subList = ((List) this.f1408j).subList(i9, i10);
        l lVar = this.f1409k;
        if (lVar == null) {
            lVar = this;
        }
        boolean z8 = subList instanceof RandomAccess;
        t0 t0Var = this.f1412n;
        Object obj = this.f1407i;
        return z8 ? new h(t0Var, obj, subList, lVar) : new l(t0Var, obj, subList, lVar);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        g();
        return this.f1408j.toString();
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i9) {
        g();
        return new k(this, i9);
    }

    @Override // java.util.List
    public final Object remove(int i9) {
        g();
        Object remove = ((List) this.f1408j).remove(i9);
        t0 t0Var = this.f1412n;
        t0Var.f1448m--;
        h();
        return remove;
    }

    @Override // java.util.List
    public final void add(int i9, Object obj) {
        g();
        boolean isEmpty = this.f1408j.isEmpty();
        ((List) this.f1408j).add(i9, obj);
        this.f1412n.f1448m++;
        if (isEmpty) {
            f();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.f1408j.addAll(collection);
        if (addAll) {
            this.f1411m.f1448m += this.f1408j.size() - size;
            if (size == 0) {
                f();
            }
        }
        return addAll;
    }
}
