package n1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7293i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ m1.b f7294j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ l1.f f7295k;

    public /* synthetic */ m(m1.b bVar, l1.f fVar, int i9) {
        this.f7293i = i9;
        this.f7294j = bVar;
        this.f7295k = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7293i) {
            case 0:
                m1.b bVar = this.f7294j;
                l1.f fVar = this.f7295k;
                q qVar = (q) bVar.f6511k;
                int i9 = g1.w.f3713a;
                m1.q qVar2 = ((l1.y) qVar).f6065i.f5804y;
                m1.a K = qVar2.K();
                qVar2.L(K, 1007, new m1.i(K, fVar, 2));
                break;
            default:
                m1.b bVar2 = this.f7294j;
                l1.f fVar2 = this.f7295k;
                synchronized (fVar2) {
                }
                q qVar3 = (q) bVar2.f6511k;
                int i10 = g1.w.f3713a;
                m1.q qVar4 = ((l1.y) qVar3).f6065i.f5804y;
                m1.a I = qVar4.I((v1.z) qVar4.f6554l.f6680e);
                qVar4.L(I, 1013, new m1.i(I, fVar2, 0));
                break;
        }
    }
}
