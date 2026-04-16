package g6;

import com.google.crypto.tink.shaded.protobuf.e0;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import r6.a1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements f6.a {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f3800c = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final a1 f3801a;

    /* renamed from: b, reason: collision with root package name */
    public final l6.b f3802b;

    public v(a1 a1Var, l6.b bVar) {
        this.f3801a = a1Var;
        this.f3802b = bVar;
    }

    @Override // f6.a
    public final byte[] a(byte[] bArr, byte[] bArr2) {
        com.google.crypto.tink.shaded.protobuf.a a9;
        a1 a1Var = this.f3801a;
        AtomicReference atomicReference = f6.n.f3435a;
        synchronized (f6.n.class) {
            try {
                m6.e eVar = ((f6.e) f6.n.f3435a.get()).a(a1Var.B()).f3416a;
                Class cls = eVar.f6660c;
                if (!eVar.f6659b.keySet().contains(cls) && !Void.class.equals(cls)) {
                    throw new IllegalArgumentException("Given internalKeyMananger " + eVar.toString() + " does not support primitive class " + cls.getName());
                }
                if (!((Boolean) f6.n.f3437c.get(a1Var.B())).booleanValue()) {
                    throw new GeneralSecurityException("newKey-operation not permitted for key type " + a1Var.B());
                }
                com.google.crypto.tink.shaded.protobuf.j C = a1Var.C();
                try {
                    b1.b d9 = eVar.d();
                    com.google.crypto.tink.shaded.protobuf.a d10 = d9.d(C);
                    d9.e(d10);
                    a9 = d9.a(d10);
                } catch (e0 e9) {
                    throw new GeneralSecurityException("Failures parsing proto of type ".concat(((Class) eVar.d().f1132i).getName()), e9);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        byte[] e10 = a9.e();
        byte[] a10 = this.f3802b.a(e10, f3800c);
        byte[] a11 = ((f6.a) f6.n.c(this.f3801a.B(), com.google.crypto.tink.shaded.protobuf.j.h(0, e10.length, e10), f6.a.class)).a(bArr, bArr2);
        return ByteBuffer.allocate(a10.length + 4 + a11.length).putInt(a10.length).put(a10).put(a11).array();
    }

    @Override // f6.a
    public final byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i9 = wrap.getInt();
            if (i9 <= 0 || i9 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i9];
            wrap.get(bArr3, 0, i9);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            byte[] b9 = this.f3802b.b(bArr3, f3800c);
            String B = this.f3801a.B();
            AtomicReference atomicReference = f6.n.f3435a;
            com.google.crypto.tink.shaded.protobuf.i iVar = com.google.crypto.tink.shaded.protobuf.j.f2248j;
            return ((f6.a) f6.n.c(B, com.google.crypto.tink.shaded.protobuf.j.h(0, b9.length, b9), f6.a.class)).b(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e9) {
            e = e9;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e10) {
            e = e10;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e11) {
            e = e11;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
