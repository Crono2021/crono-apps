package j3;

import d1.l0;
import d1.m0;
import d1.r;
import d1.s;
import d2.d0;
import d2.o;
import g1.p;
import g1.w;
import java.math.RoundingMode;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements b {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f5387m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f5388n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

    /* renamed from: a, reason: collision with root package name */
    public final o f5389a;

    /* renamed from: b, reason: collision with root package name */
    public final d0 f5390b;

    /* renamed from: c, reason: collision with root package name */
    public final e f5391c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5392d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f5393e;

    /* renamed from: f, reason: collision with root package name */
    public final p f5394f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5395g;
    public final s h;

    /* renamed from: i, reason: collision with root package name */
    public int f5396i;

    /* renamed from: j, reason: collision with root package name */
    public long f5397j;

    /* renamed from: k, reason: collision with root package name */
    public int f5398k;

    /* renamed from: l, reason: collision with root package name */
    public long f5399l;

    public a(o oVar, d0 d0Var, e eVar) {
        this.f5389a = oVar;
        this.f5390b = d0Var;
        this.f5391c = eVar;
        int i9 = eVar.f5416c;
        int max = Math.max(1, i9 / 10);
        this.f5395g = max;
        p pVar = new p((byte[]) eVar.f5419f);
        pVar.m();
        int m9 = pVar.m();
        this.f5392d = m9;
        int i10 = eVar.f5415b;
        int i11 = eVar.f5417d;
        int i12 = (((i11 - (i10 * 4)) * 8) / (eVar.f5418e * i10)) + 1;
        if (m9 != i12) {
            throw m0.a(null, "Expected frames per block: " + i12 + "; got: " + m9);
        }
        int f9 = w.f(max, m9);
        this.f5393e = new byte[f9 * i11];
        this.f5394f = new p(m9 * 2 * i10 * f9);
        int i13 = ((i11 * i9) * 8) / m9;
        r rVar = new r();
        rVar.f2528l = l0.k("audio/raw");
        rVar.f2524g = i13;
        rVar.h = i13;
        rVar.f2529m = max * 2 * i10;
        rVar.f2541y = i10;
        rVar.f2542z = i9;
        rVar.A = 2;
        this.h = new s(rVar);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0046 A[ADDED_TO_REGION, EDGE_INSN: B:49:0x0046->B:14:0x0046 BREAK  A[LOOP:0: B:5:0x0024->B:11:0x0040], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003d -> B:3:0x0021). Please report as a decompilation issue!!! */
    @Override // j3.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(d2.n r25, long r26) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.a.a(d2.n, long):boolean");
    }

    @Override // j3.b
    public final void b(int i9, long j5) {
        this.f5389a.t(new g(this.f5391c, this.f5392d, i9, j5));
        this.f5390b.e(this.h);
    }

    @Override // j3.b
    public final void c(long j5) {
        this.f5396i = 0;
        this.f5397j = j5;
        this.f5398k = 0;
        this.f5399l = 0L;
    }

    public final void d(int i9) {
        long j5 = this.f5397j;
        long j9 = this.f5399l;
        e eVar = this.f5391c;
        long j10 = eVar.f5416c;
        int i10 = w.f3713a;
        long S = j5 + w.S(j9, 1000000L, j10, RoundingMode.FLOOR);
        int i11 = i9 * 2 * eVar.f5415b;
        this.f5390b.d(S, 1, i11, this.f5398k - i11, null);
        this.f5399l += i9;
        this.f5398k -= i11;
    }
}
