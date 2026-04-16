package n1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 extends e1.e {

    /* renamed from: i, reason: collision with root package name */
    public int[] f7241i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f7242j;

    @Override // e1.d
    public final void f(ByteBuffer byteBuffer) {
        int[] iArr = this.f7242j;
        iArr.getClass();
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer k3 = k(((limit - position) / this.f3024b.f3022d) * this.f3025c.f3022d);
        while (position < limit) {
            for (int i9 : iArr) {
                k3.putShort(byteBuffer.getShort((i9 * 2) + position));
            }
            position += this.f3024b.f3022d;
        }
        byteBuffer.position(limit);
        k3.flip();
    }

    @Override // e1.e
    public final e1.b g(e1.b bVar) {
        int[] iArr = this.f7241i;
        if (iArr == null) {
            return e1.b.f3018e;
        }
        int i9 = bVar.f3021c;
        int i10 = bVar.f3020b;
        if (i9 != 2) {
            throw new e1.c(bVar);
        }
        boolean z8 = i10 != iArr.length;
        int i11 = 0;
        while (i11 < iArr.length) {
            int i12 = iArr[i11];
            if (i12 >= i10) {
                throw new e1.c(bVar);
            }
            z8 |= i12 != i11;
            i11++;
        }
        return z8 ? new e1.b(bVar.f3019a, iArr.length, 2) : e1.b.f3018e;
    }

    @Override // e1.e
    public final void h() {
        this.f7242j = this.f7241i;
    }

    @Override // e1.e
    public final void j() {
        this.f7242j = null;
        this.f7241i = null;
    }
}
