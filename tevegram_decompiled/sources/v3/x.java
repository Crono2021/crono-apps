package v3;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x extends l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f9558a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f9559b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f9560c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f9561d;

    public x(h hVar, ViewGroup viewGroup, View view, View view2) {
        this.f9561d = hVar;
        this.f9558a = viewGroup;
        this.f9559b = view;
        this.f9560c = view2;
    }

    @Override // v3.j
    public final void b(k kVar) {
        this.f9560c.setTag(2131362333, null);
        this.f9558a.getOverlay().remove(this.f9559b);
        kVar.u(this);
    }

    @Override // v3.l, v3.j
    public final void c() {
        this.f9558a.getOverlay().remove(this.f9559b);
    }

    @Override // v3.l, v3.j
    public final void d() {
        View view = this.f9559b;
        if (view.getParent() == null) {
            this.f9558a.getOverlay().add(view);
            return;
        }
        h hVar = this.f9561d;
        ArrayList arrayList = hVar.f9534u;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = hVar.f9538y;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        ArrayList arrayList3 = (ArrayList) hVar.f9538y.clone();
        int size2 = arrayList3.size();
        for (int i9 = 0; i9 < size2; i9++) {
            ((j) arrayList3.get(i9)).e();
        }
    }
}
