package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m1 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final m1 DEFAULT_INSTANCE;
    public static final int KEY_URI_FIELD_NUMBER = 1;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER;
    private String keyUri_ = "";

    static {
        m1 m1Var = new m1();
        DEFAULT_INSTANCE = m1Var;
        com.google.crypto.tink.shaded.protobuf.y.t(m1.class, m1Var);
    }

    public static m1 w() {
        return DEFAULT_INSTANCE;
    }

    public static m1 y(com.google.crypto.tink.shaded.protobuf.j jVar, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (m1) com.google.crypto.tink.shaded.protobuf.y.r(DEFAULT_INSTANCE, jVar, qVar);
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"keyUri_"});
            case 3:
                return new m1();
            case 4:
                return new k0(DEFAULT_INSTANCE, 2);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (m1.class) {
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

    public final String x() {
        return this.keyUri_;
    }
}
