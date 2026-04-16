package androidx.fragment.app;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class s implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.s, androidx.lifecycle.m0, androidx.lifecycle.h, p3.d {
    public static final Object Y = new Object();
    public v A;
    public s C;
    public int D;
    public int E;
    public String F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean K;
    public ViewGroup L;
    public View M;
    public boolean N;
    public q P;
    public boolean Q;
    public boolean R;
    public androidx.lifecycle.u T;
    public p0 U;
    public com.bumptech.glide.manager.s W;
    public final ArrayList X;

    /* renamed from: j, reason: collision with root package name */
    public Bundle f843j;

    /* renamed from: k, reason: collision with root package name */
    public SparseArray f844k;

    /* renamed from: l, reason: collision with root package name */
    public Bundle f845l;

    /* renamed from: n, reason: collision with root package name */
    public Bundle f847n;

    /* renamed from: o, reason: collision with root package name */
    public s f848o;

    /* renamed from: q, reason: collision with root package name */
    public int f850q;

    /* renamed from: s, reason: collision with root package name */
    public boolean f852s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f853t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f854u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f855v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f856w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f857x;

    /* renamed from: y, reason: collision with root package name */
    public int f858y;

    /* renamed from: z, reason: collision with root package name */
    public h0 f859z;

    /* renamed from: i, reason: collision with root package name */
    public int f842i = -1;

    /* renamed from: m, reason: collision with root package name */
    public String f846m = UUID.randomUUID().toString();

    /* renamed from: p, reason: collision with root package name */
    public String f849p = null;

    /* renamed from: r, reason: collision with root package name */
    public Boolean f851r = null;
    public h0 B = new h0();
    public final boolean J = true;
    public boolean O = true;
    public androidx.lifecycle.m S = androidx.lifecycle.m.f932m;
    public final androidx.lifecycle.y V = new androidx.lifecycle.y();

    public s() {
        new AtomicInteger();
        this.X = new ArrayList();
        this.T = new androidx.lifecycle.u(this);
        this.W = new com.bumptech.glide.manager.s(this);
    }

    @Override // p3.d
    public final n.s a() {
        return (n.s) this.W.f1859l;
    }

    public android.support.v4.media.session.b b() {
        return new p(this);
    }

    @Override // androidx.lifecycle.h
    public final b1.b c() {
        return b1.a.f1131j;
    }

    public final q d() {
        if (this.P == null) {
            q qVar = new q();
            Object obj = Y;
            qVar.f833g = obj;
            qVar.h = obj;
            qVar.f834i = obj;
            qVar.f835j = 1.0f;
            qVar.f836k = null;
            this.P = qVar;
        }
        return this.P;
    }

    public final h0 e() {
        if (this.A != null) {
            return this.B;
        }
        a.f(this, " has not been attached yet.", "Fragment ");
        return null;
    }

    @Override // androidx.lifecycle.m0
    public final androidx.lifecycle.l0 f() {
        if (this.f859z == null) {
            m7.c.p("Can't access ViewModels from detached fragment");
            return null;
        }
        if (i() == 1) {
            m7.c.p("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
            return null;
        }
        HashMap hashMap = this.f859z.F.f773e;
        androidx.lifecycle.l0 l0Var = (androidx.lifecycle.l0) hashMap.get(this.f846m);
        if (l0Var != null) {
            return l0Var;
        }
        androidx.lifecycle.l0 l0Var2 = new androidx.lifecycle.l0();
        hashMap.put(this.f846m, l0Var2);
        return l0Var2;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u g() {
        return this.T;
    }

    public final Context h() {
        v vVar = this.A;
        if (vVar == null) {
            return null;
        }
        return vVar.f872p;
    }

    public final int i() {
        androidx.lifecycle.m mVar = this.S;
        return (mVar == androidx.lifecycle.m.f929j || this.C == null) ? mVar.ordinal() : Math.min(mVar.ordinal(), this.C.i());
    }

    public final h0 j() {
        h0 h0Var = this.f859z;
        if (h0Var != null) {
            return h0Var;
        }
        a.f(this, " not associated with a fragment manager.", "Fragment ");
        return null;
    }

    public final void k(int i9, int i10, Intent intent) {
        if (h0.D(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i9 + " resultCode: " + i10 + " data: " + intent);
        }
    }

    public void l(Context context) {
        this.K = true;
        v vVar = this.A;
        if ((vVar == null ? null : vVar.f871o) != null) {
            this.K = true;
        }
    }

    public void m(Bundle bundle) {
        Parcelable parcelable;
        this.K = true;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.B.N(parcelable);
            h0 h0Var = this.B;
            h0Var.f759y = false;
            h0Var.f760z = false;
            h0Var.F.h = false;
            h0Var.s(1);
        }
        h0 h0Var2 = this.B;
        if (h0Var2.f747m >= 1) {
            return;
        }
        h0Var2.f759y = false;
        h0Var2.f760z = false;
        h0Var2.F.h = false;
        h0Var2.s(1);
    }

    public View n(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void o() {
        this.K = true;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.K = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        v vVar = this.A;
        g.l lVar = vVar == null ? null : vVar.f871o;
        if (lVar != null) {
            lVar.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        } else {
            a.f(this, " not attached to an activity.", "Fragment ");
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.K = true;
    }

    public void p() {
        this.K = true;
    }

    public LayoutInflater q(Bundle bundle) {
        v vVar = this.A;
        if (vVar == null) {
            m7.c.p("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
            return null;
        }
        g.l lVar = vVar.f875s;
        LayoutInflater cloneInContext = lVar.getLayoutInflater().cloneInContext(lVar);
        cloneInContext.setFactory2(this.B.f741f);
        return cloneInContext;
    }

    public abstract void r(Bundle bundle);

    public void s() {
        this.K = true;
    }

    public void t() {
        this.K = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.f846m);
        if (this.D != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.D));
        }
        if (this.F != null) {
            sb.append(" tag=");
            sb.append(this.F);
        }
        sb.append(")");
        return sb.toString();
    }

    public void u(Bundle bundle) {
        this.K = true;
    }

    public void v(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.B.I();
        this.f857x = true;
        this.U = new p0(f());
        View n4 = n(layoutInflater, viewGroup);
        this.M = n4;
        p0 p0Var = this.U;
        if (n4 == null) {
            if (p0Var.f825j == null) {
                this.U = null;
                return;
            } else {
                m7.c.p("Called getViewLifecycleOwner() but onCreateView() returned null");
                return;
            }
        }
        p0Var.d();
        View view = this.M;
        p0 p0Var2 = this.U;
        view.getClass();
        view.setTag(2131362517, p0Var2);
        View view2 = this.M;
        p0 p0Var3 = this.U;
        view2.getClass();
        view2.setTag(2131362520, p0Var3);
        View view3 = this.M;
        p0 p0Var4 = this.U;
        view3.getClass();
        view3.setTag(2131362519, p0Var4);
        this.V.e(this.U);
    }

    public final Context w() {
        Context h = h();
        if (h != null) {
            return h;
        }
        a.f(this, " not attached to a context.", "Fragment ");
        return null;
    }

    public final View x() {
        View view = this.M;
        if (view != null) {
            return view;
        }
        a.f(this, " did not return a View from onCreateView() or this was called before onCreateView().", "Fragment ");
        return null;
    }

    public final void y(int i9, int i10, int i11, int i12) {
        if (this.P == null && i9 == 0 && i10 == 0 && i11 == 0 && i12 == 0) {
            return;
        }
        d().f828b = i9;
        d().f829c = i10;
        d().f830d = i11;
        d().f831e = i12;
    }

    public final void z(Bundle bundle) {
        h0 h0Var = this.f859z;
        if (h0Var == null || !(h0Var.f759y || h0Var.f760z)) {
            this.f847n = bundle;
        } else {
            m7.c.p("Fragment already added and state has been saved");
        }
    }
}
