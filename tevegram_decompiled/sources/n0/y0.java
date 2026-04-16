package n0;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y0 extends t7.g implements a8.p {

    /* renamed from: k, reason: collision with root package name */
    public int f7237k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f7238l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f7239m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(View view, r7.c cVar) {
        super(cVar);
        this.f7239m = view;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        return ((y0) j((g8.c) obj, (r7.c) obj2)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        y0 y0Var = new y0(this.f7239m, cVar);
        y0Var.f7238l = obj;
        return y0Var;
    }

    @Override // t7.a
    public final Object k(Object obj) {
        Object obj2;
        Object obj3 = n7.g.f7490c;
        int i9 = this.f7237k;
        View view = this.f7239m;
        Object obj4 = s7.a.f8891i;
        if (i9 == 0) {
            com.bumptech.glide.c.V(obj);
            g8.c cVar = (g8.c) this.f7238l;
            this.f7238l = cVar;
            this.f7237k = 1;
            cVar.f3846j = view;
            cVar.f3845i = 3;
            cVar.f3848l = this;
            return obj4;
        }
        if (i9 == 1) {
            g8.c cVar2 = (g8.c) this.f7238l;
            com.bumptech.glide.c.V(obj);
            if (view instanceof ViewGroup) {
                x0 x0Var = new x0((ViewGroup) view, null);
                this.f7238l = null;
                this.f7237k = 2;
                cVar2.getClass();
                g8.c cVar3 = new g8.c();
                cVar3.f3848l = x0Var.j(cVar3, cVar3);
                if (cVar3.hasNext()) {
                    cVar2.f3847k = cVar3;
                    cVar2.f3845i = 2;
                    cVar2.f3848l = this;
                    obj2 = obj4;
                } else {
                    obj2 = obj3;
                }
                if (obj2 != obj4) {
                    obj2 = obj3;
                }
                if (obj2 == obj4) {
                    return obj4;
                }
            }
        } else {
            if (i9 != 2) {
                m7.c.p("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            com.bumptech.glide.c.V(obj);
        }
        return obj3;
    }
}
