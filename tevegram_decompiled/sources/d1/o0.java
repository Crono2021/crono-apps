package d1;

import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o0 {

    /* renamed from: d, reason: collision with root package name */
    public static final o0 f2509d = new o0(1.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f2510a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2511b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2512c;

    static {
        g1.w.H(0);
        g1.w.H(1);
    }

    public o0(float f9, float f10) {
        g1.a.f(f9 > 0.0f);
        g1.a.f(f10 > 0.0f);
        this.f2510a = f9;
        this.f2511b = f10;
        this.f2512c = Math.round(f9 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o0.class == obj.getClass()) {
            o0 o0Var = (o0) obj;
            if (this.f2510a == o0Var.f2510a && this.f2511b == o0Var.f2511b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f2511b) + ((Float.floatToRawIntBits(this.f2510a) + 527) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.f2510a), Float.valueOf(this.f2511b)};
        int i9 = g1.w.f3713a;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }
}
