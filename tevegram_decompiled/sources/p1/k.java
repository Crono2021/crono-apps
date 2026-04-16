package p1;

import android.net.Uri;
import android.text.TextUtils;
import b6.e0;
import b6.g0;
import b6.w0;
import d1.i0;
import d1.j0;
import d1.l0;
import g1.w;
import i3.c0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import m1.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends w1.a {
    public static final AtomicInteger L = new AtomicInteger();
    public final boolean A;
    public final boolean B;
    public b C;
    public r D;
    public int E;
    public boolean F;
    public volatile boolean G;
    public boolean H;
    public g0 I;
    public boolean J;
    public boolean K;

    /* renamed from: j, reason: collision with root package name */
    public final long f8135j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8136k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8137l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f8138m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f8139n;

    /* renamed from: o, reason: collision with root package name */
    public final int f8140o;

    /* renamed from: p, reason: collision with root package name */
    public final i1.h f8141p;

    /* renamed from: q, reason: collision with root package name */
    public final i1.k f8142q;

    /* renamed from: r, reason: collision with root package name */
    public final b f8143r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f8144s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f8145t;

    /* renamed from: u, reason: collision with root package name */
    public final g1.u f8146u;

    /* renamed from: v, reason: collision with root package name */
    public final j f8147v;

    /* renamed from: w, reason: collision with root package name */
    public final List f8148w;

    /* renamed from: x, reason: collision with root package name */
    public final d1.n f8149x;

    /* renamed from: y, reason: collision with root package name */
    public final q2.h f8150y;

    /* renamed from: z, reason: collision with root package name */
    public final g1.p f8151z;

    public k(j jVar, i1.h hVar, i1.k kVar, d1.s sVar, boolean z8, i1.h hVar2, i1.k kVar2, boolean z9, Uri uri, List list, int i9, Object obj, long j5, long j9, long j10, int i10, boolean z10, int i11, boolean z11, boolean z12, g1.u uVar, d1.n nVar, b bVar, q2.h hVar3, g1.p pVar, boolean z13, x xVar) {
        super(hVar, kVar, 1, sVar, i9, obj, j5, j9);
        sVar.getClass();
        this.f8135j = j10;
        this.A = z8;
        this.f8140o = i10;
        this.K = z10;
        this.f8137l = i11;
        this.f8142q = kVar2;
        this.f8141p = hVar2;
        this.F = kVar2 != null;
        this.B = z9;
        this.f8138m = uri;
        this.f8144s = z12;
        this.f8146u = uVar;
        this.f8145t = z11;
        this.f8147v = jVar;
        this.f8148w = list;
        this.f8149x = nVar;
        this.f8143r = bVar;
        this.f8150y = hVar3;
        this.f8151z = pVar;
        this.f8139n = z13;
        e0 e0Var = g0.f1391j;
        this.I = w0.f1464m;
        this.f8136k = L.getAndIncrement();
    }

    public static byte[] d(String str) {
        if (a.a.U(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    @Override // z1.m
    public final void a() {
        b bVar;
        this.D.getClass();
        if (this.C == null && (bVar = this.f8143r) != null) {
            d2.m a9 = bVar.f8098a.a();
            if ((a9 instanceof c0) || (a9 instanceof w2.i)) {
                this.C = this.f8143r;
                this.F = false;
            }
        }
        i1.k kVar = this.f8142q;
        i1.h hVar = this.f8141p;
        if (this.F) {
            hVar.getClass();
            kVar.getClass();
            c(hVar, kVar, this.B, false);
            this.E = 0;
            this.F = false;
        }
        if (this.G) {
            return;
        }
        if (!this.f8145t) {
            c(this.f9709i, this.f9703b, this.A, true);
        }
        this.H = !this.G;
    }

    @Override // z1.m
    public final void b() {
        this.G = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:8:0x0044, B:10:0x004a, B:18:0x0067, B:19:0x0069, B:20:0x007e, B:28:0x0087, B:29:0x008f, B:34:0x007b, B:13:0x0052, B:15:0x0056, B:31:0x006c, B:33:0x0074, B:35:0x0086), top: B:7:0x0044, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[Catch: all -> 0x0063, EOFException -> 0x0065, TRY_LEAVE, TryCatch #1 {all -> 0x0063, blocks: (B:13:0x0052, B:15:0x0056, B:31:0x006c, B:33:0x0074, B:35:0x0086), top: B:12:0x0052, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067 A[EDGE_INSN: B:25:0x0067->B:18:0x0067 BREAK  A[LOOP:0: B:12:0x0052->B:24:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(i1.h r23, i1.k r24, boolean r25, boolean r26) {
        /*
            r22 = this;
            r1 = r22
            r2 = r24
            int r0 = r1.E
            r3 = 0
            r5 = 0
            if (r25 == 0) goto L14
            if (r0 == 0) goto Le
            r5 = 1
        Le:
            r12 = r2
        Lf:
            r6 = r23
            r0 = r26
            goto L44
        L14:
            long r6 = (long) r0
            long r8 = r2.f4329f
            r10 = -1
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 != 0) goto L20
        L1d:
            r19 = r10
            goto L23
        L20:
            long r10 = r8 - r6
            goto L1d
        L23:
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto L2c
            int r0 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r0 != 0) goto L2c
            goto Le
        L2c:
            i1.k r12 = new i1.k
            android.net.Uri r13 = r2.f4324a
            int r14 = r2.f4325b
            byte[] r15 = r2.f4326c
            java.util.Map r0 = r2.f4327d
            long r8 = r2.f4328e
            long r17 = r8 + r6
            int r6 = r2.f4330g
            r16 = r0
            r21 = r6
            r12.<init>(r13, r14, r15, r16, r17, r19, r21)
            goto Lf
        L44:
            d2.j r7 = r1.f(r6, r12, r0)     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L52
            int r0 = r1.E     // Catch: java.lang.Throwable -> L50
            r7.i(r0)     // Catch: java.lang.Throwable -> L50
            goto L52
        L50:
            r0 = move-exception
            goto L90
        L52:
            boolean r0 = r1.G     // Catch: java.lang.Throwable -> L63 java.io.EOFException -> L65
            if (r0 != 0) goto L67
            p1.b r0 = r1.C     // Catch: java.lang.Throwable -> L63 java.io.EOFException -> L65
            d2.m r0 = r0.f8098a     // Catch: java.lang.Throwable -> L63 java.io.EOFException -> L65
            d1.w r5 = p1.b.f8097e     // Catch: java.lang.Throwable -> L63 java.io.EOFException -> L65
            int r0 = r0.h(r7, r5)     // Catch: java.lang.Throwable -> L63 java.io.EOFException -> L65
            if (r0 != 0) goto L67
            goto L52
        L63:
            r0 = move-exception
            goto L87
        L65:
            r0 = move-exception
            goto L6c
        L67:
            long r3 = r7.f2703l     // Catch: java.lang.Throwable -> L50
        L69:
            long r7 = r2.f4328e     // Catch: java.lang.Throwable -> L50
            goto L7e
        L6c:
            d1.s r5 = r1.f9705d     // Catch: java.lang.Throwable -> L63
            int r5 = r5.f2548f     // Catch: java.lang.Throwable -> L63
            r5 = r5 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L86
            p1.b r0 = r1.C     // Catch: java.lang.Throwable -> L63
            d2.m r0 = r0.f8098a     // Catch: java.lang.Throwable -> L63
            r0.c(r3, r3)     // Catch: java.lang.Throwable -> L63
            long r3 = r7.f2703l     // Catch: java.lang.Throwable -> L50
            goto L69
        L7e:
            long r3 = r3 - r7
            int r0 = (int) r3     // Catch: java.lang.Throwable -> L50
            r1.E = r0     // Catch: java.lang.Throwable -> L50
            com.bumptech.glide.d.i(r6)
            return
        L86:
            throw r0     // Catch: java.lang.Throwable -> L63
        L87:
            long r3 = r7.f2703l     // Catch: java.lang.Throwable -> L50
            long r7 = r2.f4328e     // Catch: java.lang.Throwable -> L50
            long r3 = r3 - r7
            int r2 = (int) r3     // Catch: java.lang.Throwable -> L50
            r1.E = r2     // Catch: java.lang.Throwable -> L50
            throw r0     // Catch: java.lang.Throwable -> L50
        L90:
            com.bumptech.glide.d.i(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.k.c(i1.h, i1.k, boolean, boolean):void");
    }

    public final int e(int i9) {
        g1.a.k(!this.f8139n);
        if (i9 >= this.I.size()) {
            return 0;
        }
        return ((Integer) this.I.get(i9)).intValue();
    }

    public final d2.j f(i1.h hVar, i1.k kVar, boolean z8) {
        long j5;
        long j9;
        long j10;
        long j11;
        b bVar;
        b bVar2;
        int i9;
        g1.u uVar;
        ArrayList arrayList;
        d2.m aVar;
        boolean z9;
        List list;
        boolean z10;
        int i10;
        d2.m dVar;
        long f9 = hVar.f(kVar);
        long j12 = this.f9708g;
        g1.u uVar2 = this.f8146u;
        if (z8) {
            try {
                uVar2.h(j12, this.f8144s);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            } catch (TimeoutException e9) {
                throw new IOException(e9);
            }
        }
        d2.j jVar = new d2.j(hVar, kVar.f4328e, f9);
        if (this.C == null) {
            g1.p pVar = this.f8151z;
            jVar.f2705n = 0;
            try {
                pVar.C(10);
                jVar.n(pVar.f3699a, 0, 10, false);
            } catch (EOFException unused2) {
                j5 = -9223372036854775807L;
            }
            if (pVar.w() != 4801587) {
                j9 = -9223372036854775807L;
                j5 = -9223372036854775807L;
            } else {
                pVar.G(3);
                int s8 = pVar.s();
                int i11 = s8 + 10;
                byte[] bArr = pVar.f3699a;
                j5 = -9223372036854775807L;
                if (i11 > bArr.length) {
                    pVar.C(i11);
                    System.arraycopy(bArr, 0, pVar.f3699a, 0, 10);
                }
                jVar.n(pVar.f3699a, 10, s8, false);
                j0 D0 = this.f8150y.D0(pVar.f3699a, s8);
                if (D0 != null) {
                    for (i0 i0Var : D0.f2490i) {
                        if (i0Var instanceof q2.l) {
                            q2.l lVar = (q2.l) i0Var;
                            if ("com.apple.streaming.transportStreamTimestamp".equals(lVar.f8459j)) {
                                System.arraycopy(lVar.f8460k, 0, pVar.f3699a, 0, 8);
                                pVar.F(0);
                                pVar.E(8);
                                j9 = pVar.n() & 8589934591L;
                                break;
                            }
                        }
                    }
                }
                j9 = j5;
            }
            jVar.f2705n = 0;
            b bVar3 = this.f8143r;
            if (bVar3 != null) {
                z2.c cVar = bVar3.f8101d;
                g1.u uVar3 = bVar3.f8100c;
                d1.s sVar = bVar3.f8099b;
                d2.m mVar = bVar3.f8098a;
                d2.m a9 = mVar.a();
                g1.a.k(!((a9 instanceof c0) || (a9 instanceof w2.i)));
                boolean z11 = mVar.a() == mVar;
                String str = "Can't recreate wrapped extractors. Outer type: " + mVar.getClass();
                if (!z11) {
                    m7.c.p(str);
                    return null;
                }
                if (mVar instanceof v) {
                    dVar = new v(sVar.f2546d, uVar3, cVar);
                } else if (mVar instanceof i3.d) {
                    dVar = new i3.d(0);
                } else if (mVar instanceof i3.a) {
                    dVar = new i3.a();
                } else if (mVar instanceof i3.c) {
                    dVar = new i3.c();
                } else {
                    if (!(mVar instanceof v2.d)) {
                        m7.c.p("Unexpected extractor type for recreation: ".concat(mVar.getClass().getSimpleName()));
                        return null;
                    }
                    dVar = new v2.d(0);
                }
                bVar2 = new b(dVar, sVar, uVar3, cVar);
                j11 = j9;
                j10 = j12;
            } else {
                Uri uri = kVar.f4324a;
                Map g9 = hVar.g();
                c cVar2 = (c) this.f8147v;
                cVar2.getClass();
                d1.s sVar2 = this.f9705d;
                int A = com.bumptech.glide.c.A(sVar2.f2554m);
                List list2 = (List) g9.get("Content-Type");
                int A2 = com.bumptech.glide.c.A((list2 == null || list2.isEmpty()) ? null : (String) list2.get(0));
                int B = com.bumptech.glide.c.B(uri);
                ArrayList arrayList2 = new ArrayList(7);
                c.a(A, arrayList2);
                c.a(A2, arrayList2);
                c.a(B, arrayList2);
                int i12 = 0;
                for (int i13 = 7; i12 < i13; i13 = 7) {
                    c.a(c.f8102j[i12], arrayList2);
                    i12++;
                }
                jVar.f2705n = 0;
                int i14 = 0;
                d2.m mVar2 = null;
                while (true) {
                    int size = arrayList2.size();
                    j10 = j12;
                    g1.u uVar4 = this.f8146u;
                    if (i14 >= size) {
                        j11 = j9;
                        mVar2.getClass();
                        bVar = new b(mVar2, sVar2, uVar4, (z2.c) cVar2.f8103i);
                        break;
                    }
                    int intValue = ((Integer) arrayList2.get(i14)).intValue();
                    if (intValue == 0) {
                        i9 = i14;
                        j11 = j9;
                        uVar = uVar4;
                        arrayList = arrayList2;
                        aVar = new i3.a();
                    } else if (intValue == 1) {
                        i9 = i14;
                        j11 = j9;
                        uVar = uVar4;
                        arrayList = arrayList2;
                        aVar = new i3.c();
                    } else if (intValue == 2) {
                        i9 = i14;
                        j11 = j9;
                        uVar = uVar4;
                        arrayList = arrayList2;
                        aVar = new i3.d(0);
                    } else if (intValue != 7) {
                        List list3 = this.f8148w;
                        z2.c cVar3 = z2.c.f10614b;
                        i9 = i14;
                        if (intValue == 8) {
                            uVar = uVar4;
                            arrayList = arrayList2;
                            j0 j0Var = sVar2.f2552k;
                            if (j0Var != null) {
                                j11 = j9;
                                list = list3;
                                int i15 = 0;
                                while (true) {
                                    i0[] i0VarArr = j0Var.f2490i;
                                    if (i15 >= i0VarArr.length) {
                                        break;
                                    }
                                    i0 i0Var2 = i0VarArr[i15];
                                    if (i0Var2 instanceof u) {
                                        z10 = !((u) i0Var2).f8227k.isEmpty();
                                        break;
                                    }
                                    i15++;
                                }
                            } else {
                                j11 = j9;
                                list = list3;
                            }
                            z10 = false;
                            aVar = new w2.i(cVar3, (z10 ? 4 : 0) | 32, uVar, list != null ? list : w0.f1464m);
                        } else if (intValue == 11) {
                            arrayList = arrayList2;
                            if (list3 != null) {
                                i10 = 48;
                            } else {
                                d1.r rVar = new d1.r();
                                rVar.f2528l = l0.k("application/cea-608");
                                list3 = Collections.singletonList(new d1.s(rVar));
                                i10 = 16;
                            }
                            String str2 = sVar2.f2551j;
                            if (!TextUtils.isEmpty(str2)) {
                                int i16 = i10;
                                if (l0.a(str2, "audio/mp4a-latm") == null) {
                                    i16 |= 2;
                                }
                                i10 = l0.a(str2, "video/avc") != null ? i16 : i16 | 4;
                            }
                            c0 c0Var = new c0(2, 1, cVar3, uVar4, new d4.i(i10, list3));
                            uVar = uVar4;
                            j11 = j9;
                            aVar = c0Var;
                        } else if (intValue != 13) {
                            j11 = j9;
                            uVar = uVar4;
                            arrayList = arrayList2;
                            aVar = null;
                        } else {
                            arrayList = arrayList2;
                            j11 = j9;
                            aVar = new v(sVar2.f2546d, uVar4, (z2.c) cVar2.f8103i);
                            uVar = uVar4;
                        }
                    } else {
                        i9 = i14;
                        j11 = j9;
                        uVar = uVar4;
                        arrayList = arrayList2;
                        aVar = new v2.d(0L);
                    }
                    aVar.getClass();
                    try {
                        z9 = aVar.g(jVar);
                        jVar.f2705n = 0;
                    } catch (EOFException unused3) {
                        jVar.f2705n = 0;
                        z9 = false;
                    } catch (Throwable th) {
                        jVar.f2705n = 0;
                        throw th;
                    }
                    if (z9) {
                        bVar = new b(aVar, sVar2, uVar, (z2.c) cVar2.f8103i);
                        break;
                    }
                    if (mVar2 == null && (intValue == A || intValue == A2 || intValue == B || intValue == 11)) {
                        mVar2 = aVar;
                    }
                    i14 = i9 + 1;
                    j9 = j11;
                    j12 = j10;
                    arrayList2 = arrayList;
                }
                bVar2 = bVar;
            }
            this.C = bVar2;
            d2.m a10 = bVar2.f8098a.a();
            boolean z12 = (a10 instanceof i3.d) || (a10 instanceof i3.a) || (a10 instanceof i3.c) || (a10 instanceof v2.d);
            r rVar2 = this.D;
            if (z12) {
                long b9 = j11 != j5 ? uVar2.b(j11) : j10;
                if (rVar2.f8197d0 != b9) {
                    rVar2.f8197d0 = b9;
                    for (q qVar : rVar2.D) {
                        if (qVar.F != b9) {
                            qVar.F = b9;
                            qVar.f9436z = true;
                        }
                    }
                }
            } else if (rVar2.f8197d0 != 0) {
                rVar2.f8197d0 = 0L;
                for (q qVar2 : rVar2.D) {
                    if (qVar2.F != 0) {
                        qVar2.F = 0L;
                        qVar2.f9436z = true;
                    }
                }
            }
            this.D.F.clear();
            this.C.f8098a.d(this.D);
        }
        r rVar3 = this.D;
        d1.n nVar = rVar3.f8198e0;
        d1.n nVar2 = this.f8149x;
        if (!w.a(nVar, nVar2)) {
            rVar3.f8198e0 = nVar2;
            int i17 = 0;
            while (true) {
                q[] qVarArr = rVar3.D;
                if (i17 >= qVarArr.length) {
                    break;
                }
                if (rVar3.W[i17]) {
                    q qVar3 = qVarArr[i17];
                    qVar3.I = nVar2;
                    qVar3.f9436z = true;
                }
                i17++;
            }
        }
        return jVar;
    }
}
