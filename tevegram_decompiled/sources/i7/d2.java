package i7;

import android.content.Intent;
import android.net.Uri;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.network.tvgramplayer.ui.MediaExplorerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class d2 implements androidx.activity.result.b, t3.j, n.v3 {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f4823i;

    public /* synthetic */ d2(MediaExplorerActivity mediaExplorerActivity) {
        this.f4823i = mediaExplorerActivity;
    }

    @Override // androidx.activity.result.b
    public void b(Object obj) {
        Uri data;
        int i9;
        androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
        int i10 = MediaExplorerActivity.Y;
        int i11 = aVar.f323i;
        MediaExplorerActivity mediaExplorerActivity = this.f4823i;
        if (i11 != -1) {
            mediaExplorerActivity.X = 0;
            return;
        }
        Intent intent = aVar.f324j;
        if (intent == null || (data = intent.getData()) == null || (i9 = mediaExplorerActivity.X) == 0) {
            return;
        }
        Toast.makeText(mediaExplorerActivity, "Descargando desde Telegram...", 0).show();
        c7.b bVar = mediaExplorerActivity.E;
        if (bVar == null) {
            b8.i.d("binding");
            throw null;
        }
        ((ProgressBar) bVar.h).setVisibility(0);
        mediaExplorerActivity.u().c(i9, new h7.c(mediaExplorerActivity, 8, data));
        mediaExplorerActivity.X = 0;
    }
}
