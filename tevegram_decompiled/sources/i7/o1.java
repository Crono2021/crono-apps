package i7;

import com.network.tvgramplayer.ui.MainActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o1 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public b8.m f5003m;

    /* renamed from: n, reason: collision with root package name */
    public int f5004n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ MainActivity f5005o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ long f5006p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(long j5, MainActivity mainActivity, r7.c cVar) {
        super(2, cVar);
        this.f5005o = mainActivity;
        this.f5006p = j5;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        return ((o1) j((i8.u) obj, (r7.c) obj2)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new o1(this.f5006p, this.f5005o, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        if (i8.w.q(r9, r6, r8) != r0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (i8.w.q(r9, r1, r8) != r0) goto L28;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0061 -> B:13:0x001f). Please report as a decompilation issue!!! */
    @Override // t7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r9) {
        /*
            r8 = this;
            s7.a r0 = s7.a.f8891i
            int r1 = r8.f5004n
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L27
            if (r1 == r5) goto L21
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L14
            com.bumptech.glide.c.V(r9)
            goto L7c
        L14:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            m7.c.p(r9)
            return r4
        L1a:
            b8.m r1 = r8.f5003m
            com.bumptech.glide.c.V(r9)
        L1f:
            r9 = r1
            goto L2f
        L21:
            b8.m r1 = r8.f5003m
            com.bumptech.glide.c.V(r9)
            goto L49
        L27:
            com.bumptech.glide.c.V(r9)
            b8.m r9 = new b8.m
            r9.<init>()
        L2f:
            boolean r1 = com.network.tvgramplayer.TvgramApplication.f2329j
            boolean r1 = com.network.tvgramplayer.TvgramApplication.f2329j
            if (r1 != 0) goto L64
            int r1 = r9.f1523i
            r6 = 100
            if (r1 >= r6) goto L64
            r8.f5003m = r9
            r8.f5004n = r5
            r6 = 200(0xc8, double:9.9E-322)
            java.lang.Object r1 = i8.w.d(r6, r8)
            if (r1 != r0) goto L48
            goto L7b
        L48:
            r1 = r9
        L49:
            int r9 = r1.f1523i
            int r9 = r9 + r5
            r1.f1523i = r9
            p8.d r9 = i8.c0.f5250a
            j8.d r9 = n8.o.f7529a
            androidx.lifecycle.n r6 = new androidx.lifecycle.n
            com.network.tvgramplayer.ui.MainActivity r7 = r8.f5005o
            r6.<init>(r7, r1, r4, r3)
            r8.f5003m = r1
            r8.f5004n = r3
            java.lang.Object r9 = i8.w.q(r9, r6, r8)
            if (r9 != r0) goto L1f
            goto L7b
        L64:
            p8.d r9 = i8.c0.f5250a
            j8.d r9 = n8.o.f7529a
            i7.n1 r1 = new i7.n1
            long r5 = r8.f5006p
            com.network.tvgramplayer.ui.MainActivity r3 = r8.f5005o
            r1.<init>(r5, r3, r4)
            r8.f5003m = r4
            r8.f5004n = r2
            java.lang.Object r9 = i8.w.q(r9, r1, r8)
            if (r9 != r0) goto L7c
        L7b:
            return r0
        L7c:
            n7.g r9 = n7.g.f7490c
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.o1.k(java.lang.Object):java.lang.Object");
    }
}
