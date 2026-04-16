package b6;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p0 extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final List f1431i;

    /* renamed from: j, reason: collision with root package name */
    public final a6.c f1432j;

    public p0(List list, a6.c cVar) {
        list.getClass();
        this.f1431i = list;
        this.f1432j = cVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i9) {
        return this.f1432j.apply(this.f1431i.get(i9));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f1431i.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i9) {
        return new o0(this, this.f1431i.listIterator(i9), 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i9) {
        return this.f1432j.apply(this.f1431i.remove(i9));
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        this.f1431i.subList(i9, i10).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1431i.size();
    }
}
