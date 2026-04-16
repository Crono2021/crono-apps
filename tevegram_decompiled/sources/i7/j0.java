package i7;

import com.network.tvgramplayer.ui.LoginActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j0 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4919m;

    /* renamed from: n, reason: collision with root package name */
    public int f4920n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ h7.k0 f4921o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f4922p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(h7.k0 k0Var, LoginActivity loginActivity, r7.c cVar, int i9) {
        super(2, cVar);
        this.f4919m = i9;
        this.f4921o = k0Var;
        this.f4922p = loginActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        i8.u uVar = (i8.u) obj;
        r7.c cVar = (r7.c) obj2;
        switch (this.f4919m) {
            case 0:
                ((j0) j(uVar, cVar)).k(n7.g.f7490c);
                break;
            case 1:
                ((j0) j(uVar, cVar)).k(n7.g.f7490c);
                break;
            default:
                ((j0) j(uVar, cVar)).k(n7.g.f7490c);
                break;
        }
        return s7.a.f8891i;
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        switch (this.f4919m) {
            case 0:
                return new j0(this.f4921o, this.f4922p, cVar, 0);
            case 1:
                return new j0(this.f4921o, this.f4922p, cVar, 1);
            default:
                return new j0(this.f4921o, this.f4922p, cVar, 2);
        }
    }

    @Override // t7.a
    public final Object k(Object obj) {
        switch (this.f4919m) {
            case 0:
                int i9 = this.f4920n;
                if (i9 != 0) {
                    if (i9 != 1) {
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                    throw new androidx.fragment.app.r();
                }
                com.bumptech.glide.c.V(obj);
                l8.d dVar = this.f4921o.f4135e;
                i0 i0Var = new i0(this.f4922p, 0);
                this.f4920n = 1;
                dVar.b(i0Var, this);
                return s7.a.f8891i;
            case 1:
                int i10 = this.f4920n;
                if (i10 != 0) {
                    if (i10 != 1) {
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                    throw new androidx.fragment.app.r();
                }
                com.bumptech.glide.c.V(obj);
                l8.d dVar2 = this.f4921o.f4138i;
                i0 i0Var2 = new i0(this.f4922p, 1);
                this.f4920n = 1;
                dVar2.b(i0Var2, this);
                return s7.a.f8891i;
            default:
                int i11 = this.f4920n;
                if (i11 != 0) {
                    if (i11 != 1) {
                        m7.c.p("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    com.bumptech.glide.c.V(obj);
                    throw new androidx.fragment.app.r();
                }
                com.bumptech.glide.c.V(obj);
                l8.d dVar3 = this.f4921o.f4137g;
                i0 i0Var3 = new i0(this.f4922p, 2);
                this.f4920n = 1;
                dVar3.b(i0Var3, this);
                return s7.a.f8891i;
        }
    }
}
