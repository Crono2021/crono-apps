package y;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class p extends b {

    /* renamed from: o, reason: collision with root package name */
    public boolean f10345o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10346p;

    @Override // y.b
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f10338b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = obtainStyledAttributes.getIndex(i9);
                if (index == 6) {
                    this.f10345o = true;
                } else if (index == 13) {
                    this.f10346p = true;
                }
            }
        }
    }

    public abstract void h(w.g gVar, int i9, int i10);

    @Override // y.b, android.view.View
    public final void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.f10345o || this.f10346p) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i9 = 0; i9 < this.f10225j; i9++) {
                View view = (View) constraintLayout.f534i.get(this.f10224i[i9]);
                if (view != null) {
                    if (this.f10345o) {
                        view.setVisibility(visibility);
                    }
                    if (this.f10346p && elevation > 0.0f) {
                        view.setTranslationZ(view.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f9) {
        super.setElevation(f9);
        c();
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
        c();
    }
}
