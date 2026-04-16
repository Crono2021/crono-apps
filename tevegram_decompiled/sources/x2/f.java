package x2;

import d1.m0;
import d2.n;
import g1.p;
import java.io.EOFException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f10065a;

    /* renamed from: b, reason: collision with root package name */
    public long f10066b;

    /* renamed from: c, reason: collision with root package name */
    public int f10067c;

    /* renamed from: d, reason: collision with root package name */
    public int f10068d;

    /* renamed from: e, reason: collision with root package name */
    public int f10069e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f10070f = new int[255];

    /* renamed from: g, reason: collision with root package name */
    public final p f10071g = new p(255);

    public final boolean a(n nVar, boolean z8) {
        boolean z9;
        boolean z10;
        this.f10065a = 0;
        this.f10066b = 0L;
        this.f10067c = 0;
        this.f10068d = 0;
        this.f10069e = 0;
        p pVar = this.f10071g;
        pVar.C(27);
        try {
            z9 = nVar.n(pVar.f3699a, 0, 27, z8);
        } catch (EOFException e9) {
            if (!z8) {
                throw e9;
            }
            z9 = false;
        }
        if (z9 && pVar.v() == 1332176723) {
            if (pVar.t() == 0) {
                this.f10065a = pVar.t();
                this.f10066b = pVar.j();
                pVar.k();
                pVar.k();
                pVar.k();
                int t8 = pVar.t();
                this.f10067c = t8;
                this.f10068d = t8 + 27;
                pVar.C(t8);
                try {
                    z10 = nVar.n(pVar.f3699a, 0, this.f10067c, z8);
                } catch (EOFException e10) {
                    if (!z8) {
                        throw e10;
                    }
                    z10 = false;
                }
                if (z10) {
                    for (int i9 = 0; i9 < this.f10067c; i9++) {
                        int t9 = pVar.t();
                        this.f10070f[i9] = t9;
                        this.f10069e += t9;
                    }
                    return true;
                }
            } else if (!z8) {
                throw m0.c("unsupported bit stream revision");
            }
        }
        return false;
    }

    public final boolean b(n nVar, long j5) {
        boolean z8;
        g1.a.f(nVar.getPosition() == nVar.o());
        p pVar = this.f10071g;
        pVar.C(4);
        while (true) {
            if (j5 != -1 && nVar.getPosition() + 4 >= j5) {
                break;
            }
            try {
                z8 = nVar.n(pVar.f3699a, 0, 4, true);
            } catch (EOFException unused) {
                z8 = false;
            }
            if (!z8) {
                break;
            }
            pVar.F(0);
            if (pVar.v() == 1332176723) {
                nVar.h();
                return true;
            }
            nVar.i(1);
        }
        do {
            if (j5 != -1 && nVar.getPosition() >= j5) {
                break;
            }
        } while (nVar.b(1) != -1);
        return false;
    }
}
