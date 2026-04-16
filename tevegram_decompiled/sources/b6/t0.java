package b6;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t0 extends o implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public final transient Map f1447l;

    /* renamed from: m, reason: collision with root package name */
    public transient int f1448m;

    /* renamed from: n, reason: collision with root package name */
    public transient s0 f1449n;

    public t0(Map map) {
        if (map.isEmpty()) {
            this.f1447l = map;
        } else {
            m7.c.d();
            throw null;
        }
    }

    @Override // b6.o
    public final Map a() {
        Map map = this.f1426k;
        if (map != null) {
            return map;
        }
        Map map2 = this.f1447l;
        Map fVar = map2 instanceof NavigableMap ? new f(this, (NavigableMap) map2) : map2 instanceof SortedMap ? new i(this, (SortedMap) map2) : new d(this, map2);
        this.f1426k = fVar;
        return fVar;
    }

    public final void b() {
        Map map = this.f1447l;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.f1448m = 0;
    }

    public final Collection c() {
        return (List) this.f1449n.get();
    }
}
