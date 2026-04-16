package g6;

import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.a0;
import r6.b0;
import r6.d0;
import r6.e0;
import r6.f0;
import r6.g0;
import r6.h0;
import r6.i0;
import r6.j0;
import r6.k1;
import r6.l0;
import r6.l1;
import r6.m1;
import r6.n1;
import r6.o0;
import r6.o1;
import r6.p0;
import r6.p1;
import r6.q0;
import r6.s0;
import r6.s1;
import r6.t1;
import r6.u0;
import r6.u1;
import r6.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends b1.b {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3756j = 0;

    public g(h hVar, byte b9, int i9) {
        super(h0.class);
    }

    @Override // b1.b
    public final com.google.crypto.tink.shaded.protobuf.a a(com.google.crypto.tink.shaded.protobuf.a aVar) {
        switch (this.f3756j) {
            case 0:
                r6.j jVar = (r6.j) aVar;
                f[] fVarArr = {new f(1, s6.a.class)};
                HashMap hashMap = new HashMap();
                for (f fVar : fVarArr) {
                    boolean containsKey = hashMap.containsKey(fVar.f3754a);
                    Class cls = fVar.f3754a;
                    if (containsKey) {
                        androidx.fragment.app.a.g(cls.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                        return null;
                    }
                    hashMap.put(cls, fVar);
                }
                if (fVarArr.length > 0) {
                    Class cls2 = fVarArr[0].f3754a;
                }
                Collections.unmodifiableMap(hashMap);
                r6.n y2 = jVar.y();
                r6.k D = r6.l.D();
                r6.p A = y2.A();
                D.e();
                r6.l.x((r6.l) D.f2326j, A);
                byte[] a9 = s6.l.a(y2.z());
                com.google.crypto.tink.shaded.protobuf.i h = com.google.crypto.tink.shaded.protobuf.j.h(0, a9.length, a9);
                D.e();
                r6.l.y((r6.l) D.f2326j, h);
                D.e();
                r6.l.w((r6.l) D.f2326j);
                r6.l lVar = (r6.l) D.b();
                f[] fVarArr2 = {new f(11, f6.j.class)};
                HashMap hashMap2 = new HashMap();
                for (f fVar2 : fVarArr2) {
                    boolean containsKey2 = hashMap2.containsKey(fVar2.f3754a);
                    Class cls3 = fVar2.f3754a;
                    if (containsKey2) {
                        androidx.fragment.app.a.g(cls3.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                        return null;
                    }
                    hashMap2.put(cls3, fVar2);
                }
                if (fVarArr2.length > 0) {
                    Class cls4 = fVarArr2[0].f3754a;
                }
                Collections.unmodifiableMap(hashMap2);
                s0 z8 = jVar.z();
                p0 D2 = q0.D();
                D2.e();
                q0.w((q0) D2.f2326j);
                u0 A2 = z8.A();
                D2.e();
                q0.x((q0) D2.f2326j, A2);
                byte[] a10 = s6.l.a(z8.z());
                com.google.crypto.tink.shaded.protobuf.i h9 = com.google.crypto.tink.shaded.protobuf.j.h(0, a10.length, a10);
                D2.e();
                q0.y((q0) D2.f2326j, h9);
                q0 q0Var = (q0) D2.b();
                r6.g C = r6.h.C();
                C.e();
                r6.h.x((r6.h) C.f2326j, lVar);
                C.e();
                r6.h.y((r6.h) C.f2326j, q0Var);
                C.e();
                r6.h.w((r6.h) C.f2326j);
                return (r6.h) C.b();
            case 1:
                r6.t tVar = (r6.t) aVar;
                r6.q C2 = r6.r.C();
                byte[] a11 = s6.l.a(tVar.y());
                com.google.crypto.tink.shaded.protobuf.i h10 = com.google.crypto.tink.shaded.protobuf.j.h(0, a11.length, a11);
                C2.e();
                r6.r.y((r6.r) C2.f2326j, h10);
                r6.v z9 = tVar.z();
                C2.e();
                r6.r.x((r6.r) C2.f2326j, z9);
                C2.e();
                r6.r.w((r6.r) C2.f2326j);
                return (r6.r) C2.b();
            case 2:
                r6.w A3 = r6.x.A();
                byte[] a12 = s6.l.a(((z) aVar).x());
                com.google.crypto.tink.shaded.protobuf.i h11 = com.google.crypto.tink.shaded.protobuf.j.h(0, a12.length, a12);
                A3.e();
                r6.x.x((r6.x) A3.f2326j, h11);
                A3.e();
                r6.x.w((r6.x) A3.f2326j);
                return (r6.x) A3.b();
            case 3:
                a0 A4 = b0.A();
                byte[] a13 = s6.l.a(((d0) aVar).x());
                com.google.crypto.tink.shaded.protobuf.i h12 = com.google.crypto.tink.shaded.protobuf.j.h(0, a13.length, a13);
                A4.e();
                b0.x((b0) A4.f2326j, h12);
                A4.e();
                b0.w((b0) A4.f2326j);
                return (b0) A4.b();
            case 4:
                i0 A5 = j0.A();
                A5.e();
                j0.w((j0) A5.f2326j);
                byte[] a14 = s6.l.a(32);
                com.google.crypto.tink.shaded.protobuf.i h13 = com.google.crypto.tink.shaded.protobuf.j.h(0, a14.length, a14);
                A5.e();
                j0.x((j0) A5.f2326j, h13);
                return (j0) A5.b();
            case 5:
                k1 A6 = l1.A();
                A6.e();
                l1.x((l1) A6.f2326j, (m1) aVar);
                A6.e();
                l1.w((l1) A6.f2326j);
                return (l1) A6.b();
            case 6:
                n1 A7 = o1.A();
                A7.e();
                o1.x((o1) A7.f2326j, (p1) aVar);
                A7.e();
                o1.w((o1) A7.f2326j);
                return (o1) A7.b();
            case 7:
                s1 A8 = t1.A();
                A8.e();
                t1.w((t1) A8.f2326j);
                byte[] a15 = s6.l.a(32);
                com.google.crypto.tink.shaded.protobuf.i h14 = com.google.crypto.tink.shaded.protobuf.j.h(0, a15.length, a15);
                A8.e();
                t1.x((t1) A8.f2326j, h14);
                return (t1) A8.b();
            case 8:
                e0 A9 = f0.A();
                byte[] a16 = s6.l.a(((h0) aVar).x());
                com.google.crypto.tink.shaded.protobuf.i h15 = com.google.crypto.tink.shaded.protobuf.j.h(0, a16.length, a16);
                A9.e();
                f0.x((f0) A9.f2326j, h15);
                A9.e();
                f0.w((f0) A9.f2326j);
                return (f0) A9.b();
            case 9:
                r6.d dVar = (r6.d) aVar;
                r6.a C3 = r6.b.C();
                C3.e();
                r6.b.w((r6.b) C3.f2326j);
                byte[] a17 = s6.l.a(dVar.y());
                com.google.crypto.tink.shaded.protobuf.i h16 = com.google.crypto.tink.shaded.protobuf.j.h(0, a17.length, a17);
                C3.e();
                r6.b.x((r6.b) C3.f2326j, h16);
                r6.f z10 = dVar.z();
                C3.e();
                r6.b.y((r6.b) C3.f2326j, z10);
                return (r6.b) C3.b();
            default:
                s0 s0Var = (s0) aVar;
                p0 D3 = q0.D();
                D3.e();
                q0.w((q0) D3.f2326j);
                u0 A10 = s0Var.A();
                D3.e();
                q0.x((q0) D3.f2326j, A10);
                byte[] a18 = s6.l.a(s0Var.z());
                com.google.crypto.tink.shaded.protobuf.i h17 = com.google.crypto.tink.shaded.protobuf.j.h(0, a18.length, a18);
                D3.e();
                q0.y((q0) D3.f2326j, h17);
                return (q0) D3.b();
        }
    }

    @Override // b1.b
    public Map b() {
        switch (this.f3756j) {
            case 0:
                HashMap hashMap = new HashMap();
                hashMap.put("AES128_CTR_HMAC_SHA256", h.i(16, 16, 1));
                hashMap.put("AES128_CTR_HMAC_SHA256_RAW", h.i(16, 16, 3));
                hashMap.put("AES256_CTR_HMAC_SHA256", h.i(32, 32, 1));
                hashMap.put("AES256_CTR_HMAC_SHA256_RAW", h.i(32, 32, 3));
                return Collections.unmodifiableMap(hashMap);
            case 1:
                HashMap hashMap2 = new HashMap();
                hashMap2.put("AES128_EAX", h.h(16, 1));
                hashMap2.put("AES128_EAX_RAW", h.h(16, 3));
                hashMap2.put("AES256_EAX", h.h(32, 1));
                hashMap2.put("AES256_EAX_RAW", h.h(32, 3));
                return Collections.unmodifiableMap(hashMap2);
            case 2:
                HashMap hashMap3 = new HashMap();
                hashMap3.put("AES128_GCM", h.j(16, 1));
                hashMap3.put("AES128_GCM_RAW", h.j(16, 3));
                hashMap3.put("AES256_GCM", h.j(32, 1));
                hashMap3.put("AES256_GCM_RAW", h.j(32, 3));
                return Collections.unmodifiableMap(hashMap3);
            case 3:
                HashMap hashMap4 = new HashMap();
                hashMap4.put("AES128_GCM_SIV", h.k(16, 1));
                hashMap4.put("AES128_GCM_SIV_RAW", h.k(16, 3));
                hashMap4.put("AES256_GCM_SIV", h.k(32, 1));
                hashMap4.put("AES256_GCM_SIV_RAW", h.k(32, 3));
                return Collections.unmodifiableMap(hashMap4);
            case 4:
                HashMap hashMap5 = new HashMap();
                hashMap5.put("CHACHA20_POLY1305", new m6.d(l0.w(), 1));
                hashMap5.put("CHACHA20_POLY1305_RAW", new m6.d(l0.w(), 3));
                return Collections.unmodifiableMap(hashMap5);
            case 5:
            case 6:
            default:
                return super.b();
            case 7:
                HashMap hashMap6 = new HashMap();
                hashMap6.put("XCHACHA20_POLY1305", new m6.d(u1.w(), 1));
                hashMap6.put("XCHACHA20_POLY1305_RAW", new m6.d(u1.w(), 3));
                return Collections.unmodifiableMap(hashMap6);
            case 8:
                HashMap hashMap7 = new HashMap();
                g0 y2 = h0.y();
                y2.e();
                h0.w((h0) y2.f2326j);
                hashMap7.put("AES256_SIV", new m6.d((h0) y2.b(), 1));
                g0 y3 = h0.y();
                y3.e();
                h0.w((h0) y3.f2326j);
                hashMap7.put("AES256_SIV_RAW", new m6.d((h0) y3.b(), 3));
                return Collections.unmodifiableMap(hashMap7);
            case 9:
                HashMap hashMap8 = new HashMap();
                r6.c A = r6.d.A();
                A.e();
                r6.d.w((r6.d) A.f2326j);
                r6.e z8 = r6.f.z();
                z8.e();
                r6.f.w((r6.f) z8.f2326j);
                r6.f fVar = (r6.f) z8.b();
                A.e();
                r6.d.x((r6.d) A.f2326j, fVar);
                hashMap8.put("AES_CMAC", new m6.d((r6.d) A.b(), 1));
                r6.c A2 = r6.d.A();
                A2.e();
                r6.d.w((r6.d) A2.f2326j);
                r6.e z9 = r6.f.z();
                z9.e();
                r6.f.w((r6.f) z9.f2326j);
                r6.f fVar2 = (r6.f) z9.b();
                A2.e();
                r6.d.x((r6.d) A2.f2326j, fVar2);
                hashMap8.put("AES256_CMAC", new m6.d((r6.d) A2.b(), 1));
                r6.c A3 = r6.d.A();
                A3.e();
                r6.d.w((r6.d) A3.f2326j);
                r6.e z10 = r6.f.z();
                z10.e();
                r6.f.w((r6.f) z10.f2326j);
                r6.f fVar3 = (r6.f) z10.b();
                A3.e();
                r6.d.x((r6.d) A3.f2326j, fVar3);
                hashMap8.put("AES256_CMAC_RAW", new m6.d((r6.d) A3.b(), 3));
                return Collections.unmodifiableMap(hashMap8);
            case 10:
                HashMap hashMap9 = new HashMap();
                o0 o0Var = o0.SHA256;
                hashMap9.put("HMAC_SHA256_128BITTAG", n6.b.h(32, 16, o0Var, 1));
                hashMap9.put("HMAC_SHA256_128BITTAG_RAW", n6.b.h(32, 16, o0Var, 3));
                hashMap9.put("HMAC_SHA256_256BITTAG", n6.b.h(32, 32, o0Var, 1));
                hashMap9.put("HMAC_SHA256_256BITTAG_RAW", n6.b.h(32, 32, o0Var, 3));
                o0 o0Var2 = o0.SHA512;
                hashMap9.put("HMAC_SHA512_128BITTAG", n6.b.h(64, 16, o0Var2, 1));
                hashMap9.put("HMAC_SHA512_128BITTAG_RAW", n6.b.h(64, 16, o0Var2, 3));
                hashMap9.put("HMAC_SHA512_256BITTAG", n6.b.h(64, 32, o0Var2, 1));
                hashMap9.put("HMAC_SHA512_256BITTAG_RAW", n6.b.h(64, 32, o0Var2, 3));
                hashMap9.put("HMAC_SHA512_512BITTAG", n6.b.h(64, 64, o0Var2, 1));
                hashMap9.put("HMAC_SHA512_512BITTAG_RAW", n6.b.h(64, 64, o0Var2, 3));
                return Collections.unmodifiableMap(hashMap9);
        }
    }

    @Override // b1.b
    public final com.google.crypto.tink.shaded.protobuf.a d(com.google.crypto.tink.shaded.protobuf.j jVar) {
        switch (this.f3756j) {
            case 0:
                return r6.j.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 1:
                return r6.t.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 2:
                return z.z(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 3:
                return d0.z(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 4:
                return l0.x(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 5:
                return m1.y(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 6:
                return p1.A(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 7:
                return u1.x(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 8:
                return h0.z(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            case 9:
                return r6.d.B(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
            default:
                return s0.C(jVar, com.google.crypto.tink.shaded.protobuf.q.a());
        }
    }

    @Override // b1.b
    public final void e(com.google.crypto.tink.shaded.protobuf.a aVar) {
        switch (this.f3756j) {
            case 0:
                r6.j jVar = (r6.j) aVar;
                f[] fVarArr = {new f(1, s6.a.class)};
                HashMap hashMap = new HashMap();
                for (f fVar : fVarArr) {
                    boolean containsKey = hashMap.containsKey(fVar.f3754a);
                    Class cls = fVar.f3754a;
                    if (containsKey) {
                        androidx.fragment.app.a.g(cls.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                        return;
                    }
                    hashMap.put(cls, fVar);
                }
                if (fVarArr.length > 0) {
                    Class cls2 = fVarArr[0].f3754a;
                }
                Collections.unmodifiableMap(hashMap);
                r6.n y2 = jVar.y();
                s6.m.a(y2.z());
                r6.p A = y2.A();
                if (A.y() < 12 || A.y() > 16) {
                    androidx.fragment.app.a.o("invalid IV size");
                    return;
                }
                f[] fVarArr2 = {new f(11, f6.j.class)};
                HashMap hashMap2 = new HashMap();
                for (f fVar2 : fVarArr2) {
                    boolean containsKey2 = hashMap2.containsKey(fVar2.f3754a);
                    Class cls3 = fVar2.f3754a;
                    if (containsKey2) {
                        androidx.fragment.app.a.g(cls3.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                        return;
                    }
                    hashMap2.put(cls3, fVar2);
                }
                if (fVarArr2.length > 0) {
                    Class cls4 = fVarArr2[0].f3754a;
                }
                Collections.unmodifiableMap(hashMap2);
                s0 z8 = jVar.z();
                if (z8.z() < 16) {
                    androidx.fragment.app.a.o("key too short");
                    return;
                } else {
                    n6.b.j(z8.A());
                    s6.m.a(jVar.y().z());
                    return;
                }
            case 1:
                r6.t tVar = (r6.t) aVar;
                s6.m.a(tVar.y());
                if (tVar.z().y() == 12 || tVar.z().y() == 16) {
                    return;
                }
                androidx.fragment.app.a.o("invalid IV size; acceptable values have 12 or 16 bytes");
                return;
            case 2:
                s6.m.a(((z) aVar).x());
                return;
            case 3:
                s6.m.a(((d0) aVar).x());
                return;
            case 4:
                return;
            case 5:
                return;
            case 6:
                p1 p1Var = (p1) aVar;
                if (p1Var.y().isEmpty() || !p1Var.z()) {
                    androidx.fragment.app.a.o("invalid key format: missing KEK URI or DEK template");
                    return;
                }
                return;
            case 7:
                return;
            case 8:
                h0 h0Var = (h0) aVar;
                if (h0Var.x() == 64) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("invalid key size: " + h0Var.x() + ". Valid keys must have 64 bytes.");
            case 9:
                r6.d dVar = (r6.d) aVar;
                n6.b.i(dVar.z());
                if (dVar.y() == 32) {
                    return;
                }
                androidx.fragment.app.a.o("AesCmacKey size wrong, must be 32 bytes");
                return;
            default:
                s0 s0Var = (s0) aVar;
                if (s0Var.z() >= 16) {
                    n6.b.j(s0Var.A());
                    return;
                } else {
                    androidx.fragment.app.a.o("key too short");
                    return;
                }
        }
    }

    public g(h hVar, byte b9, boolean z8) {
        super(m1.class);
    }

    public g(h hVar, byte b9, byte b10) {
        super(p1.class);
    }

    public g(h hVar, char c9) {
        super(z.class);
    }

    public g(h hVar, byte b9) {
        super(r6.t.class);
    }

    public g(h hVar, int i9) {
        super(d0.class);
    }

    public g(h hVar, short s8) {
        super(l0.class);
    }

    public g(h hVar, byte b9, char c9) {
        super(u1.class);
    }

    public /* synthetic */ g(Class cls) {
        super(cls);
    }

    public g(h hVar) {
        super(r6.j.class);
    }

    public g(n6.b bVar) {
        super(s0.class);
    }
}
