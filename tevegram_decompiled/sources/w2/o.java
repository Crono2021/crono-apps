package w2;

import g1.w;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o implements d {

    /* renamed from: d, reason: collision with root package name */
    public static final a0.b f9802d = new a0.b(new a0.b(new a6.a(':'), 3), 4);

    /* renamed from: e, reason: collision with root package name */
    public static final a0.b f9803e = new a0.b(new a0.b(new a6.a('*'), 3), 4);

    /* renamed from: a, reason: collision with root package name */
    public int f9804a;

    /* renamed from: b, reason: collision with root package name */
    public int f9805b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f9806c;

    public o(b bVar, d1.s sVar) {
        g1.p pVar = bVar.f9714k;
        this.f9806c = pVar;
        pVar.F(12);
        int x6 = pVar.x();
        if ("audio/raw".equals(sVar.f2554m)) {
            int z8 = w.z(sVar.B, sVar.f2567z);
            if (x6 == 0 || x6 % z8 != 0) {
                g1.a.D("AtomParsers", "Audio sample size mismatch. stsd sample size: " + z8 + ", stsz sample size: " + x6);
                x6 = z8;
            }
        }
        this.f9804a = x6 == 0 ? -1 : x6;
        this.f9805b = pVar.x();
    }

    @Override // w2.d
    public int a() {
        return this.f9804a;
    }

    @Override // w2.d
    public int b() {
        return this.f9805b;
    }

    @Override // w2.d
    public int c() {
        int i9 = this.f9804a;
        return i9 == -1 ? ((g1.p) this.f9806c).x() : i9;
    }

    public o() {
        this.f9806c = new ArrayList();
        this.f9804a = 0;
    }
}
