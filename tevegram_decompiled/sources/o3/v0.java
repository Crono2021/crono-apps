package o3;

import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f7826a;

    public v0(RecyclerView recyclerView) {
        this.f7826a = recyclerView;
    }

    public final void a() {
        boolean z8 = RecyclerView.K0;
        RecyclerView recyclerView = this.f7826a;
        if (!z8 || !recyclerView.B || !recyclerView.A) {
            recyclerView.I = true;
            recyclerView.requestLayout();
        } else {
            d0 d0Var = recyclerView.f1070q;
            WeakHashMap weakHashMap = n0.t0.f7209a;
            n0.c0.m(recyclerView, d0Var);
        }
    }
}
