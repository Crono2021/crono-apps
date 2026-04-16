package n0;

import android.os.Build;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class x1 {

    /* renamed from: b, reason: collision with root package name */
    public static final a2 f7234b;

    /* renamed from: a, reason: collision with root package name */
    public final a2 f7235a;

    static {
        int i9 = Build.VERSION.SDK_INT;
        f7234b = (i9 >= 30 ? new q1() : i9 >= 29 ? new p1() : new o1()).b().f7139a.a().f7139a.b().f7139a.c();
    }

    public x1(a2 a2Var) {
        this.f7235a = a2Var;
    }

    public a2 a() {
        return this.f7235a;
    }

    public a2 b() {
        return this.f7235a;
    }

    public a2 c() {
        return this.f7235a;
    }

    public i e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x1)) {
            return false;
        }
        x1 x1Var = (x1) obj;
        return n() == x1Var.n() && m() == x1Var.m() && m0.a.a(j(), x1Var.j()) && m0.a.a(h(), x1Var.h()) && m0.a.a(e(), x1Var.e());
    }

    public f0.c f(int i9) {
        return f0.c.f3192e;
    }

    public f0.c g() {
        return j();
    }

    public f0.c h() {
        return f0.c.f3192e;
    }

    public int hashCode() {
        return m0.a.b(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public f0.c i() {
        return j();
    }

    public f0.c j() {
        return f0.c.f3192e;
    }

    public f0.c k() {
        return j();
    }

    public a2 l(int i9, int i10, int i11, int i12) {
        return f7234b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public void d(View view) {
    }

    public void o(f0.c[] cVarArr) {
    }

    public void p(a2 a2Var) {
    }

    public void q(f0.c cVar) {
    }
}
