package g;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class x {
    public static OnBackInvokedDispatcher a(Activity activity) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
        return onBackInvokedDispatcher;
    }

    public static OnBackInvokedCallback b(Object obj, c0 c0Var) {
        Objects.requireNonNull(c0Var);
        androidx.activity.r rVar = new androidx.activity.r(c0Var, 1);
        androidx.activity.o.e(obj).registerOnBackInvokedCallback(1000000, rVar);
        return rVar;
    }

    public static void c(Object obj, Object obj2) {
        androidx.activity.o.e(obj).unregisterOnBackInvokedCallback(androidx.activity.o.b(obj2));
    }
}
