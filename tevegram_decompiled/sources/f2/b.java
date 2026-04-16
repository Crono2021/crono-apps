package f2;

import b2.l;
import d2.m;
import d2.n;
import d2.o;
import g1.p;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements m {

    /* renamed from: a, reason: collision with root package name */
    public final p f3276a;

    /* renamed from: b, reason: collision with root package name */
    public final l f3277b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3278c;

    /* renamed from: d, reason: collision with root package name */
    public final z2.c f3279d;

    /* renamed from: e, reason: collision with root package name */
    public int f3280e;

    /* renamed from: f, reason: collision with root package name */
    public o f3281f;

    /* renamed from: g, reason: collision with root package name */
    public c f3282g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public e[] f3283i;

    /* renamed from: j, reason: collision with root package name */
    public long f3284j;

    /* renamed from: k, reason: collision with root package name */
    public e f3285k;

    /* renamed from: l, reason: collision with root package name */
    public int f3286l;

    /* renamed from: m, reason: collision with root package name */
    public long f3287m;

    /* renamed from: n, reason: collision with root package name */
    public long f3288n;

    /* renamed from: o, reason: collision with root package name */
    public int f3289o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3290p;

    public b(int i9, z2.c cVar) {
        this.f3279d = cVar;
        this.f3278c = (i9 & 1) == 0;
        this.f3276a = new p(12);
        this.f3277b = new l();
        this.f3281f = new u5.e(27);
        this.f3283i = new e[0];
        this.f3287m = -1L;
        this.f3288n = -1L;
        this.f3286l = -1;
        this.h = -9223372036854775807L;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        this.f3284j = -1L;
        this.f3285k = null;
        for (e eVar : this.f3283i) {
            if (eVar.f3307j == 0) {
                eVar.h = 0;
            } else {
                eVar.h = eVar.f3309l[w.c(j5, eVar.f3308k, true)];
            }
        }
        if (j5 != 0) {
            this.f3280e = 6;
        } else if (this.f3283i.length == 0) {
            this.f3280e = 0;
        } else {
            this.f3280e = 3;
        }
    }

    @Override // d2.m
    public final void d(o oVar) {
        this.f3280e = 0;
        if (this.f3278c) {
            oVar = new x.c(oVar, this.f3279d);
        }
        this.f3281f = oVar;
        this.f3284j = -1L;
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        p pVar = this.f3276a;
        nVar.a(0, 12, pVar.f3699a);
        pVar.F(0);
        if (pVar.i() == 1179011410) {
            pVar.G(4);
            if (pVar.i() == 541677121) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010d  */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(d2.n r23, d1.w r24) {
        /*
            Method dump skipped, instructions count: 1080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.b.h(d2.n, d1.w):int");
    }

    @Override // d2.m
    public final m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
