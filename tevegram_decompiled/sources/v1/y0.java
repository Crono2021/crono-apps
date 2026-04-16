package v1;

import java.util.Arrays;
import java.util.Random;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public final Random f9444a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f9445b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f9446c;

    public y0(int[] iArr, Random random) {
        this.f9445b = iArr;
        this.f9444a = random;
        this.f9446c = new int[iArr.length];
        for (int i9 = 0; i9 < iArr.length; i9++) {
            this.f9446c[iArr[i9]] = i9;
        }
    }

    public final y0 a(int i9, int i10) {
        int[] iArr;
        Random random;
        int[] iArr2 = new int[i10];
        int[] iArr3 = new int[i10];
        int i11 = 0;
        while (true) {
            iArr = this.f9445b;
            random = this.f9444a;
            if (i11 >= i10) {
                break;
            }
            iArr2[i11] = random.nextInt(iArr.length + 1);
            int i12 = i11 + 1;
            int nextInt = random.nextInt(i12);
            iArr3[i11] = iArr3[nextInt];
            iArr3[nextInt] = i11 + i9;
            i11 = i12;
        }
        Arrays.sort(iArr2);
        int[] iArr4 = new int[iArr.length + i10];
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < iArr.length + i10; i15++) {
            if (i13 >= i10 || i14 != iArr2[i13]) {
                int i16 = i14 + 1;
                int i17 = iArr[i14];
                iArr4[i15] = i17;
                if (i17 >= i9) {
                    iArr4[i15] = i17 + i10;
                }
                i14 = i16;
            } else {
                iArr4[i15] = iArr3[i13];
                i13++;
            }
        }
        return new y0(iArr4, new Random(random.nextLong()));
    }

    public y0() {
        this(new Random());
    }

    public y0(Random random) {
        this(new int[0], random);
    }
}
