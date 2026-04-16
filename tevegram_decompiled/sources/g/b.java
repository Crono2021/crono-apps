package g;

import android.view.View;
import android.widget.AbsListView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3450a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3451b;

    public b(View view, View view2) {
        this.f3450a = view;
        this.f3451b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i9, int i10, int i11) {
        i.b(absListView, this.f3450a, this.f3451b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i9) {
    }
}
