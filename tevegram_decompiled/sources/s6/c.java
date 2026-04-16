package s6;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements f6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8869a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8870b;

    public c(byte[] bArr, int i9) {
        this.f8869a = i9;
        switch (i9) {
            case 1:
                this.f8870b = new h6.d(bArr, 0);
                return;
            case 2:
                this.f8870b = new h6.d(bArr, 1);
                return;
            default:
                if (androidx.activity.g.e(2)) {
                    this.f8870b = new h6.b(bArr);
                    return;
                } else {
                    androidx.fragment.app.a.o("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
                    throw null;
                }
        }
    }

    @Override // f6.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        switch (this.f8869a) {
            case 0:
                byte[] a9 = l.a(12);
                h6.b bVar = (h6.b) this.f8870b;
                boolean z8 = bVar.f4048b;
                if (a9.length != 12) {
                    androidx.fragment.app.a.o("iv is wrong size");
                } else {
                    if (bArr.length <= 2147483619) {
                        byte[] bArr3 = new byte[z8 ? bArr.length + 28 : bArr.length + 16];
                        if (z8) {
                            System.arraycopy(a9, 0, bArr3, 0, 12);
                        }
                        AlgorithmParameterSpec a10 = h6.b.a(a9);
                        c8.b bVar2 = h6.b.f4046c;
                        ((Cipher) bVar2.get()).init(1, bVar.f4047a, a10);
                        if (bArr2 != null && bArr2.length != 0) {
                            ((Cipher) bVar2.get()).updateAAD(bArr2);
                        }
                        int doFinal = ((Cipher) bVar2.get()).doFinal(bArr, 0, bArr.length, bArr3, z8 ? 12 : 0);
                        if (doFinal == bArr.length + 16) {
                            return bArr3;
                        }
                        throw new GeneralSecurityException("encryption failed; GCM tag must be 16 bytes, but got only " + (doFinal - bArr.length) + " bytes");
                    }
                    androidx.fragment.app.a.o("plaintext too long");
                }
                return null;
            case 1:
                ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 28);
                byte[] a11 = l.a(12);
                allocate.put(a11);
                ((h6.d) this.f8870b).g(allocate, a11, bArr, bArr2);
                return allocate.array();
            default:
                ByteBuffer allocate2 = ByteBuffer.allocate(bArr.length + 40);
                byte[] a12 = l.a(24);
                allocate2.put(a12);
                ((h6.d) this.f8870b).g(allocate2, a12, bArr, bArr2);
                return allocate2.array();
        }
    }

    @Override // f6.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        switch (this.f8869a) {
            case 0:
                byte[] copyOf = Arrays.copyOf(bArr, 12);
                h6.b bVar = (h6.b) this.f8870b;
                boolean z8 = bVar.f4048b;
                if (copyOf.length != 12) {
                    androidx.fragment.app.a.o("iv is wrong size");
                    break;
                } else {
                    if (bArr.length < (z8 ? 28 : 16)) {
                        androidx.fragment.app.a.o("ciphertext too short");
                        break;
                    } else {
                        if (z8 && !ByteBuffer.wrap(copyOf).equals(ByteBuffer.wrap(bArr, 0, 12))) {
                            androidx.fragment.app.a.o("iv does not match prepended iv");
                            break;
                        } else {
                            AlgorithmParameterSpec a9 = h6.b.a(copyOf);
                            c8.b bVar2 = h6.b.f4046c;
                            ((Cipher) bVar2.get()).init(2, bVar.f4047a, a9);
                            if (bArr2 != null && bArr2.length != 0) {
                                ((Cipher) bVar2.get()).updateAAD(bArr2);
                            }
                            int i9 = z8 ? 12 : 0;
                            int length = bArr.length;
                            if (z8) {
                                length -= 12;
                            }
                            break;
                        }
                    }
                }
                break;
            case 1:
                if (bArr.length < 28) {
                    androidx.fragment.app.a.o("ciphertext too short");
                    break;
                } else {
                    break;
                }
            default:
                if (bArr.length < 40) {
                    androidx.fragment.app.a.o("ciphertext too short");
                    break;
                } else {
                    break;
                }
        }
        return null;
    }
}
