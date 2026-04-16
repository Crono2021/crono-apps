package s6;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements f6.a {

    /* renamed from: a, reason: collision with root package name */
    public final a f8879a;

    /* renamed from: b, reason: collision with root package name */
    public final f6.j f8880b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8881c;

    public g(a aVar, f6.j jVar, int i9) {
        this.f8879a = aVar;
        this.f8880b = jVar;
        this.f8881c = i9;
    }

    @Override // f6.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        a aVar = this.f8879a;
        aVar.getClass();
        int length = bArr.length;
        int i9 = aVar.f8861b;
        int i10 = Integer.MAX_VALUE - i9;
        if (length > i10) {
            throw new GeneralSecurityException(androidx.activity.g.m(i10, "plaintext length can not exceed "));
        }
        byte[] bArr3 = new byte[bArr.length + i9];
        byte[] a9 = l.a(i9);
        System.arraycopy(a9, 0, bArr3, 0, i9);
        aVar.a(bArr, 0, bArr.length, bArr3, aVar.f8861b, a9, true);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return a.a.j(bArr3, this.f8880b.b(a.a.j(bArr2, bArr3, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }

    @Override // f6.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i9 = this.f8881c;
        if (length < i9) {
            androidx.fragment.app.a.o("ciphertext too short");
            return null;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i9);
        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - i9, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.f8880b.a(copyOfRange2, a.a.j(bArr2, copyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
        a aVar = this.f8879a;
        aVar.getClass();
        int length2 = copyOfRange.length;
        int i10 = aVar.f8861b;
        if (length2 < i10) {
            androidx.fragment.app.a.o("ciphertext too short");
            return null;
        }
        byte[] bArr3 = new byte[i10];
        System.arraycopy(copyOfRange, 0, bArr3, 0, i10);
        int length3 = copyOfRange.length;
        int i11 = aVar.f8861b;
        byte[] bArr4 = new byte[length3 - i11];
        aVar.a(copyOfRange, i11, copyOfRange.length - i11, bArr4, 0, bArr3, false);
        return bArr4;
    }
}
