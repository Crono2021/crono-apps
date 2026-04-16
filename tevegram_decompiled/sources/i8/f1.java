package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f5266a = new ThreadLocal();

    public static f0 a() {
        ThreadLocal threadLocal = f5266a;
        f0 f0Var = (f0) threadLocal.get();
        if (f0Var != null) {
            return f0Var;
        }
        d dVar = new d(Thread.currentThread());
        threadLocal.set(dVar);
        return dVar;
    }
}
