package y;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m extends View {
    public m(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i9) {
        d dVar = (d) getLayoutParams();
        dVar.f10231a = i9;
        setLayoutParams(dVar);
    }

    public void setGuidelineEnd(int i9) {
        d dVar = (d) getLayoutParams();
        dVar.f10233b = i9;
        setLayoutParams(dVar);
    }

    public void setGuidelinePercent(float f9) {
        d dVar = (d) getLayoutParams();
        dVar.f10235c = f9;
        setLayoutParams(dVar);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
    }
}
