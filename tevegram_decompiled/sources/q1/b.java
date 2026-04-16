package q1;

import android.net.Uri;
import android.os.SystemClock;
import b2.f0;
import d1.m0;
import i1.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import z1.r;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements z1.k {

    /* renamed from: i, reason: collision with root package name */
    public final Uri f8308i;

    /* renamed from: j, reason: collision with root package name */
    public final z1.p f8309j = new z1.p("DefaultHlsPlaylistTracker:MediaPlaylist");

    /* renamed from: k, reason: collision with root package name */
    public final i1.h f8310k;

    /* renamed from: l, reason: collision with root package name */
    public i f8311l;

    /* renamed from: m, reason: collision with root package name */
    public long f8312m;

    /* renamed from: n, reason: collision with root package name */
    public long f8313n;

    /* renamed from: o, reason: collision with root package name */
    public long f8314o;

    /* renamed from: p, reason: collision with root package name */
    public long f8315p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8316q;

    /* renamed from: r, reason: collision with root package name */
    public IOException f8317r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ c f8318s;

    public b(c cVar, Uri uri) {
        this.f8318s = cVar;
        this.f8308i = uri;
        this.f8310k = ((i1.g) cVar.f8320i.f8103i).a();
    }

    public static boolean a(b bVar, long j5) {
        bVar.f8315p = SystemClock.elapsedRealtime() + j5;
        Uri uri = bVar.f8308i;
        c cVar = bVar.f8318s;
        if (!uri.equals(cVar.f8330s)) {
            return false;
        }
        List list = cVar.f8329r.f8386e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i9 = 0; i9 < size; i9++) {
            b bVar2 = (b) cVar.f8323l.get(((k) list.get(i9)).f8378a);
            bVar2.getClass();
            if (elapsedRealtime > bVar2.f8315p) {
                Uri uri2 = bVar2.f8308i;
                cVar.f8330s = uri2;
                bVar2.c(cVar.b(uri2));
                return false;
            }
        }
        return true;
    }

    public final void b(Uri uri) {
        c cVar = this.f8318s;
        r rVar = new r(this.f8310k, uri, cVar.f8321j.d(cVar.f8329r, this.f8311l));
        z1.g gVar = cVar.f8322k;
        int i9 = rVar.f10592c;
        this.f8309j.d(rVar, this, gVar.getMinimumLoadableRetryCount(i9));
        cVar.f8325n.h(new v1.q(rVar.f10591b), i9, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void c(Uri uri) {
        this.f8315p = 0L;
        if (this.f8316q) {
            return;
        }
        z1.p pVar = this.f8309j;
        if (pVar.b() || pVar.f10589c != null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = this.f8314o;
        if (elapsedRealtime >= j5) {
            b(uri);
        } else {
            this.f8316q = true;
            this.f8318s.f8327p.postDelayed(new f0(this, 16, uri), j5 - elapsedRealtime);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(q1.i r71, v1.q r72) {
        /*
            Method dump skipped, instructions count: 747
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.b.d(q1.i, v1.q):void");
    }

    @Override // z1.k
    public final void e(z1.m mVar, long j5, long j9) {
        r rVar = (r) mVar;
        m mVar2 = (m) rVar.f10595f;
        Uri uri = rVar.f10593d.f4289k;
        v1.q qVar = new v1.q(j9);
        if (mVar2 instanceof i) {
            d((i) mVar2, qVar);
            this.f8318s.f8325n.d(qVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        } else {
            m0 b9 = m0.b("Loaded playlist has unexpected type.");
            this.f8317r = b9;
            this.f8318s.f8325n.f(qVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, b9, true);
        }
        this.f8318s.f8322k.onLoadTaskConcluded(rVar.f10590a);
    }

    @Override // z1.k
    public final j3.f p(z1.m mVar, long j5, long j9, IOException iOException, int i9) {
        r rVar = (r) mVar;
        long j10 = rVar.f10590a;
        int i10 = rVar.f10592c;
        Uri uri = rVar.f10593d.f4289k;
        v1.q qVar = new v1.q(j9);
        boolean z8 = uri.getQueryParameter("_HLS_msn") != null;
        boolean z9 = iOException instanceof n;
        j3.f fVar = z1.p.f10585e;
        Uri uri2 = this.f8308i;
        c cVar = this.f8318s;
        if (z8 || z9) {
            int i11 = iOException instanceof w ? ((w) iOException).f4364k : Integer.MAX_VALUE;
            if (z9 || i11 == 400 || i11 == 503) {
                this.f8314o = SystemClock.elapsedRealtime();
                c(uri2);
                o1.d dVar = cVar.f8325n;
                int i12 = g1.w.f3713a;
                dVar.f(qVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, true);
                return fVar;
            }
        }
        z1.j jVar = new z1.j(iOException, i9);
        Iterator it = cVar.f8324m.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= !((q) it.next()).d(uri2, jVar, false);
        }
        z1.g gVar = cVar.f8322k;
        if (z10) {
            long retryDelayMsFor = gVar.getRetryDelayMsFor(jVar);
            fVar = retryDelayMsFor != -9223372036854775807L ? new j3.f(0, retryDelayMsFor) : z1.p.f10586f;
        }
        int i13 = fVar.f5420a;
        boolean z11 = i13 == 0 || i13 == 1;
        j3.f fVar2 = fVar;
        cVar.f8325n.f(qVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, !z11);
        if (!z11) {
            gVar.onLoadTaskConcluded(rVar.f10590a);
        }
        return fVar2;
    }

    @Override // z1.k
    public final void q(z1.m mVar, long j5, long j9, boolean z8) {
        r rVar = (r) mVar;
        long j10 = rVar.f10590a;
        Uri uri = rVar.f10593d.f4289k;
        v1.q qVar = new v1.q(j9);
        c cVar = this.f8318s;
        cVar.f8322k.onLoadTaskConcluded(j10);
        cVar.f8325n.b(qVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
