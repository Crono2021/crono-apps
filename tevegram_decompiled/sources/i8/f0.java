package i8;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f0 extends s {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f5262n = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f5263k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5264l;

    /* renamed from: m, reason: collision with root package name */
    public o7.e f5265m;

    public final void i(boolean z8) {
        long j5 = this.f5263k - (z8 ? IjkMediaMeta.AV_CH_WIDE_RIGHT : 1L);
        this.f5263k = j5;
        if (j5 <= 0 && this.f5264l) {
            shutdown();
        }
    }

    public final void j(b0 b0Var) {
        o7.e eVar = this.f5265m;
        if (eVar == null) {
            eVar = new o7.e();
            this.f5265m = eVar;
        }
        eVar.addLast(b0Var);
    }

    public final void k(boolean z8) {
        this.f5263k = (z8 ? IjkMediaMeta.AV_CH_WIDE_RIGHT : 1L) + this.f5263k;
        if (z8) {
            return;
        }
        this.f5264l = true;
    }

    public abstract long l();

    public final boolean m() {
        o7.e eVar = this.f5265m;
        if (eVar == null) {
            return false;
        }
        b0 b0Var = (b0) (eVar.isEmpty() ? null : eVar.removeFirst());
        if (b0Var == null) {
            return false;
        }
        b0Var.run();
        return true;
    }

    public abstract void shutdown();
}
