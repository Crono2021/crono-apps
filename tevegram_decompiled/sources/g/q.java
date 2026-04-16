package g;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class q {

    /* renamed from: i, reason: collision with root package name */
    public static final i0 f3619i = new i0(new j0(0));

    /* renamed from: j, reason: collision with root package name */
    public static final int f3620j = -100;

    /* renamed from: k, reason: collision with root package name */
    public static j0.g f3621k = null;

    /* renamed from: l, reason: collision with root package name */
    public static j0.g f3622l = null;

    /* renamed from: m, reason: collision with root package name */
    public static Boolean f3623m = null;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f3624n = false;

    /* renamed from: o, reason: collision with root package name */
    public static final s.e f3625o = new s.e(0);

    /* renamed from: p, reason: collision with root package name */
    public static final Object f3626p = new Object();

    /* renamed from: q, reason: collision with root package name */
    public static final Object f3627q = new Object();

    public static boolean c(Context context) {
        if (f3623m == null) {
            try {
                int i9 = h0.f3538i;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) h0.class), Build.VERSION.SDK_INT >= 24 ? g0.a() | 128 : 640).metaData;
                if (bundle != null) {
                    f3623m = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f3623m = Boolean.FALSE;
            }
        }
        return f3623m.booleanValue();
    }

    public static void g(c0 c0Var) {
        synchronized (f3626p) {
            try {
                s.e eVar = f3625o;
                eVar.getClass();
                s.a aVar = new s.a(eVar);
                while (aVar.hasNext()) {
                    q qVar = (q) ((WeakReference) aVar.next()).get();
                    if (qVar == c0Var || qVar == null) {
                        aVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void d();

    public abstract void f();

    public abstract boolean h(int i9);

    public abstract void i(int i9);

    public abstract void k(View view);

    public abstract void l(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void m(CharSequence charSequence);
}
