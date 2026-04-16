package i;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.StateSet;
import s.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends Drawable.ConstantState {
    public boolean A;
    public ColorFilter B;
    public boolean C;
    public ColorStateList D;
    public PorterDuff.Mode E;
    public boolean F;
    public boolean G;
    public int[][] H;
    public s.g I;
    public i J;

    /* renamed from: a, reason: collision with root package name */
    public final g f4236a;

    /* renamed from: b, reason: collision with root package name */
    public Resources f4237b;

    /* renamed from: c, reason: collision with root package name */
    public int f4238c;

    /* renamed from: d, reason: collision with root package name */
    public int f4239d;

    /* renamed from: e, reason: collision with root package name */
    public int f4240e;

    /* renamed from: f, reason: collision with root package name */
    public SparseArray f4241f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable[] f4242g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4243i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4244j;

    /* renamed from: k, reason: collision with root package name */
    public Rect f4245k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4246l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4247m;

    /* renamed from: n, reason: collision with root package name */
    public int f4248n;

    /* renamed from: o, reason: collision with root package name */
    public int f4249o;

    /* renamed from: p, reason: collision with root package name */
    public int f4250p;

    /* renamed from: q, reason: collision with root package name */
    public int f4251q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4252r;

    /* renamed from: s, reason: collision with root package name */
    public int f4253s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4254t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4255u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4256v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4257w;

    /* renamed from: x, reason: collision with root package name */
    public int f4258x;

    /* renamed from: y, reason: collision with root package name */
    public int f4259y;

    /* renamed from: z, reason: collision with root package name */
    public int f4260z;

    public b(b bVar, e eVar, Resources resources) {
        this.f4243i = false;
        this.f4246l = false;
        this.f4257w = true;
        this.f4259y = 0;
        this.f4260z = 0;
        this.f4236a = eVar;
        this.f4237b = resources != null ? resources : bVar != null ? bVar.f4237b : null;
        int i9 = bVar != null ? bVar.f4238c : 0;
        int i10 = g.f4273u;
        i9 = resources != null ? resources.getDisplayMetrics().densityDpi : i9;
        i9 = i9 == 0 ? 160 : i9;
        this.f4238c = i9;
        if (bVar != null) {
            this.f4239d = bVar.f4239d;
            this.f4240e = bVar.f4240e;
            this.f4255u = true;
            this.f4256v = true;
            this.f4243i = bVar.f4243i;
            this.f4246l = bVar.f4246l;
            this.f4257w = bVar.f4257w;
            this.f4258x = bVar.f4258x;
            this.f4259y = bVar.f4259y;
            this.f4260z = bVar.f4260z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            if (bVar.f4238c == i9) {
                if (bVar.f4244j) {
                    this.f4245k = bVar.f4245k != null ? new Rect(bVar.f4245k) : null;
                    this.f4244j = true;
                }
                if (bVar.f4247m) {
                    this.f4248n = bVar.f4248n;
                    this.f4249o = bVar.f4249o;
                    this.f4250p = bVar.f4250p;
                    this.f4251q = bVar.f4251q;
                    this.f4247m = true;
                }
            }
            if (bVar.f4252r) {
                this.f4253s = bVar.f4253s;
                this.f4252r = true;
            }
            if (bVar.f4254t) {
                this.f4254t = true;
            }
            Drawable[] drawableArr = bVar.f4242g;
            this.f4242g = new Drawable[drawableArr.length];
            this.h = bVar.h;
            SparseArray sparseArray = bVar.f4241f;
            if (sparseArray != null) {
                this.f4241f = sparseArray.clone();
            } else {
                this.f4241f = new SparseArray(this.h);
            }
            int i11 = this.h;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f4241f.put(i12, constantState);
                    } else {
                        this.f4242g[i12] = drawableArr[i12];
                    }
                }
            }
        } else {
            this.f4242g = new Drawable[10];
            this.h = 0;
        }
        if (bVar != null) {
            this.H = bVar.H;
        } else {
            this.H = new int[this.f4242g.length][];
        }
        if (bVar != null) {
            this.I = bVar.I;
            this.J = bVar.J;
        } else {
            this.I = new s.g();
            this.J = new i();
        }
    }

    public final int a(Drawable drawable) {
        int i9 = this.h;
        if (i9 >= this.f4242g.length) {
            int i10 = i9 + 10;
            Drawable[] drawableArr = new Drawable[i10];
            Drawable[] drawableArr2 = this.f4242g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i9);
            }
            this.f4242g = drawableArr;
            int[][] iArr = new int[i10][];
            System.arraycopy(this.H, 0, iArr, 0, i9);
            this.H = iArr;
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.f4236a);
        this.f4242g[i9] = drawable;
        this.h++;
        this.f4240e = drawable.getChangingConfigurations() | this.f4240e;
        this.f4252r = false;
        this.f4254t = false;
        this.f4245k = null;
        this.f4244j = false;
        this.f4247m = false;
        this.f4255u = false;
        return i9;
    }

    public final void b() {
        this.f4247m = true;
        c();
        int i9 = this.h;
        Drawable[] drawableArr = this.f4242g;
        this.f4249o = -1;
        this.f4248n = -1;
        this.f4251q = 0;
        this.f4250p = 0;
        for (int i10 = 0; i10 < i9; i10++) {
            Drawable drawable = drawableArr[i10];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.f4248n) {
                this.f4248n = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f4249o) {
                this.f4249o = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.f4250p) {
                this.f4250p = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.f4251q) {
                this.f4251q = minimumHeight;
            }
        }
    }

    public final void c() {
        SparseArray sparseArray = this.f4241f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i9 = 0; i9 < size; i9++) {
                int keyAt = this.f4241f.keyAt(i9);
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f4241f.valueAt(i9);
                Drawable[] drawableArr = this.f4242g;
                Drawable newDrawable = constantState.newDrawable(this.f4237b);
                if (Build.VERSION.SDK_INT >= 23) {
                    com.bumptech.glide.d.a0(newDrawable, this.f4258x);
                }
                Drawable mutate = newDrawable.mutate();
                mutate.setCallback(this.f4236a);
                drawableArr[keyAt] = mutate;
            }
            this.f4241f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        int i9 = this.h;
        Drawable[] drawableArr = this.f4242g;
        for (int i10 = 0; i10 < i9; i10++) {
            Drawable drawable = drawableArr[i10];
            if (drawable == null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f4241f.get(i10);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            } else if (g0.b.b(drawable)) {
                return true;
            }
        }
        return false;
    }

    public final Drawable d(int i9) {
        int indexOfKey;
        Drawable drawable = this.f4242g[i9];
        if (drawable != null) {
            return drawable;
        }
        SparseArray sparseArray = this.f4241f;
        if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i9)) < 0) {
            return null;
        }
        Drawable newDrawable = ((Drawable.ConstantState) this.f4241f.valueAt(indexOfKey)).newDrawable(this.f4237b);
        if (Build.VERSION.SDK_INT >= 23) {
            com.bumptech.glide.d.a0(newDrawable, this.f4258x);
        }
        Drawable mutate = newDrawable.mutate();
        mutate.setCallback(this.f4236a);
        this.f4242g[i9] = mutate;
        this.f4241f.removeAt(indexOfKey);
        if (this.f4241f.size() == 0) {
            this.f4241f = null;
        }
        return mutate;
    }

    public final int e(int[] iArr) {
        int[][] iArr2 = this.H;
        int i9 = this.h;
        for (int i10 = 0; i10 < i9; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f4239d | this.f4240e;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new e(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new e(this, resources);
    }
}
