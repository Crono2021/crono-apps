package i7;

import com.network.tvgramplayer.ui.MediaExplorerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x2 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public long f5194m;

    /* renamed from: n, reason: collision with root package name */
    public long f5195n;

    /* renamed from: o, reason: collision with root package name */
    public int f5196o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f5197p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x2(MediaExplorerActivity mediaExplorerActivity, r7.c cVar) {
        super(2, cVar);
        this.f5197p = mediaExplorerActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        return ((x2) j((i8.u) obj, (r7.c) obj2)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new x2(this.f5197p, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    @Override // t7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(java.lang.Object r10) {
        /*
            r9 = this;
            s7.a r0 = s7.a.f8891i
            int r1 = r9.f5196o
            r2 = 1
            if (r1 == 0) goto L18
            if (r1 != r2) goto L11
            long r3 = r9.f5195n
            long r5 = r9.f5194m
            com.bumptech.glide.c.V(r10)
            goto L22
        L11:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            m7.c.p(r10)
            r10 = 0
            return r10
        L18:
            com.bumptech.glide.c.V(r10)
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 45000(0xafc8, double:2.2233E-319)
        L22:
            boolean r10 = com.network.tvgramplayer.TvgramApplication.f2329j
            boolean r10 = com.network.tvgramplayer.TvgramApplication.f2329j
            java.lang.String r1 = "READY"
            if (r10 == 0) goto L3e
            com.network.tvgramplayer.ui.MediaExplorerActivity r10 = r9.f5197p
            int r7 = com.network.tvgramplayer.ui.MediaExplorerActivity.Y
            h7.k0 r10 = r10.u()
            l8.d r10 = r10.f4135e
            java.lang.Object r10 = r10.d()
            boolean r10 = b8.i.a(r10, r1)
            if (r10 != 0) goto L56
        L3e:
            long r7 = java.lang.System.currentTimeMillis()
            long r7 = r7 - r3
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 >= 0) goto L56
            r9.f5194m = r5
            r9.f5195n = r3
            r9.f5196o = r2
            r7 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r10 = i8.w.d(r7, r9)
            if (r10 != r0) goto L22
            return r0
        L56:
            boolean r10 = com.network.tvgramplayer.TvgramApplication.f2329j
            if (r10 == 0) goto L9d
            com.network.tvgramplayer.ui.MediaExplorerActivity r10 = r9.f5197p
            int r0 = com.network.tvgramplayer.ui.MediaExplorerActivity.Y
            h7.k0 r10 = r10.u()
            l8.d r10 = r10.f4135e
            java.lang.Object r10 = r10.d()
            boolean r10 = b8.i.a(r10, r1)
            if (r10 == 0) goto L9d
            com.network.tvgramplayer.ui.MediaExplorerActivity r10 = r9.f5197p
            long r0 = r10.L
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L93
            h7.k0 r10 = r10.u()
            com.network.tvgramplayer.ui.MediaExplorerActivity r0 = r9.f5197p
            long r1 = r0.K
            i7.e2 r3 = new i7.e2
            r4 = 3
            r3.<init>(r0, r4)
            r10.getClass()
            h7.c r0 = new h7.c
            r4 = 0
            r0.<init>(r10, r4, r3)
            r10.h(r1, r0)
            goto Lad
        L93:
            i7.j2 r0 = new i7.j2
            r1 = 4
            r0.<init>(r10, r1)
            r10.runOnUiThread(r0)
            goto Lad
        L9d:
            com.network.tvgramplayer.ui.MediaExplorerActivity r10 = r9.f5197p
            java.lang.String r0 = "Tiempo de espera agotado."
            android.widget.Toast r10 = android.widget.Toast.makeText(r10, r0, r2)
            r10.show()
            com.network.tvgramplayer.ui.MediaExplorerActivity r10 = r9.f5197p
            r10.finish()
        Lad:
            n7.g r10 = n7.g.f7490c
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.x2.k(java.lang.Object):java.lang.Object");
    }
}
