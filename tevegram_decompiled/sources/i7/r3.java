package i7;

import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.google.android.material.chip.Chip;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.ui.PlaylistsActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class r3 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5096a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f5097b;

    public /* synthetic */ r3(KeyEvent.Callback callback, int i9) {
        this.f5096a = i9;
        this.f5097b = callback;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z8) {
        switch (this.f5096a) {
            case 0:
                PlaylistsActivity playlistsActivity = (PlaylistsActivity) this.f5097b;
                Playlist playlist = playlistsActivity.I;
                if (playlist != null) {
                    a0.l lVar = playlistsActivity.F;
                    if (lVar == null) {
                        b8.i.d("playlistManager");
                        throw null;
                    }
                    if (lVar.z(playlist.getId(), z8)) {
                        playlist.setShuffleEnabled(z8);
                        Toast.makeText(playlistsActivity, "Modo aleatorio: ".concat(z8 ? "Activado" : "Desactivado"), 0).show();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                PlaylistsActivity playlistsActivity2 = (PlaylistsActivity) this.f5097b;
                Playlist playlist2 = playlistsActivity2.I;
                if (playlist2 != null) {
                    a0.l lVar2 = playlistsActivity2.F;
                    if (lVar2 == null) {
                        b8.i.d("playlistManager");
                        throw null;
                    }
                    if (lVar2.x(playlist2.getId(), z8)) {
                        playlist2.setLoopEnabled(z8);
                        Toast.makeText(playlistsActivity2, "Modo bucle: ".concat(z8 ? "Activado" : "Desactivado"), 0).show();
                        return;
                    }
                    return;
                }
                return;
            case 2:
                PlaylistsActivity playlistsActivity3 = (PlaylistsActivity) this.f5097b;
                Playlist playlist3 = playlistsActivity3.I;
                if (playlist3 != null) {
                    a0.l lVar3 = playlistsActivity3.F;
                    if (lVar3 == null) {
                        b8.i.d("playlistManager");
                        throw null;
                    }
                    String id = playlist3.getId();
                    synchronized (lVar3) {
                        id.getClass();
                        Playlist k3 = lVar3.k(id);
                        if (k3 != null) {
                            k3.setAutoNextEnabled(z8);
                            k3.setLastModified(System.currentTimeMillis());
                            lVar3.w();
                            playlist3.setAutoNextEnabled(z8);
                            Toast.makeText(playlistsActivity3, "Auto-Siguiente: ".concat(z8 ? "Activado" : "Desactivado"), 0).show();
                            return;
                        }
                        return;
                    }
                }
                return;
            default:
                Chip chip = (Chip) this.f5097b;
                o5.g gVar = chip.f1989r;
                if (gVar != null) {
                    o5.a aVar = (o5.a) ((x) gVar).f5179j;
                    if (!z8 ? aVar.e(chip, aVar.f7936e) : aVar.a(chip)) {
                        aVar.d();
                    }
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = chip.f1988q;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z8);
                    return;
                }
                return;
        }
    }
}
