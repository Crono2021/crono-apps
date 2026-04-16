package q1;

import b6.b1;
import b6.g0;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends m {

    /* renamed from: d, reason: collision with root package name */
    public final int f8357d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8358e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8359f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f8360g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f8361i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8362j;

    /* renamed from: k, reason: collision with root package name */
    public final long f8363k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8364l;

    /* renamed from: m, reason: collision with root package name */
    public final long f8365m;

    /* renamed from: n, reason: collision with root package name */
    public final long f8366n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f8367o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f8368p;

    /* renamed from: q, reason: collision with root package name */
    public final d1.n f8369q;

    /* renamed from: r, reason: collision with root package name */
    public final g0 f8370r;

    /* renamed from: s, reason: collision with root package name */
    public final g0 f8371s;

    /* renamed from: t, reason: collision with root package name */
    public final b1 f8372t;

    /* renamed from: u, reason: collision with root package name */
    public final long f8373u;

    /* renamed from: v, reason: collision with root package name */
    public final h f8374v;

    public i(int i9, String str, List list, long j5, boolean z8, long j9, boolean z9, int i10, long j10, int i11, long j11, long j12, boolean z10, boolean z11, boolean z12, d1.n nVar, List list2, List list3, h hVar, Map map) {
        super(str, list, z10);
        this.f8357d = i9;
        this.h = j9;
        this.f8360g = z8;
        this.f8361i = z9;
        this.f8362j = i10;
        this.f8363k = j10;
        this.f8364l = i11;
        this.f8365m = j11;
        this.f8366n = j12;
        this.f8367o = z11;
        this.f8368p = z12;
        this.f8369q = nVar;
        this.f8370r = g0.m(list2);
        this.f8371s = g0.m(list3);
        this.f8372t = b1.a(map);
        if (!list3.isEmpty()) {
            d dVar = (d) b6.q.g(list3);
            this.f8373u = dVar.f8345m + dVar.f8343k;
        } else if (list2.isEmpty()) {
            this.f8373u = 0L;
        } else {
            f fVar = (f) b6.q.g(list2);
            this.f8373u = fVar.f8345m + fVar.f8343k;
        }
        long j13 = -9223372036854775807L;
        if (j5 != -9223372036854775807L) {
            long j14 = this.f8373u;
            j13 = j5 >= 0 ? Math.min(j14, j5) : Math.max(0L, j14 + j5);
        }
        this.f8358e = j13;
        this.f8359f = j5 >= 0;
        this.f8374v = hVar;
    }

    @Override // q1.m
    public final Object a(List list) {
        return this;
    }
}
