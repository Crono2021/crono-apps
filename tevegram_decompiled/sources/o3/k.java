package o3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7696a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f7697b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f7698c;

    /* renamed from: d, reason: collision with root package name */
    public final o f7699d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7700e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7701f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f7702g;

    public k(o oVar, ArrayList arrayList, int[] iArr, int[] iArr2) {
        int i9;
        j jVar;
        int i10;
        this.f7696a = arrayList;
        this.f7697b = iArr;
        this.f7698c = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        this.f7699d = oVar;
        int i11 = oVar.i();
        this.f7700e = i11;
        int h = oVar.h();
        this.f7701f = h;
        this.f7702g = true;
        j jVar2 = arrayList.isEmpty() ? null : (j) arrayList.get(0);
        if (jVar2 == null || jVar2.f7689a != 0 || jVar2.f7690b != 0) {
            arrayList.add(0, new j(0, 0, 0));
        }
        arrayList.add(new j(i11, h, 0));
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            j jVar3 = (j) obj;
            for (int i13 = 0; i13 < jVar3.f7691c; i13++) {
                int i14 = jVar3.f7689a + i13;
                int i15 = jVar3.f7690b + i13;
                int i16 = oVar.a(i14, i15) ? 1 : 2;
                iArr[i14] = (i15 << 4) | i16;
                iArr2[i15] = (i14 << 4) | i16;
            }
        }
        if (this.f7702g) {
            int size2 = arrayList.size();
            int i17 = 0;
            int i18 = 0;
            while (i18 < size2) {
                Object obj2 = arrayList.get(i18);
                i18++;
                j jVar4 = (j) obj2;
                while (true) {
                    i9 = jVar4.f7689a;
                    if (i17 < i9) {
                        if (iArr[i17] == 0) {
                            int size3 = arrayList.size();
                            int i19 = 0;
                            int i20 = 0;
                            while (true) {
                                if (i19 < size3) {
                                    jVar = (j) arrayList.get(i19);
                                    while (true) {
                                        i10 = jVar.f7690b;
                                        if (i20 < i10) {
                                            if (iArr2[i20] == 0 && oVar.b(i17, i20)) {
                                                int i21 = oVar.a(i17, i20) ? 8 : 4;
                                                iArr[i17] = (i20 << 4) | i21;
                                                iArr2[i20] = i21 | (i17 << 4);
                                            } else {
                                                i20++;
                                            }
                                        }
                                    }
                                }
                                i20 = jVar.f7691c + i10;
                                i19++;
                            }
                        }
                        i17++;
                    }
                }
                i17 = jVar4.f7691c + i9;
            }
        }
    }

    public static l b(ArrayDeque arrayDeque, int i9, boolean z8) {
        l lVar;
        Iterator it = arrayDeque.iterator();
        while (true) {
            if (!it.hasNext()) {
                lVar = null;
                break;
            }
            lVar = (l) it.next();
            if (lVar.f7719a == i9 && lVar.f7721c == z8) {
                it.remove();
                break;
            }
        }
        while (it.hasNext()) {
            l lVar2 = (l) it.next();
            if (z8) {
                lVar2.f7720b--;
            } else {
                lVar2.f7720b++;
            }
        }
        return lVar;
    }

    public final void a(g0 g0Var) {
        int[] iArr;
        o oVar;
        int i9;
        ArrayList arrayList;
        int i10;
        k kVar = this;
        b bVar = new b(new i7.x(g0Var, 16));
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList2 = kVar.f7696a;
        int size = arrayList2.size() - 1;
        int i11 = kVar.f7700e;
        int i12 = kVar.f7701f;
        int i13 = i11;
        while (size >= 0) {
            j jVar = (j) arrayList2.get(size);
            int i14 = jVar.f7689a;
            int i15 = jVar.f7691c;
            int i16 = i14 + i15;
            int i17 = jVar.f7690b;
            int i18 = i17 + i15;
            while (true) {
                iArr = kVar.f7697b;
                oVar = kVar.f7699d;
                if (i13 <= i16) {
                    break;
                }
                i13--;
                int i19 = iArr[i13];
                if ((i19 & 12) != 0) {
                    arrayList = arrayList2;
                    int i20 = i19 >> 4;
                    l b9 = b(arrayDeque, i20, false);
                    if (b9 != null) {
                        int i21 = (i11 - b9.f7720b) - 1;
                        bVar.c(i13, i21);
                        if ((i19 & 4) != 0) {
                            bVar.b(i21, 1, oVar.g(i13, i20));
                        }
                    } else {
                        arrayDeque.add(new l(i13, (i11 - i13) - 1, true));
                    }
                } else {
                    arrayList = arrayList2;
                    if (bVar.f7591b != 2 || (i10 = bVar.f7592c) < i13 || i10 > i13 + 1) {
                        bVar.a();
                        bVar.f7592c = i13;
                        bVar.f7593d = 1;
                        bVar.f7591b = 2;
                    } else {
                        bVar.f7593d++;
                        bVar.f7592c = i13;
                    }
                    i11--;
                }
                arrayList2 = arrayList;
            }
            ArrayList arrayList3 = arrayList2;
            while (i12 > i18) {
                i12--;
                int i22 = kVar.f7698c[i12];
                if ((i22 & 12) != 0) {
                    int i23 = i22 >> 4;
                    l b10 = b(arrayDeque, i23, true);
                    if (b10 == null) {
                        arrayDeque.add(new l(i12, i11 - i13, false));
                    } else {
                        bVar.c((i11 - b10.f7720b) - 1, i13);
                        if ((i22 & 4) != 0) {
                            bVar.b(i13, 1, oVar.g(i23, i12));
                        }
                    }
                } else {
                    if (bVar.f7591b == 1 && i13 >= (i9 = bVar.f7592c)) {
                        int i24 = bVar.f7593d;
                        if (i13 <= i9 + i24) {
                            bVar.f7593d = i24 + 1;
                            bVar.f7592c = Math.min(i13, i9);
                            i11++;
                        }
                    }
                    bVar.a();
                    bVar.f7592c = i13;
                    bVar.f7593d = 1;
                    bVar.f7591b = 1;
                    i11++;
                }
                kVar = this;
            }
            int i25 = i17;
            int i26 = i14;
            for (int i27 = 0; i27 < i15; i27++) {
                if ((iArr[i26] & 15) == 2) {
                    bVar.b(i26, 1, oVar.g(i26, i25));
                }
                i26++;
                i25++;
            }
            size--;
            kVar = this;
            i12 = i17;
            i13 = i14;
            arrayList2 = arrayList3;
        }
        bVar.a();
    }
}
