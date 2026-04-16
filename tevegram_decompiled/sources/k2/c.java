package k2;

import b2.d0;
import d2.r;
import d2.x;
import d2.y;
import d2.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends r {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f5537b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d0 f5538c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d0 d0Var, y yVar, y yVar2) {
        super(yVar);
        this.f5538c = d0Var;
        this.f5537b = yVar2;
    }

    @Override // d2.r, d2.y
    public final x i(long j5) {
        x i9 = this.f5537b.i(j5);
        z zVar = i9.f2753a;
        long j9 = zVar.f2756a;
        long j10 = zVar.f2757b;
        long j11 = this.f5538c.f1164j;
        z zVar2 = new z(j9, j10 + j11);
        z zVar3 = i9.f2754b;
        return new x(zVar2, new z(zVar3.f2756a, zVar3.f2757b + j11));
    }
}
