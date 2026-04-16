package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.fragment.app.g;
import com.bumptech.glide.d;
import j0.l;
import j0.m;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import l7.a;
import m1.b;
import m7.c;
import n.o;
import n0.c0;
import n0.n;
import n0.t0;
import n0.u0;
import o3.a1;
import o3.b1;
import o3.c1;
import o3.d0;
import o3.d1;
import o3.e0;
import o3.f0;
import o3.f1;
import o3.g0;
import o3.i;
import o3.i0;
import o3.j0;
import o3.k0;
import o3.l0;
import o3.m1;
import o3.o0;
import o3.p0;
import o3.q;
import o3.q0;
import o3.r;
import o3.r0;
import o3.s0;
import o3.t;
import o3.v0;
import o3.w0;
import o3.z;
import o3.z0;
import s.h;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class RecyclerView extends ViewGroup implements n {
    public static final int[] H0 = {R.attr.nestedScrollingEnabled};
    public static final float I0 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean J0;
    public static final boolean K0;
    public static final boolean L0;
    public static final Class[] M0;
    public static final e0 N0;
    public static final a1 O0;
    public boolean A;
    public final int[] A0;
    public boolean B;
    public final ArrayList B0;
    public boolean C;
    public final d0 C0;
    public int D;
    public boolean D0;
    public boolean E;
    public int E0;
    public boolean F;
    public int F0;
    public boolean G;
    public final f0 G0;
    public int H;
    public boolean I;
    public final AccessibilityManager J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public j0 O;
    public EdgeEffect P;
    public EdgeEffect Q;
    public EdgeEffect R;
    public EdgeEffect S;
    public k0 T;
    public int U;
    public int V;
    public VelocityTracker W;

    /* renamed from: a0, reason: collision with root package name */
    public int f1047a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f1048b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f1049c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f1050d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f1051e0;

    /* renamed from: f0, reason: collision with root package name */
    public q0 f1052f0;

    /* renamed from: g0, reason: collision with root package name */
    public final int f1053g0;

    /* renamed from: h0, reason: collision with root package name */
    public final int f1054h0;

    /* renamed from: i, reason: collision with root package name */
    public final float f1055i;
    public final float i0;

    /* renamed from: j, reason: collision with root package name */
    public final v0 f1056j;

    /* renamed from: j0, reason: collision with root package name */
    public final float f1057j0;

    /* renamed from: k, reason: collision with root package name */
    public final a f1058k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f1059k0;

    /* renamed from: l, reason: collision with root package name */
    public w0 f1060l;

    /* renamed from: l0, reason: collision with root package name */
    public final c1 f1061l0;

    /* renamed from: m, reason: collision with root package name */
    public final o f1062m;

    /* renamed from: m0, reason: collision with root package name */
    public t f1063m0;

    /* renamed from: n, reason: collision with root package name */
    public final g f1064n;

    /* renamed from: n0, reason: collision with root package name */
    public final r f1065n0;

    /* renamed from: o, reason: collision with root package name */
    public final b f1066o;

    /* renamed from: o0, reason: collision with root package name */
    public final z0 f1067o0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1068p;

    /* renamed from: p0, reason: collision with root package name */
    public r0 f1069p0;

    /* renamed from: q, reason: collision with root package name */
    public final d0 f1070q;

    /* renamed from: q0, reason: collision with root package name */
    public ArrayList f1071q0;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f1072r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f1073r0;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f1074s;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f1075s0;

    /* renamed from: t, reason: collision with root package name */
    public final RectF f1076t;

    /* renamed from: t0, reason: collision with root package name */
    public final f0 f1077t0;

    /* renamed from: u, reason: collision with root package name */
    public g0 f1078u;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f1079u0;

    /* renamed from: v, reason: collision with root package name */
    public o0 f1080v;

    /* renamed from: v0, reason: collision with root package name */
    public f1 f1081v0;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f1082w;

    /* renamed from: w0, reason: collision with root package name */
    public final int[] f1083w0;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f1084x;

    /* renamed from: x0, reason: collision with root package name */
    public n0.o f1085x0;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f1086y;

    /* renamed from: y0, reason: collision with root package name */
    public final int[] f1087y0;

    /* renamed from: z, reason: collision with root package name */
    public q f1088z;

    /* renamed from: z0, reason: collision with root package name */
    public final int[] f1089z0;

    static {
        J0 = Build.VERSION.SDK_INT >= 23;
        K0 = true;
        L0 = true;
        Class cls = Integer.TYPE;
        M0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        N0 = new e0(0);
        O0 = new a1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerView(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        float a9;
        int i10;
        TypedArray typedArray;
        Throwable th;
        int i11;
        char c9;
        char c10;
        char c11;
        ClassLoader classLoader;
        Constructor constructor;
        Object[] objArr;
        this.f1056j = new v0(this);
        a aVar = new a();
        aVar.h = this;
        ArrayList arrayList = new ArrayList();
        aVar.f6273c = arrayList;
        aVar.f6274d = null;
        aVar.f6275e = new ArrayList();
        aVar.f6276f = Collections.unmodifiableList(arrayList);
        aVar.f6271a = 2;
        aVar.f6272b = 2;
        this.f1058k = aVar;
        this.f1066o = new b(11);
        this.f1070q = new d0(this, 0);
        this.f1072r = new Rect();
        this.f1074s = new Rect();
        this.f1076t = new RectF();
        this.f1082w = new ArrayList();
        this.f1084x = new ArrayList();
        this.f1086y = new ArrayList();
        this.D = 0;
        this.K = false;
        this.L = false;
        this.M = 0;
        this.N = 0;
        this.O = O0;
        i iVar = new i();
        iVar.f7703a = null;
        iVar.f7704b = new ArrayList();
        iVar.f7705c = 120L;
        iVar.f7706d = 120L;
        iVar.f7707e = 250L;
        iVar.f7708f = 250L;
        int i12 = 1;
        iVar.f7677g = true;
        iVar.h = new ArrayList();
        iVar.f7678i = new ArrayList();
        iVar.f7679j = new ArrayList();
        iVar.f7680k = new ArrayList();
        iVar.f7681l = new ArrayList();
        iVar.f7682m = new ArrayList();
        iVar.f7683n = new ArrayList();
        iVar.f7684o = new ArrayList();
        iVar.f7685p = new ArrayList();
        iVar.f7686q = new ArrayList();
        iVar.f7687r = new ArrayList();
        this.T = iVar;
        this.U = 0;
        this.V = -1;
        this.i0 = Float.MIN_VALUE;
        this.f1057j0 = Float.MIN_VALUE;
        this.f1059k0 = true;
        this.f1061l0 = new c1(this);
        this.f1065n0 = L0 ? new r() : null;
        z0 z0Var = new z0();
        z0Var.f7868a = -1;
        z0Var.f7869b = 0;
        z0Var.f7870c = 0;
        z0Var.f7871d = 1;
        z0Var.f7872e = 0;
        z0Var.f7873f = false;
        z0Var.f7874g = false;
        z0Var.h = false;
        z0Var.f7875i = false;
        z0Var.f7876j = false;
        z0Var.f7877k = false;
        this.f1067o0 = z0Var;
        this.f1073r0 = false;
        this.f1075s0 = false;
        f0 f0Var = new f0(this);
        this.f1077t0 = f0Var;
        this.f1079u0 = false;
        this.f1083w0 = new int[2];
        this.f1087y0 = new int[2];
        this.f1089z0 = new int[2];
        this.A0 = new int[2];
        this.B0 = new ArrayList();
        this.C0 = new d0(this, i12);
        this.E0 = 0;
        this.F0 = 0;
        this.G0 = new f0(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1051e0 = viewConfiguration.getScaledTouchSlop();
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 26) {
            Method method = n0.w0.f7225a;
            a9 = u0.a(viewConfiguration);
        } else {
            a9 = n0.w0.a(viewConfiguration, context);
        }
        this.i0 = a9;
        this.f1057j0 = i13 >= 26 ? u0.b(viewConfiguration) : n0.w0.a(viewConfiguration, context);
        this.f1053g0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1054h0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1055i = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.T.f7703a = f0Var;
        this.f1062m = new o(new f0(this));
        this.f1064n = new g(new f0(this));
        WeakHashMap weakHashMap = t0.f7209a;
        if ((i13 >= 26 ? n0.k0.c(this) : 0) == 0 && i13 >= 26) {
            n0.k0.m(this, 8);
        }
        if (c0.c(this) == 0) {
            c0.s(this, 1);
        }
        this.J = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new f1(this));
        int[] iArr = n3.a.f7434a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i9, 0);
        t0.o(this, context, iArr, attributeSet, obtainStyledAttributes, i9);
        String string = obtainStyledAttributes.getString(8);
        if (obtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f1068p = obtainStyledAttributes.getBoolean(1, true);
        if (obtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(6);
            Drawable drawable = obtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                c.n("Trying to set fast scroller without both required drawables.".concat(z()));
                throw null;
            }
            Resources resources = getContext().getResources();
            c10 = 2;
            c11 = 1;
            typedArray = obtainStyledAttributes;
            th = null;
            i11 = 4;
            c9 = 3;
            i10 = i9;
            new q(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(2131165363), resources.getDimensionPixelSize(2131165365), resources.getDimensionPixelOffset(2131165364));
        } else {
            i10 = i9;
            typedArray = obtainStyledAttributes;
            th = null;
            i11 = 4;
            c9 = 3;
            c10 = 2;
            c11 = 1;
        }
        typedArray.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                }
                String str = trim;
                try {
                    try {
                        if (isInEditMode()) {
                            classLoader = getClass().getClassLoader();
                        } else {
                            try {
                                classLoader = context.getClassLoader();
                            } catch (ClassNotFoundException e9) {
                                e = e9;
                                th = null;
                                c.f(attributeSet.getPositionDescription(), ": Unable to find LayoutManager ", str, e);
                                throw th;
                            } catch (IllegalAccessException e10) {
                                e = e10;
                                th = null;
                                c.f(attributeSet.getPositionDescription(), ": Cannot access non-public constructor ", str, e);
                                throw th;
                            } catch (InstantiationException e11) {
                                e = e11;
                                th = null;
                                c.f(attributeSet.getPositionDescription(), ": Could not instantiate the LayoutManager: ", str, e);
                                throw th;
                            } catch (InvocationTargetException e12) {
                                e = e12;
                                th = null;
                                c.f(attributeSet.getPositionDescription(), ": Could not instantiate the LayoutManager: ", str, e);
                                throw th;
                            }
                        }
                        Class<? extends U> asSubclass = Class.forName(str, false, classLoader).asSubclass(o0.class);
                        try {
                            constructor = asSubclass.getConstructor(M0);
                            objArr = new Object[i11];
                            objArr[0] = context;
                            objArr[c11] = attributeSet;
                            objArr[c10] = Integer.valueOf(i10);
                            objArr[c9] = 0;
                        } catch (NoSuchMethodException e13) {
                            try {
                                constructor = asSubclass.getConstructor(th);
                                objArr = null;
                            } catch (NoSuchMethodException e14) {
                                e14.initCause(e13);
                                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e14);
                            }
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((o0) constructor.newInstance(objArr));
                    } catch (ClassCastException e15) {
                        c.f(attributeSet.getPositionDescription(), ": Class is not a LayoutManager ", str, e15);
                        throw null;
                    }
                } catch (ClassNotFoundException e16) {
                    e = e16;
                } catch (IllegalAccessException e17) {
                    e = e17;
                } catch (InstantiationException e18) {
                    e = e18;
                } catch (InvocationTargetException e19) {
                    e = e19;
                }
            }
        }
        int[] iArr2 = H0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i10, 0);
        t0.o(this, context, iArr2, attributeSet, obtainStyledAttributes2, i10);
        boolean z8 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z8);
        setTag(2131362147, Boolean.TRUE);
    }

    public static RecyclerView E(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            RecyclerView E = E(viewGroup.getChildAt(i9));
            if (E != null) {
                return E;
            }
        }
        return null;
    }

    public static d1 J(View view) {
        if (view == null) {
            return null;
        }
        return ((p0) view.getLayoutParams()).f7765a;
    }

    private n0.o getScrollingChildHelper() {
        if (this.f1085x0 == null) {
            this.f1085x0 = new n0.o(this);
        }
        return this.f1085x0;
    }

    public static void j(d1 d1Var) {
        WeakReference weakReference = d1Var.f7619b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == d1Var.f7618a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            d1Var.f7619b = null;
        }
    }

    public static int m(int i9, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i10) {
        if (i9 > 0 && edgeEffect != null && d.D(edgeEffect) != 0.0f) {
            int round = Math.round(d.P(edgeEffect, ((-i9) * 4.0f) / i10, 0.5f) * ((-i10) / 4.0f));
            if (round != i9) {
                edgeEffect.finish();
            }
            return i9 - round;
        }
        if (i9 >= 0 || edgeEffect2 == null || d.D(edgeEffect2) == 0.0f) {
            return i9;
        }
        float f9 = i10;
        int round2 = Math.round(d.P(edgeEffect2, (i9 * 4.0f) / f9, 0.5f) * (f9 / 4.0f));
        if (round2 != i9) {
            edgeEffect2.finish();
        }
        return i9 - round2;
    }

    public final void A(z0 z0Var) {
        if (getScrollState() != 2) {
            z0Var.getClass();
            return;
        }
        OverScroller overScroller = this.f1061l0.f7605k;
        overScroller.getFinalX();
        overScroller.getCurrX();
        z0Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View B(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            return r3
        L17:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.B(android.view.View):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            java.util.ArrayList r1 = r11.f1086y
            int r2 = r1.size()
            r3 = 0
            r4 = 0
        Lc:
            if (r4 >= r2) goto L64
            java.lang.Object r5 = r1.get(r4)
            o3.q r5 = (o3.q) r5
            int r6 = r5.f7789v
            r7 = 1
            r8 = 2
            if (r6 != r7) goto L59
            float r6 = r12.getX()
            float r9 = r12.getY()
            boolean r6 = r5.d(r6, r9)
            float r9 = r12.getX()
            float r10 = r12.getY()
            boolean r9 = r5.c(r9, r10)
            int r10 = r12.getAction()
            if (r10 != 0) goto L61
            if (r6 != 0) goto L3c
            if (r9 == 0) goto L61
        L3c:
            if (r9 == 0) goto L49
            r5.f7790w = r7
            float r6 = r12.getX()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f7783p = r6
            goto L55
        L49:
            if (r6 == 0) goto L55
            r5.f7790w = r8
            float r6 = r12.getY()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f7780m = r6
        L55:
            r5.f(r8)
            goto L5b
        L59:
            if (r6 != r8) goto L61
        L5b:
            r6 = 3
            if (r0 == r6) goto L61
            r11.f1088z = r5
            return r7
        L61:
            int r4 = r4 + 1
            goto Lc
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C(android.view.MotionEvent):boolean");
    }

    public final void D(int[] iArr) {
        int N = this.f1064n.N();
        if (N == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i9 = Integer.MAX_VALUE;
        int i10 = Integer.MIN_VALUE;
        for (int i11 = 0; i11 < N; i11++) {
            d1 J = J(this.f1064n.M(i11));
            if (!J.o()) {
                int b9 = J.b();
                if (b9 < i9) {
                    i9 = b9;
                }
                if (b9 > i10) {
                    i10 = b9;
                }
            }
        }
        iArr[0] = i9;
        iArr[1] = i10;
    }

    public final d1 F(int i9) {
        d1 d1Var = null;
        if (this.K) {
            return null;
        }
        int Z = this.f1064n.Z();
        for (int i10 = 0; i10 < Z; i10++) {
            d1 J = J(this.f1064n.Y(i10));
            if (J != null && !J.h() && G(J) == i9) {
                if (!((ArrayList) this.f1064n.f730l).contains(J.f7618a)) {
                    return J;
                }
                d1Var = J;
            }
        }
        return d1Var;
    }

    public final int G(d1 d1Var) {
        if ((d1Var.f7626j & 524) == 0 && d1Var.e()) {
            int i9 = d1Var.f7620c;
            ArrayList arrayList = (ArrayList) this.f1062m.f6985c;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                o3.a aVar = (o3.a) arrayList.get(i10);
                int i11 = aVar.f7585a;
                if (i11 != 1) {
                    if (i11 == 2) {
                        int i12 = aVar.f7586b;
                        if (i12 <= i9) {
                            int i13 = aVar.f7588d;
                            if (i12 + i13 <= i9) {
                                i9 -= i13;
                            }
                        } else {
                            continue;
                        }
                    } else if (i11 == 8) {
                        int i14 = aVar.f7586b;
                        if (i14 == i9) {
                            i9 = aVar.f7588d;
                        } else {
                            if (i14 < i9) {
                                i9--;
                            }
                            if (aVar.f7588d <= i9) {
                                i9++;
                            }
                        }
                    }
                } else if (aVar.f7586b <= i9) {
                    i9 += aVar.f7588d;
                }
            }
            return i9;
        }
        return -1;
    }

    public final long H(d1 d1Var) {
        return this.f1078u.f7660b ? d1Var.f7622e : d1Var.f7620c;
    }

    public final d1 I(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return J(view);
        }
        androidx.fragment.app.a.i("View ", view, " is not a direct child of ", this);
        return null;
    }

    public final Rect K(View view) {
        p0 p0Var = (p0) view.getLayoutParams();
        boolean z8 = p0Var.f7767c;
        Rect rect = p0Var.f7766b;
        if (!z8 || (this.f1067o0.f7874g && (p0Var.f7765a.k() || p0Var.f7765a.f()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.f1084x;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            Rect rect2 = this.f1072r;
            rect2.set(0, 0, 0, 0);
            ((l0) arrayList.get(i9)).getClass();
            ((p0) view.getLayoutParams()).f7765a.getClass();
            rect2.set(0, 0, 0, 0);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        p0Var.f7767c = false;
        return rect;
    }

    public final boolean L() {
        return !this.C || this.K || this.f1062m.j();
    }

    public final boolean M() {
        return this.M > 0;
    }

    public final void N(int i9) {
        if (this.f1080v == null) {
            return;
        }
        setScrollState(2);
        this.f1080v.m0(i9);
        awakenScrollBars();
    }

    public final void O() {
        int Z = this.f1064n.Z();
        for (int i9 = 0; i9 < Z; i9++) {
            ((p0) this.f1064n.Y(i9).getLayoutParams()).f7767c = true;
        }
        ArrayList arrayList = (ArrayList) this.f1058k.f6275e;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            p0 p0Var = (p0) ((d1) arrayList.get(i10)).f7618a.getLayoutParams();
            if (p0Var != null) {
                p0Var.f7767c = true;
            }
        }
    }

    public final void P(int i9, int i10, boolean z8) {
        int i11 = i9 + i10;
        int Z = this.f1064n.Z();
        for (int i12 = 0; i12 < Z; i12++) {
            d1 J = J(this.f1064n.Y(i12));
            if (J != null && !J.o()) {
                int i13 = J.f7620c;
                z0 z0Var = this.f1067o0;
                if (i13 >= i11) {
                    J.l(-i10, z8);
                    z0Var.f7873f = true;
                } else if (i13 >= i9) {
                    J.a(8);
                    J.l(-i10, z8);
                    J.f7620c = i9 - 1;
                    z0Var.f7873f = true;
                }
            }
        }
        a aVar = this.f1058k;
        ArrayList arrayList = (ArrayList) aVar.f6275e;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            d1 d1Var = (d1) arrayList.get(size);
            if (d1Var != null) {
                int i14 = d1Var.f7620c;
                if (i14 >= i11) {
                    d1Var.l(-i10, z8);
                } else if (i14 >= i9) {
                    d1Var.a(8);
                    aVar.g(size);
                }
            }
        }
        requestLayout();
    }

    public final void Q() {
        this.M++;
    }

    public final void R(boolean z8) {
        int i9;
        AccessibilityManager accessibilityManager;
        int i10 = this.M - 1;
        this.M = i10;
        if (i10 < 1) {
            this.M = 0;
            if (z8) {
                int i11 = this.H;
                this.H = 0;
                if (i11 != 0 && (accessibilityManager = this.J) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(IjkMediaMeta.FF_PROFILE_H264_INTRA);
                    o0.b.b(obtain, i11);
                    sendAccessibilityEventUnchecked(obtain);
                }
                ArrayList arrayList = this.B0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    d1 d1Var = (d1) arrayList.get(size);
                    if (d1Var.f7618a.getParent() == this && !d1Var.o() && (i9 = d1Var.f7633q) != -1) {
                        View view = d1Var.f7618a;
                        WeakHashMap weakHashMap = t0.f7209a;
                        c0.s(view, i9);
                        d1Var.f7633q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void S(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.V) {
            int i9 = actionIndex == 0 ? 1 : 0;
            this.V = motionEvent.getPointerId(i9);
            int x6 = (int) (motionEvent.getX(i9) + 0.5f);
            this.f1049c0 = x6;
            this.f1047a0 = x6;
            int y2 = (int) (motionEvent.getY(i9) + 0.5f);
            this.f1050d0 = y2;
            this.f1048b0 = y2;
        }
    }

    public final void T() {
        if (this.f1079u0 || !this.A) {
            return;
        }
        WeakHashMap weakHashMap = t0.f7209a;
        c0.m(this, this.C0);
        this.f1079u0 = true;
    }

    public final void U() {
        boolean z8;
        boolean z9 = false;
        if (this.K) {
            o oVar = this.f1062m;
            oVar.q((ArrayList) oVar.f6985c);
            oVar.q((ArrayList) oVar.f6986d);
            oVar.f6983a = 0;
            if (this.L) {
                this.f1080v.W();
            }
        }
        boolean z10 = this.T != null && this.f1080v.y0();
        o oVar2 = this.f1062m;
        if (z10) {
            oVar2.p();
        } else {
            oVar2.d();
        }
        boolean z11 = this.f1073r0 || this.f1075s0;
        boolean z12 = this.C && this.T != null && ((z8 = this.K) || z11 || this.f1080v.f7753f) && (!z8 || this.f1078u.f7660b);
        z0 z0Var = this.f1067o0;
        z0Var.f7876j = z12;
        if (z12 && z11 && !this.K && this.T != null && this.f1080v.y0()) {
            z9 = true;
        }
        z0Var.f7877k = z9;
    }

    public final void V(boolean z8) {
        this.L = z8 | this.L;
        this.K = true;
        int Z = this.f1064n.Z();
        for (int i9 = 0; i9 < Z; i9++) {
            d1 J = J(this.f1064n.Y(i9));
            if (J != null && !J.o()) {
                J.a(6);
            }
        }
        O();
        a aVar = this.f1058k;
        ArrayList arrayList = (ArrayList) aVar.f6275e;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            d1 d1Var = (d1) arrayList.get(i10);
            if (d1Var != null) {
                d1Var.a(6);
                d1Var.a(1024);
            }
        }
        g0 g0Var = ((RecyclerView) aVar.h).f1078u;
        if (g0Var == null || !g0Var.f7660b) {
            aVar.f();
        }
    }

    public final void W(d1 d1Var, d1.k0 k0Var) {
        d1Var.f7626j &= -8193;
        boolean z8 = this.f1067o0.h;
        b bVar = this.f1066o;
        if (z8 && d1Var.k() && !d1Var.h() && !d1Var.o()) {
            ((s.g) bVar.f6511k).f(H(d1Var), d1Var);
        }
        h hVar = (h) bVar.f6510j;
        m1 m1Var = (m1) hVar.getOrDefault(d1Var, null);
        if (m1Var == null) {
            m1Var = m1.a();
            hVar.put(d1Var, m1Var);
        }
        m1Var.f7736b = k0Var;
        m1Var.f7735a |= 4;
    }

    public final int X(int i9, float f9) {
        float height = f9 / getHeight();
        float width = i9 / getWidth();
        EdgeEffect edgeEffect = this.P;
        float f10 = 0.0f;
        if (edgeEffect == null || d.D(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.R;
            if (edgeEffect2 != null && d.D(edgeEffect2) != 0.0f) {
                boolean canScrollHorizontally = canScrollHorizontally(1);
                EdgeEffect edgeEffect3 = this.R;
                if (canScrollHorizontally) {
                    edgeEffect3.onRelease();
                } else {
                    float P = d.P(edgeEffect3, width, height);
                    if (d.D(this.R) == 0.0f) {
                        this.R.onRelease();
                    }
                    f10 = P;
                }
                invalidate();
            }
        } else {
            boolean canScrollHorizontally2 = canScrollHorizontally(-1);
            EdgeEffect edgeEffect4 = this.P;
            if (canScrollHorizontally2) {
                edgeEffect4.onRelease();
            } else {
                float f11 = -d.P(edgeEffect4, -width, 1.0f - height);
                if (d.D(this.P) == 0.0f) {
                    this.P.onRelease();
                }
                f10 = f11;
            }
            invalidate();
        }
        return Math.round(f10 * getWidth());
    }

    public final int Y(int i9, float f9) {
        float width = f9 / getWidth();
        float height = i9 / getHeight();
        EdgeEffect edgeEffect = this.Q;
        float f10 = 0.0f;
        if (edgeEffect == null || d.D(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.S;
            if (edgeEffect2 != null && d.D(edgeEffect2) != 0.0f) {
                boolean canScrollVertically = canScrollVertically(1);
                EdgeEffect edgeEffect3 = this.S;
                if (canScrollVertically) {
                    edgeEffect3.onRelease();
                } else {
                    float P = d.P(edgeEffect3, height, 1.0f - width);
                    if (d.D(this.S) == 0.0f) {
                        this.S.onRelease();
                    }
                    f10 = P;
                }
                invalidate();
            }
        } else {
            boolean canScrollVertically2 = canScrollVertically(-1);
            EdgeEffect edgeEffect4 = this.Q;
            if (canScrollVertically2) {
                edgeEffect4.onRelease();
            } else {
                float f11 = -d.P(edgeEffect4, -height, width);
                if (d.D(this.Q) == 0.0f) {
                    this.Q.onRelease();
                }
                f10 = f11;
            }
            invalidate();
        }
        return Math.round(f10 * getHeight());
    }

    public final void Z(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f1072r;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p0) {
            p0 p0Var = (p0) layoutParams;
            if (!p0Var.f7767c) {
                Rect rect2 = p0Var.f7766b;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f1080v.j0(this, view, this.f1072r, !this.C, view2 == null);
    }

    public final void a0() {
        VelocityTracker velocityTracker = this.W;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z8 = false;
        i0(0);
        EdgeEffect edgeEffect = this.P;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z8 = this.P.isFinished();
        }
        EdgeEffect edgeEffect2 = this.Q;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z8 |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect3 = this.R;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z8 |= this.R.isFinished();
        }
        EdgeEffect edgeEffect4 = this.S;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z8 |= this.S.isFinished();
        }
        if (z8) {
            WeakHashMap weakHashMap = t0.f7209a;
            c0.k(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i9, int i10) {
        o0 o0Var = this.f1080v;
        if (o0Var != null) {
            o0Var.getClass();
        }
        super.addFocusables(arrayList, i9, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b0(int r18, int r19, android.view.MotionEvent r20, int r21) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.b0(int, int, android.view.MotionEvent, int):boolean");
    }

    public final void c0(int i9, int i10, int[] iArr) {
        d1 d1Var;
        g0();
        Q();
        int i11 = m.f5347a;
        l.a("RV Scroll");
        z0 z0Var = this.f1067o0;
        A(z0Var);
        a aVar = this.f1058k;
        int l02 = i9 != 0 ? this.f1080v.l0(i9, aVar, z0Var) : 0;
        int n02 = i10 != 0 ? this.f1080v.n0(i10, aVar, z0Var) : 0;
        l.b();
        g gVar = this.f1064n;
        int N = gVar.N();
        for (int i12 = 0; i12 < N; i12++) {
            View M = gVar.M(i12);
            d1 I = I(M);
            if (I != null && (d1Var = I.f7625i) != null) {
                View view = d1Var.f7618a;
                int left = M.getLeft();
                int top = M.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        R(true);
        h0(false);
        if (iArr != null) {
            iArr[0] = l02;
            iArr[1] = n02;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p0) && this.f1080v.f((p0) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        o0 o0Var = this.f1080v;
        if (o0Var != null && o0Var.d()) {
            return this.f1080v.j(this.f1067o0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        o0 o0Var = this.f1080v;
        if (o0Var != null && o0Var.d()) {
            return this.f1080v.k(this.f1067o0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        o0 o0Var = this.f1080v;
        if (o0Var != null && o0Var.d()) {
            return this.f1080v.l(this.f1067o0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        o0 o0Var = this.f1080v;
        if (o0Var != null && o0Var.e()) {
            return this.f1080v.m(this.f1067o0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        o0 o0Var = this.f1080v;
        if (o0Var != null && o0Var.e()) {
            return this.f1080v.n(this.f1067o0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        o0 o0Var = this.f1080v;
        if (o0Var != null && o0Var.e()) {
            return this.f1080v.o(this.f1067o0);
        }
        return 0;
    }

    public final void d0(int i9) {
        z zVar;
        if (this.F) {
            return;
        }
        setScrollState(0);
        c1 c1Var = this.f1061l0;
        c1Var.f7609o.removeCallbacks(c1Var);
        c1Var.f7605k.abortAnimation();
        o0 o0Var = this.f1080v;
        if (o0Var != null && (zVar = o0Var.f7752e) != null) {
            zVar.i();
        }
        o0 o0Var2 = this.f1080v;
        if (o0Var2 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            o0Var2.m0(i9);
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f9, float f10, boolean z8) {
        return getScrollingChildHelper().a(f9, f10, z8);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f9, float f10) {
        return getScrollingChildHelper().b(f9, f10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i9, int i10, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i9, i10, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i9, int i10, int i11, int i12, int[] iArr) {
        return getScrollingChildHelper().d(i9, i10, i11, i12, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z8;
        super.draw(canvas);
        ArrayList arrayList = this.f1084x;
        int size = arrayList.size();
        boolean z9 = false;
        for (int i9 = 0; i9 < size; i9++) {
            ((l0) arrayList.get(i9)).b(canvas, this);
        }
        EdgeEffect edgeEffect = this.P;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z8 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f1068p ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.P;
            z8 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.Q;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f1068p) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.Q;
            z8 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.R;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f1068p ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.R;
            z8 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.S;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1068p) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.S;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z9 = true;
            }
            z8 |= z9;
            canvas.restoreToCount(save4);
        }
        if ((z8 || this.T == null || arrayList.size() <= 0 || !this.T.f()) ? z8 : true) {
            WeakHashMap weakHashMap = t0.f7209a;
            c0.k(this);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        return super.drawChild(canvas, view, j5);
    }

    public final boolean e0(EdgeEffect edgeEffect, int i9, int i10) {
        if (i9 > 0) {
            return true;
        }
        float D = d.D(edgeEffect) * i10;
        float abs = Math.abs(-i9) * 0.35f;
        float f9 = this.f1055i * 0.015f;
        double log = Math.log(abs / f9);
        double d9 = I0;
        return ((float) (Math.exp((d9 / (d9 - 1.0d)) * log) * ((double) f9))) < D;
    }

    public final void f(d1 d1Var) {
        View view = d1Var.f7618a;
        boolean z8 = view.getParent() == this;
        this.f1058k.l(I(view));
        boolean j5 = d1Var.j();
        g gVar = this.f1064n;
        if (j5) {
            gVar.y(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z8) {
            gVar.x(view, -1, true);
            return;
        }
        int indexOfChild = ((f0) gVar.f728j).f7650a.indexOfChild(view);
        if (indexOfChild < 0) {
            androidx.fragment.app.a.n(view, "view is not a child, cannot hide ");
        } else {
            ((b2.d0) gVar.f729k).y(indexOfChild);
            gVar.b0(view);
        }
    }

    public final void f0(int i9, int i10, boolean z8) {
        o0 o0Var = this.f1080v;
        if (o0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.F) {
            return;
        }
        if (!o0Var.d()) {
            i9 = 0;
        }
        if (!this.f1080v.e()) {
            i10 = 0;
        }
        if (i9 == 0 && i10 == 0) {
            return;
        }
        if (z8) {
            int i11 = i9 != 0 ? 1 : 0;
            if (i10 != 0) {
                i11 |= 2;
            }
            getScrollingChildHelper().g(i11, 1);
        }
        this.f1061l0.c(i9, i10, Integer.MIN_VALUE, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0197, code lost:
    
        if ((r5 * r6) >= 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0161, code lost:
    
        if (r7 > 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x017f, code lost:
    
        if (r5 > 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0182, code lost:
    
        if (r7 < 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0185, code lost:
    
        if (r5 < 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x018e, code lost:
    
        if ((r5 * r6) <= 0) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x019b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0153  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g(l0 l0Var) {
        o0 o0Var = this.f1080v;
        if (o0Var != null) {
            o0Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f1084x;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(l0Var);
        O();
        requestLayout();
    }

    public final void g0() {
        int i9 = this.D + 1;
        this.D = i9;
        if (i9 != 1 || this.F) {
            return;
        }
        this.E = false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o0 o0Var = this.f1080v;
        if (o0Var != null) {
            return o0Var.r();
        }
        c.p("RecyclerView has no LayoutManager".concat(z()));
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o0 o0Var = this.f1080v;
        if (o0Var != null) {
            return o0Var.s(getContext(), attributeSet);
        }
        c.p("RecyclerView has no LayoutManager".concat(z()));
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g0 getAdapter() {
        return this.f1078u;
    }

    @Override // android.view.View
    public int getBaseline() {
        o0 o0Var = this.f1080v;
        if (o0Var == null) {
            return super.getBaseline();
        }
        o0Var.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i9, int i10) {
        return super.getChildDrawingOrder(i9, i10);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f1068p;
    }

    public f1 getCompatAccessibilityDelegate() {
        return this.f1081v0;
    }

    public j0 getEdgeEffectFactory() {
        return this.O;
    }

    public k0 getItemAnimator() {
        return this.T;
    }

    public int getItemDecorationCount() {
        return this.f1084x.size();
    }

    public o0 getLayoutManager() {
        return this.f1080v;
    }

    public int getMaxFlingVelocity() {
        return this.f1054h0;
    }

    public int getMinFlingVelocity() {
        return this.f1053g0;
    }

    public long getNanoTime() {
        if (L0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public q0 getOnFlingListener() {
        return this.f1052f0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1059k0;
    }

    public o3.t0 getRecycledViewPool() {
        return this.f1058k.c();
    }

    public int getScrollState() {
        return this.U;
    }

    public final void h(r0 r0Var) {
        if (this.f1071q0 == null) {
            this.f1071q0 = new ArrayList();
        }
        this.f1071q0.add(r0Var);
    }

    public final void h0(boolean z8) {
        if (this.D < 1) {
            this.D = 1;
        }
        if (!z8 && !this.F) {
            this.E = false;
        }
        if (this.D == 1) {
            if (z8 && this.E && !this.F && this.f1080v != null && this.f1078u != null) {
                p();
            }
            if (!this.F) {
                this.E = false;
            }
        }
        this.D--;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i(String str) {
        if (!M()) {
            if (this.N > 0) {
                Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(z()));
            }
        } else if (str == null) {
            c.p("Cannot call this method while RecyclerView is computing a layout or scrolling".concat(z()));
        } else {
            c.p(str);
        }
    }

    public final void i0(int i9) {
        getScrollingChildHelper().h(i9);
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.A;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.F;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f7185d;
    }

    public final void k() {
        int Z = this.f1064n.Z();
        for (int i9 = 0; i9 < Z; i9++) {
            d1 J = J(this.f1064n.Y(i9));
            if (!J.o()) {
                J.f7621d = -1;
                J.f7624g = -1;
            }
        }
        a aVar = this.f1058k;
        ArrayList arrayList = (ArrayList) aVar.f6273c;
        ArrayList arrayList2 = (ArrayList) aVar.f6275e;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            d1 d1Var = (d1) arrayList2.get(i10);
            d1Var.f7621d = -1;
            d1Var.f7624g = -1;
        }
        int size2 = arrayList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            d1 d1Var2 = (d1) arrayList.get(i11);
            d1Var2.f7621d = -1;
            d1Var2.f7624g = -1;
        }
        ArrayList arrayList3 = (ArrayList) aVar.f6274d;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i12 = 0; i12 < size3; i12++) {
                d1 d1Var3 = (d1) ((ArrayList) aVar.f6274d).get(i12);
                d1Var3.f7621d = -1;
                d1Var3.f7624g = -1;
            }
        }
    }

    public final void l(int i9, int i10) {
        boolean z8;
        EdgeEffect edgeEffect = this.P;
        if (edgeEffect == null || edgeEffect.isFinished() || i9 <= 0) {
            z8 = false;
        } else {
            this.P.onRelease();
            z8 = this.P.isFinished();
        }
        EdgeEffect edgeEffect2 = this.R;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i9 < 0) {
            this.R.onRelease();
            z8 |= this.R.isFinished();
        }
        EdgeEffect edgeEffect3 = this.Q;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i10 > 0) {
            this.Q.onRelease();
            z8 |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect4 = this.S;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i10 < 0) {
            this.S.onRelease();
            z8 |= this.S.isFinished();
        }
        if (z8) {
            WeakHashMap weakHashMap = t0.f7209a;
            c0.k(this);
        }
    }

    public final void n() {
        if (!this.C || this.K) {
            int i9 = m.f5347a;
            l.a("RV FullInvalidate");
            p();
            l.b();
            return;
        }
        o oVar = this.f1062m;
        if (oVar.j()) {
            int i10 = oVar.f6983a;
            if ((i10 & 4) == 0 || (i10 & 11) != 0) {
                if (oVar.j()) {
                    int i11 = m.f5347a;
                    l.a("RV FullInvalidate");
                    p();
                    l.b();
                    return;
                }
                return;
            }
            int i12 = m.f5347a;
            l.a("RV PartialInvalidate");
            g0();
            Q();
            oVar.p();
            if (!this.E) {
                g gVar = this.f1064n;
                int N = gVar.N();
                int i13 = 0;
                while (true) {
                    if (i13 < N) {
                        d1 J = J(gVar.M(i13));
                        if (J != null && !J.o() && J.k()) {
                            p();
                            break;
                        }
                        i13++;
                    } else {
                        oVar.c();
                        break;
                    }
                }
            }
            h0(true);
            R(true);
            l.b();
        }
    }

    public final void o(int i9, int i10) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = t0.f7209a;
        setMeasuredDimension(o0.g(i9, paddingRight, c0.e(this)), o0.g(i10, getPaddingBottom() + getPaddingTop(), c0.d(this)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.M = r0
            r1 = 1
            r5.A = r1
            boolean r2 = r5.C
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = 1
            goto L16
        L15:
            r2 = 0
        L16:
            r5.C = r2
            l7.a r2 = r5.f1058k
            r2.d()
            o3.o0 r2 = r5.f1080v
            if (r2 == 0) goto L23
            r2.f7754g = r1
        L23:
            r5.f1079u0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.L0
            if (r0 == 0) goto L78
            java.lang.ThreadLocal r0 = o3.t.f7807m
            java.lang.Object r1 = r0.get()
            o3.t r1 = (o3.t) r1
            r5.f1063m0 = r1
            if (r1 != 0) goto L71
            o3.t r1 = new o3.t
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f7809i = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f7812l = r2
            r5.f1063m0 = r1
            java.util.WeakHashMap r1 = n0.t0.f7209a
            android.view.Display r1 = n0.d0.b(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L63
            if (r1 == 0) goto L63
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L63
            goto L65
        L63:
            r1 = 1114636288(0x42700000, float:60.0)
        L65:
            o3.t r2 = r5.f1063m0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f7811k = r3
            r0.set(r2)
        L71:
            o3.t r0 = r5.f1063m0
            java.util.ArrayList r0 = r0.f7809i
            r0.add(r5)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        t tVar;
        z zVar;
        super.onDetachedFromWindow();
        k0 k0Var = this.T;
        if (k0Var != null) {
            k0Var.e();
        }
        int i9 = 0;
        setScrollState(0);
        c1 c1Var = this.f1061l0;
        c1Var.f7609o.removeCallbacks(c1Var);
        c1Var.f7605k.abortAnimation();
        o0 o0Var = this.f1080v;
        if (o0Var != null && (zVar = o0Var.f7752e) != null) {
            zVar.i();
        }
        this.A = false;
        o0 o0Var2 = this.f1080v;
        if (o0Var2 != null) {
            o0Var2.f7754g = false;
            o0Var2.P(this);
        }
        this.B0.clear();
        removeCallbacks(this.C0);
        this.f1066o.getClass();
        while (m1.f7734d.b() != null) {
        }
        a aVar = this.f1058k;
        ArrayList arrayList = (ArrayList) aVar.f6275e;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            a.a.d(((d1) arrayList.get(i10)).f7618a);
        }
        aVar.e(((RecyclerView) aVar.h).f1078u, false);
        while (i9 < getChildCount()) {
            int i11 = i9 + 1;
            View childAt = getChildAt(i9);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            t0.a aVar2 = (t0.a) childAt.getTag(2131362286);
            if (aVar2 == null) {
                aVar2 = new t0.a();
                childAt.setTag(2131362286, aVar2);
            }
            ArrayList arrayList2 = aVar2.f8915a;
            arrayList2.getClass();
            int size = arrayList2.size() - 1;
            if (-1 < size) {
                arrayList2.get(size).getClass();
                androidx.fragment.app.a.c();
                return;
            }
            i9 = i11;
        }
        if (!L0 || (tVar = this.f1063m0) == null) {
            return;
        }
        tVar.f7809i.remove(this);
        this.f1063m0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f1084x;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((l0) arrayList.get(i9)).a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z8;
        boolean z9;
        if (!this.F) {
            this.f1088z = null;
            if (C(motionEvent)) {
                a0();
                setScrollState(0);
                return true;
            }
            o0 o0Var = this.f1080v;
            if (o0Var != null) {
                boolean d9 = o0Var.d();
                boolean e9 = this.f1080v.e();
                if (this.W == null) {
                    this.W = VelocityTracker.obtain();
                }
                this.W.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.G) {
                        this.G = false;
                    }
                    this.V = motionEvent.getPointerId(0);
                    int x6 = (int) (motionEvent.getX() + 0.5f);
                    this.f1049c0 = x6;
                    this.f1047a0 = x6;
                    int y2 = (int) (motionEvent.getY() + 0.5f);
                    this.f1050d0 = y2;
                    this.f1048b0 = y2;
                    EdgeEffect edgeEffect = this.P;
                    if (edgeEffect == null || d.D(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                        z8 = false;
                    } else {
                        d.P(this.P, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                        z8 = true;
                    }
                    EdgeEffect edgeEffect2 = this.R;
                    if (edgeEffect2 != null && d.D(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
                        d.P(this.R, 0.0f, motionEvent.getY() / getHeight());
                        z8 = true;
                    }
                    EdgeEffect edgeEffect3 = this.Q;
                    if (edgeEffect3 != null && d.D(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
                        d.P(this.Q, 0.0f, motionEvent.getX() / getWidth());
                        z8 = true;
                    }
                    EdgeEffect edgeEffect4 = this.S;
                    if (edgeEffect4 != null && d.D(edgeEffect4) != 0.0f && !canScrollVertically(1)) {
                        d.P(this.S, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                        z8 = true;
                    }
                    if (z8 || this.U == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        i0(1);
                    }
                    int[] iArr = this.f1089z0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i9 = d9;
                    if (e9) {
                        i9 = (d9 ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i9, 0);
                } else if (actionMasked == 1) {
                    this.W.clear();
                    i0(0);
                } else if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.V);
                    if (findPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.V + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x8 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.U != 1) {
                        int i10 = x8 - this.f1047a0;
                        int i11 = y3 - this.f1048b0;
                        if (d9 == 0 || Math.abs(i10) <= this.f1051e0) {
                            z9 = false;
                        } else {
                            this.f1049c0 = x8;
                            z9 = true;
                        }
                        if (e9 && Math.abs(i11) > this.f1051e0) {
                            this.f1050d0 = y3;
                            z9 = true;
                        }
                        if (z9) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    a0();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.V = motionEvent.getPointerId(actionIndex);
                    int x9 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.f1049c0 = x9;
                    this.f1047a0 = x9;
                    int y7 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.f1050d0 = y7;
                    this.f1048b0 = y7;
                } else if (actionMasked == 6) {
                    S(motionEvent);
                }
                if (this.U == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int i13 = m.f5347a;
        l.a("RV OnLayout");
        p();
        l.b();
        this.C = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        o0 o0Var = this.f1080v;
        if (o0Var == null) {
            o(i9, i10);
            return;
        }
        boolean J = o0Var.J();
        boolean z8 = false;
        z0 z0Var = this.f1067o0;
        if (J) {
            int mode = View.MeasureSpec.getMode(i9);
            int mode2 = View.MeasureSpec.getMode(i10);
            this.f1080v.f7749b.o(i9, i10);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z8 = true;
            }
            this.D0 = z8;
            if (z8 || this.f1078u == null) {
                return;
            }
            if (z0Var.f7871d == 1) {
                q();
            }
            this.f1080v.p0(i9, i10);
            z0Var.f7875i = true;
            r();
            this.f1080v.r0(i9, i10);
            if (this.f1080v.u0()) {
                this.f1080v.p0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                z0Var.f7875i = true;
                r();
                this.f1080v.r0(i9, i10);
            }
            this.E0 = getMeasuredWidth();
            this.F0 = getMeasuredHeight();
            return;
        }
        if (this.B) {
            this.f1080v.f7749b.o(i9, i10);
            return;
        }
        if (this.I) {
            g0();
            Q();
            U();
            R(true);
            if (z0Var.f7877k) {
                z0Var.f7874g = true;
            } else {
                this.f1062m.d();
                z0Var.f7874g = false;
            }
            this.I = false;
            h0(false);
        } else if (z0Var.f7877k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g0 g0Var = this.f1078u;
        if (g0Var != null) {
            z0Var.f7872e = g0Var.a();
        } else {
            z0Var.f7872e = 0;
        }
        g0();
        this.f1080v.f7749b.o(i9, i10);
        h0(false);
        z0Var.f7874g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i9, Rect rect) {
        if (M()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i9, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof w0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        w0 w0Var = (w0) parcelable;
        this.f1060l = w0Var;
        super.onRestoreInstanceState(w0Var.f8991i);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        w0 w0Var = new w0(super.onSaveInstanceState());
        w0 w0Var2 = this.f1060l;
        if (w0Var2 != null) {
            w0Var.f7831k = w0Var2.f7831k;
            return w0Var;
        }
        o0 o0Var = this.f1080v;
        if (o0Var != null) {
            w0Var.f7831k = o0Var.d0();
            return w0Var;
        }
        w0Var.f7831k = null;
        return w0Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        if (i9 == i11 && i10 == i12) {
            return;
        }
        this.S = null;
        this.Q = null;
        this.R = null;
        this.P = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x03a5, code lost:
    
        if (r3 == 0) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x04c3, code lost:
    
        if (r2 < r5) goto L272;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0389 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r25) {
        /*
            Method dump skipped, instructions count: 1331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x033e, code lost:
    
        if (((java.util.ArrayList) r21.f1064n.f730l).contains(getFocusedChild()) == false) goto L225;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03ea  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [o3.d1] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x009f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0083 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.q():void");
    }

    public final void r() {
        g0();
        Q();
        z0 z0Var = this.f1067o0;
        z0Var.a(6);
        this.f1062m.d();
        z0Var.f7872e = this.f1078u.a();
        z0Var.f7870c = 0;
        if (this.f1060l != null) {
            g0 g0Var = this.f1078u;
            int a9 = v.h.a(g0Var.f7661c);
            if (a9 == 1 ? g0Var.a() > 0 : a9 != 2) {
                Parcelable parcelable = this.f1060l.f7831k;
                if (parcelable != null) {
                    this.f1080v.c0(parcelable);
                }
                this.f1060l = null;
            }
        }
        z0Var.f7874g = false;
        this.f1080v.a0(this.f1058k, z0Var);
        z0Var.f7873f = false;
        z0Var.f7876j = z0Var.f7876j && this.T != null;
        z0Var.f7871d = 4;
        R(true);
        h0(false);
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z8) {
        d1 J = J(view);
        if (J != null) {
            if (J.j()) {
                J.f7626j &= -257;
            } else if (!J.o()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + J + z());
            }
        }
        view.clearAnimation();
        J(view);
        super.removeDetachedView(view, z8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        z zVar = this.f1080v.f7752e;
        if ((zVar == null || !zVar.f7857e) && !M() && view2 != null) {
            Z(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z8) {
        return this.f1080v.j0(this, view, rect, z8, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z8) {
        ArrayList arrayList = this.f1086y;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((q) arrayList.get(i9)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z8);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.D != 0 || this.F) {
            this.E = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean s(int i9, int i10, int[] iArr, int[] iArr2, int i11) {
        return getScrollingChildHelper().c(i9, i10, iArr, iArr2, i11);
    }

    @Override // android.view.View
    public final void scrollBy(int i9, int i10) {
        o0 o0Var = this.f1080v;
        if (o0Var == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.F) {
            return;
        }
        boolean d9 = o0Var.d();
        boolean e9 = this.f1080v.e();
        if (d9 || e9) {
            if (!d9) {
                i9 = 0;
            }
            if (!e9) {
                i10 = 0;
            }
            b0(i9, i10, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i9, int i10) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!M()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int a9 = accessibilityEvent != null ? o0.b.a(accessibilityEvent) : 0;
            this.H |= a9 != 0 ? a9 : 0;
        }
    }

    public void setAccessibilityDelegateCompat(f1 f1Var) {
        this.f1081v0 = f1Var;
        t0.p(this, f1Var);
    }

    public void setAdapter(g0 g0Var) {
        setLayoutFrozen(false);
        g0 g0Var2 = this.f1078u;
        v0 v0Var = this.f1056j;
        if (g0Var2 != null) {
            g0Var2.f7659a.unregisterObserver(v0Var);
            this.f1078u.getClass();
        }
        k0 k0Var = this.T;
        if (k0Var != null) {
            k0Var.e();
        }
        o0 o0Var = this.f1080v;
        a aVar = this.f1058k;
        if (o0Var != null) {
            o0Var.f0(aVar);
            this.f1080v.g0(aVar);
        }
        ((ArrayList) aVar.f6273c).clear();
        aVar.f();
        o oVar = this.f1062m;
        oVar.q((ArrayList) oVar.f6985c);
        oVar.q((ArrayList) oVar.f6986d);
        oVar.f6983a = 0;
        g0 g0Var3 = this.f1078u;
        this.f1078u = g0Var;
        if (g0Var != null) {
            g0Var.f7659a.registerObserver(v0Var);
        }
        o0 o0Var2 = this.f1080v;
        if (o0Var2 != null) {
            o0Var2.O();
        }
        g0 g0Var4 = this.f1078u;
        ((ArrayList) aVar.f6273c).clear();
        aVar.f();
        aVar.e(g0Var3, true);
        o3.t0 c9 = aVar.c();
        if (g0Var3 != null) {
            c9.f7814b--;
        }
        if (c9.f7814b == 0) {
            SparseArray sparseArray = c9.f7813a;
            for (int i9 = 0; i9 < sparseArray.size(); i9++) {
                s0 s0Var = (s0) sparseArray.valueAt(i9);
                ArrayList arrayList = s0Var.f7803a;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    a.a.d(((d1) obj).f7618a);
                }
                s0Var.f7803a.clear();
            }
        }
        if (g0Var4 != null) {
            c9.f7814b++;
        }
        aVar.d();
        this.f1067o0.f7873f = true;
        V(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(i0 i0Var) {
        if (i0Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z8) {
        if (z8 != this.f1068p) {
            this.S = null;
            this.Q = null;
            this.R = null;
            this.P = null;
        }
        this.f1068p = z8;
        super.setClipToPadding(z8);
        if (this.C) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(j0 j0Var) {
        j0Var.getClass();
        this.O = j0Var;
        this.S = null;
        this.Q = null;
        this.R = null;
        this.P = null;
    }

    public void setHasFixedSize(boolean z8) {
        this.B = z8;
    }

    public void setItemAnimator(k0 k0Var) {
        k0 k0Var2 = this.T;
        if (k0Var2 != null) {
            k0Var2.e();
            this.T.f7703a = null;
        }
        this.T = k0Var;
        if (k0Var != null) {
            k0Var.f7703a = this.f1077t0;
        }
    }

    public void setItemViewCacheSize(int i9) {
        a aVar = this.f1058k;
        aVar.f6271a = i9;
        aVar.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z8) {
        suppressLayout(z8);
    }

    public void setLayoutManager(o0 o0Var) {
        RecyclerView recyclerView;
        z zVar;
        if (o0Var == this.f1080v) {
            return;
        }
        setScrollState(0);
        c1 c1Var = this.f1061l0;
        c1Var.f7609o.removeCallbacks(c1Var);
        c1Var.f7605k.abortAnimation();
        o0 o0Var2 = this.f1080v;
        if (o0Var2 != null && (zVar = o0Var2.f7752e) != null) {
            zVar.i();
        }
        o0 o0Var3 = this.f1080v;
        a aVar = this.f1058k;
        if (o0Var3 != null) {
            k0 k0Var = this.T;
            if (k0Var != null) {
                k0Var.e();
            }
            this.f1080v.f0(aVar);
            this.f1080v.g0(aVar);
            ((ArrayList) aVar.f6273c).clear();
            aVar.f();
            if (this.A) {
                o0 o0Var4 = this.f1080v;
                o0Var4.f7754g = false;
                o0Var4.P(this);
            }
            this.f1080v.s0(null);
            this.f1080v = null;
        } else {
            ((ArrayList) aVar.f6273c).clear();
            aVar.f();
        }
        g gVar = this.f1064n;
        ((b2.d0) gVar.f729k).x();
        ArrayList arrayList = (ArrayList) gVar.f730l;
        int size = arrayList.size() - 1;
        while (true) {
            recyclerView = ((f0) gVar.f728j).f7650a;
            if (size < 0) {
                break;
            }
            d1 J = J((View) arrayList.get(size));
            if (J != null) {
                int i9 = J.f7632p;
                if (recyclerView.M()) {
                    J.f7633q = i9;
                    recyclerView.B0.add(J);
                } else {
                    View view = J.f7618a;
                    WeakHashMap weakHashMap = t0.f7209a;
                    c0.s(view, i9);
                }
                J.f7632p = 0;
            }
            arrayList.remove(size);
            size--;
        }
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            J(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f1080v = o0Var;
        if (o0Var != null) {
            if (o0Var.f7749b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(o0Var);
                String z8 = o0Var.f7749b.z();
                sb.append(" is already attached to a RecyclerView:");
                sb.append(z8);
                throw new IllegalArgumentException(sb.toString());
            }
            o0Var.s0(this);
            if (this.A) {
                this.f1080v.f7754g = true;
            }
        }
        aVar.m();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
        } else {
            c.n("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z8) {
        n0.o scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f7185d) {
            ViewGroup viewGroup = scrollingChildHelper.f7184c;
            WeakHashMap weakHashMap = t0.f7209a;
            n0.i0.z(viewGroup);
        }
        scrollingChildHelper.f7185d = z8;
    }

    public void setOnFlingListener(q0 q0Var) {
        this.f1052f0 = q0Var;
    }

    @Deprecated
    public void setOnScrollListener(r0 r0Var) {
        this.f1069p0 = r0Var;
    }

    public void setPreserveFocusAfterLayout(boolean z8) {
        this.f1059k0 = z8;
    }

    public void setRecycledViewPool(o3.t0 t0Var) {
        a aVar = this.f1058k;
        RecyclerView recyclerView = (RecyclerView) aVar.h;
        aVar.e(recyclerView.f1078u, false);
        if (((o3.t0) aVar.f6277g) != null) {
            r2.f7814b--;
        }
        aVar.f6277g = t0Var;
        if (t0Var != null && recyclerView.getAdapter() != null) {
            ((o3.t0) aVar.f6277g).f7814b++;
        }
        aVar.d();
    }

    public void setScrollState(int i9) {
        z zVar;
        if (i9 == this.U) {
            return;
        }
        this.U = i9;
        if (i9 != 2) {
            c1 c1Var = this.f1061l0;
            c1Var.f7609o.removeCallbacks(c1Var);
            c1Var.f7605k.abortAnimation();
            o0 o0Var = this.f1080v;
            if (o0Var != null && (zVar = o0Var.f7752e) != null) {
                zVar.i();
            }
        }
        o0 o0Var2 = this.f1080v;
        if (o0Var2 != null) {
            o0Var2.e0(i9);
        }
        r0 r0Var = this.f1069p0;
        if (r0Var != null) {
            r0Var.a(this, i9);
        }
        ArrayList arrayList = this.f1071q0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((r0) this.f1071q0.get(size)).a(this, i9);
            }
        }
    }

    public void setScrollingTouchSlop(int i9) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i9 != 0) {
            if (i9 == 1) {
                this.f1051e0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i9 + "; using default value");
        }
        this.f1051e0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(b1 b1Var) {
        this.f1058k.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i9) {
        return getScrollingChildHelper().g(i9, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z8) {
        z zVar;
        if (z8 != this.F) {
            i("Do not suppressLayout in layout or scroll");
            if (!z8) {
                this.F = false;
                if (this.E && this.f1080v != null && this.f1078u != null) {
                    requestLayout();
                }
                this.E = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.F = true;
            this.G = true;
            setScrollState(0);
            c1 c1Var = this.f1061l0;
            c1Var.f7609o.removeCallbacks(c1Var);
            c1Var.f7605k.abortAnimation();
            o0 o0Var = this.f1080v;
            if (o0Var == null || (zVar = o0Var.f7752e) == null) {
                return;
            }
            zVar.i();
        }
    }

    public final void t(int i9, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        getScrollingChildHelper().d(i9, i10, i11, i12, iArr, i13, iArr2);
    }

    public final void u(int i9, int i10) {
        this.N++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i9, scrollY - i10);
        r0 r0Var = this.f1069p0;
        if (r0Var != null) {
            r0Var.b(this, i9, i10);
        }
        ArrayList arrayList = this.f1071q0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((r0) this.f1071q0.get(size)).b(this, i9, i10);
            }
        }
        this.N--;
    }

    public final void v() {
        if (this.S != null) {
            return;
        }
        ((a1) this.O).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.S = edgeEffect;
        if (this.f1068p) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void w() {
        if (this.P != null) {
            return;
        }
        ((a1) this.O).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.P = edgeEffect;
        if (this.f1068p) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void x() {
        if (this.R != null) {
            return;
        }
        ((a1) this.O).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.R = edgeEffect;
        if (this.f1068p) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void y() {
        if (this.Q != null) {
            return;
        }
        ((a1) this.O).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.Q = edgeEffect;
        if (this.f1068p) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String z() {
        return " " + super.toString() + ", adapter:" + this.f1078u + ", layout:" + this.f1080v + ", context:" + getContext();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o0 o0Var = this.f1080v;
        if (o0Var != null) {
            return o0Var.t(layoutParams);
        }
        c.p("RecyclerView has no LayoutManager".concat(z()));
        return null;
    }

    @Deprecated
    public void setRecyclerListener(o3.u0 u0Var) {
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130969451);
    }
}
