package d2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements y {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f2742a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f2743b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2744c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2745d;

    public v(long j5, long[] jArr, long[] jArr2) {
        g1.a.f(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z8 = length > 0;
        this.f2745d = z8;
        if (!z8 || jArr2[0] <= 0) {
            this.f2742a = jArr;
            this.f2743b = jArr2;
        } else {
            int i9 = length + 1;
            long[] jArr3 = new long[i9];
            this.f2742a = jArr3;
            long[] jArr4 = new long[i9];
            this.f2743b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f2744c = j5;
    }

    @Override // d2.y
    public final boolean e() {
        return this.f2745d;
    }

    @Override // d2.y
    public final x i(long j5) {
        if (!this.f2745d) {
            z zVar = z.f2755c;
            return new x(zVar, zVar);
        }
        long[] jArr = this.f2743b;
        int c9 = g1.w.c(j5, jArr, true);
        long j9 = jArr[c9];
        long[] jArr2 = this.f2742a;
        z zVar2 = new z(j9, jArr2[c9]);
        if (j9 == j5 || c9 == jArr.length - 1) {
            return new x(zVar2, zVar2);
        }
        int i9 = c9 + 1;
        return new x(zVar2, new z(jArr[i9], jArr2[i9]));
    }

    @Override // d2.y
    public final long k() {
        return this.f2744c;
    }
}
