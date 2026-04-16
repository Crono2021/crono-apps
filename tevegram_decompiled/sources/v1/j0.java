package v1;

import android.net.Uri;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j0 implements z1.m {

    /* renamed from: b, reason: collision with root package name */
    public final Uri f9309b;

    /* renamed from: c, reason: collision with root package name */
    public final i1.a0 f9310c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.fragment.app.g f9311d;

    /* renamed from: e, reason: collision with root package name */
    public final m0 f9312e;

    /* renamed from: f, reason: collision with root package name */
    public final d2.f0 f9313f;
    public volatile boolean h;

    /* renamed from: j, reason: collision with root package name */
    public long f9316j;

    /* renamed from: l, reason: collision with root package name */
    public u0 f9318l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9319m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ m0 f9320n;

    /* renamed from: g, reason: collision with root package name */
    public final d1.w f9314g = new d1.w();

    /* renamed from: i, reason: collision with root package name */
    public boolean f9315i = true;

    /* renamed from: a, reason: collision with root package name */
    public final long f9308a = q.f9378b.getAndIncrement();

    /* renamed from: k, reason: collision with root package name */
    public i1.k f9317k = c(0);

    public j0(m0 m0Var, Uri uri, i1.h hVar, androidx.fragment.app.g gVar, m0 m0Var2, d2.f0 f0Var) {
        this.f9320n = m0Var;
        this.f9309b = uri;
        this.f9310c = new i1.a0(hVar);
        this.f9311d = gVar;
        this.f9312e = m0Var2;
        this.f9313f = f0Var;
    }

    @Override // z1.m
    public final void a() {
        i1.h hVar;
        d2.m mVar;
        int i9;
        int i10 = 0;
        while (i10 == 0 && !this.h) {
            try {
                long j5 = this.f9314g.f2583a;
                i1.k c9 = c(j5);
                this.f9317k = c9;
                long f9 = this.f9310c.f(c9);
                if (this.h) {
                    if (i10 != 1 && this.f9311d.P() != -1) {
                        this.f9314g.f2583a = this.f9311d.P();
                    }
                    com.bumptech.glide.d.i(this.f9310c);
                    return;
                }
                if (f9 != -1) {
                    f9 += j5;
                    m0 m0Var = this.f9320n;
                    m0Var.f9346w.post(new h0(m0Var, 0));
                }
                long j9 = f9;
                this.f9320n.f9349z = p2.b.d(this.f9310c.f4287i.g());
                i1.a0 a0Var = this.f9310c;
                p2.b bVar = this.f9320n.f9349z;
                if (bVar == null || (i9 = bVar.f8243n) == -1) {
                    hVar = a0Var;
                } else {
                    hVar = new p(a0Var, i9, this);
                    u0 C = this.f9320n.C(new l0(0, true));
                    this.f9318l = C;
                    C.e(m0.V);
                }
                this.f9311d.c0(hVar, this.f9309b, this.f9310c.f4287i.g(), j5, j9, this.f9312e);
                if (this.f9320n.f9349z != null && (mVar = (d2.m) this.f9311d.f729k) != null) {
                    d2.m a9 = mVar.a();
                    if (a9 instanceof v2.d) {
                        ((v2.d) a9).f9489q = true;
                    }
                }
                if (this.f9315i) {
                    androidx.fragment.app.g gVar = this.f9311d;
                    long j10 = this.f9316j;
                    d2.m mVar2 = (d2.m) gVar.f729k;
                    mVar2.getClass();
                    mVar2.c(j5, j10);
                    this.f9315i = false;
                }
                while (i10 == 0 && !this.h) {
                    try {
                        d2.f0 f0Var = this.f9313f;
                        synchronized (f0Var) {
                            while (!f0Var.f2689a) {
                                f0Var.wait();
                            }
                        }
                        androidx.fragment.app.g gVar2 = this.f9311d;
                        d1.w wVar = this.f9314g;
                        d2.m mVar3 = (d2.m) gVar2.f729k;
                        mVar3.getClass();
                        d2.j jVar = (d2.j) gVar2.f730l;
                        jVar.getClass();
                        i10 = mVar3.h(jVar, wVar);
                        long P = this.f9311d.P();
                        if (P > this.f9320n.f9340q + j5) {
                            this.f9313f.a();
                            m0 m0Var2 = this.f9320n;
                            m0Var2.f9346w.post(m0Var2.f9345v);
                            j5 = P;
                        }
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                }
                if (i10 == 1) {
                    i10 = 0;
                } else if (this.f9311d.P() != -1) {
                    this.f9314g.f2583a = this.f9311d.P();
                }
                com.bumptech.glide.d.i(this.f9310c);
            } catch (Throwable th) {
                if (i10 != 1 && this.f9311d.P() != -1) {
                    this.f9314g.f2583a = this.f9311d.P();
                }
                com.bumptech.glide.d.i(this.f9310c);
                throw th;
            }
        }
    }

    @Override // z1.m
    public final void b() {
        this.h = true;
    }

    public final i1.k c(long j5) {
        Map map = Collections.EMPTY_MAP;
        Map map2 = m0.U;
        Uri uri = this.f9309b;
        g1.a.m(uri, "The uri must be set.");
        return new i1.k(uri, 1, null, map2, j5, -1L, 6);
    }
}
