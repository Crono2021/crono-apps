package m3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import d4.t;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final t.i f6635a = new t.i();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f6636b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static t f6637c = null;

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? h.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static t b() {
        t tVar = new t(24);
        f6637c = tVar;
        t.i iVar = f6635a;
        iVar.getClass();
        if (t.h.f8910n.e(iVar, null, tVar)) {
            t.h.b(iVar);
        }
        return f6637c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:14|(1:81)(1:18)|19|(1:80)(1:23)|24|25|26|(2:65|66)(1:28)|29|(9:36|(1:40)|(1:60)(1:47)|48|(2:56|57)|52|53|54|55)|(1:64)|(1:40)|(1:42)|60|48|(1:50)|56|57|52|53|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009e, code lost:
    
        r6 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.j.c(android.content.Context, boolean):void");
    }
}
