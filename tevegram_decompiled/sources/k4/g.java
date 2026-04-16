package k4;

import android.graphics.ImageDecoder;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements b4.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5566a;

    /* renamed from: b, reason: collision with root package name */
    public final c f5567b;

    public g(int i9) {
        this.f5566a = i9;
        switch (i9) {
            case 1:
                this.f5567b = new c();
                break;
            default:
                this.f5567b = new c();
                break;
        }
    }

    @Override // b4.k
    public final d4.a0 a(Object obj, int i9, int i10, b4.i iVar) {
        ImageDecoder.Source createSource;
        ImageDecoder.Source createSource2;
        switch (this.f5566a) {
            case 0:
                createSource = ImageDecoder.createSource((ByteBuffer) obj);
                return this.f5567b.c(createSource, i9, i10, iVar);
            default:
                createSource2 = ImageDecoder.createSource(w4.b.b((InputStream) obj));
                return this.f5567b.c(createSource2, i9, i10, iVar);
        }
    }

    @Override // b4.k
    public final /* bridge */ /* synthetic */ boolean b(Object obj, b4.i iVar) {
        switch (this.f5566a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}
