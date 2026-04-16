package d2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class p implements y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2715a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2716b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2717c;

    public p(long j5, long j9) {
        this.f2715a = 1;
        this.f2716b = j5;
        z zVar = j9 == 0 ? z.f2755c : new z(0L, j9);
        this.f2717c = new x(zVar, zVar);
    }

    @Override // d2.y
    public final boolean e() {
        switch (this.f2715a) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return true;
        }
    }

    @Override // d2.y
    public final x i(long j5) {
        switch (this.f2715a) {
            case 0:
                q qVar = (q) this.f2717c;
                g1.a.l(qVar.f2727k);
                a5.d dVar = qVar.f2727k;
                long[] jArr = (long[]) dVar.f174j;
                long[] jArr2 = (long[]) dVar.f175k;
                int c9 = g1.w.c(g1.w.i((qVar.f2722e * j5) / 1000000, 0L, qVar.f2726j - 1), jArr, false);
                long j9 = c9 == -1 ? 0L : jArr[c9];
                long j10 = c9 != -1 ? jArr2[c9] : 0L;
                int i9 = qVar.f2722e;
                long j11 = (j9 * 1000000) / i9;
                long j12 = this.f2716b;
                z zVar = new z(j11, j10 + j12);
                if (j11 == j5 || c9 == jArr.length - 1) {
                    return new x(zVar, zVar);
                }
                int i10 = c9 + 1;
                return new x(zVar, new z((jArr[i10] * 1000000) / i9, j12 + jArr2[i10]));
            case 1:
                return (x) this.f2717c;
            default:
                f2.b bVar = (f2.b) this.f2717c;
                x b9 = bVar.f3283i[0].b(j5);
                int i11 = 1;
                while (true) {
                    f2.e[] eVarArr = bVar.f3283i;
                    if (i11 >= eVarArr.length) {
                        return b9;
                    }
                    x b10 = eVarArr[i11].b(j5);
                    if (b10.f2753a.f2757b < b9.f2753a.f2757b) {
                        b9 = b10;
                    }
                    i11++;
                }
        }
    }

    @Override // d2.y
    public final long k() {
        switch (this.f2715a) {
        }
        return this.f2716b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(long j5) {
        this(j5, 0L);
        this.f2715a = 1;
    }

    public /* synthetic */ p(int i9, long j5, Object obj) {
        this.f2715a = i9;
        this.f2717c = obj;
        this.f2716b = j5;
    }
}
