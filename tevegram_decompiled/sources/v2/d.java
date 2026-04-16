package v2;

import d1.j0;
import d2.d0;
import d2.l;
import d2.m;
import d2.n;
import d2.o;
import d2.s;
import d2.u;
import d2.w;
import g1.p;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements m {

    /* renamed from: a, reason: collision with root package name */
    public final long f9474a;

    /* renamed from: b, reason: collision with root package name */
    public final p f9475b;

    /* renamed from: c, reason: collision with root package name */
    public final w f9476c;

    /* renamed from: d, reason: collision with root package name */
    public final s f9477d;

    /* renamed from: e, reason: collision with root package name */
    public final u f9478e;

    /* renamed from: f, reason: collision with root package name */
    public final l f9479f;

    /* renamed from: g, reason: collision with root package name */
    public o f9480g;
    public d0 h;

    /* renamed from: i, reason: collision with root package name */
    public d0 f9481i;

    /* renamed from: j, reason: collision with root package name */
    public int f9482j;

    /* renamed from: k, reason: collision with root package name */
    public j0 f9483k;

    /* renamed from: l, reason: collision with root package name */
    public long f9484l;

    /* renamed from: m, reason: collision with root package name */
    public long f9485m;

    /* renamed from: n, reason: collision with root package name */
    public long f9486n;

    /* renamed from: o, reason: collision with root package name */
    public int f9487o;

    /* renamed from: p, reason: collision with root package name */
    public f f9488p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9489q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f9490r;

    /* renamed from: s, reason: collision with root package name */
    public long f9491s;

    public d(long j5) {
        this.f9474a = j5;
        this.f9475b = new p(10);
        this.f9476c = new w();
        this.f9477d = new s();
        this.f9484l = -9223372036854775807L;
        this.f9478e = new u(0);
        l lVar = new l();
        this.f9479f = lVar;
        this.f9481i = lVar;
    }

    public final a b(n nVar, long j5, boolean z8) {
        p pVar = this.f9475b;
        nVar.a(0, 4, pVar.f3699a);
        pVar.F(0);
        this.f9476c.b(pVar.g());
        if (nVar.e() != -1) {
            j5 = nVar.e();
        }
        return new a(j5, nVar.getPosition(), this.f9476c, z8);
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        this.f9482j = 0;
        this.f9484l = -9223372036854775807L;
        this.f9485m = 0L;
        this.f9487o = 0;
        this.f9491s = j9;
        f fVar = this.f9488p;
        if (!(fVar instanceof b) || ((b) fVar).a(j9)) {
            return;
        }
        this.f9490r = true;
        this.f9481i = this.f9479f;
    }

    @Override // d2.m
    public final void d(o oVar) {
        this.f9480g = oVar;
        d0 l4 = oVar.l(0, 1);
        this.h = l4;
        this.f9481i = l4;
        this.f9480g.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r9.o() > (r2 - 4)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(d2.n r9) {
        /*
            r8 = this;
            v2.f r0 = r8.f9488p
            r1 = 1
            if (r0 == 0) goto L1b
            long r2 = r0.b()
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L1b
            long r4 = r9.o()
            r6 = 4
            long r2 = r2 - r6
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L1b
            goto L27
        L1b:
            g1.p r0 = r8.f9475b     // Catch: java.io.EOFException -> L27
            byte[] r0 = r0.f3699a     // Catch: java.io.EOFException -> L27
            r2 = 0
            r3 = 4
            boolean r9 = r9.n(r0, r2, r3, r1)     // Catch: java.io.EOFException -> L27
            r9 = r9 ^ r1
            return r9
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.d.e(d2.n):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d9, code lost:
    
        if (r19 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00db, code lost:
    
        r18.i(r4 + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e3, code lost:
    
        r17.f9482j = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e5, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e0, code lost:
    
        r18.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(d2.n r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.d.f(d2.n, boolean):boolean");
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        return f(nVar, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0068, code lost:
    
        if (r9 != 1231971951) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02fd  */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(d2.n r54, d1.w r55) {
        /*
            Method dump skipped, instructions count: 1161
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.d.h(d2.n, d1.w):int");
    }

    @Override // d2.m
    public final m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }

    public d(int i9) {
        this(-9223372036854775807L);
    }
}
