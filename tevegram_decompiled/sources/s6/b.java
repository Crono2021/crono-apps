package s6;

import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements f6.a {

    /* renamed from: e, reason: collision with root package name */
    public static final c8.b f8863e = new c8.b(4);

    /* renamed from: f, reason: collision with root package name */
    public static final c8.b f8864f = new c8.b(5);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8865a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f8866b;

    /* renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f8867c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8868d;

    public b(byte[] bArr, int i9) {
        if (!androidx.activity.g.d(1)) {
            androidx.fragment.app.a.o("Can not use AES-EAX in FIPS-mode.");
            throw null;
        }
        if (i9 != 12 && i9 != 16) {
            m7.c.n("IV size should be either 12 or 16 bytes");
            throw null;
        }
        this.f8868d = i9;
        m.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f8867c = secretKeySpec;
        Cipher cipher = (Cipher) f8863e.get();
        cipher.init(1, secretKeySpec);
        byte[] c9 = c(cipher.doFinal(new byte[16]));
        this.f8865a = c9;
        this.f8866b = c(c9);
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i9 = 0;
        while (i9 < 15) {
            int i10 = i9 + 1;
            bArr2[i9] = (byte) (((bArr[i9] << 1) ^ ((bArr[i10] & 255) >>> 7)) & 255);
            i9 = i10;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i9 = 0; i9 < length; i9++) {
            bArr3[i9] = (byte) (bArr[i9] ^ bArr2[i9]);
        }
        return bArr3;
    }

    @Override // f6.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i9 = this.f8868d;
        if (length > 2147483631 - i9) {
            androidx.fragment.app.a.o("plaintext too long");
            return null;
        }
        byte[] bArr3 = new byte[bArr.length + i9 + 16];
        byte[] a9 = l.a(i9);
        System.arraycopy(a9, 0, bArr3, 0, i9);
        Cipher cipher = (Cipher) f8863e.get();
        SecretKeySpec secretKeySpec = this.f8867c;
        cipher.init(1, secretKeySpec);
        byte[] d9 = d(cipher, 0, a9, 0, a9.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] d10 = d(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = (Cipher) f8864f.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(d9));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.f8868d);
        byte[] d11 = d(cipher, 2, bArr3, this.f8868d, bArr.length);
        int length2 = bArr.length + i9;
        for (int i10 = 0; i10 < 16; i10++) {
            bArr3[length2 + i10] = (byte) ((d10[i10] ^ d9[i10]) ^ d11[i10]);
        }
        return bArr3;
    }

    @Override // f6.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i9 = this.f8868d;
        int i10 = (length - i9) - 16;
        if (i10 < 0) {
            androidx.fragment.app.a.o("ciphertext too short");
            return null;
        }
        Cipher cipher = (Cipher) f8863e.get();
        SecretKeySpec secretKeySpec = this.f8867c;
        cipher.init(1, secretKeySpec);
        byte[] d9 = d(cipher, 0, bArr, 0, this.f8868d);
        byte[] bArr3 = bArr2 == null ? new byte[0] : bArr2;
        byte[] d10 = d(cipher, 1, bArr3, 0, bArr3.length);
        byte[] d11 = d(cipher, 2, bArr, this.f8868d, i10);
        int length2 = bArr.length - 16;
        byte b9 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            b9 = (byte) (b9 | (((bArr[length2 + i11] ^ d10[i11]) ^ d9[i11]) ^ d11[i11]));
        }
        if (b9 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) f8864f.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(d9));
        return cipher2.doFinal(bArr, i9, i10);
    }

    public final byte[] d(Cipher cipher, int i9, byte[] bArr, int i10, int i11) {
        byte[] copyOf;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i9;
        byte[] bArr3 = this.f8865a;
        if (i11 == 0) {
            return cipher.doFinal(e(bArr2, bArr3));
        }
        byte[] doFinal = cipher.doFinal(bArr2);
        int i12 = 0;
        while (i11 - i12 > 16) {
            for (int i13 = 0; i13 < 16; i13++) {
                doFinal[i13] = (byte) (doFinal[i13] ^ bArr[(i10 + i12) + i13]);
            }
            doFinal = cipher.doFinal(doFinal);
            i12 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i12 + i10, i10 + i11);
        if (copyOfRange.length == 16) {
            copyOf = e(copyOfRange, bArr3);
        } else {
            copyOf = Arrays.copyOf(this.f8866b, 16);
            for (int i14 = 0; i14 < copyOfRange.length; i14++) {
                copyOf[i14] = (byte) (copyOf[i14] ^ copyOfRange[i14]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
        }
        return cipher.doFinal(e(doFinal, copyOf));
    }
}
