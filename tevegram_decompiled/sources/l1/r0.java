package l1;

import android.util.Pair;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6006i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a5.d f6007j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Pair f6008k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ v1.q f6009l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v1.v f6010m;

    public /* synthetic */ r0(a5.d dVar, Pair pair, v1.q qVar, v1.v vVar, int i9) {
        this.f6006i = i9;
        this.f6007j = dVar;
        this.f6008k = pair;
        this.f6009l = qVar;
        this.f6010m = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6006i) {
            case 0:
                m1.q qVar = (m1.q) ((v0) this.f6007j.f175k).f6039i;
                Pair pair = this.f6008k;
                qVar.y(((Integer) pair.first).intValue(), (v1.z) pair.second, this.f6009l, this.f6010m);
                break;
            case 1:
                m1.q qVar2 = (m1.q) ((v0) this.f6007j.f175k).f6039i;
                Pair pair2 = this.f6008k;
                qVar2.Q(((Integer) pair2.first).intValue(), (v1.z) pair2.second, this.f6009l, this.f6010m);
                break;
            default:
                m1.q qVar3 = (m1.q) ((v0) this.f6007j.f175k).f6039i;
                Pair pair3 = this.f6008k;
                qVar3.V(((Integer) pair3.first).intValue(), (v1.z) pair3.second, this.f6009l, this.f6010m);
                break;
        }
    }
}
