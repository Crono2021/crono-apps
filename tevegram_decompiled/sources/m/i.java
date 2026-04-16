package m;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements z, AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    public Context f6422i;

    /* renamed from: j, reason: collision with root package name */
    public LayoutInflater f6423j;

    /* renamed from: k, reason: collision with root package name */
    public m f6424k;

    /* renamed from: l, reason: collision with root package name */
    public ExpandedMenuView f6425l;

    /* renamed from: m, reason: collision with root package name */
    public y f6426m;

    /* renamed from: n, reason: collision with root package name */
    public h f6427n;

    public i(Context context) {
        this.f6422i = context;
        this.f6423j = LayoutInflater.from(context);
    }

    @Override // m.z
    public final void a(m mVar, boolean z8) {
        y yVar = this.f6426m;
        if (yVar != null) {
            yVar.a(mVar, z8);
        }
    }

    @Override // m.z
    public final void d() {
        h hVar = this.f6427n;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // m.z
    public final boolean f(o oVar) {
        return false;
    }

    @Override // m.z
    public final void g(Context context, m mVar) {
        if (this.f6422i != null) {
            this.f6422i = context;
            if (this.f6423j == null) {
                this.f6423j = LayoutInflater.from(context);
            }
        }
        this.f6424k = mVar;
        h hVar = this.f6427n;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // m.z
    public final boolean h() {
        return false;
    }

    @Override // m.z
    public final boolean i(f0 f0Var) {
        boolean hasVisibleItems = f0Var.hasVisibleItems();
        Context context = f0Var.f6434i;
        if (!hasVisibleItems) {
            return false;
        }
        n nVar = new n();
        nVar.f6452i = f0Var;
        g.j jVar = new g.j(context);
        i iVar = new i(jVar.getContext());
        nVar.f6454k = iVar;
        iVar.f6426m = nVar;
        f0Var.b(iVar, context);
        i iVar2 = nVar.f6454k;
        if (iVar2.f6427n == null) {
            iVar2.f6427n = new h(iVar2);
        }
        h hVar = iVar2.f6427n;
        g.f fVar = jVar.f3568a;
        fVar.f3521q = hVar;
        fVar.f3522r = nVar;
        View view = f0Var.f6448w;
        if (view != null) {
            fVar.f3510e = view;
        } else {
            fVar.f3508c = f0Var.f6447v;
            jVar.setTitle(f0Var.f6446u);
        }
        fVar.f3519o = nVar;
        g.k create = jVar.create();
        nVar.f6453j = create;
        create.setOnDismissListener(nVar);
        WindowManager.LayoutParams attributes = nVar.f6453j.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        nVar.f6453j.show();
        y yVar = this.f6426m;
        if (yVar == null) {
            return true;
        }
        yVar.l(f0Var);
        return true;
    }

    @Override // m.z
    public final void j(y yVar) {
        throw null;
    }

    @Override // m.z
    public final boolean k(o oVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i9, long j5) {
        this.f6424k.q(this.f6427n.getItem(i9), this, 0);
    }
}
