package s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements Cloneable {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f8642m = new Object();

    /* renamed from: i, reason: collision with root package name */
    public boolean f8643i = false;

    /* renamed from: j, reason: collision with root package name */
    public long[] f8644j;

    /* renamed from: k, reason: collision with root package name */
    public Object[] f8645k;

    /* renamed from: l, reason: collision with root package name */
    public int f8646l;

    public g() {
        int i9;
        int i10 = 4;
        while (true) {
            i9 = 80;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (80 <= i11) {
                i9 = i11;
                break;
            }
            i10++;
        }
        int i12 = i9 / 8;
        this.f8644j = new long[i12];
        this.f8645k = new Object[i12];
    }

    public final void a(long j5, Long l4) {
        int i9 = this.f8646l;
        if (i9 != 0 && j5 <= this.f8644j[i9 - 1]) {
            f(j5, l4);
            return;
        }
        if (this.f8643i && i9 >= this.f8644j.length) {
            d();
        }
        int i10 = this.f8646l;
        if (i10 >= this.f8644j.length) {
            int i11 = (i10 + 1) * 8;
            int i12 = 4;
            while (true) {
                if (i12 >= 32) {
                    break;
                }
                int i13 = (1 << i12) - 12;
                if (i11 <= i13) {
                    i11 = i13;
                    break;
                }
                i12++;
            }
            int i14 = i11 / 8;
            long[] jArr = new long[i14];
            Object[] objArr = new Object[i14];
            long[] jArr2 = this.f8644j;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f8645k;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f8644j = jArr;
            this.f8645k = objArr;
        }
        this.f8644j[i10] = j5;
        this.f8645k[i10] = l4;
        this.f8646l = i10 + 1;
    }

    public final void b() {
        int i9 = this.f8646l;
        Object[] objArr = this.f8645k;
        for (int i10 = 0; i10 < i9; i10++) {
            objArr[i10] = null;
        }
        this.f8646l = 0;
        this.f8643i = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final g clone() {
        try {
            g gVar = (g) super.clone();
            gVar.f8644j = (long[]) this.f8644j.clone();
            gVar.f8645k = (Object[]) this.f8645k.clone();
            return gVar;
        } catch (CloneNotSupportedException e9) {
            m7.c.e(e9);
            return null;
        }
    }

    public final void d() {
        int i9 = this.f8646l;
        long[] jArr = this.f8644j;
        Object[] objArr = this.f8645k;
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            Object obj = objArr[i11];
            if (obj != f8642m) {
                if (i11 != i10) {
                    jArr[i10] = jArr[i11];
                    objArr[i10] = obj;
                    objArr[i11] = null;
                }
                i10++;
            }
        }
        this.f8643i = false;
        this.f8646l = i10;
    }

    public final Object e(long j5, Long l4) {
        Object obj;
        int b9 = f.b(this.f8644j, this.f8646l, j5);
        return (b9 < 0 || (obj = this.f8645k[b9]) == f8642m) ? l4 : obj;
    }

    public final void f(long j5, Object obj) {
        int b9 = f.b(this.f8644j, this.f8646l, j5);
        if (b9 >= 0) {
            this.f8645k[b9] = obj;
            return;
        }
        int i9 = ~b9;
        int i10 = this.f8646l;
        if (i9 < i10) {
            Object[] objArr = this.f8645k;
            if (objArr[i9] == f8642m) {
                this.f8644j[i9] = j5;
                objArr[i9] = obj;
                return;
            }
        }
        if (this.f8643i && i10 >= this.f8644j.length) {
            d();
            i9 = ~f.b(this.f8644j, this.f8646l, j5);
        }
        int i11 = this.f8646l;
        if (i11 >= this.f8644j.length) {
            int i12 = (i11 + 1) * 8;
            int i13 = 4;
            while (true) {
                if (i13 >= 32) {
                    break;
                }
                int i14 = (1 << i13) - 12;
                if (i12 <= i14) {
                    i12 = i14;
                    break;
                }
                i13++;
            }
            int i15 = i12 / 8;
            long[] jArr = new long[i15];
            Object[] objArr2 = new Object[i15];
            long[] jArr2 = this.f8644j;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f8645k;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f8644j = jArr;
            this.f8645k = objArr2;
        }
        int i16 = this.f8646l - i9;
        if (i16 != 0) {
            long[] jArr3 = this.f8644j;
            int i17 = i9 + 1;
            System.arraycopy(jArr3, i9, jArr3, i17, i16);
            Object[] objArr4 = this.f8645k;
            System.arraycopy(objArr4, i9, objArr4, i17, this.f8646l - i9);
        }
        this.f8644j[i9] = j5;
        this.f8645k[i9] = obj;
        this.f8646l++;
    }

    public final int g() {
        if (this.f8643i) {
            d();
        }
        return this.f8646l;
    }

    public final Object h(int i9) {
        if (this.f8643i) {
            d();
        }
        return this.f8645k[i9];
    }

    public final String toString() {
        if (g() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f8646l * 28);
        sb.append('{');
        for (int i9 = 0; i9 < this.f8646l; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            if (this.f8643i) {
                d();
            }
            sb.append(this.f8644j[i9]);
            sb.append('=');
            Object h = h(i9);
            if (h != this) {
                sb.append(h);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
