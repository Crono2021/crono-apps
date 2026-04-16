package x1;

import b6.d0;
import b6.e0;
import b6.g0;
import b6.p;
import b6.u0;
import b6.w0;
import b6.z;
import java.util.ArrayList;
import w2.k;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements a {

    /* renamed from: b, reason: collision with root package name */
    public static final z f10039b = new z(new p(new k(1), u0.f1460j), new p(new k(2), u0.f1461k));

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10040a = new ArrayList();

    @Override // x1.a
    public final g0 a(long j5) {
        ArrayList arrayList = this.f10040a;
        if (!arrayList.isEmpty()) {
            if (j5 >= ((z2.a) arrayList.get(0)).f10608b) {
                ArrayList arrayList2 = new ArrayList();
                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                    z2.a aVar = (z2.a) arrayList.get(i9);
                    if (j5 >= aVar.f10608b && j5 < aVar.f10610d) {
                        arrayList2.add(aVar);
                    }
                    if (j5 < aVar.f10608b) {
                        break;
                    }
                }
                w0 s8 = g0.s(f10039b, arrayList2);
                d0 d0Var = new d0();
                for (int i10 = 0; i10 < s8.f1466l; i10++) {
                    d0Var.c(((z2.a) s8.get(i10)).f10607a);
                }
                return d0Var.f();
            }
        }
        e0 e0Var = g0.f1391j;
        return w0.f1464m;
    }

    @Override // x1.a
    public final long b(long j5) {
        int i9 = 0;
        long j9 = -9223372036854775807L;
        while (true) {
            ArrayList arrayList = this.f10040a;
            if (i9 >= arrayList.size()) {
                break;
            }
            long j10 = ((z2.a) arrayList.get(i9)).f10608b;
            long j11 = ((z2.a) arrayList.get(i9)).f10610d;
            if (j5 < j10) {
                j9 = j9 == -9223372036854775807L ? j10 : Math.min(j9, j10);
            } else {
                if (j5 < j11) {
                    j9 = j9 == -9223372036854775807L ? j11 : Math.min(j9, j11);
                }
                i9++;
            }
        }
        if (j9 != -9223372036854775807L) {
            return j9;
        }
        return Long.MIN_VALUE;
    }

    @Override // x1.a
    public final boolean c(z2.a aVar, long j5) {
        long j9 = aVar.f10608b;
        g1.a.f(j9 != -9223372036854775807L);
        g1.a.f(aVar.f10609c != -9223372036854775807L);
        boolean z8 = j9 <= j5 && j5 < aVar.f10610d;
        ArrayList arrayList = this.f10040a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (j9 >= ((z2.a) arrayList.get(size)).f10608b) {
                arrayList.add(size + 1, aVar);
                return z8;
            }
        }
        arrayList.add(0, aVar);
        return z8;
    }

    @Override // x1.a
    public final void clear() {
        this.f10040a.clear();
    }

    @Override // x1.a
    public final long d(long j5) {
        ArrayList arrayList = this.f10040a;
        if (arrayList.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j5 < ((z2.a) arrayList.get(0)).f10608b) {
            return -9223372036854775807L;
        }
        long j9 = ((z2.a) arrayList.get(0)).f10608b;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            long j10 = ((z2.a) arrayList.get(i9)).f10608b;
            long j11 = ((z2.a) arrayList.get(i9)).f10610d;
            if (j11 > j5) {
                if (j10 > j5) {
                    break;
                }
                j9 = Math.max(j9, j10);
            } else {
                j9 = Math.max(j9, j11);
            }
        }
        return j9;
    }

    @Override // x1.a
    public final void e(long j5) {
        int i9 = 0;
        while (true) {
            ArrayList arrayList = this.f10040a;
            if (i9 >= arrayList.size()) {
                return;
            }
            long j9 = ((z2.a) arrayList.get(i9)).f10608b;
            if (j5 > j9 && j5 > ((z2.a) arrayList.get(i9)).f10610d) {
                arrayList.remove(i9);
                i9--;
            } else if (j5 < j9) {
                return;
            }
            i9++;
        }
    }
}
