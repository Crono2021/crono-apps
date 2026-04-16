package e5;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.button.MaterialButton;
import java.util.WeakHashMap;
import n0.d0;
import n0.t0;
import u5.f;
import u5.g;
import u5.j;
import u5.t;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f3124u;

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f3125a;

    /* renamed from: b, reason: collision with root package name */
    public j f3126b;

    /* renamed from: c, reason: collision with root package name */
    public int f3127c;

    /* renamed from: d, reason: collision with root package name */
    public int f3128d;

    /* renamed from: e, reason: collision with root package name */
    public int f3129e;

    /* renamed from: f, reason: collision with root package name */
    public int f3130f;

    /* renamed from: g, reason: collision with root package name */
    public int f3131g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f3132i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f3133j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f3134k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f3135l;

    /* renamed from: m, reason: collision with root package name */
    public g f3136m;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3140q;

    /* renamed from: s, reason: collision with root package name */
    public RippleDrawable f3142s;

    /* renamed from: t, reason: collision with root package name */
    public int f3143t;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3137n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3138o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3139p = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3141r = true;

    static {
        f3124u = Build.VERSION.SDK_INT <= 22;
    }

    public c(MaterialButton materialButton, j jVar) {
        this.f3125a = materialButton;
        this.f3126b = jVar;
    }

    public final t a() {
        RippleDrawable rippleDrawable = this.f3142s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        int numberOfLayers = this.f3142s.getNumberOfLayers();
        RippleDrawable rippleDrawable2 = this.f3142s;
        return numberOfLayers > 2 ? (t) rippleDrawable2.getDrawable(2) : (t) rippleDrawable2.getDrawable(1);
    }

    public final g b(boolean z8) {
        RippleDrawable rippleDrawable = this.f3142s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) ((LayerDrawable) ((InsetDrawable) this.f3142s.getDrawable(0)).getDrawable()).getDrawable(!z8 ? 1 : 0);
    }

    public final void c(j jVar) {
        this.f3126b = jVar;
        if (!f3124u || this.f3138o) {
            if (b(false) != null) {
                b(false).setShapeAppearanceModel(jVar);
            }
            if (b(true) != null) {
                b(true).setShapeAppearanceModel(jVar);
            }
            if (a() != null) {
                a().setShapeAppearanceModel(jVar);
                return;
            }
            return;
        }
        WeakHashMap weakHashMap = t0.f7209a;
        MaterialButton materialButton = this.f3125a;
        int f9 = d0.f(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int e9 = d0.e(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        e();
        d0.k(materialButton, f9, paddingTop, e9, paddingBottom);
    }

    public final void d(int i9, int i10) {
        WeakHashMap weakHashMap = t0.f7209a;
        MaterialButton materialButton = this.f3125a;
        int f9 = d0.f(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int e9 = d0.e(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        int i11 = this.f3129e;
        int i12 = this.f3130f;
        this.f3130f = i10;
        this.f3129e = i9;
        if (!this.f3138o) {
            e();
        }
        d0.k(materialButton, f9, (paddingTop + i9) - i11, e9, (paddingBottom + i10) - i12);
    }

    public final void e() {
        g gVar = new g(this.f3126b);
        MaterialButton materialButton = this.f3125a;
        gVar.i(materialButton.getContext());
        g0.b.h(gVar, this.f3133j);
        PorterDuff.Mode mode = this.f3132i;
        if (mode != null) {
            g0.b.i(gVar, mode);
        }
        float f9 = this.h;
        ColorStateList colorStateList = this.f3134k;
        gVar.f9084i.f9077j = f9;
        gVar.invalidateSelf();
        f fVar = gVar.f9084i;
        if (fVar.f9072d != colorStateList) {
            fVar.f9072d = colorStateList;
            gVar.onStateChange(gVar.getState());
        }
        g gVar2 = new g(this.f3126b);
        gVar2.setTint(0);
        float f10 = this.h;
        int v8 = this.f3137n ? com.bumptech.glide.c.v(materialButton, 2130968848) : 0;
        gVar2.f9084i.f9077j = f10;
        gVar2.invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(v8);
        f fVar2 = gVar2.f9084i;
        if (fVar2.f9072d != valueOf) {
            fVar2.f9072d = valueOf;
            gVar2.onStateChange(gVar2.getState());
        }
        g gVar3 = new g(this.f3126b);
        this.f3136m = gVar3;
        g0.b.g(gVar3, -1);
        RippleDrawable rippleDrawable = new RippleDrawable(s5.b.a(this.f3135l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), this.f3127c, this.f3129e, this.f3128d, this.f3130f), this.f3136m);
        this.f3142s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        g b9 = b(false);
        if (b9 != null) {
            b9.k(this.f3143t);
            b9.setState(materialButton.getDrawableState());
        }
    }

    public final void f() {
        g b9 = b(false);
        g b10 = b(true);
        if (b9 != null) {
            float f9 = this.h;
            ColorStateList colorStateList = this.f3134k;
            b9.f9084i.f9077j = f9;
            b9.invalidateSelf();
            f fVar = b9.f9084i;
            if (fVar.f9072d != colorStateList) {
                fVar.f9072d = colorStateList;
                b9.onStateChange(b9.getState());
            }
            if (b10 != null) {
                float f10 = this.h;
                int v8 = this.f3137n ? com.bumptech.glide.c.v(this.f3125a, 2130968848) : 0;
                b10.f9084i.f9077j = f10;
                b10.invalidateSelf();
                ColorStateList valueOf = ColorStateList.valueOf(v8);
                f fVar2 = b10.f9084i;
                if (fVar2.f9072d != valueOf) {
                    fVar2.f9072d = valueOf;
                    b10.onStateChange(b10.getState());
                }
            }
        }
    }
}
