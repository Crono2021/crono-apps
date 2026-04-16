package m;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, y {

    /* renamed from: i, reason: collision with root package name */
    public f0 f6452i;

    /* renamed from: j, reason: collision with root package name */
    public g.k f6453j;

    /* renamed from: k, reason: collision with root package name */
    public i f6454k;

    @Override // m.y
    public final void a(m mVar, boolean z8) {
        g.k kVar;
        if ((z8 || mVar == this.f6452i) && (kVar = this.f6453j) != null) {
            kVar.dismiss();
        }
    }

    @Override // m.y
    public final boolean l(m mVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        f0 f0Var = this.f6452i;
        i iVar = this.f6454k;
        if (iVar.f6427n == null) {
            iVar.f6427n = new h(iVar);
        }
        f0Var.q(iVar.f6427n.getItem(i9), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f6454k.a(this.f6452i, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i9, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        f0 f0Var = this.f6452i;
        if (i9 == 82 || i9 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f6453j.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f6453j.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                f0Var.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return f0Var.performShortcut(i9, keyEvent, 0);
    }
}
