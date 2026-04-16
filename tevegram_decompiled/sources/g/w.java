package g;

import android.content.res.Configuration;
import android.os.LocaleList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class w {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales;
        LocaleList locales2;
        boolean equals;
        locales = configuration.getLocales();
        locales2 = configuration2.getLocales();
        equals = locales.equals(locales2);
        if (equals) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static j0.g b(Configuration configuration) {
        LocaleList locales;
        String languageTags;
        locales = configuration.getLocales();
        languageTags = locales.toLanguageTags();
        return j0.g.b(languageTags);
    }

    public static void c(j0.g gVar) {
        LocaleList forLanguageTags;
        forLanguageTags = LocaleList.forLanguageTags(gVar.f5342a.a());
        LocaleList.setDefault(forLanguageTags);
    }

    public static void d(Configuration configuration, j0.g gVar) {
        LocaleList forLanguageTags;
        forLanguageTags = LocaleList.forLanguageTags(gVar.f5342a.a());
        configuration.setLocales(forLanguageTags);
    }
}
