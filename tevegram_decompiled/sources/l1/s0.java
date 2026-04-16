package l1;

import android.util.Pair;
import java.io.IOException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class s0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6013i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ v1.q f6014j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ v1.v f6015k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ IOException f6016l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f6017m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f6018n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f6019o;

    public /* synthetic */ s0(Object obj, Object obj2, v1.q qVar, v1.v vVar, IOException iOException, boolean z8, int i9) {
        this.f6013i = i9;
        this.f6018n = obj;
        this.f6019o = obj2;
        this.f6014j = qVar;
        this.f6015k = vVar;
        this.f6016l = iOException;
        this.f6017m = z8;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, v1.d0] */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6013i) {
            case 0:
                a5.d dVar = (a5.d) this.f6018n;
                Pair pair = (Pair) this.f6019o;
                ((m1.q) ((v0) dVar.f175k).f6039i).T(((Integer) pair.first).intValue(), (v1.z) pair.second, this.f6014j, this.f6015k, this.f6016l, this.f6017m);
                break;
            default:
                o1.d dVar2 = (o1.d) this.f6018n;
                this.f6019o.T(dVar2.f7569a, dVar2.f7570b, this.f6014j, this.f6015k, this.f6016l, this.f6017m);
                break;
        }
    }
}
