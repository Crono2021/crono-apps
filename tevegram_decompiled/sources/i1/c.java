package i1;

import android.os.SystemClock;
import b6.w0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c implements h {

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4295i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f4296j = new ArrayList(1);

    /* renamed from: k, reason: collision with root package name */
    public int f4297k;

    /* renamed from: l, reason: collision with root package name */
    public k f4298l;

    public c(boolean z8) {
        this.f4295i = z8;
    }

    public final void c(int i9) {
        k kVar = this.f4298l;
        int i10 = g1.w.f3713a;
        for (int i11 = 0; i11 < this.f4297k; i11++) {
            z1.f fVar = (z1.f) this.f4296j.get(i11);
            boolean z8 = this.f4295i;
            synchronized (fVar) {
                w0 w0Var = z1.f.f10549n;
                if (z8 && (kVar.f4330g & 8) != 8) {
                    fVar.h += i9;
                }
            }
        }
    }

    @Override // i1.h
    public Map g() {
        return Collections.EMPTY_MAP;
    }

    @Override // i1.h
    public final void k(z1.f fVar) {
        fVar.getClass();
        ArrayList arrayList = this.f4296j;
        if (arrayList.contains(fVar)) {
            return;
        }
        arrayList.add(fVar);
        this.f4297k++;
    }

    public final void l() {
        k kVar = this.f4298l;
        int i9 = g1.w.f3713a;
        for (int i10 = 0; i10 < this.f4297k; i10++) {
            z1.f fVar = (z1.f) this.f4296j.get(i10);
            boolean z8 = this.f4295i;
            synchronized (fVar) {
                try {
                    w0 w0Var = z1.f.f10549n;
                    if (z8 && (kVar.f4330g & 8) != 8) {
                        g1.a.k(fVar.f10561f > 0);
                        fVar.f10558c.getClass();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        int i11 = (int) (elapsedRealtime - fVar.f10562g);
                        fVar.f10563i += i11;
                        long j5 = fVar.f10564j;
                        long j9 = fVar.h;
                        fVar.f10564j = j5 + j9;
                        if (i11 > 0) {
                            fVar.f10560e.a((int) Math.sqrt(j9), (j9 * 8000.0f) / i11);
                            if (fVar.f10563i < 2000) {
                                if (fVar.f10564j >= 524288) {
                                }
                                fVar.b(i11, fVar.h, fVar.f10565k);
                                fVar.f10562g = elapsedRealtime;
                                fVar.h = 0L;
                            }
                            fVar.f10565k = (long) fVar.f10560e.b();
                            fVar.b(i11, fVar.h, fVar.f10565k);
                            fVar.f10562g = elapsedRealtime;
                            fVar.h = 0L;
                        }
                        fVar.f10561f--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.f4298l = null;
    }

    public final void q() {
        for (int i9 = 0; i9 < this.f4297k; i9++) {
            ((z1.f) this.f4296j.get(i9)).getClass();
        }
    }

    public final void r(k kVar) {
        this.f4298l = kVar;
        for (int i9 = 0; i9 < this.f4297k; i9++) {
            z1.f fVar = (z1.f) this.f4296j.get(i9);
            boolean z8 = this.f4295i;
            synchronized (fVar) {
                try {
                    w0 w0Var = z1.f.f10549n;
                    if (z8 && (kVar.f4330g & 8) != 8) {
                        if (fVar.f10561f == 0) {
                            fVar.f10558c.getClass();
                            fVar.f10562g = SystemClock.elapsedRealtime();
                        }
                        fVar.f10561f++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
