package g6;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s extends b {
    public static s b(j jVar, i7.x xVar, Integer num) {
        t6.a aVar = (t6.a) xVar.f5179j;
        j jVar2 = j.f3768n;
        if (jVar != jVar2 && num == null) {
            androidx.fragment.app.a.q(jVar, " the value of idRequirement must be non-null", "For given Variant ");
            return null;
        }
        if (jVar == jVar2 && num != null) {
            androidx.fragment.app.a.o("For given Variant NO_PREFIX the value of idRequirement must be null");
            return null;
        }
        if (aVar.f8980a.length != 32) {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + aVar.f8980a.length);
        }
        if (jVar == jVar2) {
            t6.a.a(new byte[0]);
        } else if (jVar == j.f3767m) {
            t6.a.a(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (jVar != j.f3766l) {
                androidx.fragment.app.a.r(jVar, "Unknown Variant: ");
                return null;
            }
            t6.a.a(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        return new s();
    }
}
