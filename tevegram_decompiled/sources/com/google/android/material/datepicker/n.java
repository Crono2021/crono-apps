package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;
import com.network.tvgramplayer.ui.DiscoveryActivity;
import com.network.tvgramplayer.ui.ImageViewerActivity;
import d1.d1;
import d1.t0;
import o3.g0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2043i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f2044j;

    public /* synthetic */ n(Object obj, int i9) {
        this.f2043i = i9;
        this.f2044j = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecyclerView recyclerView;
        g0 adapter;
        int G;
        int i9 = this.f2043i;
        Object obj = this.f2044j;
        switch (i9) {
            case 0:
                ((o) obj).B();
                throw null;
            case 1:
                int i10 = DiscoveryActivity.J;
                ((DiscoveryActivity) obj).finish();
                return;
            case 2:
                int i11 = ImageViewerActivity.I;
                ((ImageViewerActivity) obj).finish();
                return;
            case 3:
                ((j7.t) obj).f5498e.a(null);
                return;
            case 4:
                l3.q.a((l3.q) obj);
                return;
            case 5:
                l3.q qVar = ((l3.f) obj).f6129g;
                t0 t0Var = qVar.f6206p0;
                if (t0Var == null || !t0Var.J(29)) {
                    return;
                }
                d1 Y = qVar.f6206p0.Y();
                t0 t0Var2 = qVar.f6206p0;
                int i12 = g1.w.f3713a;
                t0Var2.n(Y.a().b(1).g(1).a());
                ((String[]) qVar.f6201n.f4949e)[1] = qVar.getResources().getString(2131951710);
                qVar.f6211s.dismiss();
                return;
            case 6:
                l3.l lVar = (l3.l) obj;
                l3.q qVar2 = lVar.f6168x;
                int i13 = -1;
                if (lVar.f7635s != null && (recyclerView = lVar.f7634r) != null && (adapter = recyclerView.getAdapter()) != null && (G = lVar.f7634r.G(lVar)) != -1 && lVar.f7635s == adapter) {
                    i13 = G;
                }
                View view2 = qVar2.H;
                if (i13 == 0) {
                    l3.j jVar = qVar2.f6203o;
                    view2.getClass();
                    qVar2.e(jVar, view2);
                    return;
                } else {
                    if (i13 != 1) {
                        qVar2.f6211s.dismiss();
                        return;
                    }
                    l3.f fVar = qVar2.f6207q;
                    view2.getClass();
                    qVar2.e(fVar, view2);
                    return;
                }
            case 7:
                l3.q qVar3 = ((l3.f) obj).f6129g;
                t0 t0Var3 = qVar3.f6206p0;
                if (t0Var3 == null || !t0Var3.J(29)) {
                    return;
                }
                qVar3.f6206p0.n(qVar3.f6206p0.Y().a().b(3).e().a());
                qVar3.f6211s.dismiss();
                return;
            case 8:
                l3.v vVar = (l3.v) obj;
                vVar.g();
                if (view.getId() == 2131362064) {
                    vVar.f6251q.start();
                    return;
                } else {
                    if (view.getId() == 2131362063) {
                        vVar.f6252r.start();
                        return;
                    }
                    return;
                }
            case 9:
                x5.c cVar = (x5.c) obj;
                EditText editText = cVar.f10111i;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                cVar.p();
                return;
            case 10:
                ((x5.i) obj).t();
                return;
            default:
                x5.s sVar = (x5.s) obj;
                EditText editText2 = sVar.f10200f;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = sVar.f10200f;
                boolean z8 = editText3 != null && (editText3.getTransformationMethod() instanceof PasswordTransformationMethod);
                EditText editText4 = sVar.f10200f;
                if (z8) {
                    editText4.setTransformationMethod(null);
                } else {
                    editText4.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    sVar.f10200f.setSelection(selectionEnd);
                }
                sVar.p();
                return;
        }
    }
}
