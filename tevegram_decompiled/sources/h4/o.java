package h4;

import java.util.ArrayDeque;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayDeque f3998b;

    /* renamed from: a, reason: collision with root package name */
    public Object f3999a;

    static {
        char[] cArr = w4.n.f9951a;
        f3998b = new ArrayDeque(0);
    }

    public static o a(Object obj) {
        o oVar;
        ArrayDeque arrayDeque = f3998b;
        synchronized (arrayDeque) {
            oVar = (o) arrayDeque.poll();
        }
        if (oVar == null) {
            oVar = new o();
        }
        oVar.f3999a = obj;
        return oVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof o) && this.f3999a.equals(((o) obj).f3999a);
    }

    public final int hashCode() {
        return this.f3999a.hashCode();
    }
}
