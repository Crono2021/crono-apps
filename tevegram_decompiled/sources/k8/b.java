package k8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends t7.c {

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f5632l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d f5633m;

    /* renamed from: n, reason: collision with root package name */
    public int f5634n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, t7.c cVar) {
        super(cVar);
        this.f5633m = dVar;
    }

    @Override // t7.a
    public final Object k(Object obj) {
        this.f5632l = obj;
        this.f5634n |= Integer.MIN_VALUE;
        Object u3 = d.u(this.f5633m, this);
        return u3 == s7.a.f8891i ? u3 : new k(u3);
    }
}
