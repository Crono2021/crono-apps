package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.network.tvgramplayer.voip.VoIPController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.WeakHashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final a5.d f800a;

    /* renamed from: b, reason: collision with root package name */
    public final g f801b;

    /* renamed from: c, reason: collision with root package name */
    public final s f802c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f803d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f804e = -1;

    public n0(a5.d dVar, g gVar, ClassLoader classLoader, b0 b0Var, l0 l0Var) {
        this.f800a = dVar;
        this.f801b = gVar;
        s a9 = b0Var.a(l0Var.f782i);
        this.f802c = a9;
        Bundle bundle = l0Var.f791r;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a9.z(bundle);
        a9.f846m = l0Var.f783j;
        a9.f854u = l0Var.f784k;
        a9.f856w = true;
        a9.D = l0Var.f785l;
        a9.E = l0Var.f786m;
        a9.F = l0Var.f787n;
        a9.I = l0Var.f788o;
        a9.f853t = l0Var.f789p;
        a9.H = l0Var.f790q;
        a9.G = l0Var.f792s;
        a9.S = androidx.lifecycle.m.values()[l0Var.f793t];
        Bundle bundle2 = l0Var.f794u;
        if (bundle2 != null) {
            a9.f843j = bundle2;
        } else {
            a9.f843j = new Bundle();
        }
        if (h0.D(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a9);
        }
    }

    public final void a() {
        boolean D = h0.D(3);
        s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + sVar);
        }
        Bundle bundle = sVar.f843j;
        sVar.B.I();
        sVar.f842i = 3;
        sVar.K = true;
        if (h0.D(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + sVar);
        }
        View view = sVar.M;
        if (view != null) {
            Bundle bundle2 = sVar.f843j;
            SparseArray<Parcelable> sparseArray = sVar.f844k;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                sVar.f844k = null;
            }
            if (sVar.M != null) {
                sVar.U.f826k.e(sVar.f845l);
                sVar.f845l = null;
            }
            sVar.K = false;
            sVar.u(bundle2);
            if (!sVar.K) {
                a.e(sVar, " did not call through to super.onViewStateRestored()");
                return;
            } else if (sVar.M != null) {
                sVar.U.b(androidx.lifecycle.l.ON_CREATE);
            }
        }
        sVar.f843j = null;
        h0 h0Var = sVar.B;
        h0Var.f759y = false;
        h0Var.f760z = false;
        h0Var.F.h = false;
        h0Var.s(4);
        this.f800a.r0(false);
    }

    public final void b() {
        View view;
        View view2;
        ArrayList arrayList = (ArrayList) this.f801b.f728j;
        s sVar = this.f802c;
        ViewGroup viewGroup = sVar.L;
        int i9 = -1;
        if (viewGroup != null) {
            int indexOf = arrayList.indexOf(sVar);
            int i10 = indexOf - 1;
            while (true) {
                if (i10 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        s sVar2 = (s) arrayList.get(indexOf);
                        if (sVar2.L == viewGroup && (view = sVar2.M) != null) {
                            i9 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    s sVar3 = (s) arrayList.get(i10);
                    if (sVar3.L == viewGroup && (view2 = sVar3.M) != null) {
                        i9 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i10--;
                }
            }
        }
        sVar.L.addView(sVar.M, i9);
    }

    public final void c() {
        boolean D = h0.D(3);
        s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "moveto ATTACHED: " + sVar);
        }
        s sVar2 = sVar.f848o;
        g gVar = this.f801b;
        n0 n0Var = null;
        if (sVar2 != null) {
            n0 n0Var2 = (n0) ((HashMap) gVar.f729k).get(sVar2.f846m);
            if (n0Var2 == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(sVar);
                s sVar3 = sVar.f848o;
                sb.append(" declared target fragment ");
                sb.append(sVar3);
                sb.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb.toString());
            }
            sVar.f849p = sVar.f848o.f846m;
            sVar.f848o = null;
            n0Var = n0Var2;
        } else {
            String str = sVar.f849p;
            if (str != null && (n0Var = (n0) ((HashMap) gVar.f729k).get(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(sVar);
                sb2.append(" declared target fragment ");
                m7.c.p(androidx.activity.g.o(sb2, sVar.f849p, " that does not belong to this FragmentManager!"));
                return;
            }
        }
        if (n0Var != null) {
            n0Var.k();
        }
        h0 h0Var = sVar.f859z;
        sVar.A = h0Var.f748n;
        sVar.C = h0Var.f750p;
        a5.d dVar = this.f800a;
        dVar.x0(false);
        ArrayList arrayList = sVar.X;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw androidx.activity.g.l(it);
        }
        arrayList.clear();
        sVar.B.b(sVar.A, sVar.b(), sVar);
        sVar.f842i = 0;
        sVar.K = false;
        sVar.l(sVar.A.f872p);
        if (!sVar.K) {
            a.e(sVar, " did not call through to super.onAttach()");
            return;
        }
        Iterator it2 = sVar.f859z.f746l.iterator();
        while (it2.hasNext()) {
            ((k0) it2.next()).e();
        }
        h0 h0Var2 = sVar.B;
        h0Var2.f759y = false;
        h0Var2.f760z = false;
        h0Var2.F.h = false;
        h0Var2.s(0);
        dVar.s0(false);
    }

    public final int d() {
        s0 s0Var;
        s sVar = this.f802c;
        if (sVar.f859z == null) {
            return sVar.f842i;
        }
        int i9 = this.f804e;
        int ordinal = sVar.S.ordinal();
        int i10 = 0;
        if (ordinal == 1) {
            i9 = Math.min(i9, 0);
        } else if (ordinal == 2) {
            i9 = Math.min(i9, 1);
        } else if (ordinal == 3) {
            i9 = Math.min(i9, 5);
        } else if (ordinal != 4) {
            i9 = Math.min(i9, -1);
        }
        if (sVar.f854u) {
            boolean z8 = sVar.f855v;
            int i11 = this.f804e;
            if (z8) {
                i9 = Math.max(i11, 2);
                View view = sVar.M;
                if (view != null && view.getParent() == null) {
                    i9 = Math.min(i9, 2);
                }
            } else {
                i9 = i11 < 4 ? Math.min(i9, sVar.f842i) : Math.min(i9, 1);
            }
        }
        if (!sVar.f852s) {
            i9 = Math.min(i9, 1);
        }
        ViewGroup viewGroup = sVar.L;
        if (viewGroup != null) {
            k f9 = k.f(viewGroup, sVar.j().B());
            s0 d9 = f9.d(sVar);
            int i12 = d9 != null ? d9.f861b : 0;
            ArrayList arrayList = f9.f778c;
            int size = arrayList.size();
            while (true) {
                if (i10 >= size) {
                    s0Var = null;
                    break;
                }
                Object obj = arrayList.get(i10);
                i10++;
                s0Var = (s0) obj;
                if (s0Var.f862c.equals(sVar) && !s0Var.f865f) {
                    break;
                }
            }
            i10 = (s0Var == null || !(i12 == 0 || i12 == 1)) ? i12 : s0Var.f861b;
        }
        if (i10 == 2) {
            i9 = Math.min(i9, 6);
        } else if (i10 == 3) {
            i9 = Math.max(i9, 3);
        } else if (sVar.f853t) {
            i9 = sVar.f858y > 0 ? Math.min(i9, 1) : Math.min(i9, -1);
        }
        if (sVar.N && sVar.f842i < 5) {
            i9 = Math.min(i9, 4);
        }
        if (h0.D(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i9 + " for " + sVar);
        }
        return i9;
    }

    public final void e() {
        Parcelable parcelable;
        boolean D = h0.D(3);
        final s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "moveto CREATED: " + sVar);
        }
        boolean z8 = sVar.R;
        Bundle bundle = sVar.f843j;
        if (z8) {
            if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
                sVar.B.N(parcelable);
                h0 h0Var = sVar.B;
                h0Var.f759y = false;
                h0Var.f760z = false;
                h0Var.F.h = false;
                h0Var.s(1);
            }
            sVar.f842i = 1;
            return;
        }
        a5.d dVar = this.f800a;
        dVar.y0(false);
        Bundle bundle2 = sVar.f843j;
        sVar.B.I();
        sVar.f842i = 1;
        sVar.K = false;
        sVar.T.a(new androidx.lifecycle.q() { // from class: androidx.fragment.app.Fragment$5
            @Override // androidx.lifecycle.q
            public final void a(androidx.lifecycle.s sVar2, androidx.lifecycle.l lVar) {
                View view;
                if (lVar != androidx.lifecycle.l.ON_STOP || (view = s.this.M) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        sVar.W.e(bundle2);
        sVar.m(bundle2);
        sVar.R = true;
        if (!sVar.K) {
            a.e(sVar, " did not call through to super.onCreate()");
        } else {
            sVar.T.d(androidx.lifecycle.l.ON_CREATE);
            dVar.t0(false);
        }
    }

    public final void f() {
        String str;
        s sVar = this.f802c;
        if (sVar.f854u) {
            return;
        }
        if (h0.D(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + sVar);
        }
        LayoutInflater q4 = sVar.q(sVar.f843j);
        ViewGroup viewGroup = sVar.L;
        if (viewGroup == null) {
            int i9 = sVar.E;
            if (i9 == 0) {
                viewGroup = null;
            } else {
                if (i9 == -1) {
                    a.m(sVar, " for a container view with no id", "Cannot create fragment ");
                    return;
                }
                viewGroup = (ViewGroup) sVar.f859z.f749o.e0(i9);
                if (viewGroup == null && !sVar.f856w) {
                    try {
                        str = sVar.w().getResources().getResourceName(sVar.E);
                    } catch (Resources.NotFoundException unused) {
                        str = IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(sVar.E) + " (" + str + ") for fragment " + sVar);
                }
            }
        }
        sVar.L = viewGroup;
        sVar.v(q4, viewGroup, sVar.f843j);
        View view = sVar.M;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            sVar.M.setTag(2131362108, sVar);
            if (viewGroup != null) {
                b();
            }
            if (sVar.G) {
                sVar.M.setVisibility(8);
            }
            View view2 = sVar.M;
            WeakHashMap weakHashMap = n0.t0.f7209a;
            boolean b9 = n0.f0.b(view2);
            View view3 = sVar.M;
            if (b9) {
                n0.g0.c(view3);
            } else {
                view3.addOnAttachStateChangeListener(new m0(view3, 0));
            }
            sVar.B.s(2);
            this.f800a.D0(false);
            int visibility = sVar.M.getVisibility();
            sVar.d().f835j = sVar.M.getAlpha();
            if (sVar.L != null && visibility == 0) {
                View findFocus = sVar.M.findFocus();
                if (findFocus != null) {
                    sVar.d().f836k = findFocus;
                    if (h0.D(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + sVar);
                    }
                }
                sVar.M.setAlpha(0.0f);
            }
        }
        sVar.f842i = 2;
    }

    public final void g() {
        boolean z8;
        s I;
        boolean D = h0.D(3);
        s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "movefrom CREATED: " + sVar);
        }
        int i9 = 0;
        boolean z9 = sVar.f853t && sVar.f858y <= 0;
        g gVar = this.f801b;
        if (!z9) {
            j0 j0Var = (j0) gVar.f730l;
            if (!((j0Var.f771c.containsKey(sVar.f846m) && j0Var.f774f) ? j0Var.f775g : true)) {
                String str = sVar.f849p;
                if (str != null && (I = gVar.I(str)) != null && I.I) {
                    sVar.f848o = I;
                }
                sVar.f842i = 0;
                return;
            }
        }
        v vVar = sVar.A;
        if (vVar != null) {
            z8 = ((j0) gVar.f730l).f775g;
        } else {
            z8 = t.a.d(vVar.f872p) ? !r7.isChangingConfigurations() : true;
        }
        if (z9 || z8) {
            j0 j0Var2 = (j0) gVar.f730l;
            HashMap hashMap = j0Var2.f773e;
            HashMap hashMap2 = j0Var2.f772d;
            if (h0.D(3)) {
                Log.d("FragmentManager", "Clearing non-config state for " + sVar);
            }
            j0 j0Var3 = (j0) hashMap2.get(sVar.f846m);
            if (j0Var3 != null) {
                j0Var3.a();
                hashMap2.remove(sVar.f846m);
            }
            androidx.lifecycle.l0 l0Var = (androidx.lifecycle.l0) hashMap.get(sVar.f846m);
            if (l0Var != null) {
                l0Var.a();
                hashMap.remove(sVar.f846m);
            }
        }
        sVar.B.k();
        sVar.T.d(androidx.lifecycle.l.ON_DESTROY);
        sVar.f842i = 0;
        sVar.R = false;
        sVar.K = true;
        this.f800a.u0(false);
        ArrayList L = gVar.L();
        int size = L.size();
        while (i9 < size) {
            Object obj = L.get(i9);
            i9++;
            n0 n0Var = (n0) obj;
            if (n0Var != null) {
                s sVar2 = n0Var.f802c;
                if (sVar.f846m.equals(sVar2.f849p)) {
                    sVar2.f848o = sVar;
                    sVar2.f849p = null;
                }
            }
        }
        String str2 = sVar.f849p;
        if (str2 != null) {
            sVar.f848o = gVar.I(str2);
        }
        gVar.e0(this);
    }

    public final void h() {
        c1.a aVar;
        View view;
        boolean D = h0.D(3);
        s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + sVar);
        }
        ViewGroup viewGroup = sVar.L;
        if (viewGroup != null && (view = sVar.M) != null) {
            viewGroup.removeView(view);
        }
        sVar.B.s(1);
        if (sVar.M != null) {
            p0 p0Var = sVar.U;
            p0Var.d();
            if (p0Var.f825j.f943d.compareTo(androidx.lifecycle.m.f930k) >= 0) {
                sVar.U.b(androidx.lifecycle.l.ON_DESTROY);
            }
        }
        sVar.f842i = 1;
        sVar.K = false;
        sVar.o();
        if (sVar.K) {
            androidx.lifecycle.l0 f9 = sVar.f();
            f9.getClass();
            b1.a aVar2 = b1.a.f1131j;
            aVar2.getClass();
            String canonicalName = c1.a.class.getCanonicalName();
            if (canonicalName != null) {
                String concat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
                LinkedHashMap linkedHashMap = f9.f927a;
                androidx.lifecycle.j0 j0Var = (androidx.lifecycle.j0) linkedHashMap.get(concat);
                if (c1.a.class.isInstance(j0Var)) {
                    j0Var.getClass();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.putAll((LinkedHashMap) aVar2.f1132i);
                    linkedHashMap2.put(androidx.lifecycle.k0.f926b, concat);
                    try {
                        aVar = new c1.a();
                    } catch (AbstractMethodError unused) {
                        aVar = new c1.a();
                    }
                    j0Var = aVar;
                    androidx.lifecycle.j0 j0Var2 = (androidx.lifecycle.j0) linkedHashMap.put(concat, j0Var);
                    if (j0Var2 != null) {
                        j0Var2.a();
                    }
                }
                s.i iVar = ((c1.a) j0Var).f1544c;
                if (iVar.f8657k <= 0) {
                    sVar.f857x = false;
                } else {
                    iVar.f8656j[0].getClass();
                    a.c();
                }
            } else {
                m7.c.n("Local and anonymous classes can not be ViewModels");
            }
        } else {
            a.e(sVar, " did not call through to super.onDestroyView()");
        }
        this.f800a.E0(false);
        sVar.L = null;
        sVar.M = null;
        sVar.U = null;
        sVar.V.e(null);
        sVar.f855v = false;
    }

    public final void i() {
        boolean D = h0.D(3);
        s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + sVar);
        }
        sVar.f842i = -1;
        sVar.K = false;
        sVar.p();
        if (!sVar.K) {
            a.e(sVar, " did not call through to super.onDetach()");
            return;
        }
        h0 h0Var = sVar.B;
        if (!h0Var.A) {
            h0Var.k();
            sVar.B = new h0();
        }
        this.f800a.v0(false);
        sVar.f842i = -1;
        sVar.A = null;
        sVar.C = null;
        sVar.f859z = null;
        if (!sVar.f853t || sVar.f858y > 0) {
            j0 j0Var = (j0) this.f801b.f730l;
            if (!((j0Var.f771c.containsKey(sVar.f846m) && j0Var.f774f) ? j0Var.f775g : true)) {
                return;
            }
        }
        if (h0.D(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + sVar);
        }
        sVar.T = new androidx.lifecycle.u(sVar);
        sVar.W = new com.bumptech.glide.manager.s(sVar);
        sVar.f846m = UUID.randomUUID().toString();
        sVar.f852s = false;
        sVar.f853t = false;
        sVar.f854u = false;
        sVar.f855v = false;
        sVar.f856w = false;
        sVar.f858y = 0;
        sVar.f859z = null;
        sVar.B = new h0();
        sVar.A = null;
        sVar.D = 0;
        sVar.E = 0;
        sVar.F = null;
        sVar.G = false;
        sVar.H = false;
    }

    public final void j() {
        s sVar = this.f802c;
        if (sVar.f854u && sVar.f855v && !sVar.f857x) {
            if (h0.D(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + sVar);
            }
            sVar.v(sVar.q(sVar.f843j), null, sVar.f843j);
            View view = sVar.M;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                sVar.M.setTag(2131362108, sVar);
                if (sVar.G) {
                    sVar.M.setVisibility(8);
                }
                sVar.B.s(2);
                this.f800a.D0(false);
                sVar.f842i = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z8 = this.f803d;
        s sVar = this.f802c;
        if (z8) {
            if (h0.D(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + sVar);
                return;
            }
            return;
        }
        try {
            this.f803d = true;
            while (true) {
                int d9 = d();
                int i9 = sVar.f842i;
                if (d9 == i9) {
                    if (sVar.Q) {
                        if (sVar.M != null && (viewGroup = sVar.L) != null) {
                            k f9 = k.f(viewGroup, sVar.j().B());
                            if (sVar.G) {
                                if (h0.D(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + sVar);
                                }
                                f9.a(3, 1, this);
                            } else {
                                if (h0.D(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + sVar);
                                }
                                f9.a(2, 1, this);
                            }
                        }
                        h0 h0Var = sVar.f859z;
                        if (h0Var != null && sVar.f852s && h0.E(sVar)) {
                            h0Var.f758x = true;
                        }
                        sVar.Q = false;
                    }
                    this.f803d = false;
                    return;
                }
                if (d9 <= i9) {
                    switch (i9 - 1) {
                        case VoIPController.ERROR_PEER_OUTDATED /* -1 */:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            sVar.f842i = 1;
                            break;
                        case 2:
                            sVar.f855v = false;
                            sVar.f842i = 2;
                            break;
                        case 3:
                            if (h0.D(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + sVar);
                            }
                            if (sVar.M != null && sVar.f844k == null) {
                                o();
                            }
                            if (sVar.M != null && (viewGroup3 = sVar.L) != null) {
                                k f10 = k.f(viewGroup3, sVar.j().B());
                                if (h0.D(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + sVar);
                                }
                                f10.a(1, 3, this);
                            }
                            sVar.f842i = 3;
                            break;
                        case 4:
                            q();
                            break;
                        case 5:
                            sVar.f842i = 5;
                            break;
                        case 6:
                            l();
                            break;
                    }
                } else {
                    switch (i9 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (sVar.M != null && (viewGroup2 = sVar.L) != null) {
                                k f11 = k.f(viewGroup2, sVar.j().B());
                                int b9 = androidx.activity.g.b(sVar.M.getVisibility());
                                if (h0.D(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + sVar);
                                }
                                f11.a(b9, 2, this);
                            }
                            sVar.f842i = 4;
                            break;
                        case 5:
                            p();
                            break;
                        case 6:
                            sVar.f842i = 6;
                            break;
                        case 7:
                            n();
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            this.f803d = false;
            throw th;
        }
    }

    public final void l() {
        boolean D = h0.D(3);
        s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "movefrom RESUMED: " + sVar);
        }
        sVar.B.s(5);
        if (sVar.M != null) {
            sVar.U.b(androidx.lifecycle.l.ON_PAUSE);
        }
        sVar.T.d(androidx.lifecycle.l.ON_PAUSE);
        sVar.f842i = 6;
        sVar.K = true;
        this.f800a.w0(false);
    }

    public final void m(ClassLoader classLoader) {
        s sVar = this.f802c;
        Bundle bundle = sVar.f843j;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        sVar.f844k = sVar.f843j.getSparseParcelableArray("android:view_state");
        sVar.f845l = sVar.f843j.getBundle("android:view_registry_state");
        String string = sVar.f843j.getString("android:target_state");
        sVar.f849p = string;
        if (string != null) {
            sVar.f850q = sVar.f843j.getInt("android:target_req_state", 0);
        }
        boolean z8 = sVar.f843j.getBoolean("android:user_visible_hint", true);
        sVar.O = z8;
        if (z8) {
            return;
        }
        sVar.N = true;
    }

    public final void n() {
        boolean D = h0.D(3);
        s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "moveto RESUMED: " + sVar);
        }
        q qVar = sVar.P;
        View view = qVar == null ? null : qVar.f836k;
        if (view != null) {
            if (view != sVar.M) {
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != sVar.M) {
                    }
                }
            }
            boolean requestFocus = view.requestFocus();
            if (h0.D(2)) {
                StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                sb.append(view);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(sVar);
                sb.append(" resulting in focused view ");
                sb.append(sVar.M.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        sVar.d().f836k = null;
        sVar.B.I();
        sVar.B.w(true);
        sVar.f842i = 7;
        sVar.K = true;
        androidx.lifecycle.u uVar = sVar.T;
        androidx.lifecycle.l lVar = androidx.lifecycle.l.ON_RESUME;
        uVar.d(lVar);
        if (sVar.M != null) {
            sVar.U.f825j.d(lVar);
        }
        h0 h0Var = sVar.B;
        h0Var.f759y = false;
        h0Var.f760z = false;
        h0Var.F.h = false;
        h0Var.s(7);
        this.f800a.z0(false);
        sVar.f843j = null;
        sVar.f844k = null;
        sVar.f845l = null;
    }

    public final void o() {
        s sVar = this.f802c;
        if (sVar.M == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        sVar.M.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            sVar.f844k = sparseArray;
        }
        Bundle bundle = new Bundle();
        sVar.U.f826k.f(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        sVar.f845l = bundle;
    }

    public final void p() {
        boolean D = h0.D(3);
        s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "moveto STARTED: " + sVar);
        }
        sVar.B.I();
        sVar.B.w(true);
        sVar.f842i = 5;
        sVar.K = false;
        sVar.s();
        if (!sVar.K) {
            a.e(sVar, " did not call through to super.onStart()");
            return;
        }
        androidx.lifecycle.u uVar = sVar.T;
        androidx.lifecycle.l lVar = androidx.lifecycle.l.ON_START;
        uVar.d(lVar);
        if (sVar.M != null) {
            sVar.U.f825j.d(lVar);
        }
        h0 h0Var = sVar.B;
        h0Var.f759y = false;
        h0Var.f760z = false;
        h0Var.F.h = false;
        h0Var.s(5);
        this.f800a.B0(false);
    }

    public final void q() {
        boolean D = h0.D(3);
        s sVar = this.f802c;
        if (D) {
            Log.d("FragmentManager", "movefrom STARTED: " + sVar);
        }
        h0 h0Var = sVar.B;
        h0Var.f760z = true;
        h0Var.F.h = true;
        h0Var.s(4);
        if (sVar.M != null) {
            sVar.U.b(androidx.lifecycle.l.ON_STOP);
        }
        sVar.T.d(androidx.lifecycle.l.ON_STOP);
        sVar.f842i = 4;
        sVar.K = false;
        sVar.t();
        if (sVar.K) {
            this.f800a.C0(false);
        } else {
            a.e(sVar, " did not call through to super.onStop()");
        }
    }

    public n0(a5.d dVar, g gVar, s sVar) {
        this.f800a = dVar;
        this.f801b = gVar;
        this.f802c = sVar;
    }

    public n0(a5.d dVar, g gVar, s sVar, l0 l0Var) {
        this.f800a = dVar;
        this.f801b = gVar;
        this.f802c = sVar;
        sVar.f844k = null;
        sVar.f845l = null;
        sVar.f858y = 0;
        sVar.f855v = false;
        sVar.f852s = false;
        s sVar2 = sVar.f848o;
        sVar.f849p = sVar2 != null ? sVar2.f846m : null;
        sVar.f848o = null;
        Bundle bundle = l0Var.f794u;
        if (bundle != null) {
            sVar.f843j = bundle;
        } else {
            sVar.f843j = new Bundle();
        }
    }
}
