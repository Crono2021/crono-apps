package f6;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements Comparable {

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f3434i;

    public l(byte[] bArr) {
        this.f3434i = Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        l lVar = (l) obj;
        byte[] bArr = this.f3434i;
        int length = bArr.length;
        byte[] bArr2 = lVar.f3434i;
        if (length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i9 = 0; i9 < bArr.length; i9++) {
            byte b9 = bArr[i9];
            byte b10 = lVar.f3434i[i9];
            if (b9 != b10) {
                return b9 - b10;
            }
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return Arrays.equals(this.f3434i, ((l) obj).f3434i);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f3434i);
    }

    public final String toString() {
        return android.support.v4.media.session.b.F(this.f3434i);
    }
}
