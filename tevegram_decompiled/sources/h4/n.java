package h4;

import java.util.ArrayDeque;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends w4.j {
    @Override // w4.j
    public final void c(Object obj, Object obj2) {
        o oVar = (o) obj;
        oVar.getClass();
        ArrayDeque arrayDeque = o.f3998b;
        synchronized (arrayDeque) {
            arrayDeque.offer(oVar);
        }
    }
}
