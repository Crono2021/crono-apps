package o3;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t implements Runnable {

    /* renamed from: m, reason: collision with root package name */
    public static final ThreadLocal f7807m = new ThreadLocal();

    /* renamed from: n, reason: collision with root package name */
    public static final a0.k f7808n = new a0.k(11);

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f7809i;

    /* renamed from: j, reason: collision with root package name */
    public long f7810j;

    /* renamed from: k, reason: collision with root package name */
    public long f7811k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f7812l;

    public static d1 c(RecyclerView recyclerView, int i9, long j5) {
        int Z = recyclerView.f1064n.Z();
        for (int i10 = 0; i10 < Z; i10++) {
            d1 J = RecyclerView.J(recyclerView.f1064n.Y(i10));
            if (J.f7620c == i9 && !J.f()) {
                return null;
            }
        }
        l7.a aVar = recyclerView.f1058k;
        try {
            recyclerView.Q();
            d1 k3 = aVar.k(i9, j5);
            if (k3 != null) {
                if (!k3.e() || k3.f()) {
                    aVar.a(k3, false);
                } else {
                    aVar.h(k3.f7618a);
                }
            }
            recyclerView.R(false);
            return k3;
        } catch (Throwable th) {
            recyclerView.R(false);
            throw th;
        }
    }

    public final void a(RecyclerView recyclerView, int i9, int i10) {
        if (recyclerView.A && this.f7810j == 0) {
            this.f7810j = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        r rVar = recyclerView.f1065n0;
        rVar.f7795b = i9;
        rVar.f7796c = i10;
    }

    public final void b(long j5) {
        s sVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        s sVar2;
        ArrayList arrayList = this.f7812l;
        ArrayList arrayList2 = this.f7809i;
        int size = arrayList2.size();
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList2.get(i10);
            int windowVisibility = recyclerView3.getWindowVisibility();
            r rVar = recyclerView3.f1065n0;
            if (windowVisibility == 0) {
                rVar.c(recyclerView3, false);
                i9 += rVar.f7797d;
            }
        }
        arrayList.ensureCapacity(i9);
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList2.get(i12);
            if (recyclerView4.getWindowVisibility() == 0) {
                r rVar2 = recyclerView4.f1065n0;
                int abs = Math.abs(rVar2.f7796c) + Math.abs(rVar2.f7795b);
                for (int i13 = 0; i13 < rVar2.f7797d * 2; i13 += 2) {
                    if (i11 >= arrayList.size()) {
                        sVar2 = new s();
                        arrayList.add(sVar2);
                    } else {
                        sVar2 = (s) arrayList.get(i11);
                    }
                    int[] iArr = rVar2.f7794a;
                    int i14 = iArr[i13 + 1];
                    sVar2.f7798a = i14 <= abs;
                    sVar2.f7799b = abs;
                    sVar2.f7800c = i14;
                    sVar2.f7801d = recyclerView4;
                    sVar2.f7802e = iArr[i13];
                    i11++;
                }
            }
        }
        Collections.sort(arrayList, f7808n);
        for (int i15 = 0; i15 < arrayList.size() && (recyclerView = (sVar = (s) arrayList.get(i15)).f7801d) != null; i15++) {
            d1 c9 = c(recyclerView, sVar.f7802e, sVar.f7798a ? Long.MAX_VALUE : j5);
            if (c9 != null && c9.f7619b != null && c9.e() && !c9.f() && (recyclerView2 = (RecyclerView) c9.f7619b.get()) != null) {
                if (recyclerView2.K && recyclerView2.f1064n.Z() != 0) {
                    l7.a aVar = recyclerView2.f1058k;
                    k0 k0Var = recyclerView2.T;
                    if (k0Var != null) {
                        k0Var.e();
                    }
                    o0 o0Var = recyclerView2.f1080v;
                    if (o0Var != null) {
                        o0Var.f0(aVar);
                        recyclerView2.f1080v.g0(aVar);
                    }
                    ((ArrayList) aVar.f6273c).clear();
                    aVar.f();
                }
                r rVar3 = recyclerView2.f1065n0;
                rVar3.c(recyclerView2, true);
                if (rVar3.f7797d != 0) {
                    try {
                        int i16 = j0.m.f5347a;
                        j0.l.a("RV Nested Prefetch");
                        z0 z0Var = recyclerView2.f1067o0;
                        g0 g0Var = recyclerView2.f1078u;
                        z0Var.f7871d = 1;
                        z0Var.f7872e = g0Var.a();
                        z0Var.f7874g = false;
                        z0Var.h = false;
                        z0Var.f7875i = false;
                        for (int i17 = 0; i17 < rVar3.f7797d * 2; i17 += 2) {
                            c(recyclerView2, rVar3.f7794a[i17], j5);
                        }
                        j0.l.b();
                        sVar.f7798a = false;
                        sVar.f7799b = 0;
                        sVar.f7800c = 0;
                        sVar.f7801d = null;
                        sVar.f7802e = 0;
                    } catch (Throwable th) {
                        int i18 = j0.m.f5347a;
                        j0.l.b();
                        throw th;
                    }
                }
            }
            sVar.f7798a = false;
            sVar.f7799b = 0;
            sVar.f7800c = 0;
            sVar.f7801d = null;
            sVar.f7802e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f7809i;
        try {
            int i9 = j0.m.f5347a;
            j0.l.a("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long j5 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j5 = Math.max(recyclerView.getDrawingTime(), j5);
                    }
                }
                if (j5 != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(j5) + this.f7811k);
                }
            }
            this.f7810j = 0L;
            j0.l.b();
        } catch (Throwable th) {
            this.f7810j = 0L;
            int i11 = j0.m.f5347a;
            j0.l.b();
            throw th;
        }
    }
}
