package j0;

import android.os.Build;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b {
    static {
        int i9 = Build.VERSION.SDK_INT;
        a aVar = a.f5336a;
        if (i9 >= 30) {
            aVar.a(30);
        }
        if (i9 >= 30) {
            aVar.a(31);
        }
        if (i9 >= 30) {
            aVar.a(33);
        }
        if (i9 >= 30) {
            aVar.a(1000000);
        }
    }

    public static final boolean a() {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 33) {
            return true;
        }
        if (i9 < 32) {
            return false;
        }
        String str = Build.VERSION.CODENAME;
        str.getClass();
        if ("REL".equals(str)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str.toUpperCase(locale);
        upperCase.getClass();
        String upperCase2 = "Tiramisu".toUpperCase(locale);
        upperCase2.getClass();
        return upperCase.compareTo(upperCase2) >= 0;
    }
}
