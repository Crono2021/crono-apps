package v7;

import b8.i;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f9588a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        methods.getClass();
        int length = methods.length;
        int i9 = 0;
        while (true) {
            method = null;
            if (i9 >= length) {
                break;
            }
            Method method2 = methods[i9];
            if (i.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                parameterTypes.getClass();
                if (i.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i9++;
        }
        f9588a = method;
        int length2 = methods.length;
        for (int i10 = 0; i10 < length2 && !i.a(methods[i10].getName(), "getSuppressed"); i10++) {
        }
    }
}
