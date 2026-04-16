package y1;

import android.os.SystemClock;
import b6.d0;
import b6.g0;
import d1.z0;
import g1.w;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends c {

    /* renamed from: g, reason: collision with root package name */
    public final z1.f f10392g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final long f10393i;

    /* renamed from: j, reason: collision with root package name */
    public final long f10394j;

    /* renamed from: k, reason: collision with root package name */
    public final int f10395k;

    /* renamed from: l, reason: collision with root package name */
    public final int f10396l;

    /* renamed from: m, reason: collision with root package name */
    public final float f10397m;

    /* renamed from: n, reason: collision with root package name */
    public final float f10398n;

    /* renamed from: o, reason: collision with root package name */
    public final g0 f10399o;

    /* renamed from: p, reason: collision with root package name */
    public final g1.r f10400p;

    /* renamed from: q, reason: collision with root package name */
    public float f10401q;

    /* renamed from: r, reason: collision with root package name */
    public int f10402r;

    /* renamed from: s, reason: collision with root package name */
    public int f10403s;

    /* renamed from: t, reason: collision with root package name */
    public long f10404t;

    /* renamed from: u, reason: collision with root package name */
    public p1.k f10405u;

    public b(z0 z0Var, int[] iArr, z1.f fVar, long j5, long j9, long j10, g0 g0Var) {
        super(z0Var, iArr);
        if (j10 < j5) {
            g1.a.D("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j10 = j5;
        }
        this.f10392g = fVar;
        this.h = j5 * 1000;
        this.f10393i = j9 * 1000;
        this.f10394j = j10 * 1000;
        this.f10395k = 1279;
        this.f10396l = 719;
        this.f10397m = 0.7f;
        this.f10398n = 0.75f;
        this.f10399o = g0.m(g0Var);
        this.f10400p = g1.r.f3705a;
        this.f10401q = 1.0f;
        this.f10403s = 0;
        this.f10404t = -9223372036854775807L;
    }

    public static void u(ArrayList arrayList, long[] jArr) {
        long j5 = 0;
        for (long j9 : jArr) {
            j5 += j9;
        }
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            d0 d0Var = (d0) arrayList.get(i9);
            if (d0Var != null) {
                d0Var.a(new a(j5, jArr[i9]));
            }
        }
    }

    public static long w(List list) {
        if (!list.isEmpty()) {
            p1.k kVar = (p1.k) b6.q.g(list);
            long j5 = kVar.f9708g;
            if (j5 != -9223372036854775807L) {
                long j9 = kVar.h;
                if (j9 != -9223372036854775807L) {
                    return j9 - j5;
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // y1.c, y1.q
    public final void d() {
        this.f10404t = -9223372036854775807L;
        this.f10405u = null;
    }

    @Override // y1.c, y1.q
    public final int f(long j5, List list) {
        int i9;
        int i10;
        this.f10400p.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j9 = this.f10404t;
        if (j9 != -9223372036854775807L && elapsedRealtime - j9 < 1000 && (list.isEmpty() || ((p1.k) b6.q.g(list)).equals(this.f10405u))) {
            return list.size();
        }
        this.f10404t = elapsedRealtime;
        this.f10405u = list.isEmpty() ? null : (p1.k) b6.q.g(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long A = w.A(((p1.k) list.get(size - 1)).f9708g - j5, this.f10401q);
        long j10 = this.f10394j;
        if (A >= j10) {
            w(list);
            d1.s sVar = this.f10409d[v(elapsedRealtime)];
            for (int i11 = 0; i11 < size; i11++) {
                p1.k kVar = (p1.k) list.get(i11);
                d1.s sVar2 = kVar.f9705d;
                if (w.A(kVar.f9708g - j5, this.f10401q) >= j10 && sVar2.f2550i < sVar.f2550i && (i9 = sVar2.f2560s) != -1 && i9 <= this.f10396l && (i10 = sVar2.f2559r) != -1 && i10 <= this.f10395k && i9 < sVar.f2560s) {
                    return i11;
                }
            }
        }
        return size;
    }

    @Override // y1.q
    public final void g(long j5, long j9, long j10, List list, w1.b[] bVarArr) {
        long w8;
        this.f10400p.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i9 = this.f10402r;
        int i10 = 0;
        if (i9 >= bVarArr.length || !bVarArr[i9].next()) {
            int length = bVarArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    w8 = w(list);
                    break;
                }
                w1.b bVar = bVarArr[i11];
                if (bVar.next()) {
                    w8 = bVar.a() - bVar.k();
                    break;
                }
                i11++;
            }
        } else {
            w1.b bVar2 = bVarArr[this.f10402r];
            w8 = bVar2.a() - bVar2.k();
        }
        int i12 = this.f10403s;
        if (i12 == 0) {
            this.f10403s = 1;
            this.f10402r = v(elapsedRealtime);
            return;
        }
        int i13 = this.f10402r;
        boolean isEmpty = list.isEmpty();
        d1.s[] sVarArr = this.f10409d;
        if (!isEmpty) {
            d1.s sVar = ((p1.k) b6.q.g(list)).f9705d;
            while (i10 < this.f10407b) {
                if (sVarArr[i10] == sVar) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        i10 = -1;
        if (i10 != -1) {
            i12 = ((p1.k) b6.q.g(list)).f9706e;
            i13 = i10;
        }
        int v8 = v(elapsedRealtime);
        if (v8 != i13 && !b(i13, elapsedRealtime)) {
            d1.s sVar2 = sVarArr[i13];
            d1.s sVar3 = sVarArr[v8];
            long j11 = this.h;
            if (j10 != -9223372036854775807L) {
                j11 = Math.min((long) ((w8 != -9223372036854775807L ? j10 - w8 : j10) * this.f10398n), j11);
            }
            int i14 = sVar3.f2550i;
            int i15 = sVar2.f2550i;
            if ((i14 > i15 && j9 < j11) || (i14 < i15 && j9 >= this.f10393i)) {
                v8 = i13;
            }
        }
        if (v8 != i13) {
            i12 = 3;
        }
        this.f10403s = i12;
        this.f10402r = v8;
    }

    @Override // y1.c, y1.q
    public final void h() {
        this.f10405u = null;
    }

    @Override // y1.q
    public final int l() {
        return this.f10403s;
    }

    @Override // y1.q
    public final int m() {
        return this.f10402r;
    }

    @Override // y1.c, y1.q
    public final void o(float f9) {
        this.f10401q = f9;
    }

    @Override // y1.q
    public final Object p() {
        return null;
    }

    public final int v(long j5) {
        long j9;
        z1.f fVar = this.f10392g;
        synchronized (fVar) {
            j9 = fVar.f10565k;
        }
        long j10 = (long) (j9 * this.f10397m);
        this.f10392g.getClass();
        long j11 = (long) (j10 / this.f10401q);
        if (!this.f10399o.isEmpty()) {
            int i9 = 1;
            while (i9 < this.f10399o.size() - 1 && ((a) this.f10399o.get(i9)).f10390a < j11) {
                i9++;
            }
            a aVar = (a) this.f10399o.get(i9 - 1);
            a aVar2 = (a) this.f10399o.get(i9);
            long j12 = aVar.f10390a;
            long j13 = aVar.f10391b;
            j11 = j13 + ((long) (((j11 - j12) / (aVar2.f10390a - j12)) * (aVar2.f10391b - j13)));
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f10407b; i11++) {
            if (j5 == Long.MIN_VALUE || !b(i11, j5)) {
                if (this.f10409d[i11].f2550i <= j11) {
                    return i11;
                }
                i10 = i11;
            }
        }
        return i10;
    }
}
