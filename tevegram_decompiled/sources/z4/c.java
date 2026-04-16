package z4;

import android.animation.TimeInterpolator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public long f10666a;

    /* renamed from: b, reason: collision with root package name */
    public long f10667b;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f10668c;

    /* renamed from: d, reason: collision with root package name */
    public int f10669d;

    /* renamed from: e, reason: collision with root package name */
    public int f10670e;

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f10668c;
        return timeInterpolator != null ? timeInterpolator : a.f10660b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f10666a == cVar.f10666a && this.f10667b == cVar.f10667b && this.f10669d == cVar.f10669d && this.f10670e == cVar.f10670e) {
            return a().getClass().equals(cVar.a().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f10666a;
        long j9 = this.f10667b;
        return ((((a().getClass().hashCode() + (((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31)) * 31) + this.f10669d) * 31) + this.f10670e;
    }

    public final String toString() {
        return "\n" + c.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.f10666a + " duration: " + this.f10667b + " interpolator: " + a().getClass() + " repeatCount: " + this.f10669d + " repeatMode: " + this.f10670e + "}\n";
    }
}
