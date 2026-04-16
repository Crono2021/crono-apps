package b2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1167i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f1168j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f1169k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1170l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1171m;

    public /* synthetic */ e0(Object obj, String str, long j5, long j9, int i9) {
        this.f1167i = i9;
        this.f1171m = obj;
        this.f1168j = str;
        this.f1169k = j5;
        this.f1170l = j9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f1167i;
        Object obj = this.f1171m;
        switch (i9) {
            case 0:
                j0 j0Var = (j0) ((a5.d) obj).f175k;
                int i10 = g1.w.f3713a;
                m1.q qVar = ((l1.y) j0Var).f6065i.f5804y;
                m1.a K = qVar.K();
                qVar.L(K, 1016, new m1.g(K, this.f1168j, this.f1170l, this.f1169k, 2));
                break;
            default:
                n1.q qVar2 = (n1.q) ((m1.b) obj).f6511k;
                int i11 = g1.w.f3713a;
                m1.q qVar3 = ((l1.y) qVar2).f6065i.f5804y;
                m1.a K2 = qVar3.K();
                qVar3.L(K2, 1008, new m1.g(K2, this.f1168j, this.f1170l, this.f1169k, 0));
                break;
        }
    }
}
