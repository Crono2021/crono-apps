package x2;

import d1.m0;
import d2.m;
import d2.n;
import d2.o;
import g1.p;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements m {

    /* renamed from: a, reason: collision with root package name */
    public o f10057a;

    /* renamed from: b, reason: collision with root package name */
    public i f10058b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f10059c;

    public final boolean b(n nVar) {
        boolean z8;
        f fVar = new f();
        if (fVar.a(nVar, true) && (fVar.f10065a & 2) == 2) {
            int min = Math.min(fVar.f10069e, 8);
            p pVar = new p(min);
            nVar.a(0, min, pVar.f3699a);
            pVar.F(0);
            if (pVar.a() >= 5 && pVar.t() == 127 && pVar.v() == 1179402563) {
                this.f10058b = new c();
                return true;
            }
            pVar.F(0);
            try {
                z8 = d2.b.t(1, pVar, true);
            } catch (m0 unused) {
                z8 = false;
            }
            if (z8) {
                this.f10058b = new j();
            } else {
                pVar.F(0);
                if (h.e(pVar, h.f10072o)) {
                    this.f10058b = new h();
                }
            }
            return true;
        }
        return false;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        i iVar = this.f10058b;
        if (iVar != null) {
            e eVar = iVar.f10075a;
            f fVar = eVar.f10060a;
            fVar.f10065a = 0;
            fVar.f10066b = 0L;
            fVar.f10067c = 0;
            fVar.f10068d = 0;
            fVar.f10069e = 0;
            eVar.f10061b.C(0);
            eVar.f10062c = -1;
            eVar.f10064e = false;
            if (j5 == 0) {
                iVar.d(!iVar.f10085l);
                return;
            }
            if (iVar.h != 0) {
                long j10 = (iVar.f10082i * j9) / 1000000;
                iVar.f10079e = j10;
                g gVar = iVar.f10078d;
                int i9 = w.f3713a;
                gVar.p(j10);
                iVar.h = 2;
            }
        }
    }

    @Override // d2.m
    public final void d(o oVar) {
        this.f10057a = oVar;
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        try {
            return b(nVar);
        } catch (m0 unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x016c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016d  */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(d2.n r21, d1.w r22) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.d.h(d2.n, d1.w):int");
    }

    @Override // d2.m
    public final m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
