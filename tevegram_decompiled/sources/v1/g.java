package v1;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends d1 {

    /* renamed from: l, reason: collision with root package name */
    public final long f9282l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f9283m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f9284n;

    /* renamed from: o, reason: collision with root package name */
    public final d1.x0 f9285o;

    /* renamed from: p, reason: collision with root package name */
    public e f9286p;

    /* renamed from: q, reason: collision with root package name */
    public f f9287q;

    /* renamed from: r, reason: collision with root package name */
    public long f9288r;

    /* renamed from: s, reason: collision with root package name */
    public long f9289s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a aVar, long j5, boolean z8) {
        super(aVar);
        aVar.getClass();
        this.f9282l = j5;
        this.f9283m = z8;
        this.f9284n = new ArrayList();
        this.f9285o = new d1.x0();
    }

    public final void B(d1.y0 y0Var) {
        long j5;
        d1.x0 x0Var = this.f9285o;
        y0Var.n(0, x0Var);
        long j9 = x0Var.f2609q;
        e eVar = this.f9286p;
        long j10 = this.f9282l;
        ArrayList arrayList = this.f9284n;
        if (eVar == null || arrayList.isEmpty()) {
            this.f9288r = j9;
            this.f9289s = j10 != Long.MIN_VALUE ? j9 + j10 : Long.MIN_VALUE;
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                d dVar = (d) arrayList.get(i9);
                long j11 = this.f9288r;
                long j12 = this.f9289s;
                dVar.f9263m = j11;
                dVar.f9264n = j12;
            }
            j5 = 0;
        } else {
            j5 = this.f9288r - j9;
            j10 = j10 == Long.MIN_VALUE ? Long.MIN_VALUE : this.f9289s - j9;
        }
        try {
            e eVar2 = new e(y0Var, j5, j10);
            this.f9286p = eVar2;
            l(eVar2);
        } catch (f e9) {
            this.f9287q = e9;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                ((d) arrayList.get(i10)).f9265o = this.f9287q;
            }
        }
    }

    @Override // v1.a
    public final x a(z zVar, z1.d dVar, long j5) {
        d dVar2 = new d(this.f9266k.a(zVar, dVar, j5), this.f9283m, this.f9288r, this.f9289s);
        this.f9284n.add(dVar2);
        return dVar2;
    }

    @Override // v1.j, v1.a
    public final void i() {
        f fVar = this.f9287q;
        if (fVar != null) {
            throw fVar;
        }
        super.i();
    }

    @Override // v1.a
    public final void m(x xVar) {
        ArrayList arrayList = this.f9284n;
        g1.a.k(arrayList.remove(xVar));
        this.f9266k.m(((d) xVar).f9259i);
        if (arrayList.isEmpty()) {
            e eVar = this.f9286p;
            eVar.getClass();
            B(eVar.f9357b);
        }
    }

    @Override // v1.j, v1.a
    public final void o() {
        super.o();
        this.f9287q = null;
        this.f9286p = null;
    }

    @Override // v1.d1
    public final void y(d1.y0 y0Var) {
        if (this.f9287q != null) {
            return;
        }
        B(y0Var);
    }
}
