package i3;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import b6.i0;
import d1.m0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 implements d2.m {

    /* renamed from: a, reason: collision with root package name */
    public final int f4429a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4430b;

    /* renamed from: c, reason: collision with root package name */
    public final List f4431c;

    /* renamed from: d, reason: collision with root package name */
    public final g1.p f4432d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseIntArray f4433e;

    /* renamed from: f, reason: collision with root package name */
    public final d4.i f4434f;

    /* renamed from: g, reason: collision with root package name */
    public final z2.c f4435g;
    public final SparseArray h;

    /* renamed from: i, reason: collision with root package name */
    public final SparseBooleanArray f4436i;

    /* renamed from: j, reason: collision with root package name */
    public final SparseBooleanArray f4437j;

    /* renamed from: k, reason: collision with root package name */
    public final w f4438k;

    /* renamed from: l, reason: collision with root package name */
    public h2.a f4439l;

    /* renamed from: m, reason: collision with root package name */
    public d2.o f4440m;

    /* renamed from: n, reason: collision with root package name */
    public int f4441n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4442o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4443p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4444q;

    /* renamed from: r, reason: collision with root package name */
    public f0 f4445r;

    /* renamed from: s, reason: collision with root package name */
    public int f4446s;

    /* renamed from: t, reason: collision with root package name */
    public int f4447t;

    public c0(int i9, int i10, z2.c cVar, g1.u uVar, d4.i iVar) {
        this.f4434f = iVar;
        this.f4429a = i9;
        this.f4430b = i10;
        this.f4435g = cVar;
        if (i9 == 1 || i9 == 2) {
            this.f4431c = Collections.singletonList(uVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f4431c = arrayList;
            arrayList.add(uVar);
        }
        this.f4432d = new g1.p(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f4436i = sparseBooleanArray;
        this.f4437j = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.h = sparseArray;
        this.f4433e = new SparseIntArray();
        this.f4438k = new w(1);
        this.f4440m = d2.o.f2714b;
        this.f4447t = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i11 = 0; i11 < size; i11++) {
            sparseArray.put(sparseArray2.keyAt(i11), (f0) sparseArray2.valueAt(i11));
        }
        sparseArray.put(0, new a0(new a5.d(this)));
        this.f4445r = null;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        h2.a aVar;
        g1.a.k(this.f4429a != 2);
        List list = this.f4431c;
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            g1.u uVar = (g1.u) list.get(i9);
            boolean z8 = uVar.e() == -9223372036854775807L;
            if (!z8) {
                long d9 = uVar.d();
                z8 = (d9 == -9223372036854775807L || d9 == 0 || d9 == j9) ? false : true;
            }
            if (z8) {
                uVar.g(j9);
            }
        }
        if (j9 != 0 && (aVar = this.f4439l) != null) {
            aVar.d(j9);
        }
        this.f4432d.C(0);
        this.f4433e.clear();
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.h;
            if (i10 >= sparseArray.size()) {
                this.f4446s = 0;
                return;
            } else {
                ((f0) sparseArray.valueAt(i10)).a();
                i10++;
            }
        }
    }

    @Override // d2.m
    public final void d(d2.o oVar) {
        if ((this.f4430b & 1) == 0) {
            oVar = new x.c(oVar, this.f4435g);
        }
        this.f4440m = oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        r2 = r2 + 1;
     */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(d2.n r7) {
        /*
            r6 = this;
            g1.p r0 = r6.f4432d
            byte[] r0 = r0.f3699a
            d2.j r7 = (d2.j) r7
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.n(r0, r1, r2, r1)
            r2 = 0
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L29
            r3 = 0
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r2 = r2 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.i(r2)
            r7 = 1
            return r7
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.c0.g(d2.n):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    @Override // d2.m
    public final int h(d2.n nVar, d1.w wVar) {
        d2.n nVar2;
        int i9;
        ?? r12;
        int i10;
        int i11;
        boolean z8;
        int i12;
        long e9 = nVar.e();
        boolean z9 = this.f4442o;
        int i13 = this.f4429a;
        if (z9) {
            long j5 = -9223372036854775807L;
            w wVar2 = this.f4438k;
            if (e9 != -1 && i13 != 2 && !wVar2.f4677d) {
                int i14 = this.f4447t;
                g1.u uVar = wVar2.f4675b;
                g1.p pVar = wVar2.f4676c;
                if (i14 <= 0) {
                    wVar2.a(nVar);
                    return 0;
                }
                if (wVar2.f4679f) {
                    if (wVar2.h == -9223372036854775807L) {
                        wVar2.a(nVar);
                        return 0;
                    }
                    if (wVar2.f4678e) {
                        long j9 = wVar2.f4680g;
                        if (j9 == -9223372036854775807L) {
                            wVar2.a(nVar);
                            return 0;
                        }
                        wVar2.f4681i = uVar.c(wVar2.h) - uVar.b(j9);
                        wVar2.a(nVar);
                        return 0;
                    }
                    int min = (int) Math.min(112800, nVar.e());
                    long j10 = 0;
                    if (nVar.getPosition() != j10) {
                        wVar.f2583a = j10;
                        return 1;
                    }
                    pVar.C(min);
                    nVar.h();
                    nVar.a(0, min, pVar.f3699a);
                    int i15 = pVar.f3700b;
                    int i16 = pVar.f3701c;
                    while (true) {
                        if (i15 >= i16) {
                            break;
                        }
                        if (pVar.f3699a[i15] == 71) {
                            long G = a.a.G(pVar, i15, i14);
                            if (G != -9223372036854775807L) {
                                j5 = G;
                                break;
                            }
                        }
                        i15++;
                    }
                    wVar2.f4680g = j5;
                    wVar2.f4678e = true;
                    return 0;
                }
                long e10 = nVar.e();
                int min2 = (int) Math.min(112800, e10);
                long j11 = e10 - min2;
                if (nVar.getPosition() != j11) {
                    wVar.f2583a = j11;
                    return 1;
                }
                pVar.C(min2);
                nVar.h();
                nVar.a(0, min2, pVar.f3699a);
                int i17 = pVar.f3700b;
                int i18 = pVar.f3701c;
                int i19 = i18 - 188;
                while (true) {
                    if (i19 < i17) {
                        break;
                    }
                    byte[] bArr = pVar.f3699a;
                    int i20 = -4;
                    int i21 = 0;
                    while (true) {
                        if (i20 > 4) {
                            break;
                        }
                        int i22 = (i20 * 188) + i19;
                        if (i22 < i17 || i22 >= i18 || bArr[i22] != 71) {
                            i21 = 0;
                        } else {
                            i21++;
                            if (i21 == 5) {
                                long G2 = a.a.G(pVar, i19, i14);
                                if (G2 != -9223372036854775807L) {
                                    j5 = G2;
                                    break;
                                }
                            }
                        }
                        i20++;
                    }
                    i19--;
                }
                wVar2.h = j5;
                wVar2.f4679f = true;
                return 0;
            }
            if (this.f4443p) {
                i9 = i13;
                z8 = false;
                i12 = 1;
            } else {
                this.f4443p = true;
                long j12 = wVar2.f4681i;
                if (j12 != -9223372036854775807L) {
                    i12 = 1;
                    i9 = i13;
                    z8 = false;
                    h2.a aVar = new h2.a(new u5.e(26), new i0(this.f4447t, wVar2.f4675b), j12, j12 + 1, 0L, e9, 188L, 940);
                    this.f4439l = aVar;
                    this.f4440m.t(aVar.f3895a);
                } else {
                    i9 = i13;
                    z8 = false;
                    i12 = 1;
                    this.f4440m.t(new d2.p(j12));
                }
            }
            if (this.f4444q) {
                this.f4444q = z8;
                c(0L, 0L);
                if (nVar.getPosition() != 0) {
                    wVar.f2583a = 0L;
                    return i12;
                }
            }
            h2.a aVar2 = this.f4439l;
            if (aVar2 != null && aVar2.f3897c != null) {
                return aVar2.b(nVar, wVar);
            }
            nVar2 = nVar;
            r12 = z8;
        } else {
            nVar2 = nVar;
            i9 = i13;
            r12 = 0;
        }
        g1.p pVar2 = this.f4432d;
        byte[] bArr2 = pVar2.f3699a;
        if (9400 - pVar2.f3700b < 188) {
            int a9 = pVar2.a();
            if (a9 > 0) {
                System.arraycopy(bArr2, pVar2.f3700b, bArr2, r12, a9);
            }
            pVar2.D(bArr2, a9);
        }
        while (pVar2.a() < 188) {
            int i23 = pVar2.f3701c;
            int read = nVar2.read(bArr2, i23, 9400 - i23);
            if (read == -1) {
                return -1;
            }
            pVar2.E(i23 + read);
        }
        int i24 = pVar2.f3700b;
        int i25 = pVar2.f3701c;
        byte[] bArr3 = pVar2.f3699a;
        int i26 = i24;
        while (i26 < i25 && bArr3[i26] != 71) {
            i26++;
        }
        pVar2.F(i26);
        int i27 = i26 + 188;
        if (i27 > i25) {
            int i28 = (i26 - i24) + this.f4446s;
            this.f4446s = i28;
            i10 = i9;
            i11 = 2;
            if (i10 == 2 && i28 > 376) {
                throw m0.a(null, "Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            i10 = i9;
            i11 = 2;
            this.f4446s = r12;
        }
        int i29 = pVar2.f3701c;
        if (i27 > i29) {
            return r12;
        }
        int g9 = pVar2.g();
        if ((8388608 & g9) != 0) {
            pVar2.F(i27);
            return r12;
        }
        int i30 = (4194304 & g9) != 0 ? 1 : 0;
        int i31 = (2096896 & g9) >> 8;
        boolean z10 = (g9 & 32) != 0;
        f0 f0Var = (g9 & 16) != 0 ? (f0) this.h.get(i31) : null;
        if (f0Var == null) {
            pVar2.F(i27);
            return r12;
        }
        if (i10 != i11) {
            int i32 = g9 & 15;
            SparseIntArray sparseIntArray = this.f4433e;
            int i33 = sparseIntArray.get(i31, i32 - 1);
            sparseIntArray.put(i31, i32);
            if (i33 == i32) {
                pVar2.F(i27);
                return r12;
            }
            if (i32 != ((i33 + 1) & 15)) {
                f0Var.a();
            }
        }
        if (z10) {
            int t8 = pVar2.t();
            i30 |= (pVar2.t() & 64) != 0 ? 2 : 0;
            pVar2.G(t8 - 1);
        }
        boolean z11 = this.f4442o;
        if (i10 == i11 || z11 || !this.f4437j.get(i31, r12)) {
            pVar2.E(i27);
            f0Var.b(i30, pVar2);
            pVar2.E(i29);
        }
        if (i10 != i11 && !z11 && this.f4442o && e9 != -1) {
            this.f4444q = true;
        }
        pVar2.F(i27);
        return r12;
    }

    @Override // d2.m
    public final d2.m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
