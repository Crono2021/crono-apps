package n;

import android.content.Context;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends m.x {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6860l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ j f6861m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(j jVar, Context context, m.f0 f0Var, View view) {
        super(context, f0Var, view, false, 2130968608, 0);
        this.f6861m = jVar;
        if ((f0Var.I.F & 32) != 32) {
            View view2 = jVar.f6912q;
            this.f6488e = view2 == null ? (View) jVar.f6911p : view2;
        }
        i7.x xVar = jVar.E;
        this.h = xVar;
        m.u uVar = this.f6491i;
        if (uVar != null) {
            uVar.j(xVar);
        }
    }

    @Override // m.x
    public final void c() {
        switch (this.f6860l) {
            case 0:
                this.f6861m.B = null;
                super.c();
                break;
            default:
                j jVar = this.f6861m;
                m.m mVar = jVar.f6906k;
                if (mVar != null) {
                    mVar.c(true);
                }
                jVar.A = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(j jVar, Context context, m.m mVar, View view) {
        super(context, mVar, view, true, 2130968608, 0);
        this.f6861m = jVar;
        this.f6489f = 8388613;
        i7.x xVar = jVar.E;
        this.h = xVar;
        m.u uVar = this.f6491i;
        if (uVar != null) {
            uVar.j(xVar);
        }
    }
}
