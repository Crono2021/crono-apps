package g0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f3650a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable.ConstantState f3651b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f3652c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f3653d;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        int i9 = this.f3650a;
        Drawable.ConstantState constantState = this.f3651b;
        return i9 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        f fVar = new f();
        fVar.f3647l = this;
        Drawable.ConstantState constantState = this.f3651b;
        if (constantState != null) {
            fVar.h(constantState.newDrawable(resources));
        }
        f.a();
        return fVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return newDrawable(null);
    }
}
