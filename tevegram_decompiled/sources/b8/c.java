package b8;

import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c implements f8.a, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public transient f8.a f1510i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f1511j;

    /* renamed from: k, reason: collision with root package name */
    public final Class f1512k;

    /* renamed from: l, reason: collision with root package name */
    public final String f1513l;

    /* renamed from: m, reason: collision with root package name */
    public final String f1514m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f1515n;

    public c(Object obj, Class cls, String str, String str2, boolean z8) {
        this.f1511j = obj;
        this.f1512k = cls;
        this.f1513l = str;
        this.f1514m = str2;
        this.f1515n = z8;
    }

    public final d b() {
        boolean z8 = this.f1515n;
        Class cls = this.f1512k;
        if (z8) {
            p.f1526a.getClass();
            return new k(cls);
        }
        p.f1526a.getClass();
        return new e(cls);
    }
}
