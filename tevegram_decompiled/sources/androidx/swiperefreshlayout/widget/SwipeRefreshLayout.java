package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import d1.k0;
import java.util.WeakHashMap;
import n0.c0;
import n0.i0;
import n0.n;
import n0.o;
import n0.p;
import n0.q;
import n0.t0;
import t3.a;
import t3.d;
import t3.e;
import t3.f;
import t3.g;
import t3.h;
import t3.i;
import t3.j;
import t3.k;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements q, p, n {
    public static final int[] S = {R.attr.enabled};
    public final DecelerateInterpolator A;
    public final a B;
    public int C;
    public int D;
    public final int E;
    public final int F;
    public int G;
    public final e H;
    public g I;
    public g J;
    public h K;
    public h L;
    public boolean M;
    public int N;
    public boolean O;
    public final f P;
    public final g Q;
    public final g R;

    /* renamed from: i, reason: collision with root package name */
    public View f1102i;

    /* renamed from: j, reason: collision with root package name */
    public j f1103j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1104k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1105l;

    /* renamed from: m, reason: collision with root package name */
    public float f1106m;

    /* renamed from: n, reason: collision with root package name */
    public float f1107n;

    /* renamed from: o, reason: collision with root package name */
    public final k0 f1108o;

    /* renamed from: p, reason: collision with root package name */
    public final o f1109p;

    /* renamed from: q, reason: collision with root package name */
    public final int[] f1110q;

    /* renamed from: r, reason: collision with root package name */
    public final int[] f1111r;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f1112s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1113t;

    /* renamed from: u, reason: collision with root package name */
    public final int f1114u;

    /* renamed from: v, reason: collision with root package name */
    public int f1115v;

    /* renamed from: w, reason: collision with root package name */
    public float f1116w;

    /* renamed from: x, reason: collision with root package name */
    public float f1117x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1118y;

    /* renamed from: z, reason: collision with root package name */
    public int f1119z;

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1104k = false;
        this.f1106m = -1.0f;
        this.f1110q = new int[2];
        this.f1111r = new int[2];
        this.f1112s = new int[2];
        this.f1119z = -1;
        this.C = -1;
        this.P = new f(this, 0);
        this.Q = new g(this, 2);
        this.R = new g(this, 3);
        this.f1105l = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f1114u = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.A = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.N = (int) (displayMetrics.density * 40.0f);
        a aVar = new a(getContext());
        float f9 = aVar.getContext().getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = aVar.getContext().obtainStyledAttributes(s3.a.f8801a);
        aVar.f8919j = obtainStyledAttributes.getColor(0, -328966);
        obtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        WeakHashMap weakHashMap = t0.f7209a;
        i0.s(aVar, f9 * 4.0f);
        shapeDrawable.getPaint().setColor(aVar.f8919j);
        c0.q(aVar, shapeDrawable);
        this.B = aVar;
        e eVar = new e(getContext());
        this.H = eVar;
        eVar.c(1);
        this.B.setImageDrawable(this.H);
        this.B.setVisibility(8);
        addView(this.B);
        setChildrenDrawingOrderEnabled(true);
        int i9 = (int) (displayMetrics.density * 64.0f);
        this.F = i9;
        this.f1106m = i9;
        this.f1108o = new k0();
        this.f1109p = new o(this);
        setNestedScrollingEnabled(true);
        int i10 = -this.N;
        this.f1115v = i10;
        this.E = i10;
        k(1.0f);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, S);
        setEnabled(obtainStyledAttributes2.getBoolean(0, true));
        obtainStyledAttributes2.recycle();
    }

    private void setColorViewAlpha(int i9) {
        this.B.getBackground().setAlpha(i9);
        this.H.setAlpha(i9);
    }

    @Override // n0.p
    public final void a(View view, View view2, int i9, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i9);
        }
    }

    @Override // n0.p
    public final void b(View view, int i9) {
        if (i9 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // n0.p
    public final void c(View view, int i9, int i10, int[] iArr, int i11) {
        if (i11 == 0) {
            onNestedPreScroll(view, i9, i10, iArr);
        }
    }

    @Override // n0.q
    public final void d(View view, int i9, int i10, int i11, int i12, int i13, int[] iArr) {
        if (i13 != 0) {
            return;
        }
        int i14 = iArr[1];
        if (i13 == 0) {
            this.f1109p.d(i9, i10, i11, i12, this.f1111r, i13, iArr);
        }
        int i15 = i12 - (iArr[1] - i14);
        if ((i15 == 0 ? i12 + this.f1111r[1] : i15) >= 0 || g()) {
            return;
        }
        float abs = this.f1107n + Math.abs(r14);
        this.f1107n = abs;
        j(abs);
        iArr[1] = iArr[1] + i15;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f9, float f10, boolean z8) {
        return this.f1109p.a(f9, f10, z8);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f9, float f10) {
        return this.f1109p.b(f9, f10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i9, int i10, int[] iArr, int[] iArr2) {
        return this.f1109p.c(i9, i10, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i9, int i10, int i11, int i12, int[] iArr) {
        return this.f1109p.d(i9, i10, i11, i12, iArr, 0, null);
    }

    @Override // n0.p
    public final void e(View view, int i9, int i10, int i11, int i12, int i13) {
        d(view, i9, i10, i11, i12, i13, this.f1112s);
    }

    @Override // n0.p
    public final boolean f(View view, View view2, int i9, int i10) {
        if (i10 == 0) {
            return onStartNestedScroll(view, view2, i9);
        }
        return false;
    }

    public final boolean g() {
        View view = this.f1102i;
        return view instanceof ListView ? r0.h.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i9, int i10) {
        int i11 = this.C;
        return i11 < 0 ? i10 : i10 == i9 + (-1) ? i11 : i10 >= i11 ? i10 + 1 : i10;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        k0 k0Var = this.f1108o;
        return k0Var.f2493b | k0Var.f2492a;
    }

    public int getProgressCircleDiameter() {
        return this.N;
    }

    public int getProgressViewEndOffset() {
        return this.F;
    }

    public int getProgressViewStartOffset() {
        return this.E;
    }

    public final void h() {
        if (this.f1102i == null) {
            for (int i9 = 0; i9 < getChildCount(); i9++) {
                View childAt = getChildAt(i9);
                if (!childAt.equals(this.B)) {
                    this.f1102i = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f1109p.f(0);
    }

    public final void i(float f9) {
        if (f9 > this.f1106m) {
            m(true, true);
            return;
        }
        this.f1104k = false;
        e eVar = this.H;
        d dVar = eVar.f8947i;
        dVar.f8928e = 0.0f;
        dVar.f8929f = 0.0f;
        eVar.invalidateSelf();
        f fVar = new f(this, 1);
        this.D = this.f1115v;
        g gVar = this.R;
        gVar.reset();
        gVar.setDuration(200L);
        gVar.setInterpolator(this.A);
        a aVar = this.B;
        aVar.f8918i = fVar;
        aVar.clearAnimation();
        this.B.startAnimation(gVar);
        e eVar2 = this.H;
        d dVar2 = eVar2.f8947i;
        if (dVar2.f8936n) {
            dVar2.f8936n = false;
        }
        eVar2.invalidateSelf();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f1109p.f7185d;
    }

    public final void j(float f9) {
        h hVar;
        h hVar2;
        e eVar = this.H;
        d dVar = eVar.f8947i;
        if (!dVar.f8936n) {
            dVar.f8936n = true;
        }
        eVar.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f9 / this.f1106m));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f9) - this.f1106m;
        int i9 = this.G;
        if (i9 <= 0) {
            i9 = this.F;
        }
        float f10 = i9;
        double max2 = Math.max(0.0f, Math.min(abs, f10 * 2.0f) / f10) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i10 = this.E + ((int) ((f10 * min) + (f10 * pow * 2.0f)));
        if (this.B.getVisibility() != 0) {
            this.B.setVisibility(0);
        }
        this.B.setScaleX(1.0f);
        this.B.setScaleY(1.0f);
        float f11 = this.f1106m;
        e eVar2 = this.H;
        if (f9 < f11) {
            if (eVar2.f8947i.f8942t > 76 && ((hVar2 = this.K) == null || !hVar2.hasStarted() || hVar2.hasEnded())) {
                h hVar3 = new h(this, this.H.f8947i.f8942t, 76);
                hVar3.setDuration(300L);
                a aVar = this.B;
                aVar.f8918i = null;
                aVar.clearAnimation();
                this.B.startAnimation(hVar3);
                this.K = hVar3;
            }
        } else if (eVar2.f8947i.f8942t < 255 && ((hVar = this.L) == null || !hVar.hasStarted() || hVar.hasEnded())) {
            h hVar4 = new h(this, this.H.f8947i.f8942t, 255);
            hVar4.setDuration(300L);
            a aVar2 = this.B;
            aVar2.f8918i = null;
            aVar2.clearAnimation();
            this.B.startAnimation(hVar4);
            this.L = hVar4;
        }
        float min2 = Math.min(0.8f, max * 0.8f);
        e eVar3 = this.H;
        d dVar2 = eVar3.f8947i;
        dVar2.f8928e = 0.0f;
        dVar2.f8929f = min2;
        eVar3.invalidateSelf();
        float min3 = Math.min(1.0f, max);
        e eVar4 = this.H;
        d dVar3 = eVar4.f8947i;
        if (min3 != dVar3.f8938p) {
            dVar3.f8938p = min3;
        }
        eVar4.invalidateSelf();
        e eVar5 = this.H;
        eVar5.f8947i.f8930g = ((pow * 2.0f) + ((max * 0.4f) - 0.25f)) * 0.5f;
        eVar5.invalidateSelf();
        setTargetOffsetTopAndBottom(i10 - this.f1115v);
    }

    public final void k(float f9) {
        setTargetOffsetTopAndBottom((this.D + ((int) ((this.E - r0) * f9))) - this.B.getTop());
    }

    public final void l() {
        this.B.clearAnimation();
        this.H.stop();
        this.B.setVisibility(8);
        setColorViewAlpha(255);
        setTargetOffsetTopAndBottom(this.E - this.f1115v);
        this.f1115v = this.B.getTop();
    }

    public final void m(boolean z8, boolean z9) {
        if (this.f1104k != z8) {
            this.M = z9;
            h();
            this.f1104k = z8;
            f fVar = this.P;
            if (!z8) {
                g gVar = new g(this, 1);
                this.J = gVar;
                gVar.setDuration(150L);
                a aVar = this.B;
                aVar.f8918i = fVar;
                aVar.clearAnimation();
                this.B.startAnimation(this.J);
                return;
            }
            this.D = this.f1115v;
            g gVar2 = this.Q;
            gVar2.reset();
            gVar2.setDuration(200L);
            gVar2.setInterpolator(this.A);
            if (fVar != null) {
                this.B.f8918i = fVar;
            }
            this.B.clearAnimation();
            this.B.startAnimation(gVar2);
        }
    }

    public final void n(float f9) {
        float f10 = this.f1117x;
        float f11 = f9 - f10;
        float f12 = this.f1105l;
        if (f11 <= f12 || this.f1118y) {
            return;
        }
        this.f1116w = f10 + f12;
        this.f1118y = true;
        this.H.setAlpha(76);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        h();
        int actionMasked = motionEvent.getActionMasked();
        if (isEnabled() && !g() && !this.f1104k && !this.f1113t) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i9 = this.f1119z;
                        if (i9 == -1) {
                            Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        }
                        int findPointerIndex = motionEvent.findPointerIndex(i9);
                        if (findPointerIndex >= 0) {
                            n(motionEvent.getY(findPointerIndex));
                        }
                    } else if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionIndex) == this.f1119z) {
                                this.f1119z = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                            }
                        }
                    }
                    return this.f1118y;
                }
                this.f1118y = false;
                this.f1119z = -1;
                return this.f1118y;
            }
            setTargetOffsetTopAndBottom(this.E - this.B.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f1119z = pointerId;
            this.f1118y = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 >= 0) {
                this.f1117x = motionEvent.getY(findPointerIndex2);
                return this.f1118y;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f1102i == null) {
            h();
        }
        View view = this.f1102i;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.B.getMeasuredWidth();
        int measuredHeight2 = this.B.getMeasuredHeight();
        int i13 = measuredWidth / 2;
        int i14 = measuredWidth2 / 2;
        int i15 = this.f1115v;
        this.B.layout(i13 - i14, i15, i13 + i14, measuredHeight2 + i15);
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (this.f1102i == null) {
            h();
        }
        View view = this.f1102i;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.B.measure(View.MeasureSpec.makeMeasureSpec(this.N, 1073741824), View.MeasureSpec.makeMeasureSpec(this.N, 1073741824));
        this.C = -1;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == this.B) {
                this.C = i11;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f9, float f10, boolean z8) {
        return this.f1109p.a(f9, f10, z8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f9, float f10) {
        return this.f1109p.b(f9, f10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i9, int i10, int[] iArr) {
        if (i10 > 0) {
            float f9 = this.f1107n;
            if (f9 > 0.0f) {
                float f10 = i10;
                if (f10 > f9) {
                    iArr[1] = (int) f9;
                    this.f1107n = 0.0f;
                } else {
                    this.f1107n = f9 - f10;
                    iArr[1] = i10;
                }
                j(this.f1107n);
            }
        }
        int i11 = i9 - iArr[0];
        int i12 = i10 - iArr[1];
        int[] iArr2 = this.f1110q;
        if (dispatchNestedPreScroll(i11, i12, iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12) {
        d(view, i9, i10, i11, i12, 0, this.f1112s);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i9) {
        this.f1108o.f2492a = i9;
        startNestedScroll(i9 & 2);
        this.f1107n = 0.0f;
        this.f1113t = true;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.getSuperState());
        setRefreshing(kVar.f8960i);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new k(super.onSaveInstanceState(), this.f1104k);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i9) {
        return (!isEnabled() || this.f1104k || (i9 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        this.f1108o.f2492a = 0;
        this.f1113t = false;
        float f9 = this.f1107n;
        if (f9 > 0.0f) {
            i(f9);
            this.f1107n = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (isEnabled() && !g() && !this.f1104k && !this.f1113t) {
            if (actionMasked == 0) {
                this.f1119z = motionEvent.getPointerId(0);
                this.f1118y = false;
                return true;
            }
            if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f1119z);
                if (findPointerIndex < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f1118y) {
                    float y2 = (motionEvent.getY(findPointerIndex) - this.f1116w) * 0.5f;
                    this.f1118y = false;
                    i(y2);
                }
                this.f1119z = -1;
                return false;
            }
            if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f1119z);
                if (findPointerIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y3 = motionEvent.getY(findPointerIndex2);
                n(y3);
                if (this.f1118y) {
                    float f9 = (y3 - this.f1116w) * 0.5f;
                    if (f9 > 0.0f) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        j(f9);
                    }
                }
                return true;
            }
            if (actionMasked != 3) {
                if (actionMasked != 5) {
                    if (actionMasked == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == this.f1119z) {
                            this.f1119z = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                            return true;
                        }
                    }
                    return true;
                }
                int actionIndex2 = motionEvent.getActionIndex();
                if (actionIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f1119z = motionEvent.getPointerId(actionIndex2);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z8) {
        ViewParent parent;
        View view = this.f1102i;
        if (view != null) {
            WeakHashMap weakHashMap = t0.f7209a;
            if (!i0.p(view)) {
                if (this.O || (parent = getParent()) == null) {
                    return;
                }
                parent.requestDisallowInterceptTouchEvent(z8);
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z8);
    }

    public void setAnimationProgress(float f9) {
        this.B.setScaleX(f9);
        this.B.setScaleY(f9);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        h();
        e eVar = this.H;
        d dVar = eVar.f8947i;
        dVar.f8931i = iArr;
        dVar.a(0);
        dVar.a(0);
        eVar.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i9 = 0; i9 < iArr.length; i9++) {
            iArr2[i9] = a.a.t(context, iArr[i9]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i9) {
        this.f1106m = i9;
    }

    @Override // android.view.View
    public void setEnabled(boolean z8) {
        super.setEnabled(z8);
        if (z8) {
            return;
        }
        l();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z8) {
        this.O = z8;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z8) {
        o oVar = this.f1109p;
        if (oVar.f7185d) {
            ViewGroup viewGroup = oVar.f7184c;
            WeakHashMap weakHashMap = t0.f7209a;
            i0.z(viewGroup);
        }
        oVar.f7185d = z8;
    }

    public void setOnRefreshListener(j jVar) {
        this.f1103j = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i9) {
        setProgressBackgroundColorSchemeResource(i9);
    }

    public void setProgressBackgroundColorSchemeColor(int i9) {
        this.B.setBackgroundColor(i9);
    }

    public void setProgressBackgroundColorSchemeResource(int i9) {
        setProgressBackgroundColorSchemeColor(a.a.t(getContext(), i9));
    }

    public void setRefreshing(boolean z8) {
        if (!z8 || this.f1104k == z8) {
            m(z8, false);
            return;
        }
        this.f1104k = z8;
        setTargetOffsetTopAndBottom((this.F + this.E) - this.f1115v);
        this.M = false;
        this.B.setVisibility(0);
        this.H.setAlpha(255);
        g gVar = new g(this, 0);
        this.I = gVar;
        gVar.setDuration(this.f1114u);
        f fVar = this.P;
        if (fVar != null) {
            this.B.f8918i = fVar;
        }
        this.B.clearAnimation();
        this.B.startAnimation(this.I);
    }

    public void setSize(int i9) {
        if (i9 == 0 || i9 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i9 == 0) {
                this.N = (int) (displayMetrics.density * 56.0f);
            } else {
                this.N = (int) (displayMetrics.density * 40.0f);
            }
            this.B.setImageDrawable(null);
            this.H.c(i9);
            this.B.setImageDrawable(this.H);
        }
    }

    public void setSlingshotDistance(int i9) {
        this.G = i9;
    }

    public void setTargetOffsetTopAndBottom(int i9) {
        this.B.bringToFront();
        t0.k(this.B, i9);
        this.f1115v = this.B.getTop();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i9) {
        return this.f1109p.g(i9, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.f1109p.h(0);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }
}
