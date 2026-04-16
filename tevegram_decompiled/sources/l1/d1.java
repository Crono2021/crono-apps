package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d1 {

    /* renamed from: c, reason: collision with root package name */
    public static final d1 f5823c;

    /* renamed from: a, reason: collision with root package name */
    public final long f5824a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5825b;

    static {
        d1 d1Var = new d1(0L, 0L);
        new d1(Long.MAX_VALUE, Long.MAX_VALUE);
        new d1(Long.MAX_VALUE, 0L);
        new d1(0L, Long.MAX_VALUE);
        f5823c = d1Var;
    }

    public d1(long j5, long j9) {
        g1.a.f(j5 >= 0);
        g1.a.f(j9 >= 0);
        this.f5824a = j5;
        this.f5825b = j9;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a(long r11, long r13, long r15) {
        /*
            r10 = this;
            long r0 = r10.f5825b
            long r2 = r10.f5824a
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto Lf
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto Lf
            return r11
        Lf:
            int r6 = g1.w.f3713a
            long r6 = r11 - r2
            long r2 = r2 ^ r11
            long r8 = r11 ^ r6
            long r2 = r2 & r8
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 >= 0) goto L1d
            r6 = -9223372036854775808
        L1d:
            long r2 = r11 + r0
            long r8 = r11 ^ r2
            long r0 = r0 ^ r2
            long r0 = r0 & r8
            int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r8 >= 0) goto L2c
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L2c:
            r0 = 0
            r1 = 1
            int r4 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r4 > 0) goto L38
            int r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r4 > 0) goto L38
            r4 = 1
            goto L39
        L38:
            r4 = 0
        L39:
            int r5 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r5 > 0) goto L42
            int r5 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r5 > 0) goto L42
            r0 = 1
        L42:
            if (r4 == 0) goto L57
            if (r0 == 0) goto L57
            long r0 = r13 - r11
            long r0 = java.lang.Math.abs(r0)
            long r11 = r15 - r11
            long r11 = java.lang.Math.abs(r11)
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 > 0) goto L5c
            goto L59
        L57:
            if (r4 == 0) goto L5a
        L59:
            return r13
        L5a:
            if (r0 == 0) goto L5d
        L5c:
            return r15
        L5d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.d1.a(long, long, long):long");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d1.class == obj.getClass()) {
            d1 d1Var = (d1) obj;
            if (this.f5824a == d1Var.f5824a && this.f5825b == d1Var.f5825b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f5824a) * 31) + ((int) this.f5825b);
    }
}
