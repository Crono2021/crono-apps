package p6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f8254b = new a(Collections.unmodifiableMap(new HashMap()));

    /* renamed from: a, reason: collision with root package name */
    public final Map f8255a;

    public a(Map map) {
        this.f8255a = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f8255a.equals(((a) obj).f8255a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8255a.hashCode();
    }

    public final String toString() {
        return this.f8255a.toString();
    }
}
