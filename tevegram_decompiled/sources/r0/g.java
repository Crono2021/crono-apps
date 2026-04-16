package r0;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import n.x1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements View.OnTouchListener {

    /* renamed from: z, reason: collision with root package name */
    public static final int f8496z = ViewConfiguration.getTapTimeout();

    /* renamed from: i, reason: collision with root package name */
    public final a f8497i;

    /* renamed from: j, reason: collision with root package name */
    public final AccelerateInterpolator f8498j;

    /* renamed from: k, reason: collision with root package name */
    public final x1 f8499k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.activity.j f8500l;

    /* renamed from: m, reason: collision with root package name */
    public final float[] f8501m;

    /* renamed from: n, reason: collision with root package name */
    public final float[] f8502n;

    /* renamed from: o, reason: collision with root package name */
    public final int f8503o;

    /* renamed from: p, reason: collision with root package name */
    public final int f8504p;

    /* renamed from: q, reason: collision with root package name */
    public final float[] f8505q;

    /* renamed from: r, reason: collision with root package name */
    public final float[] f8506r;

    /* renamed from: s, reason: collision with root package name */
    public final float[] f8507s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8508t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f8509u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8510v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f8511w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8512x;

    /* renamed from: y, reason: collision with root package name */
    public final x1 f8513y;

    public g(x1 x1Var) {
        a aVar = new a();
        aVar.f8492e = Long.MIN_VALUE;
        aVar.f8494g = -1L;
        aVar.f8493f = 0L;
        this.f8497i = aVar;
        this.f8498j = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f8501m = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f8502n = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f8505q = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f8506r = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f8507s = fArr5;
        this.f8499k = x1Var;
        float f9 = Resources.getSystem().getDisplayMetrics().density;
        float f10 = ((int) ((1575.0f * f9) + 0.5f)) / 1000.0f;
        fArr5[0] = f10;
        fArr5[1] = f10;
        float f11 = ((int) ((f9 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f11;
        fArr4[1] = f11;
        this.f8503o = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f8504p = f8496z;
        aVar.f8488a = 500;
        aVar.f8489b = 500;
        this.f8513y = x1Var;
    }

    public static float b(float f9, float f10, float f11) {
        return f9 > f11 ? f11 : f9 < f10 ? f10 : f9;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f8501m
            r0 = r0[r4]
            float[] r1 = r3.f8502n
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            android.view.animation.AccelerateInterpolator r6 = r3.f8498j
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 >= 0) goto L26
            float r5 = -r5
            float r5 = r6.getInterpolation(r5)
            float r5 = -r5
            goto L2e
        L26:
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 <= 0) goto L37
            float r5 = r6.getInterpolation(r5)
        L2e:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L38
        L37:
            r5 = 0
        L38:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3d
            return r2
        L3d:
            float[] r0 = r3.f8505q
            r0 = r0[r4]
            float[] r1 = r3.f8506r
            r1 = r1[r4]
            float[] r2 = r3.f8507s
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L54
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L54:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.g.a(int, float, float, float):float");
    }

    public final float c(float f9, float f10) {
        if (f10 != 0.0f) {
            int i9 = this.f8503o;
            if (i9 == 0 || i9 == 1) {
                if (f9 < f10) {
                    if (f9 >= 0.0f) {
                        return 1.0f - (f9 / f10);
                    }
                    if (this.f8511w && i9 == 1) {
                        return 1.0f;
                    }
                }
            } else if (i9 == 2 && f9 < 0.0f) {
                return f9 / (-f10);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i9 = 0;
        if (this.f8509u) {
            this.f8511w = false;
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        a aVar = this.f8497i;
        int i10 = (int) (currentAnimationTimeMillis - aVar.f8492e);
        int i11 = aVar.f8489b;
        if (i10 > i11) {
            i9 = i11;
        } else if (i10 >= 0) {
            i9 = i10;
        }
        aVar.f8495i = i9;
        aVar.h = aVar.a(currentAnimationTimeMillis);
        aVar.f8494g = currentAnimationTimeMillis;
    }

    public final boolean e() {
        x1 x1Var;
        int count;
        a aVar = this.f8497i;
        float f9 = aVar.f8491d;
        int abs = (int) (f9 / Math.abs(f9));
        Math.abs(aVar.f8490c);
        if (abs != 0 && (count = (x1Var = this.f8513y).getCount()) != 0) {
            int childCount = x1Var.getChildCount();
            int firstVisiblePosition = x1Var.getFirstVisiblePosition();
            int i9 = firstVisiblePosition + childCount;
            if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && x1Var.getChildAt(0).getTop() >= 0)) : !(i9 >= count && x1Var.getChildAt(childCount - 1).getBottom() <= x1Var.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f8512x
            r1 = 0
            if (r0 != 0) goto L7
            goto L7e
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7e
        L17:
            r7.d()
            return r1
        L1b:
            r7.f8510v = r2
            r7.f8508t = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            n.x1 r4 = r7.f8499k
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            r0.a r9 = r7.f8497i
            r9.f8490c = r0
            r9.f8491d = r8
            boolean r8 = r7.f8511w
            if (r8 != 0) goto L7e
            boolean r8 = r7.e()
            if (r8 == 0) goto L7e
            androidx.activity.j r8 = r7.f8500l
            if (r8 != 0) goto L62
            androidx.activity.j r8 = new androidx.activity.j
            r9 = 14
            r8.<init>(r7, r9)
            r7.f8500l = r8
        L62:
            r7.f8511w = r2
            r7.f8509u = r2
            boolean r8 = r7.f8508t
            if (r8 != 0) goto L77
            int r8 = r7.f8504p
            if (r8 <= 0) goto L77
            androidx.activity.j r9 = r7.f8500l
            long r5 = (long) r8
            java.util.WeakHashMap r8 = n0.t0.f7209a
            n0.c0.n(r4, r9, r5)
            goto L7c
        L77:
            androidx.activity.j r8 = r7.f8500l
            r8.run()
        L7c:
            r7.f8508t = r2
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.g.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
