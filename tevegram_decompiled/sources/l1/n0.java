package l1;

import android.util.Pair;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final d1.w0 f5965a = new d1.w0();

    /* renamed from: b, reason: collision with root package name */
    public final d1.x0 f5966b = new d1.x0();

    /* renamed from: c, reason: collision with root package name */
    public final m1.q f5967c;

    /* renamed from: d, reason: collision with root package name */
    public final g1.t f5968d;

    /* renamed from: e, reason: collision with root package name */
    public final a3.i f5969e;

    /* renamed from: f, reason: collision with root package name */
    public long f5970f;

    /* renamed from: g, reason: collision with root package name */
    public int f5971g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public l0 f5972i;

    /* renamed from: j, reason: collision with root package name */
    public l0 f5973j;

    /* renamed from: k, reason: collision with root package name */
    public l0 f5974k;

    /* renamed from: l, reason: collision with root package name */
    public int f5975l;

    /* renamed from: m, reason: collision with root package name */
    public Object f5976m;

    /* renamed from: n, reason: collision with root package name */
    public long f5977n;

    public n0(m1.q qVar, g1.t tVar, a3.i iVar) {
        this.f5967c = qVar;
        this.f5968d = tVar;
        this.f5969e = iVar;
    }

    public static v1.z l(d1.y0 y0Var, Object obj, long j5, long j9, d1.x0 x0Var, d1.w0 w0Var) {
        y0Var.g(obj, w0Var);
        y0Var.n(w0Var.f2586c, x0Var);
        y0Var.b(obj);
        int i9 = w0Var.f2590g.f2369a;
        if (i9 != 0) {
            if (i9 == 1) {
                w0Var.f(0);
            }
            w0Var.f2590g.getClass();
            w0Var.g(0);
        }
        y0Var.g(obj, w0Var);
        int c9 = w0Var.c(j5);
        return c9 == -1 ? new v1.z(w0Var.b(j5), j9, obj) : new v1.z(obj, c9, w0Var.e(c9), j9, -1);
    }

    public final l0 a() {
        l0 l0Var = this.f5972i;
        if (l0Var == null) {
            return null;
        }
        if (l0Var == this.f5973j) {
            this.f5973j = l0Var.f5949l;
        }
        l0Var.g();
        int i9 = this.f5975l - 1;
        this.f5975l = i9;
        if (i9 == 0) {
            this.f5974k = null;
            l0 l0Var2 = this.f5972i;
            this.f5976m = l0Var2.f5940b;
            this.f5977n = l0Var2.f5944f.f5955a.f9450d;
        }
        this.f5972i = this.f5972i.f5949l;
        j();
        return this.f5972i;
    }

    public final void b() {
        if (this.f5975l == 0) {
            return;
        }
        l0 l0Var = this.f5972i;
        g1.a.l(l0Var);
        this.f5976m = l0Var.f5940b;
        this.f5977n = l0Var.f5944f.f5955a.f9450d;
        while (l0Var != null) {
            l0Var.g();
            l0Var = l0Var.f5949l;
        }
        this.f5972i = null;
        this.f5974k = null;
        this.f5973j = null;
        this.f5975l = 0;
        j();
    }

    public final m0 c(d1.y0 y0Var, l0 l0Var, long j5) {
        d1.w0 w0Var;
        d1.y0 y0Var2;
        Object obj;
        long j9;
        long j10;
        long j11;
        long j12;
        m0 m0Var = l0Var.f5944f;
        long j13 = (l0Var.f5952o + m0Var.f5959e) - j5;
        if (!m0Var.f5961g) {
            v1.z zVar = m0Var.f5955a;
            Object obj2 = zVar.f9447a;
            int i9 = zVar.f9451e;
            d1.w0 w0Var2 = this.f5965a;
            y0Var.g(obj2, w0Var2);
            if (!zVar.b()) {
                if (i9 != -1) {
                    w0Var2.f(i9);
                }
                int e9 = w0Var2.e(i9);
                w0Var2.g(i9);
                if (e9 != w0Var2.f2590g.a(i9).f2355a) {
                    return e(y0Var, zVar.f9447a, zVar.f9451e, e9, m0Var.f5959e, zVar.f9450d);
                }
                y0Var.g(obj2, w0Var2);
                w0Var2.d(i9);
                w0Var2.f2590g.a(i9).getClass();
                return f(y0Var, zVar.f9447a, 0L, m0Var.f5959e, zVar.f9450d);
            }
            int i10 = zVar.f9448b;
            int i11 = w0Var2.f2590g.a(i10).f2355a;
            if (i11 == -1) {
                return null;
            }
            int a9 = w0Var2.f2590g.a(i10).a(zVar.f9449c);
            if (a9 < i11) {
                return e(y0Var, zVar.f9447a, i10, a9, m0Var.f5957c, zVar.f9450d);
            }
            long j14 = m0Var.f5957c;
            if (j14 == -9223372036854775807L) {
                Pair j15 = y0Var.j(this.f5966b, w0Var2, w0Var2.f2586c, -9223372036854775807L, Math.max(0L, j13));
                w0Var = w0Var2;
                y0Var2 = y0Var;
                if (j15 == null) {
                    return null;
                }
                j14 = ((Long) j15.second).longValue();
            } else {
                w0Var = w0Var2;
                y0Var2 = y0Var;
            }
            int i12 = zVar.f9448b;
            y0Var2.g(obj2, w0Var);
            w0Var.d(i12);
            w0Var.f2590g.a(i12).getClass();
            return f(y0Var, zVar.f9447a, Math.max(0L, j14), m0Var.f5957c, zVar.f9450d);
        }
        m0 m0Var2 = l0Var.f5944f;
        v1.z zVar2 = m0Var2.f5955a;
        long j16 = m0Var2.f5957c;
        int d9 = y0Var.d(y0Var.b(zVar2.f9447a), this.f5965a, this.f5966b, this.f5971g, this.h);
        if (d9 != -1) {
            d1.w0 w0Var3 = this.f5965a;
            int i13 = y0Var.f(d9, w0Var3, true).f2586c;
            Object obj3 = w0Var3.f2585b;
            obj3.getClass();
            long j17 = zVar2.f9450d;
            if (y0Var.m(i13, this.f5966b, 0L).f2607o == d9) {
                Pair j18 = y0Var.j(this.f5966b, this.f5965a, i13, -9223372036854775807L, Math.max(0L, j13));
                if (j18 != null) {
                    Object obj4 = j18.first;
                    long longValue = ((Long) j18.second).longValue();
                    l0 l0Var2 = l0Var.f5949l;
                    if (l0Var2 == null || !l0Var2.f5940b.equals(obj4)) {
                        j12 = this.f5970f;
                        this.f5970f = 1 + j12;
                    } else {
                        j12 = l0Var2.f5944f.f5955a.f9450d;
                    }
                    obj = obj4;
                    j9 = longValue;
                    j11 = j12;
                    j10 = -9223372036854775807L;
                }
            } else {
                obj = obj3;
                j9 = 0;
                j10 = 0;
                j11 = j17;
            }
            v1.z l4 = l(y0Var, obj, j9, j11, this.f5966b, this.f5965a);
            if (j10 != -9223372036854775807L && j16 != -9223372036854775807L) {
                int i14 = y0Var.g(zVar2.f9447a, w0Var3).f2590g.f2369a;
                w0Var3.f2590g.getClass();
                if (i14 > 0) {
                    w0Var3.g(0);
                }
            }
            return d(y0Var, l4, j10, j9);
        }
        return null;
    }

    public final m0 d(d1.y0 y0Var, v1.z zVar, long j5, long j9) {
        y0Var.g(zVar.f9447a, this.f5965a);
        boolean b9 = zVar.b();
        Object obj = zVar.f9447a;
        return b9 ? e(y0Var, obj, zVar.f9448b, zVar.f9449c, j5, zVar.f9450d) : f(y0Var, obj, j9, j5, zVar.f9450d);
    }

    public final m0 e(d1.y0 y0Var, Object obj, int i9, int i10, long j5, long j9) {
        v1.z zVar = new v1.z(obj, i9, i10, j9, -1);
        d1.w0 w0Var = this.f5965a;
        long a9 = y0Var.g(obj, w0Var).a(i9, i10);
        if (i10 == w0Var.e(i9)) {
            w0Var.f2590g.getClass();
        }
        w0Var.g(i9);
        long j10 = 0;
        if (a9 != -9223372036854775807L && 0 >= a9) {
            j10 = Math.max(0L, a9 - 1);
        }
        return new m0(zVar, j10, j5, -9223372036854775807L, a9, false, false, false, false);
    }

    public final m0 f(d1.y0 y0Var, Object obj, long j5, long j9, long j10) {
        long j11;
        d1.w0 w0Var = this.f5965a;
        y0Var.g(obj, w0Var);
        int b9 = w0Var.b(j5);
        if (b9 != -1) {
            w0Var.f(b9);
        }
        boolean z8 = false;
        if (b9 != -1) {
            w0Var.g(b9);
        } else if (w0Var.f2590g.f2369a > 0) {
            w0Var.g(0);
        }
        v1.z zVar = new v1.z(b9, j10, obj);
        if (!zVar.b() && b9 == -1) {
            z8 = true;
        }
        boolean i9 = i(y0Var, zVar);
        boolean h = h(y0Var, zVar, z8);
        if (b9 != -1) {
            w0Var.g(b9);
        }
        if (b9 != -1) {
            w0Var.d(b9);
            j11 = 0;
        } else {
            j11 = -9223372036854775807L;
        }
        long j12 = (j11 == -9223372036854775807L || j11 == Long.MIN_VALUE) ? w0Var.f2587d : j11;
        return new m0(zVar, (j12 == -9223372036854775807L || j5 < j12) ? j5 : Math.max(0L, j12 - 1), j9, j11, j12, false, z8, i9, h);
    }

    public final m0 g(d1.y0 y0Var, m0 m0Var) {
        long j5;
        v1.z zVar = m0Var.f5955a;
        boolean b9 = zVar.b();
        int i9 = zVar.f9451e;
        boolean z8 = !b9 && i9 == -1;
        int i10 = zVar.f9448b;
        boolean i11 = i(y0Var, zVar);
        boolean h = h(y0Var, zVar, z8);
        Object obj = zVar.f9447a;
        d1.w0 w0Var = this.f5965a;
        y0Var.g(obj, w0Var);
        if (zVar.b() || i9 == -1) {
            j5 = -9223372036854775807L;
        } else {
            w0Var.d(i9);
            j5 = 0;
        }
        long a9 = zVar.b() ? w0Var.a(i10, zVar.f9449c) : (j5 == -9223372036854775807L || j5 == Long.MIN_VALUE) ? w0Var.f2587d : j5;
        if (zVar.b()) {
            w0Var.g(i10);
        } else if (i9 != -1) {
            w0Var.g(i9);
        }
        return new m0(zVar, m0Var.f5956b, m0Var.f5957c, j5, a9, false, z8, i11, h);
    }

    public final boolean h(d1.y0 y0Var, v1.z zVar, boolean z8) {
        int b9 = y0Var.b(zVar.f9447a);
        if (!y0Var.m(y0Var.f(b9, this.f5965a, false).f2586c, this.f5966b, 0L).f2601i) {
            if (y0Var.d(b9, this.f5965a, this.f5966b, this.f5971g, this.h) == -1 && z8) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(d1.y0 y0Var, v1.z zVar) {
        boolean z8 = !zVar.b() && zVar.f9451e == -1;
        Object obj = zVar.f9447a;
        if (z8) {
            if (y0Var.m(y0Var.g(obj, this.f5965a).f2586c, this.f5966b, 0L).f2608p == y0Var.b(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void j() {
        b6.e0 e0Var = b6.g0.f1391j;
        b6.d0 d0Var = new b6.d0();
        for (l0 l0Var = this.f5972i; l0Var != null; l0Var = l0Var.f5949l) {
            d0Var.a(l0Var.f5944f.f5955a);
        }
        l0 l0Var2 = this.f5973j;
        this.f5968d.c(new androidx.emoji2.text.m(this, d0Var, l0Var2 == null ? null : l0Var2.f5944f.f5955a, 4));
    }

    public final boolean k(l0 l0Var) {
        g1.a.l(l0Var);
        boolean z8 = false;
        if (l0Var.equals(this.f5974k)) {
            return false;
        }
        this.f5974k = l0Var;
        while (true) {
            l0Var = l0Var.f5949l;
            if (l0Var == null) {
                break;
            }
            if (l0Var == this.f5973j) {
                this.f5973j = this.f5972i;
                z8 = true;
            }
            l0Var.g();
            this.f5975l--;
        }
        l0 l0Var2 = this.f5974k;
        l0Var2.getClass();
        if (l0Var2.f5949l != null) {
            l0Var2.b();
            l0Var2.f5949l = null;
            l0Var2.c();
        }
        j();
        return z8;
    }

    public final v1.z m(d1.y0 y0Var, Object obj, long j5) {
        long j9;
        int b9;
        Object obj2 = obj;
        d1.w0 w0Var = this.f5965a;
        int i9 = y0Var.g(obj2, w0Var).f2586c;
        Object obj3 = this.f5976m;
        if (obj3 == null || (b9 = y0Var.b(obj3)) == -1 || y0Var.f(b9, w0Var, false).f2586c != i9) {
            l0 l0Var = this.f5972i;
            while (true) {
                if (l0Var == null) {
                    l0 l0Var2 = this.f5972i;
                    while (true) {
                        if (l0Var2 != null) {
                            int b10 = y0Var.b(l0Var2.f5940b);
                            if (b10 != -1 && y0Var.f(b10, w0Var, false).f2586c == i9) {
                                j9 = l0Var2.f5944f.f5955a.f9450d;
                                break;
                            }
                            l0Var2 = l0Var2.f5949l;
                        } else {
                            j9 = this.f5970f;
                            this.f5970f = 1 + j9;
                            if (this.f5972i == null) {
                                this.f5976m = obj2;
                                this.f5977n = j9;
                            }
                        }
                    }
                } else {
                    if (l0Var.f5940b.equals(obj2)) {
                        j9 = l0Var.f5944f.f5955a.f9450d;
                        break;
                    }
                    l0Var = l0Var.f5949l;
                }
            }
        } else {
            j9 = this.f5977n;
        }
        y0Var.g(obj2, w0Var);
        int i10 = w0Var.f2586c;
        d1.x0 x0Var = this.f5966b;
        y0Var.n(i10, x0Var);
        boolean z8 = false;
        for (int b11 = y0Var.b(obj); b11 >= x0Var.f2607o; b11--) {
            y0Var.f(b11, w0Var, true);
            boolean z9 = w0Var.f2590g.f2369a > 0;
            z8 |= z9;
            if (w0Var.c(w0Var.f2587d) != -1) {
                obj2 = w0Var.f2585b;
                obj2.getClass();
            }
            if (z8 && (!z9 || w0Var.f2587d != 0)) {
                break;
            }
        }
        return l(y0Var, obj2, j5, j9, this.f5966b, this.f5965a);
    }

    public final boolean n(d1.y0 y0Var) {
        d1.y0 y0Var2;
        l0 l0Var;
        l0 l0Var2 = this.f5972i;
        if (l0Var2 == null) {
            return true;
        }
        int b9 = y0Var.b(l0Var2.f5940b);
        while (true) {
            y0Var2 = y0Var;
            b9 = y0Var2.d(b9, this.f5965a, this.f5966b, this.f5971g, this.h);
            while (true) {
                l0Var = l0Var2.f5949l;
                if (l0Var == null || l0Var2.f5944f.f5961g) {
                    break;
                }
                l0Var2 = l0Var;
            }
            if (b9 == -1 || l0Var == null || y0Var2.b(l0Var.f5940b) != b9) {
                break;
            }
            l0Var2 = l0Var;
            y0Var = y0Var2;
        }
        boolean k3 = k(l0Var2);
        l0Var2.f5944f = g(y0Var2, l0Var2.f5944f);
        return !k3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0087, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0082, code lost:
    
        r14 = k(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(d1.y0 r14, long r15, long r17) {
        /*
            r13 = this;
            l1.l0 r0 = r13.f5972i
            r1 = 0
        L3:
            r2 = 1
            if (r0 == 0) goto L87
            l1.m0 r3 = r0.f5944f
            if (r1 != 0) goto L10
            l1.m0 r1 = r13.g(r14, r3)
            r4 = r15
            goto L30
        L10:
            r4 = r15
            l1.m0 r6 = r13.c(r14, r1, r4)
            if (r6 != 0) goto L1d
            boolean r14 = r13.k(r1)
        L1b:
            r14 = r14 ^ r2
            return r14
        L1d:
            long r7 = r3.f5956b
            long r9 = r6.f5956b
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L82
            v1.z r7 = r3.f5955a
            v1.z r8 = r6.f5955a
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L82
            r1 = r6
        L30:
            long r6 = r1.f5959e
            long r8 = r3.f5957c
            l1.m0 r1 = r1.a(r8)
            r0.f5944f = r1
            long r8 = r3.f5959e
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 == 0) goto L7c
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 != 0) goto L4a
            goto L7c
        L4a:
            r0.i()
            int r14 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r14 != 0) goto L57
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L5a
        L57:
            long r3 = r0.f5952o
            long r3 = r3 + r6
        L5a:
            l1.l0 r14 = r13.f5973j
            r1 = 0
            if (r0 != r14) goto L71
            l1.m0 r14 = r0.f5944f
            boolean r14 = r14.f5960f
            if (r14 != 0) goto L71
            r5 = -9223372036854775808
            int r14 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r14 == 0) goto L6f
            int r14 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r14 < 0) goto L71
        L6f:
            r14 = 1
            goto L72
        L71:
            r14 = 0
        L72:
            boolean r0 = r13.k(r0)
            if (r0 != 0) goto L7b
            if (r14 != 0) goto L7b
            goto L87
        L7b:
            return r1
        L7c:
            l1.l0 r1 = r0.f5949l
            r12 = r1
            r1 = r0
            r0 = r12
            goto L3
        L82:
            boolean r14 = r13.k(r1)
            goto L1b
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.n0.o(d1.y0, long, long):boolean");
    }
}
