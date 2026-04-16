package s6;

import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k implements f6.j {

    /* renamed from: a, reason: collision with root package name */
    public final q6.a f8888a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8889b;

    public k(q6.a aVar, int i9) {
        this.f8888a = aVar;
        this.f8889b = i9;
        if (i9 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        aVar.t(new byte[0], i9);
    }

    @Override // f6.j
    public final void a(byte[] bArr, byte[] bArr2) {
        if (MessageDigest.isEqual(b(bArr2), bArr)) {
            return;
        }
        androidx.fragment.app.a.o("invalid MAC");
    }

    @Override // f6.j
    public final byte[] b(byte[] bArr) {
        return this.f8888a.t(bArr, this.f8889b);
    }
}
