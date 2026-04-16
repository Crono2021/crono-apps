package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u0 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final u0 DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER = null;
    public static final int TAG_SIZE_FIELD_NUMBER = 2;
    private int hash_;
    private int tagSize_;

    static {
        u0 u0Var = new u0();
        DEFAULT_INSTANCE = u0Var;
        com.google.crypto.tink.shaded.protobuf.y.t(u0.class, u0Var);
    }

    public static t0 B() {
        return (t0) DEFAULT_INSTANCE.h();
    }

    public static void w(u0 u0Var, o0 o0Var) {
        u0Var.getClass();
        u0Var.hash_ = o0Var.a();
    }

    public static void x(u0 u0Var, int i9) {
        u0Var.tagSize_ = i9;
    }

    public static u0 y() {
        return DEFAULT_INSTANCE;
    }

    public final int A() {
        return this.tagSize_;
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"hash_", "tagSize_"});
            case 3:
                return new u0();
            case 4:
                return new t0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (u0.class) {
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

    public final o0 z() {
        int i9 = this.hash_;
        o0 o0Var = i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? i9 != 5 ? null : o0.SHA224 : o0.SHA512 : o0.SHA256 : o0.SHA384 : o0.SHA1 : o0.UNKNOWN_HASH;
        return o0Var == null ? o0.UNRECOGNIZED : o0Var;
    }
}
