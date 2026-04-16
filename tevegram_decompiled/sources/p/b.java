package p;

import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends e implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public c f8079i;

    /* renamed from: j, reason: collision with root package name */
    public c f8080j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f8081k;

    public b(c cVar, c cVar2, int i9) {
        this.f8081k = i9;
        this.f8079i = cVar2;
        this.f8080j = cVar;
    }

    @Override // p.e
    public final void a(c cVar) {
        c cVar2;
        c cVar3 = null;
        if (this.f8079i == cVar && cVar == this.f8080j) {
            this.f8080j = null;
            this.f8079i = null;
        }
        c cVar4 = this.f8079i;
        if (cVar4 == cVar) {
            switch (this.f8081k) {
                case 0:
                    cVar2 = cVar4.f8085l;
                    break;
                default:
                    cVar2 = cVar4.f8084k;
                    break;
            }
            this.f8079i = cVar2;
        }
        c cVar5 = this.f8080j;
        if (cVar5 == cVar) {
            c cVar6 = this.f8079i;
            if (cVar5 != cVar6 && cVar6 != null) {
                cVar3 = b(cVar5);
            }
            this.f8080j = cVar3;
        }
    }

    public final c b(c cVar) {
        switch (this.f8081k) {
            case 0:
                return cVar.f8084k;
            default:
                return cVar.f8085l;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8080j != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f8080j;
        c cVar2 = this.f8079i;
        this.f8080j = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
        return cVar;
    }
}
