package o3;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f1 extends n0.c {

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f7651d;

    /* renamed from: e, reason: collision with root package name */
    public final e1 f7652e;

    public f1(RecyclerView recyclerView) {
        this.f7651d = recyclerView;
        e1 e1Var = this.f7652e;
        if (e1Var != null) {
            this.f7652e = e1Var;
        } else {
            this.f7652e = new e1(this);
        }
    }

    @Override // n0.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f7651d.L()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().R(accessibilityEvent);
        }
    }

    @Override // n0.c
    public final void d(View view, o0.l lVar) {
        this.f7144a.onInitializeAccessibilityNodeInfo(view, lVar.f7564a);
        RecyclerView recyclerView = this.f7651d;
        if (recyclerView.L() || recyclerView.getLayoutManager() == null) {
            return;
        }
        o0 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f7749b;
        layoutManager.S(recyclerView2.f1058k, recyclerView2.f1067o0, lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3 A[ADDED_TO_REGION] */
    @Override // n0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.View r6, int r7, android.os.Bundle r8) {
        /*
            r5 = this;
            boolean r6 = super.g(r6, r7, r8)
            r8 = 1
            if (r6 == 0) goto L8
            return r8
        L8:
            androidx.recyclerview.widget.RecyclerView r6 = r5.f7651d
            boolean r0 = r6.L()
            r1 = 0
            if (r0 != 0) goto Lac
            o3.o0 r0 = r6.getLayoutManager()
            if (r0 == 0) goto Lac
            o3.o0 r6 = r6.getLayoutManager()
            androidx.recyclerview.widget.RecyclerView r0 = r6.f7749b
            l7.a r0 = r0.f1058k
            int r0 = r6.f7761o
            int r2 = r6.f7760n
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            androidx.recyclerview.widget.RecyclerView r4 = r6.f7749b
            android.graphics.Matrix r4 = r4.getMatrix()
            boolean r4 = r4.isIdentity()
            if (r4 == 0) goto L44
            androidx.recyclerview.widget.RecyclerView r4 = r6.f7749b
            boolean r4 = r4.getGlobalVisibleRect(r3)
            if (r4 == 0) goto L44
            int r0 = r3.height()
            int r2 = r3.width()
        L44:
            r3 = 4096(0x1000, float:5.74E-42)
            if (r7 == r3) goto L79
            r3 = 8192(0x2000, float:1.148E-41)
            if (r7 == r3) goto L4f
            r7 = 0
        L4d:
            r0 = 0
            goto La1
        L4f:
            androidx.recyclerview.widget.RecyclerView r7 = r6.f7749b
            r3 = -1
            boolean r7 = r7.canScrollVertically(r3)
            if (r7 == 0) goto L64
            int r7 = r6.E()
            int r0 = r0 - r7
            int r7 = r6.B()
            int r0 = r0 - r7
            int r7 = -r0
            goto L65
        L64:
            r7 = 0
        L65:
            androidx.recyclerview.widget.RecyclerView r0 = r6.f7749b
            boolean r0 = r0.canScrollHorizontally(r3)
            if (r0 == 0) goto L4d
            int r0 = r6.C()
            int r2 = r2 - r0
            int r0 = r6.D()
            int r2 = r2 - r0
            int r0 = -r2
            goto La1
        L79:
            androidx.recyclerview.widget.RecyclerView r7 = r6.f7749b
            boolean r7 = r7.canScrollVertically(r8)
            if (r7 == 0) goto L8d
            int r7 = r6.E()
            int r0 = r0 - r7
            int r7 = r6.B()
            int r0 = r0 - r7
            r7 = r0
            goto L8e
        L8d:
            r7 = 0
        L8e:
            androidx.recyclerview.widget.RecyclerView r0 = r6.f7749b
            boolean r0 = r0.canScrollHorizontally(r8)
            if (r0 == 0) goto L4d
            int r0 = r6.C()
            int r2 = r2 - r0
            int r0 = r6.D()
            int r0 = r2 - r0
        La1:
            if (r7 != 0) goto La6
            if (r0 != 0) goto La6
            goto Lac
        La6:
            androidx.recyclerview.widget.RecyclerView r6 = r6.f7749b
            r6.f0(r0, r7, r8)
            return r8
        Lac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.f1.g(android.view.View, int, android.os.Bundle):boolean");
    }
}
