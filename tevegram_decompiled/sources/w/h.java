package w;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends d {

    /* renamed from: d0, reason: collision with root package name */
    public float f9694d0 = -1.0f;

    /* renamed from: e0, reason: collision with root package name */
    public int f9695e0 = -1;

    /* renamed from: f0, reason: collision with root package name */
    public int f9696f0 = -1;

    /* renamed from: g0, reason: collision with root package name */
    public c f9697g0 = this.f9641y;

    /* renamed from: h0, reason: collision with root package name */
    public int f9698h0 = 0;

    public h() {
        this.G.clear();
        this.G.add(this.f9697g0);
        int length = this.F.length;
        for (int i9 = 0; i9 < length; i9++) {
            this.F[i9] = this.f9697g0;
        }
    }

    @Override // w.d
    public final void A(v.e eVar) {
        if (this.I == null) {
            return;
        }
        c cVar = this.f9697g0;
        eVar.getClass();
        int m9 = v.e.m(cVar);
        if (this.f9698h0 == 1) {
            this.N = m9;
            this.O = 0;
            v(this.I.i());
            y(0);
            return;
        }
        this.N = 0;
        this.O = m9;
        y(this.I.l());
        v(0);
    }

    public final void B(int i9) {
        if (this.f9698h0 == i9) {
            return;
        }
        this.f9698h0 = i9;
        ArrayList arrayList = this.G;
        arrayList.clear();
        if (this.f9698h0 == 1) {
            this.f9697g0 = this.f9640x;
        } else {
            this.f9697g0 = this.f9641y;
        }
        arrayList.add(this.f9697g0);
        c[] cVarArr = this.F;
        int length = cVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            cVarArr[i10] = this.f9697g0;
        }
    }

    @Override // w.d
    public final void a(v.e eVar) {
        e eVar2 = (e) this.I;
        if (eVar2 == null) {
            return;
        }
        c g9 = eVar2.g(2);
        c g10 = eVar2.g(4);
        d dVar = this.I;
        boolean z8 = dVar != null && dVar.f9620c0[0] == 2;
        if (this.f9698h0 == 0) {
            g9 = eVar2.g(3);
            g10 = eVar2.g(5);
            d dVar2 = this.I;
            z8 = dVar2 != null && dVar2.f9620c0[1] == 2;
        }
        if (this.f9695e0 != -1) {
            v.i j5 = eVar.j(this.f9697g0);
            eVar.e(j5, eVar.j(g9), this.f9695e0, 8);
            if (z8) {
                eVar.f(eVar.j(g10), j5, 0, 5);
                return;
            }
            return;
        }
        if (this.f9696f0 != -1) {
            v.i j9 = eVar.j(this.f9697g0);
            v.i j10 = eVar.j(g10);
            eVar.e(j9, j10, -this.f9696f0, 8);
            if (z8) {
                eVar.f(j9, eVar.j(g9), 0, 5);
                eVar.f(j10, j9, 0, 5);
                return;
            }
            return;
        }
        if (this.f9694d0 != -1.0f) {
            v.i j11 = eVar.j(this.f9697g0);
            v.i j12 = eVar.j(g10);
            float f9 = this.f9694d0;
            v.c k3 = eVar.k();
            k3.f9152d.c(j11, -1.0f);
            k3.f9152d.c(j12, f9);
            eVar.c(k3);
        }
    }

    @Override // w.d
    public final boolean b() {
        return true;
    }

    @Override // w.d
    public final c g(int i9) {
        switch (v.h.a(i9)) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.f9698h0 == 1) {
                    return this.f9697g0;
                }
                break;
            case 2:
            case 4:
                if (this.f9698h0 == 0) {
                    return this.f9697g0;
                }
                break;
        }
        m7.c.e(t.a.e(i9));
        return null;
    }
}
