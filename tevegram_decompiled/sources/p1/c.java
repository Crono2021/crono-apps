package p1;

import android.util.SparseArray;
import d1.z0;
import java.util.ArrayList;
import v1.c1;
import v1.w0;
import v1.x0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements j, w0 {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f8102j = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: i, reason: collision with root package name */
    public Object f8103i;

    public c(int i9) {
        switch (i9) {
            case 4:
                this.f8103i = new SparseArray();
                break;
            default:
                this.f8103i = new d(5, 1.0f, false);
                break;
        }
    }

    public static void a(int i9, ArrayList arrayList) {
        if (a.a.z(f8102j, i9, 0, 7) == -1 || arrayList.contains(Integer.valueOf(i9))) {
            return;
        }
        arrayList.add(Integer.valueOf(i9));
    }

    public void b() {
        l lVar = (l) this.f8103i;
        int i9 = lVar.f8169z - 1;
        lVar.f8169z = i9;
        if (i9 > 0) {
            return;
        }
        int i10 = 0;
        for (r rVar : lVar.B) {
            rVar.v();
            i10 += rVar.Q.f9256a;
        }
        z0[] z0VarArr = new z0[i10];
        int i11 = 0;
        for (r rVar2 : lVar.B) {
            rVar2.v();
            int i12 = rVar2.Q.f9256a;
            int i13 = 0;
            while (i13 < i12) {
                rVar2.v();
                z0VarArr[i11] = rVar2.Q.a(i13);
                i13++;
                i11++;
            }
        }
        lVar.A = new c1(z0VarArr);
        lVar.f8168y.c(lVar);
    }

    @Override // v1.w0
    public void d(x0 x0Var) {
        l lVar = (l) this.f8103i;
        lVar.f8168y.d(lVar);
    }
}
