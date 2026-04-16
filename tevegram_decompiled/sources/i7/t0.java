package i7;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import com.network.tvgramplayer.ui.PlayerActivity;
import com.network.tvgramplayer.ui.PlaylistsActivity;
import com.network.tvgramplayer.util.SubscriptionItem;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class t0 implements DialogInterface.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5122i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ g.l f5123j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f5124k;

    public /* synthetic */ t0(g.l lVar, Object obj, int i9) {
        this.f5122i = i9;
        this.f5123j = lVar;
        this.f5124k = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i9) {
        boolean removeIf;
        switch (this.f5122i) {
            case 0:
                MainActivity mainActivity = (MainActivity) this.f5123j;
                SubscriptionItem subscriptionItem = (SubscriptionItem) this.f5124k;
                a0.l lVar = mainActivity.J;
                if (lVar == null) {
                    b8.i.d("subscriptionManager");
                    throw null;
                }
                String url = subscriptionItem.getUrl();
                url.getClass();
                Collection collection = (Collection) ((l8.d) lVar.f32k).d();
                collection.getClass();
                ArrayList arrayList = new ArrayList(collection);
                o7.n.F0(arrayList, new b7.i(url, 2));
                lVar.v(arrayList);
                return;
            case 1:
                MainActivity mainActivity2 = (MainActivity) this.f5123j;
                TextView textView = (TextView) this.f5124k;
                int i10 = MainActivity.X;
                mainActivity2.t().b();
                textView.setText("Uso actual: 0 MB");
                return;
            case 2:
                MainActivity mainActivity3 = (MainActivity) this.f5123j;
                Playlist playlist = (Playlist) this.f5124k;
                int i11 = MainActivity.X;
                if (i9 == 0) {
                    mainActivity3.w(playlist);
                    return;
                }
                if (i9 == 1 && !playlist.getItems().isEmpty()) {
                    PlaylistItem playlistItem = playlist.getItems().get(0);
                    Intent intent = new Intent(mainActivity3, (Class<?>) PlayerActivity.class);
                    long chatId = playlistItem.getChatId();
                    long msgId = playlistItem.getMsgId();
                    String encode = Uri.encode(playlistItem.getTitle());
                    StringBuilder c9 = t.a.c("tg://msg?chat_id=", chatId, "&msg_id=");
                    c9.append(msgId);
                    c9.append("&title=");
                    c9.append(encode);
                    intent.setData(Uri.parse("tvgram://play?url=" + Uri.encode(c9.toString())));
                    intent.putExtra("EXTRA_PLAYLIST_ID", playlist.getId());
                    intent.putExtra("EXTRA_START_INDEX", 0);
                    intent.putExtra("CHAT_ID", playlistItem.getChatId());
                    intent.putExtra("MESSAGE_ID", playlistItem.getMsgId());
                    intent.putExtra("FILE_NAME", playlistItem.getTitle());
                    mainActivity3.startActivity(intent);
                    return;
                }
                return;
            case 3:
                MediaExplorerActivity mediaExplorerActivity = (MediaExplorerActivity) this.f5123j;
                TdClient$ExplorerItem tdClient$ExplorerItem = (TdClient$ExplorerItem) this.f5124k;
                int i12 = MediaExplorerActivity.Y;
                mediaExplorerActivity.t(tdClient$ExplorerItem.getActions().get(i9), tdClient$ExplorerItem.getTitle(), tdClient$ExplorerItem.getDescription());
                return;
            default:
                PlaylistsActivity playlistsActivity = (PlaylistsActivity) this.f5123j;
                Playlist playlist2 = (Playlist) this.f5124k;
                a0.l lVar2 = playlistsActivity.F;
                if (lVar2 == null) {
                    b8.i.d("playlistManager");
                    throw null;
                }
                String id = playlist2.getId();
                synchronized (lVar2) {
                    id.getClass();
                    removeIf = ((ArrayList) lVar2.f32k).removeIf(new b7.j(new b7.i(id, 1), 1));
                    if (removeIf) {
                        lVar2.w();
                    }
                }
                if (removeIf) {
                    playlistsActivity.t();
                    Toast.makeText(playlistsActivity, "Lista eliminada 🔥", 0).show();
                    return;
                }
                return;
        }
    }
}
