package n0;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s0 {

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f7196d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f7197a;

    /* renamed from: b, reason: collision with root package name */
    public SparseArray f7198b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f7199c;

    public final View a(View view) {
        int size;
        WeakHashMap weakHashMap = this.f7197a;
        if (weakHashMap == null || !weakHashMap.containsKey(view)) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View a9 = a(viewGroup.getChildAt(childCount));
                if (a9 != null) {
                    return a9;
                }
            }
        }
        ArrayList arrayList = (ArrayList) view.getTag(2131362430);
        if (arrayList == null || arrayList.size() - 1 < 0) {
            return null;
        }
        arrayList.get(size).getClass();
        androidx.fragment.app.a.c();
        return null;
    }
}
