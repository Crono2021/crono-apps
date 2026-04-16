package n1;

import android.media.AudioTrack;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n0 extends AudioTrack.StreamEventCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0 f7300a;

    public n0(o0 o0Var) {
        this.f7300a = o0Var;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i9) {
        p0 p0Var;
        i7.x xVar;
        if (audioTrack.equals(this.f7300a.f7306c.f7342u) && (xVar = (p0Var = this.f7300a.f7306c).f7338q) != null && p0Var.V) {
            xVar.G();
        }
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        p0 p0Var;
        i7.x xVar;
        if (audioTrack.equals(this.f7300a.f7306c.f7342u) && (xVar = (p0Var = this.f7300a.f7306c).f7338q) != null && p0Var.V) {
            xVar.G();
        }
    }
}
