package m;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import java.util.WeakHashMap;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6484a;

    /* renamed from: b, reason: collision with root package name */
    public final m f6485b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6486c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6487d;

    /* renamed from: e, reason: collision with root package name */
    public View f6488e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6490g;
    public y h;

    /* renamed from: i, reason: collision with root package name */
    public u f6491i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f6492j;

    /* renamed from: f, reason: collision with root package name */
    public int f6489f = 8388611;

    /* renamed from: k, reason: collision with root package name */
    public final v f6493k = new v(this);

    public x(Context context, m mVar, View view, boolean z8, int i9, int i10) {
        this.f6484a = context;
        this.f6485b = mVar;
        this.f6488e = view;
        this.f6486c = z8;
        this.f6487d = i9;
    }

    public final u a() {
        u e0Var;
        if (this.f6491i == null) {
            Context context = this.f6484a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            w.a(defaultDisplay, point);
            int min = Math.min(point.x, point.y);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131165206);
            Context context2 = this.f6484a;
            if (min >= dimensionPixelSize) {
                e0Var = new g(context2, this.f6488e, this.f6487d, this.f6486c);
            } else {
                e0Var = new e0(context2, this.f6485b, this.f6488e, this.f6487d, this.f6486c);
            }
            e0Var.l(this.f6485b);
            e0Var.r(this.f6493k);
            e0Var.n(this.f6488e);
            e0Var.j(this.h);
            e0Var.o(this.f6490g);
            e0Var.p(this.f6489f);
            this.f6491i = e0Var;
        }
        return this.f6491i;
    }

    public final boolean b() {
        u uVar = this.f6491i;
        return uVar != null && uVar.b();
    }

    public void c() {
        this.f6491i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f6492j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i9, int i10, boolean z8, boolean z9) {
        u a9 = a();
        a9.s(z9);
        if (z8) {
            int i11 = this.f6489f;
            View view = this.f6488e;
            WeakHashMap weakHashMap = t0.f7209a;
            if ((Gravity.getAbsoluteGravity(i11, n0.d0.d(view)) & 7) == 5) {
                i9 -= this.f6488e.getWidth();
            }
            a9.q(i9);
            a9.t(i10);
            int i12 = (int) ((this.f6484a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a9.f6482i = new Rect(i9 - i12, i10 - i12, i9 + i12, i10 + i12);
        }
        a9.c();
    }
}
