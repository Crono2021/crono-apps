package n0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class r1 {

    /* renamed from: a, reason: collision with root package name */
    public final a2 f7194a;

    /* renamed from: b, reason: collision with root package name */
    public f0.c[] f7195b;

    public r1() {
        this(new a2());
    }

    public final void a() {
        f0.c[] cVarArr = this.f7195b;
        if (cVarArr != null) {
            f0.c cVar = cVarArr[0];
            f0.c cVar2 = cVarArr[1];
            a2 a2Var = this.f7194a;
            if (cVar2 == null) {
                cVar2 = a2Var.f7139a.f(2);
            }
            if (cVar == null) {
                cVar = a2Var.f7139a.f(1);
            }
            g(f0.c.a(cVar, cVar2));
            f0.c cVar3 = this.f7195b[com.bumptech.glide.d.K(16)];
            if (cVar3 != null) {
                f(cVar3);
            }
            f0.c cVar4 = this.f7195b[com.bumptech.glide.d.K(32)];
            if (cVar4 != null) {
                d(cVar4);
            }
            f0.c cVar5 = this.f7195b[com.bumptech.glide.d.K(64)];
            if (cVar5 != null) {
                h(cVar5);
            }
        }
    }

    public abstract a2 b();

    public void c(int i9, f0.c cVar) {
        if (this.f7195b == null) {
            this.f7195b = new f0.c[9];
        }
        for (int i10 = 1; i10 <= 256; i10 <<= 1) {
            if ((i9 & i10) != 0) {
                this.f7195b[com.bumptech.glide.d.K(i10)] = cVar;
            }
        }
    }

    public abstract void e(f0.c cVar);

    public abstract void g(f0.c cVar);

    public r1(a2 a2Var) {
        this.f7194a = a2Var;
    }

    public void d(f0.c cVar) {
    }

    public void f(f0.c cVar) {
    }

    public void h(f0.c cVar) {
    }
}
