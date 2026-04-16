package b4;

import android.text.TextUtils;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: e, reason: collision with root package name */
    public static final u5.e f1326e = new u5.e(11);

    /* renamed from: a, reason: collision with root package name */
    public final Object f1327a;

    /* renamed from: b, reason: collision with root package name */
    public final g f1328b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1329c;

    /* renamed from: d, reason: collision with root package name */
    public volatile byte[] f1330d;

    public h(String str, Object obj, g gVar) {
        if (TextUtils.isEmpty(str)) {
            m7.c.n("Must not be null or empty");
            throw null;
        }
        this.f1329c = str;
        this.f1327a = obj;
        this.f1328b = gVar;
    }

    public static h a(Object obj, String str) {
        return new h(str, obj, f1326e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f1329c.equals(((h) obj).f1329c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1329c.hashCode();
    }

    public final String toString() {
        return androidx.activity.g.o(new StringBuilder("Option{key='"), this.f1329c, "'}");
    }
}
