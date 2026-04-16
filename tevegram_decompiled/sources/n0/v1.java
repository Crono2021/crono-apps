package n0;

import android.graphics.Insets;
import android.view.WindowInsets;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class v1 extends u1 {

    /* renamed from: n, reason: collision with root package name */
    public f0.c f7221n;

    /* renamed from: o, reason: collision with root package name */
    public f0.c f7222o;

    /* renamed from: p, reason: collision with root package name */
    public f0.c f7223p;

    public v1(a2 a2Var, WindowInsets windowInsets) {
        super(a2Var, windowInsets);
        this.f7221n = null;
        this.f7222o = null;
        this.f7223p = null;
    }

    @Override // n0.x1
    public f0.c g() {
        Insets mandatorySystemGestureInsets;
        if (this.f7222o == null) {
            mandatorySystemGestureInsets = this.f7204c.getMandatorySystemGestureInsets();
            this.f7222o = f0.c.c(mandatorySystemGestureInsets);
        }
        return this.f7222o;
    }

    @Override // n0.x1
    public f0.c i() {
        Insets systemGestureInsets;
        if (this.f7221n == null) {
            systemGestureInsets = this.f7204c.getSystemGestureInsets();
            this.f7221n = f0.c.c(systemGestureInsets);
        }
        return this.f7221n;
    }

    @Override // n0.x1
    public f0.c k() {
        Insets tappableElementInsets;
        if (this.f7223p == null) {
            tappableElementInsets = this.f7204c.getTappableElementInsets();
            this.f7223p = f0.c.c(tappableElementInsets);
        }
        return this.f7223p;
    }

    @Override // n0.s1, n0.x1
    public a2 l(int i9, int i10, int i11, int i12) {
        WindowInsets inset;
        inset = this.f7204c.inset(i9, i10, i11, i12);
        return a2.g(null, inset);
    }

    @Override // n0.t1, n0.x1
    public void q(f0.c cVar) {
    }
}
