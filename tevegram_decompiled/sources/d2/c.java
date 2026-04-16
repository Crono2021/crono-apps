package d2;

import d1.m0;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2655a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2656b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2657c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2658d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2659e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2660f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2661g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2662i;

    /* renamed from: j, reason: collision with root package name */
    public final float f2663j;

    /* renamed from: k, reason: collision with root package name */
    public final String f2664k;

    public c(ArrayList arrayList, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, float f9, String str) {
        this.f2655a = arrayList;
        this.f2656b = i9;
        this.f2657c = i10;
        this.f2658d = i11;
        this.f2659e = i12;
        this.f2660f = i13;
        this.f2661g = i14;
        this.h = i15;
        this.f2662i = i16;
        this.f2663j = f9;
        this.f2664k = str;
    }

    public static c a(g1.p pVar) {
        String str;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        float f9;
        byte[] bArr = g1.a.f3654a;
        try {
            pVar.G(4);
            int t8 = (pVar.t() & 3) + 1;
            if (t8 == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int t9 = pVar.t() & 31;
            for (int i16 = 0; i16 < t9; i16++) {
                int z8 = pVar.z();
                int i17 = pVar.f3700b;
                pVar.G(z8);
                byte[] bArr2 = pVar.f3699a;
                byte[] bArr3 = new byte[z8 + 4];
                System.arraycopy(bArr, 0, bArr3, 0, 4);
                System.arraycopy(bArr2, i17, bArr3, 4, z8);
                arrayList.add(bArr3);
            }
            int t10 = pVar.t();
            for (int i18 = 0; i18 < t10; i18++) {
                int z9 = pVar.z();
                int i19 = pVar.f3700b;
                pVar.G(z9);
                byte[] bArr4 = pVar.f3699a;
                byte[] bArr5 = new byte[z9 + 4];
                System.arraycopy(bArr, 0, bArr5, 0, 4);
                System.arraycopy(bArr4, i19, bArr5, 4, z9);
                arrayList.add(bArr5);
            }
            if (t9 > 0) {
                h1.f d9 = h1.g.d(t8, ((byte[]) arrayList.get(0)).length, (byte[]) arrayList.get(0));
                int i20 = d9.f3878e;
                int i21 = d9.f3879f;
                int i22 = d9.h + 8;
                int i23 = d9.f3881i + 8;
                int i24 = d9.f3888p;
                int i25 = d9.f3889q;
                int i26 = d9.f3890r;
                float f10 = d9.f3880g;
                str = String.format("avc1.%02X%02X%02X", Integer.valueOf(d9.f3874a), Integer.valueOf(d9.f3875b), Integer.valueOf(d9.f3876c));
                i14 = i25;
                i15 = i26;
                f9 = f10;
                i11 = i22;
                i12 = i23;
                i13 = i24;
                i9 = i20;
                i10 = i21;
            } else {
                str = null;
                i9 = -1;
                i10 = -1;
                i11 = -1;
                i12 = -1;
                i13 = -1;
                i14 = -1;
                i15 = -1;
                f9 = 1.0f;
            }
            return new c(arrayList, t8, i9, i10, i11, i12, i13, i14, i15, f9, str);
        } catch (ArrayIndexOutOfBoundsException e9) {
            throw m0.a(e9, "Error parsing AVC config");
        }
    }
}
