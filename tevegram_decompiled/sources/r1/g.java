package r1;

import android.graphics.Bitmap;
import d1.s;
import i7.x;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends l1.e {
    public final j1.e A;
    public final ArrayDeque B;
    public boolean C;
    public boolean D;
    public f E;
    public long F;
    public long G;
    public int H;
    public int I;
    public s J;
    public b K;
    public j1.e L;
    public e M;
    public Bitmap N;
    public boolean O;
    public com.google.crypto.tink.shaded.protobuf.d P;
    public com.google.crypto.tink.shaded.protobuf.d Q;
    public int R;

    /* renamed from: z, reason: collision with root package name */
    public final c f8530z;

    public g(c cVar) {
        super(4);
        this.f8530z = cVar;
        this.M = e.f8526a;
        this.A = new j1.e(0, 0);
        this.E = f.f8527c;
        this.B = new ArrayDeque();
        this.G = -9223372036854775807L;
        this.F = -9223372036854775807L;
        this.H = 0;
        this.I = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0148, code lost:
    
        if (r14 == ((r0 * r1.G) - 1)) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B(long r13) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.g.B(long):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if (r2 == null) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0112, code lost:
    
        if (r2 == false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(long r14) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.g.C(long):boolean");
    }

    public final void D() {
        s sVar = this.J;
        x xVar = (x) this.f8530z;
        int M = xVar.M(sVar);
        if (M != androidx.activity.g.f(4, 0, 0, 0) && M != androidx.activity.g.f(3, 0, 0, 0)) {
            throw l(new d("Provided decoder factory can't create decoder for format."), this.J, false, 4005);
        }
        b bVar = this.K;
        if (bVar != null) {
            bVar.release();
        }
        this.K = new b((m7.c) xVar.f5179j);
    }

    public final void E() {
        this.L = null;
        this.H = 0;
        this.G = -9223372036854775807L;
        b bVar = this.K;
        if (bVar != null) {
            bVar.release();
            this.K = null;
        }
    }

    @Override // l1.e, l1.b1
    public final boolean a() {
        return this.D;
    }

    @Override // l1.b1
    public final boolean b() {
        int i9 = this.I;
        if (i9 != 3) {
            return i9 == 0 && this.O;
        }
        return true;
    }

    @Override // l1.b1
    public final void f(long j5, long j9) {
        if (this.D) {
            return;
        }
        if (this.J == null) {
            a5.d dVar = this.f5828k;
            dVar.o0();
            j1.e eVar = this.A;
            eVar.k();
            int w8 = w(dVar, eVar, 2);
            if (w8 != -5) {
                if (w8 == -4) {
                    g1.a.k(eVar.c(4));
                    this.C = true;
                    this.D = true;
                    return;
                }
                return;
            }
            s sVar = (s) dVar.f175k;
            g1.a.l(sVar);
            this.J = sVar;
            D();
        }
        try {
            g1.a.b("drainAndFeedDecoder");
            while (B(j5)) {
            }
            while (C(j5)) {
            }
            g1.a.r();
        } catch (d e9) {
            throw l(e9, null, false, 4003);
        }
    }

    @Override // l1.e, l1.x0
    public final void g(int i9, Object obj) {
        if (i9 != 15) {
            return;
        }
        e eVar = obj instanceof e ? (e) obj : null;
        if (eVar == null) {
            eVar = e.f8526a;
        }
        this.M = eVar;
    }

    @Override // l1.b1
    public final String getName() {
        return "ImageRenderer";
    }

    @Override // l1.e
    public final void n() {
        this.J = null;
        this.E = f.f8527c;
        this.B.clear();
        E();
        this.M.getClass();
    }

    @Override // l1.e
    public final void o(boolean z8, boolean z9) {
        this.I = z9 ? 1 : 0;
    }

    @Override // l1.e
    public final void q(long j5, boolean z8) {
        this.I = Math.min(this.I, 1);
        this.D = false;
        this.C = false;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.O = false;
        this.L = null;
        b bVar = this.K;
        if (bVar != null) {
            bVar.flush();
        }
        this.B.clear();
    }

    @Override // l1.e
    public final void r() {
        E();
    }

    @Override // l1.e
    public final void s() {
        E();
        this.I = Math.min(this.I, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r2 >= r7) goto L15;
     */
    @Override // l1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(d1.s[] r6, long r7, long r9) {
        /*
            r5 = this;
            r1.f r6 = r5.E
            long r6 = r6.f8529b
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r8 == 0) goto L31
            java.util.ArrayDeque r6 = r5.B
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L26
            long r7 = r5.G
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 == 0) goto L31
            long r2 = r5.F
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 == 0) goto L26
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 < 0) goto L26
            goto L31
        L26:
            r1.f r7 = new r1.f
            long r0 = r5.G
            r7.<init>(r0, r9)
            r6.add(r7)
            return
        L31:
            r1.f r6 = new r1.f
            r6.<init>(r0, r9)
            r5.E = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.g.v(d1.s[], long, long):void");
    }

    @Override // l1.e
    public final int z(s sVar) {
        return ((x) this.f8530z).M(sVar);
    }
}
