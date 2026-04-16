package n;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o0 implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6989i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6990j;

    public /* synthetic */ o0(Object obj, int i9) {
        this.f6989i = i9;
        this.f6990j = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i9, long j5) {
        switch (this.f6989i) {
            case 0:
                q0 q0Var = (q0) this.f6990j;
                t0 t0Var = q0Var.P;
                t0Var.setSelection(i9);
                if (t0Var.getOnItemClickListener() != null) {
                    t0Var.performItemClick(view, i9, q0Var.M.getItemId(i9));
                }
                q0Var.dismiss();
                break;
            case 1:
                ((SearchView) this.f6990j).n(i9);
                break;
            default:
                x5.r rVar = (x5.r) this.f6990j;
                k2 k2Var = rVar.f10191m;
                x5.r.a(rVar, i9 < 0 ? !k2Var.H.isShowing() ? null : k2Var.f6926k.getSelectedItem() : rVar.getAdapter().getItem(i9));
                AdapterView.OnItemClickListener onItemClickListener = rVar.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i9 < 0) {
                        view = !k2Var.H.isShowing() ? null : k2Var.f6926k.getSelectedView();
                        i9 = !k2Var.H.isShowing() ? -1 : k2Var.f6926k.getSelectedItemPosition();
                        j5 = !k2Var.H.isShowing() ? Long.MIN_VALUE : k2Var.f6926k.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(k2Var.f6926k, view, i9, j5);
                }
                k2Var.dismiss();
                break;
        }
    }
}
