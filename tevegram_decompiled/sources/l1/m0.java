package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final v1.z f5955a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5956b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5957c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5958d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5959e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f5960f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5961g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f5962i;

    public m0(v1.z zVar, long j5, long j9, long j10, long j11, boolean z8, boolean z9, boolean z10, boolean z11) {
        boolean z12 = true;
        g1.a.f(!z11 || z9);
        g1.a.f(!z10 || z9);
        if (z8 && (z9 || z10 || z11)) {
            z12 = false;
        }
        g1.a.f(z12);
        this.f5955a = zVar;
        this.f5956b = j5;
        this.f5957c = j9;
        this.f5958d = j10;
        this.f5959e = j11;
        this.f5960f = z8;
        this.f5961g = z9;
        this.h = z10;
        this.f5962i = z11;
    }

    public final m0 a(long j5) {
        if (j5 == this.f5957c) {
            return this;
        }
        return new m0(this.f5955a, this.f5956b, j5, this.f5958d, this.f5959e, this.f5960f, this.f5961g, this.h, this.f5962i);
    }

    public final m0 b(long j5) {
        if (j5 == this.f5956b) {
            return this;
        }
        return new m0(this.f5955a, j5, this.f5957c, this.f5958d, this.f5959e, this.f5960f, this.f5961g, this.h, this.f5962i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m0.class == obj.getClass()) {
            m0 m0Var = (m0) obj;
            if (this.f5956b == m0Var.f5956b && this.f5957c == m0Var.f5957c && this.f5958d == m0Var.f5958d && this.f5959e == m0Var.f5959e && this.f5960f == m0Var.f5960f && this.f5961g == m0Var.f5961g && this.h == m0Var.h && this.f5962i == m0Var.f5962i && g1.w.a(this.f5955a, m0Var.f5955a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((this.f5955a.hashCode() + 527) * 31) + ((int) this.f5956b)) * 31) + ((int) this.f5957c)) * 31) + ((int) this.f5958d)) * 31) + ((int) this.f5959e)) * 31) + (this.f5960f ? 1 : 0)) * 31) + (this.f5961g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.f5962i ? 1 : 0);
    }
}
