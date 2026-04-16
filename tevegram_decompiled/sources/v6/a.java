package v6;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements Cloneable {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f9579k = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public int f9581j = 0;

    /* renamed from: i, reason: collision with root package name */
    public int[] f9580i = f9579k;

    public final void a(boolean z8) {
        c(this.f9581j + 1);
        if (z8) {
            int[] iArr = this.f9580i;
            int i9 = this.f9581j;
            int i10 = i9 / 32;
            iArr[i10] = (1 << (i9 & 31)) | iArr[i10];
        }
        this.f9581j++;
    }

    public final void b(int i9, int i10) {
        if (i10 < 0 || i10 > 32) {
            m7.c.n("Num bits must be between 0 and 32");
            return;
        }
        int i11 = this.f9581j;
        c(i11 + i10);
        for (int i12 = i10 - 1; i12 >= 0; i12--) {
            if (((1 << i12) & i9) != 0) {
                int[] iArr = this.f9580i;
                int i13 = i11 / 32;
                iArr[i13] = iArr[i13] | (1 << (i11 & 31));
            }
            i11++;
        }
        this.f9581j = i11;
    }

    public final void c(int i9) {
        if (i9 > this.f9580i.length * 32) {
            int[] iArr = new int[(((int) Math.ceil(i9 / 0.75f)) + 31) / 32];
            int[] iArr2 = this.f9580i;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            this.f9580i = iArr;
        }
    }

    public final Object clone() {
        int[] iArr = (int[]) this.f9580i.clone();
        int i9 = this.f9581j;
        a aVar = new a();
        aVar.f9580i = iArr;
        aVar.f9581j = i9;
        return aVar;
    }

    public final boolean d(int i9) {
        return ((1 << (i9 & 31)) & this.f9580i[i9 / 32]) != 0;
    }

    public final int e() {
        return (this.f9581j + 7) / 8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f9581j == aVar.f9581j && Arrays.equals(this.f9580i, aVar.f9580i);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f9580i) + (this.f9581j * 31);
    }

    public final String toString() {
        int i9 = this.f9581j;
        StringBuilder sb = new StringBuilder((i9 / 8) + i9 + 1);
        for (int i10 = 0; i10 < this.f9581j; i10++) {
            if ((i10 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(d(i10) ? 'X' : '.');
        }
        return sb.toString();
    }
}
