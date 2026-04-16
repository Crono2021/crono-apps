package n0;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class n1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Field f7178a;

    /* renamed from: b, reason: collision with root package name */
    public static final Field f7179b;

    /* renamed from: c, reason: collision with root package name */
    public static final Field f7180c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f7181d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f7178a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f7179b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f7180c = declaredField3;
            declaredField3.setAccessible(true);
            f7181d = true;
        } catch (ReflectiveOperationException e9) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e9.getMessage(), e9);
        }
    }
}
