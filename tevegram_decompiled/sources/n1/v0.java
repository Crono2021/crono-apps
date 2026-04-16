package n1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v0 extends e1.e {

    /* renamed from: i, reason: collision with root package name */
    public static final int f7382i = Float.floatToIntBits(Float.NaN);

    public static void l(int i9, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i9 * 4.656612875245797E-10d));
        if (floatToIntBits == f7382i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // e1.d
    public final void f(ByteBuffer byteBuffer) {
        ByteBuffer k3;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i9 = limit - position;
        int i10 = this.f3024b.f3021c;
        if (i10 == 21) {
            k3 = k((i9 / 3) * 4);
            while (position < limit) {
                l(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), k3);
                position += 3;
            }
        } else if (i10 == 22) {
            k3 = k(i9);
            while (position < limit) {
                l((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), k3);
                position += 4;
            }
        } else if (i10 == 1342177280) {
            k3 = k((i9 / 3) * 4);
            while (position < limit) {
                l(((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), k3);
                position += 3;
            }
        } else {
            if (i10 != 1610612736) {
                androidx.fragment.app.a.l();
                return;
            }
            k3 = k(i9);
            while (position < limit) {
                l((byteBuffer.get(position + 3) & 255) | ((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), k3);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        k3.flip();
    }

    @Override // e1.e
    public final e1.b g(e1.b bVar) {
        int i9 = bVar.f3021c;
        if (i9 == 21 || i9 == 1342177280 || i9 == 22 || i9 == 1610612736 || i9 == 4) {
            return i9 != 4 ? new e1.b(bVar.f3019a, bVar.f3020b, 4) : e1.b.f3018e;
        }
        throw new e1.c(bVar);
    }
}
