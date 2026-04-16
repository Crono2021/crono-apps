package androidx.core.widget;

import a5.d;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.google.android.material.datepicker.g;
import d1.k0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m7.c;
import n0.c0;
import n0.i0;
import n0.n;
import n0.o;
import n0.q;
import n0.t0;
import r0.e;
import r0.i;
import r0.j;
import r0.k;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class NestedScrollView extends FrameLayout implements q, n {
    public static final float J = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final g K = new g(3);
    public static final int[] L = {R.attr.fillViewport};
    public final int[] A;
    public final int[] B;
    public int C;
    public int D;
    public k E;
    public final k0 F;
    public final o G;
    public float H;
    public j I;

    /* renamed from: i, reason: collision with root package name */
    public final float f588i;

    /* renamed from: j, reason: collision with root package name */
    public long f589j;

    /* renamed from: k, reason: collision with root package name */
    public final Rect f590k;

    /* renamed from: l, reason: collision with root package name */
    public final OverScroller f591l;

    /* renamed from: m, reason: collision with root package name */
    public final EdgeEffect f592m;

    /* renamed from: n, reason: collision with root package name */
    public final EdgeEffect f593n;

    /* renamed from: o, reason: collision with root package name */
    public int f594o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f595p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f596q;

    /* renamed from: r, reason: collision with root package name */
    public View f597r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f598s;

    /* renamed from: t, reason: collision with root package name */
    public VelocityTracker f599t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f600u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f601v;

    /* renamed from: w, reason: collision with root package name */
    public final int f602w;

    /* renamed from: x, reason: collision with root package name */
    public final int f603x;

    /* renamed from: y, reason: collision with root package name */
    public final int f604y;

    /* renamed from: z, reason: collision with root package name */
    public int f605z;

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969387);
        this.f590k = new Rect();
        this.f595p = true;
        this.f596q = false;
        this.f597r = null;
        this.f598s = false;
        this.f601v = true;
        this.f605z = -1;
        this.A = new int[2];
        this.B = new int[2];
        int i9 = Build.VERSION.SDK_INT;
        this.f592m = i9 >= 31 ? e.a(context, attributeSet) : new EdgeEffect(context);
        this.f593n = i9 >= 31 ? e.a(context, attributeSet) : new EdgeEffect(context);
        this.f588i = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f591l = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f602w = viewConfiguration.getScaledTouchSlop();
        this.f603x = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f604y = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L, 2130969387, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.F = new k0();
        this.G = new o(this);
        setNestedScrollingEnabled(true);
        t0.p(this, K);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.H == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                c.p("Expected theme to define listPreferredItemHeight.");
                return 0.0f;
            }
            this.H = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.H;
    }

    public static boolean l(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && l((View) parent, nestedScrollView);
    }

    @Override // n0.p
    public final void a(View view, View view2, int i9, int i10) {
        k0 k0Var = this.F;
        if (i10 == 1) {
            k0Var.f2493b = i9;
        } else {
            k0Var.f2492a = i9;
        }
        this.G.g(2, i10);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
        } else {
            c.p("ScrollView can host only one direct child");
        }
    }

    @Override // n0.p
    public final void b(View view, int i9) {
        k0 k0Var = this.F;
        if (i9 == 1) {
            k0Var.f2493b = 0;
        } else {
            k0Var.f2492a = 0;
        }
        w(i9);
    }

    @Override // n0.p
    public final void c(View view, int i9, int i10, int[] iArr, int i11) {
        this.G.c(i9, i10, iArr, null, i11);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void computeScroll() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? (scrollY - max) + bottom : bottom;
    }

    @Override // n0.q
    public final void d(View view, int i9, int i10, int i11, int i12, int i13, int[] iArr) {
        n(i12, i13, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || i(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f9, float f10, boolean z8) {
        return this.G.a(f9, f10, z8);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f9, float f10) {
        return this.G.b(f9, f10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i9, int i10, int[] iArr, int[] iArr2) {
        return this.G.c(i9, i10, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i9, int i10, int i11, int i12, int[] iArr) {
        return this.G.d(i9, i10, i11, i12, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i9;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f592m;
        int i10 = 0;
        if (!edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (i.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                i9 = getPaddingLeft();
            } else {
                i9 = 0;
            }
            if (i.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate(i9, min);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                WeakHashMap weakHashMap = t0.f7209a;
                c0.k(this);
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect2 = this.f593n;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int save2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getScrollRange(), scrollY) + height2;
        if (i.a(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            i10 = getPaddingLeft();
        }
        if (i.a(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            max -= getPaddingBottom();
        }
        canvas.translate(i10 - width2, max);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            WeakHashMap weakHashMap2 = t0.f7209a;
            c0.k(this);
        }
        canvas.restoreToCount(save2);
    }

    @Override // n0.p
    public final void e(View view, int i9, int i10, int i11, int i12, int i13) {
        n(i12, i13, null);
    }

    @Override // n0.p
    public final boolean f(View view, View view2, int i9, int i10) {
        return (i9 & 2) != 0;
    }

    public final boolean g(int i9) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i9);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m(findNextFocus, maxScrollAmount, getHeight())) {
            if (i9 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i9 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i9 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            s(maxScrollAmount, 0, 1, true);
        } else {
            Rect rect = this.f590k;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            s(h(rect), 0, 1, true);
            findNextFocus.requestFocus(i9);
        }
        if (findFocus != null && findFocus.isFocused() && !m(findFocus, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        k0 k0Var = this.F;
        return k0Var.f2493b | k0Var.f2492a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public final int h(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i9 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i10 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i9 - verticalFadingEdgeLength : i9;
        int i11 = rect.bottom;
        if (i11 > i10 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i10, (childAt.getBottom() + layoutParams.bottomMargin) - i9);
        }
        if (rect.top >= scrollY || i11 >= i10) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i10 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.G.f(0);
    }

    public final boolean i(KeyEvent keyEvent) {
        this.f590k.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode == 19) {
                        return keyEvent.isAltPressed() ? k(33) : g(33);
                    }
                    if (keyCode == 20) {
                        return keyEvent.isAltPressed() ? k(130) : g(130);
                    }
                    if (keyCode == 62) {
                        q(keyEvent.isShiftPressed() ? 33 : 130);
                        return false;
                    }
                    if (keyCode == 92) {
                        return k(33);
                    }
                    if (keyCode == 93) {
                        return k(130);
                    }
                    if (keyCode == 122) {
                        q(33);
                        return false;
                    }
                    if (keyCode == 123) {
                        q(130);
                        return false;
                    }
                }
                return false;
            }
        }
        if (isFocused() && keyEvent.getKeyCode() != 4) {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus != null && findNextFocus != this && findNextFocus.requestFocus(130)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.G.f7185d;
    }

    public final void j(int i9) {
        if (getChildCount() > 0) {
            this.f591l.fling(getScrollX(), getScrollY(), 0, i9, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.G.g(2, 1);
            this.D = getScrollY();
            WeakHashMap weakHashMap = t0.f7209a;
            c0.k(this);
        }
    }

    public final boolean k(int i9) {
        int childCount;
        boolean z8 = i9 == 130;
        int height = getHeight();
        Rect rect = this.f590k;
        rect.top = 0;
        rect.bottom = height;
        if (z8 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return r(i9, rect.top, rect.bottom);
    }

    public final boolean m(View view, int i9, int i10) {
        Rect rect = this.f590k;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i9 >= getScrollY() && rect.top - i9 <= getScrollY() + i10;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i9, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i9, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i9, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i9, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final void n(int i9, int i10, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i9);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.G.d(0, scrollY2, 0, i9 - scrollY2, null, i10, iArr);
    }

    public final void o(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f605z) {
            int i9 = actionIndex == 0 ? 1 : 0;
            this.f594o = (int) motionEvent.getY(i9);
            this.f605z = motionEvent.getPointerId(i9);
            VelocityTracker velocityTracker = this.f599t;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f596q = false;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f9;
        int i9;
        if (motionEvent.getAction() == 8 && !this.f598s) {
            if ((motionEvent.getSource() & 2) == 2) {
                f9 = motionEvent.getAxisValue(9);
                i9 = (int) motionEvent.getX();
            } else if ((motionEvent.getSource() & 4194304) == 4194304) {
                f9 = motionEvent.getAxisValue(26);
                i9 = getWidth() / 2;
            } else {
                f9 = 0.0f;
                i9 = 0;
            }
            if (f9 != 0.0f) {
                s(-((int) (f9 * getVerticalScrollFactorCompat())), i9, 1, (motionEvent.getSource() & 8194) == 8194);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z8 = true;
        if (action == 2 && this.f598s) {
            return true;
        }
        int i9 = action & 255;
        if (i9 != 0) {
            if (i9 != 1) {
                if (i9 == 2) {
                    int i10 = this.f605z;
                    if (i10 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i10);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i10 + " in onInterceptTouchEvent");
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.f594o) > this.f602w && (2 & getNestedScrollAxes()) == 0) {
                                this.f598s = true;
                                this.f594o = y2;
                                if (this.f599t == null) {
                                    this.f599t = VelocityTracker.obtain();
                                }
                                this.f599t.addMovement(motionEvent);
                                this.C = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i9 != 3) {
                    if (i9 == 6) {
                        o(motionEvent);
                    }
                }
            }
            this.f598s = false;
            this.f605z = -1;
            VelocityTracker velocityTracker = this.f599t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f599t = null;
            }
            if (this.f591l.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                WeakHashMap weakHashMap = t0.f7209a;
                c0.k(this);
            }
            w(0);
        } else {
            int y3 = (int) motionEvent.getY();
            int x6 = (int) motionEvent.getX();
            int childCount = getChildCount();
            OverScroller overScroller = this.f591l;
            if (childCount > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y3 >= childAt.getTop() - scrollY && y3 < childAt.getBottom() - scrollY && x6 >= childAt.getLeft() && x6 < childAt.getRight()) {
                    this.f594o = y3;
                    this.f605z = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker2 = this.f599t;
                    if (velocityTracker2 == null) {
                        this.f599t = VelocityTracker.obtain();
                    } else {
                        velocityTracker2.clear();
                    }
                    this.f599t.addMovement(motionEvent);
                    overScroller.computeScrollOffset();
                    if (!v(motionEvent) && overScroller.isFinished()) {
                        z8 = false;
                    }
                    this.f598s = z8;
                    this.G.g(2, 0);
                }
            }
            if (!v(motionEvent) && overScroller.isFinished()) {
                z8 = false;
            }
            this.f598s = z8;
            VelocityTracker velocityTracker3 = this.f599t;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f599t = null;
            }
        }
        return this.f598s;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int i13;
        super.onLayout(z8, i9, i10, i11, i12);
        int i14 = 0;
        this.f595p = false;
        View view = this.f597r;
        if (view != null && l(view, this)) {
            View view2 = this.f597r;
            Rect rect = this.f590k;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int h = h(rect);
            if (h != 0) {
                scrollBy(0, h);
            }
        }
        this.f597r = null;
        if (!this.f596q) {
            if (this.E != null) {
                scrollTo(getScrollX(), this.E.f8514i);
                this.E = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i13 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i13 = 0;
            }
            int paddingTop = ((i12 - i10) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i13 && scrollY >= 0) {
                i14 = paddingTop + scrollY > i13 ? i13 - paddingTop : scrollY;
            }
            if (i14 != scrollY) {
                scrollTo(getScrollX(), i14);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f596q = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (this.f600u && View.MeasureSpec.getMode(i10) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i9, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f9, float f10, boolean z8) {
        if (z8) {
            return false;
        }
        dispatchNestedFling(0.0f, f10, true);
        j((int) f10);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f9, float f10) {
        return this.G.b(f9, f10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i9, int i10, int[] iArr) {
        this.G.c(i9, i10, iArr, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12) {
        n(i12, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i9) {
        a(view, view2, i9, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i9, int i10, boolean z8, boolean z9) {
        super.scrollTo(i9, i10);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i9, Rect rect) {
        if (i9 == 2) {
            i9 = 130;
        } else if (i9 == 1) {
            i9 = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i9) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i9);
        if (findNextFocus != null && m(findNextFocus, 0, getHeight())) {
            return findNextFocus.requestFocus(i9, rect);
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof k)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.getSuperState());
        this.E = kVar;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        k kVar = new k(super.onSaveInstanceState());
        kVar.f8514i = getScrollY();
        return kVar;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i9, int i10, int i11, int i12) {
        super.onScrollChanged(i9, i10, i11, i12);
        j jVar = this.I;
        if (jVar != null) {
            d dVar = (d) jVar;
            g.i.b(this, (View) dVar.f174j, (View) dVar.f175k);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !m(findFocus, 0, i12)) {
            return;
        }
        Rect rect = this.f590k;
        findFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(findFocus, rect);
        int h = h(rect);
        if (h != 0) {
            if (this.f601v) {
                u(0, h, false);
            } else {
                scrollBy(0, h);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i9) {
        return f(view, view2, i9, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0147  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r21) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean p(int i9, int i10, int i11, int i12) {
        int i13;
        boolean z8;
        int i14;
        boolean z9;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i15 = i11 + i9;
        if (i10 <= 0 && i10 >= 0) {
            i13 = i10;
            z8 = false;
        } else {
            z8 = true;
            i13 = 0;
        }
        if (i15 > i12) {
            i14 = i12;
            z9 = true;
        } else if (i15 < 0) {
            z9 = true;
            i14 = 0;
        } else {
            i14 = i15;
            z9 = false;
        }
        if (z9 && !this.G.f(1)) {
            this.f591l.springBack(i13, i14, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i13, i14);
        return z8 || z9;
    }

    public final void q(int i9) {
        boolean z8 = i9 == 130;
        int height = getHeight();
        Rect rect = this.f590k;
        if (z8) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i10 = rect.top;
        int i11 = height + i10;
        rect.bottom = i11;
        r(i9, i10, i11);
    }

    public final boolean r(int i9, int i10, int i11) {
        boolean z8;
        int height = getHeight();
        int scrollY = getScrollY();
        int i12 = height + scrollY;
        boolean z9 = i9 == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z10 = false;
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = focusables.get(i13);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                boolean z11 = i10 < top && bottom < i11;
                if (view == null) {
                    view = view2;
                    z10 = z11;
                } else {
                    boolean z12 = (z9 && top < view.getTop()) || (!z9 && bottom > view.getBottom());
                    if (z10) {
                        if (z11) {
                            if (!z12) {
                            }
                            view = view2;
                        }
                    } else if (z11) {
                        view = view2;
                        z10 = true;
                    } else {
                        if (!z12) {
                        }
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i10 < scrollY || i11 > i12) {
            s(z9 ? i10 - scrollY : i11 - i12, 0, 1, true);
            z8 = true;
        } else {
            z8 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i9);
        }
        return z8;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.f595p) {
            this.f597r = view2;
        } else {
            Rect rect = this.f590k;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int h = h(rect);
            if (h != 0) {
                scrollBy(0, h);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z8) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int h = h(rect);
        boolean z9 = h != 0;
        if (z9) {
            if (z8) {
                scrollBy(0, h);
                return z9;
            }
            u(0, h, false);
        }
        return z9;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z8) {
        VelocityTracker velocityTracker;
        if (z8 && (velocityTracker = this.f599t) != null) {
            velocityTracker.recycle();
            this.f599t = null;
        }
        super.requestDisallowInterceptTouchEvent(z8);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f595p = true;
        super.requestLayout();
    }

    public final int s(int i9, int i10, int i11, boolean z8) {
        int i12;
        int i13;
        boolean z9;
        o oVar = this.G;
        if (i11 == 1) {
            oVar.g(2, i11);
        }
        boolean c9 = this.G.c(0, i9, this.B, this.A, i11);
        int[] iArr = this.A;
        int[] iArr2 = this.B;
        if (c9) {
            i12 = i9 - iArr2[1];
            i13 = iArr[1];
        } else {
            i12 = i9;
            i13 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z10 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z8;
        boolean z11 = p(i12, 0, scrollY, scrollRange) && !oVar.f(i11);
        int scrollY2 = getScrollY() - scrollY;
        iArr2[1] = 0;
        this.G.d(0, scrollY2, 0, i12 - scrollY2, this.A, i11, iArr2);
        int i14 = i13 + iArr[1];
        int i15 = i12 - iArr2[1];
        int i16 = scrollY + i15;
        EdgeEffect edgeEffect = this.f593n;
        EdgeEffect edgeEffect2 = this.f592m;
        if (i16 < 0) {
            if (z10) {
                com.bumptech.glide.d.P(edgeEffect2, (-i15) / getHeight(), i10 / getWidth());
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i16 > scrollRange && z10) {
            com.bumptech.glide.d.P(edgeEffect, i15 / getHeight(), 1.0f - (i10 / getWidth()));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (edgeEffect2.isFinished() && edgeEffect.isFinished()) {
            z9 = z11;
        } else {
            WeakHashMap weakHashMap = t0.f7209a;
            c0.k(this);
            z9 = false;
        }
        if (z9 && i11 == 0) {
            this.f599t.clear();
        }
        if (i11 == 1) {
            w(i11);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i14;
    }

    @Override // android.view.View
    public final void scrollTo(int i9, int i10) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i9 < 0) {
                i9 = 0;
            } else if (width + i9 > width2) {
                i9 = width2 - width;
            }
            if (height >= height2 || i10 < 0) {
                i10 = 0;
            } else if (height + i10 > height2) {
                i10 = height2 - height;
            }
            if (i9 == getScrollX() && i10 == getScrollY()) {
                return;
            }
            super.scrollTo(i9, i10);
        }
    }

    public void setFillViewport(boolean z8) {
        if (z8 != this.f600u) {
            this.f600u = z8;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z8) {
        o oVar = this.G;
        if (oVar.f7185d) {
            ViewGroup viewGroup = oVar.f7184c;
            WeakHashMap weakHashMap = t0.f7209a;
            i0.z(viewGroup);
        }
        oVar.f7185d = z8;
    }

    public void setOnScrollChangeListener(j jVar) {
        this.I = jVar;
    }

    public void setSmoothScrollingEnabled(boolean z8) {
        this.f601v = z8;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i9) {
        return this.G.g(i9, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        w(0);
    }

    public final boolean t(EdgeEffect edgeEffect, int i9) {
        if (i9 > 0) {
            return true;
        }
        float D = com.bumptech.glide.d.D(edgeEffect) * getHeight();
        float abs = Math.abs(-i9) * 0.35f;
        float f9 = this.f588i * 0.015f;
        double log = Math.log(abs / f9);
        double d9 = J;
        return ((float) (Math.exp((d9 / (d9 - 1.0d)) * log) * ((double) f9))) < D;
    }

    public final void u(int i9, int i10, boolean z8) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f589j > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int max = Math.max(0, Math.min(i10 + scrollY, Math.max(0, height - height2))) - scrollY;
            this.f591l.startScroll(getScrollX(), scrollY, 0, max, 250);
            if (z8) {
                this.G.g(2, 1);
            } else {
                w(1);
            }
            this.D = getScrollY();
            WeakHashMap weakHashMap = t0.f7209a;
            c0.k(this);
        } else {
            OverScroller overScroller = this.f591l;
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
                w(1);
            }
            scrollBy(i9, i10);
        }
        this.f589j = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean v(MotionEvent motionEvent) {
        boolean z8;
        EdgeEffect edgeEffect = this.f592m;
        if (com.bumptech.glide.d.D(edgeEffect) != 0.0f) {
            com.bumptech.glide.d.P(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z8 = true;
        } else {
            z8 = false;
        }
        EdgeEffect edgeEffect2 = this.f593n;
        if (com.bumptech.glide.d.D(edgeEffect2) == 0.0f) {
            return z8;
        }
        com.bumptech.glide.d.P(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void w(int i9) {
        this.G.h(i9);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9) {
        if (getChildCount() <= 0) {
            super.addView(view, i9);
        } else {
            c.p("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
        } else {
            c.p("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i9, layoutParams);
        } else {
            c.p("ScrollView can host only one direct child");
        }
    }
}
