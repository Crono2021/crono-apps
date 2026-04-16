package p1;

import android.net.Uri;
import android.util.Pair;
import b6.e0;
import b6.g0;
import b6.w0;
import d1.z0;
import g1.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m1.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final j f8116a;

    /* renamed from: b, reason: collision with root package name */
    public final i1.h f8117b;

    /* renamed from: c, reason: collision with root package name */
    public final i1.h f8118c;

    /* renamed from: d, reason: collision with root package name */
    public final c f8119d;

    /* renamed from: e, reason: collision with root package name */
    public final Uri[] f8120e;

    /* renamed from: f, reason: collision with root package name */
    public final d1.s[] f8121f;

    /* renamed from: g, reason: collision with root package name */
    public final q1.c f8122g;
    public final z0 h;

    /* renamed from: i, reason: collision with root package name */
    public final List f8123i;

    /* renamed from: k, reason: collision with root package name */
    public final x f8125k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8126l;

    /* renamed from: n, reason: collision with root package name */
    public v1.b f8128n;

    /* renamed from: o, reason: collision with root package name */
    public Uri f8129o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8130p;

    /* renamed from: q, reason: collision with root package name */
    public y1.q f8131q;

    /* renamed from: s, reason: collision with root package name */
    public boolean f8133s;

    /* renamed from: j, reason: collision with root package name */
    public final c f8124j = new c(2);

    /* renamed from: m, reason: collision with root package name */
    public byte[] f8127m = w.f3718f;

    /* renamed from: r, reason: collision with root package name */
    public long f8132r = -9223372036854775807L;

    public i(j jVar, q1.c cVar, Uri[] uriArr, d1.s[] sVarArr, c cVar2, z1.f fVar, c cVar3, List list, x xVar) {
        this.f8116a = jVar;
        this.f8122g = cVar;
        this.f8120e = uriArr;
        this.f8121f = sVarArr;
        this.f8119d = cVar3;
        this.f8123i = list;
        this.f8125k = xVar;
        i1.h a9 = ((i1.g) cVar2.f8103i).a();
        this.f8117b = a9;
        if (fVar != null) {
            a9.k(fVar);
        }
        this.f8118c = ((i1.g) cVar2.f8103i).a();
        this.h = new z0("", sVarArr);
        ArrayList arrayList = new ArrayList();
        int i9 = 0;
        for (int i10 = 0; i10 < uriArr.length; i10++) {
            if ((sVarArr[i10].f2548f & 16384) == 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        z0 z0Var = this.h;
        int[] T = a.a.T(arrayList);
        g gVar = new g(z0Var, T);
        d1.s sVar = z0Var.f2619d[T[0]];
        while (true) {
            if (i9 >= gVar.f10407b) {
                i9 = -1;
                break;
            } else if (gVar.f10409d[i9] == sVar) {
                break;
            } else {
                i9++;
            }
        }
        gVar.f8111g = i9;
        this.f8131q = gVar;
    }

    public final w1.b[] a(k kVar, long j5) {
        List list;
        i iVar = this;
        k kVar2 = kVar;
        int a9 = kVar2 == null ? -1 : iVar.h.a(kVar2.f9705d);
        int length = iVar.f8131q.length();
        w1.b[] bVarArr = new w1.b[length];
        boolean z8 = false;
        int i9 = 0;
        while (i9 < length) {
            int e9 = iVar.f8131q.e(i9);
            Uri uri = iVar.f8120e[e9];
            q1.c cVar = iVar.f8122g;
            if (cVar.c(uri)) {
                q1.i a10 = cVar.a(uri, z8);
                a10.getClass();
                long j9 = a10.h - cVar.f8333v;
                Pair c9 = iVar.c(kVar2, e9 != a9, a10, j9, j5);
                long longValue = ((Long) c9.first).longValue();
                int intValue = ((Integer) c9.second).intValue();
                long j10 = a10.f8363k;
                g0 g0Var = a10.f8371s;
                g0 g0Var2 = a10.f8370r;
                int i10 = (int) (longValue - j10);
                if (i10 < 0 || g0Var2.size() < i10) {
                    e0 e0Var = g0.f1391j;
                    list = w0.f1464m;
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (i10 < g0Var2.size()) {
                        if (intValue != -1) {
                            q1.f fVar = (q1.f) g0Var2.get(i10);
                            if (intValue == 0) {
                                arrayList.add(fVar);
                            } else if (intValue < fVar.f8340u.size()) {
                                g0 g0Var3 = fVar.f8340u;
                                arrayList.addAll(g0Var3.subList(intValue, g0Var3.size()));
                            }
                            i10++;
                        }
                        arrayList.addAll(g0Var2.subList(i10, g0Var2.size()));
                        intValue = 0;
                    }
                    if (a10.f8366n != -9223372036854775807L) {
                        if (intValue == -1) {
                            intValue = 0;
                        }
                        if (intValue < g0Var.size()) {
                            arrayList.addAll(g0Var.subList(intValue, g0Var.size()));
                        }
                    }
                    list = Collections.unmodifiableList(arrayList);
                }
                bVarArr[i9] = new f(j9, list);
            } else {
                bVarArr[i9] = w1.b.f9710g;
            }
            i9++;
            iVar = this;
            kVar2 = kVar;
            z8 = false;
        }
        return bVarArr;
    }

    public final int b(k kVar) {
        int i9 = kVar.f8140o;
        if (i9 == -1) {
            return 1;
        }
        q1.i a9 = this.f8122g.a(this.f8120e[this.h.a(kVar.f9705d)], false);
        a9.getClass();
        g0 g0Var = a9.f8370r;
        int i10 = (int) (kVar.f8135j - a9.f8363k);
        if (i10 < 0) {
            return 1;
        }
        g0 g0Var2 = i10 < g0Var.size() ? ((q1.f) g0Var.get(i10)).f8340u : a9.f8371s;
        if (i9 >= g0Var2.size()) {
            return 2;
        }
        q1.d dVar = (q1.d) g0Var2.get(i9);
        if (dVar.f8335u) {
            return 0;
        }
        return w.a(Uri.parse(g1.a.A(a9.f8392a, dVar.f8341i)), kVar.f9703b.f4324a) ? 1 : 2;
    }

    public final Pair c(k kVar, boolean z8, q1.i iVar, long j5, long j9) {
        int i9;
        boolean z9 = true;
        if (kVar != null) {
            long j10 = kVar.f8135j;
            int i10 = kVar.f8140o;
            if (!z8) {
                if (!kVar.H) {
                    return new Pair(Long.valueOf(j10), Integer.valueOf(i10));
                }
                if (i10 == -1) {
                    j10 = j10 != -1 ? j10 + 1 : -1L;
                }
                return new Pair(Long.valueOf(j10), Integer.valueOf(i10 != -1 ? i10 + 1 : -1));
            }
        }
        long j11 = iVar.f8373u;
        g0 g0Var = iVar.f8371s;
        long j12 = iVar.f8363k;
        g0 g0Var2 = iVar.f8370r;
        long j13 = j5 + j11;
        long j14 = (kVar == null || this.f8130p) ? j9 : kVar.f9708g;
        if (!iVar.f8367o && j14 >= j13) {
            return new Pair(Long.valueOf(j12 + g0Var2.size()), -1);
        }
        long j15 = j14 - j5;
        Long valueOf = Long.valueOf(j15);
        int i11 = 0;
        if (this.f8122g.f8332u && kVar != null) {
            z9 = false;
        }
        int d9 = w.d(g0Var2, valueOf, z9);
        long j16 = d9 + j12;
        if (d9 >= 0) {
            q1.f fVar = (q1.f) g0Var2.get(d9);
            g0 g0Var3 = j15 < fVar.f8345m + fVar.f8343k ? fVar.f8340u : g0Var;
            while (true) {
                if (i11 >= g0Var3.size()) {
                    break;
                }
                q1.d dVar = (q1.d) g0Var3.get(i11);
                if (j15 >= dVar.f8345m + dVar.f8343k) {
                    i11++;
                } else if (dVar.f8334t) {
                    j16 += g0Var3 == g0Var ? 1L : 0L;
                    i9 = i11;
                }
            }
        }
        i9 = -1;
        return new Pair(Long.valueOf(j16), Integer.valueOf(i9));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e d(Uri uri, int i9, boolean z8) {
        if (uri == null) {
            return null;
        }
        c cVar = this.f8124j;
        byte[] bArr = (byte[]) ((d) cVar.f8103i).remove(uri);
        if (bArr != null) {
            return null;
        }
        i1.k kVar = new i1.k(uri, 1, null, Collections.EMPTY_MAP, 0L, -1L, 1);
        d1.s sVar = this.f8121f[i9];
        int l4 = this.f8131q.l();
        Object p5 = this.f8131q.p();
        byte[] bArr2 = this.f8127m;
        e eVar = new e(this.f8118c, kVar, 3, sVar, l4, p5, -9223372036854775807L, -9223372036854775807L);
        if (bArr2 == null) {
            bArr2 = w.f3718f;
        }
        eVar.f8104j = bArr2;
        return eVar;
    }
}
