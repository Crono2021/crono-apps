package b6;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g1 extends f1 implements SortedSet {
    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedSet) this.f1388i).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        Iterator it = this.f1388i.iterator();
        it.getClass();
        a6.e eVar = this.f1389j;
        eVar.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (eVar.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return new g1(((SortedSet) this.f1388i).headSet(obj), this.f1389j);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        SortedSet sortedSet = (SortedSet) this.f1388i;
        while (true) {
            Object last = sortedSet.last();
            if (this.f1389j.apply(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new g1(((SortedSet) this.f1388i).subSet(obj, obj2), this.f1389j);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new g1(((SortedSet) this.f1388i).tailSet(obj), this.f1389j);
    }
}
