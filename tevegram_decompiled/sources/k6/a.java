package k6;

import f6.n;
import g6.f;
import g6.h;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import r6.f0;
import r6.r1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5620a = 0;

    static {
        f[] fVarArr = {new f(9, f6.c.class)};
        HashMap hashMap = new HashMap();
        f fVar = fVarArr[0];
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
            n.g(c.f5625b);
            if (j6.a.a()) {
                return;
            }
            n.e(new h(f0.class, new f[]{new f(9, f6.c.class)}, 8), true);
        } catch (GeneralSecurityException e9) {
            throw new ExceptionInInitializerError(e9);
        }
    }
}
