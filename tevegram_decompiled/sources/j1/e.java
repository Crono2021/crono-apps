package j1;

import d1.f0;
import d1.s;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class e extends g5.c {

    /* renamed from: k, reason: collision with root package name */
    public s f5357k;

    /* renamed from: l, reason: collision with root package name */
    public final a f5358l = new a();

    /* renamed from: m, reason: collision with root package name */
    public ByteBuffer f5359m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5360n;

    /* renamed from: o, reason: collision with root package name */
    public long f5361o;

    /* renamed from: p, reason: collision with root package name */
    public ByteBuffer f5362p;

    /* renamed from: q, reason: collision with root package name */
    public final int f5363q;

    /* renamed from: r, reason: collision with root package name */
    public final int f5364r;

    static {
        f0.a("media3.decoder");
    }

    public e(int i9, int i10) {
        this.f5363q = i9;
        this.f5364r = i10;
    }

    public void k() {
        this.f3748j = 0;
        ByteBuffer byteBuffer = this.f5359m;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f5362p;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f5360n = false;
    }

    public final ByteBuffer l(int i9) {
        int i10 = this.f5363q;
        if (i10 == 1) {
            return ByteBuffer.allocate(i9);
        }
        if (i10 == 2) {
            return ByteBuffer.allocateDirect(i9);
        }
        ByteBuffer byteBuffer = this.f5359m;
        throw new d("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i9 + ")");
    }

    public final void m(int i9) {
        int i10 = i9 + this.f5364r;
        ByteBuffer byteBuffer = this.f5359m;
        if (byteBuffer == null) {
            this.f5359m = l(i10);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i11 = i10 + position;
        if (capacity >= i11) {
            this.f5359m = byteBuffer;
            return;
        }
        ByteBuffer l4 = l(i11);
        l4.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            l4.put(byteBuffer);
        }
        this.f5359m = l4;
    }

    public final void n() {
        ByteBuffer byteBuffer = this.f5359m;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f5362p;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }
}
