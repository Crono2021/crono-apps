package i;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements Drawable.Callback {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4271i = 0;

    /* renamed from: j, reason: collision with root package name */
    public Object f4272j;

    public f(w3.d dVar) {
        this.f4272j = dVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        switch (this.f4271i) {
            case 0:
                break;
            default:
                ((w3.d) this.f4272j).invalidateSelf();
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        switch (this.f4271i) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f4272j;
                if (callback != null) {
                    callback.scheduleDrawable(drawable, runnable, j5);
                    break;
                }
                break;
            default:
                ((w3.d) this.f4272j).scheduleSelf(runnable, j5);
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        switch (this.f4271i) {
            case 0:
                Drawable.Callback callback = (Drawable.Callback) this.f4272j;
                if (callback != null) {
                    callback.unscheduleDrawable(drawable, runnable);
                    break;
                }
                break;
            default:
                ((w3.d) this.f4272j).unscheduleSelf(runnable);
                break;
        }
    }

    public /* synthetic */ f() {
    }

    private final void a(Drawable drawable) {
    }
}
