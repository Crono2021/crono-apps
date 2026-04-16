package o3;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e1 extends n0.c {

    /* renamed from: d, reason: collision with root package name */
    public final f1 f7643d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakHashMap f7644e = new WeakHashMap();

    public e1(f1 f1Var) {
        this.f7643d = f1Var;
    }

    @Override // n0.c
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        n0.c cVar = (n0.c) this.f7644e.get(view);
        return cVar != null ? cVar.a(view, accessibilityEvent) : this.f7144a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // n0.c
    public final i7.x b(View view) {
        n0.c cVar = (n0.c) this.f7644e.get(view);
        return cVar != null ? cVar.b(view) : super.b(view);
    }

    @Override // n0.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        n0.c cVar = (n0.c) this.f7644e.get(view);
        if (cVar != null) {
            cVar.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // n0.c
    public final void d(View view, o0.l lVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = lVar.f7564a;
        f1 f1Var = this.f7643d;
        RecyclerView recyclerView = f1Var.f7651d;
        RecyclerView recyclerView2 = f1Var.f7651d;
        boolean L = recyclerView.L();
        View.AccessibilityDelegate accessibilityDelegate = this.f7144a;
        if (L || recyclerView2.getLayoutManager() == null) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            return;
        }
        recyclerView2.getLayoutManager().T(view, lVar);
        n0.c cVar = (n0.c) this.f7644e.get(view);
        if (cVar != null) {
            cVar.d(view, lVar);
        } else {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // n0.c
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        n0.c cVar = (n0.c) this.f7644e.get(view);
        if (cVar != null) {
            cVar.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // n0.c
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        n0.c cVar = (n0.c) this.f7644e.get(viewGroup);
        return cVar != null ? cVar.f(viewGroup, view, accessibilityEvent) : this.f7144a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // n0.c
    public final boolean g(View view, int i9, Bundle bundle) {
        f1 f1Var = this.f7643d;
        RecyclerView recyclerView = f1Var.f7651d;
        RecyclerView recyclerView2 = f1Var.f7651d;
        if (recyclerView.L() || recyclerView2.getLayoutManager() == null) {
            return super.g(view, i9, bundle);
        }
        n0.c cVar = (n0.c) this.f7644e.get(view);
        if (cVar != null) {
            if (cVar.g(view, i9, bundle)) {
                return true;
            }
        } else if (super.g(view, i9, bundle)) {
            return true;
        }
        l7.a aVar = recyclerView2.getLayoutManager().f7749b.f1058k;
        return false;
    }

    @Override // n0.c
    public final void h(View view, int i9) {
        n0.c cVar = (n0.c) this.f7644e.get(view);
        if (cVar != null) {
            cVar.h(view, i9);
        } else {
            super.h(view, i9);
        }
    }

    @Override // n0.c
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        n0.c cVar = (n0.c) this.f7644e.get(view);
        if (cVar != null) {
            cVar.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
