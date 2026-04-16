package d1;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2414a;

    /* renamed from: b, reason: collision with root package name */
    public final z0 f2415b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2416c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f2417d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean[] f2418e;

    static {
        g1.w.H(0);
        g1.w.H(1);
        g1.w.H(3);
        g1.w.H(4);
    }

    public e1(z0 z0Var, boolean z8, int[] iArr, boolean[] zArr) {
        int i9 = z0Var.f2616a;
        this.f2414a = i9;
        boolean z9 = false;
        g1.a.f(i9 == iArr.length && i9 == zArr.length);
        this.f2415b = z0Var;
        if (z8 && i9 > 1) {
            z9 = true;
        }
        this.f2416c = z9;
        this.f2417d = (int[]) iArr.clone();
        this.f2418e = (boolean[]) zArr.clone();
    }

    public final s a(int i9) {
        return this.f2415b.f2619d[i9];
    }

    public final boolean b() {
        for (int i9 = 0; i9 < this.f2417d.length; i9++) {
            if (c(i9)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(int i9) {
        return this.f2417d[i9] == 4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e1.class == obj.getClass()) {
            e1 e1Var = (e1) obj;
            if (this.f2416c == e1Var.f2416c && this.f2415b.equals(e1Var.f2415b) && Arrays.equals(this.f2417d, e1Var.f2417d) && Arrays.equals(this.f2418e, e1Var.f2418e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f2418e) + ((Arrays.hashCode(this.f2417d) + (((this.f2415b.hashCode() * 31) + (this.f2416c ? 1 : 0)) * 31)) * 31);
    }
}
