package l;

import n.y3;
import n0.d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f5727p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5728q;

    /* renamed from: r, reason: collision with root package name */
    public int f5729r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f5730s;

    public j(k kVar) {
        this.f5727p = 0;
        this.f5730s = kVar;
        this.f5728q = false;
        this.f5729r = 0;
    }

    @Override // n0.d1
    public final void a() {
        switch (this.f5727p) {
            case 0:
                int i9 = this.f5729r + 1;
                this.f5729r = i9;
                k kVar = (k) this.f5730s;
                if (i9 == kVar.f5731a.size()) {
                    d1 d1Var = kVar.f5734d;
                    if (d1Var != null) {
                        d1Var.a();
                    }
                    this.f5729r = 0;
                    this.f5728q = false;
                    kVar.f5735e = false;
                    break;
                }
                break;
            default:
                if (!this.f5728q) {
                    ((y3) this.f5730s).f7109a.setVisibility(this.f5729r);
                    break;
                }
                break;
        }
    }

    @Override // com.bumptech.glide.c, n0.d1
    public void b() {
        switch (this.f5727p) {
            case 1:
                this.f5728q = true;
                break;
        }
    }

    @Override // com.bumptech.glide.c, n0.d1
    public final void c() {
        switch (this.f5727p) {
            case 0:
                if (!this.f5728q) {
                    this.f5728q = true;
                    d1 d1Var = ((k) this.f5730s).f5734d;
                    if (d1Var != null) {
                        d1Var.c();
                        break;
                    }
                }
                break;
            default:
                ((y3) this.f5730s).f7109a.setVisibility(0);
                break;
        }
    }

    public j(y3 y3Var, int i9) {
        this.f5727p = 1;
        this.f5730s = y3Var;
        this.f5729r = i9;
        this.f5728q = false;
    }
}
