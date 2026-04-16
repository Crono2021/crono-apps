package z2;

import b6.e0;
import b6.g0;
import b6.p;
import b6.u0;
import b6.w0;
import g1.w;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements f {

    /* renamed from: k, reason: collision with root package name */
    public static final p f10611k = new p(new w2.k(7), u0.f1460j);

    /* renamed from: i, reason: collision with root package name */
    public final g0 f10612i;

    /* renamed from: j, reason: collision with root package name */
    public final long[] f10613j;

    /* JADX WARN: Removed duplicated region for block: B:45:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0112 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(b6.w0 r19) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.b.<init>(b6.w0):void");
    }

    @Override // z2.f
    public final int g(long j5) {
        int b9 = w.b(j5, this.f10613j, false);
        if (b9 < this.f10612i.size()) {
            return b9;
        }
        return -1;
    }

    @Override // z2.f
    public final long j(int i9) {
        g1.a.f(i9 < this.f10612i.size());
        return this.f10613j[i9];
    }

    @Override // z2.f
    public final List q(long j5) {
        int c9 = w.c(j5, this.f10613j, false);
        if (c9 != -1) {
            return (g0) this.f10612i.get(c9);
        }
        e0 e0Var = g0.f1391j;
        return w0.f1464m;
    }

    @Override // z2.f
    public final int u() {
        return this.f10612i.size();
    }
}
