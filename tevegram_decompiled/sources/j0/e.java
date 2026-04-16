package j0;

import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Locale[] f5340a = {new Locale("en", "XA"), new Locale("ar", "XB")};

    public static Locale a(String str) {
        return Locale.forLanguageTag(str);
    }

    public static boolean b(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return true;
        }
        if (locale.getLanguage().equals(locale2.getLanguage())) {
            Locale[] localeArr = f5340a;
            int length = localeArr.length;
            int i9 = 0;
            while (true) {
                if (i9 >= length) {
                    int length2 = localeArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            String a9 = l0.e.a(locale);
                            if (!a9.isEmpty()) {
                                return a9.equals(l0.e.a(locale2));
                            }
                            String country = locale.getCountry();
                            if (country.isEmpty() || country.equals(locale2.getCountry())) {
                                return true;
                            }
                        } else {
                            if (localeArr[i10].equals(locale2)) {
                                break;
                            }
                            i10++;
                        }
                    }
                } else {
                    if (localeArr[i9].equals(locale)) {
                        break;
                    }
                    i9++;
                }
            }
        }
        return false;
    }
}
