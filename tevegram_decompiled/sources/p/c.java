package p;

import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Map.Entry {

    /* renamed from: i, reason: collision with root package name */
    public final Object f8082i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f8083j;

    /* renamed from: k, reason: collision with root package name */
    public c f8084k;

    /* renamed from: l, reason: collision with root package name */
    public c f8085l;

    public c(Object obj, Object obj2) {
        this.f8082i = obj;
        this.f8083j = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f8082i.equals(cVar.f8082i) && this.f8083j.equals(cVar.f8083j);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f8082i;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f8083j;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f8082i.hashCode() ^ this.f8083j.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f8082i + "=" + this.f8083j;
    }
}
