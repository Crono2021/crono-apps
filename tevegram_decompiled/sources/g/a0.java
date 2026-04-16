package g;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 extends ContentFrameLayout {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ c0 f3449q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(c0 c0Var, l.d dVar) {
        super(dVar, null);
        this.f3449q = c0Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f3449q.u(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x6 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (x6 < -5 || y2 < -5 || x6 > getWidth() + 5 || y2 > getHeight() + 5) {
                c0 c0Var = this.f3449q;
                c0Var.s(c0Var.A(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i9) {
        setBackgroundDrawable(android.support.v4.media.session.b.I(getContext(), i9));
    }
}
