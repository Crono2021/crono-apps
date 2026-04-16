package d1;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2568a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2569b;

    /* renamed from: c, reason: collision with root package name */
    public final e0 f2570c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2571d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2572e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2573f;

    /* renamed from: g, reason: collision with root package name */
    public final long f2574g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2575i;

    static {
        androidx.activity.g.s(0, 1, 2, 3, 4);
        g1.w.H(5);
        g1.w.H(6);
    }

    public s0(Object obj, int i9, e0 e0Var, Object obj2, int i10, long j5, long j9, int i11, int i12) {
        this.f2568a = obj;
        this.f2569b = i9;
        this.f2570c = e0Var;
        this.f2571d = obj2;
        this.f2572e = i10;
        this.f2573f = j5;
        this.f2574g = j9;
        this.h = i11;
        this.f2575i = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && s0.class == obj.getClass()) {
            s0 s0Var = (s0) obj;
            if (this.f2569b == s0Var.f2569b && this.f2572e == s0Var.f2572e && this.f2573f == s0Var.f2573f && this.f2574g == s0Var.f2574g && this.h == s0Var.h && this.f2575i == s0Var.f2575i && android.support.v4.media.session.b.G(this.f2570c, s0Var.f2570c) && android.support.v4.media.session.b.G(this.f2568a, s0Var.f2568a) && android.support.v4.media.session.b.G(this.f2571d, s0Var.f2571d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2568a, Integer.valueOf(this.f2569b), this.f2570c, this.f2571d, Integer.valueOf(this.f2572e), Long.valueOf(this.f2573f), Long.valueOf(this.f2574g), Integer.valueOf(this.h), Integer.valueOf(this.f2575i)});
    }
}
