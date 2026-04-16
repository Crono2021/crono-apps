package o;

import com.bumptech.glide.d;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends d {

    /* renamed from: g, reason: collision with root package name */
    public static volatile a f7544g;

    /* renamed from: f, reason: collision with root package name */
    public final Object f7545f;

    public a(int i9) {
        switch (i9) {
            case 1:
                this.f7545f = new Object();
                Executors.newFixedThreadPool(4, new b());
                break;
            default:
                this.f7545f = new a(1);
                break;
        }
    }

    public static a g0() {
        if (f7544g != null) {
            return f7544g;
        }
        synchronized (a.class) {
            try {
                if (f7544g == null) {
                    f7544g = new a(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f7544g;
    }
}
