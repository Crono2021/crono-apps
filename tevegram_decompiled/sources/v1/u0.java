package v1;

import android.util.SparseArray;
import java.io.EOFException;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class u0 implements d2.d0 {
    public d1.s A;
    public d1.s B;
    public long C;
    public boolean E;
    public long F;
    public boolean G;

    /* renamed from: a, reason: collision with root package name */
    public final r0 f9412a;

    /* renamed from: d, reason: collision with root package name */
    public final o1.g f9415d;

    /* renamed from: e, reason: collision with root package name */
    public final o1.d f9416e;

    /* renamed from: f, reason: collision with root package name */
    public Object f9417f;

    /* renamed from: g, reason: collision with root package name */
    public d1.s f9418g;
    public i7.x h;

    /* renamed from: p, reason: collision with root package name */
    public int f9426p;

    /* renamed from: q, reason: collision with root package name */
    public int f9427q;

    /* renamed from: r, reason: collision with root package name */
    public int f9428r;

    /* renamed from: s, reason: collision with root package name */
    public int f9429s;

    /* renamed from: w, reason: collision with root package name */
    public boolean f9433w;

    /* renamed from: z, reason: collision with root package name */
    public boolean f9436z;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.crypto.tink.shaded.protobuf.d f9413b = new com.google.crypto.tink.shaded.protobuf.d();

    /* renamed from: i, reason: collision with root package name */
    public int f9419i = IjkMediaCodecInfo.RANK_MAX;

    /* renamed from: j, reason: collision with root package name */
    public long[] f9420j = new long[IjkMediaCodecInfo.RANK_MAX];

    /* renamed from: k, reason: collision with root package name */
    public long[] f9421k = new long[IjkMediaCodecInfo.RANK_MAX];

    /* renamed from: n, reason: collision with root package name */
    public long[] f9424n = new long[IjkMediaCodecInfo.RANK_MAX];

    /* renamed from: m, reason: collision with root package name */
    public int[] f9423m = new int[IjkMediaCodecInfo.RANK_MAX];

    /* renamed from: l, reason: collision with root package name */
    public int[] f9422l = new int[IjkMediaCodecInfo.RANK_MAX];

    /* renamed from: o, reason: collision with root package name */
    public d2.c0[] f9425o = new d2.c0[IjkMediaCodecInfo.RANK_MAX];

    /* renamed from: c, reason: collision with root package name */
    public final b6.i0 f9414c = new b6.i0(new m7.c(26));

    /* renamed from: t, reason: collision with root package name */
    public long f9430t = Long.MIN_VALUE;

    /* renamed from: u, reason: collision with root package name */
    public long f9431u = Long.MIN_VALUE;

    /* renamed from: v, reason: collision with root package name */
    public long f9432v = Long.MIN_VALUE;

    /* renamed from: y, reason: collision with root package name */
    public boolean f9435y = true;

    /* renamed from: x, reason: collision with root package name */
    public boolean f9434x = true;
    public boolean D = true;

    public u0(z1.d dVar, o1.g gVar, o1.d dVar2) {
        this.f9415d = gVar;
        this.f9416e = dVar2;
        this.f9412a = new r0(dVar);
    }

    public final synchronized void A() {
        this.f9429s = 0;
        r0 r0Var = this.f9412a;
        r0Var.f9395e = r0Var.f9394d;
    }

    public final synchronized boolean B(int i9) {
        A();
        int i10 = this.f9427q;
        if (i9 >= i10 && i9 <= this.f9426p + i10) {
            this.f9430t = Long.MIN_VALUE;
            this.f9429s = i9 - i10;
            return true;
        }
        return false;
    }

    public final synchronized boolean C(long j5, boolean z8) {
        Throwable th;
        u0 u0Var;
        long j9;
        int l4;
        try {
            try {
                A();
                int r8 = r(this.f9429s);
                int i9 = this.f9429s;
                int i10 = this.f9426p;
                if (!(i9 != i10) || j5 < this.f9424n[r8] || (j5 > this.f9432v && !z8)) {
                    return false;
                }
                if (this.D) {
                    int i11 = i10 - i9;
                    int i12 = 0;
                    while (true) {
                        if (i12 < i11) {
                            try {
                                if (this.f9424n[r8] >= j5) {
                                    i11 = i12;
                                    break;
                                }
                                r8++;
                                if (r8 == this.f9419i) {
                                    r8 = 0;
                                }
                                i12++;
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        } else if (!z8) {
                            i11 = -1;
                        }
                    }
                    j9 = j5;
                    l4 = i11;
                    u0Var = this;
                } else {
                    int i13 = i10 - i9;
                    u0Var = this;
                    j9 = j5;
                    l4 = u0Var.l(j9, r8, i13, true);
                }
                if (l4 == -1) {
                    return false;
                }
                u0Var.f9430t = j9;
                u0Var.f9429s += l4;
                return true;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized void D(int i9) {
        boolean z8;
        if (i9 >= 0) {
            try {
                if (this.f9429s + i9 <= this.f9426p) {
                    z8 = true;
                    g1.a.f(z8);
                    this.f9429s += i9;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z8 = false;
        g1.a.f(z8);
        this.f9429s += i9;
    }

    @Override // d2.d0
    public final int a(d1.k kVar, int i9, boolean z8) {
        return b(kVar, i9, z8);
    }

    @Override // d2.d0
    public final int b(d1.k kVar, int i9, boolean z8) {
        r0 r0Var = this.f9412a;
        int c9 = r0Var.c(i9);
        q0 q0Var = r0Var.f9396f;
        z1.a aVar = (z1.a) q0Var.f9382k;
        int read = kVar.read(aVar.f10536a, ((int) (r0Var.f9397g - q0Var.f9380i)) + aVar.f10537b, c9);
        if (read == -1) {
            if (z8) {
                return -1;
            }
            throw new EOFException();
        }
        long j5 = r0Var.f9397g + read;
        r0Var.f9397g = j5;
        q0 q0Var2 = r0Var.f9396f;
        if (j5 == q0Var2.f9381j) {
            r0Var.f9396f = (q0) q0Var2.f9383l;
        }
        return read;
    }

    @Override // d2.d0
    public final void c(int i9, g1.p pVar) {
        f(pVar, i9, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    @Override // d2.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(long r14, int r16, int r17, int r18, d2.c0 r19) {
        /*
            Method dump skipped, instructions count: 184
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.u0.d(long, int, int, int, d2.c0):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0110, code lost:
    
        if (r0 == 16) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARN: Type inference failed for: r7v26, types: [java.lang.Object, v1.t0] */
    @Override // d2.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(d1.s r7) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.u0.e(d1.s):void");
    }

    @Override // d2.d0
    public final void f(g1.p pVar, int i9, int i10) {
        while (true) {
            r0 r0Var = this.f9412a;
            if (i9 <= 0) {
                r0Var.getClass();
                return;
            }
            int c9 = r0Var.c(i9);
            q0 q0Var = r0Var.f9396f;
            z1.a aVar = (z1.a) q0Var.f9382k;
            pVar.e(((int) (r0Var.f9397g - q0Var.f9380i)) + aVar.f10537b, c9, aVar.f10536a);
            i9 -= c9;
            long j5 = r0Var.f9397g + c9;
            r0Var.f9397g = j5;
            q0 q0Var2 = r0Var.f9396f;
            if (j5 == q0Var2.f9381j) {
                r0Var.f9396f = (q0) q0Var2.f9383l;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
    
        if (((v1.s0) r9.valueAt(r9.size() - 1)).f9401a.equals(r8.B) == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void g(long r9, int r11, long r12, int r14, d2.c0 r15) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.u0.g(long, int, long, int, d2.c0):void");
    }

    public final long h(int i9) {
        this.f9431u = Math.max(this.f9431u, p(i9));
        this.f9426p -= i9;
        int i10 = this.f9427q + i9;
        this.f9427q = i10;
        int i11 = this.f9428r + i9;
        this.f9428r = i11;
        int i12 = this.f9419i;
        if (i11 >= i12) {
            this.f9428r = i11 - i12;
        }
        int i13 = this.f9429s - i9;
        this.f9429s = i13;
        int i14 = 0;
        if (i13 < 0) {
            this.f9429s = 0;
        }
        b6.i0 i0Var = this.f9414c;
        SparseArray sparseArray = (SparseArray) i0Var.f1399k;
        while (i14 < sparseArray.size() - 1) {
            int i15 = i14 + 1;
            if (i10 < sparseArray.keyAt(i15)) {
                break;
            }
            ((m7.c) i0Var.f1400l).accept(sparseArray.valueAt(i14));
            sparseArray.removeAt(i14);
            int i16 = i0Var.f1398j;
            if (i16 > 0) {
                i0Var.f1398j = i16 - 1;
            }
            i14 = i15;
        }
        if (this.f9426p != 0) {
            return this.f9421k[this.f9428r];
        }
        int i17 = this.f9428r;
        if (i17 == 0) {
            i17 = this.f9419i;
        }
        return this.f9421k[i17 - 1] + this.f9422l[r7];
    }

    public final void i(long j5, boolean z8) {
        Throwable th;
        r0 r0Var = this.f9412a;
        synchronized (this) {
            try {
                try {
                    int i9 = this.f9426p;
                    long j9 = -1;
                    if (i9 != 0) {
                        long[] jArr = this.f9424n;
                        int i10 = this.f9428r;
                        if (j5 >= jArr[i10]) {
                            if (z8) {
                                try {
                                    int i11 = this.f9429s;
                                    if (i11 != i9) {
                                        i9 = i11 + 1;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                            int l4 = l(j5, i10, i9, false);
                            if (l4 != -1) {
                                j9 = h(l4);
                            }
                            r0Var.b(j9);
                        }
                    }
                    r0Var.b(j9);
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final void j() {
        long h;
        r0 r0Var = this.f9412a;
        synchronized (this) {
            int i9 = this.f9426p;
            h = i9 == 0 ? -1L : h(i9);
        }
        r0Var.b(h);
    }

    public final long k(int i9) {
        int i10 = this.f9427q;
        int i11 = this.f9426p;
        int i12 = (i10 + i11) - i9;
        boolean z8 = false;
        g1.a.f(i12 >= 0 && i12 <= i11 - this.f9429s);
        int i13 = this.f9426p - i12;
        this.f9426p = i13;
        this.f9432v = Math.max(this.f9431u, p(i13));
        if (i12 == 0 && this.f9433w) {
            z8 = true;
        }
        this.f9433w = z8;
        b6.i0 i0Var = this.f9414c;
        SparseArray sparseArray = (SparseArray) i0Var.f1399k;
        for (int size = sparseArray.size() - 1; size >= 0 && i9 < sparseArray.keyAt(size); size--) {
            ((m7.c) i0Var.f1400l).accept(sparseArray.valueAt(size));
            sparseArray.removeAt(size);
        }
        i0Var.f1398j = sparseArray.size() > 0 ? Math.min(i0Var.f1398j, sparseArray.size() - 1) : -1;
        int i14 = this.f9426p;
        if (i14 == 0) {
            return 0L;
        }
        return this.f9421k[r(i14 - 1)] + this.f9422l[r9];
    }

    public final int l(long j5, int i9, int i10, boolean z8) {
        int i11 = -1;
        for (int i12 = 0; i12 < i10; i12++) {
            long j9 = this.f9424n[i9];
            if (j9 > j5) {
                break;
            }
            if (!z8 || (this.f9423m[i9] & 1) != 0) {
                if (j9 == j5) {
                    return i12;
                }
                i11 = i12;
            }
            i9++;
            if (i9 == this.f9419i) {
                i9 = 0;
            }
        }
        return i11;
    }

    public d1.s m(d1.s sVar) {
        if (this.F == 0 || sVar.f2558q == Long.MAX_VALUE) {
            return sVar;
        }
        d1.r a9 = sVar.a();
        a9.f2532p = sVar.f2558q + this.F;
        return new d1.s(a9);
    }

    public final synchronized long n() {
        return this.f9432v;
    }

    public final synchronized long o() {
        return Math.max(this.f9431u, p(this.f9429s));
    }

    public final long p(int i9) {
        long j5 = Long.MIN_VALUE;
        if (i9 == 0) {
            return Long.MIN_VALUE;
        }
        int r8 = r(i9 - 1);
        for (int i10 = 0; i10 < i9; i10++) {
            j5 = Math.max(j5, this.f9424n[r8]);
            if ((this.f9423m[r8] & 1) != 0) {
                return j5;
            }
            r8--;
            if (r8 == -1) {
                r8 = this.f9419i - 1;
            }
        }
        return j5;
    }

    public final int q() {
        return this.f9427q + this.f9429s;
    }

    public final int r(int i9) {
        int i10 = this.f9428r + i9;
        int i11 = this.f9419i;
        return i10 < i11 ? i10 : i10 - i11;
    }

    public final synchronized int s(long j5, boolean z8) {
        try {
            try {
                int r8 = r(this.f9429s);
                int i9 = this.f9429s;
                int i10 = this.f9426p;
                if (!(i9 != i10) || j5 < this.f9424n[r8]) {
                    return 0;
                }
                if (j5 > this.f9432v && z8) {
                    return i10 - i9;
                }
                int l4 = l(j5, r8, i10 - i9, true);
                if (l4 == -1) {
                    return 0;
                }
                return l4;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized d1.s t() {
        return this.f9435y ? null : this.B;
    }

    public final synchronized boolean u(boolean z8) {
        d1.s sVar;
        boolean z9 = false;
        if (this.f9429s != this.f9426p) {
            if (((s0) this.f9414c.d(q())).f9401a != this.f9418g) {
                return true;
            }
            return v(r(this.f9429s));
        }
        if (z8 || this.f9433w || ((sVar = this.B) != null && sVar != this.f9418g)) {
            z9 = true;
        }
        return z9;
    }

    public final boolean v(int i9) {
        i7.x xVar = this.h;
        if (xVar == null || xVar.C() == 4) {
            return true;
        }
        if ((this.f9423m[i9] & 1073741824) != 0) {
            return false;
        }
        this.h.getClass();
        return false;
    }

    public final void w(d1.s sVar, a5.d dVar) {
        d1.s sVar2;
        d1.s sVar3 = this.f9418g;
        boolean z8 = sVar3 == null;
        d1.n nVar = sVar3 == null ? null : sVar3.f2557p;
        this.f9418g = sVar;
        d1.n nVar2 = sVar.f2557p;
        o1.g gVar = this.f9415d;
        if (gVar != null) {
            int j5 = gVar.j(sVar);
            d1.r a9 = sVar.a();
            a9.H = j5;
            sVar2 = new d1.s(a9);
        } else {
            sVar2 = sVar;
        }
        dVar.f175k = sVar2;
        dVar.f174j = this.h;
        if (gVar == null) {
            return;
        }
        if (z8 || !g1.w.a(nVar, nVar2)) {
            i7.x xVar = this.h;
            o1.d dVar2 = this.f9416e;
            i7.x c9 = gVar.c(dVar2, sVar);
            this.h = c9;
            dVar.f174j = c9;
            if (xVar != null) {
                xVar.K(dVar2);
            }
        }
    }

    public final synchronized long x() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return this.f9429s != this.f9426p ? this.f9420j[r(this.f9429s)] : this.C;
    }

    public final int y(a5.d dVar, j1.e eVar, int i9, boolean z8) {
        int i10;
        boolean z9 = (i9 & 2) != 0;
        com.google.crypto.tink.shaded.protobuf.d dVar2 = this.f9413b;
        synchronized (this) {
            try {
                eVar.f5360n = false;
                i10 = -3;
                if (this.f9429s != this.f9426p) {
                    d1.s sVar = ((s0) this.f9414c.d(q())).f9401a;
                    if (!z9 && sVar == this.f9418g) {
                        int r8 = r(this.f9429s);
                        if (v(r8)) {
                            eVar.f3748j = this.f9423m[r8];
                            if (this.f9429s == this.f9426p - 1 && (z8 || this.f9433w)) {
                                eVar.a(536870912);
                            }
                            long j5 = this.f9424n[r8];
                            eVar.f5361o = j5;
                            if (j5 < this.f9430t) {
                                eVar.a(Integer.MIN_VALUE);
                            }
                            dVar2.f2213a = this.f9422l[r8];
                            dVar2.f2214b = this.f9421k[r8];
                            dVar2.f2215c = this.f9425o[r8];
                            i10 = -4;
                        } else {
                            eVar.f5360n = true;
                        }
                    }
                    w(sVar, dVar);
                    i10 = -5;
                } else {
                    if (!z8 && !this.f9433w) {
                        d1.s sVar2 = this.B;
                        if (sVar2 == null || (!z9 && sVar2 == this.f9418g)) {
                        }
                        w(sVar2, dVar);
                        i10 = -5;
                    }
                    eVar.f3748j = 4;
                    eVar.f5361o = Long.MIN_VALUE;
                    i10 = -4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i10 == -4 && !eVar.c(4)) {
            boolean z10 = (i9 & 1) != 0;
            if ((i9 & 4) == 0) {
                r0 r0Var = this.f9412a;
                com.google.crypto.tink.shaded.protobuf.d dVar3 = this.f9413b;
                if (z10) {
                    r0.f(r0Var.f9395e, eVar, dVar3, r0Var.f9393c);
                } else {
                    r0Var.f9395e = r0.f(r0Var.f9395e, eVar, dVar3, r0Var.f9393c);
                }
            }
            if (!z10) {
                this.f9429s++;
            }
        }
        return i10;
    }

    public final void z(boolean z8) {
        r0 r0Var = this.f9412a;
        r0Var.a(r0Var.f9394d);
        q0 q0Var = r0Var.f9394d;
        int i9 = r0Var.f9392b;
        g1.a.k(((z1.a) q0Var.f9382k) == null);
        q0Var.f9380i = 0L;
        q0Var.f9381j = i9;
        q0 q0Var2 = r0Var.f9394d;
        r0Var.f9395e = q0Var2;
        r0Var.f9396f = q0Var2;
        r0Var.f9397g = 0L;
        r0Var.f9391a.b();
        this.f9426p = 0;
        this.f9427q = 0;
        this.f9428r = 0;
        this.f9429s = 0;
        this.f9434x = true;
        this.f9430t = Long.MIN_VALUE;
        this.f9431u = Long.MIN_VALUE;
        this.f9432v = Long.MIN_VALUE;
        this.f9433w = false;
        b6.i0 i0Var = this.f9414c;
        SparseArray sparseArray = (SparseArray) i0Var.f1399k;
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            ((m7.c) i0Var.f1400l).accept(sparseArray.valueAt(i10));
        }
        i0Var.f1398j = -1;
        sparseArray.clear();
        if (z8) {
            this.A = null;
            this.B = null;
            this.f9435y = true;
            this.D = true;
        }
    }
}
