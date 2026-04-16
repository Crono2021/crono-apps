package m;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.fragment.app.m0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n.m2;
import n.q2;
import n.x1;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends u implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public int A;
    public int B;
    public boolean D;
    public y E;
    public ViewTreeObserver F;
    public PopupWindow.OnDismissListener G;
    public boolean H;

    /* renamed from: j, reason: collision with root package name */
    public final Context f6403j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6404k;

    /* renamed from: l, reason: collision with root package name */
    public final int f6405l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f6406m;

    /* renamed from: n, reason: collision with root package name */
    public final Handler f6407n;

    /* renamed from: v, reason: collision with root package name */
    public View f6415v;

    /* renamed from: w, reason: collision with root package name */
    public View f6416w;

    /* renamed from: x, reason: collision with root package name */
    public int f6417x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f6418y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f6419z;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f6408o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f6409p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public final d f6410q = new d(this, 0);

    /* renamed from: r, reason: collision with root package name */
    public final m0 f6411r = new m0(this, 1);

    /* renamed from: s, reason: collision with root package name */
    public final i7.x f6412s = new i7.x(this, 2);

    /* renamed from: t, reason: collision with root package name */
    public int f6413t = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f6414u = 0;
    public boolean C = false;

    public g(Context context, View view, int i9, boolean z8) {
        this.f6403j = context;
        this.f6415v = view;
        this.f6405l = i9;
        this.f6406m = z8;
        WeakHashMap weakHashMap = t0.f7209a;
        this.f6417x = n0.d0.d(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f6404k = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(2131165207));
        this.f6407n = new Handler();
    }

    @Override // m.z
    public final void a(m mVar, boolean z8) {
        ArrayList arrayList = this.f6409p;
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                i9 = -1;
                break;
            } else if (mVar == ((f) arrayList.get(i9)).f6401b) {
                break;
            } else {
                i9++;
            }
        }
        if (i9 < 0) {
            return;
        }
        int i10 = i9 + 1;
        if (i10 < arrayList.size()) {
            ((f) arrayList.get(i10)).f6401b.c(false);
        }
        f fVar = (f) arrayList.remove(i9);
        m mVar2 = fVar.f6401b;
        q2 q2Var = fVar.f6400a;
        n.a0 a0Var = q2Var.H;
        mVar2.r(this);
        if (this.H) {
            if (Build.VERSION.SDK_INT >= 23) {
                m2.b(a0Var, null);
            }
            a0Var.setAnimationStyle(0);
        }
        q2Var.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.f6417x = ((f) arrayList.get(size2 - 1)).f6402c;
        } else {
            View view = this.f6415v;
            WeakHashMap weakHashMap = t0.f7209a;
            this.f6417x = n0.d0.d(view) == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z8) {
                ((f) arrayList.get(0)).f6401b.c(false);
                return;
            }
            return;
        }
        dismiss();
        y yVar = this.E;
        if (yVar != null) {
            yVar.a(mVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.F;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.F.removeGlobalOnLayoutListener(this.f6410q);
            }
            this.F = null;
        }
        this.f6416w.removeOnAttachStateChangeListener(this.f6411r);
        this.G.onDismiss();
    }

    @Override // m.d0
    public final boolean b() {
        ArrayList arrayList = this.f6409p;
        return arrayList.size() > 0 && ((f) arrayList.get(0)).f6400a.H.isShowing();
    }

    @Override // m.d0
    public final void c() {
        if (b()) {
            return;
        }
        ArrayList arrayList = this.f6408o;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            u((m) obj);
        }
        arrayList.clear();
        View view = this.f6415v;
        this.f6416w = view;
        if (view != null) {
            boolean z8 = this.F == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.F = viewTreeObserver;
            if (z8) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f6410q);
            }
            this.f6416w.addOnAttachStateChangeListener(this.f6411r);
        }
    }

    @Override // m.z
    public final void d() {
        ArrayList arrayList = this.f6409p;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            ListAdapter adapter = ((f) obj).f6400a.f6926k.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((j) adapter).notifyDataSetChanged();
        }
    }

    @Override // m.d0
    public final void dismiss() {
        ArrayList arrayList = this.f6409p;
        int size = arrayList.size();
        if (size > 0) {
            f[] fVarArr = (f[]) arrayList.toArray(new f[size]);
            for (int i9 = size - 1; i9 >= 0; i9--) {
                f fVar = fVarArr[i9];
                if (fVar.f6400a.H.isShowing()) {
                    fVar.f6400a.dismiss();
                }
            }
        }
    }

    @Override // m.d0
    public final x1 e() {
        ArrayList arrayList = this.f6409p;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((f) arrayList.get(arrayList.size() - 1)).f6400a.f6926k;
    }

    @Override // m.z
    public final boolean h() {
        return false;
    }

    @Override // m.z
    public final boolean i(f0 f0Var) {
        ArrayList arrayList = this.f6409p;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            f fVar = (f) obj;
            if (f0Var == fVar.f6401b) {
                fVar.f6400a.f6926k.requestFocus();
                return true;
            }
        }
        if (!f0Var.hasVisibleItems()) {
            return false;
        }
        l(f0Var);
        y yVar = this.E;
        if (yVar != null) {
            yVar.l(f0Var);
        }
        return true;
    }

    @Override // m.z
    public final void j(y yVar) {
        this.E = yVar;
    }

    @Override // m.u
    public final void l(m mVar) {
        mVar.b(this, this.f6403j);
        if (b()) {
            u(mVar);
        } else {
            this.f6408o.add(mVar);
        }
    }

    @Override // m.u
    public final void n(View view) {
        if (this.f6415v != view) {
            this.f6415v = view;
            int i9 = this.f6413t;
            WeakHashMap weakHashMap = t0.f7209a;
            this.f6414u = Gravity.getAbsoluteGravity(i9, n0.d0.d(view));
        }
    }

    @Override // m.u
    public final void o(boolean z8) {
        this.C = z8;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        f fVar;
        ArrayList arrayList = this.f6409p;
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                fVar = null;
                break;
            }
            fVar = (f) arrayList.get(i9);
            if (!fVar.f6400a.H.isShowing()) {
                break;
            } else {
                i9++;
            }
        }
        if (fVar != null) {
            fVar.f6401b.c(false);
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
        if (this.f6413t != i9) {
            this.f6413t = i9;
            View view = this.f6415v;
            WeakHashMap weakHashMap = t0.f7209a;
            this.f6414u = Gravity.getAbsoluteGravity(i9, n0.d0.d(view));
        }
    }

    @Override // m.u
    public final void q(int i9) {
        this.f6418y = true;
        this.A = i9;
    }

    @Override // m.u
    public final void r(PopupWindow.OnDismissListener onDismissListener) {
        this.G = onDismissListener;
    }

    @Override // m.u
    public final void s(boolean z8) {
        this.D = z8;
    }

    @Override // m.u
    public final void t(int i9) {
        this.f6419z = true;
        this.B = i9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0167, code lost:
    
        if (((r10.getWidth() + r12[0]) + r5) > r11.right) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0169, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016b, code lost:
    
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0172, code lost:
    
        if ((r12[0] - r5) < 0) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(m.m r18) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.g.u(m.m):void");
    }
}
