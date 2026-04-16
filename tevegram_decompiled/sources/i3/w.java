package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4674a;

    /* renamed from: b, reason: collision with root package name */
    public final g1.u f4675b;

    /* renamed from: c, reason: collision with root package name */
    public final g1.p f4676c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4677d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4678e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4679f;

    /* renamed from: g, reason: collision with root package name */
    public long f4680g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public long f4681i;

    public w(int i9) {
        this.f4674a = i9;
        switch (i9) {
            case 1:
                this.f4675b = new g1.u(0L);
                this.f4680g = -9223372036854775807L;
                this.h = -9223372036854775807L;
                this.f4681i = -9223372036854775807L;
                this.f4676c = new g1.p();
                break;
            default:
                this.f4675b = new g1.u(0L);
                this.f4680g = -9223372036854775807L;
                this.h = -9223372036854775807L;
                this.f4681i = -9223372036854775807L;
                this.f4676c = new g1.p();
                break;
        }
    }

    public static int b(byte[] bArr, int i9) {
        return (bArr[i9 + 3] & 255) | ((bArr[i9] & 255) << 24) | ((bArr[i9 + 1] & 255) << 16) | ((bArr[i9 + 2] & 255) << 8);
    }

    public static long c(g1.p pVar) {
        int i9 = pVar.f3700b;
        if (pVar.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        pVar.e(0, 9, bArr);
        pVar.F(i9);
        byte b9 = bArr[0];
        if ((b9 & 196) == 68) {
            byte b10 = bArr[2];
            if ((b10 & 4) == 4) {
                byte b11 = bArr[4];
                if ((b11 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j5 = b9;
                    long j9 = b10;
                    return ((j9 & 3) << 13) | ((j5 & 3) << 28) | (((56 & j5) >> 3) << 30) | ((bArr[1] & 255) << 20) | (((j9 & 248) >> 3) << 15) | ((bArr[3] & 255) << 5) | ((b11 & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }

    public final void a(d2.n nVar) {
        switch (this.f4674a) {
            case 0:
                byte[] bArr = g1.w.f3718f;
                g1.p pVar = this.f4676c;
                pVar.getClass();
                pVar.D(bArr, bArr.length);
                this.f4677d = true;
                nVar.h();
                break;
            default:
                byte[] bArr2 = g1.w.f3718f;
                g1.p pVar2 = this.f4676c;
                pVar2.getClass();
                pVar2.D(bArr2, bArr2.length);
                this.f4677d = true;
                nVar.h();
                break;
        }
    }
}
