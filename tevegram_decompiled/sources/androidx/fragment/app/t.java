package androidx.fragment.app;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t implements p3.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f867a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f868b;

    public t(n.s sVar) {
        this.f867a = 2;
        this.f868b = new LinkedHashSet();
        sVar.e("androidx.savedstate.Restarter", this);
    }

    @Override // p3.c
    public final Bundle a() {
        switch (this.f867a) {
            case 0:
                Bundle bundle = new Bundle();
                g.l lVar = (g.l) this.f868b;
                a0.b bVar = lVar.f3577y;
                while (g.l.k(((v) bVar.f8j).f874r)) {
                }
                lVar.f3578z.d(androidx.lifecycle.l.ON_STOP);
                i0 O = ((v) bVar.f8j).f874r.O();
                if (O != null) {
                    bundle.putParcelable("android:support:fragments", O);
                }
                return bundle;
            case 1:
                Bundle bundle2 = new Bundle();
                ((g.l) this.f868b).i().getClass();
                return bundle2;
            default:
                Bundle bundle3 = new Bundle();
                bundle3.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f868b));
                return bundle3;
        }
    }

    public /* synthetic */ t(g.l lVar, int i9) {
        this.f867a = i9;
        this.f868b = lVar;
    }
}
