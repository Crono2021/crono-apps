package g2;

import d1.w;
import d2.a0;
import d2.m;
import d2.n;
import d2.o;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3726a;

    /* renamed from: b, reason: collision with root package name */
    public final m f3727b;

    public a(int i9, byte b9) {
        this.f3726a = i9;
        switch (i9) {
            case 1:
                this.f3727b = new a0(35152, 2, "image/png");
                break;
            default:
                this.f3727b = new a0(16973, 2, "image/bmp");
                break;
        }
    }

    @Override // d2.m
    public final m a() {
        int i9 = this.f3726a;
        return this;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        switch (this.f3726a) {
            case 0:
                ((a0) this.f3727b).c(j5, j9);
                break;
            case 1:
                ((a0) this.f3727b).c(j5, j9);
                break;
            default:
                this.f3727b.c(j5, j9);
                break;
        }
    }

    @Override // d2.m
    public final void d(o oVar) {
        switch (this.f3726a) {
            case 0:
                ((a0) this.f3727b).d(oVar);
                break;
            case 1:
                ((a0) this.f3727b).d(oVar);
                break;
            default:
                this.f3727b.d(oVar);
                break;
        }
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        switch (this.f3726a) {
            case 0:
                return ((a0) this.f3727b).g(nVar);
            case 1:
                return ((a0) this.f3727b).g(nVar);
            default:
                return this.f3727b.g(nVar);
        }
    }

    @Override // d2.m
    public final int h(n nVar, w wVar) {
        switch (this.f3726a) {
            case 0:
                return ((a0) this.f3727b).h(nVar, wVar);
            case 1:
                return ((a0) this.f3727b).h(nVar, wVar);
            default:
                return this.f3727b.h(nVar, wVar);
        }
    }

    @Override // d2.m
    public final void release() {
        switch (this.f3726a) {
            case 0:
            case 1:
                break;
            default:
                this.f3727b.release();
                break;
        }
    }

    private final void b() {
    }

    private final void e() {
    }

    public a(int i9) {
        this.f3726a = 2;
        if ((i9 & 1) != 0) {
            this.f3727b = new a0(65496, 2, "image/jpeg");
        } else {
            this.f3727b = new k2.a();
        }
    }
}
