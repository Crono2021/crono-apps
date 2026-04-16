package x5;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import n.e1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v extends n0.c {

    /* renamed from: d, reason: collision with root package name */
    public final TextInputLayout f10214d;

    public v(TextInputLayout textInputLayout) {
        this.f10214d = textInputLayout;
    }

    @Override // n0.c
    public final void d(View view, o0.l lVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = lVar.f7564a;
        this.f7144a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.f10214d;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean isEmpty = TextUtils.isEmpty(text);
        boolean isEmpty2 = TextUtils.isEmpty(hint);
        boolean z8 = textInputLayout.B0;
        boolean isEmpty3 = TextUtils.isEmpty(error);
        boolean z9 = (isEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String charSequence = !isEmpty2 ? hint.toString() : "";
        t tVar = textInputLayout.f2140j;
        e1 e1Var = tVar.f10203j;
        if (e1Var.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(e1Var);
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(e1Var);
            }
        } else {
            CheckableImageButton checkableImageButton = tVar.f10205l;
            if (Build.VERSION.SDK_INT >= 22) {
                accessibilityNodeInfo.setTraversalAfter(checkableImageButton);
            }
        }
        if (!isEmpty) {
            lVar.k(text);
        } else if (!TextUtils.isEmpty(charSequence)) {
            lVar.k(charSequence);
            if (!z8 && placeholderText != null) {
                lVar.k(charSequence + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            lVar.k(placeholderText);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 26) {
                lVar.j(charSequence);
            } else {
                if (!isEmpty) {
                    charSequence = ((Object) text) + ", " + charSequence;
                }
                lVar.k(charSequence);
            }
            if (i9 >= 26) {
                accessibilityNodeInfo.setShowingHintText(isEmpty);
            } else {
                lVar.h(4, isEmpty);
            }
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z9) {
            if (isEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        e1 e1Var2 = textInputLayout.f2156r.f10186y;
        if (e1Var2 != null) {
            accessibilityNodeInfo.setLabelFor(e1Var2);
        }
        textInputLayout.f2142k.b().m(lVar);
    }

    @Override // n0.c
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        this.f10214d.f2142k.b().n(accessibilityEvent);
    }
}
