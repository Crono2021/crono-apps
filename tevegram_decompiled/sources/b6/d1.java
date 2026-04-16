package b6;

import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d1 extends v0 implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final v0 f1376i;

    public d1(v0 v0Var) {
        this.f1376i = v0Var;
    }

    @Override // b6.v0
    public final v0 a() {
        return this.f1376i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f1376i.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d1) {
            return this.f1376i.equals(((d1) obj).f1376i);
        }
        return false;
    }

    public final int hashCode() {
        return -this.f1376i.hashCode();
    }

    public final String toString() {
        return this.f1376i + ".reverse()";
    }
}
