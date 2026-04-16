package i7;

import com.network.tvgramplayer.data.Playlist;
import com.network.tvgramplayer.ui.PlaylistsActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class s3 implements a8.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ PlaylistsActivity f5117i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Playlist f5118j;

    public /* synthetic */ s3(PlaylistsActivity playlistsActivity, Playlist playlist) {
        this.f5117i = playlistsActivity;
        this.f5118j = playlist;
    }

    @Override // a8.a
    public final Object d() {
        int i9 = PlaylistsActivity.K;
        PlaylistsActivity playlistsActivity = this.f5117i;
        boolean z8 = new k7.a(playlistsActivity).f5628b.getBoolean("use_playlist_external", false);
        Playlist playlist = this.f5118j;
        if (z8) {
            playlistsActivity.v(playlist);
        } else {
            playlistsActivity.x(playlist, 0);
        }
        return n7.g.f7490c;
    }
}
