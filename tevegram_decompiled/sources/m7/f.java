package m7;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements Comparable {

    /* renamed from: i, reason: collision with root package name */
    public final long f6698i;

    /* renamed from: j, reason: collision with root package name */
    public final long f6699j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6700k;

    /* renamed from: l, reason: collision with root package name */
    public final int f6701l;

    /* renamed from: m, reason: collision with root package name */
    public final int f6702m;

    /* renamed from: n, reason: collision with root package name */
    public final int f6703n;

    /* renamed from: o, reason: collision with root package name */
    public final long f6704o;

    public f(long j5, long j9, int i9, int i10, int i11, int i12, long j10) {
        this.f6698i = j5;
        this.f6699j = j9;
        this.f6700k = i9;
        this.f6701l = i10;
        this.f6702m = i11;
        this.f6703n = i12;
        this.f6704o = j10;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        f fVar = (f) obj;
        fVar.getClass();
        int i9 = fVar.f6700k;
        int i10 = this.f6700k;
        if (i10 != i9) {
            if (i10 < i9) {
                return -1;
            }
            return i10 == i9 ? 0 : 1;
        }
        int i11 = fVar.f6701l;
        int i12 = this.f6701l;
        if (i12 != i11) {
            if (i12 < i11) {
                return -1;
            }
            return i12 == i11 ? 0 : 1;
        }
        long j5 = this.f6698i;
        long j9 = fVar.f6698i;
        if (j5 < j9) {
            return -1;
        }
        return j5 == j9 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f6698i == fVar.f6698i && this.f6699j == fVar.f6699j && this.f6700k == fVar.f6700k && this.f6701l == fVar.f6701l && this.f6702m == fVar.f6702m && this.f6703n == fVar.f6703n && this.f6704o == fVar.f6704o;
    }

    public final int hashCode() {
        long j5 = this.f6698i;
        long j9 = this.f6699j;
        int i9 = ((((((((((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31) + this.f6700k) * 31) + this.f6701l) * 31) + this.f6702m) * 31) + this.f6703n) * 31;
        long j10 = this.f6704o;
        return i9 + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        StringBuilder c9 = t.a.c("SegmentRequest(ts=", this.f6698i, ", dur=");
        c9.append(this.f6699j);
        c9.append(", ch=");
        c9.append(this.f6700k);
        c9.append(", qual=");
        c9.append(this.f6701l);
        c9.append(", groupCallId=");
        c9.append(this.f6702m);
        c9.append(", scale=");
        c9.append(this.f6703n);
        c9.append(", requestTime=");
        c9.append(this.f6704o);
        c9.append(")");
        return c9.toString();
    }
}
