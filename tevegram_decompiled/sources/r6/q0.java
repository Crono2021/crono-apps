package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q0 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final q0 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.j keyValue_ = com.google.crypto.tink.shaded.protobuf.j.f2248j;
    private u0 params_;
    private int version_;

    static {
        q0 q0Var = new q0();
        DEFAULT_INSTANCE = q0Var;
        com.google.crypto.tink.shaded.protobuf.y.t(q0.class, q0Var);
    }

    public static p0 D() {
        return (p0) DEFAULT_INSTANCE.h();
    }

    public static q0 E(com.google.crypto.tink.shaded.protobuf.j jVar, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (q0) com.google.crypto.tink.shaded.protobuf.y.r(DEFAULT_INSTANCE, jVar, qVar);
    }

    public static void w(q0 q0Var) {
        q0Var.version_ = 0;
    }

    public static void x(q0 q0Var, u0 u0Var) {
        q0Var.getClass();
        u0Var.getClass();
        q0Var.params_ = u0Var;
    }

    public static void y(q0 q0Var, com.google.crypto.tink.shaded.protobuf.i iVar) {
        q0Var.getClass();
        q0Var.keyValue_ = iVar;
    }

    public static q0 z() {
        return DEFAULT_INSTANCE;
    }

    public final com.google.crypto.tink.shaded.protobuf.j A() {
        return this.keyValue_;
    }

    public final u0 B() {
        u0 u0Var = this.params_;
        return u0Var == null ? u0.y() : u0Var;
    }

    public final int C() {
        return this.version_;
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 3:
                return new q0();
            case 4:
                return new p0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (q0.class) {
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
