package s4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements d, c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8819a;

    /* renamed from: b, reason: collision with root package name */
    public final d f8820b;

    /* renamed from: c, reason: collision with root package name */
    public volatile c f8821c;

    /* renamed from: d, reason: collision with root package name */
    public volatile c f8822d;

    /* renamed from: e, reason: collision with root package name */
    public int f8823e = 3;

    /* renamed from: f, reason: collision with root package name */
    public int f8824f = 3;

    public b(Object obj, d dVar) {
        this.f8819a = obj;
        this.f8820b = dVar;
    }

    @Override // s4.d, s4.c
    public final boolean a() {
        boolean z8;
        synchronized (this.f8819a) {
            try {
                z8 = this.f8821c.a() || this.f8822d.a();
            } finally {
            }
        }
        return z8;
    }

    @Override // s4.d
    public final boolean b(c cVar) {
        boolean z8;
        synchronized (this.f8819a) {
            d dVar = this.f8820b;
            z8 = dVar == null || dVar.b(this);
        }
        return z8;
    }

    @Override // s4.d
    public final void c(c cVar) {
        synchronized (this.f8819a) {
            try {
                if (cVar.equals(this.f8821c)) {
                    this.f8823e = 4;
                } else if (cVar.equals(this.f8822d)) {
                    this.f8824f = 4;
                }
                d dVar = this.f8820b;
                if (dVar != null) {
                    dVar.c(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s4.c
    public final void clear() {
        synchronized (this.f8819a) {
            try {
                this.f8823e = 3;
                this.f8821c.clear();
                if (this.f8824f != 3) {
                    this.f8824f = 3;
                    this.f8822d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s4.c
    public final boolean d() {
        boolean z8;
        synchronized (this.f8819a) {
            try {
                z8 = this.f8823e == 3 && this.f8824f == 3;
            } finally {
            }
        }
        return z8;
    }

    @Override // s4.d
    public final boolean e(c cVar) {
        boolean z8;
        synchronized (this.f8819a) {
            d dVar = this.f8820b;
            z8 = (dVar == null || dVar.e(this)) && cVar.equals(this.f8821c);
        }
        return z8;
    }

    @Override // s4.d
    public final void f(c cVar) {
        synchronized (this.f8819a) {
            try {
                if (cVar.equals(this.f8822d)) {
                    this.f8824f = 5;
                    d dVar = this.f8820b;
                    if (dVar != null) {
                        dVar.f(this);
                    }
                    return;
                }
                this.f8823e = 5;
                if (this.f8824f != 1) {
                    this.f8824f = 1;
                    this.f8822d.g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s4.c
    public final void g() {
        synchronized (this.f8819a) {
            try {
                if (this.f8823e != 1) {
                    this.f8823e = 1;
                    this.f8821c.g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s4.d
    public final d getRoot() {
        d root;
        synchronized (this.f8819a) {
            try {
                d dVar = this.f8820b;
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
        int i9;
        synchronized (this.f8819a) {
            d dVar = this.f8820b;
            z8 = false;
            if (dVar == null || dVar.h(this)) {
                if (this.f8823e != 5 ? cVar.equals(this.f8821c) : cVar.equals(this.f8822d) && ((i9 = this.f8824f) == 4 || i9 == 5)) {
                    z8 = true;
                }
            }
        }
        return z8;
    }

    @Override // s4.c
    public final boolean i() {
        boolean z8;
        synchronized (this.f8819a) {
            try {
                z8 = this.f8823e == 4 || this.f8824f == 4;
            } finally {
            }
        }
        return z8;
    }

    @Override // s4.c
    public final boolean isRunning() {
        boolean z8;
        synchronized (this.f8819a) {
            try {
                z8 = true;
                if (this.f8823e != 1 && this.f8824f != 1) {
                    z8 = false;
                }
            } finally {
            }
        }
        return z8;
    }

    @Override // s4.c
    public final boolean j(c cVar) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f8821c.j(bVar.f8821c) && this.f8822d.j(bVar.f8822d)) {
                return true;
            }
        }
        return false;
    }

    @Override // s4.c
    public final void pause() {
        synchronized (this.f8819a) {
            try {
                if (this.f8823e == 1) {
                    this.f8823e = 2;
                    this.f8821c.pause();
                }
                if (this.f8824f == 1) {
                    this.f8824f = 2;
                    this.f8822d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
