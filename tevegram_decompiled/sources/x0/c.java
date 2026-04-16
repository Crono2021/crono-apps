package x0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.l;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends androidx.emoji2.text.i {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f10026a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f10027b;

    public c(TextView textView, d dVar) {
        this.f10026a = new WeakReference(textView);
        this.f10027b = new WeakReference(dVar);
    }

    @Override // androidx.emoji2.text.i
    public final void b() {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.f10026a.get();
        InputFilter inputFilter = (InputFilter) this.f10027b.get();
        if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
            return;
        }
        for (InputFilter inputFilter2 : filters) {
            if (inputFilter2 == inputFilter) {
                if (textView.isAttachedToWindow()) {
                    CharSequence text = textView.getText();
                    l a9 = l.a();
                    if (text == null) {
                        length = 0;
                    } else {
                        a9.getClass();
                        length = text.length();
                    }
                    CharSequence e9 = a9.e(text, 0, length);
                    if (text == e9) {
                        return;
                    }
                    int selectionStart = Selection.getSelectionStart(e9);
                    int selectionEnd = Selection.getSelectionEnd(e9);
                    textView.setText(e9);
                    if (e9 instanceof Spannable) {
                        Spannable spannable = (Spannable) e9;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                            return;
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                            return;
                        } else {
                            if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }
}
