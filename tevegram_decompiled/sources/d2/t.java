package d2;

import d1.m0;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final List f2733a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2734b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2735c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2736d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2737e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2738f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2739g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public final String f2740i;

    public t(List list, int i9, int i10, int i11, int i12, int i13, int i14, float f9, String str) {
        this.f2733a = list;
        this.f2734b = i9;
        this.f2735c = i10;
        this.f2736d = i11;
        this.f2737e = i12;
        this.f2738f = i13;
        this.f2739g = i14;
        this.h = f9;
        this.f2740i = str;
    }

    public static t a(g1.p pVar) {
        int i9;
        try {
            pVar.G(21);
            int t8 = pVar.t() & 3;
            int t9 = pVar.t();
            int i10 = pVar.f3700b;
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < t9; i13++) {
                pVar.G(1);
                int z8 = pVar.z();
                for (int i14 = 0; i14 < z8; i14++) {
                    int z9 = pVar.z();
                    i12 += z9 + 4;
                    pVar.G(z9);
                }
            }
            pVar.F(i10);
            byte[] bArr = new byte[i12];
            String str = null;
            int i15 = 0;
            int i16 = 0;
            int i17 = -1;
            int i18 = -1;
            int i19 = -1;
            int i20 = -1;
            int i21 = -1;
            float f9 = 1.0f;
            while (i15 < t9) {
                int t10 = pVar.t() & 63;
                int z10 = pVar.z();
                int i22 = 0;
                while (i22 < z10) {
                    int z11 = pVar.z();
                    int i23 = t8;
                    System.arraycopy(h1.g.f3891a, i11, bArr, i16, 4);
                    int i24 = i16 + 4;
                    System.arraycopy(pVar.f3699a, pVar.f3700b, bArr, i24, z11);
                    if (t10 == 33 && i22 == 0) {
                        h1.d c9 = h1.g.c(i24, i24 + z11, bArr);
                        i17 = c9.f3863e + 8;
                        i18 = c9.f3864f + 8;
                        i19 = c9.f3869l;
                        int i25 = c9.f3870m;
                        int i26 = c9.f3871n;
                        i9 = t9;
                        float f10 = c9.f3868k;
                        str = g1.a.d(c9.f3859a, c9.f3860b, c9.f3861c, c9.f3862d, c9.f3865g, c9.h);
                        i21 = i26;
                        f9 = f10;
                        i20 = i25;
                    } else {
                        i9 = t9;
                    }
                    i16 = i24 + z11;
                    pVar.G(z11);
                    i22++;
                    t8 = i23;
                    t9 = i9;
                    i11 = 0;
                }
                i15++;
                i11 = 0;
            }
            return new t(i12 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), t8 + 1, i17, i18, i19, i20, i21, f9, str);
        } catch (ArrayIndexOutOfBoundsException e9) {
            throw m0.a(e9, "Error parsing HEVC config");
        }
    }
}
