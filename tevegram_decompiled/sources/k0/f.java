package k0;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final j3.e f5515a = new j3.e(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f5516b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5517c;

    /* renamed from: d, reason: collision with root package name */
    public static final s.h f5518d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new d4.a(1));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f5516b = threadPoolExecutor;
        f5517c = new Object();
        f5518d = new s.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static k0.e a(java.lang.String r6, android.content.Context r7, c7.a r8, int r9) {
        /*
            j3.e r0 = k0.f.f5515a
            java.lang.Object r1 = r0.d(r6)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L10
            k0.e r6 = new k0.e
            r6.<init>(r1)
            return r6
        L10:
            d4.i r8 = k0.b.a(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            java.lang.Object r1 = r8.f2852j
            k0.g[] r1 = (k0.g[]) r1
            int r8 = r8.f2851i
            r2 = -3
            r3 = 1
            if (r8 == 0) goto L24
            if (r8 == r3) goto L22
        L20:
            r3 = -3
            goto L3d
        L22:
            r3 = -2
            goto L3d
        L24:
            if (r1 == 0) goto L3d
            int r8 = r1.length
            if (r8 != 0) goto L2a
            goto L3d
        L2a:
            int r8 = r1.length
            r3 = 0
            r4 = 0
        L2d:
            if (r4 >= r8) goto L3d
            r5 = r1[r4]
            int r5 = r5.f5523e
            if (r5 == 0) goto L3a
            if (r5 >= 0) goto L38
            goto L20
        L38:
            r3 = r5
            goto L3d
        L3a:
            int r4 = r4 + 1
            goto L2d
        L3d:
            if (r3 == 0) goto L45
            k0.e r6 = new k0.e
            r6.<init>(r3)
            return r6
        L45:
            android.support.v4.media.session.b r8 = f0.g.f3200a
            android.graphics.Typeface r7 = r8.y(r7, r1, r9)
            if (r7 == 0) goto L56
            r0.e(r6, r7)
            k0.e r6 = new k0.e
            r6.<init>(r7)
            return r6
        L56:
            k0.e r6 = new k0.e
            r6.<init>(r2)
            return r6
        L5c:
            k0.e r6 = new k0.e
            r7 = -1
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.f.a(java.lang.String, android.content.Context, c7.a, int):k0.e");
    }
}
