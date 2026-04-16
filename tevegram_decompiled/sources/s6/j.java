package s6;

import g1.o;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f8887a;

    public j(o oVar) {
        this.f8887a = oVar;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        o oVar = this.f8887a;
        try {
            i iVar = i.f8885c;
            Mac mac = (Mac) iVar.f8886a.a((String) oVar.f3694k);
            mac.init((SecretKeySpec) oVar.f3695l);
            return mac;
        } catch (GeneralSecurityException e9) {
            throw new IllegalStateException(e9);
        }
    }
}
