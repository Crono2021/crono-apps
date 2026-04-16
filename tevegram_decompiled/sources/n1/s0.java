package n1;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import l1.c1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s0 extends s1.s implements l1.k0 {
    public final Context N0;
    public final m1.b O0;
    public final w P0;
    public int Q0;
    public boolean R0;
    public boolean S0;
    public d1.s T0;
    public d1.s U0;
    public long V0;
    public boolean W0;
    public boolean X0;
    public l1.c0 Y0;
    public boolean Z0;

    public s0(Context context, s1.j jVar, s1.t tVar, boolean z8, Handler handler, q qVar, w wVar) {
        super(1, jVar, tVar, z8, 44100.0f);
        this.N0 = context.getApplicationContext();
        this.P0 = wVar;
        this.O0 = new m1.b(handler, qVar);
        ((p0) wVar).f7338q = new i7.x(this, 13);
    }

    @Override // s1.s
    public final l1.g C(s1.n nVar, d1.s sVar, d1.s sVar2) {
        l1.g b9 = nVar.b(sVar, sVar2);
        int i9 = b9.f5876e;
        if (this.N == null && p0(sVar2)) {
            i9 |= 32768;
        }
        if (v0(nVar, sVar2) > this.Q0) {
            i9 |= 64;
        }
        int i10 = i9;
        return new l1.g(nVar.f8714a, sVar, sVar2, i10 != 0 ? 0 : b9.f5875d, i10);
    }

    @Override // s1.s
    public final float N(float f9, d1.s[] sVarArr) {
        int i9 = -1;
        for (d1.s sVar : sVarArr) {
            int i10 = sVar.A;
            if (i10 != -1) {
                i9 = Math.max(i9, i10);
            }
        }
        if (i9 == -1) {
            return -1.0f;
        }
        return i9 * f9;
    }

    @Override // s1.s
    public final ArrayList O(s1.t tVar, d1.s sVar, boolean z8) {
        b6.w0 g9;
        if (sVar.f2554m == null) {
            g9 = b6.w0.f1464m;
        } else {
            if (((p0) this.P0).A(sVar)) {
                List e9 = s1.z.e("audio/raw", false, false);
                s1.n nVar = e9.isEmpty() ? null : (s1.n) e9.get(0);
                if (nVar != null) {
                    g9 = b6.g0.q(nVar);
                }
            }
            g9 = s1.z.g(tVar, sVar, z8, false);
        }
        Pattern pattern = s1.z.f8761a;
        ArrayList arrayList = new ArrayList(g9);
        Collections.sort(arrayList, new s1.u(new a3.i(sVar, 22)));
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d4, code lost:
    
        if ("AXON 7 mini".equals(r6) == false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010a  */
    @Override // s1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s1.i P(s1.n r13, d1.s r14, android.media.MediaCrypto r15, float r16) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.s0.P(s1.n, d1.s, android.media.MediaCrypto, float):s1.i");
    }

    @Override // s1.s
    public final void Q(j1.e eVar) {
        d1.s sVar;
        i0 i0Var;
        if (g1.w.f3713a < 29 || (sVar = eVar.f5357k) == null || !Objects.equals(sVar.f2554m, "audio/opus") || !this.f8746r0) {
            return;
        }
        ByteBuffer byteBuffer = eVar.f5362p;
        byteBuffer.getClass();
        d1.s sVar2 = eVar.f5357k;
        sVar2.getClass();
        int i9 = sVar2.C;
        if (byteBuffer.remaining() == 8) {
            int i10 = (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000);
            p0 p0Var = (p0) this.P0;
            AudioTrack audioTrack = p0Var.f7342u;
            if (audioTrack == null || !p0.o(audioTrack) || (i0Var = p0Var.f7340s) == null || !i0Var.f7270k) {
                return;
            }
            p0Var.f7342u.setOffloadDelayPadding(i9, i10);
        }
    }

    @Override // s1.s
    public final void V(Exception exc) {
        g1.a.q("MediaCodecAudioRenderer", "Audio codec error", exc);
        m1.b bVar = this.O0;
        Handler handler = (Handler) bVar.f6510j;
        if (handler != null) {
            handler.post(new o(bVar, exc, 0));
        }
    }

    @Override // s1.s
    public final void W(long j5, long j9, String str) {
        m1.b bVar = this.O0;
        Handler handler = (Handler) bVar.f6510j;
        if (handler != null) {
            handler.post(new b2.e0(bVar, str, j5, j9, 1));
        }
    }

    @Override // s1.s
    public final void X(String str) {
        m1.b bVar = this.O0;
        Handler handler = (Handler) bVar.f6510j;
        if (handler != null) {
            handler.post(new b2.f0(bVar, 14, str));
        }
    }

    @Override // s1.s
    public final l1.g Y(a5.d dVar) {
        d1.s sVar = (d1.s) dVar.f175k;
        sVar.getClass();
        this.T0 = sVar;
        l1.g Y = super.Y(dVar);
        m1.b bVar = this.O0;
        Handler handler = (Handler) bVar.f6510j;
        if (handler != null) {
            handler.post(new androidx.emoji2.text.m(bVar, sVar, Y, 5));
        }
        return Y;
    }

    @Override // s1.s
    public final void Z(d1.s sVar, MediaFormat mediaFormat) {
        d1.s sVar2 = this.U0;
        boolean z8 = true;
        int[] iArr = null;
        if (sVar2 != null) {
            sVar = sVar2;
        } else if (this.S != null) {
            mediaFormat.getClass();
            String str = sVar.f2554m;
            int i9 = sVar.f2567z;
            int x6 = "audio/raw".equals(str) ? sVar.B : (g1.w.f3713a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? g1.w.x(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding");
            d1.r rVar = new d1.r();
            rVar.f2528l = d1.l0.k("audio/raw");
            rVar.A = x6;
            rVar.B = sVar.C;
            rVar.C = sVar.D;
            rVar.f2526j = sVar.f2552k;
            rVar.f2518a = sVar.f2543a;
            rVar.f2519b = sVar.f2544b;
            rVar.f2520c = b6.g0.m(sVar.f2545c);
            rVar.f2521d = sVar.f2546d;
            rVar.f2522e = sVar.f2547e;
            rVar.f2523f = sVar.f2548f;
            rVar.f2541y = mediaFormat.getInteger("channel-count");
            rVar.f2542z = mediaFormat.getInteger("sample-rate");
            sVar = new d1.s(rVar);
            boolean z9 = this.R0;
            int i10 = sVar.f2567z;
            if (z9 && i10 == 6 && i9 < 6) {
                iArr = new int[i9];
                for (int i11 = 0; i11 < i9; i11++) {
                    iArr[i11] = i11;
                }
            } else if (this.S0) {
                if (i10 == 3) {
                    iArr = new int[]{0, 2, 1};
                } else if (i10 == 5) {
                    iArr = new int[]{0, 2, 1, 3, 4};
                } else if (i10 == 6) {
                    iArr = new int[]{0, 2, 1, 5, 3, 4};
                } else if (i10 == 7) {
                    iArr = new int[]{0, 2, 1, 6, 5, 3, 4};
                } else if (i10 == 8) {
                    iArr = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                }
            }
        }
        try {
            int i12 = g1.w.f3713a;
            w wVar = this.P0;
            if (i12 >= 29) {
                if (this.f8746r0) {
                    c1 c1Var = this.f5829l;
                    c1Var.getClass();
                    if (c1Var.f5810a != 0) {
                        c1 c1Var2 = this.f5829l;
                        c1Var2.getClass();
                        int i13 = c1Var2.f5810a;
                        p0 p0Var = (p0) wVar;
                        p0Var.getClass();
                        if (i12 < 29) {
                            z8 = false;
                        }
                        g1.a.k(z8);
                        p0Var.f7331j = i13;
                    }
                }
                p0 p0Var2 = (p0) wVar;
                p0Var2.getClass();
                if (i12 < 29) {
                    z8 = false;
                }
                g1.a.k(z8);
                p0Var2.f7331j = 0;
            }
            ((p0) wVar).b(sVar, iArr);
        } catch (s e9) {
            throw l(e9, e9.f7355i, false, 5001);
        }
    }

    @Override // l1.e, l1.b1
    public final boolean a() {
        if (!this.E0) {
            return false;
        }
        p0 p0Var = (p0) this.P0;
        if (p0Var.n()) {
            return p0Var.T && !p0Var.l();
        }
        return true;
    }

    @Override // s1.s
    public final void a0() {
        this.P0.getClass();
    }

    @Override // s1.s, l1.b1
    public final boolean b() {
        return ((p0) this.P0).l() || super.b();
    }

    @Override // l1.k0
    public final boolean c() {
        boolean z8 = this.Z0;
        this.Z0 = false;
        return z8;
    }

    @Override // s1.s
    public final void c0() {
        ((p0) this.P0).K = true;
    }

    @Override // l1.k0
    public final d1.o0 d() {
        return ((p0) this.P0).B;
    }

    @Override // l1.k0
    public final void e(d1.o0 o0Var) {
        ((p0) this.P0).z(o0Var);
    }

    @Override // l1.e, l1.x0
    public final void g(int i9, Object obj) {
        w wVar = this.P0;
        if (i9 == 2) {
            obj.getClass();
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
            d1.g gVar = (d1.g) obj;
            gVar.getClass();
            ((p0) wVar).w(gVar);
            return;
        }
        if (i9 == 6) {
            d1.h hVar = (d1.h) obj;
            hVar.getClass();
            ((p0) wVar).y(hVar);
            return;
        }
        switch (i9) {
            case 9:
                obj.getClass();
                p0 p0Var2 = (p0) wVar;
                p0Var2.C = ((Boolean) obj).booleanValue();
                j0 j0Var = new j0(p0Var2.B() ? d1.o0.f2509d : p0Var2.B, -9223372036854775807L, -9223372036854775807L);
                if (!p0Var2.n()) {
                    p0Var2.A = j0Var;
                    break;
                } else {
                    p0Var2.f7347z = j0Var;
                    break;
                }
            case 10:
                obj.getClass();
                int intValue = ((Integer) obj).intValue();
                p0 p0Var3 = (p0) wVar;
                if (p0Var3.X != intValue) {
                    p0Var3.X = intValue;
                    p0Var3.W = intValue != 0;
                    p0Var3.e();
                    break;
                }
                break;
            case 11:
                this.Y0 = (l1.c0) obj;
                break;
            case 12:
                if (g1.w.f3713a >= 23) {
                    r0.a(wVar, obj);
                    break;
                }
                break;
        }
    }

    @Override // s1.s
    public final boolean g0(long j5, long j9, s1.k kVar, ByteBuffer byteBuffer, int i9, int i10, int i11, long j10, boolean z8, boolean z9, d1.s sVar) {
        int i12;
        int i13;
        byteBuffer.getClass();
        if (this.U0 != null && (i10 & 2) != 0) {
            kVar.getClass();
            kVar.releaseOutputBuffer(i9, false);
            return true;
        }
        w wVar = this.P0;
        if (z8) {
            if (kVar != null) {
                kVar.releaseOutputBuffer(i9, false);
            }
            this.I0.f5860f += i11;
            ((p0) wVar).K = true;
            return true;
        }
        try {
            if (!((p0) wVar).k(byteBuffer, j10, i11)) {
                return false;
            }
            if (kVar != null) {
                kVar.releaseOutputBuffer(i9, false);
            }
            this.I0.f5859e += i11;
            return true;
        } catch (t e9) {
            d1.s sVar2 = this.T0;
            if (this.f8746r0) {
                c1 c1Var = this.f5829l;
                c1Var.getClass();
                if (c1Var.f5810a != 0) {
                    i13 = 5004;
                    throw l(e9, sVar2, e9.f7357j, i13);
                }
            }
            i13 = 5001;
            throw l(e9, sVar2, e9.f7357j, i13);
        } catch (v e10) {
            if (this.f8746r0) {
                c1 c1Var2 = this.f5829l;
                c1Var2.getClass();
                if (c1Var2.f5810a != 0) {
                    i12 = 5003;
                    throw l(e10, sVar, e10.f7380j, i12);
                }
            }
            i12 = 5002;
            throw l(e10, sVar, e10.f7380j, i12);
        }
    }

    @Override // l1.b1
    public final String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // l1.k0
    public final long j() {
        if (this.f5833p == 2) {
            w0();
        }
        return this.V0;
    }

    @Override // s1.s
    public final void j0() {
        try {
            ((p0) this.P0).t();
        } catch (v e9) {
            throw l(e9, e9.f7381k, e9.f7380j, this.f8746r0 ? 5003 : 5002);
        }
    }

    @Override // s1.s, l1.e
    public final void n() {
        m1.b bVar = this.O0;
        this.X0 = true;
        this.T0 = null;
        try {
            ((p0) this.P0).e();
            try {
                super.n();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.n();
                throw th;
            } finally {
            }
        }
    }

    @Override // l1.e
    public final void o(boolean z8, boolean z9) {
        l1.f fVar = new l1.f();
        this.I0 = fVar;
        m1.b bVar = this.O0;
        Handler handler = (Handler) bVar.f6510j;
        if (handler != null) {
            handler.post(new m(bVar, fVar, 0));
        }
        c1 c1Var = this.f5829l;
        c1Var.getClass();
        boolean z10 = c1Var.f5811b;
        w wVar = this.P0;
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

    @Override // s1.s
    public final boolean p0(d1.s sVar) {
        c1 c1Var = this.f5829l;
        c1Var.getClass();
        if (c1Var.f5810a != 0) {
            int u02 = u0(sVar);
            if ((u02 & IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED) != 0) {
                c1 c1Var2 = this.f5829l;
                c1Var2.getClass();
                if (c1Var2.f5810a == 2 || (u02 & 1024) != 0) {
                    return true;
                }
                if (sVar.C == 0 && sVar.D == 0) {
                    return true;
                }
            }
        }
        return ((p0) this.P0).A(sVar);
    }

    @Override // s1.s, l1.e
    public final void q(long j5, boolean z8) {
        super.q(j5, z8);
        ((p0) this.P0).e();
        this.V0 = j5;
        this.Z0 = false;
        this.W0 = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if ((r8.isEmpty() ? null : (s1.n) r8.get(0)) != null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    @Override // s1.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int q0(s1.t r18, d1.s r19) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.s0.q0(s1.t, d1.s):int");
    }

    @Override // l1.e
    public final void r() {
        h hVar;
        j jVar = ((p0) this.P0).f7344w;
        if (jVar != null) {
            Context context = jVar.f7272a;
            if (jVar.f7280j) {
                jVar.f7278g = null;
                if (g1.w.f3713a >= 23 && (hVar = jVar.f7275d) != null) {
                    g.b(context, hVar);
                }
                com.bumptech.glide.manager.p pVar = jVar.f7276e;
                if (pVar != null) {
                    context.unregisterReceiver(pVar);
                }
                i iVar = jVar.f7277f;
                if (iVar != null) {
                    iVar.f7258a.unregisterContentObserver(iVar);
                }
                jVar.f7280j = false;
            }
        }
    }

    @Override // l1.e
    public final void s() {
        w wVar = this.P0;
        this.Z0 = false;
        try {
            try {
                E();
                i0();
            } finally {
                androidx.activity.g.z(this.N, null);
                this.N = null;
            }
        } finally {
            if (this.X0) {
                this.X0 = false;
                ((p0) wVar).v();
            }
        }
    }

    @Override // l1.e
    public final void t() {
        ((p0) this.P0).r();
    }

    @Override // l1.e
    public final void u() {
        w0();
        ((p0) this.P0).q();
    }

    public final int u0(d1.s sVar) {
        l g9 = ((p0) this.P0).g(sVar);
        if (!g9.f7287a) {
            return 0;
        }
        int i9 = g9.f7288b ? 1536 : IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED;
        return g9.f7289c ? i9 | IjkMediaMeta.FF_PROFILE_H264_INTRA : i9;
    }

    public final int v0(s1.n nVar, d1.s sVar) {
        int i9;
        if (!"OMX.google.raw.decoder".equals(nVar.f8714a) || (i9 = g1.w.f3713a) >= 24 || (i9 == 23 && g1.w.L(this.N0))) {
            return sVar.f2555n;
        }
        return -1;
    }

    public final void w0() {
        long f9 = ((p0) this.P0).f(a());
        if (f9 != Long.MIN_VALUE) {
            if (!this.W0) {
                f9 = Math.max(this.V0, f9);
            }
            this.V0 = f9;
            this.W0 = false;
        }
    }

    @Override // l1.e, l1.b1
    public final l1.k0 i() {
        return this;
    }
}
