package m;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f f6379i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o f6380j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ m f6381k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ i7.x f6382l;

    public e(i7.x xVar, f fVar, o oVar, m mVar) {
        this.f6382l = xVar;
        this.f6379i = fVar;
        this.f6380j = oVar;
        this.f6381k = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = (g) this.f6382l.f5179j;
        f fVar = this.f6379i;
        if (fVar != null) {
            gVar.H = true;
            fVar.f6401b.c(false);
            gVar.H = false;
        }
        o oVar = this.f6380j;
        if (oVar.isEnabled() && oVar.hasSubMenu()) {
            this.f6381k.q(oVar, null, 4);
        }
    }
}
