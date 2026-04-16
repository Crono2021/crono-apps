package d7;

import androidx.activity.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final String f2967p;

    public c(String str) {
        this.f2967p = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.f2967p.equals(((c) obj).f2967p);
    }

    public final int hashCode() {
        return this.f2967p.hashCode();
    }

    public final String toString() {
        return g.n("SecureLink(token=", this.f2967p, ")");
    }
}
