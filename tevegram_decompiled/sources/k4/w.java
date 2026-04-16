package k4;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w {

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f5597e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f5598f;

    /* renamed from: g, reason: collision with root package name */
    public static final File f5599g;
    public static volatile w h;

    /* renamed from: b, reason: collision with root package name */
    public int f5601b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5602c = true;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f5603d = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final int f5600a = 20000;

    static {
        int i9 = Build.VERSION.SDK_INT;
        f5597e = i9 < 29;
        f5598f = i9 >= 28;
        f5599g = new File("/proc/self/fd");
    }

    public static w a() {
        if (h == null) {
            synchronized (w.class) {
                try {
                    if (h == null) {
                        h = new w();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT == 28) {
            Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
            while (it.hasNext()) {
                if (Build.MODEL.startsWith((String) it.next())) {
                    return 500;
                }
            }
        }
        return this.f5600a;
    }

    public final boolean c(int i9, int i10, boolean z8, boolean z9) {
        boolean z10;
        if (z8) {
            if (f5598f) {
                if (!f5597e || this.f5603d.get()) {
                    if (z9) {
                        if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
                            return false;
                        }
                    } else if (i9 >= 0 && i10 >= 0) {
                        synchronized (this) {
                            try {
                                int i11 = this.f5601b + 1;
                                this.f5601b = i11;
                                if (i11 >= 50) {
                                    this.f5601b = 0;
                                    int length = f5599g.list().length;
                                    long b9 = b();
                                    boolean z11 = ((long) length) < b9;
                                    this.f5602c = z11;
                                    if (!z11 && Log.isLoggable("Downsampler", 5)) {
                                        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + b9);
                                    }
                                }
                                z10 = this.f5602c;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z10) {
                            return true;
                        }
                        if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                            return false;
                        }
                    } else if (Log.isLoggable("HardwareConfig", 2)) {
                        Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
                    }
                } else if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed by app state");
                    return false;
                }
            } else if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
                return false;
            }
        } else if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed by caller");
            return false;
        }
        return false;
    }
}
