package n1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7297i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ m1.b f7298j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ r f7299k;

    public /* synthetic */ n(m1.b bVar, r rVar, int i9) {
        this.f7297i = i9;
        this.f7298j = bVar;
        this.f7299k = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f7297i;
        final r rVar = this.f7299k;
        m1.b bVar = this.f7298j;
        switch (i9) {
            case 0:
                q qVar = (q) bVar.f6511k;
                int i10 = g1.w.f3713a;
                m1.q qVar2 = ((l1.y) qVar).f6065i.f5804y;
                final m1.a K = qVar2.K();
                final int i11 = 0;
                qVar2.L(K, 1031, new g1.j() { // from class: m1.p
                    @Override // g1.j
                    public final void a(Object obj) {
                        switch (i11) {
                            case 0:
                                ((c) obj).c(K, rVar);
                                break;
                            default:
                                ((c) obj).w(K, rVar);
                                break;
                        }
                    }
                });
                break;
            default:
                q qVar3 = (q) bVar.f6511k;
                int i12 = g1.w.f3713a;
                m1.q qVar4 = ((l1.y) qVar3).f6065i.f5804y;
                final m1.a K2 = qVar4.K();
                final int i13 = 1;
                qVar4.L(K2, 1032, new g1.j() { // from class: m1.p
                    @Override // g1.j
                    public final void a(Object obj) {
                        switch (i13) {
                            case 0:
                                ((c) obj).c(K2, rVar);
                                break;
                            default:
                                ((c) obj).w(K2, rVar);
                                break;
                        }
                    }
                });
                break;
        }
    }
}
