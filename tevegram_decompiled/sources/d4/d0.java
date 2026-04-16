package d4;

import android.os.Handler;
import android.os.Message;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d0 implements Handler.Callback {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2824i;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f2824i) {
            case 0:
                if (message.what != 1) {
                    return false;
                }
                ((a0) message.obj).d();
                return true;
            default:
                int i9 = message.what;
                if (i9 == 0) {
                    message.obj.getClass();
                    androidx.fragment.app.a.c();
                    return false;
                }
                if (i9 != 1) {
                    return false;
                }
                message.obj.getClass();
                androidx.fragment.app.a.c();
                return false;
        }
    }
}
