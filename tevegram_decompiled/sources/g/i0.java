package g;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i0 implements Executor {

    /* renamed from: i, reason: collision with root package name */
    public final Object f3564i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayDeque f3565j = new ArrayDeque();

    /* renamed from: k, reason: collision with root package name */
    public final j0 f3566k;

    /* renamed from: l, reason: collision with root package name */
    public Runnable f3567l;

    public i0(j0 j0Var) {
        this.f3566k = j0Var;
    }

    public final void a() {
        synchronized (this.f3564i) {
            try {
                Runnable runnable = (Runnable) this.f3565j.poll();
                this.f3567l = runnable;
                if (runnable != null) {
                    this.f3566k.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f3564i) {
            try {
                this.f3565j.add(new b2.f0(this, 6, runnable));
                if (this.f3567l == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
