package i2;

import d2.j;
import d2.l;
import d2.m;
import d2.n;
import d2.o;
import g1.p;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements m {

    /* renamed from: a, reason: collision with root package name */
    public final p f4377a = new p(4);

    /* renamed from: b, reason: collision with root package name */
    public final p f4378b = new p(9);

    /* renamed from: c, reason: collision with root package name */
    public final p f4379c = new p(11);

    /* renamed from: d, reason: collision with root package name */
    public final p f4380d = new p();

    /* renamed from: e, reason: collision with root package name */
    public final c f4381e;

    /* renamed from: f, reason: collision with root package name */
    public o f4382f;

    /* renamed from: g, reason: collision with root package name */
    public int f4383g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public long f4384i;

    /* renamed from: j, reason: collision with root package name */
    public int f4385j;

    /* renamed from: k, reason: collision with root package name */
    public int f4386k;

    /* renamed from: l, reason: collision with root package name */
    public int f4387l;

    /* renamed from: m, reason: collision with root package name */
    public long f4388m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4389n;

    /* renamed from: o, reason: collision with root package name */
    public a f4390o;

    /* renamed from: p, reason: collision with root package name */
    public e f4391p;

    public b() {
        c cVar = new c(new l());
        cVar.f4392j = -9223372036854775807L;
        cVar.f4393k = new long[0];
        cVar.f4394l = new long[0];
        this.f4381e = cVar;
        this.f4383g = 1;
    }

    public final p b(n nVar) {
        int i9 = this.f4387l;
        p pVar = this.f4380d;
        byte[] bArr = pVar.f3699a;
        if (i9 > bArr.length) {
            pVar.D(new byte[Math.max(bArr.length * 2, i9)], 0);
        } else {
            pVar.F(0);
        }
        pVar.E(this.f4387l);
        nVar.readFully(pVar.f3699a, 0, this.f4387l);
        return pVar;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        if (j5 == 0) {
            this.f4383g = 1;
            this.h = false;
        } else {
            this.f4383g = 3;
        }
        this.f4385j = 0;
    }

    @Override // d2.m
    public final void d(o oVar) {
        this.f4382f = oVar;
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        p pVar = this.f4377a;
        j jVar = (j) nVar;
        jVar.n(pVar.f3699a, 0, 3, false);
        pVar.F(0);
        if (pVar.w() == 4607062) {
            jVar.n(pVar.f3699a, 0, 2, false);
            pVar.F(0);
            if ((pVar.z() & 250) == 0) {
                jVar.n(pVar.f3699a, 0, 4, false);
                pVar.F(0);
                int g9 = pVar.g();
                jVar.f2705n = 0;
                jVar.c(g9, false);
                jVar.n(pVar.f3699a, 0, 4, false);
                pVar.F(0);
                if (pVar.g() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x037b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0394 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0009 A[SYNTHETIC] */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(d2.n r29, d1.w r30) {
        /*
            Method dump skipped, instructions count: 1087
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.b.h(d2.n, d1.w):int");
    }

    @Override // d2.m
    public final m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
