package n1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7301i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ m1.b f7302j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Exception f7303k;

    public /* synthetic */ o(m1.b bVar, Exception exc, int i9) {
        this.f7301i = i9;
        this.f7302j = bVar;
        this.f7303k = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f7301i;
        Exception exc = this.f7303k;
        m1.b bVar = this.f7302j;
        switch (i9) {
            case 0:
                q qVar = (q) bVar.f6511k;
                int i10 = g1.w.f3713a;
                m1.q qVar2 = ((l1.y) qVar).f6065i.f5804y;
                m1.a K = qVar2.K();
                qVar2.L(K, 1029, new h7.o(K, exc, 17));
                break;
            default:
                q qVar3 = (q) bVar.f6511k;
                int i11 = g1.w.f3713a;
                m1.q qVar4 = ((l1.y) qVar3).f6065i.f5804y;
                m1.a K2 = qVar4.K();
                qVar4.L(K2, 1014, new h7.o(K2, exc, 19));
                break;
        }
    }
}
