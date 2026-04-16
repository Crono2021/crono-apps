package x;

import android.util.Log;
import android.util.SparseArray;
import d2.d0;
import d2.o;
import d2.w;
import d2.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements m0.c, o {

    /* renamed from: i, reason: collision with root package name */
    public final Object f9983i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f9984j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f9985k;

    public c(w.e eVar) {
        this.f9983i = new ArrayList();
        this.f9984j = new b();
        this.f9985k = eVar;
    }

    @Override // m0.c
    public boolean a(Object obj) {
        if (obj instanceof x4.b) {
            ((x4.b) obj).b().f10103a = true;
        }
        switch (((o4.d) this.f9984j).f7901i) {
            case 24:
                break;
            default:
                ((List) obj).clear();
                break;
        }
        return ((m0.e) this.f9985k).a(obj);
    }

    @Override // m0.c
    public Object b() {
        Object b9 = ((m0.e) this.f9985k).b();
        if (b9 == null) {
            b9 = ((x4.a) this.f9983i).h();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + b9.getClass());
            }
        }
        if (b9 instanceof x4.b) {
            ((x4.b) b9).b().f10103a = false;
        }
        return b9;
    }

    @Override // d2.o
    public void c() {
        ((o) this.f9983i).c();
    }

    public boolean d(w wVar, w.d dVar, boolean z8) {
        b bVar = (b) this.f9984j;
        int[] iArr = dVar.f9620c0;
        int[] iArr2 = dVar.f9628l;
        bVar.f9974a = iArr[0];
        bVar.f9975b = iArr[1];
        bVar.f9976c = dVar.l();
        bVar.f9977d = dVar.i();
        bVar.f9981i = false;
        bVar.f9982j = z8;
        boolean z9 = bVar.f9974a == 3;
        boolean z10 = bVar.f9975b == 3;
        boolean z11 = z9 && dVar.L > 0.0f;
        boolean z12 = z10 && dVar.L > 0.0f;
        if (z11 && iArr2[0] == 4) {
            bVar.f9974a = 1;
        }
        if (z12 && iArr2[1] == 4) {
            bVar.f9975b = 1;
        }
        wVar.a(dVar, bVar);
        dVar.y(bVar.f9978e);
        dVar.v(bVar.f9979f);
        dVar.f9639w = bVar.h;
        int i9 = bVar.f9980g;
        dVar.P = i9;
        dVar.f9639w = i9 > 0;
        bVar.f9982j = false;
        return bVar.f9981i;
    }

    public void e(w.e eVar, int i9, int i10) {
        int i11 = eVar.Q;
        int i12 = eVar.R;
        eVar.Q = 0;
        eVar.R = 0;
        eVar.y(i9);
        eVar.v(i10);
        if (i11 < 0) {
            eVar.Q = 0;
        } else {
            eVar.Q = i11;
        }
        if (i12 < 0) {
            eVar.R = 0;
        } else {
            eVar.R = i12;
        }
        ((w.e) this.f9985k).E();
    }

    @Override // d2.o
    public d0 l(int i9, int i10) {
        SparseArray sparseArray = (SparseArray) this.f9985k;
        o oVar = (o) this.f9983i;
        if (i10 != 3) {
            return oVar.l(i9, i10);
        }
        z2.m mVar = (z2.m) sparseArray.get(i9);
        if (mVar != null) {
            return mVar;
        }
        z2.m mVar2 = new z2.m(oVar.l(i9, i10), (z2.c) this.f9984j);
        sparseArray.put(i9, mVar2);
        return mVar2;
    }

    @Override // d2.o
    public void t(y yVar) {
        ((o) this.f9983i).t(yVar);
    }

    public c(o oVar, z2.c cVar) {
        this.f9983i = oVar;
        this.f9984j = cVar;
        this.f9985k = new SparseArray();
    }

    public c(m0.e eVar, x4.a aVar, o4.d dVar) {
        this.f9985k = eVar;
        this.f9983i = aVar;
        this.f9984j = dVar;
    }
}
