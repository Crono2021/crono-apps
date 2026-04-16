package v1;

import android.net.Uri;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p implements i1.h {

    /* renamed from: i, reason: collision with root package name */
    public final i1.h f9363i;

    /* renamed from: j, reason: collision with root package name */
    public final int f9364j;

    /* renamed from: k, reason: collision with root package name */
    public final j0 f9365k;

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f9366l;

    /* renamed from: m, reason: collision with root package name */
    public int f9367m;

    public p(i1.h hVar, int i9, j0 j0Var) {
        g1.a.f(i9 > 0);
        this.f9363i = hVar;
        this.f9364j = i9;
        this.f9365k = j0Var;
        this.f9366l = new byte[1];
        this.f9367m = i9;
    }

    @Override // i1.h
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // i1.h
    public final long f(i1.k kVar) {
        throw new UnsupportedOperationException();
    }

    @Override // i1.h
    public final Map g() {
        return this.f9363i.g();
    }

    @Override // i1.h
    public final void k(z1.f fVar) {
        fVar.getClass();
        this.f9363i.k(fVar);
    }

    @Override // i1.h
    public final Uri m() {
        return this.f9363i.m();
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        int i11 = this.f9367m;
        i1.h hVar = this.f9363i;
        if (i11 == 0) {
            byte[] bArr2 = this.f9366l;
            if (hVar.read(bArr2, 0, 1) != -1) {
                int i12 = (bArr2[0] & 255) << 4;
                if (i12 != 0) {
                    byte[] bArr3 = new byte[i12];
                    int i13 = i12;
                    int i14 = 0;
                    while (i13 > 0) {
                        int read = hVar.read(bArr3, i14, i13);
                        if (read != -1) {
                            i14 += read;
                            i13 -= read;
                        }
                    }
                    while (i12 > 0 && bArr3[i12 - 1] == 0) {
                        i12--;
                    }
                    if (i12 > 0) {
                        g1.p pVar = new g1.p(bArr3, i12);
                        j0 j0Var = this.f9365k;
                        long max = !j0Var.f9319m ? j0Var.f9316j : Math.max(j0Var.f9320n.x(true), j0Var.f9316j);
                        int a9 = pVar.a();
                        u0 u0Var = j0Var.f9318l;
                        u0Var.getClass();
                        u0Var.f(pVar, a9, 0);
                        u0Var.d(max, 1, a9, 0, null);
                        j0Var.f9319m = true;
                    }
                }
                this.f9367m = this.f9364j;
            }
            return -1;
        }
        int read2 = hVar.read(bArr, i9, Math.min(this.f9367m, i10));
        if (read2 != -1) {
            this.f9367m -= read2;
        }
        return read2;
    }
}
