package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements View.OnKeyListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ SearchView f522i;

    public b(SearchView searchView) {
        this.f522i = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i9, KeyEvent keyEvent) {
        SearchView searchView = this.f522i;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f467x;
        if (searchView.f462j0 != null) {
            if (!searchAutoComplete.isPopupShowing() || searchAutoComplete.getListSelection() == -1) {
                if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) != 0 && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i9 == 66) {
                    view.cancelLongPress();
                    searchView.getContext().startActivity(searchView.j("android.intent.action.SEARCH", null, null, searchAutoComplete.getText().toString()));
                    return true;
                }
            } else if (searchView.f462j0 != null && searchView.W != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                if (i9 == 66 || i9 == 84 || i9 == 61) {
                    searchView.n(searchAutoComplete.getListSelection());
                    return true;
                }
                if (i9 == 21 || i9 == 22) {
                    searchAutoComplete.setSelection(i9 == 21 ? 0 : searchAutoComplete.length());
                    searchAutoComplete.setListSelection(0);
                    searchAutoComplete.clearListSelection();
                    searchAutoComplete.a();
                    return true;
                }
                if (i9 == 19) {
                    searchAutoComplete.getListSelection();
                    return false;
                }
            }
        }
        return false;
    }
}
