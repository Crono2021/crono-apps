package d1;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j {
    public static final j h = new j(1, 2, 3, -1, -1, null);

    /* renamed from: a, reason: collision with root package name */
    public final int f2483a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2484b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2485c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f2486d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2487e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2488f;

    /* renamed from: g, reason: collision with root package name */
    public int f2489g;

    static {
        androidx.activity.g.s(0, 1, 2, 3, 4);
        g1.w.H(5);
    }

    public j(int i9, int i10, int i11, int i12, int i13, byte[] bArr) {
        this.f2483a = i9;
        this.f2484b = i10;
        this.f2485c = i11;
        this.f2486d = bArr;
        this.f2487e = i12;
        this.f2488f = i13;
    }

    public static String a(int i9) {
        return i9 != -1 ? i9 != 10 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? i9 != 6 ? i9 != 7 ? "Undefined color transfer" : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public static boolean b(j jVar) {
        if (jVar == null) {
            return true;
        }
        int i9 = jVar.f2483a;
        if (i9 != -1 && i9 != 1 && i9 != 2) {
            return false;
        }
        int i10 = jVar.f2484b;
        if (i10 != -1 && i10 != 2) {
            return false;
        }
        int i11 = jVar.f2485c;
        if ((i11 != -1 && i11 != 3) || jVar.f2486d != null) {
            return false;
        }
        int i12 = jVar.f2488f;
        if (i12 != -1 && i12 != 8) {
            return false;
        }
        int i13 = jVar.f2487e;
        return i13 == -1 || i13 == 8;
    }

    public static int c(int i9) {
        if (i9 == 1) {
            return 1;
        }
        if (i9 != 9) {
            return (i9 == 4 || i9 == 5 || i9 == 6 || i9 == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int d(int i9) {
        if (i9 == 1) {
            return 3;
        }
        if (i9 == 4) {
            return 10;
        }
        if (i9 == 13) {
            return 2;
        }
        if (i9 == 16) {
            return 6;
        }
        if (i9 != 18) {
            return (i9 == 6 || i9 == 7) ? 3 : -1;
        }
        return 7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            j jVar = (j) obj;
            if (this.f2483a == jVar.f2483a && this.f2484b == jVar.f2484b && this.f2485c == jVar.f2485c && Arrays.equals(this.f2486d, jVar.f2486d) && this.f2487e == jVar.f2487e && this.f2488f == jVar.f2488f) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f2489g == 0) {
            this.f2489g = ((((Arrays.hashCode(this.f2486d) + ((((((527 + this.f2483a) * 31) + this.f2484b) * 31) + this.f2485c) * 31)) * 31) + this.f2487e) * 31) + this.f2488f;
        }
        return this.f2489g;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ColorInfo(");
        int i9 = this.f2483a;
        sb.append(i9 != -1 ? i9 != 6 ? i9 != 1 ? i9 != 2 ? "Undefined color space" : "BT601" : "BT709" : "BT2020" : "Unset color space");
        sb.append(", ");
        int i10 = this.f2484b;
        sb.append(i10 != -1 ? i10 != 1 ? i10 != 2 ? "Undefined color range" : "Limited range" : "Full range" : "Unset color range");
        sb.append(", ");
        sb.append(a(this.f2485c));
        sb.append(", ");
        sb.append(this.f2486d != null);
        sb.append(", ");
        String str2 = "NA";
        int i11 = this.f2487e;
        if (i11 != -1) {
            str = i11 + "bit Luma";
        } else {
            str = "NA";
        }
        sb.append(str);
        sb.append(", ");
        int i12 = this.f2488f;
        if (i12 != -1) {
            str2 = i12 + "bit Chroma";
        }
        return androidx.activity.g.o(sb, str2, ")");
    }
}
