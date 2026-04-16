package n8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final List f7503a;

    static {
        try {
            Iterator it = Arrays.asList(new j8.b()).iterator();
            it.getClass();
            f7503a = g8.d.Z(new g8.a(new g8.f(it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
