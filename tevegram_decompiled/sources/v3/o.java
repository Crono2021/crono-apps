package v3;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n0.f0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9544a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f9545b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f9546c;

    static {
        a aVar = new a();
        aVar.E = new ArrayList();
        aVar.F = true;
        aVar.H = false;
        aVar.I = 0;
        aVar.F = false;
        aVar.F(new h(2));
        aVar.F(new f());
        aVar.F(new h(1));
        f9544a = aVar;
        f9545b = new ThreadLocal();
        f9546c = new ArrayList();
    }

    public static void a(ViewGroup viewGroup, k kVar) {
        ArrayList arrayList = f9546c;
        if (arrayList.contains(viewGroup)) {
            return;
        }
        WeakHashMap weakHashMap = t0.f7209a;
        if (f0.c(viewGroup)) {
            arrayList.add(viewGroup);
            if (kVar == null) {
                kVar = f9544a;
            }
            k clone = kVar.clone();
            ArrayList arrayList2 = (ArrayList) b().getOrDefault(viewGroup, null);
            if (arrayList2 != null && arrayList2.size() > 0) {
                int size = arrayList2.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj = arrayList2.get(i9);
                    i9++;
                    ((k) obj).t(viewGroup);
                }
            }
            if (clone != null) {
                clone.g(viewGroup, true);
            }
            if (viewGroup.getTag(2131362489) != null) {
                androidx.fragment.app.a.c();
                return;
            }
            viewGroup.setTag(2131362489, null);
            if (clone != null) {
                n nVar = new n();
                nVar.f9542i = clone;
                nVar.f9543j = viewGroup;
                viewGroup.addOnAttachStateChangeListener(nVar);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(nVar);
            }
        }
    }

    public static s.d b() {
        s.d dVar;
        ThreadLocal threadLocal = f9545b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (dVar = (s.d) weakReference.get()) != null) {
            return dVar;
        }
        s.d dVar2 = new s.d();
        threadLocal.set(new WeakReference(dVar2));
        return dVar2;
    }
}
