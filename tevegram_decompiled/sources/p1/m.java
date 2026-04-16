package p1;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import b6.g0;
import d1.a0;
import d1.b0;
import d1.e0;
import d1.f0;
import g1.w;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import v1.x;
import v1.z;
import v1.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m extends v1.a {
    public final j h;

    /* renamed from: i, reason: collision with root package name */
    public final c f8170i;

    /* renamed from: j, reason: collision with root package name */
    public final o4.d f8171j;

    /* renamed from: k, reason: collision with root package name */
    public final o1.g f8172k;

    /* renamed from: l, reason: collision with root package name */
    public final z1.g f8173l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f8174m;

    /* renamed from: n, reason: collision with root package name */
    public final int f8175n;

    /* renamed from: o, reason: collision with root package name */
    public final q1.c f8176o;

    /* renamed from: p, reason: collision with root package name */
    public final long f8177p;

    /* renamed from: q, reason: collision with root package name */
    public a0 f8178q;

    /* renamed from: r, reason: collision with root package name */
    public z1.f f8179r;

    /* renamed from: s, reason: collision with root package name */
    public e0 f8180s;

    static {
        f0.a("media3.exoplayer.hls");
    }

    public m(e0 e0Var, c cVar, j jVar, o4.d dVar, o1.g gVar, z1.g gVar2, q1.c cVar2, long j5, boolean z8, int i9) {
        this.f8180s = e0Var;
        this.f8178q = e0Var.f2410c;
        this.f8170i = cVar;
        this.h = jVar;
        this.f8171j = dVar;
        this.f8172k = gVar;
        this.f8173l = gVar2;
        this.f8176o = cVar2;
        this.f8177p = j5;
        this.f8174m = z8;
        this.f8175n = i9;
    }

    public static q1.d s(long j5, List list) {
        q1.d dVar = null;
        for (int i9 = 0; i9 < list.size(); i9++) {
            q1.d dVar2 = (q1.d) list.get(i9);
            long j9 = dVar2.f8345m;
            if (j9 > j5 || !dVar2.f8334t) {
                if (j9 > j5) {
                    break;
                }
            } else {
                dVar = dVar2;
            }
        }
        return dVar;
    }

    @Override // v1.a
    public final x a(z zVar, z1.d dVar, long j5) {
        o1.d dVar2 = new o1.d(this.f9235c.f7571c, 0, zVar);
        o1.d dVar3 = new o1.d(this.f9236d.f7571c, 0, zVar);
        z1.f fVar = this.f8179r;
        m1.x xVar = this.f9239g;
        g1.a.l(xVar);
        return new l(this.h, this.f8176o, this.f8170i, fVar, this.f8172k, dVar3, this.f8173l, dVar2, dVar, this.f8171j, this.f8174m, this.f8175n, xVar);
    }

    @Override // v1.a
    public final synchronized e0 g() {
        return this.f8180s;
    }

    @Override // v1.a
    public final void i() {
        q1.c cVar = this.f8176o;
        z1.p pVar = cVar.f8326o;
        if (pVar != null) {
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
        }
        Uri uri = cVar.f8330s;
        if (uri != null) {
            q1.b bVar = (q1.b) cVar.f8323l.get(uri);
            z1.p pVar2 = bVar.f8309j;
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
            IOException iOException5 = bVar.f8317r;
            if (iOException5 != null) {
                throw iOException5;
            }
        }
    }

    @Override // v1.a
    public final void k(z1.f fVar) {
        this.f8179r = fVar;
        Looper myLooper = Looper.myLooper();
        myLooper.getClass();
        m1.x xVar = this.f9239g;
        g1.a.l(xVar);
        o1.g gVar = this.f8172k;
        gVar.d(myLooper, xVar);
        gVar.b();
        o1.d dVar = new o1.d(this.f9235c.f7571c, 0, null);
        b0 b0Var = g().f2409b;
        b0Var.getClass();
        Uri uri = b0Var.f2361a;
        q1.c cVar = this.f8176o;
        cVar.getClass();
        cVar.f8327p = w.l(null);
        cVar.f8325n = dVar;
        cVar.f8328q = this;
        z1.r rVar = new z1.r(((i1.g) cVar.f8320i.f8103i).a(), uri, cVar.f8321j.l());
        g1.a.k(cVar.f8326o == null);
        z1.p pVar = new z1.p("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        cVar.f8326o = pVar;
        z1.g gVar2 = cVar.f8322k;
        int i9 = rVar.f10592c;
        pVar.d(rVar, cVar, gVar2.getMinimumLoadableRetryCount(i9));
        dVar.h(new v1.q(rVar.f10591b), i9, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // v1.a
    public final void m(x xVar) {
        l lVar = (l) xVar;
        lVar.f8153j.f8324m.remove(lVar);
        for (r rVar : lVar.B) {
            if (rVar.L) {
                for (q qVar : rVar.D) {
                    qVar.j();
                    i7.x xVar2 = qVar.h;
                    if (xVar2 != null) {
                        xVar2.K(qVar.f9416e);
                        qVar.h = null;
                        qVar.f9418g = null;
                    }
                }
            }
            rVar.f8209r.c(rVar);
            rVar.f8217z.removeCallbacksAndMessages(null);
            rVar.P = true;
            rVar.A.clear();
        }
        lVar.f8168y = null;
    }

    @Override // v1.a
    public final void o() {
        q1.c cVar = this.f8176o;
        cVar.f8330s = null;
        cVar.f8331t = null;
        cVar.f8329r = null;
        cVar.f8333v = -9223372036854775807L;
        cVar.f8326o.c(null);
        cVar.f8326o = null;
        HashMap hashMap = cVar.f8323l;
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            ((q1.b) it.next()).f8309j.c(null);
        }
        cVar.f8327p.removeCallbacksAndMessages(null);
        cVar.f8327p = null;
        hashMap.clear();
        this.f8172k.release();
    }

    @Override // v1.a
    public final synchronized void r(e0 e0Var) {
        this.f8180s = e0Var;
    }

    public final void t(q1.i iVar) {
        long j5;
        z0 z0Var;
        boolean z8;
        long j9;
        long j10;
        long j11;
        long j12;
        boolean z9 = iVar.f8368p;
        boolean z10 = iVar.f8360g;
        g0 g0Var = iVar.f8370r;
        long j13 = iVar.f8373u;
        long j14 = iVar.f8358e;
        int i9 = iVar.f8357d;
        long j15 = iVar.h;
        long W = z9 ? w.W(j15) : -9223372036854775807L;
        long j16 = (i9 == 2 || i9 == 1) ? W : -9223372036854775807L;
        q1.c cVar = this.f8176o;
        cVar.f8329r.getClass();
        o4.d dVar = new o4.d(1);
        long j17 = 0;
        if (cVar.f8332u) {
            q1.h hVar = iVar.f8374v;
            long j18 = j15 - cVar.f8333v;
            boolean z11 = iVar.f8367o;
            long j19 = z11 ? j18 + j13 : -9223372036854775807L;
            if (iVar.f8368p) {
                int i10 = w.f3713a;
                z8 = z10;
                long j20 = this.f8177p;
                j9 = w.M(j20 == -9223372036854775807L ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + j20) - (j15 + j13);
            } else {
                z8 = z10;
                j9 = 0;
            }
            long j21 = this.f8178q.f2348a;
            if (j21 != -9223372036854775807L) {
                j11 = w.M(j21);
            } else {
                if (j14 != -9223372036854775807L) {
                    j10 = j13 - j14;
                } else {
                    j10 = hVar.f8355d;
                    if (j10 == -9223372036854775807L || iVar.f8366n == -9223372036854775807L) {
                        j10 = hVar.f8354c;
                        if (j10 == -9223372036854775807L) {
                            j10 = 3 * iVar.f8365m;
                        }
                    }
                }
                j11 = j10 + j9;
            }
            long j22 = j13 + j9;
            long i11 = w.i(j11, j9, j22);
            a0 a0Var = g().f2410c;
            boolean z12 = a0Var.f2351d == -3.4028235E38f && a0Var.f2352e == -3.4028235E38f && hVar.f8354c == -9223372036854775807L && hVar.f8355d == -9223372036854775807L;
            d1.z zVar = new d1.z();
            zVar.f2611a = w.W(i11);
            zVar.f2614d = z12 ? 1.0f : this.f8178q.f2351d;
            zVar.f2615e = z12 ? 1.0f : this.f8178q.f2352e;
            a0 a0Var2 = new a0(zVar);
            this.f8178q = a0Var2;
            if (j14 == -9223372036854775807L) {
                j14 = j22 - w.M(a0Var2.f2348a);
            }
            if (z8) {
                j17 = j14;
            } else {
                q1.d s8 = s(j14, iVar.f8371s);
                if (s8 != null) {
                    j12 = s8.f8345m;
                } else if (!g0Var.isEmpty()) {
                    q1.f fVar = (q1.f) g0Var.get(w.d(g0Var, Long.valueOf(j14), true));
                    q1.d s9 = s(j14, fVar.f8340u);
                    j12 = s9 != null ? s9.f8345m : fVar.f8345m;
                }
                j17 = j12;
            }
            z0Var = new z0(j16, W, j19, iVar.f8373u, j18, j17, true, !z11, i9 == 2 && iVar.f8359f, dVar, g(), this.f8178q);
        } else {
            if (j14 == -9223372036854775807L || g0Var.isEmpty()) {
                j5 = 0;
            } else {
                if (!z10 && j14 != j13) {
                    j14 = ((q1.f) g0Var.get(w.d(g0Var, Long.valueOf(j14), true))).f8345m;
                }
                j5 = j14;
            }
            long j23 = iVar.f8373u;
            z0Var = new z0(j16, W, j23, j23, 0L, j5, true, false, true, dVar, g(), null);
        }
        l(z0Var);
    }
}
