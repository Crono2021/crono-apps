package o3;

import android.database.Observable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h0 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            RecyclerView recyclerView = ((v0) ((Observable) this).mObservers.get(size)).f7826a;
            recyclerView.i(null);
            recyclerView.f1067o0.f7873f = true;
            recyclerView.V(true);
            if (!recyclerView.f1062m.j()) {
                recyclerView.requestLayout();
            }
        }
    }

    public final void c(int i9, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            v0 v0Var = (v0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = v0Var.f7826a;
            recyclerView.i(null);
            n.o oVar = recyclerView.f1062m;
            ArrayList arrayList = (ArrayList) oVar.f6985c;
            if (i9 != i10) {
                arrayList.add(oVar.l(null, 8, i9, i10));
                oVar.f6983a |= 8;
                if (arrayList.size() == 1) {
                    v0Var.a();
                }
            }
        }
    }

    public final void d(int i9, int i10, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            v0 v0Var = (v0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = v0Var.f7826a;
            recyclerView.i(null);
            n.o oVar = recyclerView.f1062m;
            ArrayList arrayList = (ArrayList) oVar.f6985c;
            if (i10 >= 1) {
                arrayList.add(oVar.l(obj, 4, i9, i10));
                oVar.f6983a = 4 | oVar.f6983a;
                if (arrayList.size() == 1) {
                    v0Var.a();
                }
            }
        }
    }

    public final void e(int i9, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            v0 v0Var = (v0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = v0Var.f7826a;
            recyclerView.i(null);
            n.o oVar = recyclerView.f1062m;
            ArrayList arrayList = (ArrayList) oVar.f6985c;
            if (i10 >= 1) {
                arrayList.add(oVar.l(null, 1, i9, i10));
                oVar.f6983a |= 1;
                if (arrayList.size() == 1) {
                    v0Var.a();
                }
            }
        }
    }

    public final void f(int i9, int i10) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            v0 v0Var = (v0) ((Observable) this).mObservers.get(size);
            RecyclerView recyclerView = v0Var.f7826a;
            recyclerView.i(null);
            n.o oVar = recyclerView.f1062m;
            ArrayList arrayList = (ArrayList) oVar.f6985c;
            if (i10 >= 1) {
                arrayList.add(oVar.l(null, 2, i9, i10));
                oVar.f6983a |= 2;
                if (arrayList.size() == 1) {
                    v0Var.a();
                }
            }
        }
    }
}
