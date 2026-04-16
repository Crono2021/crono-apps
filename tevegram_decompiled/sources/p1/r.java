package p1;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import b6.g0;
import d1.j0;
import d1.l0;
import d1.z0;
import d2.d0;
import d2.y;
import g1.w;
import i7.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l1.i0;
import v1.c1;
import v1.q0;
import v1.r0;
import v1.t0;
import v1.x0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r implements z1.k, z1.n, x0, d2.o, t0 {

    /* renamed from: g0, reason: collision with root package name */
    public static final Set f8193g0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public final ArrayList A;
    public final Map B;
    public w1.a C;
    public q[] D;
    public int[] E;
    public final HashSet F;
    public final SparseIntArray G;
    public p H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public int M;
    public d1.s N;
    public d1.s O;
    public boolean P;
    public c1 Q;
    public Set R;
    public int[] S;
    public int T;
    public boolean U;
    public boolean[] V;
    public boolean[] W;
    public long X;
    public long Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f8194a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f8195b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f8196c0;

    /* renamed from: d0, reason: collision with root package name */
    public long f8197d0;

    /* renamed from: e0, reason: collision with root package name */
    public d1.n f8198e0;

    /* renamed from: f0, reason: collision with root package name */
    public k f8199f0;

    /* renamed from: i, reason: collision with root package name */
    public final String f8200i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8201j;

    /* renamed from: k, reason: collision with root package name */
    public final c f8202k;

    /* renamed from: l, reason: collision with root package name */
    public final i f8203l;

    /* renamed from: m, reason: collision with root package name */
    public final z1.d f8204m;

    /* renamed from: n, reason: collision with root package name */
    public final d1.s f8205n;

    /* renamed from: o, reason: collision with root package name */
    public final o1.g f8206o;

    /* renamed from: p, reason: collision with root package name */
    public final o1.d f8207p;

    /* renamed from: q, reason: collision with root package name */
    public final z1.g f8208q;

    /* renamed from: r, reason: collision with root package name */
    public final z1.p f8209r = new z1.p("Loader:HlsSampleStreamWrapper");

    /* renamed from: s, reason: collision with root package name */
    public final o1.d f8210s;

    /* renamed from: t, reason: collision with root package name */
    public final int f8211t;

    /* renamed from: u, reason: collision with root package name */
    public final com.bumptech.glide.manager.s f8212u;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f8213v;

    /* renamed from: w, reason: collision with root package name */
    public final List f8214w;

    /* renamed from: x, reason: collision with root package name */
    public final o f8215x;

    /* renamed from: y, reason: collision with root package name */
    public final o f8216y;

    /* renamed from: z, reason: collision with root package name */
    public final Handler f8217z;

    /* JADX WARN: Type inference failed for: r1v12, types: [p1.o] */
    /* JADX WARN: Type inference failed for: r1v13, types: [p1.o] */
    public r(String str, int i9, c cVar, i iVar, Map map, z1.d dVar, long j5, d1.s sVar, o1.g gVar, o1.d dVar2, z1.g gVar2, o1.d dVar3, int i10) {
        this.f8200i = str;
        this.f8201j = i9;
        this.f8202k = cVar;
        this.f8203l = iVar;
        this.B = map;
        this.f8204m = dVar;
        this.f8205n = sVar;
        this.f8206o = gVar;
        this.f8207p = dVar2;
        this.f8208q = gVar2;
        this.f8210s = dVar3;
        this.f8211t = i10;
        final int i11 = 0;
        com.bumptech.glide.manager.s sVar2 = new com.bumptech.glide.manager.s(5, (byte) 0);
        sVar2.f1858k = null;
        sVar2.f1857j = false;
        sVar2.f1859l = null;
        this.f8212u = sVar2;
        this.E = new int[0];
        Set set = f8193g0;
        this.F = new HashSet(set.size());
        this.G = new SparseIntArray(set.size());
        this.D = new q[0];
        this.W = new boolean[0];
        this.V = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.f8213v = arrayList;
        this.f8214w = Collections.unmodifiableList(arrayList);
        this.A = new ArrayList();
        this.f8215x = new Runnable(this) { // from class: p1.o

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ r f8185j;

            {
                this.f8185j = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i11) {
                    case 0:
                        this.f8185j.D();
                        break;
                    default:
                        r rVar = this.f8185j;
                        rVar.K = true;
                        rVar.D();
                        break;
                }
            }
        };
        final int i12 = 1;
        this.f8216y = new Runnable(this) { // from class: p1.o

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ r f8185j;

            {
                this.f8185j = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i12) {
                    case 0:
                        this.f8185j.D();
                        break;
                    default:
                        r rVar = this.f8185j;
                        rVar.K = true;
                        rVar.D();
                        break;
                }
            }
        };
        this.f8217z = w.l(null);
        this.X = j5;
        this.Y = j5;
    }

    public static int B(int i9) {
        if (i9 == 1) {
            return 2;
        }
        if (i9 != 2) {
            return i9 != 3 ? 0 : 1;
        }
        return 3;
    }

    public static d2.l w(int i9, int i10) {
        g1.a.D("HlsSampleStreamWrapper", "Unmapped track with id " + i9 + " of type " + i10);
        return new d2.l();
    }

    public static d1.s y(d1.s sVar, d1.s sVar2, boolean z8) {
        String a9;
        if (sVar == null) {
            return sVar2;
        }
        String str = sVar.f2551j;
        String str2 = sVar2.f2554m;
        int g9 = l0.g(str2);
        if (w.q(g9, str) == 1) {
            a9 = w.r(g9, str);
            str2 = l0.c(a9);
        } else {
            a9 = l0.a(str, str2);
        }
        d1.r a10 = sVar2.a();
        a10.f2518a = sVar.f2543a;
        a10.f2519b = sVar.f2544b;
        a10.f2520c = g0.m(sVar.f2545c);
        a10.f2521d = sVar.f2546d;
        a10.f2522e = sVar.f2547e;
        a10.f2523f = sVar.f2548f;
        a10.f2524g = z8 ? sVar.f2549g : -1;
        a10.h = z8 ? sVar.h : -1;
        a10.f2525i = a9;
        if (g9 == 2) {
            a10.f2533q = sVar.f2559r;
            a10.f2534r = sVar.f2560s;
            a10.f2535s = sVar.f2561t;
        }
        if (str2 != null) {
            a10.f2528l = l0.k(str2);
        }
        int i9 = sVar.f2567z;
        if (i9 != -1 && g9 == 1) {
            a10.f2541y = i9;
        }
        j0 j0Var = sVar.f2552k;
        if (j0Var != null) {
            j0 j0Var2 = sVar2.f2552k;
            if (j0Var2 != null) {
                j0Var = j0Var2.e(j0Var);
            }
            a10.f2526j = j0Var;
        }
        return new d1.s(a10);
    }

    public final k A() {
        return (k) this.f8213v.get(r0.size() - 1);
    }

    public final boolean C() {
        return this.Y != -9223372036854775807L;
    }

    public final void D() {
        if (!this.P && this.S == null && this.K) {
            int i9 = 0;
            for (q qVar : this.D) {
                if (qVar.t() == null) {
                    return;
                }
            }
            c1 c1Var = this.Q;
            if (c1Var != null) {
                int i10 = c1Var.f9256a;
                int[] iArr = new int[i10];
                this.S = iArr;
                Arrays.fill(iArr, -1);
                for (int i11 = 0; i11 < i10; i11++) {
                    int i12 = 0;
                    while (true) {
                        q[] qVarArr = this.D;
                        if (i12 < qVarArr.length) {
                            d1.s t8 = qVarArr[i12].t();
                            g1.a.l(t8);
                            d1.s sVar = this.Q.a(i11).f2619d[0];
                            String str = t8.f2554m;
                            String str2 = sVar.f2554m;
                            int g9 = l0.g(str);
                            if (g9 == 3) {
                                if (w.a(str, str2)) {
                                    if ((!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) || t8.E == sVar.E) {
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                                i12++;
                            } else if (g9 == l0.g(str2)) {
                                break;
                            } else {
                                i12++;
                            }
                        }
                    }
                    this.S[i11] = i12;
                }
                ArrayList arrayList = this.A;
                int size = arrayList.size();
                while (i9 < size) {
                    Object obj = arrayList.get(i9);
                    i9++;
                    ((n) obj).a();
                }
                return;
            }
            int length = this.D.length;
            int i13 = 0;
            int i14 = -2;
            int i15 = -1;
            while (true) {
                int i16 = 1;
                if (i13 >= length) {
                    break;
                }
                d1.s t9 = this.D[i13].t();
                g1.a.l(t9);
                String str3 = t9.f2554m;
                if (l0.j(str3)) {
                    i16 = 2;
                } else if (!l0.h(str3)) {
                    i16 = l0.i(str3) ? 3 : -2;
                }
                if (B(i16) > B(i14)) {
                    i15 = i13;
                    i14 = i16;
                } else if (i16 == i14 && i15 != -1) {
                    i15 = -1;
                }
                i13++;
            }
            z0 z0Var = this.f8203l.h;
            int i17 = z0Var.f2616a;
            this.T = -1;
            this.S = new int[length];
            for (int i18 = 0; i18 < length; i18++) {
                this.S[i18] = i18;
            }
            z0[] z0VarArr = new z0[length];
            int i19 = 0;
            while (i19 < length) {
                d1.s t10 = this.D[i19].t();
                g1.a.l(t10);
                String str4 = this.f8200i;
                d1.s sVar2 = this.f8205n;
                if (i19 == i15) {
                    d1.s[] sVarArr = new d1.s[i17];
                    for (int i20 = 0; i20 < i17; i20++) {
                        d1.s sVar3 = z0Var.f2619d[i20];
                        if (i14 == 1 && sVar2 != null) {
                            sVar3 = sVar3.d(sVar2);
                        }
                        sVarArr[i20] = i17 == 1 ? t10.d(sVar3) : y(sVar3, t10, true);
                    }
                    z0VarArr[i19] = new z0(str4, sVarArr);
                    this.T = i19;
                } else {
                    if (i14 != 2 || !l0.h(t10.f2554m)) {
                        sVar2 = null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(":muxed:");
                    sb.append(i19 < i15 ? i19 : i19 - 1);
                    z0VarArr[i19] = new z0(sb.toString(), y(sVar2, t10, false));
                }
                i19++;
            }
            this.Q = x(z0VarArr);
            g1.a.k(this.R == null);
            this.R = Collections.EMPTY_SET;
            this.L = true;
            this.f8202k.b();
        }
    }

    public final void E() {
        z1.p pVar = this.f8209r;
        IOException iOException = pVar.f10589c;
        if (iOException != null) {
            throw iOException;
        }
        z1.l lVar = pVar.f10588b;
        if (lVar != null) {
            int i9 = lVar.f10574i;
            IOException iOException2 = lVar.f10578m;
            if (iOException2 != null && lVar.f10579n > i9) {
                throw iOException2;
            }
        }
        i iVar = this.f8203l;
        v1.b bVar = iVar.f8128n;
        if (bVar != null) {
            throw bVar;
        }
        Uri uri = iVar.f8129o;
        if (uri == null || !iVar.f8133s) {
            return;
        }
        q1.b bVar2 = (q1.b) iVar.f8122g.f8323l.get(uri);
        z1.p pVar2 = bVar2.f8309j;
        IOException iOException3 = pVar2.f10589c;
        if (iOException3 != null) {
            throw iOException3;
        }
        z1.l lVar2 = pVar2.f10588b;
        if (lVar2 != null) {
            int i10 = lVar2.f10574i;
            IOException iOException4 = lVar2.f10578m;
            if (iOException4 != null && lVar2.f10579n > i10) {
                throw iOException4;
            }
        }
        IOException iOException5 = bVar2.f8317r;
        if (iOException5 != null) {
            throw iOException5;
        }
    }

    public final void F(z0[] z0VarArr, int... iArr) {
        this.Q = x(z0VarArr);
        this.R = new HashSet();
        for (int i9 : iArr) {
            this.R.add(this.Q.a(i9));
        }
        this.T = 0;
        this.f8217z.post(new a7.a(this.f8202k, 20));
        this.L = true;
    }

    public final void G() {
        for (q qVar : this.D) {
            qVar.z(this.Z);
        }
        this.Z = false;
    }

    public final boolean H(long j5, boolean z8) {
        k kVar;
        boolean z9;
        this.X = j5;
        if (C()) {
            this.Y = j5;
            return true;
        }
        boolean z10 = this.f8203l.f8130p;
        ArrayList arrayList = this.f8213v;
        if (z10) {
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                kVar = (k) arrayList.get(i9);
                if (kVar.f9708g == j5) {
                    break;
                }
            }
        }
        kVar = null;
        if (this.K && !z8) {
            int length = this.D.length;
            for (int i10 = 0; i10 < length; i10++) {
                q qVar = this.D[i10];
                if (!(kVar != null ? qVar.B(kVar.e(i10)) : qVar.C(j5, false)) && (this.W[i10] || !this.U)) {
                    z9 = false;
                    break;
                }
            }
            z9 = true;
            if (z9) {
                return false;
            }
        }
        this.Y = j5;
        this.f8195b0 = false;
        arrayList.clear();
        z1.p pVar = this.f8209r;
        if (!pVar.b()) {
            pVar.f10589c = null;
            G();
            return true;
        }
        if (this.K) {
            for (q qVar2 : this.D) {
                qVar2.j();
            }
        }
        pVar.a();
        return true;
    }

    @Override // v1.x0
    public final boolean a() {
        return this.f8209r.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0499  */
    @Override // v1.x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(l1.j0 r62) {
        /*
            Method dump skipped, instructions count: 1381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.r.b(l1.j0):boolean");
    }

    @Override // d2.o
    public final void c() {
        this.f8196c0 = true;
        this.f8217z.post(this.f8216y);
    }

    @Override // z1.n
    public final void d() {
        for (q qVar : this.D) {
            qVar.z(true);
            x xVar = qVar.h;
            if (xVar != null) {
                xVar.K(qVar.f9416e);
                qVar.h = null;
                qVar.f9418g = null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // z1.k
    public final void e(z1.m mVar, long j5, long j9) {
        w1.a aVar = (w1.a) mVar;
        this.C = null;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            byte[] bArr = eVar.f8104j;
            i iVar = this.f8203l;
            iVar.f8127m = bArr;
            c cVar = iVar.f8124j;
            Uri uri = eVar.f9703b.f4324a;
            byte[] bArr2 = eVar.f8106l;
            bArr2.getClass();
            d dVar = (d) cVar.f8103i;
            uri.getClass();
        }
        long j10 = aVar.f9702a;
        Uri uri2 = aVar.f9709i.f4289k;
        v1.q qVar = new v1.q(j9);
        this.f8208q.onLoadTaskConcluded(j10);
        this.f8210s.d(qVar, aVar.f9704c, this.f8201j, aVar.f9705d, aVar.f9706e, aVar.f9707f, aVar.f9708g, aVar.h);
        if (this.L) {
            this.f8202k.d(this);
            return;
        }
        i0 i0Var = new i0();
        i0Var.f5920a = this.X;
        b(new l1.j0(i0Var));
    }

    @Override // v1.x0
    public final long f() {
        if (C()) {
            return this.Y;
        }
        if (this.f8195b0) {
            return Long.MIN_VALUE;
        }
        return A().h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [p1.q[]] */
    /* JADX WARN: Type inference failed for: r1v1, types: [p1.q[]] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [d2.d0] */
    /* JADX WARN: Type inference failed for: r5v4, types: [p1.q, v1.u0] */
    /* JADX WARN: Type inference failed for: r5v6, types: [d2.l] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // d2.o
    public final d0 l(int i9, int i10) {
        Integer valueOf = Integer.valueOf(i10);
        Set set = f8193g0;
        boolean contains = set.contains(valueOf);
        HashSet hashSet = this.F;
        SparseIntArray sparseIntArray = this.G;
        ?? r52 = 0;
        r52 = 0;
        if (contains) {
            g1.a.f(set.contains(Integer.valueOf(i10)));
            int i11 = sparseIntArray.get(i10, -1);
            if (i11 != -1) {
                if (hashSet.add(Integer.valueOf(i10))) {
                    this.E[i11] = i9;
                }
                r52 = this.E[i11] == i9 ? this.D[i11] : w(i9, i10);
            }
        } else {
            int i12 = 0;
            while (true) {
                ?? r12 = this.D;
                if (i12 >= r12.length) {
                    break;
                }
                if (this.E[i12] == i9) {
                    r52 = r12[i12];
                    break;
                }
                i12++;
            }
        }
        if (r52 == 0) {
            if (this.f8196c0) {
                return w(i9, i10);
            }
            int length = this.D.length;
            boolean z8 = i10 == 1 || i10 == 2;
            r52 = new q(this.f8204m, this.f8206o, this.f8207p, this.B);
            r52.f9430t = this.X;
            if (z8) {
                r52.I = this.f8198e0;
                r52.f9436z = true;
            }
            long j5 = this.f8197d0;
            if (r52.F != j5) {
                r52.F = j5;
                r52.f9436z = true;
            }
            if (this.f8199f0 != null) {
                r52.C = r6.f8136k;
            }
            r52.f9417f = this;
            int i13 = length + 1;
            int[] copyOf = Arrays.copyOf(this.E, i13);
            this.E = copyOf;
            copyOf[length] = i9;
            q[] qVarArr = this.D;
            int i14 = w.f3713a;
            ?? copyOf2 = Arrays.copyOf(qVarArr, qVarArr.length + 1);
            copyOf2[qVarArr.length] = r52;
            this.D = (q[]) copyOf2;
            boolean[] copyOf3 = Arrays.copyOf(this.W, i13);
            this.W = copyOf3;
            copyOf3[length] = z8;
            this.U |= z8;
            hashSet.add(Integer.valueOf(i10));
            sparseIntArray.append(i10, length);
            if (B(i10) > B(this.I)) {
                this.J = length;
                this.I = i10;
            }
            this.V = Arrays.copyOf(this.V, i13);
        }
        if (i10 != 5) {
            return r52;
        }
        if (this.H == null) {
            this.H = new p(r52, this.f8211t);
        }
        return this.H;
    }

    @Override // v1.x0
    public final long m() {
        if (this.f8195b0) {
            return Long.MIN_VALUE;
        }
        if (C()) {
            return this.Y;
        }
        long j5 = this.X;
        k A = A();
        if (!A.H) {
            ArrayList arrayList = this.f8213v;
            A = arrayList.size() > 1 ? (k) arrayList.get(arrayList.size() - 2) : null;
        }
        if (A != null) {
            j5 = Math.max(j5, A.h);
        }
        if (this.K) {
            for (q qVar : this.D) {
                j5 = Math.max(j5, qVar.n());
            }
        }
        return j5;
    }

    @Override // v1.t0
    public final void o() {
        this.f8217z.post(this.f8215x);
    }

    @Override // z1.k
    public final j3.f p(z1.m mVar, long j5, long j9, IOException iOException, int i9) {
        boolean z8;
        j3.f fVar;
        int i10;
        w1.a aVar = (w1.a) mVar;
        boolean z9 = aVar instanceof k;
        if (z9 && !((k) aVar).K && (iOException instanceof i1.w) && ((i10 = ((i1.w) iOException).f4364k) == 410 || i10 == 404)) {
            return z1.p.f10584d;
        }
        long j10 = aVar.f9709i.f4288j;
        Uri uri = aVar.f9709i.f4289k;
        v1.q qVar = new v1.q(j9);
        w.W(aVar.f9708g);
        w.W(aVar.h);
        z1.j jVar = new z1.j(iOException, i9);
        i iVar = this.f8203l;
        z1.h o8 = com.bumptech.glide.c.o(iVar.f8131q);
        z1.g gVar = this.f8208q;
        z1.i fallbackSelectionFor = gVar.getFallbackSelectionFor(o8, jVar);
        if (fallbackSelectionFor == null || fallbackSelectionFor.f10570a != 2) {
            z8 = false;
        } else {
            long j11 = fallbackSelectionFor.f10571b;
            y1.q qVar2 = iVar.f8131q;
            z8 = qVar2.n(qVar2.t(iVar.h.a(aVar.f9705d)), j11);
        }
        if (z8) {
            if (z9 && j10 == 0) {
                ArrayList arrayList = this.f8213v;
                g1.a.k(((k) arrayList.remove(arrayList.size() - 1)) == aVar);
                if (arrayList.isEmpty()) {
                    this.Y = this.X;
                } else {
                    ((k) b6.q.g(arrayList)).J = true;
                }
            }
            fVar = z1.p.f10585e;
        } else {
            long retryDelayMsFor = gVar.getRetryDelayMsFor(jVar);
            fVar = retryDelayMsFor != -9223372036854775807L ? new j3.f(0, retryDelayMsFor) : z1.p.f10586f;
        }
        int i11 = fVar.f5420a;
        boolean z10 = i11 == 0 || i11 == 1;
        j3.f fVar2 = fVar;
        this.f8210s.f(qVar, aVar.f9704c, this.f8201j, aVar.f9705d, aVar.f9706e, aVar.f9707f, aVar.f9708g, aVar.h, iOException, !z10);
        if (!z10) {
            this.C = null;
            gVar.onLoadTaskConcluded(aVar.f9702a);
        }
        if (z8) {
            if (!this.L) {
                i0 i0Var = new i0();
                i0Var.f5920a = this.X;
                b(new l1.j0(i0Var));
                return fVar2;
            }
            this.f8202k.d(this);
        }
        return fVar2;
    }

    @Override // z1.k
    public final void q(z1.m mVar, long j5, long j9, boolean z8) {
        w1.a aVar = (w1.a) mVar;
        this.C = null;
        long j10 = aVar.f9702a;
        Uri uri = aVar.f9709i.f4289k;
        v1.q qVar = new v1.q(j9);
        this.f8208q.onLoadTaskConcluded(j10);
        this.f8210s.b(qVar, aVar.f9704c, this.f8201j, aVar.f9705d, aVar.f9706e, aVar.f9707f, aVar.f9708g, aVar.h);
        if (z8) {
            return;
        }
        if (C() || this.M == 0) {
            G();
        }
        if (this.M > 0) {
            this.f8202k.d(this);
        }
    }

    @Override // v1.x0
    public final void u(long j5) {
        z1.p pVar = this.f8209r;
        if (pVar.f10589c == null && !C()) {
            boolean b9 = pVar.b();
            i iVar = this.f8203l;
            List list = this.f8214w;
            if (b9) {
                this.C.getClass();
                if (iVar.f8128n != null ? false : iVar.f8131q.r(j5, this.C, list)) {
                    pVar.a();
                    return;
                }
                return;
            }
            int size = list.size();
            while (size > 0 && iVar.b((k) list.get(size - 1)) == 2) {
                size--;
            }
            if (size < list.size()) {
                z(size);
            }
            int size2 = (iVar.f8128n != null || iVar.f8131q.length() < 2) ? list.size() : iVar.f8131q.f(j5, list);
            if (size2 < this.f8213v.size()) {
                z(size2);
            }
        }
    }

    public final void v() {
        g1.a.k(this.L);
        this.Q.getClass();
        this.R.getClass();
    }

    public final c1 x(z0[] z0VarArr) {
        for (int i9 = 0; i9 < z0VarArr.length; i9++) {
            z0 z0Var = z0VarArr[i9];
            d1.s[] sVarArr = new d1.s[z0Var.f2616a];
            for (int i10 = 0; i10 < z0Var.f2616a; i10++) {
                d1.s sVar = z0Var.f2619d[i10];
                int j5 = this.f8206o.j(sVar);
                d1.r a9 = sVar.a();
                a9.H = j5;
                sVarArr[i10] = new d1.s(a9);
            }
            z0VarArr[i9] = new z0(z0Var.f2617b, sVarArr);
        }
        return new c1(z0VarArr);
    }

    public final void z(int i9) {
        ArrayList arrayList;
        long j5;
        q0 q0Var;
        g1.a.k(!this.f8209r.b());
        int i10 = i9;
        loop0: while (true) {
            arrayList = this.f8213v;
            if (i10 >= arrayList.size()) {
                i10 = -1;
                break;
            }
            int i11 = i10;
            while (true) {
                if (i11 >= arrayList.size()) {
                    k kVar = (k) arrayList.get(i10);
                    for (int i12 = 0; i12 < this.D.length; i12++) {
                        if (this.D[i12].q() > kVar.e(i12)) {
                            break;
                        }
                    }
                    break loop0;
                }
                if (((k) arrayList.get(i11)).f8139n) {
                    break;
                } else {
                    i11++;
                }
            }
            i10++;
        }
        if (i10 == -1) {
            return;
        }
        long j9 = A().h;
        k kVar2 = (k) arrayList.get(i10);
        int size = arrayList.size();
        int i13 = w.f3713a;
        if (i10 < 0 || size > arrayList.size() || i10 > size) {
            m7.c.d();
            return;
        }
        if (i10 != size) {
            arrayList.subList(i10, size).clear();
        }
        int i14 = 0;
        while (i14 < this.D.length) {
            int e9 = kVar2.e(i14);
            q qVar = this.D[i14];
            r0 r0Var = qVar.f9412a;
            long k3 = qVar.k(e9);
            int i15 = r0Var.f9392b;
            g1.a.f(k3 <= r0Var.f9397g);
            r0Var.f9397g = k3;
            if (k3 != 0) {
                q0 q0Var2 = r0Var.f9394d;
                if (k3 != q0Var2.f9380i) {
                    while (true) {
                        long j10 = r0Var.f9397g;
                        long j11 = q0Var2.f9381j;
                        q0Var = (q0) q0Var2.f9383l;
                        if (j10 <= j11) {
                            break;
                        } else {
                            q0Var2 = q0Var;
                        }
                    }
                    q0Var.getClass();
                    r0Var.a(q0Var);
                    q0 q0Var3 = new q0(q0Var2.f9381j, i15);
                    q0Var2.f9383l = q0Var3;
                    j5 = j9;
                    if (r0Var.f9397g == q0Var2.f9381j) {
                        q0Var2 = q0Var3;
                    }
                    r0Var.f9396f = q0Var2;
                    if (r0Var.f9395e == q0Var) {
                        r0Var.f9395e = q0Var3;
                    }
                    i14++;
                    j9 = j5;
                }
            }
            j5 = j9;
            r0Var.a(r0Var.f9394d);
            q0 q0Var4 = new q0(r0Var.f9397g, i15);
            r0Var.f9394d = q0Var4;
            r0Var.f9395e = q0Var4;
            r0Var.f9396f = q0Var4;
            i14++;
            j9 = j5;
        }
        long j12 = j9;
        if (arrayList.isEmpty()) {
            this.Y = this.X;
        } else {
            ((k) b6.q.g(arrayList)).J = true;
        }
        this.f8195b0 = false;
        this.f8210s.j(new v1.v(1, this.I, null, 3, null, w.W(kVar2.f9708g), w.W(j12)));
    }

    @Override // d2.o
    public final void t(y yVar) {
    }
}
