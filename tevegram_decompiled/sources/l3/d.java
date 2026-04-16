package l3;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import d1.t0;
import d1.y0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends View {
    public final int A;
    public final int B;
    public final StringBuilder C;
    public final Formatter D;
    public final a7.a E;
    public final CopyOnWriteArraySet F;
    public final Point G;
    public final float H;
    public int I;
    public long J;
    public int K;
    public Rect L;
    public final ValueAnimator M;
    public float N;
    public boolean O;
    public boolean P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public int U;
    public long[] V;
    public boolean[] W;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f6103i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f6104j;

    /* renamed from: k, reason: collision with root package name */
    public final Rect f6105k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f6106l;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f6107m;

    /* renamed from: n, reason: collision with root package name */
    public final Paint f6108n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f6109o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f6110p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint f6111q;

    /* renamed from: r, reason: collision with root package name */
    public final Paint f6112r;

    /* renamed from: s, reason: collision with root package name */
    public final Drawable f6113s;

    /* renamed from: t, reason: collision with root package name */
    public final int f6114t;

    /* renamed from: u, reason: collision with root package name */
    public final int f6115u;

    /* renamed from: v, reason: collision with root package name */
    public final int f6116v;

    /* renamed from: w, reason: collision with root package name */
    public final int f6117w;

    /* renamed from: x, reason: collision with root package name */
    public final int f6118x;

    /* renamed from: y, reason: collision with root package name */
    public final int f6119y;

    /* renamed from: z, reason: collision with root package name */
    public final int f6120z;

    public d(Context context, AttributeSet attributeSet) {
        super(context, null, 0);
        boolean layoutDirection;
        this.f6103i = new Rect();
        this.f6104j = new Rect();
        this.f6105k = new Rect();
        this.f6106l = new Rect();
        Paint paint = new Paint();
        this.f6107m = paint;
        Paint paint2 = new Paint();
        this.f6108n = paint2;
        Paint paint3 = new Paint();
        this.f6109o = paint3;
        Paint paint4 = new Paint();
        this.f6110p = paint4;
        Paint paint5 = new Paint();
        this.f6111q = paint5;
        Paint paint6 = new Paint();
        this.f6112r = paint6;
        paint6.setAntiAlias(true);
        this.F = new CopyOnWriteArraySet();
        this.G = new Point();
        float f9 = context.getResources().getDisplayMetrics().density;
        this.H = f9;
        this.B = a(-50, f9);
        int a9 = a(4, f9);
        int a10 = a(26, f9);
        int a11 = a(4, f9);
        int a12 = a(12, f9);
        int a13 = a(0, f9);
        int a14 = a(16, f9);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b0.f6087b, 0, 2132017469);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(10);
                this.f6113s = drawable;
                if (drawable != null) {
                    int i9 = g1.w.f3713a;
                    if (i9 >= 23) {
                        int layoutDirection2 = getLayoutDirection();
                        if (i9 >= 23) {
                            layoutDirection = drawable.setLayoutDirection(layoutDirection2);
                            if (layoutDirection) {
                            }
                        }
                    }
                    a10 = Math.max(drawable.getMinimumHeight(), a10);
                }
                this.f6114t = obtainStyledAttributes.getDimensionPixelSize(3, a9);
                this.f6115u = obtainStyledAttributes.getDimensionPixelSize(12, a10);
                this.f6116v = obtainStyledAttributes.getInt(2, 0);
                this.f6117w = obtainStyledAttributes.getDimensionPixelSize(1, a11);
                this.f6118x = obtainStyledAttributes.getDimensionPixelSize(11, a12);
                this.f6119y = obtainStyledAttributes.getDimensionPixelSize(8, a13);
                this.f6120z = obtainStyledAttributes.getDimensionPixelSize(9, a14);
                int i10 = obtainStyledAttributes.getInt(6, -1);
                int i11 = obtainStyledAttributes.getInt(7, -1);
                int i12 = obtainStyledAttributes.getInt(4, -855638017);
                int i13 = obtainStyledAttributes.getInt(13, 872415231);
                int i14 = obtainStyledAttributes.getInt(0, -1291845888);
                int i15 = obtainStyledAttributes.getInt(5, 872414976);
                paint.setColor(i10);
                paint6.setColor(i11);
                paint2.setColor(i12);
                paint3.setColor(i13);
                paint4.setColor(i14);
                paint5.setColor(i15);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.f6114t = a9;
            this.f6115u = a10;
            this.f6116v = 0;
            this.f6117w = a11;
            this.f6118x = a12;
            this.f6119y = a13;
            this.f6120z = a14;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f6113s = null;
        }
        StringBuilder sb = new StringBuilder();
        this.C = sb;
        this.D = new Formatter(sb, Locale.getDefault());
        this.E = new a7.a(this, 14);
        Drawable drawable2 = this.f6113s;
        if (drawable2 != null) {
            this.A = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.A = (Math.max(this.f6119y, Math.max(this.f6118x, this.f6120z)) + 1) / 2;
        }
        this.N = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.M = valueAnimator;
        valueAnimator.addUpdateListener(new f5.b(this, 1));
        this.R = -9223372036854775807L;
        this.J = -9223372036854775807L;
        this.I = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static int a(int i9, float f9) {
        return (int) ((i9 * f9) + 0.5f);
    }

    private long getPositionIncrement() {
        long j5 = this.J;
        if (j5 != -9223372036854775807L) {
            return j5;
        }
        long j9 = this.R;
        if (j9 == -9223372036854775807L) {
            return 0L;
        }
        return j9 / this.I;
    }

    private String getProgressText() {
        return g1.w.B(this.C, this.D, this.S);
    }

    private long getScrubberPosition() {
        if (this.f6104j.width() <= 0 || this.R == -9223372036854775807L) {
            return 0L;
        }
        return (this.f6106l.width() * this.R) / r0.width();
    }

    public final boolean b(long j5) {
        long j9 = this.R;
        if (j9 <= 0) {
            return false;
        }
        long j10 = this.P ? this.Q : this.S;
        long i9 = g1.w.i(j10 + j5, 0L, j9);
        if (i9 == j10) {
            return false;
        }
        if (this.P) {
            f(i9);
        } else {
            c(i9);
        }
        e();
        return true;
    }

    public final void c(long j5) {
        this.Q = j5;
        this.P = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            q qVar = ((g) it.next()).f6155i;
            qVar.f6220w0 = true;
            TextView textView = qVar.L;
            if (textView != null) {
                textView.setText(g1.w.B(qVar.N, qVar.O, j5));
            }
            qVar.f6192i.f();
        }
    }

    public final void d(boolean z8) {
        t0 t0Var;
        removeCallbacks(this.E);
        this.P = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            long j5 = this.Q;
            q qVar = gVar.f6155i;
            qVar.f6220w0 = false;
            if (!z8 && (t0Var = qVar.f6206p0) != null) {
                if (qVar.f6218v0) {
                    if (t0Var.J(17) && t0Var.J(10)) {
                        y0 U = t0Var.U();
                        int o8 = U.o();
                        int i9 = 0;
                        while (true) {
                            long W = g1.w.W(U.m(i9, qVar.Q, 0L).f2606n);
                            if (j5 < W) {
                                break;
                            }
                            if (i9 == o8 - 1) {
                                j5 = W;
                                break;
                            } else {
                                j5 -= W;
                                i9++;
                            }
                        }
                        t0Var.l(i9, j5);
                    }
                } else if (t0Var.J(5)) {
                    t0Var.seekTo(j5);
                }
                qVar.o();
            }
            qVar.f6192i.g();
        }
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f6113s;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void e() {
        Rect rect = this.f6105k;
        Rect rect2 = this.f6104j;
        rect.set(rect2);
        Rect rect3 = this.f6106l;
        rect3.set(rect2);
        long j5 = this.P ? this.Q : this.S;
        if (this.R > 0) {
            rect.right = Math.min(rect2.left + ((int) ((rect2.width() * this.T) / this.R)), rect2.right);
            rect3.right = Math.min(rect2.left + ((int) ((rect2.width() * j5) / this.R)), rect2.right);
        } else {
            int i9 = rect2.left;
            rect.right = i9;
            rect3.right = i9;
        }
        invalidate(this.f6103i);
    }

    public final void f(long j5) {
        if (this.Q == j5) {
            return;
        }
        this.Q = j5;
        Iterator it = this.F.iterator();
        while (it.hasNext()) {
            q qVar = ((g) it.next()).f6155i;
            TextView textView = qVar.L;
            if (textView != null) {
                textView.setText(g1.w.B(qVar.N, qVar.O, j5));
            }
        }
    }

    public long getPreferredUpdateDelay() {
        int width = (int) (this.f6104j.width() / this.H);
        if (width == 0) {
            return Long.MAX_VALUE;
        }
        long j5 = this.R;
        if (j5 == 0 || j5 == -9223372036854775807L) {
            return Long.MAX_VALUE;
        }
        return j5 / width;
    }

    @Override // android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f6113s;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        Rect rect = this.f6104j;
        int height = rect.height();
        int centerY = rect.centerY() - (height / 2);
        int i9 = centerY + height;
        long j5 = this.R;
        Paint paint = this.f6109o;
        Rect rect2 = this.f6106l;
        if (j5 <= 0) {
            canvas2 = canvas;
            canvas2.drawRect(rect.left, centerY, rect.right, i9, paint);
        } else {
            Rect rect3 = this.f6105k;
            int i10 = rect3.left;
            int i11 = rect3.right;
            int max = Math.max(Math.max(rect.left, i11), rect2.right);
            int i12 = rect.right;
            if (max < i12) {
                canvas.drawRect(max, centerY, i12, i9, paint);
            }
            int max2 = Math.max(i10, rect2.right);
            if (i11 > max2) {
                canvas.drawRect(max2, centerY, i11, i9, this.f6108n);
            }
            if (rect2.width() > 0) {
                canvas.drawRect(rect2.left, centerY, rect2.right, i9, this.f6107m);
            }
            if (this.U != 0) {
                long[] jArr = this.V;
                jArr.getClass();
                boolean[] zArr = this.W;
                zArr.getClass();
                int i13 = this.f6117w;
                int i14 = i13 / 2;
                int i15 = 0;
                int i16 = 0;
                while (i16 < this.U) {
                    int i17 = i16;
                    canvas.drawRect(Math.min(rect.width() - i13, Math.max(i15, ((int) ((rect.width() * g1.w.i(jArr[i16], 0L, this.R)) / this.R)) - i14)) + rect.left, centerY, r3 + i13, i9, zArr[i16] ? this.f6111q : this.f6110p);
                    i16 = i17 + 1;
                    i15 = 0;
                }
            }
            canvas2 = canvas;
        }
        if (this.R > 0) {
            int h = g1.w.h(rect2.right, rect2.left, rect.right);
            int centerY2 = rect2.centerY();
            Drawable drawable = this.f6113s;
            if (drawable == null) {
                canvas2.drawCircle(h, centerY2, (int) ((((this.P || isFocused()) ? this.f6120z : isEnabled() ? this.f6118x : this.f6119y) * this.N) / 2.0f), this.f6112r);
            } else {
                int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.N)) / 2;
                int intrinsicHeight = ((int) (drawable.getIntrinsicHeight() * this.N)) / 2;
                drawable.setBounds(h - intrinsicWidth, centerY2 - intrinsicHeight, h + intrinsicWidth, centerY2 + intrinsicHeight);
                drawable.draw(canvas2);
            }
        }
        canvas2.restore();
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z8, int i9, Rect rect) {
        super.onFocusChanged(z8, i9, rect);
        if (!this.P || z8) {
            return;
        }
        d(false);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.R <= 0) {
            return;
        }
        if (g1.w.f3713a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L2e
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L25
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L25;
                default: goto L12;
            }
        L12:
            goto L2e
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.b(r0)
            if (r0 == 0) goto L2e
            a7.a r5 = r4.E
            r4.removeCallbacks(r5)
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L25:
            boolean r0 = r4.P
            if (r0 == 0) goto L2e
            r5 = 0
            r4.d(r5)
            return r3
        L2e:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.d.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int i13;
        int i14;
        Rect rect;
        int i15 = i11 - i9;
        int i16 = i12 - i10;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i15 - getPaddingRight();
        int i17 = this.O ? 0 : this.A;
        int i18 = this.f6116v;
        int i19 = this.f6114t;
        int i20 = this.f6115u;
        if (i18 == 1) {
            i13 = (i16 - getPaddingBottom()) - i20;
            i14 = ((i16 - getPaddingBottom()) - i19) - Math.max(i17 - (i19 / 2), 0);
        } else {
            i13 = (i16 - i20) / 2;
            i14 = (i16 - i19) / 2;
        }
        Rect rect2 = this.f6103i;
        rect2.set(paddingLeft, i13, paddingRight, i20 + i13);
        this.f6104j.set(rect2.left + i17, i14, rect2.right - i17, i19 + i14);
        if (g1.w.f3713a >= 29 && ((rect = this.L) == null || rect.width() != i15 || this.L.height() != i16)) {
            Rect rect3 = new Rect(0, 0, i15, i16);
            this.L = rect3;
            setSystemGestureExclusionRects(Collections.singletonList(rect3));
        }
        e();
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int i11 = this.f6115u;
        if (mode == 0) {
            size = i11;
        } else if (mode != 1073741824) {
            size = Math.min(i11, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i9), size);
        Drawable drawable = this.f6113s;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i9) {
        boolean layoutDirection;
        Drawable drawable = this.f6113s;
        if (drawable == null || g1.w.f3713a < 23) {
            return;
        }
        layoutDirection = drawable.setLayoutDirection(i9);
        if (layoutDirection) {
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        if (r3 != 3) goto L34;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            r1 = 0
            if (r0 == 0) goto La1
            long r2 = r9.R
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L11
            goto La1
        L11:
            float r0 = r10.getX()
            int r0 = (int) r0
            float r2 = r10.getY()
            int r2 = (int) r2
            android.graphics.Point r3 = r9.G
            r3.set(r0, r2)
            int r0 = r3.x
            int r2 = r3.y
            int r3 = r10.getAction()
            android.graphics.Rect r4 = r9.f6104j
            android.graphics.Rect r5 = r9.f6106l
            r6 = 1
            if (r3 == 0) goto L7d
            r7 = 3
            if (r3 == r6) goto L6e
            r8 = 2
            if (r3 == r8) goto L38
            if (r3 == r7) goto L6e
            goto La1
        L38:
            boolean r10 = r9.P
            if (r10 == 0) goto La1
            int r10 = r9.B
            if (r2 >= r10) goto L52
            int r10 = r9.K
            int r0 = r0 - r10
            int r0 = r0 / r7
            int r0 = r0 + r10
            float r10 = (float) r0
            int r10 = (int) r10
            int r0 = r4.left
            int r1 = r4.right
            int r10 = g1.w.h(r10, r0, r1)
            r5.right = r10
            goto L60
        L52:
            r9.K = r0
            float r10 = (float) r0
            int r10 = (int) r10
            int r0 = r4.left
            int r1 = r4.right
            int r10 = g1.w.h(r10, r0, r1)
            r5.right = r10
        L60:
            long r0 = r9.getScrubberPosition()
            r9.f(r0)
            r9.e()
            r9.invalidate()
            return r6
        L6e:
            boolean r0 = r9.P
            if (r0 == 0) goto La1
            int r10 = r10.getAction()
            if (r10 != r7) goto L79
            r1 = 1
        L79:
            r9.d(r1)
            return r6
        L7d:
            float r10 = (float) r0
            float r0 = (float) r2
            int r10 = (int) r10
            int r0 = (int) r0
            android.graphics.Rect r2 = r9.f6103i
            boolean r0 = r2.contains(r10, r0)
            if (r0 == 0) goto La1
            int r0 = r4.left
            int r1 = r4.right
            int r10 = g1.w.h(r10, r0, r1)
            r5.right = r10
            long r0 = r9.getScrubberPosition()
            r9.c(r0)
            r9.e()
            r9.invalidate()
            return r6
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.d.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i9, Bundle bundle) {
        if (super.performAccessibilityAction(i9, bundle)) {
            return true;
        }
        if (this.R <= 0) {
            return false;
        }
        if (i9 == 8192) {
            if (b(-getPositionIncrement())) {
                d(false);
            }
        } else {
            if (i9 != 4096) {
                return false;
            }
            if (b(getPositionIncrement())) {
                d(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(int i9) {
        this.f6110p.setColor(i9);
        invalidate(this.f6103i);
    }

    public void setBufferedColor(int i9) {
        this.f6108n.setColor(i9);
        invalidate(this.f6103i);
    }

    public void setBufferedPosition(long j5) {
        if (this.T == j5) {
            return;
        }
        this.T = j5;
        e();
    }

    public void setDuration(long j5) {
        if (this.R == j5) {
            return;
        }
        this.R = j5;
        if (this.P && j5 == -9223372036854775807L) {
            d(true);
        }
        e();
    }

    @Override // android.view.View
    public void setEnabled(boolean z8) {
        super.setEnabled(z8);
        if (!this.P || z8) {
            return;
        }
        d(true);
    }

    public void setKeyCountIncrement(int i9) {
        g1.a.f(i9 > 0);
        this.I = i9;
        this.J = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j5) {
        g1.a.f(j5 > 0);
        this.I = -1;
        this.J = j5;
    }

    public void setPlayedAdMarkerColor(int i9) {
        this.f6111q.setColor(i9);
        invalidate(this.f6103i);
    }

    public void setPlayedColor(int i9) {
        this.f6107m.setColor(i9);
        invalidate(this.f6103i);
    }

    public void setPosition(long j5) {
        if (this.S == j5) {
            return;
        }
        this.S = j5;
        setContentDescription(getProgressText());
        e();
    }

    public void setScrubberColor(int i9) {
        this.f6112r.setColor(i9);
        invalidate(this.f6103i);
    }

    public void setUnplayedColor(int i9) {
        this.f6109o.setColor(i9);
        invalidate(this.f6103i);
    }
}
