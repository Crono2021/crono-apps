package q1;

import android.net.Uri;
import android.os.SystemClock;
import g1.w;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements q {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c f8307i;

    public a(c cVar) {
        this.f8307i = cVar;
    }

    @Override // q1.q
    public final void c() {
        this.f8307i.f8324m.remove(this);
    }

    @Override // q1.q
    public final boolean d(Uri uri, z1.j jVar, boolean z8) {
        b bVar;
        c cVar = this.f8307i;
        HashMap hashMap = cVar.f8323l;
        if (cVar.f8331t == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            l lVar = cVar.f8329r;
            int i9 = w.f3713a;
            List list = lVar.f8386e;
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                b bVar2 = (b) hashMap.get(((k) list.get(i11)).f8378a);
                if (bVar2 != null && elapsedRealtime < bVar2.f8315p) {
                    i10++;
                }
            }
            z1.i fallbackSelectionFor = cVar.f8322k.getFallbackSelectionFor(new z1.h(cVar.f8329r.f8386e.size(), i10), jVar);
            if (fallbackSelectionFor != null && fallbackSelectionFor.f10570a == 2 && (bVar = (b) hashMap.get(uri)) != null) {
                b.a(bVar, fallbackSelectionFor.f10571b);
            }
        }
        return false;
    }
}
