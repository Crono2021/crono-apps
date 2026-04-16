package e1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e implements d {

    /* renamed from: b, reason: collision with root package name */
    public b f3024b;

    /* renamed from: c, reason: collision with root package name */
    public b f3025c;

    /* renamed from: d, reason: collision with root package name */
    public b f3026d;

    /* renamed from: e, reason: collision with root package name */
    public b f3027e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f3028f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f3029g;
    public boolean h;

    public e() {
        ByteBuffer byteBuffer = d.f3023a;
        this.f3028f = byteBuffer;
        this.f3029g = byteBuffer;
        b bVar = b.f3018e;
        this.f3026d = bVar;
        this.f3027e = bVar;
        this.f3024b = bVar;
        this.f3025c = bVar;
    }

    @Override // e1.d
    public boolean a() {
        return this.h && this.f3029g == d.f3023a;
    }

    @Override // e1.d
    public boolean b() {
        return this.f3027e != b.f3018e;
    }

    @Override // e1.d
    public final b c(b bVar) {
        this.f3026d = bVar;
        this.f3027e = g(bVar);
        return b() ? this.f3027e : b.f3018e;
    }

    @Override // e1.d
    public ByteBuffer d() {
        ByteBuffer byteBuffer = this.f3029g;
        this.f3029g = d.f3023a;
        return byteBuffer;
    }

    @Override // e1.d
    public final void e() {
        this.h = true;
        i();
    }

    @Override // e1.d
    public final void flush() {
        this.f3029g = d.f3023a;
        this.h = false;
        this.f3024b = this.f3026d;
        this.f3025c = this.f3027e;
        h();
    }

    public abstract b g(b bVar);

    public final ByteBuffer k(int i9) {
        if (this.f3028f.capacity() < i9) {
            this.f3028f = ByteBuffer.allocateDirect(i9).order(ByteOrder.nativeOrder());
        } else {
            this.f3028f.clear();
        }
        ByteBuffer byteBuffer = this.f3028f;
        this.f3029g = byteBuffer;
        return byteBuffer;
    }

    @Override // e1.d
    public final void reset() {
        flush();
        this.f3028f = d.f3023a;
        b bVar = b.f3018e;
        this.f3026d = bVar;
        this.f3027e = bVar;
        this.f3024b = bVar;
        this.f3025c = bVar;
        j();
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }
}
