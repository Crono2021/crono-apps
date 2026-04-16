package f6;

import com.google.crypto.tink.shaded.protobuf.e0;
import com.google.crypto.tink.shaded.protobuf.y;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Iterator;
import m6.u;
import r6.a1;
import r6.c1;
import r6.d1;
import r6.e1;
import r6.f1;
import r6.q1;
import r6.v0;
import r6.w0;
import r6.x0;
import r6.y0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f3419c;

    /* renamed from: d, reason: collision with root package name */
    public static final f f3420d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f3421e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3422a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f3423b;

    static {
        int i9 = 0;
        f3419c = new f("ENABLED", i9);
        f3420d = new f("DISABLED", i9);
        f3421e = new f("DESTROYED", i9);
    }

    public f(m6.e eVar, Class cls) {
        this.f3422a = 2;
        if (eVar.f6659b.keySet().contains(cls) || Void.class.equals(cls)) {
            this.f3423b = eVar;
            return;
        }
        throw new IllegalArgumentException("Given internalKeyMananger " + eVar.toString() + " does not support primitive class " + cls.getName());
    }

    public synchronized void a(a1 a1Var) {
        e1 e9 = e(a1Var);
        c1 c1Var = (c1) this.f3423b;
        c1Var.e();
        f1.x((f1) c1Var.f2326j, e9);
    }

    public synchronized e1 b(x0 x0Var, q1 q1Var) {
        d1 F;
        int g9 = g();
        if (q1Var == q1.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        F = e1.F();
        F.e();
        e1.w((e1) F.f2326j, x0Var);
        F.e();
        e1.z((e1) F.f2326j, g9);
        F.e();
        e1.y((e1) F.f2326j);
        F.e();
        e1.x((e1) F.f2326j, q1Var);
        return (e1) F.b();
    }

    public synchronized androidx.fragment.app.g c() {
        return androidx.fragment.app.g.K((f1) ((c1) this.f3423b).b());
    }

    public synchronized boolean d(int i9) {
        Iterator it = Collections.unmodifiableList(((f1) ((c1) this.f3423b).f2326j).A()).iterator();
        while (it.hasNext()) {
            if (((e1) it.next()).B() == i9) {
                return true;
            }
        }
        return false;
    }

    public synchronized e1 e(a1 a1Var) {
        return b(n.d(a1Var), a1Var.A());
    }

    public x0 f(com.google.crypto.tink.shaded.protobuf.j jVar) {
        m6.e eVar = (m6.e) this.f3423b;
        try {
            b1.b d9 = eVar.d();
            com.google.crypto.tink.shaded.protobuf.a d10 = d9.d(jVar);
            d9.e(d10);
            com.google.crypto.tink.shaded.protobuf.a a9 = d9.a(d10);
            v0 D = x0.D();
            String b9 = eVar.b();
            D.e();
            x0.w((x0) D.f2326j, b9);
            try {
                int b10 = ((y) a9).b(null);
                byte[] bArr = new byte[b10];
                com.google.crypto.tink.shaded.protobuf.n nVar = new com.google.crypto.tink.shaded.protobuf.n(bArr, b10);
                a9.f(nVar);
                if (nVar.f2276c - nVar.f2277d != 0) {
                    throw new IllegalStateException("Did not write as much data as expected.");
                }
                com.google.crypto.tink.shaded.protobuf.i iVar = new com.google.crypto.tink.shaded.protobuf.i(bArr);
                D.e();
                x0.x((x0) D.f2326j, iVar);
                w0 e9 = eVar.e();
                D.e();
                x0.y((x0) D.f2326j, e9);
                return (x0) D.b();
            } catch (IOException e10) {
                throw new RuntimeException(a9.c("ByteString"), e10);
            }
        } catch (e0 e11) {
            throw new GeneralSecurityException("Unexpected proto", e11);
        }
    }

    public synchronized int g() {
        int a9;
        a9 = u.a();
        while (d(a9)) {
            a9 = u.a();
        }
        return a9;
    }

    public synchronized void h(int i9) {
        for (int i10 = 0; i10 < ((f1) ((c1) this.f3423b).f2326j).z(); i10++) {
            try {
                e1 y2 = ((f1) ((c1) this.f3423b).f2326j).y(i10);
                if (y2.B() == i9) {
                    if (!y2.D().equals(y0.ENABLED)) {
                        throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i9);
                    }
                    c1 c1Var = (c1) this.f3423b;
                    c1Var.e();
                    f1.w((f1) c1Var.f2326j, i9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        throw new GeneralSecurityException("key not found: " + i9);
    }

    public String toString() {
        switch (this.f3422a) {
            case 0:
                return (String) this.f3423b;
            default:
                return super.toString();
        }
    }

    public /* synthetic */ f(Object obj, int i9) {
        this.f3422a = i9;
        this.f3423b = obj;
    }
}
