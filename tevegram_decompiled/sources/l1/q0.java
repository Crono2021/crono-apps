package l1;

import android.util.Pair;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class q0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6000i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a5.d f6001j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Pair f6002k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ v1.v f6003l;

    public /* synthetic */ q0(a5.d dVar, Pair pair, v1.v vVar, int i9) {
        this.f6000i = i9;
        this.f6001j = dVar;
        this.f6002k = pair;
        this.f6003l = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6000i) {
            case 0:
                m1.q qVar = (m1.q) ((v0) this.f6001j.f175k).f6039i;
                Pair pair = this.f6002k;
                int intValue = ((Integer) pair.first).intValue();
                v1.z zVar = (v1.z) pair.second;
                zVar.getClass();
                qVar.o(intValue, zVar, this.f6003l);
                break;
            default:
                m1.q qVar2 = (m1.q) ((v0) this.f6001j.f175k).f6039i;
                Pair pair2 = this.f6002k;
                qVar2.m(((Integer) pair2.first).intValue(), (v1.z) pair2.second, this.f6003l);
                break;
        }
    }
}
