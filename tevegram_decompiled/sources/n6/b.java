package n6;

import com.google.crypto.tink.shaded.protobuf.q;
import r6.o0;
import r6.q0;
import r6.r0;
import r6.s0;
import r6.t0;
import r6.u0;
import r6.w0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends m6.e {

    /* renamed from: e, reason: collision with root package name */
    public static final m6.m f7439e = new m6.m(a.class, new m7.c(2));

    /* renamed from: f, reason: collision with root package name */
    public static final m6.m f7440f = new m6.m(i.class, new m7.c(4));

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7441d = 1;

    public b() {
        super(q0.class, new g6.f(11, f6.j.class));
    }

    public static m6.d h(int i9, int i10, o0 o0Var, int i11) {
        r0 B = s0.B();
        t0 B2 = u0.B();
        B2.e();
        u0.w((u0) B2.f2326j, o0Var);
        B2.e();
        u0.x((u0) B2.f2326j, i10);
        u0 u0Var = (u0) B2.b();
        B.e();
        s0.w((s0) B.f2326j, u0Var);
        B.e();
        s0.x((s0) B.f2326j, i9);
        return new m6.d((s0) B.b(), i11);
    }

    public static void i(r6.f fVar) {
        if (fVar.y() < 10) {
            androidx.fragment.app.a.o("tag size too short");
        } else {
            if (fVar.y() <= 16) {
                return;
            }
            androidx.fragment.app.a.o("tag size too long");
        }
    }

    public static void j(u0 u0Var) {
        if (u0Var.A() < 10) {
            androidx.fragment.app.a.o("tag size too small");
            return;
        }
        int ordinal = u0Var.z().ordinal();
        if (ordinal == 1) {
            if (u0Var.A() <= 20) {
                return;
            }
            androidx.fragment.app.a.o("tag size too big");
            return;
        }
        if (ordinal == 2) {
            if (u0Var.A() <= 48) {
                return;
            }
            androidx.fragment.app.a.o("tag size too big");
            return;
        }
        if (ordinal == 3) {
            if (u0Var.A() <= 32) {
                return;
            }
            androidx.fragment.app.a.o("tag size too big");
        } else if (ordinal == 4) {
            if (u0Var.A() <= 64) {
                return;
            }
            androidx.fragment.app.a.o("tag size too big");
        } else if (ordinal != 5) {
            androidx.fragment.app.a.o("unknown hash type");
        } else {
            if (u0Var.A() <= 28) {
                return;
            }
            androidx.fragment.app.a.o("tag size too big");
        }
    }

    @Override // m6.e
    public int a() {
        switch (this.f7441d) {
            case 1:
                return 2;
            default:
                return super.a();
        }
    }

    @Override // m6.e
    public final String b() {
        switch (this.f7441d) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCmacKey";
            default:
                return "type.googleapis.com/google.crypto.tink.HmacKey";
        }
    }

    @Override // m6.e
    public final b1.b d() {
        switch (this.f7441d) {
            case 0:
                return new g6.g(r6.d.class);
            default:
                return new g6.g(this);
        }
    }

    @Override // m6.e
    public final w0 e() {
        switch (this.f7441d) {
        }
        return w0.SYMMETRIC;
    }

    @Override // m6.e
    public final com.google.crypto.tink.shaded.protobuf.a f(com.google.crypto.tink.shaded.protobuf.j jVar) {
        switch (this.f7441d) {
            case 0:
                return r6.b.D(jVar, q.a());
            default:
                return q0.E(jVar, q.a());
        }
    }

    @Override // m6.e
    public final void g(com.google.crypto.tink.shaded.protobuf.a aVar) {
        switch (this.f7441d) {
            case 0:
                r6.b bVar = (r6.b) aVar;
                s6.m.c(bVar.B());
                if (bVar.z().size() != 32) {
                    androidx.fragment.app.a.o("AesCmacKey size wrong, must be 32 bytes");
                    break;
                } else {
                    i(bVar.A());
                    break;
                }
            default:
                q0 q0Var = (q0) aVar;
                s6.m.c(q0Var.C());
                if (q0Var.A().size() < 16) {
                    androidx.fragment.app.a.o("key too short");
                    break;
                } else {
                    j(q0Var.B());
                    break;
                }
        }
    }

    public /* synthetic */ b(Class cls, g6.f[] fVarArr) {
        super(cls, fVarArr);
    }
}
