package d1;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2616a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2617b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2618c;

    /* renamed from: d, reason: collision with root package name */
    public final s[] f2619d;

    /* renamed from: e, reason: collision with root package name */
    public int f2620e;

    static {
        g1.w.H(0);
        g1.w.H(1);
    }

    public z0(String str, s... sVarArr) {
        g1.a.f(sVarArr.length > 0);
        this.f2617b = str;
        this.f2619d = sVarArr;
        this.f2616a = sVarArr.length;
        int g9 = l0.g(sVarArr[0].f2554m);
        this.f2618c = g9 == -1 ? l0.g(sVarArr[0].f2553l) : g9;
        String str2 = sVarArr[0].f2546d;
        str2 = (str2 == null || str2.equals("und")) ? "" : str2;
        int i9 = sVarArr[0].f2548f | 16384;
        for (int i10 = 1; i10 < sVarArr.length; i10++) {
            String str3 = sVarArr[i10].f2546d;
            if (!str2.equals((str3 == null || str3.equals("und")) ? "" : str3)) {
                b("languages", sVarArr[0].f2546d, sVarArr[i10].f2546d, i10);
                return;
            } else {
                if (i9 != (sVarArr[i10].f2548f | 16384)) {
                    b("role flags", Integer.toBinaryString(sVarArr[0].f2548f), Integer.toBinaryString(sVarArr[i10].f2548f), i10);
                    return;
                }
            }
        }
    }

    public static void b(String str, String str2, String str3, int i9) {
        g1.a.q("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i9 + ")"));
    }

    public final int a(s sVar) {
        int i9 = 0;
        while (true) {
            s[] sVarArr = this.f2619d;
            if (i9 >= sVarArr.length) {
                return -1;
            }
            if (sVar == sVarArr[i9]) {
                return i9;
            }
            i9++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && z0.class == obj.getClass()) {
            z0 z0Var = (z0) obj;
            if (this.f2617b.equals(z0Var.f2617b) && Arrays.equals(this.f2619d, z0Var.f2619d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f2620e == 0) {
            this.f2620e = Arrays.hashCode(this.f2619d) + androidx.activity.g.k(527, 31, this.f2617b);
        }
        return this.f2620e;
    }
}
