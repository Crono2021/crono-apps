package l0;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f5747a;

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f5747a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return d.c(d.a(d.b(locale)));
        }
        try {
            return c.a((Locale) f5747a.invoke(null, locale));
        } catch (IllegalAccessException e9) {
            Log.w("ICUCompat", e9);
            return c.a(locale);
        } catch (InvocationTargetException e10) {
            Log.w("ICUCompat", e10);
            return c.a(locale);
        }
    }
}
