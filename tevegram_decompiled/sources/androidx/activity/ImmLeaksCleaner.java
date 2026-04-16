package androidx.activity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.q {

    /* renamed from: j, reason: collision with root package name */
    public static int f269j;

    /* renamed from: k, reason: collision with root package name */
    public static Field f270k;

    /* renamed from: l, reason: collision with root package name */
    public static Field f271l;

    /* renamed from: m, reason: collision with root package name */
    public static Field f272m;

    /* renamed from: i, reason: collision with root package name */
    public g.l f273i;

    @Override // androidx.lifecycle.q
    public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.l lVar) {
        if (lVar != androidx.lifecycle.l.ON_DESTROY) {
            return;
        }
        if (f269j == 0) {
            try {
                f269j = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                f271l = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                f272m = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                f270k = declaredField3;
                declaredField3.setAccessible(true);
                f269j = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f269j == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f273i.getSystemService("input_method");
            try {
                Object obj = f270k.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        View view = (View) f271l.get(inputMethodManager);
                        if (view != null) {
                            if (!view.isAttachedToWindow()) {
                                f272m.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            }
                        }
                    } catch (IllegalAccessException unused2) {
                    } catch (ClassCastException unused3) {
                    } catch (IllegalAccessException unused4) {
                    } finally {
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
