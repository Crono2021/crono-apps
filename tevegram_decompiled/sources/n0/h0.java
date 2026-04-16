package n0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public a2 f7159a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f7160b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f7161c;

    public h0(View view, r rVar) {
        this.f7160b = view;
        this.f7161c = rVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        a2 g9 = a2.g(view, windowInsets);
        int i9 = Build.VERSION.SDK_INT;
        r rVar = this.f7161c;
        if (i9 < 30) {
            i0.a(windowInsets, this.f7160b);
            if (g9.equals(this.f7159a)) {
                return rVar.c(view, g9).f();
            }
        }
        this.f7159a = g9;
        a2 c9 = rVar.c(view, g9);
        if (i9 >= 30) {
            return c9.f();
        }
        WeakHashMap weakHashMap = t0.f7209a;
        g0.c(view);
        return c9.f();
    }
}
