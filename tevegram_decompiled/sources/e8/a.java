package e8;

import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class a implements Iterable {

    /* renamed from: i, reason: collision with root package name */
    public final int f3158i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3159j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3160k;

    public a(int i9, int i10, int i11) {
        if (i11 == 0) {
            m7.c.n("Step must be non-zero.");
            throw null;
        }
        if (i11 == Integer.MIN_VALUE) {
            m7.c.n("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.f3158i = i9;
        if (i11 > 0) {
            if (i9 < i10) {
                int i12 = i10 % i11;
                int i13 = i9 % i11;
                int i14 = ((i12 < 0 ? i12 + i11 : i12) - (i13 < 0 ? i13 + i11 : i13)) % i11;
                i10 -= i14 < 0 ? i14 + i11 : i14;
            }
        } else {
            if (i11 >= 0) {
                m7.c.n("Step is zero.");
                throw null;
            }
            if (i9 > i10) {
                int i15 = -i11;
                int i16 = i9 % i15;
                int i17 = i10 % i15;
                int i18 = ((i16 < 0 ? i16 + i15 : i16) - (i17 < 0 ? i17 + i15 : i17)) % i15;
                i10 += i18 < 0 ? i18 + i15 : i18;
            }
        }
        this.f3159j = i10;
        this.f3160k = i11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f3158i == aVar.f3158i && this.f3159j == aVar.f3159j && this.f3160k == aVar.f3160k;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3158i * 31) + this.f3159j) * 31) + this.f3160k;
    }

    public boolean isEmpty() {
        int i9 = this.f3159j;
        int i10 = this.f3160k;
        int i11 = this.f3158i;
        return i10 > 0 ? i11 > i9 : i11 < i9;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f3158i, this.f3159j, this.f3160k);
    }

    public String toString() {
        StringBuilder sb;
        int i9 = this.f3159j;
        int i10 = this.f3160k;
        int i11 = this.f3158i;
        if (i10 > 0) {
            sb = new StringBuilder();
            sb.append(i11);
            sb.append("..");
            sb.append(i9);
            sb.append(" step ");
            sb.append(i10);
        } else {
            sb = new StringBuilder();
            sb.append(i11);
            sb.append(" downTo ");
            sb.append(i9);
            sb.append(" step ");
            sb.append(-i10);
        }
        return sb.toString();
    }
}
