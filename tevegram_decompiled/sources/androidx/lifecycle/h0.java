package androidx.lifecycle;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h0 implements p3.c {

    /* renamed from: a, reason: collision with root package name */
    public final n.s f917a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f918b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f919c;

    /* renamed from: d, reason: collision with root package name */
    public final n7.e f920d;

    public h0(n.s sVar, g.l lVar) {
        sVar.getClass();
        this.f917a = sVar;
        this.f920d = new n7.e(new androidx.activity.q(lVar, 3));
    }

    @Override // p3.c
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f919c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        Iterator it = ((i0) this.f920d.a()).f921c.entrySet().iterator();
        if (!it.hasNext()) {
            this.f918b = false;
            return bundle;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getValue().getClass();
        androidx.fragment.app.a.c();
        return null;
    }
}
