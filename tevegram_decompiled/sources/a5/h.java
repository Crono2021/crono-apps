package a5;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class h extends j {

    /* renamed from: c, reason: collision with root package name */
    public g f183c;

    /* renamed from: d, reason: collision with root package name */
    public OverScroller f184d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f185e;

    /* renamed from: f, reason: collision with root package name */
    public int f186f;

    /* renamed from: g, reason: collision with root package name */
    public int f187g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public VelocityTracker f188i;

    @Override // a0.d
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        View view2;
        int findPointerIndex;
        if (this.h < 0) {
            this.h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f185e) {
            int i9 = this.f186f;
            if (i9 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i9)) != -1) {
                int y2 = (int) motionEvent.getY(findPointerIndex);
                if (Math.abs(y2 - this.f187g) > this.h) {
                    this.f187g = y2;
                    return true;
                }
            }
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f186f = -1;
            int x6 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            WeakReference weakReference = ((AppBarLayout.BaseBehavior) this).f1883n;
            boolean z8 = (weakReference == null || !((view2 = (View) weakReference.get()) == null || !view2.isShown() || view2.canScrollVertically(-1))) && coordinatorLayout.o(view, x6, y3);
            this.f185e = z8;
            if (z8) {
                this.f187g = y3;
                this.f186f = motionEvent.getPointerId(0);
                if (this.f188i == null) {
                    this.f188i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f184d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f184d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f188i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ec  */
    @Override // a0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(androidx.coordinatorlayout.widget.CoordinatorLayout r21, android.view.View r22, android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.h.r(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract int u();

    public abstract int v(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11);

    public final void w(CoordinatorLayout coordinatorLayout, View view, int i9) {
        v(coordinatorLayout, view, i9, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
