package g0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends Drawable implements Drawable.Callback, e {

    /* renamed from: o, reason: collision with root package name */
    public static final PorterDuff.Mode f3642o = PorterDuff.Mode.SRC_IN;

    /* renamed from: p, reason: collision with root package name */
    public static Method f3643p;

    /* renamed from: i, reason: collision with root package name */
    public int f3644i;

    /* renamed from: j, reason: collision with root package name */
    public PorterDuff.Mode f3645j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3646k;

    /* renamed from: l, reason: collision with root package name */
    public g f3647l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3648m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f3649n;

    public static void a() {
        if (f3643p == null) {
            try {
                f3643p = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception e9) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e9);
            }
        }
    }

    public final boolean b() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f3649n;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final g c() {
        g gVar = this.f3647l;
        g gVar2 = new g();
        gVar2.f3652c = null;
        gVar2.f3653d = f3642o;
        if (gVar != null) {
            gVar2.f3650a = gVar.f3650a;
            gVar2.f3651b = gVar.f3651b;
            gVar2.f3652c = gVar.f3652c;
            gVar2.f3653d = gVar.f3653d;
        }
        return gVar2;
    }

    public final boolean d(int[] iArr) {
        return i(iArr) || this.f3649n.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.f3649n.draw(canvas);
    }

    public final void e(int i9) {
        setTintList(ColorStateList.valueOf(i9));
    }

    public final void f(ColorStateList colorStateList) {
        this.f3647l.f3652c = colorStateList;
        i(this.f3649n.getState());
    }

    public final void g(PorterDuff.Mode mode) {
        this.f3647l.f3653d = mode;
        i(this.f3649n.getState());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        g gVar = this.f3647l;
        return changingConfigurations | (gVar != null ? gVar.getChangingConfigurations() : 0) | this.f3649n.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        g gVar = this.f3647l;
        if (gVar == null || gVar.f3651b == null) {
            return null;
        }
        gVar.f3650a = getChangingConfigurations();
        return this.f3647l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f3649n.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final Rect getDirtyBounds() {
        return this.f3649n.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f3649n.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f3649n.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getLayoutDirection() {
        return com.bumptech.glide.d.F(this.f3649n);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f3649n.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f3649n.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f3649n.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        this.f3649n.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        return this.f3649n.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.f3649n.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        return this.f3649n.getTransparentRegion();
    }

    public final void h(Drawable drawable) {
        Drawable drawable2 = this.f3649n;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f3649n = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            g gVar = this.f3647l;
            if (gVar != null) {
                gVar.f3651b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public final boolean i(int[] iArr) {
        if (b()) {
            g gVar = this.f3647l;
            ColorStateList colorStateList = gVar.f3652c;
            PorterDuff.Mode mode = gVar.f3653d;
            if (colorStateList == null || mode == null) {
                this.f3646k = false;
                clearColorFilter();
                return false;
            }
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f3646k || colorForState != this.f3644i || mode != this.f3645j) {
                setColorFilter(colorForState, mode);
                this.f3644i = colorForState;
                this.f3645j = mode;
                this.f3646k = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return a.d(this.f3649n);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isProjected() {
        Method method;
        Drawable drawable = this.f3649n;
        if (drawable == null || (method = f3643p) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, null)).booleanValue();
        } catch (Exception e9) {
            Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e9);
            return false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        g gVar;
        ColorStateList colorStateList = (!b() || (gVar = this.f3647l) == null) ? null : gVar.f3652c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f3649n.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.f3649n.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.f3648m && super.mutate() == this) {
            this.f3647l = c();
            Drawable drawable = this.f3649n;
            if (drawable != null) {
                drawable.mutate();
            }
            g gVar = this.f3647l;
            if (gVar != null) {
                Drawable drawable2 = this.f3649n;
                gVar.f3651b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f3648m = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3649n;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i9) {
        return com.bumptech.glide.d.a0(this.f3649n, i9);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i9) {
        return this.f3649n.setLevel(i9);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        scheduleSelf(runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        this.f3649n.setAlpha(i9);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z8) {
        a.e(this.f3649n, z8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i9) {
        this.f3649n.setChangingConfigurations(i9);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3649n.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z8) {
        this.f3649n.setDither(z8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z8) {
        this.f3649n.setFilterBitmap(z8);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f9, float f10) {
        this.f3649n.setHotspot(f9, f10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i9, int i10, int i11, int i12) {
        this.f3649n.setHotspotBounds(i9, i10, i11, i12);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (!d(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i9) {
        if (b()) {
            e(i9);
        } else {
            this.f3649n.setTint(i9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (b()) {
            f(colorStateList);
        } else {
            this.f3649n.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (b()) {
            g(mode);
        } else {
            this.f3649n.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        return super.setVisible(z8, z9) || this.f3649n.setVisible(z8, z9);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
