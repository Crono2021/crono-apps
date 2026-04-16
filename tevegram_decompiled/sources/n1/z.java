package n1;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.math.RoundingMode;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z {
    public long A;
    public long B;
    public long C;
    public long D;
    public boolean E;
    public long F;
    public long G;
    public boolean H;
    public long I;
    public g1.r J;

    /* renamed from: a, reason: collision with root package name */
    public final i7.x f7401a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f7402b;

    /* renamed from: c, reason: collision with root package name */
    public AudioTrack f7403c;

    /* renamed from: d, reason: collision with root package name */
    public int f7404d;

    /* renamed from: e, reason: collision with root package name */
    public int f7405e;

    /* renamed from: f, reason: collision with root package name */
    public y f7406f;

    /* renamed from: g, reason: collision with root package name */
    public int f7407g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public long f7408i;

    /* renamed from: j, reason: collision with root package name */
    public float f7409j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7410k;

    /* renamed from: l, reason: collision with root package name */
    public long f7411l;

    /* renamed from: m, reason: collision with root package name */
    public long f7412m;

    /* renamed from: n, reason: collision with root package name */
    public Method f7413n;

    /* renamed from: o, reason: collision with root package name */
    public long f7414o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7415p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7416q;

    /* renamed from: r, reason: collision with root package name */
    public long f7417r;

    /* renamed from: s, reason: collision with root package name */
    public long f7418s;

    /* renamed from: t, reason: collision with root package name */
    public long f7419t;

    /* renamed from: u, reason: collision with root package name */
    public long f7420u;

    /* renamed from: v, reason: collision with root package name */
    public long f7421v;

    /* renamed from: w, reason: collision with root package name */
    public int f7422w;

    /* renamed from: x, reason: collision with root package name */
    public int f7423x;

    /* renamed from: y, reason: collision with root package name */
    public long f7424y;

    /* renamed from: z, reason: collision with root package name */
    public long f7425z;

    public z(i7.x xVar) {
        this.f7401a = xVar;
        if (g1.w.f3713a >= 18) {
            try {
                this.f7413n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f7402b = new long[10];
        this.J = g1.r.f3705a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0208 A[Catch: Exception -> 0x021e, TRY_LEAVE, TryCatch #0 {Exception -> 0x021e, blocks: (B:48:0x01e3, B:50:0x0208), top: B:47:0x01e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0241  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(boolean r32) {
        /*
            Method dump skipped, instructions count: 802
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.z.a(boolean):long");
    }

    public final long b() {
        this.J.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f7424y != -9223372036854775807L) {
            AudioTrack audioTrack = this.f7403c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2) {
                return this.A;
            }
            return Math.min(this.B, this.A + g1.w.S(g1.w.w(g1.w.M(elapsedRealtime) - this.f7424y, this.f7409j), this.f7407g, 1000000L, RoundingMode.CEILING));
        }
        if (elapsedRealtime - this.f7418s >= 5) {
            AudioTrack audioTrack2 = this.f7403c;
            audioTrack2.getClass();
            int playState = audioTrack2.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = audioTrack2.getPlaybackHeadPosition() & 4294967295L;
                if (this.h) {
                    if (playState == 2 && playbackHeadPosition == 0) {
                        this.f7421v = this.f7419t;
                    }
                    playbackHeadPosition += this.f7421v;
                }
                if (g1.w.f3713a <= 29) {
                    if (playbackHeadPosition != 0 || this.f7419t <= 0 || playState != 3) {
                        this.f7425z = -9223372036854775807L;
                    } else if (this.f7425z == -9223372036854775807L) {
                        this.f7425z = elapsedRealtime;
                    }
                }
                long j5 = this.f7419t;
                if (j5 > playbackHeadPosition) {
                    if (this.H) {
                        this.I += j5;
                        this.H = false;
                    } else {
                        this.f7420u++;
                    }
                }
                this.f7419t = playbackHeadPosition;
            }
            this.f7418s = elapsedRealtime;
        }
        return this.f7419t + this.I + (this.f7420u << 32);
    }

    public final boolean c(long j5) {
        long a9 = a(false);
        int i9 = this.f7407g;
        int i10 = g1.w.f3713a;
        if (j5 > g1.w.S(a9, i9, 1000000L, RoundingMode.CEILING)) {
            return true;
        }
        if (this.h) {
            AudioTrack audioTrack = this.f7403c;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2 && b() == 0) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        this.f7411l = 0L;
        this.f7423x = 0;
        this.f7422w = 0;
        this.f7412m = 0L;
        this.D = 0L;
        this.G = 0L;
        this.f7410k = false;
    }
}
