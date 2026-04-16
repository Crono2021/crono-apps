package o4;

import android.os.Handler;
import android.os.Message;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements Handler.Callback {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7910i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f7911j;

    public /* synthetic */ g(Object obj, int i9) {
        this.f7910i = i9;
        this.f7911j = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f7910i) {
            case 0:
                h hVar = (h) this.f7911j;
                int i9 = message.what;
                if (i9 == 1) {
                    hVar.b((f) message.obj);
                    return true;
                }
                if (i9 == 2) {
                    hVar.f7915d.l((f) message.obj);
                }
                return false;
            default:
                if (message.what != 0) {
                    return false;
                }
                d.a aVar = (d.a) this.f7911j;
                if (message.obj != null) {
                    androidx.fragment.app.a.c();
                    return false;
                }
                synchronized (aVar.f2343a) {
                    throw null;
                }
        }
    }
}
