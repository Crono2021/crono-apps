package n;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t3 implements m.z {

    /* renamed from: i, reason: collision with root package name */
    public m.m f7057i;

    /* renamed from: j, reason: collision with root package name */
    public m.o f7058j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Toolbar f7059k;

    public t3(Toolbar toolbar) {
        this.f7059k = toolbar;
    }

    @Override // m.z
    public final void d() {
        if (this.f7058j != null) {
            m.m mVar = this.f7057i;
            if (mVar != null) {
                int size = mVar.f6439n.size();
                for (int i9 = 0; i9 < size; i9++) {
                    if (this.f7057i.getItem(i9) == this.f7058j) {
                        return;
                    }
                }
            }
            k(this.f7058j);
        }
    }

    @Override // m.z
    public final boolean f(m.o oVar) {
        Toolbar toolbar = this.f7059k;
        toolbar.c();
        ViewParent parent = toolbar.f506p.getParent();
        if (parent != toolbar) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(toolbar.f506p);
            }
            toolbar.addView(toolbar.f506p);
        }
        View actionView = oVar.getActionView();
        toolbar.f507q = actionView;
        this.f7058j = oVar;
        ViewParent parent2 = actionView.getParent();
        if (parent2 != toolbar) {
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView(toolbar.f507q);
            }
            u3 h = Toolbar.h();
            h.f7061a = (toolbar.f512v & 112) | 8388611;
            h.f7062b = 2;
            toolbar.f507q.setLayoutParams(h);
            toolbar.addView(toolbar.f507q);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((u3) childAt.getLayoutParams()).f7062b != 2 && childAt != toolbar.f499i) {
                toolbar.removeViewAt(childCount);
                toolbar.M.add(childAt);
            }
        }
        toolbar.requestLayout();
        oVar.K = true;
        oVar.f6468v.p(false);
        KeyEvent.Callback callback = toolbar.f507q;
        if (callback instanceof l.b) {
            ((l.b) callback).onActionViewExpanded();
        }
        toolbar.u();
        return true;
    }

    @Override // m.z
    public final void g(Context context, m.m mVar) {
        m.o oVar;
        m.m mVar2 = this.f7057i;
        if (mVar2 != null && (oVar = this.f7058j) != null) {
            mVar2.d(oVar);
        }
        this.f7057i = mVar;
    }

    @Override // m.z
    public final boolean h() {
        return false;
    }

    @Override // m.z
    public final boolean i(m.f0 f0Var) {
        return false;
    }

    @Override // m.z
    public final boolean k(m.o oVar) {
        Toolbar toolbar = this.f7059k;
        KeyEvent.Callback callback = toolbar.f507q;
        if (callback instanceof l.b) {
            ((l.b) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.f507q);
        toolbar.removeView(toolbar.f506p);
        toolbar.f507q = null;
        ArrayList arrayList = toolbar.M;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f7058j = null;
        toolbar.requestLayout();
        oVar.K = false;
        oVar.f6468v.p(false);
        toolbar.u();
        return true;
    }

    @Override // m.z
    public final void a(m.m mVar, boolean z8) {
    }
}
