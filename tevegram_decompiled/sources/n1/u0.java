package n1;

import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u0 extends e1.e {

    /* renamed from: o, reason: collision with root package name */
    public int f7370o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7371p;

    /* renamed from: q, reason: collision with root package name */
    public int f7372q;

    /* renamed from: r, reason: collision with root package name */
    public long f7373r;

    /* renamed from: t, reason: collision with root package name */
    public byte[] f7375t;

    /* renamed from: w, reason: collision with root package name */
    public byte[] f7378w;

    /* renamed from: s, reason: collision with root package name */
    public int f7374s = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f7376u = 0;

    /* renamed from: v, reason: collision with root package name */
    public int f7377v = 0;

    /* renamed from: l, reason: collision with root package name */
    public final long f7367l = 100000;

    /* renamed from: i, reason: collision with root package name */
    public final float f7364i = 0.2f;

    /* renamed from: m, reason: collision with root package name */
    public final long f7368m = 2000000;

    /* renamed from: k, reason: collision with root package name */
    public final int f7366k = 10;

    /* renamed from: j, reason: collision with root package name */
    public final short f7365j = 1024;

    /* renamed from: n, reason: collision with root package name */
    public e1.b f7369n = e1.b.f3018e;

    public u0() {
        byte[] bArr = g1.w.f3718f;
        this.f7375t = bArr;
        this.f7378w = bArr;
    }

    @Override // e1.e, e1.d
    public final boolean b() {
        return this.f7369n.f3019a != -1 && this.f7371p;
    }

    @Override // e1.d
    public final void f(ByteBuffer byteBuffer) {
        int limit;
        int position;
        while (byteBuffer.hasRemaining() && !this.f3029g.hasRemaining()) {
            int i9 = this.f7372q;
            short s8 = this.f7365j;
            if (i9 == 0) {
                int limit2 = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit2, byteBuffer.position() + this.f7375t.length));
                int limit3 = byteBuffer.limit() - 1;
                while (true) {
                    if (limit3 < byteBuffer.position()) {
                        position = byteBuffer.position();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(limit3) << 8) | (byteBuffer.get(limit3 - 1) & 255)) > s8) {
                        int i10 = this.f7370o;
                        position = ((limit3 / i10) * i10) + i10;
                        break;
                    }
                    limit3 -= 2;
                }
                if (position == byteBuffer.position()) {
                    this.f7372q = 1;
                } else {
                    byteBuffer.limit(Math.min(position, byteBuffer.capacity()));
                    k(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(limit2);
            } else {
                if (i9 != 1) {
                    androidx.fragment.app.a.l();
                    return;
                }
                g1.a.k(this.f7376u < this.f7375t.length);
                int limit4 = byteBuffer.limit();
                int position2 = byteBuffer.position() + 1;
                while (true) {
                    if (position2 >= byteBuffer.limit()) {
                        limit = byteBuffer.limit();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(position2) << 8) | (byteBuffer.get(position2 - 1) & 255)) > s8) {
                        int i11 = this.f7370o;
                        limit = (position2 / i11) * i11;
                        break;
                    }
                    position2 += 2;
                }
                int position3 = limit - byteBuffer.position();
                int i12 = this.f7376u;
                int i13 = this.f7377v;
                int i14 = i12 + i13;
                byte[] bArr = this.f7375t;
                if (i14 < bArr.length) {
                    i12 = bArr.length;
                } else {
                    i14 = i13 - (bArr.length - i12);
                }
                int i15 = i12 - i14;
                boolean z8 = limit < limit4;
                int min = Math.min(position3, i15);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuffer.get(this.f7375t, i14, min);
                int i16 = this.f7377v + min;
                this.f7377v = i16;
                g1.a.k(i16 <= this.f7375t.length);
                boolean z9 = z8 && position3 < i15;
                m(z9);
                if (z9) {
                    this.f7372q = 0;
                    this.f7374s = 0;
                }
                byteBuffer.limit(limit4);
            }
        }
    }

    @Override // e1.e
    public final e1.b g(e1.b bVar) {
        if (bVar.f3021c != 2) {
            throw new e1.c(bVar);
        }
        this.f7369n = bVar;
        this.f7370o = bVar.f3020b * 2;
        return bVar;
    }

    @Override // e1.e
    public final void h() {
        if (b()) {
            int i9 = ((int) ((this.f7367l * this.f7369n.f3019a) / 1000000)) / 2;
            int i10 = this.f7370o;
            int i11 = (i9 / i10) * i10 * 2;
            if (this.f7375t.length != i11) {
                this.f7375t = new byte[i11];
                this.f7378w = new byte[i11];
            }
        }
        this.f7372q = 0;
        this.f7373r = 0L;
        this.f7374s = 0;
        this.f7376u = 0;
        this.f7377v = 0;
    }

    @Override // e1.e
    public final void i() {
        if (this.f7377v > 0) {
            m(true);
            this.f7374s = 0;
        }
    }

    @Override // e1.e
    public final void j() {
        this.f7371p = false;
        this.f7369n = e1.b.f3018e;
        byte[] bArr = g1.w.f3718f;
        this.f7375t = bArr;
        this.f7378w = bArr;
    }

    public final int l(int i9) {
        int length = ((((int) ((this.f7368m * this.f7369n.f3019a) / 1000000)) - this.f7374s) * this.f7370o) - (this.f7375t.length / 2);
        g1.a.k(length >= 0);
        int min = (int) Math.min((i9 * this.f7364i) + 0.5f, length);
        int i10 = this.f7370o;
        return (min / i10) * i10;
    }

    public final void m(boolean z8) {
        int length;
        int l4;
        int i9 = this.f7377v;
        byte[] bArr = this.f7375t;
        if (i9 == bArr.length || z8) {
            if (this.f7374s == 0) {
                if (z8) {
                    n(i9, 3);
                    length = i9;
                } else {
                    g1.a.k(i9 >= bArr.length / 2);
                    length = this.f7375t.length / 2;
                    n(length, 0);
                }
                l4 = length;
            } else if (z8) {
                int length2 = i9 - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int l9 = l(length2) + (this.f7375t.length / 2);
                n(l9, 2);
                l4 = l9;
                length = length3;
            } else {
                length = i9 - (bArr.length / 2);
                l4 = l(length);
                n(l4, 1);
            }
            boolean z9 = length % this.f7370o == 0;
            String m9 = androidx.activity.g.m(length, "bytesConsumed is not aligned to frame size: %s");
            if (!z9) {
                m7.c.p(m9);
                return;
            }
            g1.a.k(i9 >= l4);
            this.f7377v -= length;
            int i10 = this.f7376u + length;
            this.f7376u = i10;
            this.f7376u = i10 % this.f7375t.length;
            this.f7374s = (l4 / this.f7370o) + this.f7374s;
            this.f7373r += (length - l4) / r2;
        }
    }

    public final void n(int i9, int i10) {
        if (i9 == 0) {
            return;
        }
        g1.a.f(this.f7377v >= i9);
        int i11 = this.f7376u;
        if (i10 == 2) {
            int i12 = this.f7377v;
            int i13 = i11 + i12;
            byte[] bArr = this.f7375t;
            if (i13 <= bArr.length) {
                System.arraycopy(bArr, i13 - i9, this.f7378w, 0, i9);
            } else {
                int length = i12 - (bArr.length - i11);
                byte[] bArr2 = this.f7378w;
                if (length >= i9) {
                    System.arraycopy(bArr, length - i9, bArr2, 0, i9);
                } else {
                    int i14 = i9 - length;
                    System.arraycopy(bArr, bArr.length - i14, bArr2, 0, i14);
                    System.arraycopy(this.f7375t, 0, this.f7378w, i14, length);
                }
            }
        } else {
            int i15 = i11 + i9;
            byte[] bArr3 = this.f7375t;
            int length2 = bArr3.length;
            byte[] bArr4 = this.f7378w;
            if (i15 <= length2) {
                System.arraycopy(bArr3, i11, bArr4, 0, i9);
            } else {
                int length3 = bArr3.length - i11;
                System.arraycopy(bArr3, i11, bArr4, 0, length3);
                System.arraycopy(this.f7375t, 0, this.f7378w, length3, i9 - length3);
            }
        }
        g1.a.e("sizeToOutput is not aligned to frame size: " + i9, i9 % this.f7370o == 0);
        g1.a.k(this.f7376u < this.f7375t.length);
        byte[] bArr5 = this.f7378w;
        g1.a.e("byteOutput size is not aligned to frame size " + i9, i9 % this.f7370o == 0);
        if (i10 != 3) {
            for (int i16 = 0; i16 < i9; i16 += 2) {
                int i17 = i16 + 1;
                int i18 = (bArr5[i17] << 8) | (bArr5[i16] & 255);
                int i19 = this.f7366k;
                if (i10 == 0) {
                    i19 = ((((i16 * IjkMediaCodecInfo.RANK_MAX) / (i9 - 1)) * (i19 - 100)) / IjkMediaCodecInfo.RANK_MAX) + 100;
                } else if (i10 == 2) {
                    i19 += (((i16 * IjkMediaCodecInfo.RANK_MAX) * (100 - i19)) / (i9 - 1)) / IjkMediaCodecInfo.RANK_MAX;
                }
                int i20 = (i18 * i19) / 100;
                if (i20 >= 32767) {
                    bArr5[i16] = -1;
                    bArr5[i17] = Byte.MAX_VALUE;
                } else if (i20 <= -32768) {
                    bArr5[i16] = 0;
                    bArr5[i17] = Byte.MIN_VALUE;
                } else {
                    bArr5[i16] = (byte) (i20 & 255);
                    bArr5[i17] = (byte) (i20 >> 8);
                }
            }
        }
        k(i9).put(bArr5, 0, i9).flip();
    }
}
