package v1;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z0 extends d1.y0 {

    /* renamed from: n, reason: collision with root package name */
    public static final Object f9452n = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final long f9453b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9454c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9455d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9456e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9457f;

    /* renamed from: g, reason: collision with root package name */
    public final long f9458g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f9459i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f9460j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f9461k;

    /* renamed from: l, reason: collision with root package name */
    public final d1.e0 f9462l;

    /* renamed from: m, reason: collision with root package name */
    public final d1.a0 f9463m;

    static {
        d1.w wVar = new d1.w();
        b6.e0 e0Var = b6.g0.f1391j;
        b6.w0 w0Var = b6.w0.f1464m;
        List list = Collections.EMPTY_LIST;
        b6.w0 w0Var2 = b6.w0.f1464m;
        d1.z zVar = new d1.z();
        d1.c0 c0Var = d1.c0.f2371a;
        Uri uri = Uri.EMPTY;
        if (uri != null) {
            new d1.b0(uri, null, null, list, w0Var2, -9223372036854775807L);
        }
        wVar.a();
        zVar.a();
        d1.h0 h0Var = d1.h0.f2449y;
    }

    public z0(long j5, long j9, long j10, long j11, long j12, long j13, boolean z8, boolean z9, boolean z10, o4.d dVar, d1.e0 e0Var, d1.a0 a0Var) {
        this.f9453b = j5;
        this.f9454c = j9;
        this.f9455d = j10;
        this.f9456e = j11;
        this.f9457f = j12;
        this.f9458g = j13;
        this.h = z8;
        this.f9459i = z9;
        this.f9460j = z10;
        this.f9461k = dVar;
        e0Var.getClass();
        this.f9462l = e0Var;
        this.f9463m = a0Var;
    }

    @Override // d1.y0
    public final int b(Object obj) {
        return f9452n.equals(obj) ? 0 : -1;
    }

    @Override // d1.y0
    public final d1.w0 f(int i9, d1.w0 w0Var, boolean z8) {
        g1.a.i(i9, 1);
        Object obj = z8 ? f9452n : null;
        long j5 = -this.f9457f;
        w0Var.getClass();
        w0Var.h(null, obj, 0, this.f9455d, j5, d1.c.f2367c, false);
        return w0Var;
    }

    @Override // d1.y0
    public final int h() {
        return 1;
    }

    @Override // d1.y0
    public final Object l(int i9) {
        g1.a.i(i9, 1);
        return f9452n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r1 > r5) goto L10;
     */
    @Override // d1.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d1.x0 m(int r22, d1.x0 r23, long r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = 1
            r2 = r22
            g1.a.i(r2, r1)
            long r1 = r0.f9458g
            boolean r13 = r0.f9459i
            if (r13 == 0) goto L2c
            boolean r3 = r0.f9460j
            if (r3 != 0) goto L2c
            r3 = 0
            int r5 = (r24 > r3 ? 1 : (r24 == r3 ? 0 : -1))
            if (r5 == 0) goto L2c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r5 = r0.f9456e
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L25
        L23:
            r15 = r3
            goto L2d
        L25:
            long r1 = r1 + r24
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L2c
            goto L23
        L2c:
            r15 = r1
        L2d:
            java.lang.Object r1 = d1.x0.f2592r
            long r1 = r0.f9456e
            long r3 = r0.f9457f
            r19 = r3
            d1.e0 r4 = r0.f9462l
            java.lang.Object r5 = r0.f9461k
            long r6 = r0.f9453b
            long r8 = r0.f9454c
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            boolean r12 = r0.h
            d1.a0 r14 = r0.f9463m
            r3 = r23
            r17 = r1
            r3.b(r4, r5, r6, r8, r10, r12, r13, r14, r15, r17, r19)
            return r23
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.z0.m(int, d1.x0, long):d1.x0");
    }

    @Override // d1.y0
    public final int o() {
        return 1;
    }
}
