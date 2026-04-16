package r7;

import a8.p;
import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements g, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final g f8612i;

    /* renamed from: j, reason: collision with root package name */
    public final e f8613j;

    public b(g gVar, e eVar) {
        gVar.getClass();
        eVar.getClass();
        this.f8612i = gVar;
        this.f8613j = eVar;
    }

    @Override // r7.g
    public final g a(g gVar) {
        gVar.getClass();
        return gVar == h.f8615i ? this : (g) gVar.d(this, new i7.a(2));
    }

    @Override // r7.g
    public final Object d(Object obj, p pVar) {
        return pVar.h(this.f8612i.d(obj, pVar), this.f8613j);
    }

    @Override // r7.g
    public final g e(f fVar) {
        fVar.getClass();
        e eVar = this.f8613j;
        e h = eVar.h(fVar);
        g gVar = this.f8612i;
        if (h != null) {
            return gVar;
        }
        g e9 = gVar.e(fVar);
        return e9 == gVar ? this : e9 == h.f8615i ? eVar : new b(e9, eVar);
    }

    public final boolean equals(Object obj) {
        boolean z8;
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            int i9 = 2;
            b bVar2 = bVar;
            int i10 = 2;
            while (true) {
                g gVar = bVar2.f8612i;
                bVar2 = gVar instanceof b ? (b) gVar : null;
                if (bVar2 == null) {
                    break;
                }
                i10++;
            }
            b bVar3 = this;
            while (true) {
                g gVar2 = bVar3.f8612i;
                bVar3 = gVar2 instanceof b ? (b) gVar2 : null;
                if (bVar3 == null) {
                    break;
                }
                i9++;
            }
            if (i10 == i9) {
                b bVar4 = this;
                while (true) {
                    e eVar = bVar4.f8613j;
                    if (!b8.i.a(bVar.h(eVar.getKey()), eVar)) {
                        z8 = false;
                        break;
                    }
                    g gVar3 = bVar4.f8612i;
                    if (!(gVar3 instanceof b)) {
                        gVar3.getClass();
                        e eVar2 = (e) gVar3;
                        z8 = b8.i.a(bVar.h(eVar2.getKey()), eVar2);
                        break;
                    }
                    bVar4 = (b) gVar3;
                }
                if (z8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // r7.g
    public final e h(f fVar) {
        fVar.getClass();
        b bVar = this;
        while (true) {
            e h = bVar.f8613j.h(fVar);
            if (h != null) {
                return h;
            }
            g gVar = bVar.f8612i;
            if (!(gVar instanceof b)) {
                return gVar.h(fVar);
            }
            bVar = (b) gVar;
        }
    }

    public final int hashCode() {
        return this.f8613j.hashCode() + this.f8612i.hashCode();
    }

    public final String toString() {
        return "[" + ((String) d("", new i7.a(1))) + ']';
    }
}
