package m1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b6.g0;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class o implements g1.j, g1.c {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f6545i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6546j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f6547k;

    public /* synthetic */ o(a aVar, int i9, long j5, long j9) {
        this.f6547k = aVar;
        this.f6546j = i9;
        this.f6545i = j5;
    }

    @Override // g1.j
    public void a(Object obj) {
        a aVar = (a) this.f6547k;
        ((c) obj).p(this.f6546j, this.f6545i, aVar);
    }

    @Override // g1.c
    public void accept(Object obj) {
        z2.m mVar = (z2.m) this.f6547k;
        z2.a aVar = (z2.a) obj;
        g1.a.l(mVar.h);
        g0 g0Var = aVar.f10607a;
        long j5 = aVar.f10609c;
        w2.k kVar = new w2.k(6);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(g0Var.size());
        int size = g0Var.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj2 = g0Var.get(i9);
            i9++;
            arrayList.add((Bundle) kVar.apply(obj2));
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j5);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        g1.p pVar = mVar.f10625c;
        pVar.getClass();
        pVar.D(marshall, marshall.length);
        mVar.f10623a.c(marshall.length, pVar);
        int i10 = this.f6546j & Integer.MAX_VALUE;
        long j9 = aVar.f10608b;
        long j10 = this.f6545i;
        d1.s sVar = mVar.h;
        if (j9 == -9223372036854775807L) {
            g1.a.k(sVar.f2558q == Long.MAX_VALUE);
        } else {
            long j11 = sVar.f2558q;
            j10 = j11 == Long.MAX_VALUE ? j10 + j9 : j9 + j11;
        }
        mVar.f10623a.d(j10, i10, marshall.length, 0, null);
    }

    public /* synthetic */ o(z2.m mVar, long j5, int i9) {
        this.f6547k = mVar;
        this.f6545i = j5;
        this.f6546j = i9;
    }
}
