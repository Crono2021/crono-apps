package w6;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f9964g;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f9965a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f9966b;

    /* renamed from: c, reason: collision with root package name */
    public final b f9967c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9968d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9969e;

    /* renamed from: f, reason: collision with root package name */
    public final int f9970f;

    static {
        new a(4201, 4096, 1);
        new a(1033, 1024, 1);
        new a(67, 64, 1);
        new a(19, 16, 1);
        f9964g = new a(285, 256, 0);
        new a(301, 256, 1);
    }

    public a(int i9, int i10, int i11) {
        this.f9969e = i9;
        this.f9968d = i10;
        this.f9970f = i11;
        this.f9965a = new int[i10];
        this.f9966b = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.f9965a[i13] = i12;
            i12 *= 2;
            if (i12 >= i10) {
                i12 = (i12 ^ i9) & (i10 - 1);
            }
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.f9966b[this.f9965a[i14]] = i14;
        }
        this.f9967c = new b(this, new int[]{0});
    }

    public final int a(int i9, int i10) {
        if (i9 == 0 || i10 == 0) {
            return 0;
        }
        int[] iArr = this.f9966b;
        return this.f9965a[(iArr[i9] + iArr[i10]) % (this.f9968d - 1)];
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.f9969e) + ',' + this.f9968d + ')';
    }
}
