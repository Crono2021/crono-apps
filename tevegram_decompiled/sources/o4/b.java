package o4;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7888a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7889b;

    public /* synthetic */ b(Object obj, int i9) {
        this.f7888a = i9;
        this.f7889b = obj;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.f7888a) {
            case 1:
                return ((Drawable.ConstantState) this.f7889b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.f7888a) {
            case 0:
                return 0;
            default:
                return ((Drawable.ConstantState) this.f7889b).getChangingConfigurations();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        switch (this.f7888a) {
            case 0:
                return new c(this);
            default:
                w3.d dVar = new w3.d(null, 0);
                Drawable newDrawable = ((Drawable.ConstantState) this.f7889b).newDrawable();
                dVar.f9868i = newDrawable;
                newDrawable.setCallback(dVar.f9865n);
                return dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        switch (this.f7888a) {
            case 0:
                return new c(this);
            default:
                w3.d dVar = new w3.d(null, 0);
                Drawable newDrawable = ((Drawable.ConstantState) this.f7889b).newDrawable(resources);
                dVar.f9868i = newDrawable;
                newDrawable.setCallback(dVar.f9865n);
                return dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.f7888a) {
            case 1:
                w3.d dVar = new w3.d(null, 0);
                Drawable newDrawable = ((Drawable.ConstantState) this.f7889b).newDrawable(resources, theme);
                dVar.f9868i = newDrawable;
                newDrawable.setCallback(dVar.f9865n);
                return dVar;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
