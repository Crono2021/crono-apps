package a5;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import n0.c0;
import n0.i1;
import n0.m1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f179i = 1;

    /* renamed from: j, reason: collision with root package name */
    public Object f180j;

    /* renamed from: k, reason: collision with root package name */
    public Object f181k;

    /* renamed from: l, reason: collision with root package name */
    public Object f182l;

    public g(h hVar, CoordinatorLayout coordinatorLayout, View view) {
        this.f182l = hVar;
        this.f180j = coordinatorLayout;
        this.f181k = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OverScroller overScroller;
        switch (this.f179i) {
            case 0:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f180j;
                h hVar = (h) this.f182l;
                View view = (View) this.f181k;
                if (view != null && (overScroller = hVar.f184d) != null) {
                    if (!overScroller.computeScrollOffset()) {
                        AppBarLayout appBarLayout = (AppBarLayout) view;
                        ((AppBarLayout.BaseBehavior) hVar).B(coordinatorLayout, appBarLayout);
                        if (appBarLayout.f1871s) {
                            appBarLayout.e(appBarLayout.f(AppBarLayout.BaseBehavior.y(coordinatorLayout)));
                            break;
                        }
                    } else {
                        hVar.w(coordinatorLayout, view, hVar.f184d.getCurrY());
                        c0.m(view, this);
                        break;
                    }
                }
                break;
            case 1:
                try {
                    obj = ((k0.c) this.f180j).call();
                } catch (Exception unused) {
                    obj = null;
                }
                ((Handler) this.f182l).post(new androidx.fragment.app.d((k0.d) this.f181k, 10, obj));
                break;
            default:
                i1.h((View) this.f181k, (m1.b) this.f180j);
                ((ValueAnimator) this.f182l).start();
                break;
        }
    }

    public /* synthetic */ g() {
    }

    public g(View view, m1 m1Var, m1.b bVar, ValueAnimator valueAnimator) {
        this.f181k = view;
        this.f180j = bVar;
        this.f182l = valueAnimator;
    }
}
