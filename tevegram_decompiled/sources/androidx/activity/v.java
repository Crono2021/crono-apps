package androidx.activity;

import androidx.fragment.app.a0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements c {

    /* renamed from: i, reason: collision with root package name */
    public final a0 f351i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ x f352j;

    public v(x xVar, a0 a0Var) {
        a0Var.getClass();
        this.f352j = xVar;
        this.f351i = a0Var;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [a8.a, b8.h] */
    @Override // androidx.activity.c
    public final void cancel() {
        x xVar = this.f352j;
        o7.e eVar = xVar.f355b;
        a0 a0Var = this.f351i;
        eVar.remove(a0Var);
        if (b8.i.a(xVar.f356c, a0Var)) {
            a0Var.getClass();
            xVar.f356c = null;
        }
        a0Var.getClass();
        a0Var.f675b.remove(this);
        ?? r02 = a0Var.f676c;
        if (r02 != 0) {
            r02.d();
        }
        a0Var.f676c = null;
    }
}
