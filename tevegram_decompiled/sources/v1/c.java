package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements v0 {

    /* renamed from: i, reason: collision with root package name */
    public final v0 f9250i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9251j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d f9252k;

    public c(d dVar, v0 v0Var) {
        this.f9252k = dVar;
        this.f9250i = v0Var;
    }

    @Override // v1.v0
    public final boolean b() {
        return !this.f9252k.e() && this.f9250i.b();
    }

    @Override // v1.v0
    public final void n() {
        this.f9250i.n();
    }

    @Override // v1.v0
    public final int o(long j5) {
        if (this.f9252k.e()) {
            return -3;
        }
        return this.f9250i.o(j5);
    }

    @Override // v1.v0
    public final int r(a5.d dVar, j1.e eVar, int i9) {
        d dVar2 = this.f9252k;
        if (dVar2.e()) {
            return -3;
        }
        if (this.f9251j) {
            eVar.f3748j = 4;
            return -4;
        }
        long m9 = dVar2.m();
        int r8 = this.f9250i.r(dVar, eVar, i9);
        if (r8 != -5) {
            long j5 = dVar2.f9264n;
            if (j5 == Long.MIN_VALUE || ((r8 != -4 || eVar.f5361o < j5) && !(r8 == -3 && m9 == Long.MIN_VALUE && !eVar.f5360n))) {
                return r8;
            }
            eVar.k();
            eVar.f3748j = 4;
            this.f9251j = true;
            return -4;
        }
        d1.s sVar = (d1.s) dVar.f175k;
        sVar.getClass();
        int i10 = sVar.D;
        int i11 = sVar.C;
        if (i11 == 0 && i10 == 0) {
            return -5;
        }
        if (dVar2.f9263m != 0) {
            i11 = 0;
        }
        if (dVar2.f9264n != Long.MIN_VALUE) {
            i10 = 0;
        }
        d1.r a9 = sVar.a();
        a9.B = i11;
        a9.C = i10;
        dVar.f175k = new d1.s(a9);
        return -5;
    }
}
