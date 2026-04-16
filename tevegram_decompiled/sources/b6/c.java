package b6;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class c implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1359i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final Iterator f1360j;

    /* renamed from: k, reason: collision with root package name */
    public Object f1361k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1362l;

    public c(l lVar) {
        this.f1362l = lVar;
        Collection collection = lVar.f1408j;
        this.f1361k = collection;
        this.f1360j = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public void a() {
        l lVar = (l) this.f1362l;
        lVar.g();
        if (lVar.f1408j != ((Collection) this.f1361k)) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f1359i) {
            case 0:
                break;
            case 1:
                break;
            default:
                a();
                break;
        }
        return this.f1360j.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f1359i) {
            case 0:
                Map.Entry entry = (Map.Entry) this.f1360j.next();
                this.f1361k = (Collection) entry.getValue();
                return ((d) this.f1362l).a(entry);
            case 1:
                Map.Entry entry2 = (Map.Entry) this.f1360j.next();
                this.f1361k = entry2;
                return entry2.getKey();
            default:
                a();
                return this.f1360j.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f1359i) {
            case 0:
                if (!(((Collection) this.f1361k) != null)) {
                    m7.c.p("no calls to next() since the last call to remove()");
                    break;
                } else {
                    this.f1360j.remove();
                    ((d) this.f1362l).f1375l.f1448m -= ((Collection) this.f1361k).size();
                    ((Collection) this.f1361k).clear();
                    this.f1361k = null;
                    break;
                }
            case 1:
                Map.Entry entry = (Map.Entry) this.f1361k;
                if (!(entry != null)) {
                    m7.c.p("no calls to next() since the last call to remove()");
                    break;
                } else {
                    Collection collection = (Collection) entry.getValue();
                    this.f1360j.remove();
                    ((e) this.f1362l).f1378j.f1448m -= collection.size();
                    collection.clear();
                    this.f1361k = null;
                    break;
                }
            default:
                this.f1360j.remove();
                l lVar = (l) this.f1362l;
                t0 t0Var = lVar.f1411m;
                t0Var.f1448m--;
                lVar.h();
                break;
        }
    }

    public c(l lVar, ListIterator listIterator) {
        this.f1362l = lVar;
        this.f1361k = lVar.f1408j;
        this.f1360j = listIterator;
    }

    public c(e eVar, Iterator it) {
        this.f1362l = eVar;
        this.f1360j = it;
    }

    public c(d dVar) {
        this.f1362l = dVar;
        this.f1360j = dVar.f1374k.entrySet().iterator();
    }
}
