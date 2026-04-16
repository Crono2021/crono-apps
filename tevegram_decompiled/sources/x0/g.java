package x0;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.emoji2.text.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final f f10034p;

    public g(TextView textView) {
        this.f10034p = new f(textView);
    }

    @Override // com.bumptech.glide.c
    public final boolean E() {
        return this.f10034p.f10033r;
    }

    @Override // com.bumptech.glide.c
    public final void T(boolean z8) {
        if (l.f624j != null) {
            this.f10034p.T(z8);
        }
    }

    @Override // com.bumptech.glide.c
    public final void U(boolean z8) {
        boolean z9 = l.f624j != null;
        f fVar = this.f10034p;
        if (z9) {
            fVar.U(z8);
        } else {
            fVar.f10033r = z8;
        }
    }

    @Override // com.bumptech.glide.c
    public final TransformationMethod Y(TransformationMethod transformationMethod) {
        return !(l.f624j != null) ? transformationMethod : this.f10034p.Y(transformationMethod);
    }

    @Override // com.bumptech.glide.c
    public final InputFilter[] y(InputFilter[] inputFilterArr) {
        return !(l.f624j != null) ? inputFilterArr : this.f10034p.y(inputFilterArr);
    }
}
