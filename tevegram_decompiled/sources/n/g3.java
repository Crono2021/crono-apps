package n;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g3 extends TouchDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final View f6869a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f6870b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f6871c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f6872d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6873e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6874f;

    public g3(Rect rect, Rect rect2, View view) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f6873e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f6870b = rect3;
        Rect rect4 = new Rect();
        this.f6872d = rect4;
        Rect rect5 = new Rect();
        this.f6871c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i9 = -scaledTouchSlop;
        rect4.inset(i9, i9);
        rect5.set(rect2);
        this.f6869a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z8;
        boolean z9;
        int x6 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z9 = this.f6874f;
                if (z9 && !this.f6872d.contains(x6, y2)) {
                    z10 = z9;
                    z8 = false;
                }
            } else {
                if (action == 3) {
                    z9 = this.f6874f;
                    this.f6874f = false;
                }
                z8 = true;
                z10 = false;
            }
            z10 = z9;
            z8 = true;
        } else {
            if (this.f6870b.contains(x6, y2)) {
                this.f6874f = true;
                z8 = true;
            }
            z8 = true;
            z10 = false;
        }
        if (!z10) {
            return false;
        }
        Rect rect = this.f6871c;
        View view = this.f6869a;
        if (!z8 || rect.contains(x6, y2)) {
            motionEvent.setLocation(x6 - rect.left, y2 - rect.top);
        } else {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
