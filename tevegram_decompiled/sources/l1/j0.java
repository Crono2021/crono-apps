package l1;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f5929a;

    /* renamed from: b, reason: collision with root package name */
    public final float f5930b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5931c;

    public j0(i0 i0Var) {
        this.f5929a = i0Var.f5920a;
        this.f5930b = i0Var.f5921b;
        this.f5931c = i0Var.f5922c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return this.f5929a == j0Var.f5929a && this.f5930b == j0Var.f5930b && this.f5931c == j0Var.f5931c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f5929a), Float.valueOf(this.f5930b), Long.valueOf(this.f5931c)});
    }
}
