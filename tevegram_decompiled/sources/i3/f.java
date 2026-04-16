package i3;

import d1.l0;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public final g1.p f4485a;

    /* renamed from: c, reason: collision with root package name */
    public final String f4487c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4488d;

    /* renamed from: e, reason: collision with root package name */
    public String f4489e;

    /* renamed from: f, reason: collision with root package name */
    public d2.d0 f4490f;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f4492i;

    /* renamed from: j, reason: collision with root package name */
    public long f4493j;

    /* renamed from: k, reason: collision with root package name */
    public d1.s f4494k;

    /* renamed from: l, reason: collision with root package name */
    public int f4495l;

    /* renamed from: m, reason: collision with root package name */
    public int f4496m;

    /* renamed from: g, reason: collision with root package name */
    public int f4491g = 0;

    /* renamed from: p, reason: collision with root package name */
    public long f4499p = -9223372036854775807L;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f4486b = new AtomicInteger();

    /* renamed from: n, reason: collision with root package name */
    public int f4497n = -1;

    /* renamed from: o, reason: collision with root package name */
    public int f4498o = -1;

    public f(String str, int i9, int i10) {
        this.f4485a = new g1.p(new byte[i10]);
        this.f4487c = str;
        this.f4488d = i9;
    }

    @Override // i3.h
    public final void a() {
        this.f4491g = 0;
        this.h = 0;
        this.f4492i = 0;
        this.f4499p = -9223372036854775807L;
        this.f4486b.set(0);
    }

    public final boolean b(g1.p pVar, byte[] bArr, int i9) {
        int min = Math.min(pVar.a(), i9 - this.h);
        pVar.e(this.h, min, bArr);
        int i10 = this.h + min;
        this.h = i10;
        return i10 == i9;
    }

    /* JADX WARN: Removed duplicated region for block: B:193:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04b3  */
    @Override // i3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(g1.p r40) {
        /*
            Method dump skipped, instructions count: 1408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.f.c(g1.p):void");
    }

    @Override // i3.h
    public final void d(int i9, long j5) {
        this.f4499p = j5;
    }

    @Override // i3.h
    public final void f(d2.o oVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f4489e = e0Var.f4484e;
        e0Var.b();
        this.f4490f = oVar.l(e0Var.f4483d, 1);
    }

    public final void g(d2.a aVar) {
        int i9 = aVar.f2622b;
        String str = aVar.f2621a;
        int i10 = aVar.f2623c;
        if (i9 == -2147483647 || i10 == -1) {
            return;
        }
        d1.s sVar = this.f4494k;
        if (sVar != null && i10 == sVar.f2567z && i9 == sVar.A && str.equals(sVar.f2554m)) {
            return;
        }
        d1.s sVar2 = this.f4494k;
        d1.r rVar = sVar2 == null ? new d1.r() : sVar2.a();
        rVar.f2518a = this.f4489e;
        rVar.f2528l = l0.k(str);
        rVar.f2541y = i10;
        rVar.f2542z = i9;
        rVar.f2521d = this.f4487c;
        rVar.f2523f = this.f4488d;
        d1.s sVar3 = new d1.s(rVar);
        this.f4494k = sVar3;
        this.f4490f.e(sVar3);
    }

    @Override // i3.h
    public final void e() {
    }
}
