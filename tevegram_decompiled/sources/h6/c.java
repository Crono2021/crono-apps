package h6;

import com.google.crypto.tink.shaded.protobuf.m;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends m {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4049c;

    public c(int i9, int i10, byte[] bArr) {
        this.f4049c = i10;
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f2269b = a.c(bArr);
        this.f2268a = i9;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int[] c(int[] iArr, int i9) {
        switch (this.f4049c) {
            case 0:
                if (iArr.length != 3) {
                    throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
                }
                int[] iArr2 = new int[16];
                int[] iArr3 = (int[]) this.f2269b;
                int[] iArr4 = a.f4045a;
                System.arraycopy(iArr4, 0, iArr2, 0, iArr4.length);
                System.arraycopy(iArr3, 0, iArr2, iArr4.length, 8);
                iArr2[12] = i9;
                System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
                return iArr2;
            default:
                if (iArr.length != 6) {
                    throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(iArr.length * 32)));
                }
                int[] iArr5 = new int[16];
                int[] iArr6 = (int[]) this.f2269b;
                int[] iArr7 = new int[16];
                int[] iArr8 = a.f4045a;
                System.arraycopy(iArr8, 0, iArr7, 0, iArr8.length);
                System.arraycopy(iArr6, 0, iArr7, iArr8.length, 8);
                iArr7[12] = iArr[0];
                iArr7[13] = iArr[1];
                iArr7[14] = iArr[2];
                iArr7[15] = iArr[3];
                a.b(iArr7);
                iArr7[4] = iArr7[12];
                iArr7[5] = iArr7[13];
                iArr7[6] = iArr7[14];
                iArr7[7] = iArr7[15];
                int[] copyOf = Arrays.copyOf(iArr7, 8);
                System.arraycopy(iArr8, 0, iArr5, 0, iArr8.length);
                System.arraycopy(copyOf, 0, iArr5, iArr8.length, 8);
                iArr5[12] = i9;
                iArr5[13] = 0;
                iArr5[14] = iArr[4];
                iArr5[15] = iArr[5];
                return iArr5;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int i() {
        switch (this.f4049c) {
            case 0:
                return 12;
            default:
                return 24;
        }
    }
}
