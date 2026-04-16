package l1;

import android.os.SystemClock;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e1 implements k0 {

    /* renamed from: i, reason: collision with root package name */
    public final g1.r f5850i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5851j;

    /* renamed from: k, reason: collision with root package name */
    public long f5852k;

    /* renamed from: l, reason: collision with root package name */
    public long f5853l;

    /* renamed from: m, reason: collision with root package name */
    public d1.o0 f5854m = d1.o0.f2509d;

    public e1(g1.r rVar) {
        this.f5850i = rVar;
    }

    public final void a(long j5) {
        this.f5852k = j5;
        if (this.f5851j) {
            this.f5850i.getClass();
            this.f5853l = SystemClock.elapsedRealtime();
        }
    }

    public final void b() {
        if (this.f5851j) {
            return;
        }
        this.f5850i.getClass();
        this.f5853l = SystemClock.elapsedRealtime();
        this.f5851j = true;
    }

    @Override // l1.k0
    public final /* synthetic */ boolean c() {
        return false;
    }

    @Override // l1.k0
    public final d1.o0 d() {
        return this.f5854m;
    }

    @Override // l1.k0
    public final void e(d1.o0 o0Var) {
        if (this.f5851j) {
            a(j());
        }
        this.f5854m = o0Var;
    }

    @Override // l1.k0
    public final long j() {
        long j5 = this.f5852k;
        if (!this.f5851j) {
            return j5;
        }
        this.f5850i.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f5853l;
        return (this.f5854m.f2510a == 1.0f ? g1.w.M(elapsedRealtime) : elapsedRealtime * r4.f2512c) + j5;
    }
}
