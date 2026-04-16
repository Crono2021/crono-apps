package b6;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z extends v0 implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final Comparator[] f1475i;

    public z(p pVar, p pVar2) {
        this.f1475i = new Comparator[]{pVar, pVar2};
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i9 = 0;
        while (true) {
            Comparator[] comparatorArr = this.f1475i;
            if (i9 >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i9].compare(obj, obj2);
            if (compare != 0) {
                return compare;
            }
            i9++;
        }
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            return Arrays.equals(this.f1475i, ((z) obj).f1475i);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1475i);
    }

    public final String toString() {
        return androidx.activity.g.o(new StringBuilder("Ordering.compound("), Arrays.toString(this.f1475i), ")");
    }
}
