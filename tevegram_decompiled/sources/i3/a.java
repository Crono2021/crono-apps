package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements d2.m {

    /* renamed from: a, reason: collision with root package name */
    public final b f4401a = new b();

    /* renamed from: b, reason: collision with root package name */
    public final g1.p f4402b = new g1.p(2786);

    /* renamed from: c, reason: collision with root package name */
    public boolean f4403c;

    @Override // d2.m
    public final void c(long j5, long j9) {
        this.f4403c = false;
        this.f4401a.a();
    }

    @Override // d2.m
    public final void d(d2.o oVar) {
        this.f4401a.f(oVar, new e0(0, 1));
        oVar.c();
        oVar.t(new d2.p(-9223372036854775807L));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0036, code lost:
    
        r5.f2705n = 0;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003e, code lost:
    
        if ((r4 - r3) < 8192) goto L12;
     */
    @Override // d2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(d2.n r14) {
        /*
            r13 = this;
            g1.p r0 = new g1.p
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.f3699a
            r5 = r14
            d2.j r5 = (d2.j) r5
            r5.n(r4, r2, r1, r2)
            r0.F(r2)
            int r4 = r0.w()
            r6 = 4801587(0x494433, float:6.728456E-39)
            r7 = 3
            if (r4 == r6) goto L80
            r5.f2705n = r2
            r5.c(r3, r2)
            r4 = r3
        L24:
            r14 = 0
        L25:
            byte[] r6 = r0.f3699a
            r8 = 6
            r5.n(r6, r2, r8, r2)
            r0.F(r2)
            int r6 = r0.z()
            r9 = 2935(0xb77, float:4.113E-42)
            if (r6 == r9) goto L45
            r5.f2705n = r2
            int r4 = r4 + 1
            int r14 = r4 - r3
            r6 = 8192(0x2000, float:1.148E-41)
            if (r14 < r6) goto L41
            goto L79
        L41:
            r5.c(r4, r2)
            goto L24
        L45:
            r6 = 1
            int r14 = r14 + r6
            r9 = 4
            if (r14 < r9) goto L4b
            return r6
        L4b:
            byte[] r10 = r0.f3699a
            int r11 = r10.length
            r12 = -1
            if (r11 >= r8) goto L53
            r9 = -1
            goto L77
        L53:
            r11 = 5
            r11 = r10[r11]
            r11 = r11 & 248(0xf8, float:3.48E-43)
            int r11 = r11 >> r7
            if (r11 <= r1) goto L6b
            r8 = 2
            r9 = r10[r8]
            r9 = r9 & 7
            int r9 = r9 << 8
            r10 = r10[r7]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r9 = r9 | r10
            int r9 = r9 + r6
            int r9 = r9 * 2
            goto L77
        L6b:
            r6 = r10[r9]
            r9 = r6 & 192(0xc0, float:2.69E-43)
            int r8 = r9 >> 6
            r6 = r6 & 63
            int r9 = d2.b.f(r8, r6)
        L77:
            if (r9 != r12) goto L7a
        L79:
            return r2
        L7a:
            int r9 = r9 + (-6)
            r5.c(r9, r2)
            goto L25
        L80:
            r0.G(r7)
            int r4 = r0.s()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.c(r4, r2)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.g(d2.n):boolean");
    }

    @Override // d2.m
    public final int h(d2.n nVar, d1.w wVar) {
        g1.p pVar = this.f4402b;
        int read = nVar.read(pVar.f3699a, 0, 2786);
        if (read == -1) {
            return -1;
        }
        pVar.F(0);
        pVar.E(read);
        boolean z8 = this.f4403c;
        b bVar = this.f4401a;
        if (!z8) {
            bVar.f4422n = 0L;
            this.f4403c = true;
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
