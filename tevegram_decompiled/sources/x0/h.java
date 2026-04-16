package x0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.l;
import n.l3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h implements TextWatcher {

    /* renamed from: i, reason: collision with root package name */
    public final EditText f10035i;

    /* renamed from: j, reason: collision with root package name */
    public l3 f10036j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10037k = true;

    public h(EditText editText) {
        this.f10035i = editText;
    }

    public static void a(EditText editText, int i9) {
        int length;
        if (i9 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            l a9 = l.a();
            if (editableText == null) {
                length = 0;
            } else {
                a9.getClass();
                length = editableText.length();
            }
            a9.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        EditText editText = this.f10035i;
        if (editText.isInEditMode() || !this.f10037k || l.f624j == null || i10 > i11 || !(charSequence instanceof Spannable)) {
            return;
        }
        int b9 = l.a().b();
        if (b9 != 0) {
            if (b9 == 1) {
                l.a().e((Spannable) charSequence, i9, i11 + i9);
                return;
            } else if (b9 != 3) {
                return;
            }
        }
        l a9 = l.a();
        if (this.f10036j == null) {
            this.f10036j = new l3(editText);
        }
        a9.f(this.f10036j);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
    }
}
