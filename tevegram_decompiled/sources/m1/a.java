package m1;

import d1.y0;
import java.util.Arrays;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f6500a;

    /* renamed from: b, reason: collision with root package name */
    public final y0 f6501b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6502c;

    /* renamed from: d, reason: collision with root package name */
    public final z f6503d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6504e;

    /* renamed from: f, reason: collision with root package name */
    public final y0 f6505f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6506g;
    public final z h;

    /* renamed from: i, reason: collision with root package name */
    public final long f6507i;

    /* renamed from: j, reason: collision with root package name */
    public final long f6508j;

    public a(long j5, y0 y0Var, int i9, z zVar, long j9, y0 y0Var2, int i10, z zVar2, long j10, long j11) {
        this.f6500a = j5;
        this.f6501b = y0Var;
        this.f6502c = i9;
        this.f6503d = zVar;
        this.f6504e = j9;
        this.f6505f = y0Var2;
        this.f6506g = i10;
        this.h = zVar2;
        this.f6507i = j10;
        this.f6508j = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f6500a == aVar.f6500a && this.f6502c == aVar.f6502c && this.f6504e == aVar.f6504e && this.f6506g == aVar.f6506g && this.f6507i == aVar.f6507i && this.f6508j == aVar.f6508j && android.support.v4.media.session.b.G(this.f6501b, aVar.f6501b) && android.support.v4.media.session.b.G(this.f6503d, aVar.f6503d) && android.support.v4.media.session.b.G(this.f6505f, aVar.f6505f) && android.support.v4.media.session.b.G(this.h, aVar.h);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f6500a), this.f6501b, Integer.valueOf(this.f6502c), this.f6503d, Long.valueOf(this.f6504e), this.f6505f, Integer.valueOf(this.f6506g), this.h, Long.valueOf(this.f6507i), Long.valueOf(this.f6508j)});
    }
}
