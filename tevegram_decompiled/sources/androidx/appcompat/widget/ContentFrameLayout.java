package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import g.c0;
import g.s;
import m.m;
import n.f;
import n.j;
import n.n1;
import n.y3;
import n0.c1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    public TypedValue f445i;

    /* renamed from: j, reason: collision with root package name */
    public TypedValue f446j;

    /* renamed from: k, reason: collision with root package name */
    public TypedValue f447k;

    /* renamed from: l, reason: collision with root package name */
    public TypedValue f448l;

    /* renamed from: m, reason: collision with root package name */
    public TypedValue f449m;

    /* renamed from: n, reason: collision with root package name */
    public TypedValue f450n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f451o;

    /* renamed from: p, reason: collision with root package name */
    public n1 f452p;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f451o = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f449m == null) {
            this.f449m = new TypedValue();
        }
        return this.f449m;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f450n == null) {
            this.f450n = new TypedValue();
        }
        return this.f450n;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f447k == null) {
            this.f447k = new TypedValue();
        }
        return this.f447k;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f448l == null) {
            this.f448l = new TypedValue();
        }
        return this.f448l;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f445i == null) {
            this.f445i = new TypedValue();
        }
        return this.f445i;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f446j == null) {
            this.f446j = new TypedValue();
        }
        return this.f446j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        n1 n1Var = this.f452p;
        if (n1Var != null) {
            n1Var.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        j jVar;
        super.onDetachedFromWindow();
        n1 n1Var = this.f452p;
        if (n1Var != null) {
            c0 c0Var = ((s) n1Var).f3631j;
            ActionBarOverlayLayout actionBarOverlayLayout = c0Var.f3495z;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((y3) actionBarOverlayLayout.f424m).f7109a.f499i;
                if (actionMenuView != null && (jVar = actionMenuView.B) != null) {
                    jVar.c();
                    f fVar = jVar.B;
                    if (fVar != null && fVar.b()) {
                        fVar.f6491i.dismiss();
                    }
                }
            }
            if (c0Var.E != null) {
                c0Var.f3489t.getDecorView().removeCallbacks(c0Var.F);
                if (c0Var.E.isShowing()) {
                    try {
                        c0Var.E.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                c0Var.E = null;
            }
            c1 c1Var = c0Var.G;
            if (c1Var != null) {
                c1Var.b();
            }
            m mVar = c0Var.A(0).h;
            if (mVar != null) {
                mVar.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(n1 n1Var) {
        this.f452p = n1Var;
    }
}
