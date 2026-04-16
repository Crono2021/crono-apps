package i6;

import c8.b;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import s6.l;
import s6.m;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements f6.a {

    /* renamed from: b, reason: collision with root package name */
    public static final b f4747b = new b(2);

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f4748a;

    public a(byte[] bArr) {
        m.a(bArr.length);
        this.f4748a = new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec c(byte[] bArr, int i9) {
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            return new GCMParameterSpec(128, bArr, 0, i9);
        } catch (ClassNotFoundException unused) {
            if ("The Android Project".equals(System.getProperty("java.vendor"))) {
                return new IvParameterSpec(bArr, 0, i9);
            }
            androidx.fragment.app.a.o("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
            return null;
        }
    }

    @Override // f6.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length > 2147483619) {
            androidx.fragment.app.a.o("plaintext too long");
            return null;
        }
        byte[] bArr3 = new byte[bArr.length + 28];
        byte[] a9 = l.a(12);
        System.arraycopy(a9, 0, bArr3, 0, 12);
        AlgorithmParameterSpec c9 = c(a9, a9.length);
        b bVar = f4747b;
        ((Cipher) bVar.get()).init(1, this.f4748a, c9);
        if (bArr2 != null && bArr2.length != 0) {
            ((Cipher) bVar.get()).updateAAD(bArr2);
        }
        int doFinal = ((Cipher) bVar.get()).doFinal(bArr, 0, bArr.length, bArr3, 12);
        if (doFinal == bArr.length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException("encryption failed; GCM tag must be 16 bytes, but got only " + (doFinal - bArr.length) + " bytes");
    }

    @Override // f6.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length < 28) {
            androidx.fragment.app.a.o("ciphertext too short");
            return null;
        }
        AlgorithmParameterSpec c9 = c(bArr, 12);
        b bVar = f4747b;
        ((Cipher) bVar.get()).init(2, this.f4748a, c9);
        if (bArr2 != null && bArr2.length != 0) {
            ((Cipher) bVar.get()).updateAAD(bArr2);
        }
        return ((Cipher) bVar.get()).doFinal(bArr, 12, bArr.length - 12);
    }
}
