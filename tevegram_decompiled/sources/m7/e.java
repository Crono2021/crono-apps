package m7;

import a8.l;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class e implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        String sb;
        StringBuilder sb2 = k.O;
        synchronized (sb2) {
            sb = sb2.toString();
            sb2.setLength(0);
            k.N = false;
        }
        Iterator it = k.M.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(sb);
        }
    }
}
