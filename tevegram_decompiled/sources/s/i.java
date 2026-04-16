package s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements Cloneable {

    /* renamed from: l, reason: collision with root package name */
    public static final Object f8654l = new Object();

    /* renamed from: i, reason: collision with root package name */
    public int[] f8655i;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f8656j;

    /* renamed from: k, reason: collision with root package name */
    public int f8657k;

    public i() {
        int i9;
        int i10 = 4;
        while (true) {
            i9 = 40;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (40 <= i11) {
                i9 = i11;
                break;
            }
            i10++;
        }
        int i12 = i9 / 4;
        this.f8655i = new int[i12];
        this.f8656j = new Object[i12];
    }

    public final void a(int i9, Object obj) {
        int i10 = this.f8657k;
        if (i10 != 0 && i9 <= this.f8655i[i10 - 1]) {
            d(i9, obj);
            return;
        }
        if (i10 >= this.f8655i.length) {
            int i11 = (i10 + 1) * 4;
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
            int i14 = i11 / 4;
            int[] iArr = new int[i14];
            Object[] objArr = new Object[i14];
            int[] iArr2 = this.f8655i;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f8656j;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f8655i = iArr;
            this.f8656j = objArr;
        }
        this.f8655i[i10] = i9;
        this.f8656j[i10] = obj;
        this.f8657k = i10 + 1;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final i clone() {
        try {
            i iVar = (i) super.clone();
            iVar.f8655i = (int[]) this.f8655i.clone();
            iVar.f8656j = (Object[]) this.f8656j.clone();
            return iVar;
        } catch (CloneNotSupportedException e9) {
            m7.c.e(e9);
            return null;
        }
    }

    public final Object c(int i9, Integer num) {
        Object obj;
        int a9 = f.a(this.f8657k, i9, this.f8655i);
        return (a9 < 0 || (obj = this.f8656j[a9]) == f8654l) ? num : obj;
    }

    public final void d(int i9, Object obj) {
        int a9 = f.a(this.f8657k, i9, this.f8655i);
        if (a9 >= 0) {
            this.f8656j[a9] = obj;
            return;
        }
        int i10 = ~a9;
        int i11 = this.f8657k;
        if (i10 < i11) {
            Object[] objArr = this.f8656j;
            if (objArr[i10] == f8654l) {
                this.f8655i[i10] = i9;
                objArr[i10] = obj;
                return;
            }
        }
        if (i11 >= this.f8655i.length) {
            int i12 = (i11 + 1) * 4;
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
            int i15 = i12 / 4;
            int[] iArr = new int[i15];
            Object[] objArr2 = new Object[i15];
            int[] iArr2 = this.f8655i;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f8656j;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f8655i = iArr;
            this.f8656j = objArr2;
        }
        int i16 = this.f8657k - i10;
        if (i16 != 0) {
            int[] iArr3 = this.f8655i;
            int i17 = i10 + 1;
            System.arraycopy(iArr3, i10, iArr3, i17, i16);
            Object[] objArr4 = this.f8656j;
            System.arraycopy(objArr4, i10, objArr4, i17, this.f8657k - i10);
        }
        this.f8655i[i10] = i9;
        this.f8656j[i10] = obj;
        this.f8657k++;
    }

    public final String toString() {
        int i9 = this.f8657k;
        if (i9 <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i9 * 28);
        sb.append('{');
        for (int i10 = 0; i10 < this.f8657k; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(this.f8655i[i10]);
            sb.append('=');
            Object obj = this.f8656j[i10];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
