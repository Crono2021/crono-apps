package androidx.emoji2.text;

import android.graphics.Rect;
import android.view.View;
import o3.o0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public int f617a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f618b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f619c;

    public h(o0 o0Var) {
        this.f617a = Integer.MIN_VALUE;
        this.f619c = new Rect();
        this.f618b = o0Var;
    }

    public static h a(o0 o0Var, int i9) {
        if (i9 == 0) {
            return new o3.a0(o0Var, 0);
        }
        if (i9 == 1) {
            return new o3.a0(o0Var, 1);
        }
        m7.c.n("invalid orientation");
        return null;
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m(View view);

    public abstract int n(View view);

    public abstract void o(int i9);

    public h(k kVar) {
        this.f617a = 0;
        this.f619c = new e();
        this.f618b = kVar;
    }
}
