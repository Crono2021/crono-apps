package l1;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.network.tvgramplayer.player.PlayerManager$setupPlayer$renderersFactory$1;
import d1.f1;
import d1.h1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b0 implements p, d1.t0 {
    public final z1.f A;
    public final long B;
    public final long C;
    public final g1.r D;
    public final y E;
    public final z F;
    public final com.bumptech.glide.manager.s G;
    public final d H;
    public final d4.t I;
    public final d4.t J;
    public final long K;
    public int L;
    public boolean M;
    public int N;
    public int O;
    public boolean P;
    public int Q;
    public final d1 R;
    public v1.y0 S;
    public d1.p0 T;
    public d1.h0 U;
    public AudioTrack V;
    public Object W;
    public Surface X;
    public SurfaceHolder Y;
    public c2.l Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f5772a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextureView f5773b0;

    /* renamed from: c0, reason: collision with root package name */
    public final int f5774c0;

    /* renamed from: d0, reason: collision with root package name */
    public final int f5775d0;

    /* renamed from: e0, reason: collision with root package name */
    public g1.q f5776e0;

    /* renamed from: f0, reason: collision with root package name */
    public final int f5777f0;

    /* renamed from: g0, reason: collision with root package name */
    public final d1.g f5778g0;

    /* renamed from: h0, reason: collision with root package name */
    public float f5779h0;
    public boolean i0;

    /* renamed from: j, reason: collision with root package name */
    public final y1.t f5781j;

    /* renamed from: j0, reason: collision with root package name */
    public f1.c f5782j0;

    /* renamed from: k, reason: collision with root package name */
    public final d1.p0 f5783k;

    /* renamed from: k0, reason: collision with root package name */
    public final boolean f5784k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f5786l0;

    /* renamed from: m, reason: collision with root package name */
    public final Context f5787m;

    /* renamed from: m0, reason: collision with root package name */
    public h1 f5788m0;

    /* renamed from: n, reason: collision with root package name */
    public final b0 f5789n;

    /* renamed from: n0, reason: collision with root package name */
    public d1.h0 f5790n0;

    /* renamed from: o, reason: collision with root package name */
    public final b1[] f5791o;

    /* renamed from: o0, reason: collision with root package name */
    public w0 f5792o0;

    /* renamed from: p, reason: collision with root package name */
    public final y1.o f5793p;

    /* renamed from: p0, reason: collision with root package name */
    public int f5794p0;

    /* renamed from: q, reason: collision with root package name */
    public final g1.t f5795q;

    /* renamed from: q0, reason: collision with root package name */
    public long f5796q0;

    /* renamed from: r, reason: collision with root package name */
    public final t f5797r;

    /* renamed from: s, reason: collision with root package name */
    public final h0 f5798s;

    /* renamed from: t, reason: collision with root package name */
    public final g1.m f5799t;

    /* renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArraySet f5800u;

    /* renamed from: v, reason: collision with root package name */
    public final d1.w0 f5801v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f5802w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f5803x;

    /* renamed from: y, reason: collision with root package name */
    public final m1.q f5804y;

    /* renamed from: z, reason: collision with root package name */
    public final Looper f5805z;

    /* renamed from: i, reason: collision with root package name */
    public final d1.x0 f5780i = new d1.x0();

    /* renamed from: l, reason: collision with root package name */
    public final d2.f0 f5785l = new d2.f0();

    static {
        d1.f0.a("media3.exoplayer");
    }

    public b0(o oVar) {
        d1.g gVar;
        boolean equals;
        boolean z8;
        try {
            g1.a.v("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.3.1] [" + g1.w.f3717e + "]");
            this.f5787m = oVar.f5978a.getApplicationContext();
            this.f5804y = new m1.q(oVar.f5979b);
            this.f5778g0 = oVar.f5985i;
            this.f5774c0 = oVar.f5987k;
            this.f5775d0 = oVar.f5988l;
            this.i0 = false;
            this.K = oVar.f5995s;
            y yVar = new y(this);
            this.E = yVar;
            this.F = new z();
            Handler handler = new Handler(oVar.h);
            b1[] createRenderers = ((PlayerManager$setupPlayer$renderersFactory$1) oVar.f5980c.f5954j).createRenderers(handler, yVar, yVar, yVar, yVar);
            this.f5791o = createRenderers;
            g1.a.k(createRenderers.length > 0);
            this.f5793p = (y1.o) oVar.f5982e.get();
            oVar.f5981d.get();
            this.A = (z1.f) oVar.f5984g.get();
            this.f5803x = oVar.f5989m;
            this.R = oVar.f5990n;
            this.B = oVar.f5991o;
            this.C = oVar.f5992p;
            Looper looper = oVar.h;
            this.f5805z = looper;
            g1.r rVar = oVar.f5979b;
            this.D = rVar;
            this.f5789n = this;
            this.f5799t = new g1.m(looper, rVar, new h7.o(this, 7));
            this.f5800u = new CopyOnWriteArraySet();
            this.f5802w = new ArrayList();
            this.S = new v1.y0();
            this.f5781j = new y1.t(new c1[createRenderers.length], new y1.q[createRenderers.length], f1.f2421b, null);
            this.f5801v = new d1.w0();
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32};
            for (int i9 = 0; i9 < 20; i9++) {
                int i10 = iArr[i9];
                g1.a.k(!false);
                sparseBooleanArray.append(i10, true);
            }
            this.f5793p.getClass();
            g1.a.k(!false);
            sparseBooleanArray.append(29, true);
            g1.a.k(!false);
            d1.q qVar = new d1.q(sparseBooleanArray);
            this.f5783k = new d1.p0(qVar);
            SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
            for (int i11 = 0; i11 < qVar.f2516a.size(); i11++) {
                int a9 = qVar.a(i11);
                g1.a.k(!false);
                sparseBooleanArray2.append(a9, true);
            }
            g1.a.k(!false);
            sparseBooleanArray2.append(4, true);
            g1.a.k(!false);
            sparseBooleanArray2.append(10, true);
            g1.a.k(!false);
            this.T = new d1.p0(new d1.q(sparseBooleanArray2));
            this.f5795q = this.D.a(this.f5805z, null);
            t tVar = new t(this);
            this.f5797r = tVar;
            this.f5792o0 = w0.i(this.f5781j);
            this.f5804y.M(this.f5789n, this.f5805z);
            int i12 = g1.w.f3713a;
            this.f5798s = new h0(this.f5791o, this.f5793p, this.f5781j, (i) oVar.f5983f.get(), this.A, this.L, this.M, this.f5804y, this.R, oVar.f5993q, oVar.f5994r, this.f5805z, this.D, tVar, i12 < 31 ? new m1.x() : x.a(this.f5787m, this, oVar.f5996t));
            this.f5779h0 = 1.0f;
            this.L = 0;
            d1.h0 h0Var = d1.h0.f2449y;
            this.U = h0Var;
            this.f5790n0 = h0Var;
            int i13 = -1;
            this.f5794p0 = -1;
            if (i12 < 21) {
                AudioTrack audioTrack = this.V;
                if (audioTrack == null || audioTrack.getAudioSessionId() == 0) {
                    gVar = null;
                } else {
                    this.V.release();
                    gVar = null;
                    this.V = null;
                }
                if (this.V == null) {
                    this.V = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
                }
                this.f5777f0 = this.V.getAudioSessionId();
            } else {
                gVar = null;
                AudioManager audioManager = (AudioManager) this.f5787m.getSystemService("audio");
                if (audioManager != null) {
                    i13 = audioManager.generateAudioSessionId();
                }
                this.f5777f0 = i13;
            }
            this.f5782j0 = f1.c.f3259b;
            this.f5784k0 = true;
            u(this.f5804y);
            z1.f fVar = this.A;
            Handler handler2 = new Handler(this.f5805z);
            m1.q qVar2 = this.f5804y;
            fVar.getClass();
            qVar2.getClass();
            z1.c cVar = fVar.f10557b;
            cVar.getClass();
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) cVar.f10541a;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                z1.b bVar = (z1.b) it.next();
                if (bVar.f10539b == qVar2) {
                    bVar.f10540c = true;
                    copyOnWriteArrayList.remove(bVar);
                }
            }
            ((CopyOnWriteArrayList) cVar.f10541a).add(new z1.b(handler2, qVar2));
            this.f5800u.add(this.E);
            com.bumptech.glide.manager.s sVar = new com.bumptech.glide.manager.s(oVar.f5978a, handler, this.E);
            this.G = sVar;
            sVar.g();
            d dVar = new d(oVar.f5978a, handler, this.E);
            this.H = dVar;
            d1.g gVar2 = oVar.f5986j ? this.f5778g0 : gVar;
            if (!g1.w.a(dVar.f5815d, gVar2)) {
                dVar.f5815d = gVar2;
                int i14 = gVar2 == null ? 0 : 1;
                dVar.f5817f = i14;
                if (i14 != 1 && i14 != 0) {
                    z8 = false;
                    g1.a.e("Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.", z8);
                }
                z8 = true;
                g1.a.e("Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.", z8);
            }
            Context context = oVar.f5978a;
            d4.t tVar2 = new d4.t(19);
            this.I = tVar2;
            Context context2 = oVar.f5978a;
            d4.t tVar3 = new d4.t(20);
            this.J = tVar3;
            this.f5788m0 = h1.f2473e;
            this.f5776e0 = g1.q.f3702c;
            y1.o oVar2 = this.f5793p;
            d1.g gVar3 = this.f5778g0;
            synchronized (oVar2.f10477c) {
                equals = oVar2.f10482i.equals(gVar3);
                oVar2.f10482i = gVar3;
            }
            if (!equals) {
                oVar2.e();
            }
            o0(1, 10, Integer.valueOf(this.f5777f0));
            o0(2, 10, Integer.valueOf(this.f5777f0));
            o0(1, 3, this.f5778g0);
            o0(2, 4, Integer.valueOf(this.f5774c0));
            o0(2, 5, Integer.valueOf(this.f5775d0));
            o0(1, 9, Boolean.valueOf(this.i0));
            o0(2, 7, this.F);
            o0(6, 8, this.F);
            this.f5785l.b();
        } catch (Throwable th) {
            this.f5785l.b();
            throw th;
        }
    }

    public static long K(w0 w0Var) {
        d1.x0 x0Var = new d1.x0();
        d1.w0 w0Var2 = new d1.w0();
        w0Var.f6047a.g(w0Var.f6048b.f9447a, w0Var2);
        long j5 = w0Var.f6049c;
        return j5 == -9223372036854775807L ? w0Var.f6047a.m(w0Var2.f2586c, x0Var, 0L).f2605m : w0Var2.f2588e + j5;
    }

    @Override // d1.t0
    public final int A() {
        y0();
        if (this.f5792o0.f6047a.p()) {
            return 0;
        }
        w0 w0Var = this.f5792o0;
        return w0Var.f6047a.b(w0Var.f6048b.f9447a);
    }

    @Override // d1.t0
    public final f1.c B() {
        y0();
        return this.f5782j0;
    }

    @Override // d1.t0
    public final void C(TextureView textureView) {
        y0();
        if (textureView == null || textureView != this.f5773b0) {
            return;
        }
        f();
    }

    @Override // d1.t0
    public final h1 D() {
        y0();
        return this.f5788m0;
    }

    @Override // d1.t0
    public final void E(d1.r0 r0Var) {
        y0();
        r0Var.getClass();
        g1.m mVar = this.f5799t;
        mVar.f();
        CopyOnWriteArraySet copyOnWriteArraySet = mVar.f3685d;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            g1.l lVar = (g1.l) it.next();
            if (lVar.f3678a.equals(r0Var)) {
                g1.k kVar = mVar.f3684c;
                lVar.f3681d = true;
                if (lVar.f3680c) {
                    lVar.f3680c = false;
                    kVar.b(lVar.f3678a, lVar.f3679b.b());
                }
                copyOnWriteArraySet.remove(lVar);
            }
        }
    }

    @Override // d1.t0
    public final void F() {
        r0(true);
    }

    @Override // d1.t0
    public final void G() {
        n0(I(), -9223372036854775807L, false);
    }

    @Override // d1.t0
    public final int H() {
        y0();
        if (h()) {
            return this.f5792o0.f6048b.f9448b;
        }
        return -1;
    }

    @Override // d1.t0
    public final int I() {
        y0();
        int x6 = x(this.f5792o0);
        if (x6 == -1) {
            return 0;
        }
        return x6;
    }

    @Override // d1.t0
    public final boolean J(int i9) {
        y0();
        return this.T.f2515a.f2516a.get(i9);
    }

    public final boolean L() {
        int e9;
        d1.y0 U = U();
        if (U.p()) {
            e9 = -1;
        } else {
            int I = I();
            y0();
            int i9 = this.L;
            if (i9 == 1) {
                i9 = 0;
            }
            y0();
            e9 = U.e(I, i9, this.M);
        }
        return e9 != -1;
    }

    @Override // d1.t0
    public final void M(final int i9) {
        y0();
        if (this.L != i9) {
            this.L = i9;
            g1.t tVar = this.f5798s.f5900p;
            tVar.getClass();
            g1.s b9 = g1.t.b();
            b9.f3706a = tVar.f3708a.obtainMessage(11, i9, 0);
            b9.b();
            g1.j jVar = new g1.j() { // from class: l1.u
                @Override // g1.j
                public final void a(Object obj) {
                    ((d1.r0) obj).g(i9);
                }
            };
            g1.m mVar = this.f5799t;
            mVar.c(8, jVar);
            u0();
            mVar.b();
        }
    }

    @Override // d1.t0
    public final int N() {
        y0();
        if (h()) {
            return this.f5792o0.f6048b.f9449c;
        }
        return -1;
    }

    @Override // d1.t0
    public final void O(SurfaceView surfaceView) {
        y0();
        if (surfaceView instanceof b2.s) {
            m0();
            s0(surfaceView);
            q0(surfaceView.getHolder());
            return;
        }
        boolean z8 = surfaceView instanceof c2.l;
        y yVar = this.E;
        if (z8) {
            m0();
            this.Z = (c2.l) surfaceView;
            y0 m9 = m(this.F);
            g1.a.k(!m9.f6072g);
            m9.f6069d = 10000;
            c2.l lVar = this.Z;
            g1.a.k(true ^ m9.f6072g);
            m9.f6070e = lVar;
            m9.c();
            this.Z.f1598i.add(yVar);
            s0(this.Z.getVideoSurface());
            q0(surfaceView.getHolder());
            return;
        }
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        y0();
        if (holder == null) {
            f();
            return;
        }
        m0();
        this.f5772a0 = true;
        this.Y = holder;
        holder.addCallback(yVar);
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) {
            s0(null);
            h0(0, 0);
        } else {
            s0(surface);
            Rect surfaceFrame = holder.getSurfaceFrame();
            h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // d1.t0
    public final void P(SurfaceView surfaceView) {
        y0();
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        y0();
        if (holder == null || holder != this.Y) {
            return;
        }
        f();
    }

    public final boolean Q() {
        int k3;
        d1.y0 U = U();
        if (U.p()) {
            k3 = -1;
        } else {
            int I = I();
            y0();
            int i9 = this.L;
            if (i9 == 1) {
                i9 = 0;
            }
            y0();
            k3 = U.k(I, i9, this.M);
        }
        return k3 != -1;
    }

    @Override // d1.t0
    public final int R() {
        y0();
        return this.f5792o0.f6058m;
    }

    @Override // d1.t0
    public final int S() {
        y0();
        return this.L;
    }

    public final boolean T() {
        d1.y0 U = U();
        return !U.p() && U.m(I(), this.f5780i, 0L).f2601i;
    }

    @Override // d1.t0
    public final d1.y0 U() {
        y0();
        return this.f5792o0.f6047a;
    }

    public final boolean V() {
        d1.y0 U = U();
        return !U.p() && U.m(I(), this.f5780i, 0L).a();
    }

    @Override // d1.t0
    public final Looper W() {
        return this.f5805z;
    }

    @Override // d1.t0
    public final boolean X() {
        y0();
        return this.M;
    }

    @Override // d1.t0
    public final d1.d1 Y() {
        y0();
        return this.f5793p.c();
    }

    @Override // d1.t0
    public final long Z() {
        y0();
        if (this.f5792o0.f6047a.p()) {
            return this.f5796q0;
        }
        w0 w0Var = this.f5792o0;
        long j5 = 0;
        if (w0Var.f6056k.f9450d != w0Var.f6048b.f9450d) {
            return g1.w.W(w0Var.f6047a.m(I(), this.f5780i, 0L).f2606n);
        }
        long j9 = w0Var.f6061p;
        if (this.f5792o0.f6056k.b()) {
            w0 w0Var2 = this.f5792o0;
            w0Var2.f6047a.g(w0Var2.f6056k.f9447a, this.f5801v).d(this.f5792o0.f6056k.f9448b);
        } else {
            j5 = j9;
        }
        w0 w0Var3 = this.f5792o0;
        d1.y0 y0Var = w0Var3.f6047a;
        Object obj = w0Var3.f6056k.f9447a;
        d1.w0 w0Var4 = this.f5801v;
        y0Var.g(obj, w0Var4);
        return g1.w.W(j5 + w0Var4.f2588e);
    }

    public final ArrayList a(int i9, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            u0 u0Var = new u0((v1.a) list.get(i10), this.f5803x);
            arrayList.add(u0Var);
            a0 a0Var = new a0(u0Var.f6026b, u0Var.f6025a);
            this.f5802w.add(i10 + i9, a0Var);
        }
        this.S = this.S.a(i9, arrayList.size());
        return arrayList;
    }

    public final boolean a0() {
        d1.y0 U = U();
        return !U.p() && U.m(I(), this.f5780i, 0L).h;
    }

    @Override // d1.t0
    public final void b() {
        y0();
        boolean p5 = p();
        int c9 = this.H.c(2, p5);
        v0(c9, (!p5 || c9 == 1) ? 1 : 2, p5);
        w0 w0Var = this.f5792o0;
        if (w0Var.f6051e != 1) {
            return;
        }
        w0 e9 = w0Var.e(null);
        w0 g9 = e9.g(e9.f6047a.p() ? 4 : 2);
        this.N++;
        g1.t tVar = this.f5798s.f5900p;
        tVar.getClass();
        g1.s b9 = g1.t.b();
        b9.f3706a = tVar.f3708a.obtainMessage(0);
        b9.b();
        w0(g9, 1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public final w0 b0(w0 w0Var, d1.y0 y0Var, Pair pair) {
        List list;
        g1.a.f(y0Var.p() || pair != null);
        d1.y0 y0Var2 = w0Var.f6047a;
        long o8 = o(w0Var);
        w0 h = w0Var.h(y0Var);
        if (y0Var.p()) {
            v1.z zVar = w0.f6046t;
            long M = g1.w.M(this.f5796q0);
            w0 b9 = h.c(zVar, M, M, M, 0L, v1.c1.f9255d, this.f5781j, b6.w0.f1464m).b(zVar);
            b9.f6061p = b9.f6063r;
            return b9;
        }
        Object obj = h.f6048b.f9447a;
        boolean equals = obj.equals(pair.first);
        v1.z zVar2 = !equals ? new v1.z(pair.first) : h.f6048b;
        long longValue = ((Long) pair.second).longValue();
        long M2 = g1.w.M(o8);
        if (!y0Var2.p()) {
            M2 -= y0Var2.g(obj, this.f5801v).f2588e;
        }
        if (!equals || longValue < M2) {
            v1.z zVar3 = zVar2;
            g1.a.k(!zVar3.b());
            v1.c1 c1Var = !equals ? v1.c1.f9255d : h.h;
            y1.t tVar = !equals ? this.f5781j : h.f6054i;
            if (equals) {
                list = h.f6055j;
            } else {
                b6.e0 e0Var = b6.g0.f1391j;
                list = b6.w0.f1464m;
            }
            w0 b10 = h.c(zVar3, longValue, longValue, longValue, 0L, c1Var, tVar, list).b(zVar3);
            b10.f6061p = longValue;
            return b10;
        }
        if (longValue != M2) {
            v1.z zVar4 = zVar2;
            g1.a.k(!zVar4.b());
            long max = Math.max(0L, h.f6062q - (longValue - M2));
            long j5 = h.f6061p;
            if (h.f6056k.equals(h.f6048b)) {
                j5 = longValue + max;
            }
            w0 c9 = h.c(zVar4, longValue, longValue, longValue, max, h.h, h.f6054i, h.f6055j);
            c9.f6061p = j5;
            return c9;
        }
        int b11 = y0Var.b(h.f6056k.f9447a);
        if (b11 != -1 && y0Var.f(b11, this.f5801v, false).f2586c == y0Var.g(zVar2.f9447a, this.f5801v).f2586c) {
            return h;
        }
        y0Var.g(zVar2.f9447a, this.f5801v);
        boolean b12 = zVar2.b();
        d1.w0 w0Var2 = this.f5801v;
        long a9 = b12 ? w0Var2.a(zVar2.f9448b, zVar2.f9449c) : w0Var2.f2587d;
        v1.z zVar5 = zVar2;
        w0 b13 = h.c(zVar5, h.f6063r, h.f6063r, h.f6050d, a9 - h.f6063r, h.h, h.f6054i, h.f6055j).b(zVar5);
        b13.f6061p = a9;
        return b13;
    }

    public final d1.h0 c() {
        d1.y0 U = U();
        if (U.p()) {
            return this.f5790n0;
        }
        d1.e0 e0Var = U.m(I(), this.f5780i, 0L).f2596c;
        d1.g0 a9 = this.f5790n0.a();
        d1.h0 h0Var = e0Var.f2411d;
        if (h0Var != null) {
            byte[] bArr = h0Var.f2455f;
            CharSequence charSequence = h0Var.f2450a;
            if (charSequence != null) {
                a9.f2426a = charSequence;
            }
            CharSequence charSequence2 = h0Var.f2451b;
            if (charSequence2 != null) {
                a9.f2427b = charSequence2;
            }
            CharSequence charSequence3 = h0Var.f2452c;
            if (charSequence3 != null) {
                a9.f2428c = charSequence3;
            }
            CharSequence charSequence4 = h0Var.f2453d;
            if (charSequence4 != null) {
                a9.f2429d = charSequence4;
            }
            CharSequence charSequence5 = h0Var.f2454e;
            if (charSequence5 != null) {
                a9.f2430e = charSequence5;
            }
            if (bArr != null) {
                Integer num = h0Var.f2456g;
                a9.f2431f = bArr == null ? null : (byte[]) bArr.clone();
                a9.f2432g = num;
            }
            Integer num2 = h0Var.h;
            if (num2 != null) {
                a9.h = num2;
            }
            Integer num3 = h0Var.f2457i;
            if (num3 != null) {
                a9.f2433i = num3;
            }
            Integer num4 = h0Var.f2458j;
            if (num4 != null) {
                a9.f2434j = num4;
            }
            Boolean bool = h0Var.f2459k;
            if (bool != null) {
                a9.f2435k = bool;
            }
            Integer num5 = h0Var.f2460l;
            if (num5 != null) {
                a9.f2436l = num5;
            }
            Integer num6 = h0Var.f2461m;
            if (num6 != null) {
                a9.f2436l = num6;
            }
            Integer num7 = h0Var.f2462n;
            if (num7 != null) {
                a9.f2437m = num7;
            }
            Integer num8 = h0Var.f2463o;
            if (num8 != null) {
                a9.f2438n = num8;
            }
            Integer num9 = h0Var.f2464p;
            if (num9 != null) {
                a9.f2439o = num9;
            }
            Integer num10 = h0Var.f2465q;
            if (num10 != null) {
                a9.f2440p = num10;
            }
            Integer num11 = h0Var.f2466r;
            if (num11 != null) {
                a9.f2441q = num11;
            }
            CharSequence charSequence6 = h0Var.f2467s;
            if (charSequence6 != null) {
                a9.f2442r = charSequence6;
            }
            CharSequence charSequence7 = h0Var.f2468t;
            if (charSequence7 != null) {
                a9.f2443s = charSequence7;
            }
            CharSequence charSequence8 = h0Var.f2469u;
            if (charSequence8 != null) {
                a9.f2444t = charSequence8;
            }
            CharSequence charSequence9 = h0Var.f2470v;
            if (charSequence9 != null) {
                a9.f2445u = charSequence9;
            }
            CharSequence charSequence10 = h0Var.f2471w;
            if (charSequence10 != null) {
                a9.f2446v = charSequence10;
            }
            Integer num12 = h0Var.f2472x;
            if (num12 != null) {
                a9.f2447w = num12;
            }
        }
        return new d1.h0(a9);
    }

    @Override // d1.t0
    public final void c0() {
        int e9;
        if (U().p() || h()) {
            return;
        }
        if (!L()) {
            if (V() && T()) {
                n0(I(), -9223372036854775807L, false);
                return;
            }
            return;
        }
        d1.y0 U = U();
        if (U.p()) {
            e9 = -1;
        } else {
            int I = I();
            y0();
            int i9 = this.L;
            if (i9 == 1) {
                i9 = 0;
            }
            y0();
            e9 = U.e(I, i9, this.M);
        }
        if (e9 == -1) {
            return;
        }
        if (e9 == I()) {
            n0(I(), -9223372036854775807L, true);
        } else {
            n0(e9, -9223372036854775807L, false);
        }
    }

    @Override // d1.t0
    public final d1.o0 d() {
        y0();
        return this.f5792o0.f6059n;
    }

    @Override // d1.t0
    public final void d0() {
        y0();
        long currentPosition = getCurrentPosition() + this.C;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        n0(I(), Math.max(currentPosition, 0L), false);
    }

    @Override // d1.t0
    public final void e(d1.o0 o0Var) {
        y0();
        if (this.f5792o0.f6059n.equals(o0Var)) {
            return;
        }
        w0 f9 = this.f5792o0.f(o0Var);
        this.N++;
        this.f5798s.f5900p.a(4, o0Var).b();
        w0(f9, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    public final Pair e0(d1.y0 y0Var, int i9, long j5) {
        if (y0Var.p()) {
            this.f5794p0 = i9;
            if (j5 == -9223372036854775807L) {
                j5 = 0;
            }
            this.f5796q0 = j5;
            return null;
        }
        if (i9 == -1 || i9 >= y0Var.o()) {
            i9 = y0Var.a(this.M);
            j5 = g1.w.W(y0Var.m(i9, this.f5780i, 0L).f2605m);
        }
        return y0Var.i(this.f5780i, this.f5801v, i9, g1.w.M(j5));
    }

    public final void f() {
        y0();
        m0();
        s0(null);
        h0(0, 0);
    }

    @Override // d1.t0
    public final void f0(TextureView textureView) {
        y0();
        if (textureView == null) {
            f();
            return;
        }
        m0();
        this.f5773b0 = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            g1.a.D("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.E);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            s0(null);
            h0(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            s0(surface);
            this.X = surface;
            h0(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // d1.t0
    public final d1.n0 g() {
        y0();
        return this.f5792o0.f6052f;
    }

    @Override // d1.t0
    public final void g0() {
        y0();
        long currentPosition = getCurrentPosition() + (-this.B);
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        n0(I(), Math.max(currentPosition, 0L), false);
    }

    @Override // d1.t0
    public final long getCurrentPosition() {
        y0();
        return g1.w.W(s(this.f5792o0));
    }

    @Override // d1.t0
    public final long getDuration() {
        y0();
        if (!h()) {
            return z();
        }
        w0 w0Var = this.f5792o0;
        v1.z zVar = w0Var.f6048b;
        d1.y0 y0Var = w0Var.f6047a;
        Object obj = zVar.f9447a;
        d1.w0 w0Var2 = this.f5801v;
        y0Var.g(obj, w0Var2);
        return g1.w.W(w0Var2.a(zVar.f9448b, zVar.f9449c));
    }

    @Override // d1.t0
    public final boolean h() {
        y0();
        return this.f5792o0.f6048b.b();
    }

    public final void h0(final int i9, final int i10) {
        g1.q qVar = this.f5776e0;
        if (i9 == qVar.f3703a && i10 == qVar.f3704b) {
            return;
        }
        this.f5776e0 = new g1.q(i9, i10);
        this.f5799t.e(24, new g1.j() { // from class: l1.s
            @Override // g1.j
            public final void a(Object obj) {
                ((d1.r0) obj).x(i9, i10);
            }
        });
        o0(2, 14, new g1.q(i9, i10));
    }

    @Override // d1.t0
    public final long i() {
        y0();
        return this.C;
    }

    @Override // d1.t0
    public final d1.h0 i0() {
        y0();
        return this.U;
    }

    @Override // d1.t0
    public final boolean isPlaying() {
        return t() == 3 && p() && R() == 0;
    }

    @Override // d1.t0
    public final long j() {
        y0();
        return o(this.f5792o0);
    }

    @Override // d1.t0
    public final void j0() {
        int k3;
        int k9;
        if (U().p() || h()) {
            return;
        }
        boolean Q = Q();
        if (V() && !a0()) {
            if (Q) {
                d1.y0 U = U();
                if (U.p()) {
                    k9 = -1;
                } else {
                    int I = I();
                    y0();
                    int i9 = this.L;
                    if (i9 == 1) {
                        i9 = 0;
                    }
                    y0();
                    k9 = U.k(I, i9, this.M);
                }
                if (k9 == -1) {
                    return;
                }
                if (k9 == I()) {
                    n0(I(), -9223372036854775807L, true);
                    return;
                } else {
                    n0(k9, -9223372036854775807L, false);
                    return;
                }
            }
            return;
        }
        if (Q) {
            long currentPosition = getCurrentPosition();
            y0();
            if (currentPosition <= 3000) {
                d1.y0 U2 = U();
                if (U2.p()) {
                    k3 = -1;
                } else {
                    int I2 = I();
                    y0();
                    int i10 = this.L;
                    if (i10 == 1) {
                        i10 = 0;
                    }
                    y0();
                    k3 = U2.k(I2, i10, this.M);
                }
                if (k3 == -1) {
                    return;
                }
                if (k3 == I()) {
                    n0(I(), -9223372036854775807L, true);
                    return;
                } else {
                    n0(k3, -9223372036854775807L, false);
                    return;
                }
            }
        }
        n0(I(), 0L, false);
    }

    @Override // d1.t0
    public final long k() {
        y0();
        return g1.w.W(this.f5792o0.f6062q);
    }

    @Override // d1.t0
    public final long k0() {
        y0();
        return this.B;
    }

    @Override // d1.t0
    public final void l(int i9, long j5) {
        n0(i9, j5, false);
    }

    public final void l0(int i9) {
        for (int i10 = i9 - 1; i10 >= 0; i10--) {
            this.f5802w.remove(i10);
        }
        v1.y0 y0Var = this.S;
        int[] iArr = y0Var.f9445b;
        int[] iArr2 = new int[iArr.length - i9];
        int i11 = 0;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            int i13 = iArr[i12];
            if (i13 < 0 || i13 >= i9) {
                int i14 = i12 - i11;
                if (i13 >= 0) {
                    i13 -= i9;
                }
                iArr2[i14] = i13;
            } else {
                i11++;
            }
        }
        this.S = new v1.y0(iArr2, new Random(y0Var.f9444a.nextLong()));
    }

    public final y0 m(x0 x0Var) {
        int x6 = x(this.f5792o0);
        d1.y0 y0Var = this.f5792o0.f6047a;
        int i9 = x6 == -1 ? 0 : x6;
        g1.r rVar = this.D;
        h0 h0Var = this.f5798s;
        return new y0(h0Var, x0Var, y0Var, i9, rVar, h0Var.f5902r);
    }

    public final void m0() {
        c2.l lVar = this.Z;
        y yVar = this.E;
        if (lVar != null) {
            y0 m9 = m(this.F);
            g1.a.k(!m9.f6072g);
            m9.f6069d = 10000;
            g1.a.k(!m9.f6072g);
            m9.f6070e = null;
            m9.c();
            this.Z.f1598i.remove(yVar);
            this.Z = null;
        }
        TextureView textureView = this.f5773b0;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != yVar) {
                g1.a.D("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f5773b0.setSurfaceTextureListener(null);
            }
            this.f5773b0 = null;
        }
        SurfaceHolder surfaceHolder = this.Y;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(yVar);
            this.Y = null;
        }
    }

    @Override // d1.t0
    public final void n(d1.d1 d1Var) {
        y0();
        y1.o oVar = this.f5793p;
        oVar.getClass();
        if (d1Var.equals(oVar.c())) {
            return;
        }
        oVar.j(d1Var);
        this.f5799t.e(19, new a3.i(d1Var, 12));
    }

    public final void n0(int i9, long j5, boolean z8) {
        y0();
        g1.a.f(i9 >= 0);
        m1.q qVar = this.f5804y;
        if (!qVar.f6559q) {
            m1.a G = qVar.G();
            qVar.f6559q = true;
            qVar.L(G, -1, new h7.o((Object) G, 16));
        }
        d1.y0 y0Var = this.f5792o0.f6047a;
        if (y0Var.p() || i9 < y0Var.o()) {
            this.N++;
            if (h()) {
                g1.a.D("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                e0 e0Var = new e0(this.f5792o0);
                e0Var.a(1);
                b0 b0Var = this.f5797r.f6020i;
                b0Var.f5795q.c(new b2.f0(b0Var, 13, e0Var));
                return;
            }
            w0 w0Var = this.f5792o0;
            int i10 = w0Var.f6051e;
            if (i10 == 3 || (i10 == 4 && !y0Var.p())) {
                w0Var = this.f5792o0.g(2);
            }
            int I = I();
            w0 b02 = b0(w0Var, y0Var, e0(y0Var, i9, j5));
            this.f5798s.f5900p.a(3, new g0(y0Var, i9, g1.w.M(j5))).b();
            w0(b02, 0, 1, true, 1, s(b02), I, z8);
        }
    }

    public final long o(w0 w0Var) {
        v1.z zVar = w0Var.f6048b;
        long j5 = w0Var.f6049c;
        d1.y0 y0Var = w0Var.f6047a;
        if (!zVar.b()) {
            return g1.w.W(s(w0Var));
        }
        Object obj = w0Var.f6048b.f9447a;
        d1.w0 w0Var2 = this.f5801v;
        y0Var.g(obj, w0Var2);
        if (j5 == -9223372036854775807L) {
            return g1.w.W(y0Var.m(x(w0Var), this.f5780i, 0L).f2605m);
        }
        return g1.w.W(j5) + g1.w.W(w0Var2.f2588e);
    }

    public final void o0(int i9, int i10, Object obj) {
        for (b1 b1Var : this.f5791o) {
            if (((e) b1Var).f5827j == i9) {
                y0 m9 = m(b1Var);
                g1.a.k(!m9.f6072g);
                m9.f6069d = i10;
                g1.a.k(!m9.f6072g);
                m9.f6070e = obj;
                m9.c();
            }
        }
    }

    @Override // d1.t0
    public final boolean p() {
        y0();
        return this.f5792o0.f6057l;
    }

    public final void p0(List list, boolean z8) {
        y0();
        int x6 = x(this.f5792o0);
        long currentPosition = getCurrentPosition();
        this.N++;
        ArrayList arrayList = this.f5802w;
        if (!arrayList.isEmpty()) {
            l0(arrayList.size());
        }
        ArrayList a9 = a(0, list);
        a1 a1Var = new a1(arrayList, this.S);
        boolean p5 = a1Var.p();
        int i9 = a1Var.f5766d;
        if (!p5 && -1 >= i9) {
            throw new d1.u();
        }
        if (z8) {
            x6 = a1Var.a(this.M);
            currentPosition = -9223372036854775807L;
        }
        w0 b02 = b0(this.f5792o0, a1Var, e0(a1Var, x6, currentPosition));
        int i10 = b02.f6051e;
        if (x6 != -1 && i10 != 1) {
            i10 = (a1Var.p() || x6 >= i9) ? 4 : 2;
        }
        w0 g9 = b02.g(i10);
        this.f5798s.f5900p.a(17, new d0(a9, this.S, x6, g1.w.M(currentPosition))).b();
        w0(g9, 0, 1, (this.f5792o0.f6048b.f9447a.equals(g9.f6048b.f9447a) || this.f5792o0.f6047a.p()) ? false : true, 4, s(g9), -1, false);
    }

    @Override // d1.t0
    public final void pause() {
        r0(false);
    }

    @Override // d1.t0
    public final void q() {
        y0();
        ArrayList arrayList = this.f5802w;
        int size = arrayList.size();
        int min = Math.min(Integer.MAX_VALUE, size);
        if (size <= 0 || min == 0) {
            return;
        }
        w0 w0Var = this.f5792o0;
        int x6 = x(w0Var);
        long o8 = o(w0Var);
        d1.y0 y0Var = w0Var.f6047a;
        int size2 = arrayList.size();
        this.N++;
        l0(min);
        a1 a1Var = new a1(arrayList, this.S);
        w0 b02 = b0(w0Var, a1Var, y(y0Var, a1Var, x6, o8));
        int i9 = b02.f6051e;
        if (i9 != 1 && i9 != 4 && min > 0 && min == size2 && x6 >= b02.f6047a.o()) {
            b02 = b02.g(4);
        }
        v1.y0 y0Var2 = this.S;
        g1.t tVar = this.f5798s.f5900p;
        tVar.getClass();
        g1.s b9 = g1.t.b();
        b9.f3706a = tVar.f3708a.obtainMessage(20, 0, min, y0Var2);
        b9.b();
        w0(b02, 0, 1, !b02.f6048b.f9447a.equals(this.f5792o0.f6048b.f9447a), 4, s(b02), -1, false);
    }

    public final void q0(SurfaceHolder surfaceHolder) {
        this.f5772a0 = false;
        this.Y = surfaceHolder;
        surfaceHolder.addCallback(this.E);
        Surface surface = this.Y.getSurface();
        if (surface == null || !surface.isValid()) {
            h0(0, 0);
        } else {
            Rect surfaceFrame = this.Y.getSurfaceFrame();
            h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // d1.t0
    public final void r(boolean z8) {
        y0();
        if (this.M != z8) {
            this.M = z8;
            g1.t tVar = this.f5798s.f5900p;
            tVar.getClass();
            g1.s b9 = g1.t.b();
            b9.f3706a = tVar.f3708a.obtainMessage(12, z8 ? 1 : 0, 0);
            b9.b();
            v vVar = new v(z8, 0);
            g1.m mVar = this.f5799t;
            mVar.c(9, vVar);
            u0();
            mVar.b();
        }
    }

    public final void r0(boolean z8) {
        y0();
        int c9 = this.H.c(t(), z8);
        int i9 = 1;
        if (z8 && c9 != 1) {
            i9 = 2;
        }
        v0(c9, i9, z8);
    }

    public final long s(w0 w0Var) {
        if (w0Var.f6047a.p()) {
            return g1.w.M(this.f5796q0);
        }
        long j5 = w0Var.f6060o ? w0Var.j() : w0Var.f6063r;
        if (w0Var.f6048b.b()) {
            return j5;
        }
        d1.y0 y0Var = w0Var.f6047a;
        Object obj = w0Var.f6048b.f9447a;
        d1.w0 w0Var2 = this.f5801v;
        y0Var.g(obj, w0Var2);
        return j5 + w0Var2.f2588e;
    }

    public final void s0(Object obj) {
        ArrayList arrayList = new ArrayList();
        boolean z8 = false;
        for (b1 b1Var : this.f5791o) {
            if (((e) b1Var).f5827j == 2) {
                y0 m9 = m(b1Var);
                g1.a.k(!m9.f6072g);
                m9.f6069d = 1;
                g1.a.k(true ^ m9.f6072g);
                m9.f6070e = obj;
                m9.c();
                arrayList.add(m9);
            }
        }
        Object obj2 = this.W;
        if (obj2 != null && obj2 != obj) {
            try {
                int size = arrayList.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj3 = arrayList.get(i9);
                    i9++;
                    ((y0) obj3).a(this.K);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z8 = true;
            }
            Object obj4 = this.W;
            Surface surface = this.X;
            if (obj4 == surface) {
                surface.release();
                this.X = null;
            }
        }
        this.W = obj;
        if (z8) {
            t0(new l(2, new androidx.fragment.app.r("Detaching surface timed out."), 1003));
        }
    }

    @Override // d1.t0
    public final void seekTo(long j5) {
        n0(I(), j5, false);
    }

    @Override // d1.t0
    public final void stop() {
        y0();
        this.H.c(1, p());
        t0(null);
        b6.w0 w0Var = b6.w0.f1464m;
        long j5 = this.f5792o0.f6063r;
        this.f5782j0 = new f1.c(w0Var);
    }

    @Override // d1.t0
    public final int t() {
        y0();
        return this.f5792o0.f6051e;
    }

    public final void t0(l lVar) {
        w0 w0Var = this.f5792o0;
        w0 b9 = w0Var.b(w0Var.f6048b);
        b9.f6061p = b9.f6063r;
        b9.f6062q = 0L;
        w0 g9 = b9.g(1);
        if (lVar != null) {
            g9 = g9.e(lVar);
        }
        w0 w0Var2 = g9;
        this.N++;
        g1.t tVar = this.f5798s.f5900p;
        tVar.getClass();
        g1.s b10 = g1.t.b();
        b10.f3706a = tVar.f3708a.obtainMessage(6);
        b10.b();
        w0(w0Var2, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // d1.t0
    public final void u(d1.r0 r0Var) {
        r0Var.getClass();
        this.f5799t.a(r0Var);
    }

    public final void u0() {
        d1.p0 p0Var = this.T;
        int i9 = g1.w.f3713a;
        b0 b0Var = this.f5789n;
        boolean h = b0Var.h();
        boolean a02 = b0Var.a0();
        boolean Q = b0Var.Q();
        boolean L = b0Var.L();
        boolean V = b0Var.V();
        boolean T = b0Var.T();
        boolean p5 = b0Var.U().p();
        a0.b bVar = new a0.b(15);
        d1.p pVar = (d1.p) bVar.f8j;
        d1.q qVar = this.f5783k.f2515a;
        pVar.getClass();
        boolean z8 = false;
        for (int i10 = 0; i10 < qVar.f2516a.size(); i10++) {
            pVar.a(qVar.a(i10));
        }
        boolean z9 = !h;
        bVar.e(4, z9);
        bVar.e(5, a02 && !h);
        bVar.e(6, Q && !h);
        bVar.e(7, !p5 && (Q || !V || a02) && !h);
        bVar.e(8, L && !h);
        bVar.e(9, !p5 && (L || (V && T)) && !h);
        bVar.e(10, z9);
        bVar.e(11, a02 && !h);
        if (a02 && !h) {
            z8 = true;
        }
        bVar.e(12, z8);
        d1.p0 p0Var2 = new d1.p0(pVar.b());
        this.T = p0Var2;
        if (p0Var2.equals(p0Var)) {
            return;
        }
        this.f5799t.c(13, new t(this));
    }

    @Override // d1.t0
    public final f1 v() {
        y0();
        return this.f5792o0.f6054i.f10494d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    public final void v0(int i9, int i10, boolean z8) {
        int i11 = 0;
        ?? r15 = (!z8 || i9 == -1) ? 0 : 1;
        if (r15 != 0 && i9 != 1) {
            i11 = 1;
        }
        w0 w0Var = this.f5792o0;
        if (w0Var.f6057l == r15 && w0Var.f6058m == i11) {
            return;
        }
        this.N++;
        w0 w0Var2 = this.f5792o0;
        boolean z9 = w0Var2.f6060o;
        w0 w0Var3 = w0Var2;
        if (z9) {
            w0Var3 = w0Var2.a();
        }
        w0 d9 = w0Var3.d(i11, r15);
        g1.t tVar = this.f5798s.f5900p;
        tVar.getClass();
        g1.s b9 = g1.t.b();
        b9.f3706a = tVar.f3708a.obtainMessage(1, r15, i11);
        b9.b();
        w0(d9, 0, i10, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // d1.t0
    public final int w() {
        long Z;
        y0();
        if (h()) {
            w0 w0Var = this.f5792o0;
            Z = w0Var.f6056k.equals(w0Var.f6048b) ? g1.w.W(this.f5792o0.f6061p) : getDuration();
        } else {
            Z = Z();
        }
        long duration = getDuration();
        if (Z == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return g1.w.h((int) ((Z * 100) / duration), 0, 100);
    }

    public final void w0(final w0 w0Var, final int i9, final int i10, boolean z8, int i11, long j5, int i12, boolean z9) {
        Pair pair;
        int i13;
        d1.e0 e0Var;
        boolean z10;
        boolean z11;
        boolean z12;
        int i14;
        Object obj;
        d1.e0 e0Var2;
        Object obj2;
        int i15;
        long j9;
        long j10;
        long j11;
        long K;
        Object obj3;
        d1.e0 e0Var3;
        Object obj4;
        int i16;
        w0 w0Var2 = this.f5792o0;
        this.f5792o0 = w0Var;
        boolean equals = w0Var2.f6047a.equals(w0Var.f6047a);
        d1.x0 x0Var = this.f5780i;
        d1.w0 w0Var3 = this.f5801v;
        d1.y0 y0Var = w0Var2.f6047a;
        v1.z zVar = w0Var2.f6048b;
        d1.y0 y0Var2 = w0Var.f6047a;
        v1.z zVar2 = w0Var.f6048b;
        if (y0Var2.p() && y0Var.p()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (y0Var2.p() != y0Var.p()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (y0Var.m(y0Var.g(zVar.f9447a, w0Var3).f2586c, x0Var, 0L).f2594a.equals(y0Var2.m(y0Var2.g(zVar2.f9447a, w0Var3).f2586c, x0Var, 0L).f2594a)) {
            pair = (z8 && i11 == 0 && zVar.f9450d < zVar2.f9450d) ? new Pair(Boolean.TRUE, 0) : (z8 && i11 == 1 && z9) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        } else {
            if (z8 && i11 == 0) {
                i13 = 1;
            } else if (z8 && i11 == 1) {
                i13 = 2;
            } else {
                if (equals) {
                    androidx.fragment.app.a.l();
                    return;
                }
                i13 = 3;
            }
            pair = new Pair(Boolean.TRUE, Integer.valueOf(i13));
        }
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        int intValue = ((Integer) pair.second).intValue();
        if (booleanValue) {
            e0Var = !w0Var.f6047a.p() ? w0Var.f6047a.m(w0Var.f6047a.g(w0Var.f6048b.f9447a, this.f5801v).f2586c, this.f5780i, 0L).f2596c : null;
            this.f5790n0 = d1.h0.f2449y;
        } else {
            e0Var = null;
        }
        if (booleanValue || !w0Var2.f6055j.equals(w0Var.f6055j)) {
            d1.g0 a9 = this.f5790n0.a();
            List list = w0Var.f6055j;
            for (int i17 = 0; i17 < list.size(); i17++) {
                d1.j0 j0Var = (d1.j0) list.get(i17);
                int i18 = 0;
                while (true) {
                    d1.i0[] i0VarArr = j0Var.f2490i;
                    if (i18 < i0VarArr.length) {
                        i0VarArr[i18].a(a9);
                        i18++;
                    }
                }
            }
            this.f5790n0 = new d1.h0(a9);
        }
        d1.h0 c9 = c();
        boolean equals2 = c9.equals(this.U);
        this.U = c9;
        boolean z13 = w0Var2.f6057l != w0Var.f6057l;
        boolean z14 = w0Var2.f6051e != w0Var.f6051e;
        if (z14 || z13) {
            x0();
        }
        boolean z15 = w0Var2.f6053g != w0Var.f6053g;
        if (!equals) {
            final int i19 = 0;
            this.f5799t.c(0, new g1.j() { // from class: l1.w
                @Override // g1.j
                public final void a(Object obj5) {
                    d1.r0 r0Var = (d1.r0) obj5;
                    switch (i19) {
                        case 0:
                            r0Var.E(w0Var.f6047a, i9);
                            break;
                        default:
                            r0Var.p(i9, w0Var.f6057l);
                            break;
                    }
                }
            });
        }
        if (z8) {
            d1.w0 w0Var4 = new d1.w0();
            if (w0Var2.f6047a.p()) {
                z10 = booleanValue;
                z11 = equals2;
                z12 = z14;
                i14 = i12;
                obj = null;
                e0Var2 = null;
                obj2 = null;
                i15 = -1;
            } else {
                Object obj5 = w0Var2.f6048b.f9447a;
                w0Var2.f6047a.g(obj5, w0Var4);
                int i20 = w0Var4.f2586c;
                int b9 = w0Var2.f6047a.b(obj5);
                z10 = booleanValue;
                z11 = equals2;
                z12 = z14;
                obj = w0Var2.f6047a.m(i20, this.f5780i, 0L).f2594a;
                e0Var2 = this.f5780i.f2596c;
                obj2 = obj5;
                i14 = i20;
                i15 = b9;
            }
            v1.z zVar3 = w0Var2.f6048b;
            if (i11 == 0) {
                boolean b10 = zVar3.b();
                v1.z zVar4 = w0Var2.f6048b;
                if (b10) {
                    j11 = w0Var4.a(zVar4.f9448b, zVar4.f9449c);
                    K = K(w0Var2);
                } else if (zVar4.f9451e != -1) {
                    j11 = K(this.f5792o0);
                    K = j11;
                } else {
                    j9 = w0Var4.f2588e;
                    j10 = w0Var4.f2587d;
                    j11 = j9 + j10;
                    K = j11;
                }
            } else if (zVar3.b()) {
                j11 = w0Var2.f6063r;
                K = K(w0Var2);
            } else {
                j9 = w0Var4.f2588e;
                j10 = w0Var2.f6063r;
                j11 = j9 + j10;
                K = j11;
            }
            long W = g1.w.W(j11);
            long W2 = g1.w.W(K);
            v1.z zVar5 = w0Var2.f6048b;
            d1.s0 s0Var = new d1.s0(obj, i14, e0Var2, obj2, i15, W, W2, zVar5.f9448b, zVar5.f9449c);
            d1.x0 x0Var2 = this.f5780i;
            int I = I();
            if (this.f5792o0.f6047a.p()) {
                obj3 = null;
                e0Var3 = null;
                obj4 = null;
                i16 = -1;
            } else {
                w0 w0Var5 = this.f5792o0;
                Object obj6 = w0Var5.f6048b.f9447a;
                w0Var5.f6047a.g(obj6, this.f5801v);
                int b11 = this.f5792o0.f6047a.b(obj6);
                Object obj7 = this.f5792o0.f6047a.m(I, x0Var2, 0L).f2594a;
                e0Var3 = x0Var2.f2596c;
                i16 = b11;
                obj4 = obj6;
                obj3 = obj7;
            }
            long W3 = g1.w.W(j5);
            long W4 = this.f5792o0.f6048b.b() ? g1.w.W(K(this.f5792o0)) : W3;
            v1.z zVar6 = this.f5792o0.f6048b;
            this.f5799t.c(11, new h7.b(s0Var, i11, new d1.s0(obj3, I, e0Var3, obj4, i16, W3, W4, zVar6.f9448b, zVar6.f9449c)));
        } else {
            z10 = booleanValue;
            z11 = equals2;
            z12 = z14;
        }
        if (z10) {
            this.f5799t.c(1, new h7.c0(e0Var, intValue));
        }
        if (w0Var2.f6052f != w0Var.f6052f) {
            final int i21 = 3;
            this.f5799t.c(10, new g1.j() { // from class: l1.r
                @Override // g1.j
                public final void a(Object obj8) {
                    d1.r0 r0Var = (d1.r0) obj8;
                    switch (i21) {
                        case 0:
                            r0Var.a(w0Var.f6058m);
                            break;
                        case 1:
                            r0Var.F(w0Var.k());
                            break;
                        case 2:
                            r0Var.t(w0Var.f6059n);
                            break;
                        case 3:
                            r0Var.u(w0Var.f6052f);
                            break;
                        case 4:
                            r0Var.f(w0Var.f6052f);
                            break;
                        case 5:
                            r0Var.r(w0Var.f6054i.f10494d);
                            break;
                        case 6:
                            w0 w0Var6 = w0Var;
                            r0Var.d(w0Var6.f6053g);
                            r0Var.h(w0Var6.f6053g);
                            break;
                        case 7:
                            w0 w0Var7 = w0Var;
                            r0Var.n(w0Var7.f6051e, w0Var7.f6057l);
                            break;
                        default:
                            r0Var.s(w0Var.f6051e);
                            break;
                    }
                }
            });
            if (w0Var.f6052f != null) {
                final int i22 = 4;
                this.f5799t.c(10, new g1.j() { // from class: l1.r
                    @Override // g1.j
                    public final void a(Object obj8) {
                        d1.r0 r0Var = (d1.r0) obj8;
                        switch (i22) {
                            case 0:
                                r0Var.a(w0Var.f6058m);
                                break;
                            case 1:
                                r0Var.F(w0Var.k());
                                break;
                            case 2:
                                r0Var.t(w0Var.f6059n);
                                break;
                            case 3:
                                r0Var.u(w0Var.f6052f);
                                break;
                            case 4:
                                r0Var.f(w0Var.f6052f);
                                break;
                            case 5:
                                r0Var.r(w0Var.f6054i.f10494d);
                                break;
                            case 6:
                                w0 w0Var6 = w0Var;
                                r0Var.d(w0Var6.f6053g);
                                r0Var.h(w0Var6.f6053g);
                                break;
                            case 7:
                                w0 w0Var7 = w0Var;
                                r0Var.n(w0Var7.f6051e, w0Var7.f6057l);
                                break;
                            default:
                                r0Var.s(w0Var.f6051e);
                                break;
                        }
                    }
                });
            }
        }
        y1.t tVar = w0Var2.f6054i;
        y1.t tVar2 = w0Var.f6054i;
        if (tVar != tVar2) {
            y1.o oVar = this.f5793p;
            Object obj8 = tVar2.f10495e;
            oVar.getClass();
            final int i23 = 5;
            this.f5799t.c(2, new g1.j() { // from class: l1.r
                @Override // g1.j
                public final void a(Object obj82) {
                    d1.r0 r0Var = (d1.r0) obj82;
                    switch (i23) {
                        case 0:
                            r0Var.a(w0Var.f6058m);
                            break;
                        case 1:
                            r0Var.F(w0Var.k());
                            break;
                        case 2:
                            r0Var.t(w0Var.f6059n);
                            break;
                        case 3:
                            r0Var.u(w0Var.f6052f);
                            break;
                        case 4:
                            r0Var.f(w0Var.f6052f);
                            break;
                        case 5:
                            r0Var.r(w0Var.f6054i.f10494d);
                            break;
                        case 6:
                            w0 w0Var6 = w0Var;
                            r0Var.d(w0Var6.f6053g);
                            r0Var.h(w0Var6.f6053g);
                            break;
                        case 7:
                            w0 w0Var7 = w0Var;
                            r0Var.n(w0Var7.f6051e, w0Var7.f6057l);
                            break;
                        default:
                            r0Var.s(w0Var.f6051e);
                            break;
                    }
                }
            });
        }
        if (!z11) {
            this.f5799t.c(14, new a3.i(this.U, 11));
        }
        if (z15) {
            final int i24 = 6;
            this.f5799t.c(3, new g1.j() { // from class: l1.r
                @Override // g1.j
                public final void a(Object obj82) {
                    d1.r0 r0Var = (d1.r0) obj82;
                    switch (i24) {
                        case 0:
                            r0Var.a(w0Var.f6058m);
                            break;
                        case 1:
                            r0Var.F(w0Var.k());
                            break;
                        case 2:
                            r0Var.t(w0Var.f6059n);
                            break;
                        case 3:
                            r0Var.u(w0Var.f6052f);
                            break;
                        case 4:
                            r0Var.f(w0Var.f6052f);
                            break;
                        case 5:
                            r0Var.r(w0Var.f6054i.f10494d);
                            break;
                        case 6:
                            w0 w0Var6 = w0Var;
                            r0Var.d(w0Var6.f6053g);
                            r0Var.h(w0Var6.f6053g);
                            break;
                        case 7:
                            w0 w0Var7 = w0Var;
                            r0Var.n(w0Var7.f6051e, w0Var7.f6057l);
                            break;
                        default:
                            r0Var.s(w0Var.f6051e);
                            break;
                    }
                }
            });
        }
        if (z12 || z13) {
            final int i25 = 7;
            this.f5799t.c(-1, new g1.j() { // from class: l1.r
                @Override // g1.j
                public final void a(Object obj82) {
                    d1.r0 r0Var = (d1.r0) obj82;
                    switch (i25) {
                        case 0:
                            r0Var.a(w0Var.f6058m);
                            break;
                        case 1:
                            r0Var.F(w0Var.k());
                            break;
                        case 2:
                            r0Var.t(w0Var.f6059n);
                            break;
                        case 3:
                            r0Var.u(w0Var.f6052f);
                            break;
                        case 4:
                            r0Var.f(w0Var.f6052f);
                            break;
                        case 5:
                            r0Var.r(w0Var.f6054i.f10494d);
                            break;
                        case 6:
                            w0 w0Var6 = w0Var;
                            r0Var.d(w0Var6.f6053g);
                            r0Var.h(w0Var6.f6053g);
                            break;
                        case 7:
                            w0 w0Var7 = w0Var;
                            r0Var.n(w0Var7.f6051e, w0Var7.f6057l);
                            break;
                        default:
                            r0Var.s(w0Var.f6051e);
                            break;
                    }
                }
            });
        }
        if (z12) {
            final int i26 = 8;
            this.f5799t.c(4, new g1.j() { // from class: l1.r
                @Override // g1.j
                public final void a(Object obj82) {
                    d1.r0 r0Var = (d1.r0) obj82;
                    switch (i26) {
                        case 0:
                            r0Var.a(w0Var.f6058m);
                            break;
                        case 1:
                            r0Var.F(w0Var.k());
                            break;
                        case 2:
                            r0Var.t(w0Var.f6059n);
                            break;
                        case 3:
                            r0Var.u(w0Var.f6052f);
                            break;
                        case 4:
                            r0Var.f(w0Var.f6052f);
                            break;
                        case 5:
                            r0Var.r(w0Var.f6054i.f10494d);
                            break;
                        case 6:
                            w0 w0Var6 = w0Var;
                            r0Var.d(w0Var6.f6053g);
                            r0Var.h(w0Var6.f6053g);
                            break;
                        case 7:
                            w0 w0Var7 = w0Var;
                            r0Var.n(w0Var7.f6051e, w0Var7.f6057l);
                            break;
                        default:
                            r0Var.s(w0Var.f6051e);
                            break;
                    }
                }
            });
        }
        if (z13) {
            final int i27 = 1;
            this.f5799t.c(5, new g1.j() { // from class: l1.w
                @Override // g1.j
                public final void a(Object obj52) {
                    d1.r0 r0Var = (d1.r0) obj52;
                    switch (i27) {
                        case 0:
                            r0Var.E(w0Var.f6047a, i10);
                            break;
                        default:
                            r0Var.p(i10, w0Var.f6057l);
                            break;
                    }
                }
            });
        }
        if (w0Var2.f6058m != w0Var.f6058m) {
            final int i28 = 0;
            this.f5799t.c(6, new g1.j() { // from class: l1.r
                @Override // g1.j
                public final void a(Object obj82) {
                    d1.r0 r0Var = (d1.r0) obj82;
                    switch (i28) {
                        case 0:
                            r0Var.a(w0Var.f6058m);
                            break;
                        case 1:
                            r0Var.F(w0Var.k());
                            break;
                        case 2:
                            r0Var.t(w0Var.f6059n);
                            break;
                        case 3:
                            r0Var.u(w0Var.f6052f);
                            break;
                        case 4:
                            r0Var.f(w0Var.f6052f);
                            break;
                        case 5:
                            r0Var.r(w0Var.f6054i.f10494d);
                            break;
                        case 6:
                            w0 w0Var6 = w0Var;
                            r0Var.d(w0Var6.f6053g);
                            r0Var.h(w0Var6.f6053g);
                            break;
                        case 7:
                            w0 w0Var7 = w0Var;
                            r0Var.n(w0Var7.f6051e, w0Var7.f6057l);
                            break;
                        default:
                            r0Var.s(w0Var.f6051e);
                            break;
                    }
                }
            });
        }
        if (w0Var2.k() != w0Var.k()) {
            final int i29 = 1;
            this.f5799t.c(7, new g1.j() { // from class: l1.r
                @Override // g1.j
                public final void a(Object obj82) {
                    d1.r0 r0Var = (d1.r0) obj82;
                    switch (i29) {
                        case 0:
                            r0Var.a(w0Var.f6058m);
                            break;
                        case 1:
                            r0Var.F(w0Var.k());
                            break;
                        case 2:
                            r0Var.t(w0Var.f6059n);
                            break;
                        case 3:
                            r0Var.u(w0Var.f6052f);
                            break;
                        case 4:
                            r0Var.f(w0Var.f6052f);
                            break;
                        case 5:
                            r0Var.r(w0Var.f6054i.f10494d);
                            break;
                        case 6:
                            w0 w0Var6 = w0Var;
                            r0Var.d(w0Var6.f6053g);
                            r0Var.h(w0Var6.f6053g);
                            break;
                        case 7:
                            w0 w0Var7 = w0Var;
                            r0Var.n(w0Var7.f6051e, w0Var7.f6057l);
                            break;
                        default:
                            r0Var.s(w0Var.f6051e);
                            break;
                    }
                }
            });
        }
        if (!w0Var2.f6059n.equals(w0Var.f6059n)) {
            final int i30 = 2;
            this.f5799t.c(12, new g1.j() { // from class: l1.r
                @Override // g1.j
                public final void a(Object obj82) {
                    d1.r0 r0Var = (d1.r0) obj82;
                    switch (i30) {
                        case 0:
                            r0Var.a(w0Var.f6058m);
                            break;
                        case 1:
                            r0Var.F(w0Var.k());
                            break;
                        case 2:
                            r0Var.t(w0Var.f6059n);
                            break;
                        case 3:
                            r0Var.u(w0Var.f6052f);
                            break;
                        case 4:
                            r0Var.f(w0Var.f6052f);
                            break;
                        case 5:
                            r0Var.r(w0Var.f6054i.f10494d);
                            break;
                        case 6:
                            w0 w0Var6 = w0Var;
                            r0Var.d(w0Var6.f6053g);
                            r0Var.h(w0Var6.f6053g);
                            break;
                        case 7:
                            w0 w0Var7 = w0Var;
                            r0Var.n(w0Var7.f6051e, w0Var7.f6057l);
                            break;
                        default:
                            r0Var.s(w0Var.f6051e);
                            break;
                    }
                }
            });
        }
        u0();
        this.f5799t.b();
        if (w0Var2.f6060o != w0Var.f6060o) {
            Iterator it = this.f5800u.iterator();
            while (it.hasNext()) {
                ((y) it.next()).f6065i.x0();
            }
        }
    }

    public final int x(w0 w0Var) {
        return w0Var.f6047a.p() ? this.f5794p0 : w0Var.f6047a.g(w0Var.f6048b.f9447a, this.f5801v).f2586c;
    }

    public final void x0() {
        int t8 = t();
        d4.t tVar = this.J;
        d4.t tVar2 = this.I;
        if (t8 != 1) {
            if (t8 == 2 || t8 == 3) {
                y0();
                boolean z8 = this.f5792o0.f6060o;
                p();
                tVar2.getClass();
                p();
                tVar.getClass();
                return;
            }
            if (t8 != 4) {
                androidx.fragment.app.a.l();
                return;
            }
        }
        tVar2.getClass();
        tVar.getClass();
    }

    public final Pair y(d1.y0 y0Var, a1 a1Var, int i9, long j5) {
        if (y0Var.p() || a1Var.p()) {
            boolean z8 = !y0Var.p() && a1Var.p();
            return e0(a1Var, z8 ? -1 : i9, z8 ? -9223372036854775807L : j5);
        }
        Pair i10 = y0Var.i(this.f5780i, this.f5801v, i9, g1.w.M(j5));
        Object obj = i10.first;
        if (a1Var.b(obj) != -1) {
            return i10;
        }
        Object I = h0.I(this.f5780i, this.f5801v, this.L, this.M, obj, y0Var, a1Var);
        if (I == null) {
            return e0(a1Var, -1, -9223372036854775807L);
        }
        d1.w0 w0Var = this.f5801v;
        a1Var.g(I, w0Var);
        int i11 = w0Var.f2586c;
        d1.x0 x0Var = this.f5780i;
        a1Var.m(i11, x0Var, 0L);
        return e0(a1Var, i11, g1.w.W(x0Var.f2605m));
    }

    public final void y0() {
        d2.f0 f0Var = this.f5785l;
        synchronized (f0Var) {
            boolean z8 = false;
            while (!f0Var.f2689a) {
                try {
                    f0Var.wait();
                } catch (InterruptedException unused) {
                    z8 = true;
                }
            }
            if (z8) {
                Thread.currentThread().interrupt();
            }
        }
        if (Thread.currentThread() != this.f5805z.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = this.f5805z.getThread().getName();
            int i9 = g1.w.f3713a;
            Locale locale = Locale.US;
            String str = "Player is accessed on the wrong thread.\nCurrent thread: '" + name + "'\nExpected thread: '" + name2 + "'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread";
            if (this.f5784k0) {
                m7.c.p(str);
            } else {
                g1.a.E("ExoPlayerImpl", str, this.f5786l0 ? null : new IllegalStateException());
                this.f5786l0 = true;
            }
        }
    }

    @Override // d1.t0
    public final long z() {
        d1.y0 U = U();
        if (U.p()) {
            return -9223372036854775807L;
        }
        return g1.w.W(U.m(I(), this.f5780i, 0L).f2606n);
    }
}
