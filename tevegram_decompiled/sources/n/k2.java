package n;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class k2 implements m.d0 {
    public static final Method I;
    public static final Method J;
    public static final Method K;
    public final Handler D;
    public Rect F;
    public boolean G;
    public final a0 H;

    /* renamed from: i, reason: collision with root package name */
    public final Context f6924i;

    /* renamed from: j, reason: collision with root package name */
    public ListAdapter f6925j;

    /* renamed from: k, reason: collision with root package name */
    public x1 f6926k;

    /* renamed from: n, reason: collision with root package name */
    public int f6929n;

    /* renamed from: o, reason: collision with root package name */
    public int f6930o;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6932q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6933r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6934s;

    /* renamed from: v, reason: collision with root package name */
    public h2 f6937v;

    /* renamed from: w, reason: collision with root package name */
    public View f6938w;

    /* renamed from: x, reason: collision with root package name */
    public AdapterView.OnItemClickListener f6939x;

    /* renamed from: y, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f6940y;

    /* renamed from: l, reason: collision with root package name */
    public final int f6927l = -2;

    /* renamed from: m, reason: collision with root package name */
    public int f6928m = -2;

    /* renamed from: p, reason: collision with root package name */
    public final int f6931p = 1002;

    /* renamed from: t, reason: collision with root package name */
    public int f6935t = 0;

    /* renamed from: u, reason: collision with root package name */
    public final int f6936u = Integer.MAX_VALUE;

    /* renamed from: z, reason: collision with root package name */
    public final g2 f6941z = new g2(this, 1);
    public final j2 A = new j2(this);
    public final i2 B = new i2(this);
    public final g2 C = new g2(this, 0);
    public final Rect E = new Rect();

    static {
        int i9 = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        if (i9 <= 28) {
            try {
                I = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", cls);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                K = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                J = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, cls);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public k2(Context context, AttributeSet attributeSet, int i9, int i10) {
        int resourceId;
        this.f6924i = context;
        this.D = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.a.f3179o, i9, 0);
        this.f6929n = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f6930o = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f6932q = true;
        }
        obtainStyledAttributes.recycle();
        a0 a0Var = new a0(context, attributeSet, i9, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f.a.f3183s, i9, 0);
        if (obtainStyledAttributes2.hasValue(2)) {
            a.a.M(a0Var, obtainStyledAttributes2.getBoolean(2, false));
        }
        a0Var.setBackgroundDrawable((!obtainStyledAttributes2.hasValue(0) || (resourceId = obtainStyledAttributes2.getResourceId(0, 0)) == 0) ? obtainStyledAttributes2.getDrawable(0) : android.support.v4.media.session.b.I(context, resourceId));
        obtainStyledAttributes2.recycle();
        this.H = a0Var;
        a0Var.setInputMethodMode(1);
    }

    public final int a() {
        return this.f6929n;
    }

    @Override // m.d0
    public final boolean b() {
        return this.H.isShowing();
    }

    @Override // m.d0
    public final void c() {
        int i9;
        int a9;
        int paddingBottom;
        x1 x1Var;
        x1 x1Var2 = this.f6926k;
        Context context = this.f6924i;
        a0 a0Var = this.H;
        if (x1Var2 == null) {
            x1 p5 = p(context, !this.G);
            this.f6926k = p5;
            p5.setAdapter(this.f6925j);
            this.f6926k.setOnItemClickListener(this.f6939x);
            this.f6926k.setFocusable(true);
            this.f6926k.setFocusableInTouchMode(true);
            this.f6926k.setOnItemSelectedListener(new d2(this, 0));
            this.f6926k.setOnScrollListener(this.B);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f6940y;
            if (onItemSelectedListener != null) {
                this.f6926k.setOnItemSelectedListener(onItemSelectedListener);
            }
            a0Var.setContentView(this.f6926k);
        }
        Drawable background = a0Var.getBackground();
        Rect rect = this.E;
        if (background != null) {
            background.getPadding(rect);
            int i10 = rect.top;
            i9 = rect.bottom + i10;
            if (!this.f6932q) {
                this.f6930o = -i10;
            }
        } else {
            rect.setEmpty();
            i9 = 0;
        }
        boolean z8 = a0Var.getInputMethodMode() == 2;
        View view = this.f6938w;
        int i11 = this.f6930o;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = J;
            if (method != null) {
                try {
                    a9 = ((Integer) method.invoke(a0Var, view, Integer.valueOf(i11), Boolean.valueOf(z8))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            a9 = a0Var.getMaxAvailableHeight(view, i11);
        } else {
            a9 = e2.a(a0Var, view, i11, z8);
        }
        int i12 = this.f6927l;
        if (i12 == -1) {
            paddingBottom = a9 + i9;
        } else {
            int i13 = this.f6928m;
            int a10 = this.f6926k.a(i13 != -2 ? i13 != -1 ? View.MeasureSpec.makeMeasureSpec(i13, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), a9);
            paddingBottom = a10 + (a10 > 0 ? this.f6926k.getPaddingBottom() + this.f6926k.getPaddingTop() + i9 : 0);
        }
        boolean z9 = a0Var.getInputMethodMode() == 2;
        a.a.Q(a0Var, this.f6931p);
        if (a0Var.isShowing()) {
            View view2 = this.f6938w;
            WeakHashMap weakHashMap = n0.t0.f7209a;
            if (n0.f0.b(view2)) {
                int i14 = this.f6928m;
                if (i14 == -1) {
                    i14 = -1;
                } else if (i14 == -2) {
                    i14 = this.f6938w.getWidth();
                }
                if (i12 == -1) {
                    i12 = z9 ? paddingBottom : -1;
                    int i15 = this.f6928m;
                    if (z9) {
                        a0Var.setWidth(i15 == -1 ? -1 : 0);
                        a0Var.setHeight(0);
                    } else {
                        a0Var.setWidth(i15 == -1 ? -1 : 0);
                        a0Var.setHeight(-1);
                    }
                } else if (i12 == -2) {
                    i12 = paddingBottom;
                }
                a0Var.setOutsideTouchable(true);
                int i16 = i14;
                a0Var.update(this.f6938w, this.f6929n, this.f6930o, i16 < 0 ? -1 : i16, i12 < 0 ? -1 : i12);
                return;
            }
            return;
        }
        int i17 = this.f6928m;
        if (i17 == -1) {
            i17 = -1;
        } else if (i17 == -2) {
            i17 = this.f6938w.getWidth();
        }
        if (i12 == -1) {
            i12 = -1;
        } else if (i12 == -2) {
            i12 = paddingBottom;
        }
        a0Var.setWidth(i17);
        a0Var.setHeight(i12);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = I;
            if (method2 != null) {
                try {
                    method2.invoke(a0Var, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            f2.b(a0Var, true);
        }
        a0Var.setOutsideTouchable(true);
        a0Var.setTouchInterceptor(this.A);
        if (this.f6934s) {
            a.a.M(a0Var, this.f6933r);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = K;
            if (method3 != null) {
                try {
                    method3.invoke(a0Var, this.F);
                } catch (Exception e9) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e9);
                }
            }
        } else {
            f2.a(a0Var, this.F);
        }
        r0.l.a(a0Var, this.f6938w, this.f6929n, this.f6930o, this.f6935t);
        this.f6926k.setSelection(-1);
        if ((!this.G || this.f6926k.isInTouchMode()) && (x1Var = this.f6926k) != null) {
            x1Var.setListSelectionHidden(true);
            x1Var.requestLayout();
        }
        if (this.G) {
            return;
        }
        this.D.post(this.C);
    }

    public final Drawable d() {
        return this.H.getBackground();
    }

    @Override // m.d0
    public final void dismiss() {
        a0 a0Var = this.H;
        a0Var.dismiss();
        a0Var.setContentView(null);
        this.f6926k = null;
        this.D.removeCallbacks(this.f6941z);
    }

    @Override // m.d0
    public final x1 e() {
        return this.f6926k;
    }

    public final void h(Drawable drawable) {
        this.H.setBackgroundDrawable(drawable);
    }

    public final void i(int i9) {
        this.f6930o = i9;
        this.f6932q = true;
    }

    public final void k(int i9) {
        this.f6929n = i9;
    }

    public final int m() {
        if (this.f6932q) {
            return this.f6930o;
        }
        return 0;
    }

    public void o(ListAdapter listAdapter) {
        h2 h2Var = this.f6937v;
        if (h2Var == null) {
            this.f6937v = new h2(this, 0);
        } else {
            ListAdapter listAdapter2 = this.f6925j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(h2Var);
            }
        }
        this.f6925j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f6937v);
        }
        x1 x1Var = this.f6926k;
        if (x1Var != null) {
            x1Var.setAdapter(this.f6925j);
        }
    }

    public x1 p(Context context, boolean z8) {
        return new x1(context, z8);
    }

    public final void r(int i9) {
        Drawable background = this.H.getBackground();
        if (background == null) {
            this.f6928m = i9;
            return;
        }
        Rect rect = this.E;
        background.getPadding(rect);
        this.f6928m = rect.left + rect.right + i9;
    }
}
