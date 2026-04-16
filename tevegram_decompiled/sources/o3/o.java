package o3;

import android.view.View;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final a0.k f7747a = new a0.k(10);

    public static k c(o oVar) {
        int i9;
        n nVar;
        int i10;
        n nVar2;
        n nVar3;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z8;
        int i19 = oVar.i();
        int h = oVar.h();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m mVar = new m();
        mVar.f7728a = 0;
        mVar.f7729b = i19;
        mVar.f7730c = 0;
        mVar.f7731d = h;
        arrayList2.add(mVar);
        int i20 = i19 + h;
        int i21 = 1;
        int i22 = (((i20 + 1) / 2) * 2) + 1;
        int[] iArr = new int[i22];
        int i23 = i22 / 2;
        int[] iArr2 = new int[i22];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            m mVar2 = (m) arrayList2.remove(arrayList2.size() - i21);
            if (mVar2.b() >= i21 && mVar2.a() >= i21) {
                int a9 = ((mVar2.a() + mVar2.b()) + i21) / 2;
                int i24 = i21 + i23;
                iArr[i24] = mVar2.f7728a;
                iArr2[i24] = mVar2.f7729b;
                int i25 = 0;
                while (i25 < a9) {
                    boolean z9 = Math.abs(mVar2.b() - mVar2.a()) % 2 == i21;
                    int b9 = mVar2.b() - mVar2.a();
                    int i26 = -i25;
                    int i27 = i26;
                    while (true) {
                        if (i27 > i25) {
                            i9 = i23;
                            i10 = a9;
                            nVar2 = null;
                            break;
                        }
                        if (i27 == i26 || (i27 != i25 && iArr[i27 + 1 + i23] > iArr[(i27 - 1) + i23])) {
                            i15 = iArr[i27 + 1 + i23];
                            i16 = i15;
                        } else {
                            i15 = iArr[(i27 - 1) + i23];
                            i16 = i15 + 1;
                        }
                        i9 = i23;
                        int i28 = ((i16 - mVar2.f7728a) + mVar2.f7730c) - i27;
                        if (i25 == 0 || i16 != i15) {
                            i17 = i16;
                            i18 = i28;
                        } else {
                            i17 = i16;
                            i18 = i28 - 1;
                        }
                        int i29 = i27;
                        int i30 = i28;
                        int i31 = i17;
                        i10 = a9;
                        while (i31 < mVar2.f7729b && i30 < mVar2.f7731d && oVar.b(i31, i30)) {
                            i31++;
                            i30++;
                        }
                        iArr[i29 + i9] = i31;
                        if (z9) {
                            int i32 = b9 - i29;
                            z8 = z9;
                            if (i32 >= i26 + 1 && i32 <= i25 - 1 && iArr2[i32 + i9] <= i31) {
                                nVar2 = new n();
                                nVar2.f7738a = i15;
                                nVar2.f7739b = i18;
                                nVar2.f7740c = i31;
                                nVar2.f7741d = i30;
                                nVar2.f7742e = false;
                                break;
                            }
                        } else {
                            z8 = z9;
                        }
                        i27 = i29 + 2;
                        i23 = i9;
                        a9 = i10;
                        z9 = z8;
                    }
                    if (nVar2 != null) {
                        nVar = nVar2;
                        break;
                    }
                    boolean z10 = (mVar2.b() - mVar2.a()) % 2 == 0;
                    int b10 = mVar2.b() - mVar2.a();
                    int i33 = i26;
                    while (true) {
                        if (i33 > i25) {
                            nVar3 = null;
                            break;
                        }
                        if (i33 == i26 || (i33 != i25 && iArr2[i33 + 1 + i9] < iArr2[(i33 - 1) + i9])) {
                            i11 = iArr2[i33 + 1 + i9];
                            i12 = i11;
                        } else {
                            i11 = iArr2[(i33 - 1) + i9];
                            i12 = i11 - 1;
                        }
                        int i34 = mVar2.f7731d - ((mVar2.f7729b - i12) - i33);
                        int i35 = (i25 == 0 || i12 != i11) ? i34 : i34 + 1;
                        boolean z11 = z10;
                        while (i12 > mVar2.f7728a && i34 > mVar2.f7730c) {
                            i13 = b10;
                            if (!oVar.b(i12 - 1, i34 - 1)) {
                                break;
                            }
                            i12--;
                            i34--;
                            b10 = i13;
                        }
                        i13 = b10;
                        iArr2[i33 + i9] = i12;
                        if (z11 && (i14 = i13 - i33) >= i26 && i14 <= i25 && iArr[i14 + i9] >= i12) {
                            nVar3 = new n();
                            nVar3.f7738a = i12;
                            nVar3.f7739b = i34;
                            nVar3.f7740c = i11;
                            nVar3.f7741d = i35;
                            nVar3.f7742e = true;
                            break;
                        }
                        i33 += 2;
                        z10 = z11;
                        b10 = i13;
                    }
                    if (nVar3 != null) {
                        nVar = nVar3;
                        break;
                    }
                    i25++;
                    i23 = i9;
                    a9 = i10;
                    i21 = 1;
                }
            }
            i9 = i23;
            nVar = null;
            if (nVar != null) {
                if (nVar.a() > 0) {
                    int i36 = nVar.f7741d;
                    int i37 = nVar.f7739b;
                    int i38 = i36 - i37;
                    int i39 = nVar.f7740c;
                    int i40 = nVar.f7738a;
                    int i41 = i39 - i40;
                    arrayList.add(i38 != i41 ? nVar.f7742e ? new j(i40, i37, nVar.a()) : i38 > i41 ? new j(i40, i37 + 1, nVar.a()) : new j(i40 + 1, i37, nVar.a()) : new j(i40, i37, i41));
                }
                m mVar3 = arrayList3.isEmpty() ? new m() : (m) arrayList3.remove(arrayList3.size() - 1);
                mVar3.f7728a = mVar2.f7728a;
                mVar3.f7730c = mVar2.f7730c;
                mVar3.f7729b = nVar.f7738a;
                mVar3.f7731d = nVar.f7739b;
                arrayList2.add(mVar3);
                mVar2.f7729b = mVar2.f7729b;
                mVar2.f7731d = mVar2.f7731d;
                mVar2.f7728a = nVar.f7740c;
                mVar2.f7730c = nVar.f7741d;
                arrayList2.add(mVar2);
            } else {
                arrayList3.add(mVar2);
            }
            i23 = i9;
            i21 = 1;
        }
        Collections.sort(arrayList, f7747a);
        return new k(oVar, arrayList, iArr, iArr2);
    }

    public static int d(z0 z0Var, androidx.emoji2.text.h hVar, View view, View view2, o0 o0Var, boolean z8) {
        if (o0Var.v() == 0 || z0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z8) {
            return Math.abs(o0.F(view) - o0.F(view2)) + 1;
        }
        return Math.min(hVar.l(), hVar.b(view2) - hVar.e(view));
    }

    public static int e(z0 z0Var, androidx.emoji2.text.h hVar, View view, View view2, o0 o0Var, boolean z8, boolean z9) {
        if (o0Var.v() == 0 || z0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z9 ? Math.max(0, (z0Var.b() - Math.max(o0.F(view), o0.F(view2))) - 1) : Math.max(0, Math.min(o0.F(view), o0.F(view2)));
        if (z8) {
            return Math.round((max * (Math.abs(hVar.b(view2) - hVar.e(view)) / (Math.abs(o0.F(view) - o0.F(view2)) + 1))) + (hVar.k() - hVar.e(view)));
        }
        return max;
    }

    public static int f(z0 z0Var, androidx.emoji2.text.h hVar, View view, View view2, o0 o0Var, boolean z8) {
        if (o0Var.v() == 0 || z0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z8) {
            return z0Var.b();
        }
        return (int) (((hVar.b(view2) - hVar.e(view)) / (Math.abs(o0.F(view) - o0.F(view2)) + 1)) * z0Var.b());
    }

    public abstract boolean a(int i9, int i10);

    public abstract boolean b(int i9, int i10);

    public Object g(int i9, int i10) {
        return null;
    }

    public abstract int h();

    public abstract int i();
}
