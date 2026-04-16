package f6;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f3417b = Logger.getLogger(e.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f3418a;

    public e(e eVar) {
        this.f3418a = new ConcurrentHashMap(eVar.f3418a);
    }

    public final synchronized d a(String str) {
        if (!this.f3418a.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return (d) this.f3418a.get(str);
    }

    public final synchronized void b(m6.e eVar) {
        int a9 = eVar.a();
        if (!(a9 != 1 ? androidx.activity.g.e(a9) : androidx.activity.g.d(a9))) {
            throw new GeneralSecurityException("failed to register key manager " + eVar.getClass() + " as it is not FIPS compatible.");
        }
        c(new d(eVar));
    }

    public final synchronized void c(d dVar) {
        m6.e eVar = dVar.f3416a;
        Class cls = eVar.f6660c;
        if (!eVar.f6659b.keySet().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException("Given internalKeyMananger " + eVar.toString() + " does not support primitive class " + cls.getName());
        }
        String b9 = eVar.b();
        d dVar2 = (d) this.f3418a.get(b9);
        if (dVar2 != null && !dVar2.f3416a.getClass().equals(dVar.f3416a.getClass())) {
            f3417b.warning("Attempted overwrite of a registered key manager for key type ".concat(b9));
            throw new GeneralSecurityException("typeUrl (" + b9 + ") is already registered with " + dVar2.f3416a.getClass().getName() + ", cannot be re-registered with " + dVar.f3416a.getClass().getName());
        }
        this.f3418a.putIfAbsent(b9, dVar);
    }

    public e() {
        this.f3418a = new ConcurrentHashMap();
    }
}
