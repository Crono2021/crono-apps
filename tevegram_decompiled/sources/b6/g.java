package b6;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends j implements NavigableSet {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ t0 f1390l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(t0 t0Var, NavigableMap navigableMap) {
        super(t0Var, navigableMap);
        this.f1390l = t0Var;
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return f().ceilingKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return ((e) descendingSet()).iterator();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return new g(this.f1390l, f().descendingMap());
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return f().floorKey(obj);
    }

    @Override // b6.j
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final NavigableMap f() {
        return (NavigableMap) ((SortedMap) this.f1377i);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z8) {
        return new g(this.f1390l, f().headMap(obj, z8));
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return f().higherKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return f().lowerKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        c cVar = (c) iterator();
        if (!cVar.hasNext()) {
            return null;
        }
        Object next = cVar.next();
        cVar.remove();
        return next;
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        Iterator descendingIterator = descendingIterator();
        if (!descendingIterator.hasNext()) {
            return null;
        }
        Object next = descendingIterator.next();
        descendingIterator.remove();
        return next;
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z8, Object obj2, boolean z9) {
        return new g(this.f1390l, f().subMap(obj, z8, obj2, z9));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z8) {
        return new g(this.f1390l, f().tailMap(obj, z8));
    }

    @Override // b6.j, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // b6.j, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // b6.j, java.util.SortedSet, java.util.NavigableSet
    public final SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }
}
