package x5;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends u5.f {

    /* renamed from: q, reason: collision with root package name */
    public final RectF f10117q;

    public e(e eVar) {
        super(eVar);
        this.f10117q = eVar.f10117q;
    }

    @Override // u5.f, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        f fVar = new f(this);
        fVar.F = this;
        fVar.invalidateSelf();
        return fVar;
    }

    public e(u5.j jVar, RectF rectF) {
        super(jVar);
        this.f10117q = rectF;
    }
}
