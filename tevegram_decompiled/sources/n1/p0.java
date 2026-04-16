package n1;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import i7.p2;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p0 implements w {

    /* renamed from: j0, reason: collision with root package name */
    public static final Object f7312j0 = new Object();

    /* renamed from: k0, reason: collision with root package name */
    public static ExecutorService f7313k0;

    /* renamed from: l0, reason: collision with root package name */
    public static int f7314l0;
    public j0 A;
    public d1.o0 B;
    public boolean C;
    public ByteBuffer D;
    public int E;
    public long F;
    public long G;
    public long H;
    public long I;
    public int J;
    public boolean K;
    public boolean L;
    public long M;
    public float N;
    public ByteBuffer O;
    public int P;
    public ByteBuffer Q;
    public byte[] R;
    public int S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public d1.h Y;
    public k Z;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7315a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f7316a0;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.fragment.app.g f7317b;

    /* renamed from: b0, reason: collision with root package name */
    public long f7318b0;

    /* renamed from: c, reason: collision with root package name */
    public final a0 f7319c;

    /* renamed from: c0, reason: collision with root package name */
    public long f7320c0;

    /* renamed from: d, reason: collision with root package name */
    public final w0 f7321d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f7322d0;

    /* renamed from: e, reason: collision with root package name */
    public final b6.w0 f7323e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f7324e0;

    /* renamed from: f, reason: collision with root package name */
    public final b6.w0 f7325f;

    /* renamed from: f0, reason: collision with root package name */
    public Looper f7326f0;

    /* renamed from: g, reason: collision with root package name */
    public final d2.f0 f7327g;

    /* renamed from: g0, reason: collision with root package name */
    public long f7328g0;
    public final z h;

    /* renamed from: h0, reason: collision with root package name */
    public long f7329h0;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayDeque f7330i;
    public Handler i0;

    /* renamed from: j, reason: collision with root package name */
    public int f7331j;

    /* renamed from: k, reason: collision with root package name */
    public o0 f7332k;

    /* renamed from: l, reason: collision with root package name */
    public final b2.d0 f7333l;

    /* renamed from: m, reason: collision with root package name */
    public final b2.d0 f7334m;

    /* renamed from: n, reason: collision with root package name */
    public final q0 f7335n;

    /* renamed from: o, reason: collision with root package name */
    public final m1.b f7336o;

    /* renamed from: p, reason: collision with root package name */
    public m1.x f7337p;

    /* renamed from: q, reason: collision with root package name */
    public i7.x f7338q;

    /* renamed from: r, reason: collision with root package name */
    public i0 f7339r;

    /* renamed from: s, reason: collision with root package name */
    public i0 f7340s;

    /* renamed from: t, reason: collision with root package name */
    public e1.a f7341t;

    /* renamed from: u, reason: collision with root package name */
    public AudioTrack f7342u;

    /* renamed from: v, reason: collision with root package name */
    public e f7343v;

    /* renamed from: w, reason: collision with root package name */
    public j f7344w;

    /* renamed from: x, reason: collision with root package name */
    public l0 f7345x;

    /* renamed from: y, reason: collision with root package name */
    public d1.g f7346y;

    /* renamed from: z, reason: collision with root package name */
    public j0 f7347z;

    public p0(h0 h0Var) {
        Context context = h0Var.f7253a;
        this.f7315a = context;
        d1.g gVar = d1.g.f2423c;
        this.f7346y = gVar;
        e eVar = e.f7247c;
        int i9 = g1.w.f3713a;
        this.f7343v = e.c(context, gVar, null);
        this.f7317b = h0Var.f7254b;
        this.f7331j = 0;
        this.f7335n = h0Var.f7256d;
        m1.b bVar = h0Var.f7257e;
        bVar.getClass();
        this.f7336o = bVar;
        d2.f0 f0Var = new d2.f0();
        this.f7327g = f0Var;
        f0Var.b();
        this.h = new z(new i7.x(this, 12));
        a0 a0Var = new a0();
        this.f7319c = a0Var;
        w0 w0Var = new w0();
        w0Var.f7387m = g1.w.f3718f;
        this.f7321d = w0Var;
        e1.h hVar = new e1.h();
        b6.e0 e0Var = b6.g0.f1391j;
        Object[] objArr = {hVar, a0Var, w0Var};
        b6.q.a(3, objArr);
        this.f7323e = b6.g0.l(3, objArr);
        this.f7325f = b6.g0.q(new v0());
        this.N = 1.0f;
        this.X = 0;
        this.Y = new d1.h();
        d1.o0 o0Var = d1.o0.f2509d;
        this.A = new j0(o0Var, 0L, 0L);
        this.B = o0Var;
        this.C = false;
        this.f7330i = new ArrayDeque();
        this.f7333l = new b2.d0(4);
        this.f7334m = new b2.d0(4);
    }

    public static boolean o(AudioTrack audioTrack) {
        boolean isOffloadedPlayback;
        if (g1.w.f3713a < 29) {
            return false;
        }
        isOffloadedPlayback = audioTrack.isOffloadedPlayback();
        return isOffloadedPlayback;
    }

    public final boolean A(d1.s sVar) {
        return h(sVar) != 0;
    }

    public final boolean B() {
        i0 i0Var = this.f7340s;
        return i0Var != null && i0Var.f7269j && g1.w.f3713a >= 23;
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ee, code lost:
    
        if (r12 < r11) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(java.nio.ByteBuffer r10, long r11) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.p0.C(java.nio.ByteBuffer, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[ADDED_TO_REGION, REMOVE, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r9) {
        /*
            r8 = this;
            boolean r0 = r8.B()
            androidx.fragment.app.g r1 = r8.f7317b
            if (r0 != 0) goto L3c
            boolean r0 = r8.f7316a0
            if (r0 != 0) goto L36
            n1.i0 r0 = r8.f7340s
            int r2 = r0.f7263c
            if (r2 != 0) goto L36
            d1.s r0 = r0.f7261a
            int r0 = r0.B
            d1.o0 r0 = r8.B
            java.lang.Object r2 = r1.f730l
            e1.g r2 = (e1.g) r2
            float r3 = r0.f2510a
            float r4 = r2.f3052c
            r5 = 1
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L29
            r2.f3052c = r3
            r2.f3057i = r5
        L29:
            float r3 = r0.f2511b
            float r4 = r2.f3053d
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L38
            r2.f3053d = r3
            r2.f3057i = r5
            goto L38
        L36:
            d1.o0 r0 = d1.o0.f2509d
        L38:
            r8.B = r0
        L3a:
            r3 = r0
            goto L3f
        L3c:
            d1.o0 r0 = d1.o0.f2509d
            goto L3a
        L3f:
            boolean r0 = r8.f7316a0
            if (r0 != 0) goto L56
            n1.i0 r0 = r8.f7340s
            int r2 = r0.f7263c
            if (r2 != 0) goto L56
            d1.s r0 = r0.f7261a
            int r0 = r0.B
            boolean r0 = r8.C
            java.lang.Object r1 = r1.f729k
            n1.u0 r1 = (n1.u0) r1
            r1.f7371p = r0
            goto L57
        L56:
            r0 = 0
        L57:
            r8.C = r0
            n1.j0 r2 = new n1.j0
            r0 = 0
            long r4 = java.lang.Math.max(r0, r9)
            n1.i0 r9 = r8.f7340s
            long r0 = r8.j()
            int r9 = r9.f7265e
            long r6 = g1.w.Q(r9, r0)
            r2.<init>(r3, r4, r6)
            java.util.ArrayDeque r9 = r8.f7330i
            r9.add(r2)
            n1.i0 r9 = r8.f7340s
            e1.a r9 = r9.f7268i
            r8.f7341t = r9
            r9.a()
            i7.x r9 = r8.f7338q
            if (r9 == 0) goto Lb4
            boolean r10 = r8.C
            int r0 = r9.f5178i
            switch(r0) {
                case 11: goto L9f;
                default: goto L89;
            }
        L89:
            java.lang.Object r9 = r9.f5179j
            n1.s0 r9 = (n1.s0) r9
            m1.b r9 = r9.O0
            java.lang.Object r0 = r9.f6510j
            android.os.Handler r0 = (android.os.Handler) r0
            if (r0 == 0) goto Lb4
            i7.u3 r1 = new i7.u3
            r2 = 3
            r1.<init>(r9, r10, r2)
            r0.post(r1)
            goto Lb4
        L9f:
            java.lang.Object r9 = r9.f5179j
            androidx.media3.decoder.ffmpeg.b r9 = (androidx.media3.decoder.ffmpeg.b) r9
            m1.b r9 = r9.f983z
            java.lang.Object r0 = r9.f6510j
            android.os.Handler r0 = (android.os.Handler) r0
            if (r0 == 0) goto Lb4
            i7.u3 r1 = new i7.u3
            r2 = 3
            r1.<init>(r9, r10, r2)
            r0.post(r1)
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.p0.a(long):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01c2, code lost:
    
        if (r10 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01c5, code lost:
    
        if (r11 > 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01c8, code lost:
    
        if (r11 < 0) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(d1.s r27, int[] r28) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.p0.b(d1.s, int[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0049 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r6 = this;
            e1.a r0 = r6.f7341t
            boolean r0 = r0.d()
            r1 = -9223372036854775808
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L19
            java.nio.ByteBuffer r0 = r6.Q
            if (r0 != 0) goto L11
            goto L48
        L11:
            r6.C(r0, r1)
            java.nio.ByteBuffer r0 = r6.Q
            if (r0 != 0) goto L49
            goto L48
        L19:
            e1.a r0 = r6.f7341t
            boolean r5 = r0.d()
            if (r5 == 0) goto L33
            boolean r5 = r0.f3017d
            if (r5 == 0) goto L26
            goto L33
        L26:
            r0.f3017d = r4
            java.util.ArrayList r0 = r0.f3015b
            java.lang.Object r0 = r0.get(r3)
            e1.d r0 = (e1.d) r0
            r0.e()
        L33:
            r6.u(r1)
            e1.a r0 = r6.f7341t
            boolean r0 = r0.c()
            if (r0 == 0) goto L49
            java.nio.ByteBuffer r0 = r6.Q
            if (r0 == 0) goto L48
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L49
        L48:
            return r4
        L49:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.p0.c():boolean");
    }

    public final void d() {
        g1.a.k(g1.w.f3713a >= 21);
        g1.a.k(this.W);
        if (this.f7316a0) {
            return;
        }
        this.f7316a0 = true;
        e();
    }

    public final void e() {
        l0 l0Var;
        if (n()) {
            this.F = 0L;
            this.G = 0L;
            this.H = 0L;
            this.I = 0L;
            this.f7324e0 = false;
            this.J = 0;
            this.A = new j0(this.B, 0L, 0L);
            this.M = 0L;
            this.f7347z = null;
            this.f7330i.clear();
            this.O = null;
            this.P = 0;
            this.Q = null;
            this.U = false;
            this.T = false;
            this.D = null;
            this.E = 0;
            this.f7321d.f7389o = 0L;
            e1.a aVar = this.f7340s.f7268i;
            this.f7341t = aVar;
            aVar.a();
            AudioTrack audioTrack = this.h.f7403c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 3) {
                this.f7342u.pause();
            }
            if (o(this.f7342u)) {
                o0 o0Var = this.f7332k;
                o0Var.getClass();
                o0Var.b(this.f7342u);
            }
            int i9 = g1.w.f3713a;
            if (i9 < 21 && !this.W) {
                this.X = 0;
            }
            i0 i0Var = this.f7340s;
            r rVar = new r(i0Var.f7267g, i0Var.f7265e, i0Var.f7266f, i0Var.f7271l, i0Var.f7263c == 1, i0Var.h);
            i0 i0Var2 = this.f7339r;
            if (i0Var2 != null) {
                this.f7340s = i0Var2;
                this.f7339r = null;
            }
            z zVar = this.h;
            zVar.d();
            zVar.f7403c = null;
            zVar.f7406f = null;
            if (i9 >= 24 && (l0Var = this.f7345x) != null) {
                l0Var.c();
                this.f7345x = null;
            }
            AudioTrack audioTrack2 = this.f7342u;
            d2.f0 f0Var = this.f7327g;
            i7.x xVar = this.f7338q;
            f0Var.a();
            Handler handler = new Handler(Looper.myLooper());
            synchronized (f7312j0) {
                try {
                    if (f7313k0 == null) {
                        f7313k0 = Executors.newSingleThreadExecutor(new androidx.emoji2.text.a("ExoPlayer:AudioTrackReleaseThread", 1));
                    }
                    f7314l0++;
                    f7313k0.execute(new p2(audioTrack2, xVar, handler, rVar, f0Var, 1));
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f7342u = null;
        }
        this.f7334m.f1165k = null;
        this.f7333l.f1165k = null;
        this.f7328g0 = 0L;
        this.f7329h0 = 0L;
        Handler handler2 = this.i0;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    public final long f(boolean z8) {
        ArrayDeque arrayDeque;
        long w8;
        long j5;
        if (!n() || this.L) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.h.a(z8), g1.w.Q(this.f7340s.f7265e, j()));
        while (true) {
            arrayDeque = this.f7330i;
            if (arrayDeque.isEmpty() || min < ((j0) arrayDeque.getFirst()).f7283c) {
                break;
            }
            this.A = (j0) arrayDeque.remove();
        }
        j0 j0Var = this.A;
        long j9 = min - j0Var.f7283c;
        boolean equals = j0Var.f7281a.equals(d1.o0.f2509d);
        androidx.fragment.app.g gVar = this.f7317b;
        if (equals) {
            w8 = this.A.f7282b + j9;
        } else if (arrayDeque.isEmpty()) {
            e1.g gVar2 = (e1.g) gVar.f730l;
            if (gVar2.f3063o >= IjkMediaMeta.AV_CH_SIDE_RIGHT) {
                long j10 = gVar2.f3062n;
                gVar2.f3058j.getClass();
                long j11 = j10 - ((r2.f3039k * r2.f3031b) * 2);
                int i9 = gVar2.h.f3019a;
                int i10 = gVar2.f3056g.f3019a;
                long j12 = gVar2.f3063o;
                j5 = i9 == i10 ? g1.w.S(j9, j11, j12, RoundingMode.FLOOR) : g1.w.S(j9, j11 * i9, j12 * i10, RoundingMode.FLOOR);
            } else {
                j5 = (long) (gVar2.f3052c * j9);
            }
            w8 = j5 + this.A.f7282b;
        } else {
            j0 j0Var2 = (j0) arrayDeque.getFirst();
            w8 = j0Var2.f7282b - g1.w.w(j0Var2.f7283c - min, this.A.f7281a.f2510a);
        }
        long j13 = ((u0) gVar.f729k).f7373r;
        long Q = g1.w.Q(this.f7340s.f7265e, j13) + w8;
        long j14 = this.f7328g0;
        if (j13 > j14) {
            long Q2 = g1.w.Q(this.f7340s.f7265e, j13 - j14);
            this.f7328g0 = j13;
            this.f7329h0 += Q2;
            if (this.i0 == null) {
                this.i0 = new Handler(Looper.myLooper());
            }
            this.i0.removeCallbacksAndMessages(null);
            this.i0.postDelayed(new a7.a(this, 18), 100L);
        }
        return Q;
    }

    public final l g(d1.s sVar) {
        boolean booleanValue;
        if (this.f7322d0) {
            return l.f7286d;
        }
        d1.g gVar = this.f7346y;
        m1.b bVar = this.f7336o;
        bVar.getClass();
        sVar.getClass();
        int i9 = sVar.A;
        gVar.getClass();
        int i10 = g1.w.f3713a;
        if (i10 < 29 || i9 == -1) {
            return l.f7286d;
        }
        Context context = (Context) bVar.f6510j;
        Boolean bool = (Boolean) bVar.f6511k;
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager != null) {
                String parameters = audioManager.getParameters("offloadVariableRateSupported");
                bVar.f6511k = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
            } else {
                bVar.f6511k = Boolean.FALSE;
            }
            booleanValue = ((Boolean) bVar.f6511k).booleanValue();
        }
        String str = sVar.f2554m;
        str.getClass();
        int b9 = d1.l0.b(str, sVar.f2551j);
        if (b9 == 0 || i10 < g1.w.n(b9)) {
            return l.f7286d;
        }
        int p5 = g1.w.p(sVar.f2567z);
        if (p5 == 0) {
            return l.f7286d;
        }
        try {
            AudioFormat o8 = g1.w.o(i9, p5, b9);
            return i10 >= 31 ? d0.a(o8, (AudioAttributes) gVar.a().f8j, booleanValue) : c0.a(o8, (AudioAttributes) gVar.a().f8j, booleanValue);
        } catch (IllegalArgumentException unused) {
            return l.f7286d;
        }
    }

    public final int h(d1.s sVar) {
        p();
        String str = sVar.f2554m;
        int i9 = sVar.B;
        if (!"audio/raw".equals(str)) {
            return this.f7343v.d(this.f7346y, sVar) != null ? 2 : 0;
        }
        if (g1.w.I(i9)) {
            return i9 != 2 ? 1 : 2;
        }
        androidx.activity.g.t(i9, "Invalid PCM encoding: ", "DefaultAudioSink");
        return 0;
    }

    public final long i() {
        return this.f7340s.f7263c == 0 ? this.F / r0.f7262b : this.G;
    }

    public final long j() {
        i0 i0Var = this.f7340s;
        if (i0Var.f7263c != 0) {
            return this.I;
        }
        long j5 = this.H;
        long j9 = i0Var.f7264d;
        int i9 = g1.w.f3713a;
        return ((j5 + j9) - 1) / j9;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03ad, code lost:
    
        if (r13 != 0) goto L205;
     */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(java.nio.ByteBuffer r28, long r29, int r31) {
        /*
            Method dump skipped, instructions count: 1230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.p0.k(java.nio.ByteBuffer, long, int):boolean");
    }

    public final boolean l() {
        return n() && this.h.c(j());
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m() {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.p0.m():boolean");
    }

    public final boolean n() {
        return this.f7342u != null;
    }

    public final void p() {
        e eVar;
        h hVar;
        if (this.f7344w == null) {
            this.f7326f0 = Looper.myLooper();
            j jVar = new j(this.f7315a, new a3.i(this, 20), this.f7346y, this.Z);
            this.f7344w = jVar;
            if (jVar.f7280j) {
                eVar = jVar.f7278g;
                eVar.getClass();
            } else {
                jVar.f7280j = true;
                i iVar = jVar.f7277f;
                if (iVar != null) {
                    iVar.f7258a.registerContentObserver(iVar.f7259b, false, iVar);
                }
                int i9 = g1.w.f3713a;
                Handler handler = jVar.f7274c;
                Context context = jVar.f7272a;
                if (i9 >= 23 && (hVar = jVar.f7275d) != null) {
                    g.a(context, hVar, handler);
                }
                com.bumptech.glide.manager.p pVar = jVar.f7276e;
                e b9 = e.b(context, pVar != null ? context.registerReceiver(pVar, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, handler) : null, jVar.f7279i, jVar.h);
                jVar.f7278g = b9;
                eVar = b9;
            }
            this.f7343v = eVar;
        }
    }

    public final void q() {
        this.V = false;
        if (n()) {
            z zVar = this.h;
            zVar.d();
            if (zVar.f7424y == -9223372036854775807L) {
                y yVar = zVar.f7406f;
                yVar.getClass();
                yVar.a();
            } else {
                zVar.A = zVar.b();
                if (!o(this.f7342u)) {
                    return;
                }
            }
            this.f7342u.pause();
        }
    }

    public final void r() {
        this.V = true;
        if (n()) {
            z zVar = this.h;
            if (zVar.f7424y != -9223372036854775807L) {
                zVar.J.getClass();
                zVar.f7424y = g1.w.M(SystemClock.elapsedRealtime());
            }
            y yVar = zVar.f7406f;
            yVar.getClass();
            yVar.a();
            this.f7342u.play();
        }
    }

    public final void s() {
        if (this.U) {
            return;
        }
        this.U = true;
        long j5 = j();
        z zVar = this.h;
        zVar.A = zVar.b();
        zVar.J.getClass();
        zVar.f7424y = g1.w.M(SystemClock.elapsedRealtime());
        zVar.B = j5;
        this.f7342u.stop();
        this.E = 0;
    }

    public final void t() {
        if (!this.T && n() && c()) {
            s();
            this.T = true;
        }
    }

    public final void u(long j5) {
        ByteBuffer byteBuffer;
        if (!this.f7341t.d()) {
            ByteBuffer byteBuffer2 = this.O;
            if (byteBuffer2 == null) {
                byteBuffer2 = e1.d.f3023a;
            }
            C(byteBuffer2, j5);
            return;
        }
        while (!this.f7341t.c()) {
            do {
                e1.a aVar = this.f7341t;
                if (aVar.d()) {
                    ByteBuffer byteBuffer3 = aVar.f3016c[aVar.b()];
                    if (byteBuffer3.hasRemaining()) {
                        byteBuffer = byteBuffer3;
                    } else {
                        aVar.e(e1.d.f3023a);
                        byteBuffer = aVar.f3016c[aVar.b()];
                    }
                } else {
                    byteBuffer = e1.d.f3023a;
                }
                if (byteBuffer.hasRemaining()) {
                    C(byteBuffer, j5);
                } else {
                    ByteBuffer byteBuffer4 = this.O;
                    if (byteBuffer4 == null || !byteBuffer4.hasRemaining()) {
                        return;
                    }
                    e1.a aVar2 = this.f7341t;
                    ByteBuffer byteBuffer5 = this.O;
                    if (aVar2.d() && !aVar2.f3017d) {
                        aVar2.e(byteBuffer5);
                    }
                }
            } while (!byteBuffer.hasRemaining());
            return;
        }
    }

    public final void v() {
        e();
        b6.e0 listIterator = this.f7323e.listIterator(0);
        while (listIterator.hasNext()) {
            ((e1.d) listIterator.next()).reset();
        }
        b6.e0 listIterator2 = this.f7325f.listIterator(0);
        while (listIterator2.hasNext()) {
            ((e1.d) listIterator2.next()).reset();
        }
        e1.a aVar = this.f7341t;
        if (aVar != null) {
            b6.g0 g0Var = aVar.f3014a;
            for (int i9 = 0; i9 < g0Var.size(); i9++) {
                e1.d dVar = (e1.d) g0Var.get(i9);
                dVar.flush();
                dVar.reset();
            }
            aVar.f3016c = new ByteBuffer[0];
            e1.b bVar = e1.b.f3018e;
            aVar.f3017d = false;
        }
        this.V = false;
        this.f7322d0 = false;
    }

    public final void w(d1.g gVar) {
        if (this.f7346y.equals(gVar)) {
            return;
        }
        this.f7346y = gVar;
        if (this.f7316a0) {
            return;
        }
        j jVar = this.f7344w;
        if (jVar != null) {
            jVar.f7279i = gVar;
            jVar.a(e.c(jVar.f7272a, gVar, jVar.h));
        }
        e();
    }

    public final void x() {
        PlaybackParams allowDefaults;
        PlaybackParams speed;
        PlaybackParams pitch;
        PlaybackParams audioFallbackMode;
        PlaybackParams playbackParams;
        float speed2;
        PlaybackParams playbackParams2;
        float pitch2;
        if (n()) {
            allowDefaults = f.i().allowDefaults();
            speed = allowDefaults.setSpeed(this.B.f2510a);
            pitch = speed.setPitch(this.B.f2511b);
            audioFallbackMode = pitch.setAudioFallbackMode(2);
            try {
                this.f7342u.setPlaybackParams(audioFallbackMode);
            } catch (IllegalArgumentException e9) {
                g1.a.E("DefaultAudioSink", "Failed to set playback params", e9);
            }
            playbackParams = this.f7342u.getPlaybackParams();
            speed2 = playbackParams.getSpeed();
            playbackParams2 = this.f7342u.getPlaybackParams();
            pitch2 = playbackParams2.getPitch();
            d1.o0 o0Var = new d1.o0(speed2, pitch2);
            this.B = o0Var;
            float f9 = o0Var.f2510a;
            z zVar = this.h;
            zVar.f7409j = f9;
            y yVar = zVar.f7406f;
            if (yVar != null) {
                yVar.a();
            }
            zVar.d();
        }
    }

    public final void y(d1.h hVar) {
        if (this.Y.equals(hVar)) {
            return;
        }
        hVar.getClass();
        if (this.f7342u != null) {
            this.Y.getClass();
        }
        this.Y = hVar;
    }

    public final void z(d1.o0 o0Var) {
        this.B = new d1.o0(g1.w.g(o0Var.f2510a, 0.1f, 8.0f), g1.w.g(o0Var.f2511b, 0.1f, 8.0f));
        if (B()) {
            x();
            return;
        }
        j0 j0Var = new j0(o0Var, -9223372036854775807L, -9223372036854775807L);
        if (n()) {
            this.f7347z = j0Var;
        } else {
            this.A = j0Var;
        }
    }
}
