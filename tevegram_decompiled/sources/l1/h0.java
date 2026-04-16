package l1;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.webrtc.PeerConnectionFactory;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h0 implements Handler.Callback, v1.w {
    public final v0 A;
    public final h B;
    public final long C;
    public d1 D;
    public w0 E;
    public e0 F;
    public boolean G;
    public boolean I;
    public boolean J;
    public boolean L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public g0 S;
    public long T;
    public int U;
    public boolean V;
    public l W;

    /* renamed from: i, reason: collision with root package name */
    public final b1[] f5893i;

    /* renamed from: j, reason: collision with root package name */
    public final Set f5894j;

    /* renamed from: k, reason: collision with root package name */
    public final e[] f5895k;

    /* renamed from: l, reason: collision with root package name */
    public final y1.o f5896l;

    /* renamed from: m, reason: collision with root package name */
    public final y1.t f5897m;

    /* renamed from: n, reason: collision with root package name */
    public final i f5898n;

    /* renamed from: o, reason: collision with root package name */
    public final z1.f f5899o;

    /* renamed from: p, reason: collision with root package name */
    public final g1.t f5900p;

    /* renamed from: q, reason: collision with root package name */
    public final HandlerThread f5901q;

    /* renamed from: r, reason: collision with root package name */
    public final Looper f5902r;

    /* renamed from: s, reason: collision with root package name */
    public final d1.x0 f5903s;

    /* renamed from: t, reason: collision with root package name */
    public final d1.w0 f5904t;

    /* renamed from: u, reason: collision with root package name */
    public final long f5905u;

    /* renamed from: v, reason: collision with root package name */
    public final j f5906v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f5907w;

    /* renamed from: x, reason: collision with root package name */
    public final g1.r f5908x;

    /* renamed from: y, reason: collision with root package name */
    public final t f5909y;

    /* renamed from: z, reason: collision with root package name */
    public final n0 f5910z;
    public boolean H = false;
    public long X = -9223372036854775807L;
    public long K = -9223372036854775807L;

    public h0(b1[] b1VarArr, y1.o oVar, y1.t tVar, i iVar, z1.f fVar, int i9, boolean z8, m1.q qVar, d1 d1Var, h hVar, long j5, Looper looper, g1.r rVar, t tVar2, m1.x xVar) {
        this.f5909y = tVar2;
        this.f5893i = b1VarArr;
        this.f5896l = oVar;
        this.f5897m = tVar;
        this.f5898n = iVar;
        this.f5899o = fVar;
        this.M = i9;
        this.N = z8;
        this.D = d1Var;
        this.B = hVar;
        this.C = j5;
        this.f5908x = rVar;
        this.f5905u = iVar.h;
        iVar.getClass();
        w0 i10 = w0.i(tVar);
        this.E = i10;
        this.F = new e0(i10);
        this.f5895k = new e[b1VarArr.length];
        oVar.getClass();
        for (int i11 = 0; i11 < b1VarArr.length; i11++) {
            e eVar = (e) b1VarArr[i11];
            eVar.f5830m = i11;
            eVar.f5831n = xVar;
            eVar.f5832o = rVar;
            eVar.p();
            e[] eVarArr = this.f5895k;
            e eVar2 = (e) b1VarArr[i11];
            eVar2.getClass();
            eVarArr[i11] = eVar2;
            e eVar3 = this.f5895k[i11];
            synchronized (eVar3.f5826i) {
                eVar3.f5842y = oVar;
            }
        }
        this.f5906v = new j(this, rVar);
        this.f5907w = new ArrayList();
        this.f5894j = Collections.newSetFromMap(new IdentityHashMap());
        this.f5903s = new d1.x0();
        this.f5904t = new d1.w0();
        oVar.f10475a = this;
        oVar.f10476b = fVar;
        this.V = true;
        g1.t a9 = rVar.a(looper, null);
        this.f5910z = new n0(qVar, a9, new a3.i(this, 18));
        this.A = new v0(this, qVar, a9, xVar);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f5901q = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f5902r = looper2;
        this.f5900p = rVar.a(looper2, this);
    }

    public static Pair H(d1.y0 y0Var, g0 g0Var, boolean z8, int i9, boolean z9, d1.x0 x0Var, d1.w0 w0Var) {
        Object I;
        d1.y0 y0Var2 = g0Var.f5877a;
        if (y0Var.p()) {
            return null;
        }
        d1.y0 y0Var3 = y0Var2.p() ? y0Var : y0Var2;
        try {
            Pair i10 = y0Var3.i(x0Var, w0Var, g0Var.f5878b, g0Var.f5879c);
            if (!y0Var.equals(y0Var3)) {
                if (y0Var.b(i10.first) == -1) {
                    if (!z8 || (I = I(x0Var, w0Var, i9, z9, i10.first, y0Var3, y0Var)) == null) {
                        return null;
                    }
                    return y0Var.i(x0Var, w0Var, y0Var.g(I, w0Var).f2586c, -9223372036854775807L);
                }
                if (y0Var3.g(i10.first, w0Var).f2589f && y0Var3.m(w0Var.f2586c, x0Var, 0L).f2607o == y0Var3.b(i10.first)) {
                    return y0Var.i(x0Var, w0Var, y0Var.g(i10.first, w0Var).f2586c, g0Var.f5879c);
                }
            }
            return i10;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static Object I(d1.x0 x0Var, d1.w0 w0Var, int i9, boolean z8, Object obj, d1.y0 y0Var, d1.y0 y0Var2) {
        int b9 = y0Var.b(obj);
        int h = y0Var.h();
        int i10 = 0;
        int i11 = b9;
        int i12 = -1;
        while (i10 < h && i12 == -1) {
            d1.x0 x0Var2 = x0Var;
            d1.w0 w0Var2 = w0Var;
            int i13 = i9;
            boolean z9 = z8;
            d1.y0 y0Var3 = y0Var;
            i11 = y0Var3.d(i11, w0Var2, x0Var2, i13, z9);
            if (i11 == -1) {
                break;
            }
            i12 = y0Var2.b(y0Var3.l(i11));
            i10++;
            y0Var = y0Var3;
            w0Var = w0Var2;
            x0Var = x0Var2;
            i9 = i13;
            z8 = z9;
        }
        if (i12 == -1) {
            return null;
        }
        return y0Var2.l(i12);
    }

    public static void O(b1 b1Var, long j5) {
        ((e) b1Var).f5839v = true;
        if (b1Var instanceof x1.e) {
            x1.e eVar = (x1.e) b1Var;
            g1.a.k(eVar.f5839v);
            eVar.S = j5;
        }
    }

    public static boolean r(b1 b1Var) {
        return ((e) b1Var).f5833p != 0;
    }

    public final void A() {
        for (int i9 = 0; i9 < this.f5893i.length; i9++) {
            e eVar = this.f5895k[i9];
            synchronized (eVar.f5826i) {
                eVar.f5842y = null;
            }
            e eVar2 = (e) this.f5893i[i9];
            g1.a.k(eVar2.f5833p == 0);
            eVar2.r();
        }
    }

    public final void B(int i9, int i10, v1.y0 y0Var) {
        this.F.a(1);
        v0 v0Var = this.A;
        v0Var.getClass();
        g1.a.f(i9 >= 0 && i9 <= i10 && i10 <= ((ArrayList) v0Var.f6034c).size());
        v0Var.f6041k = y0Var;
        v0Var.i(i9, i10);
        m(v0Var.c(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.h0.C():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(boolean r33, boolean r34, boolean r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.h0.D(boolean, boolean, boolean, boolean):void");
    }

    public final void E() {
        l0 l0Var = this.f5910z.f5972i;
        this.I = l0Var != null && l0Var.f5944f.h && this.H;
    }

    public final void F(long j5) {
        l0 l0Var = this.f5910z.f5972i;
        long j9 = j5 + (l0Var == null ? 1000000000000L : l0Var.f5952o);
        this.T = j9;
        this.f5906v.f5923i.a(j9);
        for (b1 b1Var : this.f5893i) {
            if (r(b1Var)) {
                long j10 = this.T;
                e eVar = (e) b1Var;
                eVar.f5839v = false;
                eVar.f5837t = j10;
                eVar.f5838u = j10;
                eVar.q(j10, false);
            }
        }
        for (l0 l0Var2 = r0.f5972i; l0Var2 != null; l0Var2 = l0Var2.f5949l) {
            for (y1.q qVar : l0Var2.f5951n.f10493c) {
                if (qVar != null) {
                    qVar.q();
                }
            }
        }
    }

    public final void G(d1.y0 y0Var, d1.y0 y0Var2) {
        if (y0Var.p() && y0Var2.p()) {
            return;
        }
        ArrayList arrayList = this.f5907w;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            androidx.activity.g.w(arrayList.get(size));
            throw null;
        }
    }

    public final void J(boolean z8) {
        v1.z zVar = this.f5910z.f5972i.f5944f.f5955a;
        long L = L(zVar, this.E.f6063r, true, false);
        if (L != this.E.f6063r) {
            w0 w0Var = this.E;
            this.E = p(zVar, L, w0Var.f6049c, w0Var.f6050d, z8, 5);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:20|(7:(9:64|65|(1:83)(1:71)|72|(1:82)|79|80|11|12)(1:22)|42|43|44|10|11|12)|23|24|(1:26)(1:60)|27|(1:29)(1:59)|30|31|32|(1:34)(1:57)|35|36|37|38|39|40|41) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0150, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0151, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0152, code lost:
    
        r5 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0154, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0156, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0157, code lost:
    
        r5 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a0 A[Catch: all -> 0x00a3, TRY_LEAVE, TryCatch #1 {all -> 0x00a3, blocks: (B:6:0x0096, B:8:0x00a0, B:16:0x00ae, B:18:0x00b2, B:19:0x00b5, B:20:0x00bd, B:67:0x00cb, B:71:0x00d3), top: B:5:0x0096 }] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object, v1.x] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(l1.g0 r19) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.h0.K(l1.g0):void");
    }

    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object, v1.x] */
    public final long L(v1.z zVar, long j5, boolean z8, boolean z9) {
        c0();
        i0(false, true);
        if (z9 || this.E.f6051e == 3) {
            X(2);
        }
        n0 n0Var = this.f5910z;
        l0 l0Var = n0Var.f5972i;
        l0 l0Var2 = l0Var;
        while (l0Var2 != null && !zVar.equals(l0Var2.f5944f.f5955a)) {
            l0Var2 = l0Var2.f5949l;
        }
        if (z8 || l0Var != l0Var2 || (l0Var2 != null && l0Var2.f5952o + j5 < 0)) {
            b1[] b1VarArr = this.f5893i;
            for (b1 b1Var : b1VarArr) {
                b(b1Var);
            }
            if (l0Var2 != null) {
                while (n0Var.f5972i != l0Var2) {
                    n0Var.a();
                }
                n0Var.k(l0Var2);
                l0Var2.f5952o = 1000000000000L;
                f(new boolean[b1VarArr.length], n0Var.f5973j.e());
            }
        }
        if (l0Var2 != null) {
            ?? r9 = l0Var2.f5939a;
            n0Var.k(l0Var2);
            if (!l0Var2.f5942d) {
                l0Var2.f5944f = l0Var2.f5944f.b(j5);
            } else if (l0Var2.f5943e) {
                j5 = r9.r(j5);
                r9.s(j5 - this.f5905u);
            }
            F(j5);
            t();
        } else {
            n0Var.b();
            F(j5);
        }
        l(false);
        this.f5900p.d(2);
        return j5;
    }

    public final void M(y0 y0Var) {
        g1.t tVar = this.f5900p;
        if (y0Var.f6071f != this.f5902r) {
            tVar.a(15, y0Var).b();
            return;
        }
        synchronized (y0Var) {
        }
        try {
            y0Var.f6066a.g(y0Var.f6069d, y0Var.f6070e);
            y0Var.b(true);
            int i9 = this.E.f6051e;
            if (i9 == 3 || i9 == 2) {
                tVar.d(2);
            }
        } catch (Throwable th) {
            y0Var.b(true);
            throw th;
        }
    }

    public final void N(y0 y0Var) {
        Looper looper = y0Var.f6071f;
        if (looper.getThread().isAlive()) {
            this.f5908x.a(looper, null).c(new a7.a(this, y0Var));
        } else {
            g1.a.D("TAG", "Trying to send message on a dead thread.");
            y0Var.b(false);
        }
    }

    public final void P(boolean z8, AtomicBoolean atomicBoolean) {
        if (this.O != z8) {
            this.O = z8;
            if (!z8) {
                for (b1 b1Var : this.f5893i) {
                    if (!r(b1Var) && this.f5894j.remove(b1Var)) {
                        ((e) b1Var).y();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void Q(d0 d0Var) {
        this.F.a(1);
        int i9 = d0Var.f5821c;
        v1.y0 y0Var = d0Var.f5820b;
        ArrayList arrayList = d0Var.f5819a;
        if (i9 != -1) {
            this.S = new g0(new a1(arrayList, y0Var), d0Var.f5821c, d0Var.f5822d);
        }
        v0 v0Var = this.A;
        ArrayList arrayList2 = (ArrayList) v0Var.f6034c;
        v0Var.i(0, arrayList2.size());
        m(v0Var.a(arrayList2.size(), arrayList, y0Var), false);
    }

    public final void R(boolean z8) {
        this.H = z8;
        E();
        if (this.I) {
            n0 n0Var = this.f5910z;
            if (n0Var.f5973j != n0Var.f5972i) {
                J(true);
                l(false);
            }
        }
    }

    public final void S(int i9, int i10, boolean z8, boolean z9) {
        this.F.a(z9 ? 1 : 0);
        e0 e0Var = this.F;
        e0Var.f5843a = true;
        e0Var.f5848f = true;
        e0Var.f5849g = i10;
        this.E = this.E.d(i9, z8);
        i0(false, false);
        for (l0 l0Var = this.f5910z.f5972i; l0Var != null; l0Var = l0Var.f5949l) {
            for (y1.q qVar : l0Var.f5951n.f10493c) {
                if (qVar != null) {
                    qVar.a(z8);
                }
            }
        }
        if (!Y()) {
            c0();
            g0();
            return;
        }
        int i11 = this.E.f6051e;
        g1.t tVar = this.f5900p;
        if (i11 != 3) {
            if (i11 == 2) {
                tVar.d(2);
            }
        } else {
            i0(false, false);
            j jVar = this.f5906v;
            jVar.f5928n = true;
            jVar.f5923i.b();
            a0();
            tVar.d(2);
        }
    }

    public final void T(d1.o0 o0Var) {
        this.f5900p.f3708a.removeMessages(16);
        j jVar = this.f5906v;
        jVar.e(o0Var);
        d1.o0 d9 = jVar.d();
        o(d9, d9.f2510a, true, true);
    }

    public final void U(int i9) {
        this.M = i9;
        d1.y0 y0Var = this.E.f6047a;
        n0 n0Var = this.f5910z;
        n0Var.f5971g = i9;
        if (!n0Var.n(y0Var)) {
            J(true);
        }
        l(false);
    }

    public final void V(boolean z8) {
        this.N = z8;
        d1.y0 y0Var = this.E.f6047a;
        n0 n0Var = this.f5910z;
        n0Var.h = z8;
        if (!n0Var.n(y0Var)) {
            J(true);
        }
        l(false);
    }

    public final void W(v1.y0 y0Var) {
        this.F.a(1);
        v0 v0Var = this.A;
        int size = ((ArrayList) v0Var.f6034c).size();
        if (y0Var.f9445b.length != size) {
            y0Var = new v1.y0(new Random(y0Var.f9444a.nextLong())).a(0, size);
        }
        v0Var.f6041k = y0Var;
        m(v0Var.c(), false);
    }

    public final void X(int i9) {
        w0 w0Var = this.E;
        if (w0Var.f6051e != i9) {
            if (i9 != 2) {
                this.X = -9223372036854775807L;
            }
            this.E = w0Var.g(i9);
        }
    }

    public final boolean Y() {
        w0 w0Var = this.E;
        return w0Var.f6057l && w0Var.f6058m == 0;
    }

    public final boolean Z(d1.y0 y0Var, v1.z zVar) {
        if (zVar.b() || y0Var.p()) {
            return false;
        }
        int i9 = y0Var.g(zVar.f9447a, this.f5904t).f2586c;
        d1.x0 x0Var = this.f5903s;
        y0Var.n(i9, x0Var);
        return x0Var.a() && x0Var.f2601i && x0Var.f2599f != -9223372036854775807L;
    }

    public final void a(d0 d0Var, int i9) {
        this.F.a(1);
        v0 v0Var = this.A;
        if (i9 == -1) {
            i9 = ((ArrayList) v0Var.f6034c).size();
        }
        m(v0Var.a(i9, d0Var.f5819a, d0Var.f5820b), false);
    }

    public final void a0() {
        l0 l0Var = this.f5910z.f5972i;
        if (l0Var == null) {
            return;
        }
        y1.t tVar = l0Var.f5951n;
        int i9 = 0;
        while (true) {
            b1[] b1VarArr = this.f5893i;
            if (i9 >= b1VarArr.length) {
                return;
            }
            if (tVar.b(i9)) {
                e eVar = (e) b1VarArr[i9];
                int i10 = eVar.f5833p;
                if (i10 == 1) {
                    g1.a.k(i10 == 1);
                    eVar.f5833p = 2;
                    eVar.t();
                }
            }
            i9++;
        }
    }

    public final void b(b1 b1Var) {
        if (r(b1Var)) {
            j jVar = this.f5906v;
            if (b1Var == jVar.f5925k) {
                jVar.f5926l = null;
                jVar.f5925k = null;
                jVar.f5927m = true;
            }
            e eVar = (e) b1Var;
            int i9 = eVar.f5833p;
            if (i9 == 2) {
                g1.a.k(i9 == 2);
                eVar.f5833p = 1;
                eVar.u();
            }
            e eVar2 = (e) b1Var;
            g1.a.k(eVar2.f5833p == 1);
            eVar2.f5828k.o0();
            eVar2.f5833p = 0;
            eVar2.f5834q = null;
            eVar2.f5835r = null;
            eVar2.f5839v = false;
            eVar2.n();
            this.R--;
        }
    }

    public final void b0(boolean z8, boolean z9) {
        D(z8 || !this.O, false, true, false);
        this.F.a(z9 ? 1 : 0);
        this.f5898n.b(true);
        X(1);
    }

    @Override // v1.w
    public final void c(v1.x xVar) {
        this.f5900p.a(8, xVar).b();
    }

    public final void c0() {
        e eVar;
        int i9;
        j jVar = this.f5906v;
        jVar.f5928n = false;
        e1 e1Var = jVar.f5923i;
        if (e1Var.f5851j) {
            e1Var.a(e1Var.j());
            e1Var.f5851j = false;
        }
        for (b1 b1Var : this.f5893i) {
            if (r(b1Var) && (i9 = (eVar = (e) b1Var).f5833p) == 2) {
                g1.a.k(i9 == 2);
                eVar.f5833p = 1;
                eVar.u();
            }
        }
    }

    @Override // v1.w0
    public final void d(v1.x0 x0Var) {
        this.f5900p.a(9, (v1.x) x0Var).b();
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object, v1.x0] */
    public final void d0() {
        l0 l0Var = this.f5910z.f5974k;
        boolean z8 = this.L || (l0Var != null && l0Var.f5939a.a());
        w0 w0Var = this.E;
        if (z8 != w0Var.f6053g) {
            this.E = new w0(w0Var.f6047a, w0Var.f6048b, w0Var.f6049c, w0Var.f6050d, w0Var.f6051e, w0Var.f6052f, z8, w0Var.h, w0Var.f6054i, w0Var.f6055j, w0Var.f6056k, w0Var.f6057l, w0Var.f6058m, w0Var.f6059n, w0Var.f6061p, w0Var.f6062q, w0Var.f6063r, w0Var.f6064s, w0Var.f6060o);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:340:0x0582, code lost:
    
        if (r3 >= r15.f5918i) goto L302;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0699  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0707  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x031f A[EDGE_INSN: B:78:0x031f->B:79:0x031f BREAK  A[LOOP:0: B:38:0x02a0->B:49:0x031b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0376  */
    /* JADX WARN: Type inference failed for: r2v68, types: [java.lang.Object, v1.x] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, v1.x] */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object, v1.x] */
    /* JADX WARN: Type inference failed for: r6v47, types: [java.lang.Object, v1.x0] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object, v1.x] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 1850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.h0.e():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void e0(y1.t tVar) {
        d1.y0 y0Var = this.E.f6047a;
        y1.q[] qVarArr = tVar.f10493c;
        i iVar = this.f5898n;
        int i9 = iVar.f5916f;
        if (i9 == -1) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                b1[] b1VarArr = this.f5893i;
                int i12 = 13107200;
                if (i10 < b1VarArr.length) {
                    if (qVarArr[i10] != null) {
                        switch (((e) b1VarArr[i10]).f5827j) {
                            case 0:
                                i12 = 144310272;
                                i11 += i12;
                                break;
                            case 1:
                                i11 += i12;
                                break;
                            case 2:
                                i12 = 131072000;
                                i11 += i12;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                i12 = 131072;
                                i11 += i12;
                                break;
                            default:
                                m7.c.d();
                                break;
                        }
                        return;
                    }
                    i10++;
                } else {
                    i9 = Math.max(13107200, i11);
                }
            }
        }
        iVar.f5918i = i9;
        iVar.f5911a.a(i9);
    }

    public final void f(boolean[] zArr, long j5) {
        b1[] b1VarArr;
        Set set;
        n0 n0Var;
        k0 k0Var;
        n0 n0Var2 = this.f5910z;
        l0 l0Var = n0Var2.f5973j;
        y1.t tVar = l0Var.f5951n;
        int i9 = 0;
        while (true) {
            b1VarArr = this.f5893i;
            int length = b1VarArr.length;
            set = this.f5894j;
            if (i9 >= length) {
                break;
            }
            if (!tVar.b(i9) && set.remove(b1VarArr[i9])) {
                ((e) b1VarArr[i9]).y();
            }
            i9++;
        }
        int i10 = 0;
        while (i10 < b1VarArr.length) {
            if (tVar.b(i10)) {
                boolean z8 = zArr[i10];
                b1 b1Var = b1VarArr[i10];
                if (!r(b1Var)) {
                    l0 l0Var2 = n0Var2.f5973j;
                    boolean z9 = l0Var2 == n0Var2.f5972i;
                    y1.t tVar2 = l0Var2.f5951n;
                    c1 c1Var = tVar2.f10492b[i10];
                    y1.q qVar = tVar2.f10493c[i10];
                    int length2 = qVar != null ? qVar.length() : 0;
                    d1.s[] sVarArr = new d1.s[length2];
                    for (int i11 = 0; i11 < length2; i11++) {
                        sVarArr[i11] = qVar.c(i11);
                    }
                    boolean z10 = Y() && this.E.f6051e == 3;
                    boolean z11 = !z8 && z10;
                    this.R++;
                    set.add(b1Var);
                    v1.v0 v0Var = l0Var2.f5941c[i10];
                    long j9 = l0Var2.f5952o;
                    v1.z zVar = l0Var2.f5944f.f5955a;
                    e eVar = (e) b1Var;
                    g1.a.k(eVar.f5833p == 0);
                    eVar.f5829l = c1Var;
                    eVar.f5833p = 1;
                    eVar.o(z11, z9);
                    n0Var = n0Var2;
                    boolean z12 = z9;
                    eVar.x(sVarArr, v0Var, j5, j9, zVar);
                    eVar.f5839v = false;
                    eVar.f5837t = j5;
                    eVar.f5838u = j5;
                    eVar.q(j5, z11);
                    b1Var.g(11, new c0(this));
                    j jVar = this.f5906v;
                    jVar.getClass();
                    k0 i12 = b1Var.i();
                    if (i12 != null && i12 != (k0Var = jVar.f5926l)) {
                        if (k0Var != null) {
                            throw new l(2, new IllegalStateException("Multiple renderer media clocks enabled."), IjkMediaCodecInfo.RANK_MAX);
                        }
                        jVar.f5926l = i12;
                        jVar.f5925k = b1Var;
                        i12.e(jVar.f5923i.f5854m);
                    }
                    if (z10 && z12) {
                        e eVar2 = (e) b1Var;
                        g1.a.k(eVar2.f5833p == 1);
                        eVar2.f5833p = 2;
                        eVar2.t();
                    }
                    i10++;
                    n0Var2 = n0Var;
                }
            }
            n0Var = n0Var2;
            i10++;
            n0Var2 = n0Var;
        }
        l0Var.f5945g = true;
    }

    public final void f0(List list, int i9, int i10) {
        this.F.a(1);
        v0 v0Var = this.A;
        v0Var.getClass();
        ArrayList arrayList = (ArrayList) v0Var.f6034c;
        g1.a.f(i9 >= 0 && i9 <= i10 && i10 <= arrayList.size());
        g1.a.f(list.size() == i10 - i9);
        for (int i11 = i9; i11 < i10; i11++) {
            ((u0) arrayList.get(i11)).f6025a.r((d1.e0) list.get(i11 - i9));
        }
        m(v0Var.c(), false);
    }

    public final long g(d1.y0 y0Var, Object obj, long j5) {
        d1.w0 w0Var = this.f5904t;
        int i9 = y0Var.g(obj, w0Var).f2586c;
        d1.x0 x0Var = this.f5903s;
        y0Var.n(i9, x0Var);
        if (x0Var.f2599f == -9223372036854775807L || !x0Var.a() || !x0Var.f2601i) {
            return -9223372036854775807L;
        }
        long j9 = x0Var.f2600g;
        return g1.w.M((j9 == -9223372036854775807L ? System.currentTimeMillis() : j9 + SystemClock.elapsedRealtime()) - x0Var.f2599f) - (j5 + w0Var.f2588e);
    }

    /* JADX WARN: Type inference failed for: r2v23, types: [java.lang.Object, v1.x] */
    public final void g0() {
        long j5;
        long max;
        char c9;
        char c10;
        char c11;
        long max2;
        l0 l0Var = this.f5910z.f5972i;
        if (l0Var == null) {
            return;
        }
        long g9 = l0Var.f5942d ? l0Var.f5939a.g() : -9223372036854775807L;
        if (g9 != -9223372036854775807L) {
            if (!l0Var.f()) {
                this.f5910z.k(l0Var);
                l(false);
                t();
            }
            F(g9);
            if (g9 != this.E.f6063r) {
                w0 w0Var = this.E;
                this.E = p(w0Var.f6048b, g9, w0Var.f6049c, g9, true, 5);
            }
        } else {
            j jVar = this.f5906v;
            boolean z8 = l0Var != this.f5910z.f5973j;
            e1 e1Var = jVar.f5923i;
            b1 b1Var = jVar.f5925k;
            if (b1Var == null || b1Var.a() || ((z8 && ((e) jVar.f5925k).f5833p != 2) || (!jVar.f5925k.b() && (z8 || ((e) jVar.f5925k).m())))) {
                jVar.f5927m = true;
                if (jVar.f5928n) {
                    e1Var.b();
                }
            } else {
                k0 k0Var = jVar.f5926l;
                k0Var.getClass();
                long j9 = k0Var.j();
                if (jVar.f5927m) {
                    if (j9 >= e1Var.j()) {
                        jVar.f5927m = false;
                        if (jVar.f5928n) {
                            e1Var.b();
                        }
                    } else if (e1Var.f5851j) {
                        e1Var.a(e1Var.j());
                        e1Var.f5851j = false;
                    }
                }
                e1Var.a(j9);
                d1.o0 d9 = k0Var.d();
                if (!d9.equals(e1Var.f5854m)) {
                    e1Var.e(d9);
                    jVar.f5924j.f5900p.a(16, d9).b();
                }
            }
            long j10 = jVar.j();
            this.T = j10;
            long j11 = j10 - l0Var.f5952o;
            long j12 = this.E.f6063r;
            if (!this.f5907w.isEmpty() && !this.E.f6048b.b()) {
                if (this.V) {
                    this.V = false;
                }
                w0 w0Var2 = this.E;
                w0Var2.f6047a.b(w0Var2.f6048b.f9447a);
                int min = Math.min(this.U, this.f5907w.size());
                if (min > 0 && this.f5907w.get(min - 1) != null) {
                    androidx.fragment.app.a.c();
                    return;
                } else {
                    if (min < this.f5907w.size() && this.f5907w.get(min) != null) {
                        androidx.fragment.app.a.c();
                        return;
                    }
                    this.U = min;
                }
            }
            boolean c12 = this.f5906v.c();
            w0 w0Var3 = this.E;
            if (c12) {
                this.E = p(w0Var3.f6048b, j11, w0Var3.f6049c, j11, true, 6);
            } else {
                w0Var3.f6063r = j11;
                w0Var3.f6064s = SystemClock.elapsedRealtime();
            }
        }
        this.E.f6061p = this.f5910z.f5974k.d();
        w0 w0Var4 = this.E;
        long j13 = w0Var4.f6061p;
        l0 l0Var2 = this.f5910z.f5974k;
        if (l0Var2 == null) {
            max = 0;
            j5 = -9223372036854775807L;
        } else {
            j5 = -9223372036854775807L;
            max = Math.max(0L, j13 - (this.T - l0Var2.f5952o));
        }
        w0Var4.f6062q = max;
        w0 w0Var5 = this.E;
        if (w0Var5.f6057l && w0Var5.f6051e == 3 && Z(w0Var5.f6047a, w0Var5.f6048b)) {
            w0 w0Var6 = this.E;
            float f9 = 1.0f;
            if (w0Var6.f6059n.f2510a == 1.0f) {
                h hVar = this.B;
                long g10 = g(w0Var6.f6047a, w0Var6.f6048b.f9447a, w0Var6.f6063r);
                long j14 = this.E.f6061p;
                l0 l0Var3 = this.f5910z.f5974k;
                if (l0Var3 == null) {
                    max2 = 0;
                    c9 = 0;
                    c10 = 2;
                    c11 = 1;
                } else {
                    c9 = 0;
                    c10 = 2;
                    c11 = 1;
                    max2 = Math.max(0L, j14 - (this.T - l0Var3.f5952o));
                }
                if (hVar.f5882c != j5) {
                    long j15 = g10 - max2;
                    long j16 = hVar.f5891m;
                    if (j16 == j5) {
                        hVar.f5891m = j15;
                        hVar.f5892n = 0L;
                    } else {
                        hVar.f5891m = Math.max(j15, (long) ((j15 * 9.999871E-4f) + (j16 * 0.999f)));
                        hVar.f5892n = (long) ((9.999871E-4f * Math.abs(j15 - r14)) + (0.999f * hVar.f5892n));
                    }
                    if (hVar.f5890l == j5 || SystemClock.elapsedRealtime() - hVar.f5890l >= 1000) {
                        hVar.f5890l = SystemClock.elapsedRealtime();
                        long j17 = (hVar.f5892n * 3) + hVar.f5891m;
                        if (hVar.h > j17) {
                            float M = g1.w.M(1000L);
                            long j18 = ((long) ((hVar.f5889k - 1.0f) * M)) + ((long) ((hVar.f5887i - 1.0f) * M));
                            long j19 = hVar.f5884e;
                            long j20 = hVar.h - j18;
                            long[] jArr = new long[3];
                            jArr[c9] = j17;
                            jArr[c11] = j19;
                            jArr[c10] = j20;
                            long j21 = jArr[c9];
                            for (int i9 = 1; i9 < 3; i9++) {
                                long j22 = jArr[i9];
                                if (j22 > j21) {
                                    j21 = j22;
                                }
                            }
                            hVar.h = j21;
                        } else {
                            long i10 = g1.w.i(g10 - ((long) (Math.max(0.0f, hVar.f5889k - 1.0f) / 1.0E-7f)), hVar.h, j17);
                            hVar.h = i10;
                            long j23 = hVar.f5886g;
                            if (j23 != j5 && i10 > j23) {
                                hVar.h = j23;
                            }
                        }
                        long j24 = g10 - hVar.h;
                        if (Math.abs(j24) < hVar.f5880a) {
                            hVar.f5889k = 1.0f;
                        } else {
                            hVar.f5889k = g1.w.g((1.0E-7f * j24) + 1.0f, hVar.f5888j, hVar.f5887i);
                        }
                        f9 = hVar.f5889k;
                    } else {
                        f9 = hVar.f5889k;
                    }
                }
                if (this.f5906v.d().f2510a != f9) {
                    d1.o0 o0Var = new d1.o0(f9, this.E.f6059n.f2511b);
                    this.f5900p.f3708a.removeMessages(16);
                    this.f5906v.e(o0Var);
                    o(this.E.f6059n, this.f5906v.d().f2510a, false, false);
                }
            }
        }
    }

    public final long h() {
        l0 l0Var = this.f5910z.f5973j;
        if (l0Var == null) {
            return 0L;
        }
        long j5 = l0Var.f5952o;
        if (!l0Var.f5942d) {
            return j5;
        }
        int i9 = 0;
        while (true) {
            b1[] b1VarArr = this.f5893i;
            if (i9 >= b1VarArr.length) {
                return j5;
            }
            if (r(b1VarArr[i9])) {
                e eVar = (e) b1VarArr[i9];
                if (eVar.f5834q != l0Var.f5941c[i9]) {
                    continue;
                } else {
                    long j9 = eVar.f5838u;
                    if (j9 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j5 = Math.max(j9, j5);
                }
            }
            i9++;
        }
    }

    public final void h0(d1.y0 y0Var, v1.z zVar, d1.y0 y0Var2, v1.z zVar2, long j5, boolean z8) {
        boolean Z = Z(y0Var, zVar);
        Object obj = zVar.f9447a;
        if (!Z) {
            d1.o0 o0Var = zVar.b() ? d1.o0.f2509d : this.E.f6059n;
            j jVar = this.f5906v;
            if (jVar.d().equals(o0Var)) {
                return;
            }
            this.f5900p.f3708a.removeMessages(16);
            jVar.e(o0Var);
            o(this.E.f6059n, o0Var.f2510a, false, false);
            return;
        }
        d1.w0 w0Var = this.f5904t;
        int i9 = y0Var.g(obj, w0Var).f2586c;
        d1.x0 x0Var = this.f5903s;
        y0Var.n(i9, x0Var);
        d1.a0 a0Var = x0Var.f2603k;
        h hVar = this.B;
        hVar.getClass();
        hVar.f5882c = g1.w.M(a0Var.f2348a);
        hVar.f5885f = g1.w.M(a0Var.f2349b);
        hVar.f5886g = g1.w.M(a0Var.f2350c);
        float f9 = a0Var.f2351d;
        if (f9 == -3.4028235E38f) {
            f9 = 0.97f;
        }
        hVar.f5888j = f9;
        float f10 = a0Var.f2352e;
        if (f10 == -3.4028235E38f) {
            f10 = 1.03f;
        }
        hVar.f5887i = f10;
        if (f9 == 1.0f && f10 == 1.0f) {
            hVar.f5882c = -9223372036854775807L;
        }
        hVar.a();
        if (j5 != -9223372036854775807L) {
            hVar.f5883d = g(y0Var, obj, j5);
            hVar.a();
            return;
        }
        if (!g1.w.a(!y0Var2.p() ? y0Var2.m(y0Var2.g(zVar2.f9447a, w0Var).f2586c, x0Var, 0L).f2594a : null, x0Var.f2594a) || z8) {
            hVar.f5883d = -9223372036854775807L;
            hVar.a();
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        boolean z8;
        boolean z9;
        l0 l0Var;
        int i9;
        l0 l0Var2;
        int i10 = IjkMediaCodecInfo.RANK_MAX;
        try {
            switch (message.what) {
                case 0:
                    x();
                    break;
                case 1:
                    S(message.arg2, 1, message.arg1 != 0, true);
                    break;
                case 2:
                    e();
                    break;
                case 3:
                    K((g0) message.obj);
                    break;
                case 4:
                    T((d1.o0) message.obj);
                    break;
                case 5:
                    this.D = (d1) message.obj;
                    break;
                case 6:
                    b0(false, true);
                    break;
                case 7:
                    z();
                    return true;
                case 8:
                    n((v1.x) message.obj);
                    break;
                case 9:
                    j((v1.x) message.obj);
                    break;
                case 10:
                    C();
                    break;
                case 11:
                    U(message.arg1);
                    break;
                case 12:
                    V(message.arg1 != 0);
                    break;
                case 13:
                    P(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    y0 y0Var = (y0) message.obj;
                    y0Var.getClass();
                    M(y0Var);
                    break;
                case 15:
                    N((y0) message.obj);
                    break;
                case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                    d1.o0 o0Var = (d1.o0) message.obj;
                    o(o0Var, o0Var.f2510a, true, false);
                    break;
                case 17:
                    Q((d0) message.obj);
                    break;
                case 18:
                    a((d0) message.obj, message.arg1);
                    break;
                case 19:
                    androidx.activity.g.w(message.obj);
                    w();
                    throw null;
                case 20:
                    B(message.arg1, message.arg2, (v1.y0) message.obj);
                    break;
                case 21:
                    W((v1.y0) message.obj);
                    break;
                case 22:
                    v();
                    break;
                case 23:
                    R(message.arg1 != 0);
                    break;
                case 24:
                default:
                    return false;
                case 25:
                    C();
                    J(true);
                    break;
                case 26:
                    C();
                    J(true);
                    break;
                case 27:
                    f0((List) message.obj, message.arg1, message.arg2);
                    break;
            }
        } catch (d1.m0 e9) {
            boolean z10 = e9.f2501i;
            int i11 = e9.f2502j;
            if (i11 == 1) {
                i10 = z10 ? 3001 : 3003;
            } else if (i11 == 4) {
                i10 = z10 ? 3002 : 3004;
            }
            k(e9, i10);
        } catch (i1.i e10) {
            k(e10, e10.f4318i);
        } catch (IOException e11) {
            k(e11, 2000);
        } catch (RuntimeException e12) {
            if ((e12 instanceof IllegalStateException) || (e12 instanceof IllegalArgumentException)) {
                i10 = 1004;
            }
            l lVar = new l(2, e12, i10);
            g1.a.q("ExoPlayerImplInternal", "Playback error", lVar);
            b0(true, false);
            this.E = this.E.e(lVar);
        } catch (l e13) {
            e = e13;
            int i12 = e.f5932k;
            n0 n0Var = this.f5910z;
            if (i12 == 1 && (l0Var2 = n0Var.f5973j) != null) {
                e = new l(e.getMessage(), e.getCause(), e.f2507i, e.f5932k, e.f5933l, e.f5934m, e.f5935n, e.f5936o, l0Var2.f5944f.f5955a, e.f2508j, e.f5938q);
            }
            if (e.f5938q && (this.W == null || (i9 = e.f2507i) == 5004 || i9 == 5003)) {
                g1.a.E("ExoPlayerImplInternal", "Recoverable renderer error", e);
                l lVar2 = this.W;
                if (lVar2 != null) {
                    lVar2.addSuppressed(e);
                    e = this.W;
                } else {
                    this.W = e;
                }
                g1.t tVar = this.f5900p;
                g1.s a9 = tVar.a(25, e);
                Handler handler = tVar.f3708a;
                Message message2 = a9.f3706a;
                message2.getClass();
                handler.sendMessageAtFrontOfQueue(message2);
                a9.a();
            } else {
                l lVar3 = this.W;
                if (lVar3 != null) {
                    lVar3.addSuppressed(e);
                    e = this.W;
                }
                g1.a.q("ExoPlayerImplInternal", "Playback error", e);
                z8 = true;
                if (e.f5932k == 1) {
                    if (n0Var.f5972i != n0Var.f5973j) {
                        while (true) {
                            l0Var = n0Var.f5972i;
                            if (l0Var == n0Var.f5973j) {
                                break;
                            }
                            n0Var.a();
                        }
                        l0Var.getClass();
                        m0 m0Var = l0Var.f5944f;
                        v1.z zVar = m0Var.f5955a;
                        long j5 = m0Var.f5956b;
                        this.E = p(zVar, j5, m0Var.f5957c, j5, true, 0);
                    }
                    z9 = false;
                    z8 = true;
                } else {
                    z9 = false;
                }
                b0(z8, z9);
                this.E = this.E.e(e);
            }
        } catch (o1.b e14) {
            k(e14, e14.f7567i);
        } catch (v1.b e15) {
            k(e15, 1002);
        }
        z8 = true;
        u();
        return z8;
    }

    public final Pair i(d1.y0 y0Var) {
        long j5 = 0;
        if (y0Var.p()) {
            return Pair.create(w0.f6046t, 0L);
        }
        int a9 = y0Var.a(this.N);
        Pair i9 = y0Var.i(this.f5903s, this.f5904t, a9, -9223372036854775807L);
        v1.z m9 = this.f5910z.m(y0Var, i9.first, 0L);
        long longValue = ((Long) i9.second).longValue();
        if (m9.b()) {
            Object obj = m9.f9447a;
            d1.w0 w0Var = this.f5904t;
            y0Var.g(obj, w0Var);
            if (m9.f9449c == w0Var.e(m9.f9448b)) {
                w0Var.f2590g.getClass();
            }
        } else {
            j5 = longValue;
        }
        return Pair.create(m9, Long.valueOf(j5));
    }

    public final void i0(boolean z8, boolean z9) {
        long elapsedRealtime;
        this.J = z8;
        if (z9) {
            elapsedRealtime = -9223372036854775807L;
        } else {
            this.f5908x.getClass();
            elapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.K = elapsedRealtime;
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, v1.x0] */
    public final void j(v1.x xVar) {
        l0 l0Var = this.f5910z.f5974k;
        if (l0Var == null || l0Var.f5939a != xVar) {
            return;
        }
        long j5 = this.T;
        if (l0Var != null) {
            g1.a.k(l0Var.f5949l == null);
            if (l0Var.f5942d) {
                l0Var.f5939a.u(j5 - l0Var.f5952o);
            }
        }
        t();
    }

    public final synchronized void j0(m mVar, long j5) {
        this.f5908x.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime() + j5;
        boolean z8 = false;
        while (!((Boolean) mVar.get()).booleanValue() && j5 > 0) {
            try {
                this.f5908x.getClass();
                wait(j5);
            } catch (InterruptedException unused) {
                z8 = true;
            }
            this.f5908x.getClass();
            j5 = elapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z8) {
            Thread.currentThread().interrupt();
        }
    }

    public final void k(IOException iOException, int i9) {
        l lVar = new l(0, iOException, i9);
        l0 l0Var = this.f5910z.f5972i;
        if (l0Var != null) {
            v1.z zVar = l0Var.f5944f.f5955a;
            lVar = new l(lVar.getMessage(), lVar.getCause(), lVar.f2507i, lVar.f5932k, lVar.f5933l, lVar.f5934m, lVar.f5935n, lVar.f5936o, zVar, lVar.f2508j, lVar.f5938q);
        }
        g1.a.q("ExoPlayerImplInternal", "Playback error", lVar);
        b0(false, false);
        this.E = this.E.e(lVar);
    }

    public final void l(boolean z8) {
        l0 l0Var = this.f5910z.f5974k;
        v1.z zVar = l0Var == null ? this.E.f6048b : l0Var.f5944f.f5955a;
        boolean equals = this.E.f6056k.equals(zVar);
        if (!equals) {
            this.E = this.E.b(zVar);
        }
        w0 w0Var = this.E;
        w0Var.f6061p = l0Var == null ? w0Var.f6063r : l0Var.d();
        w0 w0Var2 = this.E;
        long j5 = w0Var2.f6061p;
        l0 l0Var2 = this.f5910z.f5974k;
        w0Var2.f6062q = l0Var2 != null ? Math.max(0L, j5 - (this.T - l0Var2.f5952o)) : 0L;
        if ((!equals || z8) && l0Var != null && l0Var.f5942d) {
            e0(l0Var.f5951n);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03ae A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r23v12, types: [long] */
    /* JADX WARN: Type inference failed for: r23v15 */
    /* JADX WARN: Type inference failed for: r23v22 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r2v43, types: [l1.n0] */
    /* JADX WARN: Type inference failed for: r33v0, types: [l1.h0] */
    /* JADX WARN: Type inference failed for: r7v18, types: [int] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v28, types: [d1.y0] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(d1.y0 r34, boolean r35) {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.h0.m(d1.y0, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, v1.x] */
    public final void n(v1.x xVar) {
        n0 n0Var = this.f5910z;
        l0 l0Var = n0Var.f5974k;
        if (l0Var == null || l0Var.f5939a != xVar) {
            return;
        }
        float f9 = this.f5906v.d().f2510a;
        d1.y0 y0Var = this.E.f6047a;
        l0Var.f5942d = true;
        l0Var.f5950m = l0Var.f5939a.j();
        y1.t h = l0Var.h(f9, y0Var);
        m0 m0Var = l0Var.f5944f;
        long j5 = m0Var.f5956b;
        long j9 = m0Var.f5959e;
        if (j9 != -9223372036854775807L && j5 >= j9) {
            j5 = Math.max(0L, j9 - 1);
        }
        long a9 = l0Var.a(h, j5, false, new boolean[l0Var.f5946i.length]);
        long j10 = l0Var.f5952o;
        m0 m0Var2 = l0Var.f5944f;
        l0Var.f5952o = (m0Var2.f5956b - a9) + j10;
        l0Var.f5944f = m0Var2.b(a9);
        e0(l0Var.f5951n);
        if (l0Var == n0Var.f5972i) {
            F(l0Var.f5944f.f5956b);
            f(new boolean[this.f5893i.length], n0Var.f5973j.e());
            w0 w0Var = this.E;
            v1.z zVar = w0Var.f6048b;
            long j11 = l0Var.f5944f.f5956b;
            this.E = p(zVar, j11, w0Var.f6049c, j11, false, 5);
        }
        t();
    }

    public final void o(d1.o0 o0Var, float f9, boolean z8, boolean z9) {
        int i9;
        if (z8) {
            if (z9) {
                this.F.a(1);
            }
            this.E = this.E.f(o0Var);
        }
        float f10 = o0Var.f2510a;
        l0 l0Var = this.f5910z.f5972i;
        while (true) {
            i9 = 0;
            if (l0Var == null) {
                break;
            }
            y1.q[] qVarArr = l0Var.f5951n.f10493c;
            int length = qVarArr.length;
            while (i9 < length) {
                y1.q qVar = qVarArr[i9];
                if (qVar != null) {
                    qVar.o(f10);
                }
                i9++;
            }
            l0Var = l0Var.f5949l;
        }
        b1[] b1VarArr = this.f5893i;
        int length2 = b1VarArr.length;
        while (i9 < length2) {
            b1 b1Var = b1VarArr[i9];
            if (b1Var != null) {
                b1Var.k(f9, o0Var.f2510a);
            }
            i9++;
        }
    }

    public final w0 p(v1.z zVar, long j5, long j9, long j10, boolean z8, int i9) {
        b6.w0 w0Var;
        boolean z9;
        this.V = (!this.V && j5 == this.E.f6063r && zVar.equals(this.E.f6048b)) ? false : true;
        E();
        w0 w0Var2 = this.E;
        v1.c1 c1Var = w0Var2.h;
        y1.t tVar = w0Var2.f6054i;
        List list = w0Var2.f6055j;
        if (this.A.f6032a) {
            l0 l0Var = this.f5910z.f5972i;
            c1Var = l0Var == null ? v1.c1.f9255d : l0Var.f5950m;
            tVar = l0Var == null ? this.f5897m : l0Var.f5951n;
            y1.q[] qVarArr = tVar.f10493c;
            b6.d0 d0Var = new b6.d0();
            boolean z10 = false;
            for (y1.q qVar : qVarArr) {
                if (qVar != null) {
                    d1.j0 j0Var = qVar.c(0).f2552k;
                    if (j0Var == null) {
                        d0Var.a(new d1.j0(new d1.i0[0]));
                    } else {
                        d0Var.a(j0Var);
                        z10 = true;
                    }
                }
            }
            if (z10) {
                w0Var = d0Var.f();
            } else {
                b6.e0 e0Var = b6.g0.f1391j;
                w0Var = b6.w0.f1464m;
            }
            list = w0Var;
            if (l0Var != null) {
                m0 m0Var = l0Var.f5944f;
                if (m0Var.f5957c != j9) {
                    l0Var.f5944f = m0Var.a(j9);
                }
            }
            b1[] b1VarArr = this.f5893i;
            l0 l0Var2 = this.f5910z.f5972i;
            if (l0Var2 != null) {
                y1.t tVar2 = l0Var2.f5951n;
                int i10 = 0;
                boolean z11 = false;
                while (true) {
                    if (i10 >= b1VarArr.length) {
                        z9 = true;
                        break;
                    }
                    if (tVar2.b(i10)) {
                        if (((e) b1VarArr[i10]).f5827j != 1) {
                            z9 = false;
                            break;
                        }
                        if (tVar2.f10492b[i10].f5810a != 0) {
                            z11 = true;
                        }
                    }
                    i10++;
                }
                boolean z12 = z11 && z9;
                if (z12 != this.Q) {
                    this.Q = z12;
                    if (!z12 && this.E.f6060o) {
                        this.f5900p.d(2);
                    }
                }
            }
        } else if (!zVar.equals(w0Var2.f6048b)) {
            c1Var = v1.c1.f9255d;
            tVar = this.f5897m;
            list = b6.w0.f1464m;
        }
        v1.c1 c1Var2 = c1Var;
        y1.t tVar3 = tVar;
        List list2 = list;
        if (z8) {
            e0 e0Var2 = this.F;
            if (!e0Var2.f5846d || e0Var2.f5847e == 5) {
                e0Var2.f5843a = true;
                e0Var2.f5846d = true;
                e0Var2.f5847e = i9;
            } else {
                g1.a.f(i9 == 5);
            }
        }
        w0 w0Var3 = this.E;
        long j11 = w0Var3.f6061p;
        l0 l0Var3 = this.f5910z.f5974k;
        return w0Var3.c(zVar, j5, j9, j10, l0Var3 == null ? 0L : Math.max(0L, j11 - (this.T - l0Var3.f5952o)), c1Var2, tVar3, list2);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, v1.x0] */
    public final boolean q() {
        l0 l0Var = this.f5910z.f5974k;
        if (l0Var == null) {
            return false;
        }
        return (!l0Var.f5942d ? 0L : l0Var.f5939a.f()) != Long.MIN_VALUE;
    }

    public final boolean s() {
        l0 l0Var = this.f5910z.f5972i;
        long j5 = l0Var.f5944f.f5959e;
        if (l0Var.f5942d) {
            return j5 == -9223372036854775807L || this.E.f6063r < j5 || !Y();
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object, v1.x] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Object, v1.x0] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, v1.x0] */
    public final void t() {
        boolean c9;
        if (q()) {
            l0 l0Var = this.f5910z.f5974k;
            long f9 = !l0Var.f5942d ? 0L : l0Var.f5939a.f();
            l0 l0Var2 = this.f5910z.f5974k;
            long max = l0Var2 == null ? 0L : Math.max(0L, f9 - (this.T - l0Var2.f5952o));
            l0 l0Var3 = this.f5910z.f5972i;
            c9 = this.f5898n.c(max, this.f5906v.d().f2510a);
            if (!c9 && max < 500000 && this.f5905u > 0) {
                this.f5910z.f5972i.f5939a.s(this.E.f6063r);
                c9 = this.f5898n.c(max, this.f5906v.d().f2510a);
            }
        } else {
            c9 = false;
        }
        this.L = c9;
        if (c9) {
            l0 l0Var4 = this.f5910z.f5974k;
            long j5 = this.T;
            float f10 = this.f5906v.d().f2510a;
            long j9 = this.K;
            g1.a.k(l0Var4.f5949l == null);
            long j10 = j5 - l0Var4.f5952o;
            ?? r02 = l0Var4.f5939a;
            i0 i0Var = new i0();
            i0Var.f5920a = j10;
            g1.a.f(f10 > 0.0f || f10 == -3.4028235E38f);
            i0Var.f5921b = f10;
            g1.a.f(j9 >= 0 || j9 == -9223372036854775807L);
            i0Var.f5922c = j9;
            r02.b(new j0(i0Var));
        }
        d0();
    }

    public final void u() {
        e0 e0Var = this.F;
        w0 w0Var = this.E;
        boolean z8 = e0Var.f5843a | (e0Var.f5844b != w0Var);
        e0Var.f5843a = z8;
        e0Var.f5844b = w0Var;
        if (z8) {
            b0 b0Var = this.f5909y.f6020i;
            b0Var.f5795q.c(new b2.f0(b0Var, 13, e0Var));
            this.F = new e0(this.E);
        }
    }

    public final void v() {
        m(this.A.c(), true);
    }

    public final void w() {
        this.F.a(1);
        throw null;
    }

    public final void x() {
        this.F.a(1);
        D(false, false, false, true);
        this.f5898n.b(false);
        X(this.E.f6047a.p() ? 4 : 2);
        z1.f fVar = this.f5899o;
        fVar.getClass();
        v0 v0Var = this.A;
        ArrayList arrayList = (ArrayList) v0Var.f6034c;
        g1.a.k(!v0Var.f6032a);
        v0Var.f6042l = fVar;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            u0 u0Var = (u0) arrayList.get(i9);
            v0Var.g(u0Var);
            ((HashSet) v0Var.h).add(u0Var);
        }
        v0Var.f6032a = true;
        this.f5900p.d(2);
    }

    public final synchronized boolean y() {
        if (!this.G && this.f5902r.getThread().isAlive()) {
            this.f5900p.d(7);
            j0(new m(this, 3), this.C);
            return this.G;
        }
        return true;
    }

    public final void z() {
        try {
            D(true, false, true, false);
            A();
            this.f5898n.b(true);
            X(1);
            HandlerThread handlerThread = this.f5901q;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            synchronized (this) {
                this.G = true;
                notifyAll();
            }
        } catch (Throwable th) {
            HandlerThread handlerThread2 = this.f5901q;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            synchronized (this) {
                this.G = true;
                notifyAll();
                throw th;
            }
        }
    }
}
