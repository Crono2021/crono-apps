package y1;

import android.os.SystemClock;
import d1.z0;
import g1.w;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c implements q {

    /* renamed from: a, reason: collision with root package name */
    public final z0 f10406a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10407b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f10408c;

    /* renamed from: d, reason: collision with root package name */
    public final d1.s[] f10409d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f10410e;

    /* renamed from: f, reason: collision with root package name */
    public int f10411f;

    public c(z0 z0Var, int[] iArr) {
        d1.s[] sVarArr;
        int i9 = 0;
        g1.a.k(iArr.length > 0);
        z0Var.getClass();
        this.f10406a = z0Var;
        int length = iArr.length;
        this.f10407b = length;
        this.f10409d = new d1.s[length];
        int i10 = 0;
        while (true) {
            int length2 = iArr.length;
            sVarArr = this.f10409d;
            if (i10 >= length2) {
                break;
            }
            sVarArr[i10] = z0Var.f2619d[iArr[i10]];
            i10++;
        }
        Arrays.sort(sVarArr, new a3.d(6));
        this.f10408c = new int[this.f10407b];
        while (true) {
            int i11 = this.f10407b;
            if (i9 >= i11) {
                this.f10410e = new long[i11];
                return;
            } else {
                this.f10408c[i9] = z0Var.a(this.f10409d[i9]);
                i9++;
            }
        }
    }

    @Override // y1.q
    public final boolean b(int i9, long j5) {
        return this.f10410e[i9] > j5;
    }

    @Override // y1.q
    public final d1.s c(int i9) {
        return this.f10409d[i9];
    }

    @Override // y1.q
    public final int e(int i9) {
        return this.f10408c[i9];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f10406a.equals(cVar.f10406a) && Arrays.equals(this.f10408c, cVar.f10408c)) {
                return true;
            }
        }
        return false;
    }

    @Override // y1.q
    public int f(long j5, List list) {
        return list.size();
    }

    public final int hashCode() {
        if (this.f10411f == 0) {
            this.f10411f = Arrays.hashCode(this.f10408c) + (System.identityHashCode(this.f10406a) * 31);
        }
        return this.f10411f;
    }

    @Override // y1.q
    public final int i() {
        return this.f10408c[m()];
    }

    @Override // y1.q
    public final z0 j() {
        return this.f10406a;
    }

    @Override // y1.q
    public final d1.s k() {
        return this.f10409d[m()];
    }

    @Override // y1.q
    public final int length() {
        return this.f10408c.length;
    }

    @Override // y1.q
    public final boolean n(int i9, long j5) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b9 = b(i9, elapsedRealtime);
        int i10 = 0;
        while (i10 < this.f10407b && !b9) {
            b9 = (i10 == i9 || b(i10, elapsedRealtime)) ? false : true;
            i10++;
        }
        if (!b9) {
            return false;
        }
        long[] jArr = this.f10410e;
        long j9 = jArr[i9];
        int i11 = w.f3713a;
        long j10 = elapsedRealtime + j5;
        if (((j5 ^ j10) & (elapsedRealtime ^ j10)) < 0) {
            j10 = Long.MAX_VALUE;
        }
        jArr[i9] = Math.max(j9, j10);
        return true;
    }

    @Override // y1.q
    public final /* synthetic */ boolean r(long j5, w1.a aVar, List list) {
        return false;
    }

    @Override // y1.q
    public final int t(int i9) {
        for (int i10 = 0; i10 < this.f10407b; i10++) {
            if (this.f10408c[i10] == i9) {
                return i10;
            }
        }
        return -1;
    }

    @Override // y1.q
    public void d() {
    }

    @Override // y1.q
    public void h() {
    }

    @Override // y1.q
    public final /* synthetic */ void q() {
    }

    @Override // y1.q
    public final /* synthetic */ void s() {
    }

    @Override // y1.q
    public final /* synthetic */ void a(boolean z8) {
    }

    @Override // y1.q
    public void o(float f9) {
    }
}
