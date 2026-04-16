package d1;

import android.util.Pair;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class y0 {

    /* renamed from: a, reason: collision with root package name */
    public static final v0 f2610a = new v0();

    static {
        g1.w.H(0);
        g1.w.H(1);
        g1.w.H(2);
    }

    public int a(boolean z8) {
        return p() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z8) {
        if (p()) {
            return -1;
        }
        return o() - 1;
    }

    public final int d(int i9, w0 w0Var, x0 x0Var, int i10, boolean z8) {
        int i11 = f(i9, w0Var, false).f2586c;
        if (m(i11, x0Var, 0L).f2608p != i9) {
            return i9 + 1;
        }
        int e9 = e(i11, i10, z8);
        if (e9 == -1) {
            return -1;
        }
        return m(e9, x0Var, 0L).f2607o;
    }

    public int e(int i9, int i10, boolean z8) {
        if (i10 == 0) {
            if (i9 == c(z8)) {
                return -1;
            }
            return i9 + 1;
        }
        if (i10 == 1) {
            return i9;
        }
        if (i10 == 2) {
            return i9 == c(z8) ? a(z8) : i9 + 1;
        }
        androidx.fragment.app.a.l();
        return 0;
    }

    public final boolean equals(Object obj) {
        int c9;
        if (this != obj) {
            if (obj instanceof y0) {
                y0 y0Var = (y0) obj;
                if (y0Var.o() == o() && y0Var.h() == h()) {
                    x0 x0Var = new x0();
                    w0 w0Var = new w0();
                    x0 x0Var2 = new x0();
                    w0 w0Var2 = new w0();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= o()) {
                            int i10 = 0;
                            while (true) {
                                if (i10 >= h()) {
                                    int a9 = a(true);
                                    if (a9 == y0Var.a(true) && (c9 = c(true)) == y0Var.c(true)) {
                                        while (a9 != c9) {
                                            int e9 = e(a9, 0, true);
                                            if (e9 == y0Var.e(a9, 0, true)) {
                                                a9 = e9;
                                            }
                                        }
                                    }
                                } else {
                                    if (!f(i10, w0Var, true).equals(y0Var.f(i10, w0Var2, true))) {
                                        break;
                                    }
                                    i10++;
                                }
                            }
                        } else {
                            if (!m(i9, x0Var, 0L).equals(y0Var.m(i9, x0Var2, 0L))) {
                                break;
                            }
                            i9++;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public abstract w0 f(int i9, w0 w0Var, boolean z8);

    public w0 g(Object obj, w0 w0Var) {
        return f(b(obj), w0Var, true);
    }

    public abstract int h();

    public final int hashCode() {
        x0 x0Var = new x0();
        w0 w0Var = new w0();
        int o8 = o() + 217;
        for (int i9 = 0; i9 < o(); i9++) {
            o8 = (o8 * 31) + m(i9, x0Var, 0L).hashCode();
        }
        int h = h() + (o8 * 31);
        for (int i10 = 0; i10 < h(); i10++) {
            h = (h * 31) + f(i10, w0Var, true).hashCode();
        }
        int a9 = a(true);
        while (a9 != -1) {
            h = (h * 31) + a9;
            a9 = e(a9, 0, true);
        }
        return h;
    }

    public final Pair i(x0 x0Var, w0 w0Var, int i9, long j5) {
        Pair j9 = j(x0Var, w0Var, i9, j5, 0L);
        j9.getClass();
        return j9;
    }

    public final Pair j(x0 x0Var, w0 w0Var, int i9, long j5, long j9) {
        g1.a.i(i9, o());
        m(i9, x0Var, j9);
        if (j5 == -9223372036854775807L) {
            j5 = x0Var.f2605m;
            if (j5 == -9223372036854775807L) {
                return null;
            }
        }
        int i10 = x0Var.f2607o;
        f(i10, w0Var, false);
        while (i10 < x0Var.f2608p && w0Var.f2588e != j5) {
            int i11 = i10 + 1;
            if (f(i11, w0Var, false).f2588e > j5) {
                break;
            }
            i10 = i11;
        }
        f(i10, w0Var, true);
        long j10 = j5 - w0Var.f2588e;
        long j11 = w0Var.f2587d;
        if (j11 != -9223372036854775807L) {
            j10 = Math.min(j10, j11 - 1);
        }
        long max = Math.max(0L, j10);
        Object obj = w0Var.f2585b;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(max));
    }

    public int k(int i9, int i10, boolean z8) {
        if (i10 == 0) {
            if (i9 == a(z8)) {
                return -1;
            }
            return i9 - 1;
        }
        if (i10 == 1) {
            return i9;
        }
        if (i10 == 2) {
            return i9 == a(z8) ? c(z8) : i9 - 1;
        }
        androidx.fragment.app.a.l();
        return 0;
    }

    public abstract Object l(int i9);

    public abstract x0 m(int i9, x0 x0Var, long j5);

    public final void n(int i9, x0 x0Var) {
        m(i9, x0Var, 0L);
    }

    public abstract int o();

    public final boolean p() {
        return o() == 0;
    }
}
