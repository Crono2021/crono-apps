package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g0 extends h0 {

    /* renamed from: k, reason: collision with root package name */
    public final f f5268k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ j0 f5269l;

    public g0(j0 j0Var, long j5, f fVar) {
        this.f5269l = j0Var;
        this.f5272i = j5;
        this.f5273j = -1;
        this.f5268k = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5268k.B(this.f5269l);
    }

    @Override // i8.h0
    public final String toString() {
        return super.toString() + this.f5268k;
    }
}
