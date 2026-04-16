package n;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g0 extends SeekBar {

    /* renamed from: i, reason: collision with root package name */
    public final h0 f6866i;

    public g0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969476);
        m3.a(this, getContext());
        h0 h0Var = new h0(this);
        this.f6866i = h0Var;
        h0Var.b(attributeSet, 2130969476);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        h0 h0Var = this.f6866i;
        g0 g0Var = h0Var.f6877e;
        Drawable drawable = h0Var.f6878f;
        if (drawable != null && drawable.isStateful() && drawable.setState(g0Var.getDrawableState())) {
            g0Var.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6866i.f6878f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f6866i.g(canvas);
    }
}
