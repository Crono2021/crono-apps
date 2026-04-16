package n;

import android.view.View;
import androidx.appcompat.widget.SearchView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z2 implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f7129a;

    public z2(SearchView searchView) {
        this.f7129a = searchView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z8) {
        SearchView searchView = this.f7129a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.S;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z8);
        }
    }
}
