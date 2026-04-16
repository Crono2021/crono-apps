package n;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import org.webrtc.PeerConnectionFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class r1 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f7021a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f7022b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f7023c = new Rect();

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i9 = Build.VERSION.SDK_INT;
        int[] iArr = f7021a;
        int[] iArr2 = f7022b;
        if (i9 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(iArr);
            } else {
                drawable.setState(iArr2);
            }
            drawable.setState(state);
            return;
        }
        if (i9 < 29 || i9 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state2 = drawable.getState();
        if (state2 == null || state2.length == 0) {
            drawable.setState(iArr);
        } else {
            drawable.setState(iArr2);
        }
        drawable.setState(state2);
    }

    public static Rect b(Drawable drawable) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 29) {
            Insets a9 = q1.a(drawable);
            i9 = a9.left;
            i10 = a9.top;
            i11 = a9.right;
            i12 = a9.bottom;
            return new Rect(i9, i10, i11, i12);
        }
        if (drawable instanceof g0.f) {
            drawable = ((g0.f) drawable).f3649n;
        }
        if (i13 >= 29) {
            boolean z8 = p1.f7000a;
        } else if (p1.f7000a) {
            try {
                Object invoke = p1.f7001b.invoke(drawable, null);
                if (invoke != null) {
                    return new Rect(p1.f7002c.getInt(invoke), p1.f7003d.getInt(invoke), p1.f7004e.getInt(invoke), p1.f7005f.getInt(invoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return f7023c;
    }

    public static PorterDuff.Mode c(int i9, PorterDuff.Mode mode) {
        if (i9 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i9 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i9 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i9) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case PeerConnectionFactory.Options.ADAPTER_TYPE_LOOPBACK /* 16 */:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
