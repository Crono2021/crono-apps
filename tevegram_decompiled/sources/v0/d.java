package v0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.activity.j;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Arrays;
import n0.t0;
import o3.e0;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: v, reason: collision with root package name */
    public static final e0 f9212v = new e0(1);

    /* renamed from: a, reason: collision with root package name */
    public int f9213a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9214b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f9216d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f9217e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f9218f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f9219g;
    public int[] h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f9220i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f9221j;

    /* renamed from: k, reason: collision with root package name */
    public int f9222k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f9223l;

    /* renamed from: m, reason: collision with root package name */
    public final float f9224m;

    /* renamed from: n, reason: collision with root package name */
    public final float f9225n;

    /* renamed from: o, reason: collision with root package name */
    public final int f9226o;

    /* renamed from: p, reason: collision with root package name */
    public final OverScroller f9227p;

    /* renamed from: q, reason: collision with root package name */
    public final android.support.v4.media.session.b f9228q;

    /* renamed from: r, reason: collision with root package name */
    public View f9229r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9230s;

    /* renamed from: t, reason: collision with root package name */
    public final CoordinatorLayout f9231t;

    /* renamed from: c, reason: collision with root package name */
    public int f9215c = -1;

    /* renamed from: u, reason: collision with root package name */
    public final j f9232u = new j(this, 15);

    public d(Context context, CoordinatorLayout coordinatorLayout, android.support.v4.media.session.b bVar) {
        if (bVar == null) {
            m7.c.n("Callback may not be null");
            throw null;
        }
        this.f9231t = coordinatorLayout;
        this.f9228q = bVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f9226o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f9214b = viewConfiguration.getScaledTouchSlop();
        this.f9224m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f9225n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f9227p = new OverScroller(context, f9212v);
    }

    public final void a() {
        this.f9215c = -1;
        float[] fArr = this.f9216d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f9217e, 0.0f);
            Arrays.fill(this.f9218f, 0.0f);
            Arrays.fill(this.f9219g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.f9220i, 0);
            Arrays.fill(this.f9221j, 0);
            this.f9222k = 0;
        }
        VelocityTracker velocityTracker = this.f9223l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f9223l = null;
        }
    }

    public final void b(View view, int i9) {
        ViewParent parent = view.getParent();
        CoordinatorLayout coordinatorLayout = this.f9231t;
        if (parent != coordinatorLayout) {
            androidx.fragment.app.a.m(coordinatorLayout, ")", "captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
            return;
        }
        this.f9229r = view;
        this.f9215c = i9;
        this.f9228q.g0(view, i9);
        n(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            goto L48
        L4:
            android.support.v4.media.session.b r1 = r3.f9228q
            int r4 = r1.S(r4)
            r2 = 1
            if (r4 <= 0) goto Lf
            r4 = 1
            goto L10
        Lf:
            r4 = 0
        L10:
            int r1 = r1.T()
            if (r1 <= 0) goto L18
            r1 = 1
            goto L19
        L18:
            r1 = 0
        L19:
            if (r4 == 0) goto L2c
            if (r1 == 0) goto L2c
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r4 = r3.f9214b
            int r4 = r4 * r4
            float r4 = (float) r4
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 <= 0) goto L48
            goto L47
        L2c:
            if (r4 == 0) goto L3a
            float r4 = java.lang.Math.abs(r5)
            int r5 = r3.f9214b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L48
            goto L47
        L3a:
            if (r1 == 0) goto L48
            float r4 = java.lang.Math.abs(r6)
            int r5 = r3.f9214b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L48
        L47:
            return r2
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.d.c(android.view.View, float, float):boolean");
    }

    public final void d(int i9) {
        float[] fArr = this.f9216d;
        if (fArr != null) {
            int i10 = this.f9222k;
            int i11 = 1 << i9;
            if ((i10 & i11) != 0) {
                fArr[i9] = 0.0f;
                this.f9217e[i9] = 0.0f;
                this.f9218f[i9] = 0.0f;
                this.f9219g[i9] = 0.0f;
                this.h[i9] = 0;
                this.f9220i[i9] = 0;
                this.f9221j[i9] = 0;
                this.f9222k = (~i11) & i10;
            }
        }
    }

    public final int e(int i9, int i10, int i11) {
        if (i9 == 0) {
            return 0;
        }
        float width = this.f9231t.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i9) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int abs = Math.abs(i10);
        return Math.min(abs > 0 ? Math.round(Math.abs(sin / abs) * 1000.0f) * 4 : (int) (((Math.abs(i9) / i11) + 1.0f) * 256.0f), IjkMediaCodecInfo.RANK_LAST_CHANCE);
    }

    public final boolean f() {
        if (this.f9213a == 2) {
            OverScroller overScroller = this.f9227p;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f9229r.getLeft();
            int top = currY - this.f9229r.getTop();
            if (left != 0) {
                t0.j(this.f9229r, left);
            }
            if (top != 0) {
                t0.k(this.f9229r, top);
            }
            if (left != 0 || top != 0) {
                this.f9228q.i0(this.f9229r, currX, currY);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f9231t.post(this.f9232u);
            }
        }
        return this.f9213a == 2;
    }

    public final View g(int i9, int i10) {
        CoordinatorLayout coordinatorLayout = this.f9231t;
        for (int childCount = coordinatorLayout.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f9228q.getClass();
            View childAt = coordinatorLayout.getChildAt(childCount);
            if (i9 >= childAt.getLeft() && i9 < childAt.getRight() && i10 >= childAt.getTop() && i10 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean h(int i9, int i10, int i11, int i12) {
        float f9;
        float f10;
        float f11;
        float f12;
        int left = this.f9229r.getLeft();
        int top = this.f9229r.getTop();
        int i13 = i9 - left;
        int i14 = i10 - top;
        OverScroller overScroller = this.f9227p;
        if (i13 == 0 && i14 == 0) {
            overScroller.abortAnimation();
            n(0);
            return false;
        }
        View view = this.f9229r;
        int i15 = (int) this.f9225n;
        int i16 = (int) this.f9224m;
        int abs = Math.abs(i11);
        if (abs < i15) {
            i11 = 0;
        } else if (abs > i16) {
            i11 = i11 > 0 ? i16 : -i16;
        }
        int abs2 = Math.abs(i12);
        if (abs2 < i15) {
            i12 = 0;
        } else if (abs2 > i16) {
            i12 = i12 > 0 ? i16 : -i16;
        }
        int abs3 = Math.abs(i13);
        int abs4 = Math.abs(i14);
        int abs5 = Math.abs(i11);
        int abs6 = Math.abs(i12);
        int i17 = abs5 + abs6;
        int i18 = abs3 + abs4;
        if (i11 != 0) {
            f9 = abs5;
            f10 = i17;
        } else {
            f9 = abs3;
            f10 = i18;
        }
        float f13 = f9 / f10;
        if (i12 != 0) {
            f11 = abs6;
            f12 = i17;
        } else {
            f11 = abs4;
            f12 = i18;
        }
        float f14 = f11 / f12;
        android.support.v4.media.session.b bVar = this.f9228q;
        overScroller.startScroll(left, top, i13, i14, (int) ((e(i14, i12, bVar.T()) * f14) + (e(i13, i11, bVar.S(view)) * f13)));
        n(2);
        return true;
    }

    public final boolean i(int i9) {
        if ((this.f9222k & (1 << i9)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i9 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void j(MotionEvent motionEvent) {
        int i9;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f9223l == null) {
            this.f9223l = VelocityTracker.obtain();
        }
        this.f9223l.addMovement(motionEvent);
        int i10 = 0;
        if (actionMasked == 0) {
            float x6 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View g9 = g((int) x6, (int) y2);
            l(x6, y2, pointerId);
            q(g9, pointerId);
            int i11 = this.h[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.f9213a == 1) {
                k();
            }
            a();
            return;
        }
        android.support.v4.media.session.b bVar = this.f9228q;
        if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f9213a == 1) {
                    this.f9230s = true;
                    bVar.j0(this.f9229r, 0.0f, 0.0f);
                    this.f9230s = false;
                    if (this.f9213a == 1) {
                        n(0);
                    }
                }
                a();
                return;
            }
            if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x8 = motionEvent.getX(actionIndex);
                float y3 = motionEvent.getY(actionIndex);
                l(x8, y3, pointerId2);
                if (this.f9213a == 0) {
                    q(g((int) x8, (int) y3), pointerId2);
                    int i12 = this.h[pointerId2];
                    return;
                }
                int i13 = (int) x8;
                int i14 = (int) y3;
                View view = this.f9229r;
                if (view != null && i13 >= view.getLeft() && i13 < view.getRight() && i14 >= view.getTop() && i14 < view.getBottom()) {
                    i10 = 1;
                }
                if (i10 != 0) {
                    q(this.f9229r, pointerId2);
                    return;
                }
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f9213a == 1 && pointerId3 == this.f9215c) {
                int pointerCount = motionEvent.getPointerCount();
                while (true) {
                    if (i10 >= pointerCount) {
                        i9 = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i10);
                    if (pointerId4 != this.f9215c) {
                        View g10 = g((int) motionEvent.getX(i10), (int) motionEvent.getY(i10));
                        View view2 = this.f9229r;
                        if (g10 == view2 && q(view2, pointerId4)) {
                            i9 = this.f9215c;
                            break;
                        }
                    }
                    i10++;
                }
                if (i9 == -1) {
                    k();
                }
            }
            d(pointerId3);
            return;
        }
        if (this.f9213a == 1) {
            if (i(this.f9215c)) {
                int findPointerIndex = motionEvent.findPointerIndex(this.f9215c);
                float x9 = motionEvent.getX(findPointerIndex);
                float y7 = motionEvent.getY(findPointerIndex);
                float[] fArr = this.f9218f;
                int i15 = this.f9215c;
                int i16 = (int) (x9 - fArr[i15]);
                int i17 = (int) (y7 - this.f9219g[i15]);
                int left = this.f9229r.getLeft() + i16;
                int top = this.f9229r.getTop() + i17;
                int left2 = this.f9229r.getLeft();
                int top2 = this.f9229r.getTop();
                if (i16 != 0) {
                    left = bVar.t(this.f9229r, left);
                    t0.j(this.f9229r, left - left2);
                }
                if (i17 != 0) {
                    top = bVar.u(this.f9229r, top);
                    t0.k(this.f9229r, top - top2);
                }
                if (i16 != 0 || i17 != 0) {
                    bVar.i0(this.f9229r, left, top);
                }
                m(motionEvent);
                return;
            }
            return;
        }
        int pointerCount2 = motionEvent.getPointerCount();
        while (i10 < pointerCount2) {
            int pointerId5 = motionEvent.getPointerId(i10);
            if (i(pointerId5)) {
                float x10 = motionEvent.getX(i10);
                float y8 = motionEvent.getY(i10);
                float f9 = x10 - this.f9216d[pointerId5];
                float f10 = y8 - this.f9217e[pointerId5];
                Math.abs(f9);
                Math.abs(f10);
                int i18 = this.h[pointerId5];
                Math.abs(f10);
                Math.abs(f9);
                int i19 = this.h[pointerId5];
                Math.abs(f9);
                Math.abs(f10);
                int i20 = this.h[pointerId5];
                Math.abs(f10);
                Math.abs(f9);
                int i21 = this.h[pointerId5];
                if (this.f9213a != 1) {
                    View g11 = g((int) x10, (int) y8);
                    if (c(g11, f9, f10) && q(g11, pointerId5)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            i10++;
        }
        m(motionEvent);
    }

    public final void k() {
        VelocityTracker velocityTracker = this.f9223l;
        float f9 = this.f9224m;
        velocityTracker.computeCurrentVelocity(IjkMediaCodecInfo.RANK_MAX, f9);
        float xVelocity = this.f9223l.getXVelocity(this.f9215c);
        float abs = Math.abs(xVelocity);
        float f10 = this.f9225n;
        if (abs < f10) {
            xVelocity = 0.0f;
        } else if (abs > f9) {
            xVelocity = xVelocity > 0.0f ? f9 : -f9;
        }
        float yVelocity = this.f9223l.getYVelocity(this.f9215c);
        float abs2 = Math.abs(yVelocity);
        if (abs2 < f10) {
            f9 = 0.0f;
        } else if (abs2 <= f9) {
            f9 = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f9 = -f9;
        }
        this.f9230s = true;
        this.f9228q.j0(this.f9229r, xVelocity, f9);
        this.f9230s = false;
        if (this.f9213a == 1) {
            n(0);
        }
    }

    public final void l(float f9, float f10, int i9) {
        float[] fArr = this.f9216d;
        if (fArr == null || fArr.length <= i9) {
            int i10 = i9 + 1;
            float[] fArr2 = new float[i10];
            float[] fArr3 = new float[i10];
            float[] fArr4 = new float[i10];
            float[] fArr5 = new float[i10];
            int[] iArr = new int[i10];
            int[] iArr2 = new int[i10];
            int[] iArr3 = new int[i10];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f9217e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f9218f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f9219g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f9220i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f9221j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f9216d = fArr2;
            this.f9217e = fArr3;
            this.f9218f = fArr4;
            this.f9219g = fArr5;
            this.h = iArr;
            this.f9220i = iArr2;
            this.f9221j = iArr3;
        }
        float[] fArr9 = this.f9216d;
        this.f9218f[i9] = f9;
        fArr9[i9] = f9;
        float[] fArr10 = this.f9217e;
        this.f9219g[i9] = f10;
        fArr10[i9] = f10;
        int[] iArr7 = this.h;
        int i11 = (int) f9;
        int i12 = (int) f10;
        CoordinatorLayout coordinatorLayout = this.f9231t;
        int left = coordinatorLayout.getLeft();
        int i13 = this.f9226o;
        int i14 = i11 < left + i13 ? 1 : 0;
        if (i12 < coordinatorLayout.getTop() + i13) {
            i14 |= 4;
        }
        if (i11 > coordinatorLayout.getRight() - i13) {
            i14 |= 2;
        }
        if (i12 > coordinatorLayout.getBottom() - i13) {
            i14 |= 8;
        }
        iArr7[i9] = i14;
        this.f9222k |= 1 << i9;
    }

    public final void m(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i9 = 0; i9 < pointerCount; i9++) {
            int pointerId = motionEvent.getPointerId(i9);
            if (i(pointerId)) {
                float x6 = motionEvent.getX(i9);
                float y2 = motionEvent.getY(i9);
                this.f9218f[pointerId] = x6;
                this.f9219g[pointerId] = y2;
            }
        }
    }

    public final void n(int i9) {
        this.f9231t.removeCallbacks(this.f9232u);
        if (this.f9213a != i9) {
            this.f9213a = i9;
            this.f9228q.h0(i9);
            if (this.f9213a == 0) {
                this.f9229r = null;
            }
        }
    }

    public final boolean o(int i9, int i10) {
        if (this.f9230s) {
            return h(i9, i10, (int) this.f9223l.getXVelocity(this.f9215c), (int) this.f9223l.getYVelocity(this.f9215c));
        }
        m7.c.p("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cd, code lost:
    
        if (r12 != r11) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.d.p(android.view.MotionEvent):boolean");
    }

    public final boolean q(View view, int i9) {
        if (view == this.f9229r && this.f9215c == i9) {
            return true;
        }
        if (view == null || !this.f9228q.y0(view, i9)) {
            return false;
        }
        this.f9215c = i9;
        b(view, i9);
        return true;
    }
}
