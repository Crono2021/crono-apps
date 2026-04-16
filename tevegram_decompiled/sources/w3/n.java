package w3;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public int f9907a;

    /* renamed from: b, reason: collision with root package name */
    public m f9908b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f9909c;

    /* renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f9910d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9911e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f9912f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f9913g;
    public PorterDuff.Mode h;

    /* renamed from: i, reason: collision with root package name */
    public int f9914i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9915j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9916k;

    /* renamed from: l, reason: collision with root package name */
    public Paint f9917l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f9907a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new p(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new p(this);
    }
}
