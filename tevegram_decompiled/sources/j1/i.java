package j1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends f {

    /* renamed from: m, reason: collision with root package name */
    public final androidx.media3.decoder.ffmpeg.a f5382m;

    /* renamed from: n, reason: collision with root package name */
    public ByteBuffer f5383n;

    public i(androidx.media3.decoder.ffmpeg.a aVar) {
        this.f5382m = aVar;
    }

    @Override // j1.f
    public final void k() {
        super.k();
        ByteBuffer byteBuffer = this.f5383n;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // j1.f
    public final void l() {
        this.f5382m.f982a.m(this);
    }
}
