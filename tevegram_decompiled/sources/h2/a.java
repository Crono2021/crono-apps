package h2;

import d1.w;
import d2.d;
import d2.e;
import d2.f;
import d2.h;
import d2.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final d f3895a;

    /* renamed from: b, reason: collision with root package name */
    public final h f3896b;

    /* renamed from: c, reason: collision with root package name */
    public e f3897c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3898d;

    public a(f fVar, h hVar, long j5, long j9, long j10, long j11, long j12, int i9) {
        this.f3896b = hVar;
        this.f3898d = i9;
        this.f3895a = new d(fVar, j5, j9, j10, j11, j12);
    }

    public static int a(byte[] bArr, int i9) {
        return (bArr[i9 + 3] & 255) | ((bArr[i9] & 255) << 24) | ((bArr[i9 + 1] & 255) << 16) | ((bArr[i9 + 2] & 255) << 8);
    }

    public static int c(n nVar, long j5, w wVar) {
        if (j5 == nVar.getPosition()) {
            return 0;
        }
        wVar.f2583a = j5;
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c9, code lost:
    
        return c(r27, r8, r28);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(d2.n r27, d1.w r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r28
        L6:
            d2.e r3 = r0.f3897c
            g1.a.l(r3)
            long r4 = r3.f2680f
            long r6 = r3.f2681g
            long r8 = r3.h
            long r6 = r6 - r4
            int r10 = r0.f3898d
            long r10 = (long) r10
            r12 = 0
            d2.h r13 = r0.f3896b
            int r14 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r14 > 0) goto L26
            r0.f3897c = r12
            r13.e0()
            int r1 = c(r1, r4, r2)
            return r1
        L26:
            long r4 = r1.getPosition()
            long r4 = r8 - r4
            r6 = 0
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 < 0) goto Lc5
            r10 = 262144(0x40000, double:1.295163E-318)
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 > 0) goto Lc5
            int r5 = (int) r4
            r1.i(r5)
            r1.h()
            long r4 = r3.f2676b
            d2.g r4 = r13.b0(r1, r4)
            int r5 = r4.f2691a
            long r14 = r4.f2692b
            r16 = r6
            long r6 = r4.f2693c
            r4 = -3
            if (r5 == r4) goto Lbb
            r4 = -2
            if (r5 == r4) goto L9c
            r4 = -1
            if (r5 == r4) goto L7c
            if (r5 != 0) goto L75
            long r3 = r1.getPosition()
            long r3 = r6 - r3
            int r5 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r5 < 0) goto L6b
            int r5 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r5 > 0) goto L6b
            int r4 = (int) r3
            r1.i(r4)
        L6b:
            r0.f3897c = r12
            r13.e0()
            int r1 = c(r1, r6, r2)
            return r1
        L75:
            java.lang.String r1 = "Invalid case"
            m7.c.p(r1)
            r1 = 0
            return r1
        L7c:
            r3.f2679e = r14
            r3.f2681g = r6
            r16 = r14
            long r14 = r3.f2676b
            long r4 = r3.f2678d
            long r8 = r3.f2680f
            long r10 = r3.f2677c
            r22 = r6
            r20 = r8
            r24 = r10
            r18 = r16
            r16 = r4
            long r4 = d2.e.a(r14, r16, r18, r20, r22, r24)
            r3.h = r4
            goto L6
        L9c:
            r4 = r14
            r3.f2678d = r4
            r3.f2680f = r6
            long r14 = r3.f2676b
            long r8 = r3.f2679e
            long r10 = r3.f2681g
            long r12 = r3.f2677c
            r16 = r4
            r20 = r6
            r18 = r8
            r22 = r10
            r24 = r12
            long r4 = d2.e.a(r14, r16, r18, r20, r22, r24)
            r3.h = r4
            goto L6
        Lbb:
            r0.f3897c = r12
            r13.e0()
            int r1 = c(r1, r8, r2)
            return r1
        Lc5:
            int r1 = c(r1, r8, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.a.b(d2.n, d1.w):int");
    }

    public final void d(long j5) {
        e eVar = this.f3897c;
        if (eVar == null || eVar.f2675a != j5) {
            d dVar = this.f3895a;
            this.f3897c = new e(j5, dVar.f2669a.e(j5), dVar.f2671c, dVar.f2672d, dVar.f2673e, dVar.f2674f);
        }
    }
}
