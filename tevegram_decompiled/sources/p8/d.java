package p8;

import i8.k0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends k0 {

    /* renamed from: l, reason: collision with root package name */
    public static final d f8282l;

    /* renamed from: k, reason: collision with root package name */
    public b f8283k;

    static {
        int i9 = j.f8291c;
        int i10 = j.f8292d;
        long j5 = j.f8293e;
        String str = j.f8289a;
        d dVar = new d();
        dVar.f8283k = new b(i9, j5, str, i10);
        f8282l = dVar;
    }

    @Override // i8.s
    public final void c(r7.g gVar, Runnable runnable) {
        b.c(this.f8283k, runnable, 6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // i8.s
    public final void f(r7.g gVar, Runnable runnable) {
        b.c(this.f8283k, runnable, 2);
    }

    @Override // i8.s
    public final String toString() {
        return "Dispatchers.Default";
    }
}
