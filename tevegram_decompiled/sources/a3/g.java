package a3;

import g1.p;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f103a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f104b;

    /* renamed from: c, reason: collision with root package name */
    public int f105c;

    /* renamed from: d, reason: collision with root package name */
    public int f106d;

    /* renamed from: e, reason: collision with root package name */
    public int f107e;

    public g(int i9, int i10) {
        this.f103a = 0;
        this.f105c = i9;
        this.f106d = i10;
        this.f104b = new byte[(i10 * 2) - 1];
        this.f107e = 0;
    }

    public void a() {
        int i9;
        int i10;
        switch (this.f103a) {
            case 2:
                int i11 = this.f105c;
                g1.a.k(i11 >= 0 && (i11 < (i9 = this.f107e) || (i11 == i9 && this.f106d == 0)));
                break;
            default:
                int i12 = this.f106d;
                g1.a.k(i12 >= 0 && (i12 < (i10 = this.f105c) || (i12 == i10 && this.f107e == 0)));
                break;
        }
    }

    public int b() {
        return ((this.f107e - this.f105c) * 8) - this.f106d;
    }

    public void c() {
        if (this.f106d == 0) {
            return;
        }
        this.f106d = 0;
        this.f105c++;
        a();
    }

    public boolean d(int i9) {
        int i10 = this.f106d;
        int i11 = i9 / 8;
        int i12 = i10 + i11;
        int i13 = (this.f107e + i9) - (i11 * 8);
        if (i13 > 7) {
            i12++;
            i13 -= 8;
        }
        while (true) {
            i10++;
            if (i10 > i12 || i12 >= this.f105c) {
                break;
            }
            if (q(i10)) {
                i12++;
                i10 += 2;
            }
        }
        int i14 = this.f105c;
        if (i12 >= i14) {
            return i12 == i14 && i13 == 0;
        }
        return true;
    }

    public boolean e() {
        int i9 = this.f106d;
        int i10 = this.f107e;
        int i11 = 0;
        while (this.f106d < this.f105c && !h()) {
            i11++;
        }
        boolean z8 = this.f106d == this.f105c;
        this.f106d = i9;
        this.f107e = i10;
        return !z8 && d((i11 * 2) + 1);
    }

    public int f() {
        g1.a.k(this.f106d == 0);
        return this.f105c;
    }

    public int g() {
        return (this.f105c * 8) + this.f106d;
    }

    public boolean h() {
        switch (this.f103a) {
            case 1:
                boolean z8 = (((this.f104b[this.f106d] & 255) >> this.f107e) & 1) == 1;
                s(1);
                return z8;
            case 2:
                boolean z9 = (this.f104b[this.f105c] & (128 >> this.f106d)) != 0;
                r();
                return z9;
            default:
                boolean z10 = (this.f104b[this.f106d] & (128 >> this.f107e)) != 0;
                r();
                return z10;
        }
    }

    public int i(int i9) {
        switch (this.f103a) {
            case 1:
                int i10 = this.f106d;
                int min = Math.min(i9, 8 - this.f107e);
                byte[] bArr = this.f104b;
                int i11 = i10 + 1;
                int i12 = ((bArr[i10] & 255) >> this.f107e) & (255 >> (8 - min));
                while (min < i9) {
                    i12 |= (bArr[i11] & 255) << min;
                    min += 8;
                    i11++;
                }
                int i13 = i12 & ((-1) >>> (32 - i9));
                s(i9);
                return i13;
            case 2:
                if (i9 == 0) {
                    return 0;
                }
                this.f106d += i9;
                int i14 = 0;
                while (true) {
                    int i15 = this.f106d;
                    if (i15 <= 8) {
                        byte[] bArr2 = this.f104b;
                        int i16 = this.f105c;
                        int i17 = ((-1) >>> (32 - i9)) & (i14 | ((bArr2[i16] & 255) >> (8 - i15)));
                        if (i15 == 8) {
                            this.f106d = 0;
                            this.f105c = i16 + 1;
                        }
                        a();
                        return i17;
                    }
                    int i18 = i15 - 8;
                    this.f106d = i18;
                    byte[] bArr3 = this.f104b;
                    int i19 = this.f105c;
                    this.f105c = i19 + 1;
                    i14 |= (bArr3[i19] & 255) << i18;
                }
            default:
                this.f107e += i9;
                int i20 = 0;
                while (true) {
                    int i21 = this.f107e;
                    if (i21 <= 8) {
                        byte[] bArr4 = this.f104b;
                        int i22 = this.f106d;
                        int i23 = ((-1) >>> (32 - i9)) & (i20 | ((bArr4[i22] & 255) >> (8 - i21)));
                        if (i21 == 8) {
                            this.f107e = 0;
                            this.f106d = i22 + (q(i22 + 1) ? 2 : 1);
                        }
                        a();
                        return i23;
                    }
                    int i24 = i21 - 8;
                    this.f107e = i24;
                    byte[] bArr5 = this.f104b;
                    int i25 = this.f106d;
                    i20 |= (bArr5[i25] & 255) << i24;
                    if (!q(i25 + 1)) {
                        r3 = 1;
                    }
                    this.f106d = i25 + r3;
                }
        }
    }

    public void j(byte[] bArr, int i9) {
        int i10 = i9 >> 3;
        for (int i11 = 0; i11 < i10; i11++) {
            byte[] bArr2 = this.f104b;
            int i12 = this.f105c;
            int i13 = i12 + 1;
            this.f105c = i13;
            byte b9 = bArr2[i12];
            int i14 = this.f106d;
            byte b10 = (byte) (b9 << i14);
            bArr[i11] = b10;
            bArr[i11] = (byte) (((255 & bArr2[i13]) >> (8 - i14)) | b10);
        }
        int i15 = i9 & 7;
        if (i15 == 0) {
            return;
        }
        byte b11 = (byte) (bArr[i10] & (255 >> i15));
        bArr[i10] = b11;
        int i16 = this.f106d;
        if (i16 + i15 > 8) {
            byte[] bArr3 = this.f104b;
            int i17 = this.f105c;
            this.f105c = i17 + 1;
            bArr[i10] = (byte) (b11 | ((bArr3[i17] & 255) << i16));
            this.f106d = i16 - 8;
        }
        int i18 = this.f106d + i15;
        this.f106d = i18;
        byte[] bArr4 = this.f104b;
        int i19 = this.f105c;
        bArr[i10] = (byte) (((byte) (((255 & bArr4[i19]) >> (8 - i18)) << (8 - i15))) | bArr[i10]);
        if (i18 == 8) {
            this.f106d = 0;
            this.f105c = i19 + 1;
        }
        a();
    }

    public void k(byte[] bArr, int i9) {
        g1.a.k(this.f106d == 0);
        System.arraycopy(this.f104b, this.f105c, bArr, 0, i9);
        this.f105c += i9;
        a();
    }

    public int l() {
        int i9 = 0;
        while (!h()) {
            i9++;
        }
        return ((1 << i9) - 1) + (i9 > 0 ? i(i9) : 0);
    }

    public int m() {
        int l4 = l();
        return ((l4 + 1) / 2) * (l4 % 2 == 0 ? -1 : 1);
    }

    public void n(p pVar) {
        o(pVar.f3699a, pVar.f3701c);
        p(pVar.f3700b * 8);
    }

    public void o(byte[] bArr, int i9) {
        this.f104b = bArr;
        this.f105c = 0;
        this.f106d = 0;
        this.f107e = i9;
    }

    public void p(int i9) {
        int i10 = i9 / 8;
        this.f105c = i10;
        this.f106d = i9 - (i10 * 8);
        a();
    }

    public boolean q(int i9) {
        if (2 > i9 || i9 >= this.f105c) {
            return false;
        }
        byte[] bArr = this.f104b;
        return bArr[i9] == 3 && bArr[i9 + (-2)] == 0 && bArr[i9 - 1] == 0;
    }

    public void r() {
        switch (this.f103a) {
            case 2:
                int i9 = this.f106d + 1;
                this.f106d = i9;
                if (i9 == 8) {
                    this.f106d = 0;
                    this.f105c++;
                }
                a();
                break;
            default:
                int i10 = this.f107e + 1;
                this.f107e = i10;
                if (i10 == 8) {
                    this.f107e = 0;
                    int i11 = this.f106d;
                    this.f106d = i11 + (q(i11 + 1) ? 2 : 1);
                }
                a();
                break;
        }
    }

    public void s(int i9) {
        int i10;
        switch (this.f103a) {
            case 1:
                int i11 = i9 / 8;
                int i12 = this.f106d + i11;
                this.f106d = i12;
                int i13 = (i9 - (i11 * 8)) + this.f107e;
                this.f107e = i13;
                boolean z8 = true;
                if (i13 > 7) {
                    this.f106d = i12 + 1;
                    this.f107e = i13 - 8;
                }
                int i14 = this.f106d;
                if (i14 < 0 || (i14 >= (i10 = this.f105c) && (i14 != i10 || this.f107e != 0))) {
                    z8 = false;
                }
                g1.a.k(z8);
                break;
            case 2:
                int i15 = i9 / 8;
                int i16 = this.f105c + i15;
                this.f105c = i16;
                int i17 = (i9 - (i15 * 8)) + this.f106d;
                this.f106d = i17;
                if (i17 > 7) {
                    this.f105c = i16 + 1;
                    this.f106d = i17 - 8;
                }
                a();
                break;
            default:
                int i18 = this.f106d;
                int i19 = i9 / 8;
                int i20 = i18 + i19;
                this.f106d = i20;
                int i21 = (i9 - (i19 * 8)) + this.f107e;
                this.f107e = i21;
                if (i21 > 7) {
                    this.f106d = i20 + 1;
                    this.f107e = i21 - 8;
                }
                while (true) {
                    i18++;
                    if (i18 > this.f106d) {
                        a();
                        break;
                    } else if (q(i18)) {
                        this.f106d++;
                        i18 += 2;
                    }
                }
        }
    }

    public void t(int i9) {
        g1.a.k(this.f106d == 0);
        this.f105c += i9;
        a();
    }

    public g(int i9, int i10, byte[] bArr) {
        this.f103a = 3;
        this.f104b = bArr;
        this.f106d = i9;
        this.f105c = i10;
        this.f107e = 0;
        a();
    }

    public g(byte[] bArr) {
        this.f103a = 1;
        this.f104b = bArr;
        this.f105c = bArr.length;
    }

    public g(byte[] bArr, int i9) {
        this.f103a = 2;
        this.f104b = bArr;
        this.f107e = i9;
    }

    public g() {
        this.f103a = 2;
        this.f104b = w.f3718f;
    }
}
