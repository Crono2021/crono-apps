package f4;

import d4.a0;
import d4.n;
import w4.j;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public n f3380d;

    @Override // w4.j
    public final int b(Object obj) {
        a0 a0Var = (a0) obj;
        if (a0Var == null) {
            return 1;
        }
        return a0Var.getSize();
    }

    @Override // w4.j
    public final void c(Object obj, Object obj2) {
        a0 a0Var = (a0) obj2;
        n nVar = this.f3380d;
        if (nVar == null || a0Var == null) {
            return;
        }
        nVar.f2887e.e(a0Var, true);
    }

    public final void f(int i9) {
        long j5;
        if (i9 >= 40) {
            e(0L);
        } else if (i9 >= 20 || i9 == 15) {
            synchronized (this) {
                j5 = this.f9944b;
            }
            e(j5 / 2);
        }
    }
}
