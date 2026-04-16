package x;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends n {
    @Override // x.e
    public final void a(e eVar) {
        w.a aVar = (w.a) this.f10013b;
        int i9 = aVar.f9589f0;
        g gVar = this.h;
        ArrayList arrayList = gVar.f10005l;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            int i13 = ((g) obj).f10001g;
            if (i12 == -1 || i13 < i12) {
                i12 = i13;
            }
            if (i10 < i13) {
                i10 = i13;
            }
        }
        if (i9 == 0 || i9 == 2) {
            gVar.d(i12 + aVar.f9591h0);
        } else {
            gVar.d(i10 + aVar.f9591h0);
        }
    }

    @Override // x.n
    public final void d() {
        w.d dVar = this.f10013b;
        if (dVar instanceof w.a) {
            g gVar = this.h;
            gVar.f9996b = true;
            ArrayList arrayList = gVar.f10005l;
            w.a aVar = (w.a) dVar;
            int i9 = aVar.f9589f0;
            boolean z8 = aVar.f9590g0;
            int i10 = 0;
            if (i9 == 0) {
                gVar.f9999e = 4;
                while (i10 < aVar.f9700e0) {
                    w.d dVar2 = aVar.f9699d0[i10];
                    if (z8 || dVar2.V != 8) {
                        g gVar2 = dVar2.f9621d.h;
                        gVar2.f10004k.add(gVar);
                        arrayList.add(gVar2);
                    }
                    i10++;
                }
                m(this.f10013b.f9621d.h);
                m(this.f10013b.f9621d.f10019i);
                return;
            }
            if (i9 == 1) {
                gVar.f9999e = 5;
                while (i10 < aVar.f9700e0) {
                    w.d dVar3 = aVar.f9699d0[i10];
                    if (z8 || dVar3.V != 8) {
                        g gVar3 = dVar3.f9621d.f10019i;
                        gVar3.f10004k.add(gVar);
                        arrayList.add(gVar3);
                    }
                    i10++;
                }
                m(this.f10013b.f9621d.h);
                m(this.f10013b.f9621d.f10019i);
                return;
            }
            if (i9 == 2) {
                gVar.f9999e = 6;
                while (i10 < aVar.f9700e0) {
                    w.d dVar4 = aVar.f9699d0[i10];
                    if (z8 || dVar4.V != 8) {
                        g gVar4 = dVar4.f9622e.h;
                        gVar4.f10004k.add(gVar);
                        arrayList.add(gVar4);
                    }
                    i10++;
                }
                m(this.f10013b.f9622e.h);
                m(this.f10013b.f9622e.f10019i);
                return;
            }
            if (i9 != 3) {
                return;
            }
            gVar.f9999e = 7;
            while (i10 < aVar.f9700e0) {
                w.d dVar5 = aVar.f9699d0[i10];
                if (z8 || dVar5.V != 8) {
                    g gVar5 = dVar5.f9622e.f10019i;
                    gVar5.f10004k.add(gVar);
                    arrayList.add(gVar5);
                }
                i10++;
            }
            m(this.f10013b.f9622e.h);
            m(this.f10013b.f9622e.f10019i);
        }
    }

    @Override // x.n
    public final void e() {
        w.d dVar = this.f10013b;
        if (dVar instanceof w.a) {
            int i9 = ((w.a) dVar).f9589f0;
            g gVar = this.h;
            if (i9 == 0 || i9 == 1) {
                dVar.N = gVar.f10001g;
            } else {
                dVar.O = gVar.f10001g;
            }
        }
    }

    @Override // x.n
    public final void f() {
        this.f10014c = null;
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
