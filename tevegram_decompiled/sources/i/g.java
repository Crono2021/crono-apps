package i;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.activity.j;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g extends Drawable implements Drawable.Callback {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f4273u = 0;

    /* renamed from: i, reason: collision with root package name */
    public b f4274i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f4275j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f4276k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f4277l;

    /* renamed from: m, reason: collision with root package name */
    public int f4278m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4279n;

    /* renamed from: o, reason: collision with root package name */
    public int f4280o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4281p;

    /* renamed from: q, reason: collision with root package name */
    public j f4282q;

    /* renamed from: r, reason: collision with root package name */
    public long f4283r;

    /* renamed from: s, reason: collision with root package name */
    public long f4284s;

    /* renamed from: t, reason: collision with root package name */
    public f f4285t;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f4279n = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f4276k
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f4283r
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f4278m
            r3.setAlpha(r9)
            r13.f4283r = r6
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            i.b r9 = r13.f4274i
            int r9 = r9.f4259y
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f4278m
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f4283r = r6
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f4277l
            if (r9 == 0) goto L65
            long r10 = r13.f4284s
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f4277l = r0
            r13.f4284s = r6
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            i.b r4 = r13.f4274i
            int r4 = r4.f4260z
            int r3 = r3 / r4
            int r4 = r13.f4278m
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f4284s = r6
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            androidx.activity.j r14 = r13.f4282q
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i.g.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        b bVar = this.f4274i;
        if (theme == null) {
            bVar.getClass();
            return;
        }
        bVar.c();
        int i9 = bVar.h;
        Drawable[] drawableArr = bVar.f4242g;
        for (int i10 = 0; i10 < i9; i10++) {
            Drawable drawable = drawableArr[i10];
            if (drawable != null && g0.b.b(drawable)) {
                g0.b.a(drawableArr[i10], theme);
                bVar.f4240e |= drawableArr[i10].getChangingConfigurations();
            }
        }
        Resources resources = theme.getResources();
        if (resources != null) {
            bVar.f4237b = resources;
            int i11 = resources.getDisplayMetrics().densityDpi;
            if (i11 == 0) {
                i11 = 160;
            }
            int i12 = bVar.f4238c;
            bVar.f4238c = i11;
            if (i12 != i11) {
                bVar.f4247m = false;
                bVar.f4244j = false;
            }
        }
    }

    public final void b(Drawable drawable) {
        if (this.f4285t == null) {
            this.f4285t = new f();
        }
        f fVar = this.f4285t;
        fVar.f4272j = drawable.getCallback();
        drawable.setCallback(fVar);
        try {
            if (this.f4274i.f4259y <= 0 && this.f4279n) {
                drawable.setAlpha(this.f4278m);
            }
            b bVar = this.f4274i;
            if (bVar.C) {
                drawable.setColorFilter(bVar.B);
            } else {
                if (bVar.F) {
                    g0.b.h(drawable, bVar.D);
                }
                b bVar2 = this.f4274i;
                if (bVar2.G) {
                    g0.b.i(drawable, bVar2.E);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f4274i.f4257w);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                com.bumptech.glide.d.a0(drawable, com.bumptech.glide.d.F(this));
            }
            g0.a.e(drawable, this.f4274i.A);
            Rect rect = this.f4275j;
            if (rect != null) {
                g0.b.f(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            f fVar2 = this.f4285t;
            Drawable.Callback callback = (Drawable.Callback) fVar2.f4272j;
            fVar2.f4272j = null;
            drawable.setCallback(callback);
        } catch (Throwable th) {
            f fVar3 = this.f4285t;
            Drawable.Callback callback2 = (Drawable.Callback) fVar3.f4272j;
            fVar3.f4272j = null;
            drawable.setCallback(callback2);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(int r10) {
        /*
            r9 = this;
            int r0 = r9.f4280o
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            i.b r0 = r9.f4274i
            int r0 = r0.f4260z
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f4277l
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f4276k
            if (r0 == 0) goto L29
            r9.f4277l = r0
            i.b r0 = r9.f4274i
            int r0 = r0.f4260z
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f4284s = r0
            goto L35
        L29:
            r9.f4277l = r4
            r9.f4284s = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f4276k
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            i.b r0 = r9.f4274i
            int r1 = r0.h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.d(r10)
            r9.f4276k = r0
            r9.f4280o = r10
            if (r0 == 0) goto L5a
            i.b r10 = r9.f4274i
            int r10 = r10.f4259y
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f4283r = r2
        L51:
            r9.b(r0)
            goto L5a
        L55:
            r9.f4276k = r4
            r10 = -1
            r9.f4280o = r10
        L5a:
            long r0 = r9.f4283r
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f4284s
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L7e
        L67:
            androidx.activity.j r0 = r9.f4282q
            if (r0 != 0) goto L78
            androidx.activity.j r0 = new androidx.activity.j
            r1 = r9
            i.e r1 = (i.e) r1
            r2 = 8
            r0.<init>(r1, r2)
            r9.f4282q = r0
            goto L7b
        L78:
            r9.unscheduleSelf(r0)
        L7b:
            r9.a(r10)
        L7e:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: i.g.c(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.f4274i.canApplyTheme();
    }

    public abstract void d(b bVar);

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f4276k;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f4277l;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f4278m;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f4274i.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z8;
        b bVar = this.f4274i;
        if (!bVar.f4255u) {
            bVar.c();
            bVar.f4255u = true;
            int i9 = bVar.h;
            Drawable[] drawableArr = bVar.f4242g;
            int i10 = 0;
            while (true) {
                if (i10 >= i9) {
                    bVar.f4256v = true;
                    z8 = true;
                    break;
                }
                if (drawableArr[i10].getConstantState() == null) {
                    bVar.f4256v = false;
                    z8 = false;
                    break;
                }
                i10++;
            }
        } else {
            z8 = bVar.f4256v;
        }
        if (!z8) {
            return null;
        }
        this.f4274i.f4239d = getChangingConfigurations();
        return this.f4274i;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f4276k;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f4275j;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        b bVar = this.f4274i;
        if (bVar.f4246l) {
            if (!bVar.f4247m) {
                bVar.b();
            }
            return bVar.f4249o;
        }
        Drawable drawable = this.f4276k;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        b bVar = this.f4274i;
        if (bVar.f4246l) {
            if (!bVar.f4247m) {
                bVar.b();
            }
            return bVar.f4248n;
        }
        Drawable drawable = this.f4276k;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        b bVar = this.f4274i;
        if (bVar.f4246l) {
            if (!bVar.f4247m) {
                bVar.b();
            }
            return bVar.f4251q;
        }
        Drawable drawable = this.f4276k;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        b bVar = this.f4274i;
        if (bVar.f4246l) {
            if (!bVar.f4247m) {
                bVar.b();
            }
            return bVar.f4250p;
        }
        Drawable drawable = this.f4276k;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f4276k;
        if (drawable != null && drawable.isVisible()) {
            b bVar = this.f4274i;
            if (bVar.f4252r) {
                return bVar.f4253s;
            }
            bVar.c();
            int i9 = bVar.h;
            Drawable[] drawableArr = bVar.f4242g;
            r1 = i9 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i10 = 1; i10 < i9; i10++) {
                r1 = Drawable.resolveOpacity(r1, drawableArr[i10].getOpacity());
            }
            bVar.f4253s = r1;
            bVar.f4252r = true;
        }
        return r1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.f4276k;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        b bVar = this.f4274i;
        Rect rect2 = null;
        boolean z8 = false;
        if (!bVar.f4243i) {
            Rect rect3 = bVar.f4245k;
            if (rect3 != null || bVar.f4244j) {
                rect2 = rect3;
            } else {
                bVar.c();
                Rect rect4 = new Rect();
                int i9 = bVar.h;
                Drawable[] drawableArr = bVar.f4242g;
                for (int i10 = 0; i10 < i9; i10++) {
                    if (drawableArr[i10].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i11 = rect4.left;
                        if (i11 > rect2.left) {
                            rect2.left = i11;
                        }
                        int i12 = rect4.top;
                        if (i12 > rect2.top) {
                            rect2.top = i12;
                        }
                        int i13 = rect4.right;
                        if (i13 > rect2.right) {
                            rect2.right = i13;
                        }
                        int i14 = rect4.bottom;
                        if (i14 > rect2.bottom) {
                            rect2.bottom = i14;
                        }
                    }
                }
                bVar.f4244j = true;
                bVar.f4245k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                z8 = true;
            }
        } else {
            Drawable drawable = this.f4276k;
            z8 = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.f4274i.A && com.bumptech.glide.d.F(this) == 1) {
            int i15 = rect.left;
            rect.left = rect.right;
            rect.right = i15;
        }
        return z8;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        b bVar = this.f4274i;
        if (bVar != null) {
            bVar.f4252r = false;
            bVar.f4254t = false;
        }
        if (drawable != this.f4276k || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f4274i.A;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z8;
        Drawable drawable = this.f4277l;
        boolean z9 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f4277l = null;
            z8 = true;
        } else {
            z8 = false;
        }
        Drawable drawable2 = this.f4276k;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f4279n) {
                this.f4276k.setAlpha(this.f4278m);
            }
        }
        if (this.f4284s != 0) {
            this.f4284s = 0L;
            z8 = true;
        }
        if (this.f4283r != 0) {
            this.f4283r = 0L;
        } else {
            z9 = z8;
        }
        if (z9) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f4281p && super.mutate() == this) {
            e eVar = (e) this;
            b bVar = new b(eVar.f4268x, eVar, null);
            bVar.I = bVar.I.clone();
            bVar.J = bVar.J.clone();
            d(bVar);
            this.f4281p = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4277l;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f4276k;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i9) {
        b bVar = this.f4274i;
        int i10 = this.f4280o;
        int i11 = bVar.h;
        Drawable[] drawableArr = bVar.f4242g;
        boolean z8 = false;
        for (int i12 = 0; i12 < i11; i12++) {
            Drawable drawable = drawableArr[i12];
            if (drawable != null) {
                boolean a02 = Build.VERSION.SDK_INT >= 23 ? com.bumptech.glide.d.a0(drawable, i9) : false;
                if (i12 == i10) {
                    z8 = a02;
                }
            }
        }
        bVar.f4258x = i9;
        return z8;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i9) {
        Drawable drawable = this.f4277l;
        if (drawable != null) {
            return drawable.setLevel(i9);
        }
        Drawable drawable2 = this.f4276k;
        if (drawable2 != null) {
            return drawable2.setLevel(i9);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        if (drawable != this.f4276k || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        if (this.f4279n && this.f4278m == i9) {
            return;
        }
        this.f4279n = true;
        this.f4278m = i9;
        Drawable drawable = this.f4276k;
        if (drawable != null) {
            if (this.f4283r == 0) {
                drawable.setAlpha(i9);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z8) {
        b bVar = this.f4274i;
        if (bVar.A != z8) {
            bVar.A = z8;
            Drawable drawable = this.f4276k;
            if (drawable != null) {
                g0.a.e(drawable, z8);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        b bVar = this.f4274i;
        bVar.C = true;
        if (bVar.B != colorFilter) {
            bVar.B = colorFilter;
            Drawable drawable = this.f4276k;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z8) {
        b bVar = this.f4274i;
        if (bVar.f4257w != z8) {
            bVar.f4257w = z8;
            Drawable drawable = this.f4276k;
            if (drawable != null) {
                drawable.setDither(z8);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f9, float f10) {
        Drawable drawable = this.f4276k;
        if (drawable != null) {
            g0.b.e(drawable, f9, f10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i9, int i10, int i11, int i12) {
        Rect rect = this.f4275j;
        if (rect == null) {
            this.f4275j = new Rect(i9, i10, i11, i12);
        } else {
            rect.set(i9, i10, i11, i12);
        }
        Drawable drawable = this.f4276k;
        if (drawable != null) {
            g0.b.f(drawable, i9, i10, i11, i12);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i9) {
        setTintList(ColorStateList.valueOf(i9));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        b bVar = this.f4274i;
        bVar.F = true;
        if (bVar.D != colorStateList) {
            bVar.D = colorStateList;
            g0.b.h(this.f4276k, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f4274i;
        bVar.G = true;
        if (bVar.E != mode) {
            bVar.E = mode;
            g0.b.i(this.f4276k, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z8, boolean z9) {
        boolean visible = super.setVisible(z8, z9);
        Drawable drawable = this.f4277l;
        if (drawable != null) {
            drawable.setVisible(z8, z9);
        }
        Drawable drawable2 = this.f4276k;
        if (drawable2 != null) {
            drawable2.setVisible(z8, z9);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f4276k || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
