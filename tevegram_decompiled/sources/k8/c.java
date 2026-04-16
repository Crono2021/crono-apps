package k8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends t7.c {

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f5635l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d f5636m;

    /* renamed from: n, reason: collision with root package name */
    public int f5637n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, t7.c cVar) {
        super(cVar);
        this.f5636m = dVar;
    }

    @Override // t7.a
    public final Object k(Object obj) {
        this.f5635l = obj;
        this.f5637n |= Integer.MIN_VALUE;
        Object v8 = this.f5636m.v(null, 0, 0L, this);
        return v8 == s7.a.f8891i ? v8 : new k(v8);
    }
}
