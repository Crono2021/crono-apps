package k2;

import b2.d0;
import d2.j;
import d2.m;
import d2.n;
import d2.o;
import g1.p;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements m {

    /* renamed from: b, reason: collision with root package name */
    public o f5526b;

    /* renamed from: c, reason: collision with root package name */
    public int f5527c;

    /* renamed from: d, reason: collision with root package name */
    public int f5528d;

    /* renamed from: e, reason: collision with root package name */
    public int f5529e;

    /* renamed from: g, reason: collision with root package name */
    public r2.a f5531g;
    public n h;

    /* renamed from: i, reason: collision with root package name */
    public d0 f5532i;

    /* renamed from: j, reason: collision with root package name */
    public w2.m f5533j;

    /* renamed from: a, reason: collision with root package name */
    public final p f5525a = new p(6);

    /* renamed from: f, reason: collision with root package name */
    public long f5530f = -1;

    public final void b() {
        o oVar = this.f5526b;
        oVar.getClass();
        oVar.c();
        this.f5526b.t(new d2.p(-9223372036854775807L));
        this.f5527c = 6;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        if (j5 == 0) {
            this.f5527c = 0;
            this.f5533j = null;
        } else if (this.f5527c == 5) {
            w2.m mVar = this.f5533j;
            mVar.getClass();
            mVar.c(j5, j9);
        }
    }

    @Override // d2.m
    public final void d(o oVar) {
        this.f5526b = oVar;
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        j jVar = (j) nVar;
        p pVar = this.f5525a;
        pVar.C(2);
        jVar.n(pVar.f3699a, 0, 2, false);
        if (pVar.z() == 65496) {
            pVar.C(2);
            jVar.n(pVar.f3699a, 0, 2, false);
            int z8 = pVar.z();
            this.f5528d = z8;
            if (z8 == 65504) {
                pVar.C(2);
                jVar.n(pVar.f3699a, 0, 2, false);
                jVar.c(pVar.z() - 2, false);
                pVar.C(2);
                jVar.n(pVar.f3699a, 0, 2, false);
                this.f5528d = pVar.z();
            }
            if (this.f5528d == 65505) {
                jVar.c(2, false);
                pVar.C(6);
                jVar.n(pVar.f3699a, 0, 6, false);
                if (pVar.v() == 1165519206 && pVar.z() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0178  */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(d2.n r26, d1.w r27) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.a.h(d2.n, d1.w):int");
    }

    @Override // d2.m
    public final void release() {
        w2.m mVar = this.f5533j;
        if (mVar != null) {
            mVar.getClass();
        }
    }

    @Override // d2.m
    public final m a() {
        return this;
    }
}
