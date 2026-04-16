package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f899c = new c();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f900a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f901b = new HashMap();

    public static void b(HashMap hashMap, b bVar, l lVar, Class cls) {
        l lVar2 = (l) hashMap.get(bVar);
        if (lVar2 == null || lVar == lVar2) {
            if (lVar2 == null) {
                hashMap.put(bVar, lVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f898b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + lVar2 + ", new value " + lVar);
    }

    public final a a(Class cls, Method[] methodArr) {
        int i9;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = this.f900a;
        if (superclass != null) {
            a aVar = (a) hashMap2.get(superclass);
            if (aVar == null) {
                aVar = a(superclass, null);
            }
            hashMap.putAll(aVar.f896b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            a aVar2 = (a) hashMap2.get(cls2);
            if (aVar2 == null) {
                aVar2 = a(cls2, null);
            }
            for (Map.Entry entry : aVar2.f896b.entrySet()) {
                b(hashMap, (b) entry.getKey(), (l) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e9) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e9);
            }
        }
        boolean z8 = false;
        for (Method method : methodArr) {
            z zVar = (z) method.getAnnotation(z.class);
            if (zVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i9 = 0;
                } else {
                    if (!s.class.isAssignableFrom(parameterTypes[0])) {
                        m7.c.n("invalid parameter type. Must be one and instanceof LifecycleOwner");
                        return null;
                    }
                    i9 = 1;
                }
                l value = zVar.value();
                if (parameterTypes.length > 1) {
                    if (!l.class.isAssignableFrom(parameterTypes[1])) {
                        m7.c.n("invalid parameter type. second arg must be an event");
                        return null;
                    }
                    if (value != l.ON_ANY) {
                        m7.c.n("Second arg is supported only for ON_ANY value");
                        return null;
                    }
                    i9 = 2;
                }
                if (parameterTypes.length > 2) {
                    m7.c.n("cannot have more than 2 params");
                    return null;
                }
                b(hashMap, new b(method, i9), value, cls);
                z8 = true;
            }
        }
        a aVar3 = new a(hashMap);
        hashMap2.put(cls, aVar3);
        this.f901b.put(cls, Boolean.valueOf(z8));
        return aVar3;
    }
}
