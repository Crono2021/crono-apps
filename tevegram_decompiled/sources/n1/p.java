package n1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7307i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7308j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f7309k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f7310l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f7311m;

    public /* synthetic */ p(Object obj, int i9, long j5, long j9, int i10) {
        this.f7307i = i10;
        this.f7311m = obj;
        this.f7308j = i9;
        this.f7309k = j5;
        this.f7310l = j9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f7307i;
        Object obj = this.f7311m;
        switch (i9) {
            case 0:
                q qVar = (q) ((m1.b) obj).f6511k;
                int i10 = g1.w.f3713a;
                m1.q qVar2 = ((l1.y) qVar).f6065i.f5804y;
                final m1.a K = qVar2.K();
                final int i11 = this.f7308j;
                final long j5 = this.f7309k;
                final long j9 = this.f7310l;
                qVar2.L(K, 1011, new g1.j() { // from class: m1.n
                    @Override // g1.j
                    public final void a(Object obj2) {
                        ((c) obj2).s(a.this, i11, j5, j9);
                    }
                });
                break;
            default:
                m1.q qVar3 = ((z1.b) obj).f10539b;
                m6.p pVar = qVar3.f6554l;
                m1.a I = qVar3.I(((b6.g0) pVar.f6677b).isEmpty() ? null : (v1.z) b6.q.g((b6.g0) pVar.f6677b));
                qVar3.L(I, 1006, new m1.o(I, this.f7308j, this.f7309k, this.f7310l));
                break;
        }
    }
}
