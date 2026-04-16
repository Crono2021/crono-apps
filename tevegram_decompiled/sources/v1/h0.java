package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f9300i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ m0 f9301j;

    public /* synthetic */ h0(m0 m0Var, int i9) {
        this.f9300i = i9;
        this.f9301j = m0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9300i) {
            case 0:
                this.f9301j.N = true;
                break;
            case 1:
                this.f9301j.z();
                break;
            default:
                m0 m0Var = this.f9301j;
                if (!m0Var.T) {
                    w wVar = m0Var.f9348y;
                    wVar.getClass();
                    wVar.d(m0Var);
                    break;
                }
                break;
        }
    }
}
