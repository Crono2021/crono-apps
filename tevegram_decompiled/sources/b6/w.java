package b6;

import java.util.Comparator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w extends y {
    public static y f(int i9) {
        return i9 < 0 ? y.f1470b : i9 > 0 ? y.f1471c : y.f1469a;
    }

    @Override // b6.y
    public final y a(int i9, int i10) {
        return f(i9 < i10 ? -1 : i9 > i10 ? 1 : 0);
    }

    @Override // b6.y
    public final y b(Object obj, Object obj2, Comparator comparator) {
        return f(comparator.compare(obj, obj2));
    }

    @Override // b6.y
    public final y c(boolean z8, boolean z9) {
        return f(z8 == z9 ? 0 : z8 ? 1 : -1);
    }

    @Override // b6.y
    public final y d(boolean z8, boolean z9) {
        return f(z9 == z8 ? 0 : z9 ? 1 : -1);
    }

    @Override // b6.y
    public final int e() {
        return 0;
    }
}
