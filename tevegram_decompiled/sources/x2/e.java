package x2;

import d2.n;
import g1.p;
import java.io.EOFException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final f f10060a = new f();

    /* renamed from: b, reason: collision with root package name */
    public final p f10061b = new p(new byte[65025], 0);

    /* renamed from: c, reason: collision with root package name */
    public int f10062c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f10063d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10064e;

    public final int a(int i9) {
        int i10;
        int i11 = 0;
        this.f10063d = 0;
        do {
            int i12 = this.f10063d;
            int i13 = i9 + i12;
            f fVar = this.f10060a;
            if (i13 >= fVar.f10067c) {
                break;
            }
            int[] iArr = fVar.f10070f;
            this.f10063d = i12 + 1;
            i10 = iArr[i13];
            i11 += i10;
        } while (i10 == 255);
        return i11;
    }

    public final boolean b(n nVar) {
        int i9;
        g1.a.k(nVar != null);
        boolean z8 = this.f10064e;
        p pVar = this.f10061b;
        if (z8) {
            this.f10064e = false;
            pVar.C(0);
        }
        while (!this.f10064e) {
            int i10 = this.f10062c;
            f fVar = this.f10060a;
            if (i10 < 0) {
                if (fVar.b(nVar, -1L) && fVar.a(nVar, true)) {
                    int i11 = fVar.f10068d;
                    if ((fVar.f10065a & 1) == 1 && pVar.f3701c == 0) {
                        i11 += a(0);
                        i9 = this.f10063d;
                    } else {
                        i9 = 0;
                    }
                    try {
                        nVar.i(i11);
                        this.f10062c = i9;
                    } catch (EOFException unused) {
                    }
                }
                return false;
            }
            int a9 = a(this.f10062c);
            int i12 = this.f10062c + this.f10063d;
            if (a9 > 0) {
                pVar.b(pVar.f3701c + a9);
                try {
                    nVar.readFully(pVar.f3699a, pVar.f3701c, a9);
                    pVar.E(pVar.f3701c + a9);
                    this.f10064e = fVar.f10070f[i12 + (-1)] != 255;
                } catch (EOFException unused2) {
                    return false;
                }
            }
            if (i12 == fVar.f10067c) {
                i12 = -1;
            }
            this.f10062c = i12;
        }
        return true;
    }
}
