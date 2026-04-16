package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f7032b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static t f7033c;

    /* renamed from: a, reason: collision with root package name */
    public t2 f7034a;

    public static synchronized t a() {
        t tVar;
        synchronized (t.class) {
            try {
                if (f7033c == null) {
                    d();
                }
                tVar = f7033c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public static synchronized PorterDuffColorFilter c(int i9, PorterDuff.Mode mode) {
        PorterDuffColorFilter h;
        synchronized (t.class) {
            h = t2.h(i9, mode);
        }
        return h;
    }

    public static synchronized void d() {
        synchronized (t.class) {
            if (f7033c == null) {
                t tVar = new t();
                f7033c = tVar;
                tVar.f7034a = t2.d();
                f7033c.f7034a.m(new m6.p());
            }
        }
    }

    public static void e(Drawable drawable, o3 o3Var, int[] iArr) {
        PorterDuff.Mode mode = t2.h;
        int[] state = drawable.getState();
        int[] iArr2 = r1.f7021a;
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z8 = o3Var.f6994d;
        if (z8 || o3Var.f6993c) {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = z8 ? o3Var.f6991a : null;
            PorterDuff.Mode mode2 = o3Var.f6993c ? o3Var.f6992b : t2.h;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilter = t2.h(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final synchronized Drawable b(Context context, int i9) {
        return this.f7034a.f(context, i9);
    }
}
