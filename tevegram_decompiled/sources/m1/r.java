package m1;

import d1.y0;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final String f6560a;

    /* renamed from: b, reason: collision with root package name */
    public int f6561b;

    /* renamed from: c, reason: collision with root package name */
    public long f6562c;

    /* renamed from: d, reason: collision with root package name */
    public final z f6563d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6564e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6565f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ s f6566g;

    public r(s sVar, String str, int i9, z zVar) {
        this.f6566g = sVar;
        this.f6560a = str;
        this.f6561b = i9;
        this.f6562c = zVar == null ? -1L : zVar.f9450d;
        if (zVar == null || !zVar.b()) {
            return;
        }
        this.f6563d = zVar;
    }

    public final boolean a(a aVar) {
        z zVar = aVar.f6503d;
        y0 y0Var = aVar.f6501b;
        if (zVar == null) {
            return this.f6561b != aVar.f6502c;
        }
        long j5 = this.f6562c;
        if (j5 == -1) {
            return false;
        }
        if (zVar.f9450d > j5) {
            return true;
        }
        z zVar2 = this.f6563d;
        if (zVar2 == null) {
            return false;
        }
        int i9 = zVar2.f9448b;
        int b9 = y0Var.b(zVar.f9447a);
        int b10 = y0Var.b(zVar2.f9447a);
        if (zVar.f9450d < zVar2.f9450d || b9 < b10) {
            return false;
        }
        if (b9 > b10) {
            return true;
        }
        if (!zVar.b()) {
            int i10 = zVar.f9451e;
            return i10 == -1 || i10 > i9;
        }
        int i11 = zVar.f9448b;
        int i12 = zVar.f9449c;
        if (i11 <= i9) {
            return i11 == i9 && i12 > zVar2.f9449c;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0 < r8.o()) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(d1.y0 r7, d1.y0 r8) {
        /*
            r6 = this;
            int r0 = r6.f6561b
            int r1 = r7.o()
            r2 = 0
            r3 = -1
            if (r0 < r1) goto L13
            int r7 = r8.o()
            if (r0 >= r7) goto L11
            goto L36
        L11:
            r0 = -1
            goto L36
        L13:
            m1.s r1 = r6.f6566g
            d1.x0 r4 = r1.f6568a
            r7.n(r0, r4)
            int r0 = r4.f2607o
        L1c:
            int r5 = r4.f2608p
            if (r0 > r5) goto L11
            java.lang.Object r5 = r7.l(r0)
            int r5 = r8.b(r5)
            if (r5 == r3) goto L33
            d1.w0 r7 = r1.f6569b
            d1.w0 r7 = r8.f(r5, r7, r2)
            int r0 = r7.f2586c
            goto L36
        L33:
            int r0 = r0 + 1
            goto L1c
        L36:
            r6.f6561b = r0
            if (r0 != r3) goto L3b
            goto L4a
        L3b:
            v1.z r7 = r6.f6563d
            if (r7 != 0) goto L40
            goto L48
        L40:
            java.lang.Object r7 = r7.f9447a
            int r7 = r8.b(r7)
            if (r7 == r3) goto L4a
        L48:
            r7 = 1
            return r7
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.r.b(d1.y0, d1.y0):boolean");
    }
}
