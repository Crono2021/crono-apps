package d7;

import b8.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final String f2964p;

    /* renamed from: q, reason: collision with root package name */
    public final String f2965q;

    public a(String str, String str2) {
        this.f2964p = str;
        this.f2965q = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2964p.equals(aVar.f2964p) && i.a(this.f2965q, aVar.f2965q);
    }

    public final int hashCode() {
        int hashCode = this.f2964p.hashCode() * 31;
        String str = this.f2965q;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "Join(url=" + this.f2964p + ", customTitle=" + this.f2965q + ")";
    }
}
