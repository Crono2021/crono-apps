package r6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x0 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final x0 DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_ = "";
    private com.google.crypto.tink.shaded.protobuf.j value_ = com.google.crypto.tink.shaded.protobuf.j.f2248j;

    static {
        x0 x0Var = new x0();
        DEFAULT_INSTANCE = x0Var;
        com.google.crypto.tink.shaded.protobuf.y.t(x0.class, x0Var);
    }

    public static v0 D() {
        return (v0) DEFAULT_INSTANCE.h();
    }

    public static void w(x0 x0Var, String str) {
        x0Var.getClass();
        str.getClass();
        x0Var.typeUrl_ = str;
    }

    public static void x(x0 x0Var, com.google.crypto.tink.shaded.protobuf.i iVar) {
        x0Var.getClass();
        x0Var.value_ = iVar;
    }

    public static void y(x0 x0Var, w0 w0Var) {
        x0Var.getClass();
        if (w0Var != w0.UNRECOGNIZED) {
            x0Var.keyMaterialType_ = w0Var.f8603i;
        } else {
            w0Var.getClass();
            m7.c.n("Can't get the number of an unknown enum value.");
        }
    }

    public static x0 z() {
        return DEFAULT_INSTANCE;
    }

    public final w0 A() {
        int i9 = this.keyMaterialType_;
        w0 w0Var = i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 4 ? null : w0.REMOTE : w0.ASYMMETRIC_PUBLIC : w0.ASYMMETRIC_PRIVATE : w0.SYMMETRIC : w0.UNKNOWN_KEYMATERIAL;
        return w0Var == null ? w0.UNRECOGNIZED : w0Var;
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
            case 3:
                return new x0();
            case 4:
                return new v0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (x0.class) {
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
