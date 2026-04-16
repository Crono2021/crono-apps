package n;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q2 extends k2 implements l2 {
    public static final Method M;
    public i7.x L;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                M = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // n.l2
    public final void f(m.m mVar, m.o oVar) {
        i7.x xVar = this.L;
        if (xVar != null) {
            xVar.f(mVar, oVar);
        }
    }

    @Override // n.k2
    public final x1 p(Context context, boolean z8) {
        p2 p2Var = new p2(context, z8);
        p2Var.setHoverListener(this);
        return p2Var;
    }

    @Override // n.l2
    public final void q(m.m mVar, MenuItem menuItem) {
        i7.x xVar = this.L;
        if (xVar != null) {
            xVar.q(mVar, menuItem);
        }
    }
}
