package m7;

import a8.p;
import h7.k0;
import i8.u;
import i8.w;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends t7.h implements p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f6711m;

    /* renamed from: n, reason: collision with root package name */
    public int f6712n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ k f6713o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ f f6714p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ k0 f6715q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ ConcurrentHashMap f6716r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f6717s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i9, k kVar, f fVar, k0 k0Var, ConcurrentHashMap concurrentHashMap, r7.c cVar, int i10) {
        super(2, cVar);
        this.f6711m = i10;
        this.f6717s = i9;
        this.f6713o = kVar;
        this.f6714p = fVar;
        this.f6715q = k0Var;
        this.f6716r = concurrentHashMap;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        u uVar = (u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f6711m) {
        }
        return ((h) j(uVar, cVar)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f6711m) {
            case 0:
                return new h(this.f6717s, this.f6713o, this.f6714p, this.f6715q, this.f6716r, cVar, 0);
            case 1:
                return new h(this.f6713o, this.f6714p, this.f6715q, this.f6716r, this.f6717s, cVar, 1);
            case 2:
                return new h(this.f6713o, this.f6714p, this.f6715q, this.f6716r, this.f6717s, cVar, 2);
            default:
                return new h(this.f6717s, this.f6713o, this.f6714p, this.f6715q, this.f6716r, cVar, 3);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        int i9 = this.f6711m;
        ConcurrentHashMap concurrentHashMap = this.f6716r;
        k0 k0Var = this.f6715q;
        f fVar = this.f6714p;
        k kVar = this.f6713o;
        s7.a aVar = s7.a.f8891i;
        int i10 = this.f6717s;
        switch (i9) {
            case 0:
                int i11 = this.f6712n;
                if (i11 == 0) {
                    com.bumptech.glide.c.V(obj);
                    long j5 = i10 * 2000;
                    this.f6712n = 1;
                    if (w.d(j5 + 5000, this) == aVar) {
                        break;
                    }
                } else if (i11 != 1) {
                    c.p("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    com.bumptech.glide.c.V(obj);
                }
                CopyOnWriteArrayList copyOnWriteArrayList = k.M;
                kVar.d(fVar, k0Var, concurrentHashMap, i10 + 1);
                break;
            case 1:
                int i12 = this.f6712n;
                if (i12 == 0) {
                    com.bumptech.glide.c.V(obj);
                    this.f6712n = 1;
                    if (w.d(2000L, this) == aVar) {
                        break;
                    }
                } else if (i12 != 1) {
                    c.p("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    com.bumptech.glide.c.V(obj);
                }
                CopyOnWriteArrayList copyOnWriteArrayList2 = k.M;
                kVar.d(fVar, k0Var, concurrentHashMap, i10 + 1);
                break;
            case 2:
                int i13 = this.f6712n;
                if (i13 == 0) {
                    com.bumptech.glide.c.V(obj);
                    this.f6712n = 1;
                    if (w.d(2000L, this) == aVar) {
                        break;
                    }
                } else if (i13 != 1) {
                    c.p("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    com.bumptech.glide.c.V(obj);
                }
                CopyOnWriteArrayList copyOnWriteArrayList3 = k.M;
                kVar.d(fVar, k0Var, concurrentHashMap, i10 + 1);
                break;
            default:
                int i14 = this.f6712n;
                if (i14 == 0) {
                    com.bumptech.glide.c.V(obj);
                    this.f6712n = 1;
                    if (w.d((i10 * 400) + 800, this) == aVar) {
                        break;
                    }
                } else if (i14 != 1) {
                    c.p("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    com.bumptech.glide.c.V(obj);
                }
                CopyOnWriteArrayList copyOnWriteArrayList4 = k.M;
                kVar.d(fVar, k0Var, concurrentHashMap, i10 + 1);
                break;
        }
        return n7.g.f7490c;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(k kVar, f fVar, k0 k0Var, ConcurrentHashMap concurrentHashMap, int i9, r7.c cVar, int i10) {
        super(2, cVar);
        this.f6711m = i10;
        this.f6713o = kVar;
        this.f6714p = fVar;
        this.f6715q = k0Var;
        this.f6716r = concurrentHashMap;
        this.f6717s = i9;
    }
}
