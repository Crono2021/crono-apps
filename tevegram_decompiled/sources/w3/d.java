package w3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends g implements Animatable {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f9860o = 0;

    /* renamed from: k, reason: collision with root package name */
    public final Context f9862k;

    /* renamed from: l, reason: collision with root package name */
    public b5.a f9863l = null;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f9864m = null;

    /* renamed from: n, reason: collision with root package name */
    public final i.f f9865n = new i.f(this);

    /* renamed from: j, reason: collision with root package name */
    public final c f9861j = new c();

    public d(Context context, int i9) {
        this.f9862k = context;
    }

    @Override // w3.g, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.b.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            return g0.b.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        c cVar = this.f9861j;
        cVar.f9856a.draw(canvas);
        if (cVar.f9857b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f9868i;
        return drawable != null ? g0.a.a(drawable) : this.f9861j.f9856a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f9861j.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f9868i;
        return drawable != null ? g0.b.c(drawable) : this.f9861j.f9856a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f9868i == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new o4.b(this.f9868i.getConstantState(), 1);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f9861j.f9856a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f9861j.f9856a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.getOpacity() : this.f9861j.f9856a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0189, code lost:
    
        if (r8.f9857b != null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x018b, code lost:
    
        r8.f9857b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0192, code lost:
    
        r8.f9857b.playTogether(r8.f9858c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0199, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r24, org.xmlpull.v1.XmlPullParser r25, android.util.AttributeSet r26, android.content.res.Resources.Theme r27) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.d.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f9868i;
        return drawable != null ? g0.a.d(drawable) : this.f9861j.f9856a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f9868i;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f9861j.f9857b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.isStateful() : this.f9861j.f9856a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f9861j.f9856a.setBounds(rect);
        }
    }

    @Override // w3.g, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i9) {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.setLevel(i9) : this.f9861j.f9856a.setLevel(i9);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f9868i;
        return drawable != null ? drawable.setState(iArr) : this.f9861j.f9856a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.setAlpha(i9);
        } else {
            this.f9861j.f9856a.setAlpha(i9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z8) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.a.e(drawable, z8);
        } else {
            this.f9861j.f9856a.setAutoMirrored(z8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f9861j.f9856a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i9) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.b.g(drawable, i9);
        } else {
            this.f9861j.f9856a.setTint(i9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.b.h(drawable, colorStateList);
        } else {
            this.f9861j.f9856a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            g0.b.i(drawable, mode);
        } else {
            this.f9861j.f9856a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            return drawable.setVisible(z8, z9);
        }
        this.f9861j.f9856a.setVisible(z8, z9);
        return super.setVisible(z8, z9);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        c cVar = this.f9861j;
        if (cVar.f9857b.isStarted()) {
            return;
        }
        cVar.f9857b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f9868i;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f9861j.f9857b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
