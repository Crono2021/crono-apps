package i7;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerAction;
import com.network.tvgramplayer.telegram.TdClient$ExplorerItem;
import com.network.tvgramplayer.telegram.TdClient$ExplorerType;
import com.network.tvgramplayer.ui.DiscoveryActivity;
import com.network.tvgramplayer.ui.ImageViewerActivity;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMetadataRetriever;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4889i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ DiscoveryActivity f4890j;

    public /* synthetic */ i(DiscoveryActivity discoveryActivity, int i9) {
        this.f4889i = i9;
        this.f4890j = discoveryActivity;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        Object obj2;
        String str;
        Object obj3;
        Object obj4;
        int i9 = this.f4889i;
        DiscoveryActivity discoveryActivity = this.f4890j;
        switch (i9) {
            case 0:
                List list = (List) obj;
                int i10 = DiscoveryActivity.J;
                list.getClass();
                discoveryActivity.runOnUiThread(new b2.f0(discoveryActivity, 9, list));
                return n7.g.f7490c;
            default:
                TdClient$ExplorerItem tdClient$ExplorerItem = (TdClient$ExplorerItem) obj;
                int i11 = DiscoveryActivity.J;
                tdClient$ExplorerItem.getClass();
                Iterator<T> it = tdClient$ExplorerItem.getActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (((TdClient$ExplorerAction) obj2).getType() == TdClient$ExplorerType.VIDEO) {
                        }
                    } else {
                        obj2 = null;
                    }
                }
                TdClient$ExplorerAction tdClient$ExplorerAction = (TdClient$ExplorerAction) obj2;
                if (tdClient$ExplorerAction == null) {
                    Iterator<T> it2 = tdClient$ExplorerItem.getActions().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj3 = it2.next();
                            if (((TdClient$ExplorerAction) obj3).getType() == TdClient$ExplorerType.LINK) {
                            }
                        } else {
                            obj3 = null;
                        }
                    }
                    tdClient$ExplorerAction = (TdClient$ExplorerAction) obj3;
                    if (tdClient$ExplorerAction == null) {
                        Iterator<T> it3 = tdClient$ExplorerItem.getActions().iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                obj4 = it3.next();
                                if (((TdClient$ExplorerAction) obj4).getType() == TdClient$ExplorerType.IMAGE) {
                                }
                            } else {
                                obj4 = null;
                            }
                        }
                        tdClient$ExplorerAction = (TdClient$ExplorerAction) obj4;
                    }
                }
                if (tdClient$ExplorerAction != null) {
                    String description = tdClient$ExplorerItem.getDescription();
                    if (description == null || (str = (String) o7.h.I0(h8.e.p0(description, new String[]{" • "}, 6))) == null) {
                        str = "Discovery";
                    }
                    String str2 = str;
                    a0.l lVar = discoveryActivity.H;
                    if (lVar == null) {
                        b8.i.d("historyManager");
                        throw null;
                    }
                    lVar.b(new HistoryItem(0L, tdClient$ExplorerAction.getUrl(), tdClient$ExplorerItem.getTitle(), str2, null, false, 0L, 0L, null, null, "play", 1008, null));
                    int i12 = m.f4972a[tdClient$ExplorerAction.getType().ordinal()];
                    if (i12 == 1) {
                        Intent intent = new Intent(discoveryActivity, (Class<?>) PlayerActivity.class);
                        intent.setData(Uri.parse("tvgram://play?url=" + Uri.encode(tdClient$ExplorerAction.getUrl()) + "&title=" + Uri.encode(tdClient$ExplorerItem.getTitle())));
                        discoveryActivity.startActivity(intent);
                    } else if (i12 != 2) {
                        if (i12 != 3) {
                            Toast.makeText(discoveryActivity, "Acción no soportada", 0).show();
                        } else {
                            Intent intent2 = new Intent(discoveryActivity, (Class<?>) ImageViewerActivity.class);
                            intent2.putExtra(IjkMediaMetadataRetriever.METADATA_KEY_TITLE, tdClient$ExplorerItem.getTitle());
                            if (h8.m.f0(tdClient$ExplorerAction.getUrl(), "telegram://", false)) {
                                Integer Z = h8.l.Z(h8.m.d0(tdClient$ExplorerAction.getUrl(), "telegram://", ""));
                                intent2.putExtra("file_id", Z != null ? Z.intValue() : 0);
                            } else {
                                intent2.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, tdClient$ExplorerAction.getUrl());
                            }
                            discoveryActivity.startActivity(intent2);
                        }
                    } else {
                        discoveryActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(tdClient$ExplorerAction.getUrl())));
                    }
                }
                return n7.g.f7490c;
        }
    }
}
