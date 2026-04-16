package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements d2.m {

    /* renamed from: a, reason: collision with root package name */
    public final b f4426a = new b(null, 0, 1);

    /* renamed from: b, reason: collision with root package name */
    public final g1.p f4427b = new g1.p(16384);

    /* renamed from: c, reason: collision with root package name */
    public boolean f4428c;

    @Override // d2.m
    public final void c(long j5, long j9) {
        this.f4428c = false;
        this.f4426a.a();
    }

    @Override // d2.m
    public final void d(d2.o oVar) {
        this.f4426a.f(oVar, new e0(0, 1));
        oVar.c();
        oVar.t(new d2.p(-9223372036854775807L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        r5.f2705n = 0;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        if ((r1 - r3) < 8192) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0088, code lost:
    
        return false;
     */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(d2.n r15) {
        /*
            r14 = this;
            g1.p r0 = new g1.p
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.f3699a
            r5 = r15
            d2.j r5 = (d2.j) r5
            r5.n(r4, r2, r1, r2)
            r0.F(r2)
            int r4 = r0.w()
            r6 = 4801587(0x494433, float:6.728456E-39)
            r7 = 3
            if (r4 == r6) goto L8f
            r5.f2705n = r2
            r5.c(r3, r2)
            r1 = r3
        L24:
            r15 = 0
        L25:
            byte[] r4 = r0.f3699a
            r6 = 7
            r5.n(r4, r2, r6, r2)
            r0.F(r2)
            int r4 = r0.z()
            r8 = 44096(0xac40, float:6.1792E-41)
            r9 = 44097(0xac41, float:6.1793E-41)
            if (r4 == r8) goto L4b
            if (r4 == r9) goto L4b
            r5.f2705n = r2
            int r1 = r1 + 1
            int r15 = r1 - r3
            r4 = 8192(0x2000, float:1.148E-41)
            if (r15 < r4) goto L47
            goto L88
        L47:
            r5.c(r1, r2)
            goto L24
        L4b:
            r8 = 1
            int r15 = r15 + r8
            r10 = 4
            if (r15 < r10) goto L51
            return r8
        L51:
            byte[] r8 = r0.f3699a
            int r11 = r8.length
            r12 = -1
            if (r11 >= r6) goto L59
            r11 = -1
            goto L86
        L59:
            r11 = 2
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r13 = r8[r7]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r13 = 65535(0xffff, float:9.1834E-41)
            if (r11 != r13) goto L80
            r10 = r8[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 16
            r11 = 5
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r10 = r10 | r11
            r11 = 6
            r8 = r8[r11]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r11 = r10 | r8
            goto L81
        L80:
            r6 = 4
        L81:
            if (r4 != r9) goto L85
            int r6 = r6 + 2
        L85:
            int r11 = r11 + r6
        L86:
            if (r11 != r12) goto L89
        L88:
            return r2
        L89:
            int r11 = r11 + (-7)
            r5.c(r11, r2)
            goto L25
        L8f:
            r0.G(r7)
            int r4 = r0.s()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.c(r4, r2)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.c.g(d2.n):boolean");
    }

    @Override // d2.m
    public final int h(d2.n nVar, d1.w wVar) {
        g1.p pVar = this.f4427b;
        int read = nVar.read(pVar.f3699a, 0, 16384);
        if (read == -1) {
            return -1;
        }
        pVar.F(0);
        pVar.E(read);
        boolean z8 = this.f4428c;
        b bVar = this.f4426a;
        if (!z8) {
            bVar.f4422n = 0L;
            this.f4428c = true;
        }
        bVar.c(pVar);
        return 0;
    }

    @Override // d2.m
    public final d2.m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
