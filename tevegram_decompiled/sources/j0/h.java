package j0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h implements i {

    /* renamed from: c, reason: collision with root package name */
    public static final Locale[] f5343c = new Locale[0];

    /* renamed from: a, reason: collision with root package name */
    public final Locale[] f5344a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5345b;

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        g gVar = g.f5341b;
        String[] split = "en-Latn".split("-", -1);
        if (split.length > 2) {
            new Locale(split[0], split[1], split[2]);
            return;
        }
        if (split.length > 1) {
            new Locale(split[0], split[1]);
        } else if (split.length == 1) {
            new Locale(split[0]);
        } else {
            m7.c.n("Can not parse language tag: [en-Latn]");
        }
    }

    public h(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f5344a = f5343c;
            this.f5345b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i9 = 0; i9 < localeArr.length; i9++) {
            Locale locale = localeArr[i9];
            if (locale == null) {
                throw new NullPointerException("list[" + i9 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                sb.append(locale2.getLanguage());
                String country = locale2.getCountry();
                if (country != null && !country.isEmpty()) {
                    sb.append('-');
                    sb.append(locale2.getCountry());
                }
                if (i9 < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f5344a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f5345b = sb.toString();
    }

    @Override // j0.i
    public final String a() {
        return this.f5345b;
    }

    @Override // j0.i
    public final Object b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        Locale[] localeArr = ((h) obj).f5344a;
        Locale[] localeArr2 = this.f5344a;
        if (localeArr2.length != localeArr.length) {
            return false;
        }
        for (int i9 = 0; i9 < localeArr2.length; i9++) {
            if (!localeArr2[i9].equals(localeArr[i9])) {
                return false;
            }
        }
        return true;
    }

    @Override // j0.i
    public final Locale get(int i9) {
        if (i9 < 0) {
            return null;
        }
        Locale[] localeArr = this.f5344a;
        if (i9 < localeArr.length) {
            return localeArr[i9];
        }
        return null;
    }

    public final int hashCode() {
        int i9 = 1;
        for (Locale locale : this.f5344a) {
            i9 = (i9 * 31) + locale.hashCode();
        }
        return i9;
    }

    @Override // j0.i
    public final boolean isEmpty() {
        return this.f5344a.length == 0;
    }

    @Override // j0.i
    public final int size() {
        return this.f5344a.length;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int i9 = 0;
        while (true) {
            Locale[] localeArr = this.f5344a;
            if (i9 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i9]);
            if (i9 < localeArr.length - 1) {
                sb.append(',');
            }
            i9++;
        }
    }
}
