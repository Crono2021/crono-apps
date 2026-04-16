package w4;

import android.os.SystemClock;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final double f9939a = 1.0d / Math.pow(10.0d, 6.0d);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f9940b = 0;

    public static double a(long j5) {
        return (SystemClock.elapsedRealtimeNanos() - j5) * f9939a;
    }
}
