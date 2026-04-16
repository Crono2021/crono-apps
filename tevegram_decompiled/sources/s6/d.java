package s6;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements f6.c {

    /* renamed from: c, reason: collision with root package name */
    public static final List f8871c = Arrays.asList(64);

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f8872d = new byte[16];

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f8873e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    public final androidx.fragment.app.g f8874a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f8875b;

    public d(byte[] bArr) {
        if (!androidx.activity.g.d(1)) {
            androidx.fragment.app.a.o("Can not use AES-SIV in FIPS-mode.");
            throw null;
        }
        if (f8871c.contains(Integer.valueOf(bArr.length))) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.f8875b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.f8874a = new androidx.fragment.app.g(copyOfRange);
        } else {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
    }

    @Override // f6.c
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length > 2147483631) {
            androidx.fragment.app.a.o("plaintext too long");
            return null;
        }
        Cipher cipher = (Cipher) i.f8884b.f8886a.a("AES/CTR/NoPadding");
        byte[] c9 = c(bArr2, bArr);
        byte[] bArr3 = (byte[]) c9.clone();
        bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
        bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
        cipher.init(1, new SecretKeySpec(this.f8875b, "AES"), new IvParameterSpec(bArr3));
        return a.a.j(c9, cipher.doFinal(bArr));
    }

    @Override // f6.c
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length < 16) {
            androidx.fragment.app.a.o("Ciphertext too short.");
            return null;
        }
        Cipher cipher = (Cipher) i.f8884b.f8886a.a("AES/CTR/NoPadding");
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArr3 = (byte[]) copyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & Byte.MAX_VALUE);
        bArr3[12] = (byte) (bArr3[12] & Byte.MAX_VALUE);
        cipher.init(2, new SecretKeySpec(this.f8875b, "AES"), new IvParameterSpec(bArr3));
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
        byte[] doFinal = cipher.doFinal(copyOfRange2);
        if (copyOfRange2.length == 0 && doFinal == null && "The Android Project".equals(System.getProperty("java.vendor"))) {
            doFinal = new byte[0];
        }
        if (MessageDigest.isEqual(copyOfRange, c(bArr2, doFinal))) {
            return doFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }

    public final byte[] c(byte[]... bArr) {
        byte[] Y;
        int length = bArr.length;
        androidx.fragment.app.g gVar = this.f8874a;
        if (length == 0) {
            return gVar.t(f8873e, 16);
        }
        byte[] t8 = gVar.t(f8872d, 16);
        for (int i9 = 0; i9 < bArr.length - 1; i9++) {
            byte[] bArr2 = bArr[i9];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            t8 = a.a.Y(com.bumptech.glide.c.p(t8), gVar.t(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        if (bArr3.length >= 16) {
            if (bArr3.length < t8.length) {
                m7.c.n("xorEnd requires a.length >= b.length");
                return null;
            }
            int length2 = bArr3.length - t8.length;
            Y = Arrays.copyOf(bArr3, bArr3.length);
            for (int i10 = 0; i10 < t8.length; i10++) {
                int i11 = length2 + i10;
                Y[i11] = (byte) (Y[i11] ^ t8[i10]);
            }
        } else {
            if (bArr3.length >= 16) {
                m7.c.n("x must be smaller than a block.");
                return null;
            }
            byte[] copyOf = Arrays.copyOf(bArr3, 16);
            copyOf[bArr3.length] = Byte.MIN_VALUE;
            Y = a.a.Y(copyOf, com.bumptech.glide.c.p(t8));
        }
        return gVar.t(Y, 16);
    }
}
