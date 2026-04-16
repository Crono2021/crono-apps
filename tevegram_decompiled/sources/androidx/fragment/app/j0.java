package androidx.fragment.app;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j0 extends androidx.lifecycle.j0 {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f774f;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f771c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f772d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f773e = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public boolean f775g = false;
    public boolean h = false;

    public j0(boolean z8) {
        this.f774f = z8;
    }

    @Override // androidx.lifecycle.j0
    public final void a() {
        if (h0.D(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f775g = true;
    }

    public final void b(s sVar) {
        if (this.h) {
            if (h0.D(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f771c.remove(sVar.f846m) == null || !h0.D(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + sVar);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j0.class == obj.getClass()) {
            j0 j0Var = (j0) obj;
            if (this.f771c.equals(j0Var.f771c) && this.f772d.equals(j0Var.f772d) && this.f773e.equals(j0Var.f773e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f773e.hashCode() + ((this.f772d.hashCode() + (this.f771c.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f771c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f772d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f773e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
