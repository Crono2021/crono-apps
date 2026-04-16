package p8;

import i8.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends g {

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f8288k;

    public i(Runnable runnable, long j5, h hVar) {
        super(j5, hVar);
        this.f8288k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f8288k.run();
        } finally {
            this.f8286j.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f8288k;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(w.f(runnable));
        sb.append(", ");
        sb.append(this.f8285i);
        sb.append(", ");
        sb.append(this.f8286j);
        sb.append(']');
        return sb.toString();
    }
}
