package w2;

import android.util.SparseArray;
import d1.l0;
import d1.m0;
import d2.d0;
import g1.u;
import g1.w;
import i7.x;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements d2.m {
    public static final byte[] H = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final d1.s I;
    public int A;
    public int B;
    public boolean C;
    public boolean G;

    /* renamed from: a, reason: collision with root package name */
    public final z2.c f9742a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9743b;

    /* renamed from: c, reason: collision with root package name */
    public final List f9744c;
    public final byte[] h;

    /* renamed from: i, reason: collision with root package name */
    public final g1.p f9749i;

    /* renamed from: j, reason: collision with root package name */
    public final u f9750j;

    /* renamed from: o, reason: collision with root package name */
    public int f9755o;

    /* renamed from: p, reason: collision with root package name */
    public int f9756p;

    /* renamed from: q, reason: collision with root package name */
    public long f9757q;

    /* renamed from: r, reason: collision with root package name */
    public int f9758r;

    /* renamed from: s, reason: collision with root package name */
    public g1.p f9759s;

    /* renamed from: t, reason: collision with root package name */
    public long f9760t;

    /* renamed from: u, reason: collision with root package name */
    public int f9761u;

    /* renamed from: y, reason: collision with root package name */
    public h f9765y;

    /* renamed from: z, reason: collision with root package name */
    public int f9766z;

    /* renamed from: k, reason: collision with root package name */
    public final m1.b f9751k = new m1.b(7);

    /* renamed from: l, reason: collision with root package name */
    public final g1.p f9752l = new g1.p(16);

    /* renamed from: e, reason: collision with root package name */
    public final g1.p f9746e = new g1.p(h1.g.f3891a);

    /* renamed from: f, reason: collision with root package name */
    public final g1.p f9747f = new g1.p(5);

    /* renamed from: g, reason: collision with root package name */
    public final g1.p f9748g = new g1.p();

    /* renamed from: m, reason: collision with root package name */
    public final ArrayDeque f9753m = new ArrayDeque();

    /* renamed from: n, reason: collision with root package name */
    public final ArrayDeque f9754n = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f9745d = new SparseArray();

    /* renamed from: w, reason: collision with root package name */
    public long f9763w = -9223372036854775807L;

    /* renamed from: v, reason: collision with root package name */
    public long f9762v = -9223372036854775807L;

    /* renamed from: x, reason: collision with root package name */
    public long f9764x = -9223372036854775807L;
    public d2.o D = d2.o.f2714b;
    public d0[] E = new d0[0];
    public d0[] F = new d0[0];

    static {
        d1.r rVar = new d1.r();
        rVar.f2528l = l0.k("application/x-emsg");
        I = new d1.s(rVar);
    }

    public i(z2.c cVar, int i9, u uVar, List list) {
        this.f9742a = cVar;
        this.f9743b = i9;
        this.f9750j = uVar;
        this.f9744c = Collections.unmodifiableList(list);
        byte[] bArr = new byte[16];
        this.h = bArr;
        this.f9749i = new g1.p(bArr);
    }

    public static d1.n b(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i9 = 0; i9 < size; i9++) {
            b bVar = (b) list.get(i9);
            if (bVar.f3748j == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.f9714k.f3699a;
                x d9 = j.d(bArr);
                UUID uuid = d9 == null ? null : (UUID) d9.f5179j;
                if (uuid == null) {
                    g1.a.D("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new d1.m(uuid, null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new d1.n(null, false, (d1.m[]) arrayList.toArray(new d1.m[0]));
    }

    public static void e(g1.p pVar, int i9, r rVar) {
        pVar.F(i9 + 8);
        int g9 = pVar.g();
        if ((g9 & 1) != 0) {
            throw m0.c("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z8 = (g9 & 2) != 0;
        int x6 = pVar.x();
        if (x6 == 0) {
            Arrays.fill(rVar.f9832l, 0, rVar.f9826e, false);
            return;
        }
        int i10 = rVar.f9826e;
        g1.p pVar2 = rVar.f9834n;
        if (x6 != i10) {
            StringBuilder p5 = androidx.activity.g.p(x6, "Senc sample count ", " is different from fragment sample count");
            p5.append(rVar.f9826e);
            throw m0.a(null, p5.toString());
        }
        Arrays.fill(rVar.f9832l, 0, x6, z8);
        pVar2.C(pVar.a());
        rVar.f9831k = true;
        rVar.f9835o = true;
        pVar.e(0, pVar2.f3701c, pVar2.f3699a);
        pVar2.F(0);
        rVar.f9835o = false;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        SparseArray sparseArray = this.f9745d;
        int size = sparseArray.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((h) sparseArray.valueAt(i9)).d();
        }
        this.f9754n.clear();
        this.f9761u = 0;
        this.f9762v = j9;
        this.f9753m.clear();
        this.f9755o = 0;
        this.f9758r = 0;
    }

    @Override // d2.m
    public final void d(d2.o oVar) {
        int i9;
        int i10 = this.f9743b;
        if ((i10 & 32) == 0) {
            oVar = new x.c(oVar, this.f9742a);
        }
        this.D = oVar;
        int i11 = 0;
        this.f9755o = 0;
        this.f9758r = 0;
        d0[] d0VarArr = new d0[2];
        this.E = d0VarArr;
        int i12 = 100;
        if ((i10 & 4) != 0) {
            d0VarArr[0] = oVar.l(100, 5);
            i9 = 1;
            i12 = 101;
        } else {
            i9 = 0;
        }
        d0[] d0VarArr2 = (d0[]) w.O(i9, this.E);
        this.E = d0VarArr2;
        for (d0 d0Var : d0VarArr2) {
            d0Var.e(I);
        }
        List list = this.f9744c;
        this.F = new d0[list.size()];
        while (i11 < this.F.length) {
            d0 l4 = this.D.l(i12, 3);
            l4.e((d1.s) list.get(i11));
            this.F[i11] = l4;
            i11++;
            i12++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:389:0x0731, code lost:
    
        r51.f9755o = 0;
        r51.f9758r = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0736, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:249:0x064b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(long r52) {
        /*
            Method dump skipped, instructions count: 1847
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.i.f(long):void");
    }

    @Override // d2.m
    public final boolean g(d2.n nVar) {
        return j.h(nVar, true, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:327:0x00c1, code lost:
    
        r3 = r2.f9732b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x00c7, code lost:
    
        if (r32.f9755o != 3) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x00cb, code lost:
    
        if (r2.f9741l != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x00cd, code lost:
    
        r4 = r2.f9734d.f9841d[r2.f9736f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x00dc, code lost:
    
        r32.f9766z = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x00e2, code lost:
    
        if (r2.f9736f >= r2.f9738i) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x00e4, code lost:
    
        r0.i(r4);
        r0 = r2.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x00eb, code lost:
    
        if (r0 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x00ee, code lost:
    
        r4 = r3.f9834n;
        r0 = r0.f9820d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x00f2, code lost:
    
        if (r0 == 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x00f4, code lost:
    
        r4.G(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x00f7, code lost:
    
        r0 = r2.f9736f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x00fb, code lost:
    
        if (r3.f9831k == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0101, code lost:
    
        if (r3.f9832l[r0] == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0103, code lost:
    
        r4.G(r4.z() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0110, code lost:
    
        if (r2.b() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x0112, code lost:
    
        r32.f9765y = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0114, code lost:
    
        r32.f9755o = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x0117, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x011f, code lost:
    
        if (r2.f9734d.f9838a.f9813g != 1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0121, code lost:
    
        r32.f9766z = r4 - 8;
        r0.i(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x012a, code lost:
    
        r4 = "audio/ac4".equals(r2.f9734d.f9838a.f9812f.f2554m);
        r6 = r32.f9766z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x013a, code lost:
    
        if (r4 == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x013c, code lost:
    
        r32.A = r2.c(r6, 7);
        r6 = r32.f9766z;
        r7 = r32.f9749i;
        d2.b.g(r6, r7);
        r2.f9731a.c(7, r7);
        r32.A += 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x015b, code lost:
    
        r32.f9766z += r32.A;
        r32.f9755o = 4;
        r32.B = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x0155, code lost:
    
        r32.A = r2.c(r6, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x00d6, code lost:
    
        r4 = r3.h[r2.f9736f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0167, code lost:
    
        r4 = r2.f9734d;
        r6 = r4.f9838a;
        r7 = r2.f9731a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x016f, code lost:
    
        if (r2.f9741l != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0171, code lost:
    
        r13 = r4.f9843f[r2.f9736f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x017e, code lost:
    
        if (r15 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0180, code lost:
    
        r13 = r15.a(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x0184, code lost:
    
        r4 = r6.f9815j;
        r6 = r6.f9812f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x0188, code lost:
    
        if (r4 == 0) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x018a, code lost:
    
        r9 = r32.f9747f;
        r11 = r9.f3699a;
        r11[0] = 0;
        r11[1] = 0;
        r11[r34] = 0;
        r8 = r4 + 1;
        r4 = 4 - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x01a0, code lost:
    
        if (r32.A >= r32.f9766z) goto L439;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x01a2, code lost:
    
        r5 = r32.B;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x01a6, code lost:
    
        if (r5 != 0) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x01a8, code lost:
    
        r0.readFully(r11, r4, r8);
        r9.F(0);
        r5 = r9.g();
        r34 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x01b6, code lost:
    
        if (r5 < 1) goto L440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x01b8, code lost:
    
        r32.B = r5 - 1;
        r5 = r32.f9746e;
        r5.F(0);
        r7.c(4, r5);
        r7.c(1, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x01cd, code lost:
    
        if (r32.F.length <= 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x01cf, code lost:
    
        r5 = r6.f2554m;
        r19 = r11[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x01d9, code lost:
    
        if ("video/avc".equals(r5) == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x01db, code lost:
    
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x01e0, code lost:
    
        if ((r19 & 31) == 6) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x01f6, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x01fc, code lost:
    
        r32.C = r4;
        r32.A += 5;
        r32.f9766z += r34;
        r4 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x020c, code lost:
    
        r8 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x01ea, code lost:
    
        if ("video/hevc".equals(r5) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x01f4, code lost:
    
        if (((r19 & 126) >> 1) != 39) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x01fb, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x01e3, code lost:
    
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x01f8, code lost:
    
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0217, code lost:
    
        throw d1.m0.a(null, "Invalid NAL length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0218, code lost:
    
        r34 = r4;
        r22 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x021f, code lost:
    
        if (r32.C == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0221, code lost:
    
        r4 = r32.f9748g;
        r4.C(r5);
        r19 = r9;
        r0.readFully(r4.f3699a, 0, r32.B);
        r7.c(r32.B, r4);
        r5 = r32.B;
        r8 = h1.g.e(r4.f3699a, r4.f3701c);
        r4.F("video/hevc".equals(r6.f2554m) ? 1 : 0);
        r4.E(r8);
        d2.b.d(r13, r4, r32.F);
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0258, code lost:
    
        r32.A += r5;
        r32.B -= r5;
        r4 = r34;
        r9 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0251, code lost:
    
        r19 = r9;
        r5 = r7.a(r0, r5, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x027b, code lost:
    
        if (r2.f9741l != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x027d, code lost:
    
        r11 = r2.f9734d.f9844g[r2.f9736f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0295, code lost:
    
        if (r2.a() == null) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0297, code lost:
    
        r11 = r11 | 1073741824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x029a, code lost:
    
        r25 = r11;
        r0 = r2.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x02a0, code lost:
    
        if (r0 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x02a2, code lost:
    
        r28 = r0.f9819c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x02a9, code lost:
    
        r23 = r13;
        r7.d(r23, r25, r32.f9766z, 0, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x02ba, code lost:
    
        if (r12.isEmpty() != false) goto L443;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x02bc, code lost:
    
        r0 = (w2.g) r12.removeFirst();
        r32.f9761u -= r0.f9730c;
        r3 = r0.f9728a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:0x02cd, code lost:
    
        if (r0.f9729b == false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x02cf, code lost:
    
        r3 = r3 + r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:414:0x02d1, code lost:
    
        if (r15 == null) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:415:0x02d3, code lost:
    
        r3 = r15.a(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x02d7, code lost:
    
        r6 = r3;
        r3 = r32.E;
        r4 = r3.length;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x02dc, code lost:
    
        if (r13 >= r4) goto L446;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x02de, code lost:
    
        r3[r13].d(r6, 1, r0.f9730c, r32.f9761u, null);
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x02f0, code lost:
    
        if (r2.b() != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:425:0x02f2, code lost:
    
        r32.f9765y = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x02f5, code lost:
    
        r32.f9755o = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x02fa, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x02a7, code lost:
    
        r28 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:430:0x028c, code lost:
    
        if (r3.f9830j[r2.f9736f] == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x028e, code lost:
    
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x0290, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x0267, code lost:
    
        r4 = r32.A;
        r5 = r32.f9766z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x026b, code lost:
    
        if (r4 >= r5) goto L447;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x026d, code lost:
    
        r32.A += r7.a(r0, r5 - r4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x0178, code lost:
    
        r13 = r3.f9829i[r2.f9736f];
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(d2.n r33, d1.w r34) {
        /*
            Method dump skipped, instructions count: 1938
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.i.h(d2.n, d1.w):int");
    }

    @Override // d2.m
    public final d2.m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
