package y1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class d implements a6.e {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ o f10412i;

    public /* synthetic */ d(o oVar) {
        this.f10412i = oVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r2.f1137a != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003a, code lost:
    
        if (r2.equals("audio/ac4") == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078 A[Catch: all -> 0x008f, TryCatch #0 {all -> 0x008f, blocks: (B:4:0x0007, B:6:0x000e, B:8:0x0012, B:10:0x0017, B:17:0x0056, B:19:0x005a, B:21:0x005e, B:34:0x0062, B:36:0x0066, B:38:0x006a, B:40:0x006e, B:42:0x0078, B:44:0x0084, B:48:0x0092), top: B:3:0x0007 }] */
    @Override // a6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean apply(java.lang.Object r10) {
        /*
            r9 = this;
            y1.o r0 = r9.f10412i
            d1.s r10 = (d1.s) r10
            java.lang.Object r1 = r0.f10477c
            monitor-enter(r1)
            y1.i r2 = r0.f10481g     // Catch: java.lang.Throwable -> L8f
            boolean r2 = r2.f10442x     // Catch: java.lang.Throwable -> L8f
            r3 = 1
            if (r2 == 0) goto L92
            boolean r2 = r0.f10480f     // Catch: java.lang.Throwable -> L8f
            if (r2 != 0) goto L92
            int r2 = r10.f2567z     // Catch: java.lang.Throwable -> L8f
            r4 = 2
            if (r2 <= r4) goto L92
            java.lang.String r2 = r10.f2554m     // Catch: java.lang.Throwable -> L8f
            r5 = 32
            r6 = 0
            if (r2 != 0) goto L1f
            goto L62
        L1f:
            int r7 = r2.hashCode()
            r8 = -1
            switch(r7) {
                case -2123537834: goto L48;
                case 187078296: goto L3d;
                case 187078297: goto L34;
                case 1504578661: goto L29;
                default: goto L27;
            }
        L27:
            r4 = -1
            goto L52
        L29:
            java.lang.String r4 = "audio/eac3"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L32
            goto L27
        L32:
            r4 = 3
            goto L52
        L34:
            java.lang.String r7 = "audio/ac4"
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L52
            goto L27
        L3d:
            java.lang.String r4 = "audio/ac3"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L46
            goto L27
        L46:
            r4 = 1
            goto L52
        L48:
            java.lang.String r4 = "audio/eac3-joc"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L51
            goto L27
        L51:
            r4 = 0
        L52:
            switch(r4) {
                case 0: goto L56;
                case 1: goto L56;
                case 2: goto L56;
                case 3: goto L56;
                default: goto L55;
            }
        L55:
            goto L62
        L56:
            int r2 = g1.w.f3713a     // Catch: java.lang.Throwable -> L8f
            if (r2 < r5) goto L92
            b2.b r2 = r0.h     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L92
            boolean r2 = r2.f1137a     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L92
        L62:
            int r2 = g1.w.f3713a     // Catch: java.lang.Throwable -> L8f
            if (r2 < r5) goto L91
            b2.b r2 = r0.h     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L91
            boolean r4 = r2.f1137a     // Catch: java.lang.Throwable -> L8f
            if (r4 == 0) goto L91
            java.lang.Object r2 = r2.f1138b     // Catch: java.lang.Throwable -> L8f
            android.media.Spatializer r2 = (android.media.Spatializer) r2     // Catch: java.lang.Throwable -> L8f
            boolean r2 = d1.e.g(r2)     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L91
            b2.b r2 = r0.h     // Catch: java.lang.Throwable -> L8f
            java.lang.Object r2 = r2.f1138b     // Catch: java.lang.Throwable -> L8f
            android.media.Spatializer r2 = (android.media.Spatializer) r2     // Catch: java.lang.Throwable -> L8f
            boolean r2 = d1.e.j(r2)     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L91
            b2.b r2 = r0.h     // Catch: java.lang.Throwable -> L8f
            d1.g r0 = r0.f10482i     // Catch: java.lang.Throwable -> L8f
            boolean r10 = r2.d(r0, r10)     // Catch: java.lang.Throwable -> L8f
            if (r10 == 0) goto L91
            goto L92
        L8f:
            r10 = move-exception
            goto L94
        L91:
            r3 = 0
        L92:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L8f
            return r3
        L94:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L8f
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.d.apply(java.lang.Object):boolean");
    }
}
