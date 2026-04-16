package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j1 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final j1 DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.b0 keyInfo_ = com.google.crypto.tink.shaded.protobuf.b1.f2202l;
    private int primaryKeyId_;

    static {
        j1 j1Var = new j1();
        DEFAULT_INSTANCE = j1Var;
        com.google.crypto.tink.shaded.protobuf.y.t(j1.class, j1Var);
    }

    public static void w(j1 j1Var, int i9) {
        j1Var.primaryKeyId_ = i9;
    }

    public static void x(j1 j1Var, i1 i1Var) {
        j1Var.getClass();
        com.google.crypto.tink.shaded.protobuf.b0 b0Var = j1Var.keyInfo_;
        if (!((com.google.crypto.tink.shaded.protobuf.b) b0Var).f2201i) {
            int size = b0Var.size();
            j1Var.keyInfo_ = b0Var.a(size == 0 ? 10 : size * 2);
        }
        j1Var.keyInfo_.add(i1Var);
    }

    public static g1 z() {
        return (g1) DEFAULT_INSTANCE.h();
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", i1.class});
            case 3:
                return new j1();
            case 4:
                return new g1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (j1.class) {
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

    public final i1 y() {
        return (i1) this.keyInfo_.get(0);
    }
}
