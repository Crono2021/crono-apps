package m7;

import a8.p;
import h7.k0;
import i8.u;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends t7.h implements p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k f6721m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ f f6722n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ k0 f6723o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f6724p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ ConcurrentHashMap f6725q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f6726r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, f fVar, k0 k0Var, String str, ConcurrentHashMap concurrentHashMap, int i9, r7.c cVar) {
        super(2, cVar);
        this.f6721m = kVar;
        this.f6722n = fVar;
        this.f6723o = k0Var;
        this.f6724p = str;
        this.f6725q = concurrentHashMap;
        this.f6726r = i9;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        j jVar = (j) j((u) obj, (r7.c) obj2);
        n7.g gVar = n7.g.f7490c;
        jVar.k(gVar);
        return gVar;
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new j(this.f6721m, this.f6722n, this.f6723o, this.f6724p, this.f6725q, this.f6726r, cVar);
    }

    @Override // t7.a
    public final Object k(Object obj) {
        String str = this.f6724p;
        f fVar = this.f6722n;
        k kVar = this.f6721m;
        AtomicInteger atomicInteger = kVar.B;
        Semaphore semaphore = kVar.f6745t;
        com.bumptech.glide.c.V(obj);
        try {
            semaphore.acquire();
            atomicInteger.incrementAndGet();
            int i9 = fVar.f6700k == 1 ? new k7.a(kVar.f6727a).f5628b.getInt("video_quality", 2) : fVar.f6701l;
            k0 k0Var = this.f6723o;
            k0Var.k(fVar.f6702m, fVar.f6698i, fVar.f6699j, fVar.f6700k, i9, fVar.f6703n, new g(kVar, this.f6725q, fVar, this.f6726r, str, k0Var));
        } catch (Exception unused) {
            atomicInteger.decrementAndGet();
            semaphore.release();
            kVar.J.remove(str);
        }
        return n7.g.f7490c;
    }
}
