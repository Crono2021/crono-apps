package n;

import android.os.Build;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e3 {

    /* renamed from: a, reason: collision with root package name */
    public Method f6857a;

    /* renamed from: b, reason: collision with root package name */
    public Method f6858b;

    /* renamed from: c, reason: collision with root package name */
    public Method f6859c;

    public e3(Method method, Method method2, Method method3) {
        this.f6857a = method;
        this.f6858b = method2;
        this.f6859c = method3;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
