package x2;

import b6.g0;
import d1.j0;
import d1.l0;
import d1.r;
import d1.s;
import g1.p;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends i {

    /* renamed from: o, reason: collision with root package name */
    public static final byte[] f10072o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f10073p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* renamed from: n, reason: collision with root package name */
    public boolean f10074n;

    public static boolean e(p pVar, byte[] bArr) {
        if (pVar.a() < bArr.length) {
            return false;
        }
        int i9 = pVar.f3700b;
        byte[] bArr2 = new byte[bArr.length];
        pVar.e(0, bArr.length, bArr2);
        pVar.F(i9);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // x2.i
    public final long b(p pVar) {
        byte[] bArr = pVar.f3699a;
        return (this.f10082i * d2.b.j(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0)) / 1000000;
    }

    @Override // x2.i
    public final boolean c(p pVar, long j5, m1.b bVar) {
        if (e(pVar, f10072o)) {
            byte[] copyOf = Arrays.copyOf(pVar.f3699a, pVar.f3701c);
            int i9 = copyOf[9] & 255;
            ArrayList a9 = d2.b.a(copyOf);
            if (((s) bVar.f6510j) == null) {
                r rVar = new r();
                rVar.f2528l = l0.k("audio/opus");
                rVar.f2541y = i9;
                rVar.f2542z = 48000;
                rVar.f2530n = a9;
                bVar.f6510j = new s(rVar);
                return true;
            }
        } else {
            if (!e(pVar, f10073p)) {
                g1.a.l((s) bVar.f6510j);
                return false;
            }
            g1.a.l((s) bVar.f6510j);
            if (!this.f10074n) {
                this.f10074n = true;
                pVar.G(8);
                j0 o8 = d2.b.o(g0.n((String[]) d2.b.s(pVar, false, false).f8j));
                if (o8 != null) {
                    r a10 = ((s) bVar.f6510j).a();
                    a10.f2526j = o8.e(((s) bVar.f6510j).f2552k);
                    bVar.f6510j = new s(a10);
                    return true;
                }
            }
        }
        return true;
    }

    @Override // x2.i
    public final void d(boolean z8) {
        super.d(z8);
        if (z8) {
            this.f10074n = false;
        }
    }
}
