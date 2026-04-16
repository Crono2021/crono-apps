package x2;

import d2.x;
import d2.y;
import d2.z;
import g1.w;
import java.math.BigInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements y {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f10042a;

    public a(b bVar) {
        this.f10042a = bVar;
    }

    @Override // d2.y
    public final boolean e() {
        return true;
    }

    @Override // d2.y
    public final x i(long j5) {
        b bVar = this.f10042a;
        long j9 = bVar.f10044j;
        BigInteger valueOf = BigInteger.valueOf((bVar.f10046l.f10082i * j5) / 1000000);
        long j10 = bVar.f10045k;
        z zVar = new z(j5, w.i((valueOf.multiply(BigInteger.valueOf(j10 - j9)).divide(BigInteger.valueOf(bVar.f10048n)).longValue() + j9) - 30000, bVar.f10044j, j10 - 1));
        return new x(zVar, zVar);
    }

    @Override // d2.y
    public final long k() {
        return (this.f10042a.f10048n * 1000000) / r0.f10046l.f10082i;
    }
}
