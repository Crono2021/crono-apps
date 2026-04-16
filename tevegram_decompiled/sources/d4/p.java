package d4;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final s4.f f2893a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f2894b;

    public p(s4.f fVar, Executor executor) {
        this.f2893a = fVar;
        this.f2894b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f2893a.equals(((p) obj).f2893a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2893a.hashCode();
    }
}
