package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m implements DialogInterface.OnDismissListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ o f795i;

    public m(o oVar) {
        this.f795i = oVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        o oVar = this.f795i;
        Dialog dialog = oVar.i0;
        if (dialog != null) {
            oVar.onDismiss(dialog);
        }
    }
}
