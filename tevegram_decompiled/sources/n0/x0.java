package n0;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x0 extends t7.g implements a8.p {

    /* renamed from: k, reason: collision with root package name */
    public ViewGroup f7227k;

    /* renamed from: l, reason: collision with root package name */
    public View f7228l;

    /* renamed from: m, reason: collision with root package name */
    public int f7229m;

    /* renamed from: n, reason: collision with root package name */
    public int f7230n;

    /* renamed from: o, reason: collision with root package name */
    public int f7231o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f7232p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f7233q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(ViewGroup viewGroup, r7.c cVar) {
        super(cVar);
        this.f7233q = viewGroup;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        return ((x0) j((g8.c) obj, (r7.c) obj2)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        x0 x0Var = new x0(this.f7233q, cVar);
        x0Var.f7232p = obj;
        return x0Var;
    }

    @Override // t7.a
    public final Object k(Object obj) {
        g8.c cVar;
        ViewGroup viewGroup;
        int childCount;
        int i9;
        int i10;
        Object obj2;
        int i11;
        ViewGroup viewGroup2;
        g8.c cVar2;
        Object obj3 = n7.g.f7490c;
        int i12 = this.f7231o;
        Object obj4 = s7.a.f8891i;
        if (i12 != 0) {
            if (i12 == 1) {
                childCount = this.f7230n;
                i10 = this.f7229m;
                View view = this.f7228l;
                viewGroup = this.f7227k;
                cVar = (g8.c) this.f7232p;
                com.bumptech.glide.c.V(obj);
                if (view instanceof ViewGroup) {
                    x0 x0Var = new x0((ViewGroup) view, null);
                    this.f7232p = cVar;
                    this.f7227k = viewGroup;
                    this.f7228l = null;
                    this.f7229m = i10;
                    this.f7230n = childCount;
                    this.f7231o = 2;
                    cVar.getClass();
                    g8.c cVar3 = new g8.c();
                    cVar3.f3848l = x0Var.j(cVar3, cVar3);
                    if (cVar3.hasNext()) {
                        cVar.f3847k = cVar3;
                        cVar.f3845i = 2;
                        cVar.f3848l = this;
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
                    i11 = i10;
                    viewGroup2 = viewGroup;
                    cVar2 = cVar;
                }
                i9 = i10 + 1;
            } else {
                if (i12 != 2) {
                    m7.c.p("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                childCount = this.f7230n;
                i11 = this.f7229m;
                viewGroup2 = this.f7227k;
                cVar2 = (g8.c) this.f7232p;
                com.bumptech.glide.c.V(obj);
            }
            viewGroup = viewGroup2;
            cVar = cVar2;
            i10 = i11;
            i9 = i10 + 1;
        } else {
            com.bumptech.glide.c.V(obj);
            cVar = (g8.c) this.f7232p;
            viewGroup = this.f7233q;
            childCount = viewGroup.getChildCount();
            i9 = 0;
        }
        if (i9 >= childCount) {
            return obj3;
        }
        View childAt = viewGroup.getChildAt(i9);
        this.f7232p = cVar;
        this.f7227k = viewGroup;
        this.f7228l = childAt;
        this.f7229m = i9;
        this.f7230n = childCount;
        this.f7231o = 1;
        cVar.f3846j = childAt;
        cVar.f3845i = 3;
        cVar.f3848l = this;
        return obj4;
    }
}
