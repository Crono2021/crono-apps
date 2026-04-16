package androidx.fragment.app;

import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final s.h f695b = new s.h();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f696a;

    public b0(h0 h0Var) {
        this.f696a = h0Var;
    }

    public static Class b(ClassLoader classLoader, String str) {
        s.h hVar = f695b;
        s.h hVar2 = (s.h) hVar.getOrDefault(classLoader, null);
        if (hVar2 == null) {
            hVar2 = new s.h();
            hVar.put(classLoader, hVar2);
        }
        Class cls = (Class) hVar2.getOrDefault(str, null);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        hVar2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e9) {
            throw new r(androidx.activity.g.n("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e9);
        } catch (ClassNotFoundException e10) {
            throw new r(androidx.activity.g.n("Unable to instantiate fragment ", str, ": make sure class name exists"), e10);
        }
    }

    public final s a(String str) {
        try {
            return (s) c(this.f696a.f748n.f872p.getClassLoader(), str).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e9) {
            throw new r(androidx.activity.g.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e9);
        } catch (InstantiationException e10) {
            throw new r(androidx.activity.g.n("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e10);
        } catch (NoSuchMethodException e11) {
            throw new r(androidx.activity.g.n("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e11);
        } catch (InvocationTargetException e12) {
            throw new r(androidx.activity.g.n("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e12);
        }
    }
}
