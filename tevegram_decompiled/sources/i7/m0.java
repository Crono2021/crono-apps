package i7;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.SearchHistoryManager$QuickSearchItem;
import com.network.tvgramplayer.ui.LiveStreamActivity;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import com.network.tvgramplayer.util.SubscriptionItem;
import tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m0 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4973i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4974j;

    public /* synthetic */ m0(MainActivity mainActivity, int i9) {
        this.f4973i = i9;
        this.f4974j = mainActivity;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        int i9 = this.f4973i;
        int i10 = 0;
        MainActivity mainActivity = this.f4974j;
        switch (i9) {
            case 0:
                String str = (String) obj;
                int i11 = MainActivity.X;
                str.getClass();
                mainActivity.s(str);
                break;
            case 1:
                HistoryItem historyItem = (HistoryItem) obj;
                int i12 = MainActivity.X;
                historyItem.getClass();
                mainActivity.v(historyItem.getUrl(), historyItem.getTitle());
                break;
            case 2:
                HistoryItem historyItem2 = (HistoryItem) obj;
                int i13 = MainActivity.X;
                historyItem2.getClass();
                a0.l lVar = mainActivity.G;
                r7.c cVar = null;
                if (lVar == null) {
                    b8.i.d("historyManager");
                    throw null;
                }
                i8.w.j((n8.e) lVar.f33l, null, new b7.h(lVar, historyItem2.getChatId(), cVar, 1), 3);
                mainActivity.y();
                break;
            case 3:
                HistoryItem historyItem3 = (HistoryItem) obj;
                int i14 = MainActivity.X;
                historyItem3.getClass();
                a0.l lVar2 = mainActivity.G;
                r7.c cVar2 = null;
                if (lVar2 == null) {
                    b8.i.d("historyManager");
                    throw null;
                }
                i8.w.j((n8.e) lVar2.f33l, null, new b7.h(lVar2, historyItem3.getChatId(), cVar2, 0), 3);
                mainActivity.y();
                break;
            case 4:
                HistoryItem historyItem4 = (HistoryItem) obj;
                int i15 = MainActivity.X;
                historyItem4.getClass();
                String url = historyItem4.getUrl();
                String title = historyItem4.getTitle();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", title);
                intent.putExtra("android.intent.extra.TEXT", title + "\n" + url);
                mainActivity.startActivity(Intent.createChooser(intent, "Compartir enlace"));
                break;
            case 5:
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem = (SearchHistoryManager$QuickSearchItem) obj;
                int i16 = MainActivity.X;
                searchHistoryManager$QuickSearchItem.getClass();
                Intent intent2 = new Intent(mainActivity, (Class<?>) MediaExplorerActivity.class);
                intent2.putExtra("chat_id", searchHistoryManager$QuickSearchItem.getChatId());
                intent2.putExtra("thread_id", searchHistoryManager$QuickSearchItem.getThreadId());
                intent2.putExtra("chat_title", searchHistoryManager$QuickSearchItem.getChatTitle());
                intent2.putExtra("search_query", searchHistoryManager$QuickSearchItem.getQuery());
                intent2.putExtra("search_filter", searchHistoryManager$QuickSearchItem.getFilterType());
                mainActivity.startActivity(intent2);
                break;
            case 6:
                SearchHistoryManager$QuickSearchItem searchHistoryManager$QuickSearchItem2 = (SearchHistoryManager$QuickSearchItem) obj;
                int i17 = MainActivity.X;
                searchHistoryManager$QuickSearchItem2.getClass();
                a5.d dVar = mainActivity.M;
                if (dVar == null) {
                    b8.i.d("searchHistoryManager");
                    throw null;
                }
                dVar.U0(searchHistoryManager$QuickSearchItem2);
                mainActivity.A();
                break;
            case 7:
                SubscriptionItem subscriptionItem = (SubscriptionItem) obj;
                int i18 = MainActivity.X;
                subscriptionItem.getClass();
                String url2 = subscriptionItem.getUrl();
                String title2 = subscriptionItem.getTitle();
                HistoryItem historyItem5 = new HistoryItem(subscriptionItem.getChatId(), url2, title2, title2, null, false, 0L, 0L, null, null, "play", 992, null);
                a0.l lVar3 = mainActivity.G;
                if (lVar3 == null) {
                    b8.i.d("historyManager");
                    throw null;
                }
                lVar3.b(historyItem5);
                mainActivity.B(url2, title2, url2, (r11 & 32) == 0, (r11 & 16) != 0 ? null : "explorer");
                break;
            case 8:
                SubscriptionItem subscriptionItem2 = (SubscriptionItem) obj;
                int i19 = MainActivity.X;
                subscriptionItem2.getClass();
                new g.j(mainActivity).setTitle("Eliminar Suscripción").c("¿Deseas eliminar '" + subscriptionItem2.getTitle() + "' de tus suscripciones?").g("Sí", new t0(mainActivity, subscriptionItem2, i10)).d("No", null).h();
                break;
            case 9:
                Playlist playlist = (Playlist) obj;
                int i20 = MainActivity.X;
                playlist.getClass();
                if (playlist.getItems().isEmpty()) {
                    Toast.makeText(mainActivity, "Esta lista está vacía.", 0).show();
                } else {
                    k7.a aVar = mainActivity.K;
                    if (aVar == null) {
                        b8.i.d("settings");
                        throw null;
                    }
                    if (aVar.f5628b.getBoolean("use_playlist_external", false)) {
                        mainActivity.w(playlist);
                    } else {
                        new g.j(mainActivity).setTitle("¿Cómo quieres reproducir '" + playlist.getName() + "'?").b(new String[]{"Reproductor Externo (VLC/Kodi)", "Reproductor Interno (TVgram)"}, new t0(mainActivity, playlist, 2)).d("Cancelar", null).h();
                    }
                }
                return n7.g.f7490c;
            default:
                h7.i0 i0Var = (h7.i0) obj;
                int i21 = MainActivity.X;
                i0Var.getClass();
                long j5 = i0Var.f4113a;
                int i22 = i0Var.f4114b;
                Log.i("MainActivity", "🚀 Launching LiveStream from List: Chat=" + j5 + ", GCID=" + i22);
                Intent intent3 = new Intent(mainActivity, (Class<?>) LiveStreamActivity.class);
                intent3.putExtra("chat_id", j5);
                intent3.putExtra("group_call_id", i22);
                intent3.putExtra(IjkMediaMetadataRetriever.METADATA_KEY_TITLE, i0Var.f4115c);
                intent3.putExtra("participant_count", i0Var.f4116d);
                intent3.addFlags(67108864);
                mainActivity.startActivity(intent3);
                break;
        }
        return n7.g.f7490c;
    }
}
