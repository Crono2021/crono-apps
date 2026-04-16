package s4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements d, c {

    /* renamed from: a, reason: collision with root package name */
    public final d f8850a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8851b;

    /* renamed from: c, reason: collision with root package name */
    public volatile f f8852c;

    /* renamed from: d, reason: collision with root package name */
    public volatile c f8853d;

    /* renamed from: e, reason: collision with root package name */
    public int f8854e = 3;

    /* renamed from: f, reason: collision with root package name */
    public int f8855f = 3;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8856g;

    public g(Object obj, d dVar) {
        this.f8851b = obj;
        this.f8850a = dVar;
    }

    @Override // s4.d, s4.c
    public final boolean a() {
        boolean z8;
        synchronized (this.f8851b) {
            try {
                z8 = this.f8853d.a() || this.f8852c.a();
            } finally {
            }
        }
        return z8;
    }

    @Override // s4.d
    public final boolean b(c cVar) {
        boolean z8;
        synchronized (this.f8851b) {
            try {
                d dVar = this.f8850a;
                z8 = (dVar == null || dVar.b(this)) && (cVar.equals(this.f8852c) || this.f8854e != 4);
            } finally {
            }
        }
        return z8;
    }

    @Override // s4.d
    public final void c(c cVar) {
        synchronized (this.f8851b) {
            try {
                if (cVar.equals(this.f8853d)) {
                    this.f8855f = 4;
                    return;
                }
                this.f8854e = 4;
                d dVar = this.f8850a;
                if (dVar != null) {
                    dVar.c(this);
                }
                if (!androidx.activity.g.h(this.f8855f)) {
                    this.f8853d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s4.c
    public final void clear() {
        synchronized (this.f8851b) {
            this.f8856g = false;
            this.f8854e = 3;
            this.f8855f = 3;
            this.f8853d.clear();
            this.f8852c.clear();
        }
    }

    @Override // s4.c
    public final boolean d() {
        boolean z8;
        synchronized (this.f8851b) {
            z8 = this.f8854e == 3;
        }
        return z8;
    }

    @Override // s4.d
    public final boolean e(c cVar) {
        boolean z8;
        synchronized (this.f8851b) {
            try {
                d dVar = this.f8850a;
                z8 = (dVar == null || dVar.e(this)) && cVar.equals(this.f8852c) && this.f8854e != 2;
            } finally {
            }
        }
        return z8;
    }

    @Override // s4.d
    public final void f(c cVar) {
        synchronized (this.f8851b) {
            try {
                if (!cVar.equals(this.f8852c)) {
                    this.f8855f = 5;
                    return;
                }
                this.f8854e = 5;
                d dVar = this.f8850a;
                if (dVar != null) {
                    dVar.f(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s4.c
    public final void g() {
        synchronized (this.f8851b) {
            try {
                this.f8856g = true;
                try {
                    if (this.f8854e != 4 && this.f8855f != 1) {
                        this.f8855f = 1;
                        this.f8853d.g();
                    }
                    if (this.f8856g && this.f8854e != 1) {
                        this.f8854e = 1;
                        this.f8852c.g();
                    }
                    this.f8856g = false;
                } catch (Throwable th) {
                    this.f8856g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // s4.d
    public final d getRoot() {
        d root;
        synchronized (this.f8851b) {
            try {
                d dVar = this.f8850a;
                root = dVar != null ? dVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // s4.d
    public final boolean h(c cVar) {
        boolean z8;
        synchronized (this.f8851b) {
            try {
                d dVar = this.f8850a;
                z8 = (dVar == null || dVar.h(this)) && cVar.equals(this.f8852c) && !a();
            } finally {
            }
        }
        return z8;
    }

    @Override // s4.c
    public final boolean i() {
        boolean z8;
        synchronized (this.f8851b) {
            z8 = this.f8854e == 4;
        }
        return z8;
    }

    @Override // s4.c
    public final boolean isRunning() {
        boolean z8;
        synchronized (this.f8851b) {
            z8 = true;
            if (this.f8854e != 1) {
                z8 = false;
            }
        }
        return z8;
    }

    @Override // s4.c
    public final boolean j(c cVar) {
        if (!(cVar instanceof g)) {
            return false;
        }
        g gVar = (g) cVar;
        if (this.f8852c == null) {
            if (gVar.f8852c != null) {
                return false;
            }
        } else if (!this.f8852c.j(gVar.f8852c)) {
            return false;
        }
        return this.f8853d == null ? gVar.f8853d == null : this.f8853d.j(gVar.f8853d);
    }

    @Override // s4.c
    public final void pause() {
        synchronized (this.f8851b) {
            try {
                if (!androidx.activity.g.h(this.f8855f)) {
                    this.f8855f = 2;
                    this.f8853d.pause();
                }
                if (!androidx.activity.g.h(this.f8854e)) {
                    this.f8854e = 2;
                    this.f8852c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
