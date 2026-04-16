package m1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i implements g1.j {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6526i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a f6527j;

    public /* synthetic */ i(a aVar, l1.f fVar, int i9) {
        this.f6526i = i9;
        this.f6527j = aVar;
    }

    @Override // g1.j
    public final void a(Object obj) {
        switch (this.f6526i) {
            case 0:
                ((c) obj).e(this.f6527j);
                break;
            case 1:
                ((c) obj).C(this.f6527j);
                break;
            default:
                ((c) obj).k(this.f6527j);
                break;
        }
    }
}
