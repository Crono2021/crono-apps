package n0;

import android.view.View;
import android.view.autofill.AutofillId;
import java.util.Collection;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class k0 {
    public static void a(View view, Collection<View> collection, int i9) {
        view.addKeyboardNavigationClusters(collection, i9);
    }

    public static AutofillId b(View view) {
        return view.getAutofillId();
    }

    public static int c(View view) {
        return view.getImportantForAutofill();
    }

    public static int d(View view) {
        return view.getNextClusterForwardId();
    }

    public static boolean e(View view) {
        return view.hasExplicitFocusable();
    }

    public static boolean f(View view) {
        return view.isFocusedByDefault();
    }

    public static boolean g(View view) {
        return view.isImportantForAutofill();
    }

    public static boolean h(View view) {
        return view.isKeyboardNavigationCluster();
    }

    public static View i(View view, View view2, int i9) {
        return view.keyboardNavigationClusterSearch(view2, i9);
    }

    public static boolean j(View view) {
        return view.restoreDefaultFocus();
    }

    public static void k(View view, String... strArr) {
        view.setAutofillHints(strArr);
    }

    public static void l(View view, boolean z8) {
        view.setFocusedByDefault(z8);
    }

    public static void m(View view, int i9) {
        view.setImportantForAutofill(i9);
    }

    public static void n(View view, boolean z8) {
        view.setKeyboardNavigationCluster(z8);
    }

    public static void o(View view, int i9) {
        view.setNextClusterForwardId(i9);
    }

    public static void p(View view, CharSequence charSequence) {
        view.setTooltipText(charSequence);
    }
}
