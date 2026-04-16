package androidx.activity;

import androidx.fragment.app.a0;
import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ListIterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q extends b8.j implements a8.a {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f315j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f316k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, int i9) {
        super(0);
        this.f315j = i9;
        this.f316k = obj;
    }

    @Override // a8.a
    public final Object d() {
        Object obj;
        switch (this.f315j) {
            case 0:
                ((x) this.f316k).b();
                return n7.g.f7490c;
            case 1:
                x xVar = (x) this.f316k;
                o7.e eVar = xVar.f355b;
                ListIterator listIterator = eVar.listIterator(eVar.f8010k);
                while (true) {
                    if (listIterator.hasPrevious()) {
                        obj = listIterator.previous();
                        if (((a0) obj).f674a) {
                        }
                    } else {
                        obj = null;
                    }
                }
                xVar.f356c = null;
                return n7.g.f7490c;
            case 2:
                ((x) this.f316k).b();
                return n7.g.f7490c;
            default:
                g.l lVar = (g.l) this.f316k;
                ArrayList arrayList = new ArrayList();
                b8.p.f1526a.getClass();
                arrayList.add(new b1.d(i0.class));
                b1.d[] dVarArr = (b1.d[]) arrayList.toArray(new b1.d[0]);
                b1.d[] dVarArr2 = (b1.d[]) Arrays.copyOf(dVarArr, dVarArr.length);
                l0 f9 = lVar.f();
                b1.b c9 = lVar.c();
                f9.getClass();
                c9.getClass();
                LinkedHashMap linkedHashMap = f9.f927a;
                j0 j0Var = (j0) linkedHashMap.get("androidx.lifecycle.internal.SavedStateHandlesVM");
                if (i0.class.isInstance(j0Var)) {
                    j0Var.getClass();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.putAll((LinkedHashMap) c9.f1132i);
                    linkedHashMap2.put(k0.f926b, "androidx.lifecycle.internal.SavedStateHandlesVM");
                    try {
                        j0Var = null;
                        for (b1.d dVar : dVarArr2) {
                            if (dVar.f1133a.equals(i0.class)) {
                                j0Var = new i0();
                            }
                        }
                        if (j0Var == null) {
                            throw new IllegalArgumentException("No initializer set for given class ".concat(i0.class.getName()));
                        }
                        j0 j0Var2 = (j0) linkedHashMap.put("androidx.lifecycle.internal.SavedStateHandlesVM", j0Var);
                        if (j0Var2 != null) {
                            j0Var2.a();
                        }
                    } catch (AbstractMethodError unused) {
                        androidx.fragment.app.a.h("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
                        return null;
                    }
                }
                return (i0) j0Var;
        }
    }
}
