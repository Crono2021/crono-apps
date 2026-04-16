package o3;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7732a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f7733b;

    public /* synthetic */ m0(o0 o0Var, int i9) {
        this.f7732a = i9;
        this.f7733b = o0Var;
    }

    public final int a(View view) {
        int right;
        int i9;
        switch (this.f7732a) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                right = view.getRight() + ((p0) view.getLayoutParams()).f7766b.right;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var).rightMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                right = view.getBottom() + ((p0) view.getLayoutParams()).f7766b.bottom;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var2).bottomMargin;
                break;
        }
        return right + i9;
    }

    public final int b(View view) {
        int left;
        int i9;
        switch (this.f7732a) {
            case 0:
                p0 p0Var = (p0) view.getLayoutParams();
                left = view.getLeft() - ((p0) view.getLayoutParams()).f7766b.left;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var).leftMargin;
                break;
            default:
                p0 p0Var2 = (p0) view.getLayoutParams();
                left = view.getTop() - ((p0) view.getLayoutParams()).f7766b.top;
                i9 = ((ViewGroup.MarginLayoutParams) p0Var2).topMargin;
                break;
        }
        return left - i9;
    }

    public final int c() {
        int i9;
        int D;
        switch (this.f7732a) {
            case 0:
                o0 o0Var = this.f7733b;
                i9 = o0Var.f7760n;
                D = o0Var.D();
                break;
            default:
                o0 o0Var2 = this.f7733b;
                i9 = o0Var2.f7761o;
                D = o0Var2.B();
                break;
        }
        return i9 - D;
    }

    public final int d() {
        switch (this.f7732a) {
            case 0:
                return this.f7733b.C();
            default:
                return this.f7733b.E();
        }
    }
}
