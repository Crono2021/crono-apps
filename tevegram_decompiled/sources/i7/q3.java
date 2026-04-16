package i7;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.network.tvgramplayer.TvgramApplication;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.ui.PlayerActivity;
import com.network.tvgramplayer.ui.PlaylistsActivity;
import java.util.List;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class q3 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5055i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PlaylistsActivity f5056j;

    public /* synthetic */ q3(PlaylistsActivity playlistsActivity, int i9) {
        this.f5055i = i9;
        this.f5056j = playlistsActivity;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        List<PlaylistItem> items;
        String id;
        int i9 = this.f5055i;
        int i10 = 1;
        final PlaylistsActivity playlistsActivity = this.f5056j;
        switch (i9) {
            case 0:
                Playlist playlist = (Playlist) obj;
                int i11 = PlaylistsActivity.K;
                playlist.getClass();
                final String id2 = playlist.getId();
                final s3 s3Var = new s3(playlistsActivity, playlist);
                Application application = playlistsActivity.getApplication();
                application.getClass();
                final h7.k0 a9 = ((TvgramApplication) application).a();
                playlistsActivity.w(true);
                a9.w("#tvgram_sync_" + id2, 1, new a8.l() { // from class: i7.x3
                    @Override // a8.l
                    public final Object a(Object obj2) {
                        TdApi.Document document;
                        List list = (List) obj2;
                        int i12 = PlaylistsActivity.K;
                        list.getClass();
                        boolean isEmpty = list.isEmpty();
                        PlaylistsActivity playlistsActivity2 = PlaylistsActivity.this;
                        s3 s3Var2 = s3Var;
                        if (isEmpty) {
                            playlistsActivity2.w(false);
                            playlistsActivity2.runOnUiThread(new z3(s3Var2, 0));
                        } else {
                            TdApi.MessageContent messageContent = ((TdApi.Message) o7.h.H0(list)).content;
                            TdApi.MessageDocument messageDocument = messageContent instanceof TdApi.MessageDocument ? (TdApi.MessageDocument) messageContent : null;
                            if (messageDocument == null || (document = messageDocument.document) == null) {
                                playlistsActivity2.w(false);
                                playlistsActivity2.runOnUiThread(new z3(s3Var2, 1));
                            } else {
                                a9.c(document.document.id, new a0(playlistsActivity2, id2, s3Var2, 3));
                            }
                        }
                        return n7.g.f7490c;
                    }
                });
                break;
            case 1:
                Playlist playlist2 = (Playlist) obj;
                int i12 = PlaylistsActivity.K;
                playlist2.getClass();
                playlistsActivity.I = playlist2;
                c7.c cVar = playlistsActivity.E;
                if (cVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                cVar.f1670n.setText("Editando: " + playlist2.getName());
                c7.c cVar2 = playlistsActivity.E;
                if (cVar2 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                cVar2.f1659b.setText("Reordena las pistas con las flechas o eliminalas de la lista");
                c7.c cVar3 = playlistsActivity.E;
                if (cVar3 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                cVar3.f1658a.setVisibility(0);
                c7.c cVar4 = playlistsActivity.E;
                if (cVar4 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((Chip) cVar4.f1667k).setChecked(playlist2.isShuffleEnabled());
                c7.c cVar5 = playlistsActivity.E;
                if (cVar5 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((Chip) cVar5.f1665i).setChecked(playlist2.isLoopEnabled());
                c7.c cVar6 = playlistsActivity.E;
                if (cVar6 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                ((Chip) cVar6.f1661d).setChecked(playlist2.isAutoNextEnabled());
                r rVar = playlistsActivity.H;
                if (rVar == null) {
                    b8.i.d("tracksAdapter");
                    throw null;
                }
                List<PlaylistItem> items2 = playlist2.getItems();
                items2.getClass();
                rVar.f5058e = items2;
                c7.c cVar7 = playlistsActivity.E;
                if (cVar7 == null) {
                    b8.i.d("binding");
                    throw null;
                }
                RecyclerView recyclerView = (RecyclerView) cVar7.f1669m;
                r rVar2 = playlistsActivity.H;
                if (rVar2 == null) {
                    b8.i.d("tracksAdapter");
                    throw null;
                }
                recyclerView.setAdapter(rVar2);
                r rVar3 = playlistsActivity.H;
                if (rVar3 == null) {
                    b8.i.d("tracksAdapter");
                    throw null;
                }
                rVar3.c();
                break;
            case 2:
                Playlist playlist3 = (Playlist) obj;
                int i13 = PlaylistsActivity.K;
                playlist3.getClass();
                new g.j(playlistsActivity).setTitle("Eliminar lista").c("¿Estás seguro de quemar la lista '" + playlist3.getName() + "'?").g("Eliminar", new t0(playlistsActivity, playlist3, 4)).d("Cancelar", null).h();
                break;
            case 3:
                PlaylistItem playlistItem = (PlaylistItem) obj;
                int i14 = PlaylistsActivity.K;
                playlistItem.getClass();
                Playlist playlist4 = playlistsActivity.I;
                String id3 = playlist4 != null ? playlist4.getId() : null;
                Playlist playlist5 = playlistsActivity.I;
                int indexOf = (playlist5 == null || (items = playlist5.getItems()) == null) ? 0 : items.indexOf(playlistItem);
                if (id3 != null) {
                    a0.l lVar = playlistsActivity.F;
                    if (lVar == null) {
                        b8.i.d("playlistManager");
                        throw null;
                    }
                    Playlist k3 = lVar.k(id3);
                    if (k3 != null) {
                        if (new k7.a(playlistsActivity).f5628b.getBoolean("use_playlist_external", false)) {
                            playlistsActivity.v(k3);
                        } else {
                            playlistsActivity.x(k3, indexOf);
                        }
                        return n7.g.f7490c;
                    }
                }
                Intent intent = new Intent(playlistsActivity, (Class<?>) PlayerActivity.class);
                long chatId = playlistItem.getChatId();
                long msgId = playlistItem.getMsgId();
                String encode = Uri.encode(playlistItem.getTitle());
                StringBuilder c9 = t.a.c("tg://msg?chat_id=", chatId, "&msg_id=");
                c9.append(msgId);
                c9.append("&title=");
                c9.append(encode);
                intent.setData(Uri.parse("tvgram://play?url=" + Uri.encode(c9.toString())));
                intent.putExtra("CHAT_ID", playlistItem.getChatId());
                intent.putExtra("MESSAGE_ID", playlistItem.getMsgId());
                intent.putExtra("FILE_NAME", playlistItem.getTitle());
                playlistsActivity.startActivity(intent);
                return n7.g.f7490c;
            case 4:
                PlaylistItem playlistItem2 = (PlaylistItem) obj;
                int i15 = PlaylistsActivity.K;
                playlistItem2.getClass();
                Playlist playlist6 = playlistsActivity.I;
                if (playlist6 != null && (id = playlist6.getId()) != null) {
                    a0.l lVar2 = playlistsActivity.F;
                    if (lVar2 == null) {
                        b8.i.d("playlistManager");
                        throw null;
                    }
                    if (lVar2.u(id, playlistItem2.getId())) {
                        a0.l lVar3 = playlistsActivity.F;
                        if (lVar3 == null) {
                            b8.i.d("playlistManager");
                            throw null;
                        }
                        Playlist k9 = lVar3.k(id);
                        if (k9 != null) {
                            playlistsActivity.I = k9;
                            r rVar4 = playlistsActivity.H;
                            if (rVar4 == null) {
                                b8.i.d("tracksAdapter");
                                throw null;
                            }
                            List<PlaylistItem> items3 = k9.getItems();
                            items3.getClass();
                            rVar4.f5058e = items3;
                            r rVar5 = playlistsActivity.H;
                            if (rVar5 == null) {
                                b8.i.d("tracksAdapter");
                                throw null;
                            }
                            rVar5.c();
                            Toast.makeText(playlistsActivity, "Pista eliminada", 0).show();
                        }
                    }
                }
                return n7.g.f7490c;
            case 5:
                PlaylistItem playlistItem3 = (PlaylistItem) obj;
                int i16 = PlaylistsActivity.K;
                playlistItem3.getClass();
                playlistsActivity.u(playlistItem3, -1);
                break;
            case 6:
                PlaylistItem playlistItem4 = (PlaylistItem) obj;
                int i17 = PlaylistsActivity.K;
                playlistItem4.getClass();
                playlistsActivity.u(playlistItem4, 1);
                break;
            case 7:
                boolean booleanValue = ((Boolean) obj).booleanValue();
                int i18 = PlaylistsActivity.K;
                playlistsActivity.runOnUiThread(new u3(booleanValue, playlistsActivity, i10));
                break;
            default:
                boolean booleanValue2 = ((Boolean) obj).booleanValue();
                int i19 = PlaylistsActivity.K;
                playlistsActivity.runOnUiThread(new u3(booleanValue2, playlistsActivity, 2));
                break;
        }
        return n7.g.f7490c;
    }
}
