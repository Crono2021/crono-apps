package d5;

import android.view.View;
import android.view.ViewGroup;
import androidx.activity.g;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2949o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ a0.d f2950p;

    public /* synthetic */ c(a0.d dVar, int i9) {
        this.f2949o = i9;
        this.f2950p = dVar;
    }

    @Override // android.support.v4.media.session.b
    public int S(View view) {
        switch (this.f2949o) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2950p;
                return sideSheetBehavior.f2115l + sideSheetBehavior.f2118o;
            default:
                return super.S(view);
        }
    }

    @Override // android.support.v4.media.session.b
    public int T() {
        switch (this.f2949o) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f2950p;
                return bottomSheetBehavior.I ? bottomSheetBehavior.T : bottomSheetBehavior.G;
            default:
                return super.T();
        }
    }

    @Override // android.support.v4.media.session.b
    public final void h0(int i9) {
        switch (this.f2949o) {
            case 0:
                if (i9 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f2950p;
                    if (bottomSheetBehavior.K) {
                        bottomSheetBehavior.D(1);
                        break;
                    }
                }
                break;
            default:
                if (i9 == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2950p;
                    if (sideSheetBehavior.f2111g) {
                        sideSheetBehavior.s(1);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.support.v4.media.session.b
    public final void i0(View view, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.f2949o) {
            case 0:
                ((BottomSheetBehavior) this.f2950p).v(i10);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2950p;
                WeakReference weakReference = sideSheetBehavior.f2120q;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f2105a.B0(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.f2124u;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f2105a.m(i9);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw g.l(it);
                }
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (r0.f2105a.Z(r6) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        if (java.lang.Math.abs(r7 - r0.f2105a.J()) < java.lang.Math.abs(r7 - r0.f2105a.K())) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        if (r7 > r4.E) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cd, code lost:
    
        if (java.lang.Math.abs(r6.getTop() - r4.y()) < java.lang.Math.abs(r6.getTop() - r4.E)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fb, code lost:
    
        if (java.lang.Math.abs(r7 - r4.E) < java.lang.Math.abs(r7 - r4.G)) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0115, code lost:
    
        if (java.lang.Math.abs(r7 - r4.D) < java.lang.Math.abs(r7 - r4.G)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0125, code lost:
    
        if (r7 < java.lang.Math.abs(r7 - r4.G)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0136, code lost:
    
        if (java.lang.Math.abs(r7 - r8) < java.lang.Math.abs(r7 - r4.G)) goto L73;
     */
    @Override // android.support.v4.media.session.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j0(android.view.View r6, float r7, float r8) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.c.j0(android.view.View, float, float):void");
    }

    @Override // android.support.v4.media.session.b
    public final int t(View view, int i9) {
        switch (this.f2949o) {
            case 0:
                return view.getLeft();
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2950p;
                return com.bumptech.glide.c.i(i9, sideSheetBehavior.f2105a.N(), sideSheetBehavior.f2105a.M());
        }
    }

    @Override // android.support.v4.media.session.b
    public final int u(View view, int i9) {
        switch (this.f2949o) {
            case 0:
                return com.bumptech.glide.c.i(i9, ((BottomSheetBehavior) this.f2950p).y(), T());
            default:
                return view.getTop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r6.canScrollVertically(-1) != false) goto L37;
     */
    @Override // android.support.v4.media.session.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean y0(android.view.View r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.f2949o
            switch(r0) {
                case 0: goto L1c;
                default: goto L5;
            }
        L5:
            a0.d r6 = r4.f2950p
            com.google.android.material.sidesheet.SideSheetBehavior r6 = (com.google.android.material.sidesheet.SideSheetBehavior) r6
            int r0 = r6.h
            r1 = 1
            if (r0 != r1) goto Lf
            goto L1a
        Lf:
            java.lang.ref.WeakReference r6 = r6.f2119p
            if (r6 == 0) goto L1a
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L1a
            goto L1b
        L1a:
            r1 = 0
        L1b:
            return r1
        L1c:
            a0.d r0 = r4.f2950p
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r0
            int r1 = r0.L
            r2 = 1
            if (r1 != r2) goto L26
            goto L56
        L26:
            boolean r3 = r0.f1921a0
            if (r3 == 0) goto L2b
            goto L56
        L2b:
            r3 = 3
            if (r1 != r3) goto L48
            int r1 = r0.Y
            if (r1 != r6) goto L48
            java.lang.ref.WeakReference r6 = r0.V
            if (r6 == 0) goto L3d
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L3e
        L3d:
            r6 = 0
        L3e:
            if (r6 == 0) goto L48
            r1 = -1
            boolean r6 = r6.canScrollVertically(r1)
            if (r6 == 0) goto L48
            goto L56
        L48:
            java.lang.System.currentTimeMillis()
            java.lang.ref.WeakReference r6 = r0.U
            if (r6 == 0) goto L56
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L56
            goto L57
        L56:
            r2 = 0
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.c.y0(android.view.View, int):boolean");
    }
}
