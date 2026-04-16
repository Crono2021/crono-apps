package f0;

import android.graphics.Insets;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f3192e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f3193a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3194b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3195c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3196d;

    public c(int i9, int i10, int i11, int i12) {
        this.f3193a = i9;
        this.f3194b = i10;
        this.f3195c = i11;
        this.f3196d = i12;
    }

    public static c a(c cVar, c cVar2) {
        return b(Math.max(cVar.f3193a, cVar2.f3193a), Math.max(cVar.f3194b, cVar2.f3194b), Math.max(cVar.f3195c, cVar2.f3195c), Math.max(cVar.f3196d, cVar2.f3196d));
    }

    public static c b(int i9, int i10, int i11, int i12) {
        return (i9 == 0 && i10 == 0 && i11 == 0 && i12 == 0) ? f3192e : new c(i9, i10, i11, i12);
    }

    public static c c(Insets insets) {
        int i9;
        int i10;
        int i11;
        int i12;
        i9 = insets.left;
        i10 = insets.top;
        i11 = insets.right;
        i12 = insets.bottom;
        return b(i9, i10, i11, i12);
    }

    public final Insets d() {
        return b.a(this.f3193a, this.f3194b, this.f3195c, this.f3196d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3196d == cVar.f3196d && this.f3193a == cVar.f3193a && this.f3195c == cVar.f3195c && this.f3194b == cVar.f3194b;
    }

    public final int hashCode() {
        return (((((this.f3193a * 31) + this.f3194b) * 31) + this.f3195c) * 31) + this.f3196d;
    }

    public final String toString() {
        return "Insets{left=" + this.f3193a + ", top=" + this.f3194b + ", right=" + this.f3195c + ", bottom=" + this.f3196d + '}';
    }
}
