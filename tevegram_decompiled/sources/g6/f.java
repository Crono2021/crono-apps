package g6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import r6.b0;
import r6.f0;
import r6.j0;
import r6.l1;
import r6.o0;
import r6.o1;
import r6.q0;
import r6.t1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Class f3754a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3755b;

    public f(int i9, Class cls) {
        this.f3755b = i9;
        this.f3754a = cls;
    }

    public final Object a(com.google.crypto.tink.shaded.protobuf.a aVar) {
        switch (this.f3755b) {
            case 0:
                r6.h hVar = (r6.h) aVar;
                f[] fVarArr = {new f(1, s6.a.class)};
                HashMap hashMap = new HashMap();
                int length = fVarArr.length;
                int i9 = 0;
                while (true) {
                    if (i9 >= length) {
                        if (fVarArr.length > 0) {
                            Class cls = fVarArr[0].f3754a;
                        }
                        Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                        r6.l z8 = hVar.z();
                        f fVar = (f) unmodifiableMap.get(s6.a.class);
                        if (fVar == null) {
                            throw new IllegalArgumentException("Requested primitive class " + s6.a.class.getCanonicalName() + " not supported.");
                        }
                        s6.a aVar2 = (s6.a) fVar.a(z8);
                        f[] fVarArr2 = {new f(11, f6.j.class)};
                        HashMap hashMap2 = new HashMap();
                        for (f fVar2 : fVarArr2) {
                            boolean containsKey = hashMap2.containsKey(fVar2.f3754a);
                            Class cls2 = fVar2.f3754a;
                            if (containsKey) {
                                androidx.fragment.app.a.g(cls2.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                            } else {
                                hashMap2.put(cls2, fVar2);
                            }
                        }
                        if (fVarArr2.length > 0) {
                            Class cls3 = fVarArr2[0].f3754a;
                        }
                        Map unmodifiableMap2 = Collections.unmodifiableMap(hashMap2);
                        q0 A = hVar.A();
                        f fVar3 = (f) unmodifiableMap2.get(f6.j.class);
                        if (fVar3 != null) {
                            return new s6.g(aVar2, (f6.j) fVar3.a(A), hVar.A().B().A());
                        }
                        throw new IllegalArgumentException("Requested primitive class " + f6.j.class.getCanonicalName() + " not supported.");
                    }
                    f fVar4 = fVarArr[i9];
                    boolean containsKey2 = hashMap.containsKey(fVar4.f3754a);
                    Class cls4 = fVar4.f3754a;
                    if (containsKey2) {
                        androidx.fragment.app.a.g(cls4.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                    } else {
                        hashMap.put(cls4, fVar4);
                        i9++;
                    }
                }
                return null;
            case 1:
                r6.l lVar = (r6.l) aVar;
                return new s6.a(lVar.A().j(), lVar.B().y());
            case 2:
                r6.r rVar = (r6.r) aVar;
                return new s6.b(rVar.z().j(), rVar.A().y());
            case 3:
                return new s6.c(((r6.x) aVar).y().j(), 0);
            case 4:
                return new i6.a(((b0) aVar).y().j());
            case 5:
                return new s6.c(((j0) aVar).y().j(), 1);
            case 6:
                String x6 = ((l1) aVar).y().x();
                return f6.i.a(x6).c(x6);
            case 7:
                o1 o1Var = (o1) aVar;
                String y2 = o1Var.y().y();
                return new v(o1Var.y().x(), f6.i.a(y2).c(y2));
            case 8:
                return new s6.c(((t1) aVar).y().j(), 2);
            case 9:
                return new s6.d(((f0) aVar).y().j());
            case 10:
                r6.b bVar = (r6.b) aVar;
                return new s6.k(new androidx.fragment.app.g(bVar.z().j()), bVar.A().y());
            default:
                q0 q0Var = (q0) aVar;
                o0 z9 = q0Var.B().z();
                SecretKeySpec secretKeySpec = new SecretKeySpec(q0Var.A().j(), "HMAC");
                int A2 = q0Var.B().A();
                int ordinal = z9.ordinal();
                if (ordinal == 1) {
                    return new s6.k(new g1.o("HMACSHA1", secretKeySpec), A2);
                }
                if (ordinal == 2) {
                    return new s6.k(new g1.o("HMACSHA384", secretKeySpec), A2);
                }
                if (ordinal == 3) {
                    return new s6.k(new g1.o("HMACSHA256", secretKeySpec), A2);
                }
                if (ordinal == 4) {
                    return new s6.k(new g1.o("HMACSHA512", secretKeySpec), A2);
                }
                if (ordinal == 5) {
                    return new s6.k(new g1.o("HMACSHA224", secretKeySpec), A2);
                }
                androidx.fragment.app.a.o("unknown hash");
                return null;
        }
    }
}
