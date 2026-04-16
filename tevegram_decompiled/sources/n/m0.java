package n;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m0 implements s0, DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public g.k f6962i;

    /* renamed from: j, reason: collision with root package name */
    public n0 f6963j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f6964k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ t0 f6965l;

    public m0(t0 t0Var) {
        this.f6965l = t0Var;
    }

    @Override // n.s0
    public final int a() {
        return 0;
    }

    @Override // n.s0
    public final boolean b() {
        g.k kVar = this.f6962i;
        if (kVar != null) {
            return kVar.isShowing();
        }
        return false;
    }

    @Override // n.s0
    public final Drawable d() {
        return null;
    }

    @Override // n.s0
    public final void dismiss() {
        g.k kVar = this.f6962i;
        if (kVar != null) {
            kVar.dismiss();
            this.f6962i = null;
        }
    }

    @Override // n.s0
    public final void g(CharSequence charSequence) {
        this.f6964k = charSequence;
    }

    @Override // n.s0
    public final void h(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // n.s0
    public final void i(int i9) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // n.s0
    public final void j(int i9) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // n.s0
    public final void k(int i9) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // n.s0
    public final void l(int i9, int i10) {
        if (this.f6963j == null) {
            return;
        }
        t0 t0Var = this.f6965l;
        g.j jVar = new g.j(t0Var.getPopupContext());
        CharSequence charSequence = this.f6964k;
        if (charSequence != null) {
            jVar.setTitle(charSequence);
        }
        n0 n0Var = this.f6963j;
        int selectedItemPosition = t0Var.getSelectedItemPosition();
        g.f fVar = jVar.f3568a;
        fVar.f3521q = n0Var;
        fVar.f3522r = this;
        fVar.f3527w = selectedItemPosition;
        fVar.f3526v = true;
        g.k create = jVar.create();
        this.f6962i = create;
        AlertController$RecycleListView alertController$RecycleListView = create.f3576n.f3544f;
        k0.d(alertController$RecycleListView, i9);
        k0.c(alertController$RecycleListView, i10);
        this.f6962i.show();
    }

    @Override // n.s0
    public final int m() {
        return 0;
    }

    @Override // n.s0
    public final CharSequence n() {
        return this.f6964k;
    }

    @Override // n.s0
    public final void o(ListAdapter listAdapter) {
        this.f6963j = (n0) listAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        t0 t0Var = this.f6965l;
        t0Var.setSelection(i9);
        if (t0Var.getOnItemClickListener() != null) {
            t0Var.performItemClick(null, i9, this.f6963j.getItemId(i9));
        }
        dismiss();
    }
}
