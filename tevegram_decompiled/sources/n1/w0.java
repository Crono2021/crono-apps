package n1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w0 extends e1.e {

    /* renamed from: i, reason: collision with root package name */
    public int f7383i;

    /* renamed from: j, reason: collision with root package name */
    public int f7384j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7385k;

    /* renamed from: l, reason: collision with root package name */
    public int f7386l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f7387m;

    /* renamed from: n, reason: collision with root package name */
    public int f7388n;

    /* renamed from: o, reason: collision with root package name */
    public long f7389o;

    @Override // e1.e, e1.d
    public final boolean a() {
        return super.a() && this.f7388n == 0;
    }

    @Override // e1.e, e1.d
    public final ByteBuffer d() {
        int i9;
        if (super.a() && (i9 = this.f7388n) > 0) {
            k(i9).put(this.f7387m, 0, this.f7388n).flip();
            this.f7388n = 0;
        }
        return super.d();
    }

    @Override // e1.d
    public final void f(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i9 = limit - position;
        if (i9 == 0) {
            return;
        }
        int min = Math.min(i9, this.f7386l);
        this.f7389o += min / this.f3024b.f3022d;
        this.f7386l -= min;
        byteBuffer.position(position + min);
        if (this.f7386l > 0) {
            return;
        }
        int i10 = i9 - min;
        int length = (this.f7388n + i10) - this.f7387m.length;
        ByteBuffer k3 = k(length);
        int h = g1.w.h(length, 0, this.f7388n);
        k3.put(this.f7387m, 0, h);
        int h9 = g1.w.h(length - h, 0, i10);
        byteBuffer.limit(byteBuffer.position() + h9);
        k3.put(byteBuffer);
        byteBuffer.limit(limit);
        int i11 = i10 - h9;
        int i12 = this.f7388n - h;
        this.f7388n = i12;
        byte[] bArr = this.f7387m;
        System.arraycopy(bArr, h, bArr, 0, i12);
        byteBuffer.get(this.f7387m, this.f7388n, i11);
        this.f7388n += i11;
        k3.flip();
    }

    @Override // e1.e
    public final e1.b g(e1.b bVar) {
        if (bVar.f3021c != 2) {
            throw new e1.c(bVar);
        }
        this.f7385k = true;
        return (this.f7383i == 0 && this.f7384j == 0) ? e1.b.f3018e : bVar;
    }

    @Override // e1.e
    public final void h() {
        if (this.f7385k) {
            this.f7385k = false;
            int i9 = this.f7384j;
            int i10 = this.f3024b.f3022d;
            this.f7387m = new byte[i9 * i10];
            this.f7386l = this.f7383i * i10;
        }
        this.f7388n = 0;
    }

    @Override // e1.e
    public final void i() {
        if (this.f7385k) {
            if (this.f7388n > 0) {
                this.f7389o += r0 / this.f3024b.f3022d;
            }
            this.f7388n = 0;
        }
    }

    @Override // e1.e
    public final void j() {
        this.f7387m = g1.w.f3718f;
    }
}
