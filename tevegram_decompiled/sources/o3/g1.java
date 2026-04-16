package o3;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g1 extends r0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7662a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f7663b;

    public g1(c0 c0Var) {
        this.f7663b = c0Var;
    }

    @Override // o3.r0
    public final void a(RecyclerView recyclerView, int i9) {
        if (i9 == 0 && this.f7662a) {
            this.f7662a = false;
            this.f7663b.f();
        }
    }

    @Override // o3.r0
    public final void b(RecyclerView recyclerView, int i9, int i10) {
        if (i9 == 0 && i10 == 0) {
            return;
        }
        this.f7662a = true;
    }
}
