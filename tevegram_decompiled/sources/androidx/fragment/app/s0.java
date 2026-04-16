package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public int f860a;

    /* renamed from: b, reason: collision with root package name */
    public int f861b;

    /* renamed from: c, reason: collision with root package name */
    public final s f862c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f863d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f864e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f865f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f866g;
    public final n0 h;

    public s0(int i9, int i10, n0 n0Var, j0.d dVar) {
        s sVar = n0Var.f802c;
        this.f863d = new ArrayList();
        this.f864e = new HashSet();
        this.f865f = false;
        this.f866g = false;
        this.f860a = i9;
        this.f861b = i10;
        this.f862c = sVar;
        dVar.a(new a0.b(this, 8));
        this.h = n0Var;
    }

    public final void a() {
        HashSet hashSet = this.f864e;
        if (this.f865f) {
            return;
        }
        this.f865f = true;
        if (hashSet.isEmpty()) {
            b();
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            j0.d dVar = (j0.d) obj;
            synchronized (dVar) {
                try {
                    if (!dVar.f5337a) {
                        dVar.f5337a = true;
                        dVar.f5339c = true;
                        j0.c cVar = dVar.f5338b;
                        if (cVar != null) {
                            try {
                                cVar.onCancel();
                            } catch (Throwable th) {
                                synchronized (dVar) {
                                    dVar.f5339c = false;
                                    dVar.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (dVar) {
                            dVar.f5339c = false;
                            dVar.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final void b() {
        if (!this.f866g) {
            if (h0.D(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f866g = true;
            ArrayList arrayList = this.f863d;
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                ((Runnable) obj).run();
            }
        }
        this.h.k();
    }

    public final void c(int i9, int i10) {
        int a9 = v.h.a(i10);
        s sVar = this.f862c;
        if (a9 == 0) {
            if (this.f860a != 1) {
                if (h0.D(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + sVar + " mFinalState = " + androidx.activity.g.B(this.f860a) + " -> " + androidx.activity.g.B(i9) + ". ");
                }
                this.f860a = i9;
                return;
            }
            return;
        }
        if (a9 == 1) {
            if (this.f860a == 1) {
                if (h0.D(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + sVar + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + androidx.activity.g.A(this.f861b) + " to ADDING.");
                }
                this.f860a = 2;
                this.f861b = 2;
                return;
            }
            return;
        }
        if (a9 != 2) {
            return;
        }
        if (h0.D(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + sVar + " mFinalState = " + androidx.activity.g.B(this.f860a) + " -> REMOVED. mLifecycleImpact  = " + androidx.activity.g.A(this.f861b) + " to REMOVING.");
        }
        this.f860a = 1;
        this.f861b = 3;
    }

    public final void d() {
        if (this.f861b == 2) {
            n0 n0Var = this.h;
            s sVar = n0Var.f802c;
            View findFocus = sVar.M.findFocus();
            if (findFocus != null) {
                sVar.d().f836k = findFocus;
                if (h0.D(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + sVar);
                }
            }
            View x6 = this.f862c.x();
            if (x6.getParent() == null) {
                n0Var.b();
                x6.setAlpha(0.0f);
            }
            if (x6.getAlpha() == 0.0f && x6.getVisibility() == 0) {
                x6.setVisibility(4);
            }
            q qVar = sVar.P;
            x6.setAlpha(qVar == null ? 1.0f : qVar.f835j);
        }
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + androidx.activity.g.B(this.f860a) + "} {mLifecycleImpact = " + androidx.activity.g.A(this.f861b) + "} {mFragment = " + this.f862c + "}";
    }
}
