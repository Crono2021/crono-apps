package m6;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final i f6664b = new i();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f6665a = new AtomicReference(new o(new m1.b(2)));

    public final synchronized void a(m mVar) {
        m1.b bVar = new m1.b((o) this.f6665a.get());
        HashMap hashMap = (HashMap) bVar.f6510j;
        n nVar = new n(mVar.f6670a, n6.f.class);
        if (hashMap.containsKey(nVar)) {
            m mVar2 = (m) hashMap.get(nVar);
            if (!mVar2.equals(mVar) || !mVar.equals(mVar2)) {
                androidx.fragment.app.a.u(nVar, "Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ");
            }
        } else {
            hashMap.put(nVar, mVar);
        }
        this.f6665a.set(new o(bVar));
    }

    public final synchronized void b(f6.m mVar) {
        m1.b bVar = new m1.b((o) this.f6665a.get());
        HashMap hashMap = (HashMap) bVar.f6511k;
        if (mVar != null) {
            Class c9 = mVar.c();
            if (hashMap.containsKey(c9)) {
                f6.m mVar2 = (f6.m) hashMap.get(c9);
                if (!mVar2.equals(mVar) || !mVar.equals(mVar2)) {
                    androidx.fragment.app.a.u(c9, "Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type");
                }
            } else {
                hashMap.put(c9, mVar);
            }
        } else {
            m7.c.o("wrapper must be non-null");
        }
        this.f6665a.set(new o(bVar));
    }
}
