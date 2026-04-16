package n8;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final j8.d f7529a;

    static {
        String str;
        int i9 = v.f7535a;
        Object obj = null;
        try {
            str = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null) {
            Boolean.parseBoolean(str);
        }
        try {
            Iterator it = Arrays.asList(new j8.a()).iterator();
            it.getClass();
            Iterator it2 = g8.d.Z(new g8.a(new g8.f(it))).iterator();
            if (it2.hasNext()) {
                obj = it2.next();
                if (it2.hasNext()) {
                    ((j8.a) obj).getClass();
                    do {
                        ((j8.a) it2.next()).getClass();
                    } while (it2.hasNext());
                }
            }
            if (((j8.a) obj) == null) {
                m7.c.p("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                f7529a = new j8.d(j8.e.a(mainLooper), false);
            } else {
                m7.c.p("The main looper is not available");
            }
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
