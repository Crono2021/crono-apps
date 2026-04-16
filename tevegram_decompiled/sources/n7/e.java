package n7;

import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public a8.a f7483i;

    /* renamed from: j, reason: collision with root package name */
    public volatile Object f7484j = g.f7489b;

    /* renamed from: k, reason: collision with root package name */
    public final Object f7485k = this;

    public e(a8.a aVar) {
        this.f7483i = aVar;
    }

    public final Object a() {
        Object obj;
        Object obj2 = this.f7484j;
        g gVar = g.f7489b;
        if (obj2 != gVar) {
            return obj2;
        }
        synchronized (this.f7485k) {
            obj = this.f7484j;
            if (obj == gVar) {
                a8.a aVar = this.f7483i;
                aVar.getClass();
                obj = aVar.d();
                this.f7484j = obj;
                this.f7483i = null;
            }
        }
        return obj;
    }

    public final String toString() {
        return this.f7484j != g.f7489b ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
