package c8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e {

    /* renamed from: i, reason: collision with root package name */
    public static final a f1727i;

    static {
        Integer num = x7.a.f10217a;
        f1727i = (num == null || num.intValue() >= 34) ? new d8.a() : new c();
    }

    public abstract int a(int i9);

    public abstract int b();

    public int c(int i9, int i10) {
        int b9;
        int i11;
        int i12;
        if (i10 <= i9) {
            throw new IllegalArgumentException(("Random range is empty: [" + Integer.valueOf(i9) + ", " + Integer.valueOf(i10) + ").").toString());
        }
        int i13 = i10 - i9;
        if (i13 > 0 || i13 == Integer.MIN_VALUE) {
            if (((-i13) & i13) == i13) {
                i12 = a(31 - Integer.numberOfLeadingZeros(i13));
            } else {
                do {
                    b9 = b() >>> 1;
                    i11 = b9 % i13;
                } while ((i13 - 1) + (b9 - i11) < 0);
                i12 = i11;
            }
            return i9 + i12;
        }
        while (true) {
            int b10 = b();
            if (i9 <= b10 && b10 < i10) {
                return b10;
            }
        }
    }
}
