package n7;

import b8.i;
import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final Object f7486i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f7487j;

    /* renamed from: k, reason: collision with root package name */
    public final Number f7488k;

    public f(Object obj, Object obj2, Number number) {
        this.f7486i = obj;
        this.f7487j = obj2;
        this.f7488k = number;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f7486i.equals(fVar.f7486i) && i.a(this.f7487j, fVar.f7487j) && this.f7488k.equals(fVar.f7488k);
    }

    public final int hashCode() {
        int hashCode = this.f7486i.hashCode() * 31;
        Object obj = this.f7487j;
        return this.f7488k.hashCode() + ((hashCode + (obj == null ? 0 : obj.hashCode())) * 31);
    }

    public final String toString() {
        return "(" + this.f7486i + ", " + this.f7487j + ", " + this.f7488k + ')';
    }
}
