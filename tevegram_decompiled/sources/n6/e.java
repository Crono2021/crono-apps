package n6;

import java.security.GeneralSecurityException;
import m6.u;
import r6.q1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final m6.l f7459a;

    /* renamed from: b, reason: collision with root package name */
    public static final m6.k f7460b;

    /* renamed from: c, reason: collision with root package name */
    public static final m6.c f7461c;

    /* renamed from: d, reason: collision with root package name */
    public static final m6.a f7462d;

    static {
        t6.a b9 = u.b("type.googleapis.com/google.crypto.tink.AesCmacKey");
        f7459a = new m6.l(d.class);
        f7460b = new m6.k(b9);
        f7461c = new m6.c(a.class);
        f7462d = new m6.a(b9, new m7.c(3));
    }

    public static c a(q1 q1Var) {
        int ordinal = q1Var.ordinal();
        if (ordinal == 1) {
            return c.f7442c;
        }
        if (ordinal == 2) {
            return c.f7444e;
        }
        if (ordinal == 3) {
            return c.f7445f;
        }
        if (ordinal == 4) {
            return c.f7443d;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var.b());
    }
}
