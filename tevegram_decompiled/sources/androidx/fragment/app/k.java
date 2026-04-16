package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f776a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f777b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f778c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f779d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f780e = false;

    public k(ViewGroup viewGroup) {
        this.f776a = viewGroup;
    }

    public static k f(ViewGroup viewGroup, u5.e eVar) {
        Object tag = viewGroup.getTag(2131362370);
        if (tag instanceof k) {
            return (k) tag;
        }
        eVar.getClass();
        k kVar = new k(viewGroup);
        viewGroup.setTag(2131362370, kVar);
        return kVar;
    }

    public final void a(int i9, int i10, n0 n0Var) {
        synchronized (this.f777b) {
            try {
                j0.d dVar = new j0.d();
                s0 d9 = d(n0Var.f802c);
                if (d9 != null) {
                    d9.c(i9, i10);
                    return;
                }
                s0 s0Var = new s0(i9, i10, n0Var, dVar);
                this.f777b.add(s0Var);
                s0Var.f863d.add(new r0(this, s0Var, 0));
                s0Var.f863d.add(new r0(this, s0Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(ArrayList arrayList, boolean z8) {
        int i9;
        boolean z9;
        ViewGroup viewGroup;
        int size = arrayList.size();
        boolean z10 = false;
        s0 s0Var = null;
        s0 s0Var2 = null;
        int i10 = 0;
        while (true) {
            i9 = 2;
            if (i10 >= size) {
                break;
            }
            Object obj = arrayList.get(i10);
            i10++;
            s0 s0Var3 = (s0) obj;
            int c9 = androidx.activity.g.c(s0Var3.f862c.M);
            int a9 = v.h.a(s0Var3.f860a);
            if (a9 != 0) {
                if (a9 != 1) {
                    if (a9 != 2 && a9 != 3) {
                    }
                } else if (c9 != 2) {
                    s0Var2 = s0Var3;
                }
            }
            if (c9 == 2 && s0Var == null) {
                s0Var = s0Var3;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList(arrayList);
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList.get(i11);
            i11++;
            s0 s0Var4 = (s0) obj2;
            j0.d dVar = new j0.d();
            s0Var4.d();
            HashSet hashSet = s0Var4.f864e;
            hashSet.add(dVar);
            h hVar = new h(s0Var4, dVar);
            hVar.f734l = z10;
            hVar.f733k = z8;
            arrayList2.add(hVar);
            j0.d dVar2 = new j0.d();
            s0Var4.d();
            hashSet.add(dVar2);
            boolean z11 = !z8 ? s0Var4 != s0Var2 : s0Var4 != s0Var;
            j jVar = new j(s0Var4, dVar2);
            int i12 = s0Var4.f860a;
            s sVar = s0Var4.f862c;
            if (i12 == 2) {
                if (z8) {
                    sVar.getClass();
                } else {
                    sVar.getClass();
                }
                if (z8) {
                    sVar.getClass();
                } else {
                    sVar.getClass();
                }
            } else if (z8) {
                sVar.getClass();
            } else {
                sVar.getClass();
            }
            if (z11) {
                if (z8) {
                    sVar.getClass();
                } else {
                    sVar.getClass();
                }
            }
            arrayList3.add(jVar);
            s0Var4.f863d.add(new d(this, arrayList4, s0Var4));
            z10 = false;
        }
        HashMap hashMap = new HashMap();
        int size3 = arrayList3.size();
        int i13 = 0;
        while (i13 < size3) {
            Object obj3 = arrayList3.get(i13);
            i13++;
            s0 s0Var5 = (s0) ((j) obj3).f761i;
            androidx.activity.g.c(s0Var5.f862c.M);
            int i14 = s0Var5.f860a;
        }
        int size4 = arrayList3.size();
        int i15 = 0;
        while (i15 < size4) {
            Object obj4 = arrayList3.get(i15);
            i15++;
            j jVar2 = (j) obj4;
            hashMap.put((s0) jVar2.f761i, Boolean.FALSE);
            jVar2.d();
        }
        boolean containsValue = hashMap.containsValue(Boolean.TRUE);
        ViewGroup viewGroup2 = this.f776a;
        Context context = viewGroup2.getContext();
        ArrayList arrayList5 = new ArrayList();
        int size5 = arrayList2.size();
        boolean z12 = false;
        int i16 = 0;
        while (i16 < size5) {
            Object obj5 = arrayList2.get(i16);
            i16++;
            h hVar2 = (h) obj5;
            s0 s0Var6 = (s0) hVar2.f761i;
            int c10 = androidx.activity.g.c(s0Var6.f862c.M);
            int i17 = s0Var6.f860a;
            if (c10 == i17 || !(c10 == i9 || i17 == i9)) {
                z9 = containsValue;
                viewGroup = viewGroup2;
                hVar2.d();
            } else {
                a5.d o8 = hVar2.o(context);
                if (o8 == null) {
                    hVar2.d();
                } else {
                    Animator animator = (Animator) o8.f175k;
                    if (animator == null) {
                        arrayList5.add(hVar2);
                    } else {
                        s0 s0Var7 = (s0) hVar2.f761i;
                        s sVar2 = s0Var7.f862c;
                        z9 = containsValue;
                        if (Boolean.TRUE.equals(hashMap.get(s0Var7))) {
                            if (h0.D(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + sVar2 + " as this Fragment was involved in a Transition.");
                            }
                            hVar2.d();
                            viewGroup = viewGroup2;
                        } else {
                            boolean z13 = s0Var7.f860a == 3;
                            if (z13) {
                                arrayList4.remove(s0Var7);
                            }
                            View view = sVar2.M;
                            viewGroup2.startViewTransition(view);
                            ViewGroup viewGroup3 = viewGroup2;
                            animator.addListener(new e(viewGroup3, view, z13, s0Var7, hVar2));
                            animator.setTarget(view);
                            animator.start();
                            ((j0.d) hVar2.f762j).a(new a0.b(animator, 5));
                            containsValue = z9;
                            viewGroup2 = viewGroup3;
                            z12 = true;
                            i9 = 2;
                        }
                    }
                }
                z9 = containsValue;
                viewGroup = viewGroup2;
            }
            containsValue = z9;
            viewGroup2 = viewGroup;
            i9 = 2;
        }
        boolean z14 = containsValue;
        ViewGroup viewGroup4 = viewGroup2;
        int size6 = arrayList5.size();
        int i18 = 0;
        while (i18 < size6) {
            Object obj6 = arrayList5.get(i18);
            i18++;
            h hVar3 = (h) obj6;
            s0 s0Var8 = (s0) hVar3.f761i;
            s sVar3 = s0Var8.f862c;
            if (z14) {
                if (h0.D(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + sVar3 + " as Animations cannot run alongside Transitions.");
                }
                hVar3.d();
            } else if (z12) {
                if (h0.D(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + sVar3 + " as Animations cannot run alongside Animators.");
                }
                hVar3.d();
            } else {
                View view2 = sVar3.M;
                a5.d o9 = hVar3.o(context);
                o9.getClass();
                Animation animation = (Animation) o9.f174j;
                animation.getClass();
                if (s0Var8.f860a != 1) {
                    view2.startAnimation(animation);
                    hVar3.d();
                } else {
                    viewGroup4.startViewTransition(view2);
                    w wVar = new w(animation, viewGroup4, view2);
                    wVar.setAnimationListener(new f(viewGroup4, view2, hVar3));
                    view2.startAnimation(wVar);
                }
                ((j0.d) hVar3.f762j).a(new g(view2, viewGroup4, hVar3, 0));
            }
        }
        int size7 = arrayList4.size();
        int i19 = 0;
        while (i19 < size7) {
            Object obj7 = arrayList4.get(i19);
            i19++;
            s0 s0Var9 = (s0) obj7;
            androidx.activity.g.a(s0Var9.f862c.M, s0Var9.f860a);
        }
        arrayList4.clear();
    }

    public final void c() {
        if (this.f780e) {
            return;
        }
        ViewGroup viewGroup = this.f776a;
        WeakHashMap weakHashMap = n0.t0.f7209a;
        if (!n0.f0.b(viewGroup)) {
            e();
            this.f779d = false;
            return;
        }
        synchronized (this.f777b) {
            try {
                if (!this.f777b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f778c);
                    this.f778c.clear();
                    int size = arrayList.size();
                    int i9 = 0;
                    while (i9 < size) {
                        Object obj = arrayList.get(i9);
                        i9++;
                        s0 s0Var = (s0) obj;
                        if (h0.D(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + s0Var);
                        }
                        s0Var.a();
                        if (!s0Var.f866g) {
                            this.f778c.add(s0Var);
                        }
                    }
                    g();
                    ArrayList arrayList2 = new ArrayList(this.f777b);
                    this.f777b.clear();
                    this.f778c.addAll(arrayList2);
                    int size2 = arrayList2.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        Object obj2 = arrayList2.get(i10);
                        i10++;
                        ((s0) obj2).d();
                    }
                    b(arrayList2, this.f779d);
                    this.f779d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final s0 d(s sVar) {
        ArrayList arrayList = this.f777b;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            s0 s0Var = (s0) obj;
            if (s0Var.f862c.equals(sVar) && !s0Var.f865f) {
                return s0Var;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        ViewGroup viewGroup = this.f776a;
        WeakHashMap weakHashMap = n0.t0.f7209a;
        boolean b9 = n0.f0.b(viewGroup);
        synchronized (this.f777b) {
            try {
                g();
                ArrayList arrayList = this.f777b;
                int size = arrayList.size();
                int i9 = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((s0) obj).d();
                }
                ArrayList arrayList2 = new ArrayList(this.f778c);
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    s0 s0Var = (s0) obj2;
                    if (h0.D(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (b9) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f776a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(s0Var);
                        Log.v("FragmentManager", sb.toString());
                    }
                    s0Var.a();
                }
                ArrayList arrayList3 = new ArrayList(this.f777b);
                int size3 = arrayList3.size();
                while (i9 < size3) {
                    Object obj3 = arrayList3.get(i9);
                    i9++;
                    s0 s0Var2 = (s0) obj3;
                    if (h0.D(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (b9) {
                            str = "";
                        } else {
                            str = "Container " + this.f776a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(s0Var2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    s0Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.f777b;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            s0 s0Var = (s0) obj;
            if (s0Var.f861b == 2) {
                s0Var.c(androidx.activity.g.b(s0Var.f862c.x().getVisibility()), 1);
            }
        }
    }
}
