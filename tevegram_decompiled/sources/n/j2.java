package n;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j2 implements View.OnTouchListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k2 f6922i;

    public j2(k2 k2Var) {
        this.f6922i = k2Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        k2 k2Var = this.f6922i;
        g2 g2Var = k2Var.f6941z;
        Handler handler = k2Var.D;
        a0 a0Var = k2Var.H;
        int action = motionEvent.getAction();
        int x6 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (action == 0 && a0Var != null && a0Var.isShowing() && x6 >= 0 && x6 < a0Var.getWidth() && y2 >= 0 && y2 < a0Var.getHeight()) {
            handler.postDelayed(g2Var, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        handler.removeCallbacks(g2Var);
        return false;
    }
}
