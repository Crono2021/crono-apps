package e1;

import g1.w;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f3018e = new b(-1, -1, -1);

    /* renamed from: a, reason: collision with root package name */
    public final int f3019a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3020b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3021c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3022d;

    public b(int i9, int i10, int i11) {
        this.f3019a = i9;
        this.f3020b = i10;
        this.f3021c = i11;
        this.f3022d = w.I(i11) ? w.z(i11, i10) : -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3019a == bVar.f3019a && this.f3020b == bVar.f3020b && this.f3021c == bVar.f3021c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3019a), Integer.valueOf(this.f3020b), Integer.valueOf(this.f3021c)});
    }

    public final String toString() {
        return "AudioFormat[sampleRate=" + this.f3019a + ", channelCount=" + this.f3020b + ", encoding=" + this.f3021c + ']';
    }
}
