package s6;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final c8.b f8859d = new c8.b(3);

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f8860a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8861b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8862c;

    public a(byte[] bArr, int i9) {
        if (!androidx.activity.g.e(2)) {
            androidx.fragment.app.a.o("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
            throw null;
        }
        m.a(bArr.length);
        this.f8860a = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) f8859d.get()).getBlockSize();
        this.f8862c = blockSize;
        if (i9 < 12 || i9 > blockSize) {
            androidx.fragment.app.a.o("invalid IV size");
            throw null;
        }
        this.f8861b = i9;
    }

    public final void a(byte[] bArr, int i9, int i10, byte[] bArr2, int i11, byte[] bArr3, boolean z8) {
        Cipher cipher = (Cipher) f8859d.get();
        byte[] bArr4 = new byte[this.f8862c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f8861b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        SecretKeySpec secretKeySpec = this.f8860a;
        if (z8) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i9, i10, bArr2, i11) == i10) {
            return;
        }
        androidx.fragment.app.a.o("stored output's length does not match input's length");
    }
}
