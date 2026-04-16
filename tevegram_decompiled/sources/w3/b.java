package w3;

import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends Animatable2.AnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h5.a f9855a;

    public b(h5.a aVar) {
        this.f9855a = aVar;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ColorStateList colorStateList = this.f9855a.f4029b.f4041w;
        if (colorStateList != null) {
            g0.b.h(drawable, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        h5.c cVar = this.f9855a.f4029b;
        ColorStateList colorStateList = cVar.f4041w;
        if (colorStateList != null) {
            g0.b.g(drawable, colorStateList.getColorForState(cVar.A, colorStateList.getDefaultColor()));
        }
    }
}
