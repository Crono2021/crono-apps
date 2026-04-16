package androidx.fragment.app;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h0 {
    public boolean A;
    public boolean B;
    public ArrayList C;
    public ArrayList D;
    public ArrayList E;
    public j0 F;
    public final androidx.activity.j G;

    /* renamed from: b, reason: collision with root package name */
    public boolean f737b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f739d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f740e;

    /* renamed from: g, reason: collision with root package name */
    public androidx.activity.x f742g;

    /* renamed from: k, reason: collision with root package name */
    public final a5.d f745k;

    /* renamed from: l, reason: collision with root package name */
    public final CopyOnWriteArrayList f746l;

    /* renamed from: m, reason: collision with root package name */
    public int f747m;

    /* renamed from: n, reason: collision with root package name */
    public v f748n;

    /* renamed from: o, reason: collision with root package name */
    public android.support.v4.media.session.b f749o;

    /* renamed from: p, reason: collision with root package name */
    public s f750p;

    /* renamed from: q, reason: collision with root package name */
    public s f751q;

    /* renamed from: r, reason: collision with root package name */
    public final b0 f752r;

    /* renamed from: s, reason: collision with root package name */
    public final u5.e f753s;

    /* renamed from: t, reason: collision with root package name */
    public androidx.activity.result.d f754t;

    /* renamed from: u, reason: collision with root package name */
    public androidx.activity.result.d f755u;

    /* renamed from: v, reason: collision with root package name */
    public androidx.activity.result.d f756v;

    /* renamed from: w, reason: collision with root package name */
    public ArrayDeque f757w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f758x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f759y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f760z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f736a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final g f738c = new g(1);

    /* renamed from: f, reason: collision with root package name */
    public final y f741f = new y(this);
    public final a0 h = new a0(this);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f743i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map f744j = Collections.synchronizedMap(new HashMap());

    public h0() {
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        new u5.e(this, 6);
        this.f745k = new a5.d(this);
        this.f746l = new CopyOnWriteArrayList();
        this.f747m = -1;
        this.f752r = new b0(this);
        this.f753s = new u5.e(7);
        this.f757w = new ArrayDeque();
        this.G = new androidx.activity.j(this, 3);
    }

    public static boolean D(int i9) {
        return Log.isLoggable("FragmentManager", i9);
    }

    public static boolean E(s sVar) {
        sVar.getClass();
        g gVar = sVar.B.f738c;
        gVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (n0 n0Var : ((HashMap) gVar.f729k).values()) {
            if (n0Var != null) {
                arrayList.add(n0Var.f802c);
            } else {
                arrayList.add(null);
            }
        }
        int size = arrayList.size();
        boolean z8 = false;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            s sVar2 = (s) obj;
            if (sVar2 != null) {
                z8 = E(sVar2);
            }
            if (z8) {
                return true;
            }
        }
        return false;
    }

    public static boolean F(s sVar) {
        if (sVar == null) {
            return true;
        }
        if (sVar.J) {
            return sVar.f859z == null || F(sVar.C);
        }
        return false;
    }

    public static boolean G(s sVar) {
        if (sVar == null) {
            return true;
        }
        h0 h0Var = sVar.f859z;
        return sVar.equals(h0Var.f751q) && G(h0Var.f750p);
    }

    public static void U(s sVar) {
        if (D(2)) {
            Log.v("FragmentManager", "show: " + sVar);
        }
        if (sVar.G) {
            sVar.G = false;
            sVar.Q = !sVar.Q;
        }
    }

    public final b0 A() {
        s sVar = this.f750p;
        return sVar != null ? sVar.f859z.A() : this.f752r;
    }

    public final u5.e B() {
        s sVar = this.f750p;
        return sVar != null ? sVar.f859z.B() : this.f753s;
    }

    public final void C(s sVar) {
        if (D(2)) {
            Log.v("FragmentManager", "hide: " + sVar);
        }
        if (sVar.G) {
            return;
        }
        sVar.G = true;
        sVar.Q = true ^ sVar.Q;
        T(sVar);
    }

    public final void H(int i9, boolean z8) {
        v vVar;
        if (this.f748n == null && i9 != -1) {
            m7.c.p("No activity");
            return;
        }
        if (z8 || i9 != this.f747m) {
            this.f747m = i9;
            g gVar = this.f738c;
            HashMap hashMap = (HashMap) gVar.f729k;
            ArrayList arrayList = (ArrayList) gVar.f728j;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                n0 n0Var = (n0) hashMap.get(((s) obj).f846m);
                if (n0Var != null) {
                    n0Var.k();
                }
            }
            for (n0 n0Var2 : hashMap.values()) {
                if (n0Var2 != null) {
                    n0Var2.k();
                    s sVar = n0Var2.f802c;
                    if (sVar.f853t && sVar.f858y <= 0) {
                        gVar.e0(n0Var2);
                    }
                }
            }
            V();
            if (this.f758x && (vVar = this.f748n) != null && this.f747m == 7) {
                vVar.f875s.i().b();
                this.f758x = false;
            }
        }
    }

    public final void I() {
        if (this.f748n == null) {
            return;
        }
        this.f759y = false;
        this.f760z = false;
        this.F.h = false;
        for (s sVar : this.f738c.T()) {
            if (sVar != null) {
                sVar.B.I();
            }
        }
    }

    public final boolean J() {
        w(false);
        v(true);
        s sVar = this.f751q;
        if (sVar != null && sVar.e().J()) {
            return true;
        }
        boolean K = K(this.C, this.D, -1, 0);
        if (K) {
            this.f737b = true;
            try {
                M(this.C, this.D);
            } finally {
                d();
            }
        }
        W();
        if (this.B) {
            this.B = false;
            V();
        }
        ((HashMap) this.f738c.f729k).values().removeAll(Collections.singleton(null));
        return K;
    }

    public final boolean K(ArrayList arrayList, ArrayList arrayList2, int i9, int i10) {
        int i11;
        b bVar;
        ArrayList arrayList3 = this.f739d;
        if (arrayList3 == null) {
            return false;
        }
        if (i9 < 0 && (i10 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f739d.remove(size));
            arrayList2.add(Boolean.TRUE);
            return true;
        }
        if (i9 >= 0) {
            i11 = arrayList3.size() - 1;
            while (i11 >= 0) {
                b bVar2 = (b) this.f739d.get(i11);
                if (i9 >= 0 && i9 == bVar2.f694r) {
                    break;
                }
                i11--;
            }
            if (i11 < 0) {
                return false;
            }
            if ((i10 & 1) != 0) {
                do {
                    i11--;
                    if (i11 < 0) {
                        break;
                    }
                    bVar = (b) this.f739d.get(i11);
                    if (i9 < 0) {
                        break;
                    }
                } while (i9 == bVar.f694r);
            }
        } else {
            i11 = -1;
        }
        if (i11 == this.f739d.size() - 1) {
            return false;
        }
        for (int size2 = this.f739d.size() - 1; size2 > i11; size2--) {
            arrayList.add(this.f739d.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void L(s sVar) {
        if (D(2)) {
            Log.v("FragmentManager", "remove: " + sVar + " nesting=" + sVar.f858y);
        }
        boolean z8 = sVar.f858y > 0;
        if (sVar.H && z8) {
            return;
        }
        g gVar = this.f738c;
        synchronized (((ArrayList) gVar.f728j)) {
            ((ArrayList) gVar.f728j).remove(sVar);
        }
        sVar.f852s = false;
        if (E(sVar)) {
            this.f758x = true;
        }
        sVar.f853t = true;
        T(sVar);
    }

    public final void M(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            m7.c.p("Internal error with the back stack records");
            return;
        }
        int size = arrayList.size();
        int i9 = 0;
        int i10 = 0;
        while (i9 < size) {
            if (!((b) arrayList.get(i9)).f691o) {
                if (i10 != i9) {
                    x(arrayList, arrayList2, i10, i9);
                }
                i10 = i9 + 1;
                if (((Boolean) arrayList2.get(i9)).booleanValue()) {
                    while (i10 < size && ((Boolean) arrayList2.get(i10)).booleanValue() && !((b) arrayList.get(i10)).f691o) {
                        i10++;
                    }
                }
                x(arrayList, arrayList2, i9, i10);
                i9 = i10 - 1;
            }
            i9++;
        }
        if (i10 != size) {
            x(arrayList, arrayList2, i10, size);
        }
    }

    public final void N(Parcelable parcelable) {
        a5.d dVar;
        n0 n0Var;
        if (parcelable == null) {
            return;
        }
        i0 i0Var = (i0) parcelable;
        if (i0Var.f763i == null) {
            return;
        }
        g gVar = this.f738c;
        ((HashMap) gVar.f729k).clear();
        ArrayList arrayList = i0Var.f763i;
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            dVar = this.f745k;
            if (i9 >= size) {
                break;
            }
            Object obj = arrayList.get(i9);
            i9++;
            l0 l0Var = (l0) obj;
            if (l0Var != null) {
                s sVar = (s) this.F.f771c.get(l0Var.f783j);
                if (sVar != null) {
                    if (D(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + sVar);
                    }
                    n0Var = new n0(dVar, gVar, sVar, l0Var);
                } else {
                    n0Var = new n0(this.f745k, this.f738c, this.f748n.f872p.getClassLoader(), A(), l0Var);
                }
                s sVar2 = n0Var.f802c;
                sVar2.f859z = this;
                if (D(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + sVar2.f846m + "): " + sVar2);
                }
                n0Var.m(this.f748n.f872p.getClassLoader());
                gVar.d0(n0Var);
                n0Var.f804e = this.f747m;
            }
        }
        j0 j0Var = this.F;
        j0Var.getClass();
        ArrayList arrayList2 = new ArrayList(j0Var.f771c.values());
        int size2 = arrayList2.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList2.get(i10);
            i10++;
            s sVar3 = (s) obj2;
            if (((HashMap) gVar.f729k).get(sVar3.f846m) == null) {
                if (D(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + sVar3 + " that was not found in the set of active Fragments " + i0Var.f763i);
                }
                this.F.b(sVar3);
                sVar3.f859z = this;
                n0 n0Var2 = new n0(dVar, gVar, sVar3);
                n0Var2.f804e = 1;
                n0Var2.k();
                sVar3.f853t = true;
                n0Var2.k();
            }
        }
        ArrayList arrayList3 = i0Var.f764j;
        ((ArrayList) gVar.f728j).clear();
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            int i11 = 0;
            while (i11 < size3) {
                Object obj3 = arrayList3.get(i11);
                i11++;
                String str = (String) obj3;
                s I = gVar.I(str);
                if (I == null) {
                    m7.c.p(androidx.activity.g.n("No instantiated fragment for (", str, ")"));
                    return;
                }
                if (D(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + I);
                }
                gVar.w(I);
            }
        }
        s sVar4 = null;
        if (i0Var.f765k != null) {
            this.f739d = new ArrayList(i0Var.f765k.length);
            int i12 = 0;
            while (true) {
                c[] cVarArr = i0Var.f765k;
                if (i12 >= cVarArr.length) {
                    break;
                }
                c cVar = cVarArr[i12];
                int[] iArr = cVar.f697i;
                b bVar = new b(this);
                int i13 = 0;
                int i14 = 0;
                while (i13 < iArr.length) {
                    o0 o0Var = new o0();
                    int i15 = i13 + 1;
                    o0Var.f816a = iArr[i13];
                    if (D(2)) {
                        Log.v("FragmentManager", "Instantiate " + bVar + " op #" + i14 + " base fragment #" + iArr[i15]);
                    }
                    String str2 = (String) cVar.f698j.get(i14);
                    if (str2 != null) {
                        o0Var.f817b = gVar.I(str2);
                    } else {
                        o0Var.f817b = sVar4;
                    }
                    o0Var.f822g = androidx.lifecycle.m.values()[cVar.f699k[i14]];
                    o0Var.h = androidx.lifecycle.m.values()[cVar.f700l[i14]];
                    int i16 = iArr[i15];
                    o0Var.f818c = i16;
                    int i17 = iArr[i13 + 2];
                    o0Var.f819d = i17;
                    int i18 = i13 + 4;
                    int i19 = iArr[i13 + 3];
                    o0Var.f820e = i19;
                    i13 += 5;
                    int i20 = iArr[i18];
                    o0Var.f821f = i20;
                    bVar.f679b = i16;
                    bVar.f680c = i17;
                    bVar.f681d = i19;
                    bVar.f682e = i20;
                    bVar.b(o0Var);
                    i14++;
                    sVar4 = null;
                }
                bVar.f683f = cVar.f701m;
                bVar.h = cVar.f702n;
                bVar.f694r = cVar.f703o;
                bVar.f684g = true;
                bVar.f685i = cVar.f704p;
                bVar.f686j = cVar.f705q;
                bVar.f687k = cVar.f706r;
                bVar.f688l = cVar.f707s;
                bVar.f689m = cVar.f708t;
                bVar.f690n = cVar.f709u;
                bVar.f691o = cVar.f710v;
                bVar.c(1);
                if (D(2)) {
                    StringBuilder p5 = androidx.activity.g.p(i12, "restoreAllState: back stack #", " (index ");
                    p5.append(bVar.f694r);
                    p5.append("): ");
                    p5.append(bVar);
                    Log.v("FragmentManager", p5.toString());
                    PrintWriter printWriter = new PrintWriter(new q0());
                    bVar.d("  ", printWriter, false);
                    printWriter.close();
                }
                this.f739d.add(bVar);
                i12++;
                sVar4 = null;
            }
        } else {
            this.f739d = null;
        }
        this.f743i.set(i0Var.f766l);
        String str3 = i0Var.f767m;
        if (str3 != null) {
            s I2 = gVar.I(str3);
            this.f751q = I2;
            p(I2);
        }
        ArrayList arrayList4 = i0Var.f768n;
        if (arrayList4 != null) {
            for (int i21 = 0; i21 < arrayList4.size(); i21++) {
                Bundle bundle = (Bundle) i0Var.f769o.get(i21);
                bundle.setClassLoader(this.f748n.f872p.getClassLoader());
                this.f744j.put(arrayList4.get(i21), bundle);
            }
        }
        this.f757w = new ArrayDeque(i0Var.f770p);
    }

    public final i0 O() {
        int i9;
        ArrayList arrayList;
        c[] cVarArr;
        int size;
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            k kVar = (k) it.next();
            if (kVar.f780e) {
                kVar.f780e = false;
                kVar.c();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((k) it2.next()).e();
        }
        w(true);
        this.f759y = true;
        this.F.h = true;
        g gVar = this.f738c;
        gVar.getClass();
        HashMap hashMap = (HashMap) gVar.f729k;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        Iterator it3 = hashMap.values().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            n0 n0Var = (n0) it3.next();
            if (n0Var != null) {
                s sVar = n0Var.f802c;
                l0 l0Var = new l0(sVar);
                if (sVar.f842i <= -1 || l0Var.f794u != null) {
                    l0Var.f794u = sVar.f843j;
                } else {
                    Bundle bundle = new Bundle();
                    sVar.r(bundle);
                    sVar.W.f(bundle);
                    i0 O = sVar.B.O();
                    if (O != null) {
                        bundle.putParcelable("android:support:fragments", O);
                    }
                    n0Var.f800a.A0(false);
                    Bundle bundle2 = bundle.isEmpty() ? null : bundle;
                    if (sVar.M != null) {
                        n0Var.o();
                    }
                    if (sVar.f844k != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putSparseParcelableArray("android:view_state", sVar.f844k);
                    }
                    if (sVar.f845l != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBundle("android:view_registry_state", sVar.f845l);
                    }
                    if (!sVar.O) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBoolean("android:user_visible_hint", sVar.O);
                    }
                    l0Var.f794u = bundle2;
                    if (sVar.f849p != null) {
                        if (bundle2 == null) {
                            l0Var.f794u = new Bundle();
                        }
                        l0Var.f794u.putString("android:target_state", sVar.f849p);
                        int i10 = sVar.f850q;
                        if (i10 != 0) {
                            l0Var.f794u.putInt("android:target_req_state", i10);
                        }
                    }
                }
                arrayList2.add(l0Var);
                if (D(2)) {
                    Log.v("FragmentManager", "Saved state of " + sVar + ": " + l0Var.f794u);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (D(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        g gVar2 = this.f738c;
        synchronized (((ArrayList) gVar2.f728j)) {
            try {
                if (((ArrayList) gVar2.f728j).isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(((ArrayList) gVar2.f728j).size());
                    ArrayList arrayList3 = (ArrayList) gVar2.f728j;
                    int size2 = arrayList3.size();
                    int i11 = 0;
                    while (i11 < size2) {
                        Object obj = arrayList3.get(i11);
                        i11++;
                        s sVar2 = (s) obj;
                        arrayList.add(sVar2.f846m);
                        if (D(2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + sVar2.f846m + "): " + sVar2);
                        }
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList4 = this.f739d;
        if (arrayList4 == null || (size = arrayList4.size()) <= 0) {
            cVarArr = null;
        } else {
            cVarArr = new c[size];
            for (i9 = 0; i9 < size; i9++) {
                cVarArr[i9] = new c((b) this.f739d.get(i9));
                if (D(2)) {
                    StringBuilder p5 = androidx.activity.g.p(i9, "saveAllState: adding back stack #", ": ");
                    p5.append(this.f739d.get(i9));
                    Log.v("FragmentManager", p5.toString());
                }
            }
        }
        i0 i0Var = new i0();
        i0Var.f767m = null;
        ArrayList arrayList5 = new ArrayList();
        i0Var.f768n = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        i0Var.f769o = arrayList6;
        i0Var.f763i = arrayList2;
        i0Var.f764j = arrayList;
        i0Var.f765k = cVarArr;
        i0Var.f766l = this.f743i.get();
        s sVar3 = this.f751q;
        if (sVar3 != null) {
            i0Var.f767m = sVar3.f846m;
        }
        arrayList5.addAll(this.f744j.keySet());
        arrayList6.addAll(this.f744j.values());
        i0Var.f770p = new ArrayList(this.f757w);
        return i0Var;
    }

    public final void P() {
        synchronized (this.f736a) {
            try {
                if (this.f736a.size() == 1) {
                    this.f748n.f873q.removeCallbacks(this.G);
                    this.f748n.f873q.post(this.G);
                    W();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void Q(s sVar, boolean z8) {
        ViewGroup z9 = z(sVar);
        if (z9 == null || !(z9 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) z9).setDrawDisappearingViewsLast(!z8);
    }

    public final void R(s sVar, androidx.lifecycle.m mVar) {
        if (sVar.equals(this.f738c.I(sVar.f846m)) && (sVar.A == null || sVar.f859z == this)) {
            sVar.S = mVar;
        } else {
            a.i("Fragment ", sVar, " is not an active fragment of FragmentManager ", this);
        }
    }

    public final void S(s sVar) {
        if (sVar != null) {
            if (!sVar.equals(this.f738c.I(sVar.f846m)) || (sVar.A != null && sVar.f859z != this)) {
                a.i("Fragment ", sVar, " is not an active fragment of FragmentManager ", this);
                return;
            }
        }
        s sVar2 = this.f751q;
        this.f751q = sVar;
        p(sVar2);
        p(this.f751q);
    }

    public final void T(s sVar) {
        ViewGroup z8 = z(sVar);
        if (z8 != null) {
            q qVar = sVar.P;
            if ((qVar == null ? 0 : qVar.f831e) + (qVar == null ? 0 : qVar.f830d) + (qVar == null ? 0 : qVar.f829c) + (qVar == null ? 0 : qVar.f828b) > 0) {
                if (z8.getTag(2131362522) == null) {
                    z8.setTag(2131362522, sVar);
                }
                s sVar2 = (s) z8.getTag(2131362522);
                q qVar2 = sVar.P;
                boolean z9 = qVar2 != null ? qVar2.f827a : false;
                if (sVar2.P == null) {
                    return;
                }
                sVar2.d().f827a = z9;
            }
        }
    }

    public final void V() {
        ArrayList L = this.f738c.L();
        int size = L.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = L.get(i9);
            i9++;
            n0 n0Var = (n0) obj;
            s sVar = n0Var.f802c;
            if (sVar.N) {
                if (this.f737b) {
                    this.B = true;
                } else {
                    sVar.N = false;
                    n0Var.k();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [a8.a, b8.h] */
    /* JADX WARN: Type inference failed for: r1v10, types: [a8.a, b8.h] */
    public final void W() {
        synchronized (this.f736a) {
            try {
                if (!this.f736a.isEmpty()) {
                    a0 a0Var = this.h;
                    a0Var.f674a = true;
                    ?? r12 = a0Var.f676c;
                    if (r12 != 0) {
                        r12.d();
                    }
                    return;
                }
                a0 a0Var2 = this.h;
                ArrayList arrayList = this.f739d;
                a0Var2.f674a = (arrayList != null ? arrayList.size() : 0) > 0 && G(this.f750p);
                ?? r02 = a0Var2.f676c;
                if (r02 != 0) {
                    r02.d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final n0 a(s sVar) {
        if (D(2)) {
            Log.v("FragmentManager", "add: " + sVar);
        }
        n0 f9 = f(sVar);
        sVar.f859z = this;
        g gVar = this.f738c;
        gVar.d0(f9);
        if (!sVar.H) {
            gVar.w(sVar);
            sVar.f853t = false;
            if (sVar.M == null) {
                sVar.Q = false;
            }
            if (E(sVar)) {
                this.f758x = true;
            }
        }
        return f9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(v vVar, android.support.v4.media.session.b bVar, s sVar) {
        j0 j0Var;
        if (this.f748n != null) {
            m7.c.p("Already attached");
            return;
        }
        this.f748n = vVar;
        this.f749o = bVar;
        this.f750p = sVar;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f746l;
        if (sVar != 0) {
            copyOnWriteArrayList.add(new c0(sVar));
        } else if (vVar != null) {
            copyOnWriteArrayList.add(vVar);
        }
        if (this.f750p != null) {
            W();
        }
        if (vVar != null) {
            androidx.activity.x h = vVar.f875s.h();
            this.f742g = h;
            h.a(sVar != 0 ? sVar : vVar, this.h);
        }
        if (sVar != 0) {
            j0 j0Var2 = sVar.f859z.F;
            HashMap hashMap = j0Var2.f772d;
            j0 j0Var3 = (j0) hashMap.get(sVar.f846m);
            if (j0Var3 == null) {
                j0Var3 = new j0(j0Var2.f774f);
                hashMap.put(sVar.f846m, j0Var3);
            }
            this.F = j0Var3;
        } else if (vVar != null) {
            androidx.lifecycle.l0 f9 = vVar.f875s.f();
            f9.getClass();
            b1.a aVar = b1.a.f1131j;
            aVar.getClass();
            String canonicalName = j0.class.getCanonicalName();
            if (canonicalName == null) {
                m7.c.n("Local and anonymous classes can not be ViewModels");
                return;
            }
            String concat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
            LinkedHashMap linkedHashMap = f9.f927a;
            androidx.lifecycle.j0 j0Var4 = (androidx.lifecycle.j0) linkedHashMap.get(concat);
            if (j0.class.isInstance(j0Var4)) {
                j0Var4.getClass();
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.putAll((LinkedHashMap) aVar.f1132i);
                linkedHashMap2.put(androidx.lifecycle.k0.f926b, concat);
                try {
                    j0Var = new j0(true);
                } catch (AbstractMethodError unused) {
                    j0Var = new j0(true);
                }
                j0Var4 = j0Var;
                androidx.lifecycle.j0 j0Var5 = (androidx.lifecycle.j0) linkedHashMap.put(concat, j0Var4);
                if (j0Var5 != null) {
                    j0Var5.a();
                }
            }
            this.F = (j0) j0Var4;
        } else {
            this.F = new j0(false);
        }
        j0 j0Var6 = this.F;
        j0Var6.h = this.f759y || this.f760z;
        this.f738c.f730l = j0Var6;
        v vVar2 = this.f748n;
        if (vVar2 != null) {
            androidx.activity.i iVar = vVar2.f875s.f307s;
            String concat2 = "FragmentManager:".concat(sVar != 0 ? androidx.activity.g.o(new StringBuilder(), sVar.f846m, ":") : "");
            this.f754t = iVar.d(concat2.concat("StartActivityForResult"), new d0(2), new z(this, 2));
            this.f755u = iVar.d(concat2.concat("StartIntentSenderForResult"), new d0(0), new z(this, 0));
            this.f756v = iVar.d(concat2.concat("RequestPermissions"), new d0(1), new z(this, 1));
        }
    }

    public final void c(s sVar) {
        if (D(2)) {
            Log.v("FragmentManager", "attach: " + sVar);
        }
        if (sVar.H) {
            sVar.H = false;
            if (sVar.f852s) {
                return;
            }
            this.f738c.w(sVar);
            if (D(2)) {
                Log.v("FragmentManager", "add from attach: " + sVar);
            }
            if (E(sVar)) {
                this.f758x = true;
            }
        }
    }

    public final void d() {
        this.f737b = false;
        this.D.clear();
        this.C.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        ArrayList L = this.f738c.L();
        int size = L.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = L.get(i9);
            i9++;
            ViewGroup viewGroup = ((n0) obj).f802c.L;
            if (viewGroup != null) {
                hashSet.add(k.f(viewGroup, B()));
            }
        }
        return hashSet;
    }

    public final n0 f(s sVar) {
        String str = sVar.f846m;
        g gVar = this.f738c;
        n0 n0Var = (n0) ((HashMap) gVar.f729k).get(str);
        if (n0Var != null) {
            return n0Var;
        }
        n0 n0Var2 = new n0(this.f745k, gVar, sVar);
        n0Var2.m(this.f748n.f872p.getClassLoader());
        n0Var2.f804e = this.f747m;
        return n0Var2;
    }

    public final void g(s sVar) {
        if (D(2)) {
            Log.v("FragmentManager", "detach: " + sVar);
        }
        if (sVar.H) {
            return;
        }
        sVar.H = true;
        if (sVar.f852s) {
            if (D(2)) {
                Log.v("FragmentManager", "remove from detach: " + sVar);
            }
            g gVar = this.f738c;
            synchronized (((ArrayList) gVar.f728j)) {
                ((ArrayList) gVar.f728j).remove(sVar);
            }
            sVar.f852s = false;
            if (E(sVar)) {
                this.f758x = true;
            }
            T(sVar);
        }
    }

    public final void h() {
        for (s sVar : this.f738c.T()) {
            if (sVar != null) {
                sVar.K = true;
                sVar.B.h();
            }
        }
    }

    public final boolean i() {
        if (this.f747m >= 1) {
            for (s sVar : this.f738c.T()) {
                if (sVar != null) {
                    if (!sVar.G ? sVar.B.i() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean j() {
        if (this.f747m < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z8 = false;
        for (s sVar : this.f738c.T()) {
            if (sVar != null && F(sVar)) {
                if (!sVar.G ? sVar.B.j() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(sVar);
                    z8 = true;
                }
            }
        }
        if (this.f740e != null) {
            for (int i9 = 0; i9 < this.f740e.size(); i9++) {
                s sVar2 = (s) this.f740e.get(i9);
                if (arrayList == null || !arrayList.contains(sVar2)) {
                    sVar2.getClass();
                }
            }
        }
        this.f740e = arrayList;
        return z8;
    }

    public final void k() {
        this.A = true;
        w(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((k) it.next()).e();
        }
        s(-1);
        this.f748n = null;
        this.f749o = null;
        this.f750p = null;
        if (this.f742g != null) {
            Iterator it2 = this.h.f675b.iterator();
            while (it2.hasNext()) {
                ((androidx.activity.c) it2.next()).cancel();
            }
            this.f742g = null;
        }
        androidx.activity.result.d dVar = this.f754t;
        if (dVar != null) {
            dVar.f329j.f(dVar.f328i);
            androidx.activity.result.d dVar2 = this.f755u;
            dVar2.f329j.f(dVar2.f328i);
            androidx.activity.result.d dVar3 = this.f756v;
            dVar3.f329j.f(dVar3.f328i);
        }
    }

    public final void l() {
        for (s sVar : this.f738c.T()) {
            if (sVar != null) {
                sVar.K = true;
                sVar.B.l();
            }
        }
    }

    public final void m() {
        for (s sVar : this.f738c.T()) {
            if (sVar != null) {
                sVar.B.m();
            }
        }
    }

    public final boolean n() {
        if (this.f747m >= 1) {
            for (s sVar : this.f738c.T()) {
                if (sVar != null) {
                    if (!sVar.G ? sVar.B.n() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void o() {
        if (this.f747m < 1) {
            return;
        }
        for (s sVar : this.f738c.T()) {
            if (sVar != null && !sVar.G) {
                sVar.B.o();
            }
        }
    }

    public final void p(s sVar) {
        if (sVar != null) {
            if (sVar.equals(this.f738c.I(sVar.f846m))) {
                sVar.f859z.getClass();
                boolean G = G(sVar);
                Boolean bool = sVar.f851r;
                if (bool == null || bool.booleanValue() != G) {
                    sVar.f851r = Boolean.valueOf(G);
                    h0 h0Var = sVar.B;
                    h0Var.W();
                    h0Var.p(h0Var.f751q);
                }
            }
        }
    }

    public final void q() {
        for (s sVar : this.f738c.T()) {
            if (sVar != null) {
                sVar.B.q();
            }
        }
    }

    public final boolean r() {
        if (this.f747m < 1) {
            return false;
        }
        boolean z8 = false;
        for (s sVar : this.f738c.T()) {
            if (sVar != null && F(sVar)) {
                if (!sVar.G ? sVar.B.r() : false) {
                    z8 = true;
                }
            }
        }
        return z8;
    }

    public final void s(int i9) {
        try {
            this.f737b = true;
            for (n0 n0Var : ((HashMap) this.f738c.f729k).values()) {
                if (n0Var != null) {
                    n0Var.f804e = i9;
                }
            }
            H(i9, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((k) it.next()).e();
            }
            this.f737b = false;
            w(true);
        } catch (Throwable th) {
            this.f737b = false;
            throw th;
        }
    }

    public final void t(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        c1.a aVar;
        String str2;
        String str3 = str + "    ";
        g gVar = this.f738c;
        ArrayList arrayList = (ArrayList) gVar.f728j;
        String str4 = str + "    ";
        HashMap hashMap = (HashMap) gVar.f729k;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (n0 n0Var : hashMap.values()) {
                printWriter.print(str);
                if (n0Var != null) {
                    s sVar = n0Var.f802c;
                    printWriter.println(sVar);
                    sVar.getClass();
                    printWriter.print(str4);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(sVar.D));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(sVar.E));
                    printWriter.print(" mTag=");
                    printWriter.println(sVar.F);
                    printWriter.print(str4);
                    printWriter.print("mState=");
                    printWriter.print(sVar.f842i);
                    printWriter.print(" mWho=");
                    printWriter.print(sVar.f846m);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(sVar.f858y);
                    printWriter.print(str4);
                    printWriter.print("mAdded=");
                    printWriter.print(sVar.f852s);
                    printWriter.print(" mRemoving=");
                    printWriter.print(sVar.f853t);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(sVar.f854u);
                    printWriter.print(" mInLayout=");
                    printWriter.println(sVar.f855v);
                    printWriter.print(str4);
                    printWriter.print("mHidden=");
                    printWriter.print(sVar.G);
                    printWriter.print(" mDetached=");
                    printWriter.print(sVar.H);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(sVar.J);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(str4);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(sVar.I);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(sVar.O);
                    if (sVar.f859z != null) {
                        printWriter.print(str4);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(sVar.f859z);
                    }
                    if (sVar.A != null) {
                        printWriter.print(str4);
                        printWriter.print("mHost=");
                        printWriter.println(sVar.A);
                    }
                    if (sVar.C != null) {
                        printWriter.print(str4);
                        printWriter.print("mParentFragment=");
                        printWriter.println(sVar.C);
                    }
                    if (sVar.f847n != null) {
                        printWriter.print(str4);
                        printWriter.print("mArguments=");
                        printWriter.println(sVar.f847n);
                    }
                    if (sVar.f843j != null) {
                        printWriter.print(str4);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(sVar.f843j);
                    }
                    if (sVar.f844k != null) {
                        printWriter.print(str4);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(sVar.f844k);
                    }
                    if (sVar.f845l != null) {
                        printWriter.print(str4);
                        printWriter.print("mSavedViewRegistryState=");
                        printWriter.println(sVar.f845l);
                    }
                    Object obj = sVar.f848o;
                    if (obj == null) {
                        h0 h0Var = sVar.f859z;
                        obj = (h0Var == null || (str2 = sVar.f849p) == null) ? null : h0Var.f738c.I(str2);
                    }
                    if (obj != null) {
                        printWriter.print(str4);
                        printWriter.print("mTarget=");
                        printWriter.print(obj);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(sVar.f850q);
                    }
                    printWriter.print(str4);
                    printWriter.print("mPopDirection=");
                    q qVar = sVar.P;
                    printWriter.println(qVar == null ? false : qVar.f827a);
                    q qVar2 = sVar.P;
                    if ((qVar2 == null ? 0 : qVar2.f828b) != 0) {
                        printWriter.print(str4);
                        printWriter.print("getEnterAnim=");
                        q qVar3 = sVar.P;
                        printWriter.println(qVar3 == null ? 0 : qVar3.f828b);
                    }
                    q qVar4 = sVar.P;
                    if ((qVar4 == null ? 0 : qVar4.f829c) != 0) {
                        printWriter.print(str4);
                        printWriter.print("getExitAnim=");
                        q qVar5 = sVar.P;
                        printWriter.println(qVar5 == null ? 0 : qVar5.f829c);
                    }
                    q qVar6 = sVar.P;
                    if ((qVar6 == null ? 0 : qVar6.f830d) != 0) {
                        printWriter.print(str4);
                        printWriter.print("getPopEnterAnim=");
                        q qVar7 = sVar.P;
                        printWriter.println(qVar7 == null ? 0 : qVar7.f830d);
                    }
                    q qVar8 = sVar.P;
                    if ((qVar8 == null ? 0 : qVar8.f831e) != 0) {
                        printWriter.print(str4);
                        printWriter.print("getPopExitAnim=");
                        q qVar9 = sVar.P;
                        printWriter.println(qVar9 == null ? 0 : qVar9.f831e);
                    }
                    if (sVar.L != null) {
                        printWriter.print(str4);
                        printWriter.print("mContainer=");
                        printWriter.println(sVar.L);
                    }
                    if (sVar.M != null) {
                        printWriter.print(str4);
                        printWriter.print("mView=");
                        printWriter.println(sVar.M);
                    }
                    if (sVar.h() != null) {
                        androidx.lifecycle.l0 f9 = sVar.f();
                        f9.getClass();
                        b1.a aVar2 = b1.a.f1131j;
                        aVar2.getClass();
                        String canonicalName = c1.a.class.getCanonicalName();
                        if (canonicalName == null) {
                            m7.c.n("Local and anonymous classes can not be ViewModels");
                            return;
                        }
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
                        if (iVar.f8657k > 0) {
                            printWriter.print(str4);
                            printWriter.println("Loaders:");
                            if (iVar.f8657k > 0) {
                                if (iVar.f8656j[0] != null) {
                                    a.c();
                                    return;
                                }
                                printWriter.print(str4);
                                printWriter.print("  #");
                                printWriter.print(iVar.f8655i[0]);
                                printWriter.print(": ");
                                throw null;
                            }
                        }
                    }
                    printWriter.print(str4);
                    printWriter.println("Child " + sVar.B + ":");
                    sVar.B.t(str4.concat("  "), fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i9 = 0; i9 < size3; i9++) {
                s sVar2 = (s) arrayList.get(i9);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i9);
                printWriter.print(": ");
                printWriter.println(sVar2.toString());
            }
        }
        ArrayList arrayList2 = this.f740e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                s sVar3 = (s) this.f740e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(sVar3.toString());
            }
        }
        ArrayList arrayList3 = this.f739d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                b bVar = (b) this.f739d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(bVar.toString());
                bVar.d(str3, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f743i.get());
        synchronized (this.f736a) {
            try {
                int size4 = this.f736a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size4; i12++) {
                        Object obj2 = (f0) this.f736a.get(i12);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
                        printWriter.print(": ");
                        printWriter.println(obj2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f748n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f749o);
        if (this.f750p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f750p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f747m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f759y);
        printWriter.print(" mStopped=");
        printWriter.print(this.f760z);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.A);
        if (this.f758x) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f758x);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        s sVar = this.f750p;
        if (sVar != null) {
            sb.append(sVar.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f750p)));
            sb.append("}");
        } else {
            v vVar = this.f748n;
            if (vVar != null) {
                sb.append(vVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f748n)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(f0 f0Var, boolean z8) {
        if (!z8) {
            if (this.f748n == null) {
                if (this.A) {
                    m7.c.p("FragmentManager has been destroyed");
                    return;
                } else {
                    m7.c.p("FragmentManager has not been attached to a host.");
                    return;
                }
            }
            if (this.f759y || this.f760z) {
                m7.c.p("Can not perform this action after onSaveInstanceState");
                return;
            }
        }
        synchronized (this.f736a) {
            try {
                if (this.f748n == null) {
                    if (!z8) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f736a.add(f0Var);
                    P();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v(boolean z8) {
        if (this.f737b) {
            m7.c.p("FragmentManager is already executing transactions");
            return;
        }
        if (this.f748n == null) {
            if (this.A) {
                m7.c.p("FragmentManager has been destroyed");
                return;
            } else {
                m7.c.p("FragmentManager has not been attached to a host.");
                return;
            }
        }
        if (Looper.myLooper() != this.f748n.f873q.getLooper()) {
            m7.c.p("Must be called from main thread of fragment host");
            return;
        }
        if (!z8 && (this.f759y || this.f760z)) {
            m7.c.p("Can not perform this action after onSaveInstanceState");
            return;
        }
        if (this.C == null) {
            this.C = new ArrayList();
            this.D = new ArrayList();
        }
        this.f737b = false;
    }

    public final boolean w(boolean z8) {
        boolean z9;
        ArrayList arrayList;
        v(z8);
        boolean z10 = false;
        while (true) {
            ArrayList arrayList2 = this.C;
            ArrayList arrayList3 = this.D;
            synchronized (this.f736a) {
                try {
                    if (this.f736a.isEmpty()) {
                        z9 = false;
                    } else {
                        int size = this.f736a.size();
                        int i9 = 0;
                        z9 = false;
                        while (true) {
                            arrayList = this.f736a;
                            if (i9 >= size) {
                                break;
                            }
                            z9 |= ((f0) arrayList.get(i9)).a(arrayList2, arrayList3);
                            i9++;
                        }
                        arrayList.clear();
                        this.f748n.f873q.removeCallbacks(this.G);
                    }
                } finally {
                }
            }
            if (!z9) {
                break;
            }
            z10 = true;
            this.f737b = true;
            try {
                M(this.C, this.D);
            } finally {
                d();
            }
        }
        W();
        if (this.B) {
            this.B = false;
            V();
        }
        ((HashMap) this.f738c.f729k).values().removeAll(Collections.singleton(null));
        return z10;
    }

    public final void x(ArrayList arrayList, ArrayList arrayList2, int i9, int i10) {
        ViewGroup viewGroup;
        boolean z8;
        int i11;
        boolean z9;
        int i12;
        int i13;
        g gVar = this.f738c;
        boolean z10 = ((b) arrayList.get(i9)).f691o;
        ArrayList arrayList3 = this.E;
        if (arrayList3 == null) {
            this.E = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.E.addAll(gVar.T());
        s sVar = this.f751q;
        int i14 = i9;
        boolean z11 = false;
        while (true) {
            int i15 = 1;
            if (i14 >= i10) {
                boolean z12 = z10;
                this.E.clear();
                if (!z12 && this.f747m >= 1) {
                    for (int i16 = i9; i16 < i10; i16++) {
                        ArrayList arrayList4 = ((b) arrayList.get(i16)).f678a;
                        int size = arrayList4.size();
                        int i17 = 0;
                        while (i17 < size) {
                            Object obj = arrayList4.get(i17);
                            i17++;
                            s sVar2 = ((o0) obj).f817b;
                            if (sVar2 != null && sVar2.f859z != null) {
                                gVar.d0(f(sVar2));
                            }
                        }
                    }
                }
                for (int i18 = i9; i18 < i10; i18++) {
                    b bVar = (b) arrayList.get(i18);
                    if (((Boolean) arrayList2.get(i18)).booleanValue()) {
                        bVar.c(-1);
                        h0 h0Var = bVar.f692p;
                        ArrayList arrayList5 = bVar.f678a;
                        int size2 = arrayList5.size() - 1;
                        while (true) {
                            if (size2 < 0) {
                                break;
                            }
                            o0 o0Var = (o0) arrayList5.get(size2);
                            s sVar3 = o0Var.f817b;
                            if (sVar3 != null) {
                                if (sVar3.P != null) {
                                    sVar3.d().f827a = true;
                                }
                                int i19 = bVar.f683f;
                                int i20 = i19 != 4097 ? i19 != 4099 ? i19 != 8194 ? 0 : 4097 : 4099 : 8194;
                                if (sVar3.P != null || i20 != 0) {
                                    sVar3.d();
                                    sVar3.P.f832f = i20;
                                }
                                sVar3.d();
                                sVar3.P.getClass();
                            }
                            switch (o0Var.f816a) {
                                case 1:
                                    sVar3.y(o0Var.f818c, o0Var.f819d, o0Var.f820e, o0Var.f821f);
                                    h0Var.Q(sVar3, true);
                                    h0Var.L(sVar3);
                                    break;
                                case 2:
                                default:
                                    a.d(o0Var.f816a, "Unknown cmd: ");
                                    continue;
                                case 3:
                                    sVar3.y(o0Var.f818c, o0Var.f819d, o0Var.f820e, o0Var.f821f);
                                    h0Var.a(sVar3);
                                    break;
                                case 4:
                                    sVar3.y(o0Var.f818c, o0Var.f819d, o0Var.f820e, o0Var.f821f);
                                    h0Var.getClass();
                                    U(sVar3);
                                    break;
                                case 5:
                                    sVar3.y(o0Var.f818c, o0Var.f819d, o0Var.f820e, o0Var.f821f);
                                    h0Var.Q(sVar3, true);
                                    h0Var.C(sVar3);
                                    break;
                                case 6:
                                    sVar3.y(o0Var.f818c, o0Var.f819d, o0Var.f820e, o0Var.f821f);
                                    h0Var.c(sVar3);
                                    break;
                                case 7:
                                    sVar3.y(o0Var.f818c, o0Var.f819d, o0Var.f820e, o0Var.f821f);
                                    h0Var.Q(sVar3, true);
                                    h0Var.g(sVar3);
                                    break;
                                case 8:
                                    h0Var.S(null);
                                    break;
                                case 9:
                                    h0Var.S(sVar3);
                                    break;
                                case 10:
                                    h0Var.R(sVar3, o0Var.f822g);
                                    break;
                            }
                            size2--;
                        }
                    } else {
                        bVar.c(1);
                        h0 h0Var2 = bVar.f692p;
                        ArrayList arrayList6 = bVar.f678a;
                        int size3 = arrayList6.size();
                        int i21 = 0;
                        while (true) {
                            if (i21 >= size3) {
                                break;
                            }
                            o0 o0Var2 = (o0) arrayList6.get(i21);
                            s sVar4 = o0Var2.f817b;
                            if (sVar4 != null) {
                                if (sVar4.P != null) {
                                    sVar4.d().f827a = false;
                                }
                                int i22 = bVar.f683f;
                                if (sVar4.P != null || i22 != 0) {
                                    sVar4.d();
                                    sVar4.P.f832f = i22;
                                }
                                sVar4.d();
                                sVar4.P.getClass();
                            }
                            switch (o0Var2.f816a) {
                                case 1:
                                    sVar4.y(o0Var2.f818c, o0Var2.f819d, o0Var2.f820e, o0Var2.f821f);
                                    h0Var2.Q(sVar4, false);
                                    h0Var2.a(sVar4);
                                    break;
                                case 2:
                                default:
                                    a.d(o0Var2.f816a, "Unknown cmd: ");
                                    continue;
                                case 3:
                                    sVar4.y(o0Var2.f818c, o0Var2.f819d, o0Var2.f820e, o0Var2.f821f);
                                    h0Var2.L(sVar4);
                                    break;
                                case 4:
                                    sVar4.y(o0Var2.f818c, o0Var2.f819d, o0Var2.f820e, o0Var2.f821f);
                                    h0Var2.C(sVar4);
                                    break;
                                case 5:
                                    sVar4.y(o0Var2.f818c, o0Var2.f819d, o0Var2.f820e, o0Var2.f821f);
                                    h0Var2.Q(sVar4, false);
                                    U(sVar4);
                                    break;
                                case 6:
                                    sVar4.y(o0Var2.f818c, o0Var2.f819d, o0Var2.f820e, o0Var2.f821f);
                                    h0Var2.g(sVar4);
                                    break;
                                case 7:
                                    sVar4.y(o0Var2.f818c, o0Var2.f819d, o0Var2.f820e, o0Var2.f821f);
                                    h0Var2.Q(sVar4, false);
                                    h0Var2.c(sVar4);
                                    break;
                                case 8:
                                    h0Var2.S(sVar4);
                                    break;
                                case 9:
                                    h0Var2.S(null);
                                    break;
                                case 10:
                                    h0Var2.R(sVar4, o0Var2.h);
                                    break;
                            }
                            i21++;
                        }
                    }
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i10 - 1)).booleanValue();
                for (int i23 = i9; i23 < i10; i23++) {
                    b bVar2 = (b) arrayList.get(i23);
                    if (booleanValue) {
                        for (int size4 = bVar2.f678a.size() - 1; size4 >= 0; size4--) {
                            s sVar5 = ((o0) bVar2.f678a.get(size4)).f817b;
                            if (sVar5 != null) {
                                f(sVar5).k();
                            }
                        }
                    } else {
                        ArrayList arrayList7 = bVar2.f678a;
                        int size5 = arrayList7.size();
                        int i24 = 0;
                        while (i24 < size5) {
                            Object obj2 = arrayList7.get(i24);
                            i24++;
                            s sVar6 = ((o0) obj2).f817b;
                            if (sVar6 != null) {
                                f(sVar6).k();
                            }
                        }
                    }
                }
                H(this.f747m, true);
                HashSet hashSet = new HashSet();
                for (int i25 = i9; i25 < i10; i25++) {
                    ArrayList arrayList8 = ((b) arrayList.get(i25)).f678a;
                    int size6 = arrayList8.size();
                    int i26 = 0;
                    while (i26 < size6) {
                        Object obj3 = arrayList8.get(i26);
                        i26++;
                        s sVar7 = ((o0) obj3).f817b;
                        if (sVar7 != null && (viewGroup = sVar7.L) != null) {
                            hashSet.add(k.f(viewGroup, B()));
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    k kVar = (k) it.next();
                    kVar.f779d = booleanValue;
                    synchronized (kVar.f777b) {
                        try {
                            kVar.g();
                            kVar.f780e = false;
                            int size7 = kVar.f777b.size() - 1;
                            while (true) {
                                if (size7 >= 0) {
                                    s0 s0Var = (s0) kVar.f777b.get(size7);
                                    int c9 = androidx.activity.g.c(s0Var.f862c.M);
                                    if (s0Var.f860a != 2 || c9 == 2) {
                                        size7--;
                                    } else {
                                        s0Var.f862c.getClass();
                                        kVar.f780e = false;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    kVar.c();
                }
                for (int i27 = i9; i27 < i10; i27++) {
                    b bVar3 = (b) arrayList.get(i27);
                    if (((Boolean) arrayList2.get(i27)).booleanValue() && bVar3.f694r >= 0) {
                        bVar3.f694r = -1;
                    }
                    bVar3.getClass();
                }
                return;
            }
            b bVar4 = (b) arrayList.get(i14);
            boolean booleanValue2 = ((Boolean) arrayList2.get(i14)).booleanValue();
            ArrayList arrayList9 = this.E;
            if (booleanValue2) {
                z8 = z10;
                i11 = i14;
                int i28 = 1;
                ArrayList arrayList10 = bVar4.f678a;
                int size8 = arrayList10.size() - 1;
                while (size8 >= 0) {
                    o0 o0Var3 = (o0) arrayList10.get(size8);
                    int i29 = o0Var3.f816a;
                    if (i29 != i28) {
                        if (i29 != 3) {
                            switch (i29) {
                                case 8:
                                    sVar = null;
                                    break;
                                case 9:
                                    sVar = o0Var3.f817b;
                                    break;
                                case 10:
                                    o0Var3.h = o0Var3.f822g;
                                    break;
                            }
                            size8--;
                            i28 = 1;
                        }
                        arrayList9.add(o0Var3.f817b);
                        size8--;
                        i28 = 1;
                    }
                    arrayList9.remove(o0Var3.f817b);
                    size8--;
                    i28 = 1;
                }
            } else {
                ArrayList arrayList11 = bVar4.f678a;
                int i30 = 0;
                while (i30 < arrayList11.size()) {
                    o0 o0Var4 = (o0) arrayList11.get(i30);
                    int i31 = o0Var4.f816a;
                    if (i31 != i15) {
                        z9 = z10;
                        if (i31 != 2) {
                            if (i31 == 3 || i31 == 6) {
                                arrayList9.remove(o0Var4.f817b);
                                s sVar8 = o0Var4.f817b;
                                if (sVar8 == sVar) {
                                    arrayList11.add(i30, new o0(9, sVar8));
                                    i30++;
                                    i12 = i14;
                                    sVar = null;
                                }
                            } else if (i31 != 7) {
                                if (i31 == 8) {
                                    arrayList11.add(i30, new o0(9, sVar));
                                    i30++;
                                    sVar = o0Var4.f817b;
                                }
                            }
                            i12 = i14;
                        } else {
                            s sVar9 = o0Var4.f817b;
                            int i32 = sVar9.E;
                            int size9 = arrayList9.size() - 1;
                            boolean z13 = false;
                            while (size9 >= 0) {
                                int i33 = size9;
                                s sVar10 = (s) arrayList9.get(size9);
                                int i34 = i14;
                                if (sVar10.E == i32) {
                                    if (sVar10 == sVar9) {
                                        z13 = true;
                                    } else {
                                        if (sVar10 == sVar) {
                                            arrayList11.add(i30, new o0(9, sVar10));
                                            i30++;
                                            sVar = null;
                                        }
                                        o0 o0Var5 = new o0(3, sVar10);
                                        o0Var5.f818c = o0Var4.f818c;
                                        o0Var5.f820e = o0Var4.f820e;
                                        o0Var5.f819d = o0Var4.f819d;
                                        o0Var5.f821f = o0Var4.f821f;
                                        arrayList11.add(i30, o0Var5);
                                        arrayList9.remove(sVar10);
                                        i30++;
                                        sVar = sVar;
                                    }
                                }
                                size9 = i33 - 1;
                                i14 = i34;
                            }
                            i12 = i14;
                            if (z13) {
                                arrayList11.remove(i30);
                                i30--;
                            } else {
                                i13 = 1;
                                o0Var4.f816a = 1;
                                arrayList9.add(sVar9);
                                i30 += i13;
                                z10 = z9;
                                i14 = i12;
                                i15 = 1;
                            }
                        }
                        i13 = 1;
                        i30 += i13;
                        z10 = z9;
                        i14 = i12;
                        i15 = 1;
                    } else {
                        z9 = z10;
                    }
                    i12 = i14;
                    i13 = 1;
                    arrayList9.add(o0Var4.f817b);
                    i30 += i13;
                    z10 = z9;
                    i14 = i12;
                    i15 = 1;
                }
                z8 = z10;
                i11 = i14;
            }
            z11 = z11 || bVar4.f684g;
            i14 = i11 + 1;
            z10 = z8;
        }
    }

    public final s y(int i9) {
        g gVar = this.f738c;
        ArrayList arrayList = (ArrayList) gVar.f728j;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            s sVar = (s) arrayList.get(size);
            if (sVar != null && sVar.D == i9) {
                return sVar;
            }
        }
        for (n0 n0Var : ((HashMap) gVar.f729k).values()) {
            if (n0Var != null) {
                s sVar2 = n0Var.f802c;
                if (sVar2.D == i9) {
                    return sVar2;
                }
            }
        }
        return null;
    }

    public final ViewGroup z(s sVar) {
        ViewGroup viewGroup = sVar.L;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (sVar.E <= 0 || !this.f749o.f0()) {
            return null;
        }
        View e02 = this.f749o.e0(sVar.E);
        if (e02 instanceof ViewGroup) {
            return (ViewGroup) e02;
        }
        return null;
    }
}
