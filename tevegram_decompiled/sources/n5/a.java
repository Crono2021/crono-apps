package n5;

import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.imageview.ShapeableImageView;
import u5.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f7435a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShapeableImageView f7436b;

    public a(ShapeableImageView shapeableImageView) {
        this.f7436b = shapeableImageView;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        ShapeableImageView shapeableImageView = this.f7436b;
        if (shapeableImageView.f2091t == null) {
            return;
        }
        if (shapeableImageView.f2090s == null) {
            shapeableImageView.f2090s = new g(shapeableImageView.f2091t);
        }
        RectF rectF = shapeableImageView.f2084m;
        Rect rect = this.f7435a;
        rectF.round(rect);
        shapeableImageView.f2090s.setBounds(rect);
        shapeableImageView.f2090s.getOutline(outline);
    }
}
