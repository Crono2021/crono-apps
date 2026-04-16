package m1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m implements g1.j {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6538i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a f6539j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ v1.v f6540k;

    public /* synthetic */ m(a aVar, v1.v vVar, int i9) {
        this.f6538i = i9;
        this.f6539j = aVar;
        this.f6540k = vVar;
    }

    @Override // g1.j
    public final void a(Object obj) {
        switch (this.f6538i) {
            case 0:
                ((c) obj).L(this.f6539j, this.f6540k);
                break;
            default:
                ((c) obj).d(this.f6539j, this.f6540k);
                break;
        }
    }
}
