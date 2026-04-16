package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.ArrayList;
import w.d;
import w.g;
import x.b;
import y.o;
import y.p;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class Flow extends p {

    /* renamed from: q, reason: collision with root package name */
    public g f530q;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // y.p, y.b
    public final void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        g gVar = new g();
        gVar.f9674f0 = 0;
        gVar.f9675g0 = 0;
        gVar.f9676h0 = 0;
        gVar.i0 = 0;
        gVar.f9677j0 = 0;
        gVar.f9678k0 = 0;
        gVar.f9679l0 = false;
        gVar.f9680m0 = 0;
        gVar.f9681n0 = 0;
        gVar.f9682o0 = new b();
        gVar.f9683p0 = null;
        gVar.f9684q0 = -1;
        gVar.f9685r0 = -1;
        gVar.f9686s0 = -1;
        gVar.f9687t0 = -1;
        gVar.f9688u0 = -1;
        gVar.f9689v0 = -1;
        gVar.f9690w0 = 0.5f;
        gVar.f9691x0 = 0.5f;
        gVar.f9692y0 = 0.5f;
        gVar.f9693z0 = 0.5f;
        gVar.A0 = 0.5f;
        gVar.B0 = 0.5f;
        gVar.C0 = 0;
        gVar.D0 = 0;
        gVar.E0 = 2;
        gVar.F0 = 2;
        gVar.G0 = 0;
        gVar.H0 = -1;
        gVar.I0 = 0;
        gVar.J0 = new ArrayList();
        gVar.K0 = null;
        gVar.L0 = null;
        gVar.M0 = null;
        gVar.O0 = 0;
        this.f530q = gVar;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f10338b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = obtainStyledAttributes.getIndex(i9);
                if (index == 0) {
                    this.f530q.I0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    g gVar2 = this.f530q;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar2.f9674f0 = dimensionPixelSize;
                    gVar2.f9675g0 = dimensionPixelSize;
                    gVar2.f9676h0 = dimensionPixelSize;
                    gVar2.i0 = dimensionPixelSize;
                } else if (index == 11) {
                    g gVar3 = this.f530q;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar3.f9676h0 = dimensionPixelSize2;
                    gVar3.f9677j0 = dimensionPixelSize2;
                    gVar3.f9678k0 = dimensionPixelSize2;
                } else if (index == 12) {
                    this.f530q.i0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f530q.f9677j0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f530q.f9674f0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f530q.f9678k0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f530q.f9675g0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 37) {
                    this.f530q.G0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 27) {
                    this.f530q.f9684q0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 36) {
                    this.f530q.f9685r0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 21) {
                    this.f530q.f9686s0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 29) {
                    this.f530q.f9688u0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 23) {
                    this.f530q.f9687t0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 31) {
                    this.f530q.f9689v0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 25) {
                    this.f530q.f9690w0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 20) {
                    this.f530q.f9692y0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 28) {
                    this.f530q.A0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 22) {
                    this.f530q.f9693z0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 30) {
                    this.f530q.B0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 34) {
                    this.f530q.f9691x0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 24) {
                    this.f530q.E0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 33) {
                    this.f530q.F0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 26) {
                    this.f530q.C0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 35) {
                    this.f530q.D0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 32) {
                    this.f530q.H0 = obtainStyledAttributes.getInt(index, -1);
                }
            }
        }
        this.f10227l = this.f530q;
        g();
    }

    @Override // y.b
    public final void f(d dVar, boolean z8) {
        g gVar = this.f530q;
        int i9 = gVar.f9676h0;
        if (i9 > 0 || gVar.i0 > 0) {
            if (z8) {
                gVar.f9677j0 = gVar.i0;
                gVar.f9678k0 = i9;
            } else {
                gVar.f9677j0 = i9;
                gVar.f9678k0 = gVar.i0;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x053a  */
    @Override // y.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(w.g r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 1386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.h(w.g, int, int):void");
    }

    @Override // y.b, android.view.View
    public final void onMeasure(int i9, int i10) {
        h(this.f530q, i9, i10);
    }

    public void setFirstHorizontalBias(float f9) {
        this.f530q.f9692y0 = f9;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i9) {
        this.f530q.f9686s0 = i9;
        requestLayout();
    }

    public void setFirstVerticalBias(float f9) {
        this.f530q.f9693z0 = f9;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i9) {
        this.f530q.f9687t0 = i9;
        requestLayout();
    }

    public void setHorizontalAlign(int i9) {
        this.f530q.E0 = i9;
        requestLayout();
    }

    public void setHorizontalBias(float f9) {
        this.f530q.f9690w0 = f9;
        requestLayout();
    }

    public void setHorizontalGap(int i9) {
        this.f530q.C0 = i9;
        requestLayout();
    }

    public void setHorizontalStyle(int i9) {
        this.f530q.f9684q0 = i9;
        requestLayout();
    }

    public void setMaxElementsWrap(int i9) {
        this.f530q.H0 = i9;
        requestLayout();
    }

    public void setOrientation(int i9) {
        this.f530q.I0 = i9;
        requestLayout();
    }

    public void setPadding(int i9) {
        g gVar = this.f530q;
        gVar.f9674f0 = i9;
        gVar.f9675g0 = i9;
        gVar.f9676h0 = i9;
        gVar.i0 = i9;
        requestLayout();
    }

    public void setPaddingBottom(int i9) {
        this.f530q.f9675g0 = i9;
        requestLayout();
    }

    public void setPaddingLeft(int i9) {
        this.f530q.f9677j0 = i9;
        requestLayout();
    }

    public void setPaddingRight(int i9) {
        this.f530q.f9678k0 = i9;
        requestLayout();
    }

    public void setPaddingTop(int i9) {
        this.f530q.f9674f0 = i9;
        requestLayout();
    }

    public void setVerticalAlign(int i9) {
        this.f530q.F0 = i9;
        requestLayout();
    }

    public void setVerticalBias(float f9) {
        this.f530q.f9691x0 = f9;
        requestLayout();
    }

    public void setVerticalGap(int i9) {
        this.f530q.D0 = i9;
        requestLayout();
    }

    public void setVerticalStyle(int i9) {
        this.f530q.f9685r0 = i9;
        requestLayout();
    }

    public void setWrapMode(int i9) {
        this.f530q.G0 = i9;
        requestLayout();
    }
}
