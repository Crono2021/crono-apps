package v1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import n.c4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n implements y {

    /* renamed from: a, reason: collision with root package name */
    public final c4 f9350a;

    /* renamed from: b, reason: collision with root package name */
    public final a5.d f9351b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9352c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9353d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9354e;

    /* renamed from: f, reason: collision with root package name */
    public final float f9355f;

    /* renamed from: g, reason: collision with root package name */
    public final float f9356g;

    public n(a5.d dVar, d2.k kVar) {
        this.f9351b = dVar;
        z2.c cVar = new z2.c(0);
        c4 c4Var = new c4();
        c4Var.f6834a = kVar;
        c4Var.f6839f = cVar;
        c4Var.f6835b = new HashMap();
        c4Var.f6836c = new HashSet();
        c4Var.f6837d = new HashMap();
        this.f9350a = c4Var;
        if (dVar != ((a5.d) c4Var.f6838e)) {
            c4Var.f6838e = dVar;
            ((HashMap) c4Var.f6835b).clear();
            ((HashMap) c4Var.f6837d).clear();
        }
        this.f9352c = -9223372036854775807L;
        this.f9353d = -9223372036854775807L;
        this.f9354e = -9223372036854775807L;
        this.f9355f = -3.4028235E38f;
        this.f9356g = -3.4028235E38f;
    }

    public static y e(Class cls, i1.g gVar) {
        try {
            return (y) cls.getConstructor(i1.g.class).newInstance(gVar);
        } catch (Exception e9) {
            throw new IllegalStateException(e9);
        }
    }

    @Override // v1.y
    public final y a() {
        c4 c4Var = this.f9350a;
        c4Var.getClass();
        synchronized (((d2.k) c4Var.f6834a)) {
        }
        Iterator it = ((HashMap) c4Var.f6837d).values().iterator();
        while (it.hasNext()) {
            ((y) it.next()).a();
        }
        return this;
    }

    @Override // v1.y
    public final /* bridge */ /* synthetic */ y b(z1.g gVar) {
        f(gVar);
        return this;
    }

    @Override // v1.y
    public final y c(z2.c cVar) {
        c4 c4Var = this.f9350a;
        c4Var.f6839f = cVar;
        d2.k kVar = (d2.k) c4Var.f6834a;
        synchronized (kVar) {
            kVar.f2711b = cVar;
        }
        Iterator it = ((HashMap) c4Var.f6837d).values().iterator();
        while (it.hasNext()) {
            ((y) it.next()).c(cVar);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e7  */
    /* JADX WARN: Type inference failed for: r7v0, types: [b6.g0] */
    @Override // v1.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v1.a d(d1.e0 r32) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.n.d(d1.e0):v1.a");
    }

    public final void f(z1.g gVar) {
        g1.a.j(gVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        c4 c4Var = this.f9350a;
        c4Var.f6840g = gVar;
        Iterator it = ((HashMap) c4Var.f6837d).values().iterator();
        while (it.hasNext()) {
            ((y) it.next()).b(gVar);
        }
    }

    public n(a5.d dVar) {
        this(dVar, new d2.k());
    }
}
