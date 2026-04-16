package n0;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i1 extends l1 {

    /* renamed from: e, reason: collision with root package name */
    public static final PathInterpolator f7165e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

    /* renamed from: f, reason: collision with root package name */
    public static final a1.a f7166f = new a1.a(0);

    /* renamed from: g, reason: collision with root package name */
    public static final DecelerateInterpolator f7167g = new DecelerateInterpolator();

    public static void e(View view) {
        e j5 = j(view);
        if (j5 != null) {
            ((View) j5.f7151m).setTranslationY(0.0f);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                e(viewGroup.getChildAt(i9));
            }
        }
    }

    public static void f(View view, WindowInsets windowInsets, boolean z8) {
        e j5 = j(view);
        if (j5 != null) {
            j5.f7148j = windowInsets;
            if (!z8) {
                View view2 = (View) j5.f7151m;
                int[] iArr = (int[]) j5.f7152n;
                view2.getLocationOnScreen(iArr);
                z8 = true;
                j5.f7149k = iArr[1];
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                f(viewGroup.getChildAt(i9), windowInsets, z8);
            }
        }
    }

    public static void g(View view, a2 a2Var, List list) {
        e j5 = j(view);
        if (j5 != null) {
            j5.a(a2Var, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                g(viewGroup.getChildAt(i9), a2Var, list);
            }
        }
    }

    public static void h(View view, m1.b bVar) {
        e j5 = j(view);
        if (j5 != null) {
            View view2 = (View) j5.f7151m;
            int[] iArr = (int[]) j5.f7152n;
            view2.getLocationOnScreen(iArr);
            int i9 = j5.f7149k - iArr[1];
            j5.f7150l = i9;
            view2.setTranslationY(i9);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                h(viewGroup.getChildAt(i10), bVar);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(2131362423) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static e j(View view) {
        Object tag = view.getTag(2131362431);
        if (tag instanceof h1) {
            return ((h1) tag).f7162a;
        }
        return null;
    }
}
