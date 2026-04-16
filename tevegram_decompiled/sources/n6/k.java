package n6;

import java.security.GeneralSecurityException;
import m6.u;
import r6.o0;
import r6.q1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final m6.l f7470a;

    /* renamed from: b, reason: collision with root package name */
    public static final m6.k f7471b;

    /* renamed from: c, reason: collision with root package name */
    public static final m6.c f7472c;

    /* renamed from: d, reason: collision with root package name */
    public static final m6.a f7473d;

    static {
        t6.a b9 = u.b("type.googleapis.com/google.crypto.tink.HmacKey");
        f7470a = new m6.l(j.class);
        f7471b = new m6.k(b9);
        f7472c = new m6.c(i.class);
        f7473d = new m6.a(b9, new m7.c(5));
    }

    public static c a(o0 o0Var) {
        int ordinal = o0Var.ordinal();
        if (ordinal == 1) {
            return c.f7446g;
        }
        if (ordinal == 2) {
            return c.f7448j;
        }
        if (ordinal == 3) {
            return c.f7447i;
        }
        if (ordinal == 4) {
            return c.f7449k;
        }
        if (ordinal == 5) {
            return c.h;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + o0Var.a());
    }

    public static c b(q1 q1Var) {
        int ordinal = q1Var.ordinal();
        if (ordinal == 1) {
            return c.f7450l;
        }
        if (ordinal == 2) {
            return c.f7452n;
        }
        if (ordinal == 3) {
            return c.f7453o;
        }
        if (ordinal == 4) {
            return c.f7451m;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var.b());
    }
}
