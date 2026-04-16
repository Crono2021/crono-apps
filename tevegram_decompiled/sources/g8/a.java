package g8;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f3844a;

    public a(f fVar) {
        this.f3844a = new AtomicReference(fVar);
    }

    @Override // g8.b
    public final Iterator iterator() {
        b bVar = (b) this.f3844a.getAndSet(null);
        if (bVar != null) {
            return bVar.iterator();
        }
        m7.c.p("This sequence can be consumed only once.");
        return null;
    }
}
