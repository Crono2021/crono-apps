package g1;

import android.os.Message;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public Message f3706a;

    public final void a() {
        this.f3706a = null;
        ArrayList arrayList = t.f3707b;
        synchronized (arrayList) {
            try {
                if (arrayList.size() < 50) {
                    arrayList.add(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        Message message = this.f3706a;
        message.getClass();
        message.sendToTarget();
        a();
    }
}
