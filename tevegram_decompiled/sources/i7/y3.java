package i7;

import android.content.DialogInterface;
import android.widget.Toast;
import com.google.gson.Gson;
import com.network.tvgramplayer.ui.PlaylistsActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class y3 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5221i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PlaylistsActivity f5222j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b7.a f5223k;

    public /* synthetic */ y3(PlaylistsActivity playlistsActivity, b7.a aVar, int i9) {
        this.f5221i = i9;
        this.f5222j = playlistsActivity;
        this.f5223k = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        switch (this.f5221i) {
            case 0:
                PlaylistsActivity playlistsActivity = this.f5222j;
                a0.l lVar = playlistsActivity.F;
                if (lVar == null) {
                    b8.i.d("playlistManager");
                    throw null;
                }
                String json = new Gson().toJson(this.f5223k);
                json.getClass();
                if (lVar.l(json)) {
                    Toast.makeText(playlistsActivity, "Lista actualizada ✅", 0).show();
                    playlistsActivity.t();
                    return;
                }
                return;
            default:
                PlaylistsActivity playlistsActivity2 = this.f5222j;
                a0.l lVar2 = playlistsActivity2.F;
                if (lVar2 == null) {
                    b8.i.d("playlistManager");
                    throw null;
                }
                String json2 = new Gson().toJson(this.f5223k);
                json2.getClass();
                if (lVar2.l(json2)) {
                    Toast.makeText(playlistsActivity2, "Lista importada ✅", 0).show();
                    playlistsActivity2.t();
                    return;
                }
                return;
        }
    }
}
