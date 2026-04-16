package i7;

import com.network.tvgramplayer.player.PlayerManager;
import com.network.tvgramplayer.ui.PlayerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a3 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4765i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f4766j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ g.k f4767k;

    public /* synthetic */ a3(PlayerActivity playerActivity, g.k kVar, int i9) {
        this.f4765i = i9;
        this.f4766j = playerActivity;
        this.f4767k = kVar;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        int i9 = this.f4765i;
        g.k kVar = this.f4767k;
        PlayerActivity playerActivity = this.f4766j;
        switch (i9) {
            case 0:
                PlayerManager.SubtitleTrack subtitleTrack = (PlayerManager.SubtitleTrack) obj;
                PlayerManager playerManager = playerActivity.F;
                if (playerManager == null) {
                    b8.i.d("playerManager");
                    throw null;
                }
                playerManager.selectSubtitleTrack(subtitleTrack);
                playerActivity.x(true);
                kVar.dismiss();
                break;
            default:
                PlayerManager.AudioTrack audioTrack = (PlayerManager.AudioTrack) obj;
                int i10 = PlayerActivity.X;
                audioTrack.getClass();
                PlayerManager playerManager2 = playerActivity.F;
                if (playerManager2 == null) {
                    b8.i.d("playerManager");
                    throw null;
                }
                playerManager2.selectAudioTrack(audioTrack);
                playerActivity.x(true);
                kVar.dismiss();
                break;
        }
        return n7.g.f7490c;
    }
}
