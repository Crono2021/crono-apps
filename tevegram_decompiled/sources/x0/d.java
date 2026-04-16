package x0;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f10028a;

    /* renamed from: b, reason: collision with root package name */
    public c f10029b;

    public d(TextView textView) {
        this.f10028a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i9, int i10, Spanned spanned, int i11, int i12) {
        TextView textView = this.f10028a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int b9 = l.a().b();
        if (b9 != 0) {
            if (b9 == 1) {
                if ((i12 == 0 && i11 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i9 != 0 || i10 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i9, i10);
                }
                return l.a().e(charSequence, 0, charSequence.length());
            }
            if (b9 != 3) {
                return charSequence;
            }
        }
        l a9 = l.a();
        if (this.f10029b == null) {
            this.f10029b = new c(textView, this);
        }
        a9.f(this.f10029b);
        return charSequence;
    }
}
