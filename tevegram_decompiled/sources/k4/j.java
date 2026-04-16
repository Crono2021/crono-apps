package k4;

import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends e {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f5570b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(b4.f.f1325a);

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f5570b);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0053  */
    @Override // k4.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap c(e4.a r9, android.graphics.Bitmap r10, int r11, int r12) {
        /*
            r8 = this;
            java.util.concurrent.locks.Lock r0 = k4.z.f5613d
            int r11 = java.lang.Math.min(r11, r12)
            float r12 = (float) r11
            r1 = 1073741824(0x40000000, float:2.0)
            float r2 = r12 / r1
            int r3 = r10.getWidth()
            int r4 = r10.getHeight()
            float r3 = (float) r3
            float r5 = r12 / r3
            float r4 = (float) r4
            float r6 = r12 / r4
            float r5 = java.lang.Math.max(r5, r6)
            float r3 = r3 * r5
            float r5 = r5 * r4
            float r4 = r12 - r3
            float r4 = r4 / r1
            float r12 = r12 - r5
            float r12 = r12 / r1
            android.graphics.RectF r1 = new android.graphics.RectF
            float r3 = r3 + r4
            float r5 = r5 + r12
            r1.<init>(r4, r12, r3, r5)
            int r12 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r12 < r3) goto L46
            android.graphics.Bitmap$Config r4 = a5.a.A()
            android.graphics.Bitmap$Config r5 = r10.getConfig()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L46
            android.graphics.Bitmap$Config r4 = a5.a.A()
            goto L48
        L46:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
        L48:
            android.graphics.Bitmap$Config r5 = r10.getConfig()
            boolean r5 = r4.equals(r5)
            r6 = 0
            if (r5 == 0) goto L55
            r4 = r10
            goto L6a
        L55:
            int r5 = r10.getWidth()
            int r7 = r10.getHeight()
            android.graphics.Bitmap r4 = r9.f(r5, r7, r4)
            android.graphics.Canvas r5 = new android.graphics.Canvas
            r5.<init>(r4)
            r7 = 0
            r5.drawBitmap(r10, r7, r7, r6)
        L6a:
            if (r12 < r3) goto L7f
            android.graphics.Bitmap$Config r12 = a5.a.A()
            android.graphics.Bitmap$Config r3 = r10.getConfig()
            boolean r12 = r12.equals(r3)
            if (r12 == 0) goto L7f
            android.graphics.Bitmap$Config r12 = a5.a.A()
            goto L81
        L7f:
            android.graphics.Bitmap$Config r12 = android.graphics.Bitmap.Config.ARGB_8888
        L81:
            android.graphics.Bitmap r11 = r9.f(r11, r11, r12)
            r12 = 1
            r11.setHasAlpha(r12)
            r0.lock()
            android.graphics.Canvas r12 = new android.graphics.Canvas     // Catch: java.lang.Throwable -> Lab
            r12.<init>(r11)     // Catch: java.lang.Throwable -> Lab
            android.graphics.Paint r3 = k4.z.f5611b     // Catch: java.lang.Throwable -> Lab
            r12.drawCircle(r2, r2, r2, r3)     // Catch: java.lang.Throwable -> Lab
            android.graphics.Paint r2 = k4.z.f5612c     // Catch: java.lang.Throwable -> Lab
            r12.drawBitmap(r4, r6, r1, r2)     // Catch: java.lang.Throwable -> Lab
            r12.setBitmap(r6)     // Catch: java.lang.Throwable -> Lab
            r0.unlock()
            boolean r10 = r4.equals(r10)
            if (r10 != 0) goto Laa
            r9.g(r4)
        Laa:
            return r11
        Lab:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.j.c(e4.a, android.graphics.Bitmap, int, int):android.graphics.Bitmap");
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        return obj instanceof j;
    }

    @Override // b4.f
    public final int hashCode() {
        return 1101716364;
    }
}
