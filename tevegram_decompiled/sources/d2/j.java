package d2;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements n {

    /* renamed from: j, reason: collision with root package name */
    public final d1.k f2701j;

    /* renamed from: k, reason: collision with root package name */
    public final long f2702k;

    /* renamed from: l, reason: collision with root package name */
    public long f2703l;

    /* renamed from: n, reason: collision with root package name */
    public int f2705n;

    /* renamed from: o, reason: collision with root package name */
    public int f2706o;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f2704m = new byte[65536];

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f2700i = new byte[4096];

    static {
        d1.f0.a("media3.extractor");
    }

    public j(d1.k kVar, long j5, long j9) {
        this.f2701j = kVar;
        this.f2703l = j5;
        this.f2702k = j9;
    }

    @Override // d2.n
    public final void a(int i9, int i10, byte[] bArr) {
        n(bArr, i9, i10, false);
    }

    @Override // d2.n
    public final int b(int i9) {
        j jVar;
        int min = Math.min(this.f2706o, i9);
        r(min);
        if (min == 0) {
            byte[] bArr = this.f2700i;
            jVar = this;
            min = jVar.q(bArr, 0, Math.min(i9, bArr.length), 0, true);
        } else {
            jVar = this;
        }
        if (min != -1) {
            jVar.f2703l += min;
        }
        return min;
    }

    public final boolean c(int i9, boolean z8) {
        l(i9);
        int i10 = this.f2706o - this.f2705n;
        while (i10 < i9) {
            int i11 = i9;
            boolean z9 = z8;
            i10 = q(this.f2704m, this.f2705n, i11, i10, z9);
            if (i10 == -1) {
                return false;
            }
            this.f2706o = this.f2705n + i10;
            i9 = i11;
            z8 = z9;
        }
        this.f2705n += i9;
        return true;
    }

    @Override // d2.n
    public final boolean d(byte[] bArr, int i9, int i10, boolean z8) {
        int min;
        int i11 = this.f2706o;
        if (i11 == 0) {
            min = 0;
        } else {
            min = Math.min(i11, i10);
            System.arraycopy(this.f2704m, 0, bArr, i9, min);
            r(min);
        }
        int i12 = min;
        while (i12 < i10 && i12 != -1) {
            i12 = q(bArr, i9, i10, i12, z8);
        }
        if (i12 != -1) {
            this.f2703l += i12;
        }
        return i12 != -1;
    }

    @Override // d2.n
    public final long e() {
        return this.f2702k;
    }

    @Override // d2.n
    public final long getPosition() {
        return this.f2703l;
    }

    @Override // d2.n
    public final void h() {
        this.f2705n = 0;
    }

    @Override // d2.n
    public final void i(int i9) {
        int min = Math.min(this.f2706o, i9);
        r(min);
        int i10 = min;
        while (i10 < i9 && i10 != -1) {
            byte[] bArr = this.f2700i;
            i10 = q(bArr, -i10, Math.min(i9, bArr.length + i10), i10, false);
        }
        if (i10 != -1) {
            this.f2703l += i10;
        }
    }

    @Override // d2.n
    public final int j(int i9, int i10, byte[] bArr) {
        j jVar;
        int min;
        l(i10);
        int i11 = this.f2706o;
        int i12 = this.f2705n;
        int i13 = i11 - i12;
        if (i13 == 0) {
            jVar = this;
            min = jVar.q(this.f2704m, i12, i10, 0, true);
            if (min == -1) {
                return -1;
            }
            jVar.f2706o += min;
        } else {
            jVar = this;
            min = Math.min(i10, i13);
        }
        System.arraycopy(jVar.f2704m, jVar.f2705n, bArr, i9, min);
        jVar.f2705n += min;
        return min;
    }

    public final void l(int i9) {
        int i10 = this.f2705n + i9;
        byte[] bArr = this.f2704m;
        if (i10 > bArr.length) {
            this.f2704m = Arrays.copyOf(this.f2704m, g1.w.h(bArr.length * 2, 65536 + i10, i10 + 524288));
        }
    }

    @Override // d2.n
    public final boolean n(byte[] bArr, int i9, int i10, boolean z8) {
        if (!c(i10, z8)) {
            return false;
        }
        System.arraycopy(this.f2704m, this.f2705n - i10, bArr, i9, i10);
        return true;
    }

    @Override // d2.n
    public final long o() {
        return this.f2703l + this.f2705n;
    }

    @Override // d2.n
    public final void p(int i9) {
        c(i9, false);
    }

    public final int q(byte[] bArr, int i9, int i10, int i11, boolean z8) {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int read = this.f2701j.read(bArr, i9 + i11, i10 - i11);
        if (read != -1) {
            return i11 + read;
        }
        if (i11 == 0 && z8) {
            return -1;
        }
        throw new EOFException();
    }

    public final void r(int i9) {
        int i10 = this.f2706o - i9;
        this.f2706o = i10;
        this.f2705n = 0;
        byte[] bArr = this.f2704m;
        byte[] bArr2 = i10 < bArr.length - 524288 ? new byte[65536 + i10] : bArr;
        System.arraycopy(bArr, i9, bArr2, 0, i10);
        this.f2704m = bArr2;
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        j jVar;
        int i11 = this.f2706o;
        int i12 = 0;
        if (i11 != 0) {
            int min = Math.min(i11, i10);
            System.arraycopy(this.f2704m, 0, bArr, i9, min);
            r(min);
            i12 = min;
        }
        if (i12 == 0) {
            jVar = this;
            i12 = jVar.q(bArr, i9, i10, 0, true);
        } else {
            jVar = this;
        }
        if (i12 != -1) {
            jVar.f2703l += i12;
        }
        return i12;
    }

    @Override // d2.n
    public final void readFully(byte[] bArr, int i9, int i10) {
        d(bArr, i9, i10, false);
    }
}
