package b2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1208i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a5.d f1209j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ l1.f f1210k;

    public /* synthetic */ i0(a5.d dVar, l1.f fVar, int i9) {
        this.f1208i = i9;
        this.f1209j = dVar;
        this.f1210k = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1208i) {
            case 0:
                a5.d dVar = this.f1209j;
                l1.f fVar = this.f1210k;
                j0 j0Var = (j0) dVar.f175k;
                int i9 = g1.w.f3713a;
                m1.q qVar = ((l1.y) j0Var).f6065i.f5804y;
                m1.a K = qVar.K();
                qVar.L(K, 1015, new m1.i(K, fVar, 1));
                break;
            default:
                a5.d dVar2 = this.f1209j;
                l1.f fVar2 = this.f1210k;
                synchronized (fVar2) {
                }
                j0 j0Var2 = (j0) dVar2.f175k;
                int i10 = g1.w.f3713a;
                m1.q qVar2 = ((l1.y) j0Var2).f6065i.f5804y;
                m1.a I = qVar2.I((v1.z) qVar2.f6554l.f6680e);
                qVar2.L(I, 1020, new h7.e(I, 8, fVar2));
                break;
        }
    }
}
