package i7;

import android.widget.ProgressBar;
import android.widget.Toast;
import com.network.tvgramplayer.ui.PlaylistsActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class u3 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5149i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f5150j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f5151k;

    public /* synthetic */ u3(Object obj, boolean z8, int i9) {
        this.f5149i = i9;
        this.f5151k = obj;
        this.f5150j = z8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f5149i;
        boolean z8 = this.f5150j;
        Object obj = this.f5151k;
        switch (i9) {
            case 0:
                c7.c cVar = ((PlaylistsActivity) obj).E;
                if (cVar != null) {
                    ((ProgressBar) cVar.f1668l).setVisibility(z8 ? 0 : 8);
                    return;
                } else {
                    b8.i.d("binding");
                    throw null;
                }
            case 1:
                PlaylistsActivity playlistsActivity = (PlaylistsActivity) obj;
                int i10 = PlaylistsActivity.K;
                if (z8) {
                    Toast.makeText(playlistsActivity, "M3U subida a Mensajes Guardados ☁️", 0).show();
                    return;
                } else {
                    Toast.makeText(playlistsActivity, "Error al subir M3U", 0).show();
                    return;
                }
            case 2:
                PlaylistsActivity playlistsActivity2 = (PlaylistsActivity) obj;
                int i11 = PlaylistsActivity.K;
                if (z8) {
                    Toast.makeText(playlistsActivity2, "Nube sincronizada con éxito ✅", 0).show();
                    return;
                } else {
                    Toast.makeText(playlistsActivity2, "Error al sincronizar con la nube ☁️", 0).show();
                    return;
                }
            default:
                n1.q qVar = (n1.q) ((m1.b) obj).f6511k;
                int i12 = g1.w.f3713a;
                l1.b0 b0Var = ((l1.y) qVar).f6065i;
                if (b0Var.i0 == z8) {
                    return;
                }
                b0Var.i0 = z8;
                b0Var.f5799t.e(23, new l1.v(z8, 1));
                return;
        }
    }

    public /* synthetic */ u3(boolean z8, PlaylistsActivity playlistsActivity, int i9) {
        this.f5149i = i9;
        this.f5150j = z8;
        this.f5151k = playlistsActivity;
    }
}
