package w4;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f9951a = "0123456789abcdef".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f9952b = new char[64];

    /* renamed from: c, reason: collision with root package name */
    public static volatile Handler f9953c;

    public static void a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        m7.c.n("You must call this method on the main thread");
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int c(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        StringBuilder sb = new StringBuilder("Cannot obtain size for recycled Bitmap: ");
        sb.append(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        sb.append("[");
        sb.append(width);
        sb.append("x");
        sb.append(height);
        sb.append("] ");
        sb.append(config);
        throw new IllegalStateException(sb.toString());
    }

    public static int d(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i9 = m.f9950a[config.ordinal()];
        int i10 = 1;
        if (i9 != 1) {
            i10 = 2;
            if (i9 != 2 && i9 != 3) {
                return i9 != 4 ? 4 : 8;
            }
        }
        return i10;
    }

    public static ArrayList e(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Handler f() {
        if (f9953c == null) {
            synchronized (n.class) {
                try {
                    if (f9953c == null) {
                        f9953c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f9953c;
    }

    public static int g(int i9, int i10) {
        return (i10 * 31) + i9;
    }

    public static int h(int i9, Object obj) {
        return g(obj == null ? 0 : obj.hashCode(), i9);
    }

    public static boolean i(int i9, int i10) {
        if (i9 > 0 || i9 == Integer.MIN_VALUE) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }
        return false;
    }
}
