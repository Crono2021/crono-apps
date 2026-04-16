package d1;

import android.util.SparseBooleanArray;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f2516a;

    public q(SparseBooleanArray sparseBooleanArray) {
        this.f2516a = sparseBooleanArray;
    }

    public final int a(int i9) {
        SparseBooleanArray sparseBooleanArray = this.f2516a;
        g1.a.i(i9, sparseBooleanArray.size());
        return sparseBooleanArray.keyAt(i9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        SparseBooleanArray sparseBooleanArray = qVar.f2516a;
        int i9 = g1.w.f3713a;
        SparseBooleanArray sparseBooleanArray2 = this.f2516a;
        if (i9 >= 24) {
            return sparseBooleanArray2.equals(sparseBooleanArray);
        }
        if (sparseBooleanArray2.size() != sparseBooleanArray.size()) {
            return false;
        }
        for (int i10 = 0; i10 < sparseBooleanArray2.size(); i10++) {
            if (a(i10) != qVar.a(i10)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i9 = g1.w.f3713a;
        SparseBooleanArray sparseBooleanArray = this.f2516a;
        if (i9 >= 24) {
            return sparseBooleanArray.hashCode();
        }
        int size = sparseBooleanArray.size();
        for (int i10 = 0; i10 < sparseBooleanArray.size(); i10++) {
            size = (size * 31) + a(i10);
        }
        return size;
    }
}
