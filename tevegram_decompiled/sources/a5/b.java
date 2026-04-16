package a5;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import g.p0;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f170a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f171b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f172c;

    public /* synthetic */ b(Object obj, int i9, Object obj2) {
        this.f170a = i9;
        this.f171b = obj;
        this.f172c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i9 = this.f170a;
        Object obj = this.f172c;
        Object obj2 = this.f171b;
        switch (i9) {
            case 0:
                AppBarLayout appBarLayout = (AppBarLayout) obj2;
                int i10 = AppBarLayout.F;
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ((u5.g) obj).k(floatValue);
                Drawable drawable = appBarLayout.C;
                if (drawable instanceof u5.g) {
                    ((u5.g) drawable).k(floatValue);
                }
                Iterator it = appBarLayout.f1877y.iterator();
                if (it.hasNext()) {
                    throw androidx.activity.g.l(it);
                }
                return;
            case 1:
                u5.g gVar = (u5.g) obj;
                int i11 = AppBarLayout.F;
                int floatValue2 = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                gVar.setAlpha(floatValue2);
                ArrayList arrayList = ((AppBarLayout) obj2).f1877y;
                int size = arrayList.size();
                int i12 = 0;
                while (i12 < size) {
                    Object obj3 = arrayList.get(i12);
                    i12++;
                    if (obj3 != null) {
                        androidx.fragment.app.a.c();
                        return;
                    }
                    ColorStateList colorStateList = gVar.f9084i.f9071c;
                    if (colorStateList != null) {
                        colorStateList.withAlpha(floatValue2).getDefaultColor();
                        throw null;
                    }
                }
                return;
            default:
                ((View) ((p0) ((a0.b) obj2).f8j).f3599d.getParent()).invalidate();
                return;
        }
    }
}
