package g6;

import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import r6.b0;
import r6.c0;
import r6.d0;
import r6.f0;
import r6.j0;
import r6.l1;
import r6.o0;
import r6.o1;
import r6.q0;
import r6.r0;
import r6.s0;
import r6.t0;
import r6.t1;
import r6.u0;
import r6.w0;
import r6.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends m6.e {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3757d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(Class cls, f[] fVarArr, int i9) {
        super(cls, fVarArr);
        this.f3757d = i9;
    }

    public static m6.d h(int i9, int i10) {
        r6.s A = r6.t.A();
        A.e();
        r6.t.x((r6.t) A.f2326j, i9);
        r6.u z8 = r6.v.z();
        z8.e();
        r6.v.w((r6.v) z8.f2326j);
        r6.v vVar = (r6.v) z8.b();
        A.e();
        r6.t.w((r6.t) A.f2326j, vVar);
        return new m6.d((r6.t) A.b(), i10);
    }

    public static m6.d i(int i9, int i10, int i11) {
        r6.m B = r6.n.B();
        r6.o z8 = r6.p.z();
        z8.e();
        r6.p.w((r6.p) z8.f2326j);
        r6.p pVar = (r6.p) z8.b();
        B.e();
        r6.n.w((r6.n) B.f2326j, pVar);
        B.e();
        r6.n.x((r6.n) B.f2326j, i9);
        r6.n nVar = (r6.n) B.b();
        r0 B2 = s0.B();
        t0 B3 = u0.B();
        B3.e();
        u0.w((u0) B3.f2326j, o0.SHA256);
        B3.e();
        u0.x((u0) B3.f2326j, i10);
        u0 u0Var = (u0) B3.b();
        B2.e();
        s0.w((s0) B2.f2326j, u0Var);
        B2.e();
        s0.x((s0) B2.f2326j, 32);
        s0 s0Var = (s0) B2.b();
        r6.i A = r6.j.A();
        A.e();
        r6.j.w((r6.j) A.f2326j, nVar);
        A.e();
        r6.j.x((r6.j) A.f2326j, s0Var);
        return new m6.d((r6.j) A.b(), i11);
    }

    public static m6.d j(int i9, int i10) {
        r6.y y2 = z.y();
        y2.e();
        z.w((z) y2.f2326j, i9);
        return new m6.d((z) y2.b(), i10);
    }

    public static m6.d k(int i9, int i10) {
        c0 y2 = d0.y();
        y2.e();
        d0.w((d0) y2.f2326j, i9);
        return new m6.d((d0) y2.b(), i10);
    }

    @Override // m6.e
    public int a() {
        switch (this.f3757d) {
            case 0:
                return 2;
            case 1:
            default:
                return super.a();
            case 2:
                return 2;
        }
    }

    @Override // m6.e
    public final String b() {
        switch (this.f3757d) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
            case 1:
                return "type.googleapis.com/google.crypto.tink.AesEaxKey";
            case 2:
                return "type.googleapis.com/google.crypto.tink.AesGcmKey";
            case 3:
                return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
            case 4:
                return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
            case 5:
                return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
            case 6:
                return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
            case 7:
                return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
            default:
                return "type.googleapis.com/google.crypto.tink.AesSivKey";
        }
    }

    @Override // m6.e
    public final b1.b d() {
        switch (this.f3757d) {
            case 0:
                return new g(this);
            case 1:
                return new g(this, (byte) 0);
            case 2:
                return new g(this, (char) 0);
            case 3:
                return new g(this, 0);
            case 4:
                return new g(this, (short) 0);
            case 5:
                return new g(this, (byte) 0, false);
            case 6:
                return new g(this, (byte) 0, (byte) 0);
            case 7:
                return new g(this, (byte) 0, (char) 0);
            default:
                return new g(this, (byte) 0, 0);
        }
    }

    @Override // m6.e
    public final w0 e() {
        switch (this.f3757d) {
        }
        return w0.SYMMETRIC;
    }

    @Override // m6.e
    public final com.google.crypto.tink.shaded.protobuf.a f(com.google.crypto.tink.shaded.protobuf.j jVar) {
        switch (this.f3757d) {
            case 0:
                return r6.h.D(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 1:
                return r6.r.D(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 2:
                return r6.x.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 3:
                return b0.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 4:
                return j0.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 5:
                return l1.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 6:
                return o1.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 7:
                return t1.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            default:
                return f0.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
        }
    }

    @Override // m6.e
    public final void g(com.google.crypto.tink.shaded.protobuf.a aVar) {
        switch (this.f3757d) {
            case 0:
                r6.h hVar = (r6.h) aVar;
                s6.m.c(hVar.B());
                f[] fVarArr = {new f(1, s6.a.class)};
                HashMap hashMap = new HashMap();
                f fVar = fVarArr[0];
                boolean containsKey = hashMap.containsKey(fVar.f3754a);
                Class cls = fVar.f3754a;
                if (containsKey) {
                    androidx.fragment.app.a.g(cls.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                    return;
                }
                hashMap.put(cls, fVar);
                Class cls2 = fVarArr[0].f3754a;
                Collections.unmodifiableMap(hashMap);
                r6.l z8 = hVar.z();
                s6.m.c(z8.C());
                s6.m.a(z8.A().size());
                r6.p B = z8.B();
                if (B.y() < 12 || B.y() > 16) {
                    androidx.fragment.app.a.o("invalid IV size");
                    return;
                }
                f[] fVarArr2 = {new f(11, f6.j.class)};
                HashMap hashMap2 = new HashMap();
                f fVar2 = fVarArr2[0];
                boolean containsKey2 = hashMap2.containsKey(fVar2.f3754a);
                Class cls3 = fVar2.f3754a;
                if (containsKey2) {
                    androidx.fragment.app.a.g(cls3.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                    return;
                }
                hashMap2.put(cls3, fVar2);
                Class cls4 = fVarArr2[0].f3754a;
                Collections.unmodifiableMap(hashMap2);
                q0 A = hVar.A();
                s6.m.c(A.C());
                if (A.A().size() >= 16) {
                    n6.b.j(A.B());
                    return;
                } else {
                    androidx.fragment.app.a.o("key too short");
                    return;
                }
            case 1:
                r6.r rVar = (r6.r) aVar;
                s6.m.c(rVar.B());
                s6.m.a(rVar.z().size());
                if (rVar.A().y() == 12 || rVar.A().y() == 16) {
                    return;
                }
                androidx.fragment.app.a.o("invalid IV size; acceptable values have 12 or 16 bytes");
                return;
            case 2:
                r6.x xVar = (r6.x) aVar;
                s6.m.c(xVar.z());
                s6.m.a(xVar.y().size());
                return;
            case 3:
                b0 b0Var = (b0) aVar;
                s6.m.c(b0Var.z());
                s6.m.a(b0Var.y().size());
                return;
            case 4:
                j0 j0Var = (j0) aVar;
                s6.m.c(j0Var.z());
                if (j0Var.y().size() == 32) {
                    return;
                }
                androidx.fragment.app.a.o("invalid ChaCha20Poly1305Key: incorrect key length");
                return;
            case 5:
                s6.m.c(((l1) aVar).z());
                return;
            case 6:
                s6.m.c(((o1) aVar).z());
                return;
            case 7:
                t1 t1Var = (t1) aVar;
                s6.m.c(t1Var.z());
                if (t1Var.y().size() == 32) {
                    return;
                }
                androidx.fragment.app.a.o("invalid XChaCha20Poly1305Key: incorrect key length");
                return;
            default:
                f0 f0Var = (f0) aVar;
                s6.m.c(f0Var.z());
                if (f0Var.y().size() == 64) {
                    return;
                }
                throw new InvalidKeyException("invalid key size: " + f0Var.y().size() + ". Valid keys must have 64 bytes.");
        }
    }
}
