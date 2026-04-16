package p8;

import java.util.concurrent.TimeUnit;
import n8.v;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f8289a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f8290b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f8291c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f8292d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f8293e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f8294f;

    /* renamed from: g, reason: collision with root package name */
    public static final h f8295g;
    public static final h h;

    static {
        String str;
        int i9 = v.f7535a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f8289a = str;
        f8290b = n8.a.i("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i10 = v.f7535a;
        if (i10 < 2) {
            i10 = 2;
        }
        f8291c = n8.a.j(i10, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f8292d = n8.a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        f8293e = TimeUnit.SECONDS.toNanos(n8.a.i("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f8294f = f.f8284a;
        f8295g = new h(0);
        h = new h(1);
    }
}
