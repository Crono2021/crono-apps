package x2;

import d2.d0;
import d2.o;
import g1.p;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class i {

    /* renamed from: b, reason: collision with root package name */
    public d0 f10076b;

    /* renamed from: c, reason: collision with root package name */
    public o f10077c;

    /* renamed from: d, reason: collision with root package name */
    public g f10078d;

    /* renamed from: e, reason: collision with root package name */
    public long f10079e;

    /* renamed from: f, reason: collision with root package name */
    public long f10080f;

    /* renamed from: g, reason: collision with root package name */
    public long f10081g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f10082i;

    /* renamed from: k, reason: collision with root package name */
    public long f10084k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10085l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10086m;

    /* renamed from: a, reason: collision with root package name */
    public final e f10075a = new e();

    /* renamed from: j, reason: collision with root package name */
    public m1.b f10083j = new m1.b(20, false);

    public void a(long j5) {
        this.f10081g = j5;
    }

    public abstract long b(p pVar);

    public abstract boolean c(p pVar, long j5, m1.b bVar);

    public void d(boolean z8) {
        if (z8) {
            this.f10083j = new m1.b(20, false);
            this.f10080f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.f10079e = -1L;
        this.f10081g = 0L;
    }
}
