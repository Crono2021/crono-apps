package r4;

import d4.l;
import d4.y;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final y f8549c = new y(Object.class, Object.class, Object.class, Collections.singletonList(new l(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new p4.d(0), null)), null);

    /* renamed from: a, reason: collision with root package name */
    public final s.d f8550a = new s.d();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f8551b = new AtomicReference();

    public final void a(Class cls, Class cls2, Class cls3, y yVar) {
        synchronized (this.f8550a) {
            s.d dVar = this.f8550a;
            w4.l lVar = new w4.l(cls, cls2, cls3);
            if (yVar == null) {
                yVar = f8549c;
            }
            dVar.put(lVar, yVar);
        }
    }
}
