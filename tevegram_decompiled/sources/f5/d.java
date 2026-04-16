package f5;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.card.MaterialCardView;
import java.util.WeakHashMap;
import n0.d0;
import n0.t0;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import u5.g;
import u5.i;
import u5.j;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: y, reason: collision with root package name */
    public static final double f3390y = Math.cos(Math.toRadians(45.0d));

    /* renamed from: z, reason: collision with root package name */
    public static final ColorDrawable f3391z;

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCardView f3392a;

    /* renamed from: c, reason: collision with root package name */
    public final g f3394c;

    /* renamed from: d, reason: collision with root package name */
    public final g f3395d;

    /* renamed from: e, reason: collision with root package name */
    public int f3396e;

    /* renamed from: f, reason: collision with root package name */
    public int f3397f;

    /* renamed from: g, reason: collision with root package name */
    public int f3398g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f3399i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f3400j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f3401k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f3402l;

    /* renamed from: m, reason: collision with root package name */
    public j f3403m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f3404n;

    /* renamed from: o, reason: collision with root package name */
    public RippleDrawable f3405o;

    /* renamed from: p, reason: collision with root package name */
    public LayerDrawable f3406p;

    /* renamed from: q, reason: collision with root package name */
    public g f3407q;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3409s;

    /* renamed from: t, reason: collision with root package name */
    public ValueAnimator f3410t;

    /* renamed from: u, reason: collision with root package name */
    public final TimeInterpolator f3411u;

    /* renamed from: v, reason: collision with root package name */
    public final int f3412v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3413w;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f3393b = new Rect();

    /* renamed from: r, reason: collision with root package name */
    public boolean f3408r = false;

    /* renamed from: x, reason: collision with root package name */
    public float f3414x = 0.0f;

    static {
        f3391z = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public d(MaterialCardView materialCardView, AttributeSet attributeSet) {
        this.f3392a = materialCardView;
        g gVar = new g(materialCardView.getContext(), attributeSet, 2130969296, 2132018212);
        this.f3394c = gVar;
        gVar.i(materialCardView.getContext());
        gVar.n();
        c7.b e9 = gVar.f9084i.f9069a.e();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, y4.a.f10499d, 2130969296, 2132017439);
        if (obtainStyledAttributes.hasValue(3)) {
            e9.c(obtainStyledAttributes.getDimension(3, 0.0f));
        }
        this.f3395d = new g();
        h(e9.a());
        this.f3411u = android.support.v4.media.session.b.o0(materialCardView.getContext(), 2130969365, z4.a.f10659a);
        this.f3412v = android.support.v4.media.session.b.n0(materialCardView.getContext(), 2130969355, IjkMediaCodecInfo.RANK_SECURE);
        this.f3413w = android.support.v4.media.session.b.n0(materialCardView.getContext(), 2130969354, IjkMediaCodecInfo.RANK_SECURE);
        obtainStyledAttributes.recycle();
    }

    public static float b(com.bumptech.glide.c cVar, float f9) {
        if (cVar instanceof i) {
            return (float) ((1.0d - f3390y) * f9);
        }
        if (cVar instanceof u5.d) {
            return f9 / 2.0f;
        }
        return 0.0f;
    }

    public final float a() {
        com.bumptech.glide.c cVar = this.f3403m.f9103a;
        g gVar = this.f3394c;
        return Math.max(Math.max(b(cVar, gVar.g()), b(this.f3403m.f9104b, gVar.f9084i.f9069a.f9108f.a(gVar.f()))), Math.max(b(this.f3403m.f9105c, gVar.f9084i.f9069a.f9109g.a(gVar.f())), b(this.f3403m.f9106d, gVar.f9084i.f9069a.h.a(gVar.f()))));
    }

    public final LayerDrawable c() {
        if (this.f3405o == null) {
            int[] iArr = s5.b.f8857a;
            this.f3407q = new g(this.f3403m);
            this.f3405o = new RippleDrawable(this.f3401k, null, this.f3407q);
        }
        if (this.f3406p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f3405o, this.f3395d, this.f3400j});
            this.f3406p = layerDrawable;
            layerDrawable.setId(2, 2131362219);
        }
        return this.f3406p;
    }

    public final c d(Drawable drawable) {
        int i9;
        int i10;
        if (this.f3392a.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((r0.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f));
            i9 = (int) Math.ceil(r0.getMaxCardElevation() + (i() ? a() : 0.0f));
            i10 = ceil;
        } else {
            i9 = 0;
            i10 = 0;
        }
        return new c(drawable, i9, i10, i9, i10);
    }

    public final void e(int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (this.f3406p != null) {
            MaterialCardView materialCardView = this.f3392a;
            if (materialCardView.getUseCompatPadding()) {
                i11 = (int) Math.ceil(((materialCardView.getMaxCardElevation() * 1.5f) + (i() ? a() : 0.0f)) * 2.0f);
                i12 = (int) Math.ceil((materialCardView.getMaxCardElevation() + (i() ? a() : 0.0f)) * 2.0f);
            } else {
                i11 = 0;
                i12 = 0;
            }
            int i15 = this.f3398g;
            boolean z8 = (i15 & 8388613) == 8388613;
            int i16 = this.f3396e;
            int i17 = z8 ? ((i9 - i16) - this.f3397f) - i12 : i16;
            int i18 = (i15 & 80) == 80 ? i16 : ((i10 - i16) - this.f3397f) - i11;
            int i19 = (i15 & 8388613) == 8388613 ? i16 : ((i9 - i16) - this.f3397f) - i12;
            if ((i15 & 80) == 80) {
                i16 = ((i10 - i16) - this.f3397f) - i11;
            }
            int i20 = i16;
            WeakHashMap weakHashMap = t0.f7209a;
            if (d0.d(materialCardView) == 1) {
                i14 = i19;
                i13 = i17;
            } else {
                i13 = i19;
                i14 = i17;
            }
            this.f3406p.setLayerInset(2, i14, i20, i13, i18);
        }
    }

    public final void f(boolean z8, boolean z9) {
        Drawable drawable = this.f3400j;
        if (drawable != null) {
            if (!z9) {
                drawable.setAlpha(z8 ? 255 : 0);
                this.f3414x = z8 ? 1.0f : 0.0f;
                return;
            }
            float f9 = z8 ? 1.0f : 0.0f;
            float f10 = this.f3414x;
            if (z8) {
                f10 = 1.0f - f10;
            }
            ValueAnimator valueAnimator = this.f3410t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f3410t = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f3414x, f9);
            this.f3410t = ofFloat;
            ofFloat.addUpdateListener(new b(this, 0));
            this.f3410t.setInterpolator(this.f3411u);
            this.f3410t.setDuration((long) ((z8 ? this.f3412v : this.f3413w) * f10));
            this.f3410t.start();
        }
    }

    public final void g(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = com.bumptech.glide.d.f0(drawable).mutate();
            this.f3400j = mutate;
            g0.b.h(mutate, this.f3402l);
            f(this.f3392a.f1980q, false);
        } else {
            this.f3400j = f3391z;
        }
        LayerDrawable layerDrawable = this.f3406p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(2131362219, this.f3400j);
        }
    }

    public final void h(j jVar) {
        this.f3403m = jVar;
        g gVar = this.f3394c;
        gVar.setShapeAppearanceModel(jVar);
        gVar.D = !gVar.j();
        g gVar2 = this.f3395d;
        if (gVar2 != null) {
            gVar2.setShapeAppearanceModel(jVar);
        }
        g gVar3 = this.f3407q;
        if (gVar3 != null) {
            gVar3.setShapeAppearanceModel(jVar);
        }
    }

    public final boolean i() {
        MaterialCardView materialCardView = this.f3392a;
        return materialCardView.getPreventCornerOverlap() && this.f3394c.j() && materialCardView.getUseCompatPadding();
    }

    public final void j() {
        MaterialCardView materialCardView = this.f3392a;
        float f9 = 0.0f;
        float a9 = ((!materialCardView.getPreventCornerOverlap() || this.f3394c.j()) && !i()) ? 0.0f : a();
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            f9 = (float) ((1.0d - f3390y) * materialCardView.getCardViewRadius());
        }
        int i9 = (int) (a9 - f9);
        Rect rect = this.f3393b;
        materialCardView.f527k.set(rect.left + i9, rect.top + i9, rect.right + i9, rect.bottom + i9);
        m1.b bVar = materialCardView.f529m;
        if (!((CardView) bVar.f6511k).getUseCompatPadding()) {
            bVar.x(0, 0, 0, 0);
            return;
        }
        r.a aVar = (r.a) bVar.f6510j;
        float f10 = aVar.f8481e;
        float f11 = aVar.f8477a;
        int ceil = (int) Math.ceil(r.b.a(f10, f11, r1.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(r.b.b(f10, f11, r1.getPreventCornerOverlap()));
        bVar.x(ceil, ceil2, ceil, ceil2);
    }

    public final void k() {
        boolean z8 = this.f3408r;
        MaterialCardView materialCardView = this.f3392a;
        if (!z8) {
            materialCardView.setBackgroundInternal(d(this.f3394c));
        }
        materialCardView.setForeground(d(this.f3399i));
    }
}
