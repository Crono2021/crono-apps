package n6;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import r6.r1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class l {
    static {
        g6.f[] fVarArr = {new g6.f(11, f6.j.class)};
        HashMap hashMap = new HashMap();
        g6.f fVar = fVarArr[0];
        boolean containsKey = hashMap.containsKey(fVar.f3754a);
        Class cls = fVar.f3754a;
        if (containsKey) {
            androidx.fragment.app.a.g(cls.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
            return;
        }
        hashMap.put(cls, fVar);
        Class cls2 = fVarArr[0].f3754a;
        Collections.unmodifiableMap(hashMap);
        int i9 = r1.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e9) {
            throw new ExceptionInInitializerError(e9);
        }
    }

    public static void a() {
        f6.n.g(o.f7479c);
        f6.n.g(h.f7463a);
        f6.n.e(new b(), true);
        m6.l lVar = k.f7470a;
        m6.j jVar = m6.j.f6666b;
        jVar.e(k.f7470a);
        jVar.d(k.f7471b);
        jVar.c(k.f7472c);
        jVar.b(k.f7473d);
        m6.i iVar = m6.i.f6664b;
        iVar.a(b.f7440f);
        if (j6.a.a()) {
            return;
        }
        f6.n.e(new b(r6.b.class, new g6.f[]{new g6.f(10, f6.j.class)}), true);
        jVar.e(e.f7459a);
        jVar.d(e.f7460b);
        jVar.c(e.f7461c);
        jVar.b(e.f7462d);
        iVar.a(b.f7439e);
    }
}
