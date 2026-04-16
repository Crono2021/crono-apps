package j0;

import android.os.Build;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f5341b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    public final i f5342a;

    public g(i iVar) {
        this.f5342a = iVar;
    }

    public static g a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new g(new k(f.a(localeArr))) : new g(new h(localeArr));
    }

    public static g b(String str) {
        if (str == null || str.isEmpty()) {
            return f5341b;
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i9 = 0; i9 < length; i9++) {
            localeArr[i9] = e.a(split[i9]);
        }
        return a(localeArr);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f5342a.equals(((g) obj).f5342a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5342a.hashCode();
    }

    public final String toString() {
        return this.f5342a.toString();
    }
}
