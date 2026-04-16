package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9447a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9448b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9449c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9450d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9451e;

    public z(Object obj, int i9, int i10, long j5, int i11) {
        this.f9447a = obj;
        this.f9448b = i9;
        this.f9449c = i10;
        this.f9450d = j5;
        this.f9451e = i11;
    }

    public final z a(Object obj) {
        if (this.f9447a.equals(obj)) {
            return this;
        }
        return new z(obj, this.f9448b, this.f9449c, this.f9450d, this.f9451e);
    }

    public final boolean b() {
        return this.f9448b != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f9447a.equals(zVar.f9447a) && this.f9448b == zVar.f9448b && this.f9449c == zVar.f9449c && this.f9450d == zVar.f9450d && this.f9451e == zVar.f9451e;
    }

    public final int hashCode() {
        return ((((((((this.f9447a.hashCode() + 527) * 31) + this.f9448b) * 31) + this.f9449c) * 31) + ((int) this.f9450d)) * 31) + this.f9451e;
    }

    public z(long j5, Object obj) {
        this(obj, -1, -1, j5, -1);
    }

    public z(int i9, long j5, Object obj) {
        this(obj, -1, -1, j5, i9);
    }

    public z(Object obj) {
        this(-1L, obj);
    }
}
