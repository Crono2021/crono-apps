package m;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.m0;
import java.util.WeakHashMap;
import n.q2;
import n.x1;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 extends u implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public boolean B;

    /* renamed from: j, reason: collision with root package name */
    public final Context f6383j;

    /* renamed from: k, reason: collision with root package name */
    public final m f6384k;

    /* renamed from: l, reason: collision with root package name */
    public final j f6385l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f6386m;

    /* renamed from: n, reason: collision with root package name */
    public final int f6387n;

    /* renamed from: o, reason: collision with root package name */
    public final int f6388o;

    /* renamed from: p, reason: collision with root package name */
    public final q2 f6389p;

    /* renamed from: s, reason: collision with root package name */
    public PopupWindow.OnDismissListener f6392s;

    /* renamed from: t, reason: collision with root package name */
    public View f6393t;

    /* renamed from: u, reason: collision with root package name */
    public View f6394u;

    /* renamed from: v, reason: collision with root package name */
    public y f6395v;

    /* renamed from: w, reason: collision with root package name */
    public ViewTreeObserver f6396w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6397x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f6398y;

    /* renamed from: z, reason: collision with root package name */
    public int f6399z;

    /* renamed from: q, reason: collision with root package name */
    public final d f6390q = new d(this, 1);

    /* renamed from: r, reason: collision with root package name */
    public final m0 f6391r = new m0(this, 2);
    public int A = 0;

    public e0(Context context, m mVar, View view, int i9, boolean z8) {
        this.f6383j = context;
        this.f6384k = mVar;
        this.f6386m = z8;
        this.f6385l = new j(mVar, LayoutInflater.from(context), z8, 2131558419);
        this.f6388o = i9;
        Resources resources = context.getResources();
        this.f6387n = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(2131165207));
        this.f6393t = view;
        this.f6389p = new q2(context, null, i9, 0);
        mVar.b(this, context);
    }

    @Override // m.z
    public final void a(m mVar, boolean z8) {
        if (mVar != this.f6384k) {
            return;
        }
        dismiss();
        y yVar = this.f6395v;
        if (yVar != null) {
            yVar.a(mVar, z8);
        }
    }

    @Override // m.d0
    public final boolean b() {
        return !this.f6397x && this.f6389p.H.isShowing();
    }

    @Override // m.d0
    public final void c() {
        View view;
        if (b()) {
            return;
        }
        if (this.f6397x || (view = this.f6393t) == null) {
            m7.c.p("StandardMenuPopup cannot be used without an anchor");
            return;
        }
        this.f6394u = view;
        q2 q2Var = this.f6389p;
        n.a0 a0Var = q2Var.H;
        n.a0 a0Var2 = q2Var.H;
        a0Var.setOnDismissListener(this);
        q2Var.f6939x = this;
        q2Var.G = true;
        a0Var2.setFocusable(true);
        View view2 = this.f6394u;
        boolean z8 = this.f6396w == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f6396w = viewTreeObserver;
        if (z8) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f6390q);
        }
        view2.addOnAttachStateChangeListener(this.f6391r);
        q2Var.f6938w = view2;
        q2Var.f6935t = this.A;
        boolean z9 = this.f6398y;
        Context context = this.f6383j;
        j jVar = this.f6385l;
        if (!z9) {
            this.f6399z = u.m(jVar, context, this.f6387n);
            this.f6398y = true;
        }
        q2Var.r(this.f6399z);
        a0Var2.setInputMethodMode(2);
        Rect rect = this.f6482i;
        q2Var.F = rect != null ? new Rect(rect) : null;
        q2Var.c();
        x1 x1Var = q2Var.f6926k;
        x1Var.setOnKeyListener(this);
        if (this.B) {
            m mVar = this.f6384k;
            if (mVar.f6446u != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(2131558418, (ViewGroup) x1Var, false);
                TextView textView = (TextView) frameLayout.findViewById(R.id.title);
                if (textView != null) {
                    textView.setText(mVar.f6446u);
                }
                frameLayout.setEnabled(false);
                x1Var.addHeaderView(frameLayout, null, false);
            }
        }
        q2Var.o(jVar);
        q2Var.c();
    }

    @Override // m.z
    public final void d() {
        this.f6398y = false;
        j jVar = this.f6385l;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    @Override // m.d0
    public final void dismiss() {
        if (b()) {
            this.f6389p.dismiss();
        }
    }

    @Override // m.d0
    public final x1 e() {
        return this.f6389p.f6926k;
    }

    @Override // m.z
    public final boolean h() {
        return false;
    }

    @Override // m.z
    public final boolean i(f0 f0Var) {
        boolean z8;
        if (f0Var.hasVisibleItems()) {
            x xVar = new x(this.f6383j, f0Var, this.f6394u, this.f6386m, this.f6388o, 0);
            y yVar = this.f6395v;
            xVar.h = yVar;
            u uVar = xVar.f6491i;
            if (uVar != null) {
                uVar.j(yVar);
            }
            int size = f0Var.f6439n.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    z8 = false;
                    break;
                }
                MenuItem item = f0Var.getItem(i9);
                if (item.isVisible() && item.getIcon() != null) {
                    z8 = true;
                    break;
                }
                i9++;
            }
            xVar.f6490g = z8;
            u uVar2 = xVar.f6491i;
            if (uVar2 != null) {
                uVar2.o(z8);
            }
            xVar.f6492j = this.f6392s;
            this.f6392s = null;
            this.f6384k.c(false);
            q2 q2Var = this.f6389p;
            int i10 = q2Var.f6929n;
            int m9 = q2Var.m();
            int i11 = this.A;
            View view = this.f6393t;
            WeakHashMap weakHashMap = t0.f7209a;
            if ((Gravity.getAbsoluteGravity(i11, n0.d0.d(view)) & 7) == 5) {
                i10 += this.f6393t.getWidth();
            }
            if (!xVar.b()) {
                if (xVar.f6488e != null) {
                    xVar.d(i10, m9, true, true);
                }
            }
            y yVar2 = this.f6395v;
            if (yVar2 != null) {
                yVar2.l(f0Var);
            }
            return true;
        }
        return false;
    }

    @Override // m.z
    public final void j(y yVar) {
        this.f6395v = yVar;
    }

    @Override // m.u
    public final void n(View view) {
        this.f6393t = view;
    }

    @Override // m.u
    public final void o(boolean z8) {
        this.f6385l.f6430k = z8;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f6397x = true;
        this.f6384k.c(true);
        ViewTreeObserver viewTreeObserver = this.f6396w;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f6396w = this.f6394u.getViewTreeObserver();
            }
            this.f6396w.removeGlobalOnLayoutListener(this.f6390q);
            this.f6396w = null;
        }
        this.f6394u.removeOnAttachStateChangeListener(this.f6391r);
        PopupWindow.OnDismissListener onDismissListener = this.f6392s;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i9, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i9 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // m.u
    public final void p(int i9) {
        this.A = i9;
    }

    @Override // m.u
    public final void q(int i9) {
        this.f6389p.f6929n = i9;
    }

    @Override // m.u
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.f6392s = onDismissListener;
    }

    @Override // m.u
    public final void s(boolean z8) {
        this.B = z8;
    }

    @Override // m.u
    public final void t(int i9) {
        this.f6389p.i(i9);
    }

    @Override // m.u
    public final void l(m mVar) {
    }
}
