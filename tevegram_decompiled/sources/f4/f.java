package f4;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    public static final int f3381e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f3382a;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityManager f3383b;

    /* renamed from: c, reason: collision with root package name */
    public final a0.b f3384c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3385d;

    static {
        f3381e = Build.VERSION.SDK_INT < 26 ? 4 : 1;
    }

    public f(Context context) {
        this.f3385d = f3381e;
        this.f3382a = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f3383b = activityManager;
        this.f3384c = new a0.b(context.getResources().getDisplayMetrics(), 22);
        if (Build.VERSION.SDK_INT < 26 || !activityManager.isLowRamDevice()) {
            return;
        }
        this.f3385d = 0.0f;
    }
}
