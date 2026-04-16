package m6;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import r6.w0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final j f6666b = new j();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f6667a = new AtomicReference(new t(new a0.l(9)));

    public final f6.b a(p pVar) {
        AtomicReference atomicReference = this.f6667a;
        t tVar = (t) atomicReference.get();
        tVar.getClass();
        t6.a aVar = (t6.a) pVar.f6677b;
        if (!tVar.f6688b.containsKey(new r(p.class, aVar))) {
            try {
                f fVar = new f();
                ((w0) pVar.f6679d).ordinal();
                return fVar;
            } catch (GeneralSecurityException e9) {
                throw new androidx.fragment.app.r("Creating a LegacyProtoKey failed", e9);
            }
        }
        t tVar2 = (t) atomicReference.get();
        tVar2.getClass();
        r rVar = new r(p.class, aVar);
        HashMap hashMap = tVar2.f6688b;
        if (hashMap.containsKey(rVar)) {
            return ((a) hashMap.get(rVar)).f6654b.a(pVar);
        }
        androidx.fragment.app.a.q(rVar, " available", "No Key Parser for requested key type ");
        return null;
    }

    public final synchronized void b(a aVar) {
        a0.l lVar = new a0.l((t) this.f6667a.get());
        lVar.s(aVar);
        this.f6667a.set(new t(lVar));
    }

    public final synchronized void c(c cVar) {
        a0.l lVar = new a0.l((t) this.f6667a.get());
        s sVar = new s(cVar.f6655a, p.class);
        HashMap hashMap = (HashMap) lVar.f30i;
        if (hashMap.containsKey(sVar)) {
            c cVar2 = (c) hashMap.get(sVar);
            if (!cVar2.equals(cVar) || !cVar.equals(cVar2)) {
                androidx.fragment.app.a.u(sVar, "Attempt to register non-equal serializer for already existing object of type: ");
            }
        } else {
            hashMap.put(sVar, cVar);
        }
        this.f6667a.set(new t(lVar));
    }

    public final synchronized void d(k kVar) {
        a0.l lVar = new a0.l((t) this.f6667a.get());
        lVar.t(kVar);
        this.f6667a.set(new t(lVar));
    }

    public final synchronized void e(l lVar) {
        a0.l lVar2 = new a0.l((t) this.f6667a.get());
        s sVar = new s(lVar.f6669a, q.class);
        HashMap hashMap = (HashMap) lVar2.f32k;
        if (hashMap.containsKey(sVar)) {
            l lVar3 = (l) hashMap.get(sVar);
            if (!lVar3.equals(lVar) || !lVar.equals(lVar3)) {
                androidx.fragment.app.a.u(sVar, "Attempt to register non-equal serializer for already existing object of type: ");
            }
        } else {
            hashMap.put(sVar, lVar);
        }
        this.f6667a.set(new t(lVar2));
    }
}
