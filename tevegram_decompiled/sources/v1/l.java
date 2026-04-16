package v1;

import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements x0 {

    /* renamed from: i, reason: collision with root package name */
    public final b6.w0 f9325i;

    /* renamed from: j, reason: collision with root package name */
    public long f9326j;

    public l(List list, List list2) {
        b6.e0 e0Var = b6.g0.f1391j;
        b6.q.b(4, "initialCapacity");
        Object[] objArr = new Object[4];
        g1.a.f(list.size() == list2.size());
        int i9 = 0;
        int i10 = 0;
        boolean z8 = false;
        while (i9 < list.size()) {
            k kVar = new k((x0) list.get(i9), (List) list2.get(i9));
            int i11 = i10 + 1;
            if (objArr.length < i11) {
                objArr = Arrays.copyOf(objArr, b6.a0.d(objArr.length, i11));
            } else if (z8) {
                objArr = (Object[]) objArr.clone();
            } else {
                objArr[i10] = kVar;
                i9++;
                i10++;
            }
            z8 = false;
            objArr[i10] = kVar;
            i9++;
            i10++;
        }
        this.f9325i = b6.g0.l(i10, objArr);
        this.f9326j = -9223372036854775807L;
    }

    @Override // v1.x0
    public final boolean a() {
        int i9 = 0;
        while (true) {
            b6.w0 w0Var = this.f9325i;
            if (i9 >= w0Var.f1466l) {
                return false;
            }
            if (((k) w0Var.get(i9)).f9321i.a()) {
                return true;
            }
            i9++;
        }
    }

    @Override // v1.x0
    public final boolean b(l1.j0 j0Var) {
        boolean z8;
        boolean z9 = false;
        do {
            long f9 = f();
            if (f9 == Long.MIN_VALUE) {
                return z9;
            }
            int i9 = 0;
            z8 = false;
            while (true) {
                b6.w0 w0Var = this.f9325i;
                if (i9 >= w0Var.f1466l) {
                    break;
                }
                long f10 = ((k) w0Var.get(i9)).f9321i.f();
                boolean z10 = f10 != Long.MIN_VALUE && f10 <= j0Var.f5929a;
                if (f10 == f9 || z10) {
                    z8 |= ((k) w0Var.get(i9)).f9321i.b(j0Var);
                }
                i9++;
            }
            z9 |= z8;
        } while (z8);
        return z9;
    }

    @Override // v1.x0
    public final long f() {
        int i9 = 0;
        long j5 = Long.MAX_VALUE;
        while (true) {
            b6.w0 w0Var = this.f9325i;
            if (i9 >= w0Var.f1466l) {
                break;
            }
            long f9 = ((k) w0Var.get(i9)).f9321i.f();
            if (f9 != Long.MIN_VALUE) {
                j5 = Math.min(j5, f9);
            }
            i9++;
        }
        if (j5 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j5;
    }

    @Override // v1.x0
    public final long m() {
        int i9 = 0;
        long j5 = Long.MAX_VALUE;
        long j9 = Long.MAX_VALUE;
        while (true) {
            b6.w0 w0Var = this.f9325i;
            if (i9 >= w0Var.f1466l) {
                break;
            }
            k kVar = (k) w0Var.get(i9);
            long m9 = kVar.f9321i.m();
            b6.g0 g0Var = kVar.f9322j;
            if ((g0Var.contains(1) || g0Var.contains(2) || g0Var.contains(4)) && m9 != Long.MIN_VALUE) {
                j5 = Math.min(j5, m9);
            }
            if (m9 != Long.MIN_VALUE) {
                j9 = Math.min(j9, m9);
            }
            i9++;
        }
        if (j5 != Long.MAX_VALUE) {
            this.f9326j = j5;
            return j5;
        }
        if (j9 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j10 = this.f9326j;
        return j10 != -9223372036854775807L ? j10 : j9;
    }

    @Override // v1.x0
    public final void u(long j5) {
        int i9 = 0;
        while (true) {
            b6.w0 w0Var = this.f9325i;
            if (i9 >= w0Var.f1466l) {
                return;
            }
            ((k) w0Var.get(i9)).u(j5);
            i9++;
        }
    }
}
