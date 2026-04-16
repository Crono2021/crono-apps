package m1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class g implements g1.j {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6520i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a f6521j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f6522k;

    public /* synthetic */ g(a aVar, String str, int i9) {
        this.f6520i = i9;
        this.f6521j = aVar;
        this.f6522k = str;
    }

    @Override // g1.j
    public final void a(Object obj) {
        switch (this.f6520i) {
            case 0:
                c cVar = (c) obj;
                cVar.getClass();
                cVar.q(this.f6521j, this.f6522k);
                break;
            case 1:
                ((c) obj).l(this.f6521j, this.f6522k);
                break;
            case 2:
                c cVar2 = (c) obj;
                cVar2.getClass();
                cVar2.g(this.f6521j, this.f6522k);
                break;
            default:
                ((c) obj).y(this.f6521j, this.f6522k);
                break;
        }
    }

    public /* synthetic */ g(a aVar, String str, long j5, long j9, int i9) {
        this.f6520i = i9;
        this.f6521j = aVar;
        this.f6522k = str;
    }
}
