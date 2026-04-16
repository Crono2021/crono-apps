package a0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f25i = 0;

    /* renamed from: j, reason: collision with root package name */
    public final Object f26j;

    public h(t4.c cVar) {
        this.f26j = new WeakReference(cVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f25i) {
            case 0:
                ((CoordinatorLayout) this.f26j).p(0);
                break;
            default:
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                t4.c cVar = (t4.c) ((WeakReference) this.f26j).get();
                if (cVar != null) {
                    ArrayList arrayList = cVar.f8967b;
                    View view = cVar.f8966a;
                    if (!arrayList.isEmpty()) {
                        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        int i9 = 0;
                        int a9 = cVar.a(view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                        int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                        int a10 = cVar.a(view.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                        if (a9 > 0 || a9 == Integer.MIN_VALUE) {
                            if (a10 > 0 || a10 == Integer.MIN_VALUE) {
                                ArrayList arrayList2 = new ArrayList(arrayList);
                                int size = arrayList2.size();
                                while (i9 < size) {
                                    Object obj = arrayList2.get(i9);
                                    i9++;
                                    ((s4.f) obj).l(a9, a10);
                                }
                                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.removeOnPreDrawListener(cVar.f8968c);
                                }
                                cVar.f8968c = null;
                                arrayList.clear();
                                break;
                            }
                        }
                    }
                }
                break;
        }
        return true;
    }

    public h(CoordinatorLayout coordinatorLayout) {
        this.f26j = coordinatorLayout;
    }
}
