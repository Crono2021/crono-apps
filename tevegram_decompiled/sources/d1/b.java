package d1;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f2355a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2356b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri[] f2357c;

    /* renamed from: d, reason: collision with root package name */
    public final e0[] f2358d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f2359e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f2360f;

    static {
        androidx.activity.g.s(0, 1, 2, 3, 4);
        g1.w.H(5);
        g1.w.H(6);
        g1.w.H(7);
        g1.w.H(8);
    }

    public b(int i9, int i10, int[] iArr, e0[] e0VarArr, long[] jArr) {
        Uri uri;
        int i11 = 0;
        g1.a.f(iArr.length == e0VarArr.length);
        this.f2355a = i9;
        this.f2356b = i10;
        this.f2359e = iArr;
        this.f2358d = e0VarArr;
        this.f2360f = jArr;
        this.f2357c = new Uri[e0VarArr.length];
        while (true) {
            Uri[] uriArr = this.f2357c;
            if (i11 >= uriArr.length) {
                return;
            }
            e0 e0Var = e0VarArr[i11];
            if (e0Var == null) {
                uri = null;
            } else {
                b0 b0Var = e0Var.f2409b;
                b0Var.getClass();
                uri = b0Var.f2361a;
            }
            uriArr[i11] = uri;
            i11++;
        }
    }

    public final int a(int i9) {
        int i10;
        int i11 = i9 + 1;
        while (true) {
            int[] iArr = this.f2359e;
            if (i11 >= iArr.length || (i10 = iArr[i11]) == 0 || i10 == 1) {
                break;
            }
            i11++;
        }
        return i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2355a == bVar.f2355a && this.f2356b == bVar.f2356b && Arrays.equals(this.f2358d, bVar.f2358d) && Arrays.equals(this.f2359e, bVar.f2359e) && Arrays.equals(this.f2360f, bVar.f2360f);
    }

    public final int hashCode() {
        int i9 = (int) 0;
        return (((Arrays.hashCode(this.f2360f) + ((Arrays.hashCode(this.f2359e) + ((Arrays.hashCode(this.f2358d) + (((((this.f2355a * 31) + this.f2356b) * 31) + i9) * 31)) * 31)) * 31)) * 31) + i9) * 31;
    }
}
