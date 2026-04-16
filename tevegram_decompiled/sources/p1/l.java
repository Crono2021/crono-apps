package p1;

import android.net.Uri;
import android.util.SparseArray;
import b6.e0;
import b6.g0;
import b6.w0;
import d1.j0;
import d1.l0;
import d1.m0;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import l1.d1;
import l1.i0;
import v1.c1;
import v1.w;
import v1.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements x, q1.q {
    public c1 A;
    public r[] B;
    public r[] C;
    public int D;
    public v1.l E;

    /* renamed from: i, reason: collision with root package name */
    public final j f8152i;

    /* renamed from: j, reason: collision with root package name */
    public final q1.c f8153j;

    /* renamed from: k, reason: collision with root package name */
    public final c f8154k;

    /* renamed from: l, reason: collision with root package name */
    public final z1.f f8155l;

    /* renamed from: m, reason: collision with root package name */
    public final o1.g f8156m;

    /* renamed from: n, reason: collision with root package name */
    public final o1.d f8157n;

    /* renamed from: o, reason: collision with root package name */
    public final z1.g f8158o;

    /* renamed from: p, reason: collision with root package name */
    public final o1.d f8159p;

    /* renamed from: q, reason: collision with root package name */
    public final z1.d f8160q;

    /* renamed from: r, reason: collision with root package name */
    public final IdentityHashMap f8161r;

    /* renamed from: s, reason: collision with root package name */
    public final c f8162s;

    /* renamed from: t, reason: collision with root package name */
    public final o4.d f8163t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f8164u;

    /* renamed from: v, reason: collision with root package name */
    public final int f8165v;

    /* renamed from: w, reason: collision with root package name */
    public final m1.x f8166w;

    /* renamed from: x, reason: collision with root package name */
    public final c f8167x = new c(this);

    /* renamed from: y, reason: collision with root package name */
    public w f8168y;

    /* renamed from: z, reason: collision with root package name */
    public int f8169z;

    public l(j jVar, q1.c cVar, c cVar2, z1.f fVar, o1.g gVar, o1.d dVar, z1.g gVar2, o1.d dVar2, z1.d dVar3, o4.d dVar4, boolean z8, int i9, m1.x xVar) {
        this.f8152i = jVar;
        this.f8153j = cVar;
        this.f8154k = cVar2;
        this.f8155l = fVar;
        this.f8156m = gVar;
        this.f8157n = dVar;
        this.f8158o = gVar2;
        this.f8159p = dVar2;
        this.f8160q = dVar3;
        this.f8163t = dVar4;
        this.f8164u = z8;
        this.f8165v = i9;
        this.f8166w = xVar;
        dVar4.getClass();
        e0 e0Var = g0.f1391j;
        w0 w0Var = w0.f1464m;
        this.E = new v1.l(w0Var, w0Var);
        this.f8161r = new IdentityHashMap();
        this.f8162s = new c(4);
        this.B = new r[0];
        this.C = new r[0];
    }

    public static d1.s l(d1.s sVar, d1.s sVar2, boolean z8) {
        j0 j0Var;
        int i9;
        String str;
        String str2;
        g0 g0Var;
        String str3;
        int i10;
        int i11;
        e0 e0Var = g0.f1391j;
        w0 w0Var = w0.f1464m;
        if (sVar2 != null) {
            str2 = sVar2.f2551j;
            j0Var = sVar2.f2552k;
            i10 = sVar2.f2567z;
            i9 = sVar2.f2547e;
            i11 = sVar2.f2548f;
            str = sVar2.f2546d;
            str3 = sVar2.f2544b;
            g0Var = sVar2.f2545c;
        } else {
            String r8 = g1.w.r(1, sVar.f2551j);
            j0Var = sVar.f2552k;
            if (z8) {
                i10 = sVar.f2567z;
                i9 = sVar.f2547e;
                i11 = sVar.f2548f;
                str = sVar.f2546d;
                str3 = sVar.f2544b;
                str2 = r8;
                g0Var = sVar.f2545c;
            } else {
                i9 = 0;
                str = null;
                str2 = r8;
                g0Var = w0Var;
                str3 = null;
                i10 = -1;
                i11 = 0;
            }
        }
        String c9 = l0.c(str2);
        int i12 = z8 ? sVar.f2549g : -1;
        int i13 = z8 ? sVar.h : -1;
        d1.r rVar = new d1.r();
        rVar.f2518a = sVar.f2543a;
        rVar.f2519b = str3;
        rVar.f2520c = g0.m(g0Var);
        rVar.f2527k = l0.k(sVar.f2553l);
        rVar.f2528l = l0.k(c9);
        rVar.f2525i = str2;
        rVar.f2526j = j0Var;
        rVar.f2524g = i12;
        rVar.h = i13;
        rVar.f2541y = i10;
        rVar.f2522e = i9;
        rVar.f2523f = i11;
        rVar.f2521d = str;
        return new d1.s(rVar);
    }

    @Override // v1.x0
    public final boolean a() {
        return this.E.a();
    }

    @Override // v1.x0
    public final boolean b(l1.j0 j0Var) {
        if (this.A != null) {
            return this.E.b(j0Var);
        }
        for (r rVar : this.B) {
            if (!rVar.L) {
                i0 i0Var = new i0();
                i0Var.f5920a = rVar.X;
                rVar.b(new l1.j0(i0Var));
            }
        }
        return false;
    }

    @Override // q1.q
    public final void c() {
        for (r rVar : this.B) {
            z1.p pVar = rVar.f8209r;
            ArrayList arrayList = rVar.f8213v;
            if (!arrayList.isEmpty()) {
                k kVar = (k) b6.q.g(arrayList);
                int b9 = rVar.f8203l.b(kVar);
                if (b9 == 1) {
                    kVar.K = true;
                } else if (b9 == 2 && !rVar.f8195b0 && pVar.b()) {
                    pVar.a();
                }
            }
        }
        this.f8168y.d(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0090, code lost:
    
        if ((r8 != null ? q1.b.a(r8, r4) ^ r13 : false) != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0058 A[SYNTHETIC] */
    @Override // q1.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.net.Uri r19, z1.j r20, boolean r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            p1.r[] r2 = r0.B
            int r3 = r2.length
            r6 = 0
            r7 = 1
        L9:
            if (r6 >= r3) goto La2
            r8 = r2[r6]
            p1.i r9 = r8.f8203l
            android.net.Uri[] r10 = r9.f8120e
            boolean r11 = g1.w.j(r10, r1)
            if (r11 != 0) goto L1d
            r14 = r20
            r4 = 1
            r13 = 1
            goto L9d
        L1d:
            if (r21 != 0) goto L3a
            z1.g r8 = r8.f8208q
            y1.q r13 = r9.f8131q
            z1.h r13 = com.bumptech.glide.c.o(r13)
            r14 = r20
            z1.i r8 = r8.getFallbackSelectionFor(r13, r14)
            if (r8 == 0) goto L38
            int r13 = r8.f10570a
            r15 = 2
            if (r13 != r15) goto L38
            r13 = 1
            long r4 = r8.f10571b
            goto L42
        L38:
            r13 = 1
            goto L3d
        L3a:
            r14 = r20
            goto L38
        L3d:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L42:
            r8 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L48:
            int r11 = r10.length
            r12 = -1
            if (r8 >= r11) goto L58
            r11 = r10[r8]
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L55
            goto L59
        L55:
            int r8 = r8 + 1
            goto L48
        L58:
            r8 = -1
        L59:
            if (r8 != r12) goto L5d
        L5b:
            r8 = 1
            goto L94
        L5d:
            y1.q r10 = r9.f8131q
            int r8 = r10.t(r8)
            if (r8 != r12) goto L66
            goto L5b
        L66:
            boolean r10 = r9.f8133s
            android.net.Uri r11 = r9.f8129o
            boolean r11 = r1.equals(r11)
            r10 = r10 | r11
            r9.f8133s = r10
            int r10 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r10 == 0) goto L5b
            y1.q r10 = r9.f8131q
            boolean r8 = r10.n(r8, r4)
            if (r8 == 0) goto L93
            q1.c r8 = r9.f8122g
            java.util.HashMap r8 = r8.f8323l
            java.lang.Object r8 = r8.get(r1)
            q1.b r8 = (q1.b) r8
            if (r8 == 0) goto L8f
            boolean r8 = q1.b.a(r8, r4)
            r8 = r8 ^ r13
            goto L90
        L8f:
            r8 = 0
        L90:
            if (r8 == 0) goto L93
            goto L5b
        L93:
            r8 = 0
        L94:
            if (r8 == 0) goto L9c
            int r8 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r8 == 0) goto L9c
            r4 = 1
            goto L9d
        L9c:
            r4 = 0
        L9d:
            r7 = r7 & r4
            int r6 = r6 + 1
            goto L9
        La2:
            v1.w r1 = r0.f8168y
            r1.d(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.l.d(android.net.Uri, z1.j, boolean):boolean");
    }

    public final r e(String str, int i9, Uri[] uriArr, d1.s[] sVarArr, d1.s sVar, List list, Map map, long j5) {
        return new r(str, i9, this.f8167x, new i(this.f8152i, this.f8153j, uriArr, sVarArr, this.f8154k, this.f8155l, this.f8162s, list, this.f8166w), map, this.f8160q, j5, sVar, this.f8156m, this.f8157n, this.f8158o, this.f8159p, this.f8165v);
    }

    @Override // v1.x0
    public final long f() {
        return this.E.f();
    }

    @Override // v1.x
    public final long g() {
        return -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e6  */
    @Override // v1.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(v1.w r26, long r27) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.l.h(v1.w, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:189:0x0116, code lost:
    
        if (r42 != r3.X) goto L63;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0126  */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    @Override // v1.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long i(y1.q[] r38, boolean[] r39, v1.v0[] r40, boolean[] r41, long r42) {
        /*
            Method dump skipped, instructions count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.l.i(y1.q[], boolean[], v1.v0[], boolean[], long):long");
    }

    @Override // v1.x
    public final c1 j() {
        c1 c1Var = this.A;
        c1Var.getClass();
        return c1Var;
    }

    @Override // v1.x
    public final long k(long j5, d1 d1Var) {
        r[] rVarArr = this.C;
        int length = rVarArr.length;
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                break;
            }
            r rVar = rVarArr[i9];
            if (rVar.I == 2) {
                i iVar = rVar.f8203l;
                q1.c cVar = iVar.f8122g;
                int m9 = iVar.f8131q.m();
                Uri[] uriArr = iVar.f8120e;
                q1.i a9 = (m9 >= uriArr.length || m9 == -1) ? null : cVar.a(uriArr[iVar.f8131q.i()], true);
                if (a9 != null) {
                    g0 g0Var = a9.f8370r;
                    if (!g0Var.isEmpty() && a9.f8394c) {
                        long j9 = a9.h - cVar.f8333v;
                        long j10 = j5 - j9;
                        int d9 = g1.w.d(g0Var, Long.valueOf(j10), true);
                        long j11 = ((q1.f) g0Var.get(d9)).f8345m;
                        return d1Var.a(j10, j11, d9 != g0Var.size() - 1 ? ((q1.f) g0Var.get(d9 + 1)).f8345m : j11) + j9;
                    }
                }
            } else {
                i9++;
            }
        }
        return j5;
    }

    @Override // v1.x0
    public final long m() {
        return this.E.m();
    }

    @Override // v1.x
    public final void n() {
        for (r rVar : this.B) {
            rVar.E();
            if (rVar.f8195b0 && !rVar.L) {
                throw m0.a(null, "Loading finished before preparation is complete.");
            }
        }
    }

    @Override // v1.x
    public final long r(long j5) {
        r[] rVarArr = this.C;
        if (rVarArr.length > 0) {
            boolean H = rVarArr[0].H(j5, false);
            int i9 = 1;
            while (true) {
                r[] rVarArr2 = this.C;
                if (i9 >= rVarArr2.length) {
                    break;
                }
                rVarArr2[i9].H(j5, H);
                i9++;
            }
            if (H) {
                ((SparseArray) this.f8162s.f8103i).clear();
            }
        }
        return j5;
    }

    @Override // v1.x
    public final void s(long j5) {
        for (r rVar : this.C) {
            if (rVar.K && !rVar.C()) {
                int length = rVar.D.length;
                for (int i9 = 0; i9 < length; i9++) {
                    rVar.D[i9].i(j5, rVar.V[i9]);
                }
            }
        }
    }

    @Override // v1.x0
    public final void u(long j5) {
        this.E.u(j5);
    }
}
