package x5;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f10134a;

    public k(l lVar) {
        this.f10134a = lVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        l lVar = this.f10134a;
        j jVar = lVar.D;
        if (lVar.A == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = lVar.A;
        if (editText != null) {
            editText.removeTextChangedListener(jVar);
            if (lVar.A.getOnFocusChangeListener() == lVar.b().e()) {
                lVar.A.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        lVar.A = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(jVar);
        }
        lVar.b().l(lVar.A);
        lVar.j(lVar.b());
    }
}
