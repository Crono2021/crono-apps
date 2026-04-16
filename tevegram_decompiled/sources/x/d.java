package x;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends n {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f9986k;

    /* renamed from: l, reason: collision with root package name */
    public int f9987l;

    public d(w.d dVar, int i9) {
        super(dVar);
        w.d dVar2;
        ArrayList arrayList = new ArrayList();
        this.f9986k = arrayList;
        this.f10017f = i9;
        w.d dVar3 = this.f10013b;
        w.d k3 = dVar3.k(i9);
        while (true) {
            dVar2 = dVar3;
            dVar3 = k3;
            if (dVar3 == null) {
                break;
            } else {
                k3 = dVar3.k(this.f10017f);
            }
        }
        this.f10013b = dVar2;
        int i10 = this.f10017f;
        arrayList.add(i10 == 0 ? dVar2.f9621d : i10 == 1 ? dVar2.f9622e : null);
        w.d j5 = dVar2.j(this.f10017f);
        while (j5 != null) {
            int i11 = this.f10017f;
            arrayList.add(i11 == 0 ? j5.f9621d : i11 == 1 ? j5.f9622e : null);
            j5 = j5.j(this.f10017f);
        }
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            n nVar = (n) obj;
            int i13 = this.f10017f;
            if (i13 == 0) {
                nVar.f10013b.f9617b = this;
            } else if (i13 == 1) {
                nVar.f10013b.f9619c = this;
            }
        }
        if (this.f10017f == 0 && ((w.e) this.f10013b.I).f9647h0 && arrayList.size() > 1) {
            this.f10013b = ((n) arrayList.get(arrayList.size() - 1)).f10013b;
        }
        int i14 = this.f10017f;
        w.d dVar4 = this.f10013b;
        this.f9987l = i14 == 0 ? dVar4.X : dVar4.Y;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x019a, code lost:
    
        if (r1 != r10) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01bf, code lost:
    
        r3.d(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01bc, code lost:
    
        r14 = r14 + 1;
        r10 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01ba, code lost:
    
        if (r1 != r10) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x03b0, code lost:
    
        r2 = r2 - r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00df  */
    @Override // x.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(x.e r28) {
        /*
            Method dump skipped, instructions count: 975
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.d.a(x.e):void");
    }

    @Override // x.n
    public final void d() {
        ArrayList arrayList = this.f9986k;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            ((n) obj).d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        w.d dVar = ((n) arrayList.get(0)).f10013b;
        w.d dVar2 = ((n) arrayList.get(size2 - 1)).f10013b;
        int i10 = this.f10017f;
        g gVar = this.f10019i;
        g gVar2 = this.h;
        if (i10 == 0) {
            w.c cVar = dVar.f9640x;
            w.c cVar2 = dVar2.f9642z;
            g i11 = n.i(cVar, 0);
            int c9 = cVar.c();
            w.d m9 = m();
            if (m9 != null) {
                c9 = m9.f9640x.c();
            }
            if (i11 != null) {
                n.b(gVar2, i11, c9);
            }
            g i12 = n.i(cVar2, 0);
            int c10 = cVar2.c();
            w.d n4 = n();
            if (n4 != null) {
                c10 = n4.f9642z.c();
            }
            if (i12 != null) {
                n.b(gVar, i12, -c10);
            }
        } else {
            w.c cVar3 = dVar.f9641y;
            w.c cVar4 = dVar2.A;
            g i13 = n.i(cVar3, 1);
            int c11 = cVar3.c();
            w.d m10 = m();
            if (m10 != null) {
                c11 = m10.f9641y.c();
            }
            if (i13 != null) {
                n.b(gVar2, i13, c11);
            }
            g i14 = n.i(cVar4, 1);
            int c12 = cVar4.c();
            w.d n9 = n();
            if (n9 != null) {
                c12 = n9.A.c();
            }
            if (i14 != null) {
                n.b(gVar, i14, -c12);
            }
        }
        gVar2.f9995a = this;
        gVar.f9995a = this;
    }

    @Override // x.n
    public final void e() {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f9986k;
            if (i9 >= arrayList.size()) {
                return;
            }
            ((n) arrayList.get(i9)).e();
            i9++;
        }
    }

    @Override // x.n
    public final void f() {
        this.f10014c = null;
        ArrayList arrayList = this.f9986k;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            ((n) obj).f();
        }
    }

    @Override // x.n
    public final long j() {
        ArrayList arrayList = this.f9986k;
        int size = arrayList.size();
        long j5 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            j5 = r5.f10019i.f10000f + ((n) arrayList.get(i9)).j() + j5 + r5.h.f10000f;
        }
        return j5;
    }

    @Override // x.n
    public final boolean k() {
        ArrayList arrayList = this.f9986k;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            if (!((n) arrayList.get(i9)).k()) {
                return false;
            }
        }
        return true;
    }

    public final w.d m() {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f9986k;
            if (i9 >= arrayList.size()) {
                return null;
            }
            w.d dVar = ((n) arrayList.get(i9)).f10013b;
            if (dVar.V != 8) {
                return dVar;
            }
            i9++;
        }
    }

    public final w.d n() {
        ArrayList arrayList = this.f9986k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            w.d dVar = ((n) arrayList.get(size)).f10013b;
            if (dVar.V != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final String toString() {
        String concat = "ChainRun ".concat(this.f10017f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.f9986k;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            concat = (concat.concat("<") + ((n) obj)).concat("> ");
        }
        return concat;
    }
}
