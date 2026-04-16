package b6;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class f1 extends AbstractCollection implements Set {

    /* renamed from: i, reason: collision with root package name */
    public final Set f1388i;

    /* renamed from: j, reason: collision with root package name */
    public final a6.e f1389j;

    public f1(Set set, a6.e eVar) {
        this.f1388i = set;
        this.f1389j = eVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        if (this.f1389j.apply(obj)) {
            return this.f1388i.add(obj);
        }
        m7.c.d();
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!this.f1389j.apply(it.next())) {
                m7.c.d();
                return false;
            }
        }
        return this.f1388i.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        Set set = this.f1388i;
        boolean z8 = set instanceof RandomAccess;
        a6.e eVar = this.f1389j;
        if (!z8 || !(set instanceof List)) {
            Iterator it = set.iterator();
            eVar.getClass();
            while (it.hasNext()) {
                if (eVar.apply(it.next())) {
                    it.remove();
                }
            }
            return;
        }
        List list = (List) set;
        eVar.getClass();
        int i9 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            Object obj = list.get(i10);
            if (!eVar.apply(obj)) {
                if (i10 > i9) {
                    try {
                        list.set(i9, obj);
                    } catch (IllegalArgumentException unused) {
                        q.l(list, eVar, i9, i10);
                        return;
                    } catch (UnsupportedOperationException unused2) {
                        q.l(list, eVar, i9, i10);
                        return;
                    }
                }
                i9++;
            }
        }
        list.subList(i9, list.size()).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        boolean z8;
        Set set = this.f1388i;
        set.getClass();
        try {
            z8 = set.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            z8 = false;
        }
        if (z8) {
            return this.f1389j.apply(obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
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
        return q.e(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return q.h(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        Iterator it = this.f1388i.iterator();
        a6.e eVar = this.f1389j;
        if (eVar == null) {
            m7.c.o("predicate");
            return false;
        }
        int i9 = 0;
        while (true) {
            if (!it.hasNext()) {
                i9 = -1;
                break;
            }
            if (eVar.apply(it.next())) {
                break;
            }
            i9++;
        }
        return true ^ (i9 != -1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        Iterator it = this.f1388i.iterator();
        it.getClass();
        a6.e eVar = this.f1389j;
        eVar.getClass();
        return new l0(it, eVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        return contains(obj) && this.f1388i.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = this.f1388i.iterator();
        boolean z8 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f1389j.apply(next) && collection.contains(next)) {
                it.remove();
                z8 = true;
            }
        }
        return z8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        Iterator it = this.f1388i.iterator();
        boolean z8 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f1389j.apply(next) && !collection.contains(next)) {
                it.remove();
                z8 = true;
            }
        }
        return z8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator it = this.f1388i.iterator();
        int i9 = 0;
        while (it.hasNext()) {
            if (this.f1389j.apply(it.next())) {
                i9++;
            }
        }
        return i9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Iterator it = iterator();
        ArrayList arrayList = new ArrayList();
        while (true) {
            l0 l0Var = (l0) it;
            if (!l0Var.hasNext()) {
                return arrayList.toArray();
            }
            arrayList.add(l0Var.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        Iterator it = iterator();
        ArrayList arrayList = new ArrayList();
        while (true) {
            l0 l0Var = (l0) it;
            if (l0Var.hasNext()) {
                arrayList.add(l0Var.next());
            } else {
                return arrayList.toArray(objArr);
            }
        }
    }
}
