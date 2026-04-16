package v6;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    public int f9582i;

    /* renamed from: j, reason: collision with root package name */
    public int f9583j;

    /* renamed from: k, reason: collision with root package name */
    public int f9584k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f9585l;

    public final Object clone() {
        int i9 = this.f9582i;
        int i10 = this.f9583j;
        int i11 = this.f9584k;
        int[] iArr = (int[]) this.f9585l.clone();
        b bVar = new b();
        bVar.f9582i = i9;
        bVar.f9583j = i10;
        bVar.f9584k = i11;
        bVar.f9585l = iArr;
        return bVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f9582i == bVar.f9582i && this.f9583j == bVar.f9583j && this.f9584k == bVar.f9584k && Arrays.equals(this.f9585l, bVar.f9585l);
    }

    public final int hashCode() {
        int i9 = this.f9582i;
        return Arrays.hashCode(this.f9585l) + (((((((i9 * 31) + i9) * 31) + this.f9583j) * 31) + this.f9584k) * 31);
    }

    public final String toString() {
        int i9 = this.f9583j;
        int i10 = this.f9582i;
        StringBuilder sb = new StringBuilder((i10 + 1) * i9);
        for (int i11 = 0; i11 < i9; i11++) {
            for (int i12 = 0; i12 < i10; i12++) {
                sb.append(((this.f9585l[(i12 / 32) + (this.f9584k * i11)] >>> (i12 & 31)) & 1) != 0 ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
