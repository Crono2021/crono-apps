package d2;

import java.io.EOFException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2713a = new byte[4096];

    @Override // d2.d0
    public final int a(d1.k kVar, int i9, boolean z8) {
        return b(kVar, i9, z8);
    }

    @Override // d2.d0
    public final int b(d1.k kVar, int i9, boolean z8) {
        byte[] bArr = this.f2713a;
        int read = kVar.read(bArr, 0, Math.min(bArr.length, i9));
        if (read != -1) {
            return read;
        }
        if (z8) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // d2.d0
    public final void c(int i9, g1.p pVar) {
        pVar.G(i9);
    }

    @Override // d2.d0
    public final void f(g1.p pVar, int i9, int i10) {
        pVar.G(i9);
    }

    @Override // d2.d0
    public final void e(d1.s sVar) {
    }

    @Override // d2.d0
    public final void d(long j5, int i9, int i10, int i11, c0 c0Var) {
    }
}
