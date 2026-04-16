package d4;

import java.security.MessageDigest;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s implements b4.f {

    /* renamed from: b, reason: collision with root package name */
    public final Object f2915b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2916c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2917d;

    /* renamed from: e, reason: collision with root package name */
    public final Class f2918e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f2919f;

    /* renamed from: g, reason: collision with root package name */
    public final b4.f f2920g;
    public final Map h;

    /* renamed from: i, reason: collision with root package name */
    public final b4.i f2921i;

    /* renamed from: j, reason: collision with root package name */
    public int f2922j;

    public s(Object obj, b4.f fVar, int i9, int i10, Map map, Class cls, Class cls2, b4.i iVar) {
        w4.f.c(obj, "Argument must not be null");
        this.f2915b = obj;
        this.f2920g = fVar;
        this.f2916c = i9;
        this.f2917d = i10;
        w4.f.c(map, "Argument must not be null");
        this.h = map;
        w4.f.c(cls, "Resource class must not be null");
        this.f2918e = cls;
        w4.f.c(cls2, "Transcode class must not be null");
        this.f2919f = cls2;
        w4.f.c(iVar, "Argument must not be null");
        this.f2921i = iVar;
    }

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.f2915b.equals(sVar.f2915b) && this.f2920g.equals(sVar.f2920g) && this.f2917d == sVar.f2917d && this.f2916c == sVar.f2916c && this.h.equals(sVar.h) && this.f2918e.equals(sVar.f2918e) && this.f2919f.equals(sVar.f2919f) && this.f2921i.equals(sVar.f2921i)) {
                return true;
            }
        }
        return false;
    }

    @Override // b4.f
    public final int hashCode() {
        if (this.f2922j == 0) {
            int hashCode = this.f2915b.hashCode();
            this.f2922j = hashCode;
            int hashCode2 = ((((this.f2920g.hashCode() + (hashCode * 31)) * 31) + this.f2916c) * 31) + this.f2917d;
            this.f2922j = hashCode2;
            int hashCode3 = this.h.hashCode() + (hashCode2 * 31);
            this.f2922j = hashCode3;
            int hashCode4 = this.f2918e.hashCode() + (hashCode3 * 31);
            this.f2922j = hashCode4;
            int hashCode5 = this.f2919f.hashCode() + (hashCode4 * 31);
            this.f2922j = hashCode5;
            this.f2922j = this.f2921i.f1331b.hashCode() + (hashCode5 * 31);
        }
        return this.f2922j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f2915b + ", width=" + this.f2916c + ", height=" + this.f2917d + ", resourceClass=" + this.f2918e + ", transcodeClass=" + this.f2919f + ", signature=" + this.f2920g + ", hashCode=" + this.f2922j + ", transformations=" + this.h + ", options=" + this.f2921i + '}';
    }
}
