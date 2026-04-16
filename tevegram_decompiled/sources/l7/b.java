package l7;

import i7.d3;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements e1.d {

    /* renamed from: b, reason: collision with root package name */
    public boolean f6278b;

    /* renamed from: c, reason: collision with root package name */
    public e1.b f6279c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f6280d;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f6281e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6282f;

    /* renamed from: g, reason: collision with root package name */
    public d3 f6283g;

    @Override // e1.d
    public final boolean a() {
        return this.f6282f && this.f6281e == e1.d.f3023a;
    }

    @Override // e1.d
    public final boolean b() {
        return this.f6278b;
    }

    @Override // e1.d
    public final e1.b c(e1.b bVar) {
        if (bVar.f3021c != 2) {
            throw new e1.c(bVar);
        }
        this.f6279c = bVar;
        this.f6278b = true;
        return bVar;
    }

    @Override // e1.d
    public final ByteBuffer d() {
        ByteBuffer byteBuffer = this.f6281e;
        ByteBuffer byteBuffer2 = e1.d.f3023a;
        byteBuffer2.getClass();
        this.f6281e = byteBuffer2;
        return byteBuffer;
    }

    @Override // e1.d
    public final void e() {
        this.f6282f = true;
    }

    @Override // e1.d
    public final void f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            int remaining = byteBuffer.remaining();
            d3 d3Var = this.f6283g;
            if (d3Var != null) {
                short[] sArr = new short[remaining / 2];
                byteBuffer.duplicate().order(ByteOrder.nativeOrder()).asShortBuffer().get(sArr);
                d3Var.c(sArr, Integer.valueOf(this.f6279c.f3020b), Integer.valueOf(this.f6279c.f3019a));
            }
            if (this.f6280d.capacity() < remaining) {
                ByteBuffer order = ByteBuffer.allocateDirect(remaining).order(ByteOrder.nativeOrder());
                order.getClass();
                this.f6280d = order;
            } else {
                this.f6280d.clear();
            }
            this.f6280d.put(byteBuffer);
            this.f6280d.flip();
            this.f6281e = this.f6280d;
        }
    }

    @Override // e1.d
    public final void flush() {
        ByteBuffer byteBuffer = e1.d.f3023a;
        byteBuffer.getClass();
        this.f6281e = byteBuffer;
        this.f6282f = false;
    }

    @Override // e1.d
    public final void reset() {
        flush();
        ByteBuffer byteBuffer = e1.d.f3023a;
        byteBuffer.getClass();
        this.f6280d = byteBuffer;
        e1.b bVar = e1.b.f3018e;
        bVar.getClass();
        this.f6279c = bVar;
        this.f6278b = false;
    }
}
