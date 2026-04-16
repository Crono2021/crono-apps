package b2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends Surface {

    /* renamed from: l, reason: collision with root package name */
    public static int f1243l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f1244m;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f1245i;

    /* renamed from: j, reason: collision with root package name */
    public final o f1246j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1247k;

    public p(o oVar, SurfaceTexture surfaceTexture, boolean z8) {
        super(surfaceTexture);
        this.f1246j = oVar;
        this.f1245i = z8;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized boolean d(android.content.Context r7) {
        /*
            java.lang.Class<b2.p> r0 = b2.p.class
            monitor-enter(r0)
            boolean r1 = b2.p.f1244m     // Catch: java.lang.Throwable -> L5c
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L5e
            int r1 = g1.w.f3713a     // Catch: java.lang.Throwable -> L5c
            r4 = 24
            if (r1 >= r4) goto L11
        Lf:
            r7 = 0
            goto L3f
        L11:
            r4 = 26
            if (r1 >= r4) goto L2a
            java.lang.String r5 = "samsung"
            java.lang.String r6 = g1.w.f3715c     // Catch: java.lang.Throwable -> L5c
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L5c
            if (r5 != 0) goto Lf
            java.lang.String r5 = "XT1650"
            java.lang.String r6 = g1.w.f3716d     // Catch: java.lang.Throwable -> L5c
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L5c
            if (r5 == 0) goto L2a
            goto Lf
        L2a:
            if (r1 >= r4) goto L39
            android.content.pm.PackageManager r7 = r7.getPackageManager()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = "android.hardware.vr.high_performance"
            boolean r7 = r7.hasSystemFeature(r4)     // Catch: java.lang.Throwable -> L5c
            if (r7 != 0) goto L39
            goto Lf
        L39:
            java.lang.String r7 = "EGL_EXT_protected_content"
            boolean r7 = g1.f.l(r7)     // Catch: java.lang.Throwable -> L5c
        L3f:
            if (r7 == 0) goto L56
            r7 = 17
            if (r1 < r7) goto L4f
            java.lang.String r7 = "EGL_KHR_surfaceless_context"
            boolean r7 = g1.f.l(r7)     // Catch: java.lang.Throwable -> L5c
            if (r7 == 0) goto L4f
            r7 = 1
            goto L50
        L4f:
            r7 = 0
        L50:
            if (r7 == 0) goto L54
            r7 = 1
            goto L57
        L54:
            r7 = 2
            goto L57
        L56:
            r7 = 0
        L57:
            b2.p.f1243l = r7     // Catch: java.lang.Throwable -> L5c
            b2.p.f1244m = r3     // Catch: java.lang.Throwable -> L5c
            goto L5e
        L5c:
            r7 = move-exception
            goto L65
        L5e:
            int r7 = b2.p.f1243l     // Catch: java.lang.Throwable -> L5c
            if (r7 == 0) goto L63
            r2 = 1
        L63:
            monitor-exit(r0)
            return r2
        L65:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5c
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.p.d(android.content.Context):boolean");
    }

    public static p e(Context context, boolean z8) {
        boolean z9 = false;
        g1.a.k(!z8 || d(context));
        o oVar = new o("ExoPlayer:PlaceholderSurface");
        int i9 = z8 ? f1243l : 0;
        oVar.start();
        Handler handler = new Handler(oVar.getLooper(), oVar);
        oVar.f1239j = handler;
        oVar.f1238i = new g1.d(handler);
        synchronized (oVar) {
            oVar.f1239j.obtainMessage(1, i9, 0).sendToTarget();
            while (oVar.f1242m == null && oVar.f1241l == null && oVar.f1240k == null) {
                try {
                    oVar.wait();
                } catch (InterruptedException unused) {
                    z9 = true;
                }
            }
        }
        if (z9) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = oVar.f1241l;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = oVar.f1240k;
        if (error != null) {
            throw error;
        }
        p pVar = oVar.f1242m;
        pVar.getClass();
        return pVar;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f1246j) {
            try {
                if (!this.f1247k) {
                    o oVar = this.f1246j;
                    oVar.f1239j.getClass();
                    oVar.f1239j.sendEmptyMessage(2);
                    this.f1247k = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
