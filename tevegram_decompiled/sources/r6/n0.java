package r6;

import java.io.ByteArrayInputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n0 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final n0 DEFAULT_INSTANCE;
    public static final int ENCRYPTED_KEYSET_FIELD_NUMBER = 2;
    public static final int KEYSET_INFO_FIELD_NUMBER = 3;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER;
    private com.google.crypto.tink.shaded.protobuf.j encryptedKeyset_ = com.google.crypto.tink.shaded.protobuf.j.f2248j;
    private j1 keysetInfo_;

    static {
        n0 n0Var = new n0();
        DEFAULT_INSTANCE = n0Var;
        com.google.crypto.tink.shaded.protobuf.y.t(n0.class, n0Var);
    }

    public static n0 A(ByteArrayInputStream byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.q qVar) {
        com.google.crypto.tink.shaded.protobuf.y s8 = com.google.crypto.tink.shaded.protobuf.y.s(DEFAULT_INSTANCE, new com.google.crypto.tink.shaded.protobuf.l(byteArrayInputStream), qVar);
        com.google.crypto.tink.shaded.protobuf.y.g(s8);
        return (n0) s8;
    }

    public static void w(n0 n0Var, com.google.crypto.tink.shaded.protobuf.i iVar) {
        n0Var.getClass();
        n0Var.encryptedKeyset_ = iVar;
    }

    public static void x(n0 n0Var, j1 j1Var) {
        n0Var.getClass();
        n0Var.keysetInfo_ = j1Var;
    }

    public static m0 z() {
        return (m0) DEFAULT_INSTANCE.h();
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"encryptedKeyset_", "keysetInfo_"});
            case 3:
                return new n0();
            case 4:
                return new m0(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (n0.class) {
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
        return this.encryptedKeyset_;
    }
}
