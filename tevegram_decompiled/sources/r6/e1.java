package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e1 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final e1 DEFAULT_INSTANCE;
    public static final int KEY_DATA_FIELD_NUMBER = 1;
    public static final int KEY_ID_FIELD_NUMBER = 3;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 2;
    private x0 keyData_;
    private int keyId_;
    private int outputPrefixType_;
    private int status_;

    static {
        e1 e1Var = new e1();
        DEFAULT_INSTANCE = e1Var;
        com.google.crypto.tink.shaded.protobuf.y.t(e1.class, e1Var);
    }

    public static d1 F() {
        return (d1) DEFAULT_INSTANCE.h();
    }

    public static void w(e1 e1Var, x0 x0Var) {
        e1Var.getClass();
        e1Var.keyData_ = x0Var;
    }

    public static void x(e1 e1Var, q1 q1Var) {
        e1Var.getClass();
        e1Var.outputPrefixType_ = q1Var.b();
    }

    public static void y(e1 e1Var) {
        e1Var.getClass();
        e1Var.status_ = y0.ENABLED.a();
    }

    public static void z(e1 e1Var, int i9) {
        e1Var.keyId_ = i9;
    }

    public final x0 A() {
        x0 x0Var = this.keyData_;
        return x0Var == null ? x0.z() : x0Var;
    }

    public final int B() {
        return this.keyId_;
    }

    public final q1 C() {
        q1 a9 = q1.a(this.outputPrefixType_);
        return a9 == null ? q1.UNRECOGNIZED : a9;
    }

    public final y0 D() {
        int i9 = this.status_;
        y0 y0Var = i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? null : y0.DESTROYED : y0.DISABLED : y0.ENABLED : y0.UNKNOWN_STATUS;
        return y0Var == null ? y0.UNRECOGNIZED : y0Var;
    }

    public final boolean E() {
        return this.keyData_ != null;
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
            case 3:
                return new e1();
            case 4:
                return new d1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (e1.class) {
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
