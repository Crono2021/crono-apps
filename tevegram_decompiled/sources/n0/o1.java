package n0;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o1 extends r1 {

    /* renamed from: e, reason: collision with root package name */
    public static Field f7187e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f7188f = false;

    /* renamed from: g, reason: collision with root package name */
    public static Constructor f7189g = null;
    public static boolean h = false;

    /* renamed from: c, reason: collision with root package name */
    public WindowInsets f7190c;

    /* renamed from: d, reason: collision with root package name */
    public f0.c f7191d;

    public o1() {
        this.f7190c = i();
    }

    private static WindowInsets i() {
        if (!f7188f) {
            try {
                f7187e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e9) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e9);
            }
            f7188f = true;
        }
        Field field = f7187e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e10) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e10);
            }
        }
        if (!h) {
            try {
                f7189g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e11) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e11);
            }
            h = true;
        }
        Constructor constructor = f7189g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e12) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e12);
            }
        }
        return null;
    }

    @Override // n0.r1
    public a2 b() {
        a();
        a2 g9 = a2.g(null, this.f7190c);
        f0.c[] cVarArr = this.f7195b;
        x1 x1Var = g9.f7139a;
        x1Var.o(cVarArr);
        x1Var.q(this.f7191d);
        return g9;
    }

    @Override // n0.r1
    public void e(f0.c cVar) {
        this.f7191d = cVar;
    }

    @Override // n0.r1
    public void g(f0.c cVar) {
        WindowInsets windowInsets = this.f7190c;
        if (windowInsets != null) {
            this.f7190c = windowInsets.replaceSystemWindowInsets(cVar.f3193a, cVar.f3194b, cVar.f3195c, cVar.f3196d);
        }
    }

    public o1(a2 a2Var) {
        super(a2Var);
        this.f7190c = a2Var.f();
    }
}
