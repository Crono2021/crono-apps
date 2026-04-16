package v3;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends k {
    public ArrayList E;
    public boolean F;
    public int G;
    public boolean H;
    public int I;

    @Override // v3.k
    public final void A(o4.d dVar) {
        super.A(dVar);
        this.I |= 4;
        if (this.E != null) {
            for (int i9 = 0; i9 < this.E.size(); i9++) {
                ((k) this.E.get(i9)).A(dVar);
            }
        }
    }

    @Override // v3.k
    public final void B() {
        this.I |= 2;
        int size = this.E.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((k) this.E.get(i9)).B();
        }
    }

    @Override // v3.k
    public final void C(long j5) {
        this.f9523j = j5;
    }

    @Override // v3.k
    public final String E(String str) {
        String E = super.E(str);
        for (int i9 = 0; i9 < this.E.size(); i9++) {
            E = E + "\n" + ((k) this.E.get(i9)).E(str.concat("  "));
        }
        return E;
    }

    public final void F(k kVar) {
        this.E.add(kVar);
        kVar.f9530q = this;
        long j5 = this.f9524k;
        if (j5 >= 0) {
            kVar.x(j5);
        }
        if ((this.I & 1) != 0) {
            kVar.z(this.f9525l);
        }
        if ((this.I & 2) != 0) {
            kVar.B();
        }
        if ((this.I & 4) != 0) {
            kVar.A(this.A);
        }
        if ((this.I & 8) != 0) {
            kVar.y(null);
        }
    }

    @Override // v3.k
    public final void c(q qVar) {
        View view = qVar.f9549b;
        if (r(view)) {
            ArrayList arrayList = this.E;
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                k kVar = (k) obj;
                if (kVar.r(view)) {
                    kVar.c(qVar);
                    qVar.f9550c.add(kVar);
                }
            }
        }
    }

    @Override // v3.k
    public final void e(q qVar) {
        int size = this.E.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((k) this.E.get(i9)).e(qVar);
        }
    }

    @Override // v3.k
    public final void f(q qVar) {
        View view = qVar.f9549b;
        if (r(view)) {
            ArrayList arrayList = this.E;
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                k kVar = (k) obj;
                if (kVar.r(view)) {
                    kVar.f(qVar);
                    qVar.f9550c.add(kVar);
                }
            }
        }
    }

    @Override // v3.k
    /* renamed from: i */
    public final k clone() {
        a aVar = (a) super.clone();
        aVar.E = new ArrayList();
        int size = this.E.size();
        for (int i9 = 0; i9 < size; i9++) {
            k clone = ((k) this.E.get(i9)).clone();
            aVar.E.add(clone);
            clone.f9530q = aVar;
        }
        return aVar;
    }

    @Override // v3.k
    public final void k(ViewGroup viewGroup, a0.l lVar, a0.l lVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j5 = this.f9523j;
        int size = this.E.size();
        for (int i9 = 0; i9 < size; i9++) {
            k kVar = (k) this.E.get(i9);
            if (j5 > 0 && (this.F || i9 == 0)) {
                long j9 = kVar.f9523j;
                if (j9 > 0) {
                    kVar.C(j9 + j5);
                } else {
                    kVar.C(j5);
                }
            }
            kVar.k(viewGroup, lVar, lVar2, arrayList, arrayList2);
        }
    }

    @Override // v3.k
    public final void t(View view) {
        super.t(view);
        int size = this.E.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((k) this.E.get(i9)).t(view);
        }
    }

    @Override // v3.k
    public final void v(View view) {
        super.v(view);
        int size = this.E.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((k) this.E.get(i9)).v(view);
        }
    }

    @Override // v3.k
    public final void w() {
        ArrayList arrayList;
        if (this.E.isEmpty()) {
            D();
            l();
            return;
        }
        g gVar = new g();
        gVar.f9516b = this;
        ArrayList arrayList2 = this.E;
        int size = arrayList2.size();
        int i9 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            ((k) obj).a(gVar);
        }
        this.G = this.E.size();
        if (this.F) {
            ArrayList arrayList3 = this.E;
            int size2 = arrayList3.size();
            while (i9 < size2) {
                Object obj2 = arrayList3.get(i9);
                i9++;
                ((k) obj2).w();
            }
            return;
        }
        int i11 = 1;
        while (true) {
            int size3 = this.E.size();
            arrayList = this.E;
            if (i11 >= size3) {
                break;
            }
            ((k) arrayList.get(i11 - 1)).a(new g((k) this.E.get(i11), 1));
            i11++;
        }
        k kVar = (k) arrayList.get(0);
        if (kVar != null) {
            kVar.w();
        }
    }

    @Override // v3.k
    public final void x(long j5) {
        ArrayList arrayList;
        this.f9524k = j5;
        if (j5 < 0 || (arrayList = this.E) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((k) this.E.get(i9)).x(j5);
        }
    }

    @Override // v3.k
    public final void y(com.bumptech.glide.c cVar) {
        this.I |= 8;
        int size = this.E.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((k) this.E.get(i9)).y(cVar);
        }
    }

    @Override // v3.k
    public final void z(TimeInterpolator timeInterpolator) {
        this.I |= 1;
        ArrayList arrayList = this.E;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                ((k) this.E.get(i9)).z(timeInterpolator);
            }
        }
        this.f9525l = timeInterpolator;
    }
}
