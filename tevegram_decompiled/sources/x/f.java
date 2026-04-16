package x;

import d2.w;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public w.e f9988a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9989b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9990c;

    /* renamed from: d, reason: collision with root package name */
    public w.e f9991d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f9992e;

    /* renamed from: f, reason: collision with root package name */
    public w f9993f;

    /* renamed from: g, reason: collision with root package name */
    public b f9994g;
    public ArrayList h;

    public final void a(g gVar, int i9, ArrayList arrayList, l lVar) {
        n nVar = gVar.f9998d;
        l lVar2 = nVar.f10014c;
        g gVar2 = nVar.f10019i;
        g gVar3 = nVar.h;
        if (lVar2 == null) {
            w.e eVar = this.f9988a;
            if (nVar == eVar.f9621d || nVar == eVar.f9622e) {
                return;
            }
            if (lVar == null) {
                lVar = new l();
                lVar.f10008a = null;
                lVar.f10009b = new ArrayList();
                lVar.f10008a = nVar;
                arrayList.add(lVar);
            }
            nVar.f10014c = lVar;
            lVar.f10009b.add(nVar);
            ArrayList arrayList2 = gVar3.f10004k;
            int size = arrayList2.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                e eVar2 = (e) obj;
                if (eVar2 instanceof g) {
                    a((g) eVar2, i9, arrayList, lVar);
                }
            }
            ArrayList arrayList3 = gVar2.f10004k;
            int size2 = arrayList3.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj2 = arrayList3.get(i12);
                i12++;
                e eVar3 = (e) obj2;
                if (eVar3 instanceof g) {
                    a((g) eVar3, i9, arrayList, lVar);
                }
            }
            if (i9 == 1 && (nVar instanceof m)) {
                ArrayList arrayList4 = ((m) nVar).f10010k.f10004k;
                int size3 = arrayList4.size();
                int i13 = 0;
                while (i13 < size3) {
                    Object obj3 = arrayList4.get(i13);
                    i13++;
                    e eVar4 = (e) obj3;
                    if (eVar4 instanceof g) {
                        a((g) eVar4, i9, arrayList, lVar);
                    }
                }
            }
            ArrayList arrayList5 = gVar3.f10005l;
            int size4 = arrayList5.size();
            int i14 = 0;
            while (i14 < size4) {
                Object obj4 = arrayList5.get(i14);
                i14++;
                a((g) obj4, i9, arrayList, lVar);
            }
            ArrayList arrayList6 = gVar2.f10005l;
            int size5 = arrayList6.size();
            int i15 = 0;
            while (i15 < size5) {
                Object obj5 = arrayList6.get(i15);
                i15++;
                a((g) obj5, i9, arrayList, lVar);
            }
            if (i9 == 1 && (nVar instanceof m)) {
                ArrayList arrayList7 = ((m) nVar).f10010k.f10005l;
                int size6 = arrayList7.size();
                while (i10 < size6) {
                    Object obj6 = arrayList7.get(i10);
                    i10++;
                    a((g) obj6, i9, arrayList, lVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0269, code lost:
    
        if (r7 != r9) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x026b, code lost:
    
        if (r1 == r6) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x026d, code lost:
    
        if (r2 != r6) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0271, code lost:
    
        if (r2 != 2) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0273, code lost:
    
        if (r1 != 2) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0275, code lost:
    
        r1 = r25[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0277, code lost:
    
        if (r1 == r8) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0279, code lost:
    
        if (r1 != r8) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x027b, code lost:
    
        r1 = r25[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x027d, code lost:
    
        if (r1 == r8) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x027f, code lost:
    
        if (r1 != r8) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0281, code lost:
    
        f(r8, (int) ((r27.l() * r20) + 0.5f), r8, (int) ((r4 * r27.i()) + 0.5f), r12);
        r0.d(r12.l());
        r14.d(r12.i());
        r12.f9615a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02ae, code lost:
    
        f(2, 0, r13, 0, r12);
        r0.f10006m = r12.l();
        r14.f10006m = r12.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x020f, code lost:
    
        f(r8, r12.l(), 1, (int) ((r4 * r27.i()) + 0.5f), r12);
        r0.d(r12.l());
        r14.d(r12.i());
        r12.f9615a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0236, code lost:
    
        r15 = r8;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x023e, code lost:
    
        if (r7[2].f9611d == null) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0246, code lost:
    
        if (r7[3].f9611d != null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0249, code lost:
    
        r7 = r10;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x024c, code lost:
    
        f(2, 0, r10, 0, r12);
        r0.d(r12.l());
        r14.d(r12.i());
        r12.f9615a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01a7, code lost:
    
        r7 = r10;
        r6 = 1;
        r8 = 1;
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0186, code lost:
    
        f(2, 0, r10, 0, r12);
        r0.d(r12.l());
        r14.d(r12.i());
        r12.f9615a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00f0, code lost:
    
        r10 = r6;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00de, code lost:
    
        if (r6 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d5, code lost:
    
        if (r15 == 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e8, code lost:
    
        if (r15 != 3) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ea, code lost:
    
        if (r6 == r13) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ed, code lost:
    
        if (r6 != 1) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f6, code lost:
    
        if (r1 != 3) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f8, code lost:
    
        if (r6 != r13) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fa, code lost:
    
        f(2, 0, r13, 0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0103, code lost:
    
        r11 = r12.i();
        f(1, (int) ((r11 * r12.L) + 0.5f), 1, r11, r12);
        r0.d(r12.l());
        r14.d(r12.i());
        r12.f9615a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0134, code lost:
    
        if (r1 != 1) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0136, code lost:
    
        f(2, 0, r6, 0, r12);
        r0.f10006m = r12.l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0147, code lost:
    
        if (r1 != 2) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0149, code lost:
    
        r8 = r25[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014b, code lost:
    
        if (r8 == 1) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x014e, code lost:
    
        if (r8 != 4) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0150, code lost:
    
        f(1, (int) ((r27.l() * r20) + 0.5f), r6, r12.i(), r12);
        r0.d(r12.l());
        r14.d(r12.i());
        r12.f9615a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0177, code lost:
    
        r10 = r6;
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x017e, code lost:
    
        if (r7[0].f9611d == null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0184, code lost:
    
        if (r7[1].f9611d != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f2, code lost:
    
        r9 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a0, code lost:
    
        if (r10 != 3) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a2, code lost:
    
        if (r15 == 2) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (r15 != r6) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01ad, code lost:
    
        if (r2 != 3) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01af, code lost:
    
        if (r15 != 2) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b1, code lost:
    
        f(2, 0, 2, 0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b9, code lost:
    
        r9 = r12.l();
        r1 = r12.L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c2, code lost:
    
        if (r12.M != (-1)) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c4, code lost:
    
        r1 = 1.0f / r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c6, code lost:
    
        f(1, r9, r6, (int) ((r9 * r1) + 0.5f), r12);
        r0.d(r12.l());
        r14.d(r12.i());
        r12.f9615a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e6, code lost:
    
        r13 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01e8, code lost:
    
        if (r2 != 1) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01ea, code lost:
    
        f(r15, 0, 2, 0, r12);
        r14.f10006m = r12.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01fb, code lost:
    
        r8 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ff, code lost:
    
        if (r2 != 2) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0201, code lost:
    
        r7 = r25[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0203, code lost:
    
        if (r7 == r6) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0206, code lost:
    
        if (r7 != 4) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0209, code lost:
    
        r15 = r8;
        r7 = r10;
        r6 = 1;
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x020d, code lost:
    
        r9 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0267, code lost:
    
        if (r15 != r9) goto L89;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(w.e r27) {
        /*
            Method dump skipped, instructions count: 779
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.f.b(w.e):void");
    }

    public final void c() {
        w.e eVar = this.f9988a;
        ArrayList arrayList = this.h;
        ArrayList arrayList2 = this.f9992e;
        arrayList2.clear();
        w.e eVar2 = this.f9991d;
        eVar2.f9621d.f();
        m mVar = eVar2.f9622e;
        mVar.f();
        arrayList2.add(eVar2.f9621d);
        arrayList2.add(mVar);
        ArrayList arrayList3 = eVar2.f9643d0;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList3.get(i9);
            i9++;
            w.d dVar = (w.d) obj;
            if (dVar instanceof w.h) {
                i iVar = new i(dVar);
                dVar.f9621d.f();
                dVar.f9622e.f();
                iVar.f10017f = ((w.h) dVar).f9698h0;
                arrayList2.add(iVar);
            } else {
                if (dVar.q()) {
                    if (dVar.f9617b == null) {
                        dVar.f9617b = new d(dVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f9617b);
                } else {
                    arrayList2.add(dVar.f9621d);
                }
                if (dVar.r()) {
                    if (dVar.f9619c == null) {
                        dVar.f9619c = new d(dVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f9619c);
                } else {
                    arrayList2.add(dVar.f9622e);
                }
                if (dVar instanceof w.i) {
                    arrayList2.add(new j(dVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList2.get(i10);
            i10++;
            ((n) obj2).f();
        }
        int size3 = arrayList2.size();
        int i11 = 0;
        while (i11 < size3) {
            Object obj3 = arrayList2.get(i11);
            i11++;
            n nVar = (n) obj3;
            if (nVar.f10013b != eVar2) {
                nVar.d();
            }
        }
        arrayList.clear();
        e(eVar.f9621d, 0, arrayList);
        e(eVar.f9622e, 1, arrayList);
        this.f9989b = false;
    }

    public final int d(w.e eVar, int i9) {
        ArrayList arrayList;
        int i10;
        long max;
        float f9;
        w.e eVar2 = eVar;
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        long j5 = 0;
        int i11 = 0;
        long j9 = 0;
        while (i11 < size) {
            n nVar = ((l) arrayList2.get(i11)).f10008a;
            if (!(nVar instanceof d) ? !(i9 != 0 ? (nVar instanceof m) : (nVar instanceof k)) : ((d) nVar).f10017f != i9) {
                g gVar = (i9 == 0 ? eVar2.f9621d : eVar2.f9622e).h;
                g gVar2 = (i9 == 0 ? eVar2.f9621d : eVar2.f9622e).f10019i;
                g gVar3 = nVar.h;
                g gVar4 = nVar.f10019i;
                boolean contains = gVar3.f10005l.contains(gVar);
                boolean contains2 = gVar4.f10005l.contains(gVar2);
                long j10 = nVar.j();
                if (contains && contains2) {
                    long b9 = l.b(gVar3, j5);
                    long a9 = l.a(gVar4, j5);
                    long j11 = b9 - j10;
                    int i12 = gVar4.f10000f;
                    arrayList = arrayList2;
                    i10 = size;
                    if (j11 >= (-i12)) {
                        j11 += i12;
                    }
                    long j12 = gVar3.f10000f;
                    long j13 = ((-a9) - j10) - j12;
                    if (j13 >= j12) {
                        j13 -= j12;
                    }
                    w.d dVar = nVar.f10013b;
                    if (i9 == 0) {
                        f9 = dVar.S;
                    } else if (i9 == 1) {
                        f9 = dVar.T;
                    } else {
                        dVar.getClass();
                        f9 = -1.0f;
                    }
                    float f10 = f9 > 0.0f ? (long) ((j11 / (1.0f - f9)) + (j13 / f9)) : 0L;
                    max = (gVar3.f10000f + ((((long) ((f10 * f9) + 0.5f)) + j10) + ((long) (((1.0f - f9) * f10) + 0.5f)))) - gVar4.f10000f;
                } else {
                    arrayList = arrayList2;
                    i10 = size;
                    max = contains ? Math.max(l.b(gVar3, gVar3.f10000f), gVar3.f10000f + j10) : contains2 ? Math.max(-l.a(gVar4, gVar4.f10000f), (-gVar4.f10000f) + j10) : (nVar.j() + gVar3.f10000f) - gVar4.f10000f;
                }
            } else {
                arrayList = arrayList2;
                i10 = size;
                max = j5;
            }
            j9 = Math.max(j9, max);
            i11++;
            eVar2 = eVar;
            arrayList2 = arrayList;
            size = i10;
            j5 = 0;
        }
        return (int) j9;
    }

    public final void e(n nVar, int i9, ArrayList arrayList) {
        g gVar = nVar.h;
        g gVar2 = nVar.f10019i;
        ArrayList arrayList2 = gVar.f10004k;
        int size = arrayList2.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            e eVar = (e) obj;
            if (eVar instanceof g) {
                a((g) eVar, i9, arrayList, null);
            } else if (eVar instanceof n) {
                a(((n) eVar).h, i9, arrayList, null);
            }
        }
        ArrayList arrayList3 = gVar2.f10004k;
        int size2 = arrayList3.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList3.get(i12);
            i12++;
            e eVar2 = (e) obj2;
            if (eVar2 instanceof g) {
                a((g) eVar2, i9, arrayList, null);
            } else if (eVar2 instanceof n) {
                a(((n) eVar2).f10019i, i9, arrayList, null);
            }
        }
        if (i9 == 1) {
            ArrayList arrayList4 = ((m) nVar).f10010k.f10004k;
            int size3 = arrayList4.size();
            while (i10 < size3) {
                Object obj3 = arrayList4.get(i10);
                i10++;
                e eVar3 = (e) obj3;
                if (eVar3 instanceof g) {
                    a((g) eVar3, i9, arrayList, null);
                }
            }
        }
    }

    public final void f(int i9, int i10, int i11, int i12, w.d dVar) {
        b bVar = this.f9994g;
        bVar.f9974a = i9;
        bVar.f9975b = i11;
        bVar.f9976c = i10;
        bVar.f9977d = i12;
        this.f9993f.a(dVar, bVar);
        dVar.y(bVar.f9978e);
        dVar.v(bVar.f9979f);
        dVar.f9639w = bVar.h;
        int i13 = bVar.f9980g;
        dVar.P = i13;
        dVar.f9639w = i13 > 0;
    }

    public final void g() {
        a aVar;
        f fVar = this;
        ArrayList arrayList = fVar.f9988a.f9643d0;
        int size = arrayList.size();
        char c9 = 0;
        int i9 = 0;
        while (i9 < size) {
            int i10 = i9 + 1;
            w.d dVar = (w.d) arrayList.get(i9);
            boolean z8 = dVar.f9615a;
            k kVar = dVar.f9621d;
            m mVar = dVar.f9622e;
            if (!z8) {
                int[] iArr = dVar.f9620c0;
                int i11 = iArr[c9];
                int i12 = iArr[1];
                int i13 = dVar.f9626j;
                int i14 = dVar.f9627k;
                boolean z9 = i11 == 2 || (i11 == 3 && i13 == 1);
                boolean z10 = i12 == 2 || (i12 == 3 && i14 == 1);
                h hVar = kVar.f10016e;
                boolean z11 = hVar.f10003j;
                h hVar2 = mVar.f10016e;
                boolean z12 = hVar2.f10003j;
                boolean z13 = z9;
                if (z11 && z12) {
                    fVar.f(1, hVar.f10001g, 1, hVar2.f10001g, dVar);
                    dVar.f9615a = true;
                } else if (z11 && z10) {
                    f(1, hVar.f10001g, 2, hVar2.f10001g, dVar);
                    h hVar3 = mVar.f10016e;
                    if (i12 == 3) {
                        hVar3.f10006m = dVar.i();
                    } else {
                        hVar3.d(dVar.i());
                        dVar.f9615a = true;
                    }
                } else if (z12 && z13) {
                    f(2, hVar.f10001g, 1, hVar2.f10001g, dVar);
                    h hVar4 = kVar.f10016e;
                    if (i11 == 3) {
                        hVar4.f10006m = dVar.l();
                    } else {
                        hVar4.d(dVar.l());
                        dVar.f9615a = true;
                    }
                }
                if (dVar.f9615a && (aVar = mVar.f10011l) != null) {
                    aVar.d(dVar.P);
                }
                c9 = 0;
                fVar = this;
            }
            i9 = i10;
        }
    }
}
