package b2;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m implements Handler.Callback {

    /* renamed from: i, reason: collision with root package name */
    public final Handler f1216i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ n f1217j;

    public m(n nVar, s1.k kVar) {
        this.f1217j = nVar;
        Handler l4 = g1.w.l(this);
        this.f1216i = l4;
        kVar.h(this, l4);
    }

    public final void a(long j5) {
        Surface surface;
        n nVar = this.f1217j;
        if (this != nVar.f1236p1 || nVar.S == null) {
            return;
        }
        if (j5 == Long.MAX_VALUE) {
            nVar.G0 = true;
            return;
        }
        try {
            nVar.t0(j5);
            nVar.z0(nVar.f1230j1);
            nVar.I0.f5859e++;
            v vVar = nVar.S0;
            boolean z8 = vVar.f1265e != 3;
            vVar.f1265e = 3;
            vVar.f1270k.getClass();
            vVar.f1267g = g1.w.M(SystemClock.elapsedRealtime());
            if (z8 && (surface = nVar.X0) != null) {
                a5.d dVar = nVar.P0;
                Handler handler = (Handler) dVar.f174j;
                if (handler != null) {
                    handler.post(new h0(dVar, surface, SystemClock.elapsedRealtime()));
                }
                nVar.f1221a1 = true;
            }
            nVar.b0(j5);
        } catch (l1.l e9) {
            nVar.H0 = e9;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        int i9 = message.arg1;
        int i10 = message.arg2;
        int i11 = g1.w.f3713a;
        a(((i9 & 4294967295L) << 32) | (4294967295L & i10));
        return true;
    }
}
