package b6;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class d extends AbstractMap {

    /* renamed from: i, reason: collision with root package name */
    public transient b f1372i;

    /* renamed from: j, reason: collision with root package name */
    public transient n f1373j;

    /* renamed from: k, reason: collision with root package name */
    public final transient Map f1374k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ t0 f1375l;

    public d(t0 t0Var, Map map) {
        this.f1375l = t0Var;
        this.f1374k = map;
    }

    public final c0 a(Map.Entry entry) {
        Object key = entry.getKey();
        List list = (List) ((Collection) entry.getValue());
        boolean z8 = list instanceof RandomAccess;
        t0 t0Var = this.f1375l;
        return new c0(key, z8 ? new h(t0Var, key, list, null) : new l(t0Var, key, list, null));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        t0 t0Var = this.f1375l;
        if (this.f1374k == t0Var.f1447l) {
            t0Var.b();
            return;
        }
        c cVar = new c(this);
        while (cVar.hasNext()) {
            cVar.next();
            cVar.remove();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map map = this.f1374k;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        b bVar = this.f1372i;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f1372i = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f1374k.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        Map map = this.f1374k;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        List list = (List) collection;
        boolean z8 = list instanceof RandomAccess;
        t0 t0Var = this.f1375l;
        return z8 ? new h(t0Var, obj, list, null) : new l(t0Var, obj, list, null);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f1374k.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        t0 t0Var = this.f1375l;
        Set set = t0Var.f1424i;
        if (set != null) {
            return set;
        }
        Map map = t0Var.f1447l;
        Set gVar = map instanceof NavigableMap ? new g(t0Var, (NavigableMap) map) : map instanceof SortedMap ? new j(t0Var, (SortedMap) map) : new e(t0Var, map);
        t0Var.f1424i = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Collection collection = (Collection) this.f1374k.remove(obj);
        if (collection == null) {
            return null;
        }
        t0 t0Var = this.f1375l;
        Collection c9 = t0Var.c();
        c9.addAll(collection);
        t0Var.f1448m -= collection.size();
        collection.clear();
        return c9;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f1374k.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f1374k.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        n nVar = this.f1373j;
        if (nVar != null) {
            return nVar;
        }
        n nVar2 = new n(this);
        this.f1373j = nVar2;
        return nVar2;
    }
}
