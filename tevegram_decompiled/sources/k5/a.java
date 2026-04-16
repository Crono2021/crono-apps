package k5;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements View.OnTouchListener {

    /* renamed from: i, reason: collision with root package name */
    public final Dialog f5614i;

    /* renamed from: j, reason: collision with root package name */
    public final int f5615j;

    /* renamed from: k, reason: collision with root package name */
    public final int f5616k;

    /* renamed from: l, reason: collision with root package name */
    public final int f5617l;

    public a(Dialog dialog, Rect rect) {
        this.f5614i = dialog;
        this.f5615j = rect.left;
        this.f5616k = rect.top;
        this.f5617l = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = findViewById.getLeft() + this.f5615j;
        int width = findViewById.getWidth() + left;
        if (new RectF(left, findViewById.getTop() + this.f5616k, width, findViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            float f9 = (-this.f5617l) - 1;
            obtain.setLocation(f9, f9);
        }
        view.performClick();
        return this.f5614i.onTouchEvent(obtain);
    }
}
