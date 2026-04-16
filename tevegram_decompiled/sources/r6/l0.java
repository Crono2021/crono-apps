package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final l0 DEFAULT_INSTANCE;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER;

    static {
        l0 l0Var = new l0();
        DEFAULT_INSTANCE = l0Var;
        com.google.crypto.tink.shaded.protobuf.y.t(l0.class, l0Var);
    }

    public static l0 w() {
        return DEFAULT_INSTANCE;
    }

    public static l0 x(com.google.crypto.tink.shaded.protobuf.j jVar, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (l0) com.google.crypto.tink.shaded.protobuf.y.r(DEFAULT_INSTANCE, jVar, qVar);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.y
    public final Object i(int i9) {
        com.google.crypto.tink.shaded.protobuf.y0 y0Var;
        switch (v.h.a(i9)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 3:
                return new l0();
            case 4:
                return new k0(DEFAULT_INSTANCE, 0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (l0.class) {
                    try {
                        y0Var = PARSER;
                        if (y0Var == null) {
                            y0Var = new com.google.crypto.tink.shaded.protobuf.x();
                            PARSER = y0Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return y0Var;
            default:
                androidx.fragment.app.a.p();
                return null;
        }
    }
}
