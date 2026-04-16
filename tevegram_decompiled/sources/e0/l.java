package e0;

import android.content.res.Resources;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f2996a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f2997b;

    public l(Resources resources, Resources.Theme theme) {
        this.f2996a = resources;
        this.f2997b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (this.f2996a.equals(lVar.f2996a) && m0.a.a(this.f2997b, lVar.f2997b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return m0.a.b(this.f2996a, this.f2997b);
    }
}
