package v5;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9576o;

    /* renamed from: p, reason: collision with root package name */
    public final SideSheetBehavior f9577p;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i9) {
        this.f9576o = i9;
        this.f9577p = sideSheetBehavior;
    }

    @Override // android.support.v4.media.session.b
    public final void B0(ViewGroup.MarginLayoutParams marginLayoutParams, int i9, int i10) {
        switch (this.f9576o) {
            case 0:
                if (i9 <= this.f9577p.f2116m) {
                    marginLayoutParams.leftMargin = i10;
                    break;
                }
                break;
            default:
                int i11 = this.f9577p.f2116m;
                if (i9 <= i11) {
                    marginLayoutParams.rightMargin = i11 - i9;
                    break;
                }
                break;
        }
    }

    @Override // android.support.v4.media.session.b
    public final int J() {
        switch (this.f9576o) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f9577p;
                return Math.max(0, sideSheetBehavior.f2117n + sideSheetBehavior.f2118o);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.f9577p;
                return Math.max(0, (sideSheetBehavior2.f2116m - sideSheetBehavior2.f2115l) - sideSheetBehavior2.f2118o);
        }
    }

    @Override // android.support.v4.media.session.b
    public final int K() {
        switch (this.f9576o) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f9577p;
                return (-sideSheetBehavior.f2115l) - sideSheetBehavior.f2118o;
            default:
                return this.f9577p.f2116m;
        }
    }

    @Override // android.support.v4.media.session.b
    public final int M() {
        switch (this.f9576o) {
            case 0:
                return this.f9577p.f2118o;
            default:
                return this.f9577p.f2116m;
        }
    }

    @Override // android.support.v4.media.session.b
    public final int N() {
        switch (this.f9576o) {
            case 0:
                return -this.f9577p.f2115l;
            default:
                return J();
        }
    }

    @Override // android.support.v4.media.session.b
    public final int O(View view) {
        switch (this.f9576o) {
            case 0:
                return view.getRight() + this.f9577p.f2118o;
            default:
                return view.getLeft() - this.f9577p.f2118o;
        }
    }

    @Override // android.support.v4.media.session.b
    public final int P(CoordinatorLayout coordinatorLayout) {
        switch (this.f9576o) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // android.support.v4.media.session.b
    public final int Q() {
        switch (this.f9576o) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // android.support.v4.media.session.b
    public final boolean W(float f9) {
        switch (this.f9576o) {
            case 0:
                if (f9 > 0.0f) {
                }
                break;
            default:
                if (f9 < 0.0f) {
                }
                break;
        }
        return false;
    }

    @Override // android.support.v4.media.session.b
    public final boolean Z(View view) {
        switch (this.f9576o) {
            case 0:
                if (view.getRight() < (J() - K()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (J() + this.f9577p.f2116m) / 2) {
                }
                break;
        }
        return false;
    }

    @Override // android.support.v4.media.session.b
    public final boolean a0(float f9, float f10) {
        switch (this.f9576o) {
            case 0:
                if (Math.abs(f9) <= Math.abs(f10) || Math.abs(f9) <= 500) {
                }
                break;
            default:
                if (Math.abs(f9) <= Math.abs(f10) || Math.abs(f9) <= 500) {
                }
                break;
        }
        return false;
    }

    @Override // android.support.v4.media.session.b
    public final int l(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f9576o) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // android.support.v4.media.session.b
    public final float m(int i9) {
        switch (this.f9576o) {
            case 0:
                float K = K();
                return (i9 - K) / (J() - K);
            default:
                float f9 = this.f9577p.f2116m;
                return (f9 - i9) / (f9 - J());
        }
    }

    @Override // android.support.v4.media.session.b
    public final boolean u0(View view, float f9) {
        switch (this.f9576o) {
            case 0:
                if (Math.abs((f9 * this.f9577p.f2114k) + view.getLeft()) > 0.5f) {
                }
                break;
            default:
                if (Math.abs((f9 * this.f9577p.f2114k) + view.getRight()) > 0.5f) {
                }
                break;
        }
        return false;
    }
}
