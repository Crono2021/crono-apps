package b7;

import a8.l;
import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.data.PlaylistItem;
import com.network.tvgramplayer.util.SubscriptionItem;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i implements l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1502i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f1503j;

    public /* synthetic */ i(String str, int i9) {
        this.f1502i = i9;
        this.f1503j = str;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        boolean a9;
        switch (this.f1502i) {
            case 0:
                PlaylistItem playlistItem = (PlaylistItem) obj;
                playlistItem.getClass();
                a9 = b8.i.a(playlistItem.getId(), this.f1503j);
                break;
            case 1:
                Playlist playlist = (Playlist) obj;
                playlist.getClass();
                a9 = b8.i.a(playlist.getId(), this.f1503j);
                break;
            default:
                SubscriptionItem subscriptionItem = (SubscriptionItem) obj;
                subscriptionItem.getClass();
                a9 = b8.i.a(subscriptionItem.getUrl(), this.f1503j);
                break;
        }
        return Boolean.valueOf(a9);
    }
}
