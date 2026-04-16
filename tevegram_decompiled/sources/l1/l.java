package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends d1.n0 {

    /* renamed from: k, reason: collision with root package name */
    public final int f5932k;

    /* renamed from: l, reason: collision with root package name */
    public final String f5933l;

    /* renamed from: m, reason: collision with root package name */
    public final int f5934m;

    /* renamed from: n, reason: collision with root package name */
    public final d1.s f5935n;

    /* renamed from: o, reason: collision with root package name */
    public final int f5936o;

    /* renamed from: p, reason: collision with root package name */
    public final v1.z f5937p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f5938q;

    static {
        androidx.activity.g.s(1001, 1002, 1003, 1004, 1005);
        g1.w.H(1006);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l(int r14, java.lang.Throwable r15, int r16, java.lang.String r17, int r18, d1.s r19, int r20, boolean r21) {
        /*
            r13 = this;
            if (r14 == 0) goto L43
            r0 = 1
            if (r14 == r0) goto L14
            r0 = 3
            if (r14 == r0) goto L11
            java.lang.String r0 = "Unexpected runtime error"
        La:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L4b
        L11:
            java.lang.String r0 = "Remote error"
            goto La
        L14:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r5 = r17
            r0.append(r5)
            java.lang.String r1 = " error, index="
            r0.append(r1)
            r6 = r18
            r0.append(r6)
            java.lang.String r1 = ", format="
            r0.append(r1)
            r7 = r19
            r0.append(r7)
            java.lang.String r1 = ", format_supported="
            r0.append(r1)
            java.lang.String r1 = g1.w.v(r20)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L4b
        L43:
            r5 = r17
            r6 = r18
            r7 = r19
            java.lang.String r0 = "Source error"
        L4b:
            r1 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L58
            java.lang.String r1 = ": null"
            java.lang.String r0 = r0.concat(r1)
        L58:
            r1 = r0
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r4 = r14
            r2 = r15
            r3 = r16
            r8 = r20
            r12 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.l.<init>(int, java.lang.Throwable, int, java.lang.String, int, d1.s, int, boolean):void");
    }

    public l(String str, Throwable th, int i9, int i10, String str2, int i11, d1.s sVar, int i12, v1.z zVar, long j5, boolean z8) {
        super(str, th, i9, j5);
        g1.a.f(!z8 || i10 == 1);
        g1.a.f(th != null || i10 == 3);
        this.f5932k = i10;
        this.f5933l = str2;
        this.f5934m = i11;
        this.f5935n = sVar;
        this.f5936o = i12;
        this.f5937p = zVar;
        this.f5938q = z8;
    }

    public l(int i9, Exception exc, int i10) {
        this(i9, exc, i10, null, -1, null, 4, false);
    }
}
