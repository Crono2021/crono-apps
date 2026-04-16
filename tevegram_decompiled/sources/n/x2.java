package n;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x2 implements TextWatcher {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7100i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f7101j;

    public /* synthetic */ x2(ViewGroup viewGroup, int i9) {
        this.f7100i = i9;
        this.f7101j = viewGroup;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.f7100i) {
            case 0:
                break;
            default:
                TextInputLayout textInputLayout = (TextInputLayout) this.f7101j;
                textInputLayout.u(!textInputLayout.H0, false);
                if (textInputLayout.f2158s) {
                    textInputLayout.n(editable);
                }
                if (textInputLayout.A) {
                    textInputLayout.v(editable);
                    break;
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        int i12 = this.f7100i;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        switch (this.f7100i) {
            case 0:
                SearchView searchView = (SearchView) this.f7101j;
                Editable text = searchView.f467x.getText();
                searchView.f460g0 = text;
                boolean isEmpty = TextUtils.isEmpty(text);
                searchView.v(!isEmpty);
                int i12 = 8;
                if (searchView.f459f0 && !searchView.V && isEmpty) {
                    searchView.C.setVisibility(8);
                    i12 = 0;
                }
                searchView.E.setVisibility(i12);
                searchView.r();
                searchView.u();
                charSequence.toString();
                break;
        }
    }

    private final void a(Editable editable) {
    }

    private final void b(int i9, int i10, int i11, CharSequence charSequence) {
    }

    private final void c(int i9, int i10, int i11, CharSequence charSequence) {
    }

    private final void d(int i9, int i10, int i11, CharSequence charSequence) {
    }
}
