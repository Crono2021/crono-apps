package h7;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.sidesheet.SideSheetBehavior;
import d1.r0;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import n0.t0;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class c0 implements Client.ResultHandler, g1.j, o0.x {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4077i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4078j;

    public /* synthetic */ c0(Object obj, int i9) {
        this.f4078j = obj;
        this.f4077i = i9;
    }

    @Override // g1.j
    public void a(Object obj) {
        ((r0) obj).C((d1.e0) this.f4078j, this.f4077i);
    }

    @Override // o0.x
    public boolean b(View view) {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4078j;
        int i9 = this.f4077i;
        if (i9 == 1 || i9 == 2) {
            throw new IllegalArgumentException(androidx.activity.g.o(new StringBuilder("STATE_"), i9 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = sideSheetBehavior.f2119p;
        if (weakReference == null || weakReference.get() == null) {
            sideSheetBehavior.s(i9);
            return true;
        }
        View view2 = (View) sideSheetBehavior.f2119p.get();
        e0.m mVar = new e0.m(i9, 2, sideSheetBehavior);
        ViewParent parent = view2.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = t0.f7209a;
            if (n0.f0.b(view2)) {
                view2.post(mVar);
                return true;
            }
        }
        mVar.run();
        return true;
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public void onResult(TdApi.Object object) {
        g7.c cVar = (g7.c) this.f4078j;
        if (object.getConstructor() == 1263291956) {
            cVar.a((TdApi.File) object);
            return;
        }
        if (object instanceof TdApi.Error) {
            TdApi.Error error = (TdApi.Error) object;
            Log.e("TdClient", "❌ GetFile Error: " + error.message + " (Code: " + error.code + ") for fileId: " + this.f4077i);
        }
        cVar.a(null);
    }
}
