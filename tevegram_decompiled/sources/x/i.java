package x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends n {
    @Override // x.e
    public final void a(e eVar) {
        g gVar = this.h;
        if (gVar.f9997c && !gVar.f10003j) {
            gVar.d((int) ((((g) gVar.f10005l.get(0)).f10001g * ((w.h) this.f10013b).f9694d0) + 0.5f));
        }
    }

    @Override // x.n
    public final void d() {
        w.d dVar = this.f10013b;
        w.h hVar = (w.h) dVar;
        int i9 = hVar.f9695e0;
        int i10 = hVar.f9696f0;
        int i11 = hVar.f9698h0;
        g gVar = this.h;
        if (i11 == 1) {
            if (i9 != -1) {
                gVar.f10005l.add(dVar.I.f9621d.h);
                this.f10013b.I.f9621d.h.f10004k.add(gVar);
                gVar.f10000f = i9;
            } else if (i10 != -1) {
                gVar.f10005l.add(dVar.I.f9621d.f10019i);
                this.f10013b.I.f9621d.f10019i.f10004k.add(gVar);
                gVar.f10000f = -i10;
            } else {
                gVar.f9996b = true;
                gVar.f10005l.add(dVar.I.f9621d.f10019i);
                this.f10013b.I.f9621d.f10019i.f10004k.add(gVar);
            }
            m(this.f10013b.f9621d.h);
            m(this.f10013b.f9621d.f10019i);
            return;
        }
        if (i9 != -1) {
            gVar.f10005l.add(dVar.I.f9622e.h);
            this.f10013b.I.f9622e.h.f10004k.add(gVar);
            gVar.f10000f = i9;
        } else if (i10 != -1) {
            gVar.f10005l.add(dVar.I.f9622e.f10019i);
            this.f10013b.I.f9622e.f10019i.f10004k.add(gVar);
            gVar.f10000f = -i10;
        } else {
            gVar.f9996b = true;
            gVar.f10005l.add(dVar.I.f9622e.f10019i);
            this.f10013b.I.f9622e.f10019i.f10004k.add(gVar);
        }
        m(this.f10013b.f9622e.h);
        m(this.f10013b.f9622e.f10019i);
    }

    @Override // x.n
    public final void e() {
        w.d dVar = this.f10013b;
        int i9 = ((w.h) dVar).f9698h0;
        g gVar = this.h;
        if (i9 == 1) {
            dVar.N = gVar.f10001g;
        } else {
            dVar.O = gVar.f10001g;
        }
    }

    @Override // x.n
    public final void f() {
        this.h.c();
    }

    @Override // x.n
    public final boolean k() {
        return false;
    }

    public final void m(g gVar) {
        g gVar2 = this.h;
        gVar2.f10004k.add(gVar);
        gVar.f10005l.add(gVar2);
    }
}
