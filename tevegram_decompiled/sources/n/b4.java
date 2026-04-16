package n;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b4 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: s, reason: collision with root package name */
    public static b4 f6801s;

    /* renamed from: t, reason: collision with root package name */
    public static b4 f6802t;

    /* renamed from: i, reason: collision with root package name */
    public final View f6803i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f6804j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6805k;

    /* renamed from: l, reason: collision with root package name */
    public final a4 f6806l;

    /* renamed from: m, reason: collision with root package name */
    public final a4 f6807m;

    /* renamed from: n, reason: collision with root package name */
    public int f6808n;

    /* renamed from: o, reason: collision with root package name */
    public int f6809o;

    /* renamed from: p, reason: collision with root package name */
    public c4 f6810p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6811q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6812r;

    /* JADX WARN: Type inference failed for: r0v0, types: [n.a4] */
    /* JADX WARN: Type inference failed for: r0v1, types: [n.a4] */
    public b4(View view, CharSequence charSequence) {
        final int i9 = 0;
        this.f6806l = new Runnable(this) { // from class: n.a4

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ b4 f6787j;

            {
                this.f6787j = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i9) {
                    case 0:
                        this.f6787j.c(false);
                        break;
                    default:
                        this.f6787j.a();
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f6807m = new Runnable(this) { // from class: n.a4

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ b4 f6787j;

            {
                this.f6787j = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i10) {
                    case 0:
                        this.f6787j.c(false);
                        break;
                    default:
                        this.f6787j.a();
                        break;
                }
            }
        };
        this.f6803i = view;
        this.f6804j = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = n0.w0.f7225a;
        this.f6805k = Build.VERSION.SDK_INT >= 28 ? n0.v0.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.f6812r = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(b4 b4Var) {
        b4 b4Var2 = f6801s;
        if (b4Var2 != null) {
            b4Var2.f6803i.removeCallbacks(b4Var2.f6806l);
        }
        f6801s = b4Var;
        if (b4Var != null) {
            b4Var.f6803i.postDelayed(b4Var.f6806l, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        b4 b4Var = f6802t;
        View view = this.f6803i;
        if (b4Var == this) {
            f6802t = null;
            c4 c4Var = this.f6810p;
            if (c4Var != null) {
                View view2 = (View) c4Var.f6835b;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) c4Var.f6834a).getSystemService("window")).removeView(view2);
                }
                this.f6810p = null;
                this.f6812r = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f6801s == this) {
            b(null);
        }
        view.removeCallbacks(this.f6807m);
    }

    public final void c(boolean z8) {
        int height;
        int i9;
        int i10;
        boolean z9;
        int i11;
        char c9;
        long longPressTimeout;
        long j5;
        long j9;
        WeakHashMap weakHashMap = n0.t0.f7209a;
        View view = this.f6803i;
        if (n0.f0.b(view)) {
            b(null);
            b4 b4Var = f6802t;
            if (b4Var != null) {
                b4Var.a();
            }
            f6802t = this;
            this.f6811q = z8;
            Context context = view.getContext();
            c4 c4Var = new c4();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            c4Var.f6837d = layoutParams;
            c4Var.f6838e = new Rect();
            c4Var.f6839f = new int[2];
            c4Var.f6840g = new int[2];
            c4Var.f6834a = context;
            View inflate = LayoutInflater.from(context).inflate(2131558427, (ViewGroup) null);
            c4Var.f6835b = inflate;
            c4Var.f6836c = (TextView) inflate.findViewById(2131362200);
            layoutParams.setTitle(c4.class.getSimpleName());
            layoutParams.packageName = context.getPackageName();
            layoutParams.type = 1002;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = 2132017156;
            layoutParams.flags = 24;
            View view2 = (View) c4Var.f6835b;
            Context context2 = (Context) c4Var.f6834a;
            this.f6810p = c4Var;
            int i12 = this.f6808n;
            int i13 = this.f6809o;
            boolean z10 = this.f6811q;
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) c4Var.f6837d;
            if (view2.getParent() != null && view2.getParent() != null) {
                ((WindowManager) context2.getSystemService("window")).removeView(view2);
            }
            ((TextView) c4Var.f6836c).setText(this.f6804j);
            int[] iArr = (int[]) c4Var.f6840g;
            int[] iArr2 = (int[]) c4Var.f6839f;
            Rect rect = (Rect) c4Var.f6838e;
            layoutParams2.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(2131166010);
            if (view.getWidth() < dimensionPixelOffset) {
                i12 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(2131166009);
                height = i13 + dimensionPixelOffset2;
                i9 = i13 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i9 = 0;
            }
            layoutParams2.gravity = 49;
            int dimensionPixelOffset3 = context2.getResources().getDimensionPixelOffset(z10 ? 2131166013 : 2131166012);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
            int i14 = i12;
            if (!(layoutParams3 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams3).type != 2) {
                Context context3 = view.getContext();
                while (true) {
                    if (!(context3 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context3 instanceof Activity) {
                        rootView = ((Activity) context3).getWindow().getDecorView();
                        break;
                    }
                    context3 = ((ContextWrapper) context3).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i10 = i9;
                    z9 = z10;
                    i11 = 0;
                    c9 = 1;
                } else {
                    Resources resources = context2.getResources();
                    c9 = 1;
                    i10 = i9;
                    z9 = z10;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i11 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(iArr);
                view.getLocationOnScreen(iArr2);
                int i15 = iArr2[i11] - iArr[i11];
                iArr2[i11] = i15;
                iArr2[c9] = iArr2[c9] - iArr[c9];
                layoutParams2.x = (i15 + i14) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, i11);
                view2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i16 = iArr2[c9];
                int i17 = ((i16 + i10) - dimensionPixelOffset3) - measuredHeight;
                int i18 = i16 + height + dimensionPixelOffset3;
                if (z9) {
                    if (i17 >= 0) {
                        layoutParams2.y = i17;
                    } else {
                        layoutParams2.y = i18;
                    }
                } else if (measuredHeight + i18 <= rect.height()) {
                    layoutParams2.y = i18;
                } else {
                    layoutParams2.y = i17;
                }
            }
            ((WindowManager) context2.getSystemService("window")).addView(view2, layoutParams2);
            view.addOnAttachStateChangeListener(this);
            if (this.f6811q) {
                j9 = 2500;
            } else {
                if ((n0.c0.g(view) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j5 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j5 = 15000;
                }
                j9 = j5 - longPressTimeout;
            }
            a4 a4Var = this.f6807m;
            view.removeCallbacks(a4Var);
            view.postDelayed(a4Var, j9);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (java.lang.Math.abs(r5 - r3.f6809o) <= r2) goto L30;
     */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            n.c4 r4 = r3.f6810p
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.f6811q
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.f6803i
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.f6812r = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            n.c4 r4 = r3.f6810p
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.f6812r
            if (r1 != 0) goto L66
            int r1 = r3.f6808n
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f6805k
            if (r1 > r2) goto L66
            int r1 = r3.f6809o
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.f6808n = r4
            r3.f6809o = r5
            r3.f6812r = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n.b4.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f6808n = view.getWidth() / 2;
        this.f6809o = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
