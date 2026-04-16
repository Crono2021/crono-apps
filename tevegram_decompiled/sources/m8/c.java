package m8;

import a8.p;
import i8.u;
import java.util.concurrent.atomic.AtomicInteger;
import n7.g;
import t7.h;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends h implements p {

    /* renamed from: m, reason: collision with root package name */
    public int f6757m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ l8.d[] f6758n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f6759o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f6760p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ k8.d f6761q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(l8.d[] dVarArr, int i9, AtomicInteger atomicInteger, k8.d dVar, r7.c cVar) {
        super(2, cVar);
        this.f6758n = dVarArr;
        this.f6759o = i9;
        this.f6760p = atomicInteger;
        this.f6761q = dVar;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        return ((c) j((u) obj, (r7.c) obj2)).k(g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new c(this.f6758n, this.f6759o, this.f6760p, this.f6761q, cVar);
    }

    @Override // t7.a
    public final Object k(Object obj) {
        int i9 = this.f6757m;
        AtomicInteger atomicInteger = this.f6760p;
        k8.d dVar = this.f6761q;
        try {
            if (i9 != 0) {
                if (i9 == 1) {
                    com.bumptech.glide.c.V(obj);
                    return g.f7490c;
                }
                m7.c.p("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            com.bumptech.glide.c.V(obj);
            l8.d[] dVarArr = this.f6758n;
            int i10 = this.f6759o;
            l8.d dVar2 = dVarArr[i10];
            b bVar = new b(dVar, i10);
            this.f6757m = 1;
            dVar2.b(bVar, this);
            return s7.a.f8891i;
        } finally {
            if (atomicInteger.decrementAndGet() == 0) {
                a.a.i(dVar);
            }
        }
    }
}
