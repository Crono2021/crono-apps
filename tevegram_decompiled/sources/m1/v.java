package m1;

import android.content.Context;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import b6.i0;
import d1.b0;
import d1.f1;
import d1.h1;
import d1.j0;
import d1.n0;
import d1.o0;
import d1.s0;
import d1.w0;
import d1.x0;
import d1.y0;
import java.io.IOException;
import java.util.HashMap;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements c {
    public boolean A;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6575a;

    /* renamed from: b, reason: collision with root package name */
    public final s f6576b;

    /* renamed from: c, reason: collision with root package name */
    public final PlaybackSession f6577c;

    /* renamed from: i, reason: collision with root package name */
    public String f6582i;

    /* renamed from: j, reason: collision with root package name */
    public PlaybackMetrics.Builder f6583j;

    /* renamed from: k, reason: collision with root package name */
    public int f6584k;

    /* renamed from: n, reason: collision with root package name */
    public n0 f6587n;

    /* renamed from: o, reason: collision with root package name */
    public i0 f6588o;

    /* renamed from: p, reason: collision with root package name */
    public i0 f6589p;

    /* renamed from: q, reason: collision with root package name */
    public i0 f6590q;

    /* renamed from: r, reason: collision with root package name */
    public d1.s f6591r;

    /* renamed from: s, reason: collision with root package name */
    public d1.s f6592s;

    /* renamed from: t, reason: collision with root package name */
    public d1.s f6593t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f6594u;

    /* renamed from: v, reason: collision with root package name */
    public int f6595v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6596w;

    /* renamed from: x, reason: collision with root package name */
    public int f6597x;

    /* renamed from: y, reason: collision with root package name */
    public int f6598y;

    /* renamed from: z, reason: collision with root package name */
    public int f6599z;

    /* renamed from: e, reason: collision with root package name */
    public final x0 f6579e = new x0();

    /* renamed from: f, reason: collision with root package name */
    public final w0 f6580f = new w0();
    public final HashMap h = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f6581g = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final long f6578d = SystemClock.elapsedRealtime();

    /* renamed from: l, reason: collision with root package name */
    public int f6585l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f6586m = 0;

    public v(Context context, PlaybackSession playbackSession) {
        this.f6575a = context.getApplicationContext();
        this.f6577c = playbackSession;
        s sVar = new s();
        this.f6576b = sVar;
        sVar.f6571d = this;
    }

    @Override // m1.c
    public final void A(a aVar, v1.v vVar, IOException iOException) {
        this.f6595v = vVar.f9437a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04f6  */
    @Override // m1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(d1.t0 r23, m1.b r24) {
        /*
            Method dump skipped, instructions count: 1532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.v.E(d1.t0, m1.b):void");
    }

    @Override // m1.c
    public final void J(a aVar, l1.f fVar) {
        this.f6597x += fVar.f5861g;
        this.f6598y += fVar.f5859e;
    }

    @Override // m1.c
    public final void K(a aVar, n0 n0Var) {
        this.f6587n = n0Var;
    }

    @Override // m1.c
    public final void L(a aVar, v1.v vVar) {
        z zVar = aVar.f6503d;
        if (zVar == null) {
            return;
        }
        d1.s sVar = vVar.f9439c;
        sVar.getClass();
        int i9 = vVar.f9440d;
        y0 y0Var = aVar.f6501b;
        zVar.getClass();
        i0 i0Var = new i0(sVar, i9, this.f6576b.d(y0Var, zVar));
        int i10 = vVar.f9438b;
        if (i10 != 0) {
            if (i10 == 1) {
                this.f6589p = i0Var;
                return;
            } else if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                this.f6590q = i0Var;
                return;
            }
        }
        this.f6588o = i0Var;
    }

    public final boolean M(i0 i0Var) {
        String str;
        if (i0Var == null) {
            return false;
        }
        String str2 = (String) i0Var.f1400l;
        s sVar = this.f6576b;
        synchronized (sVar) {
            str = sVar.f6573f;
        }
        return str2.equals(str);
    }

    public final void N() {
        PlaybackMetrics build;
        PlaybackMetrics.Builder builder = this.f6583j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.f6599z);
            this.f6583j.setVideoFramesDropped(this.f6597x);
            this.f6583j.setVideoFramesPlayed(this.f6598y);
            Long l4 = (Long) this.f6581g.get(this.f6582i);
            this.f6583j.setNetworkTransferDurationMillis(l4 == null ? 0L : l4.longValue());
            Long l9 = (Long) this.h.get(this.f6582i);
            this.f6583j.setNetworkBytesRead(l9 == null ? 0L : l9.longValue());
            this.f6583j.setStreamSource((l9 == null || l9.longValue() <= 0) ? 0 : 1);
            PlaybackSession playbackSession = this.f6577c;
            build = this.f6583j.build();
            playbackSession.reportPlaybackMetrics(build);
        }
        this.f6583j = null;
        this.f6582i = null;
        this.f6599z = 0;
        this.f6597x = 0;
        this.f6598y = 0;
        this.f6591r = null;
        this.f6592s = null;
        this.f6593t = null;
        this.A = false;
    }

    public final void O(y0 y0Var, z zVar) {
        int b9;
        PlaybackMetrics.Builder builder = this.f6583j;
        if (zVar == null || (b9 = y0Var.b(zVar.f9447a)) == -1) {
            return;
        }
        w0 w0Var = this.f6580f;
        int i9 = 0;
        y0Var.f(b9, w0Var, false);
        int i10 = w0Var.f2586c;
        x0 x0Var = this.f6579e;
        y0Var.n(i10, x0Var);
        b0 b0Var = x0Var.f2596c.f2409b;
        if (b0Var != null) {
            int F = g1.w.F(b0Var.f2361a, b0Var.f2362b);
            i9 = F != 0 ? F != 1 ? F != 2 ? 1 : 4 : 5 : 3;
        }
        builder.setStreamType(i9);
        if (x0Var.f2606n != -9223372036854775807L && !x0Var.f2604l && !x0Var.f2601i && !x0Var.a()) {
            builder.setMediaDurationMillis(g1.w.W(x0Var.f2606n));
        }
        builder.setPlaybackType(x0Var.a() ? 2 : 1);
        this.A = true;
    }

    public final void P(a aVar, String str) {
        z zVar = aVar.f6503d;
        if ((zVar == null || !zVar.b()) && str.equals(this.f6582i)) {
            N();
        }
        this.f6581g.remove(str);
        this.h.remove(str);
    }

    public final void Q(int i9, long j5, d1.s sVar, int i10) {
        TrackChangeEvent.Builder timeSinceCreatedMillis;
        TrackChangeEvent build;
        int i11;
        timeSinceCreatedMillis = t.m(i9).setTimeSinceCreatedMillis(j5 - this.f6578d);
        if (sVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            if (i10 != 1) {
                i11 = 3;
                if (i10 != 2) {
                    i11 = i10 != 3 ? 1 : 4;
                }
            } else {
                i11 = 2;
            }
            timeSinceCreatedMillis.setTrackChangeReason(i11);
            String str = sVar.f2553l;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = sVar.f2554m;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = sVar.f2551j;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i12 = sVar.f2550i;
            if (i12 != -1) {
                timeSinceCreatedMillis.setBitrate(i12);
            }
            int i13 = sVar.f2559r;
            if (i13 != -1) {
                timeSinceCreatedMillis.setWidth(i13);
            }
            int i14 = sVar.f2560s;
            if (i14 != -1) {
                timeSinceCreatedMillis.setHeight(i14);
            }
            int i15 = sVar.f2567z;
            if (i15 != -1) {
                timeSinceCreatedMillis.setChannelCount(i15);
            }
            int i16 = sVar.A;
            if (i16 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i16);
            }
            String str4 = sVar.f2546d;
            if (str4 != null) {
                int i17 = g1.w.f3713a;
                String[] split = str4.split("-", -1);
                Pair create = Pair.create(split[0], split.length >= 2 ? split[1] : null);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                Object obj = create.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f9 = sVar.f2561t;
            if (f9 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f9);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        PlaybackSession playbackSession = this.f6577c;
        build = timeSinceCreatedMillis.build();
        playbackSession.reportTrackChangeEvent(build);
    }

    @Override // m1.c
    public final void m(int i9, s0 s0Var, s0 s0Var2, a aVar) {
        if (i9 == 1) {
            this.f6594u = true;
        }
        this.f6584k = i9;
    }

    @Override // m1.c
    public final void p(int i9, long j5, a aVar) {
        z zVar = aVar.f6503d;
        if (zVar != null) {
            String d9 = this.f6576b.d(aVar.f6501b, zVar);
            HashMap hashMap = this.h;
            Long l4 = (Long) hashMap.get(d9);
            HashMap hashMap2 = this.f6581g;
            Long l9 = (Long) hashMap2.get(d9);
            hashMap.put(d9, Long.valueOf((l4 == null ? 0L : l4.longValue()) + j5));
            hashMap2.put(d9, Long.valueOf((l9 != null ? l9.longValue() : 0L) + i9));
        }
    }

    @Override // m1.c
    public final void x(a aVar, h1 h1Var) {
        i0 i0Var = this.f6588o;
        if (i0Var != null) {
            d1.s sVar = (d1.s) i0Var.f1399k;
            if (sVar.f2560s == -1) {
                d1.r a9 = sVar.a();
                a9.f2533q = h1Var.f2474a;
                a9.f2534r = h1Var.f2475b;
                this.f6588o = new i0(new d1.s(a9), i0Var.f1398j, (String) i0Var.f1400l);
            }
        }
    }

    @Override // m1.c
    public final /* synthetic */ void C(a aVar) {
    }

    @Override // m1.c
    public final /* synthetic */ void e(a aVar) {
    }

    @Override // m1.c
    public final /* synthetic */ void k(a aVar) {
    }

    @Override // m1.c
    public final /* synthetic */ void B(a aVar, j0 j0Var) {
    }

    @Override // m1.c
    public final /* synthetic */ void D(a aVar, o0 o0Var) {
    }

    @Override // m1.c
    public final /* synthetic */ void F(a aVar, boolean z8) {
    }

    @Override // m1.c
    public final /* synthetic */ void G(a aVar, boolean z8) {
    }

    @Override // m1.c
    public final /* synthetic */ void H(a aVar, int i9) {
    }

    @Override // m1.c
    public final /* synthetic */ void a(a aVar, d1.s sVar) {
    }

    @Override // m1.c
    public final /* synthetic */ void b(a aVar, int i9) {
    }

    @Override // m1.c
    public final /* synthetic */ void c(a aVar, n1.r rVar) {
    }

    @Override // m1.c
    public final /* synthetic */ void d(a aVar, v1.v vVar) {
    }

    @Override // m1.c
    public final /* synthetic */ void f(a aVar, int i9) {
    }

    @Override // m1.c
    public final /* synthetic */ void g(a aVar, String str) {
    }

    @Override // m1.c
    public final /* synthetic */ void h(a aVar, boolean z8) {
    }

    @Override // m1.c
    public final /* synthetic */ void i(a aVar, f1 f1Var) {
    }

    @Override // m1.c
    public final /* synthetic */ void j(a aVar, int i9) {
    }

    @Override // m1.c
    public final /* synthetic */ void l(a aVar, String str) {
    }

    @Override // m1.c
    public final /* synthetic */ void n(a aVar, Object obj) {
    }

    @Override // m1.c
    public final /* synthetic */ void o(a aVar, int i9) {
    }

    @Override // m1.c
    public final /* synthetic */ void q(a aVar, String str) {
    }

    @Override // m1.c
    public final /* synthetic */ void t(a aVar, int i9) {
    }

    @Override // m1.c
    public final /* synthetic */ void u(a aVar, boolean z8) {
    }

    @Override // m1.c
    public final /* synthetic */ void v(a aVar, float f9) {
    }

    @Override // m1.c
    public final /* synthetic */ void w(a aVar, n1.r rVar) {
    }

    @Override // m1.c
    public final /* synthetic */ void y(a aVar, String str) {
    }

    @Override // m1.c
    public final /* synthetic */ void z(a aVar, d1.s sVar) {
    }

    @Override // m1.c
    public final /* synthetic */ void I(a aVar, boolean z8, int i9) {
    }

    @Override // m1.c
    public final /* synthetic */ void r(a aVar, int i9, int i10) {
    }

    @Override // m1.c
    public final /* synthetic */ void s(a aVar, int i9, long j5, long j9) {
    }
}
