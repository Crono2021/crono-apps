package i7;

import com.network.tvgramplayer.player.PlayerManager;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k3 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f4947m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k3(PlayerActivity playerActivity, r7.c cVar) {
        super(2, cVar);
        this.f4947m = playerActivity;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        return ((k3) j((i8.u) obj, (r7.c) obj2)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new k3(this.f4947m, cVar);
    }

    @Override // t7.a
    public final Object k(Object obj) {
        Object obj2;
        Object obj3;
        com.bumptech.glide.c.V(obj);
        PlayerActivity playerActivity = this.f4947m;
        PlayerManager playerManager = playerActivity.F;
        if (playerManager == null) {
            b8.i.d("playerManager");
            throw null;
        }
        Iterator<T> it = playerManager.getSubtitleTracks().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((PlayerManager.SubtitleTrack) obj2).isSelected()) {
                break;
            }
        }
        PlayerManager.SubtitleTrack subtitleTrack = (PlayerManager.SubtitleTrack) obj2;
        String id = subtitleTrack != null ? subtitleTrack.getId() : null;
        PlayerManager playerManager2 = playerActivity.F;
        if (playerManager2 == null) {
            b8.i.d("playerManager");
            throw null;
        }
        Iterator<T> it2 = playerManager2.getAudioTracks().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            if (((PlayerManager.AudioTrack) obj3).isSelected()) {
                break;
            }
        }
        PlayerManager.AudioTrack audioTrack = (PlayerManager.AudioTrack) obj3;
        return new n7.b(id, audioTrack != null ? audioTrack.getId() : null);
    }
}
