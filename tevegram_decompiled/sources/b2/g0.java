package b2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1188i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a5.d f1189j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f1190k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f1191l;

    public /* synthetic */ g0(a5.d dVar, int i9, long j5) {
        this.f1189j = dVar;
        this.f1191l = i9;
        this.f1190k = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f1188i;
        int i10 = this.f1191l;
        long j5 = this.f1190k;
        a5.d dVar = this.f1189j;
        switch (i9) {
            case 0:
                j0 j0Var = (j0) dVar.f175k;
                int i11 = g1.w.f3713a;
                m1.q qVar = ((l1.y) j0Var).f6065i.f5804y;
                m1.a I = qVar.I((v1.z) qVar.f6554l.f6680e);
                qVar.L(I, 1018, new m1.d(i10, j5, I));
                break;
            default:
                j0 j0Var2 = (j0) dVar.f175k;
                int i12 = g1.w.f3713a;
                m1.q qVar2 = ((l1.y) j0Var2).f6065i.f5804y;
                m1.a I2 = qVar2.I((v1.z) qVar2.f6554l.f6680e);
                qVar2.L(I2, 1021, new h7.o(i10, j5, I2));
                break;
        }
    }

    public /* synthetic */ g0(a5.d dVar, long j5, int i9) {
        this.f1189j = dVar;
        this.f1190k = j5;
        this.f1191l = i9;
    }
}
