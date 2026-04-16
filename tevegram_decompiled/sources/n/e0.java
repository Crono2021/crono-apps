package n;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 extends RatingBar {

    /* renamed from: i, reason: collision with root package name */
    public final c0 f6849i;

    public e0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969448);
        m3.a(this, getContext());
        c0 c0Var = new c0(this);
        this.f6849i = c0Var;
        c0Var.b(attributeSet, 2130969448);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        Bitmap bitmap = (Bitmap) this.f6849i.f6818c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i9, 0), getMeasuredHeight());
        }
    }
}
