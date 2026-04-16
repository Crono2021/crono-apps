package g1;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3674i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3675j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f3676k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f3677l;

    public /* synthetic */ i(int i9, int i10, Object obj, Object obj2) {
        this.f3674i = i10;
        this.f3676k = obj;
        this.f3675j = i9;
        this.f3677l = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3674i) {
            case 0:
                CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.f3676k;
                j jVar = (j) this.f3677l;
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    if (!lVar.f3681d) {
                        int i9 = this.f3675j;
                        if (i9 != -1) {
                            lVar.f3679b.a(i9);
                        }
                        lVar.f3680c = true;
                        jVar.a(lVar.f3678a);
                    }
                }
                break;
            default:
                m3.a aVar = (m3.a) this.f3676k;
                aVar.f6607b.p(this.f3675j, this.f3677l);
                break;
        }
    }
}
