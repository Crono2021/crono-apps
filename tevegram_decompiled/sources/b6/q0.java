package b6;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q0 extends AbstractSequentialList implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final List f1433i;

    /* renamed from: j, reason: collision with root package name */
    public final a6.c f1434j;

    public q0(List list, a6.c cVar) {
        list.getClass();
        this.f1433i = list;
        this.f1434j = cVar;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i9) {
        return new o0(this, this.f1433i.listIterator(i9), 1);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i9, int i10) {
        this.f1433i.subList(i9, i10).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1433i.size();
    }
}
