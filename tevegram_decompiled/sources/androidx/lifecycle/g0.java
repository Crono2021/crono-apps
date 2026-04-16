package androidx.lifecycle;

import i8.e1;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final k0 f914a = new k0();

    /* renamed from: b, reason: collision with root package name */
    public static final k0 f915b = new k0();

    /* renamed from: c, reason: collision with root package name */
    public static final k0 f916c = new k0();

    public static final LifecycleCoroutineScopeImpl a(s sVar) {
        r7.b bVar;
        sVar.getClass();
        u g9 = sVar.g();
        g9.getClass();
        AtomicReference atomicReference = g9.f940a;
        while (true) {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) atomicReference.get();
            if (lifecycleCoroutineScopeImpl != null) {
                return lifecycleCoroutineScopeImpl;
            }
            r7.g e1Var = new e1();
            p8.d dVar = i8.c0.f5250a;
            j8.d dVar2 = n8.o.f7529a.f5503m;
            dVar2.getClass();
            r7.h hVar = r7.h.f8615i;
            if (dVar2 != hVar) {
                r7.g e9 = e1Var.e(dVar2.getKey());
                if (e9 == hVar) {
                    e1Var = dVar2;
                } else {
                    r7.d dVar3 = r7.d.f8614i;
                    i8.s sVar2 = (i8.s) e9.h(dVar3);
                    if (sVar2 == null) {
                        bVar = new r7.b(e9, dVar2);
                    } else {
                        r7.g e10 = e9.e(dVar3);
                        if (e10 == hVar) {
                            e1Var = new r7.b(dVar2, sVar2);
                        } else {
                            bVar = new r7.b(new r7.b(e10, dVar2), sVar2);
                        }
                    }
                    e1Var = bVar;
                }
            }
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = new LifecycleCoroutineScopeImpl(g9, e1Var);
            while (!atomicReference.compareAndSet(null, lifecycleCoroutineScopeImpl2)) {
                if (atomicReference.get() != null) {
                    break;
                }
            }
            p8.d dVar4 = i8.c0.f5250a;
            i8.w.j(lifecycleCoroutineScopeImpl2, n8.o.f7529a.f5503m, new n(lifecycleCoroutineScopeImpl2, null), 2);
            return lifecycleCoroutineScopeImpl2;
        }
    }
}
