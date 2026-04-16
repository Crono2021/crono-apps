package n8;

import i8.b0;
import i8.f0;
import i8.f1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends b0 implements t7.d, r7.c {

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7505p = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: l, reason: collision with root package name */
    public final i8.s f7506l;

    /* renamed from: m, reason: collision with root package name */
    public final t7.c f7507m;

    /* renamed from: n, reason: collision with root package name */
    public Object f7508n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f7509o;

    public h(i8.s sVar, t7.c cVar) {
        super(-1);
        this.f7506l = sVar;
        this.f7507m = cVar;
        this.f7508n = a.f7494c;
        r7.g gVar = cVar.f8983j;
        gVar.getClass();
        Object d9 = gVar.d(0, w.f7536k);
        d9.getClass();
        this.f7509o = d9;
    }

    @Override // t7.d
    public final t7.d b() {
        t7.c cVar = this.f7507m;
        if (t.a.d(cVar)) {
            return cVar;
        }
        return null;
    }

    @Override // i8.b0
    public final void c(Object obj, CancellationException cancellationException) {
        if (obj instanceof i8.n) {
            throw null;
        }
    }

    @Override // r7.c
    public final r7.g f() {
        r7.g gVar = this.f7507m.f8983j;
        gVar.getClass();
        return gVar;
    }

    @Override // r7.c
    public final void g(Object obj) {
        t7.c cVar = this.f7507m;
        r7.g gVar = cVar.f8983j;
        gVar.getClass();
        Throwable a9 = n7.d.a(obj);
        Object mVar = a9 == null ? obj : new i8.m(a9, false);
        i8.s sVar = this.f7506l;
        if (sVar.g()) {
            this.f7508n = mVar;
            this.f5247k = 0;
            sVar.c(gVar, this);
            return;
        }
        f0 a10 = f1.a();
        if (a10.f5263k >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            this.f7508n = mVar;
            this.f5247k = 0;
            a10.j(this);
            return;
        }
        a10.k(true);
        try {
            r7.g gVar2 = cVar.f8983j;
            gVar2.getClass();
            Object k3 = a.k(gVar2, this.f7509o);
            try {
                cVar.g(obj);
                while (a10.m()) {
                }
            } finally {
                a.f(gVar2, k3);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // i8.b0
    public final Object j() {
        Object obj = this.f7508n;
        this.f7508n = a.f7494c;
        return obj;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f7506l + ", " + i8.w.n(this.f7507m) + ']';
    }

    @Override // i8.b0
    public final r7.c d() {
        return this;
    }
}
