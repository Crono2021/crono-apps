package f4;

import java.util.ArrayDeque;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f3374a;

    public c(int i9) {
        switch (i9) {
            case 1:
                char[] cArr = n.f9951a;
                this.f3374a = new ArrayDeque(0);
                break;
            default:
                this.f3374a = new ArrayDeque();
                break;
        }
    }

    public b a() {
        b bVar;
        synchronized (this.f3374a) {
            bVar = (b) this.f3374a.poll();
        }
        return bVar == null ? new b() : bVar;
    }

    public void b(b bVar) {
        synchronized (this.f3374a) {
            try {
                if (this.f3374a.size() < 10) {
                    this.f3374a.offer(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void c(a4.c cVar) {
        cVar.f148b = null;
        cVar.f149c = null;
        this.f3374a.offer(cVar);
    }
}
