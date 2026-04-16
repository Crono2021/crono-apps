package n;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class t1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f7044a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f7045b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f7046c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f7047d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f7044a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f7045b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f7046c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f7047d = true;
        } catch (NoSuchMethodException e9) {
            e9.printStackTrace();
        }
    }
}
