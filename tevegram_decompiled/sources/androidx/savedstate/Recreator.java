package androidx.savedstate;

import android.os.Bundle;
import androidx.activity.g;
import androidx.fragment.app.t;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.i;
import androidx.lifecycle.j0;
import androidx.lifecycle.l;
import androidx.lifecycle.l0;
import androidx.lifecycle.m0;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m7.c;
import p3.b;
import p3.d;
import t.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class Recreator implements q {

    /* renamed from: i, reason: collision with root package name */
    public final d f1101i;

    public Recreator(d dVar) {
        this.f1101i = dVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, l lVar) {
        Object obj;
        boolean z8;
        if (lVar != l.ON_CREATE) {
            c.e("Next event must be ON_CREATE");
            return;
        }
        sVar.g().f(this);
        Bundle c9 = this.f1101i.a().c("androidx.savedstate.Restarter");
        if (c9 == null) {
            return;
        }
        ArrayList<String> stringArrayList = c9.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            c.p("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            return;
        }
        int size = stringArrayList.size();
        int i9 = 0;
        while (i9 < size) {
            String str = stringArrayList.get(i9);
            i9++;
            String str2 = str;
            try {
                Class<? extends U> asSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(b.class);
                asSubclass.getClass();
                try {
                    Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object newInstance = declaredConstructor.newInstance(null);
                        newInstance.getClass();
                        d dVar = this.f1101i;
                        if (!(dVar instanceof m0)) {
                            c.p("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                            return;
                        }
                        l0 f9 = ((m0) dVar).f();
                        n.s a9 = dVar.a();
                        f9.getClass();
                        Iterator it = new HashSet(f9.f927a.keySet()).iterator();
                        while (it.hasNext()) {
                            String str3 = (String) it.next();
                            str3.getClass();
                            j0 j0Var = (j0) f9.f927a.get(str3);
                            j0Var.getClass();
                            u g9 = dVar.g();
                            a9.getClass();
                            g9.getClass();
                            HashMap hashMap = j0Var.f922a;
                            if (hashMap == null) {
                                obj = null;
                            } else {
                                synchronized (hashMap) {
                                    obj = j0Var.f922a.get("androidx.lifecycle.savedstate.vm.tag");
                                }
                            }
                            SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
                            if (savedStateHandleController != null && !(z8 = savedStateHandleController.f894i)) {
                                if (z8) {
                                    c.p("Already attached to lifecycleOwner");
                                    return;
                                } else {
                                    savedStateHandleController.f894i = true;
                                    g9.a(savedStateHandleController);
                                    throw null;
                                }
                            }
                        }
                        if (!new HashSet(f9.f927a.keySet()).isEmpty()) {
                            if (!a9.f7029e) {
                                c.p("Can not perform this action after onSaveInstanceState");
                                return;
                            }
                            t tVar = (t) a9.f7026b;
                            if (tVar == null) {
                                tVar = new t(a9);
                            }
                            a9.f7026b = tVar;
                            try {
                                i.class.getDeclaredConstructor(null);
                                t tVar2 = (t) a9.f7026b;
                                if (tVar2 != null) {
                                    ((LinkedHashSet) tVar2.f868b).add(i.class.getName());
                                }
                            } catch (NoSuchMethodException e9) {
                                throw new IllegalArgumentException("Class " + i.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e9);
                            }
                        }
                    } catch (Exception e10) {
                        c.k(a.b("Failed to instantiate ", str2), e10);
                        return;
                    }
                } catch (NoSuchMethodException e11) {
                    throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
                }
            } catch (ClassNotFoundException e12) {
                c.k(g.n("Class ", str2, " wasn't found"), e12);
                return;
            }
        }
    }
}
