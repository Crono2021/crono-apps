package x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class n implements e {

    /* renamed from: a, reason: collision with root package name */
    public int f10012a;

    /* renamed from: b, reason: collision with root package name */
    public w.d f10013b;

    /* renamed from: c, reason: collision with root package name */
    public l f10014c;

    /* renamed from: d, reason: collision with root package name */
    public int f10015d;

    /* renamed from: e, reason: collision with root package name */
    public final h f10016e = new h(this);

    /* renamed from: f, reason: collision with root package name */
    public int f10017f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10018g = false;
    public final g h = new g(this);

    /* renamed from: i, reason: collision with root package name */
    public final g f10019i = new g(this);

    /* renamed from: j, reason: collision with root package name */
    public int f10020j = 1;

    public n(w.d dVar) {
        this.f10013b = dVar;
    }

    public static void b(g gVar, g gVar2, int i9) {
        gVar.f10005l.add(gVar2);
        gVar.f10000f = i9;
        gVar2.f10004k.add(gVar);
    }

    public static g h(w.c cVar) {
        w.c cVar2 = cVar.f9611d;
        if (cVar2 == null) {
            return null;
        }
        w.d dVar = cVar2.f9609b;
        k kVar = dVar.f9621d;
        m mVar = dVar.f9622e;
        int a9 = v.h.a(cVar2.f9610c);
        if (a9 == 1) {
            return kVar.h;
        }
        if (a9 == 2) {
            return mVar.h;
        }
        if (a9 == 3) {
            return kVar.f10019i;
        }
        if (a9 == 4) {
            return mVar.f10019i;
        }
        if (a9 != 5) {
            return null;
        }
        return mVar.f10010k;
    }

    public static g i(w.c cVar, int i9) {
        w.c cVar2 = cVar.f9611d;
        if (cVar2 == null) {
            return null;
        }
        w.d dVar = cVar2.f9609b;
        n nVar = i9 == 0 ? dVar.f9621d : dVar.f9622e;
        int a9 = v.h.a(cVar2.f9610c);
        if (a9 == 1 || a9 == 2) {
            return nVar.h;
        }
        if (a9 == 3 || a9 == 4) {
            return nVar.f10019i;
        }
        return null;
    }

    public final void c(g gVar, g gVar2, int i9, h hVar) {
        gVar.f10005l.add(gVar2);
        gVar.f10005l.add(this.f10016e);
        gVar.h = i9;
        gVar.f10002i = hVar;
        gVar2.f10004k.add(gVar);
        hVar.f10004k.add(gVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i9, int i10) {
        w.d dVar = this.f10013b;
        if (i10 == 0) {
            int i11 = dVar.f9630n;
            int max = Math.max(dVar.f9629m, i9);
            if (i11 > 0) {
                max = Math.min(i11, i9);
            }
            if (max != i9) {
                return max;
            }
        } else {
            int i12 = dVar.f9633q;
            int max2 = Math.max(dVar.f9632p, i9);
            if (i12 > 0) {
                max2 = Math.min(i12, i9);
            }
            if (max2 != i9) {
                return max2;
            }
        }
        return i9;
    }

    public long j() {
        if (this.f10016e.f10003j) {
            return r0.f10001g;
        }
        return 0L;
    }

    public abstract boolean k();

    public final void l(w.c cVar, w.c cVar2, int i9) {
        g h = h(cVar);
        g h9 = h(cVar2);
        if (h.f10003j && h9.f10003j) {
            int c9 = cVar.c() + h.f10001g;
            int c10 = h9.f10001g - cVar2.c();
            int i10 = c10 - c9;
            h hVar = this.f10016e;
            if (!hVar.f10003j && this.f10015d == 3) {
                int i11 = this.f10012a;
                if (i11 == 0) {
                    hVar.d(g(i10, i9));
                } else if (i11 == 1) {
                    hVar.d(Math.min(g(hVar.f10006m, i9), i10));
                } else if (i11 == 2) {
                    w.d dVar = this.f10013b;
                    w.d dVar2 = dVar.I;
                    if (dVar2 != null) {
                        if ((i9 == 0 ? dVar2.f9621d : dVar2.f9622e).f10016e.f10003j) {
                            hVar.d(g((int) ((r6.f10001g * (i9 == 0 ? dVar.f9631o : dVar.f9634r)) + 0.5f), i9));
                        }
                    }
                } else if (i11 == 3) {
                    w.d dVar3 = this.f10013b;
                    n nVar = dVar3.f9621d;
                    n nVar2 = dVar3.f9622e;
                    if (nVar.f10015d != 3 || nVar.f10012a != 3 || nVar2.f10015d != 3 || nVar2.f10012a != 3) {
                        if (i9 == 0) {
                            nVar = nVar2;
                        }
                        h hVar2 = nVar.f10016e;
                        if (hVar2.f10003j) {
                            float f9 = dVar3.L;
                            int i12 = hVar2.f10001g;
                            hVar.d(i9 == 1 ? (int) ((i12 / f9) + 0.5f) : (int) ((f9 * i12) + 0.5f));
                        }
                    }
                }
            }
            if (hVar.f10003j) {
                int i13 = hVar.f10001g;
                g gVar = this.f10019i;
                g gVar2 = this.h;
                if (i13 == i10) {
                    gVar2.d(c9);
                    gVar.d(c10);
                    return;
                }
                w.d dVar4 = this.f10013b;
                float f10 = i9 == 0 ? dVar4.S : dVar4.T;
                if (h == h9) {
                    c9 = h.f10001g;
                    c10 = h9.f10001g;
                    f10 = 0.5f;
                }
                gVar2.d((int) ((((c10 - c9) - i13) * f10) + c9 + 0.5f));
                gVar.d(gVar2.f10001g + hVar.f10001g);
            }
        }
    }
}
