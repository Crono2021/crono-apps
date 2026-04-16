package m1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class f implements g1.j {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6517i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a f6518j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f6519k;

    public /* synthetic */ f(a aVar, boolean z8, int i9) {
        this.f6517i = i9;
        this.f6518j = aVar;
        this.f6519k = z8;
    }

    @Override // g1.j
    public final void a(Object obj) {
        switch (this.f6517i) {
            case 0:
                ((c) obj).G(this.f6518j, this.f6519k);
                break;
            case 1:
                ((c) obj).F(this.f6518j, this.f6519k);
                break;
            case 2:
                ((c) obj).u(this.f6518j, this.f6519k);
                break;
            default:
                c cVar = (c) obj;
                cVar.getClass();
                cVar.h(this.f6518j, this.f6519k);
                break;
        }
    }
}
