package i1;

import b6.f1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o implements Map {

    /* renamed from: i, reason: collision with root package name */
    public final Map f4347i;

    public o(Map map) {
        this.f4347i = map;
    }

    @Override // java.util.Map
    public final void clear() {
        this.f4347i.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return obj != null && this.f4347i.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        Iterator it = ((f1) entrySet()).iterator();
        it.getClass();
        if (obj == null) {
            while (it.hasNext()) {
                if (((Map.Entry) it.next()).getValue() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(((Map.Entry) it.next()).getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return b6.q.f(this.f4347i.entrySet(), new n(0));
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj != null && b6.q.d(this, obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) this.f4347i.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return b6.q.h(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        Map map = this.f4347i;
        return map.isEmpty() || (map.size() == 1 && map.containsKey(null));
    }

    @Override // java.util.Map
    public final Set keySet() {
        return b6.q.f(this.f4347i.keySet(), new n(1));
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f4347i.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        this.f4347i.putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f4347i.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        Map map = this.f4347i;
        return map.size() - (map.containsKey(null) ? 1 : 0);
    }

    public final String toString() {
        return this.f4347i.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f4347i.values();
    }
}
