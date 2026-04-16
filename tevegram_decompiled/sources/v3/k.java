package v3;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import n0.a1;
import n0.c0;
import n0.i0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class k implements Cloneable {
    public static final int[] B = {2, 1, 3, 4};
    public static final o4.d C = new o4.d(17);
    public static final ThreadLocal D = new ThreadLocal();

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f9532s;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList f9533t;

    /* renamed from: i, reason: collision with root package name */
    public final String f9522i = getClass().getName();

    /* renamed from: j, reason: collision with root package name */
    public long f9523j = -1;

    /* renamed from: k, reason: collision with root package name */
    public long f9524k = -1;

    /* renamed from: l, reason: collision with root package name */
    public TimeInterpolator f9525l = null;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f9526m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f9527n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public a0.l f9528o = new a0.l(14);

    /* renamed from: p, reason: collision with root package name */
    public a0.l f9529p = new a0.l(14);

    /* renamed from: q, reason: collision with root package name */
    public a f9530q = null;

    /* renamed from: r, reason: collision with root package name */
    public final int[] f9531r = B;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f9534u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    public int f9535v = 0;

    /* renamed from: w, reason: collision with root package name */
    public boolean f9536w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f9537x = false;

    /* renamed from: y, reason: collision with root package name */
    public ArrayList f9538y = null;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList f9539z = new ArrayList();
    public o4.d A = C;

    public static void b(a0.l lVar, View view, q qVar) {
        s.d dVar = (s.d) lVar.f30i;
        s.d dVar2 = (s.d) lVar.f33l;
        SparseArray sparseArray = (SparseArray) lVar.f31j;
        s.g gVar = (s.g) lVar.f32k;
        dVar.put(view, qVar);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = t0.f7209a;
        String k3 = i0.k(view);
        if (k3 != null) {
            if (dVar2.containsKey(k3)) {
                dVar2.put(k3, null);
            } else {
                dVar2.put(k3, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (gVar.f8643i) {
                    gVar.d();
                }
                if (s.f.b(gVar.f8644j, gVar.f8646l, itemIdAtPosition) < 0) {
                    c0.r(view, true);
                    gVar.f(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) gVar.e(itemIdAtPosition, null);
                if (view2 != null) {
                    c0.r(view2, false);
                    gVar.f(itemIdAtPosition, null);
                }
            }
        }
    }

    public static s.d n() {
        ThreadLocal threadLocal = D;
        s.d dVar = (s.d) threadLocal.get();
        if (dVar != null) {
            return dVar;
        }
        s.d dVar2 = new s.d();
        threadLocal.set(dVar2);
        return dVar2;
    }

    public static boolean s(q qVar, q qVar2, String str) {
        Object obj = qVar.f9548a.get(str);
        Object obj2 = qVar2.f9548a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(o4.d dVar) {
        if (dVar == null) {
            this.A = C;
        } else {
            this.A = dVar;
        }
    }

    public void C(long j5) {
        this.f9523j = j5;
    }

    public final void D() {
        if (this.f9535v == 0) {
            ArrayList arrayList = this.f9538y;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f9538y.clone();
                int size = arrayList2.size();
                for (int i9 = 0; i9 < size; i9++) {
                    ((j) arrayList2.get(i9)).a();
                }
            }
            this.f9537x = false;
        }
        this.f9535v++;
    }

    public String E(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f9524k != -1) {
            str2 = str2 + "dur(" + this.f9524k + ") ";
        }
        if (this.f9523j != -1) {
            str2 = str2 + "dly(" + this.f9523j + ") ";
        }
        if (this.f9525l != null) {
            str2 = str2 + "interp(" + this.f9525l + ") ";
        }
        ArrayList arrayList = this.f9526m;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f9527n;
        if (size <= 0 && arrayList2.size() <= 0) {
            return str2;
        }
        String concat = str2.concat("tgts(");
        if (arrayList.size() > 0) {
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                if (i9 > 0) {
                    concat = concat.concat(", ");
                }
                concat = concat + arrayList.get(i9);
            }
        }
        if (arrayList2.size() > 0) {
            for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                if (i10 > 0) {
                    concat = concat.concat(", ");
                }
                concat = concat + arrayList2.get(i10);
            }
        }
        return concat.concat(")");
    }

    public void a(j jVar) {
        if (this.f9538y == null) {
            this.f9538y = new ArrayList();
        }
        this.f9538y.add(jVar);
    }

    public abstract void c(q qVar);

    public final void d(View view, boolean z8) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            q qVar = new q(view);
            if (z8) {
                f(qVar);
            } else {
                c(qVar);
            }
            qVar.f9550c.add(this);
            e(qVar);
            if (z8) {
                b(this.f9528o, view, qVar);
            } else {
                b(this.f9529p, view, qVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                d(viewGroup.getChildAt(i9), z8);
            }
        }
    }

    public abstract void f(q qVar);

    public final void g(ViewGroup viewGroup, boolean z8) {
        h(z8);
        ArrayList arrayList = this.f9526m;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f9527n;
        if (size <= 0 && arrayList2.size() <= 0) {
            d(viewGroup, z8);
            return;
        }
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i9)).intValue());
            if (findViewById != null) {
                q qVar = new q(findViewById);
                if (z8) {
                    f(qVar);
                } else {
                    c(qVar);
                }
                qVar.f9550c.add(this);
                e(qVar);
                if (z8) {
                    b(this.f9528o, findViewById, qVar);
                } else {
                    b(this.f9529p, findViewById, qVar);
                }
            }
        }
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            View view = (View) arrayList2.get(i10);
            q qVar2 = new q(view);
            if (z8) {
                f(qVar2);
            } else {
                c(qVar2);
            }
            qVar2.f9550c.add(this);
            e(qVar2);
            if (z8) {
                b(this.f9528o, view, qVar2);
            } else {
                b(this.f9529p, view, qVar2);
            }
        }
    }

    public final void h(boolean z8) {
        if (z8) {
            ((s.d) this.f9528o.f30i).clear();
            ((SparseArray) this.f9528o.f31j).clear();
            ((s.g) this.f9528o.f32k).b();
        } else {
            ((s.d) this.f9529p.f30i).clear();
            ((SparseArray) this.f9529p.f31j).clear();
            ((s.g) this.f9529p.f32k).b();
        }
    }

    @Override // 
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public k clone() {
        try {
            k kVar = (k) super.clone();
            kVar.f9539z = new ArrayList();
            kVar.f9528o = new a0.l(14);
            kVar.f9529p = new a0.l(14);
            kVar.f9532s = null;
            kVar.f9533t = null;
            return kVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator j(ViewGroup viewGroup, q qVar, q qVar2) {
        return null;
    }

    public void k(ViewGroup viewGroup, a0.l lVar, a0.l lVar2, ArrayList arrayList, ArrayList arrayList2) {
        Animator j5;
        int i9;
        int i10;
        View view;
        q qVar;
        Animator animator;
        s.d n4 = n();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            q qVar2 = (q) arrayList.get(i11);
            q qVar3 = (q) arrayList2.get(i11);
            q qVar4 = null;
            if (qVar2 != null && !qVar2.f9550c.contains(this)) {
                qVar2 = null;
            }
            if (qVar3 != null && !qVar3.f9550c.contains(this)) {
                qVar3 = null;
            }
            if (!(qVar2 == null && qVar3 == null) && ((qVar2 == null || qVar3 == null || q(qVar2, qVar3)) && (j5 = j(viewGroup, qVar2, qVar3)) != null)) {
                String str = this.f9522i;
                if (qVar3 != null) {
                    view = qVar3.f9549b;
                    String[] o8 = o();
                    if (o8 != null && o8.length > 0) {
                        qVar = new q(view);
                        q qVar5 = (q) ((s.d) lVar2.f30i).getOrDefault(view, null);
                        i9 = size;
                        if (qVar5 != null) {
                            int i12 = 0;
                            while (i12 < o8.length) {
                                String str2 = o8[i12];
                                qVar.f9548a.put(str2, qVar5.f9548a.get(str2));
                                i12++;
                                i11 = i11;
                                qVar5 = qVar5;
                            }
                        }
                        i10 = i11;
                        int i13 = n4.f8653k;
                        for (int i14 = 0; i14 < i13; i14++) {
                            i iVar = (i) n4.getOrDefault((Animator) n4.h(i14), null);
                            if (iVar.f9519c != null && iVar.f9517a == view && iVar.f9518b.equals(str) && iVar.f9519c.equals(qVar)) {
                                animator = null;
                                break;
                            }
                        }
                    } else {
                        i9 = size;
                        i10 = i11;
                        qVar = null;
                    }
                    animator = j5;
                    j5 = animator;
                    qVar4 = qVar;
                } else {
                    i9 = size;
                    i10 = i11;
                    view = qVar2.f9549b;
                }
                if (j5 != null) {
                    t tVar = r.f9551a;
                    a0 a0Var = new a0(viewGroup);
                    i iVar2 = new i();
                    iVar2.f9517a = view;
                    iVar2.f9518b = str;
                    iVar2.f9519c = qVar4;
                    iVar2.f9520d = a0Var;
                    iVar2.f9521e = this;
                    n4.put(j5, iVar2);
                    this.f9539z.add(j5);
                }
            } else {
                i9 = size;
                i10 = i11;
            }
            i11 = i10 + 1;
            size = i9;
        }
        if (sparseIntArray.size() != 0) {
            for (int i15 = 0; i15 < sparseIntArray.size(); i15++) {
                Animator animator2 = (Animator) this.f9539z.get(sparseIntArray.keyAt(i15));
                animator2.setStartDelay(animator2.getStartDelay() + (sparseIntArray.valueAt(i15) - Long.MAX_VALUE));
            }
        }
    }

    public final void l() {
        int i9 = this.f9535v - 1;
        this.f9535v = i9;
        if (i9 == 0) {
            ArrayList arrayList = this.f9538y;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f9538y.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((j) arrayList2.get(i10)).b(this);
                }
            }
            for (int i11 = 0; i11 < ((s.g) this.f9528o.f32k).g(); i11++) {
                View view = (View) ((s.g) this.f9528o.f32k).h(i11);
                if (view != null) {
                    WeakHashMap weakHashMap = t0.f7209a;
                    c0.r(view, false);
                }
            }
            for (int i12 = 0; i12 < ((s.g) this.f9529p.f32k).g(); i12++) {
                View view2 = (View) ((s.g) this.f9529p.f32k).h(i12);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = t0.f7209a;
                    c0.r(view2, false);
                }
            }
            this.f9537x = true;
        }
    }

    public final q m(View view, boolean z8) {
        a aVar = this.f9530q;
        if (aVar != null) {
            return aVar.m(view, z8);
        }
        ArrayList arrayList = z8 ? this.f9532s : this.f9533t;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size) {
                i9 = -1;
                break;
            }
            q qVar = (q) arrayList.get(i9);
            if (qVar == null) {
                return null;
            }
            if (qVar.f9549b == view) {
                break;
            }
            i9++;
        }
        if (i9 >= 0) {
            return (q) (z8 ? this.f9533t : this.f9532s).get(i9);
        }
        return null;
    }

    public String[] o() {
        return null;
    }

    public final q p(View view, boolean z8) {
        a aVar = this.f9530q;
        if (aVar != null) {
            return aVar.p(view, z8);
        }
        return (q) ((s.d) (z8 ? this.f9528o : this.f9529p).f30i).getOrDefault(view, null);
    }

    public boolean q(q qVar, q qVar2) {
        if (qVar != null && qVar2 != null) {
            String[] o8 = o();
            if (o8 != null) {
                for (String str : o8) {
                    if (s(qVar, qVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = qVar.f9548a.keySet().iterator();
                while (it.hasNext()) {
                    if (s(qVar, qVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean r(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f9526m;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f9527n;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public void t(View view) {
        if (this.f9537x) {
            return;
        }
        s.d n4 = n();
        int i9 = n4.f8653k;
        t tVar = r.f9551a;
        WindowId windowId = view.getWindowId();
        for (int i10 = i9 - 1; i10 >= 0; i10--) {
            i iVar = (i) n4.l(i10);
            if (iVar.f9517a != null && iVar.f9520d.f9504a.equals(windowId)) {
                ((Animator) n4.h(i10)).pause();
            }
        }
        ArrayList arrayList = this.f9538y;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f9538y.clone();
            int size = arrayList2.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((j) arrayList2.get(i11)).c();
            }
        }
        this.f9536w = true;
    }

    public final String toString() {
        return E("");
    }

    public void u(j jVar) {
        ArrayList arrayList = this.f9538y;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(jVar);
        if (this.f9538y.size() == 0) {
            this.f9538y = null;
        }
    }

    public void v(View view) {
        if (this.f9536w) {
            if (!this.f9537x) {
                s.d n4 = n();
                int i9 = n4.f8653k;
                t tVar = r.f9551a;
                WindowId windowId = view.getWindowId();
                for (int i10 = i9 - 1; i10 >= 0; i10--) {
                    i iVar = (i) n4.l(i10);
                    if (iVar.f9517a != null && iVar.f9520d.f9504a.equals(windowId)) {
                        ((Animator) n4.h(i10)).resume();
                    }
                }
                ArrayList arrayList = this.f9538y;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f9538y.clone();
                    int size = arrayList2.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((j) arrayList2.get(i11)).d();
                    }
                }
            }
            this.f9536w = false;
        }
    }

    public void w() {
        D();
        s.d n4 = n();
        ArrayList arrayList = this.f9539z;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            Animator animator = (Animator) obj;
            if (n4.containsKey(animator)) {
                D();
                if (animator != null) {
                    animator.addListener(new a1(this, n4));
                    long j5 = this.f9524k;
                    if (j5 >= 0) {
                        animator.setDuration(j5);
                    }
                    long j9 = this.f9523j;
                    if (j9 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j9);
                    }
                    TimeInterpolator timeInterpolator = this.f9525l;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new b5.a(this, 2));
                    animator.start();
                }
            }
        }
        this.f9539z.clear();
        l();
    }

    public void x(long j5) {
        this.f9524k = j5;
    }

    public void z(TimeInterpolator timeInterpolator) {
        this.f9525l = timeInterpolator;
    }

    public void B() {
    }

    public void e(q qVar) {
    }

    public void y(com.bumptech.glide.c cVar) {
    }
}
