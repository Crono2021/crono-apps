package n;

import android.widget.AbsListView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i2 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k2 f6892a;

    public i2(k2 k2Var) {
        this.f6892a = k2Var;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i9) {
        k2 k2Var = this.f6892a;
        g2 g2Var = k2Var.f6941z;
        a0 a0Var = k2Var.H;
        if (i9 != 1 || a0Var.getInputMethodMode() == 2 || a0Var.getContentView() == null) {
            return;
        }
        k2Var.D.removeCallbacks(g2Var);
        g2Var.run();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i9, int i10, int i11) {
    }
}
