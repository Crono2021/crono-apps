package j3;

import d1.l0;
import d1.m0;
import d1.r;
import d1.s;
import d2.d0;
import d2.n;
import d2.o;
import g1.w;
import java.math.RoundingMode;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final o f5400a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f5401b;

    /* renamed from: c, reason: collision with root package name */
    public final e f5402c;

    /* renamed from: d, reason: collision with root package name */
    public final s f5403d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5404e;

    /* renamed from: f, reason: collision with root package name */
    public long f5405f;

    /* renamed from: g, reason: collision with root package name */
    public int f5406g;
    public long h;

    public c(o oVar, d0 d0Var, e eVar, String str, int i9) {
        this.f5400a = oVar;
        this.f5401b = d0Var;
        this.f5402c = eVar;
        int i10 = eVar.f5415b;
        int i11 = eVar.f5416c;
        int i12 = (eVar.f5418e * i10) / 8;
        int i13 = eVar.f5417d;
        if (i13 != i12) {
            throw m0.a(null, "Expected block size: " + i12 + "; got: " + i13);
        }
        int i14 = i11 * i12;
        int i15 = i14 * 8;
        int max = Math.max(i12, i14 / 10);
        this.f5404e = max;
        r rVar = new r();
        rVar.f2528l = l0.k(str);
        rVar.f2524g = i15;
        rVar.h = i15;
        rVar.f2529m = max;
        rVar.f2541y = i10;
        rVar.f2542z = i11;
        rVar.A = i9;
        this.f5403d = new s(rVar);
    }

    @Override // j3.b
    public final boolean a(n nVar, long j5) {
        int i9;
        int i10;
        long j9 = j5;
        while (j9 > 0 && (i9 = this.f5406g) < (i10 = this.f5404e)) {
            int a9 = this.f5401b.a(nVar, (int) Math.min(i10 - i9, j9), true);
            if (a9 == -1) {
                j9 = 0;
            } else {
                this.f5406g += a9;
                j9 -= a9;
            }
        }
        e eVar = this.f5402c;
        int i11 = eVar.f5417d;
        int i12 = this.f5406g / i11;
        if (i12 > 0) {
            long j10 = this.f5405f;
            long j11 = this.h;
            long j12 = eVar.f5416c;
            int i13 = w.f3713a;
            long S = j10 + w.S(j11, 1000000L, j12, RoundingMode.FLOOR);
            int i14 = i12 * i11;
            int i15 = this.f5406g - i14;
            this.f5401b.d(S, 1, i14, i15, null);
            this.h += i12;
            this.f5406g = i15;
        }
        return j9 <= 0;
    }

    @Override // j3.b
    public final void b(int i9, long j5) {
        this.f5400a.t(new g(this.f5402c, 1, i9, j5));
        this.f5401b.e(this.f5403d);
    }

    @Override // j3.b
    public final void c(long j5) {
        this.f5405f = j5;
        this.f5406g = 0;
        this.h = 0L;
    }
}
