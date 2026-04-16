package f2;

import d2.d0;
import d2.x;
import d2.z;
import g1.w;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f3299a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3300b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3301c;

    /* renamed from: d, reason: collision with root package name */
    public final long f3302d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3303e;

    /* renamed from: f, reason: collision with root package name */
    public int f3304f;

    /* renamed from: g, reason: collision with root package name */
    public int f3305g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f3306i;

    /* renamed from: j, reason: collision with root package name */
    public int f3307j;

    /* renamed from: k, reason: collision with root package name */
    public long[] f3308k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f3309l;

    public e(int i9, int i10, long j5, int i11, d0 d0Var) {
        boolean z8 = true;
        if (i10 != 1 && i10 != 2) {
            z8 = false;
        }
        g1.a.f(z8);
        this.f3302d = j5;
        this.f3303e = i11;
        this.f3299a = d0Var;
        int i12 = (((i9 % 10) + 48) << 8) | ((i9 / 10) + 48);
        this.f3300b = (i10 == 2 ? 1667497984 : 1651965952) | i12;
        this.f3301c = i10 == 2 ? i12 | 1650720768 : -1;
        this.f3308k = new long[IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED];
        this.f3309l = new int[IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED];
    }

    public final z a(int i9) {
        return new z(((this.f3302d * 1) / this.f3303e) * this.f3309l[i9], this.f3308k[i9]);
    }

    public final x b(long j5) {
        int i9 = (int) (j5 / ((this.f3302d * 1) / this.f3303e));
        int e9 = w.e(this.f3309l, i9, true, true);
        if (this.f3309l[e9] == i9) {
            z a9 = a(e9);
            return new x(a9, a9);
        }
        z a10 = a(e9);
        int i10 = e9 + 1;
        return i10 < this.f3308k.length ? new x(a10, a(i10)) : new x(a10, a10);
    }
}
