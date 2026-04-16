package d2;

import d1.j0;
import d1.l0;
import java.util.Collections;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final int f2718a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2719b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2720c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2721d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2722e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2723f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2724g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2725i;

    /* renamed from: j, reason: collision with root package name */
    public final long f2726j;

    /* renamed from: k, reason: collision with root package name */
    public final a5.d f2727k;

    /* renamed from: l, reason: collision with root package name */
    public final j0 f2728l;

    public q(byte[] bArr, int i9) {
        a3.g gVar = new a3.g(bArr, bArr.length);
        gVar.p(i9 * 8);
        this.f2718a = gVar.i(16);
        this.f2719b = gVar.i(16);
        this.f2720c = gVar.i(24);
        this.f2721d = gVar.i(24);
        int i10 = gVar.i(20);
        this.f2722e = i10;
        this.f2723f = d(i10);
        this.f2724g = gVar.i(3) + 1;
        int i11 = gVar.i(5) + 1;
        this.h = i11;
        this.f2725i = a(i11);
        int i12 = gVar.i(4);
        int i13 = gVar.i(32);
        int i14 = g1.w.f3713a;
        this.f2726j = ((i12 & 4294967295L) << 32) | (i13 & 4294967295L);
        this.f2727k = null;
        this.f2728l = null;
    }

    public static int a(int i9) {
        if (i9 == 8) {
            return 1;
        }
        if (i9 == 12) {
            return 2;
        }
        if (i9 == 16) {
            return 4;
        }
        if (i9 != 20) {
            return i9 != 24 ? -1 : 6;
        }
        return 5;
    }

    public static int d(int i9) {
        switch (i9) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long b() {
        long j5 = this.f2726j;
        if (j5 == 0) {
            return -9223372036854775807L;
        }
        return (j5 * 1000000) / this.f2722e;
    }

    public final d1.s c(byte[] bArr, j0 j0Var) {
        bArr[4] = Byte.MIN_VALUE;
        int i9 = this.f2721d;
        if (i9 <= 0) {
            i9 = -1;
        }
        j0 j0Var2 = this.f2728l;
        if (j0Var2 != null) {
            j0Var = j0Var2.e(j0Var);
        }
        d1.r rVar = new d1.r();
        rVar.f2528l = l0.k("audio/flac");
        rVar.f2529m = i9;
        rVar.f2541y = this.f2724g;
        rVar.f2542z = this.f2722e;
        rVar.A = g1.w.x(this.h);
        rVar.f2530n = Collections.singletonList(bArr);
        rVar.f2526j = j0Var;
        return new d1.s(rVar);
    }

    public q(int i9, int i10, int i11, int i12, int i13, int i14, int i15, long j5, a5.d dVar, j0 j0Var) {
        this.f2718a = i9;
        this.f2719b = i10;
        this.f2720c = i11;
        this.f2721d = i12;
        this.f2722e = i13;
        this.f2723f = d(i13);
        this.f2724g = i14;
        this.h = i15;
        this.f2725i = a(i15);
        this.f2726j = j5;
        this.f2727k = dVar;
        this.f2728l = j0Var;
    }
}
