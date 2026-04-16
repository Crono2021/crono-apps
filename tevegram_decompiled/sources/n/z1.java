package n;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z1 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7127i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a2 f7128j;

    public /* synthetic */ z1(a2 a2Var, int i9) {
        this.f7127i = i9;
        this.f7128j = a2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7127i) {
            case 0:
                ViewParent parent = this.f7128j.f6779l.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                a2 a2Var = this.f7128j;
                a2Var.a();
                View view = a2Var.f6779l;
                if (view.isEnabled() && !view.isLongClickable() && a2Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    a2Var.f6782o = true;
                    break;
                }
                break;
        }
    }
}
