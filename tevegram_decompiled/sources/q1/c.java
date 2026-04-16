package q1;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import d1.l0;
import d1.s;
import g1.w;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import z1.r;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements z1.k {

    /* renamed from: w, reason: collision with root package name */
    public static final m7.c f8319w = new m7.c(17);

    /* renamed from: i, reason: collision with root package name */
    public final p1.c f8320i;

    /* renamed from: j, reason: collision with root package name */
    public final p f8321j;

    /* renamed from: k, reason: collision with root package name */
    public final z1.g f8322k;

    /* renamed from: n, reason: collision with root package name */
    public o1.d f8325n;

    /* renamed from: o, reason: collision with root package name */
    public z1.p f8326o;

    /* renamed from: p, reason: collision with root package name */
    public Handler f8327p;

    /* renamed from: q, reason: collision with root package name */
    public p1.m f8328q;

    /* renamed from: r, reason: collision with root package name */
    public l f8329r;

    /* renamed from: s, reason: collision with root package name */
    public Uri f8330s;

    /* renamed from: t, reason: collision with root package name */
    public i f8331t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8332u;

    /* renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArrayList f8324m = new CopyOnWriteArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f8323l = new HashMap();

    /* renamed from: v, reason: collision with root package name */
    public long f8333v = -9223372036854775807L;

    public c(p1.c cVar, z1.g gVar, p pVar) {
        this.f8320i = cVar;
        this.f8321j = pVar;
        this.f8322k = gVar;
    }

    public final i a(Uri uri, boolean z8) {
        HashMap hashMap = this.f8323l;
        i iVar = ((b) hashMap.get(uri)).f8311l;
        if (iVar != null && z8 && !uri.equals(this.f8330s)) {
            List list = this.f8329r.f8386e;
            int i9 = 0;
            while (true) {
                if (i9 >= list.size()) {
                    break;
                }
                if (uri.equals(((k) list.get(i9)).f8378a)) {
                    i iVar2 = this.f8331t;
                    if (iVar2 == null || !iVar2.f8367o) {
                        this.f8330s = uri;
                        b bVar = (b) hashMap.get(uri);
                        i iVar3 = bVar.f8311l;
                        if (iVar3 == null || !iVar3.f8367o) {
                            bVar.c(b(uri));
                            return iVar;
                        }
                        this.f8331t = iVar3;
                        this.f8328q.t(iVar3);
                        return iVar;
                    }
                } else {
                    i9++;
                }
            }
        }
        return iVar;
    }

    public final Uri b(Uri uri) {
        e eVar;
        i iVar = this.f8331t;
        if (iVar == null || !iVar.f8374v.f8356e || (eVar = (e) iVar.f8372t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(eVar.f8337b));
        int i9 = eVar.f8338c;
        if (i9 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i9));
        }
        return buildUpon.build();
    }

    public final boolean c(Uri uri) {
        int i9;
        b bVar = (b) this.f8323l.get(uri);
        if (bVar.f8311l == null) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long max = Math.max(30000L, w.W(bVar.f8311l.f8373u));
        i iVar = bVar.f8311l;
        return iVar.f8367o || (i9 = iVar.f8357d) == 2 || i9 == 1 || bVar.f8312m + max > elapsedRealtime;
    }

    @Override // z1.k
    public final void e(z1.m mVar, long j5, long j9) {
        l lVar;
        r rVar = (r) mVar;
        m mVar2 = (m) rVar.f10595f;
        boolean z8 = mVar2 instanceof i;
        if (z8) {
            String str = mVar2.f8392a;
            l lVar2 = l.f8384l;
            Uri parse = Uri.parse(str);
            d1.r rVar2 = new d1.r();
            rVar2.f2518a = "0";
            rVar2.f2527k = l0.k("application/x-mpegURL");
            List singletonList = Collections.singletonList(new k(parse, new s(rVar2), null, null, null, null));
            List list = Collections.EMPTY_LIST;
            lVar = new l("", list, singletonList, list, list, list, list, null, null, false, Collections.EMPTY_MAP, list);
        } else {
            lVar = (l) mVar2;
        }
        this.f8329r = lVar;
        this.f8330s = ((k) lVar.f8386e.get(0)).f8378a;
        this.f8324m.add(new a(this));
        List list2 = lVar.f8385d;
        int size = list2.size();
        for (int i9 = 0; i9 < size; i9++) {
            Uri uri = (Uri) list2.get(i9);
            this.f8323l.put(uri, new b(this, uri));
        }
        Uri uri2 = rVar.f10593d.f4289k;
        v1.q qVar = new v1.q(j9);
        b bVar = (b) this.f8323l.get(this.f8330s);
        if (z8) {
            bVar.d((i) mVar2, qVar);
        } else {
            bVar.c(bVar.f8308i);
        }
        this.f8322k.onLoadTaskConcluded(rVar.f10590a);
        this.f8325n.d(qVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // z1.k
    public final j3.f p(z1.m mVar, long j5, long j9, IOException iOException, int i9) {
        r rVar = (r) mVar;
        long j10 = rVar.f10590a;
        Uri uri = rVar.f10593d.f4289k;
        v1.q qVar = new v1.q(j9);
        int i10 = rVar.f10592c;
        z1.j jVar = new z1.j(iOException, i9);
        z1.g gVar = this.f8322k;
        long retryDelayMsFor = gVar.getRetryDelayMsFor(jVar);
        boolean z8 = retryDelayMsFor == -9223372036854775807L;
        this.f8325n.f(qVar, i10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z8);
        if (z8) {
            gVar.onLoadTaskConcluded(rVar.f10590a);
        }
        return z8 ? z1.p.f10586f : new j3.f(0, retryDelayMsFor);
    }

    @Override // z1.k
    public final void q(z1.m mVar, long j5, long j9, boolean z8) {
        r rVar = (r) mVar;
        long j10 = rVar.f10590a;
        Uri uri = rVar.f10593d.f4289k;
        v1.q qVar = new v1.q(j9);
        this.f8322k.onLoadTaskConcluded(j10);
        this.f8325n.b(qVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
