package t7;

import b8.p;
import b8.q;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g extends a implements b8.g {

    /* renamed from: j, reason: collision with root package name */
    public final int f8987j;

    public g(r7.c cVar) {
        super(cVar);
        if (cVar == null || cVar.f() == r7.h.f8615i) {
            this.f8987j = 2;
        } else {
            m7.c.n("Coroutines with restricted suspension must have EmptyCoroutineContext");
            throw null;
        }
    }

    @Override // b8.g
    public final int e() {
        return this.f8987j;
    }

    @Override // r7.c
    public final r7.g f() {
        return r7.h.f8615i;
    }

    @Override // t7.a
    public final String toString() {
        if (this.f8981i != null) {
            return super.toString();
        }
        p.f1526a.getClass();
        return q.a(this);
    }
}
