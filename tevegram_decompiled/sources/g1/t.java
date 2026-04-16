package g1;

import android.os.Handler;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t {

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f3707b = new ArrayList(50);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f3708a;

    public t(Handler handler) {
        this.f3708a = handler;
    }

    public static s b() {
        s sVar;
        ArrayList arrayList = f3707b;
        synchronized (arrayList) {
            try {
                sVar = arrayList.isEmpty() ? new s() : (s) arrayList.remove(arrayList.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    public final s a(int i9, Object obj) {
        s b9 = b();
        b9.f3706a = this.f3708a.obtainMessage(i9, obj);
        return b9;
    }

    public final void c(Runnable runnable) {
        this.f3708a.post(runnable);
    }

    public final void d(int i9) {
        this.f3708a.sendEmptyMessage(i9);
    }
}
