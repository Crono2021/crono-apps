package androidx.lifecycle;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f897a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f898b;

    public b(Method method, int i9) {
        this.f897a = i9;
        this.f898b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f897a == bVar.f897a && this.f898b.getName().equals(bVar.f898b.getName());
    }

    public final int hashCode() {
        return this.f898b.getName().hashCode() + (this.f897a * 31);
    }
}
