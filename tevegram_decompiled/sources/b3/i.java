package b3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import b6.e0;
import b6.g0;
import b6.w0;
import g1.p;
import g1.w;
import java.util.ArrayList;
import java.util.List;
import org.webrtc.PeerConnectionFactory;
import z2.k;
import z2.l;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements l {

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f1310p = {0, 7, 8, 15};

    /* renamed from: q, reason: collision with root package name */
    public static final byte[] f1311q = {0, 119, -120, -1};

    /* renamed from: r, reason: collision with root package name */
    public static final byte[] f1312r = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: i, reason: collision with root package name */
    public final Paint f1313i;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f1314j;

    /* renamed from: k, reason: collision with root package name */
    public final Canvas f1315k;

    /* renamed from: l, reason: collision with root package name */
    public final b f1316l;

    /* renamed from: m, reason: collision with root package name */
    public final a f1317m;

    /* renamed from: n, reason: collision with root package name */
    public final h f1318n;

    /* renamed from: o, reason: collision with root package name */
    public Bitmap f1319o;

    public i(List list) {
        p pVar = new p((byte[]) list.get(0));
        int z8 = pVar.z();
        int z9 = pVar.z();
        Paint paint = new Paint();
        this.f1313i = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f1314j = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f1315k = new Canvas();
        this.f1316l = new b(719, 575, 0, 719, 0, 575);
        this.f1317m = new a(0, new int[]{0, -1, -16777216, -8421505}, b(), c());
        this.f1318n = new h(z8, z9);
    }

    public static byte[] a(int i9, int i10, a3.g gVar) {
        byte[] bArr = new byte[i9];
        for (int i11 = 0; i11 < i9; i11++) {
            bArr[i11] = (byte) gVar.i(i10);
        }
        return bArr;
    }

    public static int[] b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i9 = 1; i9 < 16; i9++) {
            if (i9 < 8) {
                iArr[i9] = d(255, (i9 & 1) != 0 ? 255 : 0, (i9 & 2) != 0 ? 255 : 0, (i9 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i9] = d(255, (i9 & 1) != 0 ? 127 : 0, (i9 & 2) != 0 ? 127 : 0, (i9 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] c() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i9 = 0; i9 < 256; i9++) {
            if (i9 < 8) {
                iArr[i9] = d(63, (i9 & 1) != 0 ? 255 : 0, (i9 & 2) != 0 ? 255 : 0, (i9 & 4) == 0 ? 0 : 255);
            } else {
                int i10 = i9 & 136;
                if (i10 == 0) {
                    iArr[i9] = d(255, ((i9 & 1) != 0 ? 85 : 0) + ((i9 & 16) != 0 ? 170 : 0), ((i9 & 2) != 0 ? 85 : 0) + ((i9 & 32) != 0 ? 170 : 0), ((i9 & 4) == 0 ? 0 : 85) + ((i9 & 64) == 0 ? 0 : 170));
                } else if (i10 == 8) {
                    iArr[i9] = d(127, ((i9 & 1) != 0 ? 85 : 0) + ((i9 & 16) != 0 ? 170 : 0), ((i9 & 2) != 0 ? 85 : 0) + ((i9 & 32) != 0 ? 170 : 0), ((i9 & 4) == 0 ? 0 : 85) + ((i9 & 64) == 0 ? 0 : 170));
                } else if (i10 == 128) {
                    iArr[i9] = d(255, ((i9 & 1) != 0 ? 43 : 0) + 127 + ((i9 & 16) != 0 ? 85 : 0), ((i9 & 2) != 0 ? 43 : 0) + 127 + ((i9 & 32) != 0 ? 85 : 0), ((i9 & 4) == 0 ? 0 : 43) + 127 + ((i9 & 64) == 0 ? 0 : 85));
                } else if (i10 == 136) {
                    iArr[i9] = d(255, ((i9 & 1) != 0 ? 43 : 0) + ((i9 & 16) != 0 ? 85 : 0), ((i9 & 2) != 0 ? 43 : 0) + ((i9 & 32) != 0 ? 85 : 0), ((i9 & 4) == 0 ? 0 : 43) + ((i9 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int d(int i9, int i10, int i11, int i12) {
        return (i9 << 24) | (i10 << 16) | (i11 << 8) | i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x01d7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0206 A[LOOP:3: B:86:0x0155->B:97:0x0206, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0202 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(byte[] r21, int[] r22, int r23, int r24, int r25, android.graphics.Paint r26, android.graphics.Canvas r27) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.i.e(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static a f(a3.g gVar, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 8;
        int i16 = gVar.i(8);
        gVar.s(8);
        int i17 = 2;
        int i18 = i9 - 2;
        int[] iArr = {0, -1, -16777216, -8421505};
        int[] b9 = b();
        int[] c9 = c();
        while (i18 > 0) {
            int i19 = gVar.i(i15);
            int i20 = gVar.i(i15);
            int[] iArr2 = (i20 & 128) != 0 ? iArr : (i20 & 64) != 0 ? b9 : c9;
            if ((i20 & 1) != 0) {
                i13 = gVar.i(i15);
                i14 = gVar.i(i15);
                i10 = gVar.i(i15);
                i12 = gVar.i(i15);
                i11 = i18 - 6;
            } else {
                int i21 = gVar.i(6) << i17;
                int i22 = gVar.i(4) << 4;
                i10 = gVar.i(4) << 4;
                i11 = i18 - 4;
                i12 = gVar.i(i17) << 6;
                i13 = i21;
                i14 = i22;
            }
            if (i13 == 0) {
                i14 = 0;
                i10 = 0;
                i12 = 255;
            }
            double d9 = i13;
            double d10 = i14 - 128;
            double d11 = i10 - 128;
            iArr2[i19] = d((byte) (255 - (i12 & 255)), w.h((int) ((1.402d * d10) + d9), 0, 255), w.h((int) ((d9 - (0.34414d * d11)) - (d10 * 0.71414d)), 0, 255), w.h((int) ((d11 * 1.772d) + d9), 0, 255));
            i18 = i11;
            i16 = i16;
            c9 = c9;
            i15 = 8;
            i17 = 2;
        }
        return new a(i16, iArr, b9, c9);
    }

    public static c g(a3.g gVar) {
        byte[] bArr;
        int i9 = gVar.i(16);
        gVar.s(4);
        int i10 = gVar.i(2);
        boolean h = gVar.h();
        gVar.s(1);
        byte[] bArr2 = w.f3718f;
        if (i10 == 1) {
            gVar.s(gVar.i(8) * 16);
        } else if (i10 == 0) {
            int i11 = gVar.i(16);
            int i12 = gVar.i(16);
            if (i11 > 0) {
                bArr2 = new byte[i11];
                gVar.k(bArr2, i11);
            }
            if (i12 > 0) {
                bArr = new byte[i12];
                gVar.k(bArr, i12);
                return new c(i9, h, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new c(i9, h, bArr2, bArr);
    }

    @Override // z2.l
    public final void a0(byte[] bArr, int i9, int i10, k kVar, g1.c cVar) {
        h hVar;
        z2.a aVar;
        ArrayList arrayList;
        int i11;
        b bVar;
        h hVar2;
        f fVar;
        int i12;
        int i13;
        int i14;
        int i15;
        f fVar2;
        int i16;
        int i17;
        int i18;
        int i19;
        a3.g gVar = new a3.g(bArr, i9 + i10);
        gVar.p(i9);
        while (true) {
            int b9 = gVar.b();
            hVar = this.f1318n;
            if (b9 >= 48 && gVar.i(8) == 15) {
                int i20 = gVar.i(8);
                int i21 = gVar.i(16);
                int i22 = gVar.i(16);
                int f9 = gVar.f() + i22;
                if (i22 * 8 > gVar.b()) {
                    g1.a.D("DvbParser", "Data field length exceeds limit");
                    gVar.s(gVar.b());
                } else {
                    switch (i20) {
                        case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                            if (i21 == hVar.f1302a) {
                                d dVar = hVar.f1309i;
                                gVar.i(8);
                                int i23 = gVar.i(4);
                                int i24 = gVar.i(2);
                                gVar.s(2);
                                int i25 = i22 - 2;
                                SparseArray sparseArray = new SparseArray();
                                while (i25 > 0) {
                                    int i26 = gVar.i(8);
                                    gVar.s(8);
                                    i25 -= 6;
                                    sparseArray.put(i26, new e(gVar.i(16), gVar.i(16)));
                                }
                                d dVar2 = new d(i23, i24, sparseArray);
                                if (i24 != 0) {
                                    hVar.f1309i = dVar2;
                                    hVar.f1304c.clear();
                                    hVar.f1305d.clear();
                                    hVar.f1306e.clear();
                                    break;
                                } else if (dVar != null && dVar.f1286j != i23) {
                                    hVar.f1309i = dVar2;
                                    break;
                                }
                            }
                            break;
                        case 17:
                            d dVar3 = hVar.f1309i;
                            SparseArray sparseArray2 = hVar.f1304c;
                            if (i21 == hVar.f1302a && dVar3 != null) {
                                int i27 = gVar.i(8);
                                gVar.s(4);
                                boolean h = gVar.h();
                                gVar.s(3);
                                int i28 = gVar.i(16);
                                int i29 = gVar.i(16);
                                gVar.i(3);
                                int i30 = gVar.i(3);
                                gVar.s(2);
                                int i31 = gVar.i(8);
                                int i32 = gVar.i(8);
                                int i33 = gVar.i(4);
                                int i34 = gVar.i(2);
                                gVar.s(2);
                                int i35 = i22 - 10;
                                SparseArray sparseArray3 = new SparseArray();
                                while (i35 > 0) {
                                    int i36 = gVar.i(16);
                                    int i37 = gVar.i(2);
                                    gVar.i(2);
                                    int i38 = gVar.i(12);
                                    gVar.s(4);
                                    int i39 = gVar.i(12);
                                    int i40 = i35 - 6;
                                    if (i37 == 1 || i37 == 2) {
                                        gVar.i(8);
                                        gVar.i(8);
                                        i35 -= 8;
                                    } else {
                                        i35 = i40;
                                    }
                                    sparseArray3.put(i36, new g(i38, i39));
                                }
                                f fVar3 = new f(i27, h, i28, i29, i30, i31, i32, i33, i34, sparseArray3);
                                if (dVar3.f1287k == 0 && (fVar2 = (f) sparseArray2.get(i27)) != null) {
                                    SparseArray sparseArray4 = fVar2.f1299j;
                                    for (int i41 = 0; i41 < sparseArray4.size(); i41++) {
                                        fVar3.f1299j.put(sparseArray4.keyAt(i41), (g) sparseArray4.valueAt(i41));
                                    }
                                }
                                sparseArray2.put(fVar3.f1291a, fVar3);
                                break;
                            }
                            break;
                        case 18:
                            if (i21 == hVar.f1302a) {
                                a f10 = f(gVar, i22);
                                hVar.f1305d.put(f10.f1271a, f10);
                                break;
                            } else if (i21 == hVar.f1303b) {
                                a f11 = f(gVar, i22);
                                hVar.f1307f.put(f11.f1271a, f11);
                                break;
                            }
                            break;
                        case 19:
                            if (i21 == hVar.f1302a) {
                                c g9 = g(gVar);
                                hVar.f1306e.put(g9.f1281a, g9);
                                break;
                            } else if (i21 == hVar.f1303b) {
                                c g10 = g(gVar);
                                hVar.f1308g.put(g10.f1281a, g10);
                                break;
                            }
                            break;
                        case 20:
                            if (i21 == hVar.f1302a) {
                                gVar.s(4);
                                boolean h9 = gVar.h();
                                gVar.s(3);
                                int i42 = gVar.i(16);
                                int i43 = gVar.i(16);
                                if (h9) {
                                    int i44 = gVar.i(16);
                                    i16 = gVar.i(16);
                                    i19 = gVar.i(16);
                                    i17 = gVar.i(16);
                                    i18 = i44;
                                } else {
                                    i16 = i42;
                                    i17 = i43;
                                    i18 = 0;
                                    i19 = 0;
                                }
                                hVar.h = new b(i42, i43, i18, i16, i19, i17);
                                break;
                            }
                            break;
                    }
                    gVar.t(f9 - gVar.f());
                }
            }
        }
        d dVar4 = hVar.f1309i;
        if (dVar4 == null) {
            e0 e0Var = g0.f1391j;
            aVar = new z2.a(-9223372036854775807L, -9223372036854775807L, w0.f1464m);
        } else {
            b bVar2 = hVar.h;
            if (bVar2 == null) {
                bVar2 = this.f1316l;
            }
            Bitmap bitmap = this.f1319o;
            Canvas canvas = this.f1315k;
            if (bitmap == null || bVar2.f1275a + 1 != bitmap.getWidth() || bVar2.f1276b + 1 != this.f1319o.getHeight()) {
                Bitmap createBitmap = Bitmap.createBitmap(bVar2.f1275a + 1, bVar2.f1276b + 1, Bitmap.Config.ARGB_8888);
                this.f1319o = createBitmap;
                canvas.setBitmap(createBitmap);
            }
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray5 = (SparseArray) dVar4.f1288l;
            int i45 = 0;
            while (i45 < sparseArray5.size()) {
                canvas.save();
                e eVar = (e) sparseArray5.valueAt(i45);
                f fVar4 = (f) hVar.f1304c.get(sparseArray5.keyAt(i45));
                int i46 = eVar.f1289a + bVar2.f1277c;
                int i47 = eVar.f1290b + bVar2.f1279e;
                int i48 = fVar4.f1293c;
                int i49 = fVar4.f1296f;
                int i50 = fVar4.f1294d;
                int i51 = i46 + i48;
                int i52 = i47 + i50;
                SparseArray sparseArray6 = sparseArray5;
                canvas.clipRect(i46, i47, Math.min(i51, bVar2.f1278d), Math.min(i52, bVar2.f1280f));
                a aVar2 = (a) hVar.f1305d.get(i49);
                if (aVar2 == null && (aVar2 = (a) hVar.f1307f.get(i49)) == null) {
                    aVar2 = this.f1317m;
                }
                SparseArray sparseArray7 = fVar4.f1299j;
                int i53 = i45;
                int i54 = 0;
                while (i54 < sparseArray7.size()) {
                    int keyAt = sparseArray7.keyAt(i54);
                    SparseArray sparseArray8 = sparseArray7;
                    g gVar2 = (g) sparseArray7.valueAt(i54);
                    int i55 = i47;
                    c cVar2 = (c) hVar.f1306e.get(keyAt);
                    if (cVar2 == null) {
                        cVar2 = (c) hVar.f1308g.get(keyAt);
                    }
                    c cVar3 = cVar2;
                    if (cVar3 != null) {
                        Paint paint = cVar3.f1282b ? null : this.f1313i;
                        int i56 = i46;
                        int i57 = fVar4.f1295e;
                        hVar2 = hVar;
                        int i58 = i56 + gVar2.f1300a;
                        int i59 = i55 + gVar2.f1301b;
                        int i60 = i50;
                        Paint paint2 = paint;
                        bVar = bVar2;
                        i13 = i48;
                        i12 = i56;
                        arrayList = arrayList2;
                        i11 = i55;
                        f fVar5 = fVar4;
                        int[] iArr = i57 == 3 ? aVar2.f1274d : i57 == 2 ? aVar2.f1273c : aVar2.f1272b;
                        fVar = fVar5;
                        i14 = i54;
                        i15 = i60;
                        e(cVar3.f1283c, iArr, i57, i58, i59, paint2, canvas);
                        e(cVar3.f1284d, iArr, i57, i58, i59 + 1, paint2, canvas);
                    } else {
                        arrayList = arrayList2;
                        i11 = i55;
                        bVar = bVar2;
                        hVar2 = hVar;
                        fVar = fVar4;
                        i12 = i46;
                        i13 = i48;
                        i14 = i54;
                        i15 = i50;
                    }
                    i54 = i14 + 1;
                    i48 = i13;
                    i47 = i11;
                    fVar4 = fVar;
                    i46 = i12;
                    arrayList2 = arrayList;
                    sparseArray7 = sparseArray8;
                    bVar2 = bVar;
                    hVar = hVar2;
                    i50 = i15;
                }
                b bVar3 = bVar2;
                ArrayList arrayList3 = arrayList2;
                h hVar3 = hVar;
                int i61 = i47;
                f fVar6 = fVar4;
                int i62 = i46;
                int i63 = i48;
                int i64 = i50;
                if (fVar6.f1292b) {
                    int i65 = fVar6.f1295e;
                    int i66 = i65 == 3 ? aVar2.f1274d[fVar6.f1297g] : i65 == 2 ? aVar2.f1273c[fVar6.h] : aVar2.f1272b[fVar6.f1298i];
                    Paint paint3 = this.f1314j;
                    paint3.setColor(i66);
                    canvas.drawRect(i62, i61, i51, i52, paint3);
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(this.f1319o, i62, i61, i63, i64);
                float f12 = bVar3.f1275a;
                float f13 = bVar3.f1276b;
                arrayList3.add(new f1.b(null, null, null, createBitmap2, i61 / f13, 0, 0, i62 / f12, 0, Integer.MIN_VALUE, -3.4028235E38f, i63 / f12, i64 / f13, false, -16777216, Integer.MIN_VALUE, 0.0f));
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                i45 = i53 + 1;
                bVar2 = bVar3;
                arrayList2 = arrayList3;
                sparseArray5 = sparseArray6;
                hVar = hVar3;
            }
            aVar = new z2.a(-9223372036854775807L, -9223372036854775807L, arrayList2);
        }
        cVar.accept(aVar);
    }

    @Override // z2.l
    public final /* synthetic */ z2.f h0(int i9, int i10, byte[] bArr) {
        return t.a.a(this, bArr, i10);
    }

    @Override // z2.l
    public final void reset() {
        h hVar = this.f1318n;
        hVar.f1304c.clear();
        hVar.f1305d.clear();
        hVar.f1306e.clear();
        hVar.f1307f.clear();
        hVar.f1308g.clear();
        hVar.h = null;
        hVar.f1309i = null;
    }
}
