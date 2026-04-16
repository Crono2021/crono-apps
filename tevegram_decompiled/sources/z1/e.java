package z1;

import android.os.SystemClock;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f10548a;

    public /* synthetic */ e(f fVar) {
        this.f10548a = fVar;
    }

    public final void a(int i9) {
        f fVar = this.f10548a;
        synchronized (fVar) {
            int i10 = fVar.f10567m;
            if (i10 == 0 || fVar.f10559d) {
                if (i10 == i9) {
                    return;
                }
                fVar.f10567m = i9;
                if (i9 != 1 && i9 != 0 && i9 != 8) {
                    fVar.f10565k = fVar.a(i9);
                    fVar.f10558c.getClass();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    fVar.b(fVar.f10561f > 0 ? (int) (elapsedRealtime - fVar.f10562g) : 0, fVar.h, fVar.f10565k);
                    fVar.f10562g = elapsedRealtime;
                    fVar.h = 0L;
                    fVar.f10564j = 0L;
                    fVar.f10563i = 0L;
                    t tVar = fVar.f10560e;
                    tVar.f10601b.clear();
                    tVar.f10603d = -1;
                    tVar.f10604e = 0;
                    tVar.f10605f = 0;
                }
            }
        }
    }
}
