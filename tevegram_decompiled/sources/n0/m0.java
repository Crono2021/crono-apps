package n0;

import android.view.View;
import android.view.autofill.AutofillId;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class m0 {
    public static void a(View view, r0 r0Var) {
        s.h hVar = (s.h) view.getTag(2131362430);
        if (hVar == null) {
            hVar = new s.h();
            view.setTag(2131362430, hVar);
        }
        Objects.requireNonNull(r0Var);
        View.OnUnhandledKeyEventListener l0Var = new l0();
        hVar.put(r0Var, l0Var);
        view.addOnUnhandledKeyEventListener(l0Var);
    }

    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void e(View view, r0 r0Var) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        s.h hVar = (s.h) view.getTag(2131362430);
        if (hVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) hVar.getOrDefault(r0Var, null)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    public static <T> T f(View view, int i9) {
        return (T) view.requireViewById(i9);
    }

    public static void g(View view, boolean z8) {
        view.setAccessibilityHeading(z8);
    }

    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void i(View view, AutofillId autofillId) {
        view.setAutofillId(autofillId);
    }

    public static void j(View view, boolean z8) {
        view.setScreenReaderFocusable(z8);
    }
}
