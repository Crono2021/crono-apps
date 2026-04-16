package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class v implements g1.j {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6030i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f6031j;

    public /* synthetic */ v(boolean z8, int i9) {
        this.f6030i = i9;
        this.f6031j = z8;
    }

    @Override // g1.j
    public final void a(Object obj) {
        switch (this.f6030i) {
            case 0:
                ((d1.r0) obj).w(this.f6031j);
                break;
            default:
                ((d1.r0) obj).k(this.f6031j);
                break;
        }
    }
}
