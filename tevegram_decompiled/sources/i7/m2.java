package i7;

import android.widget.Toast;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m2 implements a8.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ a0.l f4977i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f4978j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f4979k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ TdClient$ExplorerItem f4980l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MediaExplorerActivity f4981m;

    public /* synthetic */ m2(a0.l lVar, String str, boolean z8, TdClient$ExplorerItem tdClient$ExplorerItem, MediaExplorerActivity mediaExplorerActivity) {
        this.f4977i = lVar;
        this.f4978j = str;
        this.f4979k = z8;
        this.f4980l = tdClient$ExplorerItem;
        this.f4981m = mediaExplorerActivity;
    }

    @Override // a8.a
    public final Object d() {
        String str;
        Object obj;
        boolean z8;
        a0.l lVar = this.f4977i;
        String str2 = this.f4978j;
        boolean z9 = this.f4979k;
        TdClient$ExplorerItem tdClient$ExplorerItem = this.f4980l;
        MediaExplorerActivity mediaExplorerActivity = this.f4981m;
        int i9 = MediaExplorerActivity.Y;
        Playlist k3 = lVar.k(str2);
        if (k3 == null || (str = k3.getName()) == null) {
            str = "la lista";
        }
        if (!z9 || tdClient$ExplorerItem.getMediaGroupId() == 0) {
            long chatId = tdClient$ExplorerItem.getChatId();
            long messageId = tdClient$ExplorerItem.getMessageId();
            String title = tdClient$ExplorerItem.getTitle();
            if (title == null) {
                title = "Desconocido";
            }
            if (lVar.c(str2, new PlaylistItem(null, chatId, messageId, title, 0, tdClient$ExplorerItem.getMediaGroupId(), 0L, 81, null))) {
                Toast.makeText(mediaExplorerActivity, "✅ Añadido a '" + str + "'", 0).show();
                j7.l lVar2 = mediaExplorerActivity.F;
                if (lVar2 == null) {
                    b8.i.d("adapter");
                    throw null;
                }
                lVar2.c();
            } else {
                Toast.makeText(mediaExplorerActivity, "⚠️ El track ya estaba en la lista", 0).show();
            }
        } else {
            j7.l lVar3 = mediaExplorerActivity.F;
            if (lVar3 == null) {
                b8.i.d("adapter");
                throw null;
            }
            ArrayList arrayList = lVar3.f5470d;
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj2 = arrayList.get(i10);
                i10++;
                if (((TdClient$ExplorerItem) obj2).getMediaGroupId() == tdClient$ExplorerItem.getMediaGroupId()) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList(o7.j.E0(arrayList2));
            int size2 = arrayList2.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj3 = arrayList2.get(i11);
                i11++;
                TdClient$ExplorerItem tdClient$ExplorerItem2 = (TdClient$ExplorerItem) obj3;
                long chatId2 = tdClient$ExplorerItem2.getChatId();
                long messageId2 = tdClient$ExplorerItem2.getMessageId();
                String title2 = tdClient$ExplorerItem2.getTitle();
                if (title2 == null) {
                    title2 = "Desconocido";
                }
                arrayList3.add(new PlaylistItem(null, chatId2, messageId2, title2, 0, tdClient$ExplorerItem2.getMediaGroupId(), 0L, 81, null));
            }
            synchronized (lVar) {
                try {
                    ArrayList arrayList4 = (ArrayList) lVar.f32k;
                    int size3 = arrayList4.size();
                    int i12 = 0;
                    while (true) {
                        if (i12 >= size3) {
                            obj = null;
                            break;
                        }
                        obj = arrayList4.get(i12);
                        i12++;
                        if (b8.i.a(((Playlist) obj).getId(), str2)) {
                            break;
                        }
                    }
                    Playlist playlist = (Playlist) obj;
                    if (playlist != null) {
                        int size4 = arrayList3.size();
                        z8 = false;
                        int i13 = 0;
                        while (i13 < size4) {
                            Object obj4 = arrayList3.get(i13);
                            i13++;
                            PlaylistItem playlistItem = (PlaylistItem) obj4;
                            List<PlaylistItem> items = playlist.getItems();
                            if (!(items != null) || !items.isEmpty()) {
                                for (PlaylistItem playlistItem2 : items) {
                                    if (playlistItem2.getChatId() != playlistItem.getChatId() || playlistItem2.getMsgId() != playlistItem.getMsgId()) {
                                    }
                                }
                            }
                            playlist.getItems().add(playlistItem);
                            z8 = true;
                        }
                        if (z8) {
                            playlist.setLastModified(System.currentTimeMillis());
                            lVar.w();
                        }
                    } else {
                        z8 = false;
                    }
                } finally {
                }
            }
            if (z8) {
                Toast.makeText(mediaExplorerActivity, "✅ Álbum añadido a '" + str + "'", 0).show();
                j7.l lVar4 = mediaExplorerActivity.F;
                if (lVar4 == null) {
                    b8.i.d("adapter");
                    throw null;
                }
                lVar4.c();
            } else {
                Toast.makeText(mediaExplorerActivity, "⚠️ Los tracks ya estaban en la lista", 0).show();
            }
        }
        return n7.g.f7490c;
    }
}
