package s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f8640a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Object[] f8641b = new Object[0];

    public static int a(int i9, int i10, int[] iArr) {
        int i11 = i9 - 1;
        int i12 = 0;
        while (i12 <= i11) {
            int i13 = (i12 + i11) >>> 1;
            int i14 = iArr[i13];
            if (i14 < i10) {
                i12 = i13 + 1;
            } else {
                if (i14 <= i10) {
                    return i13;
                }
                i11 = i13 - 1;
            }
        }
        return ~i12;
    }

    public static int b(long[] jArr, int i9, long j5) {
        int i10 = i9 - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            long j9 = jArr[i12];
            if (j9 < j5) {
                i11 = i12 + 1;
            } else {
                if (j9 <= j5) {
                    return i12;
                }
                i10 = i12 - 1;
            }
        }
        return ~i11;
    }
}
