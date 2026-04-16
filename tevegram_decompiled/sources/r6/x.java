package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x extends com.google.crypto.tink.shaded.protobuf.y {
    private static final x DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.j keyValue_ = com.google.crypto.tink.shaded.protobuf.j.f2248j;
    private int version_;

    static {
        x xVar = new x();
        DEFAULT_INSTANCE = xVar;
        com.google.crypto.tink.shaded.protobuf.y.t(x.class, xVar);
    }

    public static w A() {
        return (w) DEFAULT_INSTANCE.h();
    }

    public static x B(com.google.crypto.tink.shaded.protobuf.j jVar, com.google.crypto.tink.shaded.protobuf.q qVar) {
        return (x) com.google.crypto.tink.shaded.protobuf.y.r(DEFAULT_INSTANCE, jVar, qVar);
    }

    public static void w(x xVar) {
        xVar.version_ = 0;
    }

    public static void x(x xVar, com.google.crypto.tink.shaded.protobuf.i iVar) {
        xVar.getClass();
        xVar.keyValue_ = iVar;
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"version_", "keyValue_"});
            case 3:
                return new x();
            case 4:
                return new w(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (x.class) {
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

    public final com.google.crypto.tink.shaded.protobuf.j y() {
        return this.keyValue_;
    }

    public final int z() {
        return this.version_;
    }
}
