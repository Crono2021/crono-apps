package d4;

import android.os.SystemClock;
import android.util.Log;
import b6.i0;
import g.j0;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import n.c4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n {
    public static final boolean h = Log.isLoggable("Engine", 2);

    /* renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.f f2883a;

    /* renamed from: b, reason: collision with root package name */
    public final t f2884b;

    /* renamed from: c, reason: collision with root package name */
    public final f4.e f2885c;

    /* renamed from: d, reason: collision with root package name */
    public final c4 f2886d;

    /* renamed from: e, reason: collision with root package name */
    public final d1.p f2887e;

    /* renamed from: f, reason: collision with root package name */
    public final i0 f2888f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.fragment.app.g f2889g;

    public n(f4.e eVar, a0.b bVar, g4.e eVar2, g4.e eVar3, g4.e eVar4, g4.e eVar5) {
        this.f2885c = eVar;
        c.a aVar = new c.a(bVar);
        androidx.fragment.app.g gVar = new androidx.fragment.app.g(3);
        this.f2889g = gVar;
        synchronized (this) {
            synchronized (gVar) {
                gVar.f730l = this;
            }
        }
        this.f2884b = new t(0);
        this.f2883a = new com.bumptech.glide.f(1);
        c4 c4Var = new c4();
        c4Var.f6840g = x4.c.a(150, new a0.b(c4Var, 18));
        c4Var.f6834a = eVar2;
        c4Var.f6835b = eVar3;
        c4Var.f6836c = eVar4;
        c4Var.f6837d = eVar5;
        c4Var.f6838e = this;
        c4Var.f6839f = this;
        this.f2886d = c4Var;
        this.f2888f = new i0(aVar);
        this.f2887e = new d1.p(1);
        eVar.f3380d = this;
    }

    public static void d(String str, long j5, s sVar) {
        Log.v("Engine", str + " in " + w4.h.a(j5) + "ms, key: " + sVar);
    }

    public static void g(a0 a0Var) {
        if (a0Var instanceof u) {
            ((u) a0Var).b();
        } else {
            m7.c.n("Cannot release anything but an EngineResource");
        }
    }

    public final androidx.fragment.app.g a(com.bumptech.glide.e eVar, Object obj, b4.f fVar, int i9, int i10, Class cls, Class cls2, com.bumptech.glide.g gVar, m mVar, w4.c cVar, boolean z8, boolean z9, b4.i iVar, boolean z10, boolean z11, s4.f fVar2, j0 j0Var) {
        long j5;
        if (h) {
            int i11 = w4.h.f9940b;
            j5 = SystemClock.elapsedRealtimeNanos();
        } else {
            j5 = 0;
        }
        this.f2884b.getClass();
        s sVar = new s(obj, fVar, i9, i10, cVar, cls, cls2, iVar);
        synchronized (this) {
            try {
                u c9 = c(sVar, z10, j5);
                if (c9 == null) {
                    return h(eVar, obj, fVar, i9, i10, cls, cls2, gVar, mVar, cVar, z8, z9, iVar, z10, z11, fVar2, j0Var, sVar, j5);
                }
                fVar2.h(c9, 5);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d4.u b(d4.s r10) {
        /*
            r9 = this;
            f4.e r1 = r9.f2885c
            monitor-enter(r1)
            java.util.LinkedHashMap r0 = r1.f9943a     // Catch: java.lang.Throwable -> L41
            java.lang.Object r0 = r0.remove(r10)     // Catch: java.lang.Throwable -> L41
            w4.i r0 = (w4.i) r0     // Catch: java.lang.Throwable -> L41
            r2 = 0
            if (r0 != 0) goto L11
            monitor-exit(r1)
            r0 = r2
            goto L1c
        L11:
            long r3 = r1.f9945c     // Catch: java.lang.Throwable -> L41
            int r5 = r0.f9942b     // Catch: java.lang.Throwable -> L41
            long r5 = (long) r5     // Catch: java.lang.Throwable -> L41
            long r3 = r3 - r5
            r1.f9945c = r3     // Catch: java.lang.Throwable -> L41
            java.lang.Object r0 = r0.f9941a     // Catch: java.lang.Throwable -> L41
            monitor-exit(r1)
        L1c:
            r4 = r0
            d4.a0 r4 = (d4.a0) r4
            if (r4 != 0) goto L24
        L21:
            r8 = r9
            r7 = r10
            goto L36
        L24:
            boolean r0 = r4 instanceof d4.u
            if (r0 == 0) goto L2c
            r2 = r4
            d4.u r2 = (d4.u) r2
            goto L21
        L2c:
            d4.u r3 = new d4.u
            r5 = 1
            r6 = 1
            r8 = r9
            r7 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = r3
        L36:
            if (r2 == 0) goto L40
            r2.a()
            androidx.fragment.app.g r10 = r8.f2889g
            r10.v(r7, r2)
        L40:
            return r2
        L41:
            r0 = move-exception
            r8 = r9
        L43:
            r10 = r0
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L46
            throw r10
        L46:
            r0 = move-exception
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.n.b(d4.s):d4.u");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final u c(s sVar, boolean z8, long j5) {
        u uVar;
        if (z8) {
            androidx.fragment.app.g gVar = this.f2889g;
            synchronized (gVar) {
                b bVar = (b) ((HashMap) gVar.f728j).get(sVar);
                if (bVar == null) {
                    uVar = null;
                } else {
                    uVar = (u) bVar.get();
                    if (uVar == null) {
                        gVar.F(bVar);
                    }
                }
            }
            if (uVar != null) {
                uVar.a();
            }
            if (uVar != null) {
                if (h) {
                    d("Loaded resource from active resources", j5, sVar);
                }
                return uVar;
            }
            u b9 = b(sVar);
            if (b9 != null) {
                if (h) {
                    d("Loaded resource from cache", j5, sVar);
                }
                return b9;
            }
        }
        return null;
    }

    public final synchronized void e(r rVar, s sVar, u uVar) {
        if (uVar != null) {
            try {
                if (uVar.f2924i) {
                    this.f2889g.v(sVar, uVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        HashMap hashMap = this.f2883a.f1767a;
        if (rVar.equals(hashMap.get(sVar))) {
            hashMap.remove(sVar);
        }
    }

    public final void f(b4.f fVar, u uVar) {
        androidx.fragment.app.g gVar = this.f2889g;
        synchronized (gVar) {
            b bVar = (b) ((HashMap) gVar.f728j).remove(fVar);
            if (bVar != null) {
                bVar.f2796c = null;
                bVar.clear();
            }
        }
        if (uVar.f2924i) {
        } else {
            this.f2887e.e(uVar, false);
        }
    }

    public final androidx.fragment.app.g h(com.bumptech.glide.e eVar, Object obj, b4.f fVar, int i9, int i10, Class cls, Class cls2, com.bumptech.glide.g gVar, m mVar, Map map, boolean z8, boolean z9, b4.i iVar, boolean z10, boolean z11, s4.f fVar2, Executor executor, s sVar, long j5) {
        r rVar = (r) this.f2883a.f1767a.get(sVar);
        if (rVar != null) {
            rVar.a(fVar2, executor);
            if (h) {
                d("Added to existing load", j5, sVar);
            }
            return new androidx.fragment.app.g(this, fVar2, rVar);
        }
        r rVar2 = (r) ((x.c) this.f2886d.f6840g).b();
        synchronized (rVar2) {
            rVar2.f2907s = sVar;
            rVar2.f2908t = z10;
            rVar2.f2909u = z11;
        }
        i0 i0Var = this.f2888f;
        k kVar = (k) ((x.c) i0Var.f1400l).b();
        int i11 = i0Var.f1398j;
        i0Var.f1398j = i11 + 1;
        h hVar = kVar.f2856i;
        c.a aVar = kVar.f2859l;
        hVar.f2836c = eVar;
        hVar.f2837d = obj;
        hVar.f2846n = fVar;
        hVar.f2838e = i9;
        hVar.f2839f = i10;
        hVar.f2848p = mVar;
        hVar.f2840g = cls;
        hVar.h = aVar;
        hVar.f2843k = cls2;
        hVar.f2847o = gVar;
        hVar.f2841i = iVar;
        hVar.f2842j = map;
        hVar.f2849q = z8;
        hVar.f2850r = z9;
        kVar.f2863p = eVar;
        kVar.f2864q = fVar;
        kVar.f2865r = gVar;
        kVar.f2866s = sVar;
        kVar.f2867t = i9;
        kVar.f2868u = i10;
        kVar.f2869v = mVar;
        kVar.f2870w = iVar;
        kVar.f2871x = rVar2;
        kVar.f2872y = i11;
        kVar.L = 1;
        kVar.A = obj;
        com.bumptech.glide.f fVar3 = this.f2883a;
        fVar3.getClass();
        fVar3.f1767a.put(sVar, rVar2);
        rVar2.a(fVar2, executor);
        rVar2.k(kVar);
        if (h) {
            d("Started new load", j5, sVar);
        }
        return new androidx.fragment.app.g(this, fVar2, rVar2);
    }
}
