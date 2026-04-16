package d1;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x0 {

    /* renamed from: r, reason: collision with root package name */
    public static final Object f2592r = new Object();

    /* renamed from: s, reason: collision with root package name */
    public static final e0 f2593s;

    /* renamed from: b, reason: collision with root package name */
    public Object f2595b;

    /* renamed from: d, reason: collision with root package name */
    public Object f2597d;

    /* renamed from: e, reason: collision with root package name */
    public long f2598e;

    /* renamed from: f, reason: collision with root package name */
    public long f2599f;

    /* renamed from: g, reason: collision with root package name */
    public long f2600g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2601i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2602j;

    /* renamed from: k, reason: collision with root package name */
    public a0 f2603k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2604l;

    /* renamed from: m, reason: collision with root package name */
    public long f2605m;

    /* renamed from: n, reason: collision with root package name */
    public long f2606n;

    /* renamed from: o, reason: collision with root package name */
    public int f2607o;

    /* renamed from: p, reason: collision with root package name */
    public int f2608p;

    /* renamed from: q, reason: collision with root package name */
    public long f2609q;

    /* renamed from: a, reason: collision with root package name */
    public Object f2594a = f2592r;

    /* renamed from: c, reason: collision with root package name */
    public e0 f2596c = f2593s;

    static {
        w wVar = new w();
        b6.e0 e0Var = b6.g0.f1391j;
        b6.w0 w0Var = b6.w0.f1464m;
        List list = Collections.EMPTY_LIST;
        b6.w0 w0Var2 = b6.w0.f1464m;
        z zVar = new z();
        c0 c0Var = c0.f2371a;
        Uri uri = Uri.EMPTY;
        f2593s = new e0("androidx.media3.common.Timeline", new y(wVar), uri != null ? new b0(uri, null, null, list, w0Var2, -9223372036854775807L) : null, new a0(zVar), h0.f2449y, c0Var);
        androidx.activity.g.s(1, 2, 3, 4, 5);
        androidx.activity.g.s(6, 7, 8, 9, 10);
        g1.w.H(11);
        g1.w.H(12);
        g1.w.H(13);
    }

    public final boolean a() {
        g1.a.k(this.f2602j == (this.f2603k != null));
        return this.f2603k != null;
    }

    public final void b(e0 e0Var, Object obj, long j5, long j9, long j10, boolean z8, boolean z9, a0 a0Var, long j11, long j12, long j13) {
        this.f2594a = f2592r;
        this.f2596c = e0Var != null ? e0Var : f2593s;
        if (e0Var != null) {
            b0 b0Var = e0Var.f2409b;
        }
        this.f2595b = null;
        this.f2597d = obj;
        this.f2598e = j5;
        this.f2599f = j9;
        this.f2600g = j10;
        this.h = z8;
        this.f2601i = z9;
        this.f2602j = a0Var != null;
        this.f2603k = a0Var;
        this.f2605m = j11;
        this.f2606n = j12;
        this.f2607o = 0;
        this.f2608p = 0;
        this.f2609q = j13;
        this.f2604l = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !x0.class.equals(obj.getClass())) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return g1.w.a(this.f2594a, x0Var.f2594a) && g1.w.a(this.f2596c, x0Var.f2596c) && g1.w.a(this.f2597d, x0Var.f2597d) && g1.w.a(this.f2603k, x0Var.f2603k) && this.f2598e == x0Var.f2598e && this.f2599f == x0Var.f2599f && this.f2600g == x0Var.f2600g && this.h == x0Var.h && this.f2601i == x0Var.f2601i && this.f2604l == x0Var.f2604l && this.f2605m == x0Var.f2605m && this.f2606n == x0Var.f2606n && this.f2607o == x0Var.f2607o && this.f2608p == x0Var.f2608p && this.f2609q == x0Var.f2609q;
    }

    public final int hashCode() {
        int hashCode = (this.f2596c.hashCode() + ((this.f2594a.hashCode() + 217) * 31)) * 31;
        Object obj = this.f2597d;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        a0 a0Var = this.f2603k;
        int hashCode3 = (hashCode2 + (a0Var != null ? a0Var.hashCode() : 0)) * 31;
        long j5 = this.f2598e;
        int i9 = (hashCode3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j9 = this.f2599f;
        int i10 = (i9 + ((int) (j9 ^ (j9 >>> 32)))) * 31;
        long j10 = this.f2600g;
        int i11 = (((((((i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (this.h ? 1 : 0)) * 31) + (this.f2601i ? 1 : 0)) * 31) + (this.f2604l ? 1 : 0)) * 31;
        long j11 = this.f2605m;
        int i12 = (i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f2606n;
        int i13 = (((((i12 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + this.f2607o) * 31) + this.f2608p) * 31;
        long j13 = this.f2609q;
        return i13 + ((int) (j13 ^ (j13 >>> 32)));
    }
}
