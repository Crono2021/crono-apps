package p1;

import i7.x;
import java.util.ArrayList;
import java.util.Iterator;
import v1.v0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n implements v0 {

    /* renamed from: i, reason: collision with root package name */
    public final int f8181i;

    /* renamed from: j, reason: collision with root package name */
    public final r f8182j;

    /* renamed from: k, reason: collision with root package name */
    public int f8183k = -1;

    public n(r rVar, int i9) {
        this.f8182j = rVar;
        this.f8181i = i9;
    }

    public final void a() {
        g1.a.f(this.f8183k == -1);
        r rVar = this.f8182j;
        rVar.v();
        rVar.S.getClass();
        int[] iArr = rVar.S;
        int i9 = this.f8181i;
        int i10 = iArr[i9];
        if (i10 == -1) {
            if (rVar.R.contains(rVar.Q.a(i9))) {
                i10 = -3;
            }
            i10 = -2;
        } else {
            boolean[] zArr = rVar.V;
            if (!zArr[i10]) {
                zArr[i10] = true;
            }
            i10 = -2;
        }
        this.f8183k = i10;
    }

    @Override // v1.v0
    public final boolean b() {
        if (this.f8183k == -3) {
            return true;
        }
        if (!c()) {
            return false;
        }
        int i9 = this.f8183k;
        r rVar = this.f8182j;
        return !rVar.C() && rVar.D[i9].u(rVar.f8195b0);
    }

    public final boolean c() {
        int i9 = this.f8183k;
        return (i9 == -1 || i9 == -3 || i9 == -2) ? false : true;
    }

    @Override // v1.v0
    public final void n() {
        int i9 = this.f8183k;
        r rVar = this.f8182j;
        if (i9 == -2) {
            rVar.v();
            throw new b4.c(androidx.activity.g.n("Unable to bind a sample queue to TrackGroup with MIME type ", rVar.Q.a(this.f8181i).f2619d[0].f2554m, "."));
        }
        if (i9 == -1) {
            rVar.E();
            return;
        }
        if (i9 != -3) {
            rVar.E();
            q qVar = rVar.D[i9];
            x xVar = qVar.h;
            if (xVar == null || xVar.C() != 1) {
                return;
            }
            o1.b A = qVar.h.A();
            A.getClass();
            throw A;
        }
    }

    @Override // v1.v0
    public final int o(long j5) {
        Object next;
        Object obj;
        if (!c()) {
            return 0;
        }
        int i9 = this.f8183k;
        r rVar = this.f8182j;
        if (rVar.C()) {
            return 0;
        }
        q qVar = rVar.D[i9];
        int s8 = qVar.s(j5, rVar.f8195b0);
        ArrayList arrayList = rVar.f8213v;
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                obj = arrayList.get(arrayList.size() - 1);
            }
            obj = null;
        } else {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                do {
                    next = it.next();
                } while (it.hasNext());
                obj = next;
            }
            obj = null;
        }
        k kVar = (k) obj;
        if (kVar != null && !kVar.K) {
            s8 = Math.min(s8, kVar.e(i9) - qVar.q());
        }
        qVar.D(s8);
        return s8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00be, code lost:
    
        if (((p1.k) r6.get(0)).K == false) goto L61;
     */
    @Override // v1.v0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int r(a5.d r21, j1.e r22, int r23) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.n.r(a5.d, j1.e, int):int");
    }
}
