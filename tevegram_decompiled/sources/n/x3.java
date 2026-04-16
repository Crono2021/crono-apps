package n;

import android.content.Context;
import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x3 implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final m.a f7102i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ y3 f7103j;

    public x3(y3 y3Var) {
        this.f7103j = y3Var;
        Context context = y3Var.f7109a.getContext();
        CharSequence charSequence = y3Var.h;
        m.a aVar = new m.a();
        aVar.f6362m = 4096;
        aVar.f6364o = 4096;
        aVar.f6369t = null;
        aVar.f6370u = null;
        aVar.f6371v = false;
        aVar.f6372w = false;
        aVar.f6373x = 16;
        aVar.f6366q = context;
        aVar.f6358i = charSequence;
        this.f7102i = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        y3 y3Var = this.f7103j;
        Window.Callback callback = y3Var.f7118k;
        if (callback == null || !y3Var.f7119l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f7102i);
    }
}
