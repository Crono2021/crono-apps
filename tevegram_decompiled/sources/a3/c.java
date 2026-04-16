package a3;

import g1.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends l {
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f58i;

    /* renamed from: j, reason: collision with root package name */
    public final int f59j;

    /* renamed from: n, reason: collision with root package name */
    public List f63n;

    /* renamed from: o, reason: collision with root package name */
    public List f64o;

    /* renamed from: p, reason: collision with root package name */
    public int f65p;

    /* renamed from: q, reason: collision with root package name */
    public int f66q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f67r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f68s;

    /* renamed from: t, reason: collision with root package name */
    public byte f69t;

    /* renamed from: u, reason: collision with root package name */
    public byte f70u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f72w;

    /* renamed from: x, reason: collision with root package name */
    public long f73x;

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f55y = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f56z = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] A = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, IjkMediaMeta.FF_PROFILE_H264_HIGH_10, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, IjkMediaMeta.FF_PROFILE_H264_HIGH_422, 231, 247, 209, 241, 9632};
    public static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 251};
    public static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: g, reason: collision with root package name */
    public final p f57g = new p();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f61l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public b f62m = new b(0, 4);

    /* renamed from: v, reason: collision with root package name */
    public int f71v = 0;

    /* renamed from: k, reason: collision with root package name */
    public final long f60k = 16000000;

    public c(String str, int i9) {
        this.h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i9 == 1) {
            this.f59j = 0;
            this.f58i = 0;
        } else if (i9 == 2) {
            this.f59j = 1;
            this.f58i = 0;
        } else if (i9 == 3) {
            this.f59j = 0;
            this.f58i = 1;
        } else if (i9 != 4) {
            g1.a.D("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f59j = 0;
            this.f58i = 0;
        } else {
            this.f59j = 1;
            this.f58i = 1;
        }
        k(0);
        j();
        this.f72w = true;
        this.f73x = -9223372036854775807L;
    }

    @Override // a3.l
    public final a0.b e() {
        List list = this.f63n;
        this.f64o = list;
        list.getClass();
        return new a0.b(list, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085 A[SYNTHETIC] */
    @Override // a3.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(a3.j r15) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.c.f(a3.j):void");
    }

    @Override // a3.l, j1.b
    public final void flush() {
        super.flush();
        this.f63n = null;
        this.f64o = null;
        k(0);
        this.f66q = 4;
        this.f62m.h = 4;
        j();
        this.f67r = false;
        this.f68s = false;
        this.f69t = (byte) 0;
        this.f70u = (byte) 0;
        this.f71v = 0;
        this.f72w = true;
        this.f73x = -9223372036854775807L;
    }

    @Override // a3.l, j1.b
    /* renamed from: g */
    public final z2.j c() {
        z2.j jVar;
        z2.j c9 = super.c();
        if (c9 != null) {
            return c9;
        }
        long j5 = this.f60k;
        if (j5 == -9223372036854775807L) {
            return null;
        }
        long j9 = this.f73x;
        if (j9 == -9223372036854775807L || this.f125e - j9 < j5 || (jVar = (z2.j) this.f122b.pollFirst()) == null) {
            return null;
        }
        this.f63n = Collections.EMPTY_LIST;
        this.f73x = -9223372036854775807L;
        a0.b e9 = e();
        long j10 = this.f125e;
        jVar.f5365k = j10;
        jVar.f10618m = e9;
        jVar.f10619n = j10;
        return jVar;
    }

    @Override // a3.l
    public final boolean h() {
        return this.f63n != this.f64o;
    }

    public final ArrayList i() {
        ArrayList arrayList = this.f61l;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        int i9 = 2;
        for (int i10 = 0; i10 < size; i10++) {
            f1.b c9 = ((b) arrayList.get(i10)).c(Integer.MIN_VALUE);
            arrayList2.add(c9);
            if (c9 != null) {
                i9 = Math.min(i9, c9.f3250i);
            }
        }
        ArrayList arrayList3 = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            f1.b bVar = (f1.b) arrayList2.get(i11);
            if (bVar != null) {
                if (bVar.f3250i != i9) {
                    bVar = ((b) arrayList.get(i11)).c(i9);
                    bVar.getClass();
                }
                arrayList3.add(bVar);
            }
        }
        return arrayList3;
    }

    public final void j() {
        b bVar = this.f62m;
        bVar.f54g = this.f65p;
        bVar.f48a.clear();
        bVar.f49b.clear();
        bVar.f50c.setLength(0);
        bVar.f51d = 15;
        bVar.f52e = 0;
        bVar.f53f = 0;
        ArrayList arrayList = this.f61l;
        arrayList.clear();
        arrayList.add(this.f62m);
    }

    public final void k(int i9) {
        int i10 = this.f65p;
        if (i10 == i9) {
            return;
        }
        this.f65p = i9;
        if (i9 != 3) {
            j();
            if (i10 == 3 || i9 == 1 || i9 == 0) {
                this.f63n = Collections.EMPTY_LIST;
                return;
            }
            return;
        }
        int i11 = 0;
        while (true) {
            ArrayList arrayList = this.f61l;
            if (i11 >= arrayList.size()) {
                return;
            }
            ((b) arrayList.get(i11)).f54g = i9;
            i11++;
        }
    }

    @Override // a3.l, j1.b
    public final void release() {
    }
}
