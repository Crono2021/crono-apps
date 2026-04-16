package i8;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f5288b = AtomicIntegerFieldUpdater.newUpdater(m.class, "_handled");
    private volatile int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f5289a;

    public m(Throwable th, boolean z8) {
        this.f5289a = th;
        this._handled = z8 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f5289a + ']';
    }
}
