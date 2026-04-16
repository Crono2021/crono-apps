package v3;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q {

    /* renamed from: b, reason: collision with root package name */
    public final View f9549b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f9548a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f9550c = new ArrayList();

    public q(View view) {
        this.f9549b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f9549b == qVar.f9549b && this.f9548a.equals(qVar.f9548a);
    }

    public final int hashCode() {
        return this.f9548a.hashCode() + (this.f9549b.hashCode() * 31);
    }

    public final String toString() {
        String concat = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f9549b + "\n").concat("    values:");
        HashMap hashMap = this.f9548a;
        for (String str : hashMap.keySet()) {
            concat = concat + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return concat;
    }
}
