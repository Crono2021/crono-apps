package j1;

import java.util.ArrayDeque;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public final g f5369a;

    /* renamed from: e, reason: collision with root package name */
    public final e[] f5373e;

    /* renamed from: f, reason: collision with root package name */
    public final f[] f5374f;

    /* renamed from: g, reason: collision with root package name */
    public int f5375g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public e f5376i;

    /* renamed from: j, reason: collision with root package name */
    public c f5377j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5378k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5379l;

    /* renamed from: m, reason: collision with root package name */
    public int f5380m;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5370b = new Object();

    /* renamed from: n, reason: collision with root package name */
    public long f5381n = -9223372036854775807L;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f5371c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f5372d = new ArrayDeque();

    public h(e[] eVarArr, f[] fVarArr) {
        this.f5373e = eVarArr;
        this.f5375g = eVarArr.length;
        for (int i9 = 0; i9 < this.f5375g; i9++) {
            this.f5373e[i9] = e();
        }
        this.f5374f = fVarArr;
        this.h = fVarArr.length;
        for (int i10 = 0; i10 < this.h; i10++) {
            this.f5374f[i10] = f();
        }
        g gVar = new g(this);
        this.f5369a = gVar;
        gVar.start();
    }

    @Override // j1.b
    public final Object d() {
        e eVar;
        synchronized (this.f5370b) {
            try {
                c cVar = this.f5377j;
                if (cVar != null) {
                    throw cVar;
                }
                g1.a.k(this.f5376i == null);
                int i9 = this.f5375g;
                if (i9 == 0) {
                    eVar = null;
                } else {
                    e[] eVarArr = this.f5373e;
                    int i10 = i9 - 1;
                    this.f5375g = i10;
                    eVar = eVarArr[i10];
                }
                this.f5376i = eVar;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    public abstract e e();

    public abstract f f();

    @Override // j1.b
    public final void flush() {
        synchronized (this.f5370b) {
            try {
                this.f5378k = true;
                this.f5380m = 0;
                e eVar = this.f5376i;
                if (eVar != null) {
                    eVar.k();
                    e[] eVarArr = this.f5373e;
                    int i9 = this.f5375g;
                    this.f5375g = i9 + 1;
                    eVarArr[i9] = eVar;
                    this.f5376i = null;
                }
                while (!this.f5371c.isEmpty()) {
                    e eVar2 = (e) this.f5371c.removeFirst();
                    eVar2.k();
                    e[] eVarArr2 = this.f5373e;
                    int i10 = this.f5375g;
                    this.f5375g = i10 + 1;
                    eVarArr2[i10] = eVar2;
                }
                while (!this.f5372d.isEmpty()) {
                    ((f) this.f5372d.removeFirst()).l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract c g(Throwable th);

    public abstract c h(e eVar, f fVar, boolean z8);

    public final boolean i() {
        c g9;
        synchronized (this.f5370b) {
            while (!this.f5379l) {
                try {
                    if (!this.f5371c.isEmpty() && this.h > 0) {
                        break;
                    }
                    this.f5370b.wait();
                } finally {
                }
            }
            if (this.f5379l) {
                return false;
            }
            e eVar = (e) this.f5371c.removeFirst();
            f[] fVarArr = this.f5374f;
            int i9 = this.h - 1;
            this.h = i9;
            f fVar = fVarArr[i9];
            boolean z8 = this.f5378k;
            this.f5378k = false;
            if (eVar.c(4)) {
                fVar.a(4);
            } else {
                long j5 = eVar.f5361o;
                fVar.f5365k = j5;
                if (!k(j5) || eVar.c(Integer.MIN_VALUE)) {
                    fVar.a(Integer.MIN_VALUE);
                }
                if (eVar.c(134217728)) {
                    fVar.a(134217728);
                }
                try {
                    g9 = h(eVar, fVar, z8);
                } catch (OutOfMemoryError e9) {
                    g9 = g(e9);
                } catch (RuntimeException e10) {
                    g9 = g(e10);
                }
                if (g9 != null) {
                    synchronized (this.f5370b) {
                        this.f5377j = g9;
                    }
                    return false;
                }
            }
            synchronized (this.f5370b) {
                try {
                    if (this.f5378k) {
                        fVar.l();
                    } else if ((fVar.c(4) || k(fVar.f5365k)) && !fVar.c(Integer.MIN_VALUE)) {
                        fVar.f5366l = this.f5380m;
                        this.f5380m = 0;
                        this.f5372d.addLast(fVar);
                    } else {
                        this.f5380m++;
                        fVar.l();
                    }
                    eVar.k();
                    e[] eVarArr = this.f5373e;
                    int i10 = this.f5375g;
                    this.f5375g = i10 + 1;
                    eVarArr[i10] = eVar;
                } finally {
                }
            }
            return true;
        }
    }

    @Override // j1.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final f c() {
        synchronized (this.f5370b) {
            try {
                c cVar = this.f5377j;
                if (cVar != null) {
                    throw cVar;
                }
                if (this.f5372d.isEmpty()) {
                    return null;
                }
                return (f) this.f5372d.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k(long j5) {
        boolean z8;
        synchronized (this.f5370b) {
            long j9 = this.f5381n;
            z8 = j9 == -9223372036854775807L || j5 >= j9;
        }
        return z8;
    }

    @Override // j1.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void b(e eVar) {
        synchronized (this.f5370b) {
            try {
                c cVar = this.f5377j;
                if (cVar != null) {
                    throw cVar;
                }
                g1.a.f(eVar == this.f5376i);
                this.f5371c.addLast(eVar);
                if (!this.f5371c.isEmpty() && this.h > 0) {
                    this.f5370b.notify();
                }
                this.f5376i = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(f fVar) {
        synchronized (this.f5370b) {
            fVar.k();
            f[] fVarArr = this.f5374f;
            int i9 = this.h;
            this.h = i9 + 1;
            fVarArr[i9] = fVar;
            if (!this.f5371c.isEmpty() && this.h > 0) {
                this.f5370b.notify();
            }
        }
    }

    public final void n(long j5) {
        boolean z8;
        synchronized (this.f5370b) {
            try {
                if (this.f5375g != this.f5373e.length && !this.f5378k) {
                    z8 = false;
                    g1.a.k(z8);
                    this.f5381n = j5;
                }
                z8 = true;
                g1.a.k(z8);
                this.f5381n = j5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j1.b
    public void release() {
        synchronized (this.f5370b) {
            this.f5379l = true;
            this.f5370b.notify();
        }
        try {
            this.f5369a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
