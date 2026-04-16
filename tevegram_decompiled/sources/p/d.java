package p;

import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends e implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public c f8086i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8087j = true;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f f8088k;

    public d(f fVar) {
        this.f8088k = fVar;
    }

    @Override // p.e
    public final void a(c cVar) {
        c cVar2 = this.f8086i;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f8085l;
            this.f8086i = cVar3;
            this.f8087j = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8087j) {
            return this.f8088k.f8089i != null;
        }
        c cVar = this.f8086i;
        return (cVar == null || cVar.f8084k == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f8087j) {
            this.f8087j = false;
            this.f8086i = this.f8088k.f8089i;
        } else {
            c cVar = this.f8086i;
            this.f8086i = cVar != null ? cVar.f8084k : null;
        }
        return this.f8086i;
    }
}
