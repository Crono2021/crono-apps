package n6;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h implements f6.m {

    /* renamed from: a, reason: collision with root package name */
    public static final h f7463a = new h();

    @Override // f6.m
    public final Class a() {
        return f.class;
    }

    @Override // f6.m
    public final Object b(androidx.fragment.app.g gVar) {
        if (((f6.k) gVar.f729k) == null) {
            androidx.fragment.app.a.o("no primary in primitive set");
            return null;
        }
        Iterator it = ((ConcurrentMap) gVar.f728j).values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
            }
        }
        return new g();
    }

    @Override // f6.m
    public final Class c() {
        return f.class;
    }
}
