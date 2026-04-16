package s1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o {
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
    
        r6 = ((s1.n) r4.get(r5)).f8717d.getVideoCapabilities().getSupportedPerformancePoints();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ae, code lost:
    
        n1.e0.x();
        r4 = n1.e0.f();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ba, code lost:
    
        if (r5 >= r6.size()) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bc, code lost:
    
        r2 = n1.e0.h(r6.get(r5)).covers(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c8, code lost:
    
        if (r2 == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cb, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d1, code lost:
    
        if (r7 != 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d0, code lost:
    
        r7 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.media.MediaCodecInfo.VideoCapabilities r3, int r4, int r5, double r6) {
        /*
            java.util.List r3 = n1.e0.j(r3)
            r0 = 0
            if (r3 == 0) goto Le1
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto Lf
            goto Le1
        Lf:
            n1.e0.x()
            int r6 = (int) r6
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r4 = n1.e0.g(r4, r5, r6)
            r5 = 0
        L18:
            int r6 = r3.size()
            r7 = 2
            r1 = 1
            if (r5 >= r6) goto L33
            java.lang.Object r6 = r3.get(r5)
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r6 = n1.e0.h(r6)
            boolean r6 = n1.e0.u(r6, r4)
            if (r6 == 0) goto L30
            r3 = 2
            goto L34
        L30:
            int r5 = r5 + 1
            goto L18
        L33:
            r3 = 1
        L34:
            if (r3 != r1) goto Le0
            java.lang.Boolean r4 = com.bumptech.glide.c.f1751o
            if (r4 != 0) goto Le0
            int r4 = g1.w.f3713a
            r5 = 35
            if (r4 < r5) goto L43
        L40:
            r1 = 0
            goto Ld7
        L43:
            d1.r r4 = new d1.r     // Catch: s1.w -> Lce
            r4.<init>()     // Catch: s1.w -> Lce
            java.lang.String r5 = "video/avc"
            java.lang.String r5 = d1.l0.k(r5)     // Catch: s1.w -> Lce
            r4.f2528l = r5     // Catch: s1.w -> Lce
            d1.s r5 = new d1.s     // Catch: s1.w -> Lce
            r5.<init>(r4)     // Catch: s1.w -> Lce
            java.lang.String r4 = r5.f2554m     // Catch: s1.w -> Lce
            if (r4 == 0) goto Ld7
            java.util.List r4 = s1.z.e(r4, r0, r0)     // Catch: s1.w -> Lce
            java.lang.String r5 = s1.z.b(r5)     // Catch: s1.w -> Lce
            if (r5 != 0) goto L66
            b6.w0 r5 = b6.w0.f1464m     // Catch: s1.w -> Lce
            goto L6a
        L66:
            java.util.List r5 = s1.z.e(r5, r0, r0)     // Catch: s1.w -> Lce
        L6a:
            b6.d0 r6 = new b6.d0     // Catch: s1.w -> Lce
            r6.<init>()     // Catch: s1.w -> Lce
            r6.c(r4)     // Catch: s1.w -> Lce
            r6.c(r5)     // Catch: s1.w -> Lce
            b6.w0 r4 = r6.f()     // Catch: s1.w -> Lce
            r5 = 0
        L7a:
            int r6 = r4.f1466l     // Catch: s1.w -> Lce
            if (r5 >= r6) goto Ld7
            java.lang.Object r6 = r4.get(r5)     // Catch: s1.w -> Lce
            s1.n r6 = (s1.n) r6     // Catch: s1.w -> Lce
            android.media.MediaCodecInfo$CodecCapabilities r6 = r6.f8717d     // Catch: s1.w -> Lce
            if (r6 == 0) goto Ld4
            java.lang.Object r6 = r4.get(r5)     // Catch: s1.w -> Lce
            s1.n r6 = (s1.n) r6     // Catch: s1.w -> Lce
            android.media.MediaCodecInfo$CodecCapabilities r6 = r6.f8717d     // Catch: s1.w -> Lce
            android.media.MediaCodecInfo$VideoCapabilities r6 = r6.getVideoCapabilities()     // Catch: s1.w -> Lce
            if (r6 == 0) goto Ld4
            java.lang.Object r6 = r4.get(r5)     // Catch: s1.w -> Lce
            s1.n r6 = (s1.n) r6     // Catch: s1.w -> Lce
            android.media.MediaCodecInfo$CodecCapabilities r6 = r6.f8717d     // Catch: s1.w -> Lce
            android.media.MediaCodecInfo$VideoCapabilities r6 = r6.getVideoCapabilities()     // Catch: s1.w -> Lce
            java.util.List r6 = n1.e0.j(r6)     // Catch: s1.w -> Lce
            if (r6 == 0) goto Ld4
            boolean r2 = r6.isEmpty()     // Catch: s1.w -> Lce
            if (r2 != 0) goto Ld4
            n1.e0.x()     // Catch: s1.w -> Lce
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r4 = n1.e0.f()     // Catch: s1.w -> Lce
            r5 = 0
        Lb6:
            int r2 = r6.size()     // Catch: s1.w -> Lce
            if (r5 >= r2) goto Ld0
            java.lang.Object r2 = r6.get(r5)     // Catch: s1.w -> Lce
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r2 = n1.e0.h(r2)     // Catch: s1.w -> Lce
            boolean r2 = n1.e0.u(r2, r4)     // Catch: s1.w -> Lce
            if (r2 == 0) goto Lcb
            goto Ld1
        Lcb:
            int r5 = r5 + 1
            goto Lb6
        Lce:
            goto Ld7
        Ld0:
            r7 = 1
        Ld1:
            if (r7 != r1) goto L40
            goto Ld7
        Ld4:
            int r5 = r5 + 1
            goto L7a
        Ld7:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            com.bumptech.glide.c.f1751o = r4
            if (r1 == 0) goto Le0
            goto Le1
        Le0:
            return r3
        Le1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.o.a(android.media.MediaCodecInfo$VideoCapabilities, int, int, double):int");
    }
}
