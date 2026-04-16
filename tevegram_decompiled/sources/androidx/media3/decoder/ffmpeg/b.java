package androidx.media3.decoder.ffmpeg;

import a5.d;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.SystemClock;
import androidx.activity.g;
import androidx.emoji2.text.m;
import b2.e0;
import b2.f0;
import b6.g0;
import d1.l0;
import d1.o0;
import d1.r;
import d1.s;
import i7.x;
import j1.c;
import j1.h;
import j1.i;
import l1.c1;
import l1.e;
import l1.f;
import l1.k0;
import n1.b0;
import n1.j0;
import n1.o;
import n1.p0;
import n1.q;
import n1.t;
import n1.v;
import n1.w;
import v1.v0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends e implements k0 {
    public final w A;
    public final j1.e B;
    public f C;
    public s D;
    public int E;
    public int F;
    public boolean G;
    public j1.b H;
    public j1.e I;
    public i J;
    public x K;
    public x L;
    public int M;
    public boolean N;
    public boolean O;
    public long P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public long T;
    public final long[] U;
    public int V;
    public boolean W;

    /* renamed from: z, reason: collision with root package name */
    public final m1.b f983z;

    public b(Handler handler, q qVar, w wVar) {
        super(1);
        this.f983z = new m1.b(handler, qVar);
        this.A = wVar;
        ((p0) wVar).f7338q = new x(this, 11);
        this.B = new j1.e(0, 0);
        this.M = 0;
        this.O = true;
        H(-9223372036854775807L);
        this.U = new long[10];
    }

    @Override // l1.e
    public final int A() {
        return 8;
    }

    public final j1.b B(s sVar) {
        g1.a.b("createFfmpegAudioDecoder");
        int i9 = sVar.f2555n;
        int i10 = sVar.A;
        int i11 = sVar.f2567z;
        if (i9 == -1) {
            i9 = 5760;
        }
        s y2 = g1.w.y(2, i11, i10);
        w wVar = this.A;
        boolean z8 = true;
        if (((p0) wVar).A(y2)) {
            z8 = ((p0) wVar).h(g1.w.y(4, i11, i10)) != 2 ? false : true ^ "audio/ac3".equals(sVar.f2554m);
        }
        FfmpegAudioDecoder ffmpegAudioDecoder = new FfmpegAudioDecoder(i9, sVar, z8);
        g1.a.r();
        return ffmpegAudioDecoder;
    }

    public final boolean C() {
        if (this.J == null) {
            i iVar = (i) ((h) this.H).c();
            this.J = iVar;
            if (iVar != null) {
                int i9 = iVar.f5366l;
                if (i9 > 0) {
                    this.C.f5860f += i9;
                    ((p0) this.A).K = true;
                }
                if (iVar.c(134217728)) {
                    long[] jArr = this.U;
                    ((p0) this.A).K = true;
                    if (this.V != 0) {
                        H(jArr[0]);
                        int i10 = this.V - 1;
                        this.V = i10;
                        System.arraycopy(jArr, 1, jArr, 0, i10);
                    }
                }
            }
            return false;
        }
        if (this.J.c(4)) {
            if (this.M == 2) {
                G();
                E();
                this.O = true;
                return false;
            }
            this.J.l();
            this.J = null;
            try {
                this.S = true;
                ((p0) this.A).t();
                return false;
            } catch (v e9) {
                throw l(e9, e9.f7381k, e9.f7380j, 5002);
            }
        }
        if (this.O) {
            FfmpegAudioDecoder ffmpegAudioDecoder = (FfmpegAudioDecoder) this.H;
            ffmpegAudioDecoder.getClass();
            r rVar = new r();
            rVar.f2528l = l0.k("audio/raw");
            rVar.f2541y = ffmpegAudioDecoder.f977u;
            rVar.f2542z = ffmpegAudioDecoder.f978v;
            rVar.A = ffmpegAudioDecoder.f973q;
            r a9 = new s(rVar).a();
            a9.B = this.E;
            a9.C = this.F;
            s sVar = this.D;
            a9.f2526j = sVar.f2552k;
            a9.f2518a = sVar.f2543a;
            a9.f2519b = sVar.f2544b;
            a9.f2520c = g0.m(sVar.f2545c);
            s sVar2 = this.D;
            a9.f2521d = sVar2.f2546d;
            a9.f2522e = sVar2.f2547e;
            a9.f2523f = sVar2.f2548f;
            ((p0) this.A).b(new s(a9), null);
            this.O = false;
        }
        w wVar = this.A;
        i iVar2 = this.J;
        if (((p0) wVar).k(iVar2.f5383n, iVar2.f5365k, 1)) {
            this.C.f5859e++;
            this.J.l();
            this.J = null;
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r0 == null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean D() {
        /*
            r8 = this;
            j1.b r0 = r8.H
            r1 = 0
            if (r0 == 0) goto Lb0
            int r2 = r8.M
            r3 = 2
            if (r2 == r3) goto Lb0
            boolean r2 = r8.R
            if (r2 == 0) goto L10
            goto Lb0
        L10:
            j1.e r2 = r8.I
            if (r2 != 0) goto L22
            j1.h r0 = (j1.h) r0
            java.lang.Object r0 = r0.d()
            j1.e r0 = (j1.e) r0
            r8.I = r0
            if (r0 != 0) goto L22
            goto Lb0
        L22:
            int r0 = r8.M
            r2 = 4
            r4 = 0
            r5 = 1
            if (r0 != r5) goto L3c
            j1.e r0 = r8.I
            r0.f3748j = r2
            j1.b r2 = r8.H
            j1.h r2 = (j1.h) r2
            r2.getClass()
            r2.b(r0)
            r8.I = r4
            r8.M = r3
            return r1
        L3c:
            a5.d r0 = r8.f5828k
            r0.o0()
            j1.e r3 = r8.I
            int r3 = r8.w(r0, r3, r1)
            r6 = -5
            if (r3 == r6) goto Lac
            r0 = -4
            if (r3 == r0) goto L56
            r0 = -3
            if (r3 != r0) goto L51
            goto Lb0
        L51:
            androidx.fragment.app.a.l()
            r0 = 0
            return r0
        L56:
            j1.e r0 = r8.I
            boolean r0 = r0.c(r2)
            if (r0 == 0) goto L6f
            r8.R = r5
            j1.b r0 = r8.H
            j1.e r2 = r8.I
            j1.h r0 = (j1.h) r0
            r0.getClass()
            r0.b(r2)
            r8.I = r4
            return r1
        L6f:
            boolean r0 = r8.G
            if (r0 != 0) goto L7c
            r8.G = r5
            j1.e r0 = r8.I
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r0.a(r1)
        L7c:
            j1.e r0 = r8.I
            long r1 = r0.f5361o
            long r6 = r8.f5837t
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 >= 0) goto L8b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0.a(r1)
        L8b:
            j1.e r0 = r8.I
            r0.n()
            j1.e r0 = r8.I
            d1.s r1 = r8.D
            r0.f5357k = r1
            j1.b r1 = r8.H
            j1.h r1 = (j1.h) r1
            r1.getClass()
            r1.b(r0)
            r8.N = r5
            l1.f r0 = r8.C
            int r1 = r0.f5857c
            int r1 = r1 + r5
            r0.f5857c = r1
            r8.I = r4
            return r5
        Lac:
            r8.F(r0)
            return r5
        Lb0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.ffmpeg.b.D():boolean");
    }

    public final void E() {
        m1.b bVar = this.f983z;
        if (this.H != null) {
            return;
        }
        x xVar = this.L;
        g.z(this.K, xVar);
        this.K = xVar;
        if (xVar != null) {
            xVar.z();
            if (this.K.A() == null) {
                return;
            }
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            g1.a.b("createAudioDecoder");
            j1.b B = B(this.D);
            this.H = B;
            ((h) B).n(this.f5837t);
            g1.a.r();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            String o8 = ((FfmpegAudioDecoder) this.H).o();
            long j5 = elapsedRealtime2 - elapsedRealtime;
            Handler handler = (Handler) bVar.f6510j;
            if (handler != null) {
                handler.post(new e0(bVar, o8, elapsedRealtime2, j5, 1));
            }
            this.C.f5855a++;
        } catch (c e9) {
            g1.a.q("DecoderAudioRenderer", "Audio codec error", e9);
            Handler handler2 = (Handler) bVar.f6510j;
            if (handler2 != null) {
                handler2.post(new o(bVar, e9, 0));
            }
            throw l(e9, this.D, false, 4001);
        } catch (OutOfMemoryError e10) {
            throw l(e10, this.D, false, 4001);
        }
    }

    public final void F(d dVar) {
        s sVar = (s) dVar.f175k;
        sVar.getClass();
        x xVar = (x) dVar.f174j;
        g.z(this.L, xVar);
        this.L = xVar;
        s sVar2 = this.D;
        this.D = sVar;
        this.E = sVar.C;
        this.F = sVar.D;
        j1.b bVar = this.H;
        m1.b bVar2 = this.f983z;
        if (bVar == null) {
            E();
            s sVar3 = this.D;
            Handler handler = (Handler) bVar2.f6510j;
            if (handler != null) {
                handler.post(new m(bVar2, sVar3, null, 5));
                return;
            }
            return;
        }
        l1.g gVar = xVar != this.K ? new l1.g(((FfmpegAudioDecoder) bVar).o(), sVar2, sVar, 0, 128) : new l1.g(((FfmpegAudioDecoder) bVar).o(), sVar2, sVar, 0, 1);
        if (gVar.f5875d == 0) {
            if (this.N) {
                this.M = 1;
            } else {
                G();
                E();
                this.O = true;
            }
        }
        s sVar4 = this.D;
        Handler handler2 = (Handler) bVar2.f6510j;
        if (handler2 != null) {
            handler2.post(new m(bVar2, sVar4, gVar, 5));
        }
    }

    public final void G() {
        this.I = null;
        this.J = null;
        this.M = 0;
        this.N = false;
        j1.b bVar = this.H;
        if (bVar != null) {
            this.C.f5856b++;
            ((FfmpegAudioDecoder) bVar).release();
            String o8 = ((FfmpegAudioDecoder) this.H).o();
            m1.b bVar2 = this.f983z;
            Handler handler = (Handler) bVar2.f6510j;
            if (handler != null) {
                handler.post(new f0(bVar2, 14, o8));
            }
            this.H = null;
        }
        g.z(this.K, null);
        this.K = null;
    }

    public final void H(long j5) {
        this.T = j5;
        if (j5 != -9223372036854775807L) {
            this.A.getClass();
        }
    }

    public final void I() {
        long f9 = ((p0) this.A).f(a());
        if (f9 != Long.MIN_VALUE) {
            if (!this.Q) {
                f9 = Math.max(this.P, f9);
            }
            this.P = f9;
            this.Q = false;
        }
    }

    @Override // l1.e, l1.b1
    public final boolean a() {
        if (!this.S) {
            return false;
        }
        p0 p0Var = (p0) this.A;
        if (p0Var.n()) {
            return p0Var.T && !p0Var.l();
        }
        return true;
    }

    @Override // l1.b1
    public final boolean b() {
        boolean b9;
        if (((p0) this.A).l()) {
            return true;
        }
        if (this.D == null) {
            return false;
        }
        if (m()) {
            b9 = this.f5839v;
        } else {
            v0 v0Var = this.f5834q;
            v0Var.getClass();
            b9 = v0Var.b();
        }
        return b9 || this.J != null;
    }

    @Override // l1.k0
    public final boolean c() {
        boolean z8 = this.W;
        this.W = false;
        return z8;
    }

    @Override // l1.k0
    public final o0 d() {
        return ((p0) this.A).B;
    }

    @Override // l1.k0
    public final void e(o0 o0Var) {
        ((p0) this.A).z(o0Var);
    }

    @Override // l1.b1
    public final void f(long j5, long j9) {
        if (this.S) {
            try {
                ((p0) this.A).t();
                return;
            } catch (v e9) {
                throw l(e9, e9.f7381k, e9.f7380j, 5002);
            }
        }
        if (this.D == null) {
            d dVar = this.f5828k;
            dVar.o0();
            this.B.k();
            int w8 = w(dVar, this.B, 2);
            if (w8 != -5) {
                if (w8 == -4) {
                    g1.a.k(this.B.c(4));
                    this.R = true;
                    try {
                        this.S = true;
                        ((p0) this.A).t();
                        return;
                    } catch (v e10) {
                        throw l(e10, null, false, 5002);
                    }
                }
                return;
            }
            F(dVar);
        }
        E();
        if (this.H != null) {
            try {
                g1.a.b("drainAndFeed");
                while (C()) {
                }
                while (D()) {
                }
                g1.a.r();
                synchronized (this.C) {
                }
            } catch (c e11) {
                g1.a.q("DecoderAudioRenderer", "Audio codec error", e11);
                m1.b bVar = this.f983z;
                Handler handler = (Handler) bVar.f6510j;
                if (handler != null) {
                    handler.post(new o(bVar, e11, 0));
                }
                throw l(e11, this.D, false, 4003);
            } catch (n1.s e12) {
                throw l(e12, e12.f7355i, false, 5001);
            } catch (t e13) {
                throw l(e13, e13.f7358k, e13.f7357j, 5001);
            } catch (v e14) {
                throw l(e14, e14.f7381k, e14.f7380j, 5002);
            }
        }
    }

    @Override // l1.e, l1.x0
    public final void g(int i9, Object obj) {
        w wVar = this.A;
        if (i9 == 2) {
            float floatValue = ((Float) obj).floatValue();
            p0 p0Var = (p0) wVar;
            if (p0Var.N != floatValue) {
                p0Var.N = floatValue;
                if (p0Var.n()) {
                    int i10 = g1.w.f3713a;
                    AudioTrack audioTrack = p0Var.f7342u;
                    float f9 = p0Var.N;
                    if (i10 >= 21) {
                        audioTrack.setVolume(f9);
                        return;
                    } else {
                        audioTrack.setStereoVolume(f9, f9);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i9 == 3) {
            ((p0) wVar).w((d1.g) obj);
            return;
        }
        if (i9 == 6) {
            ((p0) wVar).y((d1.h) obj);
            return;
        }
        if (i9 == 12) {
            if (g1.w.f3713a >= 23) {
                b0.a(wVar, obj);
                return;
            }
            return;
        }
        if (i9 == 9) {
            p0 p0Var2 = (p0) wVar;
            p0Var2.C = ((Boolean) obj).booleanValue();
            j0 j0Var = new j0(p0Var2.B() ? o0.f2509d : p0Var2.B, -9223372036854775807L, -9223372036854775807L);
            if (p0Var2.n()) {
                p0Var2.f7347z = j0Var;
                return;
            } else {
                p0Var2.A = j0Var;
                return;
            }
        }
        if (i9 != 10) {
            return;
        }
        int intValue = ((Integer) obj).intValue();
        p0 p0Var3 = (p0) wVar;
        if (p0Var3.X != intValue) {
            p0Var3.X = intValue;
            p0Var3.W = intValue != 0;
            p0Var3.e();
        }
    }

    @Override // l1.b1
    public final String getName() {
        return "FfmpegAudioRenderer";
    }

    @Override // l1.k0
    public final long j() {
        if (this.f5833p == 2) {
            I();
        }
        return this.P;
    }

    @Override // l1.e
    public final void n() {
        m1.b bVar = this.f983z;
        this.D = null;
        this.O = true;
        H(-9223372036854775807L);
        this.W = false;
        try {
            g.z(this.L, null);
            this.L = null;
            G();
            ((p0) this.A).v();
        } finally {
            bVar.h(this.C);
        }
    }

    @Override // l1.e
    public final void o(boolean z8, boolean z9) {
        f fVar = new f();
        this.C = fVar;
        m1.b bVar = this.f983z;
        Handler handler = (Handler) bVar.f6510j;
        if (handler != null) {
            handler.post(new n1.m(bVar, fVar, 0));
        }
        c1 c1Var = this.f5829l;
        c1Var.getClass();
        boolean z10 = c1Var.f5811b;
        w wVar = this.A;
        if (z10) {
            ((p0) wVar).d();
        } else {
            p0 p0Var = (p0) wVar;
            if (p0Var.f7316a0) {
                p0Var.f7316a0 = false;
                p0Var.e();
            }
        }
        m1.x xVar = this.f5831n;
        xVar.getClass();
        p0 p0Var2 = (p0) wVar;
        p0Var2.f7337p = xVar;
        g1.r rVar = this.f5832o;
        rVar.getClass();
        p0Var2.h.J = rVar;
    }

    @Override // l1.e
    public final void q(long j5, boolean z8) {
        ((p0) this.A).e();
        this.P = j5;
        this.W = false;
        this.Q = true;
        this.R = false;
        this.S = false;
        if (this.H != null) {
            if (this.M != 0) {
                G();
                E();
                return;
            }
            this.I = null;
            i iVar = this.J;
            if (iVar != null) {
                iVar.l();
                this.J = null;
            }
            j1.b bVar = this.H;
            bVar.getClass();
            h hVar = (h) bVar;
            hVar.flush();
            hVar.n(this.f5837t);
            this.N = false;
        }
    }

    @Override // l1.e
    public final void t() {
        ((p0) this.A).r();
    }

    @Override // l1.e
    public final void u() {
        I();
        ((p0) this.A).q();
    }

    @Override // l1.e
    public final void v(s[] sVarArr, long j5, long j9) {
        this.G = false;
        if (this.T == -9223372036854775807L) {
            H(j9);
            return;
        }
        int i9 = this.V;
        long[] jArr = this.U;
        if (i9 == jArr.length) {
            g1.a.D("DecoderAudioRenderer", "Too many stream changes, so dropping offset: " + jArr[this.V - 1]);
        } else {
            this.V = i9 + 1;
        }
        jArr[this.V - 1] = j9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (((n1.p0) r4).A(g1.w.y(4, r2, r1)) == false) goto L21;
     */
    @Override // l1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int z(d1.s r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.f2554m
            int r1 = r8.A
            int r2 = r8.f2567z
            boolean r0 = d1.l0.h(r0)
            r3 = 0
            if (r0 != 0) goto L12
            int r8 = androidx.activity.g.f(r3, r3, r3, r3)
            return r8
        L12:
            java.lang.String r0 = r8.f2554m
            r0.getClass()
            boolean r4 = androidx.media3.decoder.ffmpeg.FfmpegLibrary.d()
            r5 = 2
            if (r4 == 0) goto L50
            boolean r4 = d1.l0.h(r0)
            if (r4 != 0) goto L25
            goto L50
        L25:
            boolean r0 = androidx.media3.decoder.ffmpeg.FfmpegLibrary.e(r0)
            if (r0 == 0) goto L4e
            d1.s r0 = g1.w.y(r5, r2, r1)
            n1.w r4 = r7.A
            r6 = r4
            n1.p0 r6 = (n1.p0) r6
            boolean r0 = r6.A(r0)
            r6 = 4
            if (r0 != 0) goto L48
            d1.s r0 = g1.w.y(r6, r2, r1)
            n1.p0 r4 = (n1.p0) r4
            boolean r0 = r4.A(r0)
            if (r0 != 0) goto L48
            goto L4e
        L48:
            int r8 = r8.I
            if (r8 == 0) goto L51
            r6 = 2
            goto L51
        L4e:
            r6 = 1
            goto L51
        L50:
            r6 = 0
        L51:
            if (r6 > r5) goto L58
            int r8 = androidx.activity.g.f(r6, r3, r3, r3)
            return r8
        L58:
            int r8 = g1.w.f3713a
            r0 = 21
            if (r8 < r0) goto L60
            r3 = 32
        L60:
            r8 = r6 | 8
            r8 = r8 | r3
            r8 = r8 | 128(0x80, float:1.8E-43)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.ffmpeg.b.z(d1.s):int");
    }

    @Override // l1.e, l1.b1
    public final k0 i() {
        return this;
    }
}
