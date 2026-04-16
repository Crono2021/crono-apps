package i;

import android.graphics.drawable.Animatable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4234o;

    /* renamed from: p, reason: collision with root package name */
    public final Animatable f4235p;

    public /* synthetic */ a(Animatable animatable, int i9) {
        this.f4234o = i9;
        this.f4235p = animatable;
    }

    @Override // android.support.v4.media.session.b
    public final void w0() {
        switch (this.f4234o) {
            case 0:
                this.f4235p.start();
                break;
            default:
                ((w3.d) this.f4235p).start();
                break;
        }
    }

    @Override // android.support.v4.media.session.b
    public final void x0() {
        switch (this.f4234o) {
            case 0:
                this.f4235p.stop();
                break;
            default:
                ((w3.d) this.f4235p).stop();
                break;
        }
    }
}
