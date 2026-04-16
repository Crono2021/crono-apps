package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a1 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final a1 DEFAULT_INSTANCE;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int outputPrefixType_;
    private String typeUrl_ = "";
    private com.google.crypto.tink.shaded.protobuf.j value_ = com.google.crypto.tink.shaded.protobuf.j.f2248j;

    static {
        a1 a1Var = new a1();
        DEFAULT_INSTANCE = a1Var;
        com.google.crypto.tink.shaded.protobuf.y.t(a1.class, a1Var);
    }

    public static z0 D() {
        return (z0) DEFAULT_INSTANCE.h();
    }

    public static void w(a1 a1Var, String str) {
        a1Var.getClass();
        str.getClass();
        a1Var.typeUrl_ = str;
    }

    public static void x(a1 a1Var, com.google.crypto.tink.shaded.protobuf.i iVar) {
        a1Var.getClass();
        a1Var.value_ = iVar;
    }

    public static void y(a1 a1Var, q1 q1Var) {
        a1Var.getClass();
        a1Var.outputPrefixType_ = q1Var.b();
    }

    public static a1 z() {
        return DEFAULT_INSTANCE;
    }

    public final q1 A() {
        q1 a9 = q1.a(this.outputPrefixType_);
        return a9 == null ? q1.UNRECOGNIZED : a9;
    }

    public final String B() {
        return this.typeUrl_;
    }

    public final com.google.crypto.tink.shaded.protobuf.j C() {
        return this.value_;
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "outputPrefixType_"});
            case 3:
                return new a1();
            case 4:
                return new z0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (a1.class) {
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
