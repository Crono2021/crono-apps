package r6;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f1 extends com.google.crypto.tink.shaded.protobuf.y {
    private static final f1 DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile com.google.crypto.tink.shaded.protobuf.y0 PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private com.google.crypto.tink.shaded.protobuf.b0 key_ = com.google.crypto.tink.shaded.protobuf.b1.f2202l;
    private int primaryKeyId_;

    static {
        f1 f1Var = new f1();
        DEFAULT_INSTANCE = f1Var;
        com.google.crypto.tink.shaded.protobuf.y.t(f1.class, f1Var);
    }

    public static c1 C() {
        return (c1) DEFAULT_INSTANCE.h();
    }

    public static f1 D(ByteArrayInputStream byteArrayInputStream, com.google.crypto.tink.shaded.protobuf.q qVar) {
        com.google.crypto.tink.shaded.protobuf.y s8 = com.google.crypto.tink.shaded.protobuf.y.s(DEFAULT_INSTANCE, new com.google.crypto.tink.shaded.protobuf.l(byteArrayInputStream), qVar);
        com.google.crypto.tink.shaded.protobuf.y.g(s8);
        return (f1) s8;
    }

    public static f1 E(byte[] bArr, com.google.crypto.tink.shaded.protobuf.q qVar) {
        f1 f1Var = DEFAULT_INSTANCE;
        int length = bArr.length;
        com.google.crypto.tink.shaded.protobuf.y q4 = f1Var.q();
        try {
            com.google.crypto.tink.shaded.protobuf.a1 a1Var = com.google.crypto.tink.shaded.protobuf.a1.f2198c;
            a1Var.getClass();
            com.google.crypto.tink.shaded.protobuf.d1 a9 = a1Var.a(q4.getClass());
            com.google.crypto.tink.shaded.protobuf.d dVar = new com.google.crypto.tink.shaded.protobuf.d();
            qVar.getClass();
            a9.c(q4, bArr, 0, length, dVar);
            a9.e(q4);
            com.google.crypto.tink.shaded.protobuf.y.g(q4);
            return (f1) q4;
        } catch (com.google.crypto.tink.shaded.protobuf.e0 e9) {
            if (e9.f2216i) {
                throw new com.google.crypto.tink.shaded.protobuf.e0(e9.getMessage(), e9);
            }
            throw e9;
        } catch (com.google.crypto.tink.shaded.protobuf.f1 e10) {
            throw new com.google.crypto.tink.shaded.protobuf.e0(e10.getMessage());
        } catch (IOException e11) {
            if (e11.getCause() instanceof com.google.crypto.tink.shaded.protobuf.e0) {
                throw ((com.google.crypto.tink.shaded.protobuf.e0) e11.getCause());
            }
            throw new com.google.crypto.tink.shaded.protobuf.e0(e11.getMessage(), e11);
        } catch (IndexOutOfBoundsException unused) {
            throw com.google.crypto.tink.shaded.protobuf.e0.g();
        }
    }

    public static void w(f1 f1Var, int i9) {
        f1Var.primaryKeyId_ = i9;
    }

    public static void x(f1 f1Var, e1 e1Var) {
        f1Var.getClass();
        com.google.crypto.tink.shaded.protobuf.b0 b0Var = f1Var.key_;
        if (!((com.google.crypto.tink.shaded.protobuf.b) b0Var).f2201i) {
            int size = b0Var.size();
            f1Var.key_ = b0Var.a(size == 0 ? 10 : size * 2);
        }
        f1Var.key_.add(e1Var);
    }

    public final List A() {
        return this.key_;
    }

    public final int B() {
        return this.primaryKeyId_;
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
                return new com.google.crypto.tink.shaded.protobuf.c1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", e1.class});
            case 3:
                return new f1();
            case 4:
                return new c1(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                com.google.crypto.tink.shaded.protobuf.y0 y0Var2 = PARSER;
                if (y0Var2 != null) {
                    return y0Var2;
                }
                synchronized (f1.class) {
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

    public final e1 y(int i9) {
        return (e1) this.key_.get(i9);
    }

    public final int z() {
        return this.key_.size();
    }
}
