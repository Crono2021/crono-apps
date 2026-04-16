package m0;

import android.graphics.Rect;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f6494a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f6495b;

    public b(Rect rect, Rect rect2) {
        this.f6494a = rect;
        this.f6495b = rect2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a.a(bVar.f6494a, this.f6494a) && a.a(bVar.f6495b, this.f6495b);
    }

    public final int hashCode() {
        return this.f6494a.hashCode() ^ this.f6495b.hashCode();
    }

    public final String toString() {
        return "Pair{" + this.f6494a + " " + this.f6495b + "}";
    }
}
