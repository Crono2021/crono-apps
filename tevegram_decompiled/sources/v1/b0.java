package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f9242i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o1.d f9243j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f9244k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ q f9245l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v f9246m;

    public /* synthetic */ b0(o1.d dVar, d0 d0Var, q qVar, v vVar, int i9) {
        this.f9242i = i9;
        this.f9243j = dVar;
        this.f9244k = d0Var;
        this.f9245l = qVar;
        this.f9246m = vVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, v1.d0] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, v1.d0] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, v1.d0] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9242i) {
            case 0:
                o1.d dVar = this.f9243j;
                this.f9244k.Q(dVar.f7569a, dVar.f7570b, this.f9245l, this.f9246m);
                break;
            case 1:
                o1.d dVar2 = this.f9243j;
                this.f9244k.V(dVar2.f7569a, dVar2.f7570b, this.f9245l, this.f9246m);
                break;
            default:
                o1.d dVar3 = this.f9243j;
                this.f9244k.y(dVar3.f7569a, dVar3.f7570b, this.f9245l, this.f9246m);
                break;
        }
    }
}
