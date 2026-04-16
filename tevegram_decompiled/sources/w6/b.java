package w6;

import m7.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f9971a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f9972b;

    public b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            c.d();
            throw null;
        }
        this.f9971a = aVar;
        int length = iArr.length;
        int i9 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.f9972b = iArr;
            return;
        }
        while (i9 < length && iArr[i9] == 0) {
            i9++;
        }
        if (i9 == length) {
            this.f9972b = new int[]{0};
            return;
        }
        int i10 = length - i9;
        int[] iArr2 = new int[i10];
        this.f9972b = iArr2;
        System.arraycopy(iArr, i9, iArr2, 0, i10);
    }

    public final b a(b bVar) {
        a aVar = bVar.f9971a;
        a aVar2 = this.f9971a;
        if (!aVar2.equals(aVar)) {
            c.n("GenericGFPolys do not have same GenericGF field");
            return null;
        }
        if (c()) {
            return bVar;
        }
        if (bVar.c()) {
            return this;
        }
        int[] iArr = bVar.f9972b;
        int[] iArr2 = this.f9972b;
        if (iArr2.length > iArr.length) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i9 = length; i9 < iArr.length; i9++) {
            iArr3[i9] = iArr2[i9 - length] ^ iArr[i9];
        }
        return new b(aVar2, iArr3);
    }

    public final int b() {
        return this.f9972b.length - 1;
    }

    public final boolean c() {
        return this.f9972b[0] == 0;
    }

    public final String toString() {
        if (c()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b9 = b(); b9 >= 0; b9--) {
            int[] iArr = this.f9972b;
            int i9 = iArr[(iArr.length - 1) - b9];
            if (i9 != 0) {
                if (i9 < 0) {
                    if (b9 == b()) {
                        sb.append("-");
                    } else {
                        sb.append(" - ");
                    }
                    i9 = -i9;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b9 == 0 || i9 != 1) {
                    a aVar = this.f9971a;
                    if (i9 == 0) {
                        aVar.getClass();
                        c.d();
                        return null;
                    }
                    int i10 = aVar.f9966b[i9];
                    if (i10 == 0) {
                        sb.append('1');
                    } else if (i10 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i10);
                    }
                }
                if (b9 != 0) {
                    if (b9 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b9);
                    }
                }
            }
        }
        return sb.toString();
    }
}
