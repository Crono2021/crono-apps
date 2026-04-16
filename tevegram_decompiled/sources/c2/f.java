package c2;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f1554a;

    /* renamed from: b, reason: collision with root package name */
    public int f1555b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1556c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1557d;

    public f(f fVar) {
        float[] fArr = (float[]) fVar.f1556c;
        this.f1554a = fArr.length / 3;
        this.f1556c = g1.a.n(fArr);
        this.f1557d = g1.a.n((float[]) fVar.f1557d);
        int i9 = fVar.f1555b;
        if (i9 == 1) {
            this.f1555b = 5;
        } else if (i9 != 2) {
            this.f1555b = 4;
        } else {
            this.f1555b = 6;
        }
    }

    public synchronized void a(long j5, Object obj) {
        if (this.f1555b > 0) {
            if (j5 <= ((long[]) this.f1556c)[((this.f1554a + r0) - 1) % ((Object[]) this.f1557d).length]) {
                b();
            }
        }
        c();
        int i9 = this.f1554a;
        int i10 = this.f1555b;
        Object[] objArr = (Object[]) this.f1557d;
        int length = (i9 + i10) % objArr.length;
        ((long[]) this.f1556c)[length] = j5;
        objArr[length] = obj;
        this.f1555b = i10 + 1;
    }

    public synchronized void b() {
        this.f1554a = 0;
        this.f1555b = 0;
        Arrays.fill((Object[]) this.f1557d, (Object) null);
    }

    public void c() {
        int length = ((Object[]) this.f1557d).length;
        if (this.f1555b < length) {
            return;
        }
        int i9 = length * 2;
        long[] jArr = new long[i9];
        Object[] objArr = new Object[i9];
        int i10 = this.f1554a;
        int i11 = length - i10;
        System.arraycopy((long[]) this.f1556c, i10, jArr, 0, i11);
        System.arraycopy((Object[]) this.f1557d, this.f1554a, objArr, 0, i11);
        int i12 = this.f1554a;
        if (i12 > 0) {
            System.arraycopy((long[]) this.f1556c, 0, jArr, i11, i12);
            System.arraycopy((Object[]) this.f1557d, 0, objArr, i11, this.f1554a);
        }
        this.f1556c = jArr;
        this.f1557d = objArr;
        this.f1554a = 0;
    }

    public Object d(long j5, boolean z8) {
        Object obj = null;
        long j9 = Long.MAX_VALUE;
        while (this.f1555b > 0) {
            long j10 = j5 - ((long[]) this.f1556c)[this.f1554a];
            if (j10 < 0 && (z8 || (-j10) >= j9)) {
                break;
            }
            obj = f();
            j9 = j10;
        }
        return obj;
    }

    public synchronized Object e(long j5) {
        return d(j5, true);
    }

    public Object f() {
        g1.a.k(this.f1555b > 0);
        Object[] objArr = (Object[]) this.f1557d;
        int i9 = this.f1554a;
        Object obj = objArr[i9];
        objArr[i9] = null;
        this.f1554a = (i9 + 1) % objArr.length;
        this.f1555b--;
        return obj;
    }

    public f(int i9, float[] fArr, float[] fArr2, int i10) {
        this.f1554a = i9;
        g1.a.f(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
        this.f1556c = fArr;
        this.f1557d = fArr2;
        this.f1555b = i10;
    }

    public f() {
        this.f1556c = new long[10];
        this.f1557d = new Object[10];
    }
}
