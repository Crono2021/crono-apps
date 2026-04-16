package androidx.fragment.app;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g0 implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f731a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f732b;

    public g0(h0 h0Var, int i9) {
        this.f732b = h0Var;
        this.f731a = i9;
    }

    @Override // androidx.fragment.app.f0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        h0 h0Var = this.f732b;
        s sVar = h0Var.f751q;
        int i9 = this.f731a;
        if (sVar == null || i9 >= 0 || !sVar.e().J()) {
            return h0Var.K(arrayList, arrayList2, i9, 1);
        }
        return false;
    }
}
