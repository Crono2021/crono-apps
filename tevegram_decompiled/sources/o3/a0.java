package o3;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 extends androidx.emoji2.text.h {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7589d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(o0 o0Var, int i9) {
        super(o0Var);
        this.f7589d = i9;
    }

    @Override // androidx.emoji2.text.h
    public final int b(View view) {
        int right;
        int i9;
        switch (this.f7589d) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                ((o0) this.f618b).getClass();
                right = view.getRight() + ((p0) view.getLayoutParams()).f7766b.right;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var).rightMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                ((o0) this.f618b).getClass();
                right = view.getBottom() + ((p0) view.getLayoutParams()).f7766b.bottom;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var2).bottomMargin;
                break;
        }
        return right + i9;
    }

    @Override // androidx.emoji2.text.h
    public final int c(View view) {
        int measuredWidth;
        int i9;
        switch (this.f7589d) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                ((o0) this.f618b).getClass();
                Rect rect = ((p0) view.getLayoutParams()).f7766b;
                measuredWidth = view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) p0Var).leftMargin;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var).rightMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                ((o0) this.f618b).getClass();
                Rect rect2 = ((p0) view.getLayoutParams()).f7766b;
                measuredWidth = view.getMeasuredHeight() + rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) p0Var2).topMargin;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var2).bottomMargin;
                break;
        }
        return measuredWidth + i9;
    }

    @Override // androidx.emoji2.text.h
    public final int d(View view) {
        int measuredHeight;
        int i9;
        switch (this.f7589d) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                ((o0) this.f618b).getClass();
                Rect rect = ((p0) view.getLayoutParams()).f7766b;
                measuredHeight = view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) p0Var).topMargin;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var).bottomMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                ((o0) this.f618b).getClass();
                Rect rect2 = ((p0) view.getLayoutParams()).f7766b;
                measuredHeight = view.getMeasuredWidth() + rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) p0Var2).leftMargin;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var2).rightMargin;
                break;
        }
        return measuredHeight + i9;
    }

    @Override // androidx.emoji2.text.h
    public final int e(View view) {
        int left;
        int i9;
        switch (this.f7589d) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                ((o0) this.f618b).getClass();
                left = view.getLeft() - ((p0) view.getLayoutParams()).f7766b.left;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var).leftMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                ((o0) this.f618b).getClass();
                left = view.getTop() - ((p0) view.getLayoutParams()).f7766b.top;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var2).topMargin;
                break;
        }
        return left - i9;
    }

    @Override // androidx.emoji2.text.h
    public final int f() {
        switch (this.f7589d) {
            case 0:
                return ((o0) this.f618b).f7760n;
            default:
                return ((o0) this.f618b).f7761o;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int g() {
        int i9;
        int D;
        switch (this.f7589d) {
            case 0:
                o0 o0Var = (o0) this.f618b;
                i9 = o0Var.f7760n;
                D = o0Var.D();
                break;
            default:
                o0 o0Var2 = (o0) this.f618b;
                i9 = o0Var2.f7761o;
                D = o0Var2.B();
                break;
        }
        return i9 - D;
    }

    @Override // androidx.emoji2.text.h
    public final int h() {
        switch (this.f7589d) {
            case 0:
                return ((o0) this.f618b).D();
            default:
                return ((o0) this.f618b).B();
        }
    }

    @Override // androidx.emoji2.text.h
    public final int i() {
        switch (this.f7589d) {
            case 0:
                return ((o0) this.f618b).f7758l;
            default:
                return ((o0) this.f618b).f7759m;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int j() {
        switch (this.f7589d) {
            case 0:
                return ((o0) this.f618b).f7759m;
            default:
                return ((o0) this.f618b).f7758l;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int k() {
        switch (this.f7589d) {
            case 0:
                return ((o0) this.f618b).C();
            default:
                return ((o0) this.f618b).E();
        }
    }

    @Override // androidx.emoji2.text.h
    public final int l() {
        int C;
        int D;
        switch (this.f7589d) {
            case 0:
                o0 o0Var = (o0) this.f618b;
                C = o0Var.f7760n - o0Var.C();
                D = o0Var.D();
                break;
            default:
                o0 o0Var2 = (o0) this.f618b;
                C = o0Var2.f7761o - o0Var2.E();
                D = o0Var2.B();
                break;
        }
        return C - D;
    }

    @Override // androidx.emoji2.text.h
    public final int m(View view) {
        switch (this.f7589d) {
            case 0:
                o0 o0Var = (o0) this.f618b;
                Rect rect = (Rect) this.f619c;
                o0Var.I(view, rect);
                return rect.right;
            default:
                o0 o0Var2 = (o0) this.f618b;
                Rect rect2 = (Rect) this.f619c;
                o0Var2.I(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // androidx.emoji2.text.h
    public final int n(View view) {
        switch (this.f7589d) {
            case 0:
                o0 o0Var = (o0) this.f618b;
                Rect rect = (Rect) this.f619c;
                o0Var.I(view, rect);
                return rect.left;
            default:
                o0 o0Var2 = (o0) this.f618b;
                Rect rect2 = (Rect) this.f619c;
                o0Var2.I(view, rect2);
                return rect2.top;
        }
    }

    @Override // androidx.emoji2.text.h
    public final void o(int i9) {
        switch (this.f7589d) {
            case 0:
                ((o0) this.f618b).M(i9);
                break;
            default:
                ((o0) this.f618b).N(i9);
                break;
        }
    }
}
