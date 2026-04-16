package n;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements m.z {
    public f A;
    public f B;
    public h C;
    public g D;

    /* renamed from: i, reason: collision with root package name */
    public final Context f6904i;

    /* renamed from: j, reason: collision with root package name */
    public Context f6905j;

    /* renamed from: k, reason: collision with root package name */
    public m.m f6906k;

    /* renamed from: l, reason: collision with root package name */
    public final LayoutInflater f6907l;

    /* renamed from: m, reason: collision with root package name */
    public m.y f6908m;

    /* renamed from: p, reason: collision with root package name */
    public m.b0 f6911p;

    /* renamed from: q, reason: collision with root package name */
    public i f6912q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f6913r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6914s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6915t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f6916u;

    /* renamed from: v, reason: collision with root package name */
    public int f6917v;

    /* renamed from: w, reason: collision with root package name */
    public int f6918w;

    /* renamed from: x, reason: collision with root package name */
    public int f6919x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f6920y;

    /* renamed from: n, reason: collision with root package name */
    public final int f6909n = 2131558403;

    /* renamed from: o, reason: collision with root package name */
    public final int f6910o = 2131558402;

    /* renamed from: z, reason: collision with root package name */
    public final SparseBooleanArray f6921z = new SparseBooleanArray();
    public final i7.x E = new i7.x(this, 5);

    public j(Context context) {
        this.f6904i = context;
        this.f6907l = LayoutInflater.from(context);
    }

    @Override // m.z
    public final void a(m.m mVar, boolean z8) {
        c();
        f fVar = this.B;
        if (fVar != null && fVar.b()) {
            fVar.f6491i.dismiss();
        }
        m.y yVar = this.f6908m;
        if (yVar != null) {
            yVar.a(mVar, z8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [m.a0] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final View b(m.o oVar, View view, ViewGroup viewGroup) {
        View actionView = oVar.getActionView();
        if (actionView == null || oVar.e()) {
            ActionMenuItemView actionMenuItemView = view instanceof m.a0 ? (m.a0) view : (m.a0) this.f6907l.inflate(this.f6910o, viewGroup, false);
            actionMenuItemView.a(oVar);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.f6911p);
            if (this.D == null) {
                this.D = new g(this);
            }
            actionMenuItemView2.setPopupCallback(this.D);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(oVar.K ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof l)) {
            actionView.setLayoutParams(ActionMenuView.k(layoutParams));
        }
        return actionView;
    }

    public final boolean c() {
        Object obj;
        h hVar = this.C;
        if (hVar != null && (obj = this.f6911p) != null) {
            ((View) obj).removeCallbacks(hVar);
            this.C = null;
            return true;
        }
        f fVar = this.A;
        if (fVar == null) {
            return false;
        }
        if (fVar.b()) {
            fVar.f6491i.dismiss();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m.z
    public final void d() {
        int i9;
        ViewGroup viewGroup = (ViewGroup) this.f6911p;
        ArrayList arrayList = null;
        boolean z8 = false;
        if (viewGroup != null) {
            m.m mVar = this.f6906k;
            if (mVar != null) {
                mVar.i();
                ArrayList l4 = this.f6906k.l();
                int size = l4.size();
                i9 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    m.o oVar = (m.o) l4.get(i10);
                    if ((oVar.F & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i9);
                        m.o itemData = childAt instanceof m.a0 ? ((m.a0) childAt).getItemData() : null;
                        View b9 = b(oVar, childAt, viewGroup);
                        if (oVar != itemData) {
                            b9.setPressed(false);
                            b9.jumpDrawablesToCurrentState();
                        }
                        if (b9 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) b9.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(b9);
                            }
                            ((ViewGroup) this.f6911p).addView(b9, i9);
                        }
                        i9++;
                    }
                }
            } else {
                i9 = 0;
            }
            while (i9 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i9) == this.f6912q) {
                    i9++;
                } else {
                    viewGroup.removeViewAt(i9);
                }
            }
        }
        ((View) this.f6911p).requestLayout();
        m.m mVar2 = this.f6906k;
        if (mVar2 != null) {
            mVar2.i();
            ArrayList arrayList2 = mVar2.f6442q;
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                m.p pVar = ((m.o) arrayList2.get(i11)).I;
            }
        }
        m.m mVar3 = this.f6906k;
        if (mVar3 != null) {
            mVar3.i();
            arrayList = mVar3.f6443r;
        }
        if (this.f6915t && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z8 = !((m.o) arrayList.get(0)).K;
            } else if (size3 > 0) {
                z8 = true;
            }
        }
        i iVar = this.f6912q;
        if (z8) {
            if (iVar == null) {
                this.f6912q = new i(this, this.f6904i);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f6912q.getParent();
            if (viewGroup3 != this.f6911p) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f6912q);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f6911p;
                i iVar2 = this.f6912q;
                actionMenuView.getClass();
                l j5 = ActionMenuView.j();
                j5.f6942a = true;
                actionMenuView.addView(iVar2, j5);
            }
        } else if (iVar != null) {
            Object parent = iVar.getParent();
            Object obj = this.f6911p;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.f6912q);
            }
        }
        ((ActionMenuView) this.f6911p).setOverflowReserved(this.f6915t);
    }

    public final boolean e() {
        f fVar = this.A;
        return fVar != null && fVar.b();
    }

    @Override // m.z
    public final boolean f(m.o oVar) {
        return false;
    }

    @Override // m.z
    public final void g(Context context, m.m mVar) {
        this.f6905j = context;
        LayoutInflater.from(context);
        this.f6906k = mVar;
        Resources resources = context.getResources();
        if (!this.f6916u) {
            this.f6915t = true;
        }
        int i9 = 2;
        this.f6917v = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i10 > 600 || ((i10 > 960 && i11 > 720) || (i10 > 720 && i11 > 960))) {
            i9 = 5;
        } else if (i10 >= 500 || ((i10 > 640 && i11 > 480) || (i10 > 480 && i11 > 640))) {
            i9 = 4;
        } else if (i10 >= 360) {
            i9 = 3;
        }
        this.f6919x = i9;
        int i12 = this.f6917v;
        if (this.f6915t) {
            if (this.f6912q == null) {
                i iVar = new i(this, this.f6904i);
                this.f6912q = iVar;
                if (this.f6914s) {
                    iVar.setImageDrawable(this.f6913r);
                    this.f6913r = null;
                    this.f6914s = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f6912q.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i12 -= this.f6912q.getMeasuredWidth();
        } else {
            this.f6912q = null;
        }
        this.f6918w = i12;
        float f9 = resources.getDisplayMetrics().density;
    }

    @Override // m.z
    public final boolean h() {
        ArrayList arrayList;
        int i9;
        int i10;
        boolean z8;
        j jVar = this;
        m.m mVar = jVar.f6906k;
        if (mVar != null) {
            arrayList = mVar.l();
            i9 = arrayList.size();
        } else {
            arrayList = null;
            i9 = 0;
        }
        int i11 = jVar.f6919x;
        int i12 = jVar.f6918w;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) jVar.f6911p;
        int i13 = 0;
        boolean z9 = false;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i10 = 2;
            z8 = true;
            if (i13 >= i9) {
                break;
            }
            m.o oVar = (m.o) arrayList.get(i13);
            int i16 = oVar.G;
            if ((i16 & 2) == 2) {
                i14++;
            } else if ((i16 & 1) == 1) {
                i15++;
            } else {
                z9 = true;
            }
            if (jVar.f6920y && oVar.K) {
                i11 = 0;
            }
            i13++;
        }
        if (jVar.f6915t && (z9 || i15 + i14 > i11)) {
            i11--;
        }
        int i17 = i11 - i14;
        SparseBooleanArray sparseBooleanArray = jVar.f6921z;
        sparseBooleanArray.clear();
        int i18 = 0;
        int i19 = 0;
        while (i18 < i9) {
            m.o oVar2 = (m.o) arrayList.get(i18);
            int i20 = oVar2.G;
            boolean z10 = (i20 & 2) == i10;
            int i21 = oVar2.f6456j;
            if (z10) {
                View b9 = jVar.b(oVar2, null, viewGroup);
                b9.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = b9.getMeasuredWidth();
                i12 -= measuredWidth;
                if (i19 == 0) {
                    i19 = measuredWidth;
                }
                if (i21 != 0) {
                    sparseBooleanArray.put(i21, z8);
                }
                oVar2.f(z8);
            } else if ((i20 & 1) == z8) {
                boolean z11 = sparseBooleanArray.get(i21);
                boolean z12 = (i17 > 0 || z11) && i12 > 0;
                if (z12) {
                    View b10 = jVar.b(oVar2, null, viewGroup);
                    b10.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = b10.getMeasuredWidth();
                    i12 -= measuredWidth2;
                    if (i19 == 0) {
                        i19 = measuredWidth2;
                    }
                    z12 &= i12 + i19 > 0;
                }
                if (z12 && i21 != 0) {
                    sparseBooleanArray.put(i21, true);
                } else if (z11) {
                    sparseBooleanArray.put(i21, false);
                    for (int i22 = 0; i22 < i18; i22++) {
                        m.o oVar3 = (m.o) arrayList.get(i22);
                        if (oVar3.f6456j == i21) {
                            if ((oVar3.F & 32) == 32) {
                                i17++;
                            }
                            oVar3.f(false);
                        }
                    }
                }
                if (z12) {
                    i17--;
                }
                oVar2.f(z12);
            } else {
                oVar2.f(false);
                i18++;
                i10 = 2;
                jVar = this;
                z8 = true;
            }
            i18++;
            i10 = 2;
            jVar = this;
            z8 = true;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m.z
    public final boolean i(m.f0 f0Var) {
        boolean z8;
        if (f0Var.hasVisibleItems()) {
            m.f0 f0Var2 = f0Var;
            while (true) {
                m.m mVar = f0Var2.H;
                if (mVar == this.f6906k) {
                    break;
                }
                f0Var2 = (m.f0) mVar;
            }
            m.o oVar = f0Var2.I;
            ViewGroup viewGroup = (ViewGroup) this.f6911p;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i9 = 0;
                while (true) {
                    if (i9 >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i9);
                    if ((childAt instanceof m.a0) && ((m.a0) childAt).getItemData() == oVar) {
                        view = childAt;
                        break;
                    }
                    i9++;
                }
            }
            if (view != null) {
                f0Var.I.getClass();
                int size = f0Var.f6439n.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        z8 = false;
                        break;
                    }
                    MenuItem item = f0Var.getItem(i10);
                    if (item.isVisible() && item.getIcon() != null) {
                        z8 = true;
                        break;
                    }
                    i10++;
                }
                f fVar = new f(this, this.f6905j, f0Var, view);
                this.B = fVar;
                fVar.f6490g = z8;
                m.u uVar = fVar.f6491i;
                if (uVar != null) {
                    uVar.o(z8);
                }
                f fVar2 = this.B;
                if (!fVar2.b()) {
                    if (fVar2.f6488e == null) {
                        m7.c.p("MenuPopupHelper cannot be used without an anchor");
                        return false;
                    }
                    fVar2.d(0, 0, false, false);
                }
                m.y yVar = this.f6908m;
                if (yVar != null) {
                    yVar.l(f0Var);
                }
                return true;
            }
        }
        return false;
    }

    @Override // m.z
    public final void j(m.y yVar) {
        throw null;
    }

    @Override // m.z
    public final boolean k(m.o oVar) {
        return false;
    }

    public final boolean l() {
        m.m mVar;
        if (!this.f6915t || e() || (mVar = this.f6906k) == null || this.f6911p == null || this.C != null) {
            return false;
        }
        mVar.i();
        if (mVar.f6443r.isEmpty()) {
            return false;
        }
        h hVar = new h(this, new f(this, this.f6905j, this.f6906k, this.f6912q));
        this.C = hVar;
        ((View) this.f6911p).post(hVar);
        return true;
    }
}
