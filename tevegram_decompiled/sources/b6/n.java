package b6;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends AbstractCollection {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1420i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f1421j;

    public n(d dVar) {
        this.f1420i = 2;
        this.f1421j = dVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.f1420i) {
            case 0:
                ((t0) this.f1421j).b();
                break;
            case 1:
                ((u) this.f1421j).clear();
                break;
            default:
                ((d) this.f1421j).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.f1420i) {
            case 0:
                Iterator it = ((t0) this.f1421j).a().values().iterator();
                while (it.hasNext()) {
                    if (((Collection) it.next()).contains(obj)) {
                        return true;
                    }
                }
                return false;
            case 1:
            default:
                return super.contains(obj);
            case 2:
                return ((d) this.f1421j).containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.f1420i) {
            case 2:
                return ((d) this.f1421j).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f1420i) {
            case 0:
                return new a((t0) this.f1421j);
            case 1:
                u uVar = (u) this.f1421j;
                Map b9 = uVar.b();
                return b9 != null ? b9.values().iterator() : new r(uVar, 2);
            default:
                return new r0(((d) this.f1421j).entrySet().iterator());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f1420i) {
            case 2:
                d dVar = (d) this.f1421j;
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    for (Map.Entry entry : dVar.entrySet()) {
                        if (android.support.v4.media.session.b.G(obj, entry.getValue())) {
                            dVar.remove(entry.getKey());
                            return true;
                        }
                    }
                    return false;
                }
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f1420i) {
            case 2:
                d dVar = (d) this.f1421j;
                try {
                    collection.getClass();
                    return super.removeAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : dVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return dVar.keySet().removeAll(hashSet);
                }
            default:
                return super.removeAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f1420i) {
            case 2:
                d dVar = (d) this.f1421j;
                try {
                    collection.getClass();
                    return super.retainAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    for (Map.Entry entry : dVar.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return dVar.keySet().retainAll(hashSet);
                }
            default:
                return super.retainAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f1420i) {
            case 0:
                return ((t0) this.f1421j).f1448m;
            case 1:
                return ((u) this.f1421j).size();
            default:
                return ((d) this.f1421j).f1374k.size();
        }
    }

    public /* synthetic */ n(int i9, Serializable serializable) {
        this.f1420i = i9;
        this.f1421j = serializable;
    }
}
