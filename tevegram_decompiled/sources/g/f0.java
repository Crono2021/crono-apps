package g;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;
import n.e1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class f0 {

    /* renamed from: b, reason: collision with root package name */
    public static final Class[] f3529b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f3530c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f3531d = {R.attr.accessibilityHeading};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f3532e = {R.attr.accessibilityPaneTitle};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f3533f = {R.attr.screenReaderFocusable};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f3534g = {"android.widget.", "android.view.", "android.webkit."};
    public static final s.h h = new s.h();

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f3535a = new Object[2];

    public n.n a(Context context, AttributeSet attributeSet) {
        return new n.n(context, attributeSet);
    }

    public n.p b(Context context, AttributeSet attributeSet) {
        return new n.p(context, attributeSet, 2130968727);
    }

    public n.q c(Context context, AttributeSet attributeSet) {
        return new n.q(context, attributeSet);
    }

    public n.d0 d(Context context, AttributeSet attributeSet) {
        return new n.d0(context, attributeSet);
    }

    public e1 e(Context context, AttributeSet attributeSet) {
        return new e1(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) {
        String concat;
        s.h hVar = h;
        Constructor constructor = (Constructor) hVar.getOrDefault(str, null);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    concat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                concat = str;
            }
            constructor = Class.forName(concat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f3529b);
            hVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f3535a);
    }
}
