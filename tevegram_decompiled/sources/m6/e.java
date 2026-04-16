package m6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r6.w0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final Class f6658a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f6659b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f6660c;

    public e(Class cls, g6.f... fVarArr) {
        this.f6658a = cls;
        HashMap hashMap = new HashMap();
        for (g6.f fVar : fVarArr) {
            boolean containsKey = hashMap.containsKey(fVar.f3754a);
            Class cls2 = fVar.f3754a;
            if (containsKey) {
                androidx.fragment.app.a.g(cls2.getCanonicalName(), "KeyTypeManager constructed with duplicate factories for primitive ");
                throw null;
            }
            hashMap.put(cls2, fVar);
        }
        if (fVarArr.length > 0) {
            this.f6660c = fVarArr[0].f3754a;
        } else {
            this.f6660c = Void.class;
        }
        this.f6659b = Collections.unmodifiableMap(hashMap);
    }

    public int a() {
        return 1;
    }

    public abstract String b();

    public final Object c(com.google.crypto.tink.shaded.protobuf.a aVar, Class cls) {
        g6.f fVar = (g6.f) this.f6659b.get(cls);
        if (fVar != null) {
            return fVar.a(aVar);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public abstract b1.b d();

    public abstract w0 e();

    public abstract com.google.crypto.tink.shaded.protobuf.a f(com.google.crypto.tink.shaded.protobuf.j jVar);

    public abstract void g(com.google.crypto.tink.shaded.protobuf.a aVar);
}
