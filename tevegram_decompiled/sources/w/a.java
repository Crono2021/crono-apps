package w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends i {

    /* renamed from: f0, reason: collision with root package name */
    public int f9589f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f9590g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f9591h0;

    @Override // w.d
    public final void a(v.e eVar) {
        boolean z8;
        int i9;
        int i10;
        c[] cVarArr = this.F;
        c cVar = this.f9640x;
        cVarArr[0] = cVar;
        int i11 = 2;
        c cVar2 = this.f9641y;
        cVarArr[2] = cVar2;
        c cVar3 = this.f9642z;
        cVarArr[1] = cVar3;
        c cVar4 = this.A;
        cVarArr[3] = cVar4;
        for (c cVar5 : cVarArr) {
            cVar5.f9614g = eVar.j(cVar5);
        }
        int i12 = this.f9589f0;
        if (i12 < 0 || i12 >= 4) {
            return;
        }
        c cVar6 = cVarArr[i12];
        for (int i13 = 0; i13 < this.f9700e0; i13++) {
            d dVar = this.f9699d0[i13];
            if ((this.f9590g0 || dVar.b()) && ((((i10 = this.f9589f0) == 0 || i10 == 1) && dVar.f9620c0[0] == 3 && dVar.f9640x.f9611d != null && dVar.f9642z.f9611d != null) || ((i10 == 2 || i10 == 3) && dVar.f9620c0[1] == 3 && dVar.f9641y.f9611d != null && dVar.A.f9611d != null))) {
                z8 = true;
                break;
            }
        }
        z8 = false;
        boolean z9 = cVar.e() || cVar3.e();
        boolean z10 = cVar2.e() || cVar4.e();
        int i14 = !(!z8 && (((i9 = this.f9589f0) == 0 && z9) || ((i9 == 2 && z10) || ((i9 == 1 && z9) || (i9 == 3 && z10))))) ? 4 : 5;
        int i15 = 0;
        while (i15 < this.f9700e0) {
            d dVar2 = this.f9699d0[i15];
            if (this.f9590g0 || dVar2.b()) {
                v.i j5 = eVar.j(dVar2.F[this.f9589f0]);
                c[] cVarArr2 = dVar2.F;
                int i16 = this.f9589f0;
                c cVar7 = cVarArr2[i16];
                cVar7.f9614g = j5;
                c cVar8 = cVar7.f9611d;
                int i17 = (cVar8 == null || cVar8.f9609b != this) ? 0 : cVar7.f9612e;
                if (i16 == 0 || i16 == i11) {
                    v.i iVar = cVar6.f9614g;
                    int i18 = this.f9591h0 - i17;
                    v.c k3 = eVar.k();
                    v.i l4 = eVar.l();
                    l4.f9177d = 0;
                    k3.c(iVar, j5, l4, i18);
                    eVar.c(k3);
                } else {
                    v.i iVar2 = cVar6.f9614g;
                    int i19 = this.f9591h0 + i17;
                    v.c k9 = eVar.k();
                    v.i l9 = eVar.l();
                    l9.f9177d = 0;
                    k9.b(iVar2, j5, l9, i19);
                    eVar.c(k9);
                }
                eVar.e(cVar6.f9614g, j5, this.f9591h0 + i17, i14);
            }
            i15++;
            i11 = 2;
        }
        int i20 = this.f9589f0;
        if (i20 == 0) {
            eVar.e(cVar3.f9614g, cVar.f9614g, 0, 8);
            eVar.e(cVar.f9614g, this.I.f9642z.f9614g, 0, 4);
            eVar.e(cVar.f9614g, this.I.f9640x.f9614g, 0, 0);
            return;
        }
        if (i20 == 1) {
            eVar.e(cVar.f9614g, cVar3.f9614g, 0, 8);
            eVar.e(cVar.f9614g, this.I.f9640x.f9614g, 0, 4);
            eVar.e(cVar.f9614g, this.I.f9642z.f9614g, 0, 0);
        } else if (i20 == 2) {
            eVar.e(cVar4.f9614g, cVar2.f9614g, 0, 8);
            eVar.e(cVar2.f9614g, this.I.A.f9614g, 0, 4);
            eVar.e(cVar2.f9614g, this.I.f9641y.f9614g, 0, 0);
        } else if (i20 == 3) {
            eVar.e(cVar2.f9614g, cVar4.f9614g, 0, 8);
            eVar.e(cVar2.f9614g, this.I.f9641y.f9614g, 0, 4);
            eVar.e(cVar2.f9614g, this.I.A.f9614g, 0, 0);
        }
    }

    @Override // w.d
    public final boolean b() {
        return true;
    }

    @Override // w.d
    public final String toString() {
        String o8 = androidx.activity.g.o(new StringBuilder("[Barrier] "), this.W, " {");
        for (int i9 = 0; i9 < this.f9700e0; i9++) {
            d dVar = this.f9699d0[i9];
            if (i9 > 0) {
                o8 = o8.concat(", ");
            }
            o8 = o8 + dVar.W;
        }
        return o8.concat("}");
    }
}
