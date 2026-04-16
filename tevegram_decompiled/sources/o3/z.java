package o3;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public int f7853a = -1;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f7854b;

    /* renamed from: c, reason: collision with root package name */
    public o0 f7855c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7856d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7857e;

    /* renamed from: f, reason: collision with root package name */
    public View f7858f;

    /* renamed from: g, reason: collision with root package name */
    public final x0 f7859g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f7860i;

    /* renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f7861j;

    /* renamed from: k, reason: collision with root package name */
    public PointF f7862k;

    /* renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f7863l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7864m;

    /* renamed from: n, reason: collision with root package name */
    public float f7865n;

    /* renamed from: o, reason: collision with root package name */
    public int f7866o;

    /* renamed from: p, reason: collision with root package name */
    public int f7867p;

    public z(Context context) {
        x0 x0Var = new x0();
        x0Var.f7846d = -1;
        x0Var.f7848f = false;
        x0Var.f7849g = 0;
        x0Var.f7843a = 0;
        x0Var.f7844b = 0;
        x0Var.f7845c = Integer.MIN_VALUE;
        x0Var.f7847e = null;
        this.f7859g = x0Var;
        this.f7860i = new LinearInterpolator();
        this.f7861j = new DecelerateInterpolator();
        this.f7864m = false;
        this.f7866o = 0;
        this.f7867p = 0;
        this.f7863l = context.getResources().getDisplayMetrics();
    }

    public static int a(int i9, int i10, int i11, int i12, int i13) {
        if (i13 == -1) {
            return i11 - i9;
        }
        if (i13 != 0) {
            if (i13 == 1) {
                return i12 - i10;
            }
            m7.c.n("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            return 0;
        }
        int i14 = i11 - i9;
        if (i14 > 0) {
            return i14;
        }
        int i15 = i12 - i10;
        if (i15 < 0) {
            return i15;
        }
        return 0;
    }

    public int b(View view, int i9) {
        o0 o0Var = this.f7855c;
        if (o0Var == null || !o0Var.d()) {
            return 0;
        }
        p0 p0Var = (p0) view.getLayoutParams();
        return a((view.getLeft() - ((p0) view.getLayoutParams()).f7766b.left) - ((ViewGroup.MarginLayoutParams) p0Var).leftMargin, view.getRight() + ((p0) view.getLayoutParams()).f7766b.right + ((ViewGroup.MarginLayoutParams) p0Var).rightMargin, o0Var.C(), o0Var.f7760n - o0Var.D(), i9);
    }

    public int c(View view, int i9) {
        o0 o0Var = this.f7855c;
        if (o0Var == null || !o0Var.e()) {
            return 0;
        }
        p0 p0Var = (p0) view.getLayoutParams();
        return a((view.getTop() - ((p0) view.getLayoutParams()).f7766b.top) - ((ViewGroup.MarginLayoutParams) p0Var).topMargin, view.getBottom() + ((p0) view.getLayoutParams()).f7766b.bottom + ((ViewGroup.MarginLayoutParams) p0Var).bottomMargin, o0Var.E(), o0Var.f7761o - o0Var.B(), i9);
    }

    public float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int e(int i9) {
        float abs = Math.abs(i9);
        if (!this.f7864m) {
            this.f7865n = d(this.f7863l);
            this.f7864m = true;
        }
        return (int) Math.ceil(abs * this.f7865n);
    }

    public PointF f(int i9) {
        Object obj = this.f7855c;
        if (obj instanceof y0) {
            return ((y0) obj).a(i9);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + y0.class.getCanonicalName());
        return null;
    }

    public final void g(int i9, int i10) {
        PointF f9;
        RecyclerView recyclerView = this.f7854b;
        if (this.f7853a == -1 || recyclerView == null) {
            i();
        }
        if (this.f7856d && this.f7858f == null && this.f7855c != null && (f9 = f(this.f7853a)) != null) {
            float f10 = f9.x;
            if (f10 != 0.0f || f9.y != 0.0f) {
                recyclerView.c0((int) Math.signum(f10), (int) Math.signum(f9.y), null);
            }
        }
        this.f7856d = false;
        View view = this.f7858f;
        x0 x0Var = this.f7859g;
        if (view != null) {
            this.f7854b.getClass();
            d1 J = RecyclerView.J(view);
            if ((J != null ? J.b() : -1) == this.f7853a) {
                View view2 = this.f7858f;
                z0 z0Var = recyclerView.f1067o0;
                h(view2, x0Var);
                x0Var.a(recyclerView);
                i();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f7858f = null;
            }
        }
        if (this.f7857e) {
            z0 z0Var2 = recyclerView.f1067o0;
            if (this.f7854b.f1080v.v() == 0) {
                i();
            } else {
                int i11 = this.f7866o;
                int i12 = i11 - i9;
                if (i11 * i12 <= 0) {
                    i12 = 0;
                }
                this.f7866o = i12;
                int i13 = this.f7867p;
                int i14 = i13 - i10;
                if (i13 * i14 <= 0) {
                    i14 = 0;
                }
                this.f7867p = i14;
                if (i12 == 0 && i14 == 0) {
                    PointF f11 = f(this.f7853a);
                    if (f11 != null) {
                        if (f11.x != 0.0f || f11.y != 0.0f) {
                            float f12 = f11.y;
                            float sqrt = (float) Math.sqrt((f12 * f12) + (r10 * r10));
                            float f13 = f11.x / sqrt;
                            f11.x = f13;
                            float f14 = f11.y / sqrt;
                            f11.y = f14;
                            this.f7862k = f11;
                            this.f7866o = (int) (f13 * 10000.0f);
                            this.f7867p = (int) (f14 * 10000.0f);
                            int e9 = e(10000);
                            x0Var.f7843a = (int) (this.f7866o * 1.2f);
                            x0Var.f7844b = (int) (this.f7867p * 1.2f);
                            x0Var.f7845c = (int) (e9 * 1.2f);
                            x0Var.f7847e = this.f7860i;
                            x0Var.f7848f = true;
                        }
                    }
                    x0Var.f7846d = this.f7853a;
                    i();
                }
            }
            boolean z8 = x0Var.f7846d >= 0;
            x0Var.a(recyclerView);
            if (z8 && this.f7857e) {
                this.f7856d = true;
                recyclerView.f1061l0.b();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.view.View r7, o3.x0 r8) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r6.f7862k
            r1 = 0
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L15
            float r0 = r0.x
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto Lf
            goto L15
        Lf:
            if (r0 <= 0) goto L13
            r0 = 1
            goto L16
        L13:
            r0 = -1
            goto L16
        L15:
            r0 = 0
        L16:
            int r0 = r6.b(r7, r0)
            android.graphics.PointF r5 = r6.f7862k
            if (r5 == 0) goto L2a
            float r5 = r5.y
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L25
            goto L2a
        L25:
            if (r4 <= 0) goto L29
            r1 = 1
            goto L2a
        L29:
            r1 = -1
        L2a:
            int r7 = r6.c(r7, r1)
            int r1 = r0 * r0
            int r2 = r7 * r7
            int r2 = r2 + r1
            double r1 = (double) r2
            double r1 = java.lang.Math.sqrt(r1)
            int r1 = (int) r1
            int r1 = r6.e(r1)
            double r1 = (double) r1
            r4 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r1 = r1 / r4
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            if (r1 <= 0) goto L59
            int r0 = -r0
            int r7 = -r7
            r8.f7843a = r0
            r8.f7844b = r7
            r8.f7845c = r1
            android.view.animation.DecelerateInterpolator r7 = r6.f7861j
            r8.f7847e = r7
            r8.f7848f = r3
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.z.h(android.view.View, o3.x0):void");
    }

    public final void i() {
        if (this.f7857e) {
            this.f7857e = false;
            this.f7867p = 0;
            this.f7866o = 0;
            this.f7862k = null;
            this.f7854b.f1067o0.f7868a = -1;
            this.f7858f = null;
            this.f7853a = -1;
            this.f7856d = false;
            o0 o0Var = this.f7855c;
            if (o0Var.f7752e == this) {
                o0Var.f7752e = null;
            }
            this.f7855c = null;
            this.f7854b = null;
        }
    }
}
