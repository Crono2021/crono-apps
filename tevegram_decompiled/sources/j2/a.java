package j2;

import d1.w;
import d2.a0;
import d2.j;
import d2.m;
import d2.n;
import d2.o;
import g1.p;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5384a;

    /* renamed from: b, reason: collision with root package name */
    public final p f5385b;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f5386c;

    public a(int i9) {
        this.f5384a = i9;
        switch (i9) {
            case 1:
                this.f5385b = new p(4);
                this.f5386c = new a0(-1, -1, "image/webp");
                break;
            default:
                this.f5385b = new p(4);
                this.f5386c = new a0(-1, -1, "image/heif");
                break;
        }
    }

    @Override // d2.m
    public final m a() {
        int i9 = this.f5384a;
        return this;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        switch (this.f5384a) {
            case 0:
                this.f5386c.c(j5, j9);
                break;
            default:
                this.f5386c.c(j5, j9);
                break;
        }
    }

    @Override // d2.m
    public final void d(o oVar) {
        switch (this.f5384a) {
            case 0:
                this.f5386c.d(oVar);
                break;
            default:
                this.f5386c.d(oVar);
                break;
        }
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        switch (this.f5384a) {
            case 0:
                j jVar = (j) nVar;
                jVar.c(4, false);
                p pVar = this.f5385b;
                pVar.C(4);
                jVar.n(pVar.f3699a, 0, 4, false);
                if (pVar.v() == 1718909296) {
                    pVar.C(4);
                    jVar.n(pVar.f3699a, 0, 4, false);
                    if (pVar.v() == 1751476579) {
                    }
                }
                break;
            default:
                p pVar2 = this.f5385b;
                pVar2.C(4);
                j jVar2 = (j) nVar;
                jVar2.n(pVar2.f3699a, 0, 4, false);
                if (pVar2.v() == 1380533830) {
                    jVar2.c(4, false);
                    pVar2.C(4);
                    jVar2.n(pVar2.f3699a, 0, 4, false);
                    if (pVar2.v() == 1464156752) {
                    }
                }
                break;
        }
        return false;
    }

    @Override // d2.m
    public final int h(n nVar, w wVar) {
        switch (this.f5384a) {
        }
        return this.f5386c.h(nVar, wVar);
    }

    @Override // d2.m
    public final void release() {
        int i9 = this.f5384a;
    }

    private final void b() {
    }

    private final void e() {
    }
}
