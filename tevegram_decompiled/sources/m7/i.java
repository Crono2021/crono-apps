package m7;

import a8.p;
import i7.b0;
import i8.u;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends t7.h implements p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k f6718m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ f f6719n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ long f6720o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, f fVar, long j5, r7.c cVar) {
        super(2, cVar);
        this.f6718m = kVar;
        this.f6719n = fVar;
        this.f6720o = j5;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i iVar = (i) j((u) obj, (r7.c) obj2);
        n7.g gVar = n7.g.f7490c;
        iVar.k(gVar);
        return gVar;
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new i(this.f6718m, this.f6719n, this.f6720o, cVar);
    }

    @Override // t7.a
    public final Object k(Object obj) {
        com.bumptech.glide.c.V(obj);
        b0 b0Var = this.f6718m.f6747v;
        if (b0Var != null) {
            long j5 = this.f6719n.f6698i;
            long j9 = this.f6720o;
            long j10 = j9 - j5;
            StringBuilder c9 = t.a.c("LIVE_LAG (ts=", j5, ", live=");
            c9.append(j9);
            c9.append(", delta=");
            c9.append(j10);
            c9.append("ms)");
            b0Var.a(c9.toString());
        }
        return n7.g.f7490c;
    }
}
