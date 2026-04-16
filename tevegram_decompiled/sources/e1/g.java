package e1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements d {

    /* renamed from: b, reason: collision with root package name */
    public int f3051b;

    /* renamed from: c, reason: collision with root package name */
    public float f3052c;

    /* renamed from: d, reason: collision with root package name */
    public float f3053d;

    /* renamed from: e, reason: collision with root package name */
    public b f3054e;

    /* renamed from: f, reason: collision with root package name */
    public b f3055f;

    /* renamed from: g, reason: collision with root package name */
    public b f3056g;
    public b h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3057i;

    /* renamed from: j, reason: collision with root package name */
    public f f3058j;

    /* renamed from: k, reason: collision with root package name */
    public ByteBuffer f3059k;

    /* renamed from: l, reason: collision with root package name */
    public ShortBuffer f3060l;

    /* renamed from: m, reason: collision with root package name */
    public ByteBuffer f3061m;

    /* renamed from: n, reason: collision with root package name */
    public long f3062n;

    /* renamed from: o, reason: collision with root package name */
    public long f3063o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3064p;

    @Override // e1.d
    public final boolean a() {
        if (!this.f3064p) {
            return false;
        }
        f fVar = this.f3058j;
        return fVar == null || (fVar.f3041m * fVar.f3031b) * 2 == 0;
    }

    @Override // e1.d
    public final boolean b() {
        if (this.f3055f.f3019a != -1) {
            return Math.abs(this.f3052c - 1.0f) >= 1.0E-4f || Math.abs(this.f3053d - 1.0f) >= 1.0E-4f || this.f3055f.f3019a != this.f3054e.f3019a;
        }
        return false;
    }

    @Override // e1.d
    public final b c(b bVar) {
        if (bVar.f3021c != 2) {
            throw new c(bVar);
        }
        int i9 = this.f3051b;
        if (i9 == -1) {
            i9 = bVar.f3019a;
        }
        this.f3054e = bVar;
        b bVar2 = new b(i9, bVar.f3020b, 2);
        this.f3055f = bVar2;
        this.f3057i = true;
        return bVar2;
    }

    @Override // e1.d
    public final ByteBuffer d() {
        f fVar = this.f3058j;
        if (fVar != null) {
            int i9 = fVar.f3031b;
            int i10 = fVar.f3041m * i9 * 2;
            if (i10 > 0) {
                if (this.f3059k.capacity() < i10) {
                    ByteBuffer order = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
                    this.f3059k = order;
                    this.f3060l = order.asShortBuffer();
                } else {
                    this.f3059k.clear();
                    this.f3060l.clear();
                }
                ShortBuffer shortBuffer = this.f3060l;
                int min = Math.min(shortBuffer.remaining() / i9, fVar.f3041m);
                int i11 = min * i9;
                shortBuffer.put(fVar.f3040l, 0, i11);
                int i12 = fVar.f3041m - min;
                fVar.f3041m = i12;
                short[] sArr = fVar.f3040l;
                System.arraycopy(sArr, i11, sArr, 0, i12 * i9);
                this.f3063o += i10;
                this.f3059k.limit(i10);
                this.f3061m = this.f3059k;
            }
        }
        ByteBuffer byteBuffer = this.f3061m;
        this.f3061m = d.f3023a;
        return byteBuffer;
    }

    @Override // e1.d
    public final void e() {
        f fVar = this.f3058j;
        if (fVar != null) {
            int i9 = fVar.f3039k;
            float f9 = fVar.f3032c;
            float f10 = fVar.f3033d;
            int i10 = fVar.f3041m + ((int) ((((i9 / (f9 / f10)) + fVar.f3043o) / (fVar.f3034e * f10)) + 0.5f));
            short[] sArr = fVar.f3038j;
            int i11 = fVar.h * 2;
            fVar.f3038j = fVar.c(sArr, i9, i11 + i9);
            int i12 = 0;
            while (true) {
                int i13 = fVar.f3031b;
                if (i12 >= i11 * i13) {
                    break;
                }
                fVar.f3038j[(i13 * i9) + i12] = 0;
                i12++;
            }
            fVar.f3039k = i11 + fVar.f3039k;
            fVar.f();
            if (fVar.f3041m > i10) {
                fVar.f3041m = i10;
            }
            fVar.f3039k = 0;
            fVar.f3046r = 0;
            fVar.f3043o = 0;
        }
        this.f3064p = true;
    }

    @Override // e1.d
    public final void f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            f fVar = this.f3058j;
            fVar.getClass();
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f3062n += remaining;
            int remaining2 = asShortBuffer.remaining();
            int i9 = fVar.f3031b;
            int i10 = remaining2 / i9;
            short[] c9 = fVar.c(fVar.f3038j, fVar.f3039k, i10);
            fVar.f3038j = c9;
            asShortBuffer.get(c9, fVar.f3039k * i9, ((i10 * i9) * 2) / 2);
            fVar.f3039k += i10;
            fVar.f();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // e1.d
    public final void flush() {
        if (b()) {
            b bVar = this.f3054e;
            this.f3056g = bVar;
            b bVar2 = this.f3055f;
            this.h = bVar2;
            if (this.f3057i) {
                this.f3058j = new f(bVar.f3019a, bVar.f3020b, this.f3052c, this.f3053d, bVar2.f3019a);
            } else {
                f fVar = this.f3058j;
                if (fVar != null) {
                    fVar.f3039k = 0;
                    fVar.f3041m = 0;
                    fVar.f3043o = 0;
                    fVar.f3044p = 0;
                    fVar.f3045q = 0;
                    fVar.f3046r = 0;
                    fVar.f3047s = 0;
                    fVar.f3048t = 0;
                    fVar.f3049u = 0;
                    fVar.f3050v = 0;
                }
            }
        }
        this.f3061m = d.f3023a;
        this.f3062n = 0L;
        this.f3063o = 0L;
        this.f3064p = false;
    }

    @Override // e1.d
    public final void reset() {
        this.f3052c = 1.0f;
        this.f3053d = 1.0f;
        b bVar = b.f3018e;
        this.f3054e = bVar;
        this.f3055f = bVar;
        this.f3056g = bVar;
        this.h = bVar;
        ByteBuffer byteBuffer = d.f3023a;
        this.f3059k = byteBuffer;
        this.f3060l = byteBuffer.asShortBuffer();
        this.f3061m = byteBuffer;
        this.f3051b = -1;
        this.f3057i = false;
        this.f3058j = null;
        this.f3062n = 0L;
        this.f3063o = 0L;
        this.f3064p = false;
    }
}
