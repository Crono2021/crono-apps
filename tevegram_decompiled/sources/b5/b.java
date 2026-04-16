package b5;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;
import n0.d0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public int f1336o;

    /* renamed from: p, reason: collision with root package name */
    public int f1337p = -1;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f1338q;

    public b(SwipeDismissBehavior swipeDismissBehavior) {
        this.f1338q = swipeDismissBehavior;
    }

    @Override // android.support.v4.media.session.b
    public final int S(View view) {
        return view.getWidth();
    }

    @Override // android.support.v4.media.session.b
    public final void g0(View view, int i9) {
        this.f1337p = i9;
        this.f1336o = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f1338q;
            swipeDismissBehavior.f1915c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f1915c = false;
        }
    }

    @Override // android.support.v4.media.session.b
    public final void i0(View view, int i9, int i10) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f1338q;
        float f9 = width * swipeDismissBehavior.f1917e;
        float width2 = view.getWidth() * swipeDismissBehavior.f1918f;
        float abs = Math.abs(i9 - this.f1336o);
        if (abs <= f9) {
            view.setAlpha(1.0f);
        } else if (abs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((abs - f9) / (width2 - f9))), 1.0f));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0051, code lost:
    
        if (java.lang.Math.abs(r9.getLeft() - r8.f1336o) >= java.lang.Math.round(r9.getWidth() * 0.5f)) goto L27;
     */
    @Override // android.support.v4.media.session.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j0(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f1337p = r11
            int r11 = r9.getWidth()
            r0 = 0
            com.google.android.material.behavior.SwipeDismissBehavior r1 = r8.f1338q
            r2 = 1
            r3 = 0
            int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r4 == 0) goto L39
            java.util.WeakHashMap r5 = n0.t0.f7209a
            int r5 = n0.d0.d(r9)
            if (r5 != r2) goto L1a
            r5 = 1
            goto L1b
        L1a:
            r5 = 0
        L1b:
            int r6 = r1.f1916d
            r7 = 2
            if (r6 != r7) goto L21
            goto L53
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r4 >= 0) goto L67
            goto L53
        L2a:
            if (r4 <= 0) goto L67
            goto L53
        L2d:
            if (r6 != r2) goto L67
            if (r5 == 0) goto L34
            if (r4 <= 0) goto L67
            goto L53
        L34:
            int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r4 >= 0) goto L67
            goto L53
        L39:
            int r4 = r9.getLeft()
            int r5 = r8.f1336o
            int r4 = r4 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r4 = java.lang.Math.abs(r4)
            if (r4 < r5) goto L67
        L53:
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 < 0) goto L62
            int r10 = r9.getLeft()
            int r0 = r8.f1336o
            if (r10 >= r0) goto L60
            goto L62
        L60:
            int r0 = r0 + r11
            goto L6b
        L62:
            int r10 = r8.f1336o
            int r0 = r10 - r11
            goto L6b
        L67:
            int r10 = r8.f1336o
            r0 = r10
            r2 = 0
        L6b:
            v0.d r10 = r1.f1913a
            int r11 = r9.getTop()
            boolean r10 = r10.o(r0, r11)
            if (r10 == 0) goto L81
            androidx.fragment.app.d r10 = new androidx.fragment.app.d
            r10.<init>(r1, r9, r2)
            java.util.WeakHashMap r11 = n0.t0.f7209a
            n0.c0.m(r9, r10)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.b.j0(android.view.View, float, float):void");
    }

    @Override // android.support.v4.media.session.b
    public final int t(View view, int i9) {
        int width;
        int width2;
        WeakHashMap weakHashMap = t0.f7209a;
        boolean z8 = d0.d(view) == 1;
        int i10 = this.f1338q.f1916d;
        if (i10 == 0) {
            width = this.f1336o;
            if (z8) {
                width -= view.getWidth();
                width2 = this.f1336o;
            } else {
                width2 = view.getWidth() + width;
            }
        } else {
            int i11 = this.f1336o;
            if (i10 != 1) {
                width = i11 - view.getWidth();
                width2 = view.getWidth() + this.f1336o;
            } else if (z8) {
                width2 = view.getWidth() + i11;
                width = i11;
            } else {
                width = i11 - view.getWidth();
                width2 = this.f1336o;
            }
        }
        return Math.min(Math.max(width, i9), width2);
    }

    @Override // android.support.v4.media.session.b
    public final int u(View view, int i9) {
        return view.getTop();
    }

    @Override // android.support.v4.media.session.b
    public final boolean y0(View view, int i9) {
        int i10 = this.f1337p;
        return (i10 == -1 || i10 == i9) && this.f1338q.s(view);
    }

    @Override // android.support.v4.media.session.b
    public final void h0(int i9) {
    }
}
