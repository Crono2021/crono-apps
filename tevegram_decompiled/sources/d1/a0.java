package d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f2348a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2349b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2350c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2351d;

    /* renamed from: e, reason: collision with root package name */
    public final float f2352e;

    static {
        new z().a();
        g1.w.H(0);
        g1.w.H(1);
        g1.w.H(2);
        g1.w.H(3);
        g1.w.H(4);
    }

    public a0(z zVar) {
        long j5 = zVar.f2611a;
        long j9 = zVar.f2612b;
        long j10 = zVar.f2613c;
        float f9 = zVar.f2614d;
        float f10 = zVar.f2615e;
        this.f2348a = j5;
        this.f2349b = j9;
        this.f2350c = j10;
        this.f2351d = f9;
        this.f2352e = f10;
    }

    public final z a() {
        z zVar = new z();
        zVar.f2611a = this.f2348a;
        zVar.f2612b = this.f2349b;
        zVar.f2613c = this.f2350c;
        zVar.f2614d = this.f2351d;
        zVar.f2615e = this.f2352e;
        return zVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f2348a == a0Var.f2348a && this.f2349b == a0Var.f2349b && this.f2350c == a0Var.f2350c && this.f2351d == a0Var.f2351d && this.f2352e == a0Var.f2352e;
    }

    public final int hashCode() {
        long j5 = this.f2348a;
        long j9 = this.f2349b;
        int i9 = ((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31;
        long j10 = this.f2350c;
        int i10 = (i9 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        float f9 = this.f2351d;
        int floatToIntBits = (i10 + (f9 != 0.0f ? Float.floatToIntBits(f9) : 0)) * 31;
        float f10 = this.f2352e;
        return floatToIntBits + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0);
    }
}
