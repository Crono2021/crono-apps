package n0;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j1 extends WindowInsetsAnimation.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final e f7168a;

    /* renamed from: b, reason: collision with root package name */
    public List f7169b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f7170c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f7171d;

    public j1(e eVar) {
        super(0);
        this.f7171d = new HashMap();
        this.f7168a = eVar;
    }

    public final m1 a(WindowInsetsAnimation windowInsetsAnimation) {
        m1 m1Var = (m1) this.f7171d.get(windowInsetsAnimation);
        if (m1Var == null) {
            m1Var = new m1(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                m1Var.f7177a = new k1(windowInsetsAnimation);
            }
            this.f7171d.put(windowInsetsAnimation, m1Var);
        }
        return m1Var;
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        e eVar = this.f7168a;
        a(windowInsetsAnimation);
        ((View) eVar.f7151m).setTranslationY(0.0f);
        this.f7171d.remove(windowInsetsAnimation);
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        e eVar = this.f7168a;
        a(windowInsetsAnimation);
        View view = (View) eVar.f7151m;
        int[] iArr = (int[]) eVar.f7152n;
        view.getLocationOnScreen(iArr);
        eVar.f7149k = iArr[1];
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        float fraction;
        ArrayList arrayList = this.f7170c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f7170c = arrayList2;
            this.f7169b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation l4 = b2.x.l(list.get(size));
            m1 a9 = a(l4);
            fraction = l4.getFraction();
            a9.f7177a.d(fraction);
            this.f7170c.add(a9);
        }
        e eVar = this.f7168a;
        a2 g9 = a2.g(null, windowInsets);
        eVar.a(g9, this.f7169b);
        return g9.f();
    }

    @Override // android.view.WindowInsetsAnimation.Callback
    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        Insets lowerBound;
        Insets upperBound;
        e eVar = this.f7168a;
        a(windowInsetsAnimation);
        lowerBound = bounds.getLowerBound();
        f0.c c9 = f0.c.c(lowerBound);
        upperBound = bounds.getUpperBound();
        f0.c c10 = f0.c.c(upperBound);
        View view = (View) eVar.f7151m;
        int[] iArr = (int[]) eVar.f7152n;
        view.getLocationOnScreen(iArr);
        int i9 = eVar.f7149k - iArr[1];
        eVar.f7150l = i9;
        view.setTranslationY(i9);
        b2.x.n();
        return b2.x.j(c9.d(), c10.d());
    }
}
