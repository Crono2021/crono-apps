package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends com.google.crypto.tink.shaded.protobuf.y {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    private static final j DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER;
    private n aesCtrKeyFormat_;
    private s0 hmacKeyFormat_;

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        com.google.crypto.tink.shaded.protobuf.y.t(j.class, jVar);
    }

    public static i A() {
        return (i) DEFAULT_INSTANCE.h();
    }

    public static j B(com.google.crypto.tink.shaded.protobuf.j jVar, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (j) com.google.crypto.tink.shaded.protobuf.y.r(DEFAULT_INSTANCE, jVar, qVar);
    }

    public static void w(j jVar, n nVar) {
        jVar.getClass();
        jVar.aesCtrKeyFormat_ = nVar;
    }

    public static void x(j jVar, s0 s0Var) {
        jVar.getClass();
        jVar.hmacKeyFormat_ = s0Var;
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"aesCtrKeyFormat_", "hmacKeyFormat_"});
            case 3:
                return new j();
            case 4:
                return new i(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (j.class) {
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

    public final n y() {
        n nVar = this.aesCtrKeyFormat_;
        return nVar == null ? n.y() : nVar;
    }

    public final s0 z() {
        s0 s0Var = this.hmacKeyFormat_;
        return s0Var == null ? s0.y() : s0Var;
    }
}
