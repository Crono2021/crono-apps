package d1;

import android.net.Uri;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f2361a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2362b;

    /* renamed from: c, reason: collision with root package name */
    public final List f2363c;

    /* renamed from: d, reason: collision with root package name */
    public final b6.g0 f2364d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2365e;

    static {
        androidx.activity.g.s(0, 1, 2, 3, 4);
        g1.w.H(5);
        g1.w.H(6);
        g1.w.H(7);
    }

    public b0(Uri uri, String str, com.bumptech.glide.d dVar, List list, b6.g0 g0Var, long j5) {
        this.f2361a = uri;
        this.f2362b = l0.k(str);
        this.f2363c = list;
        this.f2364d = g0Var;
        b6.e0 e0Var = b6.g0.f1391j;
        b6.q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i9 = 0;
        int i10 = 0;
        while (i9 < g0Var.size()) {
            ((d0) g0Var.get(i9)).getClass();
            d0 d0Var = new d0();
            int i11 = i10 + 1;
            if (objArr.length < i11) {
                objArr = Arrays.copyOf(objArr, b6.a0.d(objArr.length, i11));
            }
            objArr[i10] = d0Var;
            i9++;
            i10++;
        }
        b6.g0.l(i10, objArr);
        this.f2365e = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f2361a.equals(b0Var.f2361a) && g1.w.a(this.f2362b, b0Var.f2362b) && g1.w.a(null, null) && this.f2363c.equals(b0Var.f2363c) && this.f2364d.equals(b0Var.f2364d) && Long.valueOf(this.f2365e).equals(Long.valueOf(b0Var.f2365e));
    }

    public final int hashCode() {
        int hashCode = this.f2361a.hashCode() * 31;
        return (int) (((this.f2364d.hashCode() + ((this.f2363c.hashCode() + ((hashCode + (this.f2362b == null ? 0 : r1.hashCode())) * 29791)) * 961)) * 31 * 31) + this.f2365e);
    }
}
