package b2;

import android.os.SystemClock;
import d1.h1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d0 implements d2.n, d2.o {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1163i;

    /* renamed from: j, reason: collision with root package name */
    public long f1164j;

    /* renamed from: k, reason: collision with root package name */
    public Object f1165k;

    public d0(g gVar, v vVar) {
        this.f1163i = 0;
        this.f1165k = vVar;
        new u();
        new c2.f();
        new c2.f();
        long[] jArr = new long[Integer.bitCount(16) != 1 ? Integer.highestOneBit(15) << 1 : 16];
        h1 h1Var = h1.f2473e;
        this.f1164j = -9223372036854775807L;
    }

    @Override // d2.n
    public void a(int i9, int i10, byte[] bArr) {
        ((d2.n) this.f1165k).a(i9, i10, bArr);
    }

    @Override // d2.n
    public int b(int i9) {
        return ((d2.n) this.f1165k).b(i9);
    }

    @Override // d2.o
    public void c() {
        ((d2.o) this.f1165k).c();
    }

    @Override // d2.n
    public boolean d(byte[] bArr, int i9, int i10, boolean z8) {
        return ((d2.n) this.f1165k).d(bArr, 0, i10, z8);
    }

    @Override // d2.n
    public long e() {
        return ((d2.n) this.f1165k).e() - this.f1164j;
    }

    @Override // d2.n
    public long getPosition() {
        return ((d2.n) this.f1165k).getPosition() - this.f1164j;
    }

    @Override // d2.n
    public void h() {
        ((d2.n) this.f1165k).h();
    }

    @Override // d2.n
    public void i(int i9) {
        ((d2.n) this.f1165k).i(i9);
    }

    @Override // d2.n
    public int j(int i9, int i10, byte[] bArr) {
        return ((d2.n) this.f1165k).j(i9, i10, bArr);
    }

    @Override // d2.o
    public d2.d0 l(int i9, int i10) {
        return ((d2.o) this.f1165k).l(i9, i10);
    }

    @Override // d2.n
    public boolean n(byte[] bArr, int i9, int i10, boolean z8) {
        return ((d2.n) this.f1165k).n(bArr, i9, i10, z8);
    }

    @Override // d2.n
    public long o() {
        return ((d2.n) this.f1165k).o() - this.f1164j;
    }

    @Override // d2.n
    public void p(int i9) {
        ((d2.n) this.f1165k).p(i9);
    }

    public void q(int i9) {
        if (i9 < 64) {
            this.f1164j &= ~(1 << i9);
            return;
        }
        d0 d0Var = (d0) this.f1165k;
        if (d0Var != null) {
            d0Var.q(i9 - 64);
        }
    }

    public int r(int i9) {
        d0 d0Var = (d0) this.f1165k;
        if (d0Var == null) {
            long j5 = this.f1164j;
            return i9 >= 64 ? Long.bitCount(j5) : Long.bitCount(((1 << i9) - 1) & j5);
        }
        if (i9 < 64) {
            return Long.bitCount(this.f1164j & ((1 << i9) - 1));
        }
        return Long.bitCount(this.f1164j) + d0Var.r(i9 - 64);
    }

    @Override // d1.k
    public int read(byte[] bArr, int i9, int i10) {
        return ((d2.n) this.f1165k).read(bArr, i9, i10);
    }

    @Override // d2.n
    public void readFully(byte[] bArr, int i9, int i10) {
        ((d2.n) this.f1165k).readFully(bArr, i9, i10);
    }

    public void s() {
        if (((d0) this.f1165k) == null) {
            this.f1165k = new d0(5);
        }
    }

    @Override // d2.o
    public void t(d2.y yVar) {
        ((d2.o) this.f1165k).t(new k2.c(this, yVar, yVar));
    }

    public String toString() {
        switch (this.f1163i) {
            case 5:
                if (((d0) this.f1165k) == null) {
                    return Long.toBinaryString(this.f1164j);
                }
                return ((d0) this.f1165k).toString() + "xx" + Long.toBinaryString(this.f1164j);
            default:
                return super.toString();
        }
    }

    public boolean u(int i9) {
        if (i9 < 64) {
            return (this.f1164j & (1 << i9)) != 0;
        }
        s();
        return ((d0) this.f1165k).u(i9 - 64);
    }

    public void v(int i9, boolean z8) {
        if (i9 >= 64) {
            s();
            ((d0) this.f1165k).v(i9 - 64, z8);
            return;
        }
        long j5 = this.f1164j;
        boolean z9 = (Long.MIN_VALUE & j5) != 0;
        long j9 = (1 << i9) - 1;
        this.f1164j = ((j5 & (~j9)) << 1) | (j5 & j9);
        if (z8) {
            y(i9);
        } else {
            q(i9);
        }
        if (z9 || ((d0) this.f1165k) != null) {
            s();
            ((d0) this.f1165k).v(0, z9);
        }
    }

    public boolean w(int i9) {
        if (i9 >= 64) {
            s();
            return ((d0) this.f1165k).w(i9 - 64);
        }
        long j5 = 1 << i9;
        long j9 = this.f1164j;
        boolean z8 = (j9 & j5) != 0;
        long j10 = j9 & (~j5);
        this.f1164j = j10;
        long j11 = j5 - 1;
        this.f1164j = (j10 & j11) | Long.rotateRight((~j11) & j10, 1);
        d0 d0Var = (d0) this.f1165k;
        if (d0Var != null) {
            if (d0Var.u(0)) {
                y(63);
            }
            ((d0) this.f1165k).w(0);
        }
        return z8;
    }

    public void x() {
        this.f1164j = 0L;
        d0 d0Var = (d0) this.f1165k;
        if (d0Var != null) {
            d0Var.x();
        }
    }

    public void y(int i9) {
        if (i9 < 64) {
            this.f1164j |= 1 << i9;
        } else {
            s();
            ((d0) this.f1165k).y(i9 - 64);
        }
    }

    public void z(Exception exc) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (((Exception) this.f1165k) == null) {
            this.f1165k = exc;
            this.f1164j = 100 + elapsedRealtime;
        }
        if (elapsedRealtime >= this.f1164j) {
            Exception exc2 = (Exception) this.f1165k;
            if (exc2 != exc) {
                exc2.addSuppressed(exc);
            }
            Exception exc3 = (Exception) this.f1165k;
            this.f1165k = null;
            throw exc3;
        }
    }

    public d0(d2.n nVar, long j5) {
        this.f1163i = 2;
        this.f1165k = nVar;
        g1.a.f(nVar.getPosition() >= j5);
        this.f1164j = j5;
    }

    public /* synthetic */ d0(int i9, long j5, Object obj) {
        this.f1163i = i9;
        this.f1164j = j5;
        this.f1165k = obj;
    }

    public d0(int i9) {
        this.f1163i = i9;
        switch (i9) {
            case 5:
                this.f1164j = 0L;
                break;
        }
    }
}
