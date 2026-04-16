package p8;

import i8.k0;
import i8.s;
import java.util.concurrent.Executor;
import n8.v;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends k0 implements Executor {

    /* renamed from: k, reason: collision with root package name */
    public static final c f8280k = new c();

    /* renamed from: l, reason: collision with root package name */
    public static final s f8281l;

    static {
        s sVar = k.f8296k;
        int i9 = v.f7535a;
        if (64 >= i9) {
            i9 = 64;
        }
        int j5 = n8.a.j(i9, 12, "kotlinx.coroutines.io.parallelism");
        sVar.getClass();
        if (j5 < 1) {
            throw new IllegalArgumentException(androidx.activity.g.m(j5, "Expected positive parallelism level, but got ").toString());
        }
        if (j5 < j.f8292d) {
            if (j5 < 1) {
                throw new IllegalArgumentException(androidx.activity.g.m(j5, "Expected positive parallelism level, but got ").toString());
            }
            sVar = new n8.i(sVar, j5);
        }
        f8281l = sVar;
    }

    @Override // i8.s
    public final void c(r7.g gVar, Runnable runnable) {
        f8281l.c(gVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c(r7.h.f8615i, runnable);
    }

    @Override // i8.s
    public final void f(r7.g gVar, Runnable runnable) {
        f8281l.f(gVar, runnable);
    }

    @Override // i8.s
    public final String toString() {
        return "Dispatchers.IO";
    }
}
