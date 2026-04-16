package i7;

import android.graphics.Color;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.network.tvgramplayer.ui.MediaExplorerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class f2 implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4847a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4848b;

    public /* synthetic */ f2(Object obj, int i9) {
        this.f4847a = i9;
        this.f4848b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z8) {
        float f9;
        int i9 = this.f4847a;
        Object obj = this.f4848b;
        switch (i9) {
            case 0:
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) obj;
                if (z8) {
                    int i10 = MediaExplorerActivity.Y;
                    mediaExplorerActivity.B();
                    return;
                }
                c7.b bVar = mediaExplorerActivity.E;
                if (bVar != null) {
                    ((CoordinatorLayout) bVar.f1650d).postDelayed(new j2(mediaExplorerActivity, 0), 300L);
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 1:
                j7.m mVar = (j7.m) obj;
                f9 = z8 ? 1.15f : 1.0f;
                view.animate().scaleX(f9).scaleY(f9).setDuration(200L).start();
                mVar.f5476v.setStrokeWidth(z8 ? 3 : 0);
                mVar.f5475u.setTextColor(z8 ? Color.parseColor("#FFEB3B") : -1);
                return;
            case 2:
                j7.r rVar = (j7.r) obj;
                f9 = z8 ? 1.15f : 1.0f;
                view.animate().scaleX(f9).scaleY(f9).setDuration(200L).start();
                rVar.f5495w.setStrokeWidth(z8 ? 3 : 0);
                rVar.f5493u.setTextColor(z8 ? Color.parseColor("#03A9F4") : -1);
                return;
            case 3:
                x5.c cVar = (x5.c) obj;
                cVar.s(cVar.t());
                return;
            default:
                x5.i iVar = (x5.i) obj;
                iVar.f10126l = z8;
                iVar.p();
                if (z8) {
                    return;
                }
                iVar.s(false);
                iVar.f10127m = false;
                return;
        }
    }
}
