package t6;

import android.support.v4.media.session.b;
import java.util.Arrays;
import m7.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8980a;

    public a(byte[] bArr, int i9) {
        byte[] bArr2 = new byte[i9];
        this.f8980a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i9);
    }

    public static a a(byte[] bArr) {
        if (bArr != null) {
            return new a(bArr, bArr.length);
        }
        c.o("data must be non-null");
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return Arrays.equals(((a) obj).f8980a, this.f8980a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8980a);
    }

    public final String toString() {
        return "Bytes(" + b.F(this.f8980a) + ")";
    }
}
