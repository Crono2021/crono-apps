package i7;

import android.widget.Toast;
import com.network.tvgramplayer.ui.PlaylistsActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class v3 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5162i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PlaylistsActivity f5163j;

    public /* synthetic */ v3(PlaylistsActivity playlistsActivity, int i9) {
        this.f5162i = i9;
        this.f5163j = playlistsActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f5162i;
        PlaylistsActivity playlistsActivity = this.f5163j;
        switch (i9) {
            case 0:
                int i10 = PlaylistsActivity.K;
                Toast.makeText(playlistsActivity, "No se encontró backup en la nube para esta lista.", 0).show();
                break;
            default:
                int i11 = PlaylistsActivity.K;
                Toast.makeText(playlistsActivity, "Error al procesar archivo de nube", 0).show();
                break;
        }
    }
}
