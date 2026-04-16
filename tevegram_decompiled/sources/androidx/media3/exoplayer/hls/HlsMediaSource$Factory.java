package androidx.media3.exoplayer.hls;

import d.a;
import d1.b0;
import d1.e0;
import java.util.List;
import m1.b;
import o4.d;
import p1.c;
import p1.j;
import p1.m;
import q1.p;
import v1.y;
import z1.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class HlsMediaSource$Factory implements y {

    /* renamed from: a, reason: collision with root package name */
    public final c f984a;

    /* renamed from: f, reason: collision with root package name */
    public final a f989f = new a(1);

    /* renamed from: c, reason: collision with root package name */
    public final d f986c = new d(2);

    /* renamed from: d, reason: collision with root package name */
    public final m7.c f987d = q1.c.f8319w;

    /* renamed from: b, reason: collision with root package name */
    public final c f985b = j.f8134d;

    /* renamed from: g, reason: collision with root package name */
    public g f990g = new g();

    /* renamed from: e, reason: collision with root package name */
    public final d f988e = new d(15);

    /* renamed from: i, reason: collision with root package name */
    public final int f991i = 1;

    /* renamed from: j, reason: collision with root package name */
    public final long f992j = -9223372036854775807L;
    public final boolean h = true;

    public HlsMediaSource$Factory(i1.g gVar) {
        this.f984a = new c(gVar);
    }

    @Override // v1.y
    public final y a() {
        this.f985b.getClass();
        return this;
    }

    @Override // v1.y
    public final y b(g gVar) {
        g1.a.j(gVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f990g = gVar;
        return this;
    }

    @Override // v1.y
    public final y c(z2.c cVar) {
        this.f985b.f8103i = cVar;
        return this;
    }

    @Override // v1.y
    public final v1.a d(e0 e0Var) {
        b0 b0Var = e0Var.f2409b;
        b0Var.getClass();
        List list = b0Var.f2363c;
        boolean isEmpty = list.isEmpty();
        p pVar = this.f986c;
        if (!isEmpty) {
            pVar = new b(pVar, 14, list);
        }
        o1.g b9 = this.f989f.b(e0Var);
        g gVar = this.f990g;
        this.f987d.getClass();
        c cVar = this.f984a;
        return new m(e0Var, cVar, this.f985b, this.f988e, b9, gVar, new q1.c(cVar, gVar, pVar), this.f992j, this.h, this.f991i);
    }
}
