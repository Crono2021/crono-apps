package b6;

import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u0 extends v0 implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public static final u0 f1460j = new u0(0);

    /* renamed from: k, reason: collision with root package name */
    public static final u0 f1461k = new u0(1);

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1462i;

    public /* synthetic */ u0(int i9) {
        this.f1462i = i9;
    }

    @Override // b6.v0
    public final v0 a() {
        switch (this.f1462i) {
            case 0:
                return f1461k;
            default:
                return f1460j;
        }
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1462i) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                comparable.getClass();
                comparable2.getClass();
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                comparable3.getClass();
                if (comparable3 == comparable4) {
                    return 0;
                }
                return comparable4.compareTo(comparable3);
        }
    }

    public final String toString() {
        switch (this.f1462i) {
            case 0:
                return "Ordering.natural()";
            default:
                return "Ordering.natural().reverse()";
        }
    }
}
